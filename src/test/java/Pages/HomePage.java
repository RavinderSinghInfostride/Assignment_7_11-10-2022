package Pages;

import Enums.HomePageNavMenuOption_NopCommerceEnums;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver;

    String navMenuOptions = "((//div[@class='header-menu']//ul[contains(@class,'top-menu')]//a[contains(text(),'%s')]))[1]";

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToComputersPage(HomePageNavMenuOption_NopCommerceEnums value) {
        driver.findElement(By.xpath(String.format(navMenuOptions, value.getResourcesName()))).click();
    }
}