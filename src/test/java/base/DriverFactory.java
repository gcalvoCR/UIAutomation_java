package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestContext;

public class DriverFactory {

    public static WebDriver getDriver(ITestContext context) {

        WebDriver driver;

        switch ((String) context.getAttribute(Params.BROWSER.param)) {
            case "IE":
                WebDriverManager.iedriver().setup();
                driver = new InternetExplorerDriver();
                break;
            case "FIREFOX":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "CHROME":
                ChromeOptions options = new ChromeOptions();
                options.addArguments("window-size=1920,1080");
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver(options);
                break;
            default:
                throw new RuntimeException("Browser type unsupported");
        }
        return driver;
    }
}
