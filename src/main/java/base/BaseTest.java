package base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import driver.factory.DriverFactory;
import driver.manager.DriverManager;
import environment.EnvironmentManager;

public class BaseTest {
	
	@BeforeSuite
	public void beforeSuite() {
	    EnvironmentManager.initialise();
	}
	
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
