package org.example.elementsLocation;

public class CartElements {

    public static String price = "//div[@class='list-item__price-new'][1]";
    public static String name = "//span[@class=\"good-info__good-name\"]";
    public static String totalPrice = "//span[@data-link=\"{formatMoneyAnim (totalPriceWithCouponPersDiscAndDeliveryPrice - (!postpay() && payByBalance < 0 ? payByBalance : 0)) + totalPaymentFeeAmount converter='basketPriceWithCurrencyV2'}\"]";
    public static String orderButton = "//button[@type=\"button\"][@data-link='{on submitOrder ~tag}']";
}
