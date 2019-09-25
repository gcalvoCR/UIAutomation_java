package testing.cap2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class AppTest 
{
    private WebDriver driver;

    /*
    * Steps
    * 1. Download the chromeDriver.exe
    * 2. Add a system property telling it where the chromeDriver is located
    *
    * */
    @Test
    public void secondTest()
    {
        //Let the system know where to find the chrome driver
        String path = "C:\\Users\\Gabriel\\Documents\\dev\\UIAutomation_java\\src\\test\\resources\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", path);

        //we initialize the driver
        driver = new ChromeDriver();

        //From there on the driver handles everything
        driver.get("https://www.google.com/");

        //We wait 5 secs with the browser opened
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
        }

        //Then we close it
        driver.close();

    }
}
