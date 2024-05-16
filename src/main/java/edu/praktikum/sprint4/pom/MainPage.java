package edu.praktikum.sprint4.pom;
import org.openqa.selenium.*;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {

    private static final String URL = "https://qa-scooter.praktikum-services.ru/";

    private final WebDriver webDriver;

    private final By topOrderButton = By.xpath(".//button[@class='Button_Button__ra12g']");
    private final By bottomOrderButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");


    public MainPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public MainPage open() {
        webDriver.get(URL);
        return this;
    }

    //Questions check methods
    public String openQuestion(int index) {
        By question = By.id(String.format("accordion__heading-%s", index));
        WebElement questionElement = webDriver.findElement(question);
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView();", questionElement);
        new WebDriverWait(webDriver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(question));
        questionElement.click();
        return questionElement.getText();
    }

    public String openAnswer(int index) {
        By answer = By.id(String.format("accordion__panel-%s", index));
        new WebDriverWait(webDriver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(answer));
        return webDriver.findElement(answer).getText();
    }


    //Нажимаем на нижнюю кнопку заказа
    public void clickOrderButton(String orderButton) {
        if (orderButton == "top") {
        WebElement OrderButton = webDriver.findElement(topOrderButton);
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView();", OrderButton);
        new WebDriverWait(webDriver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(topOrderButton));
        OrderButton.click();}
        else {
            WebElement OrderButton = webDriver.findElement(bottomOrderButton);
            ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView();", OrderButton);
            new WebDriverWait(webDriver, Duration.ofSeconds(5))
                    .until(ExpectedConditions.visibilityOfElementLocated(bottomOrderButton));
            OrderButton.click();}
        }
    }



