package get.next.gen.webtestcase;

import org.testng.annotations.Test;

import get.next.gen.utilities.EventDetailsValidation;

public class CabinReport {

	
	@Test(priority = 103)
	public void TS103_VerifyCabinReport() throws Exception {
		EventDetailsValidation.Selectapucktovieweventdetails();
		EventDetailsValidation.Checkreportvalueupdating("CABIN");
		EventDetailsValidation.Selectreport("CABIN");
		//Memoryused();
	}
	
}
