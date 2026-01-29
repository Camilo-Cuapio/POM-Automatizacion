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

@Before
    public void setUp(){
  signInPage=new SignInPage(driver);
  driver=signInPage.chromeDriverConnection();
  signInPage.visit("https://demo.guru99.com/test/newtours/");
}
@After
    public void tearDown(){
    driver.quit();
}
@Test
    public void test() throws InterruptedException {
    signInPage.signIn();
    Thread.sleep(2000);
    assertTrue(signInPage.isHomePageDisplayed());
}


    }


