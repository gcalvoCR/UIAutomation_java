package util;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class Helper {

    WebDriver driver;
    Wait wait;

    public Helper(WebDriver driver){
        this.driver = driver;
        this.wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(2)).pollingEvery(Duration.ofMillis(500))
                .ignoring(NoSuchElementException.class);
    }
    public void waitForPageToLoad() {
        try{
            long millis = 1000;
            Thread.sleep(1000);
            do {
                Thread.sleep(millis);
                millis = millis + 500;
            } while (!(((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete")) || millis <= 2000);
        } catch(InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

    public void waitUntilClickable(WebElement ele){
        wait.until(ExpectedConditions.elementToBeClickable(ele));
    }

}
