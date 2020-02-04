package testing.cap4;

import com.applitools.eyes.selenium.Eyes;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class AppTest 
{
    private WebDriver driver;
    private Eyes eyes;

    /*
    * So let's start abstracting the logic to be reusable
    *
    * */
    @BeforeMethod
    public void setUp(){
        String path = "./src/test/resources/chromedriver";
        System.setProperty("webdriver.chrome.driver", path);
        Properties props = System.getProperties();
        try {
            props.load(new FileInputStream(new File("./src/test/resources/test.properties")));
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }

        driver = new ChromeDriver();

        driver.get("file:///Users/gabrielcalvovargas/Documents/visual-testing/index.html");
        driver.manage().window().maximize();
        initiateEyes();

    }

    @AfterMethod
    public void tearDown(){
        driver.close();
        driver.quit();
        eyes.abortIfNotClosed();
    }

    @Test
    public void validateLogo()
    {
        try {
            Thread.sleep(2000);
            validateElement();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void initiateEyes() {
        eyes = new Eyes();
        eyes.setApiKey("tseDzTUYNzXWKN7IQCKT6EJp45oRHpuId71102Uz1scDc110");
    }

    private void validateWindow(){
        eyes.open(driver, "Validate", Thread.currentThread().getStackTrace()[2].getMethodName());
        eyes.checkWindow();
        eyes.close();
    }

    private void validateElement(){
        eyes.open(driver, "Validate FedCheckLogo", Thread.currentThread().getStackTrace()[2].getMethodName());
        eyes.checkElement(By.id("logo"));
        eyes.close();
    }
}
