package Enums;

public enum NotebooksPage_NopCommerceEnums {
    SortByDropdownOption_Name_PriceLowToHigh("Price: Low to High"),
    AddToCartButton_Name_HPUltraBook("HP Spectre XT Pro UltraBook"),
    AddToCartHeaderLink_Class("ico-cart");
    private String name;

    private NotebooksPage_NopCommerceEnums(String name) {
        this.name = name;
    }

    public String getResourcesName() {
        return name;
    }
}