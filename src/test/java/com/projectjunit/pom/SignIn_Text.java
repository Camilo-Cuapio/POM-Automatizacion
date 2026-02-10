package com.projectjunit.pom;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertTrue;

public class SignIn_Text {
    //----- https://demo.guru99.com/test/newtours/
private WebDriver driver;
SignInPage signInPage;

//Ingresr a pagina
@Before
    public void setUp(){
    Base base = new Base();
    driver=base.chromeDriverConnection();
    if (driver != null) {
  signInPage=new SignInPage(driver);
  signInPage.visit("https://demo.guru99.com/test/newtours/");
    } else {
        throw new RuntimeException("No se pudo iniciar el WebDriver. Verifica la versión de Chrome.");
    }
}

//Cerrar pagina
@After
    public void tearDown(){
    if (driver != null) {
        driver.quit();
    }
}
//Logeo de usuario creado y validación de ingreso a pagina
@Test
    public void test() throws InterruptedException {
    signInPage.signIn();
    Thread.sleep(2000);
    assertTrue(signInPage.isHomePageDisplayed());
}


    }


