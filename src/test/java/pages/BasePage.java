package pages;

import base.Params;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestContext;
import util.Helper;

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


    public BasePage(ITestContext context) {
        this.context = context;
        this.driver = (WebDriver) context.getAttribute(Params.WEBDRIVER.param);
        this.url = (String) context.getAttribute(Params.URI.param);
        this.helper = new Helper(this.driver);
        PageFactory.initElements(driver, this);
    }

    public boolean suggestionItemsContain(String text){
        if(suggestionItems.size() == 0){
            return false;
        }
        for(WebElement item: suggestionItems){
            if(!item.getText().contains(text)){ return false; }
        }
        return true;
    }

    public boolean isCartItemDisplayed(){
        return cartItem.isDisplayed();
    }

    public boolean isLogoDisplayed(){
        return logo.isDisplayed();
    }

    public void clickLogo(){
        logo.click();
        helper.waitForPageToLoad();
    }

    public void search(String text){
        clickSearch();
        inputSearch.sendKeys(text);
        helper.waitForPageToLoad();
    }

    public void clickSearch(){
        iconSearch.click();
        helper.waitForPageToLoad();
    }

    public void openShoppingCart(){
        helper.waitUntilClickable(iconShoppingCart);
        iconShoppingCart.click();
    }

    public int getTotalAmount(){
        String txt = total.getText();
        txt = txt.replaceAll("₡ ", "");
        txt = txt.replace(".", "");
        return Integer.parseInt(txt);
    }

    public int getProductPrice(){
        String txt = unitPriceProduct.getText();
        txt = txt.replaceAll("₡ ", "");
        txt = txt.replace(".", "");
        return Integer.parseInt(txt);
    }

    public int getQuantity(){
        String txt = quantityProduct.getAttribute("value");
        return Integer.parseInt(txt);
    }

    public int getAmountFreeDelivery(){
        try{ Thread.sleep(1000); } catch(Exception e){}
        String txt = amountFreeDelivery.getText();
        txt = txt.replaceAll("₡ ", "");
        txt = txt.replace(".", "");
        return Integer.parseInt(txt);
    }

    public void comprar(){
        btnComprar.click();
    }

    public void openBotAndWrite(String text){
        helper.waitForPageToLoad();
        driver.switchTo().frame("Botmaker");
        btnBot.click();
        inputBot.sendKeys(text);
        inputBot.sendKeys(Keys.RETURN);
    }

    public boolean isMessageinBot(String text){
        return driver.findElement(By.xpath("//span[@class='Linkify']//div[text()='"+text+"']")).isDisplayed();
    }

    public boolean isBotOpened(){
        helper.waitUntilClickable(bot);
        return bot.isDisplayed();
    }

    public void goToMisPuntos(){
        linkMisPuntos.click();
        helper.waitForPageToLoad();
    }

    public void goTo(String endpoint){
        driver.get(url+endpoint);
    }

}
