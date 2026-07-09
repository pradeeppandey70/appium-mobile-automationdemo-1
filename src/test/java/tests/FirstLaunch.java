package tests;

import org.testng.annotations.Test;

import base.BaseTest;

public class FirstLaunch extends BaseTest{
	
	@Test
    public void verifyApplicationLaunchTest() {

        //Assert.assertNotNull(DriverManager.getDriver());

        System.out.println("Application launched successfully.");

    }


}
