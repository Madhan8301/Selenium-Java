package selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class tEAMS {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		// driver.get("https://teams.microsoft.com/_?culture=en-in&country=in#/conversations/19:preview-c0594051-8491-4b9d-90e7-e4ed0a436fea?ctx=chat");
//			driver.findElement(By.xpath("//input[@class='ts-header-search ts-heading-font power-bar ng-pristine ng-valid ng-empty ng-valid-maxlength ng-touched commandbox-string-experiment']")).click();
		int c=1;
		
		for (int i = 1600; i < 1700 & c!=0; i++) {
			WebDriver driver = getDriver();
			driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys("sumith@gmail.com");
			String Pass1 = "Kara@";
			String pass = Pass1 + Integer.toString(i);
			driver.findElement(By.xpath("//input[@id='userPassword']")).sendKeys(pass);
			driver.findElement(By.xpath("//input[@id='login']")).click();
			Thread.sleep(1000);
			String msg = GetErrorMessage(driver);
			//String msg = driver.findElement(By.cssSelector("*[class*='flyInOut']")).getText();
			if (msg.equalsIgnoreCase("Incorrect email or password.")) {
				System.out.println(pass);
				c++;
				driver.close();
			} else {
				System.out.println("Correct password is : "+pass);
				c=0;
				break;
			}
		}
		// driver.findElement(By.xpath("//input[@id='userPassword']")).click();

	}
	
	public static WebDriver getDriver() throws InterruptedException {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(option);
		driver.get("https://rahulshettyacademy.com/client/");
		Thread.sleep(3000);
		return driver;
	}
	
	public static String GetErrorMessage(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("*[class*='flyInOut']"))));
		String errMsg = driver.findElement(By.cssSelector("[class*='flyInOut']")).getText();
		System.out.println(errMsg);
		return errMsg;
	}
	

}
