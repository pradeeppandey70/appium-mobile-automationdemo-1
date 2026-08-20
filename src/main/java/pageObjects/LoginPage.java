package pageObjects;
import org.openqa.selenium.By;

import base.BasePage;
import io.appium.java_client.AppiumBy;

public class LoginPage extends BasePage{
	
	By username = AppiumBy.xpath("//android.widget.EditText[@text='Enter Your Email']");
	By password = AppiumBy.xpath("//android.widget.EditText[@text='Enter Your Password']");
	By signin_btn = AppiumBy.accessibilityId("Sign In");
	public void enterEmail(String text) {
		type(text, username);
	}
	
	public void enterPassword(String text) {
		type(text, password);
	}
	
	public void clickSignin() {
		click(signin_btn);
	}
	
	

}


