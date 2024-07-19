package pages;

public class RegisterPage extends BasePage {

    public RegisterPage() {
        super(driver);
    }

    private String nombreInput = "//input[@id='name']";
    private String apellidoInput = "//input[@id='surname']";
    private String correoInput = "//input[@id='email']";
    private String contrasenaInput = "//input[@id='password']";
    private String confirmarContrasenaInput = "//input[@id='confirmedPassword']";
    private String ciudadInput = "//input[@id='city']";
    private String paisDropdown = "//select[@name='country_name']";

    public void ingresarNombre(String nombre) {
        writeText(nombreInput, nombre);
    }

    public void ingresarApellido(String apellido) {
        writeText(apellidoInput, apellido);
    }

    public void ingresarCorreo(String correo) {
        writeText(correoInput, correo);
    }

    public void ingresarContrasena(String contrasena) {
        writeText(contrasenaInput, contrasena);
    }

    public void confirmarContrasena(String contrasena) {
        writeText(confirmarContrasenaInput, contrasena);
    }

    public void ingresarCiudad(String ciudad) {
        writeText(ciudadInput, ciudad);
    }

    public void aceptarTerminosYCondiciones() {
        toggleCheckboxByLabel("Acepto los Términos y condiciones");
    }

    public void seleccionarPais(String pais) {
        selectOptionByVisibleText(paisDropdown, pais);
    }

    public String obtenerPaisSeleccionado() {
        return getSelectedOption(paisDropdown);
    }
}
