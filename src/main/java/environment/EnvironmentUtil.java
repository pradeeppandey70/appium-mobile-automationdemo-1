package environment;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class EnvironmentUtil {
	
	public static String getAndroidSdkPath() {

        String sdkPath = System.getenv("ANDROID_HOME");

        if (sdkPath == null || sdkPath.isBlank()) {
            sdkPath = System.getenv("ANDROID_SDK_ROOT");
        }

        if (sdkPath == null || sdkPath.isBlank()) {
            throw new RuntimeException(
                    "ANDROID_HOME or ANDROID_SDK_ROOT is not set.");
        }

        return sdkPath;
    }
	
	 public static String getEmulatorPath() {

	        String emulatorPath = getAndroidSdkPath()
	                + File.separator
	                + "emulator"
	                + File.separator
	                + "emulator";

	        if (System.getProperty("os.name").toLowerCase().contains("win")) {
	            emulatorPath += ".exe";
	        }

	        return emulatorPath;
	    }
	 
	 public static String getAdbPath() {

	        Path adbPath = Paths.get(
	                getAndroidSdkPath(),
	                "platform-tools",
	                "adb.exe");

	        if (!Files.exists(adbPath)) {
	            throw new RuntimeException(
	                    "adb.exe not found at: " + adbPath);
	        }

	        return adbPath.toString();
	    }

}
