package Pages;

import Enums.NotebooksPage_NopCommerceEnums;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class NotebooksPage {
    WebDriver driver;
    WebDriverWait wait;
    List<WebElement> allNotebooksProductsHeading;
    List<WebElement> allNotebooksProductsPrice;

    By sortByDropdown = By.xpath("//select[@name='products-orderby']");
    String sortByDropdownOptions = "//select[@name='products-orderby']//option[contains(text(),'%s')]";
    By displayDropdown = By.xpath("//select[@name='products-pagesize']");
    By displayDropdownOptions = By.xpath("//option[contains(@value,'9')]");
    By notebooksProductsHeading = By.xpath("//div[@class='item-grid']//div[@class='item-box']//div[@class='details']//h2");
    By notebooksProductsPrice = By.xpath("//div[@class='item-grid']//div[@class='item-box']//div[@class='details']//span");
    String addToCartButton = "(//div[@class='details']//h2//a[contains(text(),'%s')]//following::div[@class='buttons']//button)[1]";
    By addToCartConfirmationMessage = By.xpath("//div[contains(@class,'bar-notification')]//p");
    By shoppingCartLink = By.xpath("//a[@class='ico-cart']");

    public NotebooksPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void sortByDropdownOptionSelect() {
        driver.findElement(sortByDropdown).click();
        driver.findElement(By.xpath(String.format(sortByDropdownOptions, NotebooksPage_NopCommerceEnums.SortByDropdownOption_Name_PriceLowToHigh.getResourcesName()))).click();
    }

    public void displayDropdownOptionSelect() {
        driver.findElement(displayDropdown).click();
        wait.until(ExpectedConditions.elementToBeClickable(displayDropdownOptions));
        driver.findElement(displayDropdownOptions);
    }

    public void fetchNameAndPriceOfProducts() {
        allNotebooksProductsHeading = driver.findElements(notebooksProductsHeading);
        allNotebooksProductsPrice = driver.findElements(notebooksProductsPrice);
        int number = allNotebooksProductsHeading.size();

        for (int i = 0; i < number; i++) {
            String productHeading = allNotebooksProductsHeading.get(i).getText();
            String productPrice = allNotebooksProductsPrice.get(i).getText();
            System.out.println(productHeading);
            System.out.println(productPrice);
        }
    }

    public void addProductToCart() {
        try {
            driver.findElement(By.xpath(String.format(addToCartButton, NotebooksPage_NopCommerceEnums.AddToCartButton_Name_HPUltraBook.getResourcesName()))).click();
        } catch (org.openqa.selenium.StaleElementReferenceException ex) {
            driver.findElement(By.xpath(String.format(addToCartButton, NotebooksPage_NopCommerceEnums.AddToCartButton_Name_HPUltraBook.getResourcesName()))).click();
        }
    }

    public void verifyNotificationOfAddToCart() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(addToCartConfirmationMessage));
        String isNotificationDisplayed = driver.findElement(addToCartConfirmationMessage).getText();
        Assert.assertEquals("The product has been added to your shopping cart", isNotificationDisplayed);
    }

    public void navigateToShoppingCart() {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(addToCartConfirmationMessage));
        driver.findElement(shoppingCartLink).click();
    }
}