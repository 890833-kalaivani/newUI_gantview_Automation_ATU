/*
 * This Class contains functions to validate scenarios related to Gantt view 
 * and Header functionalities
 * 
 */

package get.next.gen.serviceutils;



import get.next.gen.commonaction.CommonTest;
import get.next.gen.serviceutils.ServiceComparisioncorrection;
import get.next.gen.webtestcase.*;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.Matcher;






















import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;

import atu.testng.reports.ATUReports;
import atu.testng.reports.logging.LogAs;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import atu.testng.reports.listeners.ATUReportsListener;
import atu.testng.reports.listeners.ConfigurationListener;
import atu.testng.reports.listeners.MethodListener;
@Listeners({ ATUReportsListener.class, ConfigurationListener.class,
MethodListener.class })

public class ServiceComparisionUtilities extends CommonTest {
	
	
	 public static void VerifyTarmacreport() throws Exception{
			
		// test.log(LogStatus.INFO, "This Test will compare the old and new service for Tarmac report ");
		 ATUReports.add(" ",  LogAs.PASSED, null);; 
		 
		  	String Oldurl = Service_UI.getTarmacReportOldurl;
			String Newurl= Service_UI.getTarmacReportNewurl;
			String Starttime = Service_UI.Starttime;
			String Endtime = Service_UI.Endtime;
	
			String Stations[] = {"DFW"};
			
			for( int i = 0; i < Stations.length; i++)
			{	
				String sta = Stations[i];
				System.out.println(sta);
				String request="{\"station\":\""+sta+"\",\"transactionId\":\"UNKNOWN-0.0.00000_BETA00789696_DFW_1507119025574_212\"}";
				ServiceComparisioncorrection.ServiceComparisionstartcode("Tarmacreport",Oldurl,request,Newurl,sta);
			}	

			
	 }

	public static void SaveOrUpdateUserZones() throws Exception {
	
		// test.log(LogStatus.INFO, "This Test will compare the old and new service for SaveOrUpdateUserZones ");

		 ATUReports.add(" ",  LogAs.PASSED, null);; 
		 
		String Oldurl=Service_UI.saveOrUpdateUserZonesOldurl;
		String Newurl=Service_UI.saveOrUpdateUserZonesNewurl;
		String Starttime = Service_UI.Starttime;
		String Endtime = Service_UI.Endtime;

		String Stations[] = {"DFW","PHL"};
		
		
		for( int i = 0; i < Stations.length; i++)
		{	
			String sta = Stations[i];
			System.out.println(sta);
			String request="{\"userId\":\"NG_00789696\",\"station\":\""+sta+"\",\"transactionId\":\"UNKNOWN-0.0.00000_BETA00789696_DFW_1507119818691_204\"}";
			
			ServiceComparisioncorrection.ServiceComparisionstartcode("SaveOrUpdateUserZones",Oldurl,request,Newurl,sta);
		}
		
	}

	public static void getZonesAndGates() throws Exception {

		// test.log(LogStatus.INFO, "This Test will compare the old and new service for getZonesAndGates ");
		 ATUReports.add("This Test will compare the old and new service for getZonesAndGates ",  LogAs.INFO, new CaptureScreen(ScreenshotOf.DESKTOP));; 
		 
		String Oldurl=Service_UI.getZonesAndGatesOldurl;
		String Newurl=Service_UI.getZonesAndGatesNewurl;
		String Starttime = Service_UI.Starttime;
		String Endtime = Service_UI.Endtime;

		String Stations[] = {"DFW","PHL"};
		
		for( int i = 0; i < Stations.length; i++)
		{	
			String sta = Stations[i];
			System.out.println(sta);
			String request="{\"userId\":\"00789696\",\"station\":\""+sta+"\",\"transactionId\":\"UNKNOWN-0.0.00000_BETA00789696_DFW_1507119819605_200\"}";
			 
			ServiceComparisioncorrection.ServiceComparisionstartcode("getZonesAndGates",Oldurl,request,Newurl,sta);
		}
		
	
		
	}

	public static void getLongOnBoardAlert() throws Exception {

		// test.log(LogStatus.INFO, "This Test will compare the old and new service for getLongOnBoardAlert ");
		 ATUReports.add("This Test will compare the old and new service for getLongOnBoardAlert ",  LogAs.INFO, new CaptureScreen(ScreenshotOf.DESKTOP));; 
		 
		String Oldurl=Service_UI.getLongOnBoardAlertOldurl;
		String Newurl=Service_UI.getLongOnBoardAlertNewurl;
		String Starttime = Service_UI.Starttime;
		String Endtime = Service_UI.Endtime;

		String Stations[] = {"DFW","PHL"};

		for( int i = 0; i < Stations.length; i++)
		{	
			String sta = Stations[i];
			System.out.println(sta);
			String request="{\"station\":\""+sta+"\",\"timeRange\":\"2\",\"allIataCodes\":true,\"allGates\":true,\"gates\":[],\"iataCodes\":[],\"sortBy\":\"tails\",\"transactionId\":\"UNKNOWN-0.0.00000_BETA00789696_DFW_1507121463141_213\"}";
			
			ServiceComparisioncorrection.ServiceComparisionstartcode("getLongOnBoardAlert",Oldurl,request,Newurl,sta);
		}
		
	
		
	
		
	}

	public static void getRecentSwapCount() throws Exception {
	
		//test.log(LogStatus.INFO, "This Test will compare the old and new service for getRecentSwapCount ");
		ATUReports.add("This Test will compare the old and new service for getRecentSwapCount ",  LogAs.INFO, new CaptureScreen(ScreenshotOf.DESKTOP));; 
		
		
		String Oldurl=Service_UI.getRecentSwapCountOldurl;
		String Newurl=Service_UI.getRecentSwapCountNewurl;
		String Starttime = Service_UI.Starttime;
		String Endtime = Service_UI.Endtime;

		String Stations[] = {"DFW","PHL"};
		
		for( int i = 0; i < Stations.length; i++)
		{	
			String sta = Stations[i];
			System.out.println(sta);
			String request="{\"station\":\""+sta+"\",\"timeRange\":\"2\",\"allIataCodes\":true,\"allGates\":true,\"gates\":[],\"iataCodes\":[],\"sortBy\":\"tails\",\"transactionId\":\"UNKNOWN-0.0.00000_BETA00789696_PHL_1507121847087_213\"}";
			

			ServiceComparisioncorrection.ServiceComparisionstartcode("getRecentSwapCount",Oldurl,request,Newurl,sta);
		}
	}

	public static void getStationOffset() throws Exception {
		
		//test.log(LogStatus.INFO, "This Test will compare the old and new service for getStationOffset ");
		ATUReports.add("This Test will compare the old and new service for getStationOffset ",  LogAs.INFO, new CaptureScreen(ScreenshotOf.DESKTOP));; 
		
		
		String Oldurl=Service_UI.stationOffsetOldurl;
		String Newurl=Service_UI.stationOffsetNewurl;
		String Starttime = Service_UI.Starttime;
		String Endtime = Service_UI.Endtime;
		String Stations[] = {"DFW"};
		
		for( int i = 0; i < Stations.length; i++)
		{	
			String sta = Stations[i];
			System.out.println(sta);
			String request="{\"userId\":\"NG_00789696\",\"station\":\""+sta+"\",\"transactionId\":\"UNKNOWN-0.0.00000_BETA00789696_DFW_1507114816389_204\"}";
			

			ServiceComparisioncorrection.ServiceComparisionstartcode("getRecentSwapCount",Oldurl,request,Newurl,sta);
		}
	
	}

	public static void getSwapReport() throws Exception {

		//test.log(LogStatus.INFO, "This Test will compare the old and new service for getSwapReport ");	
		ATUReports.add("This Test will compare the old and new service for getSwapReport ",  LogAs.INFO, new CaptureScreen(ScreenshotOf.DESKTOP));; 
		
		String Oldurl=Service_UI.getSwapReportOldurl;
		String Newurl=Service_UI.getSwapReportNewurl;
		String Starttime = Service_UI.Starttime;
		String Endtime = Service_UI.Endtime;


		String Stations[] = {"DFW","MIA"};
		
		
		for( int i = 0; i < Stations.length; i++)
		{	
			String sta = Stations[i];
			System.out.println(sta);
			String request="{\"station\":\""+sta+"\",\"timeRange\":\"2\",\"allIataCodes\":true,\"allGates\":true,\"gates\":[],\"iataCodes\":[],\"sortBy\":\"gates\",\"transactionId\":\"UNKNOWN-0.0.00000_BETA00789696_DFW_1507118490559_213\"}";
			

			ServiceComparisioncorrection.ServiceComparisionstartcode("getSwapReport",Oldurl,request,Newurl,sta);
		}
	
	
		
	}

	public static void getFlightDelayReport() throws Exception {

		//test.log(LogStatus.INFO, "This Test will compare the old and new service for getFlightDelayReport ");	
		ATUReports.add("This Test will compare the old and new service for getFlightDelayReport ",  LogAs.INFO, new CaptureScreen(ScreenshotOf.DESKTOP));; 
		
	String Oldurl=Service_UI.getFlightDelayReportOldurl;
		String Newurl=Service_UI.getFlightDelayReportNewurl;
		String Starttime = Service_UI.Starttime;
		String Endtime = Service_UI.Endtime;

		String Stations[] = {"DFW","PHL"};

		for( int i = 0; i < Stations.length; i++)
		{	
			String sta = Stations[i];
			System.out.println(sta);
			String request="{\"station\":\""+sta+"\",\"startTime\":\""+Starttime+"\",\"endTime\":\""+Endtime+"\",\"pastFlights\":false,\"iatacode\":null,\"gates\":null,\"depDelayReq\":true,\"arrDelayReq\":false,\"transactionId\":\"UNKNOWN-0.0.00000_BETA00789696_"+sta+"_1507118811834_211\"}";
			
		
			ServiceComparisioncorrection.ServiceComparisionstartcode("getFlightDelayReport",Oldurl,request,Newurl,sta);
		}
	
	
		
	
		
	}

	public static void DeletecustomZone() throws Exception {

		//test.log(LogStatus.INFO, "This Test will compare the old and new service for DeletecustomZone ");	
		ATUReports.add("This Test will compare the old and new service for DeletecustomZone ",  LogAs.INFO, new CaptureScreen(ScreenshotOf.DESKTOP));; 
		
		String Oldurl=Service_UI.deleteCustomZonesOldurl;
			String Newurl=Service_UI.deleteCustomZonesNewurl;
			String Starttime = Service_UI.Starttime;
			String Endtime = Service_UI.Endtime;
			String flightkey = "AA,6465,2017-10-17,DFW,0";
			
			
		String Stations[] = {"DFW","PHL"};

			for( int i = 0; i < Stations.length; i++)
			{	
				String sta = Stations[i];
				System.out.println(sta);
				String request="{\"userId\":\"00789696\",\"station\":\""+sta+"\",\"zone\":\"TEST\",\"transactionId\":\"UNKNOWN-0.0.00000_BETA00789696_TPA_1507128798728_227\"}";
				

				
				ServiceComparisioncorrection.ServiceComparisionstartcode("DeletecustomZone",Oldurl,request,Newurl,sta);
			}
		
		
			
		
			
		
		
	}

	public static void getFlightEvents() throws Exception {
	
		//test.log(LogStatus.INFO, "This Test will compare the old and new service for getFlightEvents ");	
		ATUReports.add("This Test will compare the old and new service for getFlightEvents ",  LogAs.INFO, new CaptureScreen(ScreenshotOf.DESKTOP));; 
		
		
		String station = "DFW";
		String flightforgiventimeurl = Service_UI.getFlightsForGivenTimeflightforgiventimeurl;
		String Starttime = Service_UI.Starttime;
		String Endtime = Service_UI.Endtime;
		String request = "{\"station\":\"DFW\",\"startTime\":\""+Starttime+"\",\"endTime\":\""+Endtime+"\",\"pastFlights\":false,\"iatacode\":null,\"gates\":null,\"narrowBody\":true,\"wideBody\":true,\"transactionId\":\"UNKNOWN-0.0.00000_BETA00789696_DFW_1507111114808_201\"}";
		ServiceComparisioncorrection.ServiceComparisionstartcode("getFlightEvents",flightforgiventimeurl,request,flightforgiventimeurl,station);
		ArrayList<String> Flightkeylist =	ServiceComparisioncorrection.ServiceComparisionDataPuller("json1.txt", "EventAlert_Catering.xlsx", "EventAlert_Catering.xlsx", station);
		
		int counter = Flightkeylist.size();
		
		for(int increment=0;increment<counter;increment++ )
		{
			String Oldurl=Service_UI.getFlightEventsOldurl;
			String Newurl=Service_UI.getFlightEventsNewurl;
			String Stations[] = {"DFW"};

			for( int i = 0; i < Stations.length; i++)
			{	
				String sta = Stations[i];
				String oldrequest="[\""+Flightkeylist.get(increment)+"\"]";
				String newrequest="{\"fltKey\":[\""+Flightkeylist.get(increment)+"\"],\"transactionId\":\"UNKNOWN-0.0.00000_BETA00789696_DFW_1507115390297_219\"}";
				
				
				ServiceComparisioncorrection.ServiceComparisionstartcode1("getFlightEvents",Oldurl,oldrequest,Newurl,newrequest,Flightkeylist.get(increment));
			}
			
			
			
		}
		
		
		
	}

	public static void getPassengerDetails() throws Exception {

		//test.log(LogStatus.INFO, "This Test will compare the old and new service for getPassengerDetails ");	
		ATUReports.add("This Test will compare the old and new service for getPassengerDetails ",  LogAs.INFO, new CaptureScreen(ScreenshotOf.DESKTOP));; 
		
		
		String station = "DFW";
		String flightforgiventimeurl = Service_UI.getFlightsForGivenTimeflightforgiventimeurl;
		String Starttime = Service_UI.Starttime;
		String Endtime = Service_UI.Endtime;
		String request = "{\"station\":\"DFW\",\"startTime\":\""+Starttime+"\",\"endTime\":\""+Endtime+"\",\"pastFlights\":false,\"iatacode\":null,\"gates\":null,\"narrowBody\":true,\"wideBody\":true,\"transactionId\":\"UNKNOWN-0.0.00000_BETA00789696_DFW_1507111114808_201\"}";
		ServiceComparisioncorrection.ServiceComparisionstartcode("getPassengerDetails",flightforgiventimeurl,request,flightforgiventimeurl,station);
		ArrayList<String> Flightkeylist =	ServiceComparisioncorrection.ServiceComparisionDataPuller("json1.txt", "EventAlert_Catering.xlsx", "EventAlert_Catering.xlsx", station);
		
		int counter = Flightkeylist.size();
		
		for(int increment=0;increment<counter;increment++ )
		{
			String Oldurl=Service_UI.getPassengerDetailsOldurl;
			String Newurl=Service_UI.getPassengerDetailsNewurl;
			String Stations[] = {"DFW"};

			for( int i = 0; i < Stations.length; i++)
			{	
				String sta = Stations[i];
				String oldrequest="\""+Flightkeylist.get(increment)+"\"";
				String newrequest="{\"flightKey\":\""+Flightkeylist.get(increment)+"\",\"transactionId\":\"UNKNOWN-0.0.00000_BETA00789696_DFW_1507116690561_207\"}";
				
				
				ServiceComparisioncorrection.ServiceComparisionstartcode1("getPassengerDetails",Newurl,newrequest,Oldurl,oldrequest,Flightkeylist.get(increment));
			}
			
			
			
		}
		
		
		
	
		
	}

	public static void getCrewReport() throws Exception {

		//test.log(LogStatus.INFO, "This Test will compare the old and new service for getCrewReport ");	
		ATUReports.add("This Test will compare the old and new service for getCrewReport ",  LogAs.INFO, new CaptureScreen(ScreenshotOf.DESKTOP));; 
		
		String station = "DFW";
		String flightforgiventimeurl = Service_UI.getFlightsForGivenTimeflightforgiventimeurl;
		String Starttime = Service_UI.Starttime;
		String Endtime = Service_UI.Endtime;
		String request = "{\"station\":\"DFW\",\"startTime\":\""+Starttime+"\",\"endTime\":\""+Endtime+"\",\"pastFlights\":false,\"iatacode\":null,\"gates\":null,\"narrowBody\":true,\"wideBody\":true,\"transactionId\":\"UNKNOWN-0.0.00000_BETA00789696_DFW_1507111114808_201\"}";
		ServiceComparisioncorrection.ServiceComparisionstartcode("getCrewReport",flightforgiventimeurl,request,flightforgiventimeurl,station);
		ArrayList<String> Flightkeylist =	ServiceComparisioncorrection.ServiceComparisionDataPuller("json1.txt", "EventAlert_Catering.xlsx", "EventAlert_Catering.xlsx", station);
		
		int counter = Flightkeylist.size();
		
		for(int increment=0;increment<counter;increment++ )
		{
			String Oldurl=Service_UI.getCrewReportOldurl;
			String Newurl=Service_UI.getCrewReportNewurl;
			String Stations[] = {"DFW"};

			for( int i = 0; i < Stations.length; i++)
			{	
				String sta = Stations[i];
				String oldrequest="\""+Flightkeylist.get(increment)+"\"";
				String newrequest="{\"flightKey\":\""+Flightkeylist.get(increment)+"\",\"transactionId\":\"UNKNOWN-0.0.00000_BETA00789696_DFW_1507116690561_207\"}";
				
				
				ServiceComparisioncorrection.ServiceComparisionstartcode1("getCrewReport",Newurl,newrequest,Oldurl,oldrequest,Flightkeylist.get(increment));
			}
			
			
			
		}
		
		
		
	
		
	
		
	}

	public static void getBagReportDetails() throws Exception {
		
		//test.log(LogStatus.INFO, "This Test will compare the old and new service for getBagReportDetails ");	
		ATUReports.add("This Test will compare the old and new service for getBagReportDetails ",  LogAs.INFO, new CaptureScreen(ScreenshotOf.DESKTOP));; 	
		
		String station = "DFW";
		String flightforgiventimeurl = Service_UI.getFlightsForGivenTimeflightforgiventimeurl;
		String Starttime = Service_UI.Starttime;
		String Endtime = Service_UI.Endtime;
		String request = "{\"station\":\"DFW\",\"startTime\":\""+Starttime+"\",\"endTime\":\""+Endtime+"\",\"pastFlights\":false,\"iatacode\":null,\"gates\":null,\"narrowBody\":true,\"wideBody\":true,\"transactionId\":\"UNKNOWN-0.0.00000_BETA00789696_DFW_1507111114808_201\"}";
		ServiceComparisioncorrection.ServiceComparisionstartcode("getBagReportDetails",flightforgiventimeurl,request,flightforgiventimeurl,station);
		ArrayList<String> Flightkeylist =	ServiceComparisioncorrection.ServiceComparisionDataPuller("json1.txt", "EventAlert_Catering.xlsx", "EventAlert_Catering.xlsx", station);
		
		int counter = Flightkeylist.size();
		
		for(int increment=0;increment<counter;increment++ )
		{
			String Oldurl=Service_UI.getBagReportDetailsOldurl;
			String Newurl=Service_UI.getBagReportDetailsNewurl;
			String Stations[] = {"DFW"};

			for( int i = 0; i < Stations.length; i++)
			{	
				String sta = Stations[i];
				String oldrequest="\""+Flightkeylist.get(increment)+"\"";
				String newrequest="{\"fltKey\":[\""+Flightkeylist.get(increment)+"\"],\"transactionId\":\"UNKNOWN-0.0.00000_BETA00789696_DFW_1507116690561_207\"}";
				
				
				ServiceComparisioncorrection.ServiceComparisionstartcode1("getBagReportDetails",Newurl,newrequest,Oldurl,oldrequest,Flightkeylist.get(increment));
			}
			
			
			
		}
		
		
		
	
		
	
		
	
		
	}

	public static void getOffloadReportDetails() throws Exception {

		//test.log(LogStatus.INFO, "This Test will compare the old and new service for getOffloadReportDetails ");	
		ATUReports.add("This Test will compare the old and new service for getOffloadReportDetails ",  LogAs.INFO, new CaptureScreen(ScreenshotOf.DESKTOP));; 
		
		
		String station = "DFW";
		String flightforgiventimeurl = Service_UI.getFlightsForGivenTimeflightforgiventimeurl;
		String Starttime = Service_UI.Starttime;
		String Endtime = Service_UI.Endtime;
		String request = "{\"station\":\"DFW\",\"startTime\":\""+Starttime+"\",\"endTime\":\""+Endtime+"\",\"pastFlights\":false,\"iatacode\":null,\"gates\":null,\"narrowBody\":true,\"wideBody\":true,\"transactionId\":\"UNKNOWN-0.0.00000_BETA00789696_DFW_1507111114808_201\"}";
		ServiceComparisioncorrection.ServiceComparisionstartcode("getOffloadReportDetails",flightforgiventimeurl,request,flightforgiventimeurl,station);
		ArrayList<String> Flightkeylist =	ServiceComparisioncorrection.ServiceComparisionDataPuller("json1.txt", "EventAlert_Catering.xlsx", "EventAlert_Catering.xlsx", station);
		
		int counter = Flightkeylist.size();
		
		for(int increment=0;increment<counter;increment++ )
		{
			String Oldurl=Service_UI.getOffloadReportDetailsOldurl;
			String Newurl=Service_UI.getOffloadReportDetailsNewurl;
			String Stations[] = {"DFW"};

			for( int i = 0; i < Stations.length; i++)
			{	
				String sta = Stations[i];
				String oldrequest="{\"flightKey\":\""+Flightkeylist.get(increment)+"\",\"station\":\"DFW\",\"transactionId\":\"UNKNOWN-0.0.00000_BETA00789696_DFW_1507121143441_218\"}";
				
				
				String newrequest="{\"flightKey\":\""+Flightkeylist.get(increment)+"\",\"station\":\"DFW\",\"transactionId\":\"UNKNOWN-0.0.00000_BETA00789696_DFW_1507121143441_218\"}";
				
				
				ServiceComparisioncorrection.ServiceComparisionstartcode1("getOffloadReportDetails",Newurl,newrequest,Oldurl,oldrequest,Flightkeylist.get(increment));
			}
			
			
			
		}
		
		
		
	
		
	
		
	
		
	
		
	}

	public static void saveNotes() throws Exception {

		//test.log(LogStatus.INFO, "This Test will compare the old and new service for saveNotes ");	
		ATUReports.add("This Test will compare the old and new service for saveNotes ",  LogAs.INFO, new CaptureScreen(ScreenshotOf.DESKTOP));; 
		
		
		String station = "DFW";
		String flightforgiventimeurl = Service_UI.getFlightsForGivenTimeflightforgiventimeurl;
		String Starttime = Service_UI.Starttime;
		String Endtime = Service_UI.Endtime;
		String request = "{\"station\":\"DFW\",\"startTime\":\""+Starttime+"\",\"endTime\":\""+Endtime+"\",\"pastFlights\":false,\"iatacode\":null,\"gates\":null,\"narrowBody\":true,\"wideBody\":true,\"transactionId\":\"UNKNOWN-0.0.00000_BETA00789696_DFW_1507111114808_201\"}";
		ServiceComparisioncorrection.ServiceComparisionstartcode("saveNotes",flightforgiventimeurl,request,flightforgiventimeurl,station);
		ArrayList<String> Flightkeylist =	ServiceComparisioncorrection.ServiceComparisionDataPuller("json1.txt", "EventAlert_Catering.xlsx", "EventAlert_Catering.xlsx", station);
		
		int counter = Flightkeylist.size();
		
		for(int increment=0;increment<counter;increment++ )
		{
			String Oldurl=Service_UI.saveNotesOldurl;
			String Newurl=Service_UI.saveNotesNewurl;
			String Stations[] = {"DFW"};

			for( int i = 0; i < Stations.length; i++)
			{	
				String sta = Stations[i];
				String oldrequest="{\"note\":\"test\",\"userId\":\"00770823\",\"sendToCme\":false,\"addedAt\":1507165065796,\"visible\":true,\"name\":\"S.POTIPAREDDY\",\"fltKey\":\""+Flightkeylist.get(increment)+"\",\"addedAtStr\":\"10/17/201700:57\",\"transactionId\":\"UNKNOWN-0.0.00000_BETA00770823_DFW_1507201065800_231\"}";
				
				 
				
				String newrequest="{\"note\":\"test\",\"userId\":\"00770823\",\"sendToCme\":false,\"addedAt\":1507165065796,\"visible\":true,\"name\":\"S.POTIPAREDDY\",\"fltKey\":\""+Flightkeylist.get(increment)+"\",\"addedAtStr\":\"10/17/201700:57\",\"transactionId\":\"UNKNOWN-0.0.00000_BETA00770823_DFW_1507201065800_231\"}";
				
				
				ServiceComparisioncorrection.ServiceComparisionstartcode1("saveNotes",Newurl,newrequest,Oldurl,oldrequest,Flightkeylist.get(increment));
			}
			
			
			
		}
		
		
		
	
		
	
		
	
		
	
		
	
		
	}

	public static void getStationlist() throws Exception {

		//test.log(LogStatus.INFO, "This Test will compare the old and new service for getStationlist ");	
		ATUReports.add( "This Test will compare the old and new service for getStationlist ",  LogAs.INFO, new CaptureScreen(ScreenshotOf.DESKTOP));; 
		
		
	  	String Oldurl=Service_UI.getStationListOldurl;
		String Newurl=Service_UI.getStationListNewurl;
		String Starttime = Service_UI.Starttime;
		String Endtime = Service_UI.Endtime;

		String Stations[] = {"DFW"};
		
		for( int i = 0; i < Stations.length; i++)
		{	
			String sta = Stations[i];
			String request="{\"station\":\""+sta+"\",\"transactionId\":\"UNKNOWN-0.0.00000_BETA00789696_"+sta+"_1507119025574_212\"}";
			ServiceComparisioncorrection.Getcode(Oldurl,request,Newurl,sta,"GetStationlist");
		}	

		
 
		
	}
}
