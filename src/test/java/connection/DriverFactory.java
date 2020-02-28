package connection;

import org.testng.ITestContext;

public class DriverFactory {

    public static DriverManager getManager(ITestContext context) {

        DriverManager driverManager;

        switch ((String) context.getAttribute(Params.BROWSER.param)) {
            case "SAFARI":
                driverManager = new SafariDriver(context);
                break;
            case "IE":
                driverManager = new IEDriver(context);
                break;
            case "FIREFOX":
                driverManager = new GeckoDriver(context);
                break;
            case "CHROME":
            default:
                driverManager = new ChromeDriver(context);
        }
        return driverManager;
    }
}
