package org.example.elementsLocation;

public class TestCase4Xpath {

    public static String filters = "//button[@class='nav-element__burger j-menu-burger-btn j-wba-header-item']";
    public static String  electronics = "//a[contains(text(), 'Электроника')]";
    public static String laptopsAndPc = "//span[contains(text(), 'Ноутбуки и компьютеры')]";
    public static String laptops = "//a[@class=\"menu-burger__link j-menu-drop-link\"][@href= 'https://www.wildberries.ru/catalog/elektronika/noutbuki-pereferiya/noutbuki-ultrabuki']";
    public static String dropDownFilterButton = "//button[@class=\"dropdown-filter__btn dropdown-filter__btn--all\"]";
    public static String startPrice = "//input[@class=\"j-price\"][@name='startN']";
    public static String endPrice = "//input[@class=\"j-price\"][@name='endN']";
    public static String upTo3Days= "//span[contains(text(), 'до 3 дней')]";
    public static String apple= "//span[contains(text(), 'Apple')]";
    public static String size= "//span[contains(text(), '13.3')]";
    public static String showAll= "//button[@class='filters-desktop__btn-main btn-main']";
    public static String fullPrice= "//span[contains(text(), 'от 100 000 до 149 000')]";
    public static String dropAll= "//button[contains(text(), 'Сбросить все')]";
    public static String checkSize= "//div[@class='product-card__wrapper']";
    public static String totalItems= "//span[@data-link='html{spaceFormatted:pagerModel.totalItems}']";
    /*public static String scrollToBottom = "//h2[@class='search-tags__header section-header']";*/
    public static String scrollToBottom = "//article[@data-nm-id][1]";
}
