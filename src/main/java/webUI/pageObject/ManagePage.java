package webUI.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import webUI.BaseObject;
import webUI.decorator.MyButton;
import webUI.decorator.MyInput;

public class ManagePage extends BaseObject {
    @FindBy(xpath ="//*[@id=\"main-container\"]/div[2]/div[2]/div/ul/li[3]/a")
    private MyButton projectButton ;

    public ManagePage(WebDriver driver) {
        super(driver);
    }
    public ProjectPage goToProjectPage(){
        projectButton.myClick();
        return new ProjectPage(driver);
    }
}
