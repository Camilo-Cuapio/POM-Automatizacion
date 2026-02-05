package com.projectjunit.pom;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Base {
    private WebDriver driver;

    public Base(WebDriver driver) {
        this.driver = driver;
    }
//Conexion de pagina
    public WebDriver chromeDriverConnection() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        return driver;
    }
//Localizar elemento
    public WebElement findElement(By locator) {
        return driver.findElement(locator);
    }
//Coleccion de eleentos
    public List<WebElement> findElements(By locator) {
        return driver.findElements(locator);
    }
//Obtener texto
    public String getText(WebElement element) {
        return element.getText();
    }
//Obtener texto de elemento
    public String getText(By locator) {
        return driver.findElement(locator).getText();
    }
//Escribir texto
    public void type(String inputText, By locator) {
        driver.findElement(locator).sendKeys(inputText);
    }
//Dar click
    public void click(By locator) {
        driver.findElement(locator).click();
    }
//Se visualiza eleento
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
}



