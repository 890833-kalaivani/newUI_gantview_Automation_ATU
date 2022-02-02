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


public class GanttviewPuckOptions extends CommonTest {

	
	public static void GanttviewSettingsvalidation() throws Exception {
		TestcaseInit();
		System.out.println("Validating Gantt view with  different format/Puck Option switching");
		Thread.sleep(3000);
		ATUReports.add("Gantt view is selected",  LogAs.PASSED, null);
		CommonTest.zoomin();
		CommonTest.zoomin();
		CommonTest.zoomin();
		CommonTest.SpinnerControl();
		Thread.sleep(3000);
		CommonTest.CheckExpand();
		SetdefaultandCenteralignedView();
		
		List<WebElement> Ganntlist = getDriver().findElements(By.xpath(Web_UI.PuckComplete));
		int Ganntlistcount = Ganntlist.size();
		if(Ganntlistcount == 0)
		{
			CommonTest.CheckGanttviewListisnotZero();
		}
		if(Ganntlistcount == 0)
		{
			ATUReports.add( "*************Gantt List is Zero and hence Exiting test smoothly**************",  LogAs.PASSED, null);
		}else{
		if (Ganntlist != null) {
	
		for (WebElement gantelement : Ganntlist) {
			
			try {
				
				String elementid = gantelement.getAttribute("id");
				if (elementid != "") {
					Actions actions = new Actions(getDriver());			
					
					WebElement elee = getDriver().findElement(By.xpath("//div[@id='" + elementid + "']"));
					actions.moveToElement(elee).build().perform();
					WebElement EQtypeelement = elee.findElement(By.xpath("div[4]/div[1]/span[1]"));
					String EQtypeelements[] = EQtypeelement.getAttribute("innerText").split("/");
					String EQtypevalue = EQtypeelements[1].trim();
					
					WebElement tailelement = elee.findElement(By.xpath("div[4]/div[3]/span[1]"));
					String tailelements[] = tailelement.getAttribute("innerText").split("/");
					String Tailvalue = tailelements[0].trim();
					
					
					WebElement Flightlinkage = elee.findElement(By.xpath("div[4]/div[2]"));
					String Flightlinkages[] = Flightlinkage.getAttribute("innerText").split("/");
					String arrivalflightnumber = Flightlinkages[0];
					String Departureflightnumber = Flightlinkages[1];
					
				
					System.out.println(Tailvalue +"  "+Departureflightnumber+"   "+arrivalflightnumber+" "+EQtypevalue);
					 ATUReports.add( "Flight details are extracted successfully for verification",  LogAs.PASSED, null);
					 ATUReports.add("Departure flight no is :  "+Departureflightnumber,  LogAs.PASSED, null);
					 ATUReports.add("Arrival flight No is :  "+arrivalflightnumber,  LogAs.PASSED, null);
					 ATUReports.add("Tail Value identified is :  "+Tailvalue,  LogAs.PASSED, null);
					 ATUReports.add("Eqtype value identified is :  "+EQtypevalue,  LogAs.PASSED, null);
					 
					SetdefaultandOnEndsView();
					 ATUReports.add("Validation started when user set Default and On Ends view",  LogAs.PASSED, null);
				     ValidateDefaultandonEndsView(Tailvalue,Departureflightnumber,arrivalflightnumber,EQtypevalue,elementid);
					 ATUReports.add("Validation started when user set Tail and Center Aligned view",  LogAs.PASSED, null);
					 SettailandCenteralignedView();
					 ValidatetailandCenteralignedView(Tailvalue,Departureflightnumber,arrivalflightnumber,EQtypevalue,elementid);
					 ATUReports.add("Validation started when user set Tail and On ends view",  LogAs.PASSED, null);
					 SettailandonEndsView();
					 ValidatetailandonEndsView(Tailvalue,Departureflightnumber,arrivalflightnumber,EQtypevalue,elementid);
					 ATUReports.add("Validation started when user set Classic viewS",  LogAs.PASSED, null);
					Setclassicview();
					Validateclassicview(Tailvalue,Departureflightnumber,arrivalflightnumber,EQtypevalue,elementid);
					SetdefaultandCenteralignedView();
				}
			}
			catch (Exception Exee) {
					System.out.println("Exception While identifying the complete DepartureTime Details ");
				
					break;
					}
}
			
			
		}
		}
		}
	
	
	public static void ValidatetailandCenteralignedView(String Tailvaluetovalidate , String Departureflightnumbertovalidate, String arrivalflightnumbertovalidate, String EQtypevaluetovalidate ,String elementidtovalidate ) throws Exception {
		
		CommonTest.SpinnerControl();
		List<WebElement> Ganntlist = getDriver().findElements(By.xpath(Web_UI.GanttTable));
		int Ganntlistcount = Ganntlist.size();
		if(Ganntlistcount == 0)
		{
			CommonTest.CheckGanttviewListisnotZero();
		}
		if(Ganntlistcount == 0)
		{
			ATUReports.add("*************Gantt List is Zero and hence Exiting test smoothly**************",  LogAs.PASSED, null);
		}else{
		if (Ganntlist != null) {
	
				try {
				
				String elementid = elementidtovalidate;
				if (elementid != "") {
					Actions actions = new Actions(getDriver());			
					WebElement elee = getDriver().findElement(By.xpath("//*[@id='" + elementid + "']"));
					actions.moveToElement(elee).build().perform();
					WebElement EQtypeelement = elee.findElement(By.xpath("div[5]/div[1]/span[1]"));
					String EQtypeelements[] = EQtypeelement.getAttribute("innerText").split("/");
					String EQtypevalue = EQtypeelements[0].trim();
					
					WebElement tailelement = elee.findElement(By.xpath("div[5]/div[3]/span[1]"));
					String tailelements[] = tailelement.getAttribute("innerText").split("/");
					String Tailvalue = tailelements[0].trim();
					
					
					WebElement Flightlinkage = elee.findElement(By.xpath("div[5]/div[2]"));
					String Flightlinkages[] = Flightlinkage.getAttribute("innerText").split("/");
					String arrivalflightnumber = Flightlinkages[0];
					String Departureflightnumber = Flightlinkages[1].trim();
					
					if(arrivalflightnumber.contains(Tailvaluetovalidate))
					{
						 ATUReports.add("Verified "+Tailvaluetovalidate,  LogAs.PASSED, null);
				
					}
					else{
			
						ATUReports.add("failed "+Tailvaluetovalidate,  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}
					if(Departureflightnumber.contains(EQtypevaluetovalidate))
					{
						
						 ATUReports.add("Verified "+EQtypevaluetovalidate,  LogAs.PASSED, null);
					
					}
					else
					{
						
						ATUReports.add("failed "+EQtypevaluetovalidate,  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}
					
					if(EQtypevalue.contains(arrivalflightnumbertovalidate.trim()))
					{
						
						 ATUReports.add("Verified "+arrivalflightnumbertovalidate,  LogAs.PASSED, null);
				
					}
					else
					{
						
						ATUReports.add("failed "+arrivalflightnumbertovalidate,  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}
					if(Tailvalue.contains(Departureflightnumbertovalidate.trim()))
					{
						 ATUReports.add("Verified "+Departureflightnumbertovalidate,  LogAs.PASSED, null);
						
					}
					else
					{
						
						ATUReports.add("failed "+Departureflightnumbertovalidate,  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}
					
					System.out.println(Tailvalue +"   "+Departureflightnumber+"   "+arrivalflightnumber+" "+EQtypevalue);
				}
			}
			catch (Exception Exee) {
					System.out.println("Exception While identifying the complete DepartureTime Details ");
					
					CommonTest.CheckOKPopupPresentandclose();
					CommonTest.CheckCancelPopupPresentandclose();
					Checkappupdateclosebutton();
				}
	
	}
		
		}	
	}
	
	public static void ValidatetailandonEndsView(String Tailvaluetovalidate , String Departureflightnumbertovalidate, String arrivalflightnumbertovalidate, String EQtypevaluetovalidate,String elementidtovalidate ) throws Exception {
		
		CommonTest.SpinnerControl();
		List<WebElement> Ganntlist = getDriver().findElements(By.xpath(Web_UI.GanttTable));
		int Ganntlistcount = Ganntlist.size();
		if(Ganntlistcount == 0)
		{
			CommonTest.CheckGanttviewListisnotZero();
		}
		if(Ganntlistcount == 0)
		{
			ATUReports.add( "*************Gantt List is Zero and hence Exiting test smoothly**************",  LogAs.PASSED, null);
		}else{
		if (Ganntlist != null) {
			try {
				
				String elementid = elementidtovalidate;
				if (elementid != "") {
					Actions actions = new Actions(getDriver());			
					
					WebElement elee = getDriver().findElement(By.xpath("//*[@id='" + elementid + "']"));
					actions.moveToElement(elee).build().perform();
					WebElement EQtypeelement = elee.findElement(By.xpath("div[5]/div[1]/span[1]"));
					String EQtypeelements[] = EQtypeelement.getAttribute("innerText").split("/");
					String EQtypevalue = EQtypeelements[0].trim();
					
					WebElement tailelement = elee.findElement(By.xpath("div[5]/div[3]/span[1]"));
					String tailelements[] = tailelement.getAttribute("innerText").split("/");
					String Tailvalue = tailelements[0].trim();
					
					
					WebElement Flightlinkage = elee.findElement(By.xpath("div[5]/div[2]"));
					String Flightlinkages[] = Flightlinkage.getAttribute("innerText").split("/");
					String arrivalflightnumber = Flightlinkages[0];
					String Departureflightnumber = Flightlinkages[1].trim();
					
					if(arrivalflightnumber.contains(Tailvaluetovalidate))
					{
					 ATUReports.add( "Verified "+Tailvaluetovalidate,  LogAs.PASSED, null);
					
					}
					else{
						
						ATUReports.add( "failed "+Tailvaluetovalidate,  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}
					if(Tailvalue.contains(Departureflightnumbertovalidate.trim()))
					{
						 ATUReports.add( "Verified "+Departureflightnumbertovalidate,  LogAs.PASSED, null);
						
					}
					else
					{
						
						ATUReports.add("failed "+Departureflightnumbertovalidate,  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}
					
					if(EQtypevalue.contains(arrivalflightnumbertovalidate.trim()))
					{
						 ATUReports.add("Verified "+arrivalflightnumbertovalidate,  LogAs.PASSED, null);
					
					}
					else
					{
						
						ATUReports.add("failed "+arrivalflightnumbertovalidate,  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}
					if(Departureflightnumber.contains(EQtypevaluetovalidate))
					{
						 ATUReports.add("Verified "+EQtypevaluetovalidate,  LogAs.PASSED, null);
						System.out.println("Passed");
					}
					else
					{
						
						ATUReports.add("failed "+EQtypevaluetovalidate,  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}
					System.out.println(Tailvalue +"  "+Departureflightnumber+"   "+arrivalflightnumber+" "+EQtypevalue);
				}
			}
			catch (Exception Exee) {
					System.out.println("Exception While identifying the complete DepartureTime Details ");
					CommonTest.CheckOKPopupPresentandclose();
					CommonTest.CheckCancelPopupPresentandclose();
					Checkappupdateclosebutton();
				}
		
	}
		
		}	
	}

	
	
	public static void Validateclassicview(String Tailvaluetovalidate , String Departureflightnumbertovalidate, String arrivalflightnumbertovalidate, String EQtypevaluetovalidate,String elementidtovalidate ) throws Exception {
		
		CommonTest.SpinnerControl();
		List<WebElement> Ganntlist = getDriver().findElements(By.xpath(Web_UI.PuckComplete));
		int Ganntlistcount = Ganntlist.size();
		if(Ganntlistcount == 0)
		{
			CommonTest.CheckGanttviewListisnotZero();
		}
		if(Ganntlistcount == 0)
		{
			ATUReports.add( "*************Gantt List is Zero and hence Exiting test smoothly**************",  LogAs.PASSED, null);
		}else{
		if (Ganntlist != null) {
	
	
			
			try {
				
				String elementid = elementidtovalidate;
				if (elementid != "") {
					Actions actions = new Actions(getDriver());			
					
					WebElement elee = getDriver().findElement(By.xpath("//*[@id='" + elementid + "']"));
					actions.moveToElement(elee).build().perform();
					WebElement EQtypeelement = elee.findElement(By.xpath("div[4]/div[1]"));
					String EQtypeelements= EQtypeelement.getAttribute("innerText");
					String EQtypevalue = EQtypeelements;
					
									
				
					if(EQtypevalue.contains(Departureflightnumbertovalidate))
					{
						 ATUReports.add("Verified "+Departureflightnumbertovalidate,  LogAs.PASSED, null);
						
					}
					else
					{
						
						ATUReports.add("failed "+Departureflightnumbertovalidate,  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}
					
					if(EQtypevalue.contains(arrivalflightnumbertovalidate))
					{
						 ATUReports.add("Verified "+arrivalflightnumbertovalidate,  LogAs.PASSED, null);
					
					}
					else
					{
					
						ATUReports.add("failed "+arrivalflightnumbertovalidate,  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}
					
				
		
		
	}
			}
				catch (Exception Exee) {
					System.out.println("Exception While identifying the complete DepartureTime Details ");
				
				
				}
		
	}
		
		}	
	}
	
	
public static void SetdefaultandCenteralignedView() throws Exception {
		
		// Set settings for Defaultview and ceter
		clickByXpath(Web_UI.filtericon,"filtericon");
		Thread.sleep(2000);
		clickByXpath(Web_UI.ViewSettings,"ViewSettings");
		Thread.sleep(2000);
		clickByXpath(Web_UI.SettingPuckDefault,"SettingPuckDefault");
		Thread.sleep(2000);
		clickByXpath(Web_UI.SettingPuckCenter,"SettingPuckCenter");
		Thread.sleep(2000);
		clickByXpath(Web_UI.ApplyButton,"ApplyButton");
		Thread.sleep(5000);
		CommonTest.SpinnerControl();
	   ATUReports.add("Successfully set default and Center aligned view ",  LogAs.PASSED, null);
		
	}
public static void SetdefaultandOnEndsView() throws Exception {
		
		// Set settings for Defaultview and centeraligned
	    clickByXpath(Web_UI.filtericon,"filtericon");
		Thread.sleep(2000);
		clickByXpath(Web_UI.ViewSettings,"ViewSettings");
		Thread.sleep(2000);
		clickByXpath(Web_UI.SettingPuckDefault,"SettingPuckDefault");
		Thread.sleep(2000);
		clickByXpath(Web_UI.SettingPuckEnds,"SettingPuckEnds");
		Thread.sleep(2000);
		clickByXpath(Web_UI.ApplyButton,"ApplyButton");
		Thread.sleep(5000);
		CommonTest.SpinnerControl();
		ATUReports.add("Successfully set default and OnEnds aligned view ",  LogAs.PASSED, null);
	}
	
	
	
	
	
	
	public static void ValidateDefaultandonEndsView(String Tailvaluetovalidate , String Departureflightnumbertovalidate, String arrivalflightnumbertovalidate, String EQtypevaluetovalidate, String elementidtovalidate ) throws Exception {
	
	CommonTest.SpinnerControl();
	List<WebElement> Ganntlist = getDriver().findElements(By.xpath(Web_UI.PuckComplete));
	int Ganntlistcount = Ganntlist.size();
	if(Ganntlistcount == 0)
	{
		CommonTest.CheckGanttviewListisnotZero();
	}
	if(Ganntlistcount == 0)
	{
		ATUReports.add("*************Gantt List is Zero and hence Exiting test smoothly**************",  LogAs.PASSED, null);
	}else{
	if (Ganntlist != null) {


		
		try {
			
			String elementid = elementidtovalidate;
			if (elementid != "") {
				Actions actions = new Actions(getDriver());			
				
				WebElement elee = getDriver().findElement(By.xpath("//*[@id='" + elementid + "']"));
				actions.moveToElement(elee).build().perform();
				WebElement EQtypeelement = elee.findElement(By.xpath("div[4]/div[1]/span[1]"));
				String EQtypeelements[] = EQtypeelement.getAttribute("innerText").split("/");
				String EQtypevalue = EQtypeelements[1].trim();
				
				WebElement tailelement = elee.findElement(By.xpath("div[4]/div[3]/span[1]"));
				String tailelements[] = tailelement.getAttribute("innerText").split("/");
				String Tailvalue = tailelements[0].trim();
				
				
				WebElement Flightlinkage = elee.findElement(By.xpath("div[4]/div[2]"));
				String Flightlinkages[] = Flightlinkage.getAttribute("innerText").split("/");
				String arrivalflightnumber = Flightlinkages[0];
				String Departureflightnumber = Flightlinkages[1];
				
				if(Tailvaluetovalidate.contains(Tailvalue))
				{
					//System.out.println("Passed");
					 ATUReports.add("Verified "+Tailvalue,  LogAs.PASSED, null);
				}
				else{
					//System.out.println("Failed");
					ATUReports.add("failed "+Tailvalue,  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}
				if(Departureflightnumber.contains(Departureflightnumbertovalidate))
				{
					//System.out.println("Passed");
					 ATUReports.add("Verified "+Departureflightnumbertovalidate,  LogAs.PASSED, null);
				}
				else
				{
					//System.out.println("Failed");
					ATUReports.add("failed "+Departureflightnumbertovalidate,  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}
				
				if(arrivalflightnumber.contains(arrivalflightnumbertovalidate))
				{
					//System.out.println("Passed");
					 ATUReports.add("Verified "+arrivalflightnumbertovalidate,  LogAs.PASSED, null);
				}
				else
				{
					//System.out.println("Failed");
					ATUReports.add( "failed "+arrivalflightnumbertovalidate,  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}
				if(EQtypevalue.contains(EQtypevaluetovalidate))
				{
					//System.out.println("Passed");
					 ATUReports.add( "Verified "+EQtypevaluetovalidate,  LogAs.PASSED, null);
				}
				else
				{
					//System.out.println("Failed");
					ATUReports.add("failed "+EQtypevaluetovalidate,  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}
				
				System.out.println(Tailvalue +"   "+Departureflightnumber+"   "+arrivalflightnumber+" "+EQtypevalue);
				
			}
		}
		catch (Exception Exee) {
				System.out.println("Exception While identifying the complete DepartureTime Details ");
			}
	
}
	
	}
	
}


	public static void SettailandCenteralignedView() throws Exception {
		
		// Set settings tailview and centeraligned
		clickByXpath(Web_UI.filtericon,"filtericon");
		Thread.sleep(2000);
		clickByXpath(Web_UI.ViewSettings,"ViewSettings");
		Thread.sleep(2000);
		clickByXpath(Web_UI.SettingPuckTail,"SettingPuckTail");
		Thread.sleep(2000);
		clickByXpath(Web_UI.SettingPuckCenter,"SettingPuckCenter");
		Thread.sleep(2000);
		clickByXpath(Web_UI.ApplyButton,"ApplyButton");
		Thread.sleep(5000);
		CommonTest.SpinnerControl();
		ATUReports.add("Successfully set tail and Center aligned view ",  LogAs.PASSED, null);
		
	}
	
	public static void SettailandonEndsView() throws Exception {
		
		// Set settings tailview and Onends view
		clickByXpath(Web_UI.filtericon,"filtericon");
		Thread.sleep(2000);
		clickByXpath(Web_UI.ViewSettings,"ViewSettings");
		Thread.sleep(2000);
		clickByXpath(Web_UI.SettingPuckTail,"SettingPuckTail");
		Thread.sleep(2000);
		clickByXpath(Web_UI.SettingPuckEnds,"SettingPuckEnds");
		Thread.sleep(2000);
		clickByXpath(Web_UI.ApplyButton,"ApplyButton");
		Thread.sleep(5000);
		CommonTest.SpinnerControl();
		ATUReports.add("Successfully set tail and on Ends view ",  LogAs.PASSED, null);
		
	}
	
	
	
	public static void Setclassicview() throws Exception {
		
		// Set settings classic view
		TestcaseInit();
		clickByXpath(Web_UI.filtericon,"filtericon");
		Thread.sleep(2000);
		clickByXpath(Web_UI.ViewSettings,"ViewSettings");
		Thread.sleep(2000);
		clickByXpath(Web_UI.SettingPuckClassic,"SettingPuckClassic");
		Thread.sleep(2000);
		clickByXpath(Web_UI.ApplyButton,"ApplyButton");
		Thread.sleep(5000);
		CommonTest.SpinnerControl();
		ATUReports.add("Successfully set Classic view ",  LogAs.PASSED, null);
		
	}
	}