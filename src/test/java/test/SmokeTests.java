package test;

import base.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.BasePage;
import pages.ProductPage;

import java.util.Arrays;
import java.util.List;

public class SmokeTests extends BaseClass {

    BasePage base;
    ProductPage product;

    public List<String> subMenus = Arrays.asList(
            "Home",
            "Lo Nuevo",
            "Gift Cards",
            "Marcas",
            "Hombre",
            "Mujer",
            "Niño",
            "Teen",
            "Niña",
            "Bebé",
            "Hogar",
            "Sale",
            "Mis Puntos",
            "Tallas");

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
        product.get2ProductsAddedToShoppingCart();
        Assert.assertTrue(product.isCartItemDisplayed(), "El articulo no fue añadido al carrito");
    }
}
