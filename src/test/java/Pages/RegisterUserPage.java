package Pages;

import Enums.RegisterUserInputs_NopCommerceEnums;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class RegisterUserPage {
    WebDriver driver;

    String genderRadioButton = "//div[@class='gender']//span[@class='%s']//input[@name='Gender']";
    String personalDetailsFormInputs = "//div//strong[contains(text(),'Your Personal Details')]//following::div[@class='form-fields']//div[@class='inputs']//input[@name='%s']";
    String yourPasswordFormInputs = "//div//strong[contains(text(),'Your Password')]//following::div[@class='form-fields']//input[@name='%s']";
    By registerButton = By.xpath("//button[@name='register-button']");
    By registerContinueButton = By.xpath("//a[contains(@class,'register-continue-button')]");

    int randomNumber = (int) (Math.random() * (99 - 11 + 1) + 11);

    public RegisterUserPage(WebDriver driver) {
        this.driver = driver;
    }

    public void registerUser() throws IOException {
        FileReader reader = new FileReader("src/test/java/TestData/Data.properties");
        Properties data = new Properties();
        data.load(reader);
        String firstName = data.getProperty("firstName");
        String lastName = data.getProperty("lastName");
        String password = data.getProperty("password");
        driver.findElement(By.xpath(String.format(genderRadioButton, RegisterUserInputs_NopCommerceEnums.RegisterUserInput_Name_Gender.getResourcesName()))).click();
        driver.findElement(By.xpath(String.format(personalDetailsFormInputs, RegisterUserInputs_NopCommerceEnums.RegisterUserPersonalDetailsInput_Name_FirstName.getResourcesName()))).sendKeys(firstName);
        driver.findElement(By.xpath(String.format(personalDetailsFormInputs, RegisterUserInputs_NopCommerceEnums.RegisterUserPersonalDetailsInput_Name_LastName.getResourcesName()))).sendKeys(lastName);
        String email = firstName + lastName + randomNumber + "@mail.com";
        driver.findElement(By.xpath(String.format(personalDetailsFormInputs, RegisterUserInputs_NopCommerceEnums.RegisterUserPersonalDetailsInput_Name_Email.getResourcesName()))).sendKeys(email);
        driver.findElement(By.xpath(String.format(yourPasswordFormInputs, RegisterUserInputs_NopCommerceEnums.RegisterUserYourPasswordInput_Name_Password.getResourcesName()))).sendKeys(password);
        driver.findElement(By.xpath(String.format(yourPasswordFormInputs, RegisterUserInputs_NopCommerceEnums.RegisterUserYourPasswordInput_Name_ConfirmPassword.getResourcesName()))).sendKeys(password);
        driver.findElement(registerButton).click();
        driver.findElement(registerContinueButton).click();
    }
}