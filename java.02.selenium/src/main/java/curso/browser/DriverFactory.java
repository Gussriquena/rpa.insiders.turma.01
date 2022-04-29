package curso.browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory implements AutoCloseable {
	
	private WebDriver driver;
	
	public DriverFactory() {
		driver = new ChromeDriver(BrowserConfiguration.getChromeOptions());
	}
	
	public WebDriver getChromeDriver() {
		return driver;
	}
	
	@Override
	public void close() throws Exception {
		driver.close();
		driver.quit();
	}

}
