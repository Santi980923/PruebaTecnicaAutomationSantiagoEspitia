package pages;

// Importaciones necesarias
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {

    protected static final String BUTTON_XPATH_TEMPLATE = "//span[normalize-space()='%s']";

    protected static final String CHECKBOX_XPATH_TEMPLATE = "//input[@id='accpet']";

    /*
     * Declaración de una variable estática 'driver' de tipo WebDriver
     * Esta variable va a ser compartida por todas las instancias de BasePage y sus
     * subclases
     */
    protected static WebDriver driver;
    /*
     * Declaración de una variable de instancia 'wait' de tipo WebDriverWait.
     * Se inicializa inmediatamente con una instancia dew WebDriverWait utilizando
     * el 'driver' estático
     * WebDriverWait se usa para poner esperas explícitas en los elementos web
     */
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

    /*
     * Configura el WebDriver para Chrome usando WebDriverManager.
     * WebDriverManager va a estar descargando y configurando automáticamente el
     * driver del navegador
     */
    static {
        WebDriverManager.chromedriver().setup();

        // Inicializa la variable estática 'driver' con una instancia de ChromeDriver
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    /*
     * Este es el constructor de BasePage que acepta un objeto WebDriver como
     * argumento.
     */
    public BasePage(WebDriver driver) {
        BasePage.driver = driver;
    }

    // Método estático para navegar a una URL.
    public static void navigateTo(String url) {
        driver.get(url);
    }

    // Método estático para cerrar la instancia del driver.
    public static void closeBrowser() {
        driver.quit();
    }

    /*
     * Encuentra y devuelve un WebElement en la pagina utilzando un locator XPath,
     * esperando a que este presente en el DOM
     */
    private WebElement find(String locator) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
    }

    public void clickElement(String locator) {
        find(locator).click();
    }

    protected void writeText(String locator, String text) {
        find(locator).sendKeys(text);
    }

    public void clickButtonByText(String buttonText) {
        String xpath = String.format(BUTTON_XPATH_TEMPLATE, buttonText);
        clickElement(xpath);
    }

    public void toggleCheckboxByLabel(String label) {
        String xpath = String.format(CHECKBOX_XPATH_TEMPLATE, label);
        WebElement checkbox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));

        if (!checkbox.isSelected()) {
            checkbox.click();
        }
    }

    protected void selectOptionByVisibleText(String locator, String optionText) {
        WebElement element = find(locator);
        Select select = new Select(element);
        select.selectByVisibleText(optionText);
    }

    protected void selectOptionByValue(String locator, String value) {
        WebElement element = find(locator);
        Select select = new Select(element);
        select.selectByValue(value);
    }

    protected String getSelectedOption(String locator) {
        WebElement element = find(locator);
        Select select = new Select(element);
        return select.getFirstSelectedOption().getText();
    }

    public void waitForSeconds(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Thread was interrupted, Failed to complete operation");
        }
    }

}