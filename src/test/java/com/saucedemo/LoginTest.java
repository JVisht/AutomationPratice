package com.saucedemo;

import base.base.CommonAPI;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPages;

public  class LoginTest extends CommonAPI {



    @Test
    public void checkUserLandsOnTheRightWebsite() {
        String title = getPageTitle();
        System.out.println(title);
        Assert.assertEquals("Swag Labs",title);

    }
    @Test
    public void checkPresenceOfLoginPageComponents() {
        LoginPages loginPages = new LoginPages(driver);
        Assert.assertTrue(loginPages.checkUserNameFieldPresence());
        Assert.assertTrue(loginPages.checkPasswordFieldPresence());
        Assert.assertTrue(loginPages.checkLoginBtnPresence());

    }
    @Test
    public void LoginWithValidCredentials (){
        LoginPages loginPages = new LoginPages(driver);
        HomePage homePage= new HomePage(driver);
        loginPages.enterUserName("standard_user");
        loginPages.enterPassword("secret_sauce");
        loginPages.clickOnLoginBtn();
        Assert.assertEquals("PRODUCTS",homePage.getHomepageTitle());

}


  @Test
    public void LoginWithInvalidUsername (){

        LoginPages loginPages = new LoginPages(driver);

        loginPages.enterUserName("");
        loginPages.enterPassword("secret_sauce");
        loginPages.clickOnLoginBtn();
        Assert.assertEquals("Epic sadface: Username is required",loginPages.errorMessage());

    }


    @Test
        public void LoginWithInvalidPassword (){
        LoginPages loginPages = new LoginPages(driver);
        HomePage homePage =new HomePage(driver);

        loginPages.enterUserName("standard_user");
        loginPages.enterPassword("");;
         loginPages.clickOnLoginBtn();
        Assert.assertEquals("Epic sadface: Password is required",loginPages.errorMessage());


    }
    @Test
    public void LoginWithLockedOutUser () {
        LoginPages loginPages = new LoginPages(driver);
        HomePage homePage = new HomePage(driver);

        loginPages.enterUserName("locked_out_user");
        loginPages.enterPassword("secret_sauce");
        ;
        loginPages.clickOnLoginBtn();
        Assert.assertEquals("Epic sadface: Sorry, this user has been locked out.", loginPages.LockedOutErrorMessage());

    }

    }
