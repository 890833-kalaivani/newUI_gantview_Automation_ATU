package get.next.gen.webtestcase;

import get.next.gen.commonaction.CommonTest;
import get.next.gen.utilities.DashboardFilterOptionValidation;
import get.next.gen.utilities.EventDetailsValidation;
import get.next.gen.utilities.GanntViewHeaderFunctionality;
import get.next.gen.utilities.GanttviewPuckOptions;
import get.next.gen.utilities.Hybridview;



import get.next.gen.utilities.PuckColorValidation;

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



public class Requirement_EventdetailsPage extends CommonTest {


@Test(priority = 0)
public void T01_LoginTestcase() throws Exception {
//	GanntViewHeaderFunctionality.Login();
	GanntViewHeaderFunctionality.GanntViewSelection();
		}


	@Test(priority = 1)
	public void GETNG_TC_GANTT_000122_VerifyEventdetailsPage() throws Exception {
	
		EventDetailsValidation.EventAlertDetailsPopupselection();
			}

	@Test(priority = 2)
	public void GETNG_TC_GANTT_000122_VerifySlideoutdatadisplayed() throws Exception {
	
		EventDetailsValidation.CheckContentsinSlideOut();
			}

	

	@Test(priority = 3)
	public void GETNG_TC_GANTT_000123_VerifyOffloadReport() throws Exception {
	
		EventDetailsValidation.Selectapucktovieweventdetails();
		EventDetailsValidation.Checkreportvalueupdating("OFFLOAD");
		EventDetailsValidation.Selectreport("OFFLOAD");
		
			}
	
	
	@Test(priority = 4)
	public void GETNG_TC_GANTT_000124_VerifyClaimscanReport() throws Exception {
	
		EventDetailsValidation.Selectapucktovieweventdetails();
		EventDetailsValidation.Checkreportvalueupdating("CLAIMSCAN");
		EventDetailsValidation.Selectreport("CLAIMSCAN");
			}
	
	
	@Test(priority = 5)
	public void GETNG_TC_GANTT_000125_VerifyPaxReport() throws Exception {
	
		EventDetailsValidation.Selectapucktovieweventdetails();
		EventDetailsValidation.Checkreportvalueupdating("PAX");
		EventDetailsValidation.Selectreport("PAX");
			}
	
	
	@Test(priority = 6)
	public void GETNG_TC_GANTT_000126_VerifyBagsReport() throws Exception {
	
		EventDetailsValidation.Selectapucktovieweventdetails();
		EventDetailsValidation.Checkreportvalueupdating("BAGS");
		EventDetailsValidation.Selectreport("BAGS");
			}
	
	
	@Test(priority = 7)
	public void GETNG_TC_GANTT_000127_VerifyCabinReport() throws Exception {
	
		EventDetailsValidation.Selectapucktovieweventdetails();
		EventDetailsValidation.Checkreportvalueupdating("CABIN");
		EventDetailsValidation.Selectreport("CABIN");
			}
	
	
	@Test(priority = 8)
	public void GETNG_TC_GANTT_000127_VerifyCrewReport() throws Exception {
	
		EventDetailsValidation.Selectapucktovieweventdetails();
		EventDetailsValidation.Checkreportvalueupdating("CREW");
		EventDetailsValidation.Selectreport("CREW");
			}
			
		
}