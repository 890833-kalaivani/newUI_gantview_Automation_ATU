package get.next.gen.webtestcase;

import get.next.gen.commonaction.CommonTest;
import get.next.gen.serviceutils.correction;
import get.next.gen.utilities.GanntViewHeaderFunctionality;
import get.next.gen.utilities.GanttviewPuckOptions;
import get.next.gen.utilities.Hybridview;












import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;









import java.util.Locale;
import java.util.TimeZone;

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
import com.relevantcodes.extentreports.model.Log;



public class ServiceScript_CrewandEOBT extends CommonTest {

	
@Test(priority = 0)
public void T01_checkcrewalerthappeningproperly() throws Exception {
	
		int loopcount = 2;
	
	for( int looper = 0; looper <loopcount; looper++)
	{
		ATUReports.add("****************LOOP "+looper+"  ********",  LogAs.INFO, null);
		System.out.println("****************LOOP "+looper+"  ********");
		
		String url="http://apapnp75.tul.aa.com:8080/GetNGServices/flight/getFlightsWithPuckSplit";
			
	//String url="http://apapns43.pdc.aa.com:8080/GetNGServices/flight/getFlightsForGivenTime";
	String urlCache="http://apapns45.pdc.aa.com:8081/GetCrewCache/crew/getCrewAlertReport";
	String Stations[] = {"DFW","PHL","CLT","LAX","LGA","PIT","RDU","MIA","PHX","SFO","ORD","BOS","CHO","JFK","PHL","STL"};
	//String Stations[] = {"DFW","PHL","CLT","LAX"};
//	String Stations[] = {"DFW"};
	//String Stations[] = {"CLT"};
	//String strStartTime2 = "2018-03-12T00:02:12.292Z";
	//String strEndTime2 = "2018-03-12T22:23:12.292Z";
	
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
	
	correction.Crewstart(url,request,urlCache,request2);
	
	}
	}
	
}
/*
	@Test(priority = 1)
	public void GETNG_TC_EOBTServicevalidation() throws Exception {


		
		//	String url="http://10.245.15.40:8080/GetNGServices/flight/getFlightsForGivenTime";
		//	String url_cache="http://10.245.15.40:8080/GetNGServices/flight/getFlightsForGivenTime";	
			
			String url="http://apapns43.pdc.aa.com:8080/GetNGServices/flight/getFlightsWithPuckSplit";
			String url_cache="http://apapns43.pdc.aa.com:8080/GetNGServices/flight/getFlightsWithPuckSplit";	
	
			//String strStartTime="01:20:34";
			//String strEndTime="23:20:34";
			
			
			
			String Stations[] ={"DFW","PHL","LAX","CLT","PHX","RDU","ORD","MIA"}; 
		
			
			//String Stations[] ={"DFW"}; 
				
			for( int i = 0; i < Stations.length; i++)
			{	
				String sta = Stations[i];
				String timzoneids = correction.gettimezone(sta);
				System.out.println(sta);
				String strStartTime= correction.getStarttime("America/Chicago",40);
				String strEndTime=correction.nexthrs("America/Chicago",1);
				String halfnhourincrementedstationtime =  correction.gettime(timzoneids);
				String nowdate = correction.getdate(timzoneids);
				String previousday = correction.getpreviousdate(timzoneids);
				correction.startEOBTValidation(url,url_cache,sta,strStartTime,strEndTime,halfnhourincrementedstationtime,nowdate,previousday);
		 
			}	
	
			
		
			}
*/

}