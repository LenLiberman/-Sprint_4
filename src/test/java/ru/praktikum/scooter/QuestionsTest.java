package ru.praktikum.scooter;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.praktikum.scooter.pageobject.MainPage;

import java.util.concurrent.TimeUnit;

import static ru.praktikum.scooter.config.AppConfig.APP_URL;

public class QuestionsTest {
    WebDriver webDriver;
    MainPage mainPage;

    @Before
    public void init() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
    }

    @Test
    public void checkAnswersOfQuestions() {
        mainPage = new MainPage(webDriver);
        webDriver.get(APP_URL);

        mainPage.hideCookieWindow();

        mainPage.scrollToSectionOfQuestions();

        mainPage.clickOnQuestion(0);
        String zeroAnswerText = mainPage.getTextOfAnswer(0);
        Assert.assertEquals("Сутки — 400 рублей. Оплата курьеру — наличными или картой.", zeroAnswerText);

        mainPage.clickOnQuestion(1);
        String firstAnswerText = mainPage.getTextOfAnswer(1);
        Assert.assertEquals("Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.", firstAnswerText);

        mainPage.clickOnQuestion(2);
        String secondAnswerText = mainPage.getTextOfAnswer(2);
        Assert.assertEquals("Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.", secondAnswerText);

        mainPage.clickOnQuestion(3);
        String thirdAnswerText = mainPage.getTextOfAnswer(3);
        Assert.assertEquals("Только начиная с завтрашнего дня. Но скоро станем расторопнее.", thirdAnswerText);

        mainPage.clickOnQuestion(4);
        String fourthAnswerText = mainPage.getTextOfAnswer(4);
        Assert.assertEquals("Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.", fourthAnswerText);

        mainPage.clickOnQuestion(5);
        String fifthAnswerText = mainPage.getTextOfAnswer(5);
        Assert.assertEquals("Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.", fifthAnswerText);

        mainPage.clickOnQuestion(6);
        String sixthAnswerText = mainPage.getTextOfAnswer(6);
        Assert.assertEquals("Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.", sixthAnswerText);

        mainPage.clickOnQuestion(7);
        String seventhAnswerText = mainPage.getTextOfAnswer(7);
        Assert.assertEquals("Да, обязательно. Всем самокатов! И Москве, и Московской области.", seventhAnswerText);

    }

    @After
    public void teardown() {
        webDriver.quit();
    }
}
