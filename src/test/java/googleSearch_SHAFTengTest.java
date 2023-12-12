import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class googleSearch_SHAFTengTest {

    SHAFT.TestData.JSON tesData;
    SHAFT.GUI.WebDriver SHAFTdriver;

    @BeforeClass
    public void beforeClass (){

    }



    @BeforeMethod
    public void BeforeMethod(){
        SHAFTdriver = new SHAFT.GUI.WebDriver();

        SHAFTdriver.browser().navigateToURL("https://www.google.com/ncr");
        SHAFTdriver.element().type(By.id("xx") , tesData.getTestData("searchWord"));



    }
}
