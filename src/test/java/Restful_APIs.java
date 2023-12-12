import com.shaft.driver.SHAFT;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Restful_APIs {
    //services name
    private final String auth_serviceName = "/auth";
    private final String booking_serviceName = "/booking";
    private final int success_statusCode = 200;
    private final int success_statusCodeDelete = 201;
    String tokeen ;
    String id ;
    SHAFT.API APIs;



    public void GetBooking (){

    }

    @Test (dependsOnMethods = {"getTokenTest","CreateBooking"})
    public void DeleteBooking(){

        APIs.delete("/booking/"+id)
                .addHeader("Cookie","token="+tokeen).perform();

    }
    @BeforeClass
    public void BeforeClass (){
        APIs = new SHAFT.API("https://restful-booker.herokuapp.com");
        Login("admin" , "password123");
    }
    public void Login(String Name , String Password){

        String TokenBody = """
                {
                     "username" : "{ADMIN}",
                     "password" : "{PASSWORD}"
                 }
                """.replace("{ADMIN}" , Name).replace("{PASSWORD}" , Password);

        APIs.post(auth_serviceName)
                .setContentType(ContentType.JSON)
                .setRequestBody(TokenBody)
                .setTargetStatusCode(200)
                .perform();
        APIs.addHeader("Cookie","token="+tokeen);

       // APIs.assertThatResponse().body().contains("\"token\":").perform();
        tokeen = APIs.getResponseJSONValue("token");
        System.out.println("The token issssss : "+tokeen);

    }

    public void CreateBooking (String Fname , String Lname , String AddNeeds){
        String Booking = """
                {
                    "firstname" : "{FIRSTNAME}",
                    "lastname" : "{LASTNAME}",
                    "totalprice" : 1225,
                    "depositpaid" : true,
                    "bookingdates" : {
                        "checkin" : "2018-01-01",
                        "checkout" : "2019-01-01"
                    },
                    "additionalneeds" : "{ADDNEEDS}"
                }
                """.replace("{FIRSTNAME}",Fname ).replace("{LASTNAME}" , Lname).replace("{ADDNEEDS}" , AddNeeds);

        APIs.post(booking_serviceName)
                .setContentType(ContentType.JSON)
                .setRequestBody(Booking)
                .setTargetStatusCode(success_statusCode)
                .perform();



        id = APIs.getResponseJSONValue("bookingid");
        System.out.println("The id isssssss : " + id);

    }

    public void validateBookingCreated(String expFname  , String expLname , String ExpAddNeeds){
        APIs.assertThatResponse()
                .extractedJsonValue("booking.firstname")
                .isEqualTo(expFname)
                .perform();

        APIs.assertThatResponse()
                .extractedJsonValue("booking.lastname")
                .isEqualTo(expLname)
                .perform();

    }


}
