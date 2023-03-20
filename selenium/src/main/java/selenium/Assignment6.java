package selenium;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		String ans = "";

		driver.findElement(By.id("checkBoxOption2")).click();
		int n = driver.findElements(By.xpath("//input[@type='checkbox']")).size();
		for (int i = 0; i < n; i++) {
			boolean check = driver.findElements(By.xpath("//input[@type='checkbox']")).get(i).isSelected();
			if (check == true) {
				int j = i;
				int t = j + 1;
				if (t == 1) {
					ans = driver.findElement(By.xpath("//*[@id='checkbox-example']/fieldset/label[1]")).getText();
				} else if (t == 2) {
					ans = driver.findElement(By.xpath("//*[@id='checkbox-example']/fieldset/label[2]")).getText();
				} else {
					ans = driver.findElement(By.xpath("//*[@id='checkbox-example']/fieldset/label[3]")).getText();
				}

			}
		}

		System.out.println(ans);

		WebElement staticdropdown = driver.findElement(By.id("dropdown-class-example"));
		Select dropdown = new Select(staticdropdown);

		dropdown.selectByVisibleText(ans);

		driver.findElement(By.id("name")).sendKeys(ans);
		driver.findElement(By.xpath("//input[@id='alertbtn']")).click();
		String[] dup = driver.switchTo().alert().getText().split(",");
		driver.switchTo().alert().accept();

		String[] cls1 = dup[0].split(" ");

		List a = Arrays.asList(cls1);

		String s = ans;
		if (a.contains(s)) {
			System.out.println(ans + " is Present in Alert box");
		} else {
			System.out.println(ans + " is not Present in Alert Box");
		}

	}

}
