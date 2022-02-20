package seleniumSessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectDropDownAllOptions {

	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");
		
		//html tag = select:value = attribute,country name is =text
		By country = By.id("Form_submitForm_Country");
		
		getDropDownOptionsCount(country);
		//validation point
		if(getDropDownOptionsList(country).contains("Lithuania")) {
			System.out.println("Lithuania is present in the drop down");
		}
		selectValueFromDropDown(country, "Italy");
		
		/*Select select = new Select(driver.findElement(country));
		
		//to check how many options in the list:
		List<WebElement> optionsList = select.getOptions();
		System.out.println(optionsList.size());//how many
		
		//to get index of all the dropdown:
		int i = 0;
		//to print all th country text one by one:
		for(WebElement e : optionsList) {
			System.out.println(i+":"+e.getText());
			i++;
		}*/
		
	}
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	public static int getDropDownOptionsCount(By locator) {
		Select select = new Select(getElement(locator));
		return select.getOptions().size();
		
	}
	public static List<String> getDropDownOptionsList(By locator) {
		Select select = new Select(driver.findElement(locator));
		
		List<WebElement> optionsList = select.getOptions();
		//to eliminate int i=0; counting do this:creat empty List
		List<String> optionsTextList = new ArrayList<String>();//top casting
		System.out.println(optionsList.size());
		
		for(WebElement e : optionsList) {
			String text = e.getText();//store text to eliminate  repetitive action
			optionsTextList.add(text);
		}
		
		/*int i = 0;
		for(WebElement e : optionsList) {
			System.out.println(i+":"+e.getText());
			i++;*/
		return optionsTextList;
	}
	public static void selectValueFromDropDown(By locator, String value) {
		//to click on particular value
		Select select = new Select(driver.findElement(locator));
		List<WebElement> optionList = select.getOptions();//collect
		
		for(WebElement e : optionList) {//itterate
			String text = e.getText();//print
			//condition to break the loop:
			if(text.equals(value)) {
				e.click();
				break;
			}
		}
		
	}
	}


