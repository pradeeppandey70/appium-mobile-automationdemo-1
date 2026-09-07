package utility;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import driver.manager.DriverManager;


public class ScreenshotUtil {
	
	//private static String path;
	
	public static String capture(String testName) {
		File src = ((TakesScreenshot)DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);
		String timeStamp = new SimpleDateFormat("ddMMyyyy_HHmmss").format(new Date());
		String path = "./target/screenshots/failure_"+testName+"_"+timeStamp+".png";
		try {
			FileUtils.copyFile(src, new File(path));
		}catch(Exception e) {
			e.printStackTrace();
		}
		return path;
	}

}
