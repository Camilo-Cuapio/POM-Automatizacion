package paginaproductos.pom;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

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
       assertTrue(iniciarSesionPagina.ingesoPagina());
   }
   @Test
    public void test2() throws InterruptedException {
       iniciarSesionPagina.iniciarSesionError();
       Thread.sleep(2000);
       assertTrue(iniciarSesionPagina.mensajeError());
   }


}
