package people.registry;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import people.registry.browser.DriverFactory;
import people.registry.model.Person;

public class Main {
	
	private static String pathInput = "D:\\RPA Academy\\curso\\Projetos\\rpa.00.generator\\03.completo\\people_file.xlsx";
	private static String pathOutput = "D:\\RPA Academy\\curso\\Projetos\\rpa.00.generator\\04.processados\\people_file.xlsx";
	private static List<Person> personList = new ArrayList<>();
	
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "resources\\chromedriver.exe");
		
		readExcelInput();
		inputPeople();
		writeOutputFile();
	
		// escrever excel de saída
	}
	
	private static void readExcelInput() {
		try (FileInputStream inputStream = new FileInputStream(pathInput);
				XSSFWorkbook fileWorkbook = new XSSFWorkbook(inputStream)) {

			fileWorkbook.getSheetAt(0).rowIterator().forEachRemaining(row -> {
				String cellName = row.getCell(0).getStringCellValue();

				if (!cellName.contains("fullName")) {
					Person person = new Person();
					person.setFullName(cellName);
					person.setCity(row.getCell(1).getStringCellValue());
					person.setCountry(row.getCell(2).getStringCellValue());
					person.setEmail(row.getCell(3).getStringCellValue());
					person.setAddress(row.getCell(4).getStringCellValue());
					person.setGender(row.getCell(5).getStringCellValue());
					person.setUf(row.getCell(6).getStringCellValue());
					person.setZipCode(row.getCell(7).getStringCellValue());
					
					personList.add(person);
				}
			});
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		moveFile(pathInput, pathOutput);
	}
	
	private static void inputPeople() {
		try (DriverFactory driverFactory = new DriverFactory()) {
			WebDriver driver = driverFactory.getChromeDriver();
			driver.get("https://rpa-insiders-tools.vercel.app/exercicios/exercicio1");
			
			personList.forEach(person -> {
				inputData(driver, person);
			});
			
			personList.forEach(System.out::println);
		} catch (Exception e) {
			System.out.println(e.getCause() + " - " + e.getMessage());
		}
	}
	
	private static void inputData(WebDriver driver, Person person) {
		if(validateIfNull(person)) {
			try {
				driver.findElement(By.xpath("//label[contains(text(), 'Email')]/following-sibling::input")).sendKeys(person.getEmail());
				driver.findElement(By.xpath("//label[contains(text(), 'Nome')]/following::input[1]")).sendKeys(person.getFullName());
				driver.findElement(By.xpath("//label[contains(text(), 'Endereço')]/following-sibling::input")).sendKeys(person.getAddress());
				
				driver.findElement(By.xpath("//label[contains(text(), 'País')]/following-sibling::input")).sendKeys(person.getCountry());
				driver.findElement(By.xpath("//label[contains(text(), 'Cidade')]/following-sibling::input")).sendKeys(person.getCity());
				driver.findElement(By.xpath("//label[contains(text(), 'CEP')]/following-sibling::input")).sendKeys(person.getZipCode());
				
				driver.findElement(By.xpath("//input[@value='"+person.getGender()+"']")).click();
				
				new Select(driver.findElement(By.xpath("//label[contains(text(), 'Estado')]/following-sibling::select")))
						.selectByValue(person.getUf());
				
				driver.findElement(By.xpath("//input[@id='terms']")).click();
				driver.findElement(By.xpath("//button[@id='registerEmployerBtn']")).click();
				
				WebDriverWait wait = new WebDriverWait(driver, 40);
				wait.until(
						ExpectedConditions.textToBePresentInElement(
						driver.findElement(By.xpath("(//tbody//tr)[1]//td[1]")), person.getFullName()));
				
				person.setStatus("OK");
			} catch (Exception e) {
				System.out.println(e.getMessage());
				driver.get("https://rpa-insiders-tools.vercel.app/exercicios/exercicio1");
				person.setStatus("NOK");
				person.setStatusMessage(e.getClass().getName());
			}
		} else {
			person.setStatus("NOK");
			person.setStatusMessage("Não podem haver campos nulos ou vazios");
		}
	}
	
	private static boolean validateIfNull(Person person) {
		if(person.getFullName() == null || person.getFullName().isEmpty()) return false;
		if(person.getEmail() == null || person.getEmail().isEmpty()) return false;
		if(person.getCity() == null || person.getCity().isEmpty()) return false;
		if(person.getCountry() == null || person.getCountry().isEmpty()) return false;
		if(person.getAddress() == null || person.getAddress().isEmpty()) return false;
		if(person.getGender() == null || person.getGender().isEmpty()) return false;
		if(person.getUf() == null || person.getUf().isEmpty()) return false;
		if(person.getZipCode() == null || person.getZipCode().isEmpty()) return false;
		return true;
	}
	
	private static void writeOutputFile() {
		try (Workbook workbook = new XSSFWorkbook();
				FileOutputStream outputStream = new FileOutputStream(pathOutput)) {
				
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
				headerRow.createCell(8).setCellValue("Status");
				headerRow.createCell(9).setCellValue("Mensagem");
				
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
					row.createCell(8).setCellValue(person.getStatus());
					row.createCell(9).setCellValue(person.getStatusMessage());
					
					line++;
				}
				
				workbook.write(outputStream);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
	}
	
	private static void moveFile(String input, String output) {
		try {
			Files.move(Paths.get(input), Paths.get(output), StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			System.out.println("Falha ao mover o arquivo: " + e.getMessage());
		}
	}

}
