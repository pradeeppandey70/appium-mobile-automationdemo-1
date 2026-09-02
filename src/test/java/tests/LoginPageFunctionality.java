package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pageObjects.HomePage;
import pageObjects.LoginPage;

public class LoginPageFunctionality extends BaseTest{
	
	@Test
    public void loginWithValidCredential() throws InterruptedException {
		LoginPage lp = new LoginPage();
		HomePage home = lp.login("1000piper@yopmail.com", "Aa@12345");
		Thread.sleep(5000);
		boolean actual = home.dashboardBTNPresence();
		System.out.println(actual);
        Assert.assertEquals(actual, true);
        System.out.println("Application launched successfully.");

    }
	
	@Test
	public void loginWithwrongPassword() throws InterruptedException {
		LoginPage lp = new LoginPage();
		HomePage home = lp.login("1000piper@yopmail.com", "Aa@123456");
		Thread.sleep(5000);
		boolean actual = home.dashboardBTNPresence();
		System.out.println(actual);
        Assert.assertEquals(actual, false);
        //System.out.println("Application launched successfully.");

    }


}
