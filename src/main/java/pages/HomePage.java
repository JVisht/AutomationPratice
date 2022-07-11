package pages;

import base.base.CommonAPI;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends CommonAPI {

    public HomePage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(css=".title")
    private WebElement HomePageTitle;

    @FindBy(css = "#react-burger-menu-btn")
    private WebElement MenuBtn;

    @FindBy(xpath = "//a[contains (text (),'All Items')]")
    private WebElement sidebar;
    @FindBy(css = "a[class=shopping_cart_link]")
    private WebElement CartBadge;

    @FindBy(css = ".product_sort_container")
    private WebElement SortContainer;

    @FindBy(xpath = "//div[contains (text(),'Sauce Labs Backpack')]")
    private WebElement ItemBackpack;

    @FindBy(xpath = "//div[contains (text (),'Sauce Labs Bike Light')]")
    private WebElement ItemBikeLight;

    @FindBy(xpath = "//div[contains (text(),'Test.allTheThings() T-Shirt (Red)')]")
    private WebElement RedTestTShirt;

    @FindBy(css = ("div[class='footer_copy']"))
    private WebElement FooterCopy;

    public String getHomepageTitle() {
        String homePageTitle = getElementText(HomePageTitle);
       System.out.println("Home Page Title verified--->" +homePageTitle);
        return homePageTitle;
    }

    public void ClickMenuBtn() {
        click(MenuBtn);
        System.out.println("React Menu Btn clicked Success");
    }

    public String checkMenuSidebar() {
        String getMenuSideBar = getElementText(sidebar);
        System.out.println("Inventory menu Item Btn Success. " + getMenuSideBar );
        return getMenuSideBar;
    }

    public boolean VerifyCartBadgeIconPresence() {
       boolean VerifyCartBadgeIconPresence = isPresent(CartBadge);
        System.out.println("Shopping cart presence Verified--->"+VerifyCartBadgeIconPresence);
        return isPresent(CartBadge);
    }


     public boolean VerifySortContainerPresence() {
        boolean VerifySortContainerPresence = isPresent(SortContainer);
        System.out.println("Sort Container Verified---> "+VerifySortContainerPresence);
        return isPresent(SortContainer);
    }

    public boolean VerifyItemBackpackPresence() {
        boolean VerifyItemBackpackPresence = isPresent(ItemBackpack);
        System.out.println("Backpack Item  presence Verified---> "+VerifyItemBackpackPresence );
        return isPresent(ItemBackpack);
    }

    public boolean VerifyItemBikeLightPresence() {
        boolean VerifyItemBikeLightPresence = isPresent(ItemBikeLight);
       System.out.println("Inventory Bike Light presence verified---> " +VerifyItemBikeLightPresence);
        return isPresent(ItemBikeLight);
    }
    public boolean VerifyRedTestTShirtPresence() {
       boolean VerifyRedTestTShirtPresence = isPresent(RedTestTShirt);
        System.out.println("Red Test TShirt Picture Present---> " + VerifyRedTestTShirtPresence);
        return isPresent(RedTestTShirt);

    }

    public String VerifyFooterCopyPresenceAndAScript(){
        String VerifyFooterCopyPresenceAndAScript = getElementText(FooterCopy);
       System.out.println("Footer Copy  Script and Presence Verified--->"+VerifyFooterCopyPresenceAndAScript);
        return VerifyFooterCopyPresenceAndAScript;


    }

}





