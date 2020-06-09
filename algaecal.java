import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class algaecal {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Programming\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		// Implicit Wait to allow time to load between page transitions
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Explicit wait
		WebDriverWait w = new WebDriverWait(driver, 20);

		// Launch the website
		driver.get("https://www.algaecal.com/product/bone-builder-packs/");

		// Add 3 months of supply bundle and navigate back to main page
		driver.findElement(By.xpath("//*[@data-bc-product-id='100366']")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains (@href,'/checkout?')]")));
		driver.navigate().back();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-bc-product-id='100367']")));

		// Add 6 months of supply bundle and navigate back to main page
		driver.findElement(By.xpath("//*[@data-bc-product-id='100367']")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains (@href,'/checkout?')]")));
		driver.navigate().back();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-bc-product-id='100368']")));

		// Add 12 months of supply bundle
		driver.findElement(By.xpath("//*[@data-bc-product-id='100368']")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains (@href,'/checkout?')]")));

		boolean foundThreeMonth = false;
		boolean foundSixMonth = false;
		boolean foundTwelveMonth = false;

		// Verify if we have all three bundles in the cart
		List<WebElement> products = driver.findElements(By.xpath("//*[@class='product-name']"));
		for (int i = 0; i < products.size(); i++) {
			if (products.get(i).getText().contains("3 Month Supply")) {
				foundThreeMonth = true;
				System.out.println("Found 3 months supply");
			} else if (products.get(i).getText().contains("6 Month Supply")) {
				foundSixMonth = true;
				System.out.println("Found 6 months supply");
			} else if (products.get(i).getText().contains("12 Month Supply")) {
				foundTwelveMonth = true;
				System.out.println("Found 12 months supply");
			}
		}

		Assert.assertTrue(foundThreeMonth, "User should be able to add 3 months bundle to the cart");
		Assert.assertTrue(foundSixMonth, "User should be able to add 6 months bundle to the cart");
		Assert.assertTrue(foundTwelveMonth, "User should be able to add 12 months bundle to the cart");
		Assert.assertTrue((foundThreeMonth && foundSixMonth && foundTwelveMonth), "Add to Cart button works on the bundles");
		driver.quit();

	}

}
