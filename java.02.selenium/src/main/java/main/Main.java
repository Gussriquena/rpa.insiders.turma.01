package main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Main {
	
	public static void main(String[] args) {
		
		// chromedriver - chrome
		// geckodriver - firefox
		// iedriver - IE
		
		// Indicando para o selenium o caminho do chromedriver
		System.setProperty("webdriver.chrome.driver", "resources\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://rpa-insiders-tools.vercel.app/exercicios/exercicio1");
		
		driver.findElement(By.id("name")).sendKeys("Gustavo de Oliveira Riquena");
		driver.findElement(By.id("email")).sendKeys("admin@rpainsiders.com.br");
		driver.findElement(By.id("address")).sendKeys("Avenida tal");
		driver.findElement(By.id("address2")).sendKeys("Brasil");
		driver.findElement(By.id("city")).sendKeys("São Paulo");
		driver.findElement(By.id("zipcode")).sendKeys("00006-222");
		
		driver.findElement(By.id("male")).click();
		driver.findElement(By.name("terms")).click();
		
		// Passando o elemento para uma variável
		// Transformando a variável do tipo webelement para select
		// utilizando o select
		WebElement elementSelect = driver.findElement(By.id("state"));
		Select selectState = new Select(elementSelect);
		selectState.selectByValue("SP");
	
		// Encurtando o código anterior
		new Select(driver.findElement(By.id("state"))).selectByValue("SP");
		
		System.out.println(driver.findElement(By.tagName("h2")).getText());
		System.out.println(driver.findElement(By.id("male")).getAttribute("type"));
		
		driver.findElement(By.tagName("button")).click();
		
		if(driver.findElement(By.tagName("table")).isDisplayed()) {
			System.out.println("CADASTRADO COM SUCESSO");
		}
		
		// driver.close();
		// driver.quit();
	}

}
