package com.sergsnic.lesson6;

import com.sergsnic.lesson7.AdditionalLogger;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.events.EventFiringDecorator;

import java.util.EventListener;

@Story("Главное  меню mail.ru")
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
        driver = new EventFiringDecorator(new AdditionalLogger()).decorate(new ChromeDriver(chromeOptions));
        driver.manage().window().maximize();
        driver.get("https://mail.ru/");
    }
      @Test
      @Feature("функция Поиск Mail.ru")
      @DisplayName("Поиск")
      @TmsLink("123")
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
        LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
        for(LogEntry log: logEntries) {
            Allure.addAttachment("Элемент лога браузера", log.getMessage());

        }
        driver.quit();
    }
}
