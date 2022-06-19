package com.saucedemo;

import base.base.CommonAPI;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPages;


public class BasicComponentTest extends CommonAPI {
        //    @Test
       //  public void test1() {

    @Test
    public void checkUserLandOnTheRightWebsite() {
        String title = getPageTitle();
        System.out.println(title);
        Assert.assertEquals("Swag Labs", title);
    }

    @Test
         public void checkPresenceOfLoginPageComponents () {
        LoginPages loginPages = new LoginPages(driver);
         Assert.assertTrue(loginPages.checkUserNameFieldPresence());
         Assert.assertTrue(loginPages.checkPasswordFieldPresence());
         Assert.assertTrue(loginPages.checkLoginBtnPresence());

     }
}





















