//import APIsRestfulMain.APIsCommons;
//import com.shaft.driver.SHAFT;
//import io.restassured.http.ContentType;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
//
//public class RestfulAPI_Desgin {
//
//
//        private SHAFT.API api;
//
//        // Status Codes
//
//
//
//        // Services names
//
//
//
//        //////////// Tests \\\\\\\\\\\\
//        @Test
//        public void createBookingTest() {
//            createBooking("Basant", "Lazem", "pool");
//            validateThatTheBookingIsCreated("Basant", "Lazem", "pool");
//        }
//
//        @Test(dependsOnMethods = {"createBookingTest"})
//        public void deleteBookingTest() {
//            deleteBooking(getBookingId("Basant", "Lazem"));
//            validateThatTheBookingDeleted();
//        }
//
//
//        /////////// Configurations \\\\\\\\\\\\\\\
//        @BeforeClass
//        public void beforeClass() {
//            api = new SHAFT.API("https://restful-booker.herokuapp.com");
//            login("admin", "password123");
//        }
//
//
//
//        ////////////////// Business Methods | Actions \\\\\\\\\\\\\\\\\\\\\
//        public void login(String username, String password) {
//            String tokenBody = """
//                {
//                    "username" : "{USERNAME}",
//                    "password" : "{PASSWORD}"
//                }
//                """
//                    .replace("{USERNAME}", username)
//                    .replace("{PASSWORD}", password);
//
//            api.post(APIsCommons.authentication_serviceName)
//                    .setContentType(ContentType.JSON)
//                    .setRequestBody(tokenBody)
//                    .setTargetStatusCode(200)
//                    .perform();
//
//            String token = api.getResponseJSONValue("token");
//
//            api.addHeader("Cookie", "token=" + token);
//        }
//
//        public void createBooking(String firstName, String lastName, String additionalNeeds) {
//            String createBookingBody = """
//                {
//                    "firstname" : "{FIRST_NAME}",
//                    "lastname" : "{LAST_NAME}",
//                    "totalprice" : 111,
//                    "depositpaid" : true,
//                    "bookingdates" : {
//                        "checkin" : "2023-01-01",
//                        "checkout" : "2024-01-01"
//                    },
//                    "additionalneeds" : "{ADDITIONAL_NEEDS}"
//                }
//                """
//                    .replace("{FIRST_NAME}", firstName)
//                    .replace("{LAST_NAME}", lastName)
//                    .replace("{ADDITIONAL_NEEDS}", additionalNeeds);
//
//            api.post(booking_serviceName)
//                    .setContentType(ContentType.JSON)
//                    .setRequestBody(createBookingBody)
//                    .setTargetStatusCode(APIsCommons.success_statusCode)
//                    .perform();
//        }
//
//        public String getBookingId(String firstName, String lastName) {
//            api.get(booking_serviceName)
//                    .setUrlArguments("firstname=" + firstName + "&lastname=" + lastName)
//                    .perform();
//            return api.getResponseJSONValue("$[0].bookingid");
//        }
//
//        private void deleteBooking(String bookingId) {
//            api.delete(booking_serviceName+"/"+ bookingId).perform();
//        }
//
//        ////////// Validations \\\\\\\\\\\\\\\\\
//
//        public void validateThatTheBookingIsCreated(String expectedFirstName, String expectedLastName, String expectedAdditionalNeeds) {
//            api.verifyThatResponse().extractedJsonValue("booking.firstname").isEqualTo(expectedFirstName).perform();
//            api.verifyThatResponse().extractedJsonValue("booking.lastname").isEqualTo(expectedLastName).perform();
//            api.verifyThatResponse().extractedJsonValue("booking.additionalneeds").isEqualTo(expectedAdditionalNeeds).perform();
//            api.verifyThatResponse().body().contains("\"bookingid\":").perform();
//        }
//
//        private void validateThatTheBookingDeleted() {
//
//        }
//
//
//}
