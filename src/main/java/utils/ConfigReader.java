package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	private static Properties prop = new Properties();
	
	static {
		try {
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "src/main/resources/config.properties");
			prop.get(fis);
		}catch(IOException e) {
			System.out.println("file not found");
		}

	}
	
	public static String get(String key) {
		return prop.getProperty(key);
		
	}

}
