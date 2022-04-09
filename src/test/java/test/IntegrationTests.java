package test;

import base.BaseClass;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.BasePage;
import pages.ComprasPage;
import pages.ProductPage;

public class IntegrationTests extends BaseClass {

    BasePage base;
    ProductPage product;
    ComprasPage compras;

    @Test(description="FU-001 Validacion de integracion carrito de compras con modulo de compras")
    public void validar_integracion_modulo_principal_modulo_compras() {
        product = new ProductPage(context);
        compras = new ComprasPage(context);

        product.get2ProductsAddedToShoppingCart();
        int total = product.getTotalAmount();
        product.comprar();
        Assert.assertTrue(compras.isResumenCompraDisplayed());
        Assert.assertEquals(total, compras.getTotalModuloCompras(), "El total no es el mismo del modulo principal");
    }

    @Test(description="I-002 Validacion de integracion con BOT")
    public void validar_integracion_con_bot() {
        base = new BasePage(context);

        base.openBotAndWrite("hola");
        Assert.assertTrue(base.isBotOpened(), "El BOT no abrió al clickear en el");
        Assert.assertTrue(base.isMessageinBot("hola"), "texto no fue escrito correctamente");
    }

    @Test(description="I-003 Validacion de integracion con sistema 'Mis Puntos'")
    public void validar_integracion_con_sistema_mis_puntos() {
        base = new BasePage(context);

        base.goToMisPuntos();
        Assert.assertEquals(driver.getCurrentUrl(), "https://cr.lineuprewards.com/check-balance/","El usuario no fue dirigido al sistema Mis Puntos");
    }

}
