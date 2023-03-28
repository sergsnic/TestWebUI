package com.sergsnic.lesson6;

import io.qameta.allure.Step;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class WeatherPageHomeWork extends BasePageHomeWork{

    public WeatherPageHomeWork(WebDriver driver) {
        super(driver);
    }
    private final String iconMailLocator = "//a[.='Mail.ru  ']";
    @FindBy(xpath = iconMailLocator)
    private WebElement iconMail;

    @Step("Проверка нахождения пункта меню mail на странице")
    public WeatherPageHomeWork iconMailCheck(){
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(iconMailLocator)));
        Assertions.assertEquals(iconMail.isDisplayed(), true);
        return new WeatherPageHomeWork(driver);
    }
    private final String frameOpenLocation = "//iframe[@class='yandex-frame']";
    @FindBy(xpath = frameOpenLocation)
    private WebElement frameOpen;

    @Step("Промежуточная операция открытия Frame для доступа к блоку результатов поиска")
    public WeatherPageHomeWork frameOpen(){
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath(frameOpenLocation)));
        driver.switchTo().frame(frameOpen);
        return new WeatherPageHomeWork(driver);
    }

    @FindBy(xpath = "//a//b[.='gismeteo.ru']")
    private WebElement gismeteoWebsait;
@Step("Проверка нахождения сайта gismeteo на странице")
    public void gismeteoWebsaitCheck(){
    Assertions.assertEquals(gismeteoWebsait.isDisplayed(),true);
    }


}
