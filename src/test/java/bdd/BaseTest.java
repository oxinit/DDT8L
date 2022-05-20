package bdd;

import org.testng.annotations.*;
import util.CustomMethodInvokedListener;
import util.CustomTestListener;
import util.DriverManager;
@Listeners(CustomMethodInvokedListener.class)
public class BaseTest {
    @BeforeMethod
    public void testsSetUp(){
        DriverManager.setDriverThread();
    }
    @AfterMethod
    public void close(){
     DriverManager.getDriver().close();
    }
    @AfterClass
    public void terminate(){
    DriverManager.terminate();
    }
}
