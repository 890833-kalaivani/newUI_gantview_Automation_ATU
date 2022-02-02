package get.next.gen.webtestcase;

import get.next.gen.commonaction.CommonTest;
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



public class Report extends CommonTest {
	
	
@Test(priority = 0)
public void T01_LoginTestcase() throws Exception {
	//GanntViewHeaderFunctionality.Login();
		}

@Test(priority = 1)
public void T0331_CheckShowETDOutside() throws Exception {
	DashboardFilterOptionValidation.CheckShowETDoutside();
		}

@Test(priority = 2)
public void T0332_DrawtoActualGT() throws Exception {
	DashboardFilterOptionValidation.DrawtoActualGT();
		}

}