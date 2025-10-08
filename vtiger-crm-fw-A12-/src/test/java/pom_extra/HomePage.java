package pom_extra;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	//==========Initialization =============
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(className = "app_logo")
	private WebElement logo;

	public WebElement getLogo() {
		return logo;
	}
	// =========== Declaration ===============
	
			@FindBy(xpath="//button[contains(@class, 'btn_inventory')]")
			private WebElement addToCart;
			
			@FindBy(className = "shopping_cart_link")
			private WebElement cartIcon;
			
			//================ Getters ===========
			
			public WebElement getAddToCart() {
				return addToCart;
			}
			 
			public WebElement getCartIcon() {
				return cartIcon;
			}
}
	

