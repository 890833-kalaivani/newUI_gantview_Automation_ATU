package get.next.gen.webtestcase;

import get.next.gen.commonaction.CommonTest;
import get.next.gen.utilities.Alertingflightstatsvalidation;
import get.next.gen.utilities.CustomZone;
import get.next.gen.utilities.DashboardFilterOptionValidation;
import get.next.gen.utilities.EventDetailsValidation;
import get.next.gen.utilities.FlightStatsconfirmation;
import get.next.gen.utilities.GanntViewHeaderFunctionality;
import get.next.gen.utilities.GanttviewPuckOptions;
import get.next.gen.utilities.HoverValidation;
import get.next.gen.utilities.Hybridview;




import get.next.gen.utilities.Lazyloading;
import get.next.gen.utilities.PuckColorValidation;
import get.next.gen.utilities.PuckUIPlacement;
import get.next.gen.utilities.RampopenClose;
import get.next.gen.utilities.SearchValidation;
import get.next.gen.utilities.SortFunctionalityvalidation;

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

import atu.testng.reports.listeners.ATUReportsListener;
import atu.testng.reports.listeners.ConfigurationListener;
import atu.testng.reports.listeners.MethodListener;
@Listeners({ ATUReportsListener.class, ConfigurationListener.class,
MethodListener.class })




public class Dec15release extends CommonTest {
	
	@Parameters({ "browser", "Environment" })	
	@Test(priority = 0)
	public void TS01_LoginTestcase(String browser, String Environment) throws Exception {
		Memoryused();
		GanntViewHeaderFunctionality.Login(Environment);
		}



	@Test(priority = 1)
	public void TS501_VerifyGanttCount_MEL() throws Exception {
	
		Lazyloading.VerifyStatsCount(Web_UI.MEL,"MEL",Web_UI.MELStatsCount);
			
	}
	
	
	
	@Test(priority = 2)
	public void TS502_VerifyGanttCount_Offload() throws Exception {

		Lazyloading.VerifyStatsCount(Web_UI.Offload,"Offload",Web_UI.OffloadStatsCount);
		Memoryused();
	}

	@Test(priority = 3)
	public void TS503_VerifyGanttCount_ClaimScam() throws Exception {

		Lazyloading.VerifyStatsCount(Web_UI.Claimscan,"Claimscan",Web_UI.ClaimscanStatsCount);
		Memoryused();
	}
	@Test(priority = 4)
	public void TS504_VerifyGanttCount_Bags() throws Exception {

		Lazyloading.VerifyStatsCount(Web_UI.Bags,"Bags",Web_UI.BagsStatsCount);
		Memoryused();
	}

	@Test(priority = 5)
	public void TS505_VerifyGanttCount_Pax() throws Exception {

		Lazyloading.VerifyStatsCount(Web_UI.Passanger,"Passanger",Web_UI.PassangerStatsCount);
		Memoryused();
	}


	@Test(priority = 6)
	public void TS506_VerifyGanttCount_Crew() throws Exception {

		Lazyloading.VerifyStatsCount(Web_UI.Crew,"Crew",Web_UI.CrewStatsCount);
		Memoryused();
	}

	@Test(priority = 7)
	public void TS507_VerifyGanttCount_Cabin() throws Exception {

		Lazyloading.VerifyStatsCount(Web_UI.Cabin,"Cabin",Web_UI.CabinStatsCount);
		Memoryused();
	}

	@Test(priority = 8)
	public void TS508_VerifyGanttCount_Lavs() throws Exception {

		Lazyloading.VerifyStatsCount(Web_UI.LAV,"LAV",Web_UI.LavsStatsCount);
		Memoryused();
	}

	@Test(priority = 9)
	public void TS509_VerifyGanttCount_Water() throws Exception {

		Lazyloading.VerifyStatsCount(Web_UI.Water,"Water",Web_UI.WaterStatsCount);
		Memoryused();
	}

	@Test(priority = 10)
	public void TS510_VerifyGanttCount_Fueling() throws Exception {

		Lazyloading.VerifyStatsCount(Web_UI.Fuel,"MEL",Web_UI.FuelStatsCount);
		Memoryused();
	}

	@Test(priority = 11)
	public void TS511_VerifyGanttCount_Catering() throws Exception {

		Lazyloading.VerifyStatsCount(Web_UI.Catering,"Catering",Web_UI.CateringStatsCount);
		Memoryused();
	}

	@Test(priority = 12)
	public void TS512_VerifyGanttCount_Cancelled() throws Exception {
		
		Lazyloading.VerifyStatsCount(Web_UI.Canceled,"Canceled",Web_UI.CancelledStatsCount);
		Memoryused();
	}

	@Test(priority = 13)
	public void TS513_VerifyGanttCount_ETD() throws Exception {

		Lazyloading.VerifyStatsCount(Web_UI.ETD,"ETD",Web_UI.ETDStatsCount);
		Memoryused();
	}


	
	@Test(priority = 14)
	public void TS514_VerifyGanttCount_OTS() throws Exception {
		Lazyloading.VerifyStatsCount(Web_UI.OTS,"OTS",Web_UI.OTSStatsCount);
		Memoryused();
	}


	@Test(priority = 15)
	public void TS515_VerifyGanttCount_RightStart() throws Exception {
		
		Lazyloading.VerifyStatsCount(Web_UI.RightStart,"RightStart",Web_UI.RightstartStatsCount);
		Memoryused();
	}
	@Test(priority = 16)
	public void TS516_VerifyGanttCount_A14() throws Exception {
		
		Lazyloading.VerifyStatsCount(Web_UI.A14,"A14",Web_UI.A14StatsCount);
		Memoryused();
	}
	@Test(priority = 17)
	public void TS517_VerifyGanttCount_Unlinked() throws Exception {
		
		Lazyloading.VerifyStatsCount(Web_UI.Unlinked,"Unlinked",Web_UI.UnlinkedCount);
		Memoryused();
	}

	@Test(priority = 18)
	public void TS518_VerifyGanttCount_IFS() throws Exception {
		
		Lazyloading.VerifyStatsCount(Web_UI.IFS,"IFS",Web_UI.IFSStatsCount);
		Memoryused();
	}
	@Test(priority = 19)
	public void TS519_VerifyGanttCount_Diverted() throws Exception {
		
		Lazyloading.VerifyStatsCount(Web_UI.Diverted,"Diverted",Web_UI.DivertedStatsCount);
		Memoryused();
	}
	@Test(priority = 20)
	public void TS520_VerifyGanttCount_LateArrivals() throws Exception {
		
		Lazyloading.VerifyStatsCount(Web_UI.LateArrival,"LateArrival",Web_UI.LateArrivaStatsCount);
		Memoryused();
	}
	@Test(priority = 21)
	public void TS521_VerifyGanttCount_GateSwaps() throws Exception {
		
		Lazyloading.VerifyStatsCount(Web_UI.GateSwaps,"GateSwaps",Web_UI.GateSwapsStatsCount);
		Memoryused();
	}

	@Test(priority = 22)
	public void TS522_VerifyGanttCount_GateConflicts() throws Exception {
		
		Lazyloading.VerifyStatsCount(Web_UI.GateConflicts,"GateConflicts",Web_UI.GateConflictsStatsCount);
		Memoryused();
	}

	@Test(priority = 23)
	public void TS523_VerifyGanttCount_Decision() throws Exception {
		
		Lazyloading.VerifyStatsCount(Web_UI.Decision,"Decision",Web_UI.DecisionStatsCount);
		Memoryused();
	}
	@Test(priority = 24)
	public void TS524_VerifyGanttCount_EarlyArrivals() throws Exception {
		
		Lazyloading.VerifyStatsCount(Web_UI.EarlyArrival,"EarlyArrival",Web_UI.EarlyArrivalStatsCount);
		Memoryused();
	}
	@Test(priority = 25)
	public void TS525_VerifyGanttCount_ACSwaps() throws Exception {
		
		Lazyloading.VerifyStatsCount(Web_UI.ACSwaps,"ACSwaps",Web_UI.ACSwapsStatsCount);
		Memoryused();
	}

	@Test(priority = 26)
	public void TS526_VerifyGanttCount_Delayed() throws Exception {
		
		Lazyloading.VerifyStatsCount(Web_UI.Delayed,"Delayed",Web_UI.DelayedStatsCount);
		Memoryused();
	}

	@Test(priority = 27)
	public void TS527_VerifyGanttCount_ORIGIN() throws Exception {

		Lazyloading.VerifyStatsCount(Web_UI.Origin,"Origin",Web_UI.OriginCount);
		Memoryused();
	}

	@Test(priority = 28)
	public void TS528_VerifyGanttCount_TERM() throws Exception {
		
		Lazyloading.VerifyStatsCount(Web_UI.Term,"Term",Web_UI.TermCount);
		Memoryused();
	}

}