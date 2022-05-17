package manager;

import Pages.Page;
import org.openqa.selenium.WebDriver;

public class PageFactoryManager {

    WebDriver driver;

    public PageFactoryManager(WebDriver driver) {
        this.driver = driver;
    }

    public Page getHomePage() {
        return new Page(driver);
    }


}
