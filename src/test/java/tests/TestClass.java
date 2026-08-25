package tests;

import java.io.File;
import java.net.URL;
import java.nio.file.Files;
import java.time.Duration;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class TestClass {
	
	@Test
	public void testmain() throws Exception {

		// ----------------------------------------------------
		// 1. Appium capabilities
		// ----------------------------------------------------

		/*
		 * UiAutomator2Options options = new UiAutomator2Options();
		 * 
		 * options.setPlatformName("Android");
		 * options.setAutomationName("UiAutomator2");
		 * 
		 * // Your AVD options.setAvd("Pixel_10");
		 * 
		 * // Your application
		 * options.setApp("C:/Users/Computer/Downloads/app-release.apk");
		 * 
		 * // Keep app data between sessions if required options.setNoReset(true);
		 */
		// ----------------------------------------------------
		// 2. Camera image injection configuration
		// ----------------------------------------------------

		Map<String, Object> injectedImageProperties = new HashMap<>();

		injectedImageProperties.put("width", 184);
		injectedImageProperties.put("height", 184);

		options.setCapability("appium:injectedImageProperties", injectedImageProperties);

		// ----------------------------------------------------
		// 3. Start Appium driver
		// ----------------------------------------------------

		AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		try {

			// ------------------------------------------------
			// 4. Give emulator/app time to start
			// ------------------------------------------------

			Thread.sleep(3000);

			// ------------------------------------------------
			// 5. Open QR scanner
			// ------------------------------------------------

			WebElement scanButton = wait
					.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Scan QR")));

			scanButton.click();

			// ------------------------------------------------
			// 6. Handle camera permission
			// ------------------------------------------------

			handleCameraPermission(driver);

			Thread.sleep(2000);

			// ------------------------------------------------
			// 7. Inject QR image
			// ------------------------------------------------

			injectQrImage(driver, "C:\\Users\\Computer\\Pictures\\25.08.2026_12.48.57_REC.png");

			// ------------------------------------------------
			// 8. Wait for QR scanner to process image
			// ------------------------------------------------

			Thread.sleep(5000);

			// ------------------------------------------------
			// 9. Verify result
			// ------------------------------------------------

			WebElement result = wait
					.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.myapp:id/scan_result")));

			String scannedValue = result.getText();

			System.out.println("Scanned QR value: " + scannedValue);

			// Example assertion
			if (!scannedValue.equals("TEST-QR-12345")) {

				throw new AssertionError("Unexpected QR value: " + scannedValue);
			}

			System.out.println("QR SCAN TEST PASSED");

		} finally {

			//driver.quit();
		}
	}

	// ========================================================
	// Inject QR image into emulator camera
	// ========================================================

	private static void injectQrImage(AndroidDriver driver, String imagePath) throws Exception {

		File qrFile = new File(imagePath);

		if (!qrFile.exists()) {

			throw new IllegalArgumentException("QR image not found: " + imagePath);
		}

		byte[] imageBytes = Files.readAllBytes(qrFile.toPath());

		String base64Image = Base64.getEncoder().encodeToString(imageBytes);

		Map<String, Object> arguments = new HashMap<>();

		arguments.put("payload", base64Image);

		driver.executeScript("mobile: injectEmulatorCameraImage", arguments);

		System.out.println("QR image injected successfully.");
	}

	// ========================================================
	// Camera permission
	// ========================================================

	private static void handleCameraPermission(AndroidDriver driver) {

		try {

			WebElement allowButton = driver.findElement(
					AppiumBy.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button"));

			allowButton.click();

			System.out.println("Camera permission granted.");

		} catch (Exception e) {

			// Permission may already be granted
			System.out.println("Camera permission already granted.");
		}
	}

}
