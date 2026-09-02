package pageObjects;

import org.openqa.selenium.By;

import base.BasePage;
import io.appium.java_client.AppiumBy;

public class HomePage extends BasePage{
	
	private By dashboard = AppiumBy.accessibilityId("Dashboard");
	private By homePageHeader = AppiumBy.accessibilityId("Lalit ss, Member");
	
	public boolean dashboardBTNPresence() {
		return display(dashboard);
	}
	
	public ProfilePage clickHomepageHeader() {
		click(homePageHeader);
		return new ProfilePage();
	}

}
