package products;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CreateProductText {

public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		driver.get("http://localhost:8888/");
		
		WebElement username = driver.findElement(By.name("user_name"));
		username.sendKeys("admin");
		
		WebElement password = driver.findElement(By.name("user_password"));
		password.sendKeys("manager");
		
		driver.findElement(By.id("submitButton")).click();
		Thread.sleep(3000);
	
		driver.findElement(By.linkText("Products")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("img[alt='Create Product...']")).click();
		Thread.sleep(2000);
		
		WebElement pdNameField  = driver.findElement(By.name("productname"));
		String proName = "Adidas";
		pdNameField.sendKeys(proName);
		Thread.sleep(2000);
		
		driver.findElement(By.id("productsheet")).sendKeys("Adidas2.0");
		Thread.sleep(2000);
		driver.findElement(By.id("productcode")).sendKeys("101");
		Thread.sleep(2000);
	
		driver.findElement(By.cssSelector("input[title='Save [Alt+S]']")).click();
		Thread.sleep(1000);
		String pNameField = driver.findElement(By.id("dtlview_Product Name")).getText();

		if (pNameField.equals(proName)) {
			System.out.println("Created Product Name  Successfully!!!");
		} else {
			System.out.println("Failed...");
		}
		
		WebElement profilePic = driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));
		Actions act = new Actions(driver);
		act.moveToElement(profilePic).build().perform();
		Thread.sleep(3000);
		driver.findElement(By.linkText("Sign Out")).click();
		driver.quit();
	
	
	}		
}
