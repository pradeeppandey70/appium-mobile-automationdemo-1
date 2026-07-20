package environment;

public class EnvironmentManager {
	
	public static void initialise() {
		
		AppiumManager.startServer();

	    EmulatorManager.startEmulator();

	    

	}
	

}
