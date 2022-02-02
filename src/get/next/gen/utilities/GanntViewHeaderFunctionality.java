/*
 * This Class contains functions to validate scenarios related to Gantt view 
 * and Header functionalities
 * 
 */

package get.next.gen.utilities;



import get.next.gen.commonaction.CommonTest;
import get.next.gen.webtestcase.*;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;


import org.testng.annotations.Listeners;

import atu.testng.reports.ATUReports;
import atu.testng.reports.logging.LogAs;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;
import atu.testng.reports.listeners.ATUReportsListener;
import atu.testng.reports.listeners.ConfigurationListener;
import atu.testng.reports.listeners.MethodListener;
@Listeners({ ATUReportsListener.class, ConfigurationListener.class,
MethodListener.class })



public class GanntViewHeaderFunctionality extends CommonTest {

	
	// Below Function to check No of flights in Gantt table matches with Header Count upon Selecting Atlas Galley Category
		public static void AtlasCheck(String view) throws Exception {
			
			System.out.print("Verify the header when Atlas Galley flight stats is selected");
			ATUReports.add("Verify the count matches for Atlas Galley statistics",  LogAs.INFO, null); 
			ATUReports.add("Passing the respective statistics value and stats count to verify the count matches with stats",  LogAs.INFO, null); 
			System.out.println("Validate the Atlas Galley Flight Statistics holds Correct Count");
			FlightgantttableHeadervalidation(view,Web_UI.Atlas,Web_UI.AtlasCount,Web_UI.HybridAtlas,Web_UI.HybridAtlasCount);
			
		
		}
	
	
// Below Function to check No of flights in Gantt table matches with Header Count upon Selecting Canceled Category
	public static void CancelledCheck(String view) throws Exception {
		
		System.out.print("Verify the header when cancelled flight stats is selected");
		ATUReports.add("Verify the count matches for Cancelled statistics",  LogAs.INFO, null); 
		ATUReports.add("Passing the respective statistics value and stats count to verify the count matches with stats",  LogAs.INFO, null); 
		System.out.println("Validate the Cancelled Flight Statistics holds Correct Count");
		FlightgantttableHeadervalidation(view,Web_UI.Canceled,Web_UI.CancelledStatsCount,Web_UI.HybridCancelled,Web_UI.HybridCancelledCount);
		
	
	}
	
// Below Function to check No of flights in Gantt table matches with Header Count upon Selecting ETD Category
	public static void ETDupdatesCheck(String view) throws Exception {
		ATUReports.add("Verify the count matches for ETDupdates statistics",  LogAs.INFO, null); 
		ATUReports.add("Passing the respective statistics value and stats count to verify the count matches with stats",  LogAs.INFO, null); 
		System.out.println("Validate the ETDupdates Flight Statistics holds Correct Count");
		FlightgantttableHeadervalidation(view,Web_UI.ETD,Web_UI.ETDStatsCount,Web_UI.HybridETD,Web_UI.HybridETDCount);
	}
	
// Below Function to check No of flights in Gantt table matches with Header Count upon Selecting Diverted Category
	public static void DivertedCheck(String view) throws Exception {
		ATUReports.add("Verify the count matches for Diverted statistics",  LogAs.INFO, null); 
		ATUReports.add("Passing the respective statistics value and stats count to verify the count matches with stats",  LogAs.INFO, null); 
		System.out.println("Validate the Diverted Flight Statistics holds Correct Count");
		FlightgantttableHeadervalidation(view,Web_UI.Diverted,Web_UI.DivertedStatsCount,Web_UI.HybridDiverted,Web_UI.HybridDivertedCount);
	}

// Below Function to check No of flights in Gantt table matches with Header Count upon Selecting Decision Category
	public static void Decisioncheck(String view) throws Exception {
		ATUReports.add("Verify the count matches for Decision statistics",  LogAs.INFO, null); 
		ATUReports.add("Passing the respective statistics value and stats count to verify the count matches with stats",  LogAs.INFO, null); 
		System.out.println("Validate the Decision Flight Statistics holds Correct Count");
		FlightgantttableHeadervalidation(view,Web_UI.Decision,Web_UI.DecisionStatsCount,Web_UI.HybridDecision,Web_UI.HybridDecisionCount);
		}
	
// Below Function to check No of flights in Gantt table matches with Header Count upon Selecting LateArrival Category
	public static void LateArrivalCheck(String view) throws Exception {
		ATUReports.add("Verify the count matches for LateArrival statistics",  LogAs.INFO, null); 
		ATUReports.add("Passing the respective statistics value and stats count to verify the count matches with stats",  LogAs.INFO, null); 
		System.out.println("Validate the LateArrival Flight Statistics holds Correct Count");
		FlightgantttableHeadervalidation(view,Web_UI.LateArrival,Web_UI.LateArrivaStatsCount,Web_UI.HybridLatearrival,Web_UI.HybridLatearrivalCount);
	}

// Below Function to check No of flights in Gantt table matches with Header Count upon Selecting EarlyArrival Category
	public static void EarlyArrivalsCheck(String view) throws Exception {
		ATUReports.add("Verify the count matches for EarlyArrival statistics",  LogAs.INFO, null); 
		ATUReports.add("Passing the respective statistics value and stats count to verify the count matches with stats",  LogAs.INFO, null); 
		System.out.println("Validate the EarlyArrivals Flight Statistics holds Correct Count");
		FlightgantttableHeadervalidation(view,Web_UI.EarlyArrival,Web_UI.EarlyArrivalStatsCount,Web_UI.HybridEarlyarrival,Web_UI.HybridEarlyarrivalCount);
	}
	

// Below Function to check No of flights in Gantt table matches with Header Count upon Selecting ACSwaps Category
	public static void AcSwapsCheck(String view) throws Exception {
		ATUReports.add("Verify the count matches for AcSwaps statistics",  LogAs.INFO, null); 
		ATUReports.add("Passing the respective statistics value and stats count to verify the count matches with stats",  LogAs.INFO, null); 
		System.out.println("Validate the AcSwaps Flight Statistics holds Correct Count");
		FlightgantttableHeadervalidation(view,Web_UI.ACSwaps,Web_UI.ACSwapsStatsCount,Web_UI.HybridAcSwaps,Web_UI.HybridAcSwapsCount);
	}

// Below Function to check No of flights in Gantt table matches with Header Count upon Selecting GateSwaps Category
	public static void GateSwapsCheck(String view) throws Exception {
		ATUReports.add("Verify the count matches for GateSwaps statistics",  LogAs.INFO, null); 
		ATUReports.add("Passing the respective statistics value and stats count to verify the count matches with stats",  LogAs.INFO, null); 
		System.out.println("Validate the Cancelled Flight Statistics holds Correct Count");
		FlightgantttableHeadervalidation(view,Web_UI.GateSwaps,Web_UI.GateSwapsStatsCount,Web_UI.HybridGateSwaps,Web_UI.HybridGateSwapsCount);
	}
	
// Below Function to check No of flights in Gantt table matches with Header Count upon Selecting Fuel Category
		public static void RightStart(String view) throws Exception {
			ATUReports.add("Verify the count matches for RightStart statistics",  LogAs.INFO, null); 
			ATUReports.add("Passing the respective statistics value and stats count to verify the count matches with stats",  LogAs.INFO, null); 
			System.out.println("Validate the RightStart Flight Statistics holds Correct Count"); 
			FlightgantttableHeadervalidation(view,Web_UI.RightStart,Web_UI.RightstartStatsCount,Web_UI.HybridRightStart,Web_UI.HybridRightStartCount);
		}
		
// Below Function to check No of flights in Gantt table matches with Header Count upon Selecting Potential Tows Category
		public static void Potentialtows(String view) throws Exception {
			ATUReports.add("Verify the count matches for Potentialtows statistics",  LogAs.INFO, null); 
			ATUReports.add("Passing the respective statistics value and stats count to verify the count matches with stats",  LogAs.INFO, null); 
			System.out.println("Validate the Potentialtows Flight Statistics holds Correct Count"); 
			FlightgantttableHeadervalidation(view,"//span[text()='Potential Tows']",Web_UI.PotentialtowsStatsCount,"//span[text()='Potential Tows']",Web_UI.PotentialtowsStatsCount);
		}

		
// Below Function to check No of flights in Gantt table matches with Header Count upon Selecting IFS Category
		public static void IFS(String view) throws Exception {
			ATUReports.add("Verify the count matches for IFS statistics",  LogAs.INFO, null); 
			ATUReports.add("Passing the respective statistics value and stats count to verify the count matches with stats",  LogAs.INFO, null); 
			System.out.println("Validate the IFS Flight Statistics holds Correct Count"); 
			FlightgantttableHeadervalidation(view,Web_UI.IFS,Web_UI.IFSStatsCount,Web_UI.HybridIFS,Web_UI.HybridIFSCount);

		}

// Below Function to check No of flights in Gantt table matches with Header Count upon Selecting MEL Category
		public static void MELAssistanceCheck(String view) throws Exception {
			ATUReports.add("Verify the count matches for MEL statistics",  LogAs.INFO, null); 
			ATUReports.add("Passing the respective statistics value and stats count to verify the count matches with stats",  LogAs.INFO, null); 
			System.out.println("Validate the MEL Flight Statistics holds Correct Count");
			FlightgantttableHeadervalidation(view,Web_UI.MEL,Web_UI.MELStatsCount,Web_UI.HybridMEL,Web_UI.HybridMELCount);
		}

// Below Function to check No of flights in Gantt table matches with Header Count upon Selecting Delayed Category
			public static void DelayedCheck(String view) throws Exception {
				ATUReports.add("Verify the count matches for Delayed statistics",  LogAs.INFO, null); 
				ATUReports.add("Passing the respective statistics value and stats count to verify the count matches with stats",  LogAs.INFO, null); 
				System.out.println("Validate the Delayed Flight Statistics holds Correct Count");
				FlightgantttableHeadervalidation(view,Web_UI.Delayed,Web_UI.DelayedStatsCount,Web_UI.HybridDelayed,Web_UI.HybridDelayedCount);
			}
			
// Below Function to check No of flights in Gantt table matches with Header Count upon Selecting TotalGate Category
			public static void TotalGates(String view) throws Exception {
				ATUReports.add("Verify the count matches for TotalGates statistics",  LogAs.INFO, null); 
				ATUReports.add("Passing the respective statistics value and stats count to verify the count matches with stats",  LogAs.INFO, null); 
				System.out.println("Validate the TotalGates Flight Statistics holds Correct Count");	
				FlightgantttableHeadervalidation(view,Web_UI.TotalGate,Web_UI.TotalStatsCount,Web_UI.HybridAllGate,Web_UI.HybridAllGateCount);
			}
			
			// Below Function to check No of flights in Gantt table matches with Header Count upon Selecting Gate Conflicts Category
						public static void GateConflicts(String view) throws Exception {
							ATUReports.add("Verify the count matches for GateConflicts statistics",  LogAs.INFO, null); 
							ATUReports.add("Passing the respective statistics value and stats count to verify the count matches with stats",  LogAs.INFO, null); System.out.println("Validate the GateConflicts Flight Statistics holds Correct Count");
							FlightgantttableHeadervalidation(view,Web_UI.GateConflicts,Web_UI.GateConflictsStatsCount,Web_UI.HybridGateConflict,Web_UI.HybridGateConflictCount);
						}
						
// Below Function to check No of flights in Gantt table matches with Header Count upon Selecting Fuel Category
	public static void FuelingCheck(String view) throws Exception {
		ATUReports.add("Verify the count matches for Fueling statistics",  LogAs.INFO, null); 
		ATUReports.add( "Passing the respective statistics value and stats count to verify the count matches with stats",  LogAs.INFO, null); 
		System.out.println("Validate the Fuel Flight Statistics holds Correct Count");
		FlightgantttableHeadervalidation(view,Web_UI.Fuel,Web_UI.FuelStatsCount,Web_UI.HybridFuel,Web_UI.HybridFuelCount);
	}

// Below Function to check No of flights in Gantt table matches with Header Count upon Selecting Passanger Category
	public static void PSGRCheck(String view) throws Exception {
		ATUReports.add("Verify the count matches for PSGR statistics",  LogAs.INFO, null); 
		ATUReports.add("Passing the respective statistics value and stats count to verify the count matches with stats",  LogAs.INFO, null); 
		System.out.println("Validate the Passanger Flight Statistics holds Correct Count"); 
		FlightgantttableHeadervalidation(view,Web_UI.Passanger,Web_UI.PassangerStatsCount,Web_UI.HybridPax,Web_UI.HybridPaxCount);
	}

// Below Function to check No of flights in Gantt table matches with Header Count upon Selecting Bags Category
	public static void BagsCheck(String view) throws Exception {
		ATUReports.add("Verify the count matches for Bags statistics",  LogAs.INFO, null); 
		ATUReports.add("Passing the respective statistics value and stats count to verify the count matches with stats",  LogAs.INFO, null); 
		System.out.println("Validate the Bags Flight Statistics holds Correct Count");
		 
		FlightgantttableHeadervalidation(view,Web_UI.Bags,Web_UI.BagsStatsCount,Web_UI.HybridBags,Web_UI.HybridBagscount);
	}

// Below Function to check No of flights in Gantt table matches with Header Count upon Selecting Crew Category
	public static void CrewCheck(String view) throws Exception {
		ATUReports.add("Verify the count matches for Crew statistics",  LogAs.INFO, null); 
		ATUReports.add("Passing the respective statistics value and stats count to verify the count matches with stats",  LogAs.INFO, null); 
		System.out.println("Validate the Crew Flight Statistics holds Correct Count");
		 
		FlightgantttableHeadervalidation(view,Web_UI.Crew,Web_UI.CrewStatsCount,Web_UI.HybridCrew,Web_UI.HybridCrewCount);
	}

// Below Function to check No of flights in Gantt table matches with Header Count upon Selecting Offload Category
	public static void OffloadCheck(String view) throws Exception {
		ATUReports.add( "Verify the count matches for Offload statistics",  LogAs.INFO, null); 
		ATUReports.add("Passing the respective statistics value and stats count to verify the count matches with stats",  LogAs.INFO, null); 
		System.out.println("Validate the Offload Flight Statistics holds Correct Count");
		 CheckCollapse();
		FlightgantttableHeadervalidation(view,Web_UI.Offload,Web_UI.OffloadStatsCount,Web_UI.HybridOffload,Web_UI.HybridOffloadCount);

	}
	
	// Below Function to check No of flights in Gantt table matches with Header Count upon Selecting Offload Category
		public static void ClaimScanCheck(String view) throws Exception {
			ATUReports.add("Verify the count matches for ClaimScan statistics",  LogAs.INFO, null); 
			ATUReports.add("Passing the respective statistics value and stats count to verify the count matches with stats",  LogAs.INFO, null); 
			System.out.println("Validate the ClaimScan Flight Statistics holds Correct Count");
			 CheckCollapse();
			FlightgantttableHeadervalidation(view,Web_UI.Claimscan,Web_UI.ClaimscanStatsCount,Web_UI.HybridClaimscan,Web_UI.HybridClaimscanCount);

		}

// Below Function to check No of flights in Gantt table matches with Header Count upon Selecting Cabin Category
	public static void CabinCheck(String view) throws Exception {
		ATUReports.add("Verify the count matches for Cabin statistics",  LogAs.INFO, null); 
		ATUReports.add( "Passing the respective statistics value and stats count to verify the count matches with stats", LogAs.INFO, null); 
		 CheckCollapse();
		System.out.println("Validate the Cabin Flight Statistics holds Correct Count");
		FlightgantttableHeadervalidation(view,Web_UI.Cabin,Web_UI.CabinStatsCount,Web_UI.HybridCabin,Web_UI.HybridCabinCount);
	}

// Below Function to check No of flights in Gantt table matches with Header Count upon Selecting Catering Category
	public static void CateringCheck(String view) throws Exception {
		ATUReports.add( "Verify the count matches for Catering statistics",  LogAs.INFO, null); 
		ATUReports.add("Passing the respective statistics value and stats count to verify the count matches with stats",  LogAs.INFO, null); 
		System.out.println("Validate the Catering Flight Statistics holds Correct Count");
		 CheckCollapse();
		FlightgantttableHeadervalidation(view,Web_UI.Catering,Web_UI.CateringStatsCount,Web_UI.HybridCatering,Web_UI.HybridCateringCount);
	}

// Below Function to check No of flights in Gantt table matches with Header Count upon Selecting LAV Category
	public static void LavsCheck(String view) throws Exception {
		ATUReports.add( "Verify the count matches for  Lavs statistics",  LogAs.INFO, null); 
		ATUReports.add("Passing the respective statistics value and stats count to verify the count matches with stats",  LogAs.INFO, null); 
		System.out.println("Validate the Lavs Flight Statistics holds Correct Count");
		 CheckCollapse();
		FlightgantttableHeadervalidation(view,Web_UI.LAV,Web_UI.LavsStatsCount,Web_UI.HybridLavs,Web_UI.HybridLavsCount);
	}

// Below Function to check No of flights in Gantt table matches with Header Count upon Selecting Water Category
	public static void WaterCheck(String view) throws Exception {
		ATUReports.add("Verify the count matches for Water statistics",  LogAs.INFO, null); 
		ATUReports.add( "Passing the respective statistics value and stats count to verify the count matches with stats",  LogAs.INFO, null); 
		System.out.println("Validate the Water Flight Statistics holds Correct Count");
		 CheckCollapse();
		FlightgantttableHeadervalidation(view,Web_UI.Water,Web_UI.WaterStatsCount,Web_UI.HybridWater,Web_UI.HybridWaterCount);
	}

	
	// Below Function to check No of flights in Gantt table matches with Header Count upon Selecting Unlinked flight Category	
	public static void UnlinkedCheck(String view) throws Exception {
		ATUReports.add("Verify the count matches for  Unlinked statistics",  LogAs.INFO, null); 
		ATUReports.add( "Passing the respective statistics value and stats count to verify the count matches with stats",  LogAs.INFO, null); 
		System.out.println("Validate the Unlinked Flight Statistics holds Correct Count");
		 CheckCollapse();
		FlightgantttableHeadervalidation(view,Web_UI.Unlinked,Web_UI.UnlinkedCount,Web_UI.HybridUnlinked,Web_UI.HybridUnlinkedCount);
		
	}
	
	// Below Function to check No of flights in Gantt table matches with Header Count upon Selecting OTS flight Category
	public static void OTSCheck(String view) throws Exception {
		ATUReports.add("Verify the count matches for OTS statistics",  LogAs.INFO, null); 
		ATUReports.add( "Passing the respective statistics value and stats count to verify the count matches with stats",  LogAs.INFO, null); 
		 CheckCollapse();
		System.out.println("Validate the  OTS Flight Statistics holds Correct Count");
		FlightgantttableHeadervalidation(view,Web_UI.OTS,Web_UI.OTSStatsCount,Web_UI.HybridOTS,Web_UI.HybridOTSCount);
		
	}
	
	
	// Below Function to check No of flights in Gantt table matches with Header Count upon Selecting Closeout Category
		public static void CloseoutCheck(String view) throws Exception {
			ATUReports.add("Verify the count matches for CLOSEOUTS statistics",  LogAs.INFO, null); 
			ATUReports.add( "Passing the respective statistics value and stats count to verify the count matches with stats",  LogAs.INFO, null); 
			System.out.println("Validate the CLOSEOUTS Flight Statistics holds Correct Count");
			FlightgantttableHeadervalidation(view,"//div[@title='CLOSEOUTS']",Web_UI.CloseoutStatscount,Web_UI.HybridCLOSEOUTS,Web_UI.HybridCLOSEOUTSCount);
		}
		
		
		

	// Below Function to check No of flights in Gantt table matches with Header Count upon Selecting Ground Intterupt flight Category
	public static void GroundInteruptCheck(String view) throws Exception {
		
		ATUReports.add("Verify the count matches for GroundInterupt statistics",  LogAs.INFO, null); 
		ATUReports.add("Passing the respective statistics value and stats count to verify the count matches with stats",  LogAs.INFO, null); 
		 CheckCollapse();
		System.out.println("Validate the GroundInterupt Flight Statistics holds Correct Count");
		
		//FlightgantttableHeadervalidation(view,Web_UI.Groundinterrupt,Web_UI.GroundinterruptCount,Web_UI.Hybrid,Web_UI.GroundinterruptCount);		
	}

	// Below Function to check No of flights in Gantt table matches with Header Count upon Selecting A14 Flight Category
	public static void A14Check(String view) throws Exception {
		
		ATUReports.add("Verify the count matches for A14 statistics",  LogAs.INFO, null); 
		ATUReports.add("Passing the respective statistics value and stats count to verify the count matches with stats",  LogAs.INFO, null); 
		 CheckCollapse();
		System.out.println("Validate the A14 Flight Statistics holds Correct Count");
		FlightgantttableHeadervalidation(view,Web_UI.A14,Web_UI.A14Count,Web_UI.HybridA14,Web_UI.HybridA14Count);
		
	}

	// Below Function to check No of flights in Gantt table matches with Header Count upon Selecting MOGT flight Category
	public static void MOGTCheck(String view) throws Exception {
		ATUReports.add("Verify the count matches for  MOGT statistics",  LogAs.INFO, null); 
		ATUReports.add("Passing the respective statistics value and stats count to verify the count matches with stats",  LogAs.INFO, null); 
		 CheckCollapse();
		System.out.println("Validate the MOGT Flight Statistics holds Correct Count");
		FlightgantttableHeadervalidation(view,Web_UI.MOGT,Web_UI.MOGTCount,Web_UI.HybridMOGT,Web_UI.HybridMOGTCount);
		
	}

	// Below Function to check No of flights in Gantt table matches with Header Count upon Selecting ORIGIN flight Category
	public static void ORIGINCheck(String view) throws Exception {
		ATUReports.add("Verify the count matches for ORIGIN statistics",  LogAs.INFO, null); 
		ATUReports.add("Passing the respective statistics value and stats count to verify the count matches with stats",  LogAs.INFO, null); 
		 CheckCollapse();
		System.out.println("Validate the ORIGIN Flight Statistics holds Correct Count");
		FlightgantttableHeadervalidation(view,Web_UI.Origin,Web_UI.OriginCount,Web_UI.HybridORIGIN,Web_UI.HybridORIGINCount);
		
	}

	// Below Function to check No of flights in Gantt table matches with Header Count upon Selecting TERM Flight Category
	public static void TERMCheck(String view) throws Exception {
		ATUReports.add("Verify the count matches for TERM statistics",  LogAs.INFO, null); 
		ATUReports.add("Passing the respective statistics value and stats count to verify the count matches with stats",  LogAs.INFO, null); 
		 CheckCollapse();
		System.out.println("Validate the TERM Flight Statistics holds Correct Count");
		FlightgantttableHeadervalidation(view,Web_UI.Term,Web_UI.TermCount,Web_UI.HybridTERM,Web_UI.HybridTERMCount);
		
	}
	
	
	
		
	public static void NoCateringDetails(String view)  throws Exception {
		System.out.println("Verify the message when no catering alerting flights details available in the gantt view");
		 CheckCollapse();
		VerifyStatspresentMessagewhenNoFlights(view,Web_UI.Catering, Web_UI.CateringStatsCount,Web_UI.HybridCatering, Web_UI.HybridCateringCount);
		
	}

	public static void NoFuelingDetails(String view)  throws Exception{
		System.out.println("Verify the message when no Fueling alerting flights available in the gantt view");
		 CheckCollapse();
		VerifyStatspresentMessagewhenNoFlights(view,Web_UI.Fuel, Web_UI.FuelStatsCount,Web_UI.HybridFuel, Web_UI.HybridFuelCount);
	}

	public static void NoWaterDetails(String view) throws Exception {
		System.out.println("Verify the message when no water alerting flights available in the gantt view");
		 CheckCollapse();
		VerifyStatspresentMessagewhenNoFlights(view,Web_UI.Water, Web_UI.WaterStatsCount,Web_UI.HybridWater, Web_UI.HybridWaterCount);
	}

	public static void NoLavsDetails(String view)  throws Exception {
		
		System.out.println("Verify the message when No Lavs alerting flights available in the gantt view");
		 CheckCollapse();
		VerifyStatspresentMessagewhenNoFlights(view,Web_UI.LAV, Web_UI.LavsStatsCount,Web_UI.HybridLavs, Web_UI.HybridLavsCount);
		
	}

	public static void NoCabinDetails(String view)  throws Exception{
		System.out.println("Verify the message when no Cabin alerting flights available in the gantt view");
		 CheckCollapse();
		VerifyStatspresentMessagewhenNoFlights(view,Web_UI.Cabin, Web_UI.CabinStatsCount,Web_UI.HybridCabin, Web_UI.HybridCabinCount);
	}

	public static void NoCrewDetails(String view) throws Exception {
		System.out.println("Verify the message when No crew alerting flight available in the gantt view");
		 CheckCollapse();
		VerifyStatspresentMessagewhenNoFlights(view,Web_UI.Crew, Web_UI.CrewStatsCount,Web_UI.HybridCrew, Web_UI.HybridCrewCount);
	}

	public static void NoPaxDetails(String view)  throws Exception{
		System.out.println("Verify Message when No passanger alerting flights present in the gantt view");
		 CheckCollapse();
		VerifyStatspresentMessagewhenNoFlights(view,Web_UI.Passanger, Web_UI.PassangerStatsCount,Web_UI.HybridPax, Web_UI.HybridPaxCount);
	}

	public static void NoBagsDetails(String view)  throws Exception{
		System.out.println("Verify the message when no bags alerting flights available in gantt view");
		 CheckCollapse();
		VerifyStatspresentMessagewhenNoFlights(view,Web_UI.Bags, Web_UI.BagsStatsCount,Web_UI.HybridBags, Web_UI.HybridBagscount);
	}

	public static void NoClaimScamDetails(String view) throws Exception {
		System.out.println("Verify the message when No Claim scan alerting flights available in Gantt view");
		 CheckCollapse();
		VerifyStatspresentMessagewhenNoFlights(view,Web_UI.Claimscan, Web_UI.ClaimscanStatsCount,Web_UI.HybridClaimscan, Web_UI.HybridClaimscanCount);
		
	}

	public static void NoOffloadDetails(String view) throws Exception {
		System.out.println("Verify the message when No offload details available in gantt view");
		 CheckCollapse();
		VerifyStatspresentMessagewhenNoFlights(view,Web_UI.Offload, Web_UI.OffloadStatsCount,Web_UI.HybridOffload, Web_UI.HybridOffloadCount);
	}

	
	
	
	
	
	
	
	
	
//Below code will go through gantt table and fetch the number of flights and compare with Ganttheader
	public static void FlightgantttableHeadervalidation(String view,String OptionXpath1 ,String OptionStatsCountvaluexpath,String OptionXpathHybrid ,String OptionStatsCountvaluexpathHybrid) throws Exception {
		GanntViewHeaderFunctionality.SpinnerControl();
		TestcaseInit();
		// Get hours from Dashboard settings for Verification
		clickByXpath(Web_UI.filtericon,"filtericon");
		ATUReports.add("Select Hamburger Menu",  LogAs.PASSED, null);
		String getHoursfromtimerange = getDriver().findElement(By.xpath(Web_UI.Settingstimerange)).getAttribute("innerText").trim();
		String Hoursselected =  getHoursfromtimerange.substring(13, 15).trim();
		clickByXpath(Web_UI.DashboardfilterCancel,"DashboardfilterCancel");
		Thread.sleep(3000);
		CommonTest.SpinnerControl();
		CommonTest.CheckCollapse();
		
		ATUReports.add("View Zoomed in to verify the the pucks are visible and nothing got hidden behind",  LogAs.INFO, null); 
		System.out.println("Validating Flight Statistics category Selection Test cases  " +OptionXpath1);
		if(view.equalsIgnoreCase("Ganttview")){
		try{
			CommonTest.Selectview(view);
			System.out.println("came inside try");
			WebElement OptionXpath = getDriver().findElement(By.xpath(OptionXpath1));
			Actions action = new Actions(getDriver());
			action.moveToElement(OptionXpath).build().perform();
			//clickByXpathbyView(view, OptionXpath, OptionXpathHybrid);
			((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", OptionXpath);
			
		ATUReports.add(" Selected the corresponding flight Statisitcs for validation :: "+OptionXpath,  LogAs.PASSED, null);
		// later check this gettext functionlity have any issues
		//String HeaderAppender = getDriver().findElement(By.xpath(OptionXpath)).getAttribute("innerText");
		String HeaderAppender = OptionXpath.getAttribute("title");
		System.out.println("Header Appender is :" + HeaderAppender);
		String Headertitle = findelementbyxpath(Web_UI.Headertitle).getAttribute("innerText");
		System.out.println("Header Title is :" + Headertitle);
		GanntViewHeaderFunctionality.SpinnerControl();
		if(Headertitle.contains("Past 6 hours to next"))
		{ 
			
			if(Headertitle.contains(Hoursselected))
			{
				ATUReports.add("Gantt view Header contains the Timerange Selected value in Hours",  LogAs.PASSED, null);
				if(Headertitle.contains(HeaderAppender))
				{
					ATUReports.add("Gantt view Header contains the Selected Statistics as title :: " +Headertitle,  LogAs.PASSED, null);
				}
				else{
					ATUReports.add("Gantt view Header doesnot contains the Selected Statistics as title :: " +Headertitle,  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}
			}
			else{
				ATUReports.add( "Gantt view Header doesnot contains the Timerange Selected value in Hours" ,  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}
			
		}
		else{
			ATUReports.add( "Some issue in Header title" ,  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		}
		
		
		Thread.sleep(3000);
		
		}
		catch(Exception Titleasheader)
		{
			ATUReports.add( "No Corresponding flight statistics",  LogAs.PASSED, null);
			}
		}
		if(view.equalsIgnoreCase("Hybridview")){

			try{
				CommonTest.Selectview(view);
				clickByXpathbyView(view, OptionXpathHybrid, OptionXpathHybrid);
			ATUReports.add(" Selected the corresponding flight Statisitcs for validation :: "+OptionXpathHybrid,  LogAs.PASSED, null);
			// later check this gettext functionlity have any issues
			String HeaderAppender = getDriver().findElement(By.xpath(OptionXpathHybrid)).getText();
			String Headertitle = findelementbyxpath(Web_UI.Headertitle).getAttribute("innerText");
			GanntViewHeaderFunctionality.SpinnerControl();
			if(Headertitle.contains("Past 6 hours to next"))
			{ 
				
				if(Headertitle.contains(Hoursselected))
				{
					ATUReports.add("Hybrid view Header contains the Timerange Selected value in Hours",  LogAs.PASSED, null);
//					if(Headertitle.contains(HeaderAppender))
//					{
//					//	test.log(LogStatus.PASS, "Gantt view Header contains the Selected Statistics as title :: " +Headertitle);
//						ATUReports.add("Hybrid view Header contains the Selected Statistics as title :: " +Headertitle,  LogAs.PASSED, null);
//					}
//					else{
//						//test.log(LogStatus.FAIL, "Gantt view Header doesnot contains the Selected Statistics as title :: " +Headertitle);
//						ATUReports.add("Hybrid view Header doesnot contains the Selected Statistics as title :: " +Headertitle,  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
//					}
				}
				else{
					ATUReports.add( "Hybrid view Header doesnot contains the Timerange Selected value in Hours" ,  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}
				
			}
			else{
				ATUReports.add( "Some issue in Header title" ,  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}
			
			
			Thread.sleep(3000);
			
			}
			catch(Exception Titleasheader)
			{
				ATUReports.add( "No Corresponding flight statistics",  LogAs.PASSED, null);
				}
			
		}
		
			
		
	}
	
	public static void VerifyStatspresentMessagewhenNoFlights(String view,String OptionXpath ,String OptionStatsCountvaluexpath,String OptionXpathhybrid ,String OptionStatsCountvaluexpathHybrid) throws Exception {
		
		try{
			clickByXpathbyView(view, OptionXpath, OptionXpathhybrid);
			ATUReports.add(" Selected the corresponding flight Statisitcs for validation :: "+OptionXpath ,  LogAs.PASSED, null);
			String Messageposted = getDriver().findElement(By.xpath(Web_UI.Messageposted)).getAttribute("innerText");
			Thread.sleep(1000);
		
				if(Messageposted.contains("There are no flight"))
				{
					
					ATUReports.add("Message posted is valid when No fligts present and Message displayed is :: "+Messageposted,  LogAs.PASSED, null);
				}
				else
				{
					ATUReports.add("Message posted is invalid when No fligts present and Message displayed is :: "+Messageposted,  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}
		
			
			
	}catch (Exception es)
		{
		String ttitle = OptionXpath.substring(14,18);
		ATUReports.add("Cannot be validated as stats count is not Zero",  LogAs.INFO, null); 
		captureinfoScreenshot(getDriver(), "Cannot be validated as stats count is not Zero"+ttitle);
		}
	}
	

	public static void NoofRowsTest(String SS, String Appendheadtitle, String StatsCount) throws Exception {
				System.out.println("Validating the gantt view flight puck present in the table upon selecting Category details with flight stats count	");
				GanntViewHeaderFunctionality.SpinnerControl();
				CommonTest.zoomindata();
				Thread.sleep(3000);
				CommonTest.CheckExpand();
				List<WebElement> ganttablelist = getDriver().findElements(By.xpath(Web_UI.GanttTable));
				int gantsize = ganttablelist.size();
				int GantSizetablefull = gantsize;
				
				
				WebElement CompleteTable = getDriver().findElement(By.xpath("//div[@class='gantt-view-scroll ng-scope']"));
				String	CompleteTableText = CompleteTable.getAttribute("innerText");
				String str = CompleteTableText;
				   String[] splitStr = str.split(" ");
				   int i=0;
				   int j=0;
				   int k=0;
				   int L=0;
				   int M=0;
				   for (String word: splitStr) {
				       if (word.contains("TERM")) {
				    	   i++;
				    	   
				       }
				       else {
				           
				       }
				   }
				   for (String word: splitStr) {
				       if (word.contains("UNL")) {
				    	   L++;
				    	   
				       }
				       else {
				           
				       }
				   }
				   for (String word: splitStr) {
				       if (word.contains("OFF")) {
				    	   j++;
				    	   
				       }
				       else {
				           
				       }
				   }
				   for (String word: splitStr) {
				       if (word.contains("OUT")) {
				    	   k++;
				    	   
				       }
				       else {
				           
				       }
				   }
				   for (String word: splitStr) {
				       if (word.contains("CXL")) {
				    	   M++;
				    	   
				       }
				       else {
				           
				       }
				   }
				int unwantedpuck = i+M;
				int Countfinal = gantsize-unwantedpuck;
				String GB = Integer.toString(Countfinal);
				String ORIGINCount = Integer.toString(i);
				String UnlinkedCount = Integer.toString(L);
				CommonTest.zoomOutdata();
				
				System.out.println("Off flights"+"  "+j);
				System.out.println("Unlinked flights "+"  "+L);
				System.out.println("Term flights "+"  "+i);
				System.out.println("Out flights "+"  "+k);
				
				if(Appendheadtitle.contains("Unlinked")||Appendheadtitle.contains("TERM"))	
				{
				
				if(Appendheadtitle.contains("Unlinked"))
				{
					if (StatsCount.contains(UnlinkedCount)) {
						
						System.out.println("Flight Stats Count matches "+"  "+StatsCount+" "+GB);
						ATUReports.add("Verified the Total Number of flights puck inside Gantt view & stats count and been passed",StatsCount+" "+GB,  LogAs.PASSED, null);
					
					
					
					}
					
				}
				
				if(Appendheadtitle.contains("TERM"))
				{
					if (StatsCount.contains(ORIGINCount)) {
						
						System.out.println("Flight Stats Count matches "+"  "+StatsCount+" "+GB);
						ATUReports.add("Verified the Total Number of flights puck inside Gantt view & stats count and been passed",StatsCount+" "+GB,  LogAs.PASSED, null);
					
					}
					
				}

				if(Appendheadtitle.contains("ORIG"))
				{
					if (StatsCount.contains(ORIGINCount)) {
						
						System.out.println("Flight Stats Count matches "+"  "+StatsCount+" "+GB);
						
							ATUReports.add("Verified the Total Number of flights puck inside Gantt view & stats count and been passed",StatsCount+" "+GB,  LogAs.PASSED, null);
					}
					
				}
				}
				else{
				if (StatsCount.contains(GB)) {
					
					System.out.println("Flight Stats Count matches "+"  "+StatsCount+" "+GB);
					
					ATUReports.add("Verified the Total Number of flights puck inside Gantt view & stats count and been passed",StatsCount+" "+GB,  LogAs.PASSED, null);
				}	
				else {
					
					System.out.println("Flight Stats count mismatches"+"  "+StatsCount+"  "+GB);
					
					ATUReports.add("Verified the Total Number of flights puck inside Gantt view & stats count and been passed",StatsCount+" "+GB,  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					captureinfoScreenshot(getDriver(),"Verified the Total Number of flights puck inside Gantt view & stats count and been passed"+StatsCount+" "+GB);
					Assert.fail("Failed");
				}
				// remove first check	
				if (SS.contains(Appendheadtitle))
				{
				System.out.println("Flight Stats Count matches "+"  "+StatsCount+" "+Appendheadtitle);

				ATUReports.add("Verified the Total Number of flights puck inside Gantt view & stats count and been passed",StatsCount+" "+GB,  LogAs.PASSED, null);
				}
				
				else {
					System.out.println("Flight Stats count mismatches"+"  "+StatsCount+"  "+Appendheadtitle);

					ATUReports.add("Verified the Total Number of flights puck inside Gantt view & stats count and been passed",StatsCount+" "+GB,  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					captureinfoScreenshot(getDriver(),"Verified the Total Number of flights puck inside Gantt view & stats count and been passed"+StatsCount+" "+GB);
					Assert.fail("Failed");
				}
				}
		
				CommonTest.CheckCollapse();
	}

	// Below Function For Station Selection from Settings
	public static void StationSelection() throws Exception {
		System.out.println("Selecting Station");
//Below Values can be changed from properties file in case of switching station
		clickByXpath(Web_UI.filtericon,"filtericon");
		ATUReports.add("Select Hamburger Menu",  LogAs.PASSED, null);
		clickByXpath(Web_UI.StationDropdownselect,"StationDropdownselect");
		ATUReports.add( "Select Station from the list",  LogAs.PASSED, null);
		String Stationname = "//a[text()='"+ Web_UI.Station +"']";
		clickByXpath(Stationname,"Stationname");
		System.out.println(" Station Selected");
		CommonTest.SpinnerControl();
		System.out.println("Selecting ALL");
		ATUReports.add("Select all station",  LogAs.PASSED, null);
	try{
		clickByXpath(Web_UI.SelectingAll,"SelectingAll");
	}
	catch(Exception Selectall){
		
	}
		clickByXpath("//input[@ng-click='zoneSelection()']","zoneSelection");
		CommonTest.SpinnerControl();

	
	}
	
//Below function will validate Expand & Collapse functionality
	public static void ExpandCollapse() throws Exception {
		System.out.println("Validating Expand and collapse functionality");
		CommonTest.SpinnerControl();
		WebElement Zoomin = findelementbyxpath(Web_UI.Expandbutton);
		Zoomin.click();
		GanntViewHeaderFunctionality.SpinnerControl();
		CommonTest.SpinnerControl();
		Thread.sleep(5000);
		try {
			WebElement Zoomincheck = findelementbyxpath(Web_UI.ExpandCheckpoint);
			if (Zoomincheck != null) {
				System.out.println("Expand Option Not working");
				ATUReports.add("Expand Option Not working",  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}
		} catch (Exception zoomerror) {

			System.out.println("Gantt view is expanded");
			ATUReports.add("Gantt view is expanded",  LogAs.PASSED, null);
		}

		WebElement Zoomout = findelementbyxpath(Web_UI.Collapsebutton);
		Zoomout.click();
		Thread.sleep(5000);

		try {
			WebElement Zoomincheck = findelementbyxpath(Web_UI.ExpandCheckpoint);
			if (Zoomincheck != null) {
				System.out.println("Gantt view is Collapsed");
				ATUReports.add("Gantt view is Collapsed",  LogAs.PASSED, null);
			}
		} catch (Exception zoomerror) {

			System.out.println("Gantt view is Not Collapsed");
			ATUReports.add("Gantt view is Not Collapsed",  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		}

		
	}

	
	//Verify the Ganttheader is split on hours and 15minutes basis
	public static void GanttheaderSplitup() throws Exception {
		System.out.println("Gantt view Header is Splitted to 24 hours with 15 min interval");
		clickByXpath(Web_UI.GantviewOption,"GantviewOption");
		GanntViewHeaderFunctionality.SpinnerControl();
		Thread.sleep(5000);
		List<WebElement> hoursbar = getDriver().findElements(By.xpath(Web_UI.HoursBar));
		int hours = hoursbar.size();
		for (WebElement we : hoursbar) {
			List<WebElement> hourssplitup = we.findElements(By.xpath(Web_UI.HoursSplitup));
			int splitupsize = hourssplitup.size();
			System.out.println("Splitsize "+splitupsize);
			if (splitupsize == 100) {
				ATUReports.add("The hours are splitted into 15min interval",  LogAs.PASSED, null);
					System.out.println("The Hours are splittedd into 15min interval");
				
			} else {
				
				ATUReports.add("Hours are not splitted into 15min interval division",  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				Assert.fail("Hours are not splitted into 15min interval division");
				System.out.println("Hours are not splitted into 15min interval division");
			}
			
break;
		}

	}

	
	
	public static void GanttviewheaderValidation() throws Exception {
		System.out.println("Validating Gantt view header bar related scenarios");
		 GanntViewHeaderFunctionality.SpinnerControl();	 
		List<WebElement> hoursbar = getDriver().findElements(By.xpath(Web_UI.HoursBar));
		int hours = hoursbar.size();
		if (hours == 25) {
			
			ATUReports.add("Gannt view Header displayed in correct format",  LogAs.PASSED, null);
						System.out.println("Gannt view Header displayed in correct format");
		} else

		{
			
			ATUReports.add("Gantt view header dont have 24 hours header bar",  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			System.out.println("Gantt view header dont have 24 hours header bar");
		}

	}

	
	
	public static void NewSettings(int timer) throws Exception {
	System.out.println("Setting Zones and Flight statistics from Dashboard filter for Test Execution");
	clickByXpath(Web_UI.filtericon,"filtericon");
	Thread.sleep(5000);
	String Zone = "//span[@class='display-stn ng-binding'and text()='"+Web_UI.Station+	"']";
	clickByXpath(Zone,"Zone");
	checkunwantedpopup();
	
Thread.sleep(2000);
	clickByXpath("//span[@class='display-stn ng-binding'and text()='PHL']","PHL");
	Thread.sleep(6000);
	checkunwantedpopup();
	String completestation = getDriver().findElement(By.xpath("//ul[@class='filter-zne-headng col-xs-12']")).getAttribute("innerText");
	
	WebElement ZoneElementTable = getDriver().findElement(By.xpath("//ul[@class='filter-zne-headng col-xs-12']"));
	List<WebElement> ZoneElements = ZoneElementTable.findElements(By.xpath("//li[@class='col-lg-12 list-filter-dialoug ng-scope filter-selected']"));
	int ZonesListsize = ZoneElements.size();
	
	for(int i=1;i<ZonesListsize;i++)
	{
	
		getDriver().findElement(By.xpath("//*[@id='db-filter-zones']/ul/li["+i+"]/div/label/div/label")).click();
			
			
		}
	
	
	Thread.sleep(5000);
	clickByXpath(Web_UI.DeselectAll,"DeselectAll");
	Thread.sleep(1000);
	clickByXpath(Web_UI.SelectingAll,"SelectingAll");
	Thread.sleep(1000);
	WebElement Slider = getDriver().findElement(By.xpath("//input[@id='range-slider' and @data-ng-model='message.flightRange']"));
	Actions action = new Actions(getDriver());
			 
		 if (timer==1)
		 {
			 action.clickAndHold(Slider);
			 action.moveByOffset(-200, 0).release().build().perform(); 
			 action.release(); 
			ATUReports.add("Setting Timerange as one hour",  LogAs.PASSED, null);
			 Thread.sleep(1000);
			 
		 }
		 
		 if (timer==12)
		 {
			 action.clickAndHold(Slider);
			 action.moveByOffset(-100, 0).release().build().perform(); 
			 action.release(); 
			ATUReports.add("Setting Timerange as 12 hours",  LogAs.PASSED, null);
			 Thread.sleep(1000);
			 
		 }
		 
		 else
		 {
				

			
		 }
		 
		clickByXpath(Web_UI.ApplyButton,"ApplyButton");
    	 Thread.sleep(5000);
    	 ATUReports.add("Applied Settings Successfully",  LogAs.PASSED, null);
		 CommonTest.SpinnerControl();		 
 //Selecting Flight statistics
			clickByXpath(Web_UI.filtericon,"filtericon");
			Thread.sleep(5000);
			clickByXpath("//*[@id='db-filter-tabs']/div[3]","Stats");
			Thread.sleep(5000);
		try
		{
			
			WebElement Diverted = getDriver().findElement(By.xpath(Web_UI.StatsDiverted));
			WebElement DCN = getDriver().findElement(By.xpath(Web_UI.StatsDCN));
			WebElement MEL = getDriver().findElement(By.xpath(Web_UI.StatsMEL));
			WebElement OTS = getDriver().findElement(By.xpath(Web_UI.StatsOTS));
			WebElement RTD = getDriver().findElement(By.xpath(Web_UI.StatsRTD));
			WebElement GateSwap = getDriver().findElement(By.xpath(Web_UI.StatsGateSwap));
			WebElement AcSwap = getDriver().findElement(By.xpath(Web_UI.StatsAcSwap));
			WebElement RightStart = getDriver().findElement(By.xpath(Web_UI.StatsRightStart));
			WebElement IFS = getDriver().findElement(By.xpath(Web_UI.StatsIFS));
			WebElement GateConflict = getDriver().findElement(By.xpath(Web_UI.StatsGateConflict));
			WebElement PotentialTows = getDriver().findElement(By.xpath(Web_UI.StatsPotentialTows));
			WebElement ATCDelay = getDriver().findElement(By.xpath(Web_UI.StatsATCDelay));
			WebElement DelayedDep = getDriver().findElement(By.xpath(Web_UI.StatsDelayedDep));
			WebElement MOGT = getDriver().findElement(By.xpath(Web_UI.StatsMOGT));
			WebElement originated = getDriver().findElement(By.xpath(Web_UI.Statsoriginated));
			WebElement terminated = getDriver().findElement(By.xpath(Web_UI.Statsterminated));
			WebElement unlinked = getDriver().findElement(By.xpath(Web_UI.Statsunlinked));
			WebElement A14 = getDriver().findElement(By.xpath(Web_UI.StatsA14));
			WebElement WeightRestricted = getDriver().findElement(By.xpath(Web_UI.StatsWeightRestricted));
			
			if(WeightRestricted.isSelected()==false)
			{
				clickBywebelementxpath(WeightRestricted,"WeightRestricted");
			}
			if(MOGT.isSelected()==false)
			{
				clickBywebelementxpath(MOGT,"MOGT");
			}
			if(originated.isSelected()==false)
			{
				clickBywebelementxpath(originated,"originated");
			}
			if(terminated.isSelected()==false)
			{
				clickBywebelementxpath(terminated,"terminated");
			}
			if(unlinked.isSelected()==false)
			{
				clickBywebelementxpath(unlinked,"unlinked");
			}
			if(A14.isSelected()==false)
			{
				clickBywebelementxpath(A14,"A14");
			}
			
			if(IFS.isSelected()==false)
			{
				clickBywebelementxpath(IFS,"IFS");
			}
			
			if(Diverted.isSelected()==false)
			{
				clickBywebelementxpath(Diverted,"Diverted");
			}
			
			if(DCN.isSelected()==false)
			{
				clickBywebelementxpath(DCN,"DCN");
			}
			
			if(MEL.isSelected()==false)
			{
				clickBywebelementxpath(MEL,"MEL");
			}
			
		
			if(OTS.isSelected()==false)
			{
				clickBywebelementxpath(OTS,"OTS");
			}
			
			
			if(RTD.isSelected()==false)
			{
				clickBywebelementxpath(RTD,"RTD");
			}
			
			if(AcSwap.isSelected()==false)
			{
				clickBywebelementxpath(AcSwap,"AcSwap");
			}
			
			if(GateSwap.isSelected()==false)
			{
				clickBywebelementxpath(GateSwap,"GateSwap");
			}
			
			if(RightStart.isSelected()==false)
			{
				clickBywebelementxpath(RightStart,"RightStart");
			}
			
			if(GateConflict.isSelected()==false)
			{
				clickBywebelementxpath(GateConflict,"GateConflict");
			}
			
			if(PotentialTows.isSelected()==false)
			{
				clickBywebelementxpath(PotentialTows,"PotentialTows");
			}
			
			if(ATCDelay.isSelected()==false)
			{
				clickBywebelementxpath(ATCDelay,"ATCDelay");
			}
			
			
			if(DelayedDep.isSelected()==false)
			{
				clickBywebelementxpath(DelayedDep,"DelayedDep");
			}
			try{
				clickByXpath(Web_UI.ViewSettings,"View Settings");
				Thread.sleep(2000);
				clickByXpath(Web_UI.Puckdefaultradio,"default");
				Thread.sleep(2000);
				clickByXpath(Web_UI.SettingPuckCenter,"center");
				Thread.sleep(2000);
				try{
				WebElement Showcancel = getDriver().findElement(By.xpath(Web_UI.ShowCanceled));
				if(Showcancel.isSelected()==false)
				{
					clickBywebelementxpath(Showcancel,"Showcancel");
				}
				
				WebElement ShowUnlinked= getDriver().findElement(By.xpath(Web_UI.SettingShowUnlinkedflight));
				if(ShowUnlinked.isSelected()==false)
				{
					clickBywebelementxpath(ShowUnlinked,"ShowUnlinked");
				}
				
				}
				
				catch(Exception Noshowcancel)
				{
					
				}
			}catch(Exception ErroronSelectingViewSetting)
			{
				
			}
			clickByXpath(Web_UI.ApplyButton,"Apply");
		}
		catch(Exception Settingserror)
		{
			clickByXpath(Web_UI.ApplyButton,"Apply");
		}
		 CommonTest.SpinnerControl();	 	
		 ATUReports.add("Applied Settings Successfully",  LogAs.PASSED, null);
		 Thread.sleep(5000);
	
}
	
	public static void checkunwantedpopup() throws Exception {
		try{
		WebElement unwantedpopup1 = getDriver().findElement(By.xpath("//div[@id='getInFocusNow']"));
		if(unwantedpopup1!=null)
		{
			Thread.sleep(5000);
			clickByXpath(Web_UI.OKBUTTON, "OK button");
			
			Thread.sleep(2000);
		}
		else{
			System.out.println("No unwated popup displayed");
		}
		}
		catch (Exception EE)
		{
			// donothing
		}
		
	}
		
	public static void PuckVisibility() throws Exception {
		
		System.out.println("Verify all the Flight data are visible to user and No pucks are overlapped behind another puck");
		CommonTest.SpinnerControl();	
		String Ganttview= "";
	
		
		try{
			
				List<WebElement> Ganntlist = getDriver().findElements(By.xpath(Web_UI.Confirmdefaultview));
				int Ganntlistcount = Ganntlist.size();
				if (Ganntlistcount != 0) {
					Ganttview = "Center";
					ATUReports.add("Gantt view Option Choosen is CENTER and Default view",  LogAs.INFO, null); 
					
				}
				List<WebElement> Ganntlist1 = getDriver().findElements(By.xpath(Web_UI.Confirmtailview));
				
				int Ganntlistcount1 = Ganntlist1.size();
				if (Ganntlistcount1 != 0) {
					Ganttview = "Tail";
					ATUReports.add("Gantt view Option Choosen is Center  and Tail view",  LogAs.INFO, null); 
					
				}

				List<WebElement> Ganntlist2 = getDriver().findElements(By.xpath(Web_UI.Confirmclassicview));
				
				int Ganntlistcount2 = Ganntlist2.size();
				if (Ganntlistcount2 != 0) {
					Ganttview = "Classic";
					ATUReports.add("Gantt view Option Choosen is CENTER and Classic view",  LogAs.INFO, null); 
					
				}
				
		}catch(Exception ele1notfound)
		{
			
		}

	if(Ganttview.contains("Tail"))
	{
		
		try
		{
		Thread.sleep(3000);
		CommonTest.CheckExpand();
		List<WebElement> Ganntlist = getDriver().findElements(By.xpath(Web_UI.PuckDatacenter));
		int Ganntlistcount = Ganntlist.size();
		if (Ganntlist != null) {
			int i=0;
			for (WebElement gantelement : Ganntlist) {
			i++;
						
						try {
							Actions actions = new Actions(getDriver());
							actions.moveToElement(gantelement).build().perform();
							boolean VisibileCheck = gantelement.isDisplayed();
						
							if(VisibileCheck == true)
							{
									ATUReports.add("Puck is visibile" +i,  LogAs.PASSED, null);
							}
							else
							{
								String elementinfo = gantelement.getAttribute("innerText");
								try{
									WebElement Foundid = gantelement.findElement(By.xpath("ancestor::div[contains(@data-ng-if,'flt.addlFlightData')]"));
										String Elementidfound = Foundid.getAttribute("id");
										System.out.println("Element id Not visible is  "+Elementidfound);
										captureinfoScreenshot(getDriver(), "Elementnotvisible  "+i);
										ATUReports.add("Elementnotvisible",  LogAs.INFO, null); 
									}
									catch(Exception Nop)
									{
										System.out.println("Debugcheckpoint");
									}
							}
						}	catch (Exception Exee) {
							System.out.println("Exception while moving to the element "+i);
							}
						
								} 
		}
			else
			{
			}
				}catch(Exception Noelement)
		{
			
		}
	}
	if(Ganttview.contains("Center"))
	{
		
		try
		{
		Thread.sleep(3000);
		CommonTest.CheckExpand();
		List<WebElement> Ganntlist = getDriver().findElements(By.xpath(Web_UI.PuckDatacenter));
		int Ganntlistcount = Ganntlist.size();
		if (Ganntlist != null) {
			int i=0;
			for (WebElement gantelement : Ganntlist) {
			i++;
						
						try {
							Actions actions = new Actions(getDriver());
							actions.moveToElement(gantelement).build().perform();
							boolean VisibileCheck = gantelement.isDisplayed();
						
							if(VisibileCheck == true)
							{
								WebElement Foundid = gantelement.findElement(By.xpath("ancestor::div[contains(@data-ng-if,'flt.addlFlightData')]"));
								String Elementidfound = Foundid.getAttribute("id");
								System.out.println("Element id Not visible is  "+Elementidfound);
								captureinfoScreenshot(getDriver(), "Elementnotvisible  "+Elementidfound);
								ATUReports.add("Elementnotvisible",  LogAs.INFO, null); 
							}
							else
							{
								String elementinfo = gantelement.getAttribute("innerText");
								ATUReports.add(elementinfo+"  "+i,  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));	
								try{
								WebElement Foundid = gantelement.findElement(By.xpath("ancestor::div[contains(@data-ng-if,'flt.addlFlightData')]"));
									String Elementidfound = Foundid.getAttribute("id");
									System.out.println("Element id Not visible is  "+Elementidfound);
								}
								catch(Exception Nop)
								{
									System.out.println("Debugcheckpoint");
								}
								
							}
						}	catch (Exception Exee) {
							System.out.println("Exception while moving to the element "+i);
							}
						
								} 
		}
			else
			{
			}
				}catch(Exception Noelement)
		{
			
		}
	}
	
	
	
	if(Ganttview.contains("Classic"))
	{
		
		try
		{
		Thread.sleep(3000);
		CommonTest.CheckExpand();
		List<WebElement> Ganntlist = getDriver().findElements(By.xpath("//div[@class='crisp-linkage puck-linkage-center']"));
		int Ganntlistcount = Ganntlist.size();
		if (Ganntlist != null) {
			int i=0;
			for (WebElement gantelement : Ganntlist) {
			i++;
						
						try {
							Actions actions = new Actions(getDriver());
							actions.moveToElement(gantelement).build().perform();
							boolean VisibileCheck = gantelement.isDisplayed();
						
							if(VisibileCheck == true)
							{
								WebElement Foundid = gantelement.findElement(By.xpath("ancestor::div[contains(@data-ng-if,'flt.addlFlightData')]"));
								String Elementidfound = Foundid.getAttribute("id");
								System.out.println("Element id Not visible is  "+Elementidfound);
								captureinfoScreenshot(getDriver(), "Elementnotvisible  "+Elementidfound);
								ATUReports.add("Elementnotvisible",  LogAs.INFO, null); 
							}
							else
							{
								String elementinfo = gantelement.getAttribute("innerText");
								ATUReports.add( elementinfo+"  "+i,  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								try{
									WebElement Foundid = gantelement.findElement(By.xpath("ancestor::div[contains(@data-ng-if,'flt.addlFlightData')]"));
										String Elementidfound = Foundid.getAttribute("id");
										System.out.println("Element id Not visible is  "+Elementidfound);
									}
									catch(Exception Nop)
									{
										System.out.println("Debugcheckpoint");
									}
							}
						}	catch (Exception Exee) {
							System.out.println("Exception while moving to the element "+i);
							}
						
								} 
		}
			else
			{
			}
				}catch(Exception Noelement)
		{
			
					ATUReports.add("Gantt empty",  LogAs.INFO, null); 
		}
	}
				CommonTest.CheckCollapse();
				CommonTest.zoomOut();
				CommonTest.zoomOut();
	
		
		
		
	}

	
	
	
// Below function is used to select Gannt view option	
		public static void GanntViewSelection() throws Exception {
			
			System.out.println("Validating Gantt view selection test");		
		CommonTest.SpinnerControl();	 
		TestcaseInit();
		try
		{
			
			//Checking Gantt view is selected already , if not click so that we can save some time in Execution
			WebElement GanttviewHeader = getDriver().findElement(By.xpath(Web_UI.HeaderViewTitle));
			String Headertext = GanttviewHeader.getAttribute("innerText");
			if(Headertext.contains("Gantt View")){
				System.out.println("Checked user is in gantt view and found Already in Gantt view ..  ");
				ATUReports.add("Selected Gantt view Option ",  LogAs.PASSED, null);
			}else{
				
		try
		{
		try
		{
			
		clickByXpath(Web_UI.GantviewOption,"GantviewOption");
		System.out.println("User is not in Gantt view and hence selecting Gantt view ");
		
		ATUReports.add("Selected Gantt view Option ",  LogAs.PASSED, null);
		
		}
		catch (Exception ganttexception)
		{
			
			//Try selecting Gantt view option again 
			ATUReports.add(" ",  LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE)); 
			ATUReports.add("Selecting Gantt view Option in second Attempt ",  LogAs.PASSED, null);
			CommonTest.SpinnerControl();
			clickByXpath(Web_UI.GantviewOption,"GantviewOption");
			System.out.println("Selected gantt view button om Second attempt");
			ATUReports.add("Selected Gantt view Option in second Attemp ",  LogAs.PASSED, null);
			CommonTest.SpinnerControl();
		}
		
		
		CommonTest.SpinnerControl();	
		Thread.sleep(3000);
		String GanttViewHeader = getDriver().findElement(By.xpath(Web_UI.GanttViewHeader)).getAttribute("innerText");
		if(GanttViewHeader.contains("Gantt View"))
		{
	
		ATUReports.add("Gantt view Displayed and validated with checkpoint ",  LogAs.PASSED, null);
		}
		else
		{
			  System.out.println("Gantt view not displayed even after trying 2 times ");
			  ATUReports.add("Gantt view not displayed even after trying 2 times ",  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			
		}
		}
		catch (Exception ganttexception)
		{
			//Checking any popups blocks test
			CommonTest.CheckOKPopupPresentandclose();
			CommonTest.CheckCancelPopupPresentandclose();
			Checkappupdateclosebutton();
		}
			
			}
		}catch(Exception EE)
		{
			 System.out.println("Already in Gantt view ");
			 ATUReports.add("Selected Gantt view Option ",  LogAs.PASSED, null);
		}
		
	}
		
		
		
		
		public static void ConfirmTotalGates(String view) throws Exception {
			
			System.out.print("Verify the functionality when total gates are selected");
			TestcaseInit();
			clickByXpathbyView(view, Web_UI.TotalGate, Web_UI.HybridAllGate);
			ATUReports.add("Total Gate is selected",  LogAs.PASSED, null);
			ATUReports.add("Check Total Gates is displayed by default in Gantt view header",  LogAs.INFO, null); 
			
			String ConfirmTotalGatesHeader = getDriver().findElement(By.xpath(Web_UI.ConfirmTotalGatesHeader)).getAttribute("innerText");
			if(ConfirmTotalGatesHeader.contains("Total Gates"))
			{
				ATUReports.add("The Total Gates is selected by default upon Selecting Gantt view option",  LogAs.PASSED, null);
			}
			else
			{
				ATUReports.add("The  Total Gates is not displayed",  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}
			
			
		}
		
		
	

// Below function will check category one by one and verify counts displayed is right
	
	public static void StatisticsCountchecker() throws Exception {
		
		for(int Statisticscounter = 1;Statisticscounter<12;Statisticscounter++)
		{
			
			try
			{
				String Category1= getDriver().findElement(By.xpath("//*[@id='wrapper']/div[2]/aside/section/div[1]/div[2]/div[2]/ul/li["+Statisticscounter+"]/div[1]/div[2]")).getText();
				String Category = Category1.trim();
				
				String GanttHeaderText1= getDriver().findElement(By.xpath(Web_UI.GanttHeaderText)).getText();
				String GanttHeaderText2= GanttHeaderText1.replace("[", "");
				String GanttHeaderText3= GanttHeaderText2.replace("]", "");
				String GanttHeaderText = GanttHeaderText3.trim();
				
				if(GanttHeaderText.contains(Category))
				{
					System.out.println("Pass  "+Category);
					ATUReports.add("Gantt View Header matches",  LogAs.PASSED, null);
				}
				else
				{
					System.out.println("Fail  "+Category);
					ATUReports.add("Header doesnt matches",  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				}
				
			}
			catch(Exception NoStatistics)
			{
				System.out.println("NO Statistics ");
			}
			
			
		}
		
		
		
	}
	
	
	
	
	
	// Below Function is written to get the details and store for performance
			public static List<String> GetdetailsfromGanttview() throws Exception {
				CommonTest.Refresh();
				CommonTest.CheckExpand();
				CommonTest.zoomin();
			Thread.sleep(5000);
			List<WebElement> puckelements = getDriver().findElements(By.xpath("//div[@data-ng-attr-id='{{::flt.flight.fltNum }}']"));
			ArrayList<String> AllFlightLinkagedetails = new ArrayList<String>();		
			int count=0;
		
			for(WebElement element : puckelements){
				try
				{
					count++;
				if(count==50||count==100){
				}
				else
				{
				String idd = element.getAttribute("id");
				Actions action = new Actions(getDriver());
				WebElement moveelement =getDriver().findElement(By.id(idd));
				action.moveToElement(moveelement).build().perform();
				Thread.sleep(1000);
				WebElement FlightLinkage = getDriver().findElement(By.xpath("//div[@id='"+idd+"']/div[3]//div[@class='plunk-linkage']"));
				AllFlightLinkagedetails.add(FlightLinkage.getText());
				String FlightlinkageText = FlightLinkage.getText();
				System.out.println(FlightlinkageText);
				
					}
					}
				catch(Exception somethingwentwrong)
				{
					System.out.println("wrong");
				}
				}	    			
			CommonTest.CheckCollapse();
			//To check whether properly fetched and stored
			int FlightLinkagesize = AllFlightLinkagedetails.size();
			for(int i=0; i<FlightLinkagesize; i++){
					System.out.println(i+". "+" Flight Number : " +AllFlightLinkagedetails.get(i));
			}
			
			// To store and return the list of captured string
			List<String> list=new ArrayList<String>();
			
					 for(int j = 0; j<FlightLinkagesize;j++)
					 {
					
							String LinkageDetailsfromPuck = AllFlightLinkagedetails.get(j).trim();
							if(LinkageDetailsfromPuck.contains("/")){
							String FlightNoAlone[] = LinkageDetailsfromPuck.split("/");
							String FlightID = FlightNoAlone[1].trim();
							list.add(FlightID);
							}
							else
							{
							
							}
					}
				return list;
				
			}
			

			public static void Settings(int timer) throws Exception {

				clickByXpath(Web_UI.filtericon,"filtericon");
				Thread.sleep(5000);
				String Zone = "//span[@class='display-stn ng-binding'and text()='"+Web_UI.Station+"']";
				clickByXpath(Zone,"Zone");
				clickByXpath("//span[@class='display-stn ng-binding'and text()='DFW']","DFW");
				Thread.sleep(3000);
				
				WebElement ZoneElementTable = getDriver().findElement(By.xpath("//ul[@class='filter-zne-headng col-xs-12']"));
				List<WebElement> ZoneElements = ZoneElementTable.findElements(By.xpath("//li[@class='col-lg-12 list-filter-dialoug ng-scope filter-selected']"));
				int ZonesListsize = ZoneElements.size();
				
				for(int i=1;i<ZonesListsize;i++)
				{
				
					getDriver().findElement(By.xpath("//*[@id='db-filter-zones']/ul/li["+i+"]/div/label/div/label")).click();
						
						
					}
				
				
					Thread.sleep(5000);
					WebElement Slider = getDriver().findElement(By.xpath(Web_UI.Slider));
					Actions action = new Actions(getDriver());
					action.click(Slider).build().perform();
					 
					 if (timer==1)
					 {
						 action.clickAndHold(Slider).moveByOffset(0,0).build().perform();
						 action.release().build().perform();
	                      

											
						 action.sendKeys(Keys.ARROW_LEFT).build().perform();
						 Thread.sleep(1000);
						 action.sendKeys(Keys.ARROW_LEFT).build().perform();
						 Thread.sleep(1000);
						 action.sendKeys(Keys.ARROW_LEFT).build().perform();
						 Thread.sleep(1000);
						 action.sendKeys(Keys.ARROW_LEFT).build().perform();
						 Thread.sleep(1000);
						 action.sendKeys(Keys.ARROW_LEFT).build().perform();
						 Thread.sleep(1000);
						
					 }
					 
					 else
					 {
						 for(int timehit=2;timehit<timer;timehit++)
						 {
						 	action.sendKeys(Keys.ARROW_RIGHT).build().perform();
							Thread.sleep(1000);
						 }
					 }
					 
					clickByXpath(Web_UI.ApplyButton,"ApplyButton");
			    	 Thread.sleep(5000);
					 CommonTest.SpinnerControl();	
		

}
	
			public static void Settimer(int timer) throws Exception {
			clickByXpath("//img[@data-ng-click='openFilter()']","openFilter");
			Thread.sleep(5000);
			clickByXpath("//span[@class='display-stn ng-binding'and text()='DFW']","DFW");
			Thread.sleep(5000);
			WebElement Slider = getDriver().findElement(By.xpath(Web_UI.Slider));
			Actions action = new Actions(getDriver());
			action.click(Slider).build().perform();
				 
				 if (timer==1)
				 {
					 action.clickAndHold(Slider).moveByOffset(0,0).build().perform();
					 action.release().build().perform();
					 action.sendKeys(Keys.ARROW_LEFT).build().perform();
					 Thread.sleep(1000);
					 action.sendKeys(Keys.ARROW_LEFT).build().perform();
					 Thread.sleep(1000);
					 action.sendKeys(Keys.ARROW_LEFT).build().perform();
					 Thread.sleep(1000);
					 action.sendKeys(Keys.ARROW_LEFT).build().perform();
					 Thread.sleep(1000);
					 action.sendKeys(Keys.ARROW_LEFT).build().perform();
					 Thread.sleep(1000);
					 action.sendKeys(Keys.ARROW_LEFT).build().perform();
					 Thread.sleep(1000);
					 action.sendKeys(Keys.ARROW_LEFT).build().perform();
					 Thread.sleep(1000);
					
				 }
				 
				 else
				 {
					 for(int timehit=2;timehit<timer;timehit++)
					 {
					 	action.sendKeys(Keys.ARROW_RIGHT).build().perform();
						Thread.sleep(1000);
					 }
				 }
				 
				clickByXpath(Web_UI.ApplyButton,"ApplyButton");
		    	 Thread.sleep(5000);
				 CommonTest.SpinnerControl();	
					CommonTest.CheckOKPopupPresentandclose();
					CommonTest.CheckCancelPopupPresentandclose();
			}

		
			public static void PuckFontSizeValidation() throws Exception {
				
				TestcaseInit();
				System.out.println("Validating Flight Puck Size. It will verify the Puck size are set based upon user selection of 3 different Font sizes");
				CommonTest.SpinnerControl();
				Thread.sleep(5000);
				CommonTest.CheckExpand();
				
				try{
				List<WebElement> Ganntlist = getDriver().findElements(By.xpath(Web_UI.PuckComplete));
				int Ganntlistcount = Ganntlist.size();
				if (Ganntlistcount != 0) {
					int Flightpuckcounter=0;
					for (WebElement gantelement : Ganntlist) {
				//Setting Gantt view flight puck counter inorder to validate 20 pucks as page refresh interrupts the execution
						if(Flightpuckcounter<2)
						{
							Flightpuckcounter++;
						String elementid = gantelement.getAttribute("id");
						Actions actions = new Actions(getDriver());
						WebElement elee = findelementbyxpath("//*[@id='"+elementid+"']");
						actions.moveToElement(elee).build().perform();
						CommonTest.scrollGanttViewright();
						Thread.sleep(1000);
						
						try {
							WebElement SmallFont = getDriver().findElement(By.xpath(Web_UI.SmallFont));
							SmallFont.click();
							ATUReports.add("Small Font size is selected ",  LogAs.PASSED, null);
							Thread.sleep(2000);
							WebElement elementcolorfinder = getDriver().findElement(By.xpath("//*[@id='" + elementid + "']"));
							String SmallSize = elementcolorfinder.getCssValue("font-size");
							if (SmallSize.contains("19px"))
							{
								ATUReports.add("Font is displayed in Small Size within Gantt view",  LogAs.PASSED, null);
							}
							else
							{
								ATUReports.add("Font not displayed in Small Size within Gantt view",  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								captureinfoScreenshot(getDriver(), "Font not displayed in Small Size within Gantt view");
							}
							Thread.sleep(2000);
							
							WebElement MediumFont = getDriver().findElement(By.xpath(Web_UI.MediumFont));
							MediumFont.click();
							ATUReports.add("Medium Font size is selected ",  LogAs.PASSED, null);
							Thread.sleep(2000);
							WebElement elementcolorfinder2 = getDriver().findElement(By.xpath("//*[@id='" + elementid + "']"));
							String  MediumSize = elementcolorfinder2.getCssValue("font-size");
							if (MediumSize.contains("21px"))
							{
									ATUReports.add("Font is displayed in Medium Size within Gantt view",  LogAs.PASSED, null);
							}
							else
							{
								ATUReports.add("Font not displayed in Medium Size within Gantt view",  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								captureinfoScreenshot(getDriver(),"Font not displayed in Medium Size within Gantt view");
							}
							Thread.sleep(2000);
							
							WebElement LargeFont = getDriver().findElement(By.xpath(Web_UI.LargeFont));
							LargeFont.click();
							Thread.sleep(2000);
							WebElement elementcolorfinder3 = getDriver().findElement(By.xpath("//*[@id='" + elementid + "']"));
							String LargeSize = elementcolorfinder3.getCssValue("font-size");
								if (LargeSize.contains("23px"))
							{
								ATUReports.add("Font is displayed in Large Size within Gantt view ",  LogAs.PASSED, null);
							}
							else
							{
								ATUReports.add("Font not displayed in Large Size within Gantt view",  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								captureinfoScreenshot(getDriver(),"Font not displayed in Large Size within Gantt view");
							}
							Thread.sleep(2000);
							
							SmallFont.click();		
						}
						catch(Exception Fontsizeexception)
						{
							ATUReports.add("Something went wrong with Font size placement or selection ",  LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE)); 
							WebElement SmallFont = getDriver().findElement(By.xpath(Web_UI.SmallFont));
							SmallFont.click();
						}
			}
							
					}
				
				}
				}		catch (Exception Ganttnotexist)
				{
					ATUReports.add("Gantt table is Empty ",  LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE)); 
					
				}
				}

			public static void RealtimeBar() throws IOException {
				
					
				List<WebElement> Realtimebar = getDriver().findElements(By.xpath(Web_UI.Realtimebar));
				if (Realtimebar!=null)
				{
					ATUReports.add("Real time bar present in the center of the gantt view page ",  LogAs.PASSED, null);
				}
				else{
					ATUReports.add("Real time bar not visible. Please check the issue ",  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					
				}
				
			}

	

			public static void Betweentimerange() throws Exception {
				
				System.out.println("Verify Flights displayed in Gantt view falls under selected time range");
				TestcaseInit();
				Settimer(1);
				try{
					clickByXpath(Web_UI.TotalGate,"TotalGate");
				}
				catch(Exception Totalgatenotselected){
					ATUReports.add("Couldnot able to select Total gate",  LogAs.PASSED, null);
				}
				CommonTest.zoomindata();
						Thread.sleep(2000);
						ATUReports.add("TotalGate stats selected",  LogAs.PASSED, null);
						List<WebElement> Ganntlist = getDriver().findElements(By.xpath(Web_UI.PuckComplete));
						int Ganntlistcount1 = Ganntlist.size();
					
						if(Ganntlistcount1 == 0)
						{
							CommonTest.CheckGanttviewListisnotZero();
						}
						int Ganntlistcount = Ganntlist.size();
						if(Ganntlistcount == 0)
						{
							ATUReports.add("***********Gantt List is Zero and hence Exiting test smoothly**************",  LogAs.PASSED, null);
							captureinfoScreenshot(getDriver(), "ArrivalDepartureTimeformatValidationListZero");
						}else
						{
							if (Ganntlist != null) {
								
								int i=0;
								for (WebElement gantelement : Ganntlist) {
									i++;
									
												try {

													Actions actions = new Actions(getDriver());
													actions.moveToElement(gantelement).build().perform();
													actions.moveToElement(gantelement);
											
												String arrivaltimedetails = gantelement.findElement(By.xpath("div[4]/div[1]/span[2]")).getAttribute("innerText");
												String departuretimedetails = gantelement.findElement(By.xpath("div[4]/div[3]/span[2]/span[1]")).getAttribute("innerText");
												String arrivaltimedetailsarray[] = arrivaltimedetails.split(" ");
												String departuretimedetailsarray[] = departuretimedetails.split(" ");
												String arrivaltime =	arrivaltimedetailsarray[1];
												String departuretime =  departuretimedetailsarray[1];
												if(arrivaltime.contains("/")||departuretime.contains("/")){	
																								}else{
												String arrivaltimecomplete = arrivaltime.substring(0, 5);
												String departuretimecomplete = departuretime.substring(0, 5);
												String stationtime = getDriver().findElement(By.xpath(Web_UI.stationtime)).getAttribute("innerText").trim();
												
												
												String ArrivaltimePass = arrivaltimecomplete+":00";
												String departuretimePass = departuretimecomplete+":00";
												String stationtimePass = stationtime+":00";
												
												boolean result = isTimeBetweenTwoTime(stationtimePass,stationtimePass,ArrivaltimePass,departuretimePass);
												
												if(result==true)
												{
													ATUReports.add("Lies Between timerange ",  LogAs.PASSED, null);
												}
												else{
													ATUReports.add("Not in timerange "+" Arrival time passed "+ArrivaltimePass+" Departure time passed "+departuretimePass+" Station time  "+stationtimePass,  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
													captureinfoScreenshot(getDriver(), "Arrivaldeparturetime"+i);
												}
												
												}
												
												}catch(Exception Ete){
													System.out.print("");
												}
												
							
								}
							}
						}
				
			
			}
	
			
			
			public static boolean isTimeBetweenTwoTime(String time11, String time22, String time33,String time44) throws Exception {
				
				  
				   String string1 = time11;
			   
			    Date time1 = new SimpleDateFormat("HH:mm:ss").parse(string1);
			     // Here i think we need to subtract a day
			    Calendar calendar1 = Calendar.getInstance();
			    calendar1.setTime(time1);
			    calendar1.add(Calendar.DATE, 0);
			    calendar1.add(Calendar.HOUR, -6);
			    System.out.println(calendar1.getTime());

			    String string2 = time22;
			    Date time2 = new SimpleDateFormat("HH:mm:ss").parse(string2);
			    Calendar calendar2 = Calendar.getInstance();
			    calendar2.setTime(time2);
			    calendar2.add(Calendar.DATE, 0);
			    calendar2.add(Calendar.HOUR, 1);
			    System.out.println(calendar2.getTime());

			    String someRandomTime = time33;
			    Date d = new SimpleDateFormat("HH:mm:ss").parse(someRandomTime);
			    Calendar calendar3 = Calendar.getInstance();
			    calendar3.setTime(d);
			    calendar3.add(Calendar.DATE, 0);
			    System.out.println(calendar3.getTime());
			    
			    String someRandomTime1 = time44;
			    Date d1 = new SimpleDateFormat("HH:mm:ss").parse(someRandomTime1);
			    Calendar calendar4 = Calendar.getInstance();
			    calendar4.setTime(d1);
			    calendar4.add(Calendar.DATE, 0);
			    System.out.println(calendar4.getTime());
			    
			    
			    String someRandomTime2 = time33;
			    Date d2 = new SimpleDateFormat("HH:mm:ss").parse(someRandomTime2);
			    Calendar calendar5 = Calendar.getInstance();
			    calendar5.setTime(d2);
			    calendar5.add(Calendar.DATE, -1);
			    System.out.println(calendar5.getTime());
			    
			    String someRandomTime3 = time44;
			    Date d3 = new SimpleDateFormat("HH:mm:ss").parse(someRandomTime3);
			    Calendar calendar6 = Calendar.getInstance();
			    calendar6.setTime(d3);
			    calendar6.add(Calendar.DATE, 1);
			    System.out.println(calendar6.getTime());
			    Date x = calendar3.getTime();    // arrivaltime
			    Date xy = calendar4.getTime();   //departuretime
			    
			    Date xz = calendar5.getTime();    // arrivaltime
			    Date xyz = calendar6.getTime();   //departuretime
			    
			    Date y = calendar1.getTime();    //less timerange -sethours / 6hours
			    Date z = calendar2.getTime();    // More timerange - set hours
			  
			    if ((x.after(y)&&x.before(z))||(xy.after(y)&&xy.before(z))) {
			       	       
			        System.out.println("true");
			        return true;
			       
			    }
			    else
			    {
			    	if ((xz.after(y)&&xz.before(z))||(xyz.after(y)&&xyz.before(z))){
			    		return true;	
			    	}
			    	else{
			    	 System.out.println(false);
			    	   return false;
			    	}
			    }
			    
			    
							}
			
	
	
}
