package org.example.steps;


import org.example.elementsLocation.TestCase4Xpath;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class WbSteps {
    public static WebDriver webDriver;

    public static void beforeEach() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\M.TAG\\selenium\\chromedriver-win64\\chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.get("https://www.wildberries.ru/");
        Dimension d = new Dimension(1920, 1080);
        webDriver.manage().window().setSize(d);
        webDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }

    public static WebElement searchByXpath(String xpath) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
        Thread.sleep(200);
        return webDriver.findElement(By.xpath(xpath));
    }

    public static void clickElementXpath(String element) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(4));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(element)));
        searchByXpath(element).click();

    }

    public static void hoverMouse(String element) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(element)));

        Actions actions = new Actions(webDriver);
        actions.moveToElement(searchByXpath(element)).perform();
    }

    public static void textEquals(String element, String text) throws InterruptedException {
        Thread.sleep(1300);
        Assertions.assertTrue(element.contains(text));
    }

    public static void isEnabled(String element) throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(element)));
        Assertions.assertTrue(searchByXpath(element).isEnabled());
    }

    public static void sendKeys(String element, String text) throws InterruptedException {

        searchByXpath(element).sendKeys(text + Keys.ENTER);
        Thread.sleep(300);
    }

    public static void clean(String element) throws InterruptedException {

        searchByXpath(element).clear();
    }

    public static int elementsOnPage() throws InterruptedException {

        Thread.sleep(700);
        List<WebElement> listItems = webDriver.findElements(By.xpath(TestCase4Xpath.checkSize));
        return listItems.size();
    }
}