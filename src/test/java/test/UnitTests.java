package test;

import base.BaseClass;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.LoginPage;
import pages.ProductPage;

@Listeners(base.ListenerTest.class)
public class UnitTests extends BaseClass {

    LoginPage login;
    ProductPage product;

    @DataProvider(name = "cantidad-productos")
    public Object[][] cantidadProductos(){
        return new Object[][] {{2}, {3}};
    }

    @Test(description="U-001 Validar calculo de precio de productos")
    public void validar_calculo_de_precio_de_productos() {
        product = new ProductPage(context);
        product.getProductsAddedToShoppingCart(2);
        Assert.assertEquals(product.getTotalAmount(), product.getQuantity()*product.getProductPrice(),
                "El total no es calculado correctamente");
    }

    @Test(description="U-002 Validar correo electronico es requerido en inicio de sesion")
    public void validar_correo_electronico_es_requerido_en_inicio_sesion() {
        login= new LoginPage(context);
        login.goToLogin();
        Assert.assertTrue(login.checkEmailFieldRequired(), "Correo electronico no tiene atributo 'requerido'");
    }

    @Test(description="U-003 Validar contrasena es requerida en inicio de sesion")
    public void validar_contrasena_es_requerida_en_inicio_sesion() {
        login= new LoginPage(context);
        login.goToLogin();
        Assert.assertTrue(login.checkPasswordFieldRequired(), "Contrasena no tiene atributo 'requerido'");
    }

    @Test(description="U-004 Validar para envio gratis",
    dataProvider = "cantidad-productos {0}")
    public void validar_calculo_para_envio_gratis(int cantidad) {
        product= new ProductPage(context);
        product.getProductsAddedToShoppingCart(cantidad);
        Assert.assertEquals(product.getAmountFreeDelivery(), 50000-product.getTotalAmount(), "El monto " +
                "restante para envio gratis es correcto");
    }
}
