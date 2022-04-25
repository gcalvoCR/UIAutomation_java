package base;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext ;
import org.testng.ITestListener ;
import org.testng.ITestResult ;

public class ListenerTest implements ITestListener
{

    @Override
    public void onFinish(ITestContext Result)
    {

    }

    @Override
    public void onStart(ITestContext Result)
    {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult Result)
    {

    }

    // When Test case get failed, this method is called.
    @Override
    public void onTestFailure(ITestResult result)
    {
        System.out.println("El test fallo: "+result.getName());
        System.out.println("*** Test execution " + result.getMethod().getMethodName() + " failed...");
        System.out.println(result.getMethod().getMethodName() + " failed!");

        // attach screenshots to report
        saveScreenShot(result);
    }

    @Attachment
    public byte[] saveScreenShot(ITestResult result) {
        ITestContext context = result.getTestContext();
        WebDriver driver = (WebDriver) context.getAttribute("WebDriver");

        return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
    }

    // When Test case get Skipped, this method is called.
    @Override
    public void onTestSkipped(ITestResult result)
    {
        System.out.println("El test no corrio (skipped) :"+result.getName());
    }

    // When Test case get Started, this method is called.
    @Override
    public void onTestStart(ITestResult result)
    {
        System.out.println(result.getName()+" test case inicio");
    }

    // When Test case get passed, this method is called.
    @Override
    public void onTestSuccess(ITestResult result)
    {
        System.out.println("El test paso correctamente:"+result.getName());

        // attach screenshots to report
        saveScreenShot(result);
    }

}
