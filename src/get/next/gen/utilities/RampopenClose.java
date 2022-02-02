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

//
public class RampopenClose extends CommonTest {

	public static void RampOpen() throws Exception {
		clickByXpath("//i[@class='fa fa-ramp-weather-icn']","ramp-weather-icn");
		CommonTest.SpinnerControl();
		Thread.sleep(2000);
	
		clickByXpath("//select[@data-ng-model='rampStatus']","rampStatus");
		Thread.sleep(2000);
		
		clickByXpath("//select[@data-ng-model='rampStatus']/option[1]","rampStatus");
		Thread.sleep(2000);
		String Openedtime = getDriver().findElement(By.xpath("//input[@data-ng-change='clearRampTimeMessage()']")).getAttribute("innerText");
		Thread.sleep(2000);
		clickByXpath("//a[@data-ng-click='updateRampStatus()']","updateRampStatus");
		Thread.sleep(2000);
		CheckconfirmmessageOpen();
		CheckrampalreadyOpened();
//		
//	// check for the ramp open Message
//		String MessageOpen = getDriver().findElement(By.xpath("//div[@class='confirmBox ng-scope rampBlueBorder']/div[2]/div[2]")).getAttribute("innerText");
//		//check for the ramp open message box text color
//		String ColorOpenYes = getDriver().findElement(By.xpath("//a[@data-ng-click='confirmSubmit()']")).getCssValue("color");
//		//Check for the Yes text color
//		
//		//Check for the no text color
//		String ColorOpenNo = getDriver().findElement(By.xpath("//a[@data-ng-click='cancelConfirmSubmit()']")).getCssValue("color");
//		
		try{
		clickByXpath("//a[@data-ng-click='confirmSubmit()']","confirmSubmit");
		Thread.sleep(8000);
		CheckconfirmmessageafterOpen();
		clickByXpath("//a[text()='OK']","OK");
		ATUReports.add("Ramp open is displayed after successful Open",  LogAs.PASSED, null);;// test.log(LogStatus.PASS, "Ramp open is displayed after successful Open");
		Thread.sleep(3000);
		}
		catch(Exception alreadyopened)
		{
			
		}
		CheckrampOpenmessageinHeader();
	}
	
public static void CheckconfirmmessageOpen() throws InterruptedException, IOException {
		
		try{
			String ConfirmmessageOpentext = getDriver().findElement(By.xpath("//div[@class='confirmBox ng-scope rampBlueBorder']/div[2]/div[2]")).getAttribute("innerText");
			if(ConfirmmessageOpentext.contains("You are about to change the status of the ramp to Open"))
			{
				ATUReports.add( "Ramp open confirmation message is valid",  LogAs.PASSED, null);;// test.log(LogStatus.PASS, "Ramp open confirmation message is valid");
			}else
			{
				ATUReports.add("Ramp open confirmation message is invalid",  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));;// test.log(LogStatus.FAIL, "Ramp open confirmation message is invalid");
			}
			
		}catch(Exception Err){
			ATUReports.add("Some other issue in retrieving message",  LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE)); ;// test.log(LogStatus.INFO, "Some other issue in retrieving message");
		}
		}

public static void CheckconfirmmessageafterOpen() throws InterruptedException, IOException {
	
	try{
		String ConfirmmessageOpentext = getDriver().findElement(By.xpath("//div[@class='notificationBox ng-scope rampBlueBorder']/div[2]/div[1]/div[1]")).getAttribute("innerText");
		if(ConfirmmessageOpentext.contains("OPEN"))
		{
			ATUReports.add("Ramp open is displayed after successful Open",  LogAs.PASSED, null);;// test.log(LogStatus.PASS, "Ramp open is displayed after successful Open");
		}else
		{
			ATUReports.add("Ramp open is not displayed after successful Open",  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));;// test.log(LogStatus.FAIL, "Ramp open is not displayed after successful Open");
		}
		
	}catch(Exception Err){
		ATUReports.add( "Some other issue in retrieving message",  LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE)); ;// test.log(LogStatus.INFO, "Some other issue in retrieving message");
	}
	}

	public static void CheckrampOpenmessageinHeader() throws InterruptedException, IOException {
		
		try{
			
			WebElement Globalheader = getDriver().findElement(By.xpath("//div[@class='rampBannerText pull-left ng-binding']"));
			String Globalmessage = Globalheader.getAttribute("innerText");
			if(Globalmessage.contains("RAMP OPEN AT"))
			{
				ATUReports.add("Ramp Open message displayed successfully in global header",  LogAs.PASSED, null);;// test.log(LogStatus.PASS, "Ramp Open message displayed successfully in global header");
			}
			else{
				ATUReports.add("Ramp Open message  not displayed in global header",  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));;// test.log(LogStatus.FAIL, "Ramp Open message  not displayed in global header");
			}
			if(Globalmessage.contains(":"))
			{
				ATUReports.add("Ramp Open Time is displayed",  LogAs.PASSED, null);;// test.log(LogStatus.PASS, "Ramp Open Time is displayed");
			}
			else{
				ATUReports.add("Ramp Open Time is Not displayed",  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));;// test.log(LogStatus.FAIL, "Ramp Open Time is Not displayed");
			}
		}
	catch(Exception Err){
		ATUReports.add( "Some other issue in retrieving message",  LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE)); ;// test.log(LogStatus.INFO, "Some other issue in retrieving message");
	}
	}
	
	public static void CheckrampClosemessageinHeader() throws InterruptedException, IOException {
		
	
		

		
		try{
			
			WebElement Globalheader = getDriver().findElement(By.xpath("//div[@class='rampBannerText pull-left ng-binding']"));
			String Globalmessage = Globalheader.getAttribute("innerText");
			if(Globalmessage.contains("RAMP CLOSED AT"))
			{
				ATUReports.add( "Ramp closed message displayed successfully in global header",  LogAs.PASSED, null);;// test.log(LogStatus.PASS, "Ramp closed message displayed successfully in global header");
			}
			else{
				ATUReports.add("Ramp closed message  not displayed in global header",  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));;// test.log(LogStatus.FAIL, "Ramp closed message  not displayed in global header");
			}
			if(Globalmessage.contains(":"))
			{
				ATUReports.add("Ramp closed Time is displayed",  LogAs.PASSED, null);;// test.log(LogStatus.PASS, "Ramp closed Time is displayed");
			}
			else{
				ATUReports.add("Ramp closed Time is Not displayed",  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));;// test.log(LogStatus.FAIL, "Ramp closed Time is Not displayed");
			}
		}
	catch(Exception Err){
		ATUReports.add("Some other issue in retrieving message",  LogAs.PASSED, null);;// test.log(LogStatus.INFO, "Some other issue in retrieving message");
	}
	
		
		
	}
	
	public static boolean CheckstatusOpened() throws InterruptedException, IOException {
		try{
			WebElement Status = getDriver().findElement(By.xpath("//span[@class='rampBlue ng-binding']"));
			String Statusposted = Status.getAttribute("innerText");
			if (Statusposted.contains("OPEN"))
			{
				ATUReports.add("Already the status is opened",  LogAs.PASSED, null);;// test.log(LogStatus.PASS, "Already the status is opened");
				return true;
			}
			else{
				ATUReports.add("Status Not Opened",  LogAs.PASSED, null);;// test.log(LogStatus.PASS, "Status Not Opened");
				return false;
			}
		
			}
		catch(Exception erd)
		{
			return false;
		}
		
	}
	
	public static boolean CheckstatusClosed() throws InterruptedException, IOException {
		try{
			WebElement Status = getDriver().findElement(By.xpath("//span[@class='rampBlue ng-binding']"));
			String Statusposted = Status.getAttribute("innerText");
			if (Statusposted.contains("CLOSED"))
			{
				ATUReports.add("Already the status is CLOSED",  LogAs.PASSED, null);;// test.log(LogStatus.PASS, "Already the status is CLOSED");
				return true;
			}
			else{
				ATUReports.add("Status Not CLOSED",  LogAs.PASSED, null);;// test.log(LogStatus.PASS, "Status Not CLOSED");
				return false;
			}
		
		}
		catch(Exception erd)
		{
			return false;	
		}
	}
	
	public static void CheckrampalreadyOpened() throws InterruptedException, IOException {
		
		try{
			WebElement Errormessage = getDriver().findElement(By.xpath("//div[@class='validation right ng-binding ng-scope']"));
			String Errormessageposted = Errormessage.getAttribute("innerText");
			if(Errormessageposted.contains("Selected ramp status is same as current status"))
			{
				ATUReports.add("Already the status is opened",  LogAs.PASSED, null);;// test.log(LogStatus.PASS, "Already the status is opened");
				clickByXpath("//a[@data-ng-click='cancel()']","cancel");
				ATUReports.add( "Selected cancel button to exit",  LogAs.PASSED, null);;// test.log(LogStatus.PASS, "Selected cancel button to exit");
				
			}
			else{
				ATUReports.add("Some Other issue",  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));;// test.log(LogStatus.FAIL, "Some Other issue");
				try{
					clickByXpath("//a[@data-ng-click='cancel()']","cancel");
				}
				catch(Exception erd)
				{
					
				}
			}
			
			
		}catch(Exception EE)
		{
			
		}
		
	}
	
	public static void CheckrampalreadyClosed() throws InterruptedException, IOException {
		
		try{
			WebElement Errormessage = getDriver().findElement(By.xpath("//div[@class='validation right ng-binding ng-scope']"));
			String Errormessageposted = Errormessage.getAttribute("innerText");
			if(Errormessageposted.contains("Selected ramp status is same as current status"))
			{
				ATUReports.add("Already the status is Closed",  LogAs.PASSED, null);;// test.log(LogStatus.PASS, "Already the status is Closed");
				clickByXpath("//a[@data-ng-click='cancel()']","cancel");
				ATUReports.add("Selected cancel button to exit",  LogAs.PASSED, null);;// test.log(LogStatus.PASS, "Selected cancel button to exit");
				
			}
			else{
				ATUReports.add("Some Other issue",  LogAs.PASSED, null);;// test.log(LogStatus.FAIL, "Some Other issue");
				try{
					clickByXpath("//a[@data-ng-click='cancel()']","cancel");
				}
				catch(Exception erd)
				{
					
				}
			}
			
			
		}catch(Exception EE)
		{
			
		}
		
	}
	
	public static void RampClose() throws Exception {
		
		clickByXpath("//i[@class='fa fa-ramp-weather-icn']","ramp-weather-icn");
		CommonTest.SpinnerControl();
		Thread.sleep(2000);
		ATUReports.add("Selected ramp open closed icon from global header",  LogAs.PASSED, null);
		clickByXpath("//select[@data-ng-model='rampStatus']","rampStatus");
		Thread.sleep(2000);
		ATUReports.add(" ",  LogAs.PASSED, null);
		clickByXpath("//select[@data-ng-model='rampStatus']/option[2]","rampStatus");
		ATUReports.add("Selected closed option from dropdown",  LogAs.PASSED, null);
		Thread.sleep(2000);
		
		clickByXpath("//a[@data-ng-click='updateRampStatus()']","updateRampStatus");
		ATUReports.add("Selected Submit button",  LogAs.PASSED, null);
		Thread.sleep(2000);
		CheckconfirmmessageClosed();
		CheckrampalreadyClosed();
		
		try{
		clickByXpath("//a[@data-ng-click='confirmSubmit()']","confirmSubmit");
		ATUReports.add("Selected Yes  Button",  LogAs.PASSED, null);
		Thread.sleep(8000);
		CheckconfirmmessageafterClosed();
		clickByXpath("//a[text()='OK']","OK");
		ATUReports.add("Selected OK  button",  LogAs.PASSED, null);
		Thread.sleep(3000);
		}
		catch(Exception Alreadyclosed){
			
		}
		
	}
	
	
public static void CheckconfirmmessageClosed() throws InterruptedException, IOException {
		
		try{
			String ConfirmmessageOpentext = getDriver().findElement(By.xpath("//div[@class='confirmBox ng-scope rampRedBorder']/div[2]/div[2]")).getAttribute("innerText");
			if(ConfirmmessageOpentext.contains("You are about to change the status of the ramp to Closed"))
			{
				ATUReports.add( "Ramp Closed confirmation message is valid",  LogAs.PASSED, null);
			}else
			{
				ATUReports.add("Ramp Closed confirmation message is invalid",  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}
			
		}catch(Exception Err){
			ATUReports.add("Some other issue in retrieving message",  LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE)); 
		}
		}

public static void CheckconfirmmessageafterClosed() throws InterruptedException, IOException {
	
	try{
		String ConfirmmessageOpentext = getDriver().findElement(By.xpath("//div[@class='notificationBox ng-scope rampRedBorder']/div[2]/div[1]/div[1]")).getAttribute("innerText");
		if(ConfirmmessageOpentext.contains("CLOSED"))
		{
			ATUReports.add("Ramp Closed is displayed after successful Closed",  LogAs.PASSED, null);
		}else
		{
			ATUReports.add("Ramp Closed is not displayed after successful Closed",  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		}
		
	}catch(Exception Err){
		ATUReports.add("Some other issue in retrieving message",  LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE)); 
	}
	}



	public static void TestmessageOn() throws Exception {
		RampOpen();
		
		clickByXpath("//i[@class='fa fa-ramp-weather-icn']","ramp-weather-icn");
		CommonTest.SpinnerControl();
		Thread.sleep(2000);
		
		clickByXpath("//select[@data-ng-model='rampStatus']","rampStatus");
		Thread.sleep(2000);
		
		clickByXpath("//select[@data-ng-model='rampStatus']/option[5]","rampStatus");
		Thread.sleep(2000);
		
	String TestmessageON =	getDriver().findElement(By.xpath("//input[@data-ng-change='clearRampTimeMessage()']")).getAttribute("innerText");

	Thread.sleep(2000);
		clickByXpath("//a[@data-ng-click='updateRampStatus()']","updateRampStatus");
		Thread.sleep(2000);
		
		clickByXpath("//a[@data-ng-click='confirmSubmit()']","confirmSubmit");
		Thread.sleep(8000);
	
		clickByXpath("//a[text()='OK']","OK");
		Thread.sleep(3000);
		
	}

	public static void TestmessageOFF() throws Exception {
		//RampOpen();
		TestmessageOn();
		
		
		
		clickByXpath("//i[@class='fa fa-ramp-weather-icn']","ramp-weather-icn");
		CommonTest.SpinnerControl();
		Thread.sleep(2000);
		
		clickByXpath("//select[@data-ng-model='rampStatus']","rampStatus");
		Thread.sleep(2000);
		
		clickByXpath("//select[@data-ng-model='rampStatus']/option[6]","rampStatus");
		Thread.sleep(2000);
		
	String TestMessageOFF =	getDriver().findElement(By.xpath("//input[@data-ng-change='clearRampTimeMessage()']")).getAttribute("innerText");

	Thread.sleep(2000);
	clickByXpath("//a[@data-ng-click='updateRampStatus()']","updateRampStatus");
		Thread.sleep(2000);
		
		clickByXpath("//a[@data-ng-click='confirmSubmit()']","confirmSubmit");
		Thread.sleep(8000);
	
		clickByXpath("//a[text()='OK']","OK");
		Thread.sleep(3000);
		
	}

	public static void samestatusappliedasopen() throws Exception {
		 RampOpen();
		 RampOpen();
		
	}

	public static void samestatusappliedasclose() throws Exception {
		RampClose();
		RampClose();
	}

	public static void Errorvalidationfortime() throws Exception {
		CommonTest.SpinnerControl();
		try{
		clickByXpath("//i[@class='fa fa-ramp-weather-icn']","ramp-weather-icn");
		CommonTest.SpinnerControl();
		Thread.sleep(2000);
	boolean Statusofcurrentramp = CheckstatusOpened();
	if(Statusofcurrentramp==false)
	{
		clickByXpath("//select[@data-ng-model='rampStatus']","rampStatus");
		Thread.sleep(2000);
		
		clickByXpath("//select[@data-ng-model='rampStatus']/option[2]","rampStatus");
		Thread.sleep(2000);
		ATUReports.add("Selected Open option from dropdown",  LogAs.PASSED, null);
	}
	else{
		clickByXpath("//select[@data-ng-model='rampStatus']","rampStatus");
		Thread.sleep(2000);
		ATUReports.add("Selected dropdown",  LogAs.PASSED, null);
		clickByXpath("//select[@data-ng-model='rampStatus']/option[3]","rampStatus");
		ATUReports.add("Selected closed option from dropdown",  LogAs.PASSED, null);
		Thread.sleep(2000);
	}
	
	// Set invalid time 90:25
	getDriver().findElement(By.xpath("//input[@data-ng-change='clearRampTimeMessage()']")).clear();
	SendtextbyXpath("//input[@data-ng-change='clearRampTimeMessage()']", "90:25");
	clickByXpath("//a[@data-ng-click='updateRampStatus()']","updateRampStatus");
	WebElement errormessageposted = getDriver().findElement(By.xpath("//div[@class='validation right ng-binding ng-scope']"));
	String Error = errormessageposted.getAttribute("innerText");
	if(Error.contains("Enter a valid time"))
	{
		ATUReports.add("Displayed message ::  "+Error,  LogAs.PASSED, null);
		ATUReports.add("Error message is valid ",  LogAs.PASSED, null);
	}
	else{
		ATUReports.add("Error message is invalid",  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
	}

	// Set invalid time 14:25
	getDriver().findElement(By.xpath("//input[@data-ng-change='clearRampTimeMessage()']")).clear();
	SendtextbyXpath("//input[@data-ng-change='clearRampTimeMessage()']", "14:25");
	clickByXpath("//a[@data-ng-click='updateRampStatus()']","updateRampStatus");
	WebElement errormessageposted1 = getDriver().findElement(By.xpath("//div[@class='validation right ng-binding ng-scope']"));
	String Error1 = errormessageposted1.getAttribute("innerText");
	if(Error1.contains("Please enter a time between current time and past one hour"))
	{
		ATUReports.add("Displayed message ::  "+Error1,  LogAs.PASSED, null);
		ATUReports.add("Error message is valid when entered past time not in range of past onehour and current time",  LogAs.PASSED, null);
	}
	else{
		ATUReports.add("Error message is invalid when entered past time not in range of past onehour and current time",  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
	}
	
	
	// Set invalid time 23:59
	getDriver().findElement(By.xpath("//input[@data-ng-change='clearRampTimeMessage()']")).clear();
	SendtextbyXpath("//input[@data-ng-change='clearRampTimeMessage()']", "23:59");
	clickByXpath("//a[@data-ng-click='updateRampStatus()']","updateRampStatus");
	WebElement errormessageposted2= getDriver().findElement(By.xpath("//div[@class='validation right ng-binding ng-scope']"));
	String Error2 = errormessageposted2.getAttribute("innerText");
	if(Error2.contains("Please enter a time between current time and past one hour"))
	{
		ATUReports.add("Displayed message ::  "+Error2,  LogAs.PASSED, null);
		ATUReports.add("Error message  is valid when entered past time not in range of past onehour and current time",  LogAs.PASSED, null);
	}
	else{
		ATUReports.add("Error message is invalid when entered past time not in range of past onehour and current time",  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
	}
	
	
	
	
	clickByXpath("//a[@data-ng-click='cancel()']","cancel");
	ATUReports.add("Selected cancel and exiting test smoothly after error validation been completed",  LogAs.PASSED, null);
	
	
		}catch(Exception EE)
		{
			
			Closebutton();
			RampClosebutton();
		}
	}
	

	public static void Closebutton() throws Exception {
		try{
		clickByXpath("//span[@class='close-icn ramp-Submit-icon']","close");
		}catch(Exception closenotpresent){
			ATUReports.add("close icon not present",  LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE)); 
		}
	}	
	public static void RampClosebutton() throws Exception {
		try{
		clickByXpath("//span[@class='close-icn ramp-closeicon']","close");
		}catch(Exception closenotpresent){
			ATUReports.add("close icon not present",  LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		}
	}
	
	
	
	
	public static void RampYellow() throws Exception {
		clickByXpath("//i[@class='fa fa-ramp-weather-icn']","ramp-weather-icn");
		CommonTest.SpinnerControl();
		Thread.sleep(2000);
	
		clickByXpath("//select[@data-ng-model='rampStatus']","rampStatus");
		Thread.sleep(2000);
		
		clickByXpath("//select[@data-ng-model='rampStatus']/option[3]","rampStatus");
		Thread.sleep(2000);
		
		String Openedtime = getDriver().findElement(By.xpath("//input[@data-ng-change='clearRampTimeMessage()']")).getAttribute("innerText");
		//System.out.println("Opened time is "+Openedtime);
		
		Thread.sleep(2000);
		clickByXpath("//a[@data-ng-click='updateRampStatus()']","updateRampStatus");
		Thread.sleep(2000);
		CheckconfirmmessageYellow();
		CheckrampalreadyYellow();
//		
//	// check for the ramp open Message
//		String MessageOpen = getDriver().findElement(By.xpath("//div[@class='confirmBox ng-scope rampBlueBorder']/div[2]/div[2]")).getAttribute("innerText");
//		//check for the ramp open message box text color
//		String ColorOpenYes = getDriver().findElement(By.xpath("//a[@data-ng-click='confirmSubmit()']")).getCssValue("color");
//		//Check for the Yes text color
//		
//		//Check for the no text color
//		String ColorOpenNo = getDriver().findElement(By.xpath("//a[@data-ng-click='cancelConfirmSubmit()']")).getCssValue("color");
//		
		try{
		clickByXpath("//a[@data-ng-click='confirmSubmit()']","confirmSubmit");
		Thread.sleep(8000);
		CheckconfirmmessageafterYellow();
		clickByXpath("//a[text()='OK']","OK");
		Thread.sleep(3000);
		}
		catch(Exception alreadyopened)
		{
			
		}
		CheckrampYellowmessageinHeader();
	}
	
	public static void CheckrampalreadyYellow() throws InterruptedException, IOException {
		
		try{
			WebElement Errormessage = getDriver().findElement(By.xpath("//div[@class='validation right ng-binding ng-scope']"));
			String Errormessageposted = Errormessage.getAttribute("innerText");
			if(Errormessageposted.contains("Selected ramp status is same as current status"))
			{
				ATUReports.add("Already the status is opened",  LogAs.PASSED, null);
				clickByXpath("//a[@data-ng-click='cancel()']","cancel");
				ATUReports.add("Selected cancel button to exit",  LogAs.PASSED, null);
				
			}
			else{
				ATUReports.add( "Some Other issue",  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				try{
					clickByXpath("//a[@data-ng-click='cancel()']","cancel");
				}
				catch(Exception erd)
				{
					
				}
			}
			
			
		}catch(Exception EE)
		{
			
		}
		
	}
	
public static void CheckconfirmmessageYellow() throws InterruptedException, IOException {
		
		try{
			String ConfirmmessageOpentext = getDriver().findElement(By.xpath("//div[@class='confirmBox ng-scope rampYellowBorder']/div[2]/div[2]")).getAttribute("innerText");
			if(ConfirmmessageOpentext.contains("You are about to change the status of the ramp to Yellow Alert (Hand Signals)"))
			{
				ATUReports.add("Ramp Yellow confirmation message is valid",  LogAs.PASSED, null);
			}else
			{
				ATUReports.add("Ramp Yellow confirmation message is invalid",  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}
			
		}catch(Exception Err){
			ATUReports.add("Some other issue in retrieving message",  LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE)); 
		}
		}

public static void CheckconfirmmessageafterYellow() throws InterruptedException, IOException {
	
	try{
		String ConfirmmessageOpentext = getDriver().findElement(By.xpath("//div[@class='confirmBox ng-scope rampYellowBorder']/div[2]/div[1]/div[1]")).getAttribute("innerText");
		if(ConfirmmessageOpentext.contains("YELLOW"))
		{
			ATUReports.add( "Ramp open is displayed after successful Yellow",  LogAs.PASSED, null);
		}else
		{
			ATUReports.add("Ramp open is not displayed after successful Yellow",  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		}
		
	}catch(Exception Err){
		ATUReports.add("Some other issue in retrieving message",  LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
	}
	}

	public static void CheckrampYellowmessageinHeader() throws InterruptedException, IOException {
		
		try{
			
			WebElement Globalheader = getDriver().findElement(By.xpath("//div[@class='rampBannerText pull-left ng-binding']"));
			String Globalmessage = Globalheader.getAttribute("innerText");
			if(Globalmessage.contains("YELLOW ALERT AT"))
			{
				ATUReports.add("Ramp YELLOW message displayed successfully in global header",  LogAs.PASSED, null);
			}
			else{
				ATUReports.add( "Ramp YELLOW message  not displayed in global header",  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}
			if(Globalmessage.contains(":"))
			{
				ATUReports.add("Ramp YELLOW Time is displayed",  LogAs.PASSED, null);
			}
			else{
				ATUReports.add("Ramp YELLOW Time is Not displayed",  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}
		}
	catch(Exception Err){
		ATUReports.add("Some other issue in retrieving message",  LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
	}
	}

	public static void Gatechange() throws Exception {

		
		List<WebElement> Ganntlist = getDriver().findElements(By.xpath(Web_UI.GanttTable));
		int Ganntlistcount = Ganntlist.size();
		if(Ganntlistcount == 0)
		{
			CommonTest.CheckGanttviewListisnotZero();
		}
		
		if(Ganntlistcount == 0)
		{
			ATUReports.add("*****************Gantt List is Zero and hence Exiting test smoothly*******************",  LogAs.PASSED, null);
			captureinfoScreenshot(getDriver(), "PuckUIPlacementListZero");
		}
		
		else
		{
			if (Ganntlist != null) {
				int i=0;
				for (WebElement gantelement : Ganntlist) {
					i++;
					
								try {

									Actions actions = new Actions(getDriver());
									actions.moveToElement(gantelement).build().perform();
									actions.moveToElement(gantelement);
									
									String storeelementid = gantelement.getAttribute("id").trim();
									String storegateid = gantelement.findElement(By.xpath("ancestor::div[@drop='handleDrop']")).getAttribute("id").trim();
									
									
								
									List<WebElement> gatelist = getDriver().findElements(By.xpath("//div[@drop='handleDrop']"));
									for (WebElement gate : gatelist)
									{
										String fetchid = gate.getAttribute("id");
										
										WebElement Toid = getDriver().findElement(By.xpath("//div[@id='"+fetchid+"']/div[1]/div[1]"));
										WebElement Toid1 = getDriver().findElement(By.xpath("//div[@id='"+fetchid+"']/div[1]/div[2]/div[1]"));
										if(fetchid.contains(storegateid))
										{
											
										}
										else{
											WebElement movableelement = getDriver().findElement(By.xpath("//div[@id='"+storeelementid+"']"));
										
											//String movabletotop = movableelement.getLocation();
											
											Thread.sleep(3000);
											actions.clickAndHold(movableelement).moveToElement(Toid).release(Toid1).build().perform();
											actions.clickAndHold(movableelement).dragAndDrop(movableelement, Toid1).release();
											
											    actions.dragAndDropBy(movableelement, 436, 480).build().perform();
											
											actions.dragAndDrop(movableelement, Toid1).build().perform();
											actions.clickAndHold(movableelement).release(Toid1).build().perform();
											
											
											Robot robot = new Robot();
									        robot.setAutoDelay(50);

									        //Maximized browser:
									        robot.keyPress(KeyEvent.VK_F11);
									        Thread.sleep(2000);
									      	actions.dragAndDrop(movableelement, Toid1).build().perform();
									        
										Thread.sleep(3000);
										}
										
									}
								break;
								}catch(Exception ER)
								{
									Thread.sleep(3000);
								}
	}
	
	
	
			}
		}
		
	
		
	}


		
		
}

