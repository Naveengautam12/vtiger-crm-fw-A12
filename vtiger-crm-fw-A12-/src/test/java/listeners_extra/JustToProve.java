package listeners_extra;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(listeners_extra.List_Imp.class)
public class JustToProve {

	@BeforeSuite
	public void bs() {
		System.out.println("i am @beforesuite");
	}
	@BeforeTest
	public void precon() {
		System.out.println("pre conditon");
	}
	@BeforeClass
	public void openbro() {
		System.out.println("open browser");
	}
	
	@BeforeMethod
	public void login() {
		System.out.println("login");
	}
	
	@Test
	public void  case1() {
		System.out.println("Test Method");
	}
	
	@AfterMethod
	public void logout() {
		System.out.println("logout");
	}
	@AfterClass
	public void closebro() {
		System.out.println("close browser");
	}
	
	@AfterTest
	public void  postcon() {
		System.out.println("post conditon");
	}
	
	@AfterSuite
	public void as() {
		System.out.println("i am @aftersuite");
	}
}
