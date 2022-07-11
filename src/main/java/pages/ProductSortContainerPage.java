package pages;

import base.base.CommonAPI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ProductSortContainerPage extends CommonAPI {
    public ProductSortContainerPage (WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".product_sort_container")
     private WebElement SortContainer;


    public void SortProductDropDown(String Select) {
        click(SortContainer);
        Select dropdown = new Select(SortContainer);
        dropdown.selectByVisibleText("Price (low to high)");
        System.out.println("Sort Container clicked and visible Product selected");

    }

    }