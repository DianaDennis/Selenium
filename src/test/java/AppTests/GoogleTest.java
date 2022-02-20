package AppTests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GoogleTest extends BaseTest {//base test takes care of webdriver maneger and lunch url as well as clousing browser
//by defoult all test cases equal to: enabled = true
	@Test(priority = 1)
	public void googleTitleTest() {
		Assert.assertEquals(driver.getTitle(), "Google");
	}

	@Test(priority = 2, enabled = true)//if you want to avoid for some reason to run it use :enabled =false 
	public void googleSearch() {
		driver.findElement(By.name("q")).sendKeys("macbook pro");
		Assert.assertTrue(true);
	}

}