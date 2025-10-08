package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.TestBase;
import utils.Utilities;

import static utils.TestBase.extent;
import static utils.TestBase.test;

public class CheckOutPage extends Utilities {
    WebDriver driver;

    public CheckOutPage(WebDriver driver) {
        super();
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id="first-name")
    protected WebElement fistName;
    @FindBy(id="last-name")
    protected WebElement lastName;
    @FindBy(id="postal-code")
    protected WebElement postalCode;
    @FindBy(id="continue")
    protected WebElement conti;
    @FindBy(id="finish")
    protected WebElement complete;
    @FindBy(xpath = "//h2[@data-test='complete-header']")
    protected WebElement successMessage;
    @FindBy(id="back-to-products")
    protected WebElement backToHome;

    public void verifyCheckOutPage(){
        try {
            test = extent.createTest("Checkout Page");
            fistName.sendKeys("hello");
            lastName.sendKeys("there");
            postalCode.sendKeys("90879");
            conti.click();
            test.pass("Address has been added");
            complete.click();
            String success = successMessage.getText();
            Assert.assertEquals(success, "Thank you for your order!");
            test.pass("Wohooo! Order placed");
            backToHome.click();
        }catch (Exception e){
            e.printStackTrace();
            test.fail("Failed to place the order");
        }
    }

}
