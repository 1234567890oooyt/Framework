package webUI;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import webUI.decorator.MyFieldDecorator;

import java.time.Duration;
import java.util.UUID;

public class BaseObject {
    protected WebDriver driver;
    public BaseObject(WebDriver driver){

        this.driver = driver;
        PageFactory.initElements(new MyFieldDecorator(driver),this);
    }
    public void open(String url){

        driver.get(url);
    }

    public static String RandomText(){
        return UUID.randomUUID().toString();
    }
    public WebElement awaitElementIsVisible(WebElement element){
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOf(element));
        return element;
    }
}
