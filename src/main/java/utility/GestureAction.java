package utility;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.RemoteWebElement;

import com.google.common.collect.ImmutableMap;

import driver.manager.DriverManager;
import io.appium.java_client.AppiumDriver;

public class GestureAction {
	protected static AppiumDriver driver;
	protected static JavascriptExecutor js;
	public GestureAction(AppiumDriver driver) {
		this.driver = DriverManager.getDriver();
		js = (JavascriptExecutor)driver;
		
	}
	
	public void tap(By element) {
		js.executeScript("mobile: clickGesture", ImmutableMap.of("elementId",((RemoteWebElement)driver.findElement(element)).getId()));
		
	}

}
