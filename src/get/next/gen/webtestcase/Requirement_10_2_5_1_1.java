package get.next.gen.webtestcase;

import get.next.gen.commonaction.CommonTest;
import get.next.gen.utilities.Alertingflightstatsvalidation;
import get.next.gen.utilities.GanntViewHeaderFunctionality;
import get.next.gen.utilities.GanttviewPuckOptions;
import get.next.gen.utilities.HoverValidation;
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



public class Requirement_10_2_5_1_1 extends CommonTest {


@Test(priority = 0)
public void T01_LoginTestcase() throws Exception {
	//GanntViewHeaderFunctionality.Login();
	GanntViewHeaderFunctionality.GanntViewSelection();
		}

@Test(priority = 1)
public void GETNG_TC_GANTT_147_CheckHoverDetails() throws Exception {
	
	HoverValidation.HoverDisplayValidation();
		}
	
}