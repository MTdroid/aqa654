package org.example.elementsLocation;

public class SearchingResultsElements {

    public static String title ="//h1";
    public static String pagePath = "//ul[@class='breadcrumbs__list']";
    public static String burgerFilter = "//button[@class='dropdown-filter__btn dropdown-filter__btn--burger']";
    public static String sortFilter ="//button[@class='dropdown-filter__btn dropdown-filter__btn--sorter']";
    public static String brand = "//article[@data-nm-id][1]//span[@class='product-card__brand']";
    public static String firstProduct = "//article[@data-nm-id][1]//div[@class='product-card__wrapper']";
    public static String firstProductPrice = "//article[@data-nm-id][1]//ins[@class='price__lower-price'][1]";
    public static String firstProductName = "//span[@class='good-info__good-name']";
    public static String firstProductAddToCart = "//article[@data-nm-id][1]//a[contains(@data-link, '/lk/basket')]";
    public static String dropDownFilterButton = "//button[@class=\"dropdown-filter__btn dropdown-filter__btn--all\"]";
    public static String startPrice = "//input[@class=\"j-price\"][@name='startN']";
    public static String endPrice = "//input[@class=\"j-price\"][@name='endN']";
    public static String upTo3Days= "//span[contains(text(), 'до 3 дней')]";
    public static String apple= "//span[contains(text(), 'Apple')]";
    public static String size= "//span[contains(text(), '13.3')]";
    public static String showAll= "//button[@class='filters-desktop__btn-main btn-main']";
    public static String dropAll= "//button[contains(text(), 'Сбросить все')]";
    public static String checkSize= "//div[@class='product-card__wrapper']";
    public static String totalItems= "//span[@data-link='html{spaceFormatted:pagerModel.totalItems}']";
    public static String choiseList= "//ul[@class=\"your-choice__list\"]";
}
