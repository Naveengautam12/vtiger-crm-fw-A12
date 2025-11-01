package advance_reports;

import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;


import Base_utility.BaseClass;
import generic_utility.JavaUtility;

public class Sauce_Demo extends BaseClass{
	
	@Test 
	public void login1() {
		
		ExtentTest test = report.createTest("login1");
		test.log(Status.PASS, "This is passing");	
		System.out.println("logged in");
		
	}
	@Test 
	public void login2() {
		
		ExtentTest test = report.createTest("login2");
		
		test.log(Status.FAIL, "This is failed");
		System.out.println("added to cart");
		
	}
	
	@Test 
	public void login3() {
		
		ExtentTest test = report.createTest("login3");
		
		test.log(Status.WARNING, "This is warning");
		System.out.println("payment done");
		
	}
	@Test 
	public void login4() {
		
		ExtentTest test = report.createTest("login4");
		
		test.log(Status.SKIP, "This is skiped");
		
		System.out.println("logged out");
		
	}
	
	@Test
	public void takeSS() throws IOException {

		ExtentTest test = report.createTest("takeSS");

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.saucedemo.com/v1/");

		TakesScreenshot tks = (TakesScreenshot) driver;

//		File src = tks.getScreenshotAs(OutputType.FILE);
//		File dest = new File("./ad_reports/ss.png");
//		FileHandler.copy(src, dest);

//		Obtain the screenshot as base64 data.
		String ss = tks.getScreenshotAs(OutputType.BASE64);
		test.addScreenCaptureFromBase64String(ss, JavaUtility.currentTime());
		
		report.flush();
		driver.quit();
	}

}