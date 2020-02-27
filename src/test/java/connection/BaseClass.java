package connection;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.BeforeSuite;

public class BaseClass {

    public DriverManager driverManager;
    protected ITestContext context;
    protected WebDriver driver;


    @BeforeSuite
    public void setup(ITestContext context){
        this.context = context;
        setParameters(context);
        initializeDriver(context);
    }

    private void setParameters(ITestContext context) {
        Parameters params = new Parameters(context);

        context.setAttribute(Params.BROWSER.param, params.getBrowser());
        context.setAttribute(Params.URI.param, params.getUri());
        context.setAttribute(Params.TYPE.param, params.getType());
        context.setAttribute(Params.NODE_URI.param, params.getNodeUri());

        context.setAttribute(Params.USERNAME.param, params.getUsername());
        context.setAttribute(Params.PASSWORD.param, params.getPassword());

    }

    private void initializeDriver( ITestContext context) {
        driverManager = DriverFactory.getManager(context);
        driver = driverManager.getDriver();

        driver.get((String) context.getAttribute(Params.URI.param));
        //We probably want to log in in here
    }
}


