package products;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class cc_extra {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		driver.get("http://localhost:8888/");

		// Login Procedure
		WebElement un = driver.findElement(By.cssSelector("input[name='user_name']"));
		un.sendKeys("admin");

		WebElement pwd = driver.findElement(By.cssSelector("input[name='user_password']"));
		pwd.sendKeys("manager");

		WebElement loginbtn = driver.findElement(By.id("submitButton"));
		loginbtn.click();

		driver.findElement(By.linkText("Contacts")).click();

		driver.findElement(By.cssSelector("img[alt='Create Contact...']")).click();

		String PID = driver.getWindowHandle();

		driver.findElement(By.xpath("//img[contains(@onclick,'height=602')]")).click();
		Thread.sleep(5000);
		
		Set<String> IDs = driver.getWindowHandles();

		for (String i : IDs) {

			driver.switchTo().window(i);

			Thread.sleep(4000);

			if (driver.getCurrentUrl().contains("Accounts")) {

				Thread.sleep(5000);
				driver.findElement(By.id("1")).click();
			}

		}

		driver.switchTo().window(PID);

		driver.findElement(By.cssSelector("input[name='assistant']")).sendKeys("Naveen");
	}

}
