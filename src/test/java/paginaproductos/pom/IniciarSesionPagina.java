package paginaproductos.pom;

import com.google.gson.internal.bind.util.ISO8601Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class IniciarSesionPagina extends Base {

    By usuarioLocalizador = By.xpath("//*[@id=\"user-name\"]");
    By passLocalizador = By.cssSelector("#password");
    By loginBtnLocalizador = By.cssSelector(".submit-button");
    //Mensaje de error, contraseña incorrecta
    By errorContrasenaMensaje = By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3");
    //Localizadores de X
    By xUsuario = By.cssSelector("#login_button_container>div>form>div:nth-child(1)>svg");
    By xPassword = By.cssSelector("#login_button_container>div>form>div:nth-child(2)>svg");
    By xMsjError = By.cssSelector(".error-message-container>h3>button>svg");
    By listadeProductosElement = By.cssSelector(".inventory_item_name ");

    public IniciarSesionPagina(WebDriver driver) {
        super(driver);
    }
//Iniciar sesion con usuario y contraseña incorrecta

    public void iniciarSesion() {
        if (isDisplayed(usuarioLocalizador)) {
            type("standard_user", usuarioLocalizador);
            type("secret_sauce", passLocalizador);
            click(loginBtnLocalizador);
        } else {
            System.out.println("No se realizo el logeo correctamente");
        }
    }

    public Boolean ingresoPagina() {
        return getCurrentUrl().contains("inventory.html");
    }
//Iniciar sesion con contraseña incorrecta

    public void iniciarSesionError() {
        if (isDisplayed(usuarioLocalizador)) {
            type("standard_user", usuarioLocalizador);
            type("secret_sauc", passLocalizador);
            click(loginBtnLocalizador);
        } else {
            System.out.println("No se realizo el logeo correctamente");
        }
    }

    public String mensajeErrorLogeo() {

        return getText(errorContrasenaMensaje);

    }

    //Validacion de X en Usuario, Password y MsjError

    public int xUsu() {
        List<WebElement> xUsu = findElements(xUsuario);
        return xUsu.size();
    }

    public int xPass() {
        List<WebElement> xPass = findElements(xPassword);
        return xPass.size();
    }

    public int xMsjErrorr() {
        List<WebElement> xMsjErrorr = findElements(xMsjError);
        return xMsjErrorr.size();
    }
    //Obtener actuales productos

    public List<String> actualProductoss() {
        List<WebElement> actualProductoselement = findElements(listadeProductosElement);
        List<String> actualProductos = new ArrayList<>();

        for (WebElement element : actualProductoselement) {
            actualProductos.add(element.getText());
        }
        return actualProductos;
    }
}





