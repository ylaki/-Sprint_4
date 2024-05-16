package edu.praktikum.sprint4.pom;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class RentPage {

    private final WebDriver webDriver;

    private final By deliveryDateForm = By.xpath(".//input[@class='Input_Input__1iN_Z Input_Responsible__1jDKN' and @placeholder='* Когда привезти самокат']");
    private final By rentDurationList = By.xpath(".//div[@class='Dropdown-root']");
    private final By rentDuration = By.xpath(".//div[@class='Dropdown-option' and text()='трое суток']");
    private final By scooterBlack = By.id("black");
    private final By scooterGrey = By.id("grey");
    private final By courierComment = By.xpath(".//input[@class='Input_Input__1iN_Z Input_Responsible__1jDKN' and @placeholder='Комментарий для курьера']");
    private final By submitButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Заказать']");
    private final By yesButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Да']");

    public RentPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    //Выбираем дату доставки
    public void pickDeliveryDate(int daysToAdd){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String date = LocalDate.now().plusDays(daysToAdd).format(formatter);
        webDriver.findElement(deliveryDateForm).sendKeys(date);
    }

    //Выбираем срок аренды
    public void chooseRentDuration(String rentDurationDays){
        webDriver.findElement(rentDurationList).click();
        webDriver.findElement(By.xpath(String.format(".//div[@class='Dropdown-option' and text()='%s']",rentDurationDays)));
        webDriver.findElement(rentDuration).click();
    }

    //Выбираем цвет самоката
    public void pickScooterColor(String scooterColorChoice){
        WebElement scooter = webDriver.findElement(By.id(String.format("%s", scooterColorChoice)));
        scooter.click();
    }

    //Оставляем комментарий для курьера
    public void setCourierComment(String courierCommentText) {
        webDriver.findElement(courierComment).sendKeys(courierCommentText);
    }

    public void clickSubmitButton(){
        webDriver.findElement(submitButton).click();
    }

    public void clickYesButton(){
        webDriver.findElement(yesButton).click();
    }
}
