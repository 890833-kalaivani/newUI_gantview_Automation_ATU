package get.next.gen.webtestcase;

import get.next.gen.commonaction.CommonTest;
import get.next.gen.utilities.Alertingflightstatsvalidation;
import get.next.gen.utilities.GanntViewHeaderFunctionality;
import get.next.gen.utilities.GanttviewPuckOptions;
import get.next.gen.utilities.Hybridview;



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



public class Requirement_1_4 extends CommonTest {


@Test(priority = 0)
public void T01_LoginTestcase() throws Exception {
//	GanntViewHeaderFunctionality.Login();
	GanntViewHeaderFunctionality.GanntViewSelection();

		}

@Test(priority = 1)
public void GETNG_TC_GANTT_138_VerifyMultipleAlerticonspresent() throws Exception {
	
	Alertingflightstatsvalidation.VerifyMultipleAlertsicons("Ganttview");
}
	/*

	@Test(priority = 1)
	public void GETNG_TC_GANTT_033_VerifyAlertingflightstatistics() throws Exception {
		
		Alertingflightstatsvalidation.VerifyAlertstatspresent();
	}
	
	
	
	@Test(priority = 2)
	public void GETNG_TC_GANTT_125_VerifyMessageforblockedwhennoflights() throws Exception {
		
		Alertingflightstatsvalidation.VerifyMessagewhennoflightsforBlocked();
		
	}
	
	
	@Test(priority = 3)
	public void GETNG_TC_GANTT_126_VerifyMessageforYellowwhennoflights() throws Exception {
		
		Alertingflightstatsvalidation.VerifyMessagewhennoflightsforYellow();
	}
	
	
	@Test(priority = 4)
	public void GETNG_TC_GANTT_127_VerifyMessageforTotalwhennoflights() throws Exception {
		
		Alertingflightstatsvalidation.VerifyMessagewhennoflightsforTotal();
	}
	
	
	@Test(priority = 5)
	public void GETNG_TC_GANTT_127_VerifyMessageforRedwhennoflights() throws Exception {
		
		Alertingflightstatsvalidation.VerifyMessagewhennoflightsforRED();
	}
	
	*/
	@Test(priority = 6)
	public void GETNG_TC_GANTT_120_VerifyBlockedflightstatsdisplaysMarooncolorPuck() throws Exception {
		
		Alertingflightstatsvalidation.VerifyBlockedhaveMaroonColor("Ganttview");
	}
	
	@Test(priority = 7)
	public void GETNG_TC_GANTT_121_VerifyYellowstatsflightshaveYellowcolorPuck() throws Exception {
		
		Alertingflightstatsvalidation.VerifyYellowStatshaveyellowcolor("Ganttview");
	}
	
	@Test(priority = 8)
	public void GETNG_TC_GANTT_122_VerifyRedStatsflighthaveRedColorPuck() throws Exception {
		
		Alertingflightstatsvalidation.VerifyRedStatshaveRedcolor("Ganttview");
	}
/*	
//	@Test(priority = 5)
//	public void GETNG_TC_GANTT_123_VerifyTotalalertStatshaveallalertingflight() throws Exception {
//		
//		Alertingflightstatsvalidation.VerifyTotalHaveallcolor();
//	}
	*/
	
	
	
}