package test;

import base.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.BasePage;
import pages.ProductPage;

import java.util.Arrays;
import java.util.List;

@Listeners(base.ListenerTest.class)
public class SmokeTests extends BaseClass {

    BasePage base;
    ProductPage product;

    public List<String> subMenus = Arrays.asList(
            "Home", "Lo Nuevo", "Gift Cards", "Marcas", "Hombre", "Mujer",
            "Niño", "Teen", "Niña", "Bebé", "Hogar", "Sale", "Mis Puntos", "Tallas");

    @Test(description="H-001 Validar secciones principales")
    public void validar_elementos_submenu() {
        base = new BasePage(context);
        List<String> opciones = base.listSubmenus();
        SoftAssert assess = new SoftAssert();
        for(String opcion: opciones){
            assess.assertTrue(subMenus.contains(opcion));
        }
        assess.assertAll();
    }

    @Test(description="H-002 Validar links a redes sociales")
    public void validar_links_a_redes_sociales() {
        base = new BasePage(context);
        Assert.assertTrue(base.isFacebookIconDisplayed(), "Link a facebook no se muestra");
        Assert.assertTrue(base.isInstagramIconDisplayed(), "Link a facebook no se muestra");
    }

    @Test(description="H-003 Validar carrito contiene productos cuando son anadidos")
    public void validar_carrito_de_compras() {
        product = new ProductPage(context);
        product.getProductsAddedToShoppingCart(2);
        Assert.assertTrue(product.isCartItemDisplayed(), "El articulo no fue añadido al carrito");
    }

    @Test(description="H-004 Validar navegacion a 'Ubicaciones'")
    public void validar_ubicaciones() {
        base = new BasePage(context);
        base.clickLinkUbicaciones();
        Assert.assertEquals(driver.getCurrentUrl(), "https://cr.lineuprewards.com/stores/", "El usuario " +
                "no fue dirigido a Ubicaciones");
    }

    @Test(description="H-005 Validar elementos del footer")
    public void validar_elementos_footer() {
        base = new BasePage(context);
        List<String> links = Arrays.asList(
                "Contactanos / Chat",
                "Ubicaciones",
                "Política de Privacidad",
                "Política de devoluciones",
                "Política de envío",
                "Términos y Condiciones");
        for(String link: links) Assert.assertTrue(base.isLinkDisplayed(link), "Link '"+link+"' no se encuentra en Footer");
    }
}
