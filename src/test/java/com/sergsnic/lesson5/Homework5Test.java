package com.sergsnic.lesson5;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Homework5Test {
    WebDriver driver;
    WebDriverWait webDriverWait;
    Actions actions;

    private final static String MAIL_RU_URL = "https://mail.ru";
    ;

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        actions = new Actions(driver);
        driver.manage().window().maximize();
        driver.get(MAIL_RU_URL);
    }

    @Test
    void mailRuTest() throws InterruptedException {
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='search-arrow__frame']")));
        driver.findElement(
                        By.xpath("//input[@class = 'arrow__input mini-suggest__input']"))
                .sendKeys("погода Белгород");
        //WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//div//li[@data-text='погода белгород на неделю']")));
        driver.findElement(By.xpath("//div//li[@data-text='погода белгород на неделю']")).click();
        driver.switchTo().parentFrame();

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//a[.='Mail.ru  ']")));
        // Проверка отображения
        Assertions.assertEquals(driver.findElement
                (By.xpath("//a[.='Mail.ru  ']")).isDisplayed(), true);

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//iframe[@class='yandex-frame']")));
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='yandex-frame']")));
        Assertions.assertEquals(driver.findElement
                (By.xpath("//a//b[.='gismeteo.ru']")).isDisplayed(),true);
        Thread.sleep(5000);
    }

    @AfterEach
    void quitBrowser() {
        driver.quit();
    }
}