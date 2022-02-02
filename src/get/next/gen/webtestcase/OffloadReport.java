package get.next.gen.webtestcase;

import org.testng.annotations.Test;

import get.next.gen.utilities.EventDetailsValidation;

public class OffloadReport {

	
	@Test(priority = 99)
	public void TS99_VerifyOffloadReport() throws Exception {
		EventDetailsValidation.Selectapucktovieweventdetails();
		EventDetailsValidation.Checkreportvalueupdating("OFFLOAD");
		EventDetailsValidation.Selectreport("OFFLOAD");
		//Memoryused();
	}
}
