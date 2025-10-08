package organization;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CreateOrganizationTest {

	public static void main(String[] args) throws InterruptedException, EncryptedDocumentException, IOException {
		
		 FileInputStream fis = new FileInputStream("./src/test/resources/ContectTestScript.xlsx");
			
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sh = wb.getSheet("org");
			Row row = sh.getRow(5);
			Cell cell = row.getCell(0);
			String orgName1 = cell.getStringCellValue() + (int)(Math.random()*1000);
		wb.close();
		
		
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
		driver.findElement(By.linkText("Organizations")).click();
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("img[alt='Create Organization...']")).click();
		
		WebElement orgField = driver.findElement(By.name("accountname"));
		
		String orgName  =orgName1;
		
		orgField.sendKeys(orgName);
		Thread.sleep(5000);
		driver.findElement(By.cssSelector("input[title='Save [Alt+S]']")).click();
		Thread.sleep(3000);
		String actorgName = driver.findElement(By.id("dtlview_Organization Name")).getText();
		
		if(actorgName.equals(orgName)) {
			System.out.println("Created Organization Successfully!!!");
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
