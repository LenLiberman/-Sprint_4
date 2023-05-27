package ru.praktikum.scooter.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.Assert.assertTrue;

public class AboutRentPage {
    WebDriver webDriver;
    public AboutRentPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
    //инпут для даты
    private By dateInput = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    //дропдаун срока аренды
    private By rentalPeriodDropdown = By.xpath(".//span[@class='Dropdown-arrow']");
    //инпут для комментария
    private By commentInput = By.xpath(".//div[@class='Input_InputContainer__3NykH']/input[@class='Input_Input__1iN_Z Input_Responsible__1jDKN']");
    //локатор кнопки Заказать
    private By orderButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    //локатор кнопки Да на попапе
    private By yesButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Да']");
    private By OrderСonfirmWindow = By.xpath(".//*[text()='Заказ оформлен']");


    //Выбор даты доставки
    public void writeDateOfDelivery(String date) {
        webDriver.findElement(dateInput).sendKeys(date);
    }

    //Выбор длительности доставки
    public void chooseRentalPeriod(String time) {
        webDriver.findElement(rentalPeriodDropdown).click();
        webDriver.findElement(By.xpath(String.format("//*[text()='%s']",time))).click();
    }

    //Выбор цвета
    public void chooseColor(String color) {
        webDriver.findElement(By.xpath(String.format(".//*[text()='%s']", color))).click();
    }

    //Написание комментария
    public void leaveComment(String comment) {
        webDriver.findElement(commentInput).sendKeys(comment);
    }

    //Клик на кнопку Заказать
    public void clickOnOrderButton() {
        webDriver.findElement(orderButton).click();
    }

    //Клик на кнопку Да
    public void clickOnYesButton() {
        webDriver.findElement(yesButton).click();
    }

    //Проверка успешности заказа
    public void checkOrderIsConfirm() {
        var isDisplayed=  webDriver.findElement(OrderСonfirmWindow).isDisplayed();
        assertTrue("Заказ не зарегистрирован",isDisplayed);
    }

    //Шаг: заполнение второй страницы заказа
    public void fillSecondOrderPage(String date, String time, String color, String comment) {
        writeDateOfDelivery(date);
        chooseRentalPeriod(time);
        chooseColor(color);
        leaveComment(comment);
        clickOnOrderButton();

    }
}
