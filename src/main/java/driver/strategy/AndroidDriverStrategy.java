package driver.strategy;

import java.net.MalformedURLException;
import java.net.URL;

import driver.options.AndroidOptionManager;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import utils.ConfigReader;

public class AndroidDriverStrategy implements MobileDriverStrategy {

	@Override
	public AppiumDriver createDriver() {
		
		try{
			return new AndroidDriver(new URL(ConfigReader.get("appiumServer")),AndroidOptionManager.getOptions());
		}catch(MalformedURLException e) {
			throw new RuntimeException();
		}
	}

}
