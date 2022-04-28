package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestContext;
import util.Helper;

import java.util.ArrayList;
import java.util.List;

public class CollectionsPage extends BasePage{

    // Selectors
    @FindAll({@FindBy(css = ".CollectionInner__Products span[class='ProductItem__Price Price Price--highlight Text--subdued']")}) List<WebElement> precioProductos;
    @FindAll({@FindBy(css = ".CollectionInner__Products p[class='ProductItem__Vendor Heading']")}) List<WebElement> marcasProductos;
    @FindBy(css = "[aria-label='Ordenar por']") WebElement opcionOrdenar;
    @FindBy(css = "[data-value='price-ascending']") WebElement opcionMenorPrecio;
    @FindBy(xpath = "//button[@class='boost-pfs-filter-button'][contains(.,'Athleta')]") WebElement marcaAthleta;

    public CollectionsPage(ITestContext context) {
        super(context);
        PageFactory.initElements(driver, this);
    }

    @Step("Ordenar por menor precio")
    public void sortByPriceAscending(){
        opcionOrdenar.click();
        opcionMenorPrecio.click();
        helper.waitForPageToLoad();
    }

    @Step("Leer precio de productos")
    public List<Integer> getPrices(){
        List<Integer> opciones = new ArrayList<Integer>();
        for(WebElement ele: precioProductos){
            int num = Helper.convertirANumero(ele.getText());
            opciones.add(num);
        }
        return opciones;
    }

    @Step("Leer marcas de productos")
    public List<String> getBrandOfProducts(){
        List<String> opciones = new ArrayList<String>();
        for(WebElement ele: marcasProductos){
            opciones.add(ele.getText());
        }
        return opciones;
    }

    @Step("Seleccionar marca 'Ahtleta'")
    public void selectFilterAthleta(){
        marcaAthleta.click();
        helper.waitForPageToLoad();
    }

    @Step("Ir a collections sale")
    public void goToCollectionsSale(){
        goTo("/collections/sale");
    }

}
