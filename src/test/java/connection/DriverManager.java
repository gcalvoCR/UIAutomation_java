package connection;

import org.openqa.selenium.WebDriver;

public abstract class DriverManager {

    protected WebDriver driver;

    protected abstract void createDriver();

    public void quitDriver() {
        driver.quit();
    }

    public WebDriver getDriver(){
        createDriver();
        return this.driver;
    }

}
