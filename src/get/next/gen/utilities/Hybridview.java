/*
f * Below class includes validation of Hybrid View related scenarios and holds functionality
 * required to validate Hybrid view 
 * 
 */


package get.next.gen.utilities;

import get.next.gen.commonaction.CommonTest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import get.next.gen.commonaction.CompareExcel;
import get.next.gen.webtestcase.*;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import atu.testng.reports.ATUReports;
import atu.testng.reports.logging.LogAs;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;
import atu.testng.reports.listeners.ATUReportsListener;
import atu.testng.reports.listeners.ConfigurationListener;
import atu.testng.reports.listeners.MethodListener;
@Listeners({ ATUReportsListener.class, ConfigurationListener.class,
MethodListener.class })

///
public class Hybridview extends CommonTest {
	
	
	public static void HybridviewSelection() throws Exception {
		System.out.println("Verify user is able to select Hybrid view ");
// Selecting hybrid view icon
		clickByXpath(Web_UI.HybridViewOption,"HybridViewOption");
				Thread.sleep(5000);	
		CommonTest.SpinnerControl();	
		WebElement HeaderTitle = getDriver().findElement(By.xpath(Web_UI.HeaderViewTitle));
		String Headertitlestring = HeaderTitle.getText();
		if(Headertitlestring.contains("Hybrid View"))
		{
			System.out.println("Hybrid view is displayed");
			ATUReports.add("Hybrid view is displayed ",  LogAs.PASSED, null);
		}
		else
		{
			ATUReports.add("Hybrid view text is not present in header",  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			Assert.fail("Hybrid view text is not present in header");
			
		}
		
	}
	
	
	public static void FlightlistviewSelection() throws Exception {
		
		//flighlistselection
				clickByXpath(Web_UI.Flightlistoption,"Flight List View");
				HarStart("Flightlist_","FlightlistSelected");
				Thread.sleep(5000);	
				CommonTest.SpinnerControl();	
				HarStop("Flightlist_","FlightlistSelected");	
			}
			
	public static void Flightstatsiconselection() throws Exception {
		CommonTest.SpinnerControl();
		clickByXpath(Web_UI.HybridViewOption,"Hybrid View");
		CommonTest.SpinnerControl();
		Thread.sleep(5000);
		//Selecting All in hybrid view
		try{
		clickByXpath(Web_UI.HybridAllGate,"All");
		System.out.println("Selected All in Hybrid view ");
				FlightstatsSelected("All");
			}
		catch(Exception NoStatsfound)
		{
			
			ATUReports.add("No corresponding All Stats Found ",  LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE)); 
		}
		CommonTest.SpinnerControl();	
		try{
			clickByXpath(Web_UI.HybridCancelled, "Cancelled");
			System.out.println("Selected Cancelled from Hybrid view");
		FlightstatsSelected("cancel");
		
		}
		catch(Exception NoStatsfound)
		{
			
			ATUReports.add("No corresponding Canceled Stats Found ",  LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE)); 
		}
		
		try{
			clickByXpath(Web_UI.HybridETD, "HybridETD");
			System.out.println("Selected ETD from Hybrid view");
		FlightstatsSelected("MOGT");
		}
		catch(Exception NoStatsfound)
		{
			
			ATUReports.add("No corresponding ETD Updates Stats Found ",  LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE)); 
		}
		
		try{
			clickByXpath(Web_UI.HybridDecision, "HybridDecision");
			
			System.out.println("Selected Decision from Hybrid view");
			FlightstatsSelected("Decision");
		}
		catch(Exception NoStatsfound)
		{
			captureinfoScreenshot(getDriver(),"No corresponding Decision Stats Found ");
			ATUReports.add("No corresponding Decision Stats Found ",  LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE)); 
		}
		
		try{	
			clickByXpath(Web_UI.HybridLatearrival, "HybridLatearrival");
			
			System.out.println("Selected Late Arrivals from Hybrid view");
			FlightstatsSelected("Late");
		}catch(Exception NoStatsfound)
		{
			
			ATUReports.add("No corresponding Late Arrivals Stats Found ",  LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE)); 
		}
		try{
			clickByXpath(Web_UI.HybridEarlyarrival, "HybridEarlyarrival");
				
				System.out.println("Selected Early Arrivals from Hybrid view");
				FlightstatsSelected("Early");
		}catch(Exception NoStatsfound)
		{
			
			ATUReports.add( "No corresponding Early Arrivals Stats Found ",  LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE)); 
		}
			
		try{
			clickByXpath(Web_UI.HybridGateSwaps, "HybridGateSwaps");
			
			System.out.println("Selected Gate Swaps from Hybrid view");
			FlightstatsSelected("Gate");
		}catch(Exception NoStatsfound)
		{
			
			ATUReports.add("No corresponding Stats Gate Swaps Found ",  LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE)); 
		}
		
		try{	
			clickByXpath(Web_UI.HybridAcSwaps, "HybridAcSwaps");
					
					System.out.println("Selected A/C Swaps  from Hybrid view");
					FlightstatsSelected("A/C");
		}catch(Exception NoStatsfound)
		{
			ATUReports.add("No corresponding AC swaps  Stats Found ",  LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE)); 
		}
				
		try{		
			clickByXpath(Web_UI.HybridRightStart, "HybridRightStart");
			
		System.out.println("Selected Right Start  from Hybrid view");
		FlightstatsSelected("Right");
		}catch(Exception NoStatsfound)
		{
				ATUReports.add("No corresponding Right Start Stats Found ",  LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE)); 
		}
				
		try{		
			clickByXpath(Web_UI.HybridPotential, "HybridPotential");
			
		System.out.println("Selected 'Potential Tows  from Hybrid view");
		FlightstatsSelected("Potential");
		}		
		catch(Exception NoStatsfound)
		{
			ATUReports.add("No Potential Tows corresponding Stats Found ",  LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE)); 
		}
		try{			
			clickByXpath(Web_UI.HybridIFS, "HybridIFS");
			
		System.out.println("Selected 'IFS from Hybrid view");
		FlightstatsSelected("Flagship");
		}catch(Exception NoStatsfound)
		{
			
			ATUReports.add("No corresponding Stats Found ",  LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE)); 
			
		}
						
		try{			
			clickByXpath(Web_UI.HybridDelayed, "HybridDelayed");
			
		System.out.println("Selected Delayed from Hybrid view");
		FlightstatsSelected("Delayed");
		
		}
		catch(Exception NoStatsfound)
		{
			ATUReports.add("No corresponding IFS Stats Found ",  LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE)); 
		}
								
		try{		
			clickByXpath(Web_UI.HybridA14, "HybridA14");
			
		System.out.println("Selected A14 from Hybrid view");
		FlightstatsSelected("A14");
		}catch(Exception NoStatsfound)
		{
			ATUReports.add("No corresponding A14 Stats Found ",  LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE)); 
		}
								
		try{	
			
			getDriver().findElement(By.xpath("//li[@title='Total Red Flight(s)']")).click();
		System.out.println("Selected Red from Hybrid view");
		FlightstatsSelected("Red");
		}catch(Exception NoStatsfound)
		{
			ATUReports.add("No corresponding Red Stats Found ",  LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE)); 
			
		}
								
		try{	
			
			getDriver().findElement(By.xpath("//li[@title='Total Yellow Flight(s)']")).click();
		System.out.println("Selected Yellow from Hybrid view");
		FlightstatsSelected("Yellow");
		}catch(Exception NoStatsfound)
		{
			ATUReports.add( "No corresponding Stats Yellow Found ",  LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE)); 
		}
										
		try{		
			
			getDriver().findElement(By.xpath("//li[@title='Total Blocked Flight(s)']")).click();
		System.out.println("Selected Blocked from Hybrid view");
		FlightstatsSelected("Blocked");
		}
		catch(Exception NoStatsfound)
		{
			ATUReports.add("No corresponding Blocked Stats Found ",  LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE)); 
			
		}
												
		try{		
			
			getDriver().findElement(By.xpath("//li[@title='Total Alerting Flight(s)']")).click();
		System.out.println("Selected Total from Hybrid view");
		FlightstatsSelected("Total");
		}
		catch(Exception NoStatsfound)
		{
			
			ATUReports.add( "No corresponding Total Stats Found ",  LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE)); 
			
		}
		
	}
	
//***************************************************************************************
	
	
// Below function will go through flightlist and gantt table and validate count matches with header upon clicking All
	public static void HybridAllGateCheck() throws Exception {

		Hybrid(Web_UI.HybridAllGate,Web_UI.HybridAllGateCount);
	}

	// Below function will go through flightlist and gantt table and validate count matches with header upon clicking IFS
	public static void HybridIFSCheck() throws Exception {
				
		Hybrid(Web_UI.HybridIFS,Web_UI.HybridIFSCount);

	}

	// Below function will go through flightlist and gantt table and validate count matches with header upon clicking All gate

	public static void HybridAcSwapsCheck() throws Exception {
		Hybrid(Web_UI.HybridAcSwaps,Web_UI.HybridAcSwapsCount);
	}

	// Below function will go through flightlist and gantt table and validate count matches with header upon clicking Potentialtows
	public static void HybridPotentialtowscheck() throws Exception {

		Hybrid(Web_UI.HybridPotential,Web_UI.HybridPotentialCount);
	}

	// Below function will go through flightlist and gantt table and validate count matches with header upon clicking Cancelled
	public static void HybridCancelledCheck() throws Exception {
		Hybrid(Web_UI.HybridCancelled,Web_UI.HybridCancelledCount);
	}

	// Below function will go through flightlist and gantt table and validate count matches with header upon clicking GateSwaps
	public static void HybridGateSwapsCheck() throws Exception {
		Hybrid(Web_UI.HybridGateSwaps,Web_UI.HybridGateSwapsCount);
	}

	// Below function will go through flightlist and gantt table and validate count matches with header upon clicking Decision

	public static void HybridDecisioncheck() throws Exception {
		Hybrid(Web_UI.HybridDecision,Web_UI.HybridDecisionCount);
	}
	
	// Below function will go through flightlist and gantt table and validate count matches with header upon clicking Delayed
	public static void HybridDelayedcheck() throws Exception {
		Hybrid(Web_UI.HybridDelayed,Web_UI.HybridDelayedCount);
	}
	
	// Below function will go through flightlist and gantt table and validate count matches with header upon clicking RightStart
	public static void HybridRightStartcheck() throws Exception {
		Hybrid(Web_UI.HybridRightStart,Web_UI.HybridRightStartCount);
	}
	
	// Below function will go through flightlist and gantt table and validate count matches with header upon clicking A14
	public static void HybridA14check() throws Exception {
		Hybrid(Web_UI.HybridA14,Web_UI.HybridA14Count);
	}
	
	// Below function will go through flightlist and gantt table and validate count matches with header upon clicking Latearrival
	public static void HybridLatearrivalcheck() throws Exception {
		Hybrid(Web_UI.HybridLatearrival,Web_UI.HybridLatearrivalCount);
	}
	
	// Below function will go through flightlist and gantt table and validate count matches with header upon clicking Earlyarrival
	public static void HybridEarlyarrivalcheck() throws Exception {
		Hybrid(Web_UI.HybridEarlyarrival,Web_UI.HybridEarlyarrivalCount);
	}
	
	// Below function will go through flightlist and gantt table and validate count matches with header upon clicking ETD
	
	public static void HybridETDcheck() throws Exception {
		Hybrid(Web_UI.HybridETD,Web_UI.HybridETDCount);
	}
	
	// Below function will go through flightlist and gantt table and validate count matches with header upon clicking Red
	public static void HybridRedcheck() throws Exception {
		Hybrid(Web_UI.HybridRed,Web_UI.HybridRedCount);
	}
	
	// Below function will go through flightlist and gantt table and validate count matches with header upon clicking Yellow
	public static void HybridYellowcheck() throws Exception {
		Hybrid(Web_UI.HybridYellow,Web_UI.HybridYellowCount);
	}
	
	// Below function will go through flightlist and gantt table and validate count matches with header upon clicking Blocked
	public static void HybridBlockedcheck() throws Exception {
		Hybrid(Web_UI.HybridBlocked,Web_UI.HybridBlockedCount);
	}
	
	// Below function will go through flightlist and gantt table and validate count matches with header upon clicking Totalalert
	public static void HybridToatalalertcheck() throws Exception {
		Hybrid(Web_UI.HybridToatalalert,Web_UI.HybridToatalalertCount);
	}
		
	
	
	public static void HybridUnlinked() throws Exception {
		Hybrid(Web_UI.HybridUnlinked,Web_UI.HybridUnlinkedCount);
	}
	
	public static void HybridTERM() throws Exception {
		Hybrid(Web_UI.HybridTERM,Web_UI.HybridTERMCount);
	}
	
	public static void HybridORIGIN() throws Exception {
		Hybrid(Web_UI.HybridORIGIN,Web_UI.HybridORIGINCount);
	}
	
	public static void HybridMEL() throws Exception {
		Hybrid(Web_UI.HybridMEL,Web_UI.HybridMELCount);
	}
	
	public static void HybridDiverted() throws Exception {
		Hybrid(Web_UI.HybridDiverted,Web_UI.HybridDivertedCount);
	}
	
	public static void HybridMOGT() throws Exception {
		Hybrid(Web_UI.HybridMOGT,Web_UI.HybridMOGTCount);
	}
	
	public static void HybridOTS() throws Exception {
		Hybrid(Web_UI.HybridOTS,Web_UI.HybridOTSCount);
	}
	
	public static void HybridGateConflict() throws Exception {
		Hybrid(Web_UI.HybridGateConflict,Web_UI.HybridGateConflictCount);
	}
	

	

	public static void Hybrid(String OptionXpath ,String OptionStatsCountvaluexpath) throws Exception {

		GanntViewHeaderFunctionality.SpinnerControl();
		CommonTest.CheckScheduled();		
		System.out.println("Validating Flight Statistics category Selection Test cases  " +OptionXpath);
		try{			
		clickByXpath(OptionXpath,"OptionXpath");
		GanntViewHeaderFunctionality.SpinnerControl();
		String HeaderAppender = getDriver().findElement(By.xpath(OptionXpath)).getAttribute("title");
		GanntViewHeaderFunctionality.SpinnerControl();
		Thread.sleep(3000);
		String Ganttheaderstatus = findelementbyxpath(Web_UI.Ganttheaderstatus).getAttribute("innerText");
		String OptionStatsCountvalueScheduled1 = findelementbyxpath(OptionStatsCountvaluexpath).getAttribute("innerText");
		String OptionStatsCountvalueScheduled = OptionStatsCountvalueScheduled1.trim();
		int ScheduledCountstats = Integer.parseInt(OptionStatsCountvalueScheduled); 
	//	CommonTest.CheckDepartureSelected();
		Thread.sleep(6000);
		int OptionStatsCountvalueinteger = ScheduledCountstats;
		String OptionStatsCountvalue = Integer.toString(OptionStatsCountvalueinteger);
		NoofRowsTestHybridTest(Ganttheaderstatus, HeaderAppender, OptionStatsCountvalue);
		CommonTest.CheckScheduled();
		Thread.sleep(2000);
		
		
		}
		catch(Exception Titleasheader)
		{

			ATUReports.add("No Corresponding stats found in Hybrid view  "+OptionXpath,  LogAs.INFO, null);
			
		}
		
	}

		
		public static void NoofRowsTestHybridTest(String SS, String Appendheadtitle, String StatsCount) throws Exception {
			System.out.println("Validating the gantt view flight puck present in the table upon selecting Category details with flight stats count	");
			GanntViewHeaderFunctionality.SpinnerControl();
			Thread.sleep(3000);
			WebElement Mainflightlisttable = getDriver().findElement(By.id("flt-list"));
			List<WebElement> Nofflights1 = Mainflightlisttable.findElements(By.xpath("//div[@class='col-sm-12 no-padding ng-scope']"));
			int flightscount = Nofflights1.size();
			List<WebElement> Nofflights2 = Mainflightlisttable.findElements(By.xpath("//div[@style='display: none;']"));
			int flightscount2 = Nofflights2.size();
			//System.out.println(gantsize);
			int GantSizetablefull = flightscount-flightscount2;
			String GB = Integer.toString(GantSizetablefull);
			if(flightscount!=0)
			{
			if (StatsCount.contains(GB)) {
				System.out.println("Flight Stats Count matches "+"  "+StatsCount+" "+GB);
				ATUReports.add("Verified the Total Number of flights puck inside Gantt view & stats count and been passed ",  LogAs.PASSED, null);
				ATUReports.add("Verified the Total Number of flights puck inside Gantt view & stats count and been passed "+" "+ StatsCount+" "+  GB,  LogAs.PASSED, null);
			
			}

			else {
				System.out.println("Flight Stats count mismatches"+"  "+StatsCount+"  "+GB);
				ATUReports.add( "Verified the Total Number of flight puck inside gantt view & stats count and Mismatch identified ",  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				ATUReports.add("Verified the Total Number of flight puck inside gantt view & stats count and Mismatch identified "+" "+StatsCount+" "+ GB,  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				Assert.fail("Failed");
			}
			}else{
				ATUReports.add(" ",  LogAs.PASSED, null);
			}
			// remove first check	
			if(SS.contains("Total")==false)
			{
			if (SS.contains(Appendheadtitle))
			{
			System.out.println("Header Holds valid title "+"  "+" "+Appendheadtitle);
			ATUReports.add("Verified Gantt view header & hold Selected Category as Title  ",  LogAs.PASSED, null);
			ATUReports.add("Verified Gantt view header & hold Selected Category as Title"+" "+ SS+" "+ Appendheadtitle,  LogAs.PASSED, null);
			}
			else
			{
				System.out.println("Flight Stats count mismatches"+"  "+StatsCount+"  "+Appendheadtitle);
				ATUReports.add("Flight Stats count mismatches"+"  "+StatsCount+"  "+Appendheadtitle,  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				ATUReports.add("Verified Gantt view header & doesnt hold Selected Category as Title"+" "+ SS+" "+ Appendheadtitle,  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				Assert.fail("Failed");
			}
			}
			
		
			if (SS.contains("Total"))
			{
			if (SS.contains("Total Alerts") || SS.contains("Total Blocked") || SS.contains("Total Red") || SS.contains("Total Yellow"))
			{
			System.out.println("Header Holds valid title "+"  "+" "+Appendheadtitle);
			ATUReports.add("Verified Gantt view header & hold Selected Category as Title  ",  LogAs.PASSED, null);
			ATUReports.add("Verified Gantt view header & hold Selected Category as Title"+" "+ SS+" "+ Appendheadtitle,  LogAs.PASSED, null);
			}
	
			else {
				System.out.println("Flight Stats count mismatches"+"  "+StatsCount+"  "+Appendheadtitle);
				ATUReports.add("Verified Gantt view headerT &  doesnt hold Selected Category as Title  ",  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				ATUReports.add("Verified Gantt view headerT & doesnt hold Selected Category as Title"+ " "+SS+" "+ Appendheadtitle,  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				Assert.fail("Failed");
			}

					}
			
		}
		
		
		
		
		
		
	
	
	


	
	
//**********************************************************************************************
	
	
	public static void HybridviewTest() throws Exception {
		Thread.sleep(5000);
		CommonTest.SpinnerControl();
		clickByXpath(Web_UI.HybridViewOption,"HybridViewOption");
		HarStart("HybridView_","HybridViewSelected");
		CommonTest.SpinnerControl();
		HarStop("HybridView_","HybridViewSelected");
		//clickByXpath("//li[@title='Late Arrivals']");
		Thread.sleep(8000);
		WebElement Mainflightlisttable = getDriver().findElement(By.id("flt-list"));
		List<WebElement> Nofflights = Mainflightlisttable.findElements(By
				.xpath("//div[@class='col-sm-12 no-padding ng-scope']"));
		int flightscount = Nofflights.size();
		System.out.println("Total Number of flights in Flightlist set to scheduled  " +flightscount);
		CommonTest.SpinnerControl();
		for (int fliNo = 1; fliNo <= flightscount; fliNo++) {
		
			
			try
			{
				
			String Flightnoo1 = getDriver().findElement(By.xpath("//*[@id='flt-list']/div[" + fliNo + "]/div/div[6]/div[2]"))
					.getText();
			String Flightnoo = Flightnoo1.trim();
			String GetCompleteGanttDetails = getDriver().findElement(By.xpath("//div[@id='scroll-row']")).getAttribute("innerText");
		
			if(GetCompleteGanttDetails.contains(Flightnoo))
			{
			//	System.out.println("Pass  " +Flightnoo);
			}
			else
			{
				System.out.println("Fail  " +Flightnoo);
			}
		
			try{
			String ArrivalFlightNo1 = getDriver().findElement(By.xpath("//*[@id='flt-list']/div[" + fliNo + "]/div/div[3]/div[2]"))
					.getText();
			String ArrivalFlightNo = ArrivalFlightNo1.trim();
		//	String GetCompleteGanttDetails1 = getDriver().findElement(By.xpath("//div[@id='scroll-row']")).getAttribute("innerText");		
			if(GetCompleteGanttDetails.contains(ArrivalFlightNo))
			{
				//System.out.println("PassA  " +ArrivalFlightNo);
			}
			else
			{
				System.out.println("FailA  " +ArrivalFlightNo);
			}
		

			
		}catch(Exception emptybackendata){
			System.out.println("Arrival Fail  " );
		}
			}
			
			catch(Exception emptybackendata)
			{
				System.out.println("Dep Fail  ");
		}
	
			//System.out.println("Flightno  " +fliNo);
			}

		
		
		
	}


//***********************************************************************************
	
	public static void FlightstatsSelected(String S) throws Exception {		
		
		WebElement HeadercategoryTitle = getDriver().findElement(By.xpath("//*[@id='wrapper']/div[2]/aside/section/div[2]/div[3]/span[1]"));
		String Headercategorystring = HeadercategoryTitle.getText();
		if(S.contains("ALL"))
		{
		if(Headercategorystring.contains("Total"))
		{
			System.out.println("Title is displayed  " + Headercategorystring);
			ATUReports.add( "Title displayed is valid "+ Headercategorystring,  LogAs.PASSED, null);
		}
		else
		{
			System.out.println("Failed  " +Headercategorystring);
			ATUReports.add("Invalid Total  Header ",  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		}
		}
		// Selecting cancelled in hybrid view
		if(S.contains("cancel")){
		if(Headercategorystring.contains("Canceled"))
		{
			System.out.println("Title is displayed  " + Headercategorystring);
			ATUReports.add("Title displayed is valid "+ Headercategorystring,  LogAs.PASSED, null);
		}
		else
		{
			System.out.println("Failed  " +Headercategorystring);
			ATUReports.add(" Canceled Invalid Header ",  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		}
		}
//Selecting EtdUpdates in hybrid view
		if(S.contains("ETD")){
			if(Headercategorystring.contains("ETD"))
			{
				System.out.println("Title is displayed  " + Headercategorystring);
				ATUReports.add("Title displayed is valid "+ Headercategorystring,  LogAs.PASSED, null);
			}
			else
			{
				System.out.println("Failed  " +Headercategorystring);
				ATUReports.add("ETD Invalid Header ",  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}
		}

//Selecting Decision in hybrid view
		if(S.contains("Decision")){
			if(Headercategorystring.contains("Decision"))
			{
				System.out.println("Title is displayed  " + Headercategorystring);
				ATUReports.add("Title displayed is valid "+ Headercategorystring,  LogAs.PASSED, null);
			}
			else
			{
				System.out.println("Failed  " +Headercategorystring);
				ATUReports.add("Decision Invalid Header ",  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}
		}
//Selecting Late Arrivals in hybrid view
		if(S.contains("Late")){		
			if(Headercategorystring.contains("Late"))
			{
				System.out.println("Title is displayed  " + Headercategorystring);
				ATUReports.add("Title displayed is valid "+ Headercategorystring,  LogAs.PASSED, null);
			}
			else
			{
				System.out.println("Failed  " +Headercategorystring);
				ATUReports.add("Late Invalid Header ",  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}
		}
//Selecting Early Arrivals in hybrid view
		if(S.contains("Early")){
			if(Headercategorystring.contains("Early"))
			{
				System.out.println("Title is displayed  " + Headercategorystring);
				ATUReports.add("Title displayed is valid "+ Headercategorystring,  LogAs.PASSED, null);
			}
			else
			{
				System.out.println("Failed  " +Headercategorystring);
				ATUReports.add("Early Invalid Header ",  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}
		}

//Selecting Gate swaps in hybrid view
			
		if(S.contains("Gate")){	
			if(Headercategorystring.contains("Gate"))
			{
				System.out.println("Title is displayed  " + Headercategorystring);
				ATUReports.add("Title is displayed  " + Headercategorystring,  LogAs.PASSED, null);
			}
			else
			{
				System.out.println("Failed  " +Headercategorystring);
			    ATUReports.add("Gate Invalid Header ",  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				
			}
		}		

//Selecting A/C swaps in hybrid view
		
		if(S.contains("A/C")){
			if(Headercategorystring.contains("A/C"))
			{
				System.out.println("Title is displayed  " + Headercategorystring);
				ATUReports.add("Title displayed is valid "+ Headercategorystring,  LogAs.PASSED, null);
			}
			else
			{
				System.out.println("Failed  " +Headercategorystring);
				ATUReports.add("AC Invalid Header ",  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				
			}	

		}
//Selecting Rightstart in hybrid view
		if(S.contains("Right")){
			if(Headercategorystring.contains("Right"))
			{
				System.out.println("Title is displayed  " + Headercategorystring);
				ATUReports.add("Title displayed is valid "+ Headercategorystring,  LogAs.PASSED, null);
				
			}
			else
			{
				System.out.println("Failed  " +Headercategorystring);
				ATUReports.add("Right Invalid Header ",  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				
			}

		}
//Selecting Potential Tows in hybrid view
		if(S.contains("Potential")){
			if(Headercategorystring.contains("Potential"))
			{
				System.out.println("Title is displayed  " + Headercategorystring);
				ATUReports.add("Title displayed is valid "+ Headercategorystring,  LogAs.PASSED, null);
			}
			else
			{
				System.out.println("Failed  " +Headercategorystring);
				ATUReports.add("Potential Invalid Header ",  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				
			}
		}
//Selecting IFS in hybrid view
	
		if(S.contains("IFS")){
			if(Headercategorystring.contains("IFS"))
			{
				System.out.println("Title is displayed  " + Headercategorystring);
				ATUReports.add("Title displayed is valid "+ Headercategorystring,  LogAs.PASSED, null);
			}
			else
			{
				System.out.println("Failed  " +Headercategorystring);
				ATUReports.add("IFS Invalid Header ",  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}
		}		
//Selecting Delayed in hybrid view
	
		if(S.contains("Delayed")){	
			if(Headercategorystring.contains("Delayed"))
			{
				System.out.println("Title is displayed  " + Headercategorystring);
				ATUReports.add("Title is displayed  " + Headercategorystring,  LogAs.PASSED, null);
			}
			else
			{
				System.out.println("Failed  " +Headercategorystring);
				ATUReports.add("Delayed Invalid Header  " +Headercategorystring,  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}
		}
//Selecting A14 Risk in hybrid view
			
		if(S.contains("A14")){
			if(Headercategorystring.contains("A14"))
			{
				System.out.println("Title is displayed  " + Headercategorystring);
				ATUReports.add( "Title is displayed  " + Headercategorystring,  LogAs.PASSED, null);
			}
			else
			{
				System.out.println("Failed  " +Headercategorystring);
				ATUReports.add("A14 Failed  " +Headercategorystring,  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}
		}
//Selecting Total Red Flight(s) in hybrid view
			
		if(S.contains("Red")){	
			if(Headercategorystring.contains("Red"))
			{
				System.out.println("Title is displayed  " + Headercategorystring);
				ATUReports.add("Title is displayed  " + Headercategorystring,  LogAs.PASSED, null);
			}
			else
			{
				System.out.println("Failed  " +Headercategorystring);
				ATUReports.add("Failed  " +Headercategorystring,  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}
		}
//Selecting Total Yellow Flight(s) in hybrid view
	
		if(S.contains("Yellow")){
			if(Headercategorystring.contains("Yellow"))
			{
				System.out.println("Title is displayed  " + Headercategorystring);
				ATUReports.add("Title is displayed  " + Headercategorystring,  LogAs.PASSED, null);
			}
			else
			{
				System.out.println("Failed  " +Headercategorystring);
				ATUReports.add("Failed  " +Headercategorystring,  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}
		}
		
//Selecting Total Blocked Flight(s) in hybrid view
			
		if(S.contains("Blocked")){	
			if(Headercategorystring.contains("Blocked"))
			{
				System.out.println("Title is displayed  " + Headercategorystring);
				ATUReports.add("Title displayed is valid "+ Headercategorystring,  LogAs.PASSED, null);
			}
			else
			{
				System.out.println("Failed  " +Headercategorystring);
				ATUReports.add("Failed  " +Headercategorystring,  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}
		}

//Selecting Total Alerting Flight(s) in hybrid view
			
		if(S.contains("Total")){		
			if(Headercategorystring.contains("Total"))
			{
				System.out.println("Title is displayed  " + Headercategorystring);
				ATUReports.add("Title is displayed  " + Headercategorystring,  LogAs.PASSED, null);
			}
			else
			{
				System.out.println("Failed  " +Headercategorystring);
				ATUReports.add("Invalid Header "+Headercategorystring,  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}

		}
	}

}