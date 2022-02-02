package get.next.gen.webtestcase;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import get.next.gen.commonaction.CommonTest;
import get.next.gen.utilities.GanntViewHeaderFunctionality;
import get.next.gen.utilities.TwistApplication;

public class Twist_TestCases extends CommonTest {
	@Parameters({ "browser", "Environment" })
	@Test(priority = 0)
	public void TS01_LoginTestcase(String browser, String Environment) throws Exception {
		System.out.println("url: " + Environment + "");
		GanntViewHeaderFunctionality.loginOtherThanGetNG(Environment);
		//TwistApplication.verifyTwistAppDisplaysGMTTime();
		TwistApplication.verifyETDUpdate();
	}

}
