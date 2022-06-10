package rpa.people.gender;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import rpa.people.gender.browser.DriverFactory;
import rpa.people.gender.model.Person;

public class Main {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","resources\\chromedriver.exe");
		
		List<Person> personList = new ArrayList<>();
		
		personList.add(new Person("Gustavo", ""));
		personList.add(new Person("Fernanda", ""));
		personList.add(new Person("Diego", ""));
		personList.add(new Person("Raphael", ""));
		personList.add(new Person("Krislayne", ""));
		
		searchName(personList);
	}
	
	public static void searchName(List<Person> personList) {
		try (DriverFactory driverFactory = new DriverFactory()){
			WebDriver driver = driverFactory.getChromeDriver();
			driver.get("https://rpa-insiders-tools.vercel.app/utils/name-probability");
			
			personList.forEach(person -> {
				driver.findElement(By.id("search")).sendKeys(person.getName());
				driver.findElement(By.xpath("//button[@type='submit']")).click();
				
				WebDriverWait wait = new WebDriverWait(driver, 40);
				wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.xpath("(//h1)[2]")), person.getName()));

				String gender = driver.findElement(By.xpath("//form/following::p[1]")).getText().replace("Gênero: ", "");
				
				driver.findElement(By.id("search")).clear();
				personList.get(personList.indexOf(person)).setGender(gender);
			});
			
			System.out.println(personList);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
