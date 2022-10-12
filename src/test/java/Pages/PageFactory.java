package Pages;

import org.openqa.selenium.WebDriver;

public class PageFactory {
    WebDriver driver;
    private HomePage homePage;
    private ComputersPage computersPage;
    private NotebooksPage notebooksPage;
    private CartPage cartPage;
    private RegisterUserPage registerUserPage;
    private CheckoutPage checkoutPage;

    public PageFactory(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage getHomePage() {
        if (homePage == null) {
            homePage = new HomePage(driver);
        }
        return homePage;
    }

    public ComputersPage getComputersPage() {
        if (computersPage == null) {
            computersPage = new ComputersPage(driver);
        }
        return computersPage;
    }

    public NotebooksPage getNotebooksPage() {
        if (notebooksPage == null) {
            notebooksPage = new NotebooksPage(driver);
        }
        return notebooksPage;
    }

    public CartPage getCartPage() {
        if (cartPage == null) {
            cartPage = new CartPage(driver);
        }
        return cartPage;
    }

    public RegisterUserPage getRegisterUserPage() {
        if (registerUserPage == null) {
            registerUserPage = new RegisterUserPage(driver);
        }
        return registerUserPage;
    }

    public CheckoutPage getCheckoutPage() {
        if (checkoutPage == null) {
            checkoutPage = new CheckoutPage(driver);
        }
        return checkoutPage;
    }
}