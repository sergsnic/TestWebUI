package com.sergsnic.lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumStart {
    public static void main(String[] args) throws InterruptedException {
//        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriverManager.chromedriver().setup();
        WebDriver driverChrom = new ChromeDriver();
        driverChrom.get("https://google.com");

//        System.setProperty("webdriver.firefox.driver", "src/main/resources/firefox.exe");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driverFirefox = new FirefoxDriver();
        driverFirefox.get("https://ya.ru");
        WebDriverManager.edgedriver().setup();
        WebDriver driverEdge = new EdgeDriver();
        driverEdge.get("https://mail.ru");
        Thread.sleep(5000);
        driverChrom.quit();
        driverFirefox.quit();
        driverEdge.quit();
    }
}
