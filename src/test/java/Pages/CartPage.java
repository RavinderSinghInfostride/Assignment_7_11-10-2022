package Pages;

import Enums.CartPage_NopCommerceEnums;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
    WebDriver driver;

    By productAddedVerify = By.xpath("//span[@class='sku-number']");
    By termsAndConditionCheckbox = By.xpath("//input[@name='termsofservice']");
    By checkoutButton = By.xpath("//button[@name='checkout']");
    By registerButton = By.xpath("//button[contains(@class,'register-button')]");
    By productQuantityInputBox = By.xpath("//input[@class='qty-input']");
    String commonButtons = "//div[@class='common-buttons']//button[@name='%s']";

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void verifyProductAddedToCart() {
        String productAddedSkuNumber = driver.findElement(productAddedVerify).getText();
        Assert.assertEquals("HP_SPX_UB", productAddedSkuNumber);
    }

    public void checkoutButtonClick() {
        driver.findElement(termsAndConditionCheckbox).click();
        driver.findElement(checkoutButton).click();
    }

    public void clickOnRegisterButton() {
        driver.findElement(registerButton).click();
    }

    public void increaseProductQuantity() {
        driver.findElement(productQuantityInputBox).clear();
        driver.findElement(productQuantityInputBox).sendKeys("4");
        driver.findElement(By.xpath(String.format(commonButtons, CartPage_NopCommerceEnums.CommonButtons_Name_UpdateCart.getResourcesName()))).click();
    }
}