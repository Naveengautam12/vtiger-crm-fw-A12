package object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContPage {

	public ContPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "img[alt='Create Contact...']")
	private WebElement contPlusIcon;
	
	
	@FindBy(css = "select[name='salutationtype']")
	private WebElement fNDD;
	
	@FindBy(name = "firstname")
	private WebElement firstNameField;
	
	@FindBy(name = "lastname")
	private WebElement firstLastField;
	
	@FindBy(css = "input[title='Save [Alt+S]']")
	private WebElement savebtn;
	
	
	
	public WebElement getSavebtn() {
		return savebtn;
	}
	
	public WebElement getfirstLastField() {
		return firstLastField;
		
	}
	
	public WebElement getfirstNameField() {
		return firstNameField;
	}
	
	public WebElement getfNDD() {
		return fNDD;
	}

	public WebElement getContPlusIcon() {
		return contPlusIcon;
	}
	
	
	
	
}
