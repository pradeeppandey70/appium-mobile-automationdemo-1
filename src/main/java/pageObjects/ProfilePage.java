package pageObjects;

import org.openqa.selenium.By;

import base.BasePage;
import io.appium.java_client.AppiumBy;

public class ProfilePage extends BasePage{
	private By profileEmail = AppiumBy.xpath("//android.widget.TextView[contains(@text,'@')]");
	
	public String getemail() {
		return text(profileEmail);
	}
}


