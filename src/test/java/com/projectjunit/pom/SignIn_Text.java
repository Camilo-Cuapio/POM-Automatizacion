package com.projectjunit.pom;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class SignIn_Text {
    //----- https://demo.guru99.com/test/newtours/
    private WebDriver driver;
    SignInPage signInPage;

    //Ingresr a pagina
    @Before
    public void setUp() {
        Base base = new Base();
        driver = base.chromeDriverConnection();
        if (driver != null) {
            signInPage = new SignInPage(driver);
            signInPage.visit("https://demo.guru99.com/test/newtours/");
        } else {
            throw new RuntimeException("No se pudo iniciar el WebDriver. Verifica la versión de Chrome.");
        }
    }

    //Cerrar pagina
    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    //Logeo de usuario creado y validación de ingreso a pagina
    @Test
    public void testSignIn() {
      signInPage.signIn();
      assertTrue(signInPage.isHomePageDisplayed());





      /*  if (driver == null || signInPage == null) {
            throw new RuntimeException("WebDriver o SignInPage no inicializado correctamente.");
        }

        // Realizar login
        signInPage.signIn();

        // Espera explícita de hasta 10 segundos para que el elemento de home page aparezca
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[1]/td/h3"))); // reemplaza con el locator real

        // Validación
        assertTrue("La página de inicio debería mostrarse tras login", signInPage.isHomePageDisplayed());
    }*/
    }
}