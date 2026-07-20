package environment;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class EmulatorManager {
	
	private static final String EMULATOR_NAME = "Pixel_9";

    public static void startEmulator() {

        try {

            if (isEmulatorRunning()) {
                System.out.println("Emulator already running");
                return;
            }

            new ProcessBuilder(
                    "emulator",
                    "-avd",
                    EMULATOR_NAME
            ).start();

            System.out.println("Starting Emulator...");

            waitForBoot();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    private static boolean isEmulatorRunning() {

        try {

            Process process = Runtime.getRuntime().exec("adb devices");

            BufferedReader reader =
                    new BufferedReader(
                            new InputStreamReader(process.getInputStream()));

            String line;

            while ((line = reader.readLine()) != null) {

                if (line.contains("emulator")) {
                    return true;
                }

            }

        } catch (Exception ignored) {
        }

        return false;
    }

    private static void waitForBoot() throws Exception {
    	
    	System.out.println("Step 1");

        Runtime.getRuntime().exec("adb wait-for-device").waitFor();
        
        System.out.println("Step 2");

        while (true) {

            Process process = Runtime.getRuntime()
                    .exec("adb shell getprop sys.boot_completed");

            BufferedReader reader =
                    new BufferedReader(
                            new InputStreamReader(process.getInputStream()));

            String output = reader.readLine();

            if ("1".equals(output)) {
                break;
            }

            Thread.sleep(5000);
        }

        System.out.println("Emulator Boot Completed");
	    }

}
