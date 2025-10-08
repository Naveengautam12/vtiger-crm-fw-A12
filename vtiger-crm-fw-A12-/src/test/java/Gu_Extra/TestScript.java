package Gu_Extra;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import generic_utility.WebDriverUtility;


public class TestScript {
	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		WebDriverUtility wdUtil = new WebDriverUtility(driver);
		wdUtil.openUrl();
		
		wdUtil.winmax();
	//	driver.manage().window().maximize();
		
		
		WebElement profilePic = driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));
		//Actions act = new Actions(driver);
		//act.moveToElement(profilePic).build().perform();
		
		wdUtil.hover(profilePic);
		
		//WebElement fNDD = driver.findElement(By.cssSelector("select[name='salutationtype']"));
		//Select fn = new Select(fNDD);
		//fn.selectByContainsVisibleText("Mr.");
		
		//wdUtil.Fdropdown(fNDD);
		
		
		
		
		
	}
	
	
}
