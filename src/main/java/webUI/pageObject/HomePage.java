package webUI.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import webUI.BaseObject;
import webUI.decorator.MyButton;
import webUI.decorator.MyInput;

public class HomePage extends BaseObject {
    @FindBy(xpath ="/html/body/div[2]/div[1]/ul/li[7]/a")
    private MyButton manageButton;
    @FindBy(xpath ="/html/body/div[1]/div/div[2]/ul/li[1]/div/a")
    private MyButton problemButton;
    @FindBy(xpath ="//*[@id=\"navbar-container\"]/div[2]/ul/li[1]/div/a[2]")
    private MyButton inviteUser;
    public HomePage(WebDriver driver){
        super(driver);
    }

    public ManagePage goToManagePage(){
        manageButton.myClick();
        return new ManagePage(driver);
    }
    public ProjectPage goToProblemPage(){
        problemButton.myClick();
        return new ProjectPage(driver);
    }
    public InviteUserPage goInviteUserPage(){
        inviteUser.myClick();
        return new InviteUserPage(driver);
    }

}
