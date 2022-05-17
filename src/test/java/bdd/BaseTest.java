package bdd;

import org.testng.annotations.*;
import util.DriverManager;

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
