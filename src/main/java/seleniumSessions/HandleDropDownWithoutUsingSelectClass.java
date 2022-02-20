package seleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleDropDownWithoutUsingSelectClass {
	
	static WebDriver driver;

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");
		
		
		//it can be done with using xpath:
		By country = By.xpath("//select[@id='Form_submitForm_Country']/option");
		
		List<WebElement> countryList = driver.findElements(country);
		
		for(WebElement e : countryList) {
			String text = e.getText();
			if(text.equals("Poland")) {
				e.click();
				break;
			}
		}
	}

}
