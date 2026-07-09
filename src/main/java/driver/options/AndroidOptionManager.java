package driver.options;

import io.appium.java_client.android.options.UiAutomator2Options;
import utils.ConfigReader;

public final class AndroidOptionManager {
	
	private AndroidOptionManager() {
		
	}
	
	public static UiAutomator2Options getOptions() {
		UiAutomator2Options options = new UiAutomator2Options();
		
		options.setPlatformName("Android");

        options.setAutomationName(
                ConfigReader.get("automationName"));

        options.setDeviceName(
                ConfigReader.get("deviceName"));

        options.setPlatformVersion(
                ConfigReader.get("platformVersion"));

        options.setApp(
                ConfigReader.get("app"));

		/*
		 * options.setAppActivity( ConfigReader.get("appActivity"));
		 */

        return options;
	}

}
