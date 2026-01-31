package paginaproductos.pom;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Base {
    private WebDriver driver;

    public Base(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver chromeDriverConnection() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        return driver;
    }

    public WebElement findElement(By locator) {
        return driver.findElement(locator);
    }

    public List<WebElement> findElements(By locator) {
        return driver.findElements(locator);
    }

    public String getText(WebElement element) {
        return element.getText();
    }

    public String getText(By locator) {
        return driver.findElement(locator).getText();
    }

    public void type(String inputText, By locator) {
        driver.findElement(locator).sendKeys(inputText);
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }

    public Boolean isDisplayed(By locator) {
        try {
            return driver.findElement(locator).isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    public void visit(String url) {

        driver.get(url);
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    // Tomar imagenes de la ejecucion
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




