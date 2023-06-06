package webUI.decorator;

import org.openqa.selenium.WebElement;

public class MyText extends Element{
    public MyText(WebElement webElement) {
        super(webElement);
        this.webElement=webElement;
    }

    public String get(){
        waitForMy();
        return webElement.getText();
    }
    public boolean check(){
        waitForMy();
        return webElement.isDisplayed();
    }
}
