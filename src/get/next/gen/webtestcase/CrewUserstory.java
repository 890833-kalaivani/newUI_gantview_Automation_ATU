package get.next.gen.webtestcase;

import get.next.gen.commonaction.CommonTest;
import get.next.gen.serviceutils.correction;
import get.next.gen.utilities.Alertingflightstatsvalidation;
import get.next.gen.utilities.CustomZone;
import get.next.gen.utilities.GanntViewHeaderFunctionality;
import get.next.gen.utilities.GanttviewPuckOptions;
import get.next.gen.utilities.Hybridview;



import get.next.gen.utilities.consolidatedcrewreport;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import atu.testng.reports.ATUReports;
import atu.testng.reports.logging.LogAs;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;



public class CrewUserstory extends CommonTest {


@Test(priority = 0)
public void T01_LoginTestcase() throws Exception {
	GanntViewHeaderFunctionality.Login("Envi");
			}

	


@Test(priority = 1)
public void TC_401_CheckConsolidatedReport() throws Exception {
	System.out.println("Requesting Backend to check which station have the Crew details to continue with Testscript ");
	String url="http://apapns43.pdc.aa.com:8080/GetNGServices/flight/getFlightsForGivenTime";
	String urlCache="http://apapns45.pdc.aa.com:8081/GetCrewCache/crew/getCrewAlertReport";
	String Stations[] = {"DFW","PHL","CLT","LAX","LGA","PIT","RDU","MIA","PHX","SFO","ORD","ABE","BOS","BPT","CHO","DTW","FRA","IAD","IAH","JFK","MAD","OGG","OKC","PHL","PIA","PIB",
			"PLS","PNS","POP","POS","PSP","PTP","PTY","PUJ","PVD","PVG","PVR","PWM","SJO","SJT","SJU","STL","STS","STT","SYD","SYR"};
	String Starttime = correction.getpasthrs("America/Chicago",6);
	String Endtime = correction.nexthrs("America/Chicago",2);
	
	DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	java.util.Date date = new java.util.Date();
	String dateWithoutTime =dateFormat.format(date);   //"02 May 2016"; 
	String strStartTime2 = dateWithoutTime + "T" + Starttime +".737Z";
	String strEndTime2 = dateWithoutTime + "T" + Endtime +".737Z";

	for( int i = 0; i < Stations.length; i++)
	{
	
	String request="{\"station\":\""+Stations[i]+"\",\"startTime\":\""+strStartTime2+"\",\"endTime\":\""+strEndTime2+"\",\"gates\":[],\"allGates\":true,\"pastFlights\":true,\"transactionId\":\"UNKNOWN_00812339_PHX_1489539768116_201\"}";
	String request2="{\"station\":\""+Stations[i]+"\",\"startTime\":\""+strStartTime2+"\",\"endTime\":\""+strEndTime2+"\",\"pastFlights\":false,\"iatacode\":null,\"gates\":null,\"narrowBody\":true,\"wideBody\":true,\"internationalFlts\":true,\"domesticFlts\":true,\"alertCountsReq\":false,\"transactionId\":\"UNKNOWN-0.0.00000_00789696_DFW_1517406950252_201\"}";
	ATUReports.add("****************Request for flights for given time "+request+"  ********",  LogAs.INFO, null);
	ATUReports.add("****************Request for Consolidated crew report "+request2+"  ********",  LogAs.INFO, null);
	System.out.println(" ");
	System.out.println(Stations[i]);
	String stationname = Stations[i];
	String Alerting = correction.getAlertingstation(url, request, urlCache, request2, stationname);
	
	if(Alerting.contains("Null")){
		
	}
	else{
		CustomZone.SelectStation(stationname);
		System.out.println("Station **"+stationname+"***  have the crew alerts and proceeding with validation with **"+stationname+"** Station");
		consolidatedcrewreport.Checkconsolidatedcrewicon();
		break;
	}
	
	}
}


	@Test(priority = 2)
	public void TC_402_VerifyCrewiconhavebubbleandtitle() throws Exception {
		
			consolidatedcrewreport.Bubbleholdcountwhencrewalerts();
			
	
	}	
		
		
		
		@Test(priority = 3)
		public void TC_403_VerifyHeaderofCrewReport() throws Exception {
			
			consolidatedcrewreport.Crewreportholdsreuiredtitle();
		
		}
			
			
			
			@Test(priority = 4)
			public void TC_404_CheckSortFunctionality() throws Exception {
	
				consolidatedcrewreport.CrewSortAscendingDescending();
	
			}	
				
				
				
	
			@Test(priority = 5)
			public void TC_404_CheckSearchFunctionality() throws Exception {
			
				consolidatedcrewreport.Searchfunctionality();
			
			}
			
	
		@Test(priority = 6)
			public void TC_405_VerifyredandyellowConnex() throws Exception {
			
					consolidatedcrewreport.Crewalertcoloring();
					
			}	
	
		@Test(priority = 7)
		public void TC_406_Offandoutflightshouldnotpresent() throws Exception {
			
				consolidatedcrewreport.Offandoutflightshouldnotpresent();
				

		}

		@Test(priority = 8)
		public void TC_407_ConnexdiffofETDETA() throws Exception {
			
				consolidatedcrewreport.ConnexdiffofETDETA();
				

		}
			

		@Test(priority = 9)
		public void TC_408_Checketdlesthan360() throws Exception {

			consolidatedcrewreport.Checketdlesthan360();

		}
		
			@Test(priority = 10)
			public void TC_404_VerifyNocrewalerting() throws Exception {
				String url="http://apapns43.pdc.aa.com:8080/GetNGServices/flight/getFlightsForGivenTime";
				String urlCache="http://apapns45.pdc.aa.com:8081/GetCrewCache/crew/getCrewAlertReport";
				String Stations[] = {"DFW","PHL","CLT","LAX","LGA","PIT","RDU","MIA","PHX","SFO","ORD","ABE","BOS","BPT","CHO","DTW","FRA","IAD","IAH","JFK","MAD","OGG","OKC","PHL","PIA","PIB",
						"PLS","PNS","POP","POS","PSP","PTP","PTY","PUJ","PVD","PVG","PVR","PWM","SJO","SJT","SJU","STL","STS","STT","SYD","SYR"};
				String Starttime = correction.getpasthrs("America/Chicago",6);
				String Endtime = correction.nexthrs("America/Chicago",2);
				
				DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				java.util.Date date = new java.util.Date();
				String dateWithoutTime =dateFormat.format(date);   //"02 May 2016"; 
				String strStartTime2 = dateWithoutTime + "T" + Starttime +".737Z";
				String strEndTime2 = dateWithoutTime + "T" + Endtime +".737Z";

				for( int i = 0; i < Stations.length; i++)
				{
				
				String request="{\"station\":\""+Stations[i]+"\",\"startTime\":\""+strStartTime2+"\",\"endTime\":\""+strEndTime2+"\",\"gates\":[],\"allGates\":true,\"pastFlights\":true,\"transactionId\":\"UNKNOWN_00812339_PHX_1489539768116_201\"}";
				String request2="{\"station\":\""+Stations[i]+"\",\"startTime\":\""+strStartTime2+"\",\"endTime\":\""+strEndTime2+"\",\"pastFlights\":false,\"iatacode\":null,\"gates\":null,\"narrowBody\":true,\"wideBody\":true,\"internationalFlts\":true,\"domesticFlts\":true,\"alertCountsReq\":false,\"transactionId\":\"UNKNOWN-0.0.00000_00789696_DFW_1517406950252_201\"}";
				ATUReports.add("****************Request for flights for given time "+request+"  ********",  LogAs.INFO, null);
				ATUReports.add("****************Request for Consolidated crew report "+request2+"  ********",  LogAs.INFO, null);
				System.out.println(" ");
				System.out.println(Stations[i]);
				String stationname = Stations[i];
				String Alerting = correction.getAlertingstation(url, request, urlCache, request2, stationname);
				
				if(Alerting.contains("Null")){
					System.out.println("Station **"+stationname+"***  Do not have the crew alerts and proceeding with validation with **"+stationname+"** Station");
					CustomZone.SelectStation(stationname);
					consolidatedcrewreport.Checkconsolidatedcrewicon();
					consolidatedcrewreport.NoCrewdetailsReportmessage();
					break;
				}
				else{
					//CustomZone.SelectStation(stationname);
					//consolidatedcrewreport.Checkconsolidatedcrewicon();
					//break;
				}
				
				}
			}	
			
	
	
	
	

	
		
@Test(priority = 11)
public void TC_420_lastsortsave() throws Exception {

	consolidatedcrewreport.Savesortsession();

}	
	
	
@Test(priority = 12)
public void TC_421_CheckSlidersessionsaved() throws Exception {
	consolidatedcrewreport.CheckSliderexist();
	consolidatedcrewreport.Slidersessionsaved();

}	
	
}
	











