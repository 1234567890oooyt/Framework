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
import webUI.pageObject.*;
@Listeners({
        CustomTestListener.class,
        CustomSuiteListener.class,
        AllureTestListener.class
})
public class WebRiverTest extends ParallelExc {
    @DataProvider
    private Object[][] LogInProvider(){
        int n=2;
        int m=2;

        Object[][] res= new Object[n][m];
        res[0]= new Object[]{"72c71a6e-a","Qqwe12345678"};
        res[1]= new Object[]{"329c777d-e","Qqwe12345678"};
        return res;
    }
    @Test (dataProvider = "LogInProvider")
    public void  CreateProblemRoute(String userName, String pass) throws InterruptedException {
        WebDriver driver = getDriver();
        BaseObject baseObject = new BaseObject(driver);
        HomePage homePage = new HomePage(driver);
        LogInPage logInPage = new LogInPage(driver);
        ProblemPage problemPage = new ProblemPage(driver);
        ProblemsBrowserPage problemsBrowserPage = new ProblemsBrowserPage(driver);
        CreateProblemPage createProblemPage = new CreateProblemPage(driver);
        baseObject.open("http://localhost/my_view_page.php");
        logInPage
                .writeUserNameForDataProvider(userName)
                .writeUserPasswordForDataProvider(pass);
        homePage
                .goToProblemPage();
        problemPage
                .openSelect()
                .chooseOption();
        createProblemPage
                .selectUser()
                .writeInfo()
                .createProblem();
        Assert.assertTrue(problemsBrowserPage.getProblemName());

    }
}
