package environment;

public class EnvironmentManager {
	
	public static void initialise() {
		EmulatorManager.startEmulator();
		AppiumManager.startServer();

	    //EmulatorManager.startEmulator();

	    

	}
	

}
