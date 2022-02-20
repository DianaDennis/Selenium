package seleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectDropDown {

	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");
		
		//html tag = select:value = attribute,country name is =text
		By country = By.id("Form_submitForm_Country");
		//By state = By.id("Form_submitForm_State");
		/*WebElement country_ele = driver.findElement(country);
		
		Select select = new Select(country_ele);//Required to pass WebElement
		select.selectByIndex(5);//is good for constant values like years,months, days
		select.selectByVisibleText("Lithuania");//is good for dynamic values
		select.selectByValue("Libya");//attribute
		*/
		
		//doSelectDropDownByIndex(country, 5);
		//Thread.sleep(2000);
		//doSelectValueByIndex(state, 2);
		doSelectDropDownByVisibleText(country, "Lithuania");
		//and so on....
	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	public static void doSelectDropDownByIndex(By locator, int index) {
		Select select = new Select(getElement(locator));
		select.selectByIndex(index);
	}
	public static void doSelectDropDownByVisibleText(By locator, String visibleText) {
		Select select = new Select(getElement(locator));
		select.selectByVisibleText(visibleText);
	}
	public static void doSelectDropDownByValue(By locator, String value) {
		Select select = new Select(getElement(locator));
		select.selectByValue(value);
	}

}
