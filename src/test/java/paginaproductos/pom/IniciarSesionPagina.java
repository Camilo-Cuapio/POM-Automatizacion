package paginaproductos.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class IniciarSesionPagina extends Base {
    By usuarioLocalizador = By.xpath("//*[@id=\"user-name\"]");
    By passLocalizador = By.cssSelector("#password");
    By loginBtnLocalizador = By.cssSelector(".submit-button");
    By paginaInicioLocalizador = By.cssSelector(".title");
    By errorContrasena = By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3");

    public IniciarSesionPagina(WebDriver driver) {
        super(driver);
    }

    public void iniciarSesion() {
        if (isDisplayed(usuarioLocalizador)) {
            type("standard_user", usuarioLocalizador);
            type("secret_sauce", passLocalizador);
            click(loginBtnLocalizador);
        } else {
            System.out.println("No se realizo el logeo correctamente");
        }
    }

    public Boolean ingesoPagina() {
        return isDisplayed(paginaInicioLocalizador);
    }

    public void iniciarSesionError() {
        if (isDisplayed(usuarioLocalizador)) {
            type("standard_user", usuarioLocalizador);
            type("secret_sauc", passLocalizador);
            click(loginBtnLocalizador);
        } else {
            System.out.println("No se realizo el logeo correctamente");
        }
    }
    public Boolean mensajeError(){
        return isDisplayed(errorContrasena);
    }
}
