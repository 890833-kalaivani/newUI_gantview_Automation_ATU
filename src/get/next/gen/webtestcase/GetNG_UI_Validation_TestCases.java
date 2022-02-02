package get.next.gen.webtestcase;

import org.testng.annotations.Test;

import get.next.gen.commonaction.CommonTest;
import get.next.gen.utilities.GanntViewHeaderFunctionality;

public class GetNG_UI_Validation_TestCases {
	@Test(priority = 37)
	public void TS37_VerifyExpandandcollapse() throws Exception {
		CommonTest.ExpandTest();
		CommonTest.CollapseTest();
		//Memoryused();
	}
	
	@Test(priority = 48)
	public void TS48_VerifyGanttviewHeader_Offload() throws Exception {
		GanntViewHeaderFunctionality.OffloadCheck("Ganttview");
		CommonTest.Memoryused();
	}
	@Test(priority = 49)
	public void TS49_VerifyGanttviewHeader_ClaimScam() throws Exception {
		GanntViewHeaderFunctionality.ClaimScanCheck("Ganttview");
		CommonTest.Memoryused();
	}
	@Test(priority = 50)
	public void TS50_VerifyGanttviewHeader_Bags() throws Exception {
		GanntViewHeaderFunctionality.BagsCheck("Ganttview");
		CommonTest.Memoryused();
	}
	@Test(priority = 51)
	public void TS51_VerifyGanttviewHeader_Pax() throws Exception {
		GanntViewHeaderFunctionality.PSGRCheck("Ganttview");
		CommonTest.Memoryused();
	}
	@Test(priority = 52)
	public void TS52_VerifyGanttviewHeader_Crew() throws Exception {
		GanntViewHeaderFunctionality.CrewCheck("Ganttview");
		CommonTest.Memoryused();
	}
	@Test(priority = 53)
	public void TS53_VerifyGanttviewHeader_Cabin() throws Exception {
		GanntViewHeaderFunctionality.CabinCheck("Ganttview");
		CommonTest.Memoryused();
	}
	@Test(priority = 54)
	public void TS54_VerifyGanttviewHeader_Lavs() throws Exception {
		GanntViewHeaderFunctionality.LavsCheck("Ganttview");
		CommonTest.Memoryused();
	}
	@Test(priority = 55)
	public void TS55_VerifyGanttviewHeader_Water() throws Exception {
		GanntViewHeaderFunctionality.WaterCheck("Ganttview");
		CommonTest.Memoryused();
	}
	@Test(priority = 56)
	public void TS56_VerifyGanttviewHeaderFueling() throws Exception {
		GanntViewHeaderFunctionality.FuelingCheck("Ganttview");
		CommonTest.Memoryused();
	}
	@Test(priority = 57)
	public void TS57_VerifyGanttviewHeader_Catering() throws Exception {
		GanntViewHeaderFunctionality.CateringCheck("Ganttview");
		CommonTest.Memoryused();
	}
	@Test(priority = 58)
	public void TS58_VerifyGanttviewHeader_Cancelled() throws Exception {
		GanntViewHeaderFunctionality.CancelledCheck("Ganttview");
		CommonTest.Memoryused();
	}
	@Test(priority = 59)
	public void TS59_VerifyGanttviewHeader_ETD() throws Exception {
		GanntViewHeaderFunctionality.ETDupdatesCheck("Ganttview");
		CommonTest.Memoryused();
	}
	@Test(priority = 60)
	public void TS60_VerifyGanttviewHeader_MEL() throws Exception {
		GanntViewHeaderFunctionality.MELAssistanceCheck("Ganttview");
		CommonTest.Memoryused();
	}
	@Test(priority = 61)
	public void TS61_VerifyGanttviewHeader_OTS() throws Exception {
		GanntViewHeaderFunctionality.OTSCheck("Ganttview");
		CommonTest.Memoryused();
	}
	@Test(priority = 62)
	public void TS62_VerifyGanttviewHeader_RightStart() throws Exception {
		GanntViewHeaderFunctionality.RightStart("Ganttview");
		CommonTest.Memoryused();
	}
	@Test(priority = 63)
	public void TS63_VerifyGanttviewHeader_A14() throws Exception {
		GanntViewHeaderFunctionality.A14Check("Ganttview");
		CommonTest.Memoryused();
	}
	@Test(priority = 64)
	public void TS64_VerifyGanttviewHeader_Unlinked() throws Exception {
		GanntViewHeaderFunctionality.UnlinkedCheck("Ganttview");
		CommonTest.Memoryused();
	}
	@Test(priority = 65)
	public void TS65_VerifyGanttviewHeader_GroundInterrupt() throws Exception {
		GanntViewHeaderFunctionality.GroundInteruptCheck("Ganttview");
		CommonTest.Memoryused();
	}
	@Test(priority = 66)
	public void TS66_VerifyGanttviewHeader_IFS() throws Exception {
		GanntViewHeaderFunctionality.IFS("Ganttview");
		CommonTest.Memoryused();
	}
	@Test(priority = 67)
	public void TS71_VerifyGanttviewHeader_Diverted() throws Exception {
		GanntViewHeaderFunctionality.DivertedCheck("Ganttview");
		CommonTest.Memoryused();
	}
	@Test(priority = 68)
	public void TS67_VerifyGanttviewHeader_LateArrivals() throws Exception {
		GanntViewHeaderFunctionality.LateArrivalCheck("Ganttview");
		CommonTest.Memoryused();
	}
	@Test(priority = 69)
	public void TS68_VerifyGanttviewHeader_GateSwaps() throws Exception {
		GanntViewHeaderFunctionality.GateSwapsCheck("Ganttview");
		CommonTest.Memoryused();
	}
	@Test(priority = 70)
	public void TS69_VerifyGanttviewHeader_GateConflicts() throws Exception {
		GanntViewHeaderFunctionality.GateConflicts("Ganttview");
		CommonTest.Memoryused();
	}
	@Test(priority = 71)
	public void TS70_VerifyGanttviewHeader_Decision() throws Exception {
		GanntViewHeaderFunctionality.Decisioncheck("Ganttview");
		CommonTest.Memoryused();
	}
	@Test(priority = 72)
	public void TS072_VerifyGanttviewHeader_EarlyArrivals() throws Exception {
		GanntViewHeaderFunctionality.EarlyArrivalsCheck("Ganttview");
		CommonTest.Memoryused();
	}
	@Test(priority = 73)
	public void TS73_VerifyGanttviewHeader_ACSwaps() throws Exception {
		GanntViewHeaderFunctionality.AcSwapsCheck("Ganttview");
		CommonTest.Memoryused();
	}
	@Test(priority = 74)
	public void TS74_VerifyGanttviewHeader_Delayed() throws Exception {
		GanntViewHeaderFunctionality.DelayedCheck("Ganttview");
		CommonTest.Memoryused();
	}
	@Test(priority = 75)
	public void TS75_VerifyGanttviewHeader_ORIGIN() throws Exception {
		GanntViewHeaderFunctionality.ORIGINCheck("Ganttview");
		CommonTest.Memoryused();
	}
	@Test(priority = 76)
	public void TS76_VerifyGanttviewHeader_TERM() throws Exception {
		GanntViewHeaderFunctionality.TERMCheck("Ganttview");
		CommonTest.Memoryused();
	}
	@Test(priority = 77)
	public void TS77_VerifyGanttviewHeader_MOGT() throws Exception {
		GanntViewHeaderFunctionality.MOGTCheck("Ganttview");
		CommonTest.Memoryused();
	}
	@Test(priority = 78)
	public void TS78_VerifyGanttviewHeader_Offload() throws Exception {
		GanntViewHeaderFunctionality.NoOffloadDetails("Ganttview");
		CommonTest.Memoryused();
	}
	@Test(priority = 79)
	public void TS79_VerifyGanttviewHeader_ClaimScam() throws Exception {
		GanntViewHeaderFunctionality.NoClaimScamDetails("Ganttview");
		CommonTest.Memoryused();
	}
	@Test(priority = 80)
	public void TS80_VerifyGanttviewHeader_Bags() throws Exception {
		//
		GanntViewHeaderFunctionality.NoBagsDetails("Ganttview");
		CommonTest.Memoryused();
	}
	@Test(priority = 81)
	public void TS81_VerifyGanttviewHeader_Pax() throws Exception {
		GanntViewHeaderFunctionality.NoPaxDetails("Ganttview");
		CommonTest.Memoryused();
	}
	@Test(priority = 82)
	public void TS82_VerifyGanttviewHeader_Crew() throws Exception {
		GanntViewHeaderFunctionality.NoCrewDetails("Ganttview");
		CommonTest.Memoryused();
	}
	@Test(priority = 83)
	public void TS83_VerifyGanttviewHeader_Cabin() throws Exception {
		GanntViewHeaderFunctionality.NoCabinDetails("Ganttview");
		CommonTest.Memoryused();
	}
	@Test(priority = 84)
	public void TS84_VerifyGanttviewHeader_Lavs() throws Exception {
		GanntViewHeaderFunctionality.NoLavsDetails("Ganttview");
		CommonTest.Memoryused();
	}
	@Test(priority = 85)
	public void TS85_VerifyGanttviewHeader_Water() throws Exception {
		GanntViewHeaderFunctionality.NoWaterDetails("Ganttview");
		CommonTest.Memoryused();
	}
	@Test(priority = 86)
	public void TS86_VerifyGanttviewHeader_Fueling() throws Exception {
		GanntViewHeaderFunctionality.NoFuelingDetails("Ganttview");
		CommonTest.Memoryused();
	}
	@Test(priority = 87)
	public void TS87_VerifyGanttviewHeader_Catering() throws Exception {
		GanntViewHeaderFunctionality.NoCateringDetails("Ganttview");
		CommonTest.Memoryused();
	}

}
