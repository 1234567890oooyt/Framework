package webUI.decorator;

import driverHelper.ParallelExc;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.function.Function;


public class Element {
    WebElement webElement;

    public Element(WebElement webElement) {
        this.webElement = webElement;
    }

    public void waitForMy(){

        Wait wait = new FluentWait(ParallelExc.getDriver())
                .withTimeout(Duration.of(10, ChronoUnit.SECONDS))
                .pollingEvery(Duration.of(1, ChronoUnit.SECONDS))
                .ignoring(Exception.class);

        webElement= (WebElement) wait.until((Function<WebDriver, WebElement>) driver -> webElement);

    }
}
