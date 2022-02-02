package get.next.gen.webtestcase;

import org.testng.annotations.Test;

import get.next.gen.utilities.EventDetailsValidation;

public class PaxReport {
	
	@Test(priority = 101)
	public void TS101_VerifyPaxReport() throws Exception {
		EventDetailsValidation.Selectapucktovieweventdetails();
		EventDetailsValidation.Checkreportvalueupdating("PAX");
		EventDetailsValidation.Selectreport("PAX");
		//Memoryused();
	}

}
