package get.next.gen.webtestcase;

import get.next.gen.commonaction.CommonTest;
import get.next.gen.utilities.DashboardFilterOptionValidation;
import get.next.gen.utilities.FlightStatsconfirmation;
import get.next.gen.utilities.GanntViewHeaderFunctionality;
import get.next.gen.utilities.GanttviewPuckOptions;
import get.next.gen.utilities.Hybridview;




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



public class Requirement_10_3_2 extends CommonTest {


@Test(priority = 0)
public void T01_LoginTestcase() throws Exception {
	//GanntViewHeaderFunctionality.Login();
		}


	@Test(priority = 1)
	public void GETNG_TC_GANTT_001_GanttviewSelection() throws Exception {

		GanntViewHeaderFunctionality.GanntViewSelection();
		
		//Need to write common function to set Center aligned puck
			}
//////////////////////////////////////////////////////////////////////////////////////
	
	@Test(priority = 2)
	public void GETNG_TC_GANTT_037_CancelledflightholdCXL() throws Exception {
		
		FlightStatsconfirmation.Cancelledflightconform("Gantt");
			}

	@Test(priority = 3)
	public void GETNG_TC_GANTT_038_DelayedFlightStatsverification() throws Exception {
		
		FlightStatsconfirmation.DelayedDepartureconform("Gantt");
			}

	@Test(priority = 4)
	public void GETNG_TC_GANTT_039_DecisionFlightStatsVerification() throws Exception {
		
		FlightStatsconfirmation.Decisionconform("Gantt");
			}
	
	@Test(priority = 5)
	public void GETNG_TC_GANTT_040_DivertedFlightStatsVerification() throws Exception {
		
		FlightStatsconfirmation.DivertedConform("Gantt");
			}
	
	@Test(priority = 6)
	public void GETNG_TC_GANTT_041_MELFlightStatsVerification() throws Exception {
		
		FlightStatsconfirmation.MELConform("Gantt");
			}
	
	@Test(priority = 7)
	public void GETNG_TC_GANTT_042_MELReportuponClickingTail() throws Exception {
		
		FlightStatsconfirmation.MELReportVerification("Gantt");
			}
	
	@Test(priority = 8)
	public void GETNG_TC_GANTT_043_ETDFlightsStatsVerification() throws Exception {
		
		FlightStatsconfirmation.ETDUpdatesconform("Gantt");
			}
	
	
	@Test(priority = 9)
	public void GETNG_TC_GANTT_044_ACSwapsFlightStatsVerification() throws Exception {
		
		FlightStatsconfirmation.ACSwapConform("Gantt");
			}
	
	@Test(priority = 10)
	public void GETNG_TC_GANTT_045_GateSwapsFlightStatsVerification() throws Exception {
		
		FlightStatsconfirmation.GateSwapsconform("Gantt");
			}
	
	@Test(priority = 11)
	public void GETNG_TC_GANTT_046_OTSFlightStatsVerification() throws Exception {
		
		FlightStatsconfirmation.OTSConform("Gantt");
		
			}
	
	@Test(priority = 12)
	public void GETNG_TC_GANTT_047_RTDFlightStatsVerification() throws Exception {
		
		FlightStatsconfirmation.GroundInterruptConform("Gantt");
		
			}
	
	@Test(priority = 13)
	public void GETNG_TC_GANTT_048_EarlyArrivalFlightStatsVerification() throws Exception {
		
		FlightStatsconfirmation.Earlyarrivalsflightconform("Gantt");
		
			}
	@Test(priority = 14)
	public void GETNG_TC_GANTT_049_LateArrivalFlightStatsVerification() throws Exception {
		
		FlightStatsconfirmation.Latearrivalconform("Gantt");
		
			}
	
	@Test(priority = 15)
	public void GETNG_TC_GANTT_050_IFSFlightStatsVerification() throws Exception {
		
		FlightStatsconfirmation.IFSconform("Gantt");
		
			}
	
	@Test(priority = 16)
	public void GETNG_TC_GANTT_051_OTSReportdisplay() throws Exception {
		
		FlightStatsconfirmation.OTSReportdisplay("Gantt");
		
			}
	
//	@Test(priority = 17)
//	public void GETNG_TC_GANTT_081_MELReportdisplay() throws Exception {
//		
//		FlightStatsconfirmation.MELReportdisplay();
//		
//			}
			
}