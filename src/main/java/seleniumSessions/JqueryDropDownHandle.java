package seleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JqueryDropDownHandle {

	static WebDriver driver;
	
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");
		driver.findElement(By.id("justAnInputBox")).click();
		By choices = By.xpath("//span[@class='comboTreeItemTitle']");
		//Calling method:
		//test case 1 for single selection
		//selectChoice(choices, "choice 8");//wrong value since it is only up to 7
		
		//test case 2 multiple selection:
		selectChoice(choices, "choice 1", "choice 2", "choice 8");
		//***assignment print out choice 8 is not available***
		
		//selectChoice(choices, "choice 2");
		//selectChoice(choices, "choice 2 2");//server will be called numerous times not good approach
		//so we need to store in a String Array,it will call once with multiple choices
	
		//test case 3,select all the choices:
		//selectChoice(choices, "all");//keyword"all"_>represents 1 value
	
	}
	/**
	 * @param please pass value all
	 * @param locator
	 * @param value
	 */
	
	//generic method for this 
	public static void selectChoice(By locator, String... value) {//3 dot operator will function as String array
		
		//to collect all choices customize xpath:
				//span[@class='comboTreeItemTitle']move to top
				List<WebElement> choicesList = 
						driver.findElements(locator);
				//for getting exception if i am passing wrong value
				boolean flag = false;
				
				//for value"all" for loop:"!value" -> acts like reverse condition so we actually comparing condition
				if(!value[0].equalsIgnoreCase("all")) {//! will make it false
					
					for(WebElement e : choicesList) {
						String text =  e.getText();
						//System.out.println(text);
						
						for(int i=0; i<value.length;i++) {
							if(text.equals(value[i])) {
								flag =  true;//if it is found
								e.click();
								break;
							//*************assignment**************
								//!flag==true;
							//}else {
								//flag = false;
								//System.out.println();
							}//********************************************
						}
					}
					//will have all the logic for select all choices:wonce comparing is not satisfied
				}else {
					try {//put condition to stop from getting exception
					for(WebElement e : choicesList) {
						e.click();//to select all
						flag = true;//means all the values
					}
				
				}catch(ElementNotInteractableException e) {
					System.out.println("all choices are over.....");
				}
		}
			//put condition for flag:
				if(flag == false) {
					System.out.println("choice is not availible..."+value[0]);//to pass choice
					
				}
				
				//for(WebElement e : choicesList){//itterate
					//String text =  e.getText();//store values
					//System.out.println(text);//print all the values
					
					/*//choose values from the list:add condition..
					//if(text.equals("choice 1")) {//replace hard coded value
						if(text.equals(value)) {
					    e.click();
						break;
					}
				}

			}*///once value is declared as String array in parameters we need to make iner loop:
					//for(int i=0; i<value.length;i++) {
						//condition:
						//if(text.equals(value[i])) {
							//e.click();
							//break;
						//}
					//}
		
				//}
	}
	}


