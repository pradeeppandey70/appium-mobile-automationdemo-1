package environment;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class AppiumManager {
	
    private static AppiumDriverLocalService service;

    public static void startServer() {

        if (service != null && service.isRunning()) {
            return;
        }

        AppiumServiceBuilder builder = new AppiumServiceBuilder()
                .usingPort(4723);

        service = AppiumDriverLocalService.buildService(builder);
        service.start();

        System.out.println("Appium Server Started");
        
        System.out.println("Running: " + service.isRunning());
        System.out.println("URL: " + service.getUrl());
    }

    public static void stopServer() {

        if (service != null && service.isRunning()) {
            service.stop();
            System.out.println("Appium Server Stopped");
        }
    }

    public static String getServerUrl() {
        return service.getUrl().toString();
    }
}

