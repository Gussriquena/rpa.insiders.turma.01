package curso.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import curso.commons.Commons;

public class Aula4_Waiters {

	private static int TIMEOUT_IN_SECONDS = 60;

	public void waitElements() {

		WebDriver driver = new ChromeDriver(Aula2_Options.getChromeOptions());
		driver.get("https://rpa-insiders-tools.vercel.app/exercicios/exercicio5");

		System.out.println("Aguardando...");
		// WebDriverWait wait = new WebDriverWait(driver, 40);
		// wait.until(ExpectedConditions.presenceOfElementLocated(By.id("name")));

		waitUntilElementIsPresentTimeout(driver, By.id("name"));

		driver.findElement(By.id("name")).sendKeys("Gustavo Riquena");
		System.out.println("Tela carregou");

		// waitUntilElementIsEnabled(driver, By.id("registerEmployerBtn"));
		// System.out.println("Botão habilitado");
	}

	public boolean waitUntilElementIsPresentTimeout(WebDriver driver, By elementBy) {
		for (int tries = 0; tries <= TIMEOUT_IN_SECONDS; tries++) {
			try {
				WebElement elementToWait = null;

				Commons.sleep(1000);
				while (elementToWait == null) {
					elementToWait = driver.findElement(elementBy);
					return true;
				}
			} catch (Exception e) {
				// Silence
			}
		}

		return false;
	}

	public void waitUntilElementIsPresent(WebDriver driver, By elementBy) {
		WebElement elementToWait = null;

		while (elementToWait == null) {
			try {
				elementToWait = driver.findElement(elementBy);
			} catch (Exception e) {
				// Silence
			}
		}
	}

	public void waitUntilElementIsEnabled(WebDriver driver, By elementBy) {
		boolean isElementEnabled = false;

		while (!isElementEnabled) {
			try {
				isElementEnabled = driver.findElement(elementBy).isEnabled();
			} catch (Exception e) {
				// Silence
			}
		}
	}
}
