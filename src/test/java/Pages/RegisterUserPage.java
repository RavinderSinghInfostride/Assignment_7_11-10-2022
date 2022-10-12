package Pages;

import Enums.RegisterUserInputs_NopCommerceEnums;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterUserPage {
    WebDriver driver;

    String genderRadioButton = "//div[@class='gender']//span[@class='%s']//input[@name='Gender']";
    String personalDetailsFormInputs = "//div//strong[contains(text(),'Your Personal Details')]//following::div[@class='form-fields']//div[@class='inputs']//input[@name='%s']";

    int randomNumber = (int) (Math.random() * (99 - 11 + 1) + 11);

    public RegisterUserPage(WebDriver driver)
    {
        this.driver = driver;
    }

    public void registerUser()
    {
        driver.findElement(By.xpath(String.format(genderRadioButton, RegisterUserInputs_NopCommerceEnums.RegisterUserInput_Name_Gender.getResourcesName()))).click();
        driver.findElement(By.xpath(String.format(personalDetailsFormInputs,"FirstName"))).sendKeys("ravinder");
        driver.findElement(By.xpath(String.format(personalDetailsFormInputs,"LastName"))).sendKeys("singh");
        String email = "ravindersingh"+randomNumber+"@mail.com";
        driver.findElement(By.xpath(String.format(personalDetailsFormInputs,"Email"))).sendKeys(email);
    }
}