package curso.commons;

public class Commons {

	public static void sleep(long milliseconds) {
		try {
			Thread.sleep(milliseconds);
		} catch (InterruptedException e) {
			// Silence
		}
	}
	
}
