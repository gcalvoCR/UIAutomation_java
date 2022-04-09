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
        this.wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(5)).pollingEvery(Duration.ofMillis(500))
                .ignoring(NoSuchElementException.class);
    }
    public void waitForPageToLoad() {
        try{
            long millis = 1000;
            Thread.sleep(millis);
            do {
                Thread.sleep(millis);
                millis = millis + 1000;
            } while (!(((JavascriptExecutor) driver).executeScript("return document.readyState").toString()
                    .equals("complete")) || millis <= 4000);
        } catch(InterruptedException e) {}
    }

    public void waitUntilClickable(WebElement ele){
        wait.until(ExpectedConditions.elementToBeClickable(ele));
    }



}
