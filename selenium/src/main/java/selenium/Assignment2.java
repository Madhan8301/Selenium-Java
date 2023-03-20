package selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		//driver.findElement(By.xpath("//li[@class='nav-item'][1]")).click();
		
		driver.findElement(By.linkText("Home")).click();
		driver.findElement(By.name("name")).sendKeys("Madahn kumar");
		driver.findElement(By.name("email")).sendKeys("madhankumarm8301@gmail.com");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("Madhan@9486");
		driver.findElement(By.cssSelector("input[class='form-check-input']")).click();
		//driver.findElement(By.xpath("//select[@class='form-control'][1]")).click();
		
		WebElement staticdropdown = driver.findElement(By.xpath("//select[@class='form-control']"));
		Select dropdown = new Select(staticdropdown);
		dropdown.selectByIndex(0);
		
	
		
		driver.findElement(By.id("inlineRadio1")).click();
		driver.findElement(By.name("bday")).sendKeys("03/08/2001");
		driver.findElement(By.cssSelector("input[class*='btn-success']")).click();
		
		System.out.println(driver.findElement(By.cssSelector("div[class*='alert-success']")).getText());		
	}

}
