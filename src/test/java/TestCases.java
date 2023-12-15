
import org.example.elementsLocation.TestCase1Xpath;
import org.example.elementsLocation.TestCase2Xpath;
import org.example.elementsLocation.TestCase3Xpath;
import org.example.elementsLocation.TestCase4Xpath;
import org.example.steps.WbSteps;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.example.steps.WbSteps.webDriver;


public class TestCases {

    @BeforeEach
    public void openWb() throws InterruptedException {
        WbSteps.beforeEach();
    }

    @DisplayName("Тест-кейс 1: Работа с поисковой строкой")
    @Test
    public void searchLine() throws InterruptedException {

        WbSteps.clickElementXpath(TestCase1Xpath.searchLine);
        WbSteps.sendKeys(TestCase1Xpath.searchLine, "Iphone 13");

        String itemName = WbSteps.searchByXpath(TestCase1Xpath.itemName).getText();
        WbSteps.textEquals(itemName, "Iphone 13");

        String burgerFilter = WbSteps.searchByXpath(TestCase1Xpath.burgerFilter).getText();
        WbSteps.textEquals(burgerFilter, "Iphone 13");

        String sortFilter = WbSteps.searchByXpath(TestCase1Xpath.sortFilter).getText();
        WbSteps.textEquals(sortFilter, "По популярности");

        String brand = WbSteps.searchByXpath(TestCase1Xpath.brand).getText();
        WbSteps.textEquals(brand, "Apple");

        WbSteps.clickElementXpath(TestCase1Xpath.clearSearchLine);
        String searchLine = WbSteps.searchByXpath(TestCase1Xpath.searchLine).getText();
        WbSteps.textEquals(searchLine, "");

        webDriver.quit();
    }
    @DisplayName("Тест-кейс 2: Смена города")
    @Test
    public void changeTheCity() throws InterruptedException {

        WbSteps.clickElementXpath(TestCase2Xpath.cityChange);
        WbSteps.clickElementXpath(TestCase2Xpath.searchLine);

        WbSteps.sendKeys(TestCase2Xpath.searchLine, "Санкт-Петербург");
        WbSteps.clickElementXpath(TestCase2Xpath.searchButton);
        WbSteps.clickElementXpath(TestCase2Xpath.pickAddress);

        String pickAddress = WbSteps.searchByXpath(TestCase2Xpath.pickAddress).getText();
        String addressConfirm = WbSteps.searchByXpath(TestCase2Xpath.addressConfirm).getText();
        WbSteps.textEquals(pickAddress, addressConfirm);

        WbSteps.clickElementXpath(TestCase2Xpath.pick);
        String mainPageAdress = WbSteps.searchByXpath(TestCase2Xpath.mainPageAddress).getText();
        WbSteps.textEquals(addressConfirm, mainPageAdress);

        webDriver.quit();
    }

    @DisplayName("Тест-кейс 3: Добавление товара в корзину")
    @Test
    public void addToCart() throws InterruptedException {

        WbSteps.clickElementXpath(TestCase3Xpath.filters);
        WbSteps.hoverMouse(TestCase3Xpath.householdAppliances);
        WbSteps.clickElementXpath(TestCase3Xpath.homeAppliances);
        WbSteps.clickElementXpath(TestCase3Xpath.vacuumSteamCleaners);
        WbSteps.searchByXpath(TestCase3Xpath.title);

        String title = WbSteps.searchByXpath(TestCase3Xpath.title).getText();
        String pagePath = WbSteps.searchByXpath(TestCase3Xpath.pagePath).getText();

        WbSteps.textEquals(title, "Пылесосы и пароочистители");
        WbSteps.textEquals(pagePath, "Главная\n" +
                "Бытовая техника\n" +
                "Техника для дома\n" +
                "Пылесосы и пароочистители");

        WbSteps.hoverMouse(TestCase3Xpath.firstVacuum);
        String price = WbSteps.searchByXpath(TestCase3Xpath.firstVacuumPrice).getText();
        String name = WbSteps.searchByXpath(TestCase3Xpath.firstVacuumName).getText();

        WbSteps.clickElementXpath(TestCase3Xpath.addToCart);
        String cartCounter = WbSteps.searchByXpath(TestCase3Xpath.cartCounter).getText();

        WbSteps.textEquals(cartCounter, "1");
        WbSteps.clickElementXpath(TestCase3Xpath.goToCart);
        Thread.sleep(500);
        String priceInCart = WbSteps.searchByXpath(TestCase3Xpath.priceInCart).getText().replaceAll("\n", " ");
        WbSteps.textEquals(price, priceInCart);

        String nameInCart = WbSteps.searchByXpath(TestCase3Xpath.nameInCart).getText();
        WbSteps.textEquals(name, nameInCart);

        String totalPrice = WbSteps.searchByXpath(TestCase3Xpath.totalPrice).getText();
        WbSteps.textEquals(priceInCart, totalPrice);
        WbSteps.isEnabled(TestCase3Xpath.orderButton);

        webDriver.quit();
    }

    @DisplayName("Тест-кейс 4: Работа с фильтрами")
    @Test
    public void settingFilters() throws InterruptedException {

        WbSteps.clickElementXpath(TestCase4Xpath.filters);

        WbSteps.hoverMouse(TestCase4Xpath.electronics);

        WbSteps.clickElementXpath(TestCase4Xpath.laptopsAndPc);

        WbSteps.clickElementXpath(TestCase4Xpath.laptops);

        String itemName = WbSteps.searchByXpath(TestCase1Xpath.itemName).getText();
        WbSteps.textEquals(itemName, "Ноутбуки и ультрабуки");
        WbSteps.clickElementXpath(TestCase4Xpath.dropDownFilterButton);

        WbSteps.clean(TestCase4Xpath.startPrice);
        WbSteps.sendKeys(TestCase4Xpath.startPrice, "100000");
        WbSteps.clean(TestCase4Xpath.endPrice);
        WbSteps.sendKeys(TestCase4Xpath.endPrice, "149000");

        WbSteps.clickElementXpath(TestCase4Xpath.upTo3Days);
        WbSteps.clickElementXpath(TestCase4Xpath.apple);
        WbSteps.clickElementXpath(TestCase4Xpath.size);
        WbSteps.clickElementXpath(TestCase4Xpath.showAll);

        String days = WbSteps.searchByXpath(TestCase4Xpath.upTo3Days).getText();
        String brand = WbSteps.searchByXpath(TestCase4Xpath.apple).getText();
        String price = WbSteps.searchByXpath(TestCase4Xpath.fullPrice).getText();
        String size = WbSteps.searchByXpath(TestCase4Xpath.size).getText();

        WbSteps.textEquals("до 3 дней", days);
        WbSteps.textEquals("Apple", brand);
        WbSteps.textEquals("от 100 000 до 149 000", price);
        WbSteps.textEquals("13.3\"", size);
        WbSteps.isEnabled(TestCase4Xpath.dropAll);

        String elements = String.valueOf(WbSteps.elementsOnPage());
        String exceptedElements = WbSteps.searchByXpath(TestCase4Xpath.totalItems).getText();
        WbSteps.textEquals(exceptedElements, elements);

        webDriver.quit();
    }

}