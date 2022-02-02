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

public class PuckValidation extends CommonTest {
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
	@Test(priority = 1)
	public void TS24_ArrivaldetailsExistance() throws Exception {
		PuckUIPlacement.DeparturedetailsExistance("Ganttview");
		Memoryused();
	}
		/*@Test(priority = 1)
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
		
		@Test(priority = 34)
		public void TS34_PuckColorValidationbasedonStatus() throws Exception {
			//PuckColorValidation.PuckColorValidation("Ganttview");
		}	*/
}
