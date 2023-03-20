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



public class EndtoEnd {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(50));
		driver.manage().window().maximize();
		Loginpage(driver, w);
		HomePage(driver, w);
		ShopPage(driver, w);	
	}
	
	
	public static void Loginpage(WebDriver driver , WebDriverWait w) {
		String n1 = driver.findElement(By.cssSelector("p.text-center.text-white")).getText();
		// System.out.println(n1);

		String n2[] = n1.split("and");
		String Uname = n2[0].split("is")[1].trim();
		String pass = n2[1].split("is")[1].trim();
		
		StringBuffer sb= new StringBuffer(pass);
	    sb.deleteCharAt(sb.length()-1);
		
		System.out.println(Uname);
		System.out.println(sb);

		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(Uname);
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(sb);

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
	
	
	
	public static void HomePage(WebDriver driver,WebDriverWait w) {
		
		w.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Home")));
		driver.findElement(By.linkText("Home")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.name("name")));
		
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
		driver.findElement(By.linkText("Shop")).click();
		
	}
	
	public static void ShopPage(WebDriver driver,WebDriverWait w) throws InterruptedException {
		//w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div//h4/a")));
		Thread.sleep(3000);
		String[] prod = { "iphone X", "Nokia Edge", "Blackberry" };
		int count =0;
		List<WebElement> cart = driver.findElements(By.xpath("//div//h4/a"));

		for (int i = 0; i < cart.size(); i++) {

			String item = cart.get(i).getText();
			List orginal = Arrays.asList(prod);

			if (orginal.contains(item)) {
				count++;
				driver.findElements(By.xpath("//button[@class='btn btn-info']")).get(i).click();
			}
		}
		driver.findElement(By.xpath("//div/ul/li/a")).click();
		System.out.println(count + " Items added to cart Successfully.");
	}
	
}
