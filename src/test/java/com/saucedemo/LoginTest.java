package com.saucedemo;

import base.base.CommonAPI;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPages;

public class LoginTest extends CommonAPI {



    @Test
    public void LoginWithValidCredentials (){
        LoginPages loginPages = new LoginPages(driver);
        HomePage homePage= new HomePage(driver);
        loginPages.enterUserName("standard_user");
        loginPages.enterPassword("secret_sauce");
        loginPages.clickOnLoginBtn();
        Assert.assertEquals("PRODUCTS",homePage.getHeaderText());



}



  @Test
    public void LoginWithInvalidUsername (){

        LoginPages loginPages = new LoginPages(driver);

        loginPages.enterUserName("");
        loginPages.enterPassword("secret_sauce");;
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
        Assert.assertEquals("Epic sadface: Username is required",loginPages.errorMessage());


    }


        }
