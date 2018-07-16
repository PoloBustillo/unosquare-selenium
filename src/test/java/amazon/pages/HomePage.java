package amazon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class HomePage {

    @FindBy(className = "nav-logo-link")
    @CacheLookup
    private WebElement logoTitle;

    @FindBy(css = "[title='Search in']")
    @CacheLookup
    private WebElement searchDropdown;

    @FindBy(name = "site-search")
    @CacheLookup
    private WebElement searchForm;

    @FindBy(xpath = "//iframe")
    @CacheLookup
    private List<WebElement> iframeList;

    @FindBy(className = "icp-nav-language")
    @CacheLookup
    WebElement languagueOptions;

    private WebDriverWait wait;
    private WebDriver driver;


    public HomePage(WebDriver driver){
        this.driver = driver;
        System.out.println(driver);
        wait = new WebDriverWait(driver, 15);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 5), this);
    }

    public String getTitle(){
        return logoTitle.findElement(By.className("nav-logo-base")).getText();
    }

    public boolean isDropdownPresent(){
        wait.until(ExpectedConditions.elementToBeClickable(searchForm));
        searchForm.findElement(By.className("nav-left")).click();
        return searchForm.findElement(By.className("nav-left")).isDisplayed();
    }

    public HomePage getIframeNeeded(){
        System.out.println(iframeList.size());
        for (WebElement iframe:iframeList) {
            iframe.getLocation();
        }
        return this;

    }

    public HomePage actionsLanguague() throws InterruptedException {
        Actions actionBuilder = new Actions(driver);
        actionBuilder.moveToElement(languagueOptions);
        actionBuilder.perform();
        Thread.sleep(3000);
        return this;
    }


}
