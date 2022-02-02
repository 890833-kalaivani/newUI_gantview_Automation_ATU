package get.next.gen.webtestcase;

import org.testng.annotations.Test;

import get.next.gen.utilities.EventDetailsValidation;

public class ClaimScam {

	@Test(priority = 100)
	public void TS100_VerifyClaimscanReport() throws Exception {
		EventDetailsValidation.Selectapucktovieweventdetails();
		EventDetailsValidation.Checkreportvalueupdating("CLAIMSCAN");
		EventDetailsValidation.Selectreport("CLAIMSCAN");
		//Memoryused();
	}
	
	
}
