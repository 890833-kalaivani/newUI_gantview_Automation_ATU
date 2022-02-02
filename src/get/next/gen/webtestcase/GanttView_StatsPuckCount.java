package get.next.gen.webtestcase;

import get.next.gen.commonaction.CommonTest;
import get.next.gen.utilities.GanntViewHeaderFunctionality;
import get.next.gen.utilities.GateChange;
import get.next.gen.utilities.Gatechange_old;
import get.next.gen.utilities.GenerateReport;
import get.next.gen.utilities.Lazyloading;
import get.next.gen.utilities.Multialert;
import get.next.gen.utilities.PuckUIPlacement;
import get.next.gen.utilities.QuickNotes;
import get.next.gen.utilities.SharedGates;
import get.next.gen.utilities.TeamsMessage;
import get.next.gen.utilities.UpdateETD;
import get.next.gen.utilities.consolidatedcrewreport;
import get.next.gen.utilities.CloseOut;
import get.next.gen.utilities.DashboardFilterOptionValidation;
import get.next.gen.utilities.DiversonReport;
import get.next.gen.utilities.EventDetailsValidation;
import scala.concurrent.forkjoin.ThreadLocalRandom;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import javax.swing.Action;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import atu.testng.reports.ATUReports;
import atu.testng.reports.logging.LogAs;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;

public class GanttView_StatsPuckCount extends CommonTest {
	@Parameters({ "browser", "Environment" })	
	@Test(priority = 0)
	public void TS01_LoginTestcase(String browser, String Environment) throws Exception {
		Memoryused();
		System.out.println("url: "+Environment+"");
		//GanntViewHeaderFunctionality.Login("https://get.azne.aa.com/GetNG/home");
		GanntViewHeaderFunctionality.Login(Environment);
		Thread.sleep(1000);
		Memoryused();
	}

	 @Test(priority = 15)
	public void TS186_VerifyGanttCount_A14() throws Exception {
		Lazyloading.VerifyStatsCount(Web_UI.A14,"A14",Web_UI.A14StatsCount);
		//CommonTest.Memoryused();
	}
	@Test(priority = 24)
	public void TS195_VerifyGanttCount_ACSwaps() throws Exception {
		Lazyloading.VerifyStatsCount(Web_UI.ACSwaps,"ACSwaps",Web_UI.ACSwapsStatsCount);
		//Memoryused();
	}
	
	@Test(priority=1)
	public void TS24_ArrivaldetailsExistance() throws Exception {
		//PuckUIPlacement.ArrivaldetailsExistance("Ganttview");
		Lazyloading.VerifyStatsCount(Web_UI.MEL,"MEL",Web_UI.MELStatsCount);
		Memoryused();
	}
	@Test(priority = 11)
	public void TS182_VerifyGanttCount_Cancelled() throws Exception {
		Lazyloading.VerifyStatsCount(Web_UI.Canceled,"Canceled",Web_UI.CancelledStatsCount);
		//CommonTest.Memoryused();
	}
	@Test(priority = 25)
	public void TS196_VerifyGanttCount_Delayed() throws Exception {
		Lazyloading.VerifyStatsCount(Web_UI.Delayed,"Delayed",Web_UI.DelayedStatsCount);
		//CommonTest.Memoryused();
	}
	@Test(enabled = false)
	public void TS194_VerifyGanttCount_EarlyArrivals() throws Exception {
		Lazyloading.VerifyStatsCount(Web_UI.EarlyArrival,"EarlyArrival",Web_UI.EarlyArrivalStatsCount);
		//CommonTest.Memoryused();
	}
	@Test(enabled = false)
	public void TS194_VerifyGanttCount_MOGT() throws Exception {
		Lazyloading.VerifyStatsCount(Web_UI.MOGT_stats,"EarlyArrival",Web_UI.MOGTStatsCount);
		//CommonTest.Memoryused();
	}
	@Test(priority = 20)
	public void TS191_VerifyGanttCount_GateSwaps() throws Exception {
		Lazyloading.VerifyStatsCount(Web_UI.GateSwaps,"GateSwaps",Web_UI.GateSwapsStatsCount);
		//CommonTest.Memoryused();
	}
	@Test(priority = 17)
	public void TS188_VerifyGanttCount_flagShip() throws Exception {
		Lazyloading.VerifyStatsCount(Web_UI.IFS,"IFS",Web_UI.IFSStatsCount);
		//CommonTest.Memoryused();
	}
	@Test(priority = 19)
	public void TS190_VerifyGanttCount_LateArrivals() throws Exception {
		Lazyloading.VerifyStatsCount(Web_UI.LateArrival,"LateArrival",Web_UI.LateArrivaStatsCount);
		//CommonTest.Memoryused();
	}
	
	@Test(priority = 13)
	public void TS184_VerifyGanttCount_OTS() throws Exception {
		Lazyloading.VerifyStatsCount(Web_UI.OTS,"OTS",Web_UI.OTSStatsCount);
		//CommonTest.Memoryused();
	}
	@Test(priority = 14)
	public void TS185_VerifyGanttCount_RightStart() throws Exception {
		Lazyloading.VerifyStatsCount(Web_UI.RightStart,"RightStart",Web_UI.RightstartStatsCount);
		//	Memoryused();
	}
	@Test(priority = 27)
	public void TS198_VerifyGanttCount_TERM() throws Exception {
		Lazyloading.VerifyStatsCount(Web_UI.Term,"Term",Web_UI.TermCount);
		//CommonTest.Memoryused();
	}
	@Test(priority = 4)
	public void TS175_VerifyGanttCount_Pax() throws Exception {
		Lazyloading.VerifyStatsCount(Web_UI.Passanger,"Passanger",Web_UI.PassangerStatsCount);
		//CommonTest.Memoryused();
	}
	@Test(priority = 5)
	public void TS176_VerifyGanttCount_Crew() throws Exception {
		Lazyloading.VerifyStatsCount(Web_UI.Crew,"Crew",Web_UI.CrewStatsCount);
		//CommonTest.Memoryused();
	}
	/*@Test(priority = 1)
	public void TS172_VerifyGanttCount_Offload() throws Exception {
		Lazyloading.VerifyStatsCount(Web_UI.Offload,"Offload",Web_UI.OffloadStatsCount);
		//CommonTest.Memoryused();
	}
	@Test(priority = 173)
	public void TS173_VerifyGanttCount_ClaimScam() throws Exception {
		Lazyloading.VerifyStatsCount(Web_UI.Claimscan,"Claimscan",Web_UI.ClaimscanStatsCount);
		//CommonTest.Memoryused();
	}
	@Test(priority = 3)
	public void TS174_VerifyGanttCount_Bags() throws Exception {
		Lazyloading.VerifyStatsCount(Web_UI.Bags,"Bags",Web_UI.BagsStatsCount);
		//CommonTest.Memoryused();
	}
	
	@Test(priority = 6)
	public void TS177_VerifyGanttCount_Cabin() throws Exception {
		Lazyloading.VerifyStatsCount(Web_UI.Cabin,"Cabin",Web_UI.CabinStatsCount);
		//CommonTest.Memoryused();
	}
	@Test(priority = 7)
	public void TS178_VerifyGanttCount_Lavs() throws Exception {
		Lazyloading.VerifyStatsCount(Web_UI.LAV,"LAV",Web_UI.LavsStatsCount);
		//CommonTest.Memoryused();
	}
	@Test(priority = 8)
	public void TS179_VerifyGanttCount_Water() throws Exception {
		Lazyloading.VerifyStatsCount(Web_UI.Water,"Water",Web_UI.WaterStatsCount);
		//CommonTest.Memoryused();
	}
	@Test(priority = 9)
	public void TS180_VerifyGanttCount_Fueling() throws Exception {
		Lazyloading.VerifyStatsCount(Web_UI.Fuel,"MEL",Web_UI.FuelStatsCount);
		//CommonTest.Memoryused();
	}
	@Test(priority = 10)
	public void TS181_VerifyGanttCount_Catering() throws Exception {
		Lazyloading.VerifyStatsCount(Web_UI.Catering,"Catering",Web_UI.CateringStatsCount);
		//CommonTest.Memoryused();
	}
	
	@Test(priority = 12)
	public void TS183_VerifyGanttCount_ETD() throws Exception {
		Lazyloading.VerifyStatsCount(Web_UI.ETD,"ETD",Web_UI.ETDStatsCount);
		//CommonTest.Memoryused();
	}
	
	
	
	@Test(priority = 16)
	public void TS187_VerifyGanttCount_Unlinked() throws Exception {
		Lazyloading.VerifyStatsCount(Web_UI.Unlinked,"Unlinked",Web_UI.UnlinkedCount);
		//CommonTest.Memoryused();
	}
	
	@Test(priority = 18)
	public void TS189_VerifyGanttCount_Diverted() throws Exception {
		Lazyloading.VerifyStatsCount(Web_UI.Diverted,"Diverted",Web_UI.DivertedStatsCount);
		//CommonTest.Memoryused();
	}
	
	
	@Test(priority = 21)
	public void TS192_VerifyGanttCount_GateConflicts() throws Exception {
		//Lazyloading.VerifyStatsCount(Web_UI.GateConflicts,"GateConflicts",Web_UI.GateConflictsStatsCount);
		//	Memoryused();
	}
	@Test(priority = 22)
	public void TS193_VerifyGanttCount_Decision() throws Exception {
		Lazyloading.VerifyStatsCount(Web_UI.Decision,"Decision",Web_UI.DecisionStatsCount);
		//CommonTest.Memoryused();
	}
	@Test(priority = 23)
	public void TS194_VerifyGanttCount_EarlyArrivals() throws Exception {
		Lazyloading.VerifyStatsCount(Web_UI.EarlyArrival,"EarlyArrival",Web_UI.EarlyArrivalStatsCount);
		//CommonTest.Memoryused();
	}
	
	
	@Test(priority = 26)
	public void TS197_VerifyGanttCount_ORIGIN() throws Exception {
		//Lazyloading.VerifyStatsCount(Web_UI.Origin,"Origin",Web_UI.OriginCount);
		//CommonTest.Memoryused();
	}
	
	
	@Test(priority = 28)
	public void TS221_VerifyGanttCount_Inop() throws Exception {
		Lazyloading.VerifyStatsCount(Web_UI.Inop,"Inop",Web_UI.InopStatsCount);
		//CommonTest.Memoryused();
	}
*/
}
