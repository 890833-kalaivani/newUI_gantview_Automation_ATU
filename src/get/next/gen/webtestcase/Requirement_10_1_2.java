package get.next.gen.webtestcase;

import get.next.gen.commonaction.CommonTest;
import get.next.gen.utilities.GanntViewHeaderFunctionality;
import get.next.gen.utilities.GanttviewPuckOptions;
import get.next.gen.utilities.Hybridview;
import get.next.gen.utilities.PuckUIPlacement;
import get.next.gen.utilities.SearchValidation;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;



public class Requirement_10_1_2 extends CommonTest {


@Test(priority = 0)
public void T01_LoginTestcase() throws Exception {
//	GanntViewHeaderFunctionality.Login();
		}


@Test(priority = 1)
public void GETNG_TC_GANTT_150_GanttviewTimerange() throws Exception {
	
	GanntViewHeaderFunctionality.Betweentimerange();
		}

/*

	@Test(priority = 1)
	public void GETNG_TC_GANTT_001_GanttviewSelection() throws Exception {
		
		GanntViewHeaderFunctionality.GanntViewSelection();
			}

	@Test(priority = 2)
	public void GETNG_TC_GANTT_027_CheckETDiconplacedoverleftecornorofpuck() throws Exception {
		
		PuckUIPlacement.updateiconoverleft();
			}
		
	@Test(priority = 3)
	public void GETNG_TC_GANTT_028_ArrivaldetailsExistance() throws Exception {
		
		PuckUIPlacement.ArrivaldetailsExistance();
			}
	
	@Test(priority = 4)
	public void GETNG_TC_GANTT_029_LinkagedetailsExistance() throws Exception {
		
		PuckUIPlacement.LinkagedetailsExistance();
			}
	
	
	@Test(priority = 5)
	public void GETNG_TC_GANTT_030_DeparturedetailsExistance() throws Exception {
		
		PuckUIPlacement.DeparturedetailsExistance();
			}
	
	@Test(priority = 4)
	public void GETNG_TC_GANTT_031_CheckArrivalstatusareinProperformat() throws Exception {
		
		PuckUIPlacement.ArrivalstatusValidation();
			}
	
	@Test(priority = 5)
	public void GETNG_TC_GANTT_032_CheckDeparturestatusareinProperformat() throws Exception {
		
		PuckUIPlacement.DeparturestatusValidation();
			}
	
	@Test(priority = 6)
	public void GETNG_TC_GANTT_075_CheckTurnFlightLinkageFormat() throws Exception {
		
		PuckUIPlacement.TurnflightLinkageValidation();
			}
	
	@Test(priority = 7)
	public void GETNG_TC_GANTT_098_ArrivalDepartureTimeformatFormat() throws Exception {
		
		PuckUIPlacement.ArrivalDepartureTimeformatFormat();
			}

@Test(priority = 8)
public void GETNG_TC_GANTT_101_DeviationValidation() throws Exception {
	
	PuckUIPlacement.DeviationValidation();
		}
	
@Test(priority = 9)
public void GETNG_TC_GANTT_103_DeviationShouldnotbemorethan999() throws Exception {
	
	PuckUIPlacement.Deviationlessthan999();
		}

@Test(priority = 9)
public void GETNG_TC_GANTT_100_ArrivalorDeparturehavenodeviation() throws Exception {
	
	PuckUIPlacement.DeviationnotPresent();
		}
		
		*/
}