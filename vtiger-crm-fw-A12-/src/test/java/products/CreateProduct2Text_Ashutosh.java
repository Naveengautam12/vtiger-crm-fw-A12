package products;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreateProduct2Text_Ashutosh {

		public static void main(String[] args) throws InterruptedException, IOException {
			
//			Get Common data from property file

//			1. Get the java representation of physical file
			FileInputStream fis = new FileInputStream("./src/test/resources/CommonData.properties");
			
//			2. Use the load() of Properties class to load all the keys
			Properties pObj = new Properties();
			pObj.load(fis);
			
//			3. Use the getProperty() and pass the key to get data in String format
			String URL = pObj.getProperty("url");
			String UN = pObj.getProperty("un");
			String PWD = pObj.getProperty("pwd");
					
		
//			Open Browser 
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
			
//			Login
			driver.get(URL);
			
			WebElement username = driver.findElement(By.name("user_name"));
			username.sendKeys(UN);
			WebElement password = driver.findElement(By.name("user_password"));
			password.sendKeys(PWD);
			
			driver.findElement(By.id("submitButton")).click();
			Thread.sleep(3000);
			
//			Move to Products tab and create a new product		
			driver.findElement(By.linkText("Products")).click();
			driver.findElement(By.xpath("//img[@title='Create Product...']")).click();

//			Provide product name		
			WebElement pName = driver.findElement(By.name("productname"));
			String productName = "Mobile";
			pName.sendKeys(productName);
			Thread.sleep(2000);
			
//			Click on Product Active button 2 times
			driver.findElement(By.name("discontinued")).click();
			Thread.sleep(2000);
			driver.findElement(By.name("discontinued")).click();
			Thread.sleep(2000);
			
//	 		Provide Sales Start Date
			WebElement ssd = driver.findElement(By.name("sales_start_date"));
			String salesSD = "2025-10-12";
			ssd.sendKeys(salesSD);
			Thread.sleep(2000);
			
//			Save
			driver.findElement(By.xpath("  //input[@value='  Save  ']  ")).click();
			
//			Verification
			String actPName = driver.findElement(By.id("dtlview_Product Name")).getText();
//			String actPName = driver.findElement(By.name("productname")).getText();
			if(actPName.equals(productName))
				System.out.println("product name uploaded successfully");
			else
				System.out.println("product name not uploaded successfully");
			
			String actSalesStartDate = driver.findElement(By.id("dtlview_Sales Start Date")).getText();
			if (actSalesStartDate.equals(salesSD))
				System.out.println("Start Date uploaded successfully");
			else
				System.out.println("Start Date not uploaded successfully");
			
			driver.quit();
			

	}
}
	
