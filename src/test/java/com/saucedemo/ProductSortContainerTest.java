package com.saucedemo;

import base.base.CommonAPI;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.InventoryBackpackPage;
import pages.LoginPages;
import pages.ProductSortContainerPage;

public class ProductSortContainerTest extends CommonAPI {

    @Test
    public void selectFromSortContainer() throws InterruptedException {
        LoginPages loginPages = new LoginPages(driver);
        HomePage homePage =new HomePage(driver);
        loginPages.enterUserName("standard_user");
        loginPages.enterPassword("secret_sauce");
        loginPages.clickOnLoginBtn();
       Thread.sleep(3000);
       ProductSortContainerPage sortContainerPage = new ProductSortContainerPage(driver);
       sortContainerPage.SortProductDropDown("Price (low to high)");



    }
}