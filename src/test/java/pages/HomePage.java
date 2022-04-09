package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestContext;

public class HomePage extends BasePage{



    // Selectors
    @FindBy(xpath = "//img[contains(@srcset,'Banner-Desktop')]") WebElement banner;

    public HomePage(ITestContext context) {
        super(context);
        PageFactory.initElements(driver, this);
    }

    public boolean isBannerDisplayed(){
        return banner.isDisplayed();
    }

}
