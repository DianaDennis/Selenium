package seleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverBasics {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\MySeleniumDrivers\\chromedriver.exe");
		//automation steps:
		WebDriver driver = new ChromeDriver();//launch chrome
		driver.get("https://Facebook.com");//enter url
		String title = driver.getTitle();//get title
		System.out.println("Title of the page: " + title);
		//+
		//verification point/actual vs expected result:
		if(title.equals("Facebook - Log In or Sign Up")) {
			System.out.println("Facebook is correct title");
		}else {
			System.out.println("Incorrect title please pass correct title");
		}//automation testing
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getPageSource());
		
		if(driver.getPageSource().contains("Copyright The Closure Library Authors")) {
			System.out.println("is present...");
		}
		driver.quit();//close the browser
	}

}
