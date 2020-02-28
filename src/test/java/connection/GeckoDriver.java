package connection;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;

import java.net.MalformedURLException;
import java.net.URL;

public class GeckoDriver extends DriverManager{

    ITestContext context;

    GeckoDriver(ITestContext context){
        this.context = context;
    }

    @Override
    protected void createDriver() {

        try {
            String environment = (String)context.getAttribute(Params.ENVIRONMENT.param);

            if(environment.equals("local")){
                System.setProperty("webdriver.gecko.driver","selenium-server/geckodriver");
                driver = new FirefoxDriver();

            } else if(environment.equals("grid")){
                FirefoxOptions options = new FirefoxOptions();
                options.setCapability("build", "build number");
                options.addArguments("--no-sandbox");

                driver = new RemoteWebDriver(new URL((String) context.getAttribute(Params.NODE_URI.param)), options);
            }


        } catch (MalformedURLException ignored) {
        }
    }
}
