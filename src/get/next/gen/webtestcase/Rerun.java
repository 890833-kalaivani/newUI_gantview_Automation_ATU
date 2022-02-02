package get.next.gen.webtestcase;

import get.next.gen.commonaction.CommonTest;
import get.next.gen.serviceutils.correction;
import get.next.gen.utilities.Alertingflightstatsvalidation;
import get.next.gen.utilities.CustomZone;
import get.next.gen.utilities.DashboardFilterOptionValidation;
import get.next.gen.utilities.EventDetailsValidation;
import get.next.gen.utilities.FlightStatsconfirmation;
import get.next.gen.utilities.GanntViewHeaderFunctionality;
import get.next.gen.utilities.GanttviewPuckOptions;
import get.next.gen.utilities.HoverValidation;
import get.next.gen.utilities.Hybridview;
import get.next.gen.utilities.InternationalDomestic;
import get.next.gen.utilities.Lazyloading;
import get.next.gen.utilities.Multialert;
import get.next.gen.utilities.PuckColorValidation;
import get.next.gen.utilities.PuckUIPlacement;
import get.next.gen.utilities.RampopenClose;
import get.next.gen.utilities.SearchValidation;
import get.next.gen.utilities.SortFunctionalityvalidation;
import get.next.gen.utilities.consolidatedcrewreport;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import atu.testng.reports.ATUReports;
import atu.testng.reports.logging.LogAs;




public class Rerun extends CommonTest {

@Parameters({ "browser", "Environment" })	
@Test(priority = 0)
public void TS01_LoginTestcase(String browser, String Environment) throws Exception {
	Memoryused();
	GanntViewHeaderFunctionality.Login(Environment);
	//DashboardFilterOptionValidation.StatsoptionExist();
	//DashboardFilterOptionValidation.StatsoptionSelection();
	//DashboardFilterOptionValidation.SelectAllStatistics();
	Thread.sleep(1000);
	Memoryused();
		}


@Test(priority = 1)
public void TS147_UNCheckShowETDOutside() throws Exception {
	DashboardFilterOptionValidation.UNCheckShowETDOutside();
	Memoryused();
		}

@Test(priority = 2)
public void TS130_ValidateDayandnightmode() throws Exception {

	DashboardFilterOptionValidation.CheckDaynightenabling();
	Memoryused();
		}


@Test(priority = 3)
public void TS45_CheckHoverDetails() throws Exception {
	
	HoverValidation.HoverDisplayValidation();
	Memoryused();
		}
	
}


	
	

	

	


	

	

	

		
	



		

	
		

		
	
		
	
		

	


	

	
		
		

	
	
	


	
/*	
//	@Test(priority = 5)
//	public void TS_123_VerifyTotalalertStatshaveallalertingflight() throws Exception {
//		
//		Alertingflightstatsvalidation.VerifyTotalHaveallcolor();
//	}
	*/
	





			

			
			


	




	
	
	

	









	

