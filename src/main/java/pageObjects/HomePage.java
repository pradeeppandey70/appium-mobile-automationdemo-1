package pageObjects;

import org.openqa.selenium.By;

import base.BasePage;
import io.appium.java_client.AppiumBy;

public class HomePage extends BasePage{
	
	By dashboard = AppiumBy.accessibilityId("Dashboard");
	
	public boolean dashboardBTNPresence() {
		return display(dashboard);
	}

}
