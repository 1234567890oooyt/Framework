package webUI.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import webUI.BaseObject;
import webUI.decorator.MyButton;
import webUI.decorator.MyInput;
import webUI.decorator.MyText;


public class ProjectPage extends BaseObject {
    @FindBy(xpath ="//*[@id=\"project-name\"]")
    private MyInput projectName;
    @FindBy(xpath ="//*[@id=\"project-description\"]")
    private MyInput projectDescription;
    @FindBy(xpath ="//*[@id=\"main-container\"]/div[2]/div[2]/div/div/div[2]/div[2]/div/div[1]/form/button")
    private MyButton createProjectButton;
    @FindBy(xpath ="//*[@id=\"manage-project-create-form\"]/div/div[3]/input")
    private MyButton create;

    @FindBy(xpath ="//*[@id=\"main-container\"]/div[2]/div[2]/div/div/div[2]/div[2]/div/div[2]/table/tbody/tr/td[1]/a")
    private MyText projectText;

    public ProjectPage(WebDriver driver) {
        super(driver);
    }
    public ProjectPage createProject(){
        createProjectButton.myClick();
        return this;
    }
    public ProjectPage writeData(){
        projectName.input(RandomText());
        projectDescription.input("Description");
        return this;
    }
    public ProjectPage create(){
        create.myClick();
        return this;
    }
    public boolean checkCreation() throws InterruptedException {
        Thread.sleep(1000);
        return projectText.check();
    }
}
