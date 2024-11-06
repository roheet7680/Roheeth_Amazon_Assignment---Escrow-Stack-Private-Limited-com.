package amazonautomation1;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AmazonAutomationWeb{
	public static void main(String[] args) {
		// Setup Chrome driver path
		ChromeDriver driver  =  new ChromeDriver();   

		// Setup Chrome options
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");

		// Initialize WebDriver
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		try {
			// Step 1: Go to Amazon India
			driver.get("https://www.amazon.in");  

			// Step 2: In the search bar, enter "Wrist Watches" and search
			WebElement searchBar = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("twotabsearchtextbox")));
			searchBar.sendKeys("Wrist Watches");
			searchBar.sendKeys(Keys.RETURN);

			// Step 3: Filter the results by selecting "Leather" under Watch Band Material
			WebElement leatherFilter = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"p_n_material_browse/1480907031\"]/span/a/span")));
			leatherFilter.click();

			// Step 4: Select "Fastrack" as the watch brand
			WebElement fastrackFilter = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"p_123/230542\"]/span/a/span")));
			fastrackFilter.click();

			// Step 5: Navigate to the 2nd page of the search results
			WebElement nextPage = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@aria-label, 'Go to page 2')]")));
			nextPage.click();
   
			// Step 6: From the 1st product in the 1st row, add the item to your cart
			WebElement firstProduct = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[@data-component-type='s-search-result'])[1]//h2/a")));
			firstProduct.click();  
			WebElement addToCart = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html")));
			addToCart.click();

			System.out.println("Item has been added to the cart successfully!");
		} finally {
			// Close the browser
			driver.quit(); 
		}
	}
}


