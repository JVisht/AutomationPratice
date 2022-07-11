package com.saucedemo;

import base.base.CommonAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.InventoryBackpackPage;
import pages.LoginPages;

public class InventoryBackpackTest extends CommonAPI {

    @Test(priority = 1)
    public void ClickOnBackpackItem() throws InterruptedException {
        LoginPages loginPage = new LoginPages(driver);
        InventoryBackpackPage BackpackPage = new InventoryBackpackPage(driver);
        loginPage.enterUserName("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickOnLoginBtn();
        Thread.sleep(2000);
        BackpackPage.ClickOnBackPackItem();
        Assert.assertEquals("BACK TO PRODUCTS", BackpackPage.getBackpackPageTitle());

    }

    @Test(priority = 2)
    public void VerifyBackpackItemDescriptionAndPrice() throws InterruptedException {
        LoginPages loginPage = new LoginPages(driver);
        InventoryBackpackPage BackpackPage = new InventoryBackpackPage(driver);
        loginPage.enterUserName("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickOnLoginBtn();
        Thread.sleep(2000);
        BackpackPage.ClickOnBackPackItem();
        Assert.assertTrue(BackpackPage.CheckPresenceOFBackPackDescription());
        Assert.assertTrue(BackpackPage.CheckPresenceOFBackPackPrice());


    }

    @Test(priority = 3)
    public void ClickOnBackpackAddToCart() throws InterruptedException {
        LoginPages loginPage = new LoginPages(driver);
        InventoryBackpackPage BackpackPage = new InventoryBackpackPage(driver);
        loginPage.enterUserName("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickOnLoginBtn();
        Thread.sleep(2000);
        BackpackPage.ClickOnBackPackItem();
        BackpackPage.ClickOnAddToCartBtn();
        Actions action = new Actions(driver);

    }



}
