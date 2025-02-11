package pages;

import base.Params;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestContext;
import util.Helper;

import java.util.ArrayList;
import java.util.List;

public class BasePage {

    ITestContext context;
    WebDriver driver;
    String url;
    Helper helper;

    // Navbar selectors
    @FindBy(css = "img.Header__LogoImage") WebElement logo;
    @FindBy(css = "a[href='/cart']") WebElement iconShoppingCart;
    @FindBy(css = "a[href='/search']") WebElement iconSearch;
    @FindBy(css = ".CartItem__Price.Price") WebElement unitPriceProduct;
    @FindBy(css = ".CartItem .QuantitySelector input") WebElement quantityProduct;
    @FindBy(css = ".tdf-cart-total-parent span[style='white-space: nowrap;']") WebElement total;
    @FindBy(css = ".Drawer__Container p span") WebElement amountFreeDelivery;
    @FindBy(css = "[name='checkout']") WebElement btnComprar;
    @FindBy(css = "#wc-button .wc-button-3") WebElement btnBot;
    @FindBy(css = "#wc-chat-frame") WebElement bot;
    @FindBy(xpath = "//a[contains(text(), 'Mis Puntos')]/parent::li") WebElement linkMisPuntos;
    @FindBy(css = "textarea.wc-textarea") WebElement inputBot;
    @FindBy(css = ".CartItem") WebElement cartItem;
    @FindBy(css = "input[type='search']") WebElement inputSearch;
    @FindBy(css = ".boost-pfs-search-suggestion-item") List<WebElement> suggestionItems;
    @FindAll({@FindBy(css = ".boost-pfs-search-suggestion-item")}) List<WebElement> subMenus;
    @FindBy(css = ".Footer__Inner [aria-label='Facebook']") WebElement iconFacebook;
    @FindBy(css = ".Footer__Inner [aria-label='Instagram']") WebElement iconInstagram;
    @FindAll({@FindBy(css = ".CartItem")}) List<WebElement> cartItems;
    @FindBy(css = "a.hidden-phone") WebElement iconoLogin;
    @FindBy(xpath = "//a[text()='Ubicaciones']") WebElement linkUbicaciones;
    @FindBy(css =".EmptyState__Title") WebElement titulo404;
    @FindBy(css =".EmptyState__Action.Button") WebElement btnVolverInicio;



    public BasePage(ITestContext context) {
        this.context = context;
        this.driver = (WebDriver) context.getAttribute(Params.WEBDRIVER.param);
        this.url = (String) context.getAttribute(Params.URI.param);
        this.helper = new Helper(this.driver);
        PageFactory.initElements(driver, this);
    }

    @Step("Verificar titulo 404 se muestra")
    public boolean is404TitleDisplayed(){
        return titulo404.isDisplayed();
    }

    @Step("Verificar boton 'Volver a inicio' se muestra")
    public boolean isBtnInicioDisplayed(){
        return btnVolverInicio.isDisplayed();
    }

    @Step("Hacer click en boton 'Volver a inicio'")
    public void clickBtnVolverInicio(){
        btnVolverInicio.click();
        helper.waitForPageToLoad();
    }

    @Step("Hacer click en link 'Ubicaciones'")
    public void clickLinkUbicaciones(){
        linkUbicaciones.click();
        helper.waitForPageToLoad();
    }

    @Step("Hacer click en icono Login")
    public void clickLoginIcon(){
        iconoLogin.click();
        helper.waitForPageToLoad();
    }

    @Step("Verificar link a Facebook")
    public boolean isFacebookIconDisplayed(){
        return iconFacebook.isDisplayed();
    }

    @Step("Verificar link a Instagram")
    public boolean isInstagramIconDisplayed(){
        return iconInstagram.isDisplayed();
    }

    @Step("Verificar la lista de sugerencias")
    public boolean suggestionItemsContain(String text){
        if(suggestionItems.size() == 0){
            return false;
        }
        for(WebElement item: suggestionItems){
            if(!item.getText().contains(text)){ return false; }
        }
        return true;
    }

    @Step("Verificar si el item fue desplegado en carrito")
    public boolean isCartItemDisplayed(){
        return cartItem.isDisplayed();
    }

    @Step("Verificar si el logo fue desplegado")
    public boolean isLogoDisplayed(){
        return logo.isDisplayed();
    }

    @Step("Hacer click en logo")
    public void clickLogo(){
        logo.click();
        helper.waitForPageToLoad();
    }

    @Step("Buscar {0}")
    public void search(String text){
        clickSearch();
        helper.sendKeysWithDelay(inputSearch,text);
        inputSearch.click();
    }

    @Step("Hacer click en buscar")
    public void clickSearch(){
        iconSearch.click();
        helper.waitForPageToLoad();
    }

    @Step("Abrir carrito de compras")
    public void openShoppingCart(){
        helper.waitUntilClickable(iconShoppingCart);
        iconShoppingCart.click();
    }

    @Step("Obtener total")
    public int getTotalAmount(){
        String txt = total.getText();
        txt = txt.replaceAll("₡ ", "");
        txt = txt.replace(".", "");
        return Integer.parseInt(txt);
    }

    @Step("Obtener precio de producto")
    public int getProductPrice(){
        String txt = unitPriceProduct.getText();
        txt = txt.replaceAll("₡ ", "");
        txt = txt.replace(".", "");
        return Integer.parseInt(txt);
    }

    @Step("Obtener cantidad de producto")
    public int getQuantity(){
        String txt = quantityProduct.getAttribute("value");
        return Integer.parseInt(txt);
    }

    @Step("Obtener cantidad para 'Free delivery'")
    public int getAmountFreeDelivery(){
        try{ Thread.sleep(1000); } catch(Exception e){}
        String txt = amountFreeDelivery.getText();
        txt = txt.replaceAll("₡ ", "");
        txt = txt.replace(".", "");
        return Integer.parseInt(txt);
    }

    @Step("Hacer click en comprar")
    public void comprar(){
        btnComprar.click();
    }

    @Step("Abrir bot y escribir {0}")
    public void openBotAndWrite(String text){
        helper.waitForPageToLoad();
        driver.switchTo().frame("Botmaker");
        btnBot.click();
        inputBot.sendKeys(text);
        inputBot.sendKeys(Keys.RETURN);
    }

    @Step("Escribir en bot {0}")
    public boolean isMessageinBot(String text){
        return driver.findElement(By.xpath("//span[@class='Linkify']//div[text()='"+text+"']")).isDisplayed();
    }

    @Step("Verificar si bot esta desplegado")
    public boolean isBotOpened(){
        helper.waitUntilClickable(bot);
        return bot.isDisplayed();
    }

    @Step("Navegar a 'Mis Puntos'")
    public void goToMisPuntos(){
        linkMisPuntos.click();
        helper.waitForPageToLoad();
    }

    @Step("Navegar a {0}")
    public void goTo(String endpoint){
        driver.get(url+endpoint);
    }

    @Step("List submenus")
    public List<String> listSubmenus(){
        List<String> opciones = new ArrayList<>();
        for(WebElement ele: subMenus) opciones.add(ele.getText());
        return opciones;
    }

    @Step("Obtener cantidad de articulos en carrito")
    public int getCartItems(){
        return cartItems.size();
    }

    @Step("Verificar link '{0}'")
    public boolean isLinkDisplayed(String link){
        return driver.findElement(By.xpath("//div[@class='Footer__Inner']//a[text()='"+link+"']")).isDisplayed();
    }

}
