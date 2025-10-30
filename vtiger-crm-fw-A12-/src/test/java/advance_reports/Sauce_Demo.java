package advance_reports;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Sauce_Demo {
	@Test 
	public void login() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get("https://www.saucedemo.com/v1/");
		
		ExtentSparkReporter spark = new ExtentSparkReporter("./ad_reports/rep2.html");
		spark.config().setDocumentTitle("sauce demo");
		spark.config().setReportName("Second Report");
		spark.config().setTheme(Theme.DARK);
		
		ExtentReports report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("Browser", "Chrome");
		report.setSystemInfo("OS", "Window");
		report.setSystemInfo("UserName", "standard_user");
		
		ExtentTest test = report.createTest("login");
		
		test.log(Status.PASS, "This is passing");
		
		report.flush();
		
		driver.quit();
	}
}