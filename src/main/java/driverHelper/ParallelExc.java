package driverHelper;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class ParallelExc {
    protected static ThreadLocal<WebDriver> threadLocalDriver =  new ThreadLocal<WebDriver>();

    @Parameters({"browser"})
    @BeforeMethod
    public void setDriver(String type) {
        WebDriver driver = DriverPool.createDriverInstance(type);
        threadLocalDriver.set(driver);
    }

    public static WebDriver getDriver() {
        return threadLocalDriver.get();
    }

//    @AfterMethod
//    public void removeDriver() {
//        getDriver().close();
//        getDriver().quit();
//        threadLocalDriver.remove();
//    }
}
