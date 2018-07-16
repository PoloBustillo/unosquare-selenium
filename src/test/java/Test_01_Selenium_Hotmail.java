
import amazon.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utils.DataProviderTest;
import utils.PropertiesLoader;


public class Test_01_Selenium_Hotmail extends BaseTest{
    private WebDriver driver;
    private PropertiesLoader props = new PropertiesLoader();

    @BeforeClass
    public void setUp(){

        driver = new ChromeDriver();
        driver.get(props.load().getProperty("url"));
        System.out.println(System.getProperty("webdriver.chrome.driver"));
    }
    @Test(dataProvider = "credentials", dataProviderClass = DataProviderTest.class)
    public void title_should_be(String username, String password){

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(username,"test_user");
        softAssert.assertEquals(password,"password");
        softAssert.assertAll();

    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

}
