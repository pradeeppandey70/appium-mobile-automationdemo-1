package driver.factory;

import driver.strategy.AndroidDriverStrategy;
import driver.strategy.IOSDriverStrategy;
import driver.strategy.MobileDriverStrategy;
import io.appium.java_client.AppiumDriver;
import utils.ConfigReader;

public final class DriverFactory {
	public static AppiumDriver initialiseDriver() {
		String platform = ConfigReader.get("platformName");
		
		MobileDriverStrategy strategy;
		
		switch(platform) {
		case "Android":
			strategy = new AndroidDriverStrategy();
			break;
		case "ios":
			strategy = new IOSDriverStrategy();
			break;
		default:
			throw new IllegalArgumentException(
                    "Unsupported Platform");
		}
		
		return strategy.createDriver();
	}

}
