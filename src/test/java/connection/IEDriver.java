package connection;

import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;

import java.net.MalformedURLException;
import java.net.URL;

public class IEDriver extends DriverManager{

    ITestContext context;

    IEDriver(ITestContext context){
        this.context = context;
    }

    @Override
    protected void createDriver() {

        try {

            InternetExplorerOptions options = new InternetExplorerOptions();
            options.setCapability("build", "build number");

            driver = new RemoteWebDriver(new URL((String) context.getAttribute(Params.NODE_URI.param)), options);

        } catch (MalformedURLException ignored) {
        }
    }
}
