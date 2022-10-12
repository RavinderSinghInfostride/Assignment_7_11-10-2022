package StepDefinition;

import Pages.BaseClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.io.IOException;

public class UserAddsItemToCartAndCheckoutTheItem extends BaseClass {
    @Given("user is navigated to the website")
    public void user_is_navigated_to_the_website() throws IOException {
        setup();
    }

    @And("user navigates to the computer section")
    public void user_navigates_to_the_computer_section() {
        pageFactory.getHomePage().navigateToComputersPage();
    }

    @And("user clicks on the notebooks")
    public void user_clicks_on_the_notebooks() {
        pageFactory.getComputersPage().navigateToNotebooksPage();
    }

    @And("user sort the items by price \\(low to high) and display filter to maximum {int}")
    public void user_sort_the_items_by_price_low_to_high_and_display_filter_to_maximum(Integer int1) {
        pageFactory.getNotebooksPage().sortByDropdownOptionSelect();
        pageFactory.getNotebooksPage().displayDropdownOptionSelect();
    }

    @And("results listed with name and price")
    public void results_listed_with_name_and_price() {
        pageFactory.getNotebooksPage().fetchNameAndPriceOfProducts();
    }

    @And("user adds a product to cart")
    public void user_adds_a_product_to_cart() {
        pageFactory.getNotebooksPage().addProductToCart();
    }

    @Then("the confirmation for the product added is displayed")
    public void the_confirmation_for_the_product_added_is_displayed() {
        pageFactory.getNotebooksPage().verifyNotificationOfAddToCart();
    }

    @And("user navigates to the shopping cart page")
    public void user_navigates_to_the_shopping_cart_page() {
        pageFactory.getNotebooksPage().navigateToShoppingCart();
    }

    @Then("the product added is verified")
    public void the_product_added_is_verified() {
        pageFactory.getCartPage().verifyProductAddedToCart();
    }

    @And("user clicks on the checkout button")
    public void user_clicks_on_the_checkout_button() {
        pageFactory.getCartPage().checkoutButtonClick();
    }

    @And("user clicks on the register button")
    public void user_clicks_on_the_register_button() {
        pageFactory.getCartPage().clickOnRegisterButton();
    }

    @And("user registers himself")
    public void user_registers_himself() throws IOException {
        pageFactory.getRegisterUserPage().registerUser();
    }

    @And("user increases the quantity of product by {int}")
    public void user_increases_the_quantity_of_product_by(Integer int1) {
        pageFactory.getCartPage().increaseProductQuantity();
        pageFactory.getCartPage().checkoutButtonClick();
    }

    @When("user fill the checkout details and checkout")
    public void user_fill_the_checkout_details_and_checkout() throws IOException {
        pageFactory.getCheckoutPage().fillShippingDetails();
        pageFactory.getCheckoutPage().checkoutSteps();
    }

    @Then("the order is placed and verified")
    public void the_order_is_placed_and_verified() {
        pageFactory.getCheckoutPage().orderVerify();
    }

    @And("browser closes")
    public void browser_closes() {
        closeBrowser();
    }
}