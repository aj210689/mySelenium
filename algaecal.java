import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class algaecal {
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Programming\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//Implicit Wait to allow time to load between page transitions
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Explicit wait
		WebDriverWait w = new WebDriverWait(driver, 20);
		
		//Launch the website
		driver.get("https://www.algaecal.com/product/bone-builder-packs/");

		//Add 3 months of suppy
		driver.findElement(By.xpath("//*[@data-bc-product-id='100366']")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains (@href,'/checkout?')]")));
		
		driver.navigate().back();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-bc-product-id='100367']")));
		
		driver.findElement(By.xpath("//*[@data-bc-product-id='100367']")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains (@href,'/checkout?')]")));
		
		driver.navigate().back();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-bc-product-id='100368']")));
		
		driver.findElement(By.xpath("//*[@data-bc-product-id='100368']")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains (@href,'/checkout?')]")));
		
		System.out.println("Done");
		
		
	}

}
