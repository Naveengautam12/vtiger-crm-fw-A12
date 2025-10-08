package generic_utility;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class WebDriverUtility {
	
	WebDriver driver;
	Actions act;
	//Select fn;
	public WebDriverUtility(WebDriver driver) {
		this.driver = driver;
		this.act = new Actions(driver);
		//this.fn = new Select((WebElement) driver);
	}

	public void openUrl() {
		driver.get("http://localhost:8888/");
	}
	public void winmax() {
		driver.manage().window().maximize();
	}
	
	public void hover(WebElement TargetElement) {
		
		act.moveToElement(TargetElement).build().perform();
	}
	
	public void rightclick(WebElement TargetElement) {
		
		act.contextClick(TargetElement).build().perform();
		
	}
	public void doubleclick(WebElement TargetElement) {
		
		act.doubleClick(TargetElement).build().perform();
	}
	
	//public void Fdropdown(WebElement TargetElement) {
		//fn.deSelectByContainsVisibleText("Mr.");
	}
	
	
	
	

