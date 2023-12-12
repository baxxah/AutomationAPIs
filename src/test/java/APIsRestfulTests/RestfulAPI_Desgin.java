package APIsRestfulTests;

import APIsRestfulMain.APIsCommons;
import APIsRestfulMain.BookingAPIs;
import com.shaft.driver.SHAFT;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RestfulAPI_Desgin {


        private SHAFT.API api;

        // Status Codes
        private final int success_statusCode = 200;
        private final int successDelete_statusCode = 201;


        // Services names
        private final String authentication_serviceName = "/auth";
        private BookingAPIs bookingAPIs;

        //////////// Tests \\\\\\\\\\\\
        @Test
        public void createBookingTest() {
            bookingAPIs.createBooking("Basant", "Lazem", "pool");
            bookingAPIs.validateThatTheBookingIsCreated("Basant", "Lazem", "pool");
        }

        @Test(dependsOnMethods = {"createBookingTest"})
        public void deleteBookingTest() {
            bookingAPIs.deleteBooking(bookingAPIs.getBookingId("Basant", "Lazem"));
            bookingAPIs.validateThatTheBookingDeleted();
        }


        /////////// Configurations \\\\\\\\\\\\\\\
        @BeforeClass
        public void beforeClass() {
            api = new SHAFT.API(APIsCommons.baseURL);
            APIsCommons.login(api ,"admin", "password123");
            bookingAPIs = new BookingAPIs(api);
        }








}
