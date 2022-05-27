package rpa.people.generator;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import rpa.people.generator.browser.DriverFactory;
import rpa.people.generator.model.Person;

public class Main {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "resources\\chromedriver.exe");
		
		List<Person> personList = generateNames();
		
		if(!personList.isEmpty()) {
			createOutputExcel(personList);
		}
	}
	
	private static List<Person> generateNames() {
		List<Person> personList = new ArrayList<>();
		
		try (DriverFactory driverFactory = new DriverFactory()) {
			WebDriver driver = driverFactory.getChromeDriver();
			
			driver.get("https://pt.fakenamegenerator.com/");
			new Select(driver.findElement(By.id("gen"))).selectByVisibleText("Aleatório");
			new Select(driver.findElement(By.id("n"))).selectByVisibleText("Brasil");
			new Select(driver.findElement(By.id("c"))).selectByVisibleText("Brasil");
			
			for (int counter = 0; counter < 10; counter++) {
				driver.findElement(By.id("genbtn")).click();
				
				String fullName = driver.findElement(By.xpath("//div[@class='address']/h3")).getText();
				String[] addressRows = driver.findElement(By.xpath("//div[@class='address']/div[@class='adr']")).getText().split("\n");
				
				String address = addressRows[0];
				String city = addressRows[1].split("-")[0];
				String uf = addressRows[1].split("-")[1];
				String zipCode = addressRows[2];
				
				String country = driver.findElement(By.xpath("//div[@id='nameSetApps']/div//a")).getText();
				String email = driver.findElement(By.xpath("//dt[contains(text(), 'Endereço de e-mail')]/following::dd[1]")).getText().split("\n")[0];
				
				personList.add(new Person(fullName, email, null, address, country, uf, city, zipCode));
			}
			
			return personList;
		} catch (Exception e) {
			System.out.println(e.getCause() + " - " + e.getMessage());
		}
		
		return personList;
	}
	
	private static void createOutputExcel(List<Person> personList) {
		try (Workbook workbook = new XSSFWorkbook()) {
			Sheet sheet = workbook.createSheet("people");
			
			Row headerRow = sheet.createRow(0);
			headerRow.createCell(0).setCellValue("fullName");
			headerRow.createCell(1).setCellValue("city");
			headerRow.createCell(2).setCellValue("country");
			headerRow.createCell(3).setCellValue("email");
			headerRow.createCell(4).setCellValue("address");
			headerRow.createCell(5).setCellValue("gender");
			headerRow.createCell(6).setCellValue("uf");
			headerRow.createCell(7).setCellValue("zipCode");
			
			int line = 1;
			for(Person person : personList) {
				Row row = sheet.createRow(line);
				
				row.createCell(0).setCellValue(person.getFullName());
				row.createCell(1).setCellValue(person.getCity());
				row.createCell(2).setCellValue(person.getCountry());
				row.createCell(3).setCellValue(person.getEmail());
				row.createCell(4).setCellValue(person.getAddress());
				row.createCell(5).setCellValue(person.getGender());
				row.createCell(6).setCellValue(person.getUf());
				row.createCell(7).setCellValue(person.getZipCode());
				
				line++;
			}
			
			String outputFile = "D:\\RPA Academy\\curso\\Projetos\\rpa.00.generator\\01.entrada\\people_file.xlsx";
			FileOutputStream outputStream = new FileOutputStream(outputFile);
			workbook.write(outputStream);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}








