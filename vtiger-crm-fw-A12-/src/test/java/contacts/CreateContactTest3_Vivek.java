package contacts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CreateContactTest3_Vivek {

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

		driver.findElement(By.linkText("Contacts")).click();
		Thread.sleep(2000);

		driver.findElement(By.cssSelector("img[alt='Create Contact...']")).click();

		WebElement firstLastField = driver.findElement(By.name("lastname"));
		String lastName = "Pandey";
		firstLastField.sendKeys(lastName);
		Thread.sleep(2000);

		WebElement emField = driver.findElement(By.id("email"));
		String Email = "vp123@gmail.com";
		emField.sendKeys(Email);
		Thread.sleep(2000);
		driver.findElement(By.name("assistant")).sendKeys("Vivek");
		Thread.sleep(2000);
		
		driver.findElement(By.id("assistantphone")).sendKeys("9632587410");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("input[title='Save [Alt+S]']")).click();
		Thread.sleep(5000);
		String eField = driver.findElement(By.id("dtlview_Email")).getText();
		
		if(eField.equals(Email)) {
			System.out.println("Created Contect Email Successfully!!!");
		}else {
			System.out.println("Failed...");
		}
		
		
		WebElement profilePic = driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));
		Actions act = new Actions(driver);
		act.moveToElement(profilePic).build().perform();
		Thread.sleep(3000);
		driver.findElement(By.linkText("Sign Out")).click();
		Thread.sleep(3000);

		driver.quit();

	}
	
	
}
