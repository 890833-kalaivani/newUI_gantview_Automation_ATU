package get.next.gen.utilities;

import get.next.gen.commonaction.CommonTest;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import get.next.gen.webtestcase.*;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.springframework.core.env.SystemEnvironmentPropertySource;
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



public class PuckUIPlacement extends CommonTest {



	public static void Multiplealerticon() throws Exception {

		// Get the Number of icon present in the Multiple alert

		try{
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

			if(Ganntlistcount == 0)
			{
				ATUReports.add("*****************Gantt List is Zero and hence Exiting test smoothly*******************",  LogAs.PASSED, null);

				captureinfoScreenshot(getDriver(), "PuckUIPlacementListZero");
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
							WebElement Alerticon = gantelement.findElement(By.xpath("puck-lefticons/div/div[1]"));

							if(Alerticon!=null)
							{
								Alerticon.click();
								ATUReports.add("Alert icon is present in the left of the puck",  LogAs.PASSED, null);



							}
							else
							{
								ATUReports.add("Alert icon is Not present in the left of the puck",  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

							}

						}catch(Exception Someissueinmovingbetweenpuck)
						{


						}
					}
				}
			}

		}
		catch(Exception Someissueinmovingbetweenpuck)
		{
			CommonTest.CheckOKPopupPresentandclose();
			CommonTest.CheckCancelPopupPresentandclose();
			Checkappupdateclosebutton();
		}




		// Write a function to check multiple alert icon name and clickable



	}


	public static void updateiconoverleft(String view) throws Exception {
		System.out.println("Verify Swap alert icon are placed over the left");

		try{

			TestcaseInit();
			CommonTest.Selectview(view);

			clickByXpathbyView(view, Web_UI.GateSwaps, Web_UI.HybridGateSwaps);
			Thread.sleep(2000);
			ATUReports.add("Gate Swap stats selected",  LogAs.PASSED, null);

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

			if(Ganntlistcount == 0)
			{
				ATUReports.add("*****************Gantt List is Zero and hence Exiting test smoothly*******************",  LogAs.PASSED, null);

				captureinfoScreenshot(getDriver(), "PuckUIPlacementListZero");
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
							WebElement Alerticon = gantelement.findElement(By.xpath("puck-lefticons[1]"));

							if(Alerticon!=null)
							{
								ATUReports.add("Alert icon is present in the left of the puck",  LogAs.PASSED, null);

							}
							else
							{
								ATUReports.add("Alert icon is Not present in the left of the puck",  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

							}
							if(i==3)
							{
								break;
							}
						}catch(Exception Someissueinmovingbetweenpuck)
						{


						}
					}
				}
			}

		}
		catch(Exception Someissueinmovingbetweenpuck)
		{
			CommonTest.CheckOKPopupPresentandclose();
			CommonTest.CheckCancelPopupPresentandclose();
			Checkappupdateclosebutton();
		}
	}

	public static void ArrivaldetailsExistance(String view) throws Exception {

		System.out.println("Verify the Arrival details are exist in the puck and defined as per the required format");
		//TestcaseInit();
		//CommonTest.Selectview(view);
		try{
			Thread.sleep(1000);
			//clickByXpathbyView(view, Web_UI.TotalGate, Web_UI.HybridAllGate);
			Thread.sleep(2000);
			/*ATUReports.add("TotalGate stats selected",  LogAs.PASSED, null);

			clickByXpath(Web_UI.SortAscending,"SortAscending");
			Thread.sleep(1000);
			// Select Sort Ascending gate by alphabetical order from dropdown
			clickByXpath(Web_UI.SortAscendinggate,"SortAscendinggate");
			Thread.sleep(1000);*/

			List<WebElement> Ganntlist = getDriver().findElements(By.xpath(Web_UI.PuckCompleteArrivaldetails));
			System.out.println("Ganntlist"+Ganntlist);
			int Ganntlistcount = Ganntlist.size();
			if(Ganntlistcount == 0)
			{//commenting below function as of now in new ui need to update this - kalai
				//CommonTest.CheckGanttviewListisnotZero();
			}

			if(Ganntlistcount == 0)
			{
				ATUReports.add(" ",  LogAs.PASSED, null);

				captureinfoScreenshot(getDriver(), "ArrivaldetailsExistanceListZero");
			}else
			{
				if (Ganntlist != null) {

					int i=0;
					for (WebElement gantelement : Ganntlist) {
						i++;

						/*try{
							String idofelement = gantelement.findElement(By.xpath(Web_UI.ancestorid)).getAttribute("id");
							ATUReports.add("Verifying puck with id :: "+idofelement,  LogAs.INFO, null); 

						}catch(Exception id)
						{

						}*/
						try {

							Actions actions = new Actions(getDriver());
							actions.moveToElement(gantelement).build().perform();
							actions.moveToElement(gantelement);
							// Verifying EQtype and Arrival Station
							String  EqtypeandArrivalstation = gantelement.findElement(By.xpath("div")).getAttribute("innerText").trim();
							System.out.println("EqtypeandArrivalstation " + EqtypeandArrivalstation);
							if(EqtypeandArrivalstation.contains("null"))
							{

								ATUReports.add("Arrival Details have null value and Failed "+EqtypeandArrivalstation,  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));


							}
							else
							{
								if(EqtypeandArrivalstation.contains("/")){
									ATUReports.add( "Arrival Details Present in Left of the puck",  LogAs.PASSED, null);

									ATUReports.add("EqType and arrival details seperated by / :: "+EqtypeandArrivalstation,  LogAs.PASSED, null);

								}
							}

							String Eqtypearrivalsplit[] = EqtypeandArrivalstation.split("/");
							try{
								String Eqtypestring = Eqtypearrivalsplit[1].trim();

								int Eqtypelength = Eqtypestring.length();

								System.out.println("Eqtypelength "+Eqtypelength+" Eqtypestring "+Eqtypestring);
								if(Eqtypelength>=4 && Eqtypelength<=6)
								{
									ATUReports.add("EQtype Length is appropriate",  LogAs.PASSED, null);


								}
								else
								{
									ATUReports.add("EQtype Length is Not appropriate :: "+Eqtypearrivalsplit[1],  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

								}

								if(Eqtypelength==0)
								{
									ATUReports.add("EQtype Length is Zero and Eqp Not present",  LogAs.PASSED, null);


								}



							}catch(Exception Someissueinmovingbetweenpuck)
							{

								Checkappupdateclosebutton();	
							}
						}catch(Exception Eqpnotpresent)
						{
							ATUReports.add("EQtype Length is Zero and Eqp Not present :: ",  LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

						}
					}
				}
			}
		}



		catch(Exception Totalgatenotselected){
			ATUReports.add("Couldnot able to select Total gate",  LogAs.INFO, null); 

			CommonTest.CheckOKPopupPresentandclose();
			CommonTest.CheckCancelPopupPresentandclose();
			Checkappupdateclosebutton();

		}


	}


	public static void LinkagedetailsExistance(String view) throws Exception {
		System.out.println("Verify the linkage details present in the puck and defined in required format");

		//TestcaseInit();
		//CommonTest.Selectview(view);
		try{
			/*clickByXpathbyView(view, Web_UI.TotalGate, Web_UI.HybridAllGate);

			Thread.sleep(2000);
			ATUReports.add("TotalGate stats selected",  LogAs.PASSED, null);


			clickByXpath(Web_UI.SortAscending,"SortAscending");
			Thread.sleep(1000);
			// Select Sort Ascending gate by alphabetical order from dropdown
			clickByXpath(Web_UI.SortAscendinggate,"SortAscendinggate");
			Thread.sleep(1000);*/
			Thread.sleep(20000);
			List<WebElement> Ganntlist = getDriver().findElements(By.xpath(Web_UI.PuckCompleteLinkage));
			int Ganntlistcount = Ganntlist.size();
			if(Ganntlistcount == 0)
			{
				//	CommonTest.CheckGanttviewListisnotZero();
			}

			if(Ganntlistcount == 0)
			{
				ATUReports.add("*****************Gantt List is Zero and hence Exiting test smoothly*******************",  LogAs.PASSED, null);

				captureinfoScreenshot(getDriver(), "LinkagedetailsExistanceListZero");
			}else
			{
				if (Ganntlist != null) {

					int i=0;
					for (WebElement gantelement : Ganntlist) {
						i++;


						/*try{
							String idofelement = gantelement.findElement(By.xpath(Web_UI.ancestorid)).getAttribute("id");
							ATUReports.add("Verifying puck with id :: "+idofelement,  LogAs.INFO, null); 

						}catch(Exception id)
						{

						}*/


						try {

							Actions actions = new Actions(getDriver());
							actions.moveToElement(gantelement).build().perform();
							actions.moveToElement(gantelement);
							String Linkage = gantelement.getAttribute("innerText");

							if(gantelement!=null)
							{
								ATUReports.add("Linkage Details present :: "+Linkage,  LogAs.PASSED, null);

								ATUReports.add(Linkage,  LogAs.PASSED, null);

							}
							else{
								ATUReports.add("Linkage Details Not present :: "+Linkage,  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
							}

							if(Linkage.contains("Null")||Linkage.contains("null"))
							{
								ATUReports.add("Linkage Details contains Null value :: "+Linkage,  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

							}else{
								if(Linkage.contains("/"))
								{
									ATUReports.add(" Displayed flight is Turn flight proceeding for further validation :: "+Linkage,  LogAs.PASSED, null);

									String Linkagesplitarray[]=Linkage.split("/");
									int LinkagesplitLength = Linkagesplitarray.length;
									if (LinkagesplitLength==1)
									{
										ATUReports.add("Linkage Details checked have both Arrival and Departure flight number :: "+Linkage,  LogAs.PASSED, null);

										if (Linkage.contains("ORIG")||Linkage.contains("/")||Linkage.contains("TERM")||Linkage.contains("UNL")){

											ATUReports.add("Linkage Details is validated for Split puck functionality :: "+Linkage,  LogAs.PASSED, null);

										}
										else{
											ATUReports.add("Some issue in linkage details :: "+Linkage,  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

										}
									}
								}
								else{

									ATUReports.add("Displayed flight is Through Flight and not splitted with Backslash :: "+Linkage,  LogAs.PASSED, null);

								}
							}
						}catch(Exception Someissueinmovingbetweenpuck)
						{


						}
					}
				}
			}




		}
		catch(Exception Totalgatenotselected){
			ATUReports.add("Couldnot able to select Total gate",  LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE)); 

			CommonTest.CheckOKPopupPresentandclose();
			CommonTest.CheckCancelPopupPresentandclose();
			Checkappupdateclosebutton();
		}


	}

	public static void DeparturedetailsExistance(String view) throws Exception {

		System.out.println("Verify the departure details exist in the puck and defined in required format");
		/*TestcaseInit();
		CommonTest.Selectview(view);*/
		try{

			/*clickByXpathbyView(view, Web_UI.LateArrival, Web_UI.HybridLatearrival);

			Thread.sleep(2000);
			ATUReports.add("TotalGate stats selected",  LogAs.PASSED, null);

			clickByXpath(Web_UI.SortAscending,"SortAscending");
			Thread.sleep(1000);
			// Select Sort Ascending gate by alphabetical order from dropdown
			clickByXpath(Web_UI.SortAscendinggate,"SortAscendinggate");*/
			Thread.sleep(20000);

			List<WebElement> Ganntlist = getDriver().findElements(By.xpath(Web_UI.PuckCompleteDepartureDetails));
			int Ganntlistcount = Ganntlist.size();
			if(Ganntlistcount == 0)
			{
				//CommonTest.CheckGanttviewListisnotZero();
			}

			if(Ganntlistcount == 0)
			{

				ATUReports.add("*****************Gantt List is Zero and hence Exiting test smoothly*******************",  LogAs.PASSED, null);

				captureinfoScreenshot(getDriver(), "DeparturedetailsListZero");

			}else
			{
				if (Ganntlist != null) {

					int i=0;
					for (WebElement gantelement : Ganntlist) {
						i++;


					/*	try{
							String idofelement = gantelement.findElement(By.xpath(Web_UI.ancestorid)).getAttribute("id");
							ATUReports.add("Verifying puck with id :: "+idofelement,  LogAs.PASSED, null);

						}catch(Exception id)
						{

						}*/


						try {

							Actions actions = new Actions(getDriver());
							actions.moveToElement(gantelement).build().perform();
							actions.moveToElement(gantelement);
							String Linkagedetails = gantelement.findElement(By.xpath("div")).getAttribute("innerText");
							System.out.println("Linkagedetails " + Linkagedetails);
							if(Linkagedetails.contains("UNL"))
							{
								ATUReports.add("Unlinked puck and hence skipping the validation for this puck "+Linkagedetails,  LogAs.PASSED, null);
							}
							else{
								if(gantelement!=null)
								{

									ATUReports.add("Departure Details present in the Puck No "+i,  LogAs.PASSED, null);


								}
								else
								{
									ATUReports.add( "Departure Details Not present in the Puck No "+i,  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

									captureinfoScreenshot(getDriver(), "Departure Details Not present in the Puck No "+i);
								}

								String DepartureStation = gantelement.findElement(By.xpath("div")).getAttribute("innerText").replace("/", "").trim();
								String DepartureText = gantelement.getAttribute("innerText").trim();
								int DepartureStationlength = DepartureStation.length();
								System.out.println(DepartureText+"  "+DepartureStationlength);
								if(DepartureStationlength<4)
								{
									ATUReports.add("Departure station shown top right cornor of the puck "+DepartureStation,  LogAs.PASSED, null);

									ATUReports.add("Destination is displayed in 3 character "+DepartureStation,  LogAs.PASSED, null);

								}
								else
								{

									ATUReports.add("Destination is displayed in 3 character  for the puck:: "+DepartureStation,  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

									captureinfoScreenshot(getDriver(), "Destination is displayed in 3 character  for the puck:: "+DepartureStation);
								}

								if(DepartureText.contains("/"))
								{


									ATUReports.add("Tail and Destination is seperated by / for the puck:: "+DepartureStation,  LogAs.PASSED, null);

								}
								else
								{
									ATUReports.add("Tail and Destination is Not seperated by / for the puck:: "+DepartureStation,  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

									captureinfoScreenshot(getDriver(),  "Tail and Destination is Not seperated by / for the puck:: "+DepartureStation);
								}

							}

						}catch(Exception Someissueinmovingbetweenpuck)
						{


						}
					}
				}
			}



		}
		catch(Exception Totalgatenotselected){
			ATUReports.add("Couldnot able to select Total gate",  LogAs.PASSED, null);

			captureinfoScreenshot(getDriver(), "DeparturedetailsExistanceListZero");
			CommonTest.CheckOKPopupPresentandclose();
			CommonTest.CheckCancelPopupPresentandclose();
			Checkappupdateclosebutton();
		}	





	}

	public static void ArrivalstatusValidation(String view) throws Exception {


		System.out.println("Verify the arrival status present and defined in required format");
		/*TestcaseInit();
		CommonTest.Selectview(view);*/
		try{
			clickByXpathbyView(view, Web_UI.TotalGate, Web_UI.HybridAllGate);

			Thread.sleep(2000);
			ATUReports.add("TotalGate stats selected",  LogAs.PASSED, null);


			clickByXpath(Web_UI.SortAscending,"SortAscending");
			Thread.sleep(1000);
			// Select Sort Ascending gate by alphabetical order from dropdown
			clickByXpath(Web_UI.SortAscendinggate,"SortAscendinggate");
			Thread.sleep(1000);
			List<WebElement> Ganntlist = getDriver().findElements(By.xpath(Web_UI.PuckArrivaltimeandstatus));
			int Ganntlistcount = Ganntlist.size();
			if(Ganntlistcount == 0)
			{
				CommonTest.CheckGanttviewListisnotZero();
			}

			if(Ganntlistcount == 0)
			{
				ATUReports.add("*****************Gantt List is Zero and hence Exiting test smoothly*******************",  LogAs.PASSED, null);

				captureinfoScreenshot(getDriver(), "ArrivalstatusValidationListZero");
			}else
			{
				if (Ganntlist != null) {

					int i=0;
					for (WebElement gantelement : Ganntlist) {
						i++;

						try{
							String idofelement = gantelement.findElement(By.xpath(Web_UI.ancestorid)).getAttribute("id");
							ATUReports.add("Verifying puck with id :: "+idofelement,  LogAs.INFO, null); 

						}catch(Exception id)
						{

						}

						try {

							Actions actions = new Actions(getDriver());
							actions.moveToElement(gantelement).build().perform();
							actions.moveToElement(gantelement);

							if(gantelement!=null)
							{

								ATUReports.add("Arrival Time and Arrival Status present in the puck No "+i,  LogAs.PASSED, null);


							}
							else
							{
								ATUReports.add("Arrival Time and Arrival Status is not present in the puck No "+i,  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

								captureinfoScreenshot(getDriver(),"Arrival Time and Arrival Status is not present in the puck No "+i);
							}

							String Arrivalstationdetailscomplete = gantelement.getAttribute("innerText");
							String arrivalstationsplit[] = Arrivalstationdetailscomplete.split(" ");
							String ArrivalStatus = arrivalstationsplit[0].trim();
							int ArrivalStatusLength = ArrivalStatus.length();
							List<String> Arrivalcodelist = Arrays.asList("CHO","SKD","HLD","PRE","DCN","ETA","OFF","ON","IN","CXL","RTD");
							boolean contains = Arrivalcodelist.contains(ArrivalStatus);


							if(contains == true )
							{
								ATUReports.add("Arrival status is displayed correctly  "+"  "+ArrivalStatus,  LogAs.PASSED, null);




							} else {

								ATUReports.add("Arrival status is Not displayed correctly  "+"  "+ArrivalStatus,  LogAs.PASSED, null);

								System.out.println("Arrival status is Not displayed correctly   "+i);
								captureinfoScreenshot(getDriver(),"Arrival status is Not displayed correctly   "+i);
							}
						}catch(Exception Someissueinmovingbetweenpuck)
						{


						}
					}
				}
			}





		}
		catch(Exception Totalgatenotselected){
			ATUReports.add("Couldnot able to select Total gate",  LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE)); 
			CommonTest.CheckOKPopupPresentandclose();
			CommonTest.CheckCancelPopupPresentandclose();
			Checkappupdateclosebutton();
		}





	}


	public static void DeparturestatusValidation(String view) throws Exception {

		System.out.println("Verify the departure status exist in the puck and defined in required format");
		TestcaseInit();
		CommonTest.Selectview(view);
		try{
			clickByXpathbyView(view, Web_UI.LateArrival, Web_UI.HybridLatearrival);
			Thread.sleep(2000);
			ATUReports.add("TotalGate stats selected",  LogAs.PASSED, null);
			clickByXpath(Web_UI.SortAscending,"SortAscending");
			Thread.sleep(1000);
			// Select Sort Ascending gate by alphabetical order from dropdown
			clickByXpath(Web_UI.SortAscendinggate,"SortAscendinggate");
			Thread.sleep(1000);
			List<WebElement> Ganntlist = getDriver().findElements(By.xpath(Web_UI.PuckDepartureStatusandtime));
			int Ganntlistcount = Ganntlist.size();

			if(Ganntlistcount == 0)
			{
				CommonTest.CheckGanttviewListisnotZero();
			}

			if(Ganntlistcount == 0)
			{
				ATUReports.add("*****************Gantt List is Zero and hence Exiting test smoothly*******************",  LogAs.PASSED, null);
				captureinfoScreenshot(getDriver(), "DeparturestatusValidationListZero");
			}else
			{
				if (Ganntlist != null) {

					int i=0;
					for (WebElement gantelement : Ganntlist) {
						i++;


						try{
							String idofelement = gantelement.findElement(By.xpath("ancestor::div[1]/ancestor::div[1]/ancestor::div[1]")).getAttribute("id");
							ATUReports.add("Verifying puck with id :: "+idofelement,  LogAs.INFO, null); 

						}catch(Exception id)
						{

						}
						try {

							Actions actions = new Actions(getDriver());
							actions.moveToElement(gantelement).build().perform();
							actions.moveToElement(gantelement);

							String Linkagedetails = gantelement.findElement(By.xpath("ancestor::div[1]/ancestor::div[1]/div[2]")).getAttribute("innerText");
							if(Linkagedetails.contains("UNL")){
								ATUReports.add("Unlinked flight and hence skipping the validation for this puck "+i,  LogAs.PASSED, null);
							}else{


								if(gantelement!=null)
								{

									ATUReports.add("Departure Time and Departure Status present in the puck No "+i,  LogAs.PASSED, null);

								}
								else
								{
									ATUReports.add("Departure Time and Departure Status is not present in the puck No "+i,  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								}

								String Arrivalstationdetailscomplete = gantelement.getAttribute("innerText");
								String arrivalstationsplit[] = Arrivalstationdetailscomplete.split(" ");
								String ArrivalStatus = arrivalstationsplit[0].trim();

								List<String> Arrivalcodelist = Arrays.asList("SKD","HLD","DCN","ETD","OFF","OUT","CXL","RTD");
								boolean contains = Arrivalcodelist.contains(ArrivalStatus);


								if(contains == true )
								{
									ATUReports.add("Departure status is displayed correctly  "+"  "+ArrivalStatus,  LogAs.PASSED, null);


								} else {

									ATUReports.add("Departure status is Not displayed correctly  "+"  "+ArrivalStatus,  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									System.out.println("Departure status is Not displayed correctly   "+i);

								}

							}



						}catch(Exception Someissueinmovingbetweenpuck)
						{

						}
					}
				}
			}



		}
		catch(Exception Totalgatenotselected){
			ATUReports.add("Couldnot able to select Total gate",  LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE)); 
			CommonTest.CheckOKPopupPresentandclose();
			CommonTest.CheckCancelPopupPresentandclose();
			Checkappupdateclosebutton();
		}	

	}



	public static void TurnflightLinkageValidation(String view) throws Exception {

		System.out.println("Verify the linkage information for Turn flights");
		TestcaseInit();
		CommonTest.Selectview(view);
		try{
			clickByXpathbyView(view, Web_UI.TotalGate, Web_UI.HybridAllGate);

			Thread.sleep(2000);
			ATUReports.add("TotalGate stats selected",  LogAs.PASSED, null);
			clickByXpath(Web_UI.SortAscending,"SortAscending");
			Thread.sleep(1000);
			clickByXpath(Web_UI.SortAscendinggate,"SortAscendinggate");
			Thread.sleep(1000);
			List<WebElement> Ganntlist = getDriver().findElements(By.xpath(Web_UI.PuckCompleteLinkage));
			int Ganntlistcount = Ganntlist.size();

			if(Ganntlistcount == 0)
			{
				CommonTest.CheckGanttviewListisnotZero();
			}
			if(Ganntlistcount == 0)
			{
				ATUReports.add("*****************Gantt List is Zero and hence Exiting test smoothly*******************",  LogAs.PASSED, null);
				captureinfoScreenshot(getDriver(), "TurnflightLinkageValidationListZero");
			}else
			{
				if (Ganntlist != null) {

					int i=0;
					for (WebElement gantelement : Ganntlist) {
						i++;

						try{
							String idofelement = gantelement.findElement(By.xpath("ancestor::div[1]/ancestor::div[1]")).getAttribute("id");
							ATUReports.add("Verifying puck with id :: "+idofelement,  LogAs.INFO, null); 
						}catch(Exception id)
						{

						}

						try {

							Actions actions = new Actions(getDriver());
							actions.moveToElement(gantelement).build().perform();
							actions.moveToElement(gantelement);
							//ADD SOME MORE for taking flight no arrival and departure

							if(gantelement!=null)
							{

								ATUReports.add("Linkage details exist for the puck"+i,  LogAs.PASSED, null);

							}
							else
							{
								ATUReports.add( "Issues with linkage details "+i,  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								captureinfoScreenshot(getDriver(), "Issues with linkage details "+i);
							}

							String Linkage = gantelement.getAttribute("innerText");

							if(Linkage.contains("/") )
							{
								ATUReports.add("Turn flight is seperated by backslash  "+"  "+Linkage,  LogAs.PASSED, null);

							} else {
								if(Linkage.length()<6){
									ATUReports.add("Not turn flight  "+"  "+Linkage,  LogAs.PASSED, null);
								}
								else{
									if(Linkage.contains("DIV")){
										ATUReports.add("Its diverted flight and displayed correctly  "+"  "+Linkage,  LogAs.PASSED, null);
									}else{
										ATUReports.add("Linkage detail issue  "+"  "+Linkage,  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
										captureinfoScreenshot(getDriver(), "Linkage detail issue "+"  "+Linkage);
									}
								}
							}





						}catch(Exception Someissueinmovingbetweenpuck)
						{

						}
					}
				}
			}



		}
		catch(Exception Totalgatenotselected){
			ATUReports.add("Couldnot able to select Total gate",  LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE)); 
			CommonTest.CheckOKPopupPresentandclose();
			CommonTest.CheckCancelPopupPresentandclose();
			Checkappupdateclosebutton();
		}	



	}


	public static void ArrivalDepartureTimeformatFormat(String view) throws Exception {

		System.out.println("Verify the time format for Arrival and departure are displayed in required format");
		TestcaseInit();
		CommonTest.Selectview(view);

		try{
			clickByXpathbyView(view, Web_UI.TotalGate, Web_UI.HybridAllGate);

			Thread.sleep(2000);
			ATUReports.add( "TotalGate stats selected",  LogAs.PASSED, null);

			List<WebElement> Ganntlist = getDriver().findElements(By.xpath(Web_UI.PuckDepartureStatusandtime));
			int Ganntlistcount = Ganntlist.size();

			if(Ganntlistcount == 0)
			{
				CommonTest.CheckGanttviewListisnotZero();
			}
			if(Ganntlistcount == 0)
			{
				ATUReports.add("*****************Gantt List is Zero and hence Exiting test smoothly*******************",  LogAs.PASSED, null);
				captureinfoScreenshot(getDriver(), "ArrivalDepartureTimeformatValidationListZero");
			}else
			{
				if (Ganntlist != null) {

					int i=0;
					for (WebElement gantelement : Ganntlist) {
						i++;

						try{
							String idofelement = gantelement.findElement(By.xpath("ancestor::div[1]/ancestor::div[1]/ancestor::div[1]")).getAttribute("id");
							ATUReports.add("Verifying puck with id :: "+idofelement,  LogAs.INFO, null); 
						}catch(Exception id)
						{

						}

						try {

							Actions actions = new Actions(getDriver());
							actions.moveToElement(gantelement).build().perform();
							actions.moveToElement(gantelement);

							if(gantelement!=null)
							{

								ATUReports.add("Departure Time and Departure Status present in the puck No "+i,  LogAs.PASSED, null);
							}
							else
							{
								ATUReports.add("Departure Time and Departure Status is not present in the puck No  "+i,  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
							}

							String Arrivalstationdetailscomplete = gantelement.getAttribute("innerText");
							String arrivalstationsplit[] = Arrivalstationdetailscomplete.split(" ");
							String ArrivalStatus = arrivalstationsplit[0].trim();
							String Departuretime = arrivalstationsplit[1].trim();
							if(Departuretime.contains("/")){

								String	Departuretimewithdate[] = Departuretime.split("/");
								String Departuretimewithoutdate = Departuretimewithdate[0].trim();
								boolean Timevalidated = CommonTest.timevalidatior(Departuretimewithoutdate);
								if(Timevalidated==true)
								{
									ATUReports.add("Departure Time Validated for 24hours format "+Departuretimewithoutdate,  LogAs.PASSED, null);
								}
								else{
									ATUReports.add("Departure Time Validated for 24hours format and issue identified "+Departuretimewithoutdate,  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								}
							}
							else{
								boolean Timevalidated = CommonTest.timevalidatior(Departuretime);
								if(Timevalidated==true)
								{

									ATUReports.add("Departure Time Validated for 24hours format "+Departuretime,  LogAs.PASSED, null);
								}									else{
									ATUReports.add("Departure Time Validated for 24hours format and issue identified "+Departuretime,  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								}
							}
						}catch(Exception Someissueinmovingbetweenpuck1)
						{

						}

					}
				}
			}			List<WebElement> Ganntlist2 = getDriver().findElements(By.xpath(Web_UI.PuckArrivaltimeandstatus));
			int Ganntlistcount2 = Ganntlist2.size();
			if(Ganntlistcount2 == 0)
			{
				ATUReports.add("*****************Gantt List is Zero and hence Exiting test smoothly*******************",  LogAs.PASSED, null);
			}else
			{
				if (Ganntlist2 != null) {

					int ii=0;
					for (WebElement gantelement1 : Ganntlist2) {
						ii++;

						try{
							String idofelement = gantelement1.findElement(By.xpath("ancestor::div[1]/ancestor::div[1]/ancestor::div[1]")).getAttribute("id");
							ATUReports.add("Verifying puck with id :: "+idofelement,  LogAs.INFO, null); 
						}catch(Exception id)
						{

						}

						try {

							Actions actions = new Actions(getDriver());
							actions.moveToElement(gantelement1).build().perform();
							actions.moveToElement(gantelement1);

							if(gantelement1!=null)
							{

								ATUReports.add("Arrival Time and Arrival Status present in the puck No "+ii,  LogAs.PASSED, null);
							}
							else
							{
								ATUReports.add("Arrival Time and Arrival Status is not present in the puck No "+ii,  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
							}

							String Arrivalstationdetailscomplete1 = gantelement1.getAttribute("innerText");
							String arrivalstationsplit1[] = Arrivalstationdetailscomplete1.split(" ");
							String ArrivalStatus1 = arrivalstationsplit1[0].trim();
							String Departuretime1 = arrivalstationsplit1[1].trim();
							if(Departuretime1.contains("/")){

								String	Departuretimewithdate1[] = Departuretime1.split("/");
								String Departuretimewithoutdate1 = Departuretimewithdate1[0].trim();
								boolean Timevalidated1 = CommonTest.timevalidatior(Departuretimewithoutdate1);
								if(Timevalidated1==true)
								{
									ATUReports.add("Arrival Time Validated for 24hours format "+Timevalidated1,  LogAs.PASSED, null);
								}
								else{
									ATUReports.add("Arrival Time Validated for 24hours format and issue identified "+Timevalidated1,  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								}
							}
							else{
								boolean Timevalidated1 = CommonTest.timevalidatior(Departuretime1);
								if(Timevalidated1==true)
								{

									ATUReports.add("Arrival Time Validated for 24hours format "+Timevalidated1,  LogAs.PASSED, null);
								}
								else{
									ATUReports.add("Arrival Time Validated for 24hours format and issue identified "+Timevalidated1,  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								}
							}




						}


						catch(Exception Someissueinmovingbetweenpuck)
						{

						}
					}
				}
			}



		}
		catch(Exception Totalgatenotselected){
			ATUReports.add("Couldnot able to select Total gate",  LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE)); 
			CommonTest.CheckOKPopupPresentandclose();
			CommonTest.CheckCancelPopupPresentandclose();
			Checkappupdateclosebutton();
		}	



	}


	public static void DeviationValidation(String view) throws Exception {

		System.out.println("Verify the deviation details are displayed in required format");
		TestcaseInit();
		CommonTest.Selectview(view);
		try{
			clickByXpathbyView(view, Web_UI.LateArrival, Web_UI.HybridLatearrival);
			Thread.sleep(2000);
			ATUReports.add("LateArrival stats selected",  LogAs.PASSED, null);
			clickByXpath(Web_UI.SortAscending,"SortAscending");
			Thread.sleep(1000);
			clickByXpath(Web_UI.SortAscendinggate,"SortAscendinggate");
			Thread.sleep(1000);

			List<WebElement> Ganntlist = getDriver().findElements(By.xpath(Web_UI.PuckComplete));
			int Ganntlistcount = Ganntlist.size();
			if(Ganntlistcount == 0)
			{
				CommonTest.CheckGanttviewListisnotZero();
			}
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

					String Arrivaldetailscomplete = gantelement.findElement(By.xpath("div[4]/div[1]")).getAttribute("innerText");
					String Departuredetailscomplete = gantelement.findElement(By.xpath("div[4]/div[3]")).getAttribute("innerText");

					if(Arrivaldetailscomplete.contains("L")||Departuredetailscomplete.contains("L"))
					{
						ATUReports.add(" Late Arrival Deviation details is found and validated ",  LogAs.PASSED, null);
					}
					else
					{
						ATUReports.add(" Late Arrival Deviation details is Not present ",  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}
				}catch(Exception Someissueinmovingbetweenpuck)
				{

				}		


			}
		}
		catch(Exception Totalgatenotselected){
			ATUReports.add("Couldnot able to select LateArrival Stats",  LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE)); 
			CommonTest.CheckOKPopupPresentandclose();
			CommonTest.CheckCancelPopupPresentandclose();
			Checkappupdateclosebutton();
		}
		try{
			clickByXpathbyView(view, Web_UI.EarlyArrival, Web_UI.HybridEarlyarrival);
			List<WebElement> Ganntlist1 = getDriver().findElements(By.xpath(Web_UI.PuckComplete));
			int i=0;
			for (WebElement gantelement : Ganntlist1) {
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

					String Arrivaldetailscomplete = gantelement.findElement(By.xpath("div[4]/div[1]")).getAttribute("innerText");
					String Departuredetailscomplete = gantelement.findElement(By.xpath("div[4]/div[3]")).getAttribute("innerText");

					if(Arrivaldetailscomplete.contains("E")||Departuredetailscomplete.contains("E"))
					{
						ATUReports.add("Early arrrival Deviation details is found and validated ",  LogAs.PASSED, null);
					}
					else
					{
						ATUReports.add("Early arrrival Deviation details is Not present ",  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}
				}catch(Exception Someissueinmovingbetweenpuck)
				{

				}		


			}
		}
		catch(Exception Totalgatenotselected){
			ATUReports.add("Couldnot able to select EarlyArrival Stats",  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			CommonTest.CheckOKPopupPresentandclose();
			CommonTest.CheckCancelPopupPresentandclose();
			Checkappupdateclosebutton();
		}	




	}






	public static void DeviationnotPresent(String view) throws Exception {


		System.out.println("Verify blank if deviation is not present for arrival and departure");
		TestcaseInit();
		CommonTest.Selectview(view);

		try{
			clickByXpathbyView(view, Web_UI.TotalGate, Web_UI.HybridAllGate);

			Thread.sleep(2000);
			ATUReports.add("TotalGate stats selected",  LogAs.PASSED, null);
			clickByXpath(Web_UI.SortAscending,"SortAscending");
			Thread.sleep(1000);
			clickByXpath(Web_UI.SortAscendinggate,"SortAscendinggate");
			Thread.sleep(1000);

			List<WebElement> Ganntlist = getDriver().findElements(By.xpath(Web_UI.PuckComplete));
			int Ganntlistcount = Ganntlist.size();
			if(Ganntlistcount == 0)
			{
				CommonTest.CheckGanttviewListisnotZero();
			}

			if(Ganntlistcount == 0)
			{
				ATUReports.add("*****************Gantt List is Zero and hence Exiting test smoothly*******************",  LogAs.PASSED, null);
				captureinfoScreenshot(getDriver(), "DeviationValidationListZero");
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

							try {
								String Arrivaldetailscomplete = gantelement.findElement(By.xpath("div[4]/div[1]")).getAttribute("innerText");

							}catch(Exception nodeviationforarrival)
							{

								ATUReports.add("Arrival Deviation is not present as flight is on time and field is kept blank",  LogAs.PASSED, null);
							}
							try {
								String Departuredetailscomplete = gantelement.findElement(By.xpath("div[4]/div[3]")).getAttribute("innerText");
							}
							catch(Exception nodeviationfordeparture)
							{
								ATUReports.add("Departure Deviation is not present as flight is on time and field is kept blank ",  LogAs.PASSED, null);
							}

						}catch(Exception Someissueinmovingbetweenpuck)
						{

						}		


					}





				}
			}

		}
		catch(Exception Totalgatenotselected){
			ATUReports.add("Couldnot able to select TotalGate Stats",  LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE)); 
			CommonTest.CheckOKPopupPresentandclose();
			CommonTest.CheckCancelPopupPresentandclose();
			Checkappupdateclosebutton();
		}


	}





	public static void Deviationlessthan999(String view) throws Exception {

		System.out.println("Verify the deviation details displayed are not more than 999");
		TestcaseInit();
		CommonTest.Selectview(view);
		try{
			clickByXpathbyView(view, Web_UI.TotalGate, Web_UI.HybridAllGate);


			CommonTest.zoomindata();
			CommonTest.zoomindata();
			CommonTest.zoomindata();
			Thread.sleep(2000);
			ATUReports.add("TotalGate stats selected",  LogAs.PASSED, null);
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

			if(Ganntlistcount == 0)
			{
				ATUReports.add("*****************Gantt List is Zero and hence Exiting test smoothly*******************",  LogAs.PASSED, null);
				captureinfoScreenshot(getDriver(), "Deviationlessthan999ListZero");
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

							String Arrivalstationdetailscomplete = gantelement.findElement(By.xpath("div[contains(@class,'puck-contnt')]/div[1]/span[2]")).getAttribute("innerText");
							String Departurestationdetailscomplete = gantelement.findElement(By.xpath("div[contains(@class,'puck-contnt')]/div[3]/span[2]")).getAttribute("innerText");

							String ArrivalSplit[] = Arrivalstationdetailscomplete.split(" ");
							String DepartureSplit[] = Departurestationdetailscomplete.split(" ");
							int Arrivallength = ArrivalSplit.length;
							int Departurelength = DepartureSplit.length;
							if(Arrivallength==3)
							{
								String ArrivalDeviation = ArrivalSplit[2].trim();
								int ArrivalDeviationlength = ArrivalDeviation.length();
								if(ArrivalDeviationlength<=4)
								{
									ATUReports.add("Arrival Deviation is less than 999 ",  LogAs.PASSED, null);
								}
								else{
									ATUReports.add("Arrival Deviation is not less than 999 "+Arrivalstationdetailscomplete,  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									captureinfoScreenshot(getDriver(), "Arrival Deviation is not less than 999 "+ArrivalDeviation);
								}
							}

							if(Departurelength==3)
							{

								String DepartureDeviation = DepartureSplit[2].trim();
								int  DepartureDeviationlength = DepartureDeviation.length();
								if( DepartureDeviationlength<=4)
								{
									ATUReports.add("Departure Deviation is less than 999",  LogAs.PASSED, null);
								}
								else{
									ATUReports.add("Arrival Deviation is not less than 999 "+Departurestationdetailscomplete,  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									captureinfoScreenshot(getDriver(), "Departure Deviation is less than 999 "+DepartureDeviation);
								}
							}




						}catch(Exception Someissueinmovingbetweenpuck)
						{

						}
					}
				}
			}






		}
		catch(Exception Totalgatenotselected){
			ATUReports.add("Couldnot able to select Total gate",  LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE)); 
			CommonTest.CheckOKPopupPresentandclose();
			CommonTest.CheckCancelPopupPresentandclose();
			Checkappupdateclosebutton();
		}



	}






	// Zoom Out in Gantt view
	public static void ConfirmzoomOut() throws InterruptedException, IOException {

		List<WebElement> Ganntlist = getDriver().findElements(By.xpath(Web_UI.PuckComplete));
		int Ganntlistcount = Ganntlist.size();
		if(Ganntlistcount == 0)
		{
			ATUReports.add("*****************Gantt List is Zero and hence Exiting test smoothly*******************",  LogAs.PASSED, null);

		}else
		{
			if (Ganntlist != null) {

				int i=0;
				for (WebElement gantelement : Ganntlist) {
					i++;

					try{
						String idofelement = gantelement.getAttribute("id");
						ATUReports.add("Verifying puck with id :: "+idofelement,  LogAs.INFO, null); 
						Actions actions = new Actions(getDriver());
						actions.moveToElement(gantelement).build().perform();
						actions.moveToElement(gantelement);
						Thread.sleep(1000);
						String Sizeofpuck = gantelement.getAttribute("clientWidth").trim();
						int Sizeofpuckvalue1 = Integer.parseInt(Sizeofpuck);
						CommonTest.zoomOut();
						Thread.sleep(1000);
						String Sizeofpuck2 = gantelement.getAttribute("clientWidth").trim();
						int Sizeofpuckvalue2 = Integer.parseInt(Sizeofpuck2);
						if(Sizeofpuckvalue2<Sizeofpuckvalue1){
							ATUReports.add("Size of the puck is reduced and validated upon clicking Zoomout option ", LogAs.PASSED, null); 
						}else{
							ATUReports.add("Size of the puck is Not reduced  upon clicking Zoomout option ", LogAs.FAILED, null); 
						}
					}catch(Exception Someissueinmovingbetweenpuck)
					{

					}
					break;
				}
			}
		}

	}




	public static void Confirmzoomin() throws InterruptedException, IOException {

		List<WebElement> Ganntlist = getDriver().findElements(By.xpath(Web_UI.PuckComplete));
		int Ganntlistcount = Ganntlist.size();
		if(Ganntlistcount == 0)
		{
			ATUReports.add("*****************Gantt List is Zero and hence Exiting test smoothly*******************",  LogAs.PASSED, null);

		}else
		{
			if (Ganntlist != null) {

				int i=0;
				for (WebElement gantelement : Ganntlist) {
					i++;

					try{
						String idofelement = gantelement.getAttribute("id");
						ATUReports.add("Verifying puck with id :: "+idofelement,  LogAs.INFO, null); 
						Actions actions = new Actions(getDriver());
						actions.moveToElement(gantelement).build().perform();
						actions.moveToElement(gantelement);
						Thread.sleep(1000);
						String Sizeofpuck = gantelement.getAttribute("clientWidth").trim();
						int Sizeofpuckvalue1 = Integer.parseInt(Sizeofpuck);
						CommonTest.zoomin();
						Thread.sleep(1000);
						String Sizeofpuck2 = gantelement.getAttribute("clientWidth").trim();
						int Sizeofpuckvalue2 = Integer.parseInt(Sizeofpuck2);
						if(Sizeofpuckvalue2>Sizeofpuckvalue1){
							ATUReports.add("Size of the puck is increased and validated upon clicking Zoomin option ", LogAs.PASSED, null); 
						}else{
							ATUReports.add("Size of the puck is Not Increased  upon clicking Zoomin option ", LogAs.FAILED, null); 
						}
					}catch(Exception Someissueinmovingbetweenpuck)
					{

					}
					break;
				}
			}
		}

	}						


	public static void FittoScreen() throws Exception {
		CommonTest.SpinnerControl();
		TestcaseInit();
		try{
			clickByXpath(Web_UI.LateArrival,"LateArrival");

			clickByXpath("//img[@src='./resources/images/gantt_fitt_blue_icon.svg']","gantt_fitt_blue icon");
			Thread.sleep(3000);
			Actions actions = new Actions(getDriver());
			WebElement elee = getDriver().findElement(By.xpath("//img[@src='./resources/images/gantt_fitt_blue_icon.svg']"));
			actions.moveToElement(elee).build().perform();
			actions.moveToElement(elee).build().perform();

			String Mouseoverfit = getDriver().findElement(By.xpath("//div[@class='tooltip-inner ng-binding']")).getAttribute("innerText");
			if(Mouseoverfit.contains("Fit to Screen - Sets gate row height & font to maximize number of visible gates. For ideal performance, choose less than 30 gates"))
			{

				ATUReports.add( "Mouseover text matches",  LogAs.PASSED, null);
			}
			else{
				ATUReports.add("Mouseover text Doesnt matches  "+Mouseoverfit,  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}



			List<WebElement> Ganntlist = getDriver().findElements(By.xpath("//div[@data-ng-repeat='(key, flt) in ganttObject[gate]']"));
			int Ganntlistcount = Ganntlist.size();
			if(Ganntlistcount == 0)
			{
				CommonTest.CheckGanttviewListisnotZero();

			}


			if(Ganntlistcount == 0)
			{
				ATUReports.add("**********************************Gantt List is Zero and hence Exiting test smoothly**************************************",  LogAs.INFO, null);

			}else
			{
				if (Ganntlist != null) {
					ATUReports.add( "Gantt List is displayed with Fitto screen functionality and Puck displayed are  ::"+Ganntlistcount,  LogAs.PASSED, null);

				}

			}


		}
		catch(Exception EE){


		}
		CheckCollapse();
	}


	public static void Guidelines() throws Exception {
		TestcaseInit();
		CommonTest.SpinnerControl();
		TestcaseInit();
		clickByXpath(Web_UI.filtericon,"openFilter");
		Thread.sleep(3000);
		ATUReports.add("Selected Dashboard filter icon",  LogAs.PASSED, null);
		clickByXpath(Web_UI.ViewSettings,"View Settings");
		Thread.sleep(3000);
		ATUReports.add("Selected View Settings tab",  LogAs.PASSED, null);


		try{

			WebElement Guidlineoption = getDriver().findElement(By.xpath(Web_UI.Guidelineoption));
			boolean guidelineselected = Guidlineoption.isSelected();
			if(guidelineselected==true)
			{
				ATUReports.add("Already Selected Guidelines option from  settings",  LogAs.PASSED, null);
			}else{
				Guidlineoption.click();
				ATUReports.add(" Selected Guidelines option from  settings",  LogAs.PASSED, null);
			}

			Thread.sleep(2000);
			ATUReports.add("Selected Guidelines option from  settings",  LogAs.PASSED, null);
		}
		catch(Exception onemoreattempt)
		{
			ATUReports.add(" Issue with selecting guideline option from view settings ",  LogAs.FAILED, null);

		}
		clickByXpath("//span[text()='Apply']","Apply");
		Thread.sleep(8000);
		CommonTest.SpinnerControl();
		ATUReports.add("Selected Apply button in dasboard filter",  LogAs.PASSED, null);
		Thread.sleep(8000);


		//Verify the guidelines displayed is valid
		CommonTest.zoomindata();
		CommonTest.zoomindata();
		CommonTest.zoomindata();
		CommonTest.zoomindata();
		Thread.sleep(3000);
		try{
			List<WebElement> Guideline = 	 getDriver().findElements(By.xpath(Web_UI.Guidelineoption));
			if(Guideline!=null)
			{
				ATUReports.add("Guidelines displayed properly",  LogAs.PASSED, null);
			}
			else
			{
				ATUReports.add("Guidelines not displayed properly",  LogAs.FAILED, null);
			}
		}catch(Exception ee){
			ATUReports.add("Guidelines not displayed properly",  LogAs.FAILED, null);
		}


		CommonTest.zoomOutdata();
		CommonTest.zoomOutdata();

	}

	public static void DonotshowGuidelines() throws Exception {

		CommonTest.SpinnerControl();
		TestcaseInit();
		clickByXpath(Web_UI.filtericon,"openFilter");
		Thread.sleep(3000);
		ATUReports.add("Selected Dashboard filter icon",  LogAs.PASSED, null);
		clickByXpath(Web_UI.ViewSettings,"View Settings");
		Thread.sleep(3000);
		ATUReports.add("Selected View Settings tab",  LogAs.PASSED, null);


		try{

			WebElement Guidlineoption = getDriver().findElement(By.xpath(Web_UI.Guidelineoption));
			boolean guidelineselected = Guidlineoption.isSelected();
			if(guidelineselected==true)
			{
				Guidlineoption.click();
				ATUReports.add("Guidelines option Unselected",  LogAs.PASSED, null);
			}else{

				ATUReports.add(" Already Guidelines option Selected",  LogAs.PASSED, null);
			}

			Thread.sleep(2000);
			ATUReports.add("Selected Guidelines option from  settings",  LogAs.PASSED, null);
		}
		catch(Exception onemoreattempt)
		{
			ATUReports.add(" Issue with selecting guideline option from view settings ",  LogAs.FAILED, null);

		}
		clickByXpath(Web_UI.ApplyButton,"Apply");
		Thread.sleep(8000);
		CommonTest.SpinnerControl();
		ATUReports.add("Selected Apply button in dasboard filter",  LogAs.PASSED, null);
		Thread.sleep(8000);


		//Verify the guidelines displayed is valid
		CommonTest.zoomindata();
		CommonTest.zoomindata();
		CommonTest.zoomindata();
		CommonTest.zoomindata();
		Thread.sleep(3000);
		List<WebElement> Hours = getDriver().findElements(By.xpath("//div[@data-ng-repeat='n in range']"));
		int HoursCount = Hours.size();
		System.out.println("Hours Displayed is "+HoursCount);
		CommonTest.SpinnerControl();

		try{
			List<WebElement> Guideline = 	 getDriver().findElement(By.xpath("//div[@class='guideline-bar ng-scope']"));
			if(Guideline!=null)
			{
				ATUReports.add("Guidelines displayed upon unselecting Guideline option",  LogAs.FAILED, null);
			}
			else
			{
				ATUReports.add("Guidelines not displayed upon unselecting guideline option",  LogAs.PASSED, null);
			}
		}catch(Exception Guidelinenotpresent){
			ATUReports.add("Guidelines not displayed upon unselecting guideline option",  LogAs.PASSED, null);
		}


		CommonTest.zoomOutdata();
		CommonTest.zoomOutdata();
		CommonTest.zoomOutdata();
		CommonTest.zoomOutdata();


	}

}
