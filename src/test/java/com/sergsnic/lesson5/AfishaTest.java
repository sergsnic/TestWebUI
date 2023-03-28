package com.sergsnic.lesson5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class AfishaTest {
    WebDriver driver;
    WebDriverWait webDriverWait;
    Actions actions;

    private final static String AFISHA_BASE_URL = "https://afisha.ru";

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(30));
        actions = new Actions(driver);
        driver.manage().window().maximize();
        driver.get(AFISHA_BASE_URL);

        // Закрытие всплывающих окон.
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[.='Верно']")));
        driver.findElement(By.xpath("//button[.='Верно']")).click();
//        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[.='Не сейчас']")));
//        driver.findElement(By.xpath("//button[.='Не сейчас']")).click();
    }

    @Test
    void likeMovieTest() throws InterruptedException {
        //Ожидание с проверкой, как только элементов становится больше 0, значит можно запускать заполнение списка(List)
        webDriverWait.until(d -> d.findElements(By.xpath(
                "//a[@data-test='LINK ITEM-NAME ITEM-URL' and contains(@href, 'movie')]//div")).size() > 0);
//        заполнение списка(List) элементами с фильмами
        List<WebElement> filmsList = driver.findElements(By.xpath(
                "//a[@data-test='LINK ITEM-NAME ITEM-URL' and contains(@href, 'movie')]//div"));
//        Выбор фильма из списка(фильм должен быть обязательно на странице иначе клик не пройдет)
        filmsList.stream().filter(f -> f.getText().contains("Миллионер на три дня")).findFirst().get().click();
//        filmsList.get(0).click();
//        Ожидание появления кнопки избранное
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                "//section[@data-test='PAGE-SECTION TITLE-SECTION']//button[@data-test='BUTTON FAVORITE']")));
//        Клик по кнопке
        driver.findElement(By.xpath(
                "//section[@data-test='PAGE-SECTION TITLE-SECTION']//button[@data-test='BUTTON FAVORITE']")).click();
//        Переход в фрейм
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@src,'login')]")));
//        Ожидание появления поля Логин
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id = 'login']")));
//        Проверка отображения поля Login
        Assertions.assertEquals(driver.findElement(By.xpath("//input[@id = 'login']")).isDisplayed(), true);
        Thread.sleep(5000);
    }


    @Test
    void hoverCinemaButtonAndClickOkkoLinkTest() throws InterruptedException {
        // Наведение на элемент КИНО
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[.='КИНО']")));
        actions.moveToElement(driver.findElement(By.xpath("//a[.='КИНО']")))
                .build()
                .perform();
        // Клик на элемент Скоро онлайн в Okko
       driver.findElement(By.xpath("//header//a[.='Скоро онлайн в Okko']")).click();
// Проверка правильности url адреса
        Assertions.assertEquals(driver.getCurrentUrl(), "https://www.afisha.ru/movie/okko-soon/");
        // Удаление блока рекламы(локатор не надежный меняется)
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//div[@data-test = 'HONEY-AD AD-ad_2']")));
        ((JavascriptExecutor)driver).executeScript
                ("let element = document.evaluate(\"//div[@data-test = 'HONEY-AD AD-ad_2']\", document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null)\n" +
                        "element.singleNodeValue.remove()");
                Thread.sleep(5000);
    }
    @Test
    void scroolElementSaitTest() throws InterruptedException {
        ((JavascriptExecutor)driver).executeScript
                ("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//button[.='Подписаться']")));
        Thread.sleep(5000);
    }

    @AfterEach
    void quitBrowser() {

        driver.quit();
    }
}
