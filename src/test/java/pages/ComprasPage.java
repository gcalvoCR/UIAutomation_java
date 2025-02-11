package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestContext;

public class ComprasPage extends BasePage{

    // Selectors
    @FindBy(css = ".payment-due [data-checkout-payment-due-target]") WebElement totalCompras;
    @FindBy(css = "#order-summary") WebElement resumenCompra;

    public ComprasPage(ITestContext context) {
        super(context);
        PageFactory.initElements(driver, this);
    }

    @Step("Verificar si el resumen de compra fue desplegado")
    public boolean isResumenCompraDisplayed(){
        helper.waitUntilClickable(resumenCompra);
        return resumenCompra.isDisplayed();
    }

    @Step("Obtener total en modulo de compras")
    public int getTotalModuloCompras(){
        String total =  totalCompras.getAttribute("data-checkout-payment-due-target");
        return Integer.parseInt(total.substring(0,total.length()-2));
    }

}
