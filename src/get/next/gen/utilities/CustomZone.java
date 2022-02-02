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


public class CustomZone extends CommonTest {

	// Below function performs station selection based on User inputs
	public static void SelectStation(String Stations) throws Exception {	
		TestcaseInit();
try{
		CommonTest.SpinnerControl();
		//GanntViewHeaderFunctionality.GanntViewSelection();
		CommonTest.SpinnerControl();
			// Select Settings
			clickByXpath(Web_UI.filtericon,"filtericon");
			Thread.sleep(5000);
			ATUReports.add("Selected Dashboard filter settings",  LogAs.PASSED, null);
			clickByXpath(Web_UI.StationorZonetabselection,"StationorZonetabselection");
			Thread.sleep(2000);
			// Select ABI Station
			clickByXpath("//span[text()='"+Stations+"']","Station to be selected");
			Thread.sleep(5000);
			CheckZonedisplaycompleted();
			ATUReports.add("Selected   Station  "+Stations,  LogAs.PASSED, null);
			Thread.sleep(5000);
			// Select create Zone
			clickByXpath(Web_UI.ApplyButton,"ApplyButton");
		ATUReports.add("Selected Apply button  ",  LogAs.PASSED, null);
			Thread.sleep(5000);
			CommonTest.SpinnerControl();
}catch(Exception ee){
	clickByXpath(Web_UI.DashboardfilterCancel,"DashboardfilterCancel");
	Thread.sleep(2000);
}
		
		

	}
	
	
	
	// Check zones are displayed as sometimes it will take more time to load the zones details.
	
	public static void CheckZonedisplaycompleted() throws Exception {
		try{
		WebElement Zoneloadingindicatior = getDriver().findElement(By.xpath(Web_UI.ZoneLoadericon));
		if(Zoneloadingindicatior!=null)
		{
			ATUReports.add("Zones Loaded Successfully",  LogAs.PASSED, null);
		}
		else{
			
			for(int Zonedisplaywait = 0; Zonedisplaywait<=3;Zonedisplaywait++)
			{
				Thread.sleep(6000);
				WebElement Zoneloadingindicatior1 = getDriver().findElement(By.xpath(Web_UI.ZoneLoadericon));
				if(Zoneloadingindicatior1!=null)
				{
					break;
				}
				else{
					ATUReports.add("Zones Not Loaded Successfully",  LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE)); 
				}
			}
		}
		
	}catch(Exception Zonenotpresent)
		{
		for(int Zonedisplaywait = 0; Zonedisplaywait<=1;Zonedisplaywait++)
		{
			Thread.sleep(3000);
			try{
			WebElement Zoneloadingindicatior1 = getDriver().findElement(By.xpath("Web_UI.ZoneLoadericon"));
			if(Zoneloadingindicatior1!=null)
			{
				break;
			}
			}catch(Exception Zoneissue)
			{
				Thread.sleep(3000);
			}
		}
		
		}
	}
	
	
	//Below will create custom zone for the selected station
	
	public static void customzonecreation() throws Exception {
		TestcaseInit();
		try{
		System.out.println("Verify custom zone creation functionality");
	CommonTest.SpinnerControl();
	GanntViewHeaderFunctionality.GanntViewSelection();
	CommonTest.SpinnerControl();
		// Select Settings
		clickByXpath(Web_UI.filtericon,"openFilter");
		Thread.sleep(2000);
		ATUReports.add("Selected Dashboard filter settings",  LogAs.PASSED, null);
		clickByXpath(Web_UI.StationorZonetabselection,"StationorZonetabselection");
		Thread.sleep(2000);
		// Select ABI Station
		clickByXpath("//span[text()='PHL']","Station");
		CheckZonedisplaycompleted();
		CheckZoneNameexistanddelete();
		ATUReports.add("Selected PHL  Station",  LogAs.PASSED, null);
		Thread.sleep(10000);
		// Select create Zone
		clickByXpath("//span[@class='plus-icon']","plus");
		ATUReports.add("Selected Add Custom Zone button to created custom zone",  LogAs.PASSED, null);
		Thread.sleep(2000);
		//Add Zone name
		SendtextbyXpath("//input[@id='customZoneText']", "AutomationZone");
		ATUReports.add("Entered text for customzone",  LogAs.PASSED, null);
		// Select 2 or 3 gates
		for(int i=0;i<=2;i++)
		{
			clickByXpath("//div[@drop='removeSelectedGates']/div[1]","removeSelectedGates");	
			
			Thread.sleep(1000);
			clickByXpath("//span[text()=' Add >>']","Add");
			Thread.sleep(1000);
		}
		ATUReports.add("Selected multiple zones",  LogAs.PASSED, null);
		clickByXpath(Web_UI.ApplyButton,"ApplyButton");
		ATUReports.add("Selected Apply button to create customzone",  LogAs.PASSED, null);
		Thread.sleep(5000);
		CommonTest.SpinnerControl();
	try
	{
		WebElement createdzone = getDriver().findElement(By.xpath("//span[text()='AutomationZone']"));
		if(createdzone!=null)
		{
			ATUReports.add("Custom Zone created successfully",  LogAs.PASSED, null);
		}
		else
		{
				ATUReports.add("Custom Zone Not created ",  LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE)); 
		}
	}
	catch(Exception EE)
	{
		
		
		ATUReports.add("Custom Zone Not created ",  LogAs.PASSED, null);
		captureinfoScreenshot(getDriver(), "Custom Zone Not created");
		try{
			clickByXpath(Web_UI.OKBUTTON,"OKBUTTON");
		}catch(Exception closeokpopup)
		{
			
		}
	}
		
		
	clickByXpath(Web_UI.ApplyButton,"ApplyButton");
	Thread.sleep(8000);
		CommonTest.SpinnerControl();
	}
	catch(Exception EE)
	{
		ATUReports.add("Custom Zone Not created ",  LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE)); 
		captureinfoScreenshot(getDriver(), "Issues in creating custom zone");
		try{
			
		}
		catch(Exception Closecustompopup)
		{
			
		}
	}
	}
	
	
	//Check whether the input station exist and delete it
	
	public static void CheckZoneNameexistanddelete() throws Exception {
		try
		{
			WebElement createdzone = getDriver().findElement(By.xpath("//span[text()='AutomationZone']"));
			if(createdzone!=null)
			{
				ATUReports.add("Custom Zone created successfully",  LogAs.PASSED, null);
				clickByXpath("//span[text()='AutomationZone']/ancestor::div[@class='checkbox lftmnu-chck']/span[@data-ng-click='delZone($event,zne)']","delZone");
				Thread.sleep(2000);
				
			}
			else
			{
				ATUReports.add("Automationzone not exist and can proceed with validation ",  LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE)); 
			}
		}
		catch(Exception EE)
		{
			ATUReports.add("Custom Zone Not Present ",  LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE)); 
			captureinfoScreenshot(getDriver(), "Custom Zone Not Present");
		}
		
	}

	
	// Verify Custom zone deletion functionality
	public static void customzonedeletion() throws Exception {
	
		System.out.println("Verify Custom Zone deletion funtionality");
		TestcaseInit();
		CommonTest.SpinnerControl();
		GanntViewHeaderFunctionality.GanntViewSelection();
		CommonTest.SpinnerControl();
		// Select Settings
		clickByXpath(Web_UI.filtericon,"filtericon");
		Thread.sleep(2000);
		ATUReports.add("Selected Dashboard filter settings",  LogAs.PASSED, null);
		clickByXpath(Web_UI.StationorZonetabselection,"StationorZonetabselection");
		Thread.sleep(2000);
		clickByXpath("//span[text()='PHL']","PHL");
		CheckZonedisplaycompleted();
		ATUReports.add("Selected PHL Station",  LogAs.PASSED, null);
		Thread.sleep(2000);

		for(int looper=1;looper<=4;looper++)
		{
			try
			{
				WebElement createdzone = getDriver().findElement(By.xpath("//span[text()='AutomationZone']"));
				if(createdzone!=null)
				{
					ATUReports.add("Custom Zone created as part of previous script exists and ready for deletion ",  LogAs.PASSED, null);
					
				}
				
			}
			catch(Exception loophole)
			{
				Thread.sleep(8000);
			}
		}
		
	try
	{
		WebElement createdzone = getDriver().findElement(By.xpath("//span[text()='AutomationZone']"));
		if(createdzone!=null)
		{
				ATUReports.add("Customzone identified",  LogAs.PASSED, null);
			try
			{
			clickByXpath("//span[text()='AutomationZone']/ancestor::div[@class='checkbox lftmnu-chck']/span[@data-ng-click='delZone($event,zne)']","Custom zone created element");
			}
			catch(Exception Deletionexeception)
			{
				Thread.sleep(2000);
				clickByXpath("//span[text()='AutomationZone']/ancestor::div[@class='checkbox lftmnu-chck']/span[@data-ng-click='delZone($event,zne)']","Custom zone created element");
			}
			Thread.sleep(2000);
			ATUReports.add("Selected delete custom zone option",  LogAs.PASSED, null);
			try{
			
			
			WebElement deletezone = getDriver().findElement(By.xpath("//span[text()='AutomationZone']"));
			
			if(deletezone!=null)
			{
				ATUReports.add("Custom Zone exist and not deleted",  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}
			else{
				ATUReports.add("Custom Zone deleted successfully",  LogAs.PASSED, null);
			}
			}catch(Exception EE)
			{
				ATUReports.add("Custom Zone deleted successfully",  LogAs.PASSED, null);
			}
		}
		else
		{
			ATUReports.add( "Custom Zone Not created ",  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		}
	}
	catch(Exception EE)
	{
		ATUReports.add("Custom Zone Not deleted -- Exception",  LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE)); 
		
		
	}
		
		
	clickByXpath(Web_UI.ApplyButton,"ApplyButton");
	Thread.sleep(15000);
		CommonTest.SpinnerControl();
	
	
}
}


		
	
	
	
	
	



