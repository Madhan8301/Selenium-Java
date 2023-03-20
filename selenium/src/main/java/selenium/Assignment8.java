package selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Assignment8 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		String key = "unit";
		driver.findElement(By.cssSelector("#autocomplete")).sendKeys(key);

		List<WebElement> options = driver.findElements(By.cssSelector("li[class='ui-menu-item']"));
		Thread.sleep(2000);
		//String n1 = "";
	//	driver.findElement(By.id("autocomplete")).sendKeys(Keys.DOWN);
		// driver.findElement(By.id("autocomplete")).sendKeys(Keys.DOWN);
//		System.out.println(driver.findElement(By.id("autocomplete")).getAttribute("value"));
//		// if(n.equalsIgnoreCase("United States (USA)")) {
//		String n = driver.findElement(By.id("autocomplete")).getAttribute("value");

//		int i = 1;
//
//		if (i != 0 && n.equals("United States (USA)")) {
//			n1 = driver.findElement(By.id("autocomplete")).getAttribute("value");
//			i=0;
//			//break;
//		} else {
//			driver.findElement(By.id("autocomplete")).sendKeys(Keys.DOWN);
//			n = driver.findElement(By.id("autocomplete")).getAttribute("value");
//			i++;
//		}
//
//		System.out.println(n1);
		driver.findElement(By.id("autocomplete")).sendKeys(Keys.DOWN);
		for(int i=0;i<100;i++) {
			
			if(driver.findElement(By.id("autocomplete")).getAttribute("value").equals("United States (USA)")) {
				System.out.println(driver.findElement(By.id("autocomplete")).getAttribute("value"));
				break;
			}
			else {
				driver.findElement(By.id("autocomplete")).sendKeys(Keys.DOWN);
			}
		}
		
	}

}