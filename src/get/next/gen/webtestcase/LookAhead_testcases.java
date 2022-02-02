package get.next.gen.webtestcase;

import java.util.Date;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.relevantcodes.extentreports.NetworkMode;

import get.next.gen.commonaction.CommonTest;
import get.next.gen.utilities.LookAhead;
import groovyjarjarasm.asm.commons.Method;

public class LookAhead_testcases extends CommonTest {
	/*public static ExtentReports extent;
	public static ExtentTest test;*/
	@Parameters({ "browser", "Environment" })	
	
	/*
	@BeforeSuite
	public void beforeSuite() throws Exception {
		String reportDir = "output";
		String OFFLINE ="OFFLINE";
		extent = new ExtentReports(reportDir+"//Report.html",true,NetworkMode.OFFLINE);
	}

	@BeforeMethod
	public void beforeMethod(Method method) throws Exception {
		test = extent.startTest((this.getClass().getSimpleName()+"::"+method.getName()),method.getName());
		test.assignCategory("Service Testing");
	}

	@AfterMethod
	public void afterMethod(ITestResult result) throws Exception {
		if(result.getStatus()==ITestResult.FAILURE)
		{
			Throwable Faile =  result.getThrowable();
			String Failedd = Faile.toString();
			test.log(LogStatus.FAIL,"Fail");
		}
	}

	@AfterSuite
	public static void afterSuite() throws Exception { 
		Thread.sleep(5000);
		extent.flush();
		Thread.sleep(10000);
		Date date = new Date();
		String ExecutionDate1 = date.toString().substring(0, 16).trim();
		String ExecutionDate = ExecutionDate1.replace(":", "").trim();
	}*/
	@Test(priority = 0)
	public static void TS01_LoginTestcase(String browser, String Environment) throws Exception {
		CommonTest.loginOtherThanGetNG(Environment);
		Thread.sleep(10000);
		LookAhead.retrieveingDataFromLookAhead();
			
	}

}
