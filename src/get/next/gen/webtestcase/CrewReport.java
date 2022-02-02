package get.next.gen.webtestcase;

import org.testng.annotations.Test;

import get.next.gen.utilities.EventDetailsValidation;

public class CrewReport {
	
	@Test(priority = 104)
	public void TS104_VerifyCrewReport() throws Exception {
		EventDetailsValidation.Selectapucktovieweventdetails();
		EventDetailsValidation.Checkreportvalueupdating("CREW");
		EventDetailsValidation.Selectreport("CREW");
		//Memoryused();
	}

}
