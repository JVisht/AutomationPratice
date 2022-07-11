package pages;

import base.base.CommonAPI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InventoryBackpackPage extends CommonAPI {

    public InventoryBackpackPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[contains (text(),'Sauce Labs Backpack')]")
    private WebElement ItemBackpack;

    @FindBy(css = "button[class='btn btn_primary btn_small btn_inventory']")
    private WebElement BackpackAddToCart;

    @FindBy(css = "button[class='btn btn_secondary back btn_large inventory_details_back_button']")
    private WebElement BackToProductsTitle;

    @FindBy(css = "div[class='inventory_details_desc large_size']")
    private WebElement backPackDescription;

    @FindBy(css="div[class='inventory_details_price']")
    private WebElement CheckPricePresence;
    public void ClickOnBackPackItem() {
     click(ItemBackpack);
        System.out.println("BackPack Item Clicked Successfully");

    }

    public String getBackpackPageTitle(){
        String getBackpackPageTitle = getElementText(BackToProductsTitle);
        System.out.println("Back pack page title verified--->"+getBackpackPageTitle );
        return getBackpackPageTitle;
    }


    public void ClickOnAddToCartBtn() {
        click(BackpackAddToCart);
        System.out.println("Back pack Add to cart Clicked Successfully");
    }
    public boolean CheckPresenceOFBackPackDescription() {
        boolean CheckPresenceOFBackPackDescription = isPresent(backPackDescription);
        System.out.println("Back pack Item Description is Present--->" + CheckPresenceOFBackPackDescription);
        return isPresent(backPackDescription);
    }
        public boolean CheckPresenceOFBackPackPrice() {
            boolean CheckPresenceOFBackPackPrice = isPresent(CheckPricePresence);
            System.out.println("Back pack Item Price checked successfully--->"+ CheckPresenceOFBackPackPrice);
            return  isPresent(CheckPricePresence);

    }
}