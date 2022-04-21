package curso.seletores;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import curso.selenium.Aula2_Options;

public class Aula1_xpath {
	
	public void inputDynamicData() {
		WebDriver driver = new ChromeDriver(Aula2_Options.getChromeOptions());
		driver.get("https://rpa-insiders-tools.vercel.app/exercicios/exercicio2");
		
		driver.findElement(By.xpath("//label[contains(text(), 'Email')]/following-sibling::input")).sendKeys("gustavo@gmail.com");
		driver.findElement(By.xpath("//label[contains(text(), 'Nome')]/following::input[1]")).sendKeys("Gustavo");
		driver.findElement(By.xpath("//label[contains(text(), 'Endereço')]/following-sibling::input")).sendKeys("Av. tal");
		
		driver.findElement(By.xpath("//label[contains(text(), 'País')]/following-sibling::input")).sendKeys("Brasil");
		driver.findElement(By.xpath("//label[contains(text(), 'Cidade')]/following-sibling::input")).sendKeys("Barueri");
		driver.findElement(By.xpath("//label[contains(text(), 'CEP')]/following-sibling::input")).sendKeys("0000000");
		
		String gender = "Female";
		driver.findElement(By.xpath("//p[contains(text(), '"+gender+"')]/input")).click();
		
		new Select(driver.findElement(By.xpath("//label[contains(text(), 'Estado')]/following-sibling::select"))).selectByValue("SP");
		
		driver.findElement(By.xpath("//div[contains(text(), 'Termos')]/input")).click();
		//driver.findElement(By.xpath("//button[@id='registerEmployerBtn']")).click();
		
	}
}
