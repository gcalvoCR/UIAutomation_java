package connection;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseClass {

    public DriverManager driverManager;
    protected ITestContext context;
    protected WebDriver driver;


    @BeforeTest(alwaysRun = true)
    public void setup(ITestContext context){
        this.context = context;
        setParameters();
        initializeDriver();
    }

    @AfterTest(alwaysRun = true)
    public void tearDown(ITestContext context){
        driverManager.quitDriver();
    }

    private void setParameters() {
        Parameters params = new Parameters(context);

        this.context.setAttribute(Params.ENVIRONMENT.param, params.getEnvironment());
        this.context.setAttribute(Params.GRID.param, params.getGrid());
        this.context.setAttribute(Params.NODE_URI.param, params.getNodeUri());
        this.context.setAttribute(Params.BROWSER.param, params.getBrowser());

        this.context.setAttribute(Params.URI.param, params.getUri());
        this.context.setAttribute(Params.USERNAME.param, params.getUsername());
        this.context.setAttribute(Params.PASSWORD.param, params.getPassword());

    }

    private void initializeDriver() {
        driverManager = DriverFactory.getManager(context);
        driver = driverManager.getDriver();
        driver.manage().window().maximize();

        driver.get((String) context.getAttribute(Params.URI.param));
        //We probably want to log in in here
    }
}


