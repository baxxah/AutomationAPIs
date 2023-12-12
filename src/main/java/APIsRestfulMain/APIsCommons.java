package APIsRestfulMain;

import com.shaft.driver.SHAFT;
import io.restassured.http.ContentType;

import java.net.URL;

public class APIsCommons {
    SHAFT.API api ;
    public final static int success_statusCode = 200;
    public  final static int successDelete_statusCode = 201;
    public final static String baseURL = System.getProperty("baseURL");
    public final static String authentication_serviceName = "/auth";
    public final static String booking_serviceName = "/booking";

    public static void  login(SHAFT.API api, String username, String password) {
        String tokenBody = """
                {
                    "username" : "{USERNAME}",
                    "password" : "{PASSWORD}"
                }
                """
                .replace("{USERNAME}", username)
                .replace("{PASSWORD}", password);

        api.post(authentication_serviceName)
                .setContentType(ContentType.JSON)
                .setRequestBody(tokenBody)
                .setTargetStatusCode(success_statusCode)
                .perform();

        String token = api.getResponseJSONValue("token");

        api.addHeader("Cookie", "token=" + token);
    }


}
