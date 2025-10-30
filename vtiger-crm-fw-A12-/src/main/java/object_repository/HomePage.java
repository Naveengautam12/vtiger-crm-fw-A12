package object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText = "Contacts")
	private WebElement contLink;
	
	@FindBy(css = "img[src='themes/softed/images/user.PNG']")
	private WebElement profilePic;
	
	@FindBy(linkText = "Sign Out")
	private WebElement signOutLink;
	
	
	
	public WebElement getSignOutLink() {
		return signOutLink;
	}
	
	public WebElement getProfilePic() {
		return profilePic;
	}
	
	public WebElement getcontLink() {
		return contLink;
	}
	
}
