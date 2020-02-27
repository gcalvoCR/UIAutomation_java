package connection;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;

import java.net.MalformedURLException;
import java.net.URL;

public class ChromeDriver extends DriverManager{

    ITestContext context;

    ChromeDriver(ITestContext context){
        this.context = context;
    }

    @Override
    protected void createDriver() {

        try {
            ChromeOptions options = new ChromeOptions();
            options.setCapability("build", "build number");
            options.addArguments("--no-sandbox");

            System.setProperty("webdriver.chrome.driver","Selenium-Server/chromedriver");
            System.out.println("node-uri"+(String) context.getAttribute(Params.NODE_URI.param));
            driver = new RemoteWebDriver(new URL((String) context.getAttribute(Params.NODE_URI.param)), options);

        } catch (MalformedURLException ignored) {
        }
    }
}
