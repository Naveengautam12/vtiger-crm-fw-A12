package contacts;

import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import Base_utility.BaseClass;
import generic_utility.FileUtility;
import object_repository.ContPage;
import object_repository.HomePage;
import object_repository.NewContPage;
import object_repository.verifyContPage;

public class CreateContactTest extends BaseClass {

	@Test
	public void createContTest() throws IOException, InterruptedException {
	
	//public static void main(String[] args) throws InterruptedException, EncryptedDocumentException, IOException {

		FileUtility fUtil = new FileUtility();
		
//		Get the data from properties file
 		
		
//		String USERNAME = fUtil.getDataFromPropertiesFile("un");
//		String PASSWORD = fUtil.getDataFromPropertiesFile("pwd");
		
//		Get the data from excel file
		String fName = fUtil.getStringDataFromExcelFile("contdetalis", 11, 0);
		
		HomePage hp = new HomePage(driver);
		hp.getcontLink().click();
		Thread.sleep(2000);
		
		ContPage cp = new ContPage(driver);
		
		cp.getContPlusIcon().click();

		WebElement fNDD = cp.getfNDD();
		Select fn = new Select(fNDD);
		fn.selectByVisibleText("Mr.");
		Thread.sleep(3000);

		WebElement firstNameField = cp.getfirstNameField();
		String firstName = fName;
		firstNameField.sendKeys(firstName);
		Thread.sleep(2000);

		WebElement firstLastField = cp.getfirstLastField();
		String lastName = "kumar";
		firstLastField.sendKeys(lastName);
		Thread.sleep(2000);
		
		NewContPage ncp = new NewContPage(driver);
		
		ncp.getContPlusIcon1().click();
		
		String PID = driver.getWindowHandle();
		ncp.getContPlusIcon1().click();
		Thread.sleep(2000);

		Set<String> IDs = driver.getWindowHandles();
		Thread.sleep(2000);

		for (String i : IDs) {
			driver.switchTo().window(i);

			Thread.sleep(5000);

			if (driver.getCurrentUrl().contains("Accounts")) {
				Thread.sleep(5000);
				ncp.getOrgName().click();
				break;
			}
		}

//		Step 6> come back to home/Parent page
		driver.switchTo().window(PID);

		cp.getSavebtn().click();
		
		verifyContPage vcp = new verifyContPage(driver);
		String fNameField =vcp.getFnameField().getText();
		
		Assert.assertEquals(fNameField, firstName);
		
	}
}
