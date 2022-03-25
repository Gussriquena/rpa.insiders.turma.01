package curso.selenium;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Aula5_Cookies {

	public void getCookies() {
		System.setProperty("webdriver.chrome.driver", "resources\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rpainsiders.com.br/");
		
		//Set<Cookie> cookies = driver.manage().getCookies();
		//cookies.forEach(cookie -> System.out.println(cookie.getName() + ":" + cookie.getValue()));
		
		driver.manage().addCookie(new Cookie("meucookie", "turma 1"));
		
		//Cookie myCookie = driver.manage().getCookieNamed("__gads");  //Return specific cookie according to name
		//System.out.println(myCookie.getValue());
		
		//driver.manage().addCookie(arg0);   //Create and add the cookie
		//driver.manage().deleteCookie(arg0);  // Delete specific cookie
		//driver.manage().deleteCookieNamed(arg0); // Delete specific cookie according Name
		driver.manage().deleteAllCookies();  // Delete all cookies
		
	}
	
}
