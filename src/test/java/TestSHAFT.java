import com.shaft.driver.SHAFT;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;
public class TestSHAFT {
    public signUp_Login signUpPage ;
    public AccountInfoApplication accountInfoApplication;
    SHAFT.GUI.WebDriver SHAFTdriver = new SHAFT.GUI.WebDriver();
    WebDriver driver;
    SHAFT.TestData.JSON testData ;

    @BeforeClass
    public void beforeClass(){

        testData = new SHAFT.TestData.JSON("src/test/resources/TestData.json");
    }

    @Test
    public void signUpNewUser(){
        String email = testData.getTestData("firstName") + System.currentTimeMillis() + testData.getTestData("LastName") +"@gmail.com";
        signUpPage.navigateToautoEx();
        signUpPage.Register(testData.getTestData("firstName"),email,false );
        accountInfoApplication.AccountInfoFilling();
    }

    @BeforeMethod
    public void beforeMethod(){

        signUpPage = new signUp_Login(SHAFTdriver);
        accountInfoApplication = new AccountInfoApplication(SHAFTdriver);
        signUpPage.navigateToautoEx();

    }

    @AfterMethod
    public void afterMethod(){
        SHAFTdriver.quit();
    }
}
