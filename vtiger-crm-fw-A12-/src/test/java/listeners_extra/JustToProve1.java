
package listeners_extra;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(listeners_extra.List_Imp.class)
public class JustToProve1 {
	@Test
	public void case1() {
		Assert.assertTrue(false);
	}
}
