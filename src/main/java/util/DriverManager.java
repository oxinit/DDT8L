package util;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DriverManager {

    protected static ThreadLocal<RemoteWebDriver> driverThread = new ThreadLocal<>();
    private static final String URL ="https://rozetka.com.ua";
    public static WebDriver getDriver() {
            return driverThread.get();
        }

public static void setDriverThread(){
    WebDriverManager.chromedriver().setup();
        driverThread.set(new ChromeDriver());
    DriverManager.getDriver().manage().window().maximize();
    DriverManager.getDriver().get(URL);
}

    public static void terminate() {
        driverThread.remove(); }
}

