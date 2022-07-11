package com.saucedemo;

import base.base.CommonAPI;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPages;

public class HomePageTest extends CommonAPI {



    @Test(priority = 1)
    public void PresenceOfHomePageComponents() {
        LoginPages loginPage = new LoginPages(driver);
        loginPage.enterUserName("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickOnLoginBtn();
        HomePage homepage = new HomePage(driver);
        Assert.assertEquals("PRODUCTS", homepage.getHomepageTitle());

    }

    @Test
    public void clickOnTheMenuBtn() throws InterruptedException {
        LoginPages loginPage = new LoginPages(driver);
        loginPage.enterUserName("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickOnLoginBtn();
        HomePage homepage = new HomePage(driver);
        homepage.ClickMenuBtn();


    }

    @Test
    public void CheckMenuBtnSideBar() throws InterruptedException {
        LoginPages loginPage = new LoginPages(driver);
        loginPage.enterUserName("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickOnLoginBtn();
        HomePage homepage = new HomePage(driver);
        homepage.ClickMenuBtn();
        Thread.sleep(2000);
        Assert.assertEquals("ALL ITEMS", homepage.checkMenuSidebar());

    }

    @Test
    public void CheckHomePageComponentPresence() throws InterruptedException {
        LoginPages loginPage = new LoginPages(driver);
        loginPage.enterUserName("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickOnLoginBtn();
        Thread.sleep(3000);
        HomePage homepage = new HomePage(driver);
        Assert.assertTrue(homepage.VerifyCartBadgeIconPresence());
        Assert.assertTrue(homepage.VerifyItemBikeLightPresence());
        Assert.assertTrue(homepage.VerifyItemBackpackPresence());
        Assert.assertTrue(homepage.VerifySortContainerPresence());
        Assert.assertTrue(homepage.VerifyRedTestTShirtPresence());


    }

    @Test
    public void CheckFooterCopyScriptAndPresence() throws InterruptedException {
        LoginPages loginPage = new LoginPages(driver);
        loginPage.enterUserName("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickOnLoginBtn();
        Thread.sleep(3000);
        HomePage homepage = new HomePage(driver);
        Assert.assertEquals("© 2022 Sauce Labs. All Rights Reserved. Terms of Service | Privacy Policy",
                homepage.VerifyFooterCopyPresenceAndAScript());

    }
}




































