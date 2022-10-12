package Enums;

public enum CheckoutPage_NopCommerceEnums {
    AddressDetails_City_Name("BillingNewAddress.City"),
    AddressDetails_Address1_Name("BillingNewAddress.Address1"),
    AddressDetails_ZipCode_Name("BillingNewAddress.ZipPostalCode"),
    AddressDetails_PhoneNumber_Name("BillingNewAddress.PhoneNumber"),
    AddressDetails_CountryDropdown_Name("BillingNewAddress.CountryId"),
    BillingAddress_Title_Text("Billing address"),
    BillingAddress_ContinueButton_Class("new-address-next-step-button"),
    ShippingMethod_Title_Text("Shipping method"),
    ShippingMethod_ContinueButton_Class("shipping-method-next-step-button"),
    PaymentMethod_Title_Text("Payment method"),
    PaymentMethodContinueButton_Class("payment-method-next-step-button"),
    PaymentInformation_Title_Text("Payment information"),
    PaymentInformationContinueButton_Class("payment-info-next-step-button"),
    ConfirmOrder_Title_Text("Confirm order"),
    ConfirmOrderContinueButton_Class("confirm-order-next-step-button");
    private String name;

    private CheckoutPage_NopCommerceEnums(String name) {
        this.name = name;
    }

    public String getResourcesName() {
        return name;
    }
}