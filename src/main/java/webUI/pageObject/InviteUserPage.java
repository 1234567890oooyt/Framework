package webUI.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import webUI.BaseObject;
import webUI.decorator.MyButton;
import webUI.decorator.MyInput;

import java.util.UUID;

public class InviteUserPage extends BaseObject {
    @FindBy(xpath ="/html/body/div[2]/div[2]/div[2]/div/div/div[2]/form/div/div[2]/div/div/table/tbody/tr[1]/td[2]/input")
    private MyInput userName;
    @FindBy(xpath ="/html/body/div[2]/div[2]/div[2]/div/div/div[2]/form/div/div[2]/div/div/table/tbody/tr[2]/td[2]/input")
    private MyInput realName;
    @FindBy(xpath ="/html/body/div[2]/div[2]/div[2]/div/div/div[2]/form/div/div[2]/div/div/table/tbody/tr[3]/td[2]/input")
    private MyInput mail;
    @FindBy(xpath ="/html/body/div[2]/div[2]/div[2]/div/div/div[2]/form/div/div[2]/div/div/table/tbody/tr[4]/td[2]/select")
    private MyButton select;
    @FindBy(xpath ="/html/body/div[2]/div[2]/div[2]/div/div/div[2]/form/div/div[2]/div/div/table/tbody/tr[4]/td[2]/select/option[4]")
    private MyButton option;
    @FindBy(xpath ="/html/body/div[2]/div[2]/div[2]/div/div/div[2]/form/div/div[3]/input")
    private MyButton inviteUserBtn;

    public InviteUserPage(WebDriver driver) {
        super(driver);
    }
    public InviteUserPage writeDataInfo(){
        userName.input(UUID.randomUUID().toString());
        realName.input(UUID.randomUUID().toString());
        mail.input(UUID.randomUUID().toString() + "@gmail.com");
        return this;
    }
    public InviteUserPage selectOption(){
        select.myClick();
        option.myClick();
        return this;
    }
    public UpdateUserPage inviteNewUser(){
        inviteUserBtn.myClick();
        return new UpdateUserPage(driver);
    }
}
