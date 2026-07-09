package driver.strategy;

import io.appium.java_client.AppiumDriver;

public interface MobileDriverStrategy {
	
	AppiumDriver createDriver();

}
