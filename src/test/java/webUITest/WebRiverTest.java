package webUITest;

import driverHelper.ParallelExc;
import listeners.AllureTestListener;
import listeners.CustomSuiteListener;
import listeners.CustomTestListener;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import webUI.BaseObject;
import webUI.pageObject.HomePage;
import webUI.pageObject.LogInPage;
import webUI.pageObject.ManagePage;
import webUI.pageObject.ProjectPage;

public class WebRiverTest extends ParallelExc {
    @DataProvider
    private Object[][] LogInProvider(){
        int n=2; //number of test data sets
        int m=1; //argument number (int a, int b, int expected)

        Object[][] res= new Object[n][m];
        res[0]= new Object[]{"http://localhost/my_view_page.php"};
        res[1]= new Object[]{"http://localhost/my_view_page.php"};
        return res;
    }
    @Test(dataProvider = "LogInProvider")
    public void  CreateProjectRoute2(String url) throws InterruptedException {
        WebDriver driver = getDriver();
        BaseObject baseObject = new BaseObject(driver);
        HomePage homePage = new HomePage(driver);
        LogInPage logInPage = new LogInPage(driver);
        ProjectPage projectPage = new ProjectPage(driver);
        ManagePage managePage = new ManagePage(driver);
        baseObject.open(url);
        logInPage
                .writeUserName()
                .writeUserPassword();
        homePage
                .goToManagePage();
        managePage
                .goToProjectPage();
        projectPage
                .createProject()
                .writeData()
                .create();
        Assert.assertTrue(projectPage.checkCreation());
    }
}
