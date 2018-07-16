package amazon;

import amazon.pages.HomePage;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

//@Listeners(utils.listeners.Listener.class)
@Test(groups = { "amazon" })
public class Test_01_Selenium_Amazon extends BaseTest {

    private HomePage homePage;

    @BeforeClass
    public void initializePages(){
        homePage = new HomePage(driver);
    }
    @Test
    public void testTitleHomePage() {
        Assert.assertEquals(homePage.getTitle(),"Amazon", "Logo title is not Amazon");

        //System.out.println("Test Case One with Thread Id:- "
        //        + Thread.currentThread().getId());
    }

    @Test
    public void titleShouldBeValidWithExpectedConditions(){
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.titleContains("Amazon.com:"));
        homePage.getIframeNeeded();
    }


    @Test
    public void dropdownShoulBePresent() {
        ////Printing Id of the thread on using which test method got executed
        Assert.assertTrue(homePage.isDropdownPresent(),"Search dropdown is not visible");
       // Assert.assertEquals(false,true);
       // Assert.fail("TESTING FAIL");
    }


}
