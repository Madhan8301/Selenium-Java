package selenium;

import java.util.Iterator;
import java.util.Set;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/");
		driver.findElement(By.linkText("Multiple Windows")).click();
		driver.findElement(By.linkText("Click Here")).click();
		
		Set <String> window = driver.getWindowHandles();
		Iterator<String> it = window.iterator();
		
		String ParentId = it.next();
		String ChildId = it.next();
		
		driver.switchTo().window(ChildId);
		System.out.println(driver.findElement(By.xpath("//div/h3")).getText());
		driver.switchTo().window(ParentId);
		System.out.println(driver.findElement(By.xpath("//div/h3")).getText());
	}

}
