package amazon;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;
import utils.PropertiesLoader;

@Test(groups = { "amazon", "hotmail"})
public abstract class BaseTest {
    public  WebDriver driver;
    public PropertiesLoader props = new PropertiesLoader();

    @BeforeClass
    public void setUp() {
        System.out.println("SETUP");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless");
        driver = new ChromeDriver(chromeOptions);
        driver.get(props.load().getProperty("url"));
        //System.out.println(System.getProperty("webdriver.chrome.driver"));
    }

    @AfterClass
    public void tearDown() {
        if (driver != null)
        {
            try
            {
                driver.quit();
            }
            catch (WebDriverException e) {
                System.out.println("***** CAUGHT EXCEPTION IN DRIVER TEARDOWN *****");
                System.out.println(e);
            }

        }
    }
}
