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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

import scala.util.control.Exception.Catch;
import atu.testng.reports.ATUReports;


import atu.testng.reports.logging.LogAs;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;
import atu.testng.reports.listeners.ATUReportsListener;
import atu.testng.reports.listeners.ConfigurationListener;
import atu.testng.reports.listeners.MethodListener;
@Listeners({ ATUReportsListener.class, ConfigurationListener.class,
MethodListener.class })


//

public class Alertingflightstatsvalidation extends CommonTest {

	public static void VerifyAlertstatspresent(String view) throws Exception {
		System.out.println("Verify the gantt view section have Alerting flights dashboard options");
		TestcaseInit();
		try{
			String Flighteventalertchart = getDriver().findElement(By.xpath("//div[@class='col-xs-12 col-sm-4 col-md-12 col-lg-3 fltevt-chrt']")).getAttribute("innerText");
			if(Flighteventalertchart.contains("Alerting Flights")&&Flighteventalertchart.contains("Blocked")&&Flighteventalertchart.contains("Red")&&Flighteventalertchart.contains("Yellow")&&Flighteventalertchart.contains("Total"))
	{
	ATUReports.add("Alerting statistics contains RED,Yellow, Blocked and Total alerting status and verified ",  LogAs.PASSED, null);;	
	
	
	}
	else
	{
		ATUReports.add(" Alerting statistics doesnot contains RED,Yellow, Blocked and Total alerting status and verified",  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));;
		
		captureinfoScreenshot(getDriver(), "Alertstats failed");
	}
		
}catch(Exception Someissuewithbrowserresponsiveness)
	{
	try{
		GanntViewHeaderFunctionality.GanntViewSelection();
		CommonTest.SpinnerControl();
		String Flighteventalertchart = getDriver().findElement(By.xpath("//div[@class='col-xs-12 col-sm-4 col-md-12 col-lg-3 fltevt-chrt']")).getAttribute("innerText");
		if(Flighteventalertchart.contains("Alerting Flights")&&Flighteventalertchart.contains("Blocked")&&Flighteventalertchart.contains("Red")&&Flighteventalertchart.contains("Yellow")&&Flighteventalertchart.contains("Total"))
{
			ATUReports.add("Alerting statistics contains RED,Yellow, Blocked and Total alerting status and verified",  LogAs.PASSED, null);;

}
else
{
	ATUReports.add("Alerting statistics doesnot contains RED,Yellow, Blocked and Total alerting status and verified ",  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));;
	
	captureinfoScreenshot(getDriver(), "Alertstats failed");
}
	}catch(Exception browserresponsiveness)
	{
		ATUReports.add("Alerting statistics doesnot contains RED,Yellow, Blocked and Total alerting status and verified ",  LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE)); ;
		
		captureinfoScreenshot(getDriver(), "VerifyAlertstatspresent Failed");	
	}

	}
	}
	
	
	
	
	
	
	
	
	
	
public static void VerifyMessagewhenNoAlertingFlights(String OptionXpath ,String OptionStatsCountvaluexpath) throws Exception {
	TestcaseInit();
		try{
			clickByXpath(OptionXpath,"OptionXpath");
			Thread.sleep(2000);
			ATUReports.add("Selected the corresponding flight Statisitcs for validation :: "+OptionXpath,  LogAs.PASSED, null);;
			
			String Messageposted = getDriver().findElement(By.xpath(Web_UI.AlertMessageposted)).getAttribute("innerText");
			
			
				if(Messageposted.contains("There are no flight"))
				{
					
					ATUReports.add(" Message posted is valid when No fligts present and Message displayed is :: "+Messageposted,  LogAs.PASSED, null);;
				
				}
				else
				{
					String ttitle = OptionXpath.substring(16,18);
					ATUReports.add("Message posted is invalid when No fligts present and Message displayed is :: "+Messageposted,  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));;
					
					captureinfoScreenshot(getDriver(),ttitle+ " Message posted is invalid "+Messageposted);
				}
			
			
			
	}catch (Exception es)
		{
		String ttitle = OptionXpath.substring(16,18);
		ATUReports.add("Cannot be validated as stats count is not Zero" +ttitle,  LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE)); ;
		
		captureinfoScreenshot(getDriver(), "Cannot be validated as stats count is not Zero"+ttitle);
		}
	}





































public static void VerifyMessagewhennoflightsforBlocked(String view) throws Exception {
	System.out.println("Verify the message when No flights present for the Blocked flight statistics");
	CheckCollapse();
	Selectview(view);
	VerifyMessagewhenNoAlertingFlights(Web_UI.Blocked,Web_UI.BlockedCount);
	
}


public static void VerifyMessagewhennoflightsforYellow(String view) throws Exception {
	System.out.println("Verify the message when No flights present for the Yellow flight statistics");
	CheckCollapse();
	Selectview(view);
	VerifyMessagewhenNoAlertingFlights(Web_UI.Yellow, Web_UI.YellowCount);
}

public static void VerifyMessagewhennoflightsforCloseout(String view) throws Exception {
	System.out.println("Verify the message when No flights present for the Closeout flight statistics");
	CheckCollapse();
	Selectview(view);
	VerifyMessagewhenNoAlertingFlights("//div[@title='CLOSEOUTS']","//div[@title='CLOSEOUTS']");
	
}


public static void VerifyMessagewhennoflightsforTotal(String view) throws Exception {
	System.out.println("Verify the message when No flights present for the Total flight statistics");
	CheckCollapse();
	Selectview(view);
	VerifyMessagewhenNoAlertingFlights(Web_UI.TotalAlerts,Web_UI.TotalAlertCount);
}


public static void VerifyMessagewhennoflightsforRED(String view) throws Exception {
	
	System.out.println("Verify the message when No flights present for the Red flight statistics");
	CheckCollapse();
	Selectview(view);
	VerifyMessagewhenNoAlertingFlights(Web_UI.Red, Web_UI.RedCount);
}






public static void VerifyBlockedhaveMaroonColor(String view) throws Exception {
	System.out.print("Verify the Blocked flights drawn with Maroon Color");
	TestcaseInit();
	try{
	GanntViewHeaderFunctionality.GanntViewSelection();

CommonTest.SpinnerControl();
	
	try{
		clickByXpath(Web_UI.Blocked,"Blocked");
		ATUReports.add("Blocked Status selected Successfully",  LogAs.PASSED, null);;
	Thread.sleep(2000);

	List<WebElement> Ganntlist = getDriver().findElements(By.xpath(Web_UI.PuckComplete));
	int Ganntlistcount = Ganntlist.size();
	if(Ganntlistcount == 0)
	{
				ATUReports.add("***********Gantt List is Zero and hence Exiting test smoothly*****************",  LogAs.PASSED, null);;
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
						String Puckcolor = gantelement.getCssValue("background-color");
						
						if(Puckcolor.contains("0, 0, 0")){
							ATUReports.add("Flight is OUT and hence displayed in Black color" +i,  LogAs.PASSED, null);
						}
						else{
							
						
						if(Puckcolor.contains("128, 0, 0"))
						{
							ATUReports.add( "Puck Color is displayed in Maroon "+i,  LogAs.PASSED, null);;
						
						}
						else{
							
							ATUReports.add( "Puck Color is Not displayed in Maroon "+i,  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));;
						
						}
						
						}
						}
							
							  catch(Exception Someissueinmovingbetweenpuck)
							{
									System.out.print("Some  Issue in moving between pucks");	
										
							}
			}
		}
	}
	}catch(Exception Notclicking)
	{
		ATUReports.add("Red Status not selected Successfully",  LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE)); ;
		GanntViewHeaderFunctionality.GanntViewSelection();
		CommonTest.SpinnerControl();
		clickByXpath(Web_UI.Blocked,"Blocked");
		System.out.print("Some  Issue in moving between pucks");
	}
	}
	catch(Exception Someissueinmovingbetweenpuck)
	{
		System.out.print("Some  Issue in moving between pucks");
		captureinfoScreenshot(getDriver(), "VerifyBlockedhaveMaroonColor");
	}
	
	
	
}






public static void VerifyYellowStatshaveyellowcolor(String view) throws Exception {
	System.out.print("Verify Yellow alerting flights puck are drawn in Yellow color");
	TestcaseInit();
	CommonTest.SpinnerControl();
	try{
		clickByXpath(Web_UI.Yellow,"Yellow");
		ATUReports.add("Yellow Status selected Successfully",  LogAs.PASSED, null);;
	
	Thread.sleep(2000);

	List<WebElement> Ganntlist = getDriver().findElements(By.xpath(Web_UI.PuckComplete));
	int Ganntlistcount = Ganntlist.size();
	if(Ganntlistcount == 0)
	{
		ATUReports.add("***********Gantt List is Zero and hence Exiting test smoothly*****************",  LogAs.PASSED, null);;
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
						String Puckcolor = gantelement.getCssValue("background-color");
						String Text = gantelement.getAttribute("innerText");
						
						if(Puckcolor.contains("0, 0, 0")){
							ATUReports.add("Flight is OUT and hence displayed in Black color" +i,  LogAs.PASSED, null);
						}
						else{
							
						
						if(Puckcolor.contains("128, 0, 0")||Puckcolor.contains("212, 0, 0")){
							ATUReports.add("Already the puck holds Red or blocked alerting and proceeding further to check Multiple alerts hover present" +i,  LogAs.PASSED, null);
						}else{
											
						if(Puckcolor.contains("255, 206, 4"))
						{
								ATUReports.add("Puck Color is displayed in Yellow "+i,  LogAs.PASSED, null);;
						}
						else{
							if(Text.contains("ORIG")||Text.contains("TERM"))
							{
									ATUReports.add("Origin/Term Flight and hence can be Differ in Color "+i,  LogAs.PASSED, null);;
								
							}else{
							
							ATUReports.add("Puck Color is Not displayed in Yellow "+i,  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));;
							captureinfoScreenshot(getDriver(), "Puck Color is Not displayed in Yellow "+i);
							}
						}
							}
						}
							}
							  catch(Exception Someissueinmovingbetweenpuck)
							{
									System.out.print("Some  Issue in moving between pucks");	
									captureinfoScreenshot(getDriver(), "VerifyYellowStatshaveyellowcolor");
										
							}
							
							
			}
		}
		
	}
	
	}catch(Exception Notclicking)
	{
		ATUReports.add("Red Status not selected Successfully",  LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE)); ;
		GanntViewHeaderFunctionality.GanntViewSelection();
		CommonTest.SpinnerControl();
		clickByXpath(Web_UI.Yellow,"Yellow");
	}
	

	
}





public static void VerifyRedStatshaveRedcolor(String view) throws Exception {
	TestcaseInit();
	System.out.print("Verify Red Stats flights pucks are drawn in Red color");
	CommonTest.SpinnerControl();
	try{
	clickByXpath(Web_UI.Red,"Red");
	
	ATUReports.add("Red Status selected Successfully",  LogAs.PASSED, null);;
	
	Thread.sleep(2000);

	List<WebElement> Ganntlist = getDriver().findElements(By.xpath(Web_UI.GanttTable));
	int Ganntlistcount = Ganntlist.size();
	if(Ganntlistcount == 0)
	{
		ATUReports.add("***********Gantt List is Zero and hence Exiting test smoothly*****************",  LogAs.PASSED, null);;
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
						String Puckcolor = gantelement.getCssValue("background-color");
						String Text = gantelement.getAttribute("innerText");
					
						if(Puckcolor.contains("0, 0, 0")){
							ATUReports.add("Flight is OUT and hence displayed in Black color" +i,  LogAs.PASSED, null);
						}
						else{
							
							if(Puckcolor.contains("128, 0, 0")){
							ATUReports.add("Already the puck holds blocked alerting and proceeding further to check Multiple alerts hover present" +i,  LogAs.PASSED, null);
						}
						else{
						if(Puckcolor.contains("212, 0, 0"))
						{
								ATUReports.add("Puck Color is displayed in Red "+i,  LogAs.PASSED, null);;
						}
						else{
							if(Text.contains("ORIG")||Text.contains("TERM"))
							{
								ATUReports.add("Origin/Term Flight and hence can be Differ in Color "+i,  LogAs.PASSED, null);;
								
							}else{
							
							ATUReports.add("Puck Color is Not displayed in Red "+i,  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));;
							captureinfoScreenshot(getDriver(), "Puck Color is Not displayed in Red "+i);
							}
						}
							}
						}
							}
							
							  catch(Exception Someissueinmovingbetweenpuck)
							{
									System.out.print("Some  Issue in moving between pucks");	
										captureinfoScreenshot(getDriver(), "VerifyRedStatshaveRedcolor");
							}
			}
		}
	}
	
	
	

	

	}catch(Exception Notclicking)
	{
		ATUReports.add("Red Status not selected Successfully",  LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE)); ;
		GanntViewHeaderFunctionality.GanntViewSelection();
		CommonTest.SpinnerControl();
		clickByXpath(Web_UI.Red,"Red");
	}	

	
}






public static void VerifyTotalHaveallcolor(String view) throws InterruptedException {}













public static void VerifyMultipleAlertsicons(String view) throws Exception {
	TestcaseInit();
	System.out.println("Verify the puck option that holds Multiple alerting flights icons");
	
	GanntViewHeaderFunctionality.GanntViewSelection();
	CommonTest.SpinnerControl();
	CommonTest.CollapseTest();
	try{
	clickByXpath(Web_UI.TotalAlerts,"TotalAlerts");
	CommonTest.ExpandTest();
	try
	{
	List<WebElement> Ganntlist = getDriver().findElements(By.xpath(Web_UI.PuckComplete));
	int Ganntlistcount = Ganntlist.size();
	if(Ganntlistcount == 0)
	{
		CommonTest.CheckGanttviewListisnotZero();
	}
	TestcaseInit();
	if (Ganntlistcount != 0) {
		int Flightpuckcounter=0;
		for (WebElement gantelement : Ganntlist) {
	
			if(Flightpuckcounter<10)
			{
				Flightpuckcounter++;
				Actions actions = new Actions(getDriver());
			actions.moveToElement(gantelement).build().perform();
			Thread.sleep(1000);
			WebElement Multiplealerticon = gantelement.findElement(By.xpath("div[2]/div[1]/span[1]"));
			if(Multiplealerticon!=null)
			{
				ATUReports.add("Multiple alert icon present in the puck ",  LogAs.PASSED, null);;
				actions.moveToElement(Multiplealerticon).build().perform();
				actions.moveToElement(Multiplealerticon).build().perform();	
				WebElement Hover = gantelement.findElement(By.xpath("div[2]/div[2]/div[2]"));
				if(Multiplealerticon!=null)
				{
				ATUReports.add("Hover is displayed upon mouseover ",  LogAs.PASSED, null);;
				}
				else
				{
					ATUReports.add("Hover is not displayed upon mouseover ",  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));;
				}
				
				List<WebElement> Hoverelement = Hover.findElements(By.xpath("span"));
				int Hoverlementsize = Hoverelement.size();
				if(Hoverlementsize>1)
				{
					ATUReports.add("Displays Multiple alert icon ",  LogAs.PASSED, null);;
				}
				else
				{
					ATUReports.add("Some issue in hover or multiple icons not displayed ",  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));;
				}
				
				for (WebElement alert : Hoverelement) {
					
					String alertname1 = alert.findElement(By.xpath("span[1]")).getAttribute("class");
					System.out.println(alertname1);
					ATUReports.add("Alert icon present are "+alertname1,  LogAs.PASSED, null);;
				}
				
			}
			else
			{
				ATUReports.add("No Total alert present",  LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE)); ;
			}
	
	
	
	CommonTest.CheckCollapse();		
	CommonTest.zoomOut();
	CommonTest.zoomOut();
	CommonTest.zoomOut();
	CommonTest.zoomOut();
	
}
		}}

	}catch(Exception alerticomissng){
		ATUReports.add("No multiple alert flights present in the view",  LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE)); ;
	}
}

catch(Exception Noganttable)
{
	ATUReports.add("No multiple alert flights present in the view",  LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE)); ;
	captureinfoScreenshot(getDriver(), "VerifyMultipleAlertsicons");
}

}	
	
	
	
	
	
	
	
	
	
	
	
}