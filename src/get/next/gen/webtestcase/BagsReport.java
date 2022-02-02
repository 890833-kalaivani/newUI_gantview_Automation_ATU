package get.next.gen.webtestcase;

import org.testng.annotations.Test;
import get.next.gen.commonaction.CommonTest;
import get.next.gen.utilities.EventDetailsValidation;

public class BagsReport {

	@Test(priority = 102)
	public void TS102_VerifyBagsReport() throws Exception {
		EventDetailsValidation.Selectapucktovieweventdetails();
		EventDetailsValidation.Checkreportvalueupdating("BAGS");
		EventDetailsValidation.Selectreport("BAGS");
		CommonTest.Memoryused();
	}
}
