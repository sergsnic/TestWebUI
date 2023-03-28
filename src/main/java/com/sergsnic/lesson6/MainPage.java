package com.sergsnic.lesson6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class MainPage extends BasePage{
    public MainPage(WebDriver driver) {
        super(driver);
        mainMenuBlock = new MainMenuBlock(driver);
    }
    @FindBy(xpath = "//a@[class ='login")
    // закрыли переменную чтобы работать только с методом.
    private WebElement signInButton;

    public MainMenuBlock mainMenuBlock;

    public LoginPage clickSignInBatton(){
        signInButton.click();
        return new LoginPage(driver);
    }
}
