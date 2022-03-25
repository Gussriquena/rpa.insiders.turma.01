package curso.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Aula3_Alerts {
	
	public void alertsHandling() {
		System.setProperty("webdriver.chrome.driver", "resources\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(Aula2_Options.getChromeOptions());
		
		driver.get("https://rpa-insiders-tools.vercel.app/exercicios/exercicio6");
		
		String alertMessage = driver.switchTo().alert().getText();
		
		driver.switchTo().alert().accept();
		
		System.out.println(alertMessage);
	}
	
}
