package webUI.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import webUI.BaseObject;
import webUI.decorator.MyButton;
import webUI.decorator.MyInput;

public class ProblemPage extends BaseObject {
    @FindBy(xpath ="/html/body/div[1]/div/div[2]/ul/li[2]/a")
    private MyButton openSelect;
    @FindBy(xpath ="/html/body/div[1]/div/div[2]/ul/li[2]/ul/li[3]/div/ul/li[7]/a")
    private MyButton chooseProject;

    public ProblemPage(WebDriver driver) {
        super(driver);
    }
    public ProblemPage openSelect(){
        openSelect.myClick();
        return this;
    }
    public CreateProblemPage chooseOption(){
        chooseProject.myClick();
        return new CreateProblemPage(driver);
    }
}
