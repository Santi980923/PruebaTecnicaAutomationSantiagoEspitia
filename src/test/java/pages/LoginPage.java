package pages;

public class LoginPage extends BasePage {

    public LoginPage() {
        super(driver);
    }

    private String emailInput = "//input[@name='email']";
    private String passwordInput = "//input[@name='password']";

    public void ingresarEmail(String email) {
        writeText(emailInput, email);
    }

    public void ingresarContrasena(String contrasena) {
        writeText(passwordInput, contrasena);
    }

}
