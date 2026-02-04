package paginaproductos.pom;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class iniciarSesion_Test {
   private WebDriver driver;
   IniciarSesionPagina iniciarSesionPagina;

   @Before
    public void setUp(){
       iniciarSesionPagina=new IniciarSesionPagina(driver);
       driver=iniciarSesionPagina.chromeDriverConnection();
       iniciarSesionPagina.visit("https://www.saucedemo.com/");
   }
   @After
    public void tearDown(){
       driver.quit();
   }
   @Test
    public void test() throws InterruptedException {
       iniciarSesionPagina.iniciarSesion();
       Thread.sleep(2000);
      assertTrue(iniciarSesionPagina.ingresoPagina());
       iniciarSesionPagina.takeScreenshot("inicio de sesion");
   }
   @Test
    public void test2() throws InterruptedException {
       iniciarSesionPagina.iniciarSesionError();
       assertEquals("Epic sadface: Username and password do not match any user in this service",iniciarSesionPagina.mensajeErrorLogeo());
       iniciarSesionPagina.takeScreenshot("Contraseña incorrecta, Mensaje de error");
   }
   @Test
    public void test3(){
       iniciarSesionPagina.iniciarSesionError();
       assertEquals(1,iniciarSesionPagina.xUsu());
       assertEquals(1,iniciarSesionPagina.xPass());
       assertEquals(1,iniciarSesionPagina.xMsjErrorr());
       iniciarSesionPagina.takeScreenshot("Validación de X inicio con error");
   }


}
