package ru.praktikum.scooter;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.praktikum.scooter.pageobject.AboutRentPage;
import ru.praktikum.scooter.pageobject.ForWhomPage;
import ru.praktikum.scooter.pageobject.MainPage;

import java.util.concurrent.TimeUnit;

import static ru.praktikum.scooter.config.AppConfig.APP_URL;

public class OrderTest {
    WebDriver webDriver;
    MainPage mainPage;
    ForWhomPage forWhomPage;
    AboutRentPage aboutRentPage;

    @Before
    public void init() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void checkOrderOfScooter1() {
        mainPage = new MainPage(webDriver);


        webDriver.get(APP_URL);
        mainPage.hideCookieWindow();
        mainPage.clickOnOrderButton();

        forWhomPage = new ForWhomPage(webDriver);
        forWhomPage.fillFirstOrderPage("Елена","Либерман","Невский проспект 129", "Черкизовская", "+79089072784");

        aboutRentPage = new AboutRentPage(webDriver);
        aboutRentPage.fillSecondOrderPage("28.05.2023", "сутки", "серая безысходность", "Привет, как дела?");

        aboutRentPage.clickOnYesButton();
        aboutRentPage.checkOrderIsConfirm();
    }

    @Test
    public void checkOrderOfScooter() {
        mainPage = new MainPage(webDriver);


        webDriver.get(APP_URL);
        mainPage.hideCookieWindow();
        mainPage.clickOnOrderButton();

        forWhomPage = new ForWhomPage(webDriver);
        forWhomPage.fillFirstOrderPage("Мари","Петрова","Пискарёвский проспект 2", "Сокольники", "+79099999999");

        aboutRentPage = new AboutRentPage(webDriver);
        aboutRentPage.fillSecondOrderPage("26.05.2023", "двое суток", "чёрный жемчуг", "Звоните");

        aboutRentPage.clickOnYesButton();
        aboutRentPage.checkOrderIsConfirm();
    }


    @After
    public void closeBrowser() {
        webDriver.quit();
    }

}
