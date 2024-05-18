package edu.praktikum.sprint4.pom;

import org.openqa.selenium.*;
import java.time.Duration;


public class OrderPage {

    private final WebDriver webDriver;
    private final By nameInput = By.xpath(".//input[@class='Input_Input__1iN_Z Input_Responsible__1jDKN' and @placeholder='* Имя']");
    private final By lastNameInput = By.xpath(".//input[@class='Input_Input__1iN_Z Input_Responsible__1jDKN' and @placeholder='* Фамилия']");
    private final By addressInput = By.xpath(".//input[@class='Input_Input__1iN_Z Input_Responsible__1jDKN' and @placeholder='* Адрес: куда привезти заказ']");
    private final By metroInput = By.xpath(".//div[@class='select-search__value']");
    private final By metroSelect = By.xpath(".//button[@class='Order_SelectOption__82bhS select-search__option' and @value='5']");
    private final By phoneInput = By.xpath(".//input[@class='Input_Input__1iN_Z Input_Responsible__1jDKN' and @placeholder='* Телефон: на него позвонит курьер']");
    private final By nextButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    public OrderPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    //Отправляем данные в форму
    public void inputDataToForm(String name, String lastName, String address, String phoneNumber) {
        webDriver.findElement(nameInput).sendKeys(name);
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        webDriver.findElement(lastNameInput).sendKeys(lastName);
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        webDriver.findElement(addressInput).sendKeys(address);
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        webDriver.findElement(phoneInput).sendKeys(phoneNumber);
    }

    //    Выбираем метро из списка
    public void pickMetroFromList(String metroStationId) {
        webDriver.findElement(metroInput).click();
        webDriver.findElement(By.xpath(String.format(".//button[@class='Order_SelectOption__82bhS select-search__option' and @value='%s']", metroStationId))).click();
    }
        //Нажимаем кнопку далее
        public void clickNextButton() {
        webDriver.findElement(nextButton).click();
    }
}