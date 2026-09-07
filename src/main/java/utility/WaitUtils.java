package utility;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import driver.manager.DriverManager;
import io.appium.java_client.AppiumDriver;

public class WaitUtils {
	protected AppiumDriver driver;
	protected WebDriverWait wait;
	
	public WaitUtils(AppiumDriver driver) {
		this.driver = DriverManager.getDriver();
		wait = new WebDriverWait(driver,Duration.ofSeconds(Long.valueOf(ConfigReader.get("explicitWaitTime"))));
	}
	
	public WebElement visible(By locator) {
		return  wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	public WebElement clickable(By locator) {
		return wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

}
