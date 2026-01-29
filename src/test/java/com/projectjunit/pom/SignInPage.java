package com.projectjunit.pom;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class SignInPage extends Base{

    By userLocator=By.name("userName");
    By passLocator=By.name("password");
    By signInBtnLocator=By.name("submit");

    By homePageLocator=By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[1]/td/h3");

 public SignInPage(WebDriver driver){
     super(driver);
 }
 public void signIn(){
     if (isDisplayed(userLocator)){
         type("qualityadmin", userLocator);
         type("pass1", passLocator);
         click(signInBtnLocator);
     }else {
         System.out.println("No se encuentra los elementos para signIn");
     }
 }
 public Boolean isHomePageDisplayed(){
return isDisplayed(homePageLocator);
 }
}

