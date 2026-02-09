package com.projectjunit.pom;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;


public class Register_Test {
//----- https://demo.guru99.com/test/newtours/
private WebDriver driver;
RegisterPage registerPage;

@Before
public void setUp(){
Base base=new Base();
driver=base.chromeDriverConnection();
registerPage=new RegisterPage(driver);
registerPage.visit("https://demo.guru99.com/test/newtours/");
}
@After
    public void tearDown(){
    driver.quit();
}
@Test
    public void test() throws InterruptedException {
    registerPage.registerUser();
    assertEquals("Note: Your user name is qualityadmin.",registerPage.registeredMessage());
}
}

