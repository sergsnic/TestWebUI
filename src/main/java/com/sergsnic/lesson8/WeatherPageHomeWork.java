package com.sergsnic.lesson8;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class WeatherPageHomeWork {

//    private final String iconMailLocator = "//a[.='Mail.ru  ']";
    private SelenideElement iconMail = $(By.xpath("//a[.='Mail.ru  ']"));
//    private final String frameOpenLocation = "//iframe[@class='yandex-frame']";
    private SelenideElement frameOpen = $(By.xpath("//iframe[@class='yandex-frame']"));
    private SelenideElement gismeteoWebsait = $(By.xpath("//a//b[.='gismeteo.ru']"));
//    @Step("Проверка нахождения пункта меню mail на странице")
    public WeatherPageHomeWork iconMailCheck(){
        //webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(iconMailLocator)));
        iconMail.shouldBe(Condition.visible);
        return page(WeatherPageHomeWork.class);
    }
//    @Step("Промежуточная операция открытия Frame для доступа к блоку результатов поиска")
    public WeatherPageHomeWork frameOpen(){
        Selenide.switchTo().frame(frameOpen);
        return page(WeatherPageHomeWork.class);
    }
//@Step("Проверка нахождения сайта gismeteo на странице")
    public void gismeteoWebsaitCheck(){
        gismeteoWebsait.shouldBe(Condition.visible);
    }
}
