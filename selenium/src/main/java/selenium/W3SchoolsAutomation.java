package selenium;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class W3SchoolsAutomation {
    public static void main(String[] args) {
        // Set the path to the chromedriver executable
        //System.setProperty("webdriver.chrome.driver", "path/to/chromedriver.exe");

        // Initialize the ChromeDriver instance
    	WebDriver driver = new ChromeDriver();

        // Navigate to the W3Schools website
        driver.get("https://www.w3schools.com/");

        // Find the search box element by name
        WebElement searchBox = driver.findElement(By.id("search2"));

        // Enter a search term
        searchBox.sendKeys("Selenium");

        // Submit the search form
        searchBox.submit();

        // Wait for the search results page to load
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement searchResults = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("main")));

        // Print the page title and URL
        System.out.println("Page title is: " + driver.getTitle());
        System.out.println("Page URL is: " + driver.getCurrentUrl());
    }
}
