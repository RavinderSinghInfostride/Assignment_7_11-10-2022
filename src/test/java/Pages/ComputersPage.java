package Pages;

import Enums.ComputersPageItems_NopCommerceEnums;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ComputersPage {
    WebDriver driver;

    String computersBoxItems = "//div[@class='item-grid']//div[@class='sub-category-item']//a[contains(text(),'%s')]";

    public ComputersPage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToNotebooksPage() {
        driver.findElement(By.xpath(String.format(computersBoxItems, ComputersPageItems_NopCommerceEnums.ComputersPageItems_Name_Notebooks.getResourcesName()))).click();
    }
}