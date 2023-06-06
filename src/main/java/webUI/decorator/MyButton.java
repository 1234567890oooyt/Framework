package webUI.decorator;

import org.openqa.selenium.WebElement;

public class MyButton extends Element{

        public MyButton(WebElement webElement) {
                super(webElement);
                this.webElement=webElement;
        }

        public void myClick(){
                System.out.println("myClick");
                waitForMy();
                webElement.click();
        }
}
