package object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class verifyContPage {

	public verifyContPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
			
	}
	
	@FindBy(id = "dtlview_First Name")
	private WebElement fNameField;
	
	
	public WebElement getFnameField() {
		return fNameField;
	}
	
	
}
