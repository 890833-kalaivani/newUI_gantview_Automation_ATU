package get.next.gen.webtestcase;

import get.next.gen.commonaction.CommonTest;
import get.next.gen.serviceutils.correction;
import get.next.gen.serviceutils.Alerts;
import get.next.gen.utilities.Alertingflightstatsvalidation;
import get.next.gen.utilities.CustomZone;
import get.next.gen.utilities.DashboardFilterOptionValidation;
import get.next.gen.utilities.EventDetailsValidation;
import get.next.gen.utilities.FlightStatsconfirmation;
import get.next.gen.utilities.GanntViewHeaderFunctionality;
import get.next.gen.utilities.GanttviewPuckOptions;
import get.next.gen.utilities.HoverValidation;
import get.next.gen.utilities.Hybridview;




import get.next.gen.utilities.PuckColorValidation;
import get.next.gen.utilities.PuckUIPlacement;
import get.next.gen.utilities.RampopenClose;
import get.next.gen.utilities.SearchValidation;
import get.next.gen.utilities.SortFunctionalityvalidation;

import java.io.IOException;
import java.util.List;














import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;



public class testservicescript extends CommonTest {
	
	@Test(priority = 9)
	 public void T09_StageVSProd() throws Exception{
		
		//Compare Stage and Prod responses
		
//		String url="http://apapnp95.tul.aa.com:8080/GetFlightCache/flight/getFlightsForGivenTime";
//		String url_cache="http://apapns44.pdc.aa.com:8080/GetFlightCache/flight/getFlightsForGivenTime";
//		String strStartTime="05:05:41";
//		String strEndTime="06:12:41";
//		
//		String Stations[] = {"PHL","DFW","ORD","MIA","STL","CLT"};
//		for( int i = 0; i < Stations.length; i++)
//		{	
//			String sta = Stations[i];
//			System.out.println(sta);
//			 correction.VerifyProdvsStage(url,url_cache,sta,strStartTime,strEndTime);
//	 
//		}
	}
	
	
	
	@Test(priority = 8)
	 public void T10_BeforeandAfterRestart() throws Exception{
		
		//validate response captured locally before and after restart
		String url="http://apapnp95.tul.aa.com:8080/GetFlightCache/flight/getFlightsForGivenTime";
		String url_cache="http://apapns44.pdc.aa.com:8080/GetFlightCache/flight/getFlightsForGivenTime";
		String strStartTime="00:01:41";
		String strEndTime="00:30:41";
		
		String Stations[] = {"PHL"};
		for( int i = 0; i < Stations.length; i++)
		{	
			String sta = Stations[i];
			System.out.println(sta);
			 correction.Verifybeforeandafter(url,url_cache,sta,strStartTime,strEndTime);
	 
		}
		
	}
}