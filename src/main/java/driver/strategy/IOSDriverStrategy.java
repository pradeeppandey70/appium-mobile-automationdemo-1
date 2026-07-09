package driver.strategy;

import java.net.MalformedURLException;
import java.net.URL;

import driver.options.IOSOptionManager;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import utils.ConfigReader;

public class IOSDriverStrategy implements MobileDriverStrategy {

	@Override
	public AppiumDriver createDriver() {
		
		try{
			return new IOSDriver(new URL(ConfigReader.get("appiumServer")),IOSOptionManager.getOptions());
		}catch(MalformedURLException e) {
			throw new RuntimeException();
		}
	}

}
