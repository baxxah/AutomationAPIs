package pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class AccountInfoApplication {
//    WebDriver driver;
    SHAFT.GUI.WebDriver SHAFTdriver ;


    SHAFT.TestData.JSON testData ;

    String pageURL= "https://automationexercise.com/signup";
    public By VisibilityPath = By.xpath("//b[contains(text(),\"Enter Account\")]");
    public By genderButton =By.id("id_gender2");
    public By PasswordPath = By.xpath("//input[@type='password']");
    public By Days = By.xpath("//select[@data-qa='days']");
    public By Month = By.xpath("//select[@data-qa='months']");
    public By Year = By.xpath("//select[@data-qa='years']");

    public By newSettler = By.id("newsletter");
    public By optinButton = By.id("optin");
    public By firstName = By.id("first_name");
    public By LastName = By.id("last_name");

    public By Company = By.xpath("//input[@data-qa=\"company\"]");
    public By address = By.xpath("//input[@data-qa=\"address\"]");
    public By Country = By.xpath("//input[@data-qa=\"country\"]");

    public By state = By.xpath("//input[@data-qa=\"state\"]");
    public By city = By.xpath("//input[@data-qa=\"city\"]");
    public By zipcode =By.xpath("//input[@data-qa=\"zipcode\"]");
    public By mobilenumber =By.xpath("//input[@data-qa=\"mobile_number\"]");

    public By submitButton = By.id("subscribe");
    public By visible = By.xpath("//button[@data-qa=\"create-account\"]");

    public AccountInfoApplication(SHAFT.GUI.WebDriver SHAFTdriver) {
        this.SHAFTdriver= SHAFTdriver ;
    }

    public  void checkVisibility (By by, String item)
    {
        Boolean visible = SHAFTdriver.element().isElementDisplayed(by);
        String output = String.format(" Is visible for " + item + " = %b ", visible);
        System.out.println(output);
    }

    public void clickOn(By by) {
        SHAFTdriver.element().click(by);
    }

//    public void selectFromDropDownMenu(By by , int Index){
//        Select drpDay = new Select(driver.findElement(by));
//        SHAFTdriver.element().select(by,)
//        drpDay.selectByIndex(Index);
//    }

    public void AccountInfoFilling (){

        testData = new SHAFT.TestData.JSON("src/test/resources/TestData.json");
        checkVisibility(VisibilityPath,"'ENTER ACCOUNT INFORMATION'");
        clickOn(genderButton);
        SHAFTdriver.element().type(PasswordPath,"Password123");
        String fname = testData.getTestData("LastName");

        SHAFTdriver.element().select(Days,"25");
        SHAFTdriver.element().select(Month,"12");
        SHAFTdriver.element().select(Year,"2001");
        SHAFTdriver.element().type(firstName, fname);
        SHAFTdriver.element().type(LastName, fname);
        SHAFTdriver.element().type(Company , "Giza Systems");
        SHAFTdriver.element().type(address,"Cairo");
        SHAFTdriver.element().type(state,"cairo");
        SHAFTdriver.element().type(city,"Cairo");
        SHAFTdriver.element().type(zipcode , "12511");
        SHAFTdriver.element().type(mobilenumber,"0100439925");
        clickOn(newSettler);
        clickOn(optinButton);
        clickOn(submitButton);
        checkVisibility(visible,"Create Account Button");


    }

}

