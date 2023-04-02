package com.sergsnic.lesson8;

import com.codeborne.selenide.Configuration;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.codeborne.selenide.Selenide.open;

public class MyStepdefs {
    @Given("^Пользователь зашел на сайт$")
    public void userOpenSait() {
        Configuration.timeout = 10000;
        open("https://mail.ru/");
    }
    @When("^Выбираем подстроку Погода в Белгороде$")
    public void inputSeachString() {
        new MainPageHomeWork().openFrame();
//        new MainPageHomeWork().seachMenu();
    }

    @And("^Выбираем подстроку$")
    public void inputSubString() {
        new MainPageHomeWork().seachSubString();
    }

    @And("^Проверяем наличие пункта меню Mail$")
    public void checkMail() {
        new WeatherPageHomeWork().iconMailCheck();
    }

    @Then("^Проверяем наличие результата поиска Gismeteo$")
    public void checkGismeteo() {
        new WeatherPageHomeWork().frameOpen();
        new WeatherPageHomeWork().gismeteoWebsaitCheck();
    }
}
