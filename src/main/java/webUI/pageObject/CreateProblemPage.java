package webUI.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import webUI.BaseObject;
import webUI.decorator.MyButton;
import webUI.decorator.MyInput;

import java.util.UUID;

public class CreateProblemPage extends BaseObject {

    @FindBy(xpath ="/html/body/div[2]/div[2]/div[2]/div/div/form/div/div[2]/div[1]/div/table/tbody/tr[6]/td/select")
    private MyButton selectUser;
    @FindBy(xpath ="/html/body/div[2]/div[2]/div[2]/div/div/form/div/div[2]/div[1]/div/table/tbody/tr[6]/td/select/option[2]")
    private MyButton chooseUser;
    @FindBy(xpath ="/html/body/div[2]/div[2]/div[2]/div/div/form/div/div[2]/div[1]/div/table/tbody/tr[7]/td/input")
    private MyInput writeStaticInfo;
    @FindBy(xpath ="/html/body/div[2]/div[2]/div[2]/div/div/form/div/div[2]/div[1]/div/table/tbody/tr[8]/td/textarea")
    private MyInput description;
    @FindBy(xpath ="/html/body/div[2]/div[2]/div[2]/div/div/form/div/div[2]/div[1]/div/table/tbody/tr[9]/td/textarea")
    private MyInput steps;
    @FindBy(xpath ="/html/body/div[2]/div[2]/div[2]/div/div/form/div/div[2]/div[1]/div/table/tbody/tr[10]/td/textarea")
    private MyInput addInfo;
    @FindBy(xpath ="//*[@id=\"report_bug_form\"]/div/div[2]/div[2]/input")
    private MyButton createProblemBtn;

    public CreateProblemPage(WebDriver driver) {
        super(driver);

    }
    public CreateProblemPage selectUser(){
        selectUser.myClick();
        chooseUser.myClick();
        return this;
    }
    public CreateProblemPage writeInfo(){
        writeStaticInfo.input(UUID.randomUUID().toString());
        description.input(UUID.randomUUID().toString());
        steps.input(UUID.randomUUID().toString());
        addInfo.input(UUID.randomUUID().toString());
        return this;
    }
    public ProblemsBrowserPage createProblem(){
        createProblemBtn.myClick();
        return new ProblemsBrowserPage(driver);
    }
}
