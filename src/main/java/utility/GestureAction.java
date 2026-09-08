package utility;

import driver.manager.DriverManager;
import io.appium.java_client.AppiumDriver;

public class GestureAction {
	protected static AppiumDriver driver;
	public GestureAction(AppiumDriver driver) {
		this.driver = DriverManager.getDriver();
	}
	
	public void swap() {
		
	}

}
