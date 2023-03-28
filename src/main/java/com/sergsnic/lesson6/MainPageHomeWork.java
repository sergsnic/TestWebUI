package com.sergsnic.lesson6;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.awt.*;


public class MainPageHomeWork extends BasePageHomeWork{
    public MainPageHomeWork(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//iframe[@class='search-arrow__frame']")
    // закрыли переменную чтобы работать только с методом.
    private WebElement frameInOpen;

    @Step("Промежуточная операция открытия Frame для доступа к строке поиска")
    public MainPageHomeWork openFrame(){
        driver.switchTo().frame(frameInOpen);
        return new MainPageHomeWork(driver);
    }
    @FindBy(xpath = "//input[@class = 'arrow__input mini-suggest__input']")
    private WebElement seachMenu;

    @Step("Поиск подстроки в строке поиска mail.ru")
    public MainPageHomeWork seachMenu(){ //"погода Белгород"
        seachMenu.sendKeys("погода Белгород");
        return new MainPageHomeWork(driver);
    }
    private final String subStringLocator = "//div//li[@data-text='погода белгород на неделю']";
    @FindBy(xpath = subStringLocator)
    private WebElement seachSubString;

    @Step("Клик подстроки в строке поиска mail.ru")
    public WeatherPageHomeWork seachSubString(){
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(subStringLocator)));
        seachSubString.click();
        driver.switchTo().parentFrame();
        return new WeatherPageHomeWork(driver);
    }
}
