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
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import get.next.gen.commonaction.CompareExcel;
import get.next.gen.webtestcase.*;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
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




public class EventDetailsValidation  extends CommonTest {


	public static void EventAlertDetailsPopupselection()  throws Exception {
		TestcaseInit();
		System.out.println("Verify the user is shown with event details page");
		CommonTest.SpinnerControl();
		CommonTest.CollapseTest();
		try{
			clickByXpath(Web_UI.TotalGate,"TotalGate");

			CommonTest.ExpandTest();
			try{

				CommonTest.zoomin();
				CommonTest.zoomin();
				CommonTest.zoomin();

				CommonTest.SpinnerControl();
				System.out.println("Verify the Event details Slideout is displayed upon selecting a flight puck in Gantt view ");	
				clickByXpath(Web_UI.SortAscending,"SortAscending");
				Thread.sleep(1000);
				// Select Sort Ascending gate by alphabetical order from dropdown
				clickByXpath(Web_UI.SortAscendinggate,"SortAscendinggate");

				Thread.sleep(1000);
				List<WebElement> Ganntlist = getDriver().findElements(By.xpath(Web_UI.PuckComplete));
				int Ganntlistcount = Ganntlist.size();
				if (Ganntlistcount != 0) {
					int Flightpuckcounter=0;
					for (WebElement gantelement : Ganntlist) {
						//Setting Gantt view flight puck counter inorder to validate 20 pucks as page refresh interrupts the execution
						if(Flightpuckcounter<20)
						{
							Flightpuckcounter++;
							String elementid = gantelement.getAttribute("id");
							Actions actions = new Actions(getDriver());
							WebElement elee = findelementbyxpath("//*[@id='"+elementid+"']");

							actions.moveToElement(elee).build().perform();
							//	CommonTest.scrollGanttView();
							try {
								elee.click();
								Thread.sleep(5000);
								String EventdetailsPopupHeaderText = getDriver().findElement(By.xpath("//ul[@class='slideoutMenu']")).getAttribute("innerText");
								String Slideoutheadertrimmed =  EventdetailsPopupHeaderText.trim();
								String elementidtrimmer = elementid.substring(0, 4);

								if (EventdetailsPopupHeaderText.contains(elementidtrimmer))
								{

									ATUReports.add("Slide out is displayed ",Slideoutheadertrimmed,  LogAs.PASSED, null); 
									System.out.println("Slide out displayed upon selecting a puck ");
								}
								else
								{

									ATUReports.add("Slideout not displayed ",  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE)); 
									System.out.println("Having issue in Slide out display  ");
								}

								clickByXpath("//div[@class='close-icn pop-over-close close-slde-icon']","pop-over-close");
								System.out.println(" Close Button is selected and Slideout closed successfully ");
								Thread.sleep(1000);
								ATUReports.add("Slideout closed Successfully ",  LogAs.PASSED, null); 
							}
							catch (Exception Popupnotdisplayed)
							{
								System.out.println("Some issue with elements identification --EventDetailsValidation()");
								captureinfoScreenshot(getDriver(),"Some issue with elements");
							}		


						}
						break;
					}
				}
			}
			catch (Exception Popupnotdisplayed)
			{
				System.out.println("Some issue with elements identification ");
				CommonTest.CheckOKPopupPresentandclose();
				CommonTest.CheckCancelPopupPresentandclose();
				Checkappupdateclosebutton();
			}

		}catch(Exception totalgatesselection){

		}

	}

	public static void Atlasiconexistance()  throws Exception {
		TestcaseInit();
		System.out.println(" Verify the Atlas icon displayed on Event details screen  ");
		CommonTest.SpinnerControl();
		try{
			clickByXpathbyView("Ganttview", Web_UI.Atlas, Web_UI.HybridAtlas);
			List<WebElement> Ganntlist = getDriver().findElements(By.xpath(Web_UI.GanttTable));
			int Ganntlistcount = Ganntlist.size();
			if (Ganntlistcount != 0) {
				int Flightpuckcounter=0;
				for (WebElement gantelement : Ganntlist) {
					//Setting Gantt view flight puck counter inorder to validate 20 pucks as page refresh interrupts the execution

					String elementid = gantelement.getAttribute("id");
					Actions actions = new Actions(getDriver());
					WebElement elee = findelementbyxpath("//*[@id='"+elementid+"']");
					actions.moveToElement(elee).build().perform();
					try {
						elee.click();
						System.out.println(" Clicked on a Puck ");
						Thread.sleep(6000);

						try{
							WebElement AtlasiconinEventdetailspage = getDriver().findElement(By.xpath("//img[@title='Atlas Galley']"));
							if(AtlasiconinEventdetailspage!=null){
								ATUReports.add("Atlas icon Present in Event details page ",  LogAs.PASSED,null);  
							}

						}catch(Exception atlasnotexist){
							ATUReports.add("Atlas icon not exist ",  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));  
						}

						//*******************************************************************************************************************				
						WebElement EventdetailsClose = getDriver().findElement(By.xpath("//div[@class='close-icn pop-over-close close-slde-icon']"));
						EventdetailsClose.click();
						ATUReports.add("Event Details Popover closed Successfully ",  LogAs.PASSED, null); 

					}
					catch(Exception EmptyganttEventdetails)
					{
						System.out.println("EmptyganttEventdetails");
						ATUReports.add("EmptyganttEventdetails 1",  LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));  
						captureinfoScreenshot(getDriver(),"EmptyganttEventdetails 1");
					}


					break;	

				}



			}

		}catch(Exception Atlasiconnotpresent){
			ATUReports.add("Atlasgalley stats not present in statistics.",  LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));  
		}

	}


	public static void EventAlertDetailsComparison()  throws Exception {

		System.out.println(" Verify the Slide out holds All the Events  ");
		TestcaseInit();
		List<WebElement> Ganntlist = getDriver().findElements(By.xpath(Web_UI.GanttTable));
		int Ganntlistcount = Ganntlist.size();
		if (Ganntlistcount != 0) {
			int Flightpuckcounter=0;
			for (WebElement gantelement : Ganntlist) {
				//Setting Gantt view flight puck counter inorder to validate 20 pucks as page refresh interrupts the execution
				if(Flightpuckcounter<20)
				{
					Flightpuckcounter++;
					String elementid = gantelement.getAttribute("id");
					Actions actions = new Actions(getDriver());
					WebElement elee = findelementbyxpath("//*[@id='"+elementid+"']");
					actions.moveToElement(elee).build().perform();
					//CommonTest.scrollGanttView();
					try {
						elee.click();
						System.out.println(" Clicked on a Puck ");
						Thread.sleep(6000);
						clickByXpath("//ul[@class='col-xs-12 flt-status ng-scope']/li[1]","flt-status");
						List<WebElement> EventdetailsList = getDriver().findElements(By.xpath("//div[@ng-repeat=' evt in $parent.flightEvents']"));
						int Eventdetailscount = EventdetailsList.size();
						//***************************************************************************	
						int eventcontrol = (Eventdetailscount+1)-Eventdetailscount;
						System.out.println(" The Number of Event details present in Slide out are   "+Eventdetailscount);

						int Offloadplacement = eventcontrol;
						int Crewplacement = Offloadplacement+1;
						int Bagsplacement = Crewplacement+1;
						int Paxplacement = Bagsplacement+1;
						int Cabinplacement = Paxplacement+1;
						int Cateringplacement = Cabinplacement+1;
						int Fuelingplacement = Cateringplacement+1;
						int Waterplacement = Fuelingplacement+1;
						int Lavsplacement = Waterplacement+1;
						//**************************************************************************************														
						/*	try{
						String	OffloadFlightListText1 =  getDriver().findElement(By.xpath("//*[@id='0']/div/div["+Offloadplacement+"]/div[1]")).getText();		
						String	CrewFlightListText1 = 	 getDriver().findElement(By.xpath("//*[@id='0']/div/div["+Crewplacement+"]/div[1]")).getText();			
						String	BagsFlightListText1 = 	 getDriver().findElement(By.xpath("//*[@id='0']/div/div["+Bagsplacement+"]/div[1]")).getText();		
						String	PaxFlightListText1 = 	 getDriver().findElement(By.xpath("//*[@id='0']/div/div["+Paxplacement+"]/div[1]")).getText();		
						String	CabinFlightListText1 = 	 getDriver().findElement(By.xpath("//*[@id='0']/div/div["+Cabinplacement+"]/div[1]")).getText();	


						String	OffloadFlightListText = OffloadFlightListText1.trim();
						String	CrewFlightListText = 	CrewFlightListText1.trim();
						String	BagsFlightListText = 	 BagsFlightListText1.trim();
						String	PaxFlightListText = 	 PaxFlightListText1.trim();
						String	CabinFlightListText = 	 CabinFlightListText1.trim();
						 */	

						//************************************************************************************************			
						//	elee.click();
						Thread.sleep(2000);
						try{
							String	GanttOffloadFlightListText1 =  getDriver().findElement(By.xpath("//div[@data-ng-init='flightEvents  = flts.flightEvents']/div["+Offloadplacement+"]/div[1]")).getAttribute("innerText");		
							String	GanttCrewFlightListText1 =   getDriver().findElement(By.xpath("//div[@data-ng-init='flightEvents  = flts.flightEvents']/div["+Crewplacement+"]/div[1]")).getAttribute("innerText");	
							String	GanttBagsFlightListText1 =  	getDriver().findElement(By.xpath("//div[@data-ng-init='flightEvents  = flts.flightEvents']/div["+Bagsplacement+"]/div[1]")).getAttribute("innerText");			
							String	GanttPaxFlightListText1 =   	getDriver().findElement(By.xpath("//div[@data-ng-init='flightEvents  = flts.flightEvents']/div["+Paxplacement+"]/div[1]")).getAttribute("innerText");			
							String	GanttCabinFlightListText1 = 	getDriver().findElement(By.xpath("//div[@data-ng-init='flightEvents  = flts.flightEvents']/div["+Cabinplacement+"]/div[1]")).getAttribute("innerText");	



							String	GanttOffloadFlightListText =   GanttOffloadFlightListText1.trim();
							String	GanttCrewFlightListText =   	GanttCrewFlightListText1.trim();	
							String	GanttBagsFlightListText =  	GanttBagsFlightListText1.trim();		
							String	GanttPaxFlightListText =   	GanttPaxFlightListText1.trim();	
							String	GanttCabinFlightListText = 	GanttCabinFlightListText1.trim();

							System.out.println(" The Offload Event Hold title as   "+GanttOffloadFlightListText);
							System.out.println(" The CREW Event Hold title as   "+GanttCrewFlightListText);
							System.out.println(" The BAGS Event Hold title as   "+GanttBagsFlightListText);
							System.out.println(" The PAX Event Hold title as   "+GanttPaxFlightListText);
							System.out.println(" The CABIN Event Hold title as   "+GanttCabinFlightListText);
							//************************* Validation Starts Here*******************************************************************				


							if(GanttOffloadFlightListText1.contains("OFFLOAD"))
							{
								System.out.println("Offload Validated");
								ATUReports.add(" ",  LogAs.PASSED, null); 
							}
							else
							{
								System.out.println("Offload Fail");
								ATUReports.add("Mismatch identified while comparing offload event alert",  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE)); 
								captureinfoScreenshot(getDriver(),"Mismatch identified while comparing offload event alert");

							}

							if(GanttCrewFlightListText1.contains("CREW"))
							{
								System.out.println("Crew Validated");
								ATUReports.add("Compared the Gantt view Crew Event alert with Flight list view and been passed  ",  LogAs.PASSED, null); 
							}
							else
							{
								System.out.println("Crew Fail");
								ATUReports.add("Mismatch identified while comparing CREW event alert",  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE)); 
								captureinfoScreenshot(getDriver(),"Mismatch identified while comparing CREW event alert");

							}


							if(GanttBagsFlightListText1.contains("BAGS"))
							{
								System.out.println("bags Validated");
								ATUReports.add("Compared the Gantt view Bags Event alert with Flight list view and been passed  ",  LogAs.PASSED, null); 
							}
							else
							{
								System.out.println("bags Fail");
								ATUReports.add("Mismatch identified while comparing BAGS event alert",  LogAs.PASSED, null); 
								captureinfoScreenshot(getDriver(),"Mismatch identified while comparing BAGS event alert");

							}


							if(GanttPaxFlightListText1.contains("PAX"))
							{
								System.out.println("pax Validated");
								ATUReports.add("Compared the Gantt view Passanger Event alert with Flight list view and been passed  ",  LogAs.PASSED, null); 
							}
							else
							{
								System.out.println("pax Fail");
								ATUReports.add("Mismatch identified while comparing PAX event alert",  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE)); 
								captureinfoScreenshot(getDriver(),"Mismatch identified while comparing PAX event alert");

							}


							if(GanttCabinFlightListText1.contains("CABIN"))
							{
								System.out.println("Cabin Validated");
								ATUReports.add("Compared the Gantt view Cabin Event alert with Flight list view and been passed  ",  LogAs.PASSED, null); 
							}
							else
							{
								System.out.println("Cabin Fail");
								ATUReports.add("Mismatch identified while comparing Cabin event alert",  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE)); 
								captureinfoScreenshot(getDriver(),"Mismatch identified while comparing Cabin event alert");

							}

							//**********************************   Validation if More than 5 event reports present ****************************************				

							if(Cateringplacement<Eventdetailscount)
							{
								String	CateringFlightListText1 =  getDriver().findElement(By.xpath("//*[@id='0']/div/div["+Cateringplacement+"]/div[1]")).getText();		
								String	CateringFlightListText = CateringFlightListText1.trim();
								String	GanttCateringFlightListText1 =  getDriver().findElement(By.xpath("//*[@id='0']/div/div["+Cateringplacement+"]/div[1]")).getText();		
								String	GanttCateringFlightListText = GanttCateringFlightListText1.trim();
								if(CateringFlightListText.contains(GanttCateringFlightListText))
								{
									System.out.println("Catering Pass");
									ATUReports.add("Compared the Gantt view Catering Event alert with Flight list view and been passed  ",  LogAs.PASSED, null); 
								}
								else
								{
									System.out.println("Catering Fail");
									ATUReports.add("Mismatch identified while comparing Catering event alert",  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE)); 
									captureinfoScreenshot(getDriver(),"Mismatch identified while comparing Catering event alert");
								}


							}	

							//*****************	

							if(Fuelingplacement<Eventdetailscount)
							{
								String	FuelFlightListText1 = 	 getDriver().findElement(By.xpath("//*[@id='0']/div/div["+Fuelingplacement+"]/div[1]")).getText();		
								String	FuelFlightListText = 	FuelFlightListText1.trim();
								String	GanttFuelFlightListText1 = 	 getDriver().findElement(By.xpath("//*[@id='0']/div/div["+Fuelingplacement+"]/div[1]")).getText();		
								String	GanttFuelFlightListText = 	GanttFuelFlightListText1.trim();
								if(FuelFlightListText.contains(GanttFuelFlightListText))
								{
									System.out.println("Fuel Pass");
									ATUReports.add("Compared the Gantt view Fueling Event alert with Flight list view and been passed  ",  LogAs.PASSED, null); 
								}
								else
								{
									System.out.println("Fuel Fail");
									ATUReports.add("Mismatch identified while comparing Fueling event alert",  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE)); 
									captureinfoScreenshot(getDriver(),"Mismatch identified while comparing Fueling event alert");
								}

							}	

							//********************

							if(Waterplacement<Eventdetailscount)
							{
								String	WaterFlightListText1 = 	 getDriver().findElement(By.xpath("//*[@id='0']/div/div["+Waterplacement+"]/div[1]")).getText();	
								String	WaterFlightListText = 	 WaterFlightListText1.trim();
								String	GanttWaterFlightListText1 = 	 getDriver().findElement(By.xpath("//*[@id='0']/div/div["+Waterplacement+"]/div[1]")).getText();	
								String	GanttWaterFlightListText = 	GanttWaterFlightListText1.trim();
								if(WaterFlightListText.contains(GanttWaterFlightListText))
								{
									System.out.println("Water Pass");
									ATUReports.add("Compared the Gantt view Water Event alert with Flight list view and been passed  ",  LogAs.PASSED, null); 
								}
								else
								{
									System.out.println("Water Fail");
									ATUReports.add("Mismatch identified while comparing Water event alert",  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE)); 

								}


							}

							if(Lavsplacement<Eventdetailscount)
							{
								String	LavsFlightListText1 = 	 getDriver().findElement(By.xpath("//*[@id='0']/div/div["+Lavsplacement+"]/div[1]")).getText();	
								String	LavsFlightListText = 	 LavsFlightListText1.trim();
								String	GanttLavsFlightListText1 = 	 getDriver().findElement(By.xpath("//*[@id='0']/div/div["+Lavsplacement+"]/div[1]")).getText();	
								String	GanttLavsFlightListText = 	 GanttLavsFlightListText1.trim();

								if(LavsFlightListText.contains(GanttLavsFlightListText))
								{
									System.out.println("Lavs Pass");
									ATUReports.add("Compared the Gantt view LAVS Event alert with Flight list view and been passed  ",  LogAs.PASSED, null); 
								}
								else
								{
									System.out.println("Lavs Fail");
									ATUReports.add("Mismatch identified while comparing LAVS event alert",  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE)); 
								}

							}


							//*******************************************************************************************************************				
							WebElement EventdetailsClose = getDriver().findElement(By.xpath("//div[@class='close-icn pop-over-close']"));
							EventdetailsClose.click();
							ATUReports.add("Event Details Popover closed Successfully ",  LogAs.PASSED, null); 

						}
						catch(Exception EmptyganttEventdetails)
						{
							System.out.println("EmptyganttEventdetails");
							ATUReports.add("EmptyganttEventdetails 1",  LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));  
						}




					}
					catch(Exception EmptyganttEventdetails)
					{
						System.out.println("EmptyganttEventdetails");
						ATUReports.add("EmptyganttEventdetails 2",  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE)); 

					}
				}		break;
			}
		}
	}


	//*************************************************************************************************	


	public static void CheckContentsinSlideOut()  throws Exception {

		TestcaseInit();
		System.out.println("Verify the Eventdetails page details matches with the selected puck");
		try{
			clickByXpath(Web_UI.TotalGate,"TotalGate");

			CommonTest.SpinnerControl();
			clickByXpath(Web_UI.SortAscending,"SortAscending");
			Thread.sleep(1000);
			// Select Sort Ascending gate by alphabetical order from dropdown
			clickByXpath(Web_UI.SortAscendinggate,"SortAscendinggate");

			Thread.sleep(1000);
			System.out.println("Verify the Event details data  upon selecting a flight puck in Gantt view ");	
			List<WebElement> Ganntlist = getDriver().findElements(By.xpath(Web_UI.PuckComplete));
			int Ganntlistcount = Ganntlist.size();
			if (Ganntlistcount != 0) {
				int Flightpuckcounter=0;
				for (WebElement gantelement : Ganntlist) {
					//Setting Gantt view flight puck counter inorder to validate 20 pucks as page refresh interrupts the execution
					if(Flightpuckcounter<20)
					{
						Flightpuckcounter++;
						String elementid = gantelement.getAttribute("id");

						Boolean elementidoriginterm = (elementid.contains("TERMINATED")||elementid.contains("ORIGINATED")||elementid.contains("UNLINKED"));
						if(elementidoriginterm!=true)
						{

							System.out.println("elementidoriginterm   ::  @@@@@ "+elementidoriginterm);
							Actions actions = new Actions(getDriver());
							WebElement elee = findelementbyxpath("//*[@id='"+elementid+"']");

							actions.moveToElement(elee).build().perform();
							actions.moveToElement(elee).build().perform();
							String CompletepuckText = elee.getAttribute("innerText");

							if(CompletepuckText.contains(":"))
							{
								try {

									elee.click();
									Thread.sleep(10000);

									try
									{
										WebElement Flightdetails = getDriver().findElement(By.xpath("//span[text()='Flight Details']"));
										if  (Flightdetails!=null)
										{

										}
										else
										{
											clickByXpath("//div[@class='gantt-sldout collapse-clse-icn']","collapse");
										}
									}catch(Exception Flightdetailsopen)
									{
										clickByXpath("//div[@class='gantt-sldout collapse-clse-icn']","collapse");

									}




									//	String LinkageTextSlideout1 = getDriver().findElement(By.xpath("//div[@id='gantt-event']/div[1]/div[2]/div[2]/div[1]/div[1]/span[2]")).getAttribute("innerText").trim();
									String ArrivalGateSlideout1 = getDriver().findElement(By.xpath("//div[@id='gantt-event']/div[1]/div[3]/div[2]/div[5]/span[2]")).getAttribute("innerText").trim();
									String ArrivalFlightNumberSlideout1 = getDriver().findElement(By.xpath("//div[@id='gantt-event']/div[1]/div[3]/div[2]/div[1]/span[2]")).getAttribute("innerText").trim();
									String ArrivalStationSlideout1 = getDriver().findElement(By.xpath("//div[@id='gantt-event']/div[1]/div[3]/div[2]/div[2]/span[2]")).getAttribute("innerText").trim();
									String ArrivalStatusSlideout1 = getDriver().findElement(By.xpath("//div[@id='gantt-event']/div[1]/div[3]/div[2]/div[3]/span[2]")).getAttribute("innerText").trim();
									String ArrivalTimeSlideout1 = getDriver().findElement(By.xpath("//div[@id='gantt-event']/div[1]/div[3]/div[2]/div[4]/span[2]")).getAttribute("innerText").trim();
									String EQTypeSlideout1 = getDriver().findElement(By.xpath("//div[@id='gantt-event']/div[1]/div[2]/div[2]/div[2]/div[1]/span[2]")).getAttribute("innerText").trim();
									String TailSlideout1 = getDriver().findElement(By.xpath("//div[@id='gantt-event']/div[1]/div[2]/div[2]/div[1]/div[2]/span[2]")).getAttribute("innerText").trim();
									String DepartureGateSlideout1 = getDriver().findElement(By.xpath("//div[@id='gantt-event']/div[1]/div[4]/div[2]/div[5]/span[2]")).getAttribute("innerText").trim();
									String DepartureFlightNumberSlideout1 = getDriver().findElement(By.xpath("//div[@id='gantt-event']/div[1]/div[4]/div[2]/div[1]/span[2]")).getAttribute("innerText").trim();
									String DestinationStationSlideout1 = getDriver().findElement(By.xpath("//div[@id='gantt-event']/div[1]/div[4]/div[2]/div[2]/span[2]")).getAttribute("innerText").trim();
									String DepartureStatusSlideout1 = getDriver().findElement(By.xpath("//div[@id='gantt-event']/div[1]/div[4]/div[2]/div[3]/span[2]")).getAttribute("innerText").trim();
									String DepartureTimeSlideout1 = getDriver().findElement(By.xpath("//div[@id='gantt-event']/div[1]/div[4]/div[2]/div[4]/span[2]")).getAttribute("innerText").trim();
									//	String TUDSlideout1 = getDriver().findElement(By.xpath("//div[@id='gantt-event']/div[1]/div[2]/div[2]/div[2]/div[2]/span[2]")).getAttribute("innerText").trim();


									//String LinkageTextSlideout = LinkageTextSlideout1.trim();
									String ArrivalGateSlideout = ArrivalGateSlideout1.trim();
									String ArrivalFlightNumberSlideout = ArrivalFlightNumberSlideout1.trim();
									String ArrivalStationSlideout = ArrivalStationSlideout1.trim();
									String ArrivalStatusSlideout = ArrivalStatusSlideout1.trim();
									String ArrivalTimeSlideout = ArrivalTimeSlideout1.trim();
									String EQTypeSlideout = EQTypeSlideout1.trim();
									String TailSlideout = TailSlideout1.trim();
									String DepartureGateSlideout = DepartureGateSlideout1.trim();
									String DepartureFlightNumberSlideout = DepartureFlightNumberSlideout1.trim();
									String DestinationStationSlideout = DestinationStationSlideout1.trim();
									String DepartureStatusSlideout = DepartureStatusSlideout1.trim();
									String DepartureTimeSlideout = DepartureTimeSlideout1.trim();

									System.out.println(""+DepartureTimeSlideout);
									//	String TUDSlideout = TUDSlideout1.trim();


									if(CompletepuckText.contains(ArrivalFlightNumberSlideout))
									{
										ATUReports.add("Arrival Flight Number matches with Puck",  LogAs.PASSED, null); 
									}else
									{
										ATUReports.add("Arrival Flight Number Not matches with Puck",  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE)); 
									}



									if(CompletepuckText.contains(ArrivalStationSlideout))
									{
										ATUReports.add("Arrival Station matches with Puck",  LogAs.PASSED, null); 
									}else
									{
										ATUReports.add("Arrival Station Not matches with Puck",  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE)); 
									}


									if(CompletepuckText.contains(ArrivalStatusSlideout))
									{
										ATUReports.add( "Arrival status matches with Puck",  LogAs.PASSED, null); 
									}else
									{
										ATUReports.add("Arrival status Not matches with Puck",  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE)); 
									}



									if(CompletepuckText.contains(ArrivalTimeSlideout))
									{
										ATUReports.add("Arrival time matches with Puck",  LogAs.PASSED, null); 
									}else
									{
										ATUReports.add("Arrival time Not matches with Puck",  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE)); 
									}



									if(CompletepuckText.contains(EQTypeSlideout))
									{
										ATUReports.add("EQType matches with Puck",  LogAs.PASSED, null); 
									}else
									{
										ATUReports.add("EQType Not matches with Puck",  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE)); 
									}


									if(CompletepuckText.contains(TailSlideout))
									{
										ATUReports.add("Tail matches with Puck",  LogAs.PASSED, null); 
									}else
									{
										ATUReports.add("Tail Not matches with Puck",  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE)); 
									}

									if(CompletepuckText.contains(DepartureFlightNumberSlideout))
									{
										ATUReports.add("Departure Flight number matches with Puck",  LogAs.PASSED, null); 
									}else
									{
										ATUReports.add("Departure Flight numberNot matches with Puck",  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE)); 
									}
									if(CompletepuckText.contains(DestinationStationSlideout))
									{
										ATUReports.add( "Destination Station matches with Puck",  LogAs.PASSED, null); 
									}else
									{
										ATUReports.add("Destination Station Not matches with Puck",  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE)); 
									}

									if(CompletepuckText.contains(DepartureStatusSlideout))
									{
										ATUReports.add("Departure Status matches with Puck",  LogAs.PASSED, null); 
									}else
									{
										ATUReports.add("Departure Status Not matches with Puck",  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE)); 
									}

									if(CompletepuckText.contains(DepartureTimeSlideout))
									{
										ATUReports.add("Departure time matches with Puck",  LogAs.PASSED, null); 
									}else
									{
										ATUReports.add("Departure timeNot matches with Puck",  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE)); 
									}
									WebElement EventdetailsClose = getDriver().findElement(By.xpath("//div[@title='Close Slideout']"));
									EventdetailsClose.click();
									ATUReports.add("Event Details Popover closed Successfully ",  LogAs.PASSED, null); 
									Thread.sleep(2000);


								}
								catch(Exception Element)
								{
									try
									{
										WebElement EventdetailsClose = getDriver().findElement(By.xpath("//div[@title='Close Slideout']"));
										EventdetailsClose.click();
									}
									catch(Exception Elementt)
									{

									}

									System.out.println("Something Wrong in Fetching the details from Slideout ");
									ATUReports.add("Something Wrong in Fetching the details from Slideout ",  LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));  
									captureinfoScreenshot(getDriver(),"Something Wrong in Fetching the details from Slideout");
								}

								break;
							}
						}
					}
				}

			}
		}catch(Exception totalgatesselection){

		}
	}


	//**********************************************************************************





	public static void CheckReportContent() throws Exception {
		Thread.sleep(2000);

		try{
			WebElement Reportcontent = getDriver().findElement(By.xpath("//div[@class='modal-dialog modal-lg']/div[1]/div[2]/div[2]"));
			Thread.sleep(2000);
			String Reportcontents = Reportcontent.getAttribute("innerText");
			if(Reportcontents.contains("null") || Reportcontents.contains("NULL"))
			{
				ATUReports.add("Verified content and donot have Null value is present ",  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE)); 
				captureinfoScreenshot(getDriver(),"Verified content and donot have Null value is present ");
			}
			else
			{
				ATUReports.add("Verified content and donot have Null value present ",  LogAs.PASSED, null); 

			}

		}
		catch(Exception Nobagcontent)
		{
			CommonTest.CheckOKPopupPresentandclose();
			CommonTest.CheckCancelPopupPresentandclose();
			Checkappupdateclosebutton();
		}

		///////////////////////
		try{
			WebElement Reportcontent = getDriver().findElement(By.xpath("//div[@class='modal-dialog modal-lg']/div[1]/div[2]/div[2]/div[1]/div[2]"));
			Thread.sleep(2000);
			String Reportcontents = Reportcontent.getAttribute("innerText");
			if(Reportcontents.contains("null") || Reportcontents.contains("NULL"))
			{
				ATUReports.add("Verified content and donot have Null value is present ",  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE)); 
				captureinfoScreenshot(getDriver(),"LaunchError");

			}
			else
			{
				ATUReports.add( "Verified content and donot have Null value present ",  LogAs.PASSED, null); }

		}
		catch(Exception Nobagcontent)
		{
			CommonTest.CheckOKPopupPresentandclose();
			CommonTest.CheckCancelPopupPresentandclose();
			Checkappupdateclosebutton();
		}


		////////////////////////////////////
		try{
			WebElement Reportcontent = getDriver().findElement(By.xpath("//div[@class='modal-dialog modal-lg']/div[1]/div[1]/div[2]/div[2]"));
			Thread.sleep(2000);
			String Reportcontents = Reportcontent.getAttribute("innerText");
			if(Reportcontents.contains("null") || Reportcontents.contains("NULL"))
			{
				ATUReports.add("Verified content and donot have Null value is present ",  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE)); 
				captureinfoScreenshot(getDriver(), "Verified content and donot have Null value is present ");

			}
			else
			{
				ATUReports.add("Verified content and donot have Null value present ",  LogAs.PASSED, null); 
			}

		}
		catch(Exception Nobagcontent)
		{

		}







	}





	public static void CloseEventdetails() throws Exception {
		Thread.sleep(2000);
		try{

			WebElement CloseEventdetailspopup = getDriver().findElement(By.xpath("//div[@class='collpase-slideout ng-scope']"));
			CloseEventdetailspopup.click();
			ATUReports.add("Slideout closed Successfully ",  LogAs.PASSED, null); 
			Thread.sleep(2000);
		}
		catch(Exception CloseEventdetailspopupexception)
		{
			System.out.println("Slideout  button not displayed");
			ATUReports.add("Something went wrong in closing the Slideout details popup  ",  LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));  
			CommonTest.CheckOKPopupPresentandclose();
			CommonTest.CheckCancelPopupPresentandclose();
			Checkappupdateclosebutton();
		}

	}

	public static void Closepopup()  throws Exception {

		Thread.sleep(2000);
		try{

			WebElement Closepopupicon = getDriver().findElement(By.xpath("//div[text()='OK']"));
			Closepopupicon.click();
			ATUReports.add("Validated the report and closing the report dialog box  ",  LogAs.PASSED, null); 
			Thread.sleep(2000);
		}
		catch(Exception Closepoputexception)
		{
			System.out.println("Close Popup exception");
			ATUReports.add("Something went wrong or Close report button is not been displayed ",  LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));  
			clickByXpath("//span[@class='close-icn']","close");
		}
	}



	public static void CheckNoreport()  throws Exception {

		Thread.sleep(3000);
		try
		{
			Boolean NodataPopup = getDriver().findElement(By.xpath("//div[@id='getInFocusNow']")).isDisplayed();

			if(NodataPopup == true)
			{
				System.out.println("No data popup is displayed");
				ATUReports.add("No data at this time popup is displayed  ",  LogAs.PASSED, null); 
				WebElement Closeerrorpopup = getDriver().findElement(By.xpath("//span[@class='close-icn error-popup']"));
				Closeerrorpopup.click();
				Thread.sleep(3000);
			}

		}
		catch(Exception NoErrorreport)
		{

			System.out.println("Data present");
			ATUReports.add("Data is present and moving further to script for report validation  ",  LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));  
		}	

	}




























	public static void EventalertcountValidation(String Elementname)  throws Exception {

		List<WebElement> Ganntlist = getDriver().findElements(By.xpath("//div[@data-ng-repeat='flt in gts.Flights']"));
		int Ganntlistcount = Ganntlist.size();
		if (Ganntlistcount != 0) {

			for (WebElement gantelement : Ganntlist) {
				//Setting Gantt view flight puck counter inorder to validate 20 pucks as page refresh interrupts the execution

				String elementid = gantelement.getAttribute("id");
				Actions actions = new Actions(getDriver());
				WebElement elee = findelementbyxpath("//*[@id='"+elementid+"']");
				actions.moveToElement(elee).build().perform();
				actions.moveToElement(elee).build().perform();
				try{
					elee.click();
					Thread.sleep(5000);
					try {

						List<WebElement> EventdetailsList = getDriver().findElements(By.xpath("//div[@data-ng-click='$parent.openEventDet($event,evt,$parent);']"));
						int Eventdetailscount = EventdetailsList.size();
						//***************************************************************************	
						int eventcontrol = (Eventdetailscount+1)-Eventdetailscount;

						int Offloadplacement = eventcontrol;
						int Crewplacement = Offloadplacement+1;
						int Bagsplacement = Crewplacement+1;
						int Paxplacement = Bagsplacement+1;
						int Cabinplacement = Paxplacement+1;
						int Cateringplacement = Cabinplacement+1;
						int Fuelingplacement = Cateringplacement+1;
						int Waterplacement = Fuelingplacement+1;
						int Lavsplacement = Waterplacement+1;

						//************************************************************************************************			

						try{
							WebElement	GanttOffload =  getDriver().findElement(By.xpath("//*[@id='gantt-event']/div/div["+Offloadplacement+"]/div[1]"));			
							WebElement	GanttCrew =   getDriver().findElement(By.xpath("//*[@id='gantt-event']/div/div["+Crewplacement+"]/div[1]"));		
							WebElement	GanttBags =  	getDriver().findElement(By.xpath("//*[@id='gantt-event']/div/div["+Bagsplacement+"]/div[1]"));		
							WebElement	GanttPax =   	getDriver().findElement(By.xpath("//*[@id='gantt-event']/div/div["+Paxplacement+"]/div[1]"));		
							WebElement	GanttCabin = 	getDriver().findElement(By.xpath("//*[@id='gantt-event']/div/div["+Cabinplacement+"]/div[1]"));	

							//************************* Validation Starts Here*******************************************************************				

							String GanttOffloadCount = getDriver().findElement(By.xpath("//*[@id='gantt-event']/div/div[1]/div[1]/span[2]/span[2]")).getText();
							String GanttCrewCount = getDriver().findElement(By.xpath("//*[@id='gantt-event']/div/div[2]/div[1]/span[2]/span[2]")).getText();
							String GanttBagsCount =  getDriver().findElement(By.xpath("//*[@id='gantt-event']/div/div[3]/div[1]/span[2]/span[2]")).getText();
							String GanttPaxCount =  getDriver().findElement(By.xpath("//*[@id='gantt-event']/div/div[4]/div[1]/span[2]/span[2]")).getText();

							int GanttOffloadCountint = Integer.parseInt(GanttOffloadCount);
							int GanttCrewCountint = Integer.parseInt(GanttCrewCount);
							int GanttBagsCountint = Integer.parseInt(GanttBagsCount);
							int GanttPaxCountint = Integer.parseInt(GanttPaxCount);

							if(Elementname.contains("OFFLOAD"))
							{
								GanttOffload.click();
								System.out.println("Offload clicked");
								//test.log(LogStatus.PASS, "Offload report is selected ","OFFLOAD"+" "+ Elementname);
								ATUReports.add("Offload report is selected ","OFFLOAD"+" "+ Elementname,  LogAs.PASSED, null); 
								Thread.sleep(6000);
								CommonTest.SpinnerControl();
								// Check for Error message when no report present
								CheckNoreport();
								// Check report content dont have null values	
								CheckReportCount(GanttOffloadCountint);
								//Close Report page
								Closepopup();
								// Close Event details popup
								CloseEventdetails();					
							}


							if(Elementname.contains("CREW"))
							{
								GanttCrew.click();
								System.out.println("Crew Clicked");
								//test.log(LogStatus.PASS, "Crew report is selected ","CREW"+" "+ Elementname);
								ATUReports.add("Crew report is selected ","CREW"+" "+ Elementname,  LogAs.PASSED, null); 
								CommonTest.SpinnerControl();
								Thread.sleep(6000);
								// Check for Error message when no report present
								CheckNoreport();
								// Check report content dont have null values	
								CheckReportCount(GanttCrewCountint);
								//Close Report page
								Closepopup();
								// Close Event details popup
								CloseEventdetails();

							}


							if(Elementname.contains("BAGS"))
							{
								GanttBags.click();
								System.out.println("BAGS clicked");
								//test.log(LogStatus.PASS, "BAGS report is selected ","BAGS"+" "+ Elementname);
								ATUReports.add("BAGS report is selected ","BAGS"+" "+ Elementname,  LogAs.PASSED, null); 
								CommonTest.SpinnerControl();
								Thread.sleep(6000);
								// Check for Error message when no report present
								CheckNoreport();
								// Check report content dont have null values	
								CheckReportCount(GanttBagsCountint);
								//Close Report page
								Closepopup();
								// Close Event details popup
								CloseEventdetails();

							}


							if(Elementname.contains("PAX"))
							{
								GanttPax.click();
								System.out.println("PAX Clicked");
								//test.log(LogStatus.PASS, "PAX report is selected ","PAX"+" "+ Elementname);
								ATUReports.add("PAX report is selected ","PAX"+" "+ Elementname,  LogAs.PASSED, null); 
								CommonTest.SpinnerControl();
								Thread.sleep(6000);
								// Check for Error message when no report present
								CheckNoreport();
								// Check report content dont have null values	
								CheckReportCount(GanttPaxCountint);
								//Close Report page
								Closepopup();
								// Close Event details popup
								CloseEventdetails(); 
							}


							if(Elementname.contains("CABIN"))
							{
								GanttCabin.click();
								System.out.println("Cabin Clicked");
								//test.log(LogStatus.PASS, "CABIN report is selected ","CABIN"+" "+ Elementname);
								ATUReports.add( "CABIN report is selected ","CABIN"+" "+ Elementname,  LogAs.PASSED, null); 
								CommonTest.SpinnerControl();
								Thread.sleep(6000);
								// Check for Error message when no report present
								CheckNoreport();
								// Check report content dont have null values	
								//CheckReportCount(GanttCabinCountint);
								//Close Report page
								Closepopup();
								// Close Event details popup
								CloseEventdetails() ;

							}


						}
						catch(Exception EmptyganttEventdetails)
						{
							System.out.println("EmptyganttEventdetails");
						}

					}
					catch (Exception Popupnotdisplayed)
					{
						System.out.println("Event details Popup may not be displayed");
					}		

				}
				catch (Exception Popupnotdisplayed)
				{
					System.out.println("Puck is not visible to select from selenium");
				}

				break;
			}
		}
	}


	public static void CheckReportCount(int Counted) throws Exception {
		Thread.sleep(2000);

		int Total = 0;
		int completetotal =Total;
		List<WebElement> Tablerow = getDriver().findElements(By.xpath("//div[@class='col-lg-2 col-xs-2   text-center ellipsis-text ng-binding']"));
		int Tablerowcount = Tablerow.size();
		for (WebElement rowwise : Tablerow) {

			String Rowvalue = rowwise.getText();
			String Splitter[] = Rowvalue.split("/");
			int Rowvalueint = Integer.parseInt(Splitter[1]);



		}


	}




	public static void Selectapucktovieweventdetails() throws Exception {
		System.out.println("Verify the user Shown with event details page");
		TestcaseInit();
		CommonTest.SpinnerControl();
		CommonTest.CollapseTest();
		try{
			clickByXpath(Web_UI.TotalGate,"TotalGate");

			CommonTest.ExpandTest();
			try{
				GanntViewHeaderFunctionality.GanntViewSelection();
				CommonTest.SpinnerControl();
				clickByXpath(Web_UI.SortAscending,"SortAscending");
				Thread.sleep(1000);
				// Select Sort Ascending gate by alphabetical order from dropdown
				clickByXpath(Web_UI.SortAscendinggate,"SortAscendinggate");

				Thread.sleep(1000);
				System.out.println("Verify the Event details data  upon selecting a flight puck in Gantt view ");	
				List<WebElement> Ganntlist = getDriver().findElements(By.xpath(Web_UI.PuckComplete));
				int Ganntlistcount = Ganntlist.size();
				if (Ganntlistcount != 0) {
					int Flightpuckcounter=0;
					for (WebElement gantelement : Ganntlist) {
						//Setting Gantt view flight puck counter inorder to validate 20 pucks as page refresh interrupts the execution
						if(Flightpuckcounter<20)
						{
							Flightpuckcounter++;
							String elementid = gantelement.getAttribute("id");

							Boolean elementidoriginterm = (elementid.contains("TERMINATED")||elementid.contains("ORIGINATED")||elementid.contains("UNLINKED"));
							if(elementidoriginterm!=true)
							{

								System.out.println("elementidoriginterm   ::  @@@@@ "+elementidoriginterm);
								Actions actions = new Actions(getDriver());
								WebElement elee = findelementbyxpath("//*[@id='"+elementid+"']");

								actions.moveToElement(elee).build().perform();
								actions.moveToElement(elee).build().perform();
								String CompletepuckText = elee.getAttribute("innerText");

								if(CompletepuckText.contains(":"))
								{

									elee.click();
									ATUReports.add("Selected a Puck and Event details page is displayed with flight details for   "+ elementid,  LogAs.PASSED, null); 
									Thread.sleep(10000);

									try
									{

										WebElement Eventdetailscheckpoint = getDriver().findElement(By.xpath("//span[text()='Notes']"));
										ATUReports.add("Event details view is already expanded ",  LogAs.PASSED, null); 

									}catch(Exception Flightdetailsopen)
									{

										clickByXpath("//span[text()='Events/Notes']/ancestor::div[1]/div[1]","Events");
										clickByXpath("//ul[@class='col-xs-12 flt-status ng-scope']/li[1]","flt-status");
										ATUReports.add( "Expanded the evendetails view to see the available reports",  LogAs.PASSED, null); 
									}


								}
								break;	
							}
						}


					}

				}

			}
			catch(Exception Flightdetailsopen)
			{
				System.out.println("Exception Selectapucktovieweventdetails()");
				CommonTest.CheckOKPopupPresentandclose();
				CommonTest.CheckCancelPopupPresentandclose();
				Checkappupdateclosebutton();
			}
		}catch(Exception totalgatesselection){

		}
	}


	public static void Checkreportvalueupdating(String Eventname) throws Exception {

		System.out.println("Verify the user is shown with current event progress "+Eventname+"  Report");

		try{	
			WebElement Evendetailprovided = getDriver().findElement(By.xpath("//span[text()='"+Eventname+"']"));
			ATUReports.add(Eventname+" Report is available and will be selected for further validation",  LogAs.PASSED, null); 
			if(Evendetailprovided!=null)
			{
				String Getprogresscontrol1 = getDriver().findElement(By.xpath("//span[text()='"+Eventname+"']/ancestor::div[1]/span[2]/span[1]")).getAttribute("innerText");
				String Getprogresscontrol2 = getDriver().findElement(By.xpath("//span[text()='"+Eventname+"']/ancestor::div[1]/span[2]/span[2]")).getAttribute("innerText");

				String currentprogress = Getprogresscontrol1.replace("[", "");
				String ToComplete = Getprogresscontrol2;
				String InProgress = currentprogress;
				ATUReports.add(Eventname+" Progressing state  "+InProgress,  LogAs.PASSED, null); 
				ATUReports.add( Eventname+" Event target to complete "+ToComplete,  LogAs.PASSED, null); 
			}


		}catch(Exception Noeventdetail)

		{
			System.out.println(Noeventdetail);

		}


	}


	public static void Selectreport(String Eventname) throws Exception {
		System.out.println("Verify the user is shown with "+Eventname+"  Report");

		try{	
			WebElement Evendetailprovided = getDriver().findElement(By.xpath("//span[text()='"+Eventname+"']"));
			ATUReports.add(Eventname+" Report is available and will be selected for further validation",  LogAs.PASSED, null); 
			if(Evendetailprovided!=null)
			{
				getDriver().findElement(By.xpath("//span[text()='"+Eventname+"']/ancestor::div[@data-ng-repeat='evt in flts.flightEvents']")).click();
				System.out.println("Report selected successfully " +Eventname);
				ATUReports.add("Report selected successfully  "+Eventname,  LogAs.PASSED, null); 
				CommonTest.SpinnerControl();
				Thread.sleep(10000);
			}
			try{
				WebElement Reporttitle = getDriver().findElement(By.xpath("//span[contains(@class,'report') or contains(@class,'report-title') or contains(@class,'title')]"));
				String Reporttitlefetched = Reporttitle.getAttribute("innerText");
				if(Reporttitlefetched!=null)
				{
					System.out.println("Report title fetched is " +Reporttitlefetched);
					ATUReports.add("Report  Displayed  successfully  "+Reporttitlefetched,  LogAs.PASSED, null); 

				}else
				{
					ATUReports.add( "Report Not Displayed  ",  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE)); 
					captureinfoScreenshot(getDriver(), "Report Not Displayed  "+Eventname);
				}

				getDriver().findElement(By.xpath("//span[@data-ng-click='cancel()']")).click();
				Thread.sleep(5000);

				CloseEventdetails();
			}catch(Exception Noreport)
			{
				try{
					WebElement Reporttitle = getDriver().findElement(By.xpath("//p[contains(@class,'title')]"));
					String Reporttitlefetched = Reporttitle.getAttribute("innerText");
					if(Reporttitlefetched!=null)
					{
						System.out.println("Report title fetched is " +Reporttitlefetched);
						ATUReports.add("Report  Displayed  successfully  "+Reporttitlefetched,  LogAs.PASSED, null); 
					}else
					{
						System.out.println("Fail");
						ATUReports.add("Report Not Displayed  ",  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE)); 
					}


					getDriver().findElement(By.xpath("//span[@data-ng-click='cancel()']")).click();
					Thread.sleep(5000);

					CloseEventdetails();
				}catch(Exception Reportnotdisplayed)
				{
					CheckNoreport();
					Closepopup();
					CloseEventdetails();
				}
			}

		}catch(Exception Noeventdetail)

		{

			try{
				CheckNoreport();
				Closepopup();
				CloseEventdetails();
			}catch(Exception secondattemptexception){

				CloseEventdetails();
			}
			System.out.println("Exception");
			CommonTest.CheckOKPopupPresentandclose();
			CommonTest.CheckCancelPopupPresentandclose();
			Checkappupdateclosebutton();
		}




	}




}