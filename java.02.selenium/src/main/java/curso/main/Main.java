package curso.main;

import curso.selenium.Aula1_Selenium;

public class Main {
	
	public static void main(String[] args) {
		// The path to the driver executable must be set by the webdriver.chrome.driver system property
		System.setProperty("webdriver.chrome.driver", "resources\\chromedriver.exe");
		
		Aula1_Selenium aulaXpath = new Aula1_Selenium();
		aulaXpath.InsertPeople();
		
	}

}
