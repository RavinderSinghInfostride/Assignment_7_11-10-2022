package Pages;

import Enums.CheckoutPage_NopCommerceEnums;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

public class CheckoutPage {
    WebDriver driver;
    WebDriverWait wait;

    String editAddressInputBox = "//div[@class='edit-address']//input[@name='%s']";
    String editAddressDropdown = "//div[@class='edit-address']//select[@name='%s']";
    String countryDropdownOption = "//select[@name='BillingNewAddress.CountryId']//option[@value='%s']";
    String continueButtons = "//div//h2[contains(text(),'%s')]//following::button[contains(@class,'%s')]";
    By confirmOrderVerify = By.xpath("//div[contains(@class,'order-completed')]//div[@class='title']//strong");
    By orderCompleteContinueButton = By.xpath("//button[contains(@class,'order-completed-continue-button')]");

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void fillShippingDetails() throws IOException {
        String path = System.getProperty("user.dir") + "/src/test/java/TestData/TestData.xlsx";
        FileInputStream testData = null;
        try {
            testData = new FileInputStream(path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        XSSFWorkbook wb = new XSSFWorkbook(testData);
        XSSFSheet sheet = wb.getSheet("Sheet1");
        String city = sheet.getRow(2).getCell(0).getStringCellValue();
        String address1 = sheet.getRow(2).getCell(1).getStringCellValue();
        String zipCode = sheet.getRow(2).getCell(2).getStringCellValue();
        String phoneNumber = sheet.getRow(2).getCell(3).getStringCellValue();
        driver.findElement(By.xpath(String.format(editAddressDropdown, CheckoutPage_NopCommerceEnums.AddressDetails_CountryDropdown_Name.getResourcesName()))).click();
        driver.findElement(By.xpath(String.format(countryDropdownOption, "133"))).click();
        driver.findElement(By.xpath(String.format(editAddressInputBox, CheckoutPage_NopCommerceEnums.AddressDetails_City_Name.getResourcesName()))).sendKeys(city);
        driver.findElement(By.xpath(String.format(editAddressInputBox, CheckoutPage_NopCommerceEnums.AddressDetails_Address1_Name.getResourcesName()))).sendKeys(address1);
        driver.findElement(By.xpath(String.format(editAddressInputBox, CheckoutPage_NopCommerceEnums.AddressDetails_ZipCode_Name.getResourcesName()))).sendKeys(zipCode);
        driver.findElement(By.xpath(String.format(editAddressInputBox, CheckoutPage_NopCommerceEnums.AddressDetails_PhoneNumber_Name.getResourcesName()))).sendKeys(phoneNumber);
    }

    public void checkoutSteps() {
        WebElement billingAddressContinueButton = driver.findElement(By.xpath(String.format(continueButtons, CheckoutPage_NopCommerceEnums.BillingAddress_Title_Text.getResourcesName(), CheckoutPage_NopCommerceEnums.BillingAddress_ContinueButton_Class.getResourcesName())));
        WebElement shippingMethodContinueButton = driver.findElement(By.xpath(String.format(continueButtons, CheckoutPage_NopCommerceEnums.ShippingMethod_Title_Text.getResourcesName(), CheckoutPage_NopCommerceEnums.ShippingMethod_ContinueButton_Class.getResourcesName())));
        WebElement paymentMethodContinueButton = driver.findElement(By.xpath(String.format(continueButtons, CheckoutPage_NopCommerceEnums.PaymentMethod_Title_Text.getResourcesName(), CheckoutPage_NopCommerceEnums.PaymentMethodContinueButton_Class.getResourcesName())));
        WebElement paymentInformationContinueButton = driver.findElement(By.xpath(String.format(continueButtons, CheckoutPage_NopCommerceEnums.PaymentInformation_Title_Text.getResourcesName(), CheckoutPage_NopCommerceEnums.PaymentInformationContinueButton_Class.getResourcesName())));
        WebElement confirmOrderContinueButton = driver.findElement(By.xpath(String.format(continueButtons, CheckoutPage_NopCommerceEnums.ConfirmOrder_Title_Text.getResourcesName(), CheckoutPage_NopCommerceEnums.ConfirmOrderContinueButton_Class.getResourcesName())));
        wait.until(ExpectedConditions.visibilityOf(billingAddressContinueButton));
        billingAddressContinueButton.click();
        wait.until(ExpectedConditions.visibilityOf(shippingMethodContinueButton));
        shippingMethodContinueButton.click();
        wait.until(ExpectedConditions.visibilityOf(paymentMethodContinueButton));
        paymentMethodContinueButton.click();
        wait.until(ExpectedConditions.visibilityOf(paymentInformationContinueButton));
        paymentInformationContinueButton.click();
        wait.until(ExpectedConditions.visibilityOf(confirmOrderContinueButton));
        confirmOrderContinueButton.click();
    }

    public void orderVerify() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(confirmOrderVerify));
        boolean isOrderConfirmed = driver.findElement(confirmOrderVerify).isDisplayed();
        Assert.assertTrue(isOrderConfirmed);
        driver.findElement(orderCompleteContinueButton).click();
    }
}