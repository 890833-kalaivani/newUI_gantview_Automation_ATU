package get.next.gen.webtestcase;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import get.next.gen.commonaction.CommonTest;
import get.next.gen.utilities.DashboardFilterOptionValidation;
import get.next.gen.utilities.GanntViewHeaderFunctionality;

public class RandomTestcases  extends CommonTest {
	@Parameters({ "browser", "Environment" })	
	@Test(priority = 0)
	public void TS01_LoginTestcase(String browser, String Environment) throws Exception {
		Memoryused();
		System.out.println("url: "+Environment+"");
		GanntViewHeaderFunctionality.Login(Environment);
		DashboardFilterOptionValidation.StatsoptionExist();
		DashboardFilterOptionValidation.StatsoptionSelection();
		DashboardFilterOptionValidation.SelectAllStatistics();
		Thread.sleep(1000);
		Memoryused();
	}
}
