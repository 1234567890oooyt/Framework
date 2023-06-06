package webUI.decorator;

import org.openqa.selenium.WebElement;

public class MyInput extends Element{

    public MyInput(WebElement webElement) {
        super(webElement);
        this.webElement=webElement;
    }

    public void input(String inputText){
        System.out.println("input '"+inputText+"'");
        waitForMy();
        webElement.sendKeys(inputText);;
    }
}
