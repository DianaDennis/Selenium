package seleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleSearch {

	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	driver.get("https://www.google.com/");
	driver.findElement(By.name("q")).sendKeys("Naveen Automation Labs");
	Thread.sleep(3000);
	
	suggestionList("youtube");
	
	/*
	 * List<WebElement> suggList = driver.findElements(By.xpath(
	 * "//ul[@role='listbox']//div[@class='wM6W7d']/span"));
	 * System.out.println(suggList.size());//to print a list i can use : for each or
	 * for loop
	 * 
	 * //for each loop to print all suggestions for(WebElement e : suggList) {
	 * //System.out.println(e.getText());no to print directly all suggestion but
	 * choose which one to click on String text = e.getText();//it is a string so
	 * store in a String //put in condition
	 * if(text.equals("naveen automation labs youtube")) { e.click();//select
	 * suggestion break;//if suggestion match } }
	 *///*************************************************************************************
		//assignment with second aproch:even better customize text to make it generic text in a method!
	//WebElement ele = driver.findElement(By.xpath("//ul[@role='listbox']//b[contains(text(),' testng')]"));
			//("//ul/li[3]/div/div[2]/div[1]/span/b[contains(text(),' testng')]"));works too!!!		
	//ele.click();
	}
    public static void suggestionList(String text) {
    	
    	WebElement ele = driver.findElement(By.xpath("//ul[@role='listbox']//b[contains(text(),'"+text+"')]"));
    	ele.click();
    
    }
}
