package get.next.gen.webtestcase;

import org.testng.annotations.Test;

import get.next.gen.utilities.InternationalDomestic;

public class GetNG_Settings {
	
	@Test(priority = 35)
	public void TS35_Verifydomesticflightsonly() throws Exception {
		InternationalDomestic.Domesticflightsonly();
		//Memoryused();
	}
	@Test(priority = 36)
	public void TS36_Verifyinternationflightsonly() throws Exception {
		InternationalDomestic.Internationalflightsonly();
		//Memoryused();
	}

}
