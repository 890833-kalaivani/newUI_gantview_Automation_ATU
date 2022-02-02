package get.next.gen.webtestcase;

import get.next.gen.commonaction.CommonTest;
import get.next.gen.utilities.GanntViewHeaderFunctionality;
import get.next.gen.utilities.GateChange;
import get.next.gen.utilities.Gatechange_old;
import get.next.gen.utilities.GenerateReport;
import get.next.gen.utilities.Lazyloading;
import get.next.gen.utilities.Multialert;
import get.next.gen.utilities.QuickNotes;
import get.next.gen.utilities.SharedGates;
import get.next.gen.utilities.TeamsMessage;
import get.next.gen.utilities.UpdateETD;
import get.next.gen.utilities.consolidatedcrewreport;
import get.next.gen.utilities.CloseOut;
import get.next.gen.utilities.DashboardFilterOptionValidation;
import get.next.gen.utilities.DiversonReport;
import get.next.gen.utilities.EventDetailsValidation;
import scala.concurrent.forkjoin.ThreadLocalRandom;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import javax.swing.Action;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import atu.testng.reports.ATUReports;
import atu.testng.reports.logging.LogAs;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;




public class RegressionSuite2 extends CommonTest {

	@Parameters({ "browser", "Environment" })	
	@Test(priority = 0)
	public void TS01_LoginTestcase(String browser, String Environment) throws Exception {
		Memoryused();
		System.out.println("url: "+Environment+"");
		GanntViewHeaderFunctionality.Login("https://get.azne.aa.com/GetNG/home");
		//GanntViewHeaderFunctionality.Login(Environment);
		Thread.sleep(1000);
		Memoryused();
	}
	@Test(priority = 1)
	public void TS02_GanttviewSelection() throws Exception {
	//	GanntViewHeaderFunctionality.GanntViewSelection();
		Memoryused();
	}

	
	@Test(priority = 2)
	public void TS03_verifyIfConnectMeIconIsAvailableInLeftSideOFPuckInAlertSection() throws Exception {
		System.out.println("teams msg tc");
		GanntViewHeaderFunctionality.GanntViewSelection();
		System.out.println("Gantt view has been selected");
		//TeamsMessage.verifyDefaultMsgWhenTeamsMsgIsZer();
		Thread.sleep(5000);
		clickByXpath(Web_UI.connectMe,"Connect Me");
		Thread.sleep(5000);
		Actions actions = new Actions(getDriver());
		List<WebElement> entirePuckList = getDriver().findElements(By.xpath(Web_UI.PuckComplete));
		for(WebElement puckDetails:entirePuckList) {
			String terminatedStringInID = puckDetails.getAttribute("id");
			System.out.println(terminatedStringInID);
			WebElement leftpuck = getDriver().findElement(By.xpath("//div[@id='"+terminatedStringInID+"']/puck-lefticons"));
			actions.moveToElement(leftpuck).build().perform();
			Thread.sleep(3000);
			WebElement leftpuckIconClick = getDriver().findElement(By.xpath("//div[@id='"+terminatedStringInID+"']/puck-lefticons/div"));
			actions.clickAndHold(leftpuckIconClick).build().perform();
			Thread.sleep(5000);
			List<WebElement> classattribute = getDriver().findElements(By.xpath("//div[@id='"+terminatedStringInID+"']/puck-lefticons//icons-component//span"));
			System.out.println("size"+classattribute.size());
			for(int i=1;i<=classattribute.size();i++) {
				System.out.println("(//div[@id='"+terminatedStringInID+"']/puck-lefticons//icons-component//span)["+i+"]");
				System.out.println(getDriver().findElement(By.xpath("(//div[@id='"+terminatedStringInID+"']/puck-lefticons//icons-component//span)["+i+"]")).getAttribute("class"));
				System.out.println(i);
			}
		}
		/*System.out.println(classattribute.size());
		classattribute.forEach(action ->
		System.out.println(getDriver().findElement(By.xpath("//div[@id='4189-2021-10-12-TERMINATED']/puck-lefticons//icons-component//span")).getAttribute("class"))

				);	*/	

		//.getAttribute("class");


		//Lazyloading.VerifyStatsCount(Web_UI.Inop,"Inop",Web_UI.InopStatsCount);


		/*Actions actions = new Actions(getDriver());
		WebElement moveelement = getDriver().findElement(By.xpath("(//div[@data-ng-repeat='(key, flt) in ganttObject[gate]']/div[@data-ng-click='getEvents(flt,$event);'])[3]//div[@class='gantt-multi-icn  gantt-left-puck-icns ng-scope']"));
		actions.moveToElement(moveelement).build().perform();
		actions.moveToElement(moveelement).build().perform();
		Thread.sleep(2000);
		Boolean Hoverpopup = getDriver().findElement(By.xpath("(//div[@data-ng-repeat='(key, flt) in ganttObject[gate]']/div[@data-ng-click='getEvents(flt,$event);'])[3]//div[@class='gantt-multi-icn  gantt-left-puck-icns ng-scope']/div[2]")).isDisplayed();
		if(Hoverpopup==true){
			System.out.println("Multialert Hover displayed upon hovering for the puck id "); 
			String s1 = getDriver().findElement(By.xpath("(//div[@data-ng-repeat='(key, flt) in ganttObject[gate]']/div[@data-ng-click='getEvents(flt,$event);'])[3]//div[@class='gantt-multi-icn  gantt-left-puck-icns ng-scope']/div[2]")).getAttribute("textContent");
			System.out.println(s1);
		}else{
			System.out.println("Multialert Hover popup not displayed upon hovering for the puck id  "); 
		}*/
		//	Memoryused();
	}

	@Test(enabled=false)
	public  void verifyTeamMessageContentOfPuckWithEventSlideOut()throws Exception{
		Thread.sleep(5000);
		/*List<WebElement> totalPuck = getDriver().findElements(By.xpath(Web_UI.PuckComplete));
		aa:*/
		//	for(int i=1;i<=totalPuck.size();i++) {
		//WebElement puckNavigation = getDriver().findElement(By.xpath("(//div[@data-ng-repeat='(key, flt) in ganttObject[gate]']/div[@data-ng-click='getEvents(flt,$event);'])["+i+"]/puck-lefticons"));
		//if(puckNavigation.isDisplayed()) {
		GanntViewHeaderFunctionality.GanntViewSelection();
		System.out.println("Gantt view has been selected");
		Thread.sleep(5000);
		clickByXpath("//li[@title='MEL']", "mel");
		Thread.sleep(5000);
		Actions actions = new Actions(getDriver());
		WebElement leftpuck = getDriver().findElement(By.xpath("//div[@id='0442-2021-10-18-UNLINKED']/puck-lefticons/div"));
		actions.moveToElement(leftpuck).build().perform();
		Thread.sleep(3000);
		actions.clickAndHold(leftpuck).build().perform();
		Thread.sleep(3000);
		actions.click(leftpuck).build().perform();
		Thread.sleep(3000);
		//actions.click(leftpuck).build().perform();
		List<WebElement> popoverList = getDriver().findElements(By.xpath("//div[@id='0442-2021-10-18-UNLINKED']/puck-lefticons//notification-component//div[@class='scrtabs-tabs-fixed-container']//li"));
		for(int i=1;i<=3;i++) {
			System.out.println("title value is : "+getDriver().findElement(By.xpath("(//div[@id='0442-2021-10-18-UNLINKED']/puck-lefticons//notification-component//div[@class='scrtabs-tabs-fixed-container']//li)[2]//img")).getAttribute("title"));
			Thread.sleep(3000);

		}
		actions.click(getDriver().findElement(By.xpath("(//div[@id='0442-2021-10-18-UNLINKED']/puck-lefticons//notification-component//div[@class='scrtabs-tabs-fixed-container']//li)[2]"))).build().perform();
		Thread.sleep(3000);
		//break aa;
		//	WebElement leftpuckIconClick = getDriver().findElement(By.xpath("//div[@id='2812-2021-10-13-ORIGINATED']/puck-lefticons/div"));
		//	}

		//	}


	}

	/*

	@Parameters({ "browser", "Environment" })	
	@Test(priority = 0)
	public void TS01_LoginTestcase(String browser, String Environment) throws Exception {		
		Memoryused();
		System.out.println("url: "+Environment+"");
		GanntViewHeaderFunctionality.loginOtherThanGetNG(Environment);

		if(DiversonReport.divReport_IsDisplayed()==true) {
			System.out.println("Entered if ");
			DiversonReport.divReport_createAdhocEvent();
			DiversonReport.divReport_createUpdateETD();
			DiversonReport.divReport_EnteringNotes();
			DiversonReport.divReport_generateReport();
		}

		//DiversonReport.loginOtherThanGetNG(Environment);
		//DiversonReport.createAdhocEvent();

		//DiversonReport.divReport_wideBodyIconVerification();
		//DashboardFilterOptionValidation.StatsoptionExist();
		//DashboardFilterOptionValidation.StatsoptionSelection();
		//DashboardFilterOptionValidation.SelectAllStatistics();
		//Thread.sleep(1000);
		//DiversonReport.iconClick();
		//GanntViewHeaderFunctionality.GanntViewSelection();
		Thread.sleep(1000);
		//DiversonReport.divReport_IsDisplayed();
		//DiversonReport.divReport_EnteringNotes();
		//DiversonReport.petDisabledForOffStatusFlights();

		Memoryused();
	}

	@Test(priority = 0)
	public static void TS68_VerifyGanttviewHeader_GateSwaps() throws Exception {
		//CloseOut.shouldshowcloseoutonly();
		//GanntViewHeaderFunctionality.GateSwapsCheck("Ganttview");
	}
	@Test(priority = 1)
	public static void updateGateChangeIconDisplaye() throws Exception {
		//QuickNotes.rightClickPuck("BAGS");
		//GenerateReport.clickPuckForEventSlideOut();
		//GenerateReport.enteringFlightAndTailNotes();
		//GenerateReport.switchingToGenerateReportFrame();
		//GenerateReport.printButton();
		//SharedGates.scroll();
		//UpdateETD.updateETD_NA_ForTermFlights();
		//UpdateETD.verifyETDPost("advisoryPost");
		//UpdateETD.verifyETDPost("requestToPost");
		//UpdateETD.verifyErrMsg("errorMsgValidation");
		//GateChange.verifyUpdateGateIcon();
	}
	@Test(priority = 2)
	public static void verifyETDRequestToPost() throws Exception {

		//UpdateETD.verifyETDPost("requestToPost");
	}
	@Test(priority = 3)
	public static void verifyErrMSgINUpdateETDScreen() throws Exception {
		//UpdateETD.verifyErrMsg("errorMsgValidation");
	}

	@Test(priority = 4)
	public static void TS101_VerifyPaxReport() throws Exception {
		EventDetailsValidation.Selectapucktovieweventdetails();
		EventDetailsValidation.Checkreportvalueupdating("PAX");
		EventDetailsValidation.Selectreport("PAX");
	}
	@Test(priority = 250)
	public void TS200_VerifyLogout() throws Exception {

		//CommonTest.Logout();
		//Memoryused();

	}

	 */

	@AfterMethod
	public static void getStatus(ITestResult result) {

		//System.out.println("Method Status : "+ result.getStatus() + " : Method Name :"+ result.getMethod().getMethodName());
		HashMap<String,Integer> testResultStatusUpdates = new HashMap<String,Integer>();
		testResultStatusUpdates.put(result.getMethod().getMethodName(), result.getStatus());

		System.out.println(testResultStatusUpdates.entrySet());

	}

}
