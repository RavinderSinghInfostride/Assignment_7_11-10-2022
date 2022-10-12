package Enums;

public enum CartPage_NopCommerceEnums {
    CommonButtons_Name_UpdateCart("updatecart");
    private String name;

    private CartPage_NopCommerceEnums(String name) {
        this.name = name;
    }

    public String getResourcesName() {
        return name;
    }
}