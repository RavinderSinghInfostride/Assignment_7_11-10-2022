package Enums;

public enum ComputersPageItems_NopCommerceEnums {
    ComputersPageItems_Name_Notebooks("Notebooks");
    private String name;

    private ComputersPageItems_NopCommerceEnums(String name) {
        this.name = name;
    }

    public String getResourcesName() {
        return name;
    }
}