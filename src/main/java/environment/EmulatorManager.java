package environment;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class EmulatorManager {

	private static final String EMULATOR_NAME = "Pixel_10";// need to take this from config file
	private static final String emulatorPath = EnvironmentUtil.getEmulatorPath();

	public static void startEmulator() {
		System.out.println(emulatorPath);

		try {

			if (isEmulatorRunning()) {
				System.out.println("Emulator already running");
				return;
			}
			ProcessBuilder pb = new ProcessBuilder(emulatorPath, "-avd", EMULATOR_NAME);

			pb.inheritIO(); // <-- IMPORTANT

			Process process = pb.start();

			Thread.sleep(5000);

			System.out.println("PID : " + process.pid());
			System.out.println("Alive : " + process.isAlive());
			// System.out.println(process.isAlive());
			System.out.println("Starting Emulator...");

			waitForBoot();

		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

	private static boolean isEmulatorRunning() {
		System.out.println(EnvironmentUtil.getAdbPath());

		try {

			Process process = new ProcessBuilder(EnvironmentUtil.getAdbPath(), "devices").start();
			process.waitFor();
			System.out.println("ADB Exit Code: " + process.exitValue());

			BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

			String line;

			while ((line = reader.readLine()) != null) {

				System.out.println("ADB -> [" + line + "]");

				if (line.startsWith("emulator-") && line.contains("device")) {
					System.out.println("Emulator detected!");
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

			if (retries++ > 15) {
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
