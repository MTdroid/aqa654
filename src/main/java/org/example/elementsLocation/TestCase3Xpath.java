package org.example.elementsLocation;


public class TestCase3Xpath {

    public static String filters = "//button[@class='nav-element__burger j-menu-burger-btn j-wba-header-item']";
    public static String householdAppliances = "//a[contains(text(), 'Бытовая техника')]";
    public static String homeAppliances = "//span[contains(text(), 'Техника для дома')]";
    public static String vacuumSteamCleaners = "//a[contains(text(), 'Пылесосы и пароочистители')]";
    public static String title = "//h1";
    public static String pagePath = "//ul[@class='breadcrumbs__list']";
    public static String firstVacuum = "//article[@data-nm-id][1]//div[@class='product-card__wrapper']";
    public static String firstVacuumPrice = "//article[@data-nm-id][1]//p[@class='product-card__price price'][1]";
    public static String firstVacuumName = "//article[@data-nm-id][1]//span[@class='product-card__name']";
    public static String addToCart = "//article[@data-nm-id][1]//a[contains(@data-link, '/lk/basket')]";
    public static String cartCounter = "//span[@class='navbar-pc__notify']";
    public static String goToCart = "//span[@class='navbar-pc__icon navbar-pc__icon--basket']";
    public static String priceInCart = "//div[@class='list-item__price'][1]";
    public static String nameInCart = "//span[@class=\"good-info__good-name\"]";
    public static String totalPrice = "//span[@data-link=\"{formatMoneyAnim (totalPriceWithCouponPersDiscAndDeliveryPrice - (!postpay() && payByBalance < 0 ? payByBalance : 0)) + totalPaymentFeeAmount converter='basketPriceWithCurrencyV2'}\"]";
    public static String orderButton = "//button[@type=\"button\"][@data-link='{on submitOrder ~tag}']";

}
