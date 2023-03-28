package com.sergsnic.lesson6;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Homework6Test {
    WebDriver driver;

    @BeforeAll
    static void  registerDriver(){
        WebDriverManager.chromedriver().setup();
    }
    @BeforeEach
    void initDriver() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*","ignore-certificate-errors");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.get("https://mail.ru/");
    }
      @Test
    void mailRuTest()  {
        new MainPageHomeWork(driver)
                .openFrame()
                .seachMenu()
                .seachSubString()
                .iconMailCheck()
                .frameOpen()
                .gismeteoWebsaitCheck();
    }

    @AfterEach
    void quitBrowser() {
        driver.quit();
    }
}
