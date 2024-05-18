package edu.praktikum.sprint4.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderSuccess {

    private final WebDriver webDriver;


    public OrderSuccess(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public String orderMessage() {
        By successOrderMessage = By.className("Order_ModalHeader__3FDaJ");
        return webDriver.findElement(successOrderMessage).getText();
    }
}
