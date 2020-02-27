package connection;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;

import java.net.MalformedURLException;
import java.net.URL;

public class ChromeDriver extends DriverManager{

    ITestContext context;

    @Override
    protected void createDriver(String testName) {

        ChromeOptions chromeOptions = new ChromeOptions();
        System.setProperty("webdriver.chrome.driver","Selenium-Server/chromedriver");

        try {
            driver = new RemoteWebDriver(new URL((String) context.getAttribute("nodeURL")), chromeOptions);
        } catch (MalformedURLException e) {

        }
    }
}
