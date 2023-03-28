package com.sergsnic.lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Date;
import java.util.List;

public class DiaryTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
//        driver.get("https://diary.ru/user/login");
//        WebElement loginForm = driver.findElement(By.id("loginform-username"));
//        loginForm.sendKeys("sergsnic");
//        driver.findElement(By.id("loginform-password")).sendKeys("Sergsnic01");
//        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='reCAPTCHA']")));
//        driver.findElement(By.xpath("//div[@class='recaptcha-checkbox-border']")).click();
//        driver.switchTo().parentFrame();
//
//        driver.findElement(By.id("login_btn")).click();

        driver.get("https://diary.ru");
        Cookie cookie = new Cookie("_identity_", "585b20c972c278d441e16667cd30b434e1f5ff6b530cbab4a82f0dcba3046cd0a%3A2%3A%7Bi%3A0%3Bs%3A10%3A%22_identity_%22%3Bi%3A1%3Bs%3A52%3A%22%5B3579384%2C%22dtPbZGlJY7diblgEArDGxFPa-9SRgQrH%22%2C2592000%5D%22%3B%7D");
        driver.manage().addCookie(cookie);
        driver.navigate().refresh();

//        удаление куки(logout)
//       driver.manage().getCookieNamed("_identity_");
//        driver.manage().getCookieNamed("_session");
//        driver.navigate().refresh();

        driver.findElement(By.id("writeThisDiary")).click();
        Date date = new Date();
        final String postTitle = "Test " + date.toString();
        driver.findElement(By.id("postTitle")).sendKeys(postTitle);
        driver.switchTo().frame(driver.findElement(By.id("message_ifr")));
        driver.findElement(By.id("tinymce")).sendKeys(postTitle);
        driver.switchTo().parentFrame();
        driver.findElement(By.id("rewrite")).click();
        //driver.findElement(By.xpath(String.format("//a[text = '%s']", postTitle))).click();
//        List<WebElement> postTitles = driver.findElements(By.xpath("a//[@class='title']"));
//        postTitles.stream().filter(p -> p.getText().equals(postTitle)).findFirst().get().click();
        driver.findElements(By.xpath("//a[@class = 'title']")).get(0).click();

        Thread.sleep(5000);
        driver.quit();

    }
}
