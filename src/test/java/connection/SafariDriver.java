package connection;

import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.testng.ITestContext;

import java.net.MalformedURLException;
import java.net.URL;

public class SafariDriver extends DriverManager{

    ITestContext context;

    SafariDriver(ITestContext context){
        this.context = context;
    }

    @Override
    protected void createDriver() {

        try {
            SafariOptions options = new SafariOptions();
            options.setUseTechnologyPreview(true);

            System.setProperty("webdriver.safari.driver","/usr/bin/safaridriver");
            driver = new RemoteWebDriver(new URL((String) context.getAttribute(Params.NODE_URI.param)), options);

        } catch (MalformedURLException ignored) {
        }
    }
}
