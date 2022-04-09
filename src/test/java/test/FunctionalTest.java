package test;

import base.BaseClass;
import base.Params;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.ComprasPage;
import pages.HomePage;
import pages.ProductPage;

public class FunctionalTest extends BaseClass {

    BasePage base;
    ProductPage product;

    @Test(description="FU-001 Validar que logo redirige a pagina principal desde cualquier sitio")
    public void validar_logo_redigire_apropiadamente() {
        base = new BasePage(context);
        base.goTo("/collections/gift-cards");
        base.clickLogo();
        Assert.assertEquals(driver.getCurrentUrl(), context.getAttribute(Params.URI.param),"El usuario no fue dirigido a la pagina de inicio");
    }

    @Test(description="FU-002 Validar que los articulos pueden ser añadidos al carrito de compras")
    public void validar_articulos_pueden_ser_anhadidos_a_carrito() {
        product = new ProductPage(context);
        product.get2ProductsAddedToShoppingCart();
        Assert.assertTrue(product.isCartItemDisplayed(), "El articulo no fue añadido al carrito");
    }

    @Test(description="FU-003 Validar busqueda predictiva")
    public void validar_busqueda_predictiva() {
        base = new BasePage(context);
        base.search("Pantalones");
        Assert.assertTrue(base.suggestionItemsContain("Pantalones"), "La busqueda predictiva mostro resultados que no son Pantalones");
    }
}
