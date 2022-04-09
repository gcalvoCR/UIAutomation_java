package base;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseClass {

    protected ITestContext context;
    protected WebDriver driver;

    protected void setParameters() {
        Parameters params = new Parameters(context);

        this.context.setAttribute(Params.ENVIRONMENT.param, params.getEnvironment());
        this.context.setAttribute(Params.GRID.param, params.getGrid());
        this.context.setAttribute(Params.NODE_URI.param, params.getNodeUri());
        this.context.setAttribute(Params.BROWSER.param, params.getBrowser());

        this.context.setAttribute(Params.URI.param, params.getUri());
        this.context.setAttribute(Params.USERNAME.param, params.getUsername());
        this.context.setAttribute(Params.PASSWORD.param, params.getPassword());

    }

    protected void initializeDriver() {
        driver = DriverFactory.getDriver(context);

        //Setting implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
       // driver.manage().window().maximize();

        driver.get((String) context.getAttribute(Params.URI.param));
        this.context.setAttribute(Params.WEBDRIVER.param, driver);
    }

    @BeforeMethod()
    public void setup(ITestContext context){
        this.context = context;
        setParameters();
        initializeDriver();
    }

    @AfterMethod()
    public void tearDown(ITestContext context){
        if (driver != null) {
            driver.close();
            driver.quit();
        }
    }

}


