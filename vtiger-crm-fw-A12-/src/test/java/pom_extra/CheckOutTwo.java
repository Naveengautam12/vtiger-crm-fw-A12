  package pom_extra;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutTwo {

	// =========== constructor ===============
		public CheckOutTwo(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}
		
		
		
		// ============== Elements ====================
		
		@FindBy(linkText = "FINISH")
		private WebElement finishBtn;
		
		
		// ============ Getters =====================
		
		public WebElement getFinishBtn() {
			return finishBtn;
		}
	
	
}
