package pages;

import base.Params;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestContext;

public class LoginPage extends BasePage{

    // Selectors
    @FindBy(css = "#customer_login input[type='email']") WebElement inputEmail;
    @FindBy(css = "#customer_login input[type='password']") WebElement inputPassword;
    @FindBy(css = "#customer_login button[type='submit']") WebElement btnSubmit;

    public LoginPage(ITestContext context) {
        super(context);
        PageFactory.initElements(driver, this);
    }

    public void typeEmail(String text){
        inputEmail.sendKeys(text);
    }
    public void submitForm(){
        btnSubmit.click();
    }

    @Step("Navegar a pagina login")
    public void goToLogin(){
        driver.get(url+"account/login?return_url=%2Faccount");
    }


    public boolean hasRequiredAttribute(WebElement ele){
        return  ele.getAttribute("required").equals("true");

    }

    @Step("Verificar el correo es requerido")
    public boolean checkEmailFieldRequired(){
        return hasRequiredAttribute(inputEmail);
    }

    @Step("Verificar contrasena es requerida")
    public boolean checkPasswordFieldRequired(){
        return hasRequiredAttribute(inputPassword);
    }

}
