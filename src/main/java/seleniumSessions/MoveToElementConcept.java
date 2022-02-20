package seleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MoveToElementConcept {

	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		
		//move to element
		//parent to child menu
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://mrbool.com/search/?txtsearch=how-to-create-menu-with-submenu-using-css-html");
		
		WebElement contentparent =  driver.findElement(By.className("menulink"));
		//then need to mouse hover to get visible elements to be able interact
		Actions act = new Actions(driver);
		act.moveToElement(contentparent).perform();//if removed performed action canot be performed but it will not give an error on console
		//if you have single action is enough just to write .perform(),if need more actions then must write .build().perform()
		//only build() will not perform anything ...build only to collect
		Thread.sleep(3000);
		
		//move from parent to the child menu !!!"Courses"->in a dom not considered only what is on display which is in this case is all capitol"COURSES"
		driver.findElement(By.linkText("COURSES")).click();
	}

}
