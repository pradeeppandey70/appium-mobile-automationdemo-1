package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.ProfilePage;

public class LoginPageFunctionality extends BaseTest{
	
	@Test
    public void loginWithValidCredential() throws InterruptedException {
		LoginPage lp = new LoginPage();
		HomePage home = lp.login("1000piper@yopmail.com", "Aa@12345");
		Thread.sleep(5000);
		boolean actual = home.dashboardBTNPresence();
		System.out.println(actual);
        Assert.assertEquals(actual, true);
        ProfilePage profile =home.clickHomepageHeader();
        String email = profile.getemail();
        Assert.assertEquals(email, "1000piper@yopmail.com");
        System.out.println("Application launched successfully.");

    }
	
	@Test
	public void loginWithwrongPassword() throws InterruptedException {
		LoginPage lp = new LoginPage();
		lp.login("1000piper@yopmail.com", "Aa@123456");
		Thread.sleep(5000);
		String errorMsg = lp.getLoginError();
		System.out.println(errorMsg);
        Assert.assertEquals(errorMsg, "Incorrect email or password");
        //System.out.println("Application launched successfully.");

    }
	
	@Test
	public void loginWithunregisteredemail() throws InterruptedException {
		LoginPage lp = new LoginPage();
		lp.login("pradeeptest2@yopmail.com", "Aa@12345");
		Thread.sleep(5000);
		String errorMsg = lp.getLoginError();
		System.out.println(errorMsg);
        Assert.assertEquals(errorMsg, "Incorrect email or password");
        //System.out.println("Application launched successfully.");

    }
	
	@Test
	public void loginWithNoData() throws InterruptedException {
		LoginPage lp = new LoginPage();
		lp.enterEmail("");
		lp.enterPassword("");
		boolean buttonActive =lp.SigninButtonActive();
		Thread.sleep(5000);
        Assert.assertEquals(buttonActive, false);
        //System.out.println("Application launched successfully.");

    }
	
	@Test
	public void validateEmailField() throws InterruptedException {
		LoginPage lp = new LoginPage();
		lp.enterEmail("");
		//enter various combination like half email, without @, without domain etc
		// assert error message
		//make it datadriven

    }
	
	@Test
	public void testPasswordEyeButtonDefaultStatus() throws InterruptedException {
		LoginPage lp = new LoginPage();
		lp.enterPassword("Aa@12345");
		//Assert Password Status is Encrypted 
		// 

    }
	
	@Test
	public void testPasswordEyeButtonencryptDecrypt() throws InterruptedException {
		LoginPage lp = new LoginPage();
		lp.enterPassword("Aa@12345");
		//Assert Password Status is Encrypted 
		//click on eye button
		//Assert decrypted	// 

    }
	
	@Test
	public void testForgotPasswordVisibility() throws InterruptedException {
		LoginPage lp = new LoginPage();
		//check forgotpassword link visibility
		
    }
	
	@Test
	public void testforgotPWDRedirection() throws InterruptedException {
		LoginPage lp = new LoginPage();
		//click on forgot passowrd and assert the redirection 
		//assert current url

    }


}
