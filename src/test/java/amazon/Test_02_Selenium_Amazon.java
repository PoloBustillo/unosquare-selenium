package amazon;
import amazon.pages.HomePage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@Test(groups = { "amazon" })
public class Test_02_Selenium_Amazon extends BaseTest {

    private HomePage homePage;

    @BeforeClass
    public void initializePages(){

        homePage = new HomePage(driver);
    }



    @Test(groups = {"one","test"})
    public void testCaseOne() throws InterruptedException {
        homePage.actionsLanguague();
    }

    @Test(groups = {"two", "test"})
    public void testCaseTwo() {
        ////Printing Id of the thread on using which test method got executed
        System.out.println("Test Case two with Thread Id:- "
                + Thread.currentThread().getId());
    }

}
