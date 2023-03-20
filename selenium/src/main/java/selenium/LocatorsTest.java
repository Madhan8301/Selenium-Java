package selenium;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsTest{
	public static void main(String[] args) {
		WebDriver driver= new ChromeDriver();driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.cssSelector("input[placeholder='Name']")).sendKeys("Afrin");
		driver.findElement(By.xpath("//form[@class='form']/input[2]")).sendKeys("rahulshettyacy");
		driver.findElement(By.cssSelector("input#chkboxOne")).click();
		driver.findElement(By.cssSelector("input[value='agreeTerms']")).click();
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}
}