package com.sergsnic.lesson6;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PageObjectTest {
    WebDriver driver;

    @BeforeAll
    static void  registerDriver(){
        WebDriverManager.chromedriver().setup();
    }
    @BeforeEach
    void initDriver(){
        driver = new ChromeDriver();
        driver.get("http://automationpractice.com/index.php");
    }

    @Test
    void putTShirtToCartTest() {//throws InterruptedException {
        //Первая страница
//        MainPage mainPage = new MainPage(driver);
//        mainPage.clickSignInBatton();
        //Вторая страница
//        new LoginPage(driver).login("spartalex93@test.test", "123456");
//        Thread.sleep(5000);
new MainPage(driver).clickSignInBatton()
        .login("spartalex93@test.test", "123456")
        .mainMenuBlock
        .huverWomenButton()
        .clickTShirtsButton()
        .selectSize("S")
        .moveMouseToProductAndToCart()
        .checkTotalSumma("$18.51");
    }

    @AfterEach
    void killBrowser(){
        driver.quit();
    }
}
