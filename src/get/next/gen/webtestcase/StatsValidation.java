package get.next.gen.webtestcase;

import org.testng.annotations.Test;
import get.next.gen.commonaction.CommonTest;
import get.next.gen.utilities.GanntViewHeaderFunctionality;
import get.next.gen.utilities.FlightStatsconfirmation;

public class StatsValidation {

	@Test(priority = 2)
	public void TS03_CancelledflightholdCXL() throws Exception {
		FlightStatsconfirmation.Cancelledflightconform("Ganttview");
		//Memoryused();	
	}
	@Test(priority = 3)
	public void TS04_DelayedFlightStatsverification() throws Exception {
		FlightStatsconfirmation.DelayedDepartureconform("Ganttview");
		//Memoryused();	
	}
	@Test(priority = 4)
	public void TS05_DecisionFlightStatsVerification() throws Exception {
		FlightStatsconfirmation.Decisionconform("Ganttview");
		//Memoryused();
	}
	@Test(priority = 5)
	public void TS06_DivertedFlightStatsVerification() throws Exception {
		FlightStatsconfirmation.DivertedConform("Ganttview");
		//Memoryused();
	}
	@Test(priority = 6)
	public void TS07_MELFlightStatsVerification() throws Exception {
		FlightStatsconfirmation.MELConform("Ganttview");
		//Memoryused();
	}
	@Test(priority = 7)
	public void TS_07_MELReportuponClickingTail() throws Exception {
		FlightStatsconfirmation.MELReportVerification("Ganttview");
		//Memoryused();
	}
	@Test(priority = 8)
	public void TS09_ETDFlightsStatsVerification() throws Exception {
		FlightStatsconfirmation.ETDUpdatesconform("Ganttview");
		//Memoryused();
	}
	@Test(priority = 9)
	public void TS10_ACSwapsFlightStatsVerification() throws Exception {
		FlightStatsconfirmation.ACSwapConform("Ganttview");
		//Memoryused();
	}
	@Test(priority = 10)
	public void TS11_GateSwapsFlightStatsVerification() throws Exception {
		FlightStatsconfirmation.GateSwapsconform("Ganttview");
		//Memoryused();
	}
	@Test(priority = 11)
	public void TS12_OTSFlightStatsVerification() throws Exception {
		FlightStatsconfirmation.OTSConform("Ganttview");
		//Memoryused();
	}
	@Test(priority = 12)
	public void TS13_RTDFlightStatsVerification() throws Exception {
		FlightStatsconfirmation.GroundInterruptConform("Ganttview");
		//Memoryused();
	}
	@Test(priority = 13)
	public void TS048_EarlyArrivalFlightStatsVerification() throws Exception {
		FlightStatsconfirmation.Earlyarrivalsflightconform("Ganttview");
		//Memoryused();
	}
	@Test(priority = 14)
	public void TS14_LateArrivalFlightStatsVerification() throws Exception {
		FlightStatsconfirmation.Latearrivalconform("Ganttview");
		//Memoryused();
	}
	@Test(priority = 15)
	public void TS15_IFSFlightStatsVerification() throws Exception {
		FlightStatsconfirmation.IFSconform("Ganttview");
		//Memoryused();
	}
	@Test(priority = 16)
	public void TS16_OTSReportdisplay() throws Exception {
		FlightStatsconfirmation.OTSReportdisplay("Ganttview");
		//Memoryused();
	}
	@Test(priority = 17)
	public void TS17_MELReportdisplay() throws Exception {
		FlightStatsconfirmation.MELReportdisplay("Ganttview");
		//Memoryused();
	}
	@Test(priority = 18)
	public void TS18_VerifyRightStartflight() throws Exception {
		FlightStatsconfirmation.Rightstartflightconform("Ganttview");
		//Memoryused();
	}
	@Test(priority = 19)
	public void TS19_VerifyWeightrestricted() throws Exception {
		FlightStatsconfirmation.WeightRestrictedflightconform("Ganttview");
		//Memoryused();
	}
	@Test(priority = 20)
	public void TS20_VerifyTermflight() throws Exception {
		FlightStatsconfirmation.TermFlightConform("Ganttview");
		//Memoryused();
	}
	@Test(priority = 21)
	public void TS21_VerifyOriginflight() throws Exception {
		FlightStatsconfirmation.OriginFlightConform("Ganttview");
		//Memoryused();
	}
	@Test(priority = 22)
	public void TS22_VerifyUnlinkedFlight() throws Exception {
		FlightStatsconfirmation.UnlinkedFlightConform("Ganttview");
		//Memoryused();
	}

	
}
