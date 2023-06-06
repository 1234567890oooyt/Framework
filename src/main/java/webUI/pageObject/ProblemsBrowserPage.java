package webUI.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import webUI.BaseObject;
import webUI.decorator.MyButton;
import webUI.decorator.MyInput;
import webUI.decorator.MyText;

public class ProblemsBrowserPage extends BaseObject {
    @FindBy(xpath ="/html/body/div[2]/div[2]/div[2]/div/div[1]/div/div[2]/div[2]/div/table/tbody/tr[2]/td[2]")
    private MyText checkText;
    public ProblemsBrowserPage(WebDriver driver) {
        super(driver);
    }
    public boolean getProblemName(){

        return checkText.check();
    }
}
