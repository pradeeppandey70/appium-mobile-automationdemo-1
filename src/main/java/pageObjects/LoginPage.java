package pageObjects;
import org.openqa.selenium.By;

import base.BasePage;
import io.appium.java_client.AppiumBy;

public class LoginPage extends BasePage{
	
	By logoImage = AppiumBy.androidUIAutomator("new UiSelector().className(\"com.horcrux.svg.GroupView\").instance(2)");
	By headerSignin = AppiumBy.androidUIAutomator("new UiSelector().text(\"Sign In\").instance(0)");
	By labelemail = AppiumBy.androidUIAutomator("new UiSelector().text(\"EMAIL *\")");
	By emailField = AppiumBy.xpath("//android.widget.EditText[@text='Enter Your Email']");
	By labelpassword = AppiumBy.androidUIAutomator("new UiSelector().text(\"PASSWORD *\")");
	By passwordFieldEyeBtn = AppiumBy.androidUIAutomator("new UiSelector().className(\"com.horcrux.svg.PathView\").instance(8)");
	By passwordField = AppiumBy.xpath("//android.widget.EditText[@text='Enter Your Password']");
	By signin_btn = AppiumBy.accessibilityId("Sign In");
	By forgetPasswordLink = AppiumBy.androidUIAutomator("new UiSelector().text(\"Forgot your password?\")");
	By loginErrorMsg = AppiumBy.xpath("//android.widget.TextView[@text='Incorrect email or password']");
	
	
	public boolean logoDisplay() {
		return display(logoImage);
	}
	
	public String headertext() {
		return text(headerSignin);
	}
	
	public boolean headerdisplay() {
		return display(headerSignin);
	}
	
	public void enterEmail(String text) {
		type(text, emailField);
	}
	
	public void enterPassword(String text) {
		type(text, passwordField);
	}
	
	public void clickSignin() {
		click(signin_btn);
	}
	
	public HomePage login(String email, String password) {
		enterEmail(email);
		enterPassword(password);
		clickSignin();
		return new HomePage();
	}
	
	public boolean forgetPasswordDisplay() {
		return display(forgetPasswordLink);
	}
	
	public String getLoginError() {
		return text(loginErrorMsg);
	}
	
	public ForgetPassowordScreen clickforgetpassoword() {
		click(forgetPasswordLink);
		return new ForgetPassowordScreen();
	}
	
	

}


