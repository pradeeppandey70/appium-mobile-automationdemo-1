package driver.options;

import io.appium.java_client.ios.options.XCUITestOptions;
import utils.ConfigReader;

public final class IOSOptionManager {
	
	private IOSOptionManager() {
		
	}
	
	public static XCUITestOptions getOptions() {
		XCUITestOptions options = new XCUITestOptions();
		
		options.setPlatformName("ios");

        options.setAutomationName(
                ConfigReader.get("automationName"));

        options.setDeviceName(
                ConfigReader.get("deviceName"));

        options.setPlatformVersion(
                ConfigReader.get("platformVersion"));

        options.setBundleId(
                ConfigReader.get("bundleId"));

        

        return options;
	}

}
