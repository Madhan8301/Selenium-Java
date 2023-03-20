package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Summa {

	public static void main(String[] args) {
		// TODO Auto-generated method stubb
		WebDriver driver = new ChromeDriver();
		driver.get("https://exercises.test-design.org/paid-vacation-days/");
		driver.findElement(By.xpath("//input[@data-harmony-id='Age']")).sendKeys("59");
		driver.findElement(By.xpath("//input[@data-harmony-id='Service']")).sendKeys("29");
		driver.findElement(By.xpath("//button[@data-harmony-id='Continue']")).click();
		String actual = driver.findElement(By.xpath("//span[@data-harmony-id='Vacation days']")).getText();
		
		String Expected = "20";
		
		if(actual.equalsIgnoreCase(Expected)) {
			System.out.println("Passed");
		}
		else {
			System.err.println("Failed");
		}
	}

}
