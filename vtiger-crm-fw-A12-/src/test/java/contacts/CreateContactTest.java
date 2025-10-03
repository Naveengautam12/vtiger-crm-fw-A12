package contacts;

import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import generic_utility.FileUtility;

public class CreateContactTest {

	public static void main(String[] args) throws InterruptedException, EncryptedDocumentException, IOException {

FileUtility fUtil = new FileUtility();
		
//		Get the data from properties file
		String BROWSER = fUtil.getDataFromPropertiesFile("bro");
		String URL = fUtil.getDataFromPropertiesFile("url");
		String USERNAME = fUtil.getDataFromPropertiesFile("un");
		String PASSWORD = fUtil.getDataFromPropertiesFile("pwd");
		
//		Get the data from excel file
		String fName = fUtil.getStringDataFromExcelFile("contdetalis", 11, 0);
		
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		driver.get(URL);
		
		WebElement username = driver.findElement(By.name("user_name"));
		username.sendKeys(USERNAME);

		WebElement password = driver.findElement(By.name("user_password"));
		password.sendKeys(PASSWORD);

		driver.findElement(By.id("submitButton")).click();
		Thread.sleep(3000);

		driver.findElement(By.linkText("Contacts")).click();
		Thread.sleep(2000);

		driver.findElement(By.cssSelector("img[alt='Create Contact...']")).click();

		WebElement fNDD = driver.findElement(By.cssSelector("select[name='salutationtype']"));
		Select fn = new Select(fNDD);
		fn.selectByContainsVisibleText("Mr.");
		Thread.sleep(3000);

		WebElement firstNameField = driver.findElement(By.name("firstname"));
		String firstName = fName;
		firstNameField.sendKeys(firstName);
		Thread.sleep(2000);

		WebElement firstLastField = driver.findElement(By.name("lastname"));
		String lastName = "kumar";
		firstLastField.sendKeys(lastName);
		Thread.sleep(2000);

		String PID = driver.getWindowHandle();
		driver.findElement(By.cssSelector("img[alt='Select']")).click();
		Thread.sleep(2000);

		Set<String> IDs = driver.getWindowHandles();
		Thread.sleep(2000);

		for (String i : IDs) {
			driver.switchTo().window(i);

			Thread.sleep(5000);

			if (driver.getCurrentUrl().contains("Accounts")) {
				Thread.sleep(5000);
				driver.findElement(By.id("1")).click();

			}
		}

//		Step 6> come back to home/Parent page
		driver.switchTo().window(PID);

		driver.findElement(By.cssSelector("input[title='Save [Alt+S]']")).click();
		Thread.sleep(1000);
		String fNameField = driver.findElement(By.id("dtlview_First Name")).getText();

		if (fNameField.equals(firstName)) {
			System.out.println("Created Contect First name Successfully!!!");
		} else {
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
