package selenium;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FunctionalTesting {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		int count =0;
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		
		Thread.sleep(3000);
		String expected [] = {"Pomegranate","Apple","Carrot","Cauliflower","Raspberry","Walnuts","Pista","Almonds"};
		
		List<WebElement> shopItems = driver.findElements(By.cssSelector("h4.product-name"));
		
		for (int i=0;i<shopItems.size();i++) {
			
			
			String[] name = shopItems.get(i).getText().split("-");
			String formattedname = name[0].trim();
			
			List real = Arrays.asList(expected);
			
			if(real.contains(formattedname)) {
				count++;
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				
				if(count==expected.length) {
					System.out.println(expected.length+" Items Added to the Cart Successfully!!");
					break;
				}
			}
			
			
			
		}
		
		

	}

}
