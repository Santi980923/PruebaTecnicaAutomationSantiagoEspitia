package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import pages.PaginaPrincipal;
import pages.RegisterPage;

public class RegisterSteps {

    PaginaPrincipal landingPage = new PaginaPrincipal();
    RegisterPage registerPage = new RegisterPage();
    LoginPage loginPage = new LoginPage();

    @Given("I navigate to the register page")
    public void iNavigateToAPI() {
        landingPage.navigateToApiPublica();
    }

    @When("I click on {string} for login or register")
    public void clickOnButton(String buttonText) {
        registerPage.waitForSeconds(10);
        landingPage.clickButtonByText(buttonText);
    }

    @And("I fill in the registration form")
    public void fillRegistrationForm() {
        registerPage.waitForSeconds(10);
        registerPage.ingresarNombre("John");
        registerPage.ingresarApellido("Doe");
        registerPage.ingresarCorreo("john.doe@example.com");
        registerPage.ingresarContrasena("password123");
        registerPage.confirmarContrasena("password123");
        registerPage.ingresarCiudad("Bogota");
    }

    @And("I select {string} as the country")
    public void selectCountry(String country) {
        registerPage.seleccionarPais(country);
    }

    @And("I accept the terms and conditions")
    public void acceptTermsAndConditions() {
        registerPage.aceptarTerminosYCondiciones();
    }

    @Then("I click on {string} button")
    public void clickOnRegisterButton(String buttonText) {
        registerPage.clickButtonByText(buttonText);
        registerPage.waitForSeconds(10);
    }

    @And("I return to the main page")
    public void returnToMainPage() {
        landingPage.navigateToApiPublica();
    }

    // Login
    @When("I click on {string}")
    public void clickOnLoginButton(String buttonText) {
        landingPage.clickButtonByText(buttonText);
        registerPage.waitForSeconds(10);
    }

    @And("I fill in the login form")
    public void fillLoginForm() {
        loginPage.ingresarEmail("john.doe@example.com");
        loginPage.ingresarContrasena("password123");
    }

    @Then("I click on {string} button for sign in")
    public void clickOnSigninButton(String buttonText) {
        registerPage.clickButtonByText(buttonText);
        registerPage.waitForSeconds(8);
    }

}