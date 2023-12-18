package org.example.elementsLocation;

public class FiltersElements {

    public static String householdAppliances = "//a[contains(text(), 'Бытовая техника')]";
    public static String homeAppliances = "//span[contains(text(), 'Техника для дома')]";
    public static String vacuumSteamCleaners = "//span[contains(text(), 'Пылесосы и пароочистители')]";
    public static String vacuumCleaners = "//a[@href=\"https://www.wildberries.ru/catalog/elektronika/tehnika-dlya-doma/pylesosy-i-parootchistiteli\"]";
    public static String  electronics = "//a[contains(text(), 'Электроника')]";
    public static String laptopsAndPc = "//span[contains(text(), 'Ноутбуки и компьютеры')]";
    public static String laptops = "//a[@class=\"menu-burger__link j-menu-drop-link\"][@href= 'https://www.wildberries.ru/catalog/elektronika/noutbuki-pereferiya/noutbuki-ultrabuki']";
}
