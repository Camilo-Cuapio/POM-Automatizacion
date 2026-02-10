package paginaproductos.pom;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Base {
    private WebDriver driver;

    public Base() {

    }
    public Base(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver chromeDriverConnection() {
        try {
            // Prepara el ChromeDriver compatible
            WebDriverManager.chromedriver().setup();

            // ChromeOptions mínimo para estabilidad
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized"); // solo esta opción

            driver = new ChromeDriver(options);

        } catch (Exception e) {
            e.printStackTrace();
            driver = null; // evita NPE si falla la sesión
        }
        return driver;
    }
//Encontrar un elemento
    public WebElement findElement(By locator) {

        return driver.findElement(locator);
    }
//Collección Arraylist
    public List<WebElement> findElements(By locator) {

        return driver.findElements(locator);
    }
//Obtener texto
    public String getText(WebElement element) {

        return element.getText();
    }
//Obtener texto de un elemento
    public String getText(By locator) {
        return
                driver.findElement(locator).getText();
    }
//Escribir texto
    public void type(String inputText, By locator) {

        driver.findElement(locator).sendKeys(inputText);
    }
//Dar click a boton
    public void click(By locator) {

        driver.findElement(locator).click();
    }
//Se visualiza el elemento
    public Boolean isDisplayed(By locator) {
        try {
            return driver.findElement(locator).isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }
//Visitar pagina
    public void visit(String url) {

        driver.get(url);
    }
//Obtener URL
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    // Toma de captura de cada Test
    public void takeScreenshot(String name) {
        File screenshotFile = ((TakesScreenshot) driver)
                .getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(
                    screenshotFile,
                    new File(name + "_" + System.currentTimeMillis() + ".png")
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setImplicitWait(long seconds) {
        driver.manage().timeouts()
                .implicitlyWait(Duration.ofSeconds(seconds));
    }
}




