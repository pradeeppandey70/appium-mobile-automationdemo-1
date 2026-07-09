package base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import driver.factory.DriverFactory;
import driver.manager.DriverManager;

public class BaseTest {
	@BeforeMethod
	public void setup() {
		DriverManager.setDriver(DriverFactory.initialiseDriver());
	}
	
	@AfterMethod
	public void tearDown() {
		if(DriverManager.getDriver() != null) {
			DriverManager.getDriver().quit();
		}
		DriverManager.unload();
		
	}

}
