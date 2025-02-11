package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestContext;
import util.Helper;

public class ProductPage extends BasePage{

    // Selectors
    @FindBy(css = "span[data-action='increase-quantity']") WebElement btnIncreaseAmount;
    @FindBy(css = ".Product__Info button[type='submit']") WebElement btnAddToCard;
    @FindBy(css= "[data-action='remove-item']") WebElement btnDelete;

    public ProductPage(ITestContext context) {
        super(context);
        PageFactory.initElements(driver, this);
    }

    @Step("Anadir '{0}' productos a carrito de compras")
    public void getProductsAddedToShoppingCart(int cantidad){
        goToSpecificProductPage();
        for(int i = 1; i < cantidad; i++){
            increaseAmount();
            addProductToCart();
        }
    }

    public void increaseAmount(){
        btnIncreaseAmount.click();
        helper.waitForPageToLoad();
    }

    public void addProductToCart(){
        btnAddToCard.click();
        helper.waitForPageToLoad();
    }

    public void deleteProductFromCart(){
        btnDelete.click();
        helper.waitForPageToLoad();
    }

    public void goToSpecificProductPage(){
        driver.get(url+"collections/hombre/products/on-graphic-go-dry-cool-odor-control-core-t-shirt-for-men-olive-camo-victory-everyday-magic01737944-01");
        helper.waitForPageToLoad();
    }

}
