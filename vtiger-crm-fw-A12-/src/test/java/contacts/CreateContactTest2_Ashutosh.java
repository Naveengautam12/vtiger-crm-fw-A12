package contacts;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

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


import generic_utility.WebDriverUtility;

public class CreateContactTest2_Ashutosh {

		public static void main(String[] args) throws InterruptedException, EncryptedDocumentException, IOException {
			
//			Get data from properties file
//			1. Get the java representation of the physical file
				FileInputStream fis = new FileInputStream("./src/test/resources/CommonData.properties");
				
//			2. Use the load() of Properties class to load all the keys
				Properties pObj = new Properties();
				pObj.load(fis);
				
//			3. Use the getProperty(key) and pass the key and get the value in String format
//				String Browser = pObj.getProperty("bro");
				String URL = pObj.getProperty("url");
				String UserName = pObj.getProperty("un");
				String PassWord = pObj.getProperty("pwd");
			
//			Get the data from an excel file
			FileInputStream fisExcel = new FileInputStream("./src/test/resources/testScriptData.xlsx");

			Workbook wb = WorkbookFactory.create(fisExcel);
			Sheet sh = wb.getSheet("Contacts");
			
			// LastName
			Row rowLastName = sh.getRow(4);
			Cell cellLastName = rowLastName.getCell(1);
			String valueLastName = cellLastName.getStringCellValue();
			
			// Title
			Row rowTitle = sh.getRow(4);
			Cell cellTitle = rowTitle.getCell(2);
			String valueTitle = cellTitle.getStringCellValue();
			
			//Department
			Row rowDepartment = sh.getRow(4);
			Cell cellDepartment = rowDepartment.getCell(3);
			String valueDepartment = cellDepartment.getStringCellValue();
			
			
//			Open Browser 
			WebDriver driver = new ChromeDriver();
			WebDriverUtility wdUtil = new WebDriverUtility(driver);
			wdUtil.winmax();
//			wdUtil.waitForPageLoad();

//			Login
			driver.get(URL);

			WebElement username = driver.findElement(By.name("user_name"));
			username.sendKeys(UserName);
			WebElement password = driver.findElement(By.name("user_password"));
			password.sendKeys(PassWord);

			driver.findElement(By.id("submitButton")).click();
			Thread.sleep(3000);
//	      Move to Contacts		
			driver.findElement(By.linkText("Contacts")).click();
//			click on add contacts button

			driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
			WebElement leadSource = driver.findElement(By.name("leadsource"));
			leadSource.click();

			WebElement leadSourceValue = driver.findElement(By.xpath("//option[@value='Self Generated']"));
			leadSourceValue.click();

			driver.findElement(By.name("lastname")).sendKeys(valueLastName);

			Thread.sleep(3000);
			WebElement titleField = driver.findElement(By.id("title"));
			String title = valueTitle;
			titleField.sendKeys(title);
			
			WebElement departmentField = driver.findElement(By.id("department"));
			String department = valueDepartment;
			departmentField.sendKeys(department);

			Thread.sleep(3000);
//			Save
			driver.findElement(By.cssSelector("input[title='Save [Alt+S]']")).click();

//			Verification

			String actDept = driver.findElement(By.id("dtlview_Department")).getText();
			if (actDept.equals(department))
				System.out.println("Department uploaded correctly");
			else
				System.out.println("LeadSource Not uploaded correctly");

			String actTitle = driver.findElement(By.id("dtlview_Title")).getText();
			if (actTitle.equals(title))
				System.out.println("Title uploaded correctly");
			else
				System.out.println("Title not uploaded correctly");
			
	WebElement profilePic = driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));
			
			wdUtil.hover(profilePic);
			
			Thread.sleep(2000);
			driver.findElement(By.linkText("Sign Out")).click();
			
			Thread.sleep(3000);
			driver.quit();

		}
	}
	

