package seleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserUtil {

	private WebDriver driver;

	/**
	 * This method is used to initialize the driver on the basis of browsername
	 * 
	 * @param browser
	 * @return this returns webdriver
	 */
	public WebDriver launchBrowser(String browser) {

		System.out.println("browser name is: " + browser);

		if (browser.equalsIgnoreCase("chrome")) {
			//System.setProperty("webdriver.chrome.driver", "C:\\MySeleniumDrivers\\chromedriver.exe");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			//System.setProperty("webdriver.gecko.driver", "C:\\MySeleniumDrivers\\geckodriver.exe");
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("safari")) {
			driver = new SafariDriver();
		//*********************************************
		}else if(browser.equalsIgnoreCase("ie")) {
			//System.setProperty("webdriver.ie.driver", "C:\\MySeleniumDrivers\\IEDriverServer.exe");
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}else if(browser.equalsIgnoreCase("ms")) {
			//System.setProperty("webdriver.edge.driver","C:\\MySeleniumDrivers\\msedgedriver.exe" );
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		//*************************************************
		else {
			System.out.println("please pass the right browser...." + browser);
		}

		return driver;

	}

	/**
	 * 
	 * @param url
	 */
	public void enterUrl(String url) {
		System.out.println("url is:" + url);
		if (url.contains("http") || url.contains("https")) {
			driver.get(url);
		} else {
			System.out.println("incorrect url....");
			try {
				throw new Exception("INCORRECT URL MISSING HTTP or HTTPS");
			} catch (Exception e) {

			}
		}
	}

	public String getPageTitle() {
		return driver.getTitle();
	}

	public String getPageUrl() {
		return driver.getCurrentUrl();
	}

	public void quitBrowser() {
		driver.quit();
	}

	public void closeBrowser() {
		driver.close();
	}

}