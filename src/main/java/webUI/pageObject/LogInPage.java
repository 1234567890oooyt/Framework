package webUI.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Parameters;
import webUI.BaseObject;
import webUI.decorator.MyButton;
import webUI.decorator.MyInput;

public class LogInPage extends BaseObject {
    @FindBy(xpath ="//*[@id=\"username\"]")
    private MyInput userNameInput;
    @FindBy(xpath ="//*[@id=\"login-form\"]/fieldset/input[2]")
    private MyButton userNameButton;
    @FindBy(xpath ="//*[@id=\"password\"]")
    private MyInput userPasswordInput;
    @FindBy(xpath ="//*[@id=\"login-form\"]/fieldset/input[3]")
    private MyButton userPasswordButton;

    public LogInPage(WebDriver driver) {
        super(driver);
    }

    public LogInPage writeUserName(){
//        WebElement nameInput = driver.findElement(userNameInput);
        userNameInput.input("administrator");
        userNameButton.myClick();
        return this;
    }
    public LogInPage writeUserPassword() throws InterruptedException {
        Thread.sleep(1000);
        userPasswordInput.input("root");
        userPasswordButton.myClick();

        return this;
    }
}
