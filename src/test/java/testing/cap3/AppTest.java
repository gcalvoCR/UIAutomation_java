package testing.cap3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class AppTest 
{
    private WebDriver driver;

    /*
    * So let's start abstracting the logic to be reusable
    *
    * */
    @BeforeMethod
    public void setUp(){
        String path = "C:\\Users\\Gabriel\\Documents\\dev\\UIAutomation_java\\src\\test\\resources\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", path);
        driver = new ChromeDriver();
    }

    @AfterMethod
    public void tearDown(){
        driver.close();
    }

    @Test
    public void secondTest()
    {
        driver.get("https://www.google.com/");
        driver.manage().window().maximize();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
        }

        assertTrue(true);
    }
}
