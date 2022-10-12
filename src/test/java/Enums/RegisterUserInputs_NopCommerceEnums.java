package Enums;

public enum RegisterUserInputs_NopCommerceEnums {
    RegisterUserInput_Name_Gender("male");

    private String name;

    private RegisterUserInputs_NopCommerceEnums(String name) {
        this.name = name;
    }

    public String getResourcesName() {
        return name;
    }
}
