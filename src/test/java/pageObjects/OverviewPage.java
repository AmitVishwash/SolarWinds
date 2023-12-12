package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ActionLibrary;

public class OverviewPage {

    WebDriver driver;

    ActionLibrary actionLibrary = new ActionLibrary();

    public static String updatedName;

    public OverviewPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h2[contains(text(),'Quick Start & Tour')]")
    public static WebElement MainHeadingLabel;

    @FindBy(xpath = "//div[text()='Settings']")
    public static WebElement settingsLink;

    @FindBy(xpath = "//a[text()='Profile']")
    public static WebElement profileLink;

    // Profile Page
    @FindBy(xpath = "//label[text()='Name']")
    public static WebElement nameLabel;

    @FindBy(id = "user_name")
    public static WebElement nameTextBox;

    @FindBy(xpath = "//button[text()='Update Preferences']")
    public static WebElement updatePreferenceButton;

    @FindBy(css = ".flash.notice")
    public static WebElement flashMessageSign;

    @FindBy(xpath = "//p[contains(text(),' Profile updated.')]")
    public static WebElement flashMessageText;









    @FindBy(xpath = "//div[text()='Alerts']")
    public static WebElement alertsLink;

    @FindBy(xpath = "//div[text()='Events']")
    public static WebElement eventsLink;

    @FindBy(xpath = "//div[text()='Dashboard']")
    public static WebElement dashboardLink;

    @FindBy(xpath = "//div[text()='Support']")
    public static WebElement supportLink;

    public void isOverviewPageDisplayed(){
        Assert.assertTrue(actionLibrary.getElementIsDisplayedStatus(MainHeadingLabel));
        Assert.assertTrue(actionLibrary.getElementIsDisplayedStatus(settingsLink));
        Assert.assertTrue(actionLibrary.getElementIsDisplayedStatus(alertsLink));
        Assert.assertTrue(actionLibrary.getElementIsDisplayedStatus(supportLink));
        Assert.assertTrue(actionLibrary.getElementIsDisplayedStatus(eventsLink));
        Assert.assertTrue(actionLibrary.getElementIsDisplayedStatus(dashboardLink));
    }


    public void editUserName(String changedProfileName) {
        actionLibrary.clickElement(settingsLink);
        actionLibrary.clickElement(profileLink);
        actionLibrary.getElementIsDisplayedStatus(nameLabel);
        actionLibrary.clearValue(nameTextBox);
        actionLibrary.enterText(nameTextBox,changedProfileName);
        updatedName = changedProfileName;
        actionLibrary.clickElement(updatePreferenceButton);
        actionLibrary.getElementIsDisplayedStatus(flashMessageSign);
        Assert.assertEquals("Expected: " + "Profile updated." + " but found " + flashMessageText.getText() ,"Profile updated.", flashMessageText.getText());
    }

    public void checkUserName() {
        Assert.assertEquals("Expected: " + updatedName + " but found " + actionLibrary.getElementValue(nameTextBox) , updatedName, actionLibrary.getElementValue(nameTextBox));
    }
}
