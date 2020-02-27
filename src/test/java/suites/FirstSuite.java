package suites.suite1;

import org.testng.Assert;
import org.testng.annotations.Test;

public class FirstSuite
{
    @Test
    public void testAssertTrue() throws InterruptedException {

        String mivariable = "Accept button";
        System.out.println(mivariable);
        Thread.sleep(1000);
        Assert.assertEquals(mivariable, "Accept button", "The element was not found");

    }
}
