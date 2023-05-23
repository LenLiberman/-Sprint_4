package ru.praktikum.scooter.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class MainPage {
    WebDriver webDriver;
    public MainPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    private By orderButton = By.xpath(".//div[@class='Header_Nav__AGCXC']/button[@class='Button_Button__ra12g']");
    private By orderButtonMiddle = By.xpath(".//div[@class='Home_FinishButton__1_cWm']/button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    private By cookieButton = By.xpath(".//div/button[@id='rcc-confirm-button']");
    private By sectionOfQuestions = By.xpath(".//div[@class='accordion']");
    private By zeroQuestion = By.xpath(".//div[@id='accordion__heading-0' and @class='accordion__button']");
    private By zeroAnswer = By.xpath(".//div[@id='accordion__panel-0']");
    private By firstQuestion = By.xpath(".//div[@id='accordion__heading-1' and @class='accordion__button']");
    private By firstAnswer = By.xpath(".//div[@id='accordion__panel-1']");
    private By secondQuestion = By.xpath(".//div[@id='accordion__heading-2' and @class='accordion__button']");
    private By secondAnswer = By.xpath(".//div[@id='accordion__panel-2']");
    private By thirdQuestion = By.xpath(".//div[@id='accordion__heading-3' and @class='accordion__button']");
    private By thirdAnswer = By.xpath(".//div[@id='accordion__panel-3']");
    private By fourthQuestion = By.xpath(".//div[@id='accordion__heading-4' and @class='accordion__button']");
    private By fourthAnswer = By.xpath(".//div[@id='accordion__panel-4']");
    private By fifthQuestion = By.xpath(".//div[@id='accordion__heading-5' and @class='accordion__button']");
    private By fifthAnswer = By.xpath(".//div[@id='accordion__panel-5']");
    private By sixthQuestion = By.xpath(".//div[@id='accordion__heading-6' and @class='accordion__button']");
    private By sixthAnswer = By.xpath(".//div[@id='accordion__panel-6']");
    private By seventhQuestion = By.xpath(".//div[@id='accordion__heading-7' and @class='accordion__button']");
    private By seventhAnswer = By.xpath(".//div[@id='accordion__panel-7']");

   public void hideCookieWindow() {
       WebDriverWait wait = new WebDriverWait(webDriver, 10);
       By cookieButtonLocator = By.xpath(".//div/button[@id='rcc-confirm-button']");
       WebElement cookieButton = wait.until(ExpectedConditions.visibilityOfElementLocated(cookieButtonLocator));
       ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView(true);", cookieButton);
       cookieButton.click();
   }

    public void scrollToSectionOfQuestions() {
        WebElement sectionElement = webDriver.findElement(sectionOfQuestions);
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView(true);", sectionElement);
    }

    public void clickOnQuestion(int questionIndex) {
        By questionLocator = By.xpath(".//div[@class='accordion__button' and @id='accordion__heading-" + questionIndex + "']");
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        WebElement questionElement = wait.until(ExpectedConditions.visibilityOfElementLocated(questionLocator));
        webDriver.findElement(questionLocator).click();
    }

    public String getTextOfAnswer(int answerIndex) {
        By answerLocator = By.xpath(".//div[@id='accordion__panel-" + answerIndex + "']");
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        WebElement answerElement = wait.until(ExpectedConditions.visibilityOfElementLocated(answerLocator));
        return webDriver.findElement(answerLocator).getText();
    }

    public void clickOnOrderButton() {
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        By orderButtonLocator = By.xpath(".//div[@class='Header_Nav__AGCXC']/button[@class='Button_Button__ra12g']");
        WebElement orderButton = wait.until(ExpectedConditions.visibilityOfElementLocated(orderButtonLocator));
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView(true);", orderButton);
        orderButton.click();
    }
    public void clickOnOrderButtonMiddle() {
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        By orderButtonMiddleLocator = By.xpath(".//div[@class='Home_FinishButton__1_cWm']/button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
        WebElement orderButtonMiddle = wait.until(ExpectedConditions.visibilityOfElementLocated(orderButtonMiddleLocator));
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView(true);", orderButtonMiddle);
        orderButtonMiddle.click();

    }




}
