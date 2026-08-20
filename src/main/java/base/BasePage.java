package base;

import org.openqa.selenium.By;

import driver.manager.DriverManager;
import io.appium.java_client.AppiumDriver;

public class BasePage {
	protected AppiumDriver driver;
	public BasePage() {
		this.driver = DriverManager.getDriver();
	}
	
	public void type(String text, By locator) {
		driver.findElement(locator).sendKeys(text);;
	}
	
	public void click(By locator) {
		driver.findElement(locator).click();
	}
	
	

}
