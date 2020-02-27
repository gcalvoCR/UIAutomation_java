package connection;

import org.testng.ITestContext;

public class DriverFactory {

    ITestContext context;

    public DriverFactory(ITestContext context) {
        this.context = context;
    }

    public static DriverManager getManager(ITestContext context) {

        DriverManager driverManager;
        switch ((String) context.getAttribute("browser")) {
            case "FIREFOX":
                driverManager = new FirefoxDriver(context);
                break;
            case "IE":
                driverManager = new IEDriver(context);
                break;
            case "SAFARI":
                driverManager = new SafariDriver(context);
                break;
            case "CHROME":
            default:
                driverManager = new ChromeDriver(context);
        }
        return driverManager;
    }
}
