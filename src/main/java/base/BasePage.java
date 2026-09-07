package base;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

import driver.manager.DriverManager;
import io.appium.java_client.AppiumDriver;
import utility.WaitUtils;

public class BasePage {
	protected AppiumDriver driver;
	protected WaitUtils wait;
	public BasePage() {
		this.driver = DriverManager.getDriver();
		wait = new WaitUtils(driver);
		
	}
	
	public void type(String text, By locator) {
		wait.visible(locator).sendKeys(text);
		//driver.findElement(locator).sendKeys(text);;
	}
	
	public void click(By locator) {
		wait.clickable(locator).click();
		//driver.findElement(locator).click();
	}
	
	public boolean display(By locator) {
		 return wait.visible(locator).isDisplayed();
	}
	
	public String text(By locator) {
		 return wait.visible(locator).getText();
	}
	
	public String attribute(By locator, String attribute) {
		 return wait.visible(locator).getAttribute("text");
	}
	
	public boolean enabled(By locator) {
		return wait.visible(locator).isEnabled();
	}

}
