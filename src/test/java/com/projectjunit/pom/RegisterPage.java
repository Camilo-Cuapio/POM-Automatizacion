package com.projectjunit.pom;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class RegisterPage extends Base{

    By registerLinkLocator=By.linkText("REGISTER");
    By registerPageLocator=By.cssSelector("[src=\"images/mast_register.gif\"]");

    By usernameLocator=By.id("email");
    By passwordLocator=By.name("password");
    By confirmPasswordLocator=By.cssSelector("[name=\"confirmPassword\"]");

    By registerBtnLocator=By.name("submit");

    By registeredMessage=By.cssSelector("font");

   public RegisterPage(WebDriver driver){
       super(driver);
   }
   public void registerUser() throws InterruptedException {
   click(registerLinkLocator);
   Thread.sleep(2000);
   if (isDisplayed(registerPageLocator)){
       type("qualityadmin",usernameLocator);
       type("pass1",passwordLocator);
       type("pass1",confirmPasswordLocator);
       click(registerBtnLocator);
   }else {
       System.out.println("No se realizo el registro de usuario");
   }
   }
   public String registeredMessage(){
       List<WebElement> fonts=findElements(registeredMessage);
       return getText(fonts.get(5));
   }
}






