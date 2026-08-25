package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pageObjects.HomePage;
import pageObjects.LoginPage;

public class LoginPageFunctionality extends BaseTest{
	
	@Test
    public void verifyApplicationLaunchTest() throws InterruptedException {
		LoginPage lp = new LoginPage();
		HomePage home = lp.login("1000piper@yopmail.com", "Aa@12345");
		Thread.sleep(5000);
		String actual = home.dashboardText();
		System.out.println(actual);
        Assert.assertEquals(actual, "Dashboard");
        System.out.println("Application launched successfully.");

    }


}
