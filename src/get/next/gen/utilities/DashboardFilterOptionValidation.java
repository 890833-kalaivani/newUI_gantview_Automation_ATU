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

public class DashboardFilterOptionValidation extends CommonTest {

	public static void StatsoptionExist() throws Exception {

		System.out.println("Verify the Stats option ");
		TestcaseInit();
// Select Dashboard filter icon
		clickByXpath(Web_UI.filtericon,"filtericon");
// Check Stats option exist
		
	WebElement Statsoption = getDriver().findElement(By.xpath(Web_UI.StatsOption));
	String StatsHeader = Statsoption.getAttribute("innerText");
	if(StatsHeader.contains("Stats"))
	{
		
		ATUReports.add("The header contains the right text as  "+StatsHeader,  LogAs.PASSED, null); 
	}	else
	{
		
		ATUReports.add("The header Mismatch with the expected  "+StatsHeader,  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE)); 
		captureinfoScreenshot(getDriver(), " Mismatch "+StatsHeader );
	}

		

	}

	// Select Stats option
	public static void StatsoptionSelection() throws InterruptedException {
		WebElement Statsoption = getDriver().findElement(By.xpath(Web_UI.StatsOption));
		Statsoption.click();
		Thread.sleep(5000);
		ATUReports.add("Stats Option is selected ",  LogAs.PASSED, null); 
	}
	
	
	//Select all flight statistics in Settings page if it is unselected
	public static void SelectAllStatistics() throws Exception{
		
		System.out.println("Verify the user is allowed to select all flight statistics");
		
		try{
			
			WebElement Latearrival = getDriver().findElement(By.xpath("//*[@id='lateArr']"));
			WebElement Earlyarrival = getDriver().findElement(By.xpath("//*[@id='earlyArr']"));
			WebElement EtdUpdate = getDriver().findElement(By.xpath("//*[@id='etdUpdates']"));
			WebElement Cancelled = getDriver().findElement(By.xpath("//*[@id='canceled']"));
			
					String LaterarrivalCheckbox = Latearrival.getAttribute("disabled");
					String EarlyarrivalCheckbox = EtdUpdate.getAttribute("disabled");
					String EtdUpdateCheckbox = EtdUpdate.getAttribute("disabled");
					String CancelledCheckbox = Cancelled.getAttribute("disabled");
				
					if(LaterarrivalCheckbox.contains("true") && EarlyarrivalCheckbox.contains("true") && EtdUpdateCheckbox.contains("true") &&CancelledCheckbox.contains("true")){
						ATUReports.add("Check box disabled for Latearrival , Early Arrival, EtdUpdate and Cancelled  ",  LogAs.PASSED, null); 
					}
					else{
						ATUReports.add("Some of checkbox are not disabled ",  LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));  
						captureinfoScreenshot(getDriver(), "Some of checkbox are not disabled ");
					}
		}
		catch(Exception disableexep){
			
		}
		
		
			try{
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
			//WebElement PotentialTows = getDriver().findElement(By.xpath("//*[@id='PotentialTows']"));
			WebElement ATCDelay = getDriver().findElement(By.xpath(Web_UI.StatsATCDelay));
			WebElement DelayedDep = getDriver().findElement(By.xpath(Web_UI.StatsDelayedDep));
			WebElement MOGT = getDriver().findElement(By.xpath(Web_UI.StatsMOGT));
			WebElement originated = getDriver().findElement(By.xpath(Web_UI.Statsoriginated));
			WebElement terminated = getDriver().findElement(By.xpath(Web_UI.Statsterminated));
			WebElement unlinked = getDriver().findElement(By.xpath(Web_UI.Statsunlinked));
			WebElement A14 = getDriver().findElement(By.xpath(Web_UI.StatsA14));
			WebElement WeightRestricted = getDriver().findElement(By.xpath(Web_UI.StatsWeightRestricted));
			WebElement atlasGalley = getDriver().findElement(By.xpath(Web_UI.StatsatlasGalley));
			
			
			
			if(WeightRestricted.isSelected()==false)
			{
				clickBywebelementxpath(WeightRestricted,"WeightRestricted");
				ATUReports.add("Weight Restricted Check box is selected  ",  LogAs.PASSED, null); 
			}	
			if(originated.isSelected()==false)
			{
				clickBywebelementxpath(originated,"originated");
				ATUReports.add("Origin Check box is Not selected by default and Checkbox is Selected successfully  " ,  LogAs.PASSED, null); 
			}
			if(terminated.isSelected()==false)
			{
				clickBywebelementxpath(terminated,"terminated");
				ATUReports.add("Term Check box is Not selected by default and Checkbox is Selected successfully   " ,  LogAs.PASSED, null); 
			}
			
			if(MOGT.isSelected()==false)
			{
				clickBywebelementxpath(MOGT,"MOGT");
				ATUReports.add("MOGT Check box is Not selected by default and Checkbox is Selected successfully  ",  LogAs.PASSED, null); 
			}
			if(originated.isSelected()==false)
			{
				clickBywebelementxpath(originated,"originated");
				
				ATUReports.add("originated Check box is Not selected by default and Checkbox is Selected successfully  ",  LogAs.PASSED, null); 
			}
			if(terminated.isSelected()==false)
			{
				clickBywebelementxpath(terminated,"terminated");
				ATUReports.add("Term Check box is Not selected by default and Checkbox is Selected successfully   ",  LogAs.PASSED, null); 
			}
			if(unlinked.isSelected()==false)
			{
				clickBywebelementxpath(unlinked,"unlinked");
				ATUReports.add("unlinked Check box is Not selected by default and Checkbox is Selected successfully   ",  LogAs.PASSED, null); 
			}
			if(A14.isSelected()==false)
			{
				clickBywebelementxpath(A14,"A14");
				ATUReports.add("A14 Check box is Not selected by default and Checkbox is Selected successfully   ",  LogAs.PASSED, null); 
			}
			
			if(IFS.isSelected()==false)
			{
				clickBywebelementxpath(IFS,"IFS");
				ATUReports.add("IFS Check box is Not selected by default and Checkbox is Selected successfully  ",  LogAs.PASSED, null); 
			}
			
			if(Diverted.isSelected()==false)
			{
				clickBywebelementxpath(Diverted,"Diverted");
				ATUReports.add("Diverted Check box is Not selected by default and Checkbox is Selected successfully   ",  LogAs.PASSED, null); 
			}
			
			if(DCN.isSelected()==false)
			{
				clickBywebelementxpath(MEL,"MEL");
				ATUReports.add("DCN Check box is Not selected by default and Checkbox is Selected successfully  ",  LogAs.PASSED, null); 
			}
			
			if(MEL.isSelected()==false)
			{
				clickBywebelementxpath(MEL,"MEL");
				ATUReports.add("MEL Check box is Not selected by default and Checkbox is Selected successfully  ",  LogAs.PASSED, null); 
			}
			
		
			if(OTS.isSelected()==false)
			{
				clickBywebelementxpath(OTS,"OTS");
				ATUReports.add("OTS Check box is Not selected by default and Checkbox is Selected successfully   ",  LogAs.PASSED, null); 
			}
			
			
			if(RTD.isSelected()==false)
			{
				clickBywebelementxpath(RTD,"RTD");
				ATUReports.add("RTD Check box is Not selected by default and Checkbox is Selected successfully   " ,  LogAs.PASSED, null); 
			}
			
			if(AcSwap.isSelected()==false)
			{
				clickBywebelementxpath(AcSwap,"AcSwap");
				ATUReports.add("AcSwap Check box is Not selected by default and Checkbox is Selected successfully   ",  LogAs.PASSED, null); 
			}
			
			if(GateSwap.isSelected()==false)
			{
				clickBywebelementxpath(GateSwap,"GateSwap");
				ATUReports.add("GateSwap Check box is Not selected by default and Checkbox is Selected successfully   ",  LogAs.PASSED, null); 
			}
			
			if(RightStart.isSelected()==false)
			{
				clickBywebelementxpath(RightStart,"RightStart");
				ATUReports.add("RightStart Check box is Not selected by default and Checkbox is Selected successfully   ",  LogAs.PASSED, null); 
			}
			
			if(GateConflict.isSelected()==false)
			{
				clickBywebelementxpath(GateConflict,"GateConflict");
				ATUReports.add("GateConflict Check box is Not selected by default and Checkbox is Selected successfully   ",  LogAs.PASSED, null); 
			}
			
		
			
			if(ATCDelay.isSelected()==false)
			{
				clickBywebelementxpath(ATCDelay,"ATCDelay");
				ATUReports.add("ATCDelay Check box is Not selected by default and Checkbox is Selected successfully  ",  LogAs.PASSED, null); 
			}
			
			
			if(DelayedDep.isSelected()==false)
			{
				clickBywebelementxpath(DelayedDep,"DelayedDep");
				ATUReports.add("DelayedDep Check box is Not selected by default and Checkbox is Selected successfully   ",  LogAs.PASSED, null); 
			}
			Actions actions = new Actions(getDriver());	
			actions.moveToElement(atlasGalley).build().perform();
			if(atlasGalley.isSelected()==false)
			{
				clickBywebelementxpath(atlasGalley,"atlasGalley");
				ATUReports.add("atlasGalley Check box is selected  ",  LogAs.PASSED, null); 
			}
			
			}
			catch(Exception Error)
			{
				System.out.println("Exception with some status");
				ATUReports.add("Some stats thrown error  " +Error.toString(),  LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE)); 
				clickByXpath(Web_UI.ApplyButton,"ApplyButton");
				Thread.sleep(8000);
				GanntViewHeaderFunctionality.SpinnerControl();
			}
		
			clickByXpath(Web_UI.ApplyButton,"ApplyButton");
			Thread.sleep(8000);
			GanntViewHeaderFunctionality.SpinnerControl();
	
	}	
	
	
	//Select Draw to Actual GT option from View settings page
	
	public static void DrawtoActualGT() throws Exception {

		TestcaseInit();
		clickByXpath(Web_UI.filtericon,"filtericon");
		Thread.sleep(1000);
		clickByXpath(Web_UI.ViewSettings,"ViewSettings");
		Thread.sleep(1000);
		WebElement showetd = getDriver().findElement(By.xpath("//input[@id='gantt-puck-width']"));
		boolean showetdselected = showetd.isSelected();
		try{
		if(showetdselected==true){
			ATUReports.add("Already DrawtoActual GT  is already selected. " ,  LogAs.PASSED, null);	
		}
		else{
			showetd.click();
			ATUReports.add("Already DrawtoActual GT is selected " ,  LogAs.PASSED, null);	
		}
		}catch(Exception Showetdnotselected){
			ATUReports.add("Issue with selecting DrawtoActual GT   " ,  LogAs.FAILED, null);	
		}
		
		clickByXpath(Web_UI.ApplyButton,"ApplyButton");
		Thread.sleep(6000);
		CommonTest.SpinnerControl();
		
		
		try{
			clickByXpath(Web_UI.ETD,"ETD");
		
		List<WebElement> Ganntlist = getDriver().findElements(By.xpath(Web_UI.PuckDepartureStatusandtime));
		int Ganntlistcount = Ganntlist.size();
		if(Ganntlistcount == 0)
		{
			ATUReports.add("*****************Gantt List is Zero and hence Exiting test smoothly*******************",  LogAs.PASSED, null);
			captureinfoScreenshot(getDriver(), "DeparturestatusValidationListZero");
		}else
		{
					
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
									if(Linkagedetails.contains("UNL")||Linkagedetails.contains("TERM")){
										ATUReports.add("Unlinked or TERM flights and hence skipping the validation for this puck "+i,  LogAs.PASSED, null);
									}else{
										
								
								String Arrivalstationdetailscomplete = gantelement.getAttribute("innerText");
								String arrivalstationsplit[] = Arrivalstationdetailscomplete.split(" ");
								String ArrivalStatus = arrivalstationsplit[0].trim();
								
								List<String> Arrivalcodelist = Arrays.asList("OFF","OUT","CXL");
								boolean contains = Arrivalcodelist.contains(ArrivalStatus);
										
								
								if(contains == true )
								{
									ATUReports.add("Flight is already departed and hence show ETD is not applicable to this flights "+i,  LogAs.PASSED, null);
									
								} else {
								
								
									String idofelement = gantelement.findElement(By.xpath("ancestor::div[1]/ancestor::div[1]/ancestor::div[1]")).getAttribute("id");
									actions.moveToElement(gantelement).build().perform();
									try{
											WebElement etdoutside = getDriver().findElement(By.xpath("//div[@id='"+idofelement+"']/ancestor::div[1]/div[1]"));
											if(etdoutside!=null){
												ATUReports.add("Puck is drawn to GT"+idofelement,  LogAs.PASSED, null);
											}
											else{
												ATUReports.add("Puck is Not drawn to GT"+idofelement,  LogAs.FAILED, null);
											}
									}catch(Exception id)
									{
										
									}
								}
								
									}
						
		
	}catch(Exception id)
								{
		
								}
								}
				
		} 
		}catch(Exception elementnotexist)
		{
			ATUReports.add("<MOGT stats not present  ",  LogAs.INFO, null);
		}
		}
	
	
	
	//Select Show ETD outside option from View settings page
	
	public static void CheckShowETDoutside() throws Exception {
		TestcaseInit();
		clickByXpath(Web_UI.filtericon,"filtericon");
		Thread.sleep(1000);
		clickByXpath(Web_UI.ViewSettings,"ViewSettings");
		Thread.sleep(1000);
		WebElement showetd = getDriver().findElement(By.xpath(Web_UI.Showetd));
		boolean showetdselected = showetd.isSelected();
		try{
		if(showetdselected==true){
			ATUReports.add("Already showETDoutside is selected. " ,  LogAs.PASSED, null);	
		}
		else{
			showetd.click();
			ATUReports.add("Already showETDoutside is selected " ,  LogAs.PASSED, null);	
		}
		}catch(Exception Showetdnotselected){
			ATUReports.add("Issue with selecting show ETD " ,  LogAs.INFO, null);	
		}
		
		clickByXpath(Web_UI.ApplyButton,"ApplyButton");
		Thread.sleep(8000);
		CommonTest.SpinnerControl();
		TestcaseInit();
		try{
		clickByXpath(Web_UI.ETD,"<MOGT");
		}
		catch(Exception Nomogtstats){
			ATUReports.add("Issue with selecting show ETD " ,  LogAs.FAILED, null);	
		}
		
		List<WebElement> Ganntlist = getDriver().findElements(By.xpath(Web_UI.PuckDepartureStatusandtime));
		int Ganntlistcount = Ganntlist.size();
		if(Ganntlistcount == 0)
		{
			ATUReports.add("*****************Gantt List is Zero and hence Exiting test smoothly*******************",  LogAs.PASSED, null);
			captureinfoScreenshot(getDriver(), "DeparturestatusValidationListZero");
		}else
		{
					
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
										
								
								String Arrivalstationdetailscomplete = gantelement.getAttribute("innerText");
								String arrivalstationsplit[] = Arrivalstationdetailscomplete.split(" ");
								String ArrivalStatus = arrivalstationsplit[0].trim();
								
								List<String> Arrivalcodelist = Arrays.asList("OFF","OUT","CXL");
								boolean contains = Arrivalcodelist.contains(ArrivalStatus);
										
								
								if(contains == true )
								{
									ATUReports.add("Flight is already departed and hence show ETD is not applicable to this flights "+i,  LogAs.PASSED, null);
									
								} else {
								
								
									String idofelement = gantelement.findElement(By.xpath("ancestor::div[1]/ancestor::div[1]/ancestor::div[1]")).getAttribute("id");
									actions.moveToElement(gantelement).build().perform();
									try{
											WebElement etdoutside = getDriver().findElement(By.xpath("//div[@id='"+idofelement+"']//div[@class='etd-outside-puck ng-scope']"));
											String etdoutsidetime  = etdoutside.getAttribute("innerText");
											if(etdoutsidetime.contains(":")){
												ATUReports.add("Show ETD details exist for the puck  "+idofelement,  LogAs.PASSED, null);
											}
											else{
												ATUReports.add("Show ETD details not exist for the puck  "+idofelement,  LogAs.FAILED, null);
											}
									}catch(Exception id)
									{
										
									}
								}
								
									}
						
		
	}catch(Exception id)
								{
		
								}
								}
				
		}
}


//Verify dashboard settings is renamed
//*******************************************************************************
	public static void CheckDashboardrenamed() throws Exception {
		TestcaseInit();
		clickByXpath(Web_UI.filtericon,"filtericon");
		ATUReports.add("Dashboard filter icon is clicked from the dashboard page and user is show with settings screen" ,  LogAs.PASSED, null);
		WebElement Settingtitleelement = getDriver().findElement(By.xpath("//div[@class='col-lg-12 col-xs-12 filter-panel-heading']/div[1]"));
		if(Settingtitleelement!=null){
			ATUReports.add("Dashboard header section present" ,  LogAs.PASSED, null);
		}else{
			ATUReports.add("Dashboard header section not  present" ,  LogAs.FAILED, null);
		}
		
		String Settingtitle = Settingtitleelement.getAttribute("innerText");
		if(Settingtitle.contains("Settings"))
		{
			
			ATUReports.add("Dashboard is renamed to Settings " ,  LogAs.PASSED, null);
		}
		else{
			ATUReports.add("Setting not renamed to Settings and Text found is::: " +Settingtitle,  LogAs.FAILED, null);
		}
		
		
		clickByXpath(Web_UI.DashboardfilterCancel,"DashboardfilterCancel");
		Thread.sleep(1000);
		ATUReports.add("Cancel button is selected from the Settings page and user shown with GetNG Dashboard" ,  LogAs.PASSED, null);
		
	}
	
	
	// Verify user can able to switch between day and night mode
	
	public static void CheckDaynightenabling() throws Exception {
		TestcaseInit();
		try{
		EnableNightmode();
		WebElement Checkapplicationcolor1 = getDriver().findElement(By.xpath("//section[contains(@class,'content dashboard')]"));
		String getcolorofapplication1 = Checkapplicationcolor1.getCssValue("background-color").trim();
		if(getcolorofapplication1.contains("0, 0, 0")){
			ATUReports.add("Mode changed to Nightmode and verified with checkpoint" ,  LogAs.PASSED, null);
		}else{
			ATUReports.add("Mode not changed to Nightmode" ,  LogAs.FAILED, null);
		}
		EnableDaymode();
		WebElement Checkapplicationcolor = getDriver().findElement(By.xpath("//section[contains(@class,'content dashboard')]"));
		String getcolorofapplication = Checkapplicationcolor.getCssValue("background-color").trim();
		if(getcolorofapplication.contains("255, 255, 255")){
			ATUReports.add("Mode changed to Daymode and verified with checkpoint" ,  LogAs.PASSED, null);
		}else{
			ATUReports.add("Mode not changed to Daymode" ,  LogAs.FAILED, null);
		}
		}catch(Exception ee){
			
		}
	
	}
	
	
	// Below will enable Night mode

	public static void EnableNightmode() throws Exception {
		
		clickByXpath(Web_UI.filtericon,"filtericon");
		try{
			WebElement Nighticon = getDriver().findElement(By.xpath(Web_UI.Daymodeenabled));
			ATUReports.add("User is in Day mode " ,  LogAs.PASSED, null);
			clickBywebelementxpath(Nighticon,"Nighticon");
			ATUReports.add("User is switched to Nightmode " ,  LogAs.PASSED, null);
			clickByXpath(Web_UI.ApplyButton,"ApplyButton");
		}catch(Exception nonightmode)
		{
			ATUReports.add("User is already in Night mode " ,  LogAs.PASSED, null);
			clickByXpath(Web_UI.DashboardfilterCancel,"DashboardfilterCancel");
		}
		
		Thread.sleep(10000);
		CommonTest.SpinnerControl();
	}

	//Below will enable day mode
	public static void EnableDaymode() throws Exception {
		
		clickByXpath(Web_UI.filtericon,"filtericon");
		try{
			WebElement Nighticon = getDriver().findElement(By.xpath(Web_UI.Nightmodeenabled));
			ATUReports.add("User is in Night mode " ,  LogAs.PASSED, null);
			clickBywebelementxpath(Nighticon,"Nighticon");
			ATUReports.add("User is switched to Day Mode " ,  LogAs.PASSED, null);
			clickByXpath(Web_UI.ApplyButton,"ApplyButton");
		}catch(Exception nonightmode)
		{
			ATUReports.add("User is already in Day Mode  " ,  LogAs.PASSED, null);
			clickByXpath(Web_UI.DashboardfilterCancel,"DashboardfilterCancel");
		}
	
		Thread.sleep(10000);
		CommonTest.SpinnerControl();
	}
	
	// Verify Show etd outside functionality when Uncheck the option

	public static void UNCheckShowETDOutside() throws Exception {

		TestcaseInit();
		clickByXpath(Web_UI.filtericon,"filtericon");
		Thread.sleep(1000);
		clickByXpath(Web_UI.ViewSettings,"ViewSettings");
		Thread.sleep(1000);
		WebElement showetd = getDriver().findElement(By.xpath("//input[@id='gantt-show-etd']"));
		boolean showetdselected = showetd.isSelected();
		try{
		if(showetdselected==false){
			//showetd.click();
			ATUReports.add("Already showETDoutside is Unselected " ,  LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			
		}
		else{
			showetd.click();
			ATUReports.add(" showETDoutside is UNselected. " ,  LogAs.PASSED, null);
				
		}
		}catch(Exception Showetdnotselected){
			ATUReports.add("Issue with selecting show ETD " ,  LogAs.FAILED, null);	
		}
		
		clickByXpath(Web_UI.ApplyButton,"ApplyButton");
		Thread.sleep(9000);
		CommonTest.SpinnerControl();
		TestcaseInit();
		CommonTest.zoomindata();
		CommonTest.zoomindata();
		CommonTest.zoomindata();
		clickByXpath(Web_UI.ETD, "<MOGT");
		
		List<WebElement> Ganntlist = getDriver().findElements(By.xpath(Web_UI.PuckDepartureStatusandtime));
		int Ganntlistcount = Ganntlist.size();
		if(Ganntlistcount == 0)
		{
			ATUReports.add("*****************Gantt List is Zero and hence Exiting test smoothly*******************",  LogAs.PASSED, null);
			captureinfoScreenshot(getDriver(), "DeparturestatusValidationListZero");
		}else
		{
					
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
										
								
								String Arrivalstationdetailscomplete = gantelement.getAttribute("innerText");
								String arrivalstationsplit[] = Arrivalstationdetailscomplete.split(" ");
								String ArrivalStatus = arrivalstationsplit[0].trim();
								
								List<String> Arrivalcodelist = Arrays.asList("OFF","OUT","CXL");
								boolean contains = Arrivalcodelist.contains(ArrivalStatus);
										
								
								if(contains == true )
								{
									ATUReports.add("Flight is already departed and hence show ETD is not applicable to this flights "+i,  LogAs.PASSED, null);
									
								} else {
								
								
									String idofelement = gantelement.findElement(By.xpath("ancestor::div[1]/ancestor::div[1]/ancestor::div[1]")).getAttribute("id");
									actions.moveToElement(gantelement).build().perform();
									try{
											WebElement etdoutside = getDriver().findElement(By.xpath("//div[@id='"+idofelement+"']//div[@class='etd-outside-puck ng-scope']"));
											String etdoutsidetime  = etdoutside.getAttribute("innerText");
											if(etdoutsidetime.contains(":")){
												ATUReports.add("Show ETD details exist for the puck  "+idofelement,  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
											}
											else{
												ATUReports.add("Show ETD details not exist for the puck  "+idofelement,  LogAs.PASSED, null);
											}
									}catch(Exception id)
									{
										ATUReports.add("Show ETD details Not exist for the puck  "+idofelement,  LogAs.PASSED, null);
									}
								}
								
									}
						
		
	}catch(Exception id)
								{
		
								}
								}
				
		}

		
	}
	
	//Verify the Draw to actual GT option when UNchecked

	public static void DonotdisplayDrawtoActualGT() throws Exception {


		TestcaseInit();
		clickByXpath(Web_UI.filtericon,"filtericon");
		Thread.sleep(1000);
		clickByXpath(Web_UI.ViewSettings,"ViewSettings");
		Thread.sleep(1000);
		WebElement showetd = getDriver().findElement(By.xpath(Web_UI.Showmogt));
		boolean showetdselected = showetd.isSelected();
		try{
		if(showetdselected==true){
			showetd.click();
			ATUReports.add("Already DrawtoActual GT  is Unselected. " ,  LogAs.PASSED, null);	
		}
		else{
			
			ATUReports.add("Already DrawtoActual GT is already  UNselected " ,  LogAs.PASSED, null);	
		}
		}catch(Exception Showetdnotselected){
			ATUReports.add("Issue with selecting DrawtoActual GT   " ,  LogAs.FAILED, null);	
		}
		
		clickByXpath(Web_UI.ApplyButton,"ApplyButton");
		Thread.sleep(6000);
		CommonTest.SpinnerControl();
		
		
		try{
			clickByXpath(Web_UI.ETD,"ETD");
		
		List<WebElement> Ganntlist = getDriver().findElements(By.xpath(Web_UI.PuckDepartureStatusandtime));
		int Ganntlistcount = Ganntlist.size();
		if(Ganntlistcount == 0)
		{
			ATUReports.add("*****************Gantt List is Zero and hence Exiting test smoothly*******************",  LogAs.PASSED, null);
			captureinfoScreenshot(getDriver(), "DeparturestatusValidationListZero");
		}else
		{
					
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
									if(Linkagedetails.contains("UNL")||Linkagedetails.contains("TERM")){
										ATUReports.add("Unlinked or TERM flights and hence skipping the validation for this puck "+i,  LogAs.PASSED, null);
									}else{
										
								
								String Arrivalstationdetailscomplete = gantelement.getAttribute("innerText");
								String arrivalstationsplit[] = Arrivalstationdetailscomplete.split(" ");
								String ArrivalStatus = arrivalstationsplit[0].trim();
								
								List<String> Arrivalcodelist = Arrays.asList("OFF","OUT","CXL");
								boolean contains = Arrivalcodelist.contains(ArrivalStatus);
										
								
								if(contains == true )
								{
									ATUReports.add("Flight is already departed and hence show ETD is not applicable to this flights "+i,  LogAs.PASSED, null);
									
								} else {
								
								
									String idofelement = gantelement.findElement(By.xpath("ancestor::div[1]/ancestor::div[1]/ancestor::div[1]")).getAttribute("id");
									actions.moveToElement(gantelement).build().perform();
									try{
											WebElement etdoutside = getDriver().findElement(By.xpath("//div[@id='"+idofelement+"']/ancestor::div[@data-ng-repeat='(key, flt) in ganttObject[gate]']/div[1]"));
											String mogtdraw = etdoutside.getAttribute("id");
											
											
											if(mogtdraw.contains("TURN")||mogtdraw.contains("ORIG")||mogtdraw.contains("TERM")){
												ATUReports.add("Puck is drawn to GT"+idofelement,  LogAs.PASSED, null);
											}
											else{
												ATUReports.add("Puck is Not drawn to GT"+idofelement,  LogAs.PASSED, null);
											}
									}catch(Exception id)
									{
										ATUReports.add("Puck is Not drawn to GT"+idofelement,  LogAs.PASSED, null);
									}
								}
								
									}
						
		
	}catch(Exception id)
								{
		
								}
								}
				
		} 
		}catch(Exception elementnotexist)
		{
			ATUReports.add("<MOGT stats not present  ",  LogAs.INFO, null);
		}
		
		
	}

	
	// Select show event slide out option below from view settings page.
	public static void SelectEventslideouttobelow() throws Exception {
		TestcaseInit();
		System.out.println("");
		clickByXpath(Web_UI.filtericon,"filtericon");
		Thread.sleep(1000);
		clickByXpath(Web_UI.ViewSettings,"ViewSettings");
		Thread.sleep(1000);
		WebElement slideoutbelow = getDriver().findElement(By.xpath(Web_UI.Slideoutbelow));
		boolean slideoutbelowselected = slideoutbelow.isSelected();
		try{
		if(slideoutbelowselected==false){
			slideoutbelow.click();
			ATUReports.add("Selected Event slide out *Below* Option" ,  LogAs.PASSED, null);	
		}
		else{
			
			ATUReports.add("Event slide out *Below* is already selected " ,  LogAs.PASSED, null);	
		}
		
	}catch(Exception slideoutbelowexep ){
		
	}
		clickByXpath(Web_UI.ApplyButton,"ApplyButton");
		Thread.sleep(8000);
		CommonTest.SpinnerControl();
	}
	
	// Perform Show EOB, Uncheck show CXL , Uncheck Show UNLinked

	public static void UnSelectCXL_UNL_Showeobt() throws Exception {
		TestcaseInit();
		clickByXpath(Web_UI.filtericon,"filtericon");
		Thread.sleep(1000);
		clickByXpath(Web_UI.ViewSettings,"ViewSettings");
		Thread.sleep(1000);
		try{
			WebElement ShowCancel = getDriver().findElement(By.xpath(Web_UI.SettingShowcancelledflight));
			String ShowCancelSelected = ShowCancel.getAttribute("checked");
			if(ShowCancelSelected.equalsIgnoreCase("true")){
				ShowCancel.click();
				ATUReports.add("ShowCancel is Unchecked " ,  LogAs.PASSED, null);
			}else{
				
				ATUReports.add("ShowCancel Is already Unselected " ,  LogAs.PASSED, null);
			}
			
		}catch(Exception slideoutbelowexep ){
			
		}
try{
	WebElement ShowUnlinked = getDriver().findElement(By.xpath(Web_UI.ShowUnlinked));
	String ShowUnlinkedselected = ShowUnlinked.getAttribute("checked");		
	
	if(ShowUnlinkedselected.equalsIgnoreCase("true")){
		ShowUnlinked.click();
		ATUReports.add("Show Unlinked is Unchecked " ,  LogAs.PASSED, null);
	}else{
		
		ATUReports.add("Show Unlinked is already Unchecked" ,  LogAs.PASSED, null);
	}
	
		}catch(Exception slideoutbelowexep ){
			
		}
try{
	WebElement ShowSdt = getDriver().findElement(By.xpath("//div[@class='checkbox']/input[1]"));
	boolean ShowSdtSelected = ShowSdt.isSelected();
	
if(ShowSdtSelected==true){
	
	ATUReports.add("Show SDT is already Checked " ,  LogAs.PASSED, null);
	
	}else{
		ShowSdt.click();
		ATUReports.add("Show EDT is checked and selected " ,  LogAs.PASSED, null);
	}
	
}catch(Exception slideoutbelowexep ){
	
}

clickByXpath(Web_UI.ApplyButton,"ApplyButton");
Thread.sleep(6000);
CommonTest.SpinnerControl();
	}


}