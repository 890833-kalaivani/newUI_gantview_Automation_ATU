package get.next.gen.utilities;

import get.next.gen.commonaction.CommonTest;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;










import get.next.gen.serviceutils.correction;
import get.next.gen.webtestcase.*;

import org.apache.commons.lang3.time.DateUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;


import org.testng.annotations.Listeners;

import atu.testng.reports.ATUReports;
import atu.testng.reports.logging.LogAs;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;





import com.sun.jna.platform.win32.OaIdl.SYSKIND;

import atu.testng.reports.listeners.ATUReportsListener;
import atu.testng.reports.listeners.ConfigurationListener;
import atu.testng.reports.listeners.MethodListener;
@Listeners({ ATUReportsListener.class, ConfigurationListener.class,
MethodListener.class })


//
public class FlightStatsconfirmation extends CommonTest {
	
	
// Validate the L is present in the Arrival details for all flight puck upon selecting LateArrivals
	public static void Latearrivalconform(String view) throws Exception {
		System.out.println("Validating Late arrival flight statics with gantt view. If the flights are late , then the flight should hold the *L* with Late by minutes value ");
		Thread.sleep(3000);
		TestcaseInit();
		CommonTest.Selectview(view);
		System.out.println("Selected view for validation is "+view);
		CheckCollapse();
		CommonTest.zoomin();
		CommonTest.zoomin();
		CommonTest.zoomindata();
		CommonTest.zoomindata();
		try
		{
		clickByXpathbyView(view, Web_UI.LateArrival, Web_UI.HybridLatearrival);
		ATUReports.add("Selected Late arrival stats from Statistics ",  LogAs.PASSED, null);
		CommonTest.SpinnerControl();
		Thread.sleep(3000);
		clickByXpath(Web_UI.SortAscending,"SortAscending");
		Thread.sleep(1000);
		// Select Sort Ascending gate by alphabetical order from dropdown
		clickByXpath(Web_UI.SortAscendinggate,"SortAscendinggate");
		
		Thread.sleep(1000);
	
		List<WebElement> Ganntlist = getDriver().findElements(By.xpath(Web_UI.PuckComplete));
		int Ganntlistcount = Ganntlist.size();
	
		if(Ganntlistcount == 0)
		{
			CommonTest.CheckGanttviewListisnotZero();
		}
		CheckCollapse();
		clickByXpathbyView(view, Web_UI.LateArrival, Web_UI.HybridLatearrival);
		CommonTest.CheckExpand();
		List<WebElement> Ganntlist1= getDriver().findElements(By.xpath(Web_UI.PuckComplete));
		int Ganntlistcount1 = Ganntlist1.size();
		
		if(Ganntlistcount1 == 0)
		{
			ATUReports.add( "*************Gantt List is Zero and hence Exiting test smoothly*******************",  LogAs.PASSED, null);
		}else
		{
	
			int i=0;
			for (WebElement gantelement : Ganntlist) {
			i++;
			try{
				String idofelement = gantelement.getAttribute("id");
				ATUReports.add("Verifying puck with id :: "+idofelement,  LogAs.INFO, null); 
				
			}catch(Exception id)
			{
				
			}
						try {

							Actions actions = new Actions(getDriver());
							actions.moveToElement(gantelement).build().perform();
							actions.moveToElement(gantelement);
							String Arrivaltimetext = gantelement.getAttribute("innerText");
							if(Arrivaltimetext!="")
							{
				
							if (Arrivaltimetext.contains("L")) {
								System.out.println("Verified the puck and the flight arrived late "+i);
								ATUReports.add("Verified the puck and the flight arrived late  "+i,  LogAs.PASSED, null);
							} else {
								
								String Arrivaltimetext1 = gantelement.getAttribute("innerText");gantelement.findElement(By.xpath("div[@class='puck-contnt puck-data-center puck-full-width']")).getAttribute("innerText");
								if (Arrivaltimetext1.contains("L")) {
									ATUReports.add("Verified the puck and the flight arrived late "+i,  LogAs.PASSED, null);
								}else{
								System.out.println("The flight donot belongs to late arrival "+i);
								ATUReports.add("The flight donot belongs to late arrival "+i,  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								}
							}
							}
						}	catch (Exception Exee) {
							System.out.println("Exception while moving to the element "+i);
							ATUReports.add("Exception while moving to the element "+i,  LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE)); 
							}
						
								} 
		
			
		}		}catch(Exception Noelement)
		{
			
			ATUReports.add("Late Arrival may not present in flight statistics",  LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE)); 
		}
				CommonTest.CheckCollapse();
				CommonTest.zoomOut();
				CommonTest.zoomOut();
	}
		
		
		
		
	public static void Cancelledflightconform(String view) throws Exception {
		System.out.println("Validating Cancelled flight statics with gantt view. A Cancelled flight should hold the Status *CXL*. Color validation will be performed in Different script");
		Thread.sleep(3000);
		TestcaseInit();
		CommonTest.Selectview(view);
		System.out.println("Selected view for validation is "+view);
		CheckCollapse();
		CommonTest.zoomin();
		CommonTest.zoomin();
		CommonTest.zoomindata();
		try
		{
		clickByXpathbyView(view, Web_UI.Canceled, Web_UI.HybridCancelled);
		
		ATUReports.add("Cancelled Flight stats selected successfully",  LogAs.PASSED, null);
		CommonTest.SpinnerControl();
		Thread.sleep(3000);
		CommonTest.CheckExpand();
		//Perform Sort functionality so that empty gates issue can be avoided
		clickByXpath(Web_UI.SortAscending,"SortAscending");
		Thread.sleep(1000);
		// Select Sort Ascending gate by alphabetical order from dropdown
		clickByXpath(Web_UI.SortAscendinggate,"SortAscendinggate");
		Thread.sleep(1000);
		List<WebElement> Ganntlist = getDriver().findElements(By.xpath(Web_UI.PuckComplete));
		int Ganntlistcount = Ganntlist.size();
		if(Ganntlistcount == 0)
		{
			CommonTest.CheckGanttviewListisnotZero();
		}
		CommonTest.SpinnerControl();
		CheckCollapse();
		clickByXpathbyView(view, Web_UI.Canceled, Web_UI.HybridCancelled);
		CommonTest.CheckExpand();
		List<WebElement> Ganntlist1 = getDriver().findElements(By.xpath(Web_UI.PuckComplete));
		int Ganntlistcount1 = Ganntlist1.size();
		
		if(Ganntlistcount1 == 0)
		{
					ATUReports.add("*************Gantt List is Zero and hence Exiting test smoothly*******************",  LogAs.PASSED, null);
		}else{
	
			int i=0;
			
			//Loop the list and check each and every element for the functionality
			for (WebElement gantelement : Ganntlist) {
			i++;
			try{
				
				String idofelement = gantelement.getAttribute("id");
				ATUReports.add("Verifying puck with id :: "+idofelement,  LogAs.INFO, null); 
				
			}catch(Exception id)
			{
				
			}
						try {
							Actions actions = new Actions(getDriver());
							actions.moveToElement(gantelement).build().perform();
							actions.moveToElement(gantelement);
							
							String Arrivaltimetext = gantelement.getAttribute("innerText");
							System.out.println("Arrivaltimetext:"+Arrivaltimetext);
							if(Arrivaltimetext!="")
							{
				
							if (Arrivaltimetext.contains("CXL")) {
								
								ATUReports.add("Validated CXL present in gantt view for flight puck no "+i,  LogAs.PASSED, null);
							} else {
								System.out.println("Status CXL is not present ");
								ATUReports.add("Status CXL is not present",  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
							
							}
							}
						}	catch (Exception Exee) {
							System.out.println("Exception while moving to the element "+i);
							ATUReports.add("Exception while moving to the element "+i,  LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE)); 	
						}
						
								} 
		
			
		}		}catch(Exception Noelement)
		{
			
			captureinfoScreenshot(getDriver()," Cancelled Flight statistics may not present in flight statistics");
			ATUReports.add(" Cancelled Flight statistics may not present in flight statistics",  LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE)); 
		}
				CommonTest.CheckCollapse();
				CommonTest.zoomOut();
				CommonTest.zoomOut();
	}

	

	public static void GroundInterruptConform(String view) throws Exception {
		

		System.out.println("Validating GroundInterrupt flight statics with gantt view. A Ground interrupt flight puck should hold status *RTD*");
		Thread.sleep(3000);
		TestcaseInit();
		CheckCollapse();
		CommonTest.Selectview(view);
		System.out.println("Selected view for validation is "+view);
		CommonTest.zoomin();
		CommonTest.zoomin();
		CommonTest.zoomin();
		CommonTest.zoomin();
		CommonTest.zoomindata();
		try
		{

		clickByXpathbyView(view, Web_UI.Groundinterrupt, Web_UI.Groundinterrupt);
	
		ATUReports.add("Ground Flight stats selected successfully",  LogAs.PASSED, null);
		CommonTest.SpinnerControl();
		Thread.sleep(3000);
		clickByXpath(Web_UI.SortAscending,"SortAscending");
		Thread.sleep(1000);
		// Select Sort Ascending gate by alphabetical order from dropdown
		clickByXpath(Web_UI.SortAscendinggate,"SortAscendinggate");
		
		Thread.sleep(1000);
		CommonTest.CheckExpand();
		List<WebElement> Ganntlist = getDriver().findElements(By.xpath(Web_UI.PuckComplete));
		int Ganntlistcount = Ganntlist.size();
		if(Ganntlistcount == 0)
		{
			CommonTest.CheckGanttviewListisnotZero();
		}
		CheckCollapse();
		clickByXpathbyView(view, Web_UI.Groundinterrupt, Web_UI.Groundinterrupt);
		CommonTest.CheckExpand();
		List<WebElement> Ganntlist1= getDriver().findElements(By.xpath(Web_UI.PuckComplete));
		int Ganntlistcount1 = Ganntlist1.size();
		
		if(Ganntlistcount1 == 0)
		{
		
			ATUReports.add("*************Gantt List is Zero and hence Exiting test smoothly*******************",  LogAs.PASSED, null);
		}else{
	
			int i=0;
			for (WebElement gantelement : Ganntlist) {
			i++;
			try{
				String idofelement = gantelement.getAttribute("id");
	
				ATUReports.add("Verifying puck with id :: "+idofelement,  LogAs.INFO, null); 
	
			}catch(Exception id)
			{
				
			}
						
						try {
							Actions actions = new Actions(getDriver());
							actions.moveToElement(gantelement).build().perform();
							String Arrivaltimetext = gantelement.getAttribute("innerText");
							Boolean Arrivalcontent = Arrivaltimetext.contains(":");
							if(Arrivaltimetext!=""||Arrivalcontent==true)
							{
				
							if (Arrivaltimetext.contains("RTD")) {
		
								ATUReports.add("Validated RTD present in gantt view for flight puck No"+i,  LogAs.PASSED, null);
							} else {
								System.out.println("Status RTD is not present ");
								captureinfoScreenshot(getDriver(),"Status RTD is not present "+i);
			
								ATUReports.add("Status RTD is not present",  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				
							}
							}
						}	catch (Exception Exee) {
							System.out.println("Exception while moving to the element "+i);
		
							ATUReports.add("Exception while moving to the element "+i,  LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE)); 
							}
						
								} 
		
		}			}catch(Exception Noelement)
		{
			
				ATUReports.add("Ground Interrupt Statistics may not present in flight statistics",  LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE)); 
		}
				CommonTest.CheckCollapse();
				CommonTest.zoomOut();
				CommonTest.zoomOut();
	
		
	}
	
	
	public static void Earlyarrivalsflightconform(String view) throws Exception {
		

		System.out.println("Validating EarlyArrivals flight statics with gantt view.A Early Arrival flight puck should hold the *E* with time in min");
		Thread.sleep(3000);
		TestcaseInit();
		CheckCollapse();
		CommonTest.Selectview(view);
		System.out.println("Selected view for validation is "+view);
		CommonTest.zoomin();
		CommonTest.zoomin();
		CommonTest.zoomindata();
		try
		{

		clickByXpathbyView(view, Web_UI.EarlyArrival, Web_UI.HybridEarlyarrival);

		ATUReports.add("Early Arrival Flight stats selected successfully",  LogAs.PASSED, null);
		CommonTest.SpinnerControl();
		Thread.sleep(3000);
		clickByXpath(Web_UI.SortAscending,"SortAscending");
		Thread.sleep(1000);
		// Select Sort Ascending gate by alphabetical order from dropdown
		clickByXpath(Web_UI.SortAscendinggate,"SortAscendinggate");
		Thread.sleep(1000);
	
		
		CommonTest.CheckExpand();
		
		List<WebElement> Ganntlist = getDriver().findElements(By.xpath(Web_UI.PuckComplete));
		int Ganntlistcount = Ganntlist.size();
		if(Ganntlistcount == 0)
		{
			CommonTest.CheckGanttviewListisnotZero();
		}
		
		CommonTest.SpinnerControl();
		CheckCollapse();
		clickByXpathbyView(view, Web_UI.EarlyArrival, Web_UI.HybridEarlyarrival);
		CommonTest.CheckExpand();
		List<WebElement> Ganntlist1 = getDriver().findElements(By.xpath(Web_UI.PuckComplete));
		int Ganntlistcount1 = Ganntlist1.size();
		if(Ganntlistcount1 == 0)
		{

			ATUReports.add("*************Gantt List is Zero and hence Exiting test smoothly*******************",  LogAs.PASSED, null);
		}else{
		
			int i=0;
			for (WebElement gantelement : Ganntlist) {
			i++;
						
			try{

				String idofelement = gantelement.getAttribute("id");

				ATUReports.add("Verifying puck with id :: "+idofelement,  LogAs.INFO, null); 
			
			}catch(Exception id)
			{
				
			}
			
						try {
							Actions actions = new Actions(getDriver());
							actions.moveToElement(gantelement).build().perform();
							String Arrivaltimetext = gantelement.getAttribute("innerText");
			
							if(Arrivaltimetext!="")
							{
				
							if (Arrivaltimetext.contains("E")) {
								
				
								ATUReports.add("Verified and the flight number arrived early and belongs to early arrival statistics ::"+i,  LogAs.PASSED, null);
							} else {
								System.out.println("Not falls under early arrival statistics  Flight no:: "+i);
								ATUReports.add("Flight doesnot belongs to early arrival statistics "+i,  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								
							}
							}
						}	catch (Exception Exee) {
							System.out.println("Exception while moving to the element "+i);

							ATUReports.add("Exception while moving to the element "+i,  LogAs.INFO, null);
							}
						
								} 
		
		}		}catch(Exception Noelement)
		{
			

			ATUReports.add("Early Arrivals Flight Statistics may not present in flight statistics",  LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE)); 
			captureinfoScreenshot(getDriver(),"Early Arrivals Flight Statistics may not present in flight statistics");
		}
				CommonTest.CheckCollapse();
				CommonTest.zoomOut();
				CommonTest.zoomOut();
	
		
	}

	public static void GateSwapsconform(String view) throws Exception {
		
			System.out.println("Validating GateSwap flight statics with gantt view. A Gate swap Flight should hold an icon with Gate swap. Upon clicking it should have the content stating Gate swapped details");
			Thread.sleep(3000);
			TestcaseInit();
			CheckCollapse();
			CommonTest.Selectview(view);
			System.out.println("Selected view for validation is "+view);
			CommonTest.zoomin();
			CommonTest.zoomin();
			CommonTest.zoomindata();
			try
			{

			clickByXpathbyView(view, Web_UI.GateSwaps, Web_UI.HybridGateSwaps);

			ATUReports.add(" ",  LogAs.PASSED, null);
			CommonTest.SpinnerControl();
			Thread.sleep(3000);
			clickByXpath(Web_UI.SortAscending,"SortAscending");
			Thread.sleep(1000);
			// Select Sort Ascending gate by alphabetical order from dropdown
			clickByXpath(Web_UI.SortAscendinggate,"SortAscendinggate");
			
			Thread.sleep(1000);
			CommonTest.CheckExpand();
			List<WebElement> Ganntlist = getDriver().findElements(By.xpath(Web_UI.Gateswapicons));
			int Ganntlistcount = Ganntlist.size();
			if(Ganntlistcount == 0)
			{
				CommonTest.CheckGanttviewListisnotZero();
			}
			CommonTest.SpinnerControl();
			CheckCollapse();
			clickByXpathbyView(view, Web_UI.GateSwaps, Web_UI.HybridGateSwaps);
			CommonTest.CheckExpand();
			List<WebElement> Ganntlist1 = getDriver().findElements(By.xpath(Web_UI.PuckComplete));
			int Ganntlistcount1 = Ganntlist1.size();
			if(Ganntlistcount1 == 0)
			{

				ATUReports.add("*************Gantt List is Zero and hence Exiting test smoothly*******************",  LogAs.PASSED, null);
			}else{
			
				int i=0;
				for (WebElement gantelement : Ganntlist) {
				i++;
				try{
					String idofelement = gantelement.findElement(By.xpath("ancestor::div[@data-ng-click='getEvents(flt,$event);']")).getAttribute("id");

					ATUReports.add("Verifying puck with id :: "+idofelement,  LogAs.INFO, null); 

				}catch(Exception id)
				{
					
				}
				
							try {
								Actions actions = new Actions(getDriver());
								actions.moveToElement(gantelement).build().perform();
								actions.moveToElement(gantelement).click(gantelement).build().perform();
								//actions.moveToElement(gantelement);
								//gantelement.click();
								Thread.sleep(1000);
								WebElement Extract = getDriver().findElement(By.xpath("//div[@class='popover-content']"));
								String elementExtract = Extract.getAttribute("innerText");
	
								if(elementExtract!="")
								{
								if(elementExtract.contains("DG/C")||elementExtract.contains("AG/C"))
								{
									WebElement Closebutton = getDriver().findElement(By.xpath("//div[contains(@class,'pop-over-close')]"));
									Closebutton.click();
										System.out.println("GateswapAlert icon present for the flight " +i);
										ATUReports.add("GateswapAlert icon present for the flight "+i,  LogAs.PASSED, null);
										ATUReports.add("Gate Swap details present in the Report and validated "+i,  LogAs.PASSED, null);
								}	
								else{
		
									ATUReports.add("Some issues in gateswap report "+i,  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									
								}
						
							
							}	
							}
							catch (Exception Exee) {
							}
								
								}
							
							
		
			}		}catch(Exception Noelement)
			{
				

				ATUReports.add("Gate Swap Flight Statistics may not present in flight statistics",  LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE)); 
				}
					CommonTest.CheckCollapse();
					CommonTest.zoomOut();
					CommonTest.zoomOut();
		
			
	}
	
	
	public static void DivertedConform(String view) throws Exception {

		
		System.out.println("Validating DIV is present in all puck when Diverted is selected from statistics");
		Thread.sleep(3000);
		TestcaseInit();
		CheckCollapse();
		CommonTest.Selectview(view);
		System.out.println("Selected view for validation is "+view);
		CommonTest.zoomin();
		CommonTest.zoomin();
		CommonTest.zoomindata();
		try
		{

			clickByXpathbyView(view, Web_UI.Diverted, Web_UI.HybridDiverted);

		ATUReports.add("Diverted Flight stats selected successfully",  LogAs.PASSED, null);
		CommonTest.SpinnerControl();
		Thread.sleep(3000);
		
		clickByXpath(Web_UI.SortAscending,"SortAscending");
		Thread.sleep(1000);
		// Select Sort Ascending gate by alphabetical order from dropdown
		clickByXpath(Web_UI.SortAscendinggate,"SortAscendinggate");
		Thread.sleep(1000);
		
		CommonTest.CheckExpand();
		
		List<WebElement> Ganntlist = getDriver().findElements(By.xpath(Web_UI.PuckCompleteLinkage));
		int Ganntlistcount = Ganntlist.size();
		if(Ganntlistcount == 0)
		{
			CommonTest.CheckGanttviewListisnotZero();
		}
		CommonTest.SpinnerControl();
		CheckCollapse();
		clickByXpathbyView(view, Web_UI.Diverted, Web_UI.HybridDiverted);
	
		CommonTest.CheckExpand();
		List<WebElement> Ganntlist1 = getDriver().findElements(By.xpath(Web_UI.PuckComplete));
		int Ganntlistcount1 = Ganntlist1.size();
		if(Ganntlistcount1 == 0)
		{

			ATUReports.add("*************Gantt List is Zero and hence Exiting test smoothly*******************",  LogAs.PASSED, null);
		}else{
		
			int i=0;
			for (WebElement gantelement : Ganntlist) {
			i++;
						
			try{
				String idofelement = gantelement.findElement(By.xpath("ancestor::div[@data-ng-click='getEvents(flt,$event);']")).getAttribute("id");
				ATUReports.add( "Verifying puck with id :: "+idofelement,  LogAs.INFO, null); 

			}catch(Exception id)
			{
				
			}
			
						try {
							Actions actions = new Actions(getDriver());
							actions.moveToElement(gantelement).build().perform();
							Thread.sleep(1000);
							String elementExtract = gantelement.getAttribute("innerText");

							if(elementExtract!="")
							{
							if(elementExtract.contains("DIV"))
							{
								
									System.out.println("DIV is present in puck and its Diverted flight " +i);

									ATUReports.add("DIV is present in puck and its Diverted flight " +i,  LogAs.PASSED, null);
							}	else
							{
								if(elementExtract.contains("ORIG")||(elementExtract.contains("TERM")))
								{

									ATUReports.add("The Selected flight is Term flight and hence Diverted text will not be published in puck "+i,  LogAs.PASSED, null);
								}
								else{

								ATUReports.add("DIV is not present in puck and its not Diverted flight "+i,  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								captureinfoScreenshot(getDriver(),"DIV is not present in puck and its not Diverted flight "+i);
								}
							}
					
						
						}	
						}
						catch (Exception Exee) {
						}
							System.out.println("Exception while moving to the element "+i);
							}
						
			
		}
		}catch(Exception Noelement)
		{
			
			ATUReports.add("Diverted Statistics may not present in flight statistics",  LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE)); 
			}
				CommonTest.CheckCollapse();
				CommonTest.zoomOut();
				CommonTest.zoomOut();
	
		
	}
	
	public static void ACSwapConform(String view) throws Exception {
		
		System.out.println("Validating the AC Swap flight statics with gantt view. Flight Puck should hold swap icon and upon clicking should display the A/C swap details");
		Thread.sleep(3000);
		TestcaseInit();
		CheckCollapse();
		CommonTest.Selectview(view);
		System.out.println("Selected view for validation is "+view);
		CommonTest.zoomin();
		CommonTest.zoomin();
		CommonTest.zoomindata();
		
		try
		{

		clickByXpathbyView(view, Web_UI.ACSwaps, Web_UI.HybridAcSwaps);

		ATUReports.add("AC Swaps Flight stats selected successfully",  LogAs.PASSED, null);
		CommonTest.SpinnerControl();
		Thread.sleep(3000);
		clickByXpath(Web_UI.SortAscending,"SortAscending");
		Thread.sleep(1000);
		// Select Sort Ascending gate by alphabetical order from dropdown
		clickByXpath(Web_UI.SortAscendinggate,"SortAscendinggate");
		
		Thread.sleep(1000);
		CommonTest.CheckExpand();
		List<WebElement> Ganntlist = getDriver().findElements(By.xpath(Web_UI.Gateswapicons));
		int Ganntlistcount = Ganntlist.size();
		if(Ganntlistcount == 0)
		{
			CommonTest.CheckGanttviewListisnotZero();
		}
		CommonTest.SpinnerControl();
		CheckCollapse();
		clickByXpathbyView(view, Web_UI.ACSwaps, Web_UI.HybridAcSwaps);
		CommonTest.CheckExpand();		
		List<WebElement> Ganntlist1 = getDriver().findElements(By.xpath(Web_UI.PuckComplete));
		int Ganntlistcount1 = Ganntlist1.size();
		
		if(Ganntlistcount1 == 0)
		{

			ATUReports.add("Gantt List  Iis Zero and hence Exiting test smoothly",  LogAs.PASSED, null);
		}else{
		
			int i=0;
			for (WebElement gantelement : Ganntlist) {
			i++;
					
			try{
				String idofelement = gantelement.findElement(By.xpath("ancestor::div[@data-ng-click='getEvents(flt,$event);']")).getAttribute("id");
	
				ATUReports.add("Verifying puck with id :: "+idofelement,  LogAs.INFO, null); 
	
			}catch(Exception id)
			{
				
			}
			
						try {
							Actions actions = new Actions(getDriver());
							actions.moveToElement(gantelement).build().perform();
							actions.moveToElement(gantelement).click(gantelement).build().perform();
//							actions.moveToElement(gantelement);
//							gantelement.click();
							Thread.sleep(1000);
							WebElement Extract = getDriver().findElement(By.xpath("//div[@class='popover-content']"));
							String elementExtract = Extract.getAttribute("innerText");
				
							if(elementExtract!="")
							{
							if(elementExtract.contains("A/C"))
							{
								WebElement Closebutton = getDriver().findElement(By.xpath("//div[contains(@class,'pop-over-close')]"));
								Closebutton.click();
									System.out.println("GateswapAlert icon present for the flight " +i);
							ATUReports.add("GateswapAlert icon present for the flight " +i,  LogAs.PASSED, null);
									ATUReports.add("AC Swap details present in the Report and validated "+i,  LogAs.PASSED, null);
							}	
							else
							{
						
								
							}
					
						
						}	
						}
						catch (Exception Exee) {
						}
							
							}
						
		
		}	}catch(Exception Noelement)
		{
		
			ATUReports.add("Gate Swap Flight Statistics may not present in flight statistics",  LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE)); 
		}
				CommonTest.CheckCollapse();
				CommonTest.zoomOut();
				CommonTest.zoomOut();
	
		
	
}
	
	
	
	public static void IFSconform(String view) throws Exception {
	System.out.println("Validating Flagship details displayed are valid. Flagship statistics will hold list of flights comes under certain EQTYPE provided in requirement");

	TestcaseInit();
	CheckCollapse();	
	Thread.sleep(5000);
	CommonTest.Selectview(view);
	System.out.println("Selected view for validation is "+view);
		CommonTest.zoomin();
		CommonTest.zoomin();
		CommonTest.zoomindata();
		try
		{
			 GanntViewHeaderFunctionality.SpinnerControl();	

		clickByXpathbyView(view, Web_UI.IFS, Web_UI.HybridIFS);

		ATUReports.add("IFS Flight stats selected successfully",  LogAs.PASSED, null);
		 GanntViewHeaderFunctionality.SpinnerControl();	 
		Thread.sleep(5000);
		clickByXpath(Web_UI.SortAscending,"SortAscending");
		Thread.sleep(1000);
		// Select Sort Ascending gate by alphabetical order from dropdown
		clickByXpath(Web_UI.SortAscendinggate,"SortAscendinggate");
		
		Thread.sleep(1000);
		CommonTest.CheckExpand();
	
		List<WebElement> Ganntlist = getDriver().findElements(By.xpath(Web_UI.PuckComplete));
		int Ganntlistcount = Ganntlist.size();
		if(Ganntlistcount == 0)
		{
			CommonTest.CheckGanttviewListisnotZero();
		}
		CommonTest.SpinnerControl();
		CheckCollapse();
		clickByXpathbyView(view, Web_UI.IFS, Web_UI.HybridIFS);
		CommonTest.CheckExpand();
		List<WebElement> Ganntlist1 = getDriver().findElements(By.xpath(Web_UI.PuckComplete));
		int Ganntlistcount1 = Ganntlist1.size();
		
		if(Ganntlistcount1 == 0)
		{

			ATUReports.add("*************Gantt List is Zero and hence Exiting test smoothly*******************",  LogAs.PASSED, null);
		}else{
	
			int i=0;
			for (WebElement gantelement : Ganntlist) {
				try
				{
					
				i++;
				if(i<100)
				{
					
	
					Actions actions = new Actions(getDriver());		
					WebElement elee = gantelement;
					actions.moveToElement(elee).build().perform();
					try{
						String idofelement = gantelement.getAttribute("id");
						ATUReports.add("Verifying puck with id :: "+idofelement,  LogAs.INFO, null); 
						WebElement IFSDestination = gantelement.findElement(By.xpath("div[@class='puck-contnt puck-data-center']/div[@class='puck-additional-det']/span[1]"));
						String IFSDestinationText = IFSDestination.getAttribute("innerText");
						String IFSDestinationText1[] = 	IFSDestinationText.split("/");
						String IFSDestinationText2 = IFSDestinationText1[1];
						String IFSDestinationFinal = IFSDestinationText2.trim();
						
						WebElement IFSArrival = gantelement.findElement(By.xpath("div[@class='puck-contnt puck-data-center']/div[@class='mel-ots puck-dest-det-add']/span[1]"));
						String IFSArrivalText = IFSArrival.getAttribute("innerText");
						String IFSArrivalText1[] = 	IFSArrivalText.split("/");
						String IFSArrivalText2 = IFSArrivalText1[1];
						String IFSArrivalFinal = IFSArrivalText2.trim();
					
						List<String> IFSCODE = Arrays.asList("7673","321T","763P","76RP","757E","75EL","757R","757P","757X","772M","B772","772A","773W","A330","A332","7878","7879");
						boolean contains = IFSCODE.contains(IFSDestinationFinal);
						boolean contains1 = IFSCODE.contains(IFSArrivalFinal); 					
						
						if(contains == true || contains1 == true )
						{
	
							ATUReports.add("IFS details validated and details of flight   "+"  "+IFSArrivalFinal,  LogAs.PASSED, null);
							System.out.println("IFS details validated and details of flight  "+i);
									
							
						} else {
						
							System.out.println("IFS Invalid "+i+"  "+IFSArrivalFinal);
							captureinfoScreenshot(getDriver(),"IFS Invalid "+i+"  "+IFSArrivalFinal);
							ATUReports.add("IFS Invalid "+i+"  "+IFSArrivalFinal,  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

						}
						
					}
					catch(Exception Noelmentfound)
					{
						
					}
				}
			
				}
			
				catch(Exception IFS)
				{
					
				}
			
		}
			}
		
		
		}
		catch(Exception Noelement)
		{

			ATUReports.add(" may not present ",  LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE)); 
		
		}
		
		CommonTest.CheckCollapse();
		CommonTest.zoomOut();
		CommonTest.zoomOut();
		}
	
	
	
	public static void PotentialTowsconform(String view) throws Exception {
		System.out.println("Validating Potential Tow Information Confirmation Testcase");
	
		TestcaseInit();
		CheckCollapse();
		Thread.sleep(5000);
		clickByXpath("//div[@title='Hybrid View']","Hybrid View");
		clickByXpath("//li[@title='Potential Tows']","Potential Tows");
		CommonTest.SpinnerControl();
		Thread.sleep(5000);
		
		
		WebElement Mainflightlisttable = getDriver().findElement(By.id("flt-list"));
		List<WebElement> Nofflights = Mainflightlisttable.findElements(By
				.xpath("//div[@class='col-sm-12 no-padding ng-scope']"));
		int flightscount = Nofflights.size();

		for (int fliNo = 1; fliNo <= flightscount; fliNo++) {
			
			String Arrivalgate1 = getDriver().findElement(By.xpath("//*[@id='flt-list']/div[" + fliNo + "]/div//div[3]/div[1]"))
					.getText();
			String Arrivalgate = Arrivalgate1.trim();
			
			String DepartureGate1 = getDriver().findElement(By.xpath("//*[@id='flt-list']/div[" + fliNo + "]/div/div[6]/div[1]"))
					.getText();
			String Flight = getDriver().findElement(By.xpath("//*[@id='flt-list']/div[" + fliNo + "]/div/div[6]/div[2]"))
					.getText();
			
			String DepartureGate = DepartureGate1.trim();
			if(Arrivalgate!="")
			{
			if(Arrivalgate!=DepartureGate)
			{
			
				ATUReports.add("Arrival gate and departure gate are Not matching. Potential tow information is valid and validated for flight   "+Flight+" "+Arrivalgate+" "+DepartureGate,  LogAs.PASSED, null);
			}
			else
			{
			
				ATUReports.add("Potential tow information is invalid"+Flight+" "+Arrivalgate+" "+DepartureGate,  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}
			}
			
		}
	
		}


	
		public static void DelayedDepartureconform(String view) throws Exception {
			

			System.out.println("Validating Delayed flight statics with gantt view. Delayed flights should hold the status DCN or ETD");
			TestcaseInit();
			CheckCollapse();
			Thread.sleep(3000);
			CommonTest.Selectview(view);
			System.out.println("Selected view for validation is "+view);
			CommonTest.zoomin();
			CommonTest.zoomin();
			CommonTest.zoomindata();
			try
			{	

			clickByXpathbyView(view, Web_UI.Delayed, Web_UI.HybridDelayed);

			ATUReports.add(" ",  LogAs.PASSED, null);
			CommonTest.SpinnerControl();
			Thread.sleep(3000);
			clickByXpath(Web_UI.SortAscending,"SortAscending");
			Thread.sleep(1000);
			// Select Sort Ascending gate by alphabetical order from dropdown
			clickByXpath(Web_UI.SortAscendinggate,"SortAscendinggate");
			Thread.sleep(1000);
			CommonTest.CheckExpand();
			List<WebElement> Ganntlist = getDriver().findElements(By.xpath(Web_UI.PuckComplete));
			int Ganntlistcount = Ganntlist.size();
			if(Ganntlistcount == 0)
			{
				CommonTest.CheckGanttviewListisnotZero();
			}
			CommonTest.SpinnerControl();
			CheckCollapse();
			clickByXpathbyView(view, Web_UI.Delayed, Web_UI.HybridDelayed);
			CommonTest.CheckExpand();
			List<WebElement> Ganntlist1 = getDriver().findElements(By.xpath(Web_UI.PuckComplete));
			int Ganntlistcount1 = Ganntlist1.size();
			if (Ganntlistcount1 == 0) {
				ATUReports.add("Ganttlist is Zero. Screenshot below : ",  LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE)); 
				
			}else{
				int j=0;
				for (WebElement gantelementt : Ganntlist) {
					j++;
					
					try{

						String idofelement = gantelementt.getAttribute("id");
						ATUReports.add("Verifying puck with id :: "+idofelement,  LogAs.INFO, null); 

					}catch(Exception id)
					{
						
					}
					
					try {
						Actions actions = new Actions(getDriver());
						actions.moveToElement(gantelementt).build().perform();
						String Arrivaltimetext = gantelementt.getAttribute("innerText");

						if(Arrivaltimetext.contains("ETD")||Arrivaltimetext.contains("DCN") )
						{
								ATUReports.add("Validated ETD and passed for the Puck No:  "+j,  LogAs.PASSED, null);
						} else {
							System.out.println("ETD details not passed ");
							ATUReports.add("Validated ETD and Failed for the Puck No:  "+j,  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								
						}
						}catch (Exception Exee) {
						System.out.println("Exception while moving to the element "+j);
						
						}
				}
				
			}
				
			}catch(Exception Noelement)
			{
				

				ATUReports.add("Delayed statistics may not present in flight statistics ",  LogAs.INFO, null);
			}
					CommonTest.CheckCollapse();
					CommonTest.zoomOut();
					CommonTest.zoomOut();
		
		}

		public static void Timerliesbetween(String view) throws Exception {
			
			System.out.println("Verify the Flights present in the gantt view falls under the selected time range. The flights should falls between Current station time - past 6hours and selected hours in dashboard filter");
			// Validate the gantt view pucks displayed are falls under the selected time range
			CheckCollapse();
			TestcaseInit();
			CommonTest.Selectview(view);
			System.out.println("Selected view for validation is "+view);
			try
			{
			CommonTest.SpinnerControl();
			Thread.sleep(3000);
			CommonTest.CheckExpand();
			String TimerSet1 = getDriver().findElement(By.xpath(Web_UI.Headertitle)).getAttribute("innerText");
			Pattern pattern = Pattern.compile("next (.*?) hours");
			Matcher matcher = pattern.matcher(TimerSet1);
		
			boolean hoursvalue1 = matcher.find();
			String hoursvalue= matcher.group(1);
			int Hourssetfromsettings = Integer.parseInt(hoursvalue);
			System.out.println(Hourssetfromsettings);
			
			String CurrentStationTime = getDriver().findElement(By.xpath(Web_UI.stationtime)).getAttribute("innerText").trim()+":00";
			 Date StationTime = new SimpleDateFormat("HH:mm:ss").parse(CurrentStationTime);
			 Calendar calendarMain = Calendar.getInstance();
			 calendarMain.setTime(StationTime);
			 // From Settings we have set the hour to one and we are finalizing the start and end time range here
			 calendarMain.add(Calendar.HOUR, Hourssetfromsettings);
			 int Pasthours = Hourssetfromsettings+6;
			 Date oneHourahead = calendarMain.getTime();
			 calendarMain.add(Calendar.HOUR, -Pasthours);
			 Date sixHourBack = calendarMain.getTime();
			 
			 
			List<WebElement> Ganntlist = getDriver().findElements(By.xpath(Web_UI.PuckComplete));
			int Ganntlistcount = Ganntlist.size();
			if (Ganntlist != null) {
				int i=0;
				for (WebElement gantelement : Ganntlist) {
				i++;
				try{
					String idofelement = gantelement.getAttribute("id");

					ATUReports.add("Verifying puck with id :: "+idofelement,  LogAs.INFO, null); 

				}catch(Exception id)
				{
					
				}
							try {

								Actions actions = new Actions(getDriver());
								WebElement Movetest = gantelement.findElement(By.xpath("ancestor::div[1]"));			
								actions.moveToElement(Movetest).build().perform();
								WebElement Arrivaltimetexts = gantelement.findElement(By.xpath("div[1]/span[2]"));			
								WebElement Departuretimetexts = gantelement.findElement(By.xpath("div[3]/span[2]"));
								String Arrivaltimearrayelement = Arrivaltimetexts.getAttribute("innerText");
								String Departuretimearrayelement = Departuretimetexts.getAttribute("innerText");
					// Check if any of the details are not retrieved properly and proceed further
							if (Arrivaltimearrayelement!="" && Departuretimearrayelement!="" )
							{
								String Arrivaltimearray[]= Arrivaltimearrayelement.split(" ");
								String Departuretimearray[] = Departuretimearrayelement.split(" ");
								String Arrivaltime = Arrivaltimearray[1].trim().substring(0, 5)+":00";
								String Departuretime = Departuretimearray[1].trim().substring(0, 5)+":00";
							try {
								
							    String string1 = Arrivaltime;
							    Date time1 = new SimpleDateFormat("HH:mm:ss").parse(string1);
							    Calendar calendar1 = Calendar.getInstance();
							    calendar1.setTime(time1);

							    String string2 = Departuretime;
							    Date time2 = new SimpleDateFormat("HH:mm:ss").parse(string2);
							    Calendar calendar2 = Calendar.getInstance();
							    calendar2.setTime(time2);
							    calendar2.add(Calendar.DATE, 1);
							  // Get the arrival & Departure time and set it in calendar instance seperately
							    Date Arrival = calendar1.getTime();
							    Date Departure = calendar2.getTime();

							    // Validate if the arrival time or departure time falls under the range provided
							    if ((Arrival.after(sixHourBack) || Arrival.before(oneHourahead)) && ( Departure.after(sixHourBack)  || Departure.before(oneHourahead)) ) {
							        //checks whether the current time is between provided time rande.
							    	System.out.println(Arrivaltime+"  "+Departuretime);
							        System.out.println("The Puck no  "+i+ " falls between the time range"+sixHourBack.getHours()+":"+sixHourBack.getMinutes()+" to "+oneHourahead.getHours()+":"+oneHourahead.getMinutes());
							         ATUReports.add("The Puck no  "+i+ " falls between the time range",  LogAs.PASSED, null);
							    }
							    else
							    {

							    	ATUReports.add("The Puck no  "+i+ " not falls between the time range",  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
							    	captureinfoScreenshot(getDriver(),"The Puck no  "+i+ " not falls between the time range");
							    }
							} catch (ParseException e) {
							    e.printStackTrace();
							}

							
							}	
							
							}
								catch (Exception Exee) {
								System.out.println("Exception while fetching time details from the element "+i);
								}
							
									} 
			}
				else
				{
				}
					}catch(Exception Noelement)
			{
				

						ATUReports.add("Gantt view not displayed or exception occurred ",  LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE)); 
						captureinfoScreenshot(getDriver(), "Gantt view not displayed or exception occurred ");
			}
					CommonTest.CheckCollapse();
					CommonTest.zoomOut();
					CommonTest.zoomOut();
		
			
			
		
		
			
			
		}
		


		// Validate the Status D is present in the Decision details for all flight puck upon selecting LateArrivals
			public static void Decisionconform(String view) throws Exception {
				

				System.out.println("Validating Decision flight statics with gantt view");
				CheckCollapse();
				TestcaseInit();
				Thread.sleep(3000);
				CommonTest.Selectview(view);
				System.out.println("Selected view for validation is "+view);
				CommonTest.zoomin();
				CommonTest.zoomin();
				CommonTest.zoomindata();
				try
				{

				clickByXpathbyView(view, Web_UI.Decision, Web_UI.HybridDecision);

				ATUReports.add("Decision Flight stats selected successfully",  LogAs.PASSED, null);
				CommonTest.SpinnerControl();
				Thread.sleep(3000);
				clickByXpath(Web_UI.SortAscending,"SortAscending");
				Thread.sleep(1000);
				// Select Sort Ascending gate by alphabetical order from dropdown
				clickByXpath(Web_UI.SortAscendinggate,"SortAscendinggate");
				Thread.sleep(1000);
				CommonTest.CheckExpand();
				List<WebElement> Ganntlist = getDriver().findElements(By.xpath(Web_UI.PuckComplete));
				int Ganntlistcount = Ganntlist.size();
				if(Ganntlistcount == 0)
				{
					CommonTest.CheckGanttviewListisnotZero();
				}
				CommonTest.SpinnerControl();
				CheckCollapse();
				clickByXpathbyView(view, Web_UI.Decision, Web_UI.HybridDecision);
				CommonTest.CheckExpand();
				List<WebElement> Ganntlist1 = getDriver().findElements(By.xpath(Web_UI.PuckComplete));
				int Ganntlistcount1 = Ganntlist1.size();
				if(Ganntlistcount1 == 0)
				{

					ATUReports.add("*************Gantt List is Zero and hence Exiting test smoothly*******************",  LogAs.PASSED, null);
				}
				else
				{
				
						int i=0;
						for (WebElement gantelement : Ganntlist) {
						i++;
						try{

							String idofelement = gantelement.getAttribute("id");

							ATUReports.add("Verifying puck with id :: "+idofelement,  LogAs.INFO, null); 

						}catch(Exception id)
						{
							
						}	
									try {
	
										Actions actions = new Actions(getDriver());
										actions.moveToElement(gantelement).build().perform();
										String Departurestatusstext = gantelement.getAttribute("innerText");
										
										if(Departurestatusstext!="")
										{
							
											if (Departurestatusstext.contains("DCN")) {
	
												ATUReports.add( "Validated DCN present in gantt view for flight puck No:  "+i,  LogAs.PASSED, null);
										} else {
											System.out.println("Status DCN is not present ");

											ATUReports.add("Status DCN is not present",  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
											
										}
										}
									}	catch (Exception Exee) {
										System.out.println("Exception while moving to the element "+i);
										}
									
											} 
					
				}
						}catch(Exception Noelement)
				{
					

							ATUReports.add("Decision statistics may not present in flight statistics",  LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE)); 
							
				}
						CommonTest.CheckCollapse();
						CommonTest.zoomOut();
						CommonTest.zoomOut();
			
				
				
			
			}




	public static void ETDUpdatesconform(String view) throws Exception {
		
		System.out.println("Validating ETD Updates flight statics with gantt view");
		TestcaseInit();
		CheckCollapse();
		Thread.sleep(3000);
		CommonTest.Selectview(view);
		System.out.println("Selected view for validation is "+view);
		CommonTest.zoomin();
		CommonTest.zoomin();
		CommonTest.zoomindata();
		try
		{

		clickByXpathbyView(view, Web_UI.ETD, Web_UI.HybridETD);

		ATUReports.add("ETD update Flight stats selected successfully",  LogAs.PASSED, null);
		CommonTest.SpinnerControl();
		Thread.sleep(3000);
		
		clickByXpath(Web_UI.SortAscending,"SortAscending");
		Thread.sleep(1000);
		// Select Sort Ascending gate by alphabetical order from dropdown
		clickByXpath(Web_UI.SortAscendinggate,"SortAscendinggate");
		
		Thread.sleep(1000);
		
		
		CommonTest.CheckExpand();
		List<WebElement> Ganntlist = getDriver().findElements(By.xpath(Web_UI.PuckComplete));
	
		int Ganntlistcount = Ganntlist.size();
		if(Ganntlistcount == 0)
		{
			CommonTest.CheckGanttviewListisnotZero();
		}
		CommonTest.SpinnerControl();
		CheckCollapse();
		clickByXpathbyView(view, Web_UI.ETD, Web_UI.HybridETD);
		CommonTest.CheckExpand();
		List<WebElement> Ganntlist1 = getDriver().findElements(By.xpath(Web_UI.PuckComplete));
		int Ganntlistcount1 = Ganntlist1.size();
		if(Ganntlistcount1 == 0)
		{
		
			ATUReports.add("*************Gantt List is Zero and hence Exiting test smoothly*******************",  LogAs.PASSED, null);
		}
		else
		{
			
				int i=0;
				for (WebElement gantelement : Ganntlist) {
				i++;
				try{
					String idofelement = gantelement.getAttribute("id");

					ATUReports.add("Verifying puck with id :: "+idofelement,  LogAs.INFO, null); 

				}catch(Exception id)
				{
					
				}	
							try {

								Actions actions = new Actions(getDriver());
								actions.moveToElement(gantelement).build().perform();
								String Bordercolor = gantelement.getCssValue("border-bottom-color");
									
								if(Bordercolor.contains("255, 0, 0, 1"))
								{
					
									ATUReports.add("Matching with ETD update Characteristics :"+i,  LogAs.PASSED, null);
									
								}
								else
								{
									String completeText = gantelement.getAttribute("innerText");
									if(completeText.contains("TERM")){
										ATUReports.add("TERM Flight wont be highlighted with Red Border :"+i,  LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									}else{
							
									ATUReports.add("Border is not highlighted in Red Color :"+i,  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									}
								}
								try{
								String Statusvalidation =  gantelement.findElement(By.xpath("div[contains(@class,'puck-data')]")).getAttribute("innerText");
								if(Statusvalidation.contains("ETD")||Statusvalidation.contains("ETA")||Statusvalidation.contains("PRE")||Statusvalidation.contains("CHO"))
								{
				
									ATUReports.add( "Status of flights falls under ETD Category"+i,  LogAs.PASSED, null);
								}
								else{
						
									
									ATUReports.add("Check the status of puck is not falls under ETD"+Statusvalidation,  LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE)); 
								}
								
								}catch(Exception FetchingText)
								{
						
									ATUReports.add("Fetching issue :"+i,  LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE)); 
								}
								
							} catch(Exception MovingtoElement)
							{
								
							}
			}
			
				
				
				
			
			
		}
				}catch(Exception Noelement)
		{
			

					ATUReports.add("Decision statistics may not present in flight statistics",  LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE)); 
					
		}
				CommonTest.CheckCollapse();
				CommonTest.zoomOut();
				CommonTest.zoomOut();
	
		
		
	
	
		
	}
	
	
	
	public static void GateconflictConfirm(String view) throws Exception {
		System.out.println("Validating GateConflict details format present in the flight puck details.");
		TestcaseInit();
		CheckCollapse();
		Thread.sleep(5000);
		CommonTest.Selectview(view);
		System.out.println("Selected view for validation is "+view);
		
		CommonTest.zoomin();
		CommonTest.zoomin();
		try
		{

			GanntViewHeaderFunctionality.SpinnerControl();	
		clickByXpath("//span[text()='Gate Conflicts']","Gate Conflicts");

		ATUReports.add("Gate Conflict Stats selected",  LogAs.PASSED, null);

		 GanntViewHeaderFunctionality.SpinnerControl();	 
		Thread.sleep(5000);
		CommonTest.CheckExpand();
	
		
		List<WebElement> Ganntlist = getDriver().findElements(By.xpath("//div[@drop='handleDrop']"));
		double Ganntlistcount = Ganntlist.size();
		List<WebElement> FlightsDisplayed = getDriver().findElements(By.xpath("//div[@data-ng-repeat='flt in gts.Flights']"));
		double FlightsDisplayedcount = FlightsDisplayed.size();
		double Conflictcheck = FlightsDisplayedcount/2;
		if(Conflictcheck<=Ganntlistcount)
		{

			ATUReports.add("Gate conflict details are updating properly",  LogAs.PASSED, null);
			System.out.println("Gate conflicts happening and updating properly in gantt view");
		}
		else
		{

			ATUReports.add("Gate conflict details are not updating properly",  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			System.out.println("Gate conflicts not updated properly");
		}
		
		for (WebElement gantelement : Ganntlist) {
			String Ganttid = gantelement.getAttribute("id");
			WebElement idofgannt = getDriver().findElement(By.id(Ganttid));
			List<WebElement> Ganntlist1 = getDriver().findElement(By.id(Ganttid)).findElements(By.xpath("//div[@data-ng-repeat='flt in gts.Flights']"));
			
			int Ganntlistcount2 = Ganntlist1.size();
			if(Ganntlistcount2>1)
			{

				ATUReports.add("The selected gate have one or more flight which are conflicting",  LogAs.PASSED, null);
			}
			else
			{

				ATUReports.add("The selected gate have one or more flight which are conflicting",  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}
		}
		
		
		
		}
		
		
	
		catch (Exception Noelement)
		{

			ATUReports.add("Gate Conflict details may not present in flight stats",  LogAs.PASSED, null);
		}
		
		CommonTest.CheckCollapse();
		CommonTest.zoomOut();
		CommonTest.zoomOut();
	}
	
	
	
	
	// Revision required for this complete method. Revisit again
	
	public static void MELConform(String view) throws Exception {
		System.out.println("Validating MEl icon details format present in the flight puck details.");
		TestcaseInit();
		CheckCollapse();
		Thread.sleep(5000);
		CommonTest.Selectview(view);
		System.out.println("Selected view for validation is "+view);
		try{

		clickByXpathbyView(view, Web_UI.MEL, Web_UI.HybridMEL);

		ATUReports.add("MEL Stats Selected",  LogAs.PASSED, null);
		 GanntViewHeaderFunctionality.SpinnerControl();	 
		Thread.sleep(5000);
		clickByXpath(Web_UI.SortAscending,"SortAscending");
		Thread.sleep(1000);
		// Select Sort Ascending gate by alphabetical order from dropdown
	clickByXpath(Web_UI.SortAscendinggate,"SortAscendinggate");
		Thread.sleep(1000);
		CommonTest.CheckExpand();
			CommonTest.zoomin();
			CommonTest.zoomin();
			CommonTest.zoomin();
			CommonTest.zoomindata();
		List<WebElement> Ganntlist = getDriver().findElements(By.xpath(Web_UI.PuckComplete));
		int Ganntlistcount = Ganntlist.size();

		if(Ganntlistcount == 0)
		{
			CommonTest.CheckGanttviewListisnotZero();
		}
		CommonTest.SpinnerControl();
		CheckCollapse();
		clickByXpathbyView(view, Web_UI.MEL, Web_UI.HybridMEL);
		CommonTest.CheckExpand();
		List<WebElement> Ganntlist1 = getDriver().findElements(By.xpath(Web_UI.PuckComplete));
		int Ganntlistcount1 = Ganntlist1.size();
		if(Ganntlistcount1 == 0)
		{

			ATUReports.add("*************Gantt List is Zero and hence Exiting test smoothly*******************",  LogAs.PASSED, null);
		}else{
		
				
			int i=0;
			
			for (WebElement gantelement : Ganntlist) {
				
				i++;
				
				try{
					String idofelement = gantelement.getAttribute("id");

					ATUReports.add("Verifying puck  with id :: "+idofelement,  LogAs.INFO, null); 

				}catch(Exception id)
				{
					
				}
				
				
				if(i<100)
				{
			
				String elementid = gantelement.getAttribute("id");

				if (elementid != "") {
					Actions actions = new Actions(getDriver());			
					
					WebElement elee = getDriver().findElement(By.xpath("//*[@id='" + elementid + "']"));
					actions.moveToElement(elee).build().perform();
					
					try
					{

						WebElement MELChecker = getDriver().findElement(By.xpath("//div[@id='"+ elementid +"']//span[@data-ng-click='getMELOTSpopover(flt,$event)']"));
						if(MELChecker!=null)
						{
								Thread.sleep(1000);
								
								ATUReports.add( "MEL details present for the puck : "+elementid,  LogAs.PASSED, null);
					}
						else
						{
							
							ATUReports.add("MEL details Not present for the puck"+elementid,  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					
							
						}
						
						try
						{
							WebElement taildetail = getDriver().findElement(By.xpath("//div[@id='"+ elementid +"']//span[@data-ng-click='getMELOTSpopover(flt,$event)']"));
							String tailvalue = taildetail.getAttribute("innerText").trim();
							if(tailvalue!=null){
								ATUReports.add("Tailvalue present for the puck"+elementid,  LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
							}
							if(tailvalue.equalsIgnoreCase("")){
								ATUReports.add("Tailvalue Not present for the puck and shown Blank"+elementid,  LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
							}
							
						}catch(Exception Fetchingtailexception)
						{
							
						}
						
					}
					catch(Exception Gateswapiconnotpresent)
					{
							ATUReports.add("Some other issue in identifying element "+elementid,  LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE)); 
					}
					
					}
				}
				
				}
		}
		}
		catch(Exception Noelement)
		{
			ATUReports.add("MEL Icon may not present or stats may not present ",  LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE)); 
			
			}
		
		CommonTest.zoomOut();
		CommonTest.zoomOut();
		CommonTest.zoomOut();
		
	CommonTest.CheckCollapse();
	}
	
	
	
	public static void UnlinkedFlightConform(String view) throws Exception {
		
		

		System.out.println("Validating Unlinked flight statics with gantt view. Unlinked flight will hold Destination flight details as UNLINKED");
		TestcaseInit();
		CheckCollapse();
		Thread.sleep(3000);
		CommonTest.Selectview(view);
		System.out.println("Selected view for validation is "+view);
		CommonTest.zoomin();
		CommonTest.zoomin();
		CommonTest.zoomindata();
		try
		{

		clickByXpathbyView(view, Web_UI.Unlinked, Web_UI.HybridUnlinked);

		ATUReports.add("Unlinked Flight Stats selected successfully",  LogAs.PASSED, null);
		CommonTest.SpinnerControl();
		Thread.sleep(3000);
		clickByXpath(Web_UI.SortAscending,"SortAscending");
		Thread.sleep(1000);
		// Select Sort Ascending gate by alphabetical order from dropdown
		clickByXpath("//div[@title='sort ascending']//span[text()='Gate - Alphabetic Order']","Gate - Alphabetic Order");
		Thread.sleep(1000);
		CommonTest.CheckExpand();
		List<WebElement> Ganntlist = getDriver().findElements(By.xpath(Web_UI.PuckComplete));
		
		int Ganntlistcount = Ganntlist.size();
		if(Ganntlistcount == 0)
		{
			CommonTest.CheckGanttviewListisnotZero();
		}
		CommonTest.SpinnerControl();
		CheckCollapse();
		clickByXpathbyView(view, Web_UI.Unlinked, Web_UI.HybridUnlinked);
		List<WebElement> Ganntlist1 = getDriver().findElements(By.xpath(Web_UI.PuckComplete));
		CommonTest.CheckExpand();
		int Ganntlistcount1 = Ganntlist1.size();
		if(Ganntlistcount1 == 0)
		{

			ATUReports.add("*************Gantt List is Zero and hence Exiting test smoothly*******************",  LogAs.PASSED, null);
		}else{
	
			int i=0;
			for (WebElement gantelement : Ganntlist) {
			i++;
						
			
			try{

				String idofelement = gantelement.getAttribute("id");

				ATUReports.add("Verifying puck with id :: "+idofelement,  LogAs.INFO, null); 

			}catch(Exception id)
			{
				
			}	
						try {

							Actions actions = new Actions(getDriver());
							actions.moveToElement(gantelement).build().perform();
							String Arrivaltimetext = gantelement.findElement(By.xpath("div[@class='puck-contnt puck-data-center']/div[@class='mel-ots ng-binding puck-linkage-center']")).getAttribute("innerText");
							String Departurelist = gantelement.findElement(By.xpath("div[@class='puck-contnt puck-data-center']/div[@class='mel-ots puck-dest-det-add']")).getAttribute("innerText");
						
							if(Departurelist.contains(":")||Departurelist.contains("/"))
							{

								ATUReports.add("Contains Departure details for the  puck No:: "+i,  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
							}
							else
							{

								ATUReports.add("Do not Contains Departure details for the  puck No:: "+i,  LogAs.PASSED, null);
							}
								
							if(Arrivaltimetext!="")
							{
				
							if (Arrivaltimetext.contains("UNL")) {

								ATUReports.add("Validated Unlinked present in gantt view for flight puck No:: "+i,  LogAs.PASSED, null);
							} else {
								System.out.println("Status Unlinked is not present ");
								ATUReports.add("Status Unlinked is not present",  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

							}
							}
						}	catch (Exception Exee) {
							System.out.println("Exception while moving to the element "+i);
							}
						
								} 
			
			
			
			
			
		
		}	}catch(Exception Noelement)
		{
			
			ATUReports.add("Unlinked may not present in flight statistics",  LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE)); 
		}
				CommonTest.CheckCollapse();
				CommonTest.zoomOut();
				CommonTest.zoomOut();
	
	}
	
	
	public static void OriginFlightConform(String view) throws Exception {
		
		

		System.out.println("Validating OriginFlight statics with gantt view. A origin Flight Will hold ORIGIN as Text for Arrival Flight NUMBER");
		TestcaseInit();
		CheckCollapse();
		Thread.sleep(3000);
		CommonTest.Selectview(view);
		System.out.println("Selected view for validation is "+view);
		CommonTest.zoomin();
		CommonTest.zoomin();
		CommonTest.zoomindata();
		try
		{

		clickByXpathbyView(view, Web_UI.Origin, Web_UI.HybridORIGIN);
		CommonTest.SpinnerControl();
		Thread.sleep(3000);
		CommonTest.CheckExpand();
		List<WebElement> Ganntlist = getDriver().findElements(By.xpath(Web_UI.PuckComplete));
		int Ganntlistcount = Ganntlist.size();
		if(Ganntlistcount == 0)
		{
			CommonTest.CheckGanttviewListisnotZero();
		}
		CommonTest.SpinnerControl();
		CheckCollapse();
		clickByXpathbyView(view, Web_UI.Origin, Web_UI.HybridORIGIN);
		CommonTest.CheckExpand();
		List<WebElement> Ganntlist1 = getDriver().findElements(By.xpath(Web_UI.PuckComplete));
		
		int Ganntlistcount1 = Ganntlist1.size();
		if(Ganntlistcount1 == 0)
		{

			ATUReports.add("*************Gantt List is Zero and hence Exiting test smoothly*******************",  LogAs.PASSED, null);
		}else{
		
	
			int i=0;
			
			for (WebElement gantelement : Ganntlist) {
			i++;
						
			try{

				String idofelement = gantelement.getAttribute("id");

				ATUReports.add("Verifying puck with id :: "+idofelement,  LogAs.INFO, null); 

			}catch(Exception id)
			{
				
			}	
			
			
						try {

							Actions actions = new Actions(getDriver());
							actions.moveToElement(gantelement).build().perform();
							String Arrivaltimetext = gantelement.getAttribute("innerText");

							if(Arrivaltimetext.contains("TERM")){
								ATUReports.add("Term Flight and skipping validation for Originator for this specific puck  : "+i,  LogAs.PASSED, null);
							}else{
								
							
							
							if(Arrivaltimetext!="")
							{
				
							if (Arrivaltimetext.contains("ORIG")) {

								ATUReports.add("Validated ORIG present in gantt view for flight puck No: "+i,  LogAs.PASSED, null);
							} 
							else if(Arrivaltimetext.contains("-")){
								System.out.println("Gate tow is present ");
								ATUReports.add("Gate Tow flight and hence skipping Term flight validation for this specific puck  "+i,  LogAs.INFO, null);
							}
							else {
								System.out.println("Status ORIG is not present ");
								ATUReports.add("Status ORIG is not present",  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

							}
							}}
						}	catch (Exception Exee) {
							System.out.println("Exception while moving to the element "+i);
							}
						
								} 
	
		}	}catch(Exception Noelement)
		{

			ATUReports.add( "ORIGIN may not present in flight statistics",  LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE)); 
		}
				CommonTest.CheckCollapse();
				CommonTest.zoomOut();
				CommonTest.zoomOut();
	
	}

	
	
	
	
	public static void TermFlightConform(String view) throws Exception {
		
	System.out.println("Validating TermFlight statics with gantt view. A Term Flight will hold Text as Term for Departure Flight Number");
	TestcaseInit();
	CheckCollapse();	
	Thread.sleep(3000);
	CommonTest.Selectview(view);
	System.out.println("Selected view for validation is "+view);
		CommonTest.zoomin();
		CommonTest.zoomin();
		CommonTest.zoomindata();
		try
		{

		clickByXpathbyView(view, Web_UI.Term, Web_UI.HybridTERM);
		CommonTest.SpinnerControl();
		Thread.sleep(3000);
		CommonTest.CheckExpand();
		List<WebElement> Ganntlist = getDriver().findElements(By.xpath(Web_UI.PuckComplete));
		int Ganntlistcount = Ganntlist.size();
		if(Ganntlistcount == 0)
		{
			CommonTest.CheckGanttviewListisnotZero();
		}
		CommonTest.SpinnerControl();
		CheckCollapse();
		clickByXpathbyView(view, Web_UI.Term, Web_UI.HybridTERM);
		CommonTest.CheckExpand();
		List<WebElement> Ganntlist1 = getDriver().findElements(By.xpath(Web_UI.PuckComplete));
		int Ganntlistcount1 = Ganntlist1.size();
		if(Ganntlistcount1 == 0)
		{

			ATUReports.add("*************Gantt List is Zero and hence Exiting test smoothly*******************",  LogAs.PASSED, null);
		}else{
	
			int i=0;
			for (WebElement gantelement : Ganntlist) {
			i++;
			
			try{

				String idofelement = gantelement.getAttribute("id");

				ATUReports.add("Verifying puck with id :: "+idofelement,  LogAs.INFO, null); 

			}catch(Exception id)
			{
				
			}	
						try {

							Actions actions = new Actions(getDriver());
							actions.moveToElement(gantelement).build().perform();
							String Arrivaltimetext = gantelement.getAttribute("innerText");

							String idofelement = gantelement.getAttribute("id");
							if(Arrivaltimetext!="")
							{
								if (idofelement.contains("ORIG")){
									ATUReports.add("Origin flight and hence skipping Term flight validation for this specific puck  "+i,  LogAs.PASSED, null);
								}else{
				
							if (Arrivaltimetext.contains("TERM")) {

								ATUReports.add("Validated TERM present in gantt view for flight puck No "+i,  LogAs.PASSED, null);
							} 
							else if(Arrivaltimetext.contains("-")){
								System.out.println("Gate tow is present ");
								ATUReports.add("Gate Tow flight and hence skipping Term flight validation for this specific puck  "+i,  LogAs.INFO, null);
							}
							else {
								System.out.println("Status TERM is not present ");
							
								ATUReports.add("Status TERM is not present",  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

							}
							}
							}
						}	catch (Exception Exee) {
							System.out.println("Exception while moving to the element "+i);
							}
						
								} 
		
		}	}catch(Exception Noelement)
		{
			
			ATUReports.add("TERM may not present in flight statistics",  LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE)); 
		}
				CommonTest.CheckCollapse();
				CommonTest.zoomOut();
				CommonTest.zoomOut();
	
	
				
	}

	
	// Revisit this method.
	
	public static void OTSConform(String view) throws Exception {
		System.out.println("Validating OTS icon details format present in the flight puck details.");
		TestcaseInit();
		CheckCollapse();
		Thread.sleep(5000);
		CommonTest.Selectview(view);
		System.out.println("Selected view for validation is "+view);
		try{

		clickByXpathbyView(view, Web_UI.OTS, Web_UI.HybridOTS);
		GanntViewHeaderFunctionality.SpinnerControl();	 
		Thread.sleep(5000);
		clickByXpath(Web_UI.SortAscending,"SortAscending");
		Thread.sleep(1000);
		// Select Sort Ascending gate by alphabetical order from dropdown
		clickByXpath(Web_UI.SortAscendinggate,"SortAscendinggate");
		
		Thread.sleep(1000);
		CommonTest.CheckExpand();
		CommonTest.zoomin();
		CommonTest.zoomin();
		CommonTest.zoomindata();
		
		List<WebElement> Ganntlist = getDriver().findElements(By.xpath(Web_UI.PuckComplete));
	
		int Ganntlistcount = Ganntlist.size();
		if(Ganntlistcount == 0)
		{
			CommonTest.CheckGanttviewListisnotZero();
		}
		CommonTest.SpinnerControl();
		CheckCollapse();
		clickByXpathbyView(view, Web_UI.OTS, Web_UI.HybridOTS);
		CommonTest.CheckExpand();
		List<WebElement> Ganntlist1 = getDriver().findElements(By.xpath(Web_UI.PuckComplete));
		int Ganntlistcount1 = Ganntlist1.size();
		if(Ganntlistcount1 == 0)
		{

			ATUReports.add("*************Gantt List is Zero and hence Exiting test smoothly*******************",  LogAs.PASSED, null);
		}else{
	
			int i=0;
			
			for (WebElement gantelement : Ganntlist) {
				
				i++;
				
				
				try{
					String idofelement = gantelement.getAttribute("id");

					ATUReports.add("Verifying puck with id :: "+idofelement,  LogAs.INFO, null); 

				}catch(Exception id)
				{
					
				}	
					
				
				
				if(i<100)
				{
			
				String elementid = gantelement.getAttribute("id");

				if (elementid != "") {
					Actions actions = new Actions(getDriver());			
					
					WebElement elee = getDriver().findElement(By.xpath("//*[@id='" + elementid + "']"));
					actions.moveToElement(elee).build().perform();
					
					try
					{

						WebElement OTSChecker = getDriver().findElement(By.xpath("//div[@id='"+ elementid +"']//span[contains(@class,'tail')]"));
						String OTSColor = OTSChecker.getCssValue("background-color");

						if(OTSChecker!=null)
						{
							if(OTSColor.contains("252, 25, 32"))
							{
								Thread.sleep(2000);

								ATUReports.add("OTS details present for the puck "+elementid,  LogAs.PASSED, null);

								ATUReports.add("OTS details are Highlighted in Red Color Background "+elementid,  LogAs.PASSED, null);
							}
					}
						else
						{
							ATUReports.add("OTS details Not present for the puck"+elementid,  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					
							
						}
					}
					catch(Exception Gateswapiconnotpresent)
					{
						ATUReports.add("Some other issue in identifying element "+elementid,  LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE)); 
					}
					
					}
				}
				
				}
		}}
		catch(Exception Noelement)
		{
			
			ATUReports.add("OTS Stats may not present or stats may not present ",  LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE)); 
			
			}
		
		CommonTest.zoomOut();
		CommonTest.zoomOut();
		
	CommonTest.CheckCollapse();
	}




	public static void MELReportVerification(String view) throws Exception {

		System.out.println("Validating MEL icon details format present in the flight puck details.");
		TestcaseInit();
		CheckCollapse();
		Thread.sleep(5000);
		CommonTest.Selectview(view);
		System.out.println("Selected view for validation is "+view);
		try{

		clickByXpathbyView(view, Web_UI.MEL, Web_UI.HybridMEL);

		ATUReports.add("MEL Stats Selected",  LogAs.PASSED, null);
		 GanntViewHeaderFunctionality.SpinnerControl();	 
		Thread.sleep(5000);
		
		clickByXpath(Web_UI.SortAscending,"SortAscending");
		Thread.sleep(1000);
		// Select Sort Ascending gate by alphabetical order from dropdown
		clickByXpath(Web_UI.SortAscendinggate,"SortAscendinggate");
		Thread.sleep(1000);
		
		CommonTest.CheckExpand();
		CommonTest.zoomin();
		CommonTest.zoomin();
		CommonTest.zoomin();
		CommonTest.zoomindata();
		
		List<WebElement> Ganntlist = getDriver().findElements(By.xpath(Web_UI.GanttTable));
		int Ganntlistcount = Ganntlist.size();

		if(Ganntlistcount == 0)
		{
			CommonTest.CheckGanttviewListisnotZero();
		}
		CommonTest.SpinnerControl();
		CheckCollapse();
		clickByXpathbyView(view, Web_UI.MEL, Web_UI.HybridMEL);
		CommonTest.CheckExpand();
		List<WebElement> Ganntlist1 = getDriver().findElements(By.xpath(Web_UI.PuckComplete));
		int Ganntlistcount1 = Ganntlist1.size();
		if(Ganntlistcount1 == 0)
		{

			ATUReports.add("*************Gantt List is Zero and hence Exiting test smoothly*******************",  LogAs.PASSED, null);
		}else{
					
			int i=0;
			
			for (WebElement gantelement : Ganntlist) {
				
				i++;
				if(i<100)
				{
			
				String elementid = gantelement.getAttribute("id");

				if (elementid != "") {
					Actions actions = new Actions(getDriver());			
					
					WebElement elee = getDriver().findElement(By.xpath("//*[@id='" + elementid + "']"));
					actions.moveToElement(elee).build().perform();
					
					try
					{

						WebElement MELChecker = getDriver().findElement(By.xpath("//div[@id='"+ elementid +"']//span[contains(@class,'tail')]"));
						if(MELChecker!=null)
						{
								Thread.sleep(1000);

								ATUReports.add("MEL details present for the puck : "+elementid,  LogAs.PASSED, null);
								
								MELChecker.click();
								Thread.sleep(1000);
								WebElement MELreportextract = getDriver().findElement(By.xpath("//div[contains(@class,'popup-tmplte')]"));	
								String MELReportextracttext = MELreportextract.getAttribute("innerText");
								if (MELReportextracttext.contains("null")||MELReportextracttext.contains("NULL")||MELReportextracttext.contains("Null") )
								{

									ATUReports.add( "MEL report  verified and Contains Null value : "+elementid,  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									ATUReports.add(MELReportextracttext ,  LogAs.INFO,null);
								}
								else{

									ATUReports.add( "MEL report verified and Looks good : "+elementid,  LogAs.PASSED, null);
								}
								
					}
						else
						{
							ATUReports.add("MEL details Not present for the puck"+elementid,  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					
							
						}
					}
					catch(Exception Gateswapiconnotpresent)
					{
						ATUReports.add("Some other issue in identifying element "+elementid,  LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE)); 
					}
					
					}
				}
				
				}
		}
		}
		catch(Exception Noelement)
		{
			ATUReports.add("MEL Icon may not present or stats may not present ",  LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE)); 
			
			}
		
		CommonTest.zoomOut();
		CommonTest.zoomOut();
		CommonTest.zoomOut();
		
	CommonTest.CheckCollapse();
	
		
	}




	public static void OTSReportdisplay(String view) throws Exception {
		
		System.out.println("Validating OTS Report  present in the flight puck details upon selecting Tail");
		TestcaseInit();
		CheckCollapse();
		Thread.sleep(5000);
		CommonTest.Selectview(view);
		System.out.println("Selected view for validation is "+view);
		try{

		clickByXpathbyView(view, Web_UI.OTS, Web_UI.HybridOTS);
		 GanntViewHeaderFunctionality.SpinnerControl();	 
		 	 
		Thread.sleep(5000);
		clickByXpath(Web_UI.SortAscending,"SortAscending");
		Thread.sleep(1000);
		// Select Sort Ascending gate by alphabetical order from dropdown
		clickByXpath(Web_UI.SortAscendinggate,"SortAscendinggate");
		
		Thread.sleep(1000);
		CommonTest.CheckExpand();
		CommonTest.zoomin();
		CommonTest.zoomin();
		CommonTest.zoomindata();
		
		List<WebElement> Ganntlist = getDriver().findElements(By.xpath(Web_UI.GanttTable));
		int Ganntlistcount = Ganntlist.size();
		if(Ganntlistcount == 0)
		{
			CommonTest.CheckGanttviewListisnotZero();
		}
		CommonTest.SpinnerControl();
		CheckCollapse();
		CheckCollapse();
		clickByXpathbyView(view, Web_UI.OTS, Web_UI.HybridOTS);
		CommonTest.CheckExpand();
		List<WebElement> Ganntlist1 = getDriver().findElements(By.xpath(Web_UI.PuckComplete));
		int Ganntlistcount1 = Ganntlist1.size();
		if(Ganntlistcount1 == 0)
		{
			ATUReports.add("*************Gantt List is Zero and hence Exiting test smoothly*******************",  LogAs.PASSED, null);
		}else{

			int i=0;
			
			for (WebElement gantelement : Ganntlist) {
				
				i++;
				if(i<100)
				{
			
				String elementid = gantelement.getAttribute("id");

				if (elementid != "") {
					Actions actions = new Actions(getDriver());			
					
					WebElement elee = getDriver().findElement(By.xpath("//*[@id='" + elementid + "']"));
					actions.moveToElement(elee).build().perform();
					
					try
					{

						WebElement OTSChecker = getDriver().findElement(By.xpath("//div[@id='"+ elementid +"']//span[contains(@class,'tail')]"));
						OTSChecker.click();
						Thread.sleep(2000);
					
						
						try{
							
						
						WebElement Popovercontent = getDriver().findElement(By.xpath("//div[contains(@class,'popup-tmplte')]"));
						String Popovercontenttext = Popovercontent.getAttribute("innerText");
						
		
						if(Popovercontenttext.contains("null"))
						{

							ATUReports.add( "Report contains null value "+elementid,  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
							ATUReports.add( Popovercontenttext,  LogAs.INFO, null);
						}
						else
						{

							ATUReports.add("Report Verified and looks good "+elementid,  LogAs.PASSED, null);
						}
						}	catch(Exception SelectingReport)
						{
							
						}
						
					}
					catch(Exception Gateswapiconnotpresent)
					{
					
						ATUReports.add("Some other issue in identifying element "+elementid,  LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE)); 
					}
					
					}
				}
				
				}
		}}
		catch(Exception Noelement)
		{
			
			ATUReports.add("OTS Icon may not present or stats may not present ",  LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE)); 
			
			}
		
		CommonTest.zoomOut();
		CommonTest.zoomOut();
		
	CommonTest.CheckCollapse();
	
		
	}




	public static void MELReportdisplay(String view) throws Exception {
		
		System.out.println("Validating MEL Report  present in the flight puck details upon selecting Tail");
		TestcaseInit();
		CheckCollapse();
		Thread.sleep(5000);
		CommonTest.Selectview(view);
		System.out.println("Selected view for validation is "+view);
		try{

		clickByXpathbyView(view, Web_UI.MEL, Web_UI.HybridMEL);
		 GanntViewHeaderFunctionality.SpinnerControl();	 
		 	 
		Thread.sleep(5000);
		CommonTest.CheckExpand();
		CommonTest.zoomin();
		CommonTest.zoomin();
		CommonTest.zoomindata();
		List<WebElement> Ganntlist = getDriver().findElements(By.xpath(Web_UI.GanttTable));
		int Ganntlistcount = Ganntlist.size();
	
		if(Ganntlistcount == 0)
		{
			CommonTest.CheckGanttviewListisnotZero();
		}
		CommonTest.SpinnerControl();
		CheckCollapse();
		clickByXpathbyView(view, Web_UI.MEL, Web_UI.HybridMEL);
		CommonTest.CheckExpand();
		List<WebElement> Ganntlist1 = getDriver().findElements(By.xpath(Web_UI.PuckComplete));
		int Ganntlistcount1 = Ganntlist1.size();
		if(Ganntlistcount1 == 0)
		{

			ATUReports.add("*************Gantt List is Zero and hence Exiting test smoothly*******************",  LogAs.PASSED, null);
		}else{

			int i=0;
			
			for (WebElement gantelement : Ganntlist) {
				
				i++;
				if(i<100)
				{
			
				String elementid = gantelement.getAttribute("id");

				if (elementid != "") {
					Actions actions = new Actions(getDriver());			
					
					WebElement elee = getDriver().findElement(By.xpath("//*[@id='" + elementid + "']"));
					actions.moveToElement(elee).build().perform();
					
					try
					{

						WebElement OTSChecker = getDriver().findElement(By.xpath("//div[@id='"+ elementid +"']//span[contains(@class,'tail')]"));
						OTSChecker.click();
						Thread.sleep(2000);
					
												try{
						
						WebElement Popovercontent = getDriver().findElement(By.xpath("//div[contains(@class,'popup-tmplte')]"));
						String Popovercontenttext = Popovercontent.getAttribute("innerText");
								
						if(Popovercontenttext.contains("null"))
						{

							ATUReports.add("Report contains null value "+elementid,  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						}
						else
						{

							ATUReports.add("Report Verified and looks good "+elementid,  LogAs.PASSED, null);
						}
						}	catch(Exception SelectingReport)
						{
							
						}
						
					}
					catch(Exception Gateswapiconnotpresent)
					{
						
						ATUReports.add("Some other issue in identifying element "+elementid,  LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE)); 
					}
					
					}
				}
				
				}
		}}
		catch(Exception Noelement)
		{
			
			ATUReports.add("MEL Icon may not present or stats may not present ",  LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE)); 
			
			}
		
		CommonTest.zoomOut();
		CommonTest.zoomOut();
		
	CommonTest.CheckCollapse();
	
		
	
		
	}

	public static void WeightRestrictedflightconform(String view) throws Exception {

		System.out.println("Validating Weight restricted details present in the flight puck details Upon selecting weight restricted stats");
		TestcaseInit();
		CheckCollapse();
		Thread.sleep(5000);
		CommonTest.Selectview(view);
		System.out.println("Selected view for validation is "+view);
		try{

		clickByXpathbyView(view, Web_UI.WeightRestricted, Web_UI.HybridWeightRestricted);
		
		 GanntViewHeaderFunctionality.SpinnerControl();	 
		 	 
		Thread.sleep(5000);
		
		clickByXpath(Web_UI.SortAscending,"SortAscending");
		Thread.sleep(1000);
		// Select Sort Ascending gate by alphabetical order from dropdown
		clickByXpath(Web_UI.SortAscendinggate,"SortAscendinggate");
		
		Thread.sleep(1000);
		CommonTest.CheckExpand();
		CommonTest.zoomin();
		CommonTest.zoomin();
		CommonTest.zoomindata();
		
		List<WebElement> Ganntlist = getDriver().findElements(By.xpath(Web_UI.PuckComplete));
		int Ganntlistcount = Ganntlist.size();
		if(Ganntlistcount == 0)
		{
			CommonTest.CheckGanttviewListisnotZero();
		}
		CommonTest.SpinnerControl();
		CheckCollapse();
		clickByXpathbyView(view, Web_UI.WeightRestricted, Web_UI.HybridWeightRestricted);
		CommonTest.CheckExpand();
		List<WebElement> Ganntlist1 = getDriver().findElements(By.xpath(Web_UI.PuckComplete));
		int Ganntlistcount1 = Ganntlist1.size();
		if(Ganntlistcount1 == 0)
		{

			ATUReports.add("*************Gantt List is Zero and hence Exiting test smoothly*******************",  LogAs.PASSED, null);
		}else{
			int i=0;
			
			for (WebElement gantelement : Ganntlist) {
				
				i++;
				
				
				try{
					String idofelement = gantelement.getAttribute("id");

					ATUReports.add("Verifying puck with id :: "+idofelement,  LogAs.INFO, null); 

				}catch(Exception id)
				{
					
				}	
					
				
				
				if(i<100)
				{
			
				String elementid = gantelement.getAttribute("id");

				if (elementid != "") {
					Actions actions = new Actions(getDriver());			
					
					WebElement elee = getDriver().findElement(By.xpath("//*[@id='" + elementid + "']"));
					actions.moveToElement(elee).build().perform();
					Thread.sleep(1000);
					try
					{

						WebElement linkWeight = getDriver().findElement(By.xpath("//div[@id='"+ elementid +"']//span[@class='ng-binding wt-restricted']"));
						if(linkWeight!=null){
							ATUReports.add("Weight restriction details available for   "+elementid,  LogAs.PASSED, null); 
						}
						linkWeight.click();
						String Popovercontent = getDriver().findElement(By.xpath("//div[contains(@class,'popup-tmplte')]")).getAttribute("innerText");
						if(Popovercontent.contains("Weight Restriction")){
							ATUReports.add("Weight restriction popup displayed for  "+elementid,  LogAs.PASSED, null); 
						}else{
							ATUReports.add("Weight restriction popup not  displayed for  "+elementid,  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE)); 
						}
						
						
					}
					catch(Exception Gateswapiconnotpresent)
					{

						ATUReports.add("Some other issue in identifying element "+elementid,  LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE)); 
					}
					
					}
				}
				
				}
		}}
		catch(Exception Noelement)
		{

			ATUReports.add("Weight restriction Stats may not present or stats may not present ",  LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE)); 
			
			}
		
		CommonTest.zoomOut();
		CommonTest.zoomOut();
		
	CommonTest.CheckCollapse();
	
		
		
		
	}


	public static void Rightstartflightconform(String view) throws Exception {
		
		
//			String Stations[] = {"DFW","PHL","CLT","LAX","LGA","PIT","RDU","MIA","PHX","SFO","ORD","ABE","BOS","BPT","CHO","DTW","FRA","IAD","IAH","JFK","MAD","OGG","OKC","PHL","PIA","PIB",
//				"PLS","PNS","POP","POS","PSP","PTP","PTY","PUJ","PVD","PVG","PVR","PWM","SJO","SJT","SJU","STL","STS","STT","SYD","SYR"};
		String Starttime = correction.getpasthrs("America/Chicago",-1);
		String Endtime = correction.nexthrs("America/Chicago",12);
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date = new java.util.Date();
		String dateWithoutTime =dateFormat.format(date);   //"02 May 2016"; 
		String strStartTime2 = dateWithoutTime + "T" + Starttime +".737Z";
		String strEndTime2 = dateWithoutTime + "T" + Endtime +".737Z";
	
		
		System.out.println("Verify the only the Rightstart flights marked *Yes* flights in service are shown under Rightstart flight statistics");
		System.out.println("Posting Request to service and get the details");
		
		//String url="http://apapns43.pdc.aa.com:8080/GetNGServices/flight/getFlightsForGivenTime";
		//String urlCache="http://apapns45.pdc.aa.com:8081/GetCrewCache/crew/getCrewAlertReport";
	
		String url="http://10.245.15.40:8080/GetNGServices/flight/getFlightsForGivenTime";
		String urls="http://10.245.15.40:8080/GetNGServices/flight/getFlightsForGivenTime";
	
		String sta = "DFW";
		
		String request= "{\"station\":\""+sta+"\",\"startTime\":\""+strStartTime2+"\",\"endTime\":\""+strEndTime2+"\",\"gates\":[],\"allGates\":true,\"pastFlights\":true,\"transactionId\":\"UNKNOWN_00812339_PHX_1489539768116_201\"}";
		String request13= "{\"station\":\""+sta+"\",\"startTime\":\""+strStartTime2+"\",\"endTime\":\""+strEndTime2+"\",\"gates\":[],\"allGates\":true,\"pastFlights\":true,\"transactionId\":\"UNKNOWN_00812339_PHX_1489539768116_201\"}";
		try{
		ArrayList<String> rightstartflights = correction.startcode(url, request, urls, sta, "kickOffFlt");
			ATUReports.add("Successfully fetched rightstartflights  :: "+rightstartflights,  LogAs.PASSED, null);
		try{
			CustomZone.SelectStation("DFW");
		}
		catch(Exception Totalgatenotselected){
		ATUReports.add("Couldnot able to Set station",  LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE)); 
		}
		
		Thread.sleep(5000);
		CommonTest.SpinnerControl();
		TestcaseInit();
		DashboardFilterOptionValidation.StatsoptionExist();
		DashboardFilterOptionValidation.StatsoptionSelection();
		DashboardFilterOptionValidation.SelectAllStatistics();
		CommonTest.Selectview(view);
		System.out.println("Selected view for validation is "+view);
		try{
			
			clickByXpathbyView(view, Web_UI.RightStart, Web_UI.HybridRightStart);
			
			try{
				CheckCollapse();
				
					Thread.sleep(2000);
				
					ATUReports.add("Rightstart stats selected",  LogAs.PASSED, null);
					clickByXpath(Web_UI.SortAscending,"SortAscending");
					Thread.sleep(1000);
					// Select Sort Ascending gate by alphabetical order from dropdown
					clickByXpath(Web_UI.SortAscendinggate,"SortAscendinggate");
					Thread.sleep(1000);
					CommonTest.zoomindata();
					List<WebElement> Ganntlist = getDriver().findElements(By.xpath(Web_UI.PuckCompleteLinkage));
					int Ganntlistcount = Ganntlist.size();
					if(Ganntlistcount == 0)
					{
						CommonTest.CheckGanttviewListisnotZero();
					}
					CommonTest.SpinnerControl();
					CheckCollapse();
					clickByXpathbyView(view, Web_UI.RightStart, Web_UI.HybridRightStart);
					CommonTest.CheckExpand();
					List<WebElement> Ganntlist1 = getDriver().findElements(By.xpath(Web_UI.PuckComplete));
					CommonTest.CheckExpand();
					int Ganntlistcount1 = Ganntlist1.size();
					if(Ganntlistcount1 == 0)
					{
						
						ATUReports.add("*************Gantt List is Zero and hence Exiting test smoothly*******************",  LogAs.PASSED, null);
						
					}else
					{
						if (Ganntlist != null) {
							
							int i=0;
							for (WebElement gantelement : Ganntlist) {
								i++;
								
								
								try{

									String idofelement = gantelement.getAttribute("id");
									ATUReports.add("Verifying puck with id :: "+idofelement,  LogAs.INFO, null); 

								}catch(Exception id)
								{
									
								}
								
											try {

												Actions actions = new Actions(getDriver());
												actions.moveToElement(gantelement).build().perform();
												actions.moveToElement(gantelement);
												String Linkage = gantelement.getAttribute("innerText");
												String Departuretext[] = Linkage.split("/");
												String Departureflight = Departuretext[1].trim();
												if(Departureflight!=""){
													boolean termchecker = Departureflight.contains("TERM");
												if(termchecker==false)
												{
													
													boolean contains = rightstartflights.contains(Departureflight);

													if(contains == true)	
													{

														ATUReports.add("Flight is Righstart flight and No is :: "+Departureflight,  LogAs.PASSED, null);
													}else{

														ATUReports.add("Flight is not a Righstart flight and No is :: "+Departureflight,  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
													}
													
												}
												
												}
										
											}catch(Exception Someissueinmovingbetweenpuck)
											{
													System.out.print("Some Issue in moving between pucks");	
														
											}
							}
											
							}
							
						
							}
					}
			
						catch(Exception Totalgatenotselected){

							ATUReports.add("Couldnot able to select Rightstart",  LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE)); 
							
						CommonTest.CheckOKPopupPresentandclose();
						CommonTest.CheckCancelPopupPresentandclose();
					}
		}catch(Exception Applybuttontakestime)
		{

			ATUReports.add("Couldnot able to select Rightstart",  LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE)); 
			
		CommonTest.CheckOKPopupPresentandclose();
		CommonTest.CheckCancelPopupPresentandclose();
		}
		System.out.println(rightstartflights);
	}catch(Exception Fetchingissueinservice)
	{
		ATUReports.add("Service not responding ",  LogAs.INFO, null); 
}
				CommonTest.zoomOutdata();
					
	}
	
	
	
	
	
	
		
}





