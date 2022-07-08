package com.saucedemo;

import base.base.CommonAPI;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPages;


public class BasicComponentTest extends CommonAPI {


    @Test
    public void checkUserLandOnTheRightWebsite() {
        String title = getPageTitle();
        System.out.println(title);
        Assert.assertEquals("Swag Labs", title);
    }

    @Test
         public void checkPresenceOfLoginPageComponents () {
        LoginPages loginPages = new LoginPages(driver);
        loginPages.enterUserName("standard_user");
        loginPages.enterPassword("secret_sauce");
        loginPages.clickOnLoginBtn();
         Assert.assertTrue(loginPages.checkLoginBtnPresence());

     }
}





















