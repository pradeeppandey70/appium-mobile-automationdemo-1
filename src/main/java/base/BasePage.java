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
	
	public boolean display(By locator) {
		 return driver.findElement(locator).isDisplayed();
	}
	
	public String text(By locator) {
		 return driver.findElement(locator).getText();
	}
	
	public String attribute(By locator, String attribute) {
		 return driver.findElement(locator).getAttribute("text");
	}
	
	public boolean enabled(By locator) {
		return driver.findElement(locator).isEnabled();
	}

}
