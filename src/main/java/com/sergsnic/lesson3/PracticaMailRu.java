package com.sergsnic.lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PracticaMailRu {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://mail.ru");
       // Thread.sleep(2000);
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='search-arrow__frame']")));
        driver.findElement(By.xpath("//input[@class = 'arrow__input mini-suggest__input']")).sendKeys("погода Белгород");
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//div//li[@data-text ='погода белгород на неделю']")));
        driver.findElement(By.xpath("//div//li[@data-text ='погода белгород на неделю']")).click();
        driver.switchTo().parentFrame();
        Thread.sleep(5000);
        driver.quit();
    }
}
