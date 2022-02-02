/*
 * 
 * 
 */


package get.next.gen.utilities;

import get.next.gen.commonaction.CommonTest;
import get.next.gen.webtestcase.Web_UI;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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




public class PuckColorValidation extends CommonTest {

	
	
	public static void 	PuckColorValidation(String view) throws Exception {
		System.out.println("Validating Flight puck color details when the puck holds different flight status");
		TestcaseInit();
		CommonTest.Selectview(view);
		clickByXpathbyView(view, Web_UI.TotalGate, Web_UI.HybridAllGate);
		CommonTest.SpinnerControl();
		Thread.sleep(5000);
		CommonTest.CheckExpand();
		CommonTest.zoomin();
		CommonTest.zoomin();
		CommonTest.zoomin();
		CommonTest.zoomindata();
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
		
		if (Ganntlistcount != 0) {
			int Flightpuckcounter=0;
			for (WebElement gantelement : Ganntlist) {
		//Setting Gantt view flight puck counter inorder to validate 20 pucks as page refresh interrupts the execution
				if(Flightpuckcounter<20)
				{
				Flightpuckcounter++;
				Actions actions = new Actions(getDriver());
				actions.moveToElement(gantelement).build().perform();
				Thread.sleep(1000);
				try {
				
					WebElement elementcolorfinder = gantelement;
					String elementid = elementcolorfinder.getAttribute("id");
					String Colorfound = elementcolorfinder.getCssValue("background-color");
					System.out.print(Colorfound);
					WebElement DepartureStatusFinder = gantelement.findElement(By.xpath("div[3]/div[3]/span[2]"));
					WebElement ArrivalStatusFinder = gantelement.findElement(By.xpath("div[3]/div[1]/span[2]"));
					String DepartureStatusfound = DepartureStatusFinder.getAttribute("innerText");
					String ArrivalStatusfound = ArrivalStatusFinder.getAttribute("innerText");
						if(DepartureStatusfound!="")
				{
					if(ArrivalStatusfound!="")		
					{
						if(Colorfound.contains("212, 0, 0")||Colorfound.contains("255, 206, 4")||Colorfound.contains("128, 0, 0"))	
						{
							ATUReports.add("Alerting Flights and Highlighting in Yellow or Red  "+"" +"  " +Colorfound+ "  "+DepartureStatusfound+" "+ArrivalStatusfound,  LogAs.PASSED, null);;// test.log(LogStatus.PASS, "Alerting Flights and Highlighting in Yellow or Red  "+"" +"  " +Colorfound+ "  "+DepartureStatusfound+" "+ArrivalStatusfound);
						}
						else{
						if (DepartureStatusfound.contains("SKD")||DepartureStatusfound.contains("ETD")){
							if (ArrivalStatusfound.contains("SKD")||ArrivalStatusfound.contains("PRE"))	 {
												if (Colorfound.contains("25, 70, 147")) {
								System.out.print("Color Matches to Blue");
								ATUReports.add("Color Matches to Blue  "+"" +"  " +Colorfound+ "  "+DepartureStatusfound+" "+ArrivalStatusfound,  LogAs.PASSED, null);;// test.log(LogStatus.PASS, "Color Matches to Blue  "+"" +"  " +Colorfound+ "  "+DepartureStatusfound+" "+ArrivalStatusfound);
							}
							else {
								System.out.print("Color Not Matches to Blue");
									ATUReports.add("Color Not Matches to Blue "+"" + "  " +Colorfound+ "  "+DepartureStatusfound+" "+ArrivalStatusfound+" "+elementid,  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));;// test.log(LogStatus.FAIL, "Color Not Matches to Blue "+"" + "  " +Colorfound+ "  "+DepartureStatusfound+" "+ArrivalStatusfound);
							}
							}
					
					}		
						
						else if (ArrivalStatusfound.contains("HLD")||DepartureStatusfound.contains("HLD")) {	
							if (Colorfound.contains("125,128,0")) {
								System.out.print("Color Matches to Olive Drab");
								ATUReports.add("Color Matches to Olive Drab  "+"" +"  " +Colorfound+ "  "+DepartureStatusfound+" "+ArrivalStatusfound,  LogAs.PASSED, null);;// test.log(LogStatus.PASS, "Color Matches to Olive Drab  "+"" +"  " +Colorfound+ "  "+DepartureStatusfound+" "+ArrivalStatusfound);
							 }
							else {
								System.out.print("Color Not Matches to Color Matches to Olive Drab");
									ATUReports.add("Color Not Matches to Color Matches to Olive Drab "+"  " +Colorfound+ "  "+DepartureStatusfound+" "+ArrivalStatusfound+" "+elementid,  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));;// test.log(LogStatus.FAIL, "Color Not Matches to Color Matches to Olive Drab "+"  " +Colorfound+ "  "+DepartureStatusfound+" "+ArrivalStatusfound);
							}
						}

						else if (ArrivalStatusfound.contains("ETA")) {	
						if (Colorfound.contains("0, 128, 128")) {
							System.out.print("Color Matches to Teal");
							ATUReports.add("Color Matches to Teal  "+"" +"  " +Colorfound+ "  "+DepartureStatusfound+" "+ArrivalStatusfound,  LogAs.PASSED, null);;// test.log(LogStatus.PASS, "Color Matches to Teal  "+"" +"  " +Colorfound+ "  "+DepartureStatusfound+" "+ArrivalStatusfound);
						 }
						else {
							System.out.print("Color Not Matches to Teal");
								ATUReports.add("Color Not Matches to Teal "+"  " +Colorfound+ "  "+DepartureStatusfound+" "+ArrivalStatusfound+" "+elementid,  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));;// test.log(LogStatus.FAIL, "Color Not Matches to Teal "+"  " +Colorfound+ "  "+DepartureStatusfound+" "+ArrivalStatusfound);
						}
					}
						
						else if (ArrivalStatusfound.contains("CHO")) {
			
						if (Colorfound.contains("9, 0, 128")) {
							System.out.print("Color Matches to Dark blue");
							ATUReports.add("Color Matches to Dark blue  "+"" +"  " +Colorfound+ "  "+DepartureStatusfound+" "+ArrivalStatusfound,  LogAs.PASSED, null);;// test.log(LogStatus.PASS, "Color Matches to Dark blue  "+"" +"  " +Colorfound+ "  "+DepartureStatusfound+" "+ArrivalStatusfound);
						 }
						else {
							System.out.print("Color Not Matches to Dark blue");
								ATUReports.add("Color Not Matches to Dark blue "+"" + "  " +Colorfound+ "  "+DepartureStatusfound+" "+ArrivalStatusfound+" "+elementid,  LogAs.FAILED, null);;// test.log(LogStatus.FAIL, "Color Not Matches to Dark blue "+"" + "  " +Colorfound+ "  "+DepartureStatusfound+" "+ArrivalStatusfound);
						}
					}
						else if (DepartureStatusfound.contains("SKD")){
							if  (ArrivalStatusfound.contains("ON"))  {
								if (Colorfound.contains("8, 146, 208")) {
				System.out.println("Color Matches to Light Blue");
				ATUReports.add("Color Matches to Light Blue  "+"" +"  " +Colorfound+ "  "+DepartureStatusfound+" "+ArrivalStatusfound,  LogAs.PASSED, null);;// test.log(LogStatus.PASS, "Color Matches to Light Blue  "+"" +"  " +Colorfound+ "  "+DepartureStatusfound+" "+ArrivalStatusfound);
			} else {
				System.out.println("Color Not Matches to Light Blue");
				ATUReports.add("Color Not Matches to Light Blue "+"" + "  " +Colorfound+ "  "+DepartureStatusfound+" "+ArrivalStatusfound+" "+elementid,  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));;// test.log(LogStatus.FAIL, "Color Not Matches to Light Blue "+"" + "  " +Colorfound+ "  "+DepartureStatusfound+" "+ArrivalStatusfound);
			}
	}
						}			
							else if (DepartureStatusfound.contains("OUT")){
								if  (DepartureStatusfound.contains("OUT"))  {
									if (Colorfound.contains("0, 0, 0")) {
					System.out.println("Color Matches to Black");
					ATUReports.add("Color Matches to Black  "+"" +"  " +Colorfound+ "  "+DepartureStatusfound+" "+ArrivalStatusfound,  LogAs.PASSED, null);;// test.log(LogStatus.PASS, "Color Matches to Black  "+"" +"  " +Colorfound+ "  "+DepartureStatusfound+" "+ArrivalStatusfound);
				} else {
					System.out.println("Color Not Matches to Black");
					ATUReports.add("Color Not Matches to Black "+"" + "  " +Colorfound+ "  "+DepartureStatusfound+" "+ArrivalStatusfound+" "+elementid,  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));;// test.log(LogStatus.FAIL, "Color Not Matches to Black "+"" + "  " +Colorfound+ "  "+DepartureStatusfound+" "+ArrivalStatusfound);
				}
		}					
							}

								else if (DepartureStatusfound.contains("OFF")){
									if  (DepartureStatusfound.contains("OFF"))  {
										if (Colorfound.contains("128, 128, 128")) {
						System.out.println("Color Matches to Grey");
						ATUReports.add("Color Matches to Grey  "+"" +"  " +Colorfound+ "  "+DepartureStatusfound+" "+ArrivalStatusfound,  LogAs.PASSED, null);;// test.log(LogStatus.PASS, "Color Matches to Grey  "+"" +"  " +Colorfound+ "  "+DepartureStatusfound+" "+ArrivalStatusfound);
					} else {
						System.out.println("Color Not Matches to Grey");
						ATUReports.add("Color Not Matches to Grey "+"" + "  " +Colorfound+ "  "+DepartureStatusfound+" "+ArrivalStatusfound+" "+elementid,  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));;// test.log(LogStatus.FAIL, "Color Not Matches to Grey "+"" + "  " +Colorfound+ "  "+DepartureStatusfound+" "+ArrivalStatusfound);
					}
			}	
								}	
								
								
									else if (DepartureStatusfound.contains("DCN")){
										if  (ArrivalStatusfound.contains("DCN") || DepartureStatusfound.contains("DCN") )  {
											if (Colorfound.contains("255, 255, 255")) {
							System.out.println("Color Matches to White");
							ATUReports.add("Color Matches to White  "+"" +"  " +Colorfound+ "  "+DepartureStatusfound+" "+ArrivalStatusfound,  LogAs.PASSED, null);;// test.log(LogStatus.PASS, "Color Matches to White  "+"" +"  " +Colorfound+ "  "+DepartureStatusfound+" "+ArrivalStatusfound);
						} else {
							System.out.println("Color Not Matches to White");
							ATUReports.add("Color Not Matches to White "+"" + "  " +Colorfound+ "  "+DepartureStatusfound+" "+ArrivalStatusfound+" "+elementid,  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));;// test.log(LogStatus.FAIL, "Color Not Matches to White "+"" + "  " +Colorfound+ "  "+DepartureStatusfound+" "+ArrivalStatusfound);
						}
				}					
									}			
						
						else if (DepartureStatusfound.contains("SKD")){
							if  (ArrivalStatusfound.contains("IN"))  {
								if (Colorfound.contains("18, 157, 28")) {
				System.out.println("Color Matches to Green");
				ATUReports.add("Color Matches to Green  "+"" +"  " +Colorfound+ "  "+DepartureStatusfound+" "+ArrivalStatusfound,  LogAs.PASSED, null);;// test.log(LogStatus.PASS, "Color Matches to Green  "+"" +"  " +Colorfound+ "  "+DepartureStatusfound+" "+ArrivalStatusfound);
			} else {
				System.out.println("Color Not Matches to Green");
				ATUReports.add( "Color Not Matches to Green "+"" + "  " +Colorfound+ "  "+DepartureStatusfound+" "+ArrivalStatusfound+" "+elementid,  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));;// test.log(LogStatus.FAIL, "Color Not Matches to Green "+"" + "  " +Colorfound+ "  "+DepartureStatusfound+" "+ArrivalStatusfound);
			}
	}
						}		
											
						else if (ArrivalStatusfound.contains("CXL")) {
						if (Colorfound.contains("178, 63, 229")) {
							System.out.println("Color Matches to Purple");
						} else {
							System.out.println("Color Not Matches to Purple");
							ATUReports.add("Color Not Matches to Purple "+"" + "  " +Colorfound+ "  "+DepartureStatusfound+" "+ArrivalStatusfound+" "+elementid,  LogAs.PASSED, null);;// test.log(LogStatus.FAIL, "Color Not Matches to Purple "+"" + "  " +Colorfound+ "  "+DepartureStatusfound+" "+ArrivalStatusfound);
						}
									} 		
					
					}
					}
					}
				
		}
		catch (Exception Exee) {
			
			System.out.println("Didnt find the status");
			CommonTest.CheckOKPopupPresentandclose();
			CommonTest.CheckCancelPopupPresentandclose();
			Checkappupdateclosebutton();
		
		}
			}
			}
		}
		CommonTest.CheckCollapse();		
		CommonTest.zoomOut();
		CommonTest.zoomOut();
		CommonTest.zoomOut();
		CommonTest.zoomOut();
		
	}
	
	
	
	
}


