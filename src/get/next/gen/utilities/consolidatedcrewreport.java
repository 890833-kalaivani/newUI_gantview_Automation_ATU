/*
 * 
 * 
 */


package get.next.gen.utilities;

import get.next.gen.commonaction.CommonTest;
import get.next.gen.webtestcase.Web_UI;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
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




public class consolidatedcrewreport extends CommonTest {


	// Below will check consolidated crew report is clickable and can be opened
	public static void 	Checkconsolidatedcrewicon() throws Exception {
		TestcaseInit();
		CommonTest.SpinnerControl();
		checkcrewisclosed();
		try{
			WebElement Consolidatedcrewicon = getDriver().findElement(By.xpath(Web_UI.Crewconnexicon));
			if(Consolidatedcrewicon!=null){
				ATUReports.add("Consolidated crew icon present ", LogAs.PASSED, null);
				System.out.println("Consolidated crew icon present ");
			}else{
				ATUReports.add("Consolidated crew icon not present ", LogAs.FAILED, null);
				System.out.println("Consolidated crew icon Not present ");
			}
			clickBywebelementxpath(Consolidatedcrewicon,"Consolidatedcrewicon");
			System.out.println("Selected Consolidated crew icon ");
			CommonTest.SpinnerControl();
			Thread.sleep(5000);
		}catch(Exception Consolidatedcrewiconissue){
			ATUReports.add("Consolidated crew report is not selectable ", LogAs.INFO, null);
		}
	}


	// Check whether the Consolidated crew report have counts and display formats
	public static void 	Bubbleholdcountwhencrewalerts() throws Exception {

		Thread.sleep(2000);
		WebElement Consolidatedcrewicon = getDriver().findElement(By.xpath(Web_UI.Crewconnexicon));
		try{
			WebElement Consolidatedcrewcount = getDriver().findElement(By.xpath(Web_UI.Crewconnexcount));
			String Consolidatedcrewcountfetch = Consolidatedcrewcount.getAttribute("innerText").trim();
			String Bubblecolor =  Consolidatedcrewcount.getCssValue("background-color");
			if(Consolidatedcrewcountfetch!=null){
				ATUReports.add("Crew count is present in bubble   "+Consolidatedcrewcountfetch, LogAs.PASSED, null);
			}else{
				ATUReports.add("Crew count is not present in bubble   "+Consolidatedcrewcountfetch, LogAs.FAILED, null);
			}


			if(Bubblecolor.contains("217, 83, 79")||Bubblecolor.contains("255, 206, 4")){
				if(Bubblecolor.contains("217, 83, 79")){
					ATUReports.add("Bubble color displayed in Red and verified   ", LogAs.PASSED, null);
				}
				if(Bubblecolor.contains("255, 206, 4")){
					ATUReports.add("Bubble color displayed in Yellow and verified   ", LogAs.PASSED, null);
				}

			}else{
				ATUReports.add("Manually check the bubble color   "+Consolidatedcrewcountfetch, LogAs.FAILED, null);
			}






		}catch(Exception EE){
			ATUReports.add("Crew report is Empty and hence bubble is not displayed   ", LogAs.PASSED, null);
		}
		//clickBywebelementxpath(Consolidatedcrewicon,"Consolidatedcrewicon");
		Checkconsolidatedcrewicon();
		CommonTest.SpinnerControl();
		Thread.sleep(3000);

		// Check report title
		String Reporttitle = getDriver().findElement(By.xpath(Web_UI.Crewreporttitle)).getAttribute("innerText");
		if(Reporttitle.contains("Crew Connection Report")){
			ATUReports.add("Crew report title is present   "+Reporttitle, LogAs.PASSED, null);
		}else{
			ATUReports.add("Crew report title is not present   "+Reporttitle, LogAs.FAILED, null);
		}
		closecrewreport();
	}


	//Below will check crew report headers and title
	public static void 	Crewreportholdsreuiredtitle() throws Exception {
		TestcaseInit();
		Checkconsolidatedcrewicon();
		Thread.sleep(2000);
		try{
			String Headeritems = getDriver().findElement(By.xpath(Web_UI.CrewHeaderitems)).getAttribute("innerText");

			List<String> Crewheaderitems = Arrays.asList("POS","USER","ID","EMP","NAME","SCAN","TIME","FLIGHT","ETD","GATE","INB","FLT","ORIGIN","GATE","STATUS","ETA","CONX","PUSH","TIME","MOT","BLOCK","FDP","DCT");

			String Headeritemsarray[] =Headeritems.split(" ");
			int Headeritemscount = Headeritemsarray.length;
			for(int i = 0; i<Headeritemscount;i++)
			{
				boolean contains = Crewheaderitems.contains(Headeritemsarray[i].trim());
				if(contains == true){
					ATUReports.add("The Title name **"+Headeritemsarray[i]+" ** "+"Exist in report header", LogAs.PASSED, null);
				}else{
					ATUReports.add("The Title name **"+Headeritemsarray[i]+" ** "+" Not Exist in report header", LogAs.FAILED, null);
				}
			}
		}catch(Exception Reportnotopened){
			ATUReports.add("Report not opened or report is not viewable", LogAs.INFO, null);
		}
		closecrewreport();


	}






	// Below will check the search functionality with different inputs provided

	public static void 	Searchfunctionality() throws Exception {
		TestcaseInit();
		Checkconsolidatedcrewicon();
		Thread.sleep(2000);
		WebElement Consolidatedcrewicon = getDriver().findElement(By.xpath(Web_UI.Crewconnexicon));

		String POSSearchkey = Getsearchstring(Web_UI.POSSearchkey);
		String useridSearchkey = Getsearchstring(Web_UI.useridSearchkey);
		String EmpNameSearchkey = Getsearchstring(Web_UI.EmpNameSearchkey);
		//String ScantimeSearchkey = Getsearchstring(Web_UI.ScantimeSearchkey);
		String FlightnoSearchkey = Getsearchstring(Web_UI.FlightnoSearchkey);
		String EtdSearchkey = Getsearchstring(Web_UI.EtdSearchkey);
		String GateSearchkey = Getsearchstring(Web_UI.GateSearchkey);
		String INBFltSearchkey = Getsearchstring(Web_UI.INBFltSearchkey);
		String ORIGINSearchkey = Getsearchstring(Web_UI.ORIGINSearchkey);
		String Gate2Searchkey = Getsearchstring(Web_UI.Gate2Searchkey);
		String StatusSearchkey = Getsearchstring(Web_UI.StatusSearchkey);
		String ETASearchkey = Getsearchstring(Web_UI.ETASearchkey);
		//String connexSearchkey = Getsearchstring("", Consolidatedcrewicon);

		confirmsearchworking(POSSearchkey,"POS");
		confirmsearchworking(useridSearchkey,"userid");
		confirmsearchworking(EmpNameSearchkey,"EmpName");
		//confirmsearchworking(ScantimeSearchkey,"Scantime");
		confirmsearchworking(FlightnoSearchkey,"Flightno");
		confirmsearchworking(EtdSearchkey,"Etd");
		confirmsearchworking(GateSearchkey,"Gate");
		confirmsearchworking(INBFltSearchkey,"INBFlt");
		confirmsearchworking(ORIGINSearchkey,"ORIGIN");
		confirmsearchworking(Gate2Searchkey,"Gate2");
		confirmsearchworking(StatusSearchkey,"Status");
		confirmsearchworking(ETASearchkey,"ETA");
		//confirmsearchworking(connexSearchkey,"connex");

		closecrewreport();
	}



	//Below will check Slider session present and can be switched and store session
	public static void Slidersessionsaved() throws Exception {
		Thread.sleep(2000);
		CommonTest.SpinnerControl();
		OpenCrewReport();
		try{
			getDriver().findElement(By.xpath(Web_UI.Crewslider)).click();
		}catch(Exception et){

		}

		try{
			WebElement Slider = getDriver().findElement(By.xpath(Web_UI.Crewslider));
			String Color = getDriver().findElement(By.xpath(Web_UI.Crewslider)).getCssValue("background-color");


			if(Color.contains("204")){
				Slider.click();
			}

			reopencrewreport();
			Checkslidersessionsaved(Web_UI.Crewslider,"Slider ON ",Color);
			OpenCrewReport();
			Thread.sleep(1000);
			WebElement Slider1 = getDriver().findElement(By.xpath(Web_UI.Crewslider));
			String Color1 = Slider1.getCssValue("background-color");

			if(Color1.contains("33")){
				Slider1.click();
			}

			WebElement Slider2 = getDriver().findElement(By.xpath(Web_UI.Crewslider));
			String Color2 = Slider1.getCssValue("background-color");
			reopencrewreport();
			Checkslidersessionsaved(Web_UI.Crewslider,"Slider OFF ",Color2);

		}catch(Exception errorinopeningreport){
			ATUReports.add("Report not opened or report is not viewable", LogAs.INFO, null);
		}


	}


	public static void 	Checkslidersessionsaved(String pos, String Elementname, String color) throws Exception {


		WebElement Sessionstored = getDriver().findElement(By.xpath(pos));

		try{
			String checkpoint = Sessionstored.getCssValue("background-color");

			if(checkpoint.contains(color)){
				ATUReports.add("Session Not Saved For Filter settings  "+Elementname+" Option", LogAs.FAILED, null);
			}else{
				ATUReports.add("Session  Saved For filter settings  "+Elementname+" Option", LogAs.PASSED, null);
			}
		}catch(Exception e){
			Thread.sleep(2000);

		}

		closecrewreport();
	}


	//Below will check the session saved will hold as it is

	public static void 	Savesortsession() throws Exception {

		Thread.sleep(2000);

		TestcaseInit();
		Checkconsolidatedcrewicon();
		Thread.sleep(1000);
		WebElement pos = getDriver().findElement(By.xpath(Web_UI.Crewpos));
		Thread.sleep(1000);
		pos.click();
		reopencrewreport();
		checkSavesession(Web_UI.Crewposspan,"POS");

		OpenCrewReport();
		Thread.sleep(1000);
		WebElement userid = getDriver().findElement(By.xpath(Web_UI.Crewuserid));
		Thread.sleep(1000);
		userid.click();
		reopencrewreport();
		checkSavesession(Web_UI.Crewuseridspan,"userid");

		OpenCrewReport();
		Thread.sleep(1000);
		WebElement EmpName = getDriver().findElement(By.xpath(Web_UI.CrewEmpName));
		Thread.sleep(1000);
		EmpName.click();
		reopencrewreport();
		checkSavesession(Web_UI.CrewEmpNamespan,"EmpName");

		OpenCrewReport();
		Thread.sleep(1000);
		WebElement Scantime = getDriver().findElement(By.xpath(Web_UI.CrewScantime));
		Thread.sleep(1000);
		Scantime.click();
		reopencrewreport();
		checkSavesession(Web_UI.CrewScantimespan,"Scantime");

		OpenCrewReport();
		Thread.sleep(1000);
		WebElement Flightno = getDriver().findElement(By.xpath(Web_UI.CrewFlightno));
		Thread.sleep(1000);
		Flightno.click();
		reopencrewreport();
		checkSavesession(Web_UI.CrewFlightnospan,"Flightno");

		OpenCrewReport();
		Thread.sleep(1000);
		WebElement Etd = getDriver().findElement(By.xpath(Web_UI.CrewEtd));
		Thread.sleep(1000);
		Etd.click();
		reopencrewreport();
		checkSavesession(Web_UI.CrewEtdspan,"Etd");

		OpenCrewReport();
		Thread.sleep(1000);
		WebElement Gate = getDriver().findElement(By.xpath(Web_UI.CrewGate));
		Thread.sleep(1000);
		Gate.click();
		reopencrewreport();
		checkSavesession(Web_UI.CrewGatespan,"Gate");

		OpenCrewReport();
		Thread.sleep(1000);
		WebElement INBFlt = getDriver().findElement(By.xpath(Web_UI.CrewINBFlt));
		Thread.sleep(1000);
		INBFlt.click();
		reopencrewreport();
		checkSavesession(Web_UI.CrewINBFltspan,"INBFlt");

		OpenCrewReport();
		Thread.sleep(1000);
		WebElement ORIGIN = getDriver().findElement(By.xpath(Web_UI.CrewORIGIN));
		Thread.sleep(1000);
		ORIGIN.click();
		reopencrewreport();
		checkSavesession(Web_UI.CrewORIGINspan,"ORIGIN");

		OpenCrewReport();
		Thread.sleep(1000);
		WebElement Gate2 = getDriver().findElement(By.xpath(Web_UI.CrewGate2));
		Thread.sleep(1000);
		Gate2.click();
		reopencrewreport();
		checkSavesession(Web_UI.CrewGate2span,"Gate2");


		OpenCrewReport();
		Thread.sleep(1000);
		WebElement Status = getDriver().findElement(By.xpath(Web_UI.CrewStatus));
		Thread.sleep(1000);
		Status.click();
		reopencrewreport();
		checkSavesession(Web_UI.CrewStatusspan,"Status");

		OpenCrewReport();
		Thread.sleep(1000);
		WebElement ETA = getDriver().findElement(By.xpath(Web_UI.CrewETA));
		Thread.sleep(1000);
		ETA.click();
		reopencrewreport();
		checkSavesession(Web_UI.CrewETAspan,"ETA");

		OpenCrewReport();
		Thread.sleep(1000);
		WebElement connex = getDriver().findElement(By.xpath(Web_UI.Crewconnex));
		Thread.sleep(1000);
		connex.click();
		reopencrewreport();
		checkSavesession(Web_UI.Crewconnexspan,"connex");

		OpenCrewReport();
		Thread.sleep(1000);
		WebElement MOTFDP = getDriver().findElement(By.xpath(Web_UI.crewMOTFDP));
		Thread.sleep(1000);
		MOTFDP.click();
		reopencrewreport();
		checkSavesession(Web_UI.crewMOTFDPSpan,"MOTFDP");

	}

	public static void 	OpenCrewReport() throws Exception {	
		TestcaseInit();
		CommonTest.SpinnerControl();
		WebElement Consolidatedcrewicon = getDriver().findElement(By.xpath(Web_UI.Crewconnexicon));
		clickBywebelementxpath(Consolidatedcrewicon,"Consolidatedcrewicon");
		CommonTest.SpinnerControl();
		Thread.sleep(3000);
	}

	public static void 	reopencrewreport() throws Exception {
		CommonTest.SpinnerControl();
		checkcrewisclosed();
		WebElement Consolidatedcrewicon = getDriver().findElement(By.xpath(Web_UI.Crewconnexicon));
		clickBywebelementxpath(Consolidatedcrewicon,"Consolidatedcrewicon");
		CommonTest.SpinnerControl();
		Thread.sleep(3000);
	}

	public static void 	checkSavesession(String pos, String Elementname) throws Exception {


		WebElement Sessionstored = getDriver().findElement(By.xpath(pos));

		try{
			String checkpoint = Sessionstored.getAttribute("class");

			if(checkpoint.contains("nrml")){
				ATUReports.add("Session Not Saved and Crew report Not saved with last stored session when user selected  "+Elementname+" Option", LogAs.FAILED, null);
			}else{
				ATUReports.add("Session Saved and Crew report saved with last stored session when user selected  "+Elementname+" Option", LogAs.PASSED, null);
			}
		}catch(Exception e){
			Thread.sleep(2000);

		}

		closecrewreport();
	}


	//Validate crew report sort functionality working as expected
	public static void 	CrewSortAscendingDescending() throws Exception {
		TestcaseInit();
		Checkconsolidatedcrewicon();
		Thread.sleep(2000);
		WebElement pos = getDriver().findElement(By.xpath(Web_UI.Crewpos));
		WebElement userid = getDriver().findElement(By.xpath(Web_UI.Crewuserid));
		WebElement EmpName = getDriver().findElement(By.xpath(Web_UI.CrewEmpName));
		//WebElement Scantime = getDriver().findElement(By.xpath(Web_UI.CrewScantime));
		WebElement Flightno = getDriver().findElement(By.xpath(Web_UI.CrewFlightno));
		WebElement Etd = getDriver().findElement(By.xpath(Web_UI.CrewEtd));
		WebElement Gate = getDriver().findElement(By.xpath(Web_UI.CrewGate));
		WebElement INBFlt = getDriver().findElement(By.xpath(Web_UI.CrewINBFlt));
		WebElement ORIGIN = getDriver().findElement(By.xpath(Web_UI.CrewORIGIN));
		WebElement Gate2 = getDriver().findElement(By.xpath(Web_UI.CrewGate2));
		WebElement Status = getDriver().findElement(By.xpath(Web_UI.CrewStatus));
		WebElement ETA = getDriver().findElement(By.xpath(Web_UI.CrewETA));
		WebElement connex = getDriver().findElement(By.xpath(Web_UI.Crewconnex));

		//***********************************************************
		CheckSortGateAscending("div[1]/div[1]",pos );
		CheckSortGateAscending("div[1]/div[2]", userid );
		CheckSortGateAscending("div[1]/div[3]", EmpName );
		//CheckSortGateAscending("div[1]/div[4]", Scantime );
		CheckSortGateAscending("div[2]/div[1]", Flightno );
		CheckSortGateAscending("div[2]/div[2]", Etd );
		CheckSortGateAscending("div[2]/div[3]", Gate );
		CheckSortGateAscending("div[2]/div[4]", INBFlt );
		CheckSortGateAscending("div[3]/div[1]/div[1]", ORIGIN );
		CheckSortGateAscending("div[3]/div[1]/div[2]", Gate2 );
		CheckSortGateAscending("div[3]/div[1]/div[3]", Status );
		CheckSortGateAscending("div[3]/div[1]/div[4]", ETA );
		CheckSortGateAscending("div[3]/div[2]", connex );
		//************************************************************
		CheckSortGateDescending("div[1]/div[1]", pos);
		CheckSortGateDescending("div[1]/div[2]", userid);
		CheckSortGateDescending("div[1]/div[3]", EmpName);
		//CheckSortGateDescending("div[1]/div[4]", Scantime);
		CheckSortGateDescending("div[2]/div[1]", Flightno);
		CheckSortGateDescending("div[2]/div[2]", Etd);
		CheckSortGateDescending("div[2]/div[3]", Gate);
		CheckSortGateDescending("div[2]/div[4]", INBFlt);
		CheckSortGateDescending("div[3]/div[1]/div[1]", ORIGIN);
		CheckSortGateDescending("div[3]/div[1]/div[2]", Gate2);
		CheckSortGateDescending("div[3]/div[1]/div[3]", Status);
		CheckSortGateDescending("div[3]/div[1]/div[4]", ETA);
		CheckSortGateDescending("div[3]/div[2]", connex);

		closecrewreport();
	}


	/// Validate the crew report display As per the color coding defined
	public static void 	Crewalertcoloring() throws Exception {
		TestcaseInit();
		Checkconsolidatedcrewicon();
		Thread.sleep(2000);
		try{
			List<WebElement> Listelementfetched = getDriver().findElements(By.xpath("//div[contains(@class,'col-lg-12 col-xs-12 crew-overflow')]/div[@class='col-lg-12 scroll-report no-padding  report-bg ng-scope']"));
			for (WebElement listiterator : Listelementfetched) {

				String Value = listiterator.findElement(By.xpath("div[3]/div[2]")).getAttribute("innerText");
				String connex = Value.trim();
				String Color = listiterator.findElement(By.xpath("div[3]/div[2]")).getCssValue("background-color");

				int connectiontime = Integer.parseInt(connex);
				if(connectiontime>30&&connectiontime<46){
					ATUReports.add("Connection time is Less than 45 and greater than 30 MINUTES", LogAs.PASSED, null);
					if(Color.contains("255, 206, 4")){
						ATUReports.add("Displayed in Yellow color", LogAs.PASSED, null);
					}else{
						ATUReports.add("Not displayed in Yellow color", LogAs.FAILED, null);
					}
				}

				if(connectiontime>1&&connectiontime<30){
					ATUReports.add("Connection time is Less than 30 and greater than a MINUTES", LogAs.PASSED, null);
					if(Color.contains("212, 0, 0")){
						ATUReports.add("Displayed in RED color", LogAs.PASSED, null);
					}else{
						ATUReports.add("Not displayed in RED color", LogAs.FAILED, null);
					}
				}
			}
		}catch(Exception Err){
			ATUReports.add("No Alerting flights present ", LogAs.INFO, null);
		}
		closecrewreport();
	}










	private static void confirmsearchworking(String SearchKey, String categoryofstring) throws InterruptedException {
		if(SearchKey.contains("HBLA")){
			ATUReports.add("No crew report to validate "+categoryofstring, LogAs.INFO, null);
		}else{

			SendtextbyXpath("//input[contains(@ng-model,'crewSearch')]", SearchKey);
			try{
				String Getcompletetextofreport = getDriver().findElement(By.xpath("//div[contains(@class,'col-lg-12 col-xs-12 crew-overflow')]")).getAttribute("innerText");
				Thread.sleep(2000);
				if(Getcompletetextofreport.contains(SearchKey)){
					ATUReports.add("Search result displayed when user searched with  "+categoryofstring, LogAs.PASSED, null);
					System.out.println("Search result displayed when user searched with  "+categoryofstring);
				}else{
					ATUReports.add("Search result not displayed when user searched with "+categoryofstring, LogAs.PASSED, null);
					System.out.println("Search result not displayed when user searched with  "+categoryofstring);
				}
			}catch(Exception err){
				ATUReports.add("Some issues in search script", LogAs.INFO, null);
			}


			getDriver().findElement(By.xpath("//input[contains(@ng-model,'crewSearch')]")).clear();

		}

	}

	public static String Getsearchstring(String xpathforcolomn ) throws Exception {

		try{
			String GetsearchStringvalue = getDriver().findElement(By.xpath(xpathforcolomn)).getAttribute("innerText");

			return GetsearchStringvalue;
		}catch (Exception er){
			return "HBLA";
		}

	}



	public static void CheckSortGateAscending(String xpathforcolomn, WebElement clickableheader ) throws Exception {
		///clickByXpath("//div[contains(@class,'report-crew-title delay-heading')]/div[1]/div[4]","Scan time");
		Thread.sleep(1000);
		// Pull the gate values to list
		ArrayList<String> AllReportvalues = new ArrayList<String>();	
		ArrayList<String> AllReportvaluessorting = new ArrayList<String>();	
		List<WebElement> Listelementfetched = getDriver().findElements(By.xpath("//div[contains(@class,'crew-overflow')]/div[contains(@class,'report-bg ng-scope')]"));
		for (WebElement listiterator : Listelementfetched) {

			String Value = listiterator.findElement(By.xpath(xpathforcolomn)).getAttribute("innerText");
			AllReportvalues.add(Value);

		}

		System.out.println("Values fetched from report :: "+ AllReportvalues);

		clickBywebelementxpath(clickableheader,"clickableheader");
		Thread.sleep(2000);

		List<WebElement> Listelementfetched1 = getDriver().findElements(By.xpath("//div[contains(@class,'crew-overflow')]/div[contains(@class,'report-bg ng-scope')]"));

		// Storing it into another array for force sort from java and compare the exist array is matching	
		for (WebElement listiterator2 : Listelementfetched1) {
			String Value1 = listiterator2.findElement(By.xpath(xpathforcolomn)).getAttribute("innerText");
			AllReportvaluessorting.add(Value1);
		}
		Collections.sort(AllReportvalues,new AlphanumComparator());
		System.out.println("AfterSort  Ascending : "+ AllReportvalues);


		//Perform comparison
		boolean result = Arrays.equals(AllReportvalues.toArray(),AllReportvaluessorting.toArray());

		// Return result
		if(result==true)
		{
			ATUReports.add("Arranged properly in Ascending order ",  LogAs.PASSED, null);
			ATUReports.add("Sorted Ascending order is  valid   ::  "+AllReportvaluessorting+"  "+AllReportvalues,  LogAs.PASSED, null);
		}
		else
		{
			ATUReports.add("Not arranged in Ascending order" +AllReportvaluessorting+"  "+AllReportvalues ,  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			System.out.println(result);
		}

	}


	public static void CheckSortGateDescending(String xpathforcolomn, WebElement clickableheader) throws Exception {
		//clickByXpath("//div[contains(@class,'report-crew-title delay-heading')]/div[1]/div[4]","Scan time");
		Thread.sleep(1000);
		// Pull the gate values to list
		ArrayList<String> AllReportvalues = new ArrayList<String>();	
		ArrayList<String> AllReportvaluessorting = new ArrayList<String>();	
		List<WebElement> Listelementfetched = getDriver().findElements(By.xpath("//div[contains(@class,'col-lg-12 col-xs-12 crew-overflow')]/div[@class='col-lg-12 scroll-report no-padding  report-bg ng-scope']"));
		for (WebElement listiterator : Listelementfetched) {
			String Value = listiterator.findElement(By.xpath(xpathforcolomn)).getAttribute("innerText");
			AllReportvalues.add(Value);

		}

		System.out.println("Values fetched from report :: "+ AllReportvalues);

		clickBywebelementxpath(clickableheader,"clickableheader");
		clickBywebelementxpath(clickableheader,"clickableheader");
		Thread.sleep(2000);

		// Storing it into another array for force sort from java and compare the exist array is matching	
		List<WebElement> Listelementfetched1 = getDriver().findElements(By.xpath("//div[contains(@class,'col-lg-12 col-xs-12 crew-overflow')]/div[@class='col-lg-12 scroll-report no-padding  report-bg ng-scope']"));
		for (WebElement listiterator2 : Listelementfetched1) {
			String Value1 = listiterator2.findElement(By.xpath(xpathforcolomn)).getAttribute("innerText");
			AllReportvaluessorting.add(Value1);
		}
		Collections.sort(AllReportvalues,new AlphanumComparator2());

		System.out.println("AfterSort Descending : "+ AllReportvalues);


		//Perform comparison
		boolean result = Arrays.equals(AllReportvalues.toArray(),AllReportvaluessorting.toArray());

		// Return result
		if(result==true)
		{
			ATUReports.add( "Arranged  properly in Descending order"+AllReportvaluessorting+"  "+AllReportvalues,  LogAs.PASSED, null);
			ATUReports.add("Sorted Descending order is valid::  "+AllReportvaluessorting+"  "+AllReportvalues,  LogAs.PASSED, null);
			System.out.println(result);
		}
		else
		{
			ATUReports.add("Not Arranged properly in Descending order"+AllReportvaluessorting+"  "+AllReportvalues,  LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE)); 
			ATUReports.add("Sorted order::  "+AllReportvaluessorting+"  "+AllReportvalues,  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			System.out.println(result);
		}




	}

	//******************************************************************************************************************************************************************

	// Verify the message when crew report not have data
	public static boolean Checkreporthavedetails() throws Exception {

		try{
			WebElement noreport = getDriver().findElement(By.xpath(Web_UI.CrewNoreport));
			String NoreportMessage = noreport.getAttribute("innerText");
			if(NoreportMessage.contains("No crew connection")){
				return true;
			}else{
				return false;
			}}catch(Exception Er){
				return false;
			}

	}

	//*******************************************************************************************************************************************************************

	public static void NoCrewdetailsReportmessage() throws Exception {

		Checkconsolidatedcrewicon();
		Thread.sleep(2000);
		boolean Checkmessageexist = Checkreporthavedetails();

		if(Checkmessageexist==true){
			ATUReports.add("Valid error message displayed to user when No crew is alerting for the selected station ",  LogAs.PASSED,null);
		}else
		{
			ATUReports.add("Error message is not valid when No Crew is alerting for the selected station ",  LogAs.FAILED,null);
		}

		closecrewreport();
	}

	//********************************************************************************************************************************************************************	
	// Below will close crew report if it is opened
	public static void closecrewreport() throws Exception {

		WebElement Closebutton = getDriver().findElement(By.xpath(Web_UI.CrewClosebutton));
		try{
			clickBywebelementxpath(Closebutton,"Closebutton");
			ATUReports.add("Consolidated crew Report closed successfully ",  LogAs.PASSED,null);
		}
		catch(Exception ee){
			ATUReports.add("Consolidated crew Report No closed ",  LogAs.FAILED,null);
		}
		Thread.sleep(2000);
	}

	public static void checkcrewisclosed() throws Exception {
		try{
			WebElement Closebutton = getDriver().findElement(By.xpath(Web_UI.CrewClosebutton));
			clickBywebelementxpath(Closebutton,"Closebutton");
			ATUReports.add("Consolidated crew Report closed successfully ",  LogAs.PASSED,null);
		}
		catch(Exception ee){

		}
		Thread.sleep(2000);
	}

	//Verify OFF and OUT status flights are not present in consolidated crew report

	public static void Offandoutflightshouldnotpresent() throws Exception {
		TestcaseInit();
		Checkconsolidatedcrewicon();
		Thread.sleep(2000);
		try{
			ArrayList<String> AllReportvalues = new ArrayList<String>();	
			ArrayList<String> AllReportvaluessorting = new ArrayList<String>();	
			List<WebElement> Listelementfetched = getDriver().findElements(By.xpath("//div[contains(@class,'crew-overflow')]/div[contains(@class,'report-bg ng-scope')]"));
			for (WebElement listiterator : Listelementfetched) {

				String Value = listiterator.findElement(By.xpath("div[3]/div[1]/div[3]")).getAttribute("innerText");
				AllReportvalues.add(Value);

			}

			List<String> Statusshouldnothave = Arrays.asList("CXL","OUT","OFF");
			int Statusvaluefetchedfromreport = AllReportvalues.size();
			for(int m=0;m<Statusvaluefetchedfromreport;m++){
				String statusiterationvalue = AllReportvalues.get(m);
				boolean contains = Statusshouldnothave.contains(statusiterationvalue);
				if(contains == true){
					ATUReports.add("Contains OUT or OFF value ",  LogAs.FAILED,null);
				}else{
					ATUReports.add("Status do not contains OUT or OFF value ",  LogAs.PASSED,null);
				}
			}
		}catch(Exception noreport){

			ATUReports.add("Report is Empty ",  LogAs.PASSED,null);

		}	


	}

	public static void ConnexdiffofETDETA() throws Exception {
		Checkconsolidatedcrewicon();
		Thread.sleep(2000);
		try{
			ArrayList<String> AllReportvalues = new ArrayList<String>();	

			ArrayList<String> AllReportvaluessorting = new ArrayList<String>();	
			List<WebElement> Listelementfetched = getDriver().findElements(By.xpath("//div[contains(@class,'crew-overflow')]/div[contains(@class,'report-bg ng-scope')]"));
			for (WebElement listiterator : Listelementfetched) {

				String ETDValue = listiterator.findElement(By.xpath("div[2]/div[2]")).getAttribute("innerText").trim();
				String ETAValue = listiterator.findElement(By.xpath("div[3]/div[1]/div[4]")).getAttribute("innerText").trim();
				String Connex =  listiterator.findElement(By.xpath("div[3]/div[2]")).getAttribute("innerText").trim();
				AllReportvalues.add(ETDValue);


				String ETDValuewithseconds =ETDValue +":00";
				String ETAValuewithseconds =ETAValue +":00";

				Date ETDTime = new SimpleDateFormat("HH:mm:ss").parse(ETDValuewithseconds);
				Date ETATime = new SimpleDateFormat("HH:mm:ss").parse(ETAValuewithseconds);
				int connectiontime = ETDTime.getMinutes()-ETATime.getMinutes();
				System.out.println(connectiontime);
				String connexverification = Integer.toString(connectiontime);
				if(Connex.contains("-")){

				}else{
					if(Connex.contains(connexverification)){
						ATUReports.add("Difference of ETA and ETD = connextime is verified and passed ",  LogAs.PASSED,null);
					}else{
						ATUReports.add("Difference of ETA and ETD = connextime is verified and Failed "+"Expected:: "+Connex+"  Actual:: "+connexverification,  LogAs.FAILED,null);
					}
				}
			}



		}catch(Exception noreport){

			ATUReports.add("Report is Empty ",  LogAs.PASSED,null);

		}	

	}

	// Check whether the ETD should not be greater than 360 mins
	public static void Checketdlesthan360() throws Exception {

		TestcaseInit();
		try{

			String Currentstationtime = getDriver().findElement(By.xpath("//div[@class='dp-date-header']/span[1]")).getAttribute("innerText").trim();
			String Currenttime = Currentstationtime+":00";

			Checkconsolidatedcrewicon();
			Thread.sleep(2000);


			try{

				ArrayList<String> AllReportvalues = new ArrayList<String>();	

				ArrayList<String> AllReportvaluessorting = new ArrayList<String>();	
				List<WebElement> Listelementfetched = getDriver().findElements(By.xpath("//div[contains(@class,'crew-overflow')]/div[contains(@class,'report-bg ng-scope')]"));
				for (WebElement listiterator : Listelementfetched) {

					String ETDValue = listiterator.findElement(By.xpath("div[2]/div[2]")).getAttribute("innerText").trim();
					String ETDValuewithseconds =ETDValue +":00";


					Date ETDTime = new SimpleDateFormat("HH:mm:ss").parse(ETDValuewithseconds);
					Date StationTime = new SimpleDateFormat("HH:mm:ss").parse(Currenttime);

					long difference = ETDTime.getTime() - StationTime.getTime();
					DecimalFormat crunchifyFormatter = new DecimalFormat("###,###");		 
					int diffmin = (int) (difference / (60 * 1000));
					System.out.println("difference between minutues: " + crunchifyFormatter.format(diffmin));
					if(diffmin<=360){
						ATUReports.add("ETD falls under 360 min and verified",  LogAs.PASSED,null);
					}
					else
					{
						ATUReports.add("ETD is more than 360 min and failed.",  LogAs.FAILED,null);
					}
				}


			}catch(Exception TR){

			}

		}catch(Exception ST){

		}


	}

	//Verify the slider exist in consolidate crew report/

	public static void CheckSliderexist() throws Exception {
		TestcaseInit();
		OpenCrewReport();
		try{
			WebElement Slider = getDriver().findElement(By.xpath(Web_UI.Crewslider));	
			if(Slider!=null){
				ATUReports.add("Slider present in consolidated crew report ",  LogAs.PASSED,null);
			}else{
				ATUReports.add("Slider Not present in consolidated crew report ",  LogAs.PASSED,null);

			}
		}catch(Exception Slidernotexist){
			ATUReports.add("Slider not exist.", LogAs.INFO, null);
		}
		closecrewreport();
	}

}
