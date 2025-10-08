package products;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;


public class CreateProductText4_Abhishek {

		public static void main(String[] args) throws InterruptedException {
			
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

			driver.get("http://localhost:8888/");
			
//			LOGIN
			
			WebElement username = driver.findElement(By.name("user_name"));
			username.sendKeys("admin");
			
			WebElement password = driver.findElement(By.name("user_password"));
			password.sendKeys("manager");
			
			driver.findElement(By.id("submitButton")).click();
			Thread.sleep(3000);
		
//			CLICK ON PRODUCT
			
			driver.findElement(By.linkText("Products")).click();
			Thread.sleep(2000);
			driver.findElement(By.cssSelector("img[alt='Create Product...']")).click();
			Thread.sleep(2000);
			
//			WRITE PRODUCT NAME / FILL DETAILS
			
			WebElement pdNameField  = driver.findElement(By.name("productname"));
			String proName = "H&M";
			pdNameField.sendKeys(proName);
			Thread.sleep(2000);
			
			
			
			WebElement dateField = driver.findElement(By.name("sales_start_date"));
			dateField.clear();
			dateField.sendKeys("2024-12-25");
			Thread.sleep(3000);
			
			WebElement sal = driver.findElement(By.name("productcategory"));
			Select dropdown = new Select(sal);
			dropdown.selectByVisibleText("Software");
			Thread.sleep(3000);
			
			WebElement date = driver.findElement(By.name("sales_end_date"));
			date.clear();
			date.sendKeys("2025-09-29");
			Thread.sleep(3000);
			
			driver.findElement(By.id("productsheet")).sendKeys("ZARA");
			Thread.sleep(2000);
			driver.findElement(By.id("productcode")).sendKeys("689");
			Thread.sleep(2000);
		
			WebElement startdate = driver.findElement(By.name("start_date"));
			startdate.clear();
			startdate.sendKeys("2025-08-28");
			Thread.sleep(2000);
			
			 WebElement enddate = driver.findElement(By.name("expiry_date"));
			enddate.clear();
			enddate.sendKeys("2025-09-28");
			Thread.sleep(2000);
//			SAVE
			
			driver.findElement(By.cssSelector("input[title='Save [Alt+S]']")).click();
			Thread.sleep(1000);
			
//			VERIFICATION
			
			WebElement profilePic = driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));
			Actions act = new Actions(driver);
			act.moveToElement(profilePic).build().perform();
			Thread.sleep(3000);
			driver.findElement(By.linkText("Sign Out")).click();
			Thread.sleep(2000);
			
			driver.quit();
		
		
		}		
}