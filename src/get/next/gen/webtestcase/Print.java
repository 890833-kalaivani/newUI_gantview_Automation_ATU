package get.next.gen.webtestcase;

import get.next.gen.commonaction.CommonTest;
import get.next.gen.serviceutils.correction;
import get.next.gen.utilities.Alertingflightstatsvalidation;
import get.next.gen.utilities.CustomZone;
import get.next.gen.utilities.GanntViewHeaderFunctionality;
import get.next.gen.utilities.GanttviewPuckOptions;
import get.next.gen.utilities.Hybridview;



import get.next.gen.utilities.RampopenClose;
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
import org.testng.annotations.Test;

import atu.testng.reports.ATUReports;
import atu.testng.reports.logging.LogAs;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;



public class Print extends CommonTest {


@Test(priority = 0)
public void T01_LoginTestcase() throws Exception {
	
	System.out.println("Memory of chrome at intial stage...");
	ATUReports.add("Memory of chrome at intial stage...", LogAs.PASSED, null); 
	Memoryused();
	//GanntViewHeaderFunctionality.Login();
	//Thread.sleep(300000);
			}

/*
@Test(priority = 1)
public void T1000_Memoryusage() throws Exception {
	ArrayList<Long> Memoryvalues = new ArrayList<Long>();	
	ArrayList<Long> Memoryvalues1 = new ArrayList<Long>();
	for(int lp =0;lp<=53;lp++){
	System.out.println(">>......  "+lp);	
	ATUReports.add(">>......  "+lp, LogAs.PASSED, null); 
		try{
			//Wait 5 minutes
	Thread.sleep(300000);
	System.out.println(">>......");
	ATUReports.add(">>......", LogAs.PASSED, null); 
	Long mem = Memoryused();
	Memoryvalues.add(mem);
	GanntViewHeaderFunctionality.Selectview("Ganntview");
	
	//Wait 5 minutes
	Thread.sleep(300000);
	System.out.println(">>...");
	ATUReports.add(">>......", LogAs.PASSED, null); 
	Long mem2 = Memoryused();
	Memoryvalues.add(mem2);
	GanntViewHeaderFunctionality.Selectview("Hybridview");
		
	
	launchApp(Web_UI.Url);
		Thread.sleep(5000);
		for(int lp1 =0;lp1<=19;lp1++){
				System.out.println(">>......  "+lp);	
				ATUReports.add(">>......  "+lp, LogAs.PASSED, null); 
			
					//Wait 5 minutes
			Thread.sleep(300000);
			System.out.println(">>......");
			ATUReports.add(">>......", LogAs.PASSED, null); 
			Long mem3 = Memoryused();
			Memoryvalues.add(mem2);
			GanntViewHeaderFunctionality.Selectview("Ganntview");
			
			//Wait 5 minutes
			Thread.sleep(300000);
			System.out.println(">>...");
			ATUReports.add(">>......", LogAs.PASSED, null); 
			Long mem4 = Memoryused();
			Memoryvalues.add(mem2);
			GanntViewHeaderFunctionality.Selectview("Hybridview");
				}
		}
				catch(Exception ed){
				
			}
	}
	ATUReports.add(Memoryvalues.toString(), LogAs.PASSED, null); 
	Exportmemoryvalue(Memoryvalues);
}


	*/


@Test(priority = 146)
public void TC_421_CheckSlidersessionsaved() throws Exception {
	consolidatedcrewreport.CheckSliderexist();
	consolidatedcrewreport.Slidersessionsaved();
	Memoryused();
}

}






