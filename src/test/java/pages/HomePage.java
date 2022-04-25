package pages;

import io.qameta.allure.Step;
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

    @Step("Verificar si el banner fue desplegado")
    public boolean isBannerDisplayed(){
        return banner.isDisplayed();
    }

}
