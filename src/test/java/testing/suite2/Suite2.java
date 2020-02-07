package testing.suite2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class Suite2
{
    private WebDriver driver;

    /*
    * So let's start abstracting the logic to be reusable
    *
    * */
    @BeforeMethod
    public void setUp(){
        String path = "./src/test/resources/chromedriver";
        System.setProperty("webdriver.chrome.driver", path);
        driver = new ChromeDriver();
    }

    @AfterMethod
    public void tearDown(){
        driver.close();
    }

    @Test
    public void secondTest() throws InterruptedException {
        driver.get("https://www.google.com/");
        driver.manage().window().maximize();
        Thread.sleep(3000);
        assertTrue(true);
    }
}
