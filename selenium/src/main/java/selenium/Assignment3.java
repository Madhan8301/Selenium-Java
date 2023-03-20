package selenium;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment3 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		LoginPage(driver, w);
		HomePage(driver, w);

	}

	public static void LoginPage(WebDriver driver, WebDriverWait w) {

		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("rahulshettyacademy");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("learning");
		driver.findElement(By.xpath("//input[@value='user']")).click();
		
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[id='okayBtn']")));
		System.out.println(driver.findElement(By.xpath("//div[@class='modal-body']")).getText());
		driver.findElement(By.cssSelector("button[id='okayBtn']")).click();
		WebElement staticdropdown = driver.findElement(By.xpath("//select[@data-style='btn-info']"));
		Select dropdown = new Select(staticdropdown);

		dropdown.selectByVisibleText("Consultant");
		driver.findElement(By.id("terms")).click();
		driver.findElement(By.id("signInBtn")).click();

	}

	public static void HomePage(WebDriver driver, WebDriverWait w) {
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div/h1")));

		String[] prod = { "iphone X", "Nokia Edge", "Blackberry" };

		List<WebElement> cart = driver.findElements(By.xpath("//div//h4/a"));

		for (int i = 0; i < cart.size(); i++) {

			String item = cart.get(i).getText();
			List orginal = Arrays.asList(prod);

			if (orginal.contains(item)) {
				driver.findElements(By.xpath("//button[@class='btn btn-info']")).get(i).click();
			}
		}
		driver.findElement(By.xpath("//div/ul/li/a")).click();
	}

}
