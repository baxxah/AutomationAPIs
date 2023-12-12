package pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class signUp_Login {
    WebDriver driver;
    SHAFT.GUI.WebDriver SHAFTdriver;

    String pageURL="https://automationexercise.com/";
    public By SignUpPartialLink = By.xpath("//a[@href=\"/login\"]");
    public By SignUpName = By.xpath("//input[@data-qa=\"signup-name\"]");
    public By SignUpEmail = By.xpath("//input[@data-qa=\"signup-email\"]");
    public By SignUpButton = By.xpath("//button[@data-qa=\"signup-button\"]");

    public signUp_Login(SHAFT.GUI.WebDriver SHAFTdriver ) {
        this.SHAFTdriver = SHAFTdriver ;
}


    public void Register (String X , String Y , Boolean headless)
    {
        clickOn(SignUpPartialLink);
        SHAFTdriver.element().type(SignUpName ,X);
        SHAFTdriver.element().type(SignUpEmail ,Y);
        clickOn(SignUpButton);



    }
    public void navigateToautoEx() {
        SHAFTdriver.browser().navigateToURL(pageURL);

    }
    public void clickOn(By by)
    {

        SHAFTdriver.element().click(by);

    }

}
