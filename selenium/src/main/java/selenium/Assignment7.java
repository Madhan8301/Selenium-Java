package selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("http://qaclickacademy.com/practice.php");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,750)");
		
		
		int rowCount= driver.findElements(By.cssSelector(".table-display tr")).size();
		System.out.println(rowCount);
		
		
		int coloumnCount = driver.findElements(By.cssSelector(".table-display th")).size();
		System.out.println(coloumnCount);
		
		for(int i=0;i<rowCount;i++) {
			if(i==2) {
				
				List<WebElement> ans = driver.findElements(By.tagName("tr")).get(i).findElements(By.tagName("td"));
				for(int j=0;j<coloumnCount;j++) {
					System.out.println(ans.get(j).getText());
				}
				
				break;
			}
		}
		
		

	}

}
