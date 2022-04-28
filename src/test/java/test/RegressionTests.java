package test;

import base.BaseClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.CollectionsPage;
import pages.HomePage;
import pages.LoginPage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RegressionTests extends BaseClass {

    CollectionsPage collections;
    HomePage home;

    public List<String> menuBebe = Arrays.asList(
            "Camisas",
            "Camisetas",
            "Sudaderas",
            "Jackets",
            "Vestidos",
            "Denim",
            "Pantalones",
            "Shorts",
            "Trajes de Baño",
            "Medias",
            "Zapatos",
            "Accesorios",
            "Pijamas",
            "OnePiece & Sets");

    @Test(description="RE-001 Validar elementos de submenu 'Bebe'")
    public void validar_elementos_submenu() {
        home = new HomePage(context);
        home.hoverOverSubMenuBebe();
        List<String> opciones = home.getListOfOptionsSubmenuBebe();
        SoftAssert assess = new SoftAssert();
        for(String opcion: opciones){
            assess.assertTrue(menuBebe.contains(opcion));
        }
        assess.assertAll();
    }

    @Test(description="RE-002 Validar ordenar busqueda por precio ascendente")
    public void validar_ordenar_busqueda_precio_ascendente() {
        collections = new CollectionsPage(context);
        collections.goToCollectionsSale();
        collections.sortByPriceAscending();
        List<Integer> precios = collections.getPrices();
        SoftAssert assess = new SoftAssert();
        for(int i=1; i < precios.size(); i++){
            assess.assertTrue(precios.get(i-1)<= precios.get(i));
        }
        assess.assertAll();
    }

    @Test(description="RE-003 Validar filtros por marca la busqueda de artículos 'Athleta'")
    public void validar_filtros_busqueda() {
        collections = new CollectionsPage(context);
        collections.goToCollectionsSale();
        collections.selectFilterAthleta();
        List<String> marcas = collections.getBrandOfProducts();
        SoftAssert assess = new SoftAssert();
        for(String marca: marcas){
            assess.assertEquals(marca, "Athleta", "Hay marcas distintas a 'Athleta en la busqueda. Revise los filtros'");
        }
        assess.assertAll();
    }
}
