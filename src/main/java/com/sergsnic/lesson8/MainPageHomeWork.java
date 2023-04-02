package com.sergsnic.lesson8;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;
public class MainPageHomeWork {
    private SelenideElement frameInOpen = $(By.xpath( "//iframe[@class='search-arrow__frame']"));
    private SelenideElement seachMenu = $(By.xpath( "//input[@class = 'arrow__input mini-suggest__input']"));
    private SelenideElement seachSubString = $(By.xpath( "//div//li[@data-text='погода белгород на неделю']"));
//    private final String subStringLocator = "//div//li[@data-text='погода белгород на неделю']";
//    @Step("Промежуточная операция открытия Frame для доступа к строке поиска")
    public MainPageHomeWork openFrame(){
        Selenide.switchTo().frame(frameInOpen);
        return page(MainPageHomeWork.class);
    }
//    @Step("Поиск подстроки в строке поиска mail.ru")
    public MainPageHomeWork seachMenu(){ //"погода Белгород"
        seachMenu.sendKeys("погода Белгород");
        return page(MainPageHomeWork.class);
    }



    @Step("Клик подстроки в строке поиска mail.ru")
    public WeatherPageHomeWork seachSubString(){
        //webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(subStringLocator)));
        seachSubString.click();
        Selenide.switchTo().parentFrame();
        return page(WeatherPageHomeWork.class);
    }
}
