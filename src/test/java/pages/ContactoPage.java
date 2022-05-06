package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestContext;

public class ContactoPage extends BasePage{

    // Selectors
    @FindBy(css = "input[name='name']") WebElement inputFirstName;
    @FindBy(css = "input[name='last_name']") WebElement inputLastName;
    @FindBy(css = "input[name='email']") WebElement inputEmail;
    @FindBy(css = "textarea[name='comment']") WebElement inputComment;
    @FindBy(css = "button.btn") WebElement submitButton;

    public ContactoPage(ITestContext context) {
        super(context);
        PageFactory.initElements(driver, this);
    }

    @Step("Llenar formulario con datos --> nombre: '{0}', apellidos: '{1}', correo: '{2}', comentario: '{3}'")
    public void fillInForm(String nombre, String apellidos, String correo, String comentario ){
        inputFirstName.sendKeys(nombre);
        inputLastName.sendKeys(apellidos);
        inputEmail.sendKeys(correo);
        inputComment.sendKeys(comentario);
        submitButton.click();
        helper.waitForPageToLoad();
    }

    @Step("Navegar a Contacto")
    public void goToContactPage(){
        driver.get("https://cr.lineuprewards.com/contact/");
    }

}
