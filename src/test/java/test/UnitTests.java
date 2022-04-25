package test;

import base.BaseClass;
import base.ListenerTest;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductPage;

public class UnitTests extends BaseClass {

    LoginPage login;
    ProductPage product;


    @Test(description="U-001 Validar calculo de precio de productos")
    public void validar_calculo_de_precio_de_productos() {
        product = new ProductPage(context);
        product.get2ProductsAddedToShoppingCart();
        Assert.assertEquals(product.getTotalAmount(), product.getQuantity()*product.getProductPrice(), "El total no es calculado correctamente");
    }

    @Test(description="U-002 Validar correo electronico es requerido en inicio de sesion")
    public void validar_correo_electronico_es_requerido_en_inicio_sesion() {
        login= new LoginPage(context);
        login.goToLogin();
        Assert.assertTrue(login.checkEmailFieldRequired(), "Correo electronico no tiene atributo 'requerido'");
    }

    @Test(description="U-003 Validar para envio gratis")
    public void validar_calculo_para_envio_gratis() {
        product= new ProductPage(context);
        product.get2ProductsAddedToShoppingCart();
        Assert.assertEquals(product.getAmountFreeDelivery(), 50000-product.getTotalAmount(), "El monto restante para envio gratis es correcto");
    }

}
