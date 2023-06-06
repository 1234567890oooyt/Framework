package listeners;

import driverHelper.ParallelExc;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import static hibernate.HibernateMain.*;

public class AllureTestListener implements ITestListener {



    @Attachment(value="Page screen", type="image/png")
    public byte[] getScreenshot(){
        return ((TakesScreenshot) ParallelExc.getDriver())
                .getScreenshotAs(OutputType.BYTES);
    }

    @Attachment(value="{0}", type="text/plain")
    public String getDom(){
        return ParallelExc.getDriver().getPageSource();
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ITestListener.super.onTestFailure(result);
        getScreenshot();
        getDom();
//        beginTrans();
//        saveToWebLogs(result.getEndMillis(),getDom(),result.getName());
//        closeSession();

    }
    @Override
    public void onTestSuccess(ITestResult result) {
        ITestListener.super.onTestSuccess(result);
        getScreenshot();
        getDom();
        System.out.println(getDom());


    }
    @Override
    public void onFinish(ITestContext context) {
        ITestListener.super.onFinish(context);
        getScreenshot();
        getDom();
    }
}
