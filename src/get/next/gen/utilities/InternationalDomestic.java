/*
 * 
 * 
 */


package get.next.gen.utilities;

import get.next.gen.commonaction.CommonTest;
import get.next.gen.webtestcase.Web_UI;

import java.util.Arrays;
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




public class InternationalDomestic extends CommonTest {

	
	
	public static void 	Domesticflightsonly() throws Exception {

		TestcaseInit();
		System.out.println("Verify user is displayed with Domestic flight only");
		clickByXpath(Web_UI.filtericon,"filtericon");
		clickByXpath(Web_UI.SettingsAdvancedTab,"Advanced");
		
		try{
			WebElement domesticcheck1 = getDriver().findElement(By.xpath(Web_UI.Domesticradio));
			boolean checkDomesticselected = domesticcheck1.isSelected();
			if(checkDomesticselected==false){
			clickBywebelementxpath(domesticcheck1,"Domestic");
			ATUReports.add("Selected Domestic option in settings",  LogAs.PASSED, null);
			}else{
				ATUReports.add("Domestic option already selected ",  LogAs.PASSED, null);
			}
			WebElement internationalcheck1 = getDriver().findElement(By.xpath(Web_UI.Internationalradio));
			boolean checkinternationalselected = internationalcheck1.isSelected();
			if(checkinternationalselected==true){
			clickBywebelementxpath(internationalcheck1,"internationalcheck1");
			ATUReports.add("International option deselected",  LogAs.PASSED, null);
			}else{
				ATUReports.add("International option already deselected ",  LogAs.PASSED, null);
			}
			
			
			}catch(Exception anotherprop){
				
				ATUReports.add("Some issue in selecting International and domestic Option ",  LogAs.INFO,  new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}
		
		clickByXpath(Web_UI.ApplyButton,"Apply");
		
		Thread.sleep(10000);
		CommonTest.SpinnerControl();
	
		clickByXpath(Web_UI.SortAscending,"SortAscending");
		Thread.sleep(1000);
		// Select Sort Ascending gate by alphabetical order from dropdown
		clickByXpath(Web_UI.SortAscendinggate,"SortAscendinggate");
		Thread.sleep(1000);
	
		List<WebElement> GanntlistArrival = getDriver().findElements(By.xpath(Web_UI.PuckArrivalStation));
		List<WebElement> GanntlistDeparture = getDriver().findElements(By.xpath(Web_UI.PuckDepartureStation));
		
		int ganntlistArrivalcount = GanntlistArrival.size();
		for (int looper=0;looper<ganntlistArrivalcount;looper++){
		
			try{
			String arrivalstation = GanntlistArrival.get(looper).getAttribute("innerText").trim();
			String Departurestation1[] = GanntlistDeparture.get(looper).getAttribute("innerText").split("/");
			String Departurestation = Departurestation1[1].trim();
			
			
			List<String> IFSCODE = Arrays.asList("AGU","AKL","AMS","ANU","AUA","BAQ","BCN","BDA","BGI","BJX","BOG","BSB","BZE","CAP","CCS","CDG","CFG","CLO","CMW","CNF","CUR","CUU","CZM","DUB","ELH","EZE","FCO","FPO","GCM","GDL","GGT","GIG","GND","GRU","GUA","GYE","HAV","HKG","HMO","HND","HOG","ICN","KIN","LHR","LIM","LIR","LPB","MAD","MAN","MAO","MAR","MBJ","MDE","MGA","MHH","MID","MLM","MTY","MUC","MVD","MXP","MZT","NAS","NRT","PAP","PBC","PEK","PGV","PLS","POP","POS","PTY","PUJ","PVG","PVR","QRO","RTB","SAL","SAP","SAW","SCL","SDQ","SJD","SJK","SJO","SJU","SKB","SLP","SNU","STI","STT","STX","SXM","SYD","TGU","TRC","UIO","UVF","VRA","VVI","ZCL","ZRH");
			boolean contains = IFSCODE.contains(arrivalstation);
			boolean contains1 = IFSCODE.contains(Departurestation); 
			if(contains==false || contains1==false )
			{
				ATUReports.add("Verified and flight belongs to Domestic stations  "+ arrivalstation+"  "+Departurestation,  LogAs.PASSED, null);
				System.out.println("Passed Validation::  "+arrivalstation+"  "+Departurestation);
			}
			else{
				String elementid = GanntlistArrival.get(looper).findElement(By.xpath("ancestor::div[1]/ancestor::div[1]")).getAttribute("innerText");
				System.out.println("Failed"+" International flights exist "+arrivalstation+"  "+Departurestation);
				ATUReports.add("Verified and flight not belongs to Domestic stations  "+ arrivalstation+"  "+Departurestation+"  "+elementid,  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}
			
			}catch(Exception Arrayerrors)
			{
				
			}
			
		}
		
			
		}
		
		
		
		
	
		
	
		
		
	
	

	public static void Internationalflightsonly() throws Exception {



		TestcaseInit();
		
		System.out.println("Verify user is displayed with International flight only");
		clickByXpath(Web_UI.filtericon,"filtericon");
		clickByXpath("//div[@id='db-filter-tabs']/div[4]","Advanced");
		
		
		try{
			WebElement domesticcheck1 = getDriver().findElement(By.xpath(Web_UI.Domesticradio));
			boolean checkDomesticselected = domesticcheck1.isSelected();
			if(checkDomesticselected==true){
			clickBywebelementxpath(domesticcheck1,"domesticcheck1");
			ATUReports.add("Unchecked Domestic option",  LogAs.PASSED, null);
			}else{
				ATUReports.add("Domestic option already Unchecked ",  LogAs.PASSED, null);
			}
			WebElement internationalcheck1 = getDriver().findElement(By.xpath(Web_UI.Internationalradio));
			boolean checkinternationalselected = internationalcheck1.isSelected();
			if(checkinternationalselected==false){
			clickBywebelementxpath(internationalcheck1,"internationalcheck1");
			ATUReports.add("International option Selected",  LogAs.PASSED, null);
			}else{
				ATUReports.add("International option already Selected ",  LogAs.PASSED, null);
			}
			
			
			}catch(Exception anotherprop){
				
				ATUReports.add("Some issue in selecting International and domestic Option ",  LogAs.INFO,  new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}
		
		clickByXpath(Web_UI.ApplyButton,"Apply");
		
	
		Thread.sleep(10000);
		CommonTest.SpinnerControl();
	
		clickByXpath(Web_UI.SortAscending,"SortAscending");
		Thread.sleep(1000);
		// Select Sort Ascending gate by alphabetical order from dropdown
		clickByXpath(Web_UI.SortAscendinggate,"SortAscendinggate");
		Thread.sleep(1000);
	
		List<WebElement> GanntlistArrival = getDriver().findElements(By.xpath(Web_UI.PuckArrivalStation));
		List<WebElement> GanntlistDeparture = getDriver().findElements(By.xpath(Web_UI.PuckDepartureStation));
		
		int ganntlistArrivalcount = GanntlistArrival.size();
		for (int looper=0;looper<ganntlistArrivalcount;looper++){
			try{
			String arrivalstation = GanntlistArrival.get(looper).getAttribute("innerText").trim();
			String Departurestation1[] = GanntlistDeparture.get(looper).getAttribute("innerText").split("/");
			String Departurestation = Departurestation1[1].trim();
					
			List<String> IFSCODE = Arrays.asList("AGU","AKL","AMS","ANU","AUA","BAQ","BCN","BDA","BGI","BJX","BOG","BSB","BZE","CAP","CCS","CDG","CFG","CLO","CMW","CNF","CUR","CUU","CZM","DUB","ELH","EZE","FCO","FPO","GCM","GDL","GGT","GIG","GND","GRU","GUA","GYE","HAV","HKG","HMO","HND","HOG","ICN","KIN","LHR","LIM","LIR","LPB","MAD","MAN","MAO","MAR","MBJ","MDE","MGA","MHH","MID","MLM","MTY","MUC","MVD","MXP","MZT","NAS","NRT","PAP","PBC","PEK","PGV","PLS","POP","POS","PTY","PUJ","PVG","PVR","QRO","RTB","SAL","SAP","SAW","SCL","SDQ","SJD","SJK","SJO","SJU","SKB","SLP","SNU","STI","STT","STX","SXM","SYD","TGU","TRC","UIO","UVF","VRA","VVI","ZCL","ZRH");
			boolean contains = IFSCODE.contains(arrivalstation);
			boolean contains1 = IFSCODE.contains(Departurestation); 
			if(contains==true || contains1==true )
			{
				System.out.println("Passed Validation::  "+arrivalstation+"  "+Departurestation);
				ATUReports.add("Passed Validation::  "+arrivalstation+"  "+Departurestation,  LogAs.PASSED, null);
			}
			else{
				String elementid = GanntlistArrival.get(looper).findElement(By.xpath("ancestor::div[1]/ancestor::div[1]")).getAttribute("innerText");
						
				System.out.println("Failed "+" Domestic flights exist  "+arrivalstation+"  "+Departurestation);
				ATUReports.add("Failed"+" Domestic flights exist "+arrivalstation+"  "+Departurestation+"  "+elementid,  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}
			
			}catch(Exception Arrayerrors)
			{
				
			}
		}
		
			
		}
		
		
	
		
	}	
		
	
	
	
	
	



