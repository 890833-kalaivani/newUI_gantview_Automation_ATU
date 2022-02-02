package get.next.gen.webtestcase;

import get.next.gen.commonaction.CommonTest;
import get.next.gen.utilities.Alertingflightstatsvalidation;
import get.next.gen.utilities.CloseOut;
import get.next.gen.utilities.CustomZone;
import get.next.gen.utilities.DashboardFilterOptionValidation;
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
import get.next.gen.utilities.consolidatedcrewreport;

import java.io.IOException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;




public class HybridSuite extends CommonTest {
	
	
	
@Parameters({ "browser", "Environment" })	
@Test(priority = 0)
public void TS01_LoginTestcase(String browser, String Environment) throws Exception {
	GanntViewHeaderFunctionality.Login(Environment);
		}

	@Test(priority = 1)
	public void TS02_HybridViewSelection() throws Exception {
	
		Hybridview.HybridviewSelection();
		
			}
	
	@Test(priority = 2)
	public void TS03_CancelledflightholdCXL() throws Exception {
			//FlightStatsconfirmation.Cancelledflightconform("Ganttview");
			FlightStatsconfirmation.Cancelledflightconform("Hybridview");
			}

	
	@Test(priority = 3)
	public void TS04_DelayedFlightStatsverification() throws Exception {
			//FlightStatsconfirmation.DelayedDepartureconform("Ganttview");
			FlightStatsconfirmation.DelayedDepartureconform("Hybridview");
			}

	@Test(priority = 4)
	public void TS05_DecisionFlightStatsVerification() throws Exception {
			//FlightStatsconfirmation.Decisionconform("Ganttview");
			FlightStatsconfirmation.Decisionconform("Hybridview");
			}
	
	@Test(priority = 5)
	public void TS06_DivertedFlightStatsVerification() throws Exception {
		//FlightStatsconfirmation.DivertedConform("Ganttview");
			FlightStatsconfirmation.DivertedConform("Hybridview");
			}
	
	@Test(priority = 6)
	public void TS07_MELFlightStatsVerification() throws Exception {
		//FlightStatsconfirmation.MELConform("Ganttview");
				FlightStatsconfirmation.MELConform("Hybridview");
			}
	
	@Test(priority = 7)
	public void TS_07_MELReportuponClickingTail() throws Exception {
		//FlightStatsconfirmation.MELReportVerification("Ganttview");
				FlightStatsconfirmation.MELReportVerification("Hybridview");
			}
	
	@Test(priority = 8)
	public void TS09_ETDFlightsStatsVerification() throws Exception {
		
		//FlightStatsconfirmation.ETDUpdatesconform("Ganttview");
		FlightStatsconfirmation.ETDUpdatesconform("Hybridview");
			}
	
	
	@Test(priority = 9)
	public void TS10_ACSwapsFlightStatsVerification() throws Exception {
		
		//FlightStatsconfirmation.ACSwapConform("Ganttview");
		FlightStatsconfirmation.ACSwapConform("Hybridview");
			}
	
	@Test(priority = 10)
	public void TS11_GateSwapsFlightStatsVerification() throws Exception {
	
		//FlightStatsconfirmation.GateSwapsconform("Ganttview");
		FlightStatsconfirmation.GateSwapsconform("Hybridview");
			}
	
	@Test(priority = 11)
	public void TS12_OTSFlightStatsVerification() throws Exception {
		
		//FlightStatsconfirmation.OTSConform("Ganttview");
		FlightStatsconfirmation.OTSConform("Hybridview");
			}
	
	@Test(priority = 12)
	public void TS13_RTDFlightStatsVerification() throws Exception {
		
		//FlightStatsconfirmation.GroundInterruptConform("Ganttview");
		FlightStatsconfirmation.GroundInterruptConform("Hybridview");
			}
	
	@Test(priority = 13)
	public void TS048_EarlyArrivalFlightStatsVerification() throws Exception {
		
		//FlightStatsconfirmation.Earlyarrivalsflightconform("Ganttview");
		FlightStatsconfirmation.Earlyarrivalsflightconform("Hybridview");
			}
	@Test(priority = 14)
	public void TS14_LateArrivalFlightStatsVerification() throws Exception {
		
		//FlightStatsconfirmation.Latearrivalconform("Ganttview");
		FlightStatsconfirmation.Latearrivalconform("Hybridview");
			}
	
	@Test(priority = 15)
	public void TS15_IFSFlightStatsVerification() throws Exception {
		
		//FlightStatsconfirmation.IFSconform("Ganttview");
		FlightStatsconfirmation.IFSconform("Hybridview");
			}
	
	@Test(priority = 16)
	public void TS16_OTSReportdisplay() throws Exception {
		
		//FlightStatsconfirmation.OTSReportdisplay("Ganttview");
		FlightStatsconfirmation.OTSReportdisplay("Hybridview");
			}
	
	@Test(priority = 17)
	public void TS17_MELReportdisplay() throws Exception {
		
		//FlightStatsconfirmation.MELReportdisplay("Ganttview");
		FlightStatsconfirmation.MELReportdisplay("Hybridview");
			}
			
	
	@Test(priority = 18)
	public void TS18_VerifyRightStartflight() throws Exception {
		
		//FlightStatsconfirmation.Rightstartflightconform("Ganttview");
		FlightStatsconfirmation.Rightstartflightconform("Hybridview");
			}
	
	
	@Test(priority = 19)
	public void TS19_VerifyWeightrestricted() throws Exception {
		
		//FlightStatsconfirmation.WeightRestrictedflightconform("Ganttview");
		FlightStatsconfirmation.WeightRestrictedflightconform("Hybridview");
			}
	
	@Test(priority = 20)
	public void TS20_VerifyTermflight() throws Exception {
		
		//FlightStatsconfirmation.TermFlightConform("Ganttview");
		FlightStatsconfirmation.TermFlightConform("Hybridview");
			}
	
	@Test(priority = 21)
	public void TS21_VerifyOriginflight() throws Exception {
		
		//FlightStatsconfirmation.OriginFlightConform("Ganttview");
			FlightStatsconfirmation.OriginFlightConform("Hybridview");
			}
	
	@Test(priority = 22)
	public void TS22_VerifyUnlinkedFlight() throws Exception {
		
		//FlightStatsconfirmation.UnlinkedFlightConform("Ganttview");
			FlightStatsconfirmation.UnlinkedFlightConform("Hybridview");
			}
	
	///////////////////////////////////////////////////////////////////////////
	
	@Test(priority = 23)
	public void TS23_CheckETDiconplacedoverleftecornorofpuck() throws Exception {
		//CommonTest.Selectview("Ganttview");
		//PuckUIPlacement.updateiconoverleft("Ganttview");
			CommonTest.Selectview("Hybridview");
			PuckUIPlacement.updateiconoverleft("Hybridview");
			}
		
	@Test(priority = 24)
	public void TS24_ArrivaldetailsExistance() throws Exception {
		//CommonTest.Selectview("Ganttview");
		//PuckUIPlacement.ArrivaldetailsExistance("Ganttview");
			CommonTest.Selectview("Hybridview");
			PuckUIPlacement.ArrivaldetailsExistance("Hybridview");
			}
	
	@Test(priority = 25)
	public void TS25_LinkagedetailsExistance() throws Exception {
		//CommonTest.Selectview("Ganttview");
		//PuckUIPlacement.LinkagedetailsExistance("Ganttview");
		CommonTest.Selectview("Hybridview");
		PuckUIPlacement.LinkagedetailsExistance("Hybridview");
			}

	@Test(priority = 26)
	public void TS26_DeparturedetailsExistance() throws Exception {
		//CommonTest.Selectview("Ganttview");
		//PuckUIPlacement.DeparturedetailsExistance("Ganttview");
		CommonTest.Selectview("Hybridview");
		PuckUIPlacement.DeparturedetailsExistance("Hybridview");
			}
	
	@Test(priority = 27)
	public void TS27_CheckArrivalstatusareinProperformat() throws Exception {
		//CommonTest.Selectview("Ganttview");
		//PuckUIPlacement.ArrivalstatusValidation("Ganttview");
		CommonTest.Selectview("Hybridview");
		PuckUIPlacement.ArrivalstatusValidation("Hybridview");
			}
	
	@Test(priority = 28)
	public void TS28_CheckDeparturestatusareinProperformat() throws Exception {
		//CommonTest.Selectview("Ganttview");
		//PuckUIPlacement.DeparturestatusValidation("Ganttview");
		CommonTest.Selectview("Hybridview");
		PuckUIPlacement.DeparturestatusValidation("Hybridview");
			}
	
	@Test(priority = 29)
	public void TS29_CheckTurnFlightLinkageFormat() throws Exception {
		//CommonTest.Selectview("Ganttview");
		//PuckUIPlacement.TurnflightLinkageValidation("Ganttview");
		CommonTest.Selectview("Hybridview");
		PuckUIPlacement.TurnflightLinkageValidation("Hybridview");
			}
	
	@Test(priority = 30)
	public void TS30_ArrivalDepartureTimeformatFormat() throws Exception {
		//CommonTest.Selectview("Ganttview");
		//PuckUIPlacement.ArrivalDepartureTimeformatFormat("Ganttview");
		CommonTest.Selectview("Hybridview");
		PuckUIPlacement.ArrivalDepartureTimeformatFormat("Hybridview");
			}

@Test(priority = 31)
public void TS31_DeviationValidation() throws Exception {
	//CommonTest.Selectview("Ganttview");
	//PuckUIPlacement.DeviationValidation("Ganttview");
	CommonTest.Selectview("Hybridview");
	PuckUIPlacement.DeviationValidation("Hybridview");
		}
	
@Test(priority = 32)
public void TS32_DeviationShouldnotbemorethan999() throws Exception {
	//CommonTest.Selectview("Ganttview");
	//PuckUIPlacement.Deviationlessthan999("Ganttview");
	CommonTest.Selectview("Hybridview");
	PuckUIPlacement.Deviationlessthan999("Hybridview");
		}

@Test(priority = 33)
public void TS33_ArrivalorDeparturehavenodeviation() throws Exception {
	//CommonTest.Selectview("Ganttview");
	//PuckUIPlacement.DeviationnotPresent("Ganttview");
	CommonTest.Selectview("Hybridview");
	PuckUIPlacement.DeviationnotPresent("Hybridview");
		}

@Test(priority = 34)
public void TS34_PuckColorValidationbasedonStatus() throws Exception {
	//CommonTest.Selectview("Ganttview");
	//PuckColorValidation.PuckColorValidation("Ganttview");
	CommonTest.Selectview("Hybridview");
	PuckColorValidation.PuckColorValidation("Hybridview");
		}
	
	
@Test(priority = 35)
public void TS35_Verifydomesticflightsonly() throws Exception {
	//CommonTest.Selectview("Ganttview");
	//InternationalDomestic.Domesticflightsonly();
	CommonTest.Selectview("Hybridview");
	InternationalDomestic.Domesticflightsonly();
		}

@Test(priority = 36)
public void TS36_Verifyinternationflightsonly() throws Exception {
	//CommonTest.Selectview("Ganttview");
	//InternationalDomestic.Internationalflightsonly();
	CommonTest.Selectview("Hybridview");
	InternationalDomestic.Internationalflightsonly();
		}
		

@Test(priority = 38)
public void TS38_Verifydifferentpucksize() throws Exception {
	//CommonTest.Selectview("Ganttview");
	//	GanntViewHeaderFunctionality.PuckFontSizeValidation();
	CommonTest.Selectview("Hybridview");
	GanntViewHeaderFunctionality.PuckFontSizeValidation();
	
}
	
@Test(priority = 39)
public void TS39_VerifyRealtimebarExistance() throws Exception {
	//CommonTest.Selectview("Ganttview");
	//GanntViewHeaderFunctionality.RealtimeBar();
		CommonTest.Selectview("Hybridview");
	GanntViewHeaderFunctionality.RealtimeBar();
}
	
	
@Test(priority = 40)
public void TS40_VerifyFlightbetweentimerange() throws Exception {
	//CommonTest.Selectview("Ganttview");
	//GanntViewHeaderFunctionality.Betweentimerange();
CommonTest.Selectview("Hybridview");
GanntViewHeaderFunctionality.Betweentimerange();
}

	
@Test(priority = 41)
public void TS41_VerifySortGatebyAscendingorder() throws Exception {
	//CommonTest.Selectview("Ganttview");
	//SortFunctionalityvalidation.SortGateAscending();
		CommonTest.Selectview("Hybridview");
		SortFunctionalityvalidation.SortGateAscending();
}

@Test(priority = 42)
public void TS42_VerifySortGatebyDescendingorder() throws Exception {
	//CommonTest.Selectview("Ganttview");
	//SortFunctionalityvalidation.SortGateDescending();
	CommonTest.Selectview("Hybridview");
	SortFunctionalityvalidation.SortGateDescending();
	}


@Test(priority = 43)
public void TS43_VerifySearchinGanttview() throws Exception {
	//CommonTest.Selectview("Ganttview");
	//SearchValidation.SearchWithValidSearchkey("Ganttview");
		CommonTest.Selectview("Hybridview");
		SearchValidation.SearchWithValidSearchkey("Hybridview");
}



@Test(priority = 44)
public void TS44_VerifySearchwithinvalidkey() throws Exception {
	//CommonTest.Selectview("Ganttview");
	//SearchValidation.SearchWithINValidSearchkey("Ganttview");
	CommonTest.Selectview("Hybridview");
	SearchValidation.SearchWithINValidSearchkey("Hybridview");
}

@Test(priority = 45)
public void TS45_CheckHoverDetails() throws Exception {
	//CommonTest.Selectview("Ganttview");
	//HoverValidation.HoverDisplayValidation();
	CommonTest.Selectview("Hybridview");
	HoverValidation.HoverDisplayValidation();
		}
	
@Test(priority = 46)
public void TS46_ShouldShowTotalGates() throws Exception {
	//CommonTest.Selectview("Ganttview");
	//GanntViewHeaderFunctionality.ConfirmTotalGates("Ganttview");
	CommonTest.Selectview("Hybridview");
	GanntViewHeaderFunctionality.ConfirmTotalGates("Hybridview");
	}


@Test(priority = 47)
public void TS47_VerifyZoominZoomouticonPresence() throws Exception {
	//CommonTest.Selectview("Ganttview");
	//CommonTest.zoomin();
	//CommonTest.zoomOut();
	CommonTest.Selectview("Hybridview");
	CommonTest.zoomin();
	CommonTest.zoomOut();
	
}

@Test(priority = 48)
public void TS48_VerifyGanttviewHeader_Offload() throws Exception {
	//CommonTest.Selectview("Ganttview");
	//GanntViewHeaderFunctionality.OffloadCheck("Ganttview");
	CommonTest.Selectview("Hybridview");
	GanntViewHeaderFunctionality.OffloadCheck("Hybridview");
}

@Test(priority = 49)
public void TS49_VerifyGanttviewHeader_ClaimScam() throws Exception {
	CommonTest.Selectview("Ganttview");
	GanntViewHeaderFunctionality.ClaimScanCheck("Ganttview");
	//CommonTest.Selectview("Hybridview");
	//GanntViewHeaderFunctionality.ClaimScanCheck("Hybridview");
}
@Test(priority = 50)
public void TS50_VerifyGanttviewHeader_Bags() throws Exception {
	//CommonTest.Selectview("Ganttview");
	//GanntViewHeaderFunctionality.BagsCheck("Ganttview");
	CommonTest.Selectview("Hybridview");
	GanntViewHeaderFunctionality.BagsCheck("Hybridview");
}

@Test(priority = 51)
public void TS51_VerifyGanttviewHeader_Pax() throws Exception {
	//CommonTest.Selectview("Ganttview");
	//GanntViewHeaderFunctionality.PSGRCheck("Ganttview");
	CommonTest.Selectview("Hybridview");
	GanntViewHeaderFunctionality.PSGRCheck("Hybridview");
}

@Test(priority = 52)
public void TS52_VerifyGanttviewHeader_Crew() throws Exception {
	//CommonTest.Selectview("Ganttview");
	//GanntViewHeaderFunctionality.CrewCheck("Ganttview");
	CommonTest.Selectview("Hybridview");
	GanntViewHeaderFunctionality.CrewCheck("Hybridview");
}

@Test(priority = 53)
public void TS53_VerifyGanttviewHeader_Cabin() throws Exception {
	//CommonTest.Selectview("Ganttview");
	//GanntViewHeaderFunctionality.CabinCheck("Ganttview");
	CommonTest.Selectview("Hybridview");
	GanntViewHeaderFunctionality.CabinCheck("Hybridview");
}

@Test(priority = 54)
public void TS54_VerifyGanttviewHeader_Lavs() throws Exception {
	//CommonTest.Selectview("Ganttview");
	//GanntViewHeaderFunctionality.LavsCheck("Ganttview");
	CommonTest.Selectview("Hybridview");
	GanntViewHeaderFunctionality.LavsCheck("Hybridview");
}

@Test(priority = 55)
public void TS55_VerifyGanttviewHeader_Water() throws Exception {
	//CommonTest.Selectview("Ganttview");
	//GanntViewHeaderFunctionality.WaterCheck("Ganttview");
	CommonTest.Selectview("Hybridview");
	GanntViewHeaderFunctionality.WaterCheck("Hybridview");
}

@Test(priority = 56)
public void TS56_VerifyGanttviewHeaderFueling() throws Exception {
	//CommonTest.Selectview("Ganttview");
	//GanntViewHeaderFunctionality.FuelingCheck("Ganttview");
	CommonTest.Selectview("Hybridview");
	GanntViewHeaderFunctionality.FuelingCheck("Hybridview");
}

@Test(priority = 57)
public void TS57_VerifyGanttviewHeader_Catering() throws Exception {
	//CommonTest.Selectview("Ganttview");
	//GanntViewHeaderFunctionality.CateringCheck("Ganttview");
	CommonTest.Selectview("Hybridview");
	GanntViewHeaderFunctionality.CateringCheck("Hybridview");
}

@Test(priority = 58)
public void TS58_VerifyGanttviewHeader_Cancelled() throws Exception {
	//CommonTest.Selectview("Ganttview");
	//GanntViewHeaderFunctionality.CancelledCheck("Ganttview");
	CommonTest.Selectview("Hybridview");
	GanntViewHeaderFunctionality.CancelledCheck("Hybridview");
}

@Test(priority = 59)
public void TS59_VerifyGanttviewHeader_ETD() throws Exception {
	//CommonTest.Selectview("Ganttview");
	//GanntViewHeaderFunctionality.ETDupdatesCheck("Ganttview");
	CommonTest.Selectview("Hybridview");
	GanntViewHeaderFunctionality.ETDupdatesCheck("Hybridview");
}

@Test(priority = 60)
public void TS60_VerifyGanttviewHeader_MEL() throws Exception {
	//CommonTest.Selectview("Ganttview");
	//GanntViewHeaderFunctionality.MELAssistanceCheck("Ganttview");
	CommonTest.Selectview("Hybridview");
	GanntViewHeaderFunctionality.MELAssistanceCheck("Hybridview");
}
@Test(priority = 61)
public void TS61_VerifyGanttviewHeader_OTS() throws Exception {
	//CommonTest.Selectview("Ganttview");
	//GanntViewHeaderFunctionality.OTSCheck("Ganttview");
	CommonTest.Selectview("Hybridview");
	GanntViewHeaderFunctionality.OTSCheck("Hybridview");
}
@Test(priority = 62)
public void TS62_VerifyGanttviewHeader_RightStart() throws Exception {
	//CommonTest.Selectview("Ganttview");
	//GanntViewHeaderFunctionality.RightStart("Ganttview");
	CommonTest.Selectview("Hybridview");
	GanntViewHeaderFunctionality.RightStart("Hybridview");
}
@Test(priority = 63)
public void TS63_VerifyGanttviewHeader_A14() throws Exception {
	//CommonTest.Selectview("Ganttview");
	//GanntViewHeaderFunctionality.A14Check("Ganttview");
	CommonTest.Selectview("Hybridview");
	GanntViewHeaderFunctionality.A14Check("Hybridview");
}
@Test(priority = 64)
public void TS64_VerifyGanttviewHeader_Unlinked() throws Exception {
	//CommonTest.Selectview("Ganttview");
	//GanntViewHeaderFunctionality.UnlinkedCheck("Ganttview");
	CommonTest.Selectview("Hybridview");
	GanntViewHeaderFunctionality.UnlinkedCheck("Hybridview");
}
@Test(priority = 65)
public void TS65_VerifyGanttviewHeader_GroundInterrupt() throws Exception {
	//CommonTest.Selectview("Ganttview");
	//GanntViewHeaderFunctionality.GroundInteruptCheck("Ganttview");
	CommonTest.Selectview("Hybridview");
	GanntViewHeaderFunctionality.GroundInteruptCheck("Hybridview");
}
@Test(priority = 66)
public void TS66_VerifyGanttviewHeader_IFS() throws Exception {
	//CommonTest.Selectview("Ganttview");
	//GanntViewHeaderFunctionality.IFS("Ganttview");
	CommonTest.Selectview("Hybridview");
	GanntViewHeaderFunctionality.IFS("Hybridview");
}
@Test(priority = 67)
public void TS71_VerifyGanttviewHeader_Diverted() throws Exception {
	//CommonTest.Selectview("Ganttview");
	//GanntViewHeaderFunctionality.DivertedCheck("Ganttview");
	CommonTest.Selectview("Hybridview");
	GanntViewHeaderFunctionality.DivertedCheck("Hybridview");
}

@Test(priority = 68)
public void TS67_VerifyGanttviewHeader_LateArrivals() throws Exception {
	//CommonTest.Selectview("Ganttview");
	//GanntViewHeaderFunctionality.LateArrivalCheck("Ganttview");
	CommonTest.Selectview("Hybridview");
	GanntViewHeaderFunctionality.LateArrivalCheck("Hybridview");
}

@Test(priority = 69)
public void TS68_VerifyGanttviewHeader_GateSwaps() throws Exception {
	//CommonTest.Selectview("Ganttview");
	//GanntViewHeaderFunctionality.GateSwapsCheck("Ganttview");
	CommonTest.Selectview("Hybridview");
	GanntViewHeaderFunctionality.GateSwapsCheck("Hybridview");
}
@Test(priority = 70)
public void TS69_VerifyGanttviewHeader_GateConflicts() throws Exception {
	//CommonTest.Selectview("Ganttview");
	//GanntViewHeaderFunctionality.GateConflicts("Ganttview");
	CommonTest.Selectview("Hybridview");
	GanntViewHeaderFunctionality.GateConflicts("Hybridview");
}

@Test(priority = 71)
public void TS70_VerifyGanttviewHeader_Decision() throws Exception {
	//CommonTest.Selectview("Ganttview");
	//GanntViewHeaderFunctionality.Decisioncheck("Ganttview");
		CommonTest.Selectview("Hybridview");
	GanntViewHeaderFunctionality.Decisioncheck("Hybridview");
}
@Test(priority = 72)
public void TS072_VerifyGanttviewHeader_EarlyArrivals() throws Exception {
	//CommonTest.Selectview("Ganttview");
	//GanntViewHeaderFunctionality.EarlyArrivalsCheck("Ganttview");
	CommonTest.Selectview("Hybridview");
	GanntViewHeaderFunctionality.EarlyArrivalsCheck("Hybridview");
}
@Test(priority = 73)
public void TS73_VerifyGanttviewHeader_ACSwaps() throws Exception {
	//CommonTest.Selectview("Ganttview");
	//GanntViewHeaderFunctionality.AcSwapsCheck("Ganttview");
	CommonTest.Selectview("Hybridview");
	GanntViewHeaderFunctionality.AcSwapsCheck("Hybridview");
}

@Test(priority = 74)
public void TS74_VerifyGanttviewHeader_Delayed() throws Exception {
	//CommonTest.Selectview("Ganttview");
	//GanntViewHeaderFunctionality.DelayedCheck("Ganttview");
	CommonTest.Selectview("Hybridview");
	GanntViewHeaderFunctionality.DelayedCheck("Hybridview");
}

@Test(priority = 75)
public void TS75_VerifyGanttviewHeader_ORIGIN() throws Exception {
	//CommonTest.Selectview("Ganttview");
	//GanntViewHeaderFunctionality.ORIGINCheck("Ganttview");
	CommonTest.Selectview("Hybridview");
	GanntViewHeaderFunctionality.ORIGINCheck("Hybridview");
}

@Test(priority = 76)
public void TS76_VerifyGanttviewHeader_TERM() throws Exception {
	//CommonTest.Selectview("Ganttview");
	//GanntViewHeaderFunctionality.TERMCheck("Ganttview");
	CommonTest.Selectview("Hybridview");
	GanntViewHeaderFunctionality.TERMCheck("Hybridview");
}

@Test(priority = 77)
public void TS77_VerifyGanttviewHeader_MOGT() throws Exception {
	//CommonTest.Selectview("Ganttview");
	//GanntViewHeaderFunctionality.MOGTCheck("Ganttview");
	CommonTest.Selectview("Hybridview");
	GanntViewHeaderFunctionality.MOGTCheck("Hybridview");
}


@Test(priority = 78)
public void TS78_VerifyGanttviewHeader_Offload() throws Exception {
	//CommonTest.Selectview("Ganttview");
	//GanntViewHeaderFunctionality.NoOffloadDetails("Ganttview");
	CommonTest.Selectview("Hybridview");
	GanntViewHeaderFunctionality.NoOffloadDetails("Hybridview");
}

@Test(priority = 79)
public void TS79_VerifyGanttviewHeader_ClaimScam() throws Exception {
	//CommonTest.Selectview("Ganttview");
	//GanntViewHeaderFunctionality.NoClaimScamDetails("Ganttview");
	CommonTest.Selectview("Hybridview");
	GanntViewHeaderFunctionality.NoClaimScamDetails("Hybridview");
}

@Test(priority = 80)
public void TS80_VerifyGanttviewHeader_Bags() throws Exception {
	//CommonTest.Selectview("Ganttview");
	//GanntViewHeaderFunctionality.NoBagsDetails("Ganttview");
	CommonTest.Selectview("Hybridview");
	GanntViewHeaderFunctionality.NoBagsDetails("Hybridview");
}

@Test(priority = 81)
public void TS81_VerifyGanttviewHeader_Pax() throws Exception {
	CommonTest.Selectview("Ganttview");
	GanntViewHeaderFunctionality.NoPaxDetails("Ganttview");
	CommonTest.Selectview("Hybridview");
	GanntViewHeaderFunctionality.NoPaxDetails("Hybridview");
}

@Test(priority = 82)
public void TS82_VerifyGanttviewHeader_Crew() throws Exception {
	//CommonTest.Selectview("Ganttview");
	//GanntViewHeaderFunctionality.NoCrewDetails("Ganttview");
	CommonTest.Selectview("Hybridview");
	GanntViewHeaderFunctionality.NoCrewDetails("Hybridview");
}

@Test(priority = 83)
public void TS83_VerifyGanttviewHeader_Cabin() throws Exception {
	//CommonTest.Selectview("Ganttview");
	//GanntViewHeaderFunctionality.NoCabinDetails("Ganttview");
	CommonTest.Selectview("Hybridview");
	GanntViewHeaderFunctionality.NoCabinDetails("Hybridview");
}

@Test(priority = 84)
public void TS84_VerifyGanttviewHeader_Lavs() throws Exception {
	//CommonTest.Selectview("Ganttview");
	//GanntViewHeaderFunctionality.NoLavsDetails("Ganttview");
	CommonTest.Selectview("Hybridview");
	GanntViewHeaderFunctionality.NoLavsDetails("Hybridview");
}

@Test(priority = 85)
public void TS85_VerifyGanttviewHeader_Water() throws Exception {
	//CommonTest.Selectview("Ganttview");
	//GanntViewHeaderFunctionality.NoWaterDetails("Ganttview");
	CommonTest.Selectview("Hybridview");
	GanntViewHeaderFunctionality.NoWaterDetails("Hybridview");
}

@Test(priority = 86)
public void TS86_VerifyGanttviewHeader_Fueling() throws Exception {
	//CommonTest.Selectview("Ganttview");
	//GanntViewHeaderFunctionality.NoFuelingDetails("Ganttview");
	CommonTest.Selectview("Hybridview");
	GanntViewHeaderFunctionality.NoFuelingDetails("Hybridview");
}

@Test(priority = 87)
public void TS87_VerifyGanttviewHeader_Catering() throws Exception {
	//CommonTest.Selectview("Ganttview");
	//GanntViewHeaderFunctionality.NoCateringDetails("Ganttview");
	CommonTest.Selectview("Hybridview");
	GanntViewHeaderFunctionality.NoCateringDetails("Hybridview");
}

@Test(priority = 88)
public void TS88_VerifyMultipleAlerticonspresent() throws Exception {
	//CommonTest.Selectview("Ganttview");
	//Alertingflightstatsvalidation.VerifyMultipleAlertsicons("Ganttview");
	CommonTest.Selectview("Hybridview");
	Alertingflightstatsvalidation.VerifyMultipleAlertsicons("Hybridview");
}
	

	@Test(priority = 89)
	public void TS89_VerifyAlertingflightstatistics() throws Exception {
		//CommonTest.Selectview("Ganttview");
		//Alertingflightstatsvalidation.VerifyAlertstatspresent("Ganttview");
		CommonTest.Selectview("Hybridview");
		Alertingflightstatsvalidation.VerifyAlertstatspresent("Hybridview");
	}
	
	
	
	@Test(priority = 90)
	public void TS90_VerifyMessageforblockedSelected() throws Exception {
		//CommonTest.Selectview("Ganttview");
		//Alertingflightstatsvalidation.VerifyMessagewhennoflightsforBlocked("Ganttview");
		CommonTest.Selectview("Hybridview");
		Alertingflightstatsvalidation.VerifyMessagewhennoflightsforBlocked("Hybridview");
		
	}
	
	
	@Test(priority = 91)
	public void TS91_VerifyMessageforYellowSelected() throws Exception {
		//CommonTest.Selectview("Ganttview");
		//Alertingflightstatsvalidation.VerifyMessagewhennoflightsforYellow("Ganttview");
		CommonTest.Selectview("Hybridview");
		Alertingflightstatsvalidation.VerifyMessagewhennoflightsforYellow("Hybridview");
	}
	
	
	@Test(priority = 92)
	public void TS92_VerifyMessageforTotalSelected() throws Exception {
		//CommonTest.Selectview("Ganttview");
		//Alertingflightstatsvalidation.VerifyMessagewhennoflightsforTotal("Ganttview");
		CommonTest.Selectview("Hybridview");
		Alertingflightstatsvalidation.VerifyMessagewhennoflightsforTotal("Hybridview");
	}
	
	
	@Test(priority = 93)
	public void TS93_VerifyMessageforRedSelected() throws Exception {
		//CommonTest.Selectview("Ganttview");
		//Alertingflightstatsvalidation.VerifyMessagewhennoflightsforRED("Ganttview");
		CommonTest.Selectview("Hybridview");
		Alertingflightstatsvalidation.VerifyMessagewhennoflightsforRED("Hybridview");
	}
	

	@Test(priority = 94)
	public void TS94_VerifyBlockedflightinMaroon() throws Exception {
		//CommonTest.Selectview("Ganttview");
		//Alertingflightstatsvalidation.VerifyBlockedhaveMaroonColor("Ganttview");
		CommonTest.Selectview("Hybridview");
		Alertingflightstatsvalidation.VerifyBlockedhaveMaroonColor("Hybridview");
	}
	
	@Test(priority = 95)
	public void TS95_VerifyYellowalertflightsshownYellow() throws Exception {
		//CommonTest.Selectview("Ganttview");
		//Alertingflightstatsvalidation.VerifyYellowStatshaveyellowcolor("Ganttview");
		CommonTest.Selectview("Hybridview");
		Alertingflightstatsvalidation.VerifyYellowStatshaveyellowcolor("Hybridview");
	}
	
	@Test(priority = 96)
	public void TS96_VerifyRedalertflightshownRed() throws Exception {
		//CommonTest.Selectview("Ganttview");
		//Alertingflightstatsvalidation.VerifyRedStatshaveRedcolor("Ganttview");
		CommonTest.Selectview("Hybridview");
		Alertingflightstatsvalidation.VerifyRedStatshaveRedcolor("Hybridview");
	}

	
	@Test(priority = 97)
	public void TS97_VerifyEventdetailsPage() throws Exception {
		//CommonTest.Selectview("Ganttview");
		//EventDetailsValidation.EventAlertDetailsPopupselection();
		CommonTest.Selectview("Hybridview");
		EventDetailsValidation.EventAlertDetailsPopupselection();
			}

	@Test(priority = 98)
	public void TS98_VerifySlideoutdatadisplayed() throws Exception {
		//CommonTest.Selectview("Ganttview");
		//EventDetailsValidation.CheckContentsinSlideOut();
		CommonTest.Selectview("Hybridview");
		EventDetailsValidation.CheckContentsinSlideOut();
			}

	@Test(priority = 99)
	public void TS99_VerifyOffloadReport() throws Exception {
		//CommonTest.Selectview("Ganttview");
		//EventDetailsValidation.Selectapucktovieweventdetails();
		//EventDetailsValidation.Checkreportvalueupdating("OFFLOAD");
		//EventDetailsValidation.Selectreport("OFFLOAD");
		CommonTest.Selectview("Hybridview");
		EventDetailsValidation.Selectapucktovieweventdetails();
		EventDetailsValidation.Checkreportvalueupdating("OFFLOAD");
		EventDetailsValidation.Selectreport("OFFLOAD");
		
			}
	
	
	@Test(priority = 100)
	public void TS100_VerifyClaimscanReport() throws Exception {
		//CommonTest.Selectview("Ganttview");
		//EventDetailsValidation.Selectapucktovieweventdetails();
		//EventDetailsValidation.Checkreportvalueupdating("CLAIMSCAN");
		//EventDetailsValidation.Selectreport("CLAIMSCAN");
		CommonTest.Selectview("Hybridview");
		EventDetailsValidation.Selectapucktovieweventdetails();
		EventDetailsValidation.Checkreportvalueupdating("CLAIMSCAN");
		EventDetailsValidation.Selectreport("CLAIMSCAN");
		
			}
	
	
	@Test(priority = 101)
	public void TS101_VerifyPaxReport() throws Exception {
		//CommonTest.Selectview("Ganttview");
		//EventDetailsValidation.Selectapucktovieweventdetails();
		//EventDetailsValidation.Checkreportvalueupdating("PAX");
		//EventDetailsValidation.Selectreport("PAX");
		CommonTest.Selectview("Hybridview");
		EventDetailsValidation.Selectapucktovieweventdetails();
		EventDetailsValidation.Checkreportvalueupdating("PAX");
		EventDetailsValidation.Selectreport("PAX");
			}
	
	
	@Test(priority = 102)
	public void TS102_VerifyBagsReport() throws Exception {
		//CommonTest.Selectview("Ganttview");
		//EventDetailsValidation.Selectapucktovieweventdetails();
		//EventDetailsValidation.Checkreportvalueupdating("BAGS");
		//EventDetailsValidation.Selectreport("BAGS");
		CommonTest.Selectview("Hybridview");
		EventDetailsValidation.Selectapucktovieweventdetails();
		EventDetailsValidation.Checkreportvalueupdating("BAGS");
		EventDetailsValidation.Selectreport("BAGS");
			}
	
	
	@Test(priority = 103)
	public void TS103_VerifyCabinReport() throws Exception {
		//CommonTest.Selectview("Ganttview");
		//EventDetailsValidation.Selectapucktovieweventdetails();
		//EventDetailsValidation.Checkreportvalueupdating("CABIN");
		//EventDetailsValidation.Selectreport("CABIN");
		CommonTest.Selectview("Hybridview");
		EventDetailsValidation.Selectapucktovieweventdetails();
		EventDetailsValidation.Checkreportvalueupdating("CABIN");
		EventDetailsValidation.Selectreport("CABIN");
			}
	
	
	@Test(priority = 104)
	public void TS104_VerifyCrewReport() throws Exception {
		//CommonTest.Selectview("Ganttview");
		//EventDetailsValidation.Selectapucktovieweventdetails();
		//EventDetailsValidation.Checkreportvalueupdating("CREW");
		//EventDetailsValidation.Selectreport("CREW");
		CommonTest.Selectview("Hybridview");
		EventDetailsValidation.Selectapucktovieweventdetails();
		EventDetailsValidation.Checkreportvalueupdating("CREW");
	EventDetailsValidation.Selectreport("CREW");	

	}
	@Test(priority = 115)
	public void TS115_FittoScreen() throws Exception {
		System.out.println("TS115_FittoScreen");
		PuckUIPlacement.FittoScreen();
		Memoryused();
			}
	


	@Test(priority = 116)
	public void TS116_Guidelines() throws Exception {
		//CommonTest.Selectview("Ganttview");
		//PuckUIPlacement.Guidelines();
		CommonTest.Selectview("Hybridview");
		PuckUIPlacement.Guidelines();
				}
	
	
		
	@Test(priority = 117)
	public void TS117_StatSelection() throws Exception {
		CommonTest.Selectview("Hybridview");	
	DashboardFilterOptionValidation.StatsoptionExist();
	DashboardFilterOptionValidation.StatsoptionSelection();
	
	
	}
	
	@Test(priority = 118)
	public void TS118_VerifyallStatsareSelected() throws Exception {
		
	DashboardFilterOptionValidation.SelectAllStatistics();
	
	}
	
	
	@Test(priority = 119)
	public void TS119_VerifyGanttviewpuckOption() throws Exception {
		CommonTest.Selectview("Hybridview");
	GanttviewPuckOptions.GanttviewSettingsvalidation();
	
	}
	
	@Test(priority = 128)
	public void TS105_CustomZoneCreation() throws Exception {
			CustomZone.customzonecreation();
						}


	@Test(priority = 129)
	public void TS106_CustomZonedeletion() throws Exception {
	
		CustomZone.customzonedeletion();
			}
	
	@Test(priority = 130)
	public void TS130_ValidateDayandnightmode() throws Exception {
		System.out.println("TS130_ValidateDayandnightmode");
		DashboardFilterOptionValidation.CheckDaynightenabling();
		Memoryused();
			}

	@Test(priority = 131)
	public void TS131_CheckDashboardrenamed() throws Exception {
		System.out.println("TS131_CheckDashboardrenamed");
		DashboardFilterOptionValidation.CheckDashboardrenamed();
		Memoryused();
		
			}
	@Test(priority = 134)
	public void TC_402_VerifyCrewiconhavebubbleandtitle() throws Exception {
		System.out.println("TC_402_VerifyCrewiconhavebubbleandtitle");			
			consolidatedcrewreport.Bubbleholdcountwhencrewalerts();
			Memoryused();
	
	}	
		
		
		
		@Test(priority = 135)
		public void TS133_VerifyHeaderofCrewReport() throws Exception {
			System.out.println("TS133_VerifyHeaderofCrewReport");
			consolidatedcrewreport.Crewreportholdsreuiredtitle();
			Memoryused();
		}
			
			
					
			@Test(priority = 136)
			public void TS136_CheckSortFunctionality() throws Exception {
				System.out.println("TS136_CheckSortFunctionality");
				consolidatedcrewreport.CrewSortAscendingDescending();
				Memoryused();
			}	
				
				
				
	
			@Test(priority = 137)
			public void TS137_CheckSearchFunctionality() throws Exception {
				System.out.println("TS137_CheckSearchFunctionality");
				consolidatedcrewreport.Searchfunctionality();
				Memoryused();
			}
			
	
		@Test(priority = 138)
			public void TS138_VerifyredandyellowConnex() throws Exception {
			System.out.println("TS138_VerifyredandyellowConnex");
					consolidatedcrewreport.Crewalertcoloring();
					Memoryused();
			}	
			
		
		@Test(priority = 139)
		public void TS139_Offandoutflightshouldnotpresent() throws Exception {
			System.out.println("TS139_Offandoutflightshouldnotpresent");
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
			System.out.println("TS141_Checketdlesthan360");
			consolidatedcrewreport.Checketdlesthan360();
			Memoryused();
		}
		
		@Test(priority = 145)
		public void TS142_lastsortsave() throws Exception {
			System.out.println("TS142_lastsortsave");
			consolidatedcrewreport.Savesortsession();
			Memoryused();
			
			
			
		}	
	
			
		@Test(priority = 146)
		public void TS146_CheckSlidersessionsaved() throws Exception {
			System.out.println("TS146_CheckSlidersessionsaved");
			consolidatedcrewreport.CheckSliderexist();
		//	consolidatedcrewreport.Slidersessionsaved();
			Memoryused();
		}	

		@Test(priority = 147)
		public void TS147_UNCheckShowETDOutside() throws Exception {
			System.out.println("TS147_UNCheckShowETDOutside");
			DashboardFilterOptionValidation.UNCheckShowETDOutside();
			Memoryused();
				}
		@Test(priority = 148)
		public void TS148_DonotshowGuidelines() throws Exception {
			System.out.println("TS148_DonotshowGuidelines");
			PuckUIPlacement.DonotshowGuidelines();
			Memoryused();
				}
		@Test(priority = 149)
		public void TS149_DonotdisplayDrawtoActualGT() throws Exception {
			System.out.println("TS149_DonotdisplayDrawtoActualGT");
			DashboardFilterOptionValidation.DonotdisplayDrawtoActualGT();
			Memoryused();
				}
		
		
		
				@Test(priority = 150)
		public void TS150_Atlasiconinslideout() throws Exception {
					System.out.println("TS150_Atlasiconinslideout");
					EventDetailsValidation.Atlasiconexistance();
					Memoryused();
					
				}
				
				@Test(priority = 151)
				public void TS151_VerifyGanttviewHeaderAtlasGalley() throws Exception {
					System.out.println("TS151_VerifyGanttviewHeaderAtlasGalley");
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
								@Test(priority = 171)
								public void TS171_VerifyGanttCount_MEL() throws Exception {
									System.out.println("TS171_VerifyGanttCount_MEL");
									Lazyloading.VerifyStatsCount(Web_UI.MEL,"MEL",Web_UI.MELStatsCount);
										
								}
								
								
								
								@Test(priority = 172)
								public void TS172_VerifyGanttCount_Offload() throws Exception {
									System.out.println("TS172_VerifyGanttCount_Offload");
									Lazyloading.VerifyStatsCount(Web_UI.Offload,"Offload",Web_UI.OffloadStatsCount);
									Memoryused();
								}

								@Test(priority = 173)
								public void TS173_VerifyGanttCount_ClaimScam() throws Exception {
									System.out.println("TS173_VerifyGanttCount_ClaimScam");
									Lazyloading.VerifyStatsCount(Web_UI.Claimscan,"Claimscan",Web_UI.ClaimscanStatsCount);
									Memoryused();
								}
								@Test(priority = 174)
								public void TS174_VerifyGanttCount_Bags() throws Exception {
									System.out.println("TS174_VerifyGanttCount_Bags");
									Lazyloading.VerifyStatsCount(Web_UI.Bags,"Bags",Web_UI.BagsStatsCount);
									Memoryused();
								}

								@Test(priority = 175)
								public void TS175_VerifyGanttCount_Pax() throws Exception {
									System.out.println("TS175_VerifyGanttCount_Pax");
									Lazyloading.VerifyStatsCount(Web_UI.Passanger,"Passanger",Web_UI.PassangerStatsCount);
									Memoryused();
								}


								@Test(priority = 176)
								public void TS176_VerifyGanttCount_Crew() throws Exception {
									System.out.println("TS176_VerifyGanttCount_Crew");
									Lazyloading.VerifyStatsCount(Web_UI.Crew,"Crew",Web_UI.CrewStatsCount);
									Memoryused();
								}

								@Test(priority = 177)
								public void TS177_VerifyGanttCount_Cabin() throws Exception {
									System.out.println("TS177_VerifyGanttCount_Cabin");
									Lazyloading.VerifyStatsCount(Web_UI.Cabin,"Cabin",Web_UI.CabinStatsCount);
									Memoryused();
								}

								@Test(priority = 178)
								public void TS178_VerifyGanttCount_Lavs() throws Exception {
									System.out.println("TS178_VerifyGanttCount_Lavs");
									Lazyloading.VerifyStatsCount(Web_UI.LAV,"LAV",Web_UI.LavsStatsCount);
									Memoryused();
								}

								@Test(priority = 179)
								public void TS179_VerifyGanttCount_Water() throws Exception {
									System.out.println("TS179_VerifyGanttCount_Water");
									Lazyloading.VerifyStatsCount(Web_UI.Water,"Water",Web_UI.WaterStatsCount);
									Memoryused();
								}

								@Test(priority = 180)
								public void TS180_VerifyGanttCount_Fueling() throws Exception {
									System.out.println("TS180_VerifyGanttCount_Fueling");
									Lazyloading.VerifyStatsCount(Web_UI.Fuel,"MEL",Web_UI.FuelStatsCount);
									Memoryused();
								}
								
								@Test(priority = 181)
								public void TS181_VerifyGanttCount_Catering() throws Exception {
									System.out.println("TS181_VerifyGanttCount_Catering");
									Lazyloading.VerifyStatsCount(Web_UI.Catering,"Catering",Web_UI.CateringStatsCount);
									Memoryused();
								}

								@Test(priority = 182)
								public void TS182_VerifyGanttCount_Cancelled() throws Exception {
									System.out.println("TS182_VerifyGanttCount_Cancelled");
									Lazyloading.VerifyStatsCount(Web_UI.Canceled,"Canceled",Web_UI.CancelledStatsCount);
									Memoryused();
								}

								@Test(priority = 183)
								public void TS183_VerifyGanttCount_ETD() throws Exception {
									System.out.println("TS183_VerifyGanttCount_ETD");
									Lazyloading.VerifyStatsCount(Web_UI.ETD,"ETD",Web_UI.ETDStatsCount);
									Memoryused();
								}


								
								@Test(priority = 184)
								public void TS184_VerifyGanttCount_OTS() throws Exception {
									System.out.println("TS184_VerifyGanttCount_OTS");
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
									System.out.println("TS186_VerifyGanttCount_A14");
									Lazyloading.VerifyStatsCount(Web_UI.A14,"A14",Web_UI.A14StatsCount);
									Memoryused();
								}
								@Test(priority = 187)
								public void TS187_VerifyGanttCount_Unlinked() throws Exception {
									System.out.println("TS187_VerifyGanttCount_Unlinked");
									Lazyloading.VerifyStatsCount(Web_UI.Unlinked,"Unlinked",Web_UI.UnlinkedCount);
									Memoryused();
								}

								@Test(priority = 188)
								public void TS188_VerifyGanttCount_IFS() throws Exception {
									System.out.println("TS188_VerifyGanttCount_IFS");
									Lazyloading.VerifyStatsCount(Web_UI.IFS,"IFS",Web_UI.IFSStatsCount);
									Memoryused();
								}
								@Test(priority = 189)
								public void TS189_VerifyGanttCount_Diverted() throws Exception {
									System.out.println("TS189_VerifyGanttCount_Diverted");
									Lazyloading.VerifyStatsCount(Web_UI.Diverted,"Diverted",Web_UI.DivertedStatsCount);
									Memoryused();
								}
								@Test(priority = 190)
								public void TS190_VerifyGanttCount_LateArrivals() throws Exception {
									System.out.println("TS190_VerifyGanttCount_LateArrivals");
									Lazyloading.VerifyStatsCount(Web_UI.LateArrival,"LateArrival",Web_UI.LateArrivaStatsCount);
									Memoryused();
								}
								@Test(priority = 191)
								public void TS191_VerifyGanttCount_GateSwaps() throws Exception {
									System.out.println("TS191_VerifyGanttCount_GateSwaps");
									Lazyloading.VerifyStatsCount(Web_UI.GateSwaps,"GateSwaps",Web_UI.GateSwapsStatsCount);
									Memoryused();
								}

								@Test(priority = 192)
								public void TS192_VerifyGanttCount_GateConflicts() throws Exception {
									System.out.println("TS192_VerifyGanttCount_GateConflicts");
									//Lazyloading.VerifyStatsCount(Web_UI.GateConflicts,"GateConflicts",Web_UI.GateConflictsStatsCount);
								//	Memoryused();
								}

								@Test(priority = 193)
								public void TS193_VerifyGanttCount_Decision() throws Exception {
									System.out.println("TS193_VerifyGanttCount_Decision");
									Lazyloading.VerifyStatsCount(Web_UI.Decision,"Decision",Web_UI.DecisionStatsCount);
									Memoryused();
								}
								@Test(priority = 194)
								public void TS194_VerifyGanttCount_EarlyArrivals() throws Exception {
									System.out.println("TS194_VerifyGanttCount_EarlyArrivals");
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
									System.out.println("TS196_VerifyGanttCount_Delayed");
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
									System.out.println("TS198_VerifyGanttCount_TERM");
									Lazyloading.VerifyStatsCount(Web_UI.Term,"Term",Web_UI.TermCount);
									Memoryused();
								}
								
								
								
								
								@Test(priority = 199)
								public void TS199_Closeoutflightsselection() throws Exception {
									System.out.println("TS199_Closeoutflightsselection");
									CloseOut.SelectCloseout();
									Memoryused();
										}
								
								
								
								@Test(priority = 200)
								public void TS200_UnCloseoutflightsselection() throws Exception {
									System.out.println("TS200_UnCloseoutflightsselection");
									CloseOut.UnSelectCloseout();
									Memoryused();
										}

								@Test(priority = 201)
								public void TS201_Verifywhennocloseoutflights() throws Exception {
									System.out.println("TS201_Verifywhennocloseoutflights");
									Alertingflightstatsvalidation.VerifyMessagewhennoflightsforCloseout("Ganttview");
									Memoryused();
										}


								@Test(priority = 202)
								public void TS202_VerifyGanttviewHeader_Closeout() throws Exception {
									System.out.println("TS202_VerifyGanttviewHeader_Closeout");
									GanntViewHeaderFunctionality.CloseoutCheck("Ganttview");
									Memoryused();
										}

								
								@Test(priority = 203)
								public void TS203_Verifycloseoutflightisshown() throws Exception {
									System.out.println("TS203_Verifycloseoutflightisshown");
									CloseOut.shouldshowcloseoutonly();
									Memoryused();
										}
								
								
								@Test(priority = 204)
								public void TS204_Verifycloseoutnotshownforschandoffflts() throws Exception {
									System.out.println("TS204_Verifycloseoutnotshownforschandoffflts");
									CloseOut.ShouldnotshowClosoutexceptoutstatus();
									Memoryused();
										}
								
								@Test(priority = 205)
								public void TS205_VerifyMessagecloseoutclicked() throws Exception {
									System.out.println("TS205_VerifyMessagecloseoutclicked");
									CloseOut.ShouldnotshowClosoutexceptoutstatus();
									Memoryused();
										}		
								
								@Test(priority = 206)
								public void TS206_Resetsettingsvalidation() throws Exception {
									System.out.println("TS206_Resetsettingsvalidation");
									ResetSettings.Validate_resetsettings();
									
											}
			
						
								@Test(priority = 207)
								public void TS207_ValidateMultialert() throws Exception {

									System.out.println("TS207_ValidateMultialert");
									Multialert.Checkmultialertpresent();
									Multialert.Checkeventmultialertpresent();
									
								}
								@Test(priority = 208)
								public void TS207_ValidateMultialertpriority() throws Exception {
									System.out.println("TS208_ValidateMultialertpriority");
									Multialert.Checkmultialertpriority();

								}
	
	@Test(priority = 230)
	public void TS130_VerifyLogout() throws Exception {
	
	CommonTest.Logout();
	
	}
	
	
/*	
//	@Test(priority = 5)
//	public void TS_123_VerifyTotalalertStatshaveallalertingflight() throws Exception {
//		
//		Alertingflightstatsvalidation.VerifyTotalHaveallcolor();
//	}
	*/
	





			

			
			


	




	
	
	

	












}
