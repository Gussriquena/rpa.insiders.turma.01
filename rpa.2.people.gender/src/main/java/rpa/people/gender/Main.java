package rpa.people.gender;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import rpa.people.gender.browser.DriverFactory;
import rpa.people.gender.model.Person;

public class Main {

	private static String pathInput = "D:\\RPA Academy\\curso\\Projetos\\rpa.00.generator\\01.entrada\\people_file.xlsx";
	private static String pathGender = "D:\\RPA Academy\\curso\\Projetos\\rpa.00.generator\\02.gender\\people_file.xlsx";
	private static String pathOutput = "D:\\RPA Academy\\curso\\Projetos\\rpa.00.generator\\03.completo\\people_file.xlsx";
	
	private static List<Person> personList;
	
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "resources\\chromedriver.exe");
		personList = new ArrayList<>();
		
		readExcel();
		search();
		writeOutputFile();
	}
	
	private static void readExcel() {
		System.out.println("Starting read excel");
		moveFile(pathInput, pathGender);
		
		try (FileInputStream inputStream = new FileInputStream(pathGender);
				XSSFWorkbook fileWorkbook = new XSSFWorkbook(inputStream)) {

			fileWorkbook.getSheetAt(0).rowIterator().forEachRemaining(row -> {
				String cellName = row.getCell(0).getStringCellValue();

				if (!cellName.contains("fullName")) {
					personList.add(new Person(cellName, ""));
				}
			});
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	
	public static void search() {
		System.out.println("searching on web");
		
		try (DriverFactory driverFactory = new DriverFactory()) {
			WebDriver driver = driverFactory.getChromeDriver();
			driver.get("https://rpa-insiders-tools.vercel.app/utils/name-probability");

			personList.forEach(person -> {
				String gender = searchName(driver, person.getName().split(" ")[0]);
				personList.get(personList.indexOf(person)).setGender(gender);
			});
			
			System.out.println(personList.toString());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	private static String searchName(WebDriver driver, String name) {
		driver.findElement(By.id("search")).sendKeys(name);
		driver.findElement(By.xpath("//button[@type='submit']")).click();

		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.xpath("(//h1)[2]")), name));

		String gender = driver.findElement(By.xpath("//form/following::p[1]")).getText().replace("Gênero: ", "");

		driver.findElement(By.id("search")).clear();
		return gender;
	}
	
	private static void writeOutputFile() {
		System.out.println("Writing output file");
		
		try (FileInputStream fileInputStream = new FileInputStream(pathGender);
				XSSFWorkbook fileWorkbook = new XSSFWorkbook(fileInputStream);
				FileOutputStream outputStream = new FileOutputStream(pathGender)){
			
			fileWorkbook.getSheetAt(0).rowIterator().forEachRemaining(row -> {
				if (!row.getCell(0).getStringCellValue().contains("fullName")) {
					row.createCell(5).setCellValue(personList.get(row.getRowNum()-1).getGender());
				}
			});
			
			fileWorkbook.write(outputStream);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		moveFile(pathGender, pathOutput);
	}

	private static void moveFile(String input, String output) {
		try {
			Files.move(Paths.get(input), Paths.get(output), StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			System.out.println("Falha ao mover o arquivo: " + e.getMessage());
		}
	}

}
