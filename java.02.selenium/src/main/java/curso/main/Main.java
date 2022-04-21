package curso.main;

import curso.seletores.Aula1_xpath;

public class Main {
	
	public static void main(String[] args) {
		// The path to the driver executable must be set by the webdriver.chrome.driver system property
		System.setProperty("webdriver.chrome.driver", "resources\\chromedriver.exe");
		
		Aula1_xpath aulaXpath = new Aula1_xpath();
		aulaXpath.inputDynamicData();
		
	}

}
