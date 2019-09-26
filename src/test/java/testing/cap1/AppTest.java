package testing.cap1;


import org.testng.Assert;
import org.testng.annotations.Test;

public class AppTest
{
    @Test
    public void miPrimerTest(){

        String mivariable = "Elemento logOut";
        System.out.println(mivariable);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
        }

        Assert.assertEquals(mivariable, "Accept button", "El elemento no fue encontrado");

    }

}
