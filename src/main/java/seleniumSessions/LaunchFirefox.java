package seleniumSessions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LaunchFirefox {

	public static void main(String[] args) {

		System.setProperty("webdriver.gecko.driver", "C:\\MySeleniumDrivers\\geckodriver.exe");

		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.google.com");//enter the url
		String title = driver.getTitle();//get the title of the page
		System.out.println("title is: " + title);
		
		driver.quit();
		
	}

}