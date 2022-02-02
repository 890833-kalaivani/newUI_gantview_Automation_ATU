package get.next.gen.webtestcase;
import get.next.gen.commonaction.CommonTest;
import get.next.gen.serviceutils.correction;
import get.next.gen.utilities.Alertingflightstatsvalidation;
import get.next.gen.utilities.CloseOut;
import get.next.gen.utilities.CustomZone;
import get.next.gen.utilities.DashboardFilterOptionValidation;
import get.next.gen.utilities.DiversonReport;
import get.next.gen.utilities.EventDetailsValidation;
import get.next.gen.utilities.FlightStatsconfirmation;
import get.next.gen.utilities.GanntViewHeaderFunctionality;
import get.next.gen.utilities.GanttviewPuckOptions;
import get.next.gen.utilities.HoverValidation;
import get.next.gen.utilities.Hybridview;
import get.next.gen.utilities.InternationalDomestic;
import get.next.gen.utilities.Lazyloading;
import get.next.gen.utilities.Multialert;
import get.next.gen.utilities.PuckColorValidation;
import get.next.gen.utilities.PuckUIPlacement;
import get.next.gen.utilities.RampopenClose;
import get.next.gen.utilities.ResetSettings;
import get.next.gen.utilities.SearchValidation;
import get.next.gen.utilities.SortFunctionalityvalidation;
import get.next.gen.utilities.UpdateETD;
import get.next.gen.utilities.consolidatedcrewreport;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import atu.testng.reports.ATUReports;
import atu.testng.reports.logging.LogAs;
public class RegressionSuite extends CommonTest {
	@Parameters({ "browser", "Environment" })	
	@Test(priority = 0)
	public void TS01_LoginTestcase(String browser, String Environment) throws Exception {
		Memoryused();
		System.out.println("url: "+Environment+"");
		GanntViewHeaderFunctionality.Login(Environment);
		DashboardFilterOptionValidation.StatsoptionExist();
		DashboardFilterOptionValidation.StatsoptionSelection();
		DashboardFilterOptionValidation.SelectAllStatistics();
		Thread.sleep(1000);
		Memoryused();
	}
	@Test(priority = 1)
	public void TS02_GanttviewSelection() throws Exception {
		GanntViewHeaderFunctionality.GanntViewSelection();
		Memoryused();
	}
	@Test(priority = 2)
	public void TS03_CancelledflightholdCXL() throws Exception {
		FlightStatsconfirmation.Cancelledflightconform("Ganttview");
		Memoryused();	
	}
	@Test(priority = 3)
	public void TS04_DelayedFlightStatsverification() throws Exception {
		FlightStatsconfirmation.DelayedDepartureconform("Ganttview");
		Memoryused();	
	}
	@Test(priority = 4)
	public void TS05_DecisionFlightStatsVerification() throws Exception {
		FlightStatsconfirmation.Decisionconform("Ganttview");
		Memoryused();
	}
	@Test(priority = 5)
	public void TS06_DivertedFlightStatsVerification() throws Exception {
		FlightStatsconfirmation.DivertedConform("Ganttview");
		Memoryused();
	}
	@Test(priority = 6)
	public void TS07_MELFlightStatsVerification() throws Exception {
		FlightStatsconfirmation.MELConform("Ganttview");
		Memoryused();
	}
	@Test(priority = 7)
	public void TS_07_MELReportuponClickingTail() throws Exception {
		FlightStatsconfirmation.MELReportVerification("Ganttview");
		Memoryused();
	}
	@Test(priority = 8)
	public void TS09_ETDFlightsStatsVerification() throws Exception {
		FlightStatsconfirmation.ETDUpdatesconform("Ganttview");
		Memoryused();
	}
	@Test(priority = 9)
	public void TS10_ACSwapsFlightStatsVerification() throws Exception {
		FlightStatsconfirmation.ACSwapConform("Ganttview");
		Memoryused();
	}
	@Test(priority = 10)
	public void TS11_GateSwapsFlightStatsVerification() throws Exception {
		FlightStatsconfirmation.GateSwapsconform("Ganttview");
		Memoryused();
	}
	@Test(priority = 11)
	public void TS12_OTSFlightStatsVerification() throws Exception {
		FlightStatsconfirmation.OTSConform("Ganttview");
		Memoryused();
	}
	@Test(priority = 12)
	public void TS13_RTDFlightStatsVerification() throws Exception {
		FlightStatsconfirmation.GroundInterruptConform("Ganttview");
		Memoryused();
	}
	@Test(priority = 13)
	public void TS048_EarlyArrivalFlightStatsVerification() throws Exception {
		FlightStatsconfirmation.Earlyarrivalsflightconform("Ganttview");
		Memoryused();
	}
	@Test(priority = 14)
	public void TS14_LateArrivalFlightStatsVerification() throws Exception {
		FlightStatsconfirmation.Latearrivalconform("Ganttview");
		Memoryused();
	}
	@Test(priority = 15)
	public void TS15_IFSFlightStatsVerification() throws Exception {
		FlightStatsconfirmation.IFSconform("Ganttview");
		Memoryused();
	}
	@Test(priority = 16)
	public void TS16_OTSReportdisplay() throws Exception {
		FlightStatsconfirmation.OTSReportdisplay("Ganttview");
		Memoryused();
	}
	@Test(priority = 17)
	public void TS17_MELReportdisplay() throws Exception {
		FlightStatsconfirmation.MELReportdisplay("Ganttview");
		Memoryused();
	}
	@Test(priority = 18)
	public void TS18_VerifyRightStartflight() throws Exception {
		FlightStatsconfirmation.Rightstartflightconform("Ganttview");
		Memoryused();
	}
	@Test(priority = 19)
	public void TS19_VerifyWeightrestricted() throws Exception {
		FlightStatsconfirmation.WeightRestrictedflightconform("Ganttview");
		Memoryused();
	}
	@Test(priority = 20)
	public void TS20_VerifyTermflight() throws Exception {
		FlightStatsconfirmation.TermFlightConform("Ganttview");
		Memoryused();
	}
	@Test(priority = 21)
	public void TS21_VerifyOriginflight() throws Exception {
		FlightStatsconfirmation.OriginFlightConform("Ganttview");
		Memoryused();
	}
	@Test(priority = 22)
	public void TS22_VerifyUnlinkedFlight() throws Exception {
		FlightStatsconfirmation.UnlinkedFlightConform("Ganttview");
		Memoryused();
	}
	///////////////////////////////////////////////////////////////////////////
	@Test(priority = 23)
	public void TS23_CheckETDiconplacedoverleft() throws Exception {
		PuckUIPlacement.updateiconoverleft("Ganttview");
		Memoryused();
	}
	@Test(priority = 24)
	public void TS24_ArrivaldetailsExistance() throws Exception {
		PuckUIPlacement.ArrivaldetailsExistance("Ganttview");
		Memoryused();
	}
	@Test(priority = 25)
	public void TS25_LinkagedetailsExistance() throws Exception {
		PuckUIPlacement.LinkagedetailsExistance("Ganttview");
		Memoryused();
	}
	@Test(priority = 26)
	public void TS26_DeparturedetailsExistance() throws Exception {
		PuckUIPlacement.DeparturedetailsExistance("Ganttview");
		Memoryused();
	}
	@Test(priority = 27)
	public void TS27_CheckArrivalstatusareinProperformat() throws Exception {
		PuckUIPlacement.ArrivalstatusValidation("Ganttview");
		Memoryused();
	}
	@Test(priority = 28)
	public void TS28_CheckDeparturestatusareinProperformat() throws Exception {
		PuckUIPlacement.DeparturestatusValidation("Ganttview");
		Memoryused();
	}
	@Test(priority = 29)
	public void TS29_CheckTurnFlightLinkageFormat() throws Exception {
		PuckUIPlacement.TurnflightLinkageValidation("Ganttview");
		Memoryused();
	}
	@Test(priority = 30)
	public void TS30_ArrivalDepartureTimeformatFormat() throws Exception {
		PuckUIPlacement.ArrivalDepartureTimeformatFormat("Ganttview");
		Memoryused();
	}
	@Test(priority = 31)
	public void TS31_DeviationValidation() throws Exception {
		PuckUIPlacement.DeviationValidation("Ganttview");
		Memoryused();
	}
	@Test(priority = 32)
	public void TS32_DeviationShouldnotbemorethan999() throws Exception {
		PuckUIPlacement.Deviationlessthan999("Ganttview");
		Memoryused();
	}
	@Test(priority = 33)
	public void TS33_ArrivalorDeparturehavenodeviation() throws Exception {
		PuckUIPlacement.DeviationnotPresent("Ganttview");
		Memoryused();
	}
	///////////////////////////////////////////////////////////////////////////////////
	@Test(priority = 34)
	public void TS34_PuckColorValidationbasedonStatus() throws Exception {
		//PuckColorValidation.PuckColorValidation("Ganttview");
	}
	/////////////////////////////////////////////////////////////////////////////////	
	@Test(priority = 35)
	public void TS35_Verifydomesticflightsonly() throws Exception {
		InternationalDomestic.Domesticflightsonly();
		Memoryused();
	}
	@Test(priority = 36)
	public void TS36_Verifyinternationflightsonly() throws Exception {
		InternationalDomestic.Internationalflightsonly();
		Memoryused();
	}
	@Test(priority = 37)
	public void TS37_VerifyExpandandcollapse() throws Exception {
		CommonTest.ExpandTest();
		CommonTest.CollapseTest();
		Memoryused();
	}
	@Test(priority = 38)
	public void TS38_Verifydifferentpucksize() throws Exception {
		GanntViewHeaderFunctionality.PuckFontSizeValidation();
		Memoryused();
	}
	@Test(priority = 39)
	public void TS39_VerifyRealtimebarExistance() throws Exception {
		GanntViewHeaderFunctionality.GanntViewSelection();
		System.out.println("Verify Realtime bar is present in the gantt view");
		GanntViewHeaderFunctionality.RealtimeBar();
		Memoryused();
	}
	@Test(priority = 40)
	public void TS40_VerifyFlightbetweentimerange() throws Exception {
		//have doubt
		//GanntViewHeaderFunctionality.Betweentimerange();
		Memoryused();
	}
	@Test(priority = 41)
	public void TS41_VerifySortGatebyAscendingorder() throws Exception {
		SortFunctionalityvalidation.SortGateAscending();
		Memoryused();
	}
	@Test(priority = 42)
	public void TS42_VerifySortGatebyDescendingorder() throws Exception {
		SortFunctionalityvalidation.SortGateDescending();
		Memoryused();
	}
	@Test(priority = 43)
	public void TS43_VerifySearchinGanttview() throws Exception {
		SearchValidation.SearchWithValidSearchkey("Ganttview");
		Memoryused();
	}
	@Test(priority = 44)
	public void TS44_VerifySearchwithinvalidkey() throws Exception {
		SearchValidation.SearchWithINValidSearchkey("Ganttview");
		Memoryused();
	}
	@Test(priority = 45)
	public void TS45_CheckHoverDetails() throws Exception {
		HoverValidation.HoverDisplayValidation();
		Memoryused();
	}
	@Test(priority = 46)
	public void TS46_ShouldShowTotalGates() throws Exception {
		//GanntViewHeaderFunctionality.ConfirmTotalGates("Ganttview");
		//Memoryused();
	}
	@Test(priority = 47)
	public void TS47_VerifyZoominZoomouticonPresence() throws Exception {
		CommonTest.zoomin();
		CommonTest.zoomOut();
		Memoryused();
	}
	@Test(priority = 48)
	public void TS48_VerifyGanttviewHeader_Offload() throws Exception {
		GanntViewHeaderFunctionality.OffloadCheck("Ganttview");
		Memoryused();
	}
	@Test(priority = 49)
	public void TS49_VerifyGanttviewHeader_ClaimScam() throws Exception {
		GanntViewHeaderFunctionality.ClaimScanCheck("Ganttview");
		Memoryused();
	}
	@Test(priority = 50)
	public void TS50_VerifyGanttviewHeader_Bags() throws Exception {
		GanntViewHeaderFunctionality.BagsCheck("Ganttview");
		Memoryused();
	}
	@Test(priority = 51)
	public void TS51_VerifyGanttviewHeader_Pax() throws Exception {
		GanntViewHeaderFunctionality.PSGRCheck("Ganttview");
		Memoryused();
	}
	@Test(priority = 52)
	public void TS52_VerifyGanttviewHeader_Crew() throws Exception {
		GanntViewHeaderFunctionality.CrewCheck("Ganttview");
		Memoryused();
	}
	@Test(priority = 53)
	public void TS53_VerifyGanttviewHeader_Cabin() throws Exception {
		GanntViewHeaderFunctionality.CabinCheck("Ganttview");
		Memoryused();
	}
	@Test(priority = 54)
	public void TS54_VerifyGanttviewHeader_Lavs() throws Exception {
		GanntViewHeaderFunctionality.LavsCheck("Ganttview");
		Memoryused();
	}
	@Test(priority = 55)
	public void TS55_VerifyGanttviewHeader_Water() throws Exception {
		GanntViewHeaderFunctionality.WaterCheck("Ganttview");
		Memoryused();
	}
	@Test(priority = 56)
	public void TS56_VerifyGanttviewHeaderFueling() throws Exception {
		GanntViewHeaderFunctionality.FuelingCheck("Ganttview");
		Memoryused();
	}
	@Test(priority = 57)
	public void TS57_VerifyGanttviewHeader_Catering() throws Exception {
		GanntViewHeaderFunctionality.CateringCheck("Ganttview");
		Memoryused();
	}
	@Test(priority = 58)
	public void TS58_VerifyGanttviewHeader_Cancelled() throws Exception {
		GanntViewHeaderFunctionality.CancelledCheck("Ganttview");
		Memoryused();
	}
	@Test(priority = 59)
	public void TS59_VerifyGanttviewHeader_ETD() throws Exception {
		GanntViewHeaderFunctionality.ETDupdatesCheck("Ganttview");
		Memoryused();
	}
	@Test(priority = 60)
	public void TS60_VerifyGanttviewHeader_MEL() throws Exception {
		GanntViewHeaderFunctionality.MELAssistanceCheck("Ganttview");
		Memoryused();
	}
	@Test(priority = 61)
	public void TS61_VerifyGanttviewHeader_OTS() throws Exception {
		GanntViewHeaderFunctionality.OTSCheck("Ganttview");
		Memoryused();
	}
	@Test(priority = 62)
	public void TS62_VerifyGanttviewHeader_RightStart() throws Exception {
		GanntViewHeaderFunctionality.RightStart("Ganttview");
		Memoryused();
	}
	@Test(priority = 63)
	public void TS63_VerifyGanttviewHeader_A14() throws Exception {
		GanntViewHeaderFunctionality.A14Check("Ganttview");
		Memoryused();
	}
	@Test(priority = 64)
	public void TS64_VerifyGanttviewHeader_Unlinked() throws Exception {
		GanntViewHeaderFunctionality.UnlinkedCheck("Ganttview");
		Memoryused();
	}
	@Test(priority = 65)
	public void TS65_VerifyGanttviewHeader_GroundInterrupt() throws Exception {
		GanntViewHeaderFunctionality.GroundInteruptCheck("Ganttview");
		Memoryused();
	}
	@Test(priority = 66)
	public void TS66_VerifyGanttviewHeader_IFS() throws Exception {
		GanntViewHeaderFunctionality.IFS("Ganttview");
		Memoryused();
	}
	@Test(priority = 67)
	public void TS71_VerifyGanttviewHeader_Diverted() throws Exception {
		GanntViewHeaderFunctionality.DivertedCheck("Ganttview");
		Memoryused();
	}
	@Test(priority = 68)
	public void TS67_VerifyGanttviewHeader_LateArrivals() throws Exception {
		GanntViewHeaderFunctionality.LateArrivalCheck("Ganttview");
		Memoryused();
	}
	@Test(priority = 69)
	public void TS68_VerifyGanttviewHeader_GateSwaps() throws Exception {
		GanntViewHeaderFunctionality.GateSwapsCheck("Ganttview");
		Memoryused();
	}
	@Test(priority = 70)
	public void TS69_VerifyGanttviewHeader_GateConflicts() throws Exception {
		GanntViewHeaderFunctionality.GateConflicts("Ganttview");
		Memoryused();
	}
	@Test(priority = 71)
	public void TS70_VerifyGanttviewHeader_Decision() throws Exception {
		GanntViewHeaderFunctionality.Decisioncheck("Ganttview");
		Memoryused();
	}
	@Test(priority = 72)
	public void TS072_VerifyGanttviewHeader_EarlyArrivals() throws Exception {
		GanntViewHeaderFunctionality.EarlyArrivalsCheck("Ganttview");
		Memoryused();
	}
	@Test(priority = 73)
	public void TS73_VerifyGanttviewHeader_ACSwaps() throws Exception {
		GanntViewHeaderFunctionality.AcSwapsCheck("Ganttview");
		Memoryused();
	}
	@Test(priority = 74)
	public void TS74_VerifyGanttviewHeader_Delayed() throws Exception {
		GanntViewHeaderFunctionality.DelayedCheck("Ganttview");
		Memoryused();
	}
	@Test(priority = 75)
	public void TS75_VerifyGanttviewHeader_ORIGIN() throws Exception {
		GanntViewHeaderFunctionality.ORIGINCheck("Ganttview");
		Memoryused();
	}
	@Test(priority = 76)
	public void TS76_VerifyGanttviewHeader_TERM() throws Exception {
		GanntViewHeaderFunctionality.TERMCheck("Ganttview");
		Memoryused();
	}
	@Test(priority = 77)
	public void TS77_VerifyGanttviewHeader_MOGT() throws Exception {
		GanntViewHeaderFunctionality.MOGTCheck("Ganttview");
		Memoryused();
	}
	@Test(priority = 78)
	public void TS78_VerifyGanttviewHeader_Offload() throws Exception {
		GanntViewHeaderFunctionality.NoOffloadDetails("Ganttview");
		Memoryused();
	}
	@Test(priority = 79)
	public void TS79_VerifyGanttviewHeader_ClaimScam() throws Exception {
		GanntViewHeaderFunctionality.NoClaimScamDetails("Ganttview");
		Memoryused();
	}
	@Test(priority = 80)
	public void TS80_VerifyGanttviewHeader_Bags() throws Exception {
		//
		GanntViewHeaderFunctionality.NoBagsDetails("Ganttview");
		Memoryused();
	}
	@Test(priority = 81)
	public void TS81_VerifyGanttviewHeader_Pax() throws Exception {
		GanntViewHeaderFunctionality.NoPaxDetails("Ganttview");
		Memoryused();
	}
	@Test(priority = 82)
	public void TS82_VerifyGanttviewHeader_Crew() throws Exception {
		GanntViewHeaderFunctionality.NoCrewDetails("Ganttview");
		Memoryused();
	}
	@Test(priority = 83)
	public void TS83_VerifyGanttviewHeader_Cabin() throws Exception {
		GanntViewHeaderFunctionality.NoCabinDetails("Ganttview");
		Memoryused();
	}
	@Test(priority = 84)
	public void TS84_VerifyGanttviewHeader_Lavs() throws Exception {
		GanntViewHeaderFunctionality.NoLavsDetails("Ganttview");
		Memoryused();
	}
	@Test(priority = 85)
	public void TS85_VerifyGanttviewHeader_Water() throws Exception {
		GanntViewHeaderFunctionality.NoWaterDetails("Ganttview");
		Memoryused();
	}
	@Test(priority = 86)
	public void TS86_VerifyGanttviewHeader_Fueling() throws Exception {
		GanntViewHeaderFunctionality.NoFuelingDetails("Ganttview");
		Memoryused();
	}
	@Test(priority = 87)
	public void TS87_VerifyGanttviewHeader_Catering() throws Exception {
		GanntViewHeaderFunctionality.NoCateringDetails("Ganttview");
		Memoryused();
	}
	@Test(priority = 88)
	public void TS88_VerifyMultipleAlerticonspresent() throws Exception {
		Alertingflightstatsvalidation.VerifyMultipleAlertsicons("Ganttview");
		Memoryused();
	}
	@Test(priority = 89)
	public void TS89_VerifyAlertingflightstatistics() throws Exception {
		//No more valid
		//	Alertingflightstatsvalidation.VerifyAlertstatspresent("Ganttview");
	}
	@Test(priority = 90)
	public void TS90_VerifyMessageforblockedSelected() throws Exception {
		Alertingflightstatsvalidation.VerifyMessagewhennoflightsforBlocked("Ganttview");
		Memoryused();
	}
	@Test(priority = 91)
	public void TS91_VerifyMessageforYellowSelected() throws Exception {
		Alertingflightstatsvalidation.VerifyMessagewhennoflightsforYellow("Ganttview");
		Memoryused();
	}
	@Test(priority = 92)
	public void TS92_VerifyMessageforTotalSelected() throws Exception {
		//Alertingflightstatsvalidation.VerifyMessagewhennoflightsforTotal("Ganttview");
		//Memoryused();
	}
	@Test(priority = 93)
	public void TS93_VerifyMessageforRedSelected() throws Exception {
		Alertingflightstatsvalidation.VerifyMessagewhennoflightsforRED("Ganttview");
		Memoryused();
	}
	@Test(priority = 94)
	public void TS94_VerifyBlockedflightinMaroon() throws Exception {
		Alertingflightstatsvalidation.VerifyBlockedhaveMaroonColor("Ganttview");
		Memoryused();
	}
	@Test(priority = 95)
	public void TS95_VerifyYellowalertflightsshownYellow() throws Exception {
		Alertingflightstatsvalidation.VerifyYellowStatshaveyellowcolor("Ganttview");
		Memoryused();
	}
	@Test(priority = 96)
	public void TS96_VerifyRedalertflightshownRed() throws Exception {
		Alertingflightstatsvalidation.VerifyRedStatshaveRedcolor("Ganttview");
		Memoryused();
	}
	@Test(priority = 97)
	public void TS97_VerifyEventdetailsPage() throws Exception {
		EventDetailsValidation.EventAlertDetailsPopupselection();
		Memoryused();
	}
	@Test(priority = 98)
	public void TS98_VerifySlideoutdatadisplayed() throws Exception {
		EventDetailsValidation.CheckContentsinSlideOut();
		Memoryused();
	}
	@Test(priority = 99)
	public void TS99_VerifyOffloadReport() throws Exception {
		EventDetailsValidation.Selectapucktovieweventdetails();
		EventDetailsValidation.Checkreportvalueupdating("OFFLOAD");
		EventDetailsValidation.Selectreport("OFFLOAD");
		Memoryused();
	}
	@Test(priority = 100)
	public void TS100_VerifyClaimscanReport() throws Exception {
		EventDetailsValidation.Selectapucktovieweventdetails();
		EventDetailsValidation.Checkreportvalueupdating("CLAIMSCAN");
		EventDetailsValidation.Selectreport("CLAIMSCAN");
		Memoryused();
	}
	@Test(priority = 101)
	public void TS101_VerifyPaxReport() throws Exception {
		EventDetailsValidation.Selectapucktovieweventdetails();
		EventDetailsValidation.Checkreportvalueupdating("PAX");
		EventDetailsValidation.Selectreport("PAX");
		Memoryused();
	}
	@Test(priority = 102)
	public void TS102_VerifyBagsReport() throws Exception {
		EventDetailsValidation.Selectapucktovieweventdetails();
		EventDetailsValidation.Checkreportvalueupdating("BAGS");
		EventDetailsValidation.Selectreport("BAGS");
		Memoryused();
	}
	@Test(priority = 103)
	public void TS103_VerifyCabinReport() throws Exception {
		EventDetailsValidation.Selectapucktovieweventdetails();
		EventDetailsValidation.Checkreportvalueupdating("CABIN");
		EventDetailsValidation.Selectreport("CABIN");
		Memoryused();
	}
	@Test(priority = 104)
	public void TS104_VerifyCrewReport() throws Exception {
		EventDetailsValidation.Selectapucktovieweventdetails();
		EventDetailsValidation.Checkreportvalueupdating("CREW");
		EventDetailsValidation.Selectreport("CREW");
		Memoryused();
	}
	@Test(priority = 105)
	public void TS105_CustomZoneCreation() throws Exception {
		CustomZone.customzonecreation();
		Memoryused();
	}
	@Test(priority = 106)
	public void TS106_CustomZonedeletion() throws Exception {
		CustomZone.customzonedeletion();
		Memoryused();
	}
	@Test(priority = 107)
	public void TS107_RampOpen() throws Exception {
		//RampopenClose.RampOpen();
	}
	@Test(priority = 108)
	public void T108_RampClose() throws Exception {
		//RampopenClose.RampClose();
	}
	@Test(priority = 109)
	public void TS109_TestmessageOn() throws Exception {
		//	RampopenClose.TestmessageOn();
	}
	@Test(priority = 110)
	public void TS110_TestmessageOFF() throws Exception {
		//RampopenClose.TestmessageOFF();
	}
	@Test(priority = 111)
	public void TS111_Verifysamestatusappliedasopen() throws Exception {
		//RampopenClose.samestatusappliedasopen();
	}
	@Test(priority = 112)
	public void TS112_Verifysamestatusappliedasclose() throws Exception {
		//RampopenClose.samestatusappliedasclose();
	}
	@Test(priority = 113)
	public void TS113_VerifyErrorMessagevalidation() throws Exception {
		//RampopenClose.Errorvalidationfortime();
	}
	@Test(priority = 114)
	public void TS114_RampYellow() throws Exception {
		//RampopenClose.RampYellow();
	}
	@Test(priority = 115)
	public void TS115_FittoScreen() throws Exception {
		PuckUIPlacement.FittoScreen();
		Memoryused();
	}
	@Test(priority = 116)
	public void TS116_Guidelines() throws Exception {
		PuckUIPlacement.Guidelines();
		Memoryused();
	}
	@Test(priority = 117)
	public void TS117_StatSelection() throws Exception {
		DashboardFilterOptionValidation.StatsoptionExist();
		DashboardFilterOptionValidation.StatsoptionSelection();
		Memoryused();
	}
	@Test(priority = 118)
	public void TS118_VerifyallStatsareSelected() throws Exception {
		DashboardFilterOptionValidation.SelectAllStatistics();
		Memoryused();
	}
	@Test(priority = 119)
	public void TS119_VerifyGanttviewpuckOption() throws Exception {
		GanttviewPuckOptions.GanttviewSettingsvalidation();
		Memoryused();
	}
	@Test(priority = 128)
	public void TS128_CheckShowETDOutside() throws Exception {
		DashboardFilterOptionValidation.CheckShowETDoutside();
		Memoryused();
	}
	@Test(priority = 129)
	public void TS129_DrawtoActualGT() throws Exception {
		DashboardFilterOptionValidation.DrawtoActualGT();
		Memoryused();
	}
	@Test(priority = 130)
	public void TS130_ValidateDayandnightmode() throws Exception {
		DashboardFilterOptionValidation.CheckDaynightenabling();
		Memoryused();
	}
	@Test(priority = 131)
	public void TS131_CheckDashboardrenamed() throws Exception {
		DashboardFilterOptionValidation.CheckDashboardrenamed();
		Memoryused();
	}
	@Test(priority = 133)
	public void TS132_CheckConsolidatedReport() throws Exception {
		String url="http://apapns43.pdc.aa.com:8080/GetNGServices/flight/getFlightsForGivenTime";
		String urlCache="http://apapns45.pdc.aa.com:8081/GetCrewCache/crew/getCrewAlertReport";
		String Stations[] = {"DFW","PHL","CLT","LAX","LGA","PIT","RDU","MIA","PHX","SFO","ORD","ABE","BOS","BPT","CHO","DTW","FRA","IAD","IAH","JFK","MAD","OGG","OKC","PHL","PIA","PIB",
				"PLS","PNS","POP","POS","PSP","PTP","PTY","PUJ","PVD","PVG","PVR","PWM","SJO","SJT","SJU","STL","STS","STT","SYD","SYR"};
		String Starttime = correction.getpasthrs("America/Chicago",6);
		String Endtime = correction.nexthrs("America/Chicago",2);
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date = new java.util.Date();
		String dateWithoutTime =dateFormat.format(date);   //"02 May 2016"; 
		String strStartTime2 = dateWithoutTime + "T" + Starttime +".737Z";
		String strEndTime2 = dateWithoutTime + "T" + Endtime +".737Z";
		for( int i = 0; i < Stations.length; i++)
		{
			String request="{\"station\":\""+Stations[i]+"\",\"startTime\":\""+strStartTime2+"\",\"endTime\":\""+strEndTime2+"\",\"gates\":[],\"allGates\":true,\"pastFlights\":true,\"transactionId\":\"UNKNOWN_00812339_PHX_1489539768116_201\"}";
			String request2="{\"station\":\""+Stations[i]+"\",\"startTime\":\""+strStartTime2+"\",\"endTime\":\""+strEndTime2+"\",\"pastFlights\":false,\"iatacode\":null,\"gates\":null,\"narrowBody\":true,\"wideBody\":true,\"internationalFlts\":true,\"domesticFlts\":true,\"alertCountsReq\":false,\"transactionId\":\"UNKNOWN-0.0.00000_00789696_DFW_1517406950252_201\"}";
			ATUReports.add("****************Request for flights for given time "+request+"  ********",  LogAs.INFO, null);
			ATUReports.add("****************Request for Consolidated crew report "+request2+"  ********",  LogAs.INFO, null);
			System.out.println(" ");
			System.out.println(Stations[i]);
			String stationname = Stations[i];
			String Alerting = correction.getAlertingstation(url, request, urlCache, request2, stationname);
			if(Alerting.contains("Null")){
			}
			else{
				CustomZone.SelectStation(stationname);
				consolidatedcrewreport.Checkconsolidatedcrewicon();
				break;
			}
		}
		Memoryused();
	}
	@Test(priority = 134)
	public void TC_402_VerifyCrewiconhavebubbleandtitle() throws Exception {
		consolidatedcrewreport.Bubbleholdcountwhencrewalerts();
		Memoryused();
	}	
	@Test(priority = 135)
	public void TS133_VerifyHeaderofCrewReport() throws Exception {
		consolidatedcrewreport.Crewreportholdsreuiredtitle();
		Memoryused();
	}
	@Test(priority = 136)
	public void TS136_CheckSortFunctionality() throws Exception {
		consolidatedcrewreport.CrewSortAscendingDescending();
		Memoryused();
	}	
	@Test(priority = 137)
	public void TS137_CheckSearchFunctionality() throws Exception {
		consolidatedcrewreport.Searchfunctionality();
		Memoryused();
	}
	@Test(priority = 138)
	public void TS138_VerifyredandyellowConnex() throws Exception {
		consolidatedcrewreport.Crewalertcoloring();
		Memoryused();
	}	
	@Test(priority = 139)
	public void TS139_Offandoutflightshouldnotpresent() throws Exception {
		consolidatedcrewreport.Offandoutflightshouldnotpresent();
		Memoryused();
	}
	@Test(priority = 140)
	public void TS140_ConnexdiffofETDETA() throws Exception {
		//	consolidatedcrewreport.ConnexdiffofETDETA();
		Memoryused();
	}
	@Test(priority = 141)
	public void TS141_Checketdlesthan360() throws Exception {
		consolidatedcrewreport.Checketdlesthan360();
		Memoryused();
	}
	/*
				@Test(priority = 142)
				public void TS404_VerifyNocrewalerting() throws Exception {
					String url="http://apapns43.pdc.aa.com:8080/GetNGServices/flight/getFlightsForGivenTime";
					String urlCache="http://apapns45.pdc.aa.com:8081/GetCrewCache/crew/getCrewAlertReport";
					String Stations[] = {"DFW","PHL","CLT","LAX","LGA","PIT","RDU","MIA","PHX","SFO","ORD","ABE","BOS","BPT","CHO","DTW","FRA","IAD","IAH","JFK","MAD","OGG","OKC","PHL","PIA","PIB",
							"PLS","PNS","POP","POS","PSP","PTP","PTY","PUJ","PVD","PVG","PVR","PWM","SJO","SJT","SJU","STL","STS","STT","SYD","SYR"};
					String Starttime = correction.getpasthrs("America/Chicago",6);
					String Endtime = correction.nexthrs("America/Chicago",2);
					DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
					java.util.Date date = new java.util.Date();
					String dateWithoutTime =dateFormat.format(date);   //"02 May 2016"; 
					String strStartTime2 = dateWithoutTime + "T" + Starttime +".737Z";
					String strEndTime2 = dateWithoutTime + "T" + Endtime +".737Z";
					for( int i = 0; i < Stations.length; i++)
					{
					String request="{\"station\":\""+Stations[i]+"\",\"startTime\":\""+strStartTime2+"\",\"endTime\":\""+strEndTime2+"\",\"gates\":[],\"allGates\":true,\"pastFlights\":true,\"transactionId\":\"UNKNOWN_00812339_PHX_1489539768116_201\"}";
					String request2="{\"station\":\""+Stations[i]+"\",\"startTime\":\""+strStartTime2+"\",\"endTime\":\""+strEndTime2+"\",\"pastFlights\":false,\"iatacode\":null,\"gates\":null,\"narrowBody\":true,\"wideBody\":true,\"internationalFlts\":true,\"domesticFlts\":true,\"alertCountsReq\":false,\"transactionId\":\"UNKNOWN-0.0.00000_00789696_DFW_1517406950252_201\"}";
					ATUReports.add("****************Request for flights for given time "+request+"  ********",  LogAs.INFO, null);
					ATUReports.add("****************Request for Consolidated crew report "+request2+"  ********",  LogAs.INFO, null);
					System.out.println(" ");
					System.out.println(Stations[i]);
					String stationname = Stations[i];
					String Alerting = correction.getAlertingstation(url, request, urlCache, request2, stationname);
					if(Alerting.contains("Null")){
						CustomZone.SelectStation(stationname);
						consolidatedcrewreport.Checkconsolidatedcrewicon();
						consolidatedcrewreport.NoCrewdetailsReportmessage();
						break;
					}
					else{
						//CustomZone.SelectStation(stationname);
						//consolidatedcrewreport.Checkconsolidatedcrewicon();
						//break;
					}
					}
					consolidatedcrewreport.closecrewreport();
				}	
	 */
	@Test(priority = 145)
	public void TS142_lastsortsave() throws Exception {
		consolidatedcrewreport.Savesortsession();
		Memoryused();
	}	
	@Test(priority = 146)
	public void TS146_CheckSlidersessionsaved() throws Exception {
		consolidatedcrewreport.CheckSliderexist();
		//	consolidatedcrewreport.Slidersessionsaved();
		Memoryused();
	}	
	@Test(priority = 147)
	public void TS147_UNCheckShowETDOutside() throws Exception {
		DashboardFilterOptionValidation.UNCheckShowETDOutside();
		Memoryused();
	}
	@Test(priority = 148)
	public void TS148_DonotshowGuidelines() throws Exception {
		PuckUIPlacement.DonotshowGuidelines();
		Memoryused();
	}
	@Test(priority = 149)
	public void TS149_DonotdisplayDrawtoActualGT() throws Exception {
		DashboardFilterOptionValidation.DonotdisplayDrawtoActualGT();
		Memoryused();
	}
	@Test(priority = 150)
	public void TS150_Atlasiconinslideout() throws Exception {
		EventDetailsValidation.Atlasiconexistance();
		Memoryused();
	}
	@Test(priority = 151)
	public void TS151_VerifyGanttviewHeaderAtlasGalley() throws Exception {
		GanntViewHeaderFunctionality.AtlasCheck("Ganttview");
		Memoryused();
	}
	@Test(priority = 152)
	public void TS152_VerifySortArrivaltimeAscending() throws Exception {
		//	SortFunctionalityvalidation.SortArrivaltimeAscending();
		//	Memoryused();
	}
	@Test(priority = 153)
	public void TS153_VerifySortArrivaltimeDescending() throws Exception {
		//	SortFunctionalityvalidation.SortArrivaltimeDescending();
		//		Memoryused();
	}
	@Test(priority = 154)
	public void TS154_VerifySortDeparturetimeAscending() throws Exception {
		//	SortFunctionalityvalidation.SortDeparturetimeAscending();
		//Memoryused();
	}
	@Test(priority = 155)
	public void TS155_VerifySortDeparturetimeDescending() throws Exception {
		//	SortFunctionalityvalidation.SortDeparturetimeDescending();
		//	Memoryused();
	}
	@Test(priority = 156)
	public void TS156_VerifySortAscendingbyarrivalstatus() throws Exception {
		//SortFunctionalityvalidation.SortAscendingbyarrivalstatus();
		//Memoryused();
	}
	@Test(priority = 157)
	public void TS157_SortDescendingbyarrivalstatus() throws Exception {
		//SortFunctionalityvalidation.SortDescendingbyarrivalstatus();
		//Memoryused();
	}
	@Test(priority = 158)
	public void TS158_VerifySortAscendingbyDeparturestatus() throws Exception {
		//SortFunctionalityvalidation.SortAscendingbyDeparturestatus();
		//Memoryused();
	}
	@Test(priority = 159)
	public void TS159_VerifySortDescendingbyDeparturestatus() throws Exception {
		//SortFunctionalityvalidation.SortDescendingbyDeparturestatus();
		//Memoryused();
	}
	/*
										@Test(priority = 169)
										public void T1000_Memoryusage() throws Exception {
											ArrayList<Long> Memoryvalues = new ArrayList<Long>();	
											ArrayList<Long> Memoryvalues1 = new ArrayList<Long>();
											for(int lp =0;lp<=53;lp++){
											//	System.out.println(">>......  "+lp);	
												//ATUReports.add(">>......  "+lp, LogAs.PASSED, null); 
												try{
													//Wait 5 minutes
											Thread.sleep(300000);
											System.out.println(">>......");
											ATUReports.add(">>......", LogAs.PASSED, null); 
											Long mem = Memoryused();
											Memoryvalues.add(mem);
											GanntViewHeaderFunctionality.Selectview("Ganntview");
											//Wait 5 minutes
											Thread.sleep(300000);
											System.out.println(">>...");
											ATUReports.add(">>......", LogAs.PASSED, null); 
											Long mem2 = Memoryused();
											Memoryvalues.add(mem2);
											GanntViewHeaderFunctionality.Selectview("Hybridview");
												launchApp(Web_UI.Url);
												Thread.sleep(5000);
												for(int lp1 =0;lp1<=19;lp1++){
													//	System.out.println(">>......  "+lp);	
														//ATUReports.add(">>......  "+lp, LogAs.PASSED, null); 
															//Wait 5 minutes
													Thread.sleep(300000);
													System.out.println(">>......");
													ATUReports.add(">>......", LogAs.PASSED, null); 
													Long mem3 = Memoryused();
													Memoryvalues.add(mem2);
													GanntViewHeaderFunctionality.Selectview("Ganntview");
													//Wait 5 minutes
													Thread.sleep(300000);
													System.out.println(">>...");
													ATUReports.add(">>......", LogAs.PASSED, null); 
													Long mem4 = Memoryused();
													Memoryvalues.add(mem2);
													GanntViewHeaderFunctionality.Selectview("Hybridview");
														}
												}
														catch(Exception ed){
													}
											}
											ATUReports.add(Memoryvalues.toString(), LogAs.PASSED, null); 
											Exportmemoryvalue(Memoryvalues);
										}
	 */
	/*			
										@Test(priority = 161)
										 public void TS161_Tarmacgreaterthan15Validation() throws Exception{
											/*US671614
	 * Below script will check the response have tarmac report greater than 15 and check its been displayed under appropriate objects in service
	 */
	//			String url="http://apapns86.pdc.aa.com:8080/GetNGServices/report/getTarmacReport";
	//			String urlCache="http://apapns86.pdc.aa.com:8080/GetNGServices/report/getTarmacReport";
	//			String Stations[] = {"DFW","PHL"};
	//												String Stations[] = {"DFW","PHL","LAX","ABE","ABI","ABQ","ACT","AEX","AGS","AGU","AKL","ALB","ALO","AMA","AMS","ANC","ANU","ART","ATH","ATL","AUA","AUS","AVL","AVP","AZO","BAQ","BCN","BDA","BDL","BFI","BFL","BFM","BGI","BGR","BHM","BIS","BJX","BMI","BNA","BOG","BOI","BOS","BPT","BRO","BSB","BTR","BTV","BUF","BUR","BWI","BZE","BZN","CAE","CAK","CAP",
	//													"CCS","CDG","CFG","CHA","CHO","CHS","CID","CKB","CLE","CLL","CLO","CLT","CMH","CMI","CMW","CNF","COS","COU","CRP","CRW","CUN","CUR","CUU","CVG","CWA","CYS","CZM",
	//													"DAB","DAY","DBQ","DCA","DEN","DRO","DSM","DTW","DUB","EDI","ELH","ELP","ERI","EUG","EVV","EWN","EWR","EYW","EZE","FAR","FAT","FAY","FCO","FDF","FLG","FLL","FLO",
	//													"FNT","FPO","FRA","FSD","FSM","FWA","GCK","GCM","GDL","GEG","GGG","GGT","GIG","GJT","GLA","GND","GNV","GPT","GRB","GRI","GRK","GRR","GRU","GSO","GSP","GUA","GUS",
	//													"GYE","HAV","HHH","HKG","HMO","HND","HNL","HOG","HOU","HPN","HSV","HTS","HVN","IAD","IAH","ICT","IFP","ILM","IND","IPT","ISP","ITH","JAN","JAX","JFK","JLN",
	//													"KIN","KOA","LAN","LAS","LAW","LBB","LCH","LEX","LFT","LGA","LGB","LHR","LIH","LIM","LIR","LIS","LIT","LPB","LRD","LSE","LYH","MAD","MAF","MAN","MAO","MAR","MBJ",
	//													"MCI","MCO","MDE","MDT","MEI","MEM","MEX","MFE","MGA","MGM","MHH","MHK","MHT","MIA","MKE","MLB","MLI","MLM","MLU","MOB","MQT","MRY","MSN","MSP","MSY","MTJ","MTY",
	//													"MUC","MVD","MXP","MYR","MZT","NAS","NRT","OAJ","OAK","OGG","OKC","OMA","ONT","ORD","ORF","PAP","PBC","PBI","PDX","PEK","PGV","PHF","PHL","PHX","PIA","PIB","PIT",
	//													"PLS","PNS","POP","POS","PSP","PTP","PTY","PUJ","PVD","PVG","PVR","PWM","QRO","RAP","RDM","RDU","RFD","RIC","RME","RNO","ROA","ROC","ROW","RST","RSW","RTB",
	//													"SAF","SAL","SAN","SAP","SAT","SAV","SBA","SBP","SBY","SCE","SCL","SDF","SDQ","SEA","SFO","SGF","SGU","SHV","SJC","SJD","SJO","SJT","SJU","SKB","SLC","SLP",
	//													"SMF","SNA","SNN","SNU","SPI","SPS","SRQ","STI","STL","STS","STT","STX","SUX","SWF","SWO","SXM","SYD","SYR","TGU","TLH","TOL","TPA","TRC","TRI","TUL","TUS","TVC",
	//													"TXK","TYR","TYS","UIO","UVF","VCE","VPS","VRA","VVI","XNA","YOW","YUL","YUM","YVR","YYC","YYZ","ZCL","ZIH","ZRH","ZSA"};
	//	for( int i = 0; i < Stations.length; i++)
	//		{	
	//			String sta = Stations[i];
	//		System.out.println("station   :"+ sta);
	//			String request="{\"station\": \""+sta+"\"}";
	//			correction.Tarmacgreaterthan15startcode(url,request,urlCache,sta);
	//	}	
	//}
	//		@Test(priority = 162)
	//		 public void TS162_Checktarmacdescendingorder() throws Exception{
	/*US671614
	 * Below script will check the response have tarmac report greater than 15 and check its been displayed under appropriate objects in service
	 */
	///				String url="http://apapns86.pdc.aa.com:8080/GetNGServices/report/getTarmacReport";
	//				String urlCache="http://apapns86.pdc.aa.com:8080/GetNGServices/report/getTarmacReport";
	//				String Stations[] = {"DFW","PHL"};
	//	String Stations[] = {"DFW","PHL","LAX","ABE","ABI","ABQ","ACT","AEX","AGS","AGU","AKL","ALB","ALO","AMA","AMS","ANC","ANU","ART","ATH","ATL","AUA","AUS","AVL","AVP","AZO","BAQ","BCN","BDA","BDL","BFI","BFL","BFM","BGI","BGR","BHM","BIS","BJX","BMI","BNA","BOG","BOI","BOS","BPT","BRO","BSB","BTR","BTV","BUF","BUR","BWI","BZE","BZN","CAE","CAK","CAP",
	//			"CCS","CDG","CFG","CHA","CHO","CHS","CID","CKB","CLE","CLL","CLO","CLT","CMH","CMI","CMW","CNF","COS","COU","CRP","CRW","CUN","CUR","CUU","CVG","CWA","CYS","CZM",
	//				"DAB","DAY","DBQ","DCA","DEN","DRO","DSM","DTW","DUB","EDI","ELH","ELP","ERI","EUG","EVV","EWN","EWR","EYW","EZE","FAR","FAT","FAY","FCO","FDF","FLG","FLL","FLO",
	//				"FNT","FPO","FRA","FSD","FSM","FWA","GCK","GCM","GDL","GEG","GGG","GGT","GIG","GJT","GLA","GND","GNV","GPT","GRB","GRI","GRK","GRR","GRU","GSO","GSP","GUA","GUS",
	//				"GYE","HAV","HHH","HKG","HMO","HND","HNL","HOG","HOU","HPN","HSV","HTS","HVN","IAD","IAH","ICT","IFP","ILM","IND","IPT","ISP","ITH","JAN","JAX","JFK","JLN",
	//				"KIN","KOA","LAN","LAS","LAW","LBB","LCH","LEX","LFT","LGA","LGB","LHR","LIH","LIM","LIR","LIS","LIT","LPB","LRD","LSE","LYH","MAD","MAF","MAN","MAO","MAR","MBJ",
	//				"MCI","MCO","MDE","MDT","MEI","MEM","MEX","MFE","MGA","MGM","MHH","MHK","MHT","MIA","MKE","MLB","MLI","MLM","MLU","MOB","MQT","MRY","MSN","MSP","MSY","MTJ","MTY",
	//			"MUC","MVD","MXP","MYR","MZT","NAS","NRT","OAJ","OAK","OGG","OKC","OMA","ONT","ORD","ORF","PAP","PBC","PBI","PDX","PEK","PGV","PHF","PHL","PHX","PIA","PIB","PIT",
	//				"PLS","PNS","POP","POS","PSP","PTP","PTY","PUJ","PVD","PVG","PVR","PWM","QRO","RAP","RDM","RDU","RFD","RIC","RME","RNO","ROA","ROC","ROW","RST","RSW","RTB",
	//				"SAF","SAL","SAN","SAP","SAT","SAV","SBA","SBP","SBY","SCE","SCL","SDF","SDQ","SEA","SFO","SGF","SGU","SHV","SJC","SJD","SJO","SJT","SJU","SKB","SLC","SLP",
	//				"SMF","SNA","SNN","SNU","SPI","SPS","SRQ","STI","STL","STS","STT","STX","SUX","SWF","SWO","SXM","SYD","SYR","TGU","TLH","TOL","TPA","TRC","TRI","TUL","TUS","TVC",
	//				"TXK","TYR","TYS","UIO","UVF","VCE","VPS","VRA","VVI","XNA","YOW","YUL","YUM","YVR","YYC","YYZ","ZCL","ZIH","ZRH","ZSA"};
	//		for( int i = 0; i < Stations.length; i++)
	//			{	
	//				String sta = Stations[i];
	//				System.out.println("station   :"+ sta);
	//			String request="{\"station\": \""+sta+"\"}";
	//			correction.CheckTarmacdescending(url,request,urlCache,sta);
	//		}	
	//}
	@Test(priority = 171)
	public void TS171_VerifyGanttCount_MEL() throws Exception {
		Lazyloading.VerifyStatsCount(Web_UI.MEL,"MEL",Web_UI.MELStatsCount);
	}
	@Test(priority = 172)
	public void TS172_VerifyGanttCount_Offload() throws Exception {
		Lazyloading.VerifyStatsCount(Web_UI.Offload,"Offload",Web_UI.OffloadStatsCount);
		Memoryused();
	}
	@Test(priority = 173)
	public void TS173_VerifyGanttCount_ClaimScam() throws Exception {
		Lazyloading.VerifyStatsCount(Web_UI.Claimscan,"Claimscan",Web_UI.ClaimscanStatsCount);
		Memoryused();
	}
	@Test(priority = 174)
	public void TS174_VerifyGanttCount_Bags() throws Exception {
		Lazyloading.VerifyStatsCount(Web_UI.Bags,"Bags",Web_UI.BagsStatsCount);
		Memoryused();
	}
	@Test(priority = 175)
	public void TS175_VerifyGanttCount_Pax() throws Exception {
		Lazyloading.VerifyStatsCount(Web_UI.Passanger,"Passanger",Web_UI.PassangerStatsCount);
		Memoryused();
	}
	@Test(priority = 176)
	public void TS176_VerifyGanttCount_Crew() throws Exception {
		Lazyloading.VerifyStatsCount(Web_UI.Crew,"Crew",Web_UI.CrewStatsCount);
		Memoryused();
	}
	@Test(priority = 177)
	public void TS177_VerifyGanttCount_Cabin() throws Exception {
		Lazyloading.VerifyStatsCount(Web_UI.Cabin,"Cabin",Web_UI.CabinStatsCount);
		Memoryused();
	}
	@Test(priority = 178)
	public void TS178_VerifyGanttCount_Lavs() throws Exception {
		Lazyloading.VerifyStatsCount(Web_UI.LAV,"LAV",Web_UI.LavsStatsCount);
		Memoryused();
	}
	@Test(priority = 179)
	public void TS179_VerifyGanttCount_Water() throws Exception {
		Lazyloading.VerifyStatsCount(Web_UI.Water,"Water",Web_UI.WaterStatsCount);
		Memoryused();
	}
	@Test(priority = 180)
	public void TS180_VerifyGanttCount_Fueling() throws Exception {
		Lazyloading.VerifyStatsCount(Web_UI.Fuel,"MEL",Web_UI.FuelStatsCount);
		Memoryused();
	}
	@Test(priority = 181)
	public void TS181_VerifyGanttCount_Catering() throws Exception {
		Lazyloading.VerifyStatsCount(Web_UI.Catering,"Catering",Web_UI.CateringStatsCount);
		Memoryused();
	}
	@Test(priority = 182)
	public void TS182_VerifyGanttCount_Cancelled() throws Exception {
		Lazyloading.VerifyStatsCount(Web_UI.Canceled,"Canceled",Web_UI.CancelledStatsCount);
		Memoryused();
	}
	@Test(priority = 183)
	public void TS183_VerifyGanttCount_ETD() throws Exception {
		Lazyloading.VerifyStatsCount(Web_UI.ETD,"ETD",Web_UI.ETDStatsCount);
		Memoryused();
	}
	@Test(priority = 184)
	public void TS184_VerifyGanttCount_OTS() throws Exception {
		Lazyloading.VerifyStatsCount(Web_UI.OTS,"OTS",Web_UI.OTSStatsCount);
		Memoryused();
	}
	@Test(priority = 185)
	public void TS185_VerifyGanttCount_RightStart() throws Exception {
		//Lazyloading.VerifyStatsCount(Web_UI.RightStart,"RightStart",Web_UI.RightstartStatsCount);
		//	Memoryused();
	}
	@Test(priority = 186)
	public void TS186_VerifyGanttCount_A14() throws Exception {
		Lazyloading.VerifyStatsCount(Web_UI.A14,"A14",Web_UI.A14StatsCount);
		Memoryused();
	}
	@Test(priority = 187)
	public void TS187_VerifyGanttCount_Unlinked() throws Exception {
		Lazyloading.VerifyStatsCount(Web_UI.Unlinked,"Unlinked",Web_UI.UnlinkedCount);
		Memoryused();
	}
	@Test(priority = 188)
	public void TS188_VerifyGanttCount_IFS() throws Exception {
		Lazyloading.VerifyStatsCount(Web_UI.IFS,"IFS",Web_UI.IFSStatsCount);
		Memoryused();
	}
	@Test(priority = 189)
	public void TS189_VerifyGanttCount_Diverted() throws Exception {
		Lazyloading.VerifyStatsCount(Web_UI.Diverted,"Diverted",Web_UI.DivertedStatsCount);
		Memoryused();
	}
	@Test(priority = 190)
	public void TS190_VerifyGanttCount_LateArrivals() throws Exception {
		Lazyloading.VerifyStatsCount(Web_UI.LateArrival,"LateArrival",Web_UI.LateArrivaStatsCount);
		Memoryused();
	}
	@Test(priority = 191)
	public void TS191_VerifyGanttCount_GateSwaps() throws Exception {
		Lazyloading.VerifyStatsCount(Web_UI.GateSwaps,"GateSwaps",Web_UI.GateSwapsStatsCount);
		Memoryused();
	}
	@Test(priority = 192)
	public void TS192_VerifyGanttCount_GateConflicts() throws Exception {
		//Lazyloading.VerifyStatsCount(Web_UI.GateConflicts,"GateConflicts",Web_UI.GateConflictsStatsCount);
		//	Memoryused();
	}
	@Test(priority = 193)
	public void TS193_VerifyGanttCount_Decision() throws Exception {
		Lazyloading.VerifyStatsCount(Web_UI.Decision,"Decision",Web_UI.DecisionStatsCount);
		Memoryused();
	}
	@Test(priority = 194)
	public void TS194_VerifyGanttCount_EarlyArrivals() throws Exception {
		Lazyloading.VerifyStatsCount(Web_UI.EarlyArrival,"EarlyArrival",Web_UI.EarlyArrivalStatsCount);
		Memoryused();
	}
	@Test(priority = 195)
	public void TS195_VerifyGanttCount_ACSwaps() throws Exception {
		//Lazyloading.VerifyStatsCount(Web_UI.ACSwaps,"ACSwaps",Web_UI.ACSwapsStatsCount);
		//Memoryused();
	}
	@Test(priority = 196)
	public void TS196_VerifyGanttCount_Delayed() throws Exception {
		Lazyloading.VerifyStatsCount(Web_UI.Delayed,"Delayed",Web_UI.DelayedStatsCount);
		Memoryused();
	}
	@Test(priority = 197)
	public void TS197_VerifyGanttCount_ORIGIN() throws Exception {
		//Lazyloading.VerifyStatsCount(Web_UI.Origin,"Origin",Web_UI.OriginCount);
		//	Memoryused();
	}
	@Test(priority = 198)
	public void TS198_VerifyGanttCount_TERM() throws Exception {
		Lazyloading.VerifyStatsCount(Web_UI.Term,"Term",Web_UI.TermCount);
		Memoryused();
	}
	@Test(priority = 199)
	public void TS199_Closeoutflightsselection() throws Exception {
		CloseOut.SelectCloseout();
		Memoryused();
	}
	@Test(priority = 200)
	public void TS200_UnCloseoutflightsselection() throws Exception {
		CloseOut.UnSelectCloseout();
		Memoryused();
	}
	@Test(priority = 201)
	public void TS201_Verifywhennocloseoutflights() throws Exception {
		Alertingflightstatsvalidation.VerifyMessagewhennoflightsforCloseout("Ganttview");
		Memoryused();
	}
	@Test(priority = 202)
	public void TS202_VerifyGanttviewHeader_Closeout() throws Exception {
		GanntViewHeaderFunctionality.CloseoutCheck("Ganttview");
		Memoryused();
	}
	@Test(priority = 203)
	public void TS203_Verifycloseoutflightisshown() throws Exception {
		CloseOut.shouldshowcloseoutonly();
		Memoryused();
	}
	@Test(priority = 204)
	public void TS204_Verifycloseoutnotshownforschandoffflts() throws Exception {
		CloseOut.ShouldnotshowClosoutexceptoutstatus();
		Memoryused();
	}
	@Test(priority = 205)
	public void TS205_VerifyMessagecloseoutclicked() throws Exception {
		CloseOut.ShouldnotshowClosoutexceptoutstatus();
		Memoryused();
	}		
	@Test(priority = 206)
	public void TS206_Resetsettingsvalidation() throws Exception {
		ResetSettings.Validate_resetsettings();
	}
	@Test(priority = 207)
	public void TS207_ValidateMultialert() throws Exception {
		Multialert.Checkmultialertpresent();
		Multialert.Checkeventmultialertpresent();
	}
	@Test(priority = 208)
	public void TS208_ValidateMultialertpriority() throws Exception {
		System.out.println("TS208_ValidateMultialertpriority");
		Multialert.Checkmultialertpriority();
	}
	@Test(priority = 209)
	public void TS209_validateUpdateETD() throws Exception {
		System.out.println("TS209_validateUpdateETD");
		UpdateETD.verifyETDPost("advisoryPost");
		UpdateETD.verifyETDPost("requestToPost");
		UpdateETD.verifyErrMsg("errorMsgValidation");
	}
	@Test(priority = 210)
	public void TS210_divReport_IsDisplayed() throws Exception {
		System.out.println("TS210_divReport_IsDisplayed");
		DiversonReport.divReport_IsDisplayed();
	}
	@Test(priority = 211)
	public void TS211_divReport_wideBodyIconVerification() throws Exception {
		System.out.println("TS210_divReport_IsDisplayed");
		DiversonReport.divReport_IsDisplayed();
		DiversonReport.divReport_wideBodyIconVerification();
	}
	@Test(priority = 212)
	public void TS212_divReport_InternationalFlagVerfication() throws Exception {
		System.out.println("TS210_divReport_IsDisplayed");
		DiversonReport.divReport_IsDisplayed();
		DiversonReport.divReport_InternationalFlagVerfication();
	}
	@Test(priority = 213)
	public void TS213_divReport_generateReport() throws Exception {
		System.out.println("TS210_divReport_IsDisplayed");
		DiversonReport.divReport_IsDisplayed();
		DiversonReport.divReport_generateReport();
	}
	@Test(priority = 214)
	public void TS214_divReport_createUpdateETD() throws Exception {
		System.out.println("TS210_divReport_IsDisplayed");
		DiversonReport.divReport_IsDisplayed();
		DiversonReport.divReport_createUpdateETD();
	}
	@Test(priority = 215)
	public void TS215_divReport_EnteringNotes() throws Exception {
		System.out.println("TS210_divReport_IsDisplayed");
		DiversonReport.divReport_IsDisplayed();
		DiversonReport.divReport_EnteringNotes();
	}
	@Test(priority = 216)
	public void TS216_divReport_compareFltNumOfEnhancedviewVsClassicViewWithoutIncludingSwim() throws Exception {
		System.out.println("TS210_divReport_IsDisplayed");
		DiversonReport.divReport_IsDisplayed();
		DiversonReport.divReport_compareFltNumOfEnhancedviewVsClassicViewWithoutIncludingSwim();
	}
	@Test(priority = 217)
	public void TS217_verifySaveBtnDisabledForOFFFLightsAndEnabledForOtherStatusInClassicViewm() throws Exception {
		System.out.println("TS210_divReport_IsDisplayed");
		DiversonReport.divReport_IsDisplayed();
		DiversonReport.verifySaveBtnDisabledForOFFFLightsAndEnabledForOtherStatusInClassicView();
	}
	@Test(priority = 218)
	public void TS218_verifyPETActions() throws Exception {
		System.out.println("TS210_divReport_IsDisplayed");
		DiversonReport.divReport_IsDisplayed();
		DiversonReport.verifyPETActions();
	}
	@Test(priority = 219)
	public void TS219_petDisabledForOffStatusFlights() throws Exception {
		System.out.println("TS210_divReport_IsDisplayed");
		DiversonReport.divReport_IsDisplayed();
		DiversonReport.petDisabledForOffStatusFlights();
	}
	@Test(priority = 220)
	public void TS220_verifyGanttViewInLocal() throws Exception {
		System.out.println("TS210_divReport_IsDisplayed");
		DiversonReport.divReport_IsDisplayed();
		DiversonReport.verifyGanttViewInLocal();
	}
	@Test(priority = 221)
	public void TS221_VerifyGanttCount_Inop() throws Exception {
		Lazyloading.VerifyStatsCount(Web_UI.Inop,"Inop",Web_UI.InopStatsCount);
		Memoryused();
	}
	
	@Test(priority = 250)
	public void TS200_VerifyLogout() throws Exception {
		CommonTest.Logout();
		Memoryused();
	}
}
