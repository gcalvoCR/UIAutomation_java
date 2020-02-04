package testing.cap1;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AppTest
{
    @Test
    public void testAssertTrue(){

        String mivariable = "Accept button";
        System.out.println(mivariable);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }

        Assert.assertEquals(mivariable, "Accept button", "El elemento no fue encontrado");

    }

    @Test
    public void testObjetos(){

        Persona keyrin = new Persona();
        keyrin.setId("124");
        keyrin.setNombre("Keyrin");

        Persona gabriel = new Persona();
        gabriel.setId("124");
        gabriel.setNombre("Keyrin");

        Assert.assertEquals(keyrin, keyrin, "Las personas no son iguales");

    }

}
