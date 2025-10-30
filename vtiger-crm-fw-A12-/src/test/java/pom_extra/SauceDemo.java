package pom_extra;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class SauceDemo {
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.edge.driver", "./resources/msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
//		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get("https://www.saucedemo.com/v1/");

		LoginPage lp = new LoginPage(driver);

//		login
//		Declaration with initialization 
		WebElement un = lp.getUn();
		WebElement pwd = lp.getPwd();
		WebElement login = lp.getLogin();

		driver.navigate().refresh();

//		Utilization
		un.sendKeys("standard_user");
		pwd.sendKeys("secret_sauce");
		login.click();

//		verify
		HomePage hp = new HomePage(driver);
		
		
		Thread.sleep(5000);
		// add product to cart
				
				WebElement addToCart = hp.getAddToCart();
				WebElement cart = hp.getCartIcon();
				
				addToCart.click();
				cart.click();
				
				Thread.sleep(1500);
				
				// Cart page
				CartPage cp = new CartPage(driver);
				
				WebElement checkout = cp.getCheckout();
				
				checkout.click();
				
				
				// checkout 1 Page
				CheckOutOne cp1 = new CheckOutOne(driver);
				
				WebElement fname = cp1.getFname();
				WebElement lname = cp1.getLname();
				WebElement postal = cp1.getPostalCode();
				WebElement continueBtn = cp1.getContinueBtn();
				
				fname.sendKeys("Naveen");
				lname.sendKeys("Kumar");
				postal.sendKeys("201301");
				
				continueBtn.click();
				
				Thread.sleep(1000);
				

				// checkout overview - 2 page
				CheckOutTwo cp2 = new CheckOutTwo(driver);
				
				WebElement finishbtn = cp2.getFinishBtn();
				finishbtn.click();
				
				Thread.sleep(500);
				

				//  confirmation page
				ConfirmationPage confirm = new ConfirmationPage(driver);
				
				WebElement thankMsg = confirm.getThankMsg();
				
				if(thankMsg.isDisplayed())
					System.out.println("Ordered successfully");
				else
					System.out.println("Order failed");
				
				
				Thread.sleep(1500);
				
				driver.quit();
			}
	}
