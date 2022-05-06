package test;

import base.BaseClass;
import base.Params;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.ContactoPage;
import pages.ProductPage;

@Listeners(base.ListenerTest.class)
public class FunctionalTest extends BaseClass {

    BasePage base;
    ProductPage product;
    ContactoPage contacto;

    @DataProvider(name = "busqueda-productos")
    public Object[][] busquedaProductos(){
        return new Object[][] {{"Pantalones"}, {"Gorro"}};
    }

    @Test(description="FU-001 Validar que logo redirige a pagina principal desde cualquier sitio")
    public void validar_logo_redigire_apropiadamente() {
        base = new BasePage(context);
        base.goTo("collections/gift-cards");
        base.clickLogo();
        Assert.assertEquals(driver.getCurrentUrl(), context.getAttribute(Params.URI.param),"El usuario no fue " +
                "dirigido a la pagina de inicio");
    }

    @Test(description="FU-002 Validar que icono de login redirige a pagina login desde cualquier sitio")
    public void validar_icono_login_redigire_apropiadamente() {
        base = new BasePage(context);
        base.goTo("/collections/gift-cards");
        base.clickLoginIcon();
        Assert.assertEquals(driver.getCurrentUrl(), "https://shop.lineuprewards.com/account/login?return_url=%2Faccount",
                "El usuario no fue dirigido a la pagina de login");
    }

    @Test(description="FU-002 Validar que los articulos pueden ser añadidos al carrito de compras")
    public void validar_articulos_pueden_ser_anhadidos_a_carrito() {
        product = new ProductPage(context);
        product.getProductsAddedToShoppingCart(2);
        Assert.assertTrue(product.isCartItemDisplayed(), "El articulo no fue añadido al carrito");
    }

    @Test(description="FU-003 Validar que los articulos pueden ser eliminados al carrito de compras")
    public void validar_articulos_pueden_ser_eliminados_del_carrito() {
        product = new ProductPage(context);
        product.getProductsAddedToShoppingCart(2);
        Assert.assertTrue(product.isCartItemDisplayed(), "El articulo no fue añadido al carrito");
        product.deleteProductFromCart();
        Assert.assertEquals(product.getCartItems(), 0, "El articulo no fue eliminado del carrito");
    }

    @Test(description="FU-004 y FU-005 Validar busqueda predictiva", dataProvider = "busqueda-productos" )
    public void validar_busqueda_predictiva(String articulo) {
        base = new BasePage(context);
        base.search(articulo);
        Assert.assertTrue(base.suggestionItemsContain(articulo), "La busqueda predictiva mostro " +
                "resultados que no son " + articulo);
    }

    @Test(description="FU-006 Validar busqueda predictiva caso sin resultados")
    public void validar_busqueda_predictiva_sin_resultados() {
        base = new BasePage(context);
        base.search("Hola");
        Assert.assertTrue(base.suggestionItemsContain("Sorry, nothing found for \"Hola\""), "La busqueda predictiva mostro reultados");
    }

    @Test(description="FU-008 Validar formulario de contacto")
    public void validar_formulario_contacto() {
        contacto = new ContactoPage(context);
        contacto.goToContactPage();
        contacto.fillInForm("Test", "Test", "test@test", "test");
        Assert.assertEquals(driver.getCurrentUrl(), "https://cr.lineuprewards.com/","El formulario de " +
                "contacto no proceso correctamente");
    }

    @Test(description = "FU-009 Validar se le muestra pagina 404 cuando usuario se dirige a pagina inexistente")
    public void validar_navegacion_404(){
        base = new BasePage(context);
        driver.get("https://shop.lineuprewards.com/hello/");
        Assert.assertTrue(base.is404TitleDisplayed(), "Titulo de pagina 404 no se muestra");
        Assert.assertTrue(base.isBtnInicioDisplayed(), "Boton 'Volver a Inicio' no se muestra");
    }

    @Test(description = "FU-010 Validar navegacion a inicio desde pagina 404")
    public void validar_navegacion_a_inicio_desde_404(){
        base = new BasePage(context);
        driver.get("https://shop.lineuprewards.com/hello/");
        base.clickBtnVolverInicio();
        Assert.assertEquals(driver.getCurrentUrl(), context.getAttribute(Params.URI.param),"El usuario no fue dirigido a la pagina de inicio");

    }

}
