package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestContext;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends BasePage{

    // Selectors
    @FindBy(xpath = "//img[contains(@srcset,'Banner-Desktop')]") WebElement banner;
    @FindBy(css = "[href='/collections/bebe']") WebElement submenuBebe;
    @FindAll({@FindBy(xpath = "//li[@class='HorizontalList__Item']/a[.='Bebé']/following-sibling::div//a")}) List<WebElement> opcionesSubmenuBebe;


    public HomePage(ITestContext context) {
        super(context);
        PageFactory.initElements(driver, this);
    }

    @Step("Verificar si el banner fue desplegado")
    public boolean isBannerDisplayed(){
        return banner.isDisplayed();
    }

    @Step("Hacer Hover sobre el submenu bebe")
    public void hoverOverSubMenuBebe(){
        //Creating object of an Actions class
        Actions action = new Actions(driver);

        //Performing the mouse hover action on the target element.
        action.moveToElement(submenuBebe).perform();
    }

    @Step("Obtener lista de opciones del submenu")
    public List<String> getListOfOptionsSubmenuBebe(){
        List<String> opciones = new ArrayList<String>();
        for(WebElement ele: opcionesSubmenuBebe){
            opciones.add(ele.getText());
        }
        return opciones;
    }

}
