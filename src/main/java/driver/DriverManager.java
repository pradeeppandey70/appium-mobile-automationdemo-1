package driver;

import org.openqa.selenium.WebDriver;

import io.appium.java_client.AppiumDriver;

public class DriverManager {
	private static final ThreadLocal<AppiumDriver> driver = new ThreadLocal<>();
	
	public static void setDriver(AppiumDriver appiumDriver) {
		driver.set(appiumDriver);
	}
	
	public static WebDriver getDriver() {
		return driver.get();
	}
	
	public static void unload() {
		driver.remove();
	}

}
