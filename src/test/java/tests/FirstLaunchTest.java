package tests;

import org.testng.annotations.Test;

import base.BaseTest;
import pageObjects.LoginPage;

public class FirstLaunchTest extends BaseTest{
	
	@Test
    public void verifyApplicationLaunchTest() {
		LoginPage lp = new LoginPage();
		lp.enterEmail("pradeeptest1@yopmail.com");
		lp.enterPassword("Aa@123456");
		lp.clickSignin();
        //Assert.assertNotNull(DriverManager.getDriver());

        System.out.println("Application launched successfully.");

    }


}
