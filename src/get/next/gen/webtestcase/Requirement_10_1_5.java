package get.next.gen.webtestcase;

import get.next.gen.commonaction.CommonTest;
import get.next.gen.utilities.GanntViewHeaderFunctionality;
import get.next.gen.utilities.GanttviewPuckOptions;
import get.next.gen.utilities.Hybridview;


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



public class Requirement_10_1_5 extends CommonTest {



	
@Test(priority = 0)
public void T01_LoginTestcase() throws Exception {
	//GanntViewHeaderFunctionality.Login();
		}


@Test(priority = 1)
public void GETNG_TC_GANTT_500_VerifySortArrivaltimebyAscendingorder() throws Exception {

	SortFunctionalityvalidation.SortDescendingbyarrivalstatus();
	
}

@Test(priority = 2)
public void GETNG_TC_GANTT_026_VerifySortArrivaltimebyDescendingorder() throws Exception {
	SortFunctionalityvalidation.SortDescendingbyarrivalstatus();
	}




/*

	@Test(priority = 1)
	public void GETNG_TC_GANTT_025_VerifySortGatebyAscendingorder() throws Exception {

		SortFunctionalityvalidation.SortGateAscending();
		
	}

	@Test(priority = 2)
	public void GETNG_TC_GANTT_026_VerifySortGatebyDescendingorder() throws Exception {
		SortFunctionalityvalidation.SortGateDescending();
		}
	*/
}