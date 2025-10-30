package object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewContPage {

	public NewContPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
			
	}
	
	@FindBy(css = "img[alt='Select']")
	private WebElement ContplusIcon1;
	
	@FindBy(id = "1")
	private WebElement OrgName;
	
	
	public WebElement getOrgName() {
		return OrgName;
	}
	
	
	public WebElement getContPlusIcon1() {
		return ContplusIcon1;
	}
}
