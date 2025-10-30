package testng_extra;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Demo2 {
	@Test(priority = -1)
	public void create() {
		
		System.out.println("baby");
	}
	
	@Test
	public void modify() {
		Assert.assertTrue(false);
		System.out.println("boy");
	}
	@Test(priority =1)
	public void delete() {
		
		System.out.println("delete boy");
	}
}
