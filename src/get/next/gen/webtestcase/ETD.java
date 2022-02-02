package get.next.gen.webtestcase;

import org.testng.annotations.Test;

import get.next.gen.utilities.PuckUIPlacement;
import get.next.gen.utilities.UpdateETD;

public class ETD {
	
	@Test(priority = 23)
	public void TS23_CheckETDiconplacedoverleft() throws Exception {
		PuckUIPlacement.updateiconoverleft("Ganttview");
		//Memoryused();
	}
	
	@Test(priority = 209)
	public void TS209_validateUpdateETD() throws Exception {
		System.out.println("TS209_validateUpdateETD");
		UpdateETD.verifyETDPost("advisoryPost");
		UpdateETD.verifyETDPost("requestToPost");
		UpdateETD.verifyErrMsg("errorMsgValidation");
	}

}
