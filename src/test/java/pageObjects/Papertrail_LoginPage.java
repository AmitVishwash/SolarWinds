package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ActionLibrary;
import utilities.ReadConfigValues;

public class Papertrail_LoginPage {

    WebDriver driver;
    ActionLibrary actionLibrary = new ActionLibrary();
    public Papertrail_LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@name='email']")
    public static WebElement emailTextBox;

    @FindBy(xpath = "//input[@name='password']")
    public static WebElement passwordTextBox;

    @FindBy(className = "LoginButton_background__ZUiUh")
    public static WebElement loginButton;

    @FindBy(css = ".LoginForm_forgotPassword__IDrus.forgotPassword")
    public static WebElement forgetPwdButton;

    @FindBy(id = "SamlLink_samlButton__oYXpU")
    public static WebElement samlButton;

    @FindBy(xpath = "//b[text()='Start free trial']")
    public static WebElement startFreeTrialLabel;


    public void isLoginPageDisplayed(){
        Assert.assertTrue(actionLibrary.getElementIsDisplayedStatus(emailTextBox));
        Assert.assertTrue(actionLibrary.getElementIsDisplayedStatus(passwordTextBox));
        Assert.assertTrue(actionLibrary.getElementIsDisplayedStatus(loginButton));
        Assert.assertTrue(actionLibrary.getElementIsDisplayedStatus(forgetPwdButton));
        Assert.assertTrue(actionLibrary.getElementIsDisplayedStatus(samlButton));
        Assert.assertTrue(actionLibrary.getElementIsDisplayedStatus(startFreeTrialLabel));
    }

    public void enterEmail(){
        actionLibrary.enterText(emailTextBox, ReadConfigValues.getProperty("email"));
    }

    public void enterPassword(){
        actionLibrary.enterText(passwordTextBox, ReadConfigValues.getProperty("password"));
    }

    public void clickLogin(){
        actionLibrary.clickElement(loginButton);
    }
}
