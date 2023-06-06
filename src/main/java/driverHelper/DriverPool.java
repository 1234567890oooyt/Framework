package driverHelper;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;

import java.util.concurrent.TimeUnit;

public class DriverPool {
    public static WebDriver createDriverInstance(String browserType) {

        WebDriver driver = null;
        switch (browserType){
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");
                driver = new ChromeDriver(options);
                break;
            case "firefox":
                System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");

                FirefoxOptions options2 = new FirefoxOptions();

                driver = new FirefoxDriver(options2);
                break;
        }

        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        driver.manage().window().setSize(new Dimension(1024, 768));
        return driver;

    }
}
