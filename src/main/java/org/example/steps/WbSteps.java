package org.example.steps;


import org.example.elementsLocation.MainPageElements;
import org.example.elementsLocation.SearchingResultsElements;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;


public class WbSteps {

    public static WebDriver webDriver;

    public static void beforeEach()  {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\M.TAG\\selenium\\chromedriver-win64\\chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.get("https://www.wildberries.ru/");
        Dimension d = new Dimension(1920, 1080);
        webDriver.manage().window().setSize(d);
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(11));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(MainPageElements.chatButton)));
    }

    public static WebElement searchByXpath(String xpath){

        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));

        return webDriver.findElement(By.xpath(xpath));
    }

    public static void clickElementXpath(String element) {

        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(element)));
        wait.ignoring(StaleElementReferenceException.class);
        searchByXpath(element).click();
    }

    public static void addressEquals(String element,String text) {

        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.textMatches(By.xpath(element), Pattern.compile(text)));
        searchByXpath(element).click();
    }

    public static void hoverMouse(String element) {

        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(element)));
        Actions actions = new Actions(webDriver);
        actions.moveToElement(searchByXpath(element)).perform();
    }

    public static void textEquals(String element, String text) {

        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(6));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(element)));
        Assertions.assertTrue(searchByXpath(element).getText().contains(text));
    }

    public static void isEnabled(String element) {

        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(element)));
        Assertions.assertTrue(searchByXpath(element).isEnabled());
    }

    public static void sendKeys(String element, String text) {

        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(3));
        wait.withTimeout(Duration.ofSeconds(3));
        searchByXpath(element).sendKeys(text + Keys.ENTER);
    }

    public static void clean(String element){
        searchByXpath(element).clear();
    }

    public static int elementsOnPage() {

        List<WebElement> listItems = webDriver.findElements(By.xpath(SearchingResultsElements.checkSize));

        return listItems.size();
    }
}