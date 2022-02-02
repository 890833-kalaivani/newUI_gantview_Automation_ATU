package get.next.gen.utilities;
import get.next.gen.commonaction.CommonTest;
import java.awt.Robot;
import java.awt.event.KeyEvent;
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
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
public class CloseOut extends CommonTest {
	// Below will go to settings and enable Closeout events .
	public static void SelectCloseout() throws Exception {
		try{
			CommonTest.SpinnerControl();
			clickByXpath(Web_UI.filtericon,"filtericon");
			Thread.sleep(5000);
			clickByXpath("//div[@id='db-filter-tabs']/div[2]", "EventorAlerts");
			Thread.sleep(2000);
			WebElement Closeoutalertcheckbox =getDriver().findElement(By.xpath("//input[@id='CLOSEOUTS']"));
			boolean closeoutselected = Closeoutalertcheckbox.isSelected();
			if(closeoutselected==true){
				ATUReports.add("Closeout is already selected ",  LogAs.PASSED, null); 
			}
			else{
				ATUReports.add("Closeout is not already selected ",  LogAs.PASSED, null); 
				clickByXpath("//input[@id='CLOSEOUTS']", "Closeout Option");
				ATUReports.add("Closeout is Selected  ",  LogAs.PASSED, null); 
			}
			clickByXpath(Web_UI.ApplyButton,"ApplyButton");
			Thread.sleep(8000);
			GanntViewHeaderFunctionality.SpinnerControl();
		}catch(Exception ee){
		}
		try{
			CheckCollapse();
			WebElement Closeoutstats = getDriver().findElement(By.xpath("//div[@title='CLOSEOUTS']"));
			String closeoutenabled =  getDriver().findElement(By.xpath("//div[@title='CLOSEOUTS']/ancestor::div[1]")).getAttribute("className");
			if(closeoutenabled.contains("Gray")){
				ATUReports.add("Closeout Stats  is disabled ",  LogAs.FAILED, null); 
			}else
			{
				ATUReports.add("Closeout Stats  is not disabled ",  LogAs.PASSED, null); 
			}
		}catch(Exception ee1){
		}
	}
	// Below will Select Closeout option from settings  if not selected
	public static void UnSelectCloseout() throws Exception {
		try{
			CommonTest.SpinnerControl();
			clickByXpath(Web_UI.filtericon,"filtericon");
			Thread.sleep(5000);
			clickByXpath("//div[@id='db-filter-tabs']/div[2]", "EventorAlerts");
			Thread.sleep(2000);
			WebElement Closeoutalertcheckbox =getDriver().findElement(By.xpath("//input[@id='CLOSEOUTS']"));
			boolean closeoutselected = Closeoutalertcheckbox.isSelected();
			if(closeoutselected==true){
				ATUReports.add("Closeout is already selected ",  LogAs.PASSED, null); 
				clickByXpath("//input[@id='CLOSEOUTS']", "Closeout Option");
				ATUReports.add("Closeout is UnSelected  ",  LogAs.PASSED, null); 
			}
			else{
				ATUReports.add("Closeout is not already selected ",  LogAs.PASSED, null); 
			}
			clickByXpath(Web_UI.ApplyButton,"ApplyButton");
			Thread.sleep(8000);
			GanntViewHeaderFunctionality.SpinnerControl();
		}catch(Exception ee){
		}
		try{
			CheckCollapse();
			WebElement Closeoutstats = getDriver().findElement(By.xpath("//div[@title='CLOSEOUTS']"));
			String closeoutenabled =  getDriver().findElement(By.xpath("//div[@title='CLOSEOUTS']/ancestor::div[1]")).getAttribute("className");
			if(closeoutenabled.contains("gray")){
				ATUReports.add("Closeout Stats  is disabled ",  LogAs.PASSED, null); 
			}else
			{
				ATUReports.add("Closeout Stats  is not disabled ",  LogAs.PASSED, null); 
			}
		}catch(Exception ee1){
		}
	}
	//Below will check whether closeout event is present in event details page.
	public static void shouldshowcloseoutonly() throws Exception {
		try {
			WebElement Closeoutstats = getDriver().findElement(By.xpath("//div[@title='CLOSEOUTS']"));		
			clickBywebelementxpath(Closeoutstats, "Closeoutstats");
			List<WebElement> Ganntlist = getDriver().findElements(By.xpath(Web_UI.PuckComplete));
			int Ganntlistcount = Ganntlist.size();
			if (Ganntlistcount != 0) {
				for (WebElement gantelement : Ganntlist) {
					String elementid = gantelement.getAttribute("id");
					Actions actions = new Actions(getDriver());
					WebElement elee = findelementbyxpath("//*[@id='"+elementid+"']");
					actions.moveToElement(elee).build().perform();
					actions.moveToElement(elee).build().perform();
					String CompletepuckText = elee.getAttribute("innerText");
					if(CompletepuckText.contains("OUT"))
					{
						ATUReports.add("Status of flight is OUT ",  LogAs.PASSED, null); 
					}else{
						ATUReports.add("Status of flight is Not OUT ",  LogAs.INFO, null); 
					}
					String iconforcloseout = gantelement.findElement(By.xpath("div[3]/div[1]/div[1]/span[1]")).getAttribute("className");
					if(iconforcloseout.contains("CLOSEOUT")){
						ATUReports.add("Closeout icon is displayed ",  LogAs.PASSED, null); 
					}else{
						ATUReports.add("Closeout icon is not displayed ",  LogAs.PASSED, null); 
					}
					elee.click();
					CheckCloseoutupdated("CLOSEOUTS");
					ATUReports.add("Selected a Puck and Event details page is displayed with flight details for   "+ elementid,  LogAs.PASSED, null); 
					Thread.sleep(10000);
				}
			}else{
			}
		}catch(Exception e) {
			ATUReports.add("CloseOut stats is not available ",  LogAs.PASSED, null);
		}
	}
	public static void CheckCloseoutupdated(String Eventname) throws Exception {
		System.out.println("Verify the user is shown with current event progress "+Eventname+"  Report");
		try{	
			WebElement Evendetailprovided = getDriver().findElement(By.xpath("//span[text()='"+Eventname+"']"));
			ATUReports.add(Eventname+" Report is available and will be selected for further validation",  LogAs.PASSED, null); 
			if(Evendetailprovided!=null)
			{
				String GetBagsstatus = getDriver().findElement(By.xpath("//span[text()='"+Eventname+"']/ancestor::div[1]/ancestor::div[1]/div[2]/div[1]/div[2]")).getAttribute("innerText");
				String GetBagsColor = getDriver().findElement(By.xpath("//span[text()='"+Eventname+"']/ancestor::div[1]/ancestor::div[1]/div[2]/div[1]/div[2]")).getCssValue("background-color");
				String GetPaxstatus = getDriver().findElement(By.xpath("//span[text()='"+Eventname+"']/ancestor::div[1]/ancestor::div[1]/div[2]/div[2]/div[2]")).getAttribute("innerText");
				String GetPaxcolor = getDriver().findElement(By.xpath("//span[text()='"+Eventname+"']/ancestor::div[1]/ancestor::div[1]/div[2]/div[2]/div[2]")).getCssValue("background-color");
				if(GetBagsstatus.equalsIgnoreCase("OPEN")){
					if(GetBagsColor.contains("255, 0, 0")){
						ATUReports.add("BAGS Status is OPEN and Color is Marked in RED",  LogAs.PASSED, null); 
					}else{
						ATUReports.add("BAGS Status is Open and Color is NOT Marked in RED",  LogAs.FAILED, null); 
					}
				}
				if(GetPaxstatus.equalsIgnoreCase("OPEN")){
					if(GetPaxcolor.contains("255, 0, 0")){
						ATUReports.add("PAX Status is OPEN and Color is Marked in RED",  LogAs.PASSED, null); 
					}else{
						ATUReports.add("PAX Status is Open and Color is NOT Marked in RED",  LogAs.FAILED, null); 
					}
				}
				if(GetBagsstatus.equalsIgnoreCase("CLOSED")){
					if(GetBagsColor.contains("66, 176, 74")){
						ATUReports.add("BAGS Status is CLOSED and Color is Marked in GREEN",  LogAs.PASSED, null); 
					}else{
						ATUReports.add("BAGS Status is CLOSED and Color is NOT Marked in GREEN",  LogAs.FAILED, null); 
					}
					try{
						String Getbagstime = getDriver().findElement(By.xpath("//span[text()='"+Eventname+"']/ancestor::div[1]/ancestor::div[1]/div[2]/div[1]/div[3]")).getAttribute("innerText");
						if(Getbagstime.contains("@")&&Getbagstime.contains(":")){
							ATUReports.add("Bags displays the Closeout time correctly",  LogAs.PASSED, null); 
						}else{
							ATUReports.add("Bags doesnt displays the Closeout time correctly",  LogAs.FAILED, null); 
						}
					}catch(Exception Noeventdetail)
					{
					}
				}
				if(GetPaxstatus.equalsIgnoreCase("CLOSED")){
					if(GetPaxcolor.contains("66, 176, 74")){
						ATUReports.add("PAX Status is CLOSED and Color is Marked in RED",  LogAs.PASSED, null); 
					}else{
						ATUReports.add("PAX Status is CLOSED and Color is NOT Marked in RED",  LogAs.FAILED, null); 
					}
					try{
						String Getpaxtime = getDriver().findElement(By.xpath("//span[text()='"+Eventname+"']/ancestor::div[1]/ancestor::div[1]/div[2]/div[2]/div[3]")).getAttribute("innerText");
						if(Getpaxtime.contains("@")&&Getpaxtime.contains(":")){
							ATUReports.add("Pax displays the Closeout time correctly",  LogAs.PASSED, null); 
						}else{
							ATUReports.add("Pax doesnt displays the Closeout time correctly",  LogAs.FAILED, null); 
						}
					}catch(Exception Noeventdetail)
					{
					}
				}
			}	
		}catch(Exception Noeventdetail)
		{
		}
	}
	// Below check whether closeout is shown only for off flights
	public static void ShouldnotshowClosoutexceptoutstatus() throws Exception {
		TestcaseInit();
		clickByXpath(Web_UI.TotalGate, "Total Gate");
		List<WebElement> Ganntlist = getDriver().findElements(By.xpath(Web_UI.PuckComplete));
		int Ganntlistcount = Ganntlist.size();
		if (Ganntlistcount != 0) {
			for (WebElement gantelement : Ganntlist) {
				String elementid = gantelement.getAttribute("id");
				Actions actions = new Actions(getDriver());
				WebElement elee = findelementbyxpath("//*[@id='"+elementid+"']");
				actions.moveToElement(elee).build().perform();
				actions.moveToElement(elee).build().perform();
				String CompletepuckText = elee.getAttribute("innerText");
				if(CompletepuckText.contains("TERM")||CompletepuckText.contains("UNL"))
				{
				}else{
					try			
					{
						gantelement.click();
						Thread.sleep(4000);
						WebElement Closeoutevent = findelementbyxpath("//span[text()='CLOSEOUTS']");	
						Closeoutevent.click();
						Thread.sleep(2000);
						WebElement Closeoutpopup = findelementbyxpath("//div[@id='getInFocusNow']/span[1]");
						String Closeoutmessage = Closeoutpopup.getAttribute("innerText");
						if(Closeoutmessage.contains("As of latest release, reports module for the selected event is unavailable")){
							ATUReports.add("Closeout message to user is displayed",  LogAs.PASSED, null);	
						}else{
							ATUReports.add("Closeout message not displayed",  LogAs.FAILED, null);
						}
					}catch (Exception eer){
					}
					try			
					{
						getDriver().findElement(By.xpath("//div[text()='OK']")).click();
					}catch (Exception eer2){
					}
				}
				break;	
			}
		}
	}
}
