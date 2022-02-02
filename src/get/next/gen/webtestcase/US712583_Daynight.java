package get.next.gen.webtestcase;

import get.next.gen.commonaction.CommonTest;
import get.next.gen.utilities.DashboardFilterOptionValidation;
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



public class US712583_Daynight extends CommonTest {

	

@Test(priority = 0)
public void T01_LoginTestcase() throws Exception {
	//GanntViewHeaderFunctionality.Login();
		}


	@Test(priority = 1)
	public void T321_ValidateDayandnightmode() throws Exception {

		DashboardFilterOptionValidation.CheckDaynightenabling();
			}

	@Test(priority = 3)
	public void T323_CheckDashboardrenamed() throws Exception {

		DashboardFilterOptionValidation.CheckDashboardrenamed();
		
			}

	
	
	
	
}