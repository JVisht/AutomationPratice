package pages;

import base.base.CommonAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddItemToCartPage extends CommonAPI {

    public AddItemToCartPage (WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    @FindBy(css = "a[class=shopping_cart_link]")
    private WebElement CartBadge;

    @FindBy(css = "div[class='header_secondary_container']")
    private WebElement YourCartPage;

    @FindBy(css = "div[class='cart_desc_label']")
    private WebElement QtyAndDescription;

    @FindBy(css = "button[class='btn btn_action btn_medium checkout_button']")
    private WebElement CheckoutBtn;

    @FindBy(css = "#continue-shopping")
    private WebElement ContinueShoppingBtn;
    @FindBy( css = "div[class='header_secondary_container']")
    private WebElement CheckoutPage;

    @FindBy(css=".title")
    private WebElement HomePageTitle;



    public String VerifyCartPageTitle() {
       String VerifyCartPageTitle = getElementText(YourCartPage);
        System.out.println("Cart page Verified--->"+VerifyCartPageTitle);
        return  VerifyCartPageTitle;
    }

    public boolean VerifyPresenceQtyAndDescription(){
    boolean VerifyPresenceQtyAndDescription = isPresent(QtyAndDescription);
        System.out.println("Quantity and Description is Present--->"+VerifyPresenceQtyAndDescription );
        return isPresent(QtyAndDescription);

    }
    public boolean VerifyPresenceCheckoutBtn() {
       boolean VerifyPresenceCheckoutBtn = isPresent(CheckoutBtn);
        System.out.println("Checkout Btn Verified--->"+VerifyPresenceCheckoutBtn);
        return isPresent(CheckoutBtn);

    }
    public boolean VerifyPresenceContinueShopping() {
        boolean VerifyPresenceContinueShopping = isPresent(ContinueShoppingBtn);
        System.out.println("Continue shopping Btn Verified--->"+VerifyPresenceContinueShopping);
        return isPresent(ContinueShoppingBtn);


    }
    public void ClickOnCartBadge(){
        click(CartBadge);
        System.out.println("cart icon Clicked successfully");
    }
    public String ClickOnCheckoutBtn() {
        click(CheckoutBtn);
        String ClickOnCheckoutBtn = getElementText(CheckoutPage);
        System.out.println("Check out Btn Clicked Successfully--->"+ClickOnCheckoutBtn);
        return ClickOnCheckoutBtn;
    }

     public String ClickOnContinueShoppingBtn(){
       click(ContinueShoppingBtn);
        String ClickOnContinueShoppingBtn = getElementText(HomePageTitle);
        System.out.println("Continue shopping Btn Clicked Successfully--->"+ClickOnContinueShoppingBtn);
        return ClickOnContinueShoppingBtn;
    }


    }


