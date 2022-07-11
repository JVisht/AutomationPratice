package com.saucedemo;

import base.base.CommonAPI;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AddItemToCartPage;
import pages.HomePage;
import pages.LoginPages;

public class AddItemToCartTest  extends CommonAPI {


    @Test
    public void VerifyThePresenceComponentsOfCartPage() throws InterruptedException {
        LoginPages loginPages=new LoginPages(driver);
        loginPages.enterUserName("standard_user");
        loginPages.enterPassword("secret_sauce");
        loginPages.clickOnLoginBtn();
        Thread.sleep(3000);
        AddItemToCartPage cartPage = new AddItemToCartPage(driver);
        cartPage.ClickOnCartBadge();
        Assert.assertEquals("YOUR CART",cartPage.VerifyCartPageTitle());
        cartPage.VerifyPresenceCheckoutBtn();
        cartPage.VerifyPresenceContinueShopping();
        cartPage.VerifyPresenceQtyAndDescription();
    }
    @Test
    public void VerifyCheckoutBtn() throws InterruptedException {
        LoginPages loginPages = new LoginPages(driver);
        loginPages.enterUserName("standard_user");
        loginPages.enterPassword("secret_sauce");
        loginPages.clickOnLoginBtn();
        AddItemToCartPage cartPage = new AddItemToCartPage(driver);
        cartPage.ClickOnCartBadge();
        Thread.sleep(3000);
        Assert.assertEquals("CHECKOUT: YOUR INFORMATION", cartPage.ClickOnCheckoutBtn());
    }
    @Test
    public void VerifyContinueShoppingBtn() throws InterruptedException {
        LoginPages loginPages = new LoginPages(driver);
        loginPages.enterUserName("standard_user");
        loginPages.enterPassword("secret_sauce");
        loginPages.clickOnLoginBtn();
        AddItemToCartPage cartPage = new AddItemToCartPage(driver);
        cartPage.ClickOnCartBadge();
        Thread.sleep(3000);
        Assert.assertEquals("PRODUCTS", cartPage.ClickOnContinueShoppingBtn());
    }
}










