package pages;

public class PaginaPrincipal extends BasePage {

    private String iniciarSesionButton = "//span[normalize-space()='Inicia sesión']";

    public PaginaPrincipal() {
        super(driver);
    }

    // Método para navegar a
    // https://ed.team/blog/las-mejores-apis-publicas-para-practicar
    public void navigateToApiPublica() {
        navigateTo("https://ed.team/blog/las-mejores-apis-publicas-para-practicar");

    }

    public void clickComenzarGratis() {
        clickButtonByText("¡Comienza gratis!");
    }

    public void clickIniciarSesion() {
        clickButtonByText("Inicia sesión");
    }
    

}