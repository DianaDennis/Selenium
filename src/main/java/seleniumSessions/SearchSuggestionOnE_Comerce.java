package seleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SearchSuggestionOnE_Comerce {

	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
	
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://automationpractice.com/index.php");
		driver.findElement(By.id("search_query_top")).sendKeys("Dress");
		
		Thread.sleep(4000);
		selectSuggestion("Summer Dresses > Printed Chiffon ");
		
		
		  //stort in WebElement 
		//WebElement ele = driver.findElement
				//(By.xpath("//div[@class='ac_results']//li[contains(text(),'Casual Dresses > Printed ')]"));
		//ele.click();//select element
		 
		//assignment with for loop:
		/*List<WebElement> searchList = driver.findElements(By.xpath("//div[@class='ac_results']//li"));
		System.out.println(searchList.size());//get size
		for(WebElement e : searchList) {
			System.out.println(e.getText());//print available list of items
			String text = e.getText();
			if(text.equals("T-shirts > Faded Short Sleeve T-shirts")) {
				e.click();//select desired one
				break;
			}
		}*/

	}
	        //Generic function:
			public static void selectSuggestion(String suggestion) {
			//to avoid By locator:	
				WebElement ele = driver.findElement
						(By.xpath("//div[@class='ac_results']//li[contains(text(),'"+suggestion+"')]"));//customized string of item
				ele.click();
			}

}
