package util;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.Arrays;

public class Helper {

    WebDriver driver;
    Wait wait;

    public Helper(WebDriver driver){
        this.driver = driver;
        this.wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(2)).pollingEvery(Duration.ofMillis(500))
                .ignoring(NoSuchElementException.class);
    }

    public void specialWait() {
        try{
            long millis = 1500;
            Thread.sleep(1500);
            do {
                Thread.sleep(millis);
                millis = millis + 500;
            } while (!(((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete")) || millis <= 3000);
        } catch(InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

    public void waitForPageToLoad() {
        try{
            long millis = 500;
            Thread.sleep(500);
            do {
                Thread.sleep(millis);
                millis = millis + 500;
            } while (!(((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete")) || millis <= 1000);
        } catch(InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

    public void waitUntilClickable(WebElement ele){
        wait.until(ExpectedConditions.elementToBeClickable(ele));
    }

    public static int convertirANumero(String txt){
        try{
            txt = txt.replaceAll("₡ ", "");
            txt = txt.replace(".", "");
            txt = txt.replace(",", "");
            return Integer.parseInt(txt);
        } catch (Exception e){
            return -1;
        }
    }

    public void sendKeysWithDelay(By locator, CharSequence... charSequences) {
        WebElement element = driver.findElement(locator);
        this.sendKeysWithDelay(element, charSequences);
    }

    public void sendKeysWithDelay(WebElement element, CharSequence... charSequences) {
        element.click();
        try {
            Thread.sleep(700);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // break down the values to insert i.e. element.sendkeys("hi", Keys.SPACE, "how are you")
        Arrays.stream(charSequences).forEach(cS ->
                // break down each string into a list of 'chars'
                Arrays.stream(cS.toString().split(""))
                        // send each value
                        .forEach(c -> element.sendKeys(c))
        );
    }

}
