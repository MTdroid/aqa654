
import org.example.elementsLocation.*;
import org.example.steps.WbSteps;
import org.junit.jupiter.api.*;



import static org.example.steps.WbSteps.webDriver;


public class TestCases {

    @BeforeEach
    public void openWb() {

        WbSteps.beforeEach();
    }
    @AfterEach
    public void quitWebDriver() {

        webDriver.quit();
    }

    @DisplayName("Тест-кейс 1: Работа с поисковой строкой")
    @Test
    public void searchLine() {

        WbSteps.clickElementXpath(MainPageElements.searchLine);
        WbSteps.sendKeys(MainPageElements.searchLine, "Iphone 13");

        WbSteps.textEquals(SearchingResultsElements.title, "Iphone 13");
        WbSteps.textEquals(SearchingResultsElements.burgerFilter, "Iphone 13");
        WbSteps.textEquals(SearchingResultsElements.sortFilter, "По популярности");
        WbSteps.textEquals(SearchingResultsElements.brand, "Apple");

        WbSteps.clickElementXpath(MainPageElements.clearSearchLine);

        WbSteps.textEquals(MainPageElements.searchLine, "");
    }
    @DisplayName("Тест-кейс 2: Смена города")
    @Test
    public void changeTheCity() {

        WbSteps.clickElementXpath(MainPageElements.cityChange);
        WbSteps.clickElementXpath(CityChangeElements.searchLine);

        WbSteps.sendKeys(CityChangeElements.searchLine, "Санкт-Петербург");

        WbSteps.addressEquals(CityChangeElements.pickAddress,"Санкт-Петербург");
        String addressConfirm = WbSteps.searchByXpath(CityChangeElements.addressConfirm).getText();

        WbSteps.textEquals(CityChangeElements.pickAddress, addressConfirm);

        WbSteps.clickElementXpath(CityChangeElements.pick);

        WbSteps.textEquals(MainPageElements.cityChange, addressConfirm);
    }

    @DisplayName("Тест-кейс 3: Добавление товара в корзину")
    @Test
    public void addToCart() {

        WbSteps.clickElementXpath(MainPageElements.filters);
        WbSteps.hoverMouse(FiltersElements.householdAppliances);
        WbSteps.clickElementXpath(FiltersElements.homeAppliances);
        WbSteps.clickElementXpath(FiltersElements.vacuumSteamCleaners);
        WbSteps.clickElementXpath(FiltersElements.vacuumCleaners);

        WbSteps.textEquals(SearchingResultsElements.title, "Пылесосы и пароочистители");
        WbSteps.textEquals(SearchingResultsElements.pagePath, "Главная\n" +
                "Бытовая техника\n" +
                "Техника для дома\n" +
                "Пылесосы и пароочистители");

        WbSteps.hoverMouse(SearchingResultsElements.firstProduct);
        String price = WbSteps.searchByXpath(SearchingResultsElements.firstProductPrice).getText();

        WbSteps.clickElementXpath(SearchingResultsElements.firstProductAddToCart);

        WbSteps.textEquals(MainPageElements.cart, "1");

        WbSteps.clickElementXpath(MainPageElements.cart);
        String productName = WbSteps.searchByXpath(SearchingResultsElements.firstProductName).getText();

        WbSteps.textEquals(CartElements.name, productName);
        WbSteps.textEquals(CartElements.price, price);
        WbSteps.textEquals(CartElements.totalPrice, WbSteps.searchByXpath(CartElements.price).getText());
        WbSteps.isEnabled(CartElements.orderButton);
    }

    @DisplayName("Тест-кейс 4: Работа с фильтрами")
    @Test
    public void settingFilters() {

        WbSteps.clickElementXpath(MainPageElements.filters);
        WbSteps.hoverMouse(FiltersElements.electronics);
        WbSteps.clickElementXpath(FiltersElements.laptopsAndPc);
        WbSteps.clickElementXpath(FiltersElements.laptops);

        WbSteps.textEquals(SearchingResultsElements.title, "Ноутбуки и ультрабуки");

        WbSteps.clickElementXpath(SearchingResultsElements.dropDownFilterButton);
        WbSteps.clean(SearchingResultsElements.startPrice);
        WbSteps.sendKeys(SearchingResultsElements.startPrice, "100000");
        WbSteps.clean(SearchingResultsElements.endPrice);
        WbSteps.sendKeys(SearchingResultsElements.endPrice, "149000");
        WbSteps.clickElementXpath(SearchingResultsElements.upTo3Days);
        WbSteps.clickElementXpath(SearchingResultsElements.apple);
        WbSteps.clickElementXpath(SearchingResultsElements.size);
        WbSteps.clickElementXpath(SearchingResultsElements.showAll);

        WbSteps.textEquals(SearchingResultsElements.choiseList,
                "до 3 дней\n" +
                "Apple\n" +
                "от 100 000 до 149 000\n" +
                "13.3\"\n" +
                "Сбросить все");
        WbSteps.isEnabled(SearchingResultsElements.dropAll);

        String elements = String.valueOf(WbSteps.elementsOnPage());
        WbSteps.textEquals(SearchingResultsElements.totalItems, elements);
    }
}