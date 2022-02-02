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
import java.lang.reflect.Array;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
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



import get.next.gen.utilities.AlphanumComparator;
import get.next.gen.utilities.AlphanumComparator2;
import atu.testng.reports.listeners.ATUReportsListener;
import atu.testng.reports.listeners.ConfigurationListener;
import atu.testng.reports.listeners.MethodListener;
@Listeners({ ATUReportsListener.class, ConfigurationListener.class,
MethodListener.class })
//
public class SortFunctionalityvalidation  extends CommonTest {
	
	public static void SortGateAscending() throws Exception {
		TestcaseInit();
		Selectview("Ganttview");
		System.out.println("Verify gates are sorted as per ascending order");
		// Select Sort Ascending button
		clickByXpath(Web_UI.SortAscending,"sort ascending");
		Thread.sleep(1000);
		// Select Sort Ascending gate by alphabetical order from dropdown
		clickByXpath(Web_UI.SortAscendinggate,"sort ascending'");
		Thread.sleep(1000);
		// Pull the gate values to list
		ArrayList<String> AllGatevalues = new ArrayList<String>();	
		ArrayList<String> AllGatevaluessorting = new ArrayList<String>();	
		List<WebElement> Gatelist = getDriver().findElements(By.xpath("//div[@class='gate-info lft-gte-info ']"));
		for (WebElement gate : Gatelist) {
			String Gatevalue11 = gate.getAttribute("innerText");
			AllGatevalues.add(Gatevalue11);
			
		}
		
		System.out.println("GateValue Recieved : "+ AllGatevalues);
		
	// Storing it into another array for force sort from java and compare the exist array is matching	
		for (WebElement gate : Gatelist) {
			String Gatevalue1 = gate.getAttribute("innerText");
			AllGatevaluessorting.add(Gatevalue1);
			}
		Collections.sort(AllGatevaluessorting,new AlphanumComparator());
		System.out.println("AfterSort Ascending : "+ AllGatevaluessorting);
		
			
		//Perform comparison
		boolean result = Arrays.equals(AllGatevalues.toArray(),AllGatevaluessorting.toArray());
		
		// Return result
		if(result==true)
		{
			ATUReports.add("Arranged properly in Ascending order",  LogAs.PASSED, null);
			ATUReports.add("Sorted Ascending order is valid::  "+AllGatevaluessorting,  LogAs.PASSED, null);
			System.out.println(result);
		}
		else
		{
			ATUReports.add("Not arranged in Ascending order",  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			System.out.println(result);
		}
				
	}
	
	
	public static void SortGateDescending() throws Exception {
		
		System.out.print("Verify gates are sorted as per descending order");
		TestcaseInit();
		Selectview("Ganttview");
		// Select Sort Descending button
		clickByXpath("//div[@title='sort descending']","sort descending");
		Thread.sleep(1000);
		// Select Sort Descending gate by alphabetical order from dropdown
		clickByXpath("//div[@title='sort descending']//span[text()='Gate - Alphabetic Order']","ate - Alphabetic Order");
		
		// Pull the gate values to list
		ArrayList<String> AllGatevalues = new ArrayList<String>();	
		ArrayList<String> AllGatevaluessorting = new ArrayList<String>();	
		List<WebElement> Gatelist = getDriver().findElements(By.xpath("//div[@class='gate-info lft-gte-info ']"));
		for (WebElement gate : Gatelist) {
			String Gatevalue11 = gate.getAttribute("innerText");
			AllGatevalues.add(Gatevalue11);		
					
		}
		System.out.println("Gatevalue recieved : "+ AllGatevalues);
	
	// Storing it into another array for force sort from java and compare the exist array is matching	
		for (WebElement gate : Gatelist) {
			String Gatevalue1 = gate.getAttribute("innerText");
				AllGatevaluessorting.add(Gatevalue1);
			}
	
		Collections.sort(AllGatevaluessorting,new AlphanumComparator2());
			
		System.out.println("AfterSort Descending : "+ AllGatevaluessorting);
		
		
		//Perform comparison
		boolean result = Arrays.equals(AllGatevalues.toArray(),AllGatevaluessorting.toArray());
		
		// Return result
		if(result==true)
		{
			ATUReports.add( "Arranged properly in Descending order",  LogAs.PASSED, null);
			ATUReports.add("Sorted Descending order is valid::  "+AllGatevaluessorting+"   "+AllGatevalues,  LogAs.PASSED, null);
			System.out.println(result);
		}
		else
		{
			ATUReports.add("Not Arranged properly in Descending order",  LogAs.INFO, null);
			ATUReports.add("Sorted order::  "+AllGatevaluessorting+"   "+AllGatevalues,  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			
			System.out.println(result);
		}
				
		
		
		
	}




	public static void SortArrivaltimeAscending() throws Exception {
try{
		TestcaseInit();
		Selectview("Ganttview");
		CommonTest.zoomindata();
		CommonTest.zoomindata();
		CommonTest.zoomindata();
		CommonTest.zoomindata();
	
		clickByXpath(Web_UI.LateArrival,"Late Arrival");
		
		System.out.println("Verify Arrival time are sorted as per ascending order");
		// Select Sort Ascending button
		clickByXpath(Web_UI.SortAscending,"sort ascending");
		Thread.sleep(1000);
		// Select Sort Ascending gate by alphabetical order from dropdown
		clickByXpath(Web_UI.SortAscendingArrivaltime,"sort ascending'");
		Thread.sleep(1000);
		// Pull the gate values to list
		
		ArrayList<String> AllGatevalues = new ArrayList<String>();	
		ArrayList<String> AllGatevaluessorting = new ArrayList<String>();	
		ArrayList<String> Arrivaltimelist = new ArrayList<String>();	
		ArrayList<String> OnlyArrivaltime = new ArrayList<String>();
		ArrayList<String> OnlyArrivaltimesorting = new ArrayList<String>();
		
		
		List<WebElement> Gatelist = getDriver().findElements(By.xpath("//div[@class='gate-info lft-gte-info ']"));
		for (WebElement gate : Gatelist) {
			String Gatevalue11 = gate.getAttribute("innerText");
			AllGatevalues.add(Gatevalue11);
			
		}
	
		
	// Storing it into another array for force sort from java and compare the exist array is matching	
		for (WebElement gate : Gatelist) {
			String Gatevalue1 = gate.getAttribute("innerText");
			AllGatevaluessorting.add(Gatevalue1);
			}
	
		
		for (String gate1 : AllGatevaluessorting) {
		
			String loopgatevalue = gate1;
			
			WebElement movableelement = getDriver().findElement(By.xpath("//div[@id='"+loopgatevalue+"']"));
			Actions actions = new Actions(getDriver());
			actions.moveToElement(movableelement).build().perform();
			actions.moveToElement(movableelement);
			Thread.sleep(1000);
			
			
			
			String checker = "//div[@id='"+loopgatevalue+"']/div[1]/div[contains(@data-ng-include,'defaultFLightPuck')]/div[1]//div[@class='puck-contnt puck-data-center']/div[1]/span[2]";
			WebElement Firstelementofgatevalue =  getDriver().findElement(By.xpath(checker));
			String arrivaltime = Firstelementofgatevalue.getAttribute("innerText");
					Arrivaltimelist.add(arrivaltime);
			}
		
	for (String Onlyarrivaltime : Arrivaltimelist) {
				
	String Arrivaltimebeforesplit = Onlyarrivaltime;
	String Arrivaltimesplit[] = Arrivaltimebeforesplit.split(" ");
	String Arrivaltime = Arrivaltimesplit[1].trim();	
	OnlyArrivaltime.add(Arrivaltime);
	
	}
		ArrayList<Date> myDates = new ArrayList<Date>();

		for (String Onlyarrivaltime : OnlyArrivaltime) {
			
			String arrivaltimetaken = Onlyarrivaltime;
			if(arrivaltimetaken.contains("/")){
				String arrivaltime1[]= arrivaltimetaken.split("/");
				String arrivaltime = arrivaltime1[0];
				String datefetched = arrivaltime1[1].trim();
				//OnlyArrivaltimesorting.add("2018-04-"+datefetched+"T"+arrivaltime.trim()+":24.234");
				String dateunformated = "2018-04-"+datefetched+"T"+arrivaltime.trim()+":24.234";
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");

					Date date = formatter.parse(dateunformated);
				    myDates.add(date);


			}
			else{
				//OnlyArrivaltimesorting.add("2018-04-"+Web_UI.Todaysdate+"T"+arrivaltimetaken.trim()+":24.234");
				//OnlyArrivaltimesorting.add(arrivaltimetaken.trim());
				String dateunformated = "2018-04-"+Web_UI.Todaysdate+"T"+arrivaltimetaken.trim()+":24.234";
			//	ArrayList<Date> myDates = new ArrayList<Date>();
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
						
				    Date date = formatter.parse(dateunformated);
				    myDates.add(date);
						
				
			}
			
			 
			 
			}
		ArrayList<Date> myDates1 = myDates;
		Collections.sort(myDates); // Ascending
		 System.out.println("Ascending sort     "+myDates);
		
		
			
		//Perform comparison
		boolean result = Arrays.equals(myDates1.toArray(),myDates.toArray());
		
		// Return result
		if(result==true)
		{
			ATUReports.add("Arranged properly in Ascending order",  LogAs.PASSED, null);
			ATUReports.add("Sorted Ascending order is valid::  "+OnlyArrivaltime,  LogAs.PASSED, null);
			System.out.println(result);
		}
		else
		{
			ATUReports.add("Not arranged in Ascending order",  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			System.out.println(result);
		}
	
	}catch(Exception ee){
		System.out.println("");
	}
	}


	public static void SortArrivaltimeDescending() throws Exception {

		try{
		TestcaseInit();
		Selectview("Ganttview");
		CommonTest.zoomindata();
		CommonTest.zoomindata();
		CommonTest.zoomindata();
		CommonTest.zoomindata();
		clickByXpath(Web_UI.LateArrival,"Late Arrival");
		
		System.out.println("Verify Arrivaltime are sorted as per Descending order");
		// Select Sort Ascending button
		clickByXpath("//div[@title='sort descending']","sort Descending");
		Thread.sleep(1000);
		// Select Sort Ascending gate by alphabetical order from dropdown
		clickByXpath("//div[@title='sort descending']//span[text()='Arrival Time']","sort ascending'");
		Thread.sleep(1000);
		// Pull the gate values to list
		
		
		
		ArrayList<String> AllGatevalues = new ArrayList<String>();	
		ArrayList<String> AllGatevaluessorting = new ArrayList<String>();	
		ArrayList<String> Arrivaltimelist = new ArrayList<String>();	
		ArrayList<String> OnlyArrivaltime = new ArrayList<String>();
		ArrayList<String> OnlyArrivaltimesorting = new ArrayList<String>();
		List<WebElement> Gatelist = getDriver().findElements(By.xpath("//div[@class='gate-info lft-gte-info ']"));
		for (WebElement gate : Gatelist) {
			String Gatevalue11 = gate.getAttribute("innerText");
			AllGatevalues.add(Gatevalue11);
			
		}
		
		
	// Storing it into another array for force sort from java and compare the exist array is matching	
		for (WebElement gate : Gatelist) {
			String Gatevalue1 = gate.getAttribute("innerText");
			AllGatevaluessorting.add(Gatevalue1);
			}
	
		
		for (String gate1 : AllGatevaluessorting) {
		
			String loopgatevalue = gate1;
			
			WebElement movableelement = getDriver().findElement(By.xpath("//div[@id='"+loopgatevalue+"']"));
			Actions actions = new Actions(getDriver());
			actions.moveToElement(movableelement).build().perform();
			actions.moveToElement(movableelement);
			Thread.sleep(1000);
			
			
			
			String checker = "//div[@id='"+loopgatevalue+"']/div[1]/div[contains(@data-ng-include,'defaultFLightPuck')]/div[1]//div[@class='puck-contnt puck-data-center']/div[1]/span[2]";
			WebElement Firstelementofgatevalue =  getDriver().findElement(By.xpath(checker));
			String arrivaltime = Firstelementofgatevalue.getAttribute("innerText");
					Arrivaltimelist.add(arrivaltime);
			}
		
		
		for (String Onlyarrivaltime : Arrivaltimelist) {
				
	String Arrivaltimebeforesplit = Onlyarrivaltime;
	String Arrivaltimesplit[] = Arrivaltimebeforesplit.split(" ");
	String Arrivaltime = Arrivaltimesplit[1].trim();	
	OnlyArrivaltime.add(Arrivaltime);
	
	}
		ArrayList<Date> myDates = new ArrayList<Date>();

		for (String Onlyarrivaltime : OnlyArrivaltime) {
			
			String arrivaltimetaken = Onlyarrivaltime;
			if(arrivaltimetaken.contains("/")){
				String arrivaltime1[]= arrivaltimetaken.split("/");
				String arrivaltime = arrivaltime1[0];
				String datefetched = arrivaltime1[1].trim();
				//OnlyArrivaltimesorting.add("2018-04-"+datefetched+"T"+arrivaltime.trim()+":24.234");
				String dateunformated = "2018-04-"+datefetched+"T"+arrivaltime.trim()+":24.234";
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");

					Date date = formatter.parse(dateunformated);
				    myDates.add(date);


			}
			else{
					String dateunformated = "2018-04-"+Web_UI.Todaysdate+"T"+arrivaltimetaken.trim()+":24.234";
			//	ArrayList<Date> myDates = new ArrayList<Date>();
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
						
				    Date date = formatter.parse(dateunformated);
				    myDates.add(date);
						
				
			}
			
			 
			 
			}
		ArrayList<Date> myDates1 = myDates;
		//Collections.sort(myDates); // Ascending
		
		 Collections.sort(myDates, Collections.reverseOrder()); // Descending
		 System.out.println("Descending  sort     "+myDates);
		
			
		//Perform comparison
		boolean result = Arrays.equals(myDates1.toArray(),myDates.toArray());
		
		// Return result
		if(result==true)
		{
			ATUReports.add("Arranged properly in Ascending order",  LogAs.PASSED, null);
			ATUReports.add("Sorted Ascending order is valid::  "+OnlyArrivaltime,  LogAs.PASSED, null);
			System.out.println(result);
		}
		else
		{
			ATUReports.add("Not arranged in Ascending order",  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			System.out.println(result);
		}
	
	}catch(Exception ee){
		System.out.println("");
	}
}
	
	
	
	public static void SortDeparturetimeAscending() throws Exception {
		try{
				TestcaseInit();
				Selectview("Ganttview");
				CommonTest.zoomindata();
				CommonTest.zoomindata();
				CommonTest.zoomindata();
				CommonTest.zoomindata();
			
				clickByXpath(Web_UI.LateArrival,"Late Arrival");
				
				System.out.println("Verify Arrival time are sorted as per ascending order");
				// Select Sort Ascending button
				clickByXpath(Web_UI.SortAscending,"sort ascending");
				Thread.sleep(1000);
				// Select Sort Ascending gate by alphabetical order from dropdown
				clickByXpath(Web_UI.SortAscendingDeparturetime,"sort ascending'");
				Thread.sleep(1000);
				// Pull the gate values to list
				
				ArrayList<String> AllGatevalues = new ArrayList<String>();	
				ArrayList<String> AllGatevaluessorting = new ArrayList<String>();	
				ArrayList<String> Arrivaltimelist = new ArrayList<String>();	
				ArrayList<String> OnlyArrivaltime = new ArrayList<String>();
				ArrayList<String> OnlyArrivaltimesorting = new ArrayList<String>();
				List<WebElement> Gatelist = getDriver().findElements(By.xpath("//div[@class='gate-info lft-gte-info ']"));
				for (WebElement gate : Gatelist) {
					String Gatevalue11 = gate.getAttribute("innerText");
					AllGatevalues.add(Gatevalue11);
					
				}
				
			//	System.out.println("GateValue Recieved : "+ AllGatevalues);
				
			// Storing it into another array for force sort from java and compare the exist array is matching	
				for (WebElement gate : Gatelist) {
					String Gatevalue1 = gate.getAttribute("innerText");
					AllGatevaluessorting.add(Gatevalue1);
					}
			
				
				for (String gate1 : AllGatevaluessorting) {
				
					String loopgatevalue = gate1;
					
					WebElement movableelement = getDriver().findElement(By.xpath("//div[@id='"+loopgatevalue+"']"));
					Actions actions = new Actions(getDriver());
					actions.moveToElement(movableelement).build().perform();
					actions.moveToElement(movableelement);
					Thread.sleep(1000);
					
					
					
					String checker = "//div[@id='"+loopgatevalue+"']/div[1]/div[contains(@data-ng-include,'defaultFLightPuck')]/div[1]//div[@class='puck-contnt puck-data-center']/div[3]/span[2]/span[1]";
					WebElement Firstelementofgatevalue =  getDriver().findElement(By.xpath(checker));
					String arrivaltime = Firstelementofgatevalue.getAttribute("innerText");
							Arrivaltimelist.add(arrivaltime);
					}
				
			
				for (String Onlyarrivaltime : Arrivaltimelist) {
						
			String Arrivaltimebeforesplit = Onlyarrivaltime;
			String Arrivaltimesplit[] = Arrivaltimebeforesplit.split(" ");
			String Arrivaltime = Arrivaltimesplit[1].trim();	
			OnlyArrivaltime.add(Arrivaltime);
			
			}
				ArrayList<Date> myDates = new ArrayList<Date>();

				for (String Onlyarrivaltime : OnlyArrivaltime) {
					
					String arrivaltimetaken = Onlyarrivaltime;
					if(arrivaltimetaken.contains("/")){
						String arrivaltime1[]= arrivaltimetaken.split("/");
						String arrivaltime = arrivaltime1[0];
						String datefetched = arrivaltime1[1].trim();
						//OnlyArrivaltimesorting.add("2018-04-"+datefetched+"T"+arrivaltime.trim()+":24.234");
						String dateunformated = "2018-04-"+datefetched+"T"+arrivaltime.trim()+":24.234";
						SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");

							Date date = formatter.parse(dateunformated);
						    myDates.add(date);


					}
					else{
							String dateunformated = "2018-04-"+Web_UI.Todaysdate+"T"+arrivaltimetaken.trim()+":24.234";
					//	ArrayList<Date> myDates = new ArrayList<Date>();
						SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
								
						    Date date = formatter.parse(dateunformated);
						    myDates.add(date);
								
						
					}
					
					 
					 
					}
				ArrayList<Date> myDates1 = myDates;
				Collections.sort(myDates); // Ascending
				 System.out.println("Ascending sort     "+myDates);
			
					
				//Perform comparison
				boolean result = Arrays.equals(myDates1.toArray(),myDates.toArray());
				
				// Return result
				if(result==true)
				{
					ATUReports.add("Arranged properly in Ascending order",  LogAs.PASSED, null);
					ATUReports.add("Sorted Ascending order is valid::  "+OnlyArrivaltime,  LogAs.PASSED, null);
					System.out.println(result);
				}
				else
				{
					ATUReports.add("Not arranged in Ascending order",  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					System.out.println(result);
				}
			
			}catch(Exception ee){
				System.out.println("");
			}
			}
	
	
	public static void SortDeparturetimeDescending() throws Exception {

		try{
		TestcaseInit();
		Selectview("Ganttview");
		CommonTest.zoomindata();
		CommonTest.zoomindata();
		CommonTest.zoomindata();
		CommonTest.zoomindata();
		clickByXpath(Web_UI.LateArrival,"Late Arrival");
		
		System.out.println("Verify Arrivaltime are sorted as per Descending order");
		// Select Sort Ascending button
		clickByXpath("//div[@title='sort descending']","sort Descending");
		Thread.sleep(1000);
		// Select Sort Ascending gate by alphabetical order from dropdown
		clickByXpath("//div[@title='sort descending']//span[text()='Departure Time']","sort ascending'");
		Thread.sleep(1000);
		// Pull the gate values to list
		
		
		
		ArrayList<String> AllGatevalues = new ArrayList<String>();	
		ArrayList<String> AllGatevaluessorting = new ArrayList<String>();	
		ArrayList<String> Arrivaltimelist = new ArrayList<String>();	
		ArrayList<String> OnlyArrivaltime = new ArrayList<String>();
		ArrayList<String> OnlyArrivaltimesorting = new ArrayList<String>();
		List<WebElement> Gatelist = getDriver().findElements(By.xpath("//div[@class='gate-info lft-gte-info ']"));
		for (WebElement gate : Gatelist) {
			String Gatevalue11 = gate.getAttribute("innerText");
			AllGatevalues.add(Gatevalue11);
			
		}
		
	//	System.out.println("GateValue Recieved : "+ AllGatevalues);
		
	// Storing it into another array for force sort from java and compare the exist array is matching	
		for (WebElement gate : Gatelist) {
			String Gatevalue1 = gate.getAttribute("innerText");
			AllGatevaluessorting.add(Gatevalue1);
			}
	
		
		for (String gate1 : AllGatevaluessorting) {
		
			String loopgatevalue = gate1;
			
			WebElement movableelement = getDriver().findElement(By.xpath("//div[@id='"+loopgatevalue+"']"));
			Actions actions = new Actions(getDriver());
			actions.moveToElement(movableelement).build().perform();
			actions.moveToElement(movableelement);
			Thread.sleep(1000);
			
			
			
			String checker = "//div[@id='"+loopgatevalue+"']/div[1]/div[contains(@data-ng-include,'defaultFLightPuck')]/div[1]//div[@class='puck-contnt puck-data-center']/div[3]/span[2]/span[1]";
			WebElement Firstelementofgatevalue =  getDriver().findElement(By.xpath(checker));
			String arrivaltime = Firstelementofgatevalue.getAttribute("innerText");
					Arrivaltimelist.add(arrivaltime);
			}
		
	//	System.out.println("Arrival time   : "+ Arrivaltimelist);
		
		
		
		for (String Onlyarrivaltime : Arrivaltimelist) {
				
	String Arrivaltimebeforesplit = Onlyarrivaltime;
	String Arrivaltimesplit[] = Arrivaltimebeforesplit.split(" ");
	String Arrivaltime = Arrivaltimesplit[1].trim();	
	OnlyArrivaltime.add(Arrivaltime);
	
	}
		ArrayList<Date> myDates = new ArrayList<Date>();

		for (String Onlyarrivaltime : OnlyArrivaltime) {
			
			String arrivaltimetaken = Onlyarrivaltime;
			if(arrivaltimetaken.contains("/")){
				String arrivaltime1[]= arrivaltimetaken.split("/");
				String arrivaltime = arrivaltime1[0];
				String datefetched = arrivaltime1[1].trim();
				//OnlyArrivaltimesorting.add("2018-04-"+datefetched+"T"+arrivaltime.trim()+":24.234");
				String dateunformated = "2018-04-"+datefetched+"T"+arrivaltime.trim()+":24.234";
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");

					Date date = formatter.parse(dateunformated);
				    myDates.add(date);


			}
			else{
				//OnlyArrivaltimesorting.add("2018-04-"+Web_UI.Todaysdate+"T"+arrivaltimetaken.trim()+":24.234");
				//OnlyArrivaltimesorting.add(arrivaltimetaken.trim());
				String dateunformated = "2018-04-"+Web_UI.Todaysdate+"T"+arrivaltimetaken.trim()+":24.234";
			//	ArrayList<Date> myDates = new ArrayList<Date>();
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
						
				    Date date = formatter.parse(dateunformated);
				    myDates.add(date);
						
				
			}
			
			 
			 
			}
		ArrayList<Date> myDates1 = myDates;
		//Collections.sort(myDates); // Ascending
		
		 Collections.sort(myDates, Collections.reverseOrder()); // Descending
		 System.out.println("Descending  sort     "+myDates);
	
		
			
		//Perform comparison
		boolean result = Arrays.equals(myDates1.toArray(),myDates.toArray());
		
		// Return result
		if(result==true)
		{
			ATUReports.add("Arranged properly in Ascending order",  LogAs.PASSED, null);
			ATUReports.add("Sorted Ascending order is valid::  "+OnlyArrivaltime,  LogAs.PASSED, null);
			System.out.println(result);
		}
		else
		{
			ATUReports.add("Not arranged in Ascending order",  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			System.out.println(result);
		}
	
	}catch(Exception ee){
		System.out.println("");
	}
}
	
	
	
	public static void SortDescendingbyarrivalstatus() throws Exception {

		System.out.println("Verify gates are sorted as per descending order by arrival status");
		TestcaseInit();
		Selectview("Hybridview");
		CommonTest.SpinnerControl();
		// Select Sort Descending button
		clickByXpath("//div[@title='sort descending']","sort descending");
		Thread.sleep(1000);
		// Select Sort Descending gate by alphabetical order from dropdown
		clickByXpath("//div[@title='sort descending']//span[text()='Arrival Status']"," Arrival - Ascending Order");
		Thread.sleep(1000);
		clickByXpath("//span[text()='LDT']"," Select LTD");
		clickByXpath("//div[@class='col-sm-2 col-lg-2 cursr-ptr mar-top col-dep-flt arrival-col']/div[1]/div[4]","Select Arrival status ascending order");
		clickByXpath("//div[@class='col-sm-2 col-lg-2 cursr-ptr mar-top col-dep-flt arrival-col']/div[1]/div[4]"," Select Arrival status Descending order");
		
		
		// Pull the gate values to list
		ArrayList<String> AllGatevaluesganttview = new ArrayList<String>();	
		ArrayList<String> AllGatevaluesFlightlistview = new ArrayList<String>();	
		int gnt =0;
		int flt= 0;
		
		List<WebElement> Gatelist = getDriver().findElements(By.xpath("//div[@class='gate-info lft-gte-info ']"));
		for (WebElement gate : Gatelist) {
			String Gatevalue11 = gate.getAttribute("innerText");
			AllGatevaluesganttview.add(Gatevalue11);	
			gnt++;
			if(gnt>=4){
				break;
			}
					
		}
		//System.out.println("Gatevalue recieved : "+ AllGatevaluesganttview);
	
		List<WebElement> flightlist = getDriver().findElements(By.xpath("//div[@class='col-sm-2 col-lg-2 col-dep-flt  col-dep-val']/div[1]"));
				for (WebElement gate1 : flightlist) {
					String Gatevalue11 = gate1.getAttribute("innerText");
					AllGatevaluesFlightlistview.add(Gatevalue11);		
					flt++;
					if(flt>=4){
						break;
					}
				}	
		
				int ma=0;
				for (String looper : AllGatevaluesganttview) {
					String one = AllGatevaluesganttview.get(ma);
					String two = AllGatevaluesFlightlistview.get(ma);
					
					if(one.equalsIgnoreCase(two)){
						
					}else{
						ATUReports.add("Not arranged in Descending order",  LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}
					ma++;
				}
		
	}
	
	
	public static void SortAscendingbyarrivalstatus() throws Exception {

		TestcaseInit();
		Selectview("Hybridview");
		CommonTest.SpinnerControl();
		System.out.println("Verify gates are sorted as per ascending order by arrival status");
		// Select Sort Ascending button
		clickByXpath(Web_UI.SortAscending,"sort ascending");
		Thread.sleep(1000);
		// Select Sort Ascending gate by alphabetical order from dropdown
		clickByXpath(Web_UI.SortAscendingArrivalstatus,"sort ascending By arrivalstatys");
		Thread.sleep(1000);
		clickByXpath("//span[text()='LDT']"," Select LTD");
		clickByXpath("//div[@class='col-sm-2 col-lg-2 cursr-ptr mar-top col-dep-flt arrival-col']/div[1]/div[4]","Select Arrival status ascending order");
			
		
		// Pull the gate values to list
				ArrayList<String> AllGatevaluesganttview = new ArrayList<String>();	
				ArrayList<String> AllGatevaluesFlightlistview = new ArrayList<String>();	
				int gnt =0;
				int flt= 0;
				
				List<WebElement> Gatelist = getDriver().findElements(By.xpath("//div[@class='gate-info lft-gte-info ']"));
				for (WebElement gate : Gatelist) {
					String Gatevalue11 = gate.getAttribute("innerText");
					AllGatevaluesganttview.add(Gatevalue11);	
					gnt++;
					if(gnt>=4){
						break;
					}
							
				}
			//	System.out.println("Gatevalue recieved : "+ AllGatevaluesganttview);
			
				List<WebElement> flightlist = getDriver().findElements(By.xpath("//div[@class='col-sm-2 col-lg-2 col-dep-flt  col-dep-val']/div[1]"));
						for (WebElement gate1 : flightlist) {
							String Gatevalue11 = gate1.getAttribute("innerText");
							AllGatevaluesFlightlistview.add(Gatevalue11);		
							flt++;
							if(flt>=4){
								break;
							}
						}	
				
						int ma=0;
						for (String looper : AllGatevaluesganttview) {
							String one = AllGatevaluesganttview.get(ma);
							String two = AllGatevaluesFlightlistview.get(ma);
							
							if(one.equalsIgnoreCase(two)){
								
							}else{
								ATUReports.add("Not arranged in Ascending order",  LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
							}
							ma++;
						}
	}
	
	
	
	public static void SortAscendingbyDeparturestatus() throws Exception {

		TestcaseInit();
		Selectview("Hybridview");
		CommonTest.SpinnerControl();
		System.out.println("Verify gates are sorted as per ascending order by Departure status");
		// Select Sort Ascending button
		clickByXpath(Web_UI.SortAscending,"sort ascending");
		Thread.sleep(1000);
		// Select Sort Ascending gate by alphabetical order from dropdown
		clickByXpath(Web_UI.SortAscendingDeaparturestatus,"Departure status Ascending");
		Thread.sleep(1000);
		clickByXpath("//span[text()='LDT']"," Select LTD");
		clickByXpath("//div[@class='col-sm-2 col-lg-2 col-dep-flt pad-dep cursr-ptr mar-top col-dep-val']/div[1]/div[6]","Select Departure status ascending order");
		
		
		// Pull the gate values to list
				ArrayList<String> AllGatevaluesganttview = new ArrayList<String>();	
				ArrayList<String> AllGatevaluesFlightlistview = new ArrayList<String>();	
				int gnt =0;
				int flt= 0;
				
				List<WebElement> Gatelist = getDriver().findElements(By.xpath("//div[@class='gate-info lft-gte-info ']"));
				for (WebElement gate : Gatelist) {
					String Gatevalue11 = gate.getAttribute("innerText");
					AllGatevaluesganttview.add(Gatevalue11);	
					gnt++;
					if(gnt>=4){
						break;
					}
							
				}
		
				List<WebElement> flightlist = getDriver().findElements(By.xpath("//div[@class='col-sm-2 col-lg-2 col-dep-flt  col-dep-val']/div[1]"));
						for (WebElement gate1 : flightlist) {
							String Gatevalue11 = gate1.getAttribute("innerText");
							AllGatevaluesFlightlistview.add(Gatevalue11);		
							flt++;
							if(flt>=4){
								break;
							}
						}	
				
						int ma=0;
						for (String looper : AllGatevaluesganttview) {
							String one = AllGatevaluesganttview.get(ma);
							String two = AllGatevaluesFlightlistview.get(ma);
							
							if(one.equalsIgnoreCase(two)){
								
							}else{
								ATUReports.add("Not arranged in Ascending order",  LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
							}
							ma++;
						}
		
	}
	
	
	
	public static void SortDescendingbyDeparturestatus() throws Exception {

		
		System.out.println("Verify gates are sorted as per descending order by Departure status");
		TestcaseInit();
		Selectview("Hybridview");
		CommonTest.SpinnerControl();
		// Select Sort Descending button
		clickByXpath("//div[@title='sort descending']","sort descending");
		Thread.sleep(1000);
		// Select Sort Descending gate by alphabetical order from dropdown
		clickByXpath("//div[@title='sort descending']//span[text()='Departure Status']","Departure status Descending");
		
		Thread.sleep(1000);
		clickByXpath("//span[text()='LDT']"," Select LTD");
		clickByXpath("//div[@class='col-sm-2 col-lg-2 col-dep-flt pad-dep cursr-ptr mar-top col-dep-val']/div[1]/div[6]","Select Depature status ascending order");
		clickByXpath("//div[@class='col-sm-2 col-lg-2 col-dep-flt pad-dep cursr-ptr mar-top col-dep-val']/div[1]/div[6]"," Select Departure status Descending order");
		
		
		// Pull the gate values to list
				ArrayList<String> AllGatevaluesganttview = new ArrayList<String>();	
				ArrayList<String> AllGatevaluesFlightlistview = new ArrayList<String>();	
				int gnt =0;
				int flt= 0;
				
				List<WebElement> Gatelist = getDriver().findElements(By.xpath("//div[@class='gate-info lft-gte-info ']"));
				for (WebElement gate : Gatelist) {
					String Gatevalue11 = gate.getAttribute("innerText");
					AllGatevaluesganttview.add(Gatevalue11);	
					gnt++;
					if(gnt>=4){
						break;
					}
							
				}
			
				List<WebElement> flightlist = getDriver().findElements(By.xpath("//div[@class='col-sm-2 col-lg-2 col-dep-flt  col-dep-val']/div[1]"));
						for (WebElement gate1 : flightlist) {
							String Gatevalue11 = gate1.getAttribute("innerText");
							AllGatevaluesFlightlistview.add(Gatevalue11);		
							flt++;
							if(flt>=4){
								break;
							}
						}	
				
						int ma=0;
						for (String looper : AllGatevaluesganttview) {
							String one = AllGatevaluesganttview.get(ma);
							String two = AllGatevaluesFlightlistview.get(ma);
							
							if(one.equalsIgnoreCase(two)){
								
							}else{
								ATUReports.add("Not arranged in Descending order",  LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
							}
							ma++;
						}
	}
	
}

