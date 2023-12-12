package stepdef;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.safari.SafariDriver;
import utilities.ReadConfigValues;

public class Hooks {

    public static WebDriver driver;
    @Before
    public void browserSetUp() {
        System.out.println(ReadConfigValues.getProperty("browser"));
        if (ReadConfigValues.getProperty("browser").equalsIgnoreCase(BrowserType.CHROME)) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless");
            options.addArguments("--no-sandbox");
            System.setProperty("webdriver.chrome.args", "--disable-logging");
            System.setProperty("webdriver.chrome.silentOutput", "true");
            options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
            options.addArguments("disable-infobars"); // disabling infobars
            options.addArguments("--disable-extensions"); // disabling extensions
            options.addArguments("--disable-gpu"); // applicable to windows os only
            options.addArguments("window-size=1024,768"); // Bypass OS security model
            driver = new ChromeDriver(options);

        } else if (ReadConfigValues.getProperty("browser").equalsIgnoreCase(BrowserType.FIREFOX)) {
            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions firefoxDockerOptions = new FirefoxOptions();
            System.setProperty("webdriver.gecko.driver","/app/bin/geckodriver");
            firefoxDockerOptions.addArguments("--headless");
            firefoxDockerOptions.addArguments("--no-sandbox");
            System.setProperty("webdriver.gecko.args", "--disable-logging");
            System.setProperty("webdriver.gecko.silentOutput", "true");
            firefoxDockerOptions.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
            firefoxDockerOptions.addArguments("disable-infobars"); // disabling infobars
            firefoxDockerOptions.addArguments("--disable-extensions"); // disabling extensions
            firefoxDockerOptions.addArguments("--disable-gpu"); // applicable to windows os only
            firefoxDockerOptions.addArguments("--width=1920"); // Bypass OS security model
            firefoxDockerOptions.addArguments("--height=1080");
            driver = new FirefoxDriver(firefoxDockerOptions);
        } else if (ReadConfigValues.getProperty("browser").equalsIgnoreCase(BrowserType.EDGE)) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
            driver.manage().window().maximize();
            
            driver.manage().window().maximize();
        } else if (ReadConfigValues.getProperty("browser").equalsIgnoreCase(BrowserType.SAFARI)) {
            driver = new SafariDriver();
            driver.manage().window().maximize();
        } else {
            Assert.fail("Please select appropriate browser value from {chrome,firefox,MicrosoftEdge and safari}. The current browser value is: " + ReadConfigValues.getProperty("browser"));

        }
    }




    @After
    public void closeBrowser()
    {
        if (driver!=null)
           driver.quit();
    }
}
