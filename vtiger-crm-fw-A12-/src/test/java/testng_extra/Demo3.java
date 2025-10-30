package testng_extra;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Demo3 {
	@Test
	public void create() {
		
		System.out.println("baby");
	}
	
	@Test(dependsOnMethods ="create")
	public void modify() {
		Assert.assertTrue(false);
		System.out.println("baby -> boy");
	}
	@Test(dependsOnMethods = "modify")
	public void delete() {
		
		System.out.println("delete boy");
	}
}
