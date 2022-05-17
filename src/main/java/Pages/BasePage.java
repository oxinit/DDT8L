package Pages;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import static java.lang.Thread.sleep;

public class BasePage {
    WebDriver driverFather;

    @FindBy(xpath = "//input")
    private WebElement SearchField;
    @FindBy(xpath = "//button[contains(text(),'Найти')]")
    private WebElement FindButton;

    public BasePage(WebDriver driver){
        driverFather =driver;
        PageFactory.initElements(driverFather,this);
    }

    public void searchFieldSendKeys(String searchKey) {
        waitForPageLoading(10);
        SearchField.sendKeys(searchKey);

    }
    public void clickFindButton() throws InterruptedException {
        waitVisibilityOfElement(60,FindButton);
        FindButton.click();
        waitForPageLoading(10);
        Thread.sleep(600);
    }

    public void waitForPageLoading(long timeToWait){
        new WebDriverWait(driverFather, Duration.ofSeconds(timeToWait)).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }
    public void waitVisibilityOfElement(long timeToWait, WebElement locator) {
        WebDriverWait wait = new WebDriverWait(driverFather, Duration.ofSeconds(timeToWait));
        wait.until(ExpectedConditions.visibilityOf(locator));
    }

    public void implicitWait1(long timeOut) throws InterruptedException {
        driverFather.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeOut));
        sleep(timeOut);
    }
    public void waitForAjaxToComplete(long timeToWait) {
        new WebDriverWait(driverFather, Duration.ofSeconds(timeToWait)).until(
             webDriver -> ((JavascriptExecutor) webDriver).executeScript("return window.jQuery != undefined && jQuery.active == 0;"));
 }
}
