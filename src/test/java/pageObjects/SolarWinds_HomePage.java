package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ActionLibrary;

public class SolarWinds_HomePage {


    WebDriver driver;

    ActionLibrary actionLibrary = new ActionLibrary();

    public SolarWinds_HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".ui.inline.image.CardLayout_logo__1zWGk")
    public static WebElement solarWindsLogo;

    @FindBy(xpath = "//p[text()='Continue by selecting your product below.']")
    public static WebElement productsMainLabel;


    @FindBy(id = "product-1")
    public static WebElement product_AppOpticsButton;

    @FindBy(id = "product-2")
    public static WebElement product_LogglyButton;
    @FindBy(id = "product-3")
    public static WebElement product_PapertrailButton;

    @FindBy(id = "product-4")
    public static WebElement product_PingdomButton;

    public void selectProduct(String product){
        if (product.equalsIgnoreCase("papertrail"))
            actionLibrary.clickElement(product_PapertrailButton);
        else if (product.equalsIgnoreCase("appoptics"))
            actionLibrary.clickElement(product_AppOpticsButton);
        else if (product.equalsIgnoreCase("loggly"))
            actionLibrary.clickElement(product_LogglyButton);
        else if (product.equalsIgnoreCase("pingdom"))
            actionLibrary.clickElement(product_PingdomButton);
    }

    public void isHomePageDisplayed(){
        Assert.assertTrue(actionLibrary.getElementIsDisplayedStatus(solarWindsLogo));
        Assert.assertTrue(actionLibrary.getElementIsDisplayedStatus(productsMainLabel));
        Assert.assertTrue(actionLibrary.getElementIsDisplayedStatus(product_AppOpticsButton));
        Assert.assertTrue(actionLibrary.getElementIsDisplayedStatus(product_LogglyButton));
        Assert.assertTrue(actionLibrary.getElementIsDisplayedStatus(product_PapertrailButton));
        Assert.assertTrue(actionLibrary.getElementIsDisplayedStatus(product_PingdomButton));

    }

    public void openApplication()
    {
        actionLibrary.launchUrl();
    }

}
