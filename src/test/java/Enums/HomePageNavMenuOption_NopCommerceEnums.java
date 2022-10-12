package Enums;

public enum HomePageNavMenuOption_NopCommerceEnums {
    NavMenuOptions_Name_Computers("Computers");
    private String name;

    private HomePageNavMenuOption_NopCommerceEnums(String name) {
        this.name = name;
    }

    public String getResourcesName() {
        return name;
    }
}
