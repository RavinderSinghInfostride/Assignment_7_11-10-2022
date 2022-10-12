package Enums;

public enum RegisterUserInputs_NopCommerceEnums {
    RegisterUserInput_Name_Gender("male"),
    RegisterUserPersonalDetailsInput_Name_FirstName("FirstName"),
    RegisterUserPersonalDetailsInput_Name_LastName("LastName"),
    RegisterUserPersonalDetailsInput_Name_Email("Email"),
    RegisterUserYourPasswordInput_Name_Password("Password"),
    RegisterUserYourPasswordInput_Name_ConfirmPassword("ConfirmPassword");
    private String name;

    private RegisterUserInputs_NopCommerceEnums(String name) {
        this.name = name;
    }

    public String getResourcesName() {
        return name;
    }
}