package environment;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class EmulatorManager {

	private static final String EMULATOR_NAME = "Pixel_9";// need to take this from config file
	private static final String emulatorPath = EnvironmentUtil.getEmulatorPath();

	public static void startEmulator() {
		System.out.println(emulatorPath);

		try {

			if (isEmulatorRunning()) {
				System.out.println("Emulator already running");
				return;
			}
			ProcessBuilder pb = new ProcessBuilder(emulatorPath, "-avd", EMULATOR_NAME);
			
			pb.inheritIO();   // <-- IMPORTANT

			Process process = pb.start();
			
			Thread.sleep(5000);

			System.out.println("PID : " + process.pid());
			System.out.println("Alive : " + process.isAlive());
			//System.out.println(process.isAlive());
			System.out.println("Starting Emulator...");

			waitForBoot();

		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

	private static boolean isEmulatorRunning() {

		try {

			Process process = new ProcessBuilder(EnvironmentUtil.getAdbPath(),"adb devices").start();
			

			BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

			String line;

			while ((line = reader.readLine()) != null) {
				
				System.out.println("ADB OUTPUT -> " + line);

				if (line.contains("emulator")) {
					return true;
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	private static void waitForBoot() throws Exception {

		System.out.println("Waiting for emulator to appear...");
		int retries = 0;

		while (!isEmulatorRunning()) {

		    if (retries++ > 10) {
		        throw new RuntimeException("Emulator failed to start.");
		    }

		    Thread.sleep(3000);
		}

		/*
		 * while (!isEmulatorRunning()) { Thread.sleep(3000); }
		 */
		System.out.println("Emulator detected.");

		while (true) {

			Process process = Runtime.getRuntime().exec("adb shell getprop sys.boot_completed");

			BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

			String output = reader.readLine();

			if ("1".equals(output)) {
				break;
			}

			Thread.sleep(5000);
		}

		System.out.println("Emulator Boot Completed");
	}

}
