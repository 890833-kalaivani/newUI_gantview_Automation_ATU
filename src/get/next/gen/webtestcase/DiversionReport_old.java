package get.next.gen.webtestcase;

import get.next.gen.commonaction.CommonTest;
import get.next.gen.serviceutils.correction;
import get.next.gen.utilities.Alertingflightstatsvalidation;
import get.next.gen.utilities.CloseOut;
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
import get.next.gen.utilities.PuckColorValidation;
import get.next.gen.utilities.PuckUIPlacement;
import get.next.gen.utilities.RampopenClose;
import get.next.gen.utilities.ResetSettings;
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
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import atu.testng.reports.ATUReports;
import atu.testng.reports.logging.LogAs;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;



public class DiversionReport_old extends CommonTest{

	@Parameters({ "browser", "Environment" })	

	//@Test(enabled = false)
	@Test(priority = 0)
	private static void diversionReportIconEnabled(String browser, String Environment) throws Exception{
		TestcaseInit();
		GanntViewHeaderFunctionality.Login(Environment);
		CommonTest.SpinnerControl();
		WebElement dvrTrckerIcon = getDriver().findElement(By.xpath("//li[@title='Diversion report']/a[@class='dropdown-toggle evt-notify-header']"));
		if(dvrTrckerIcon.isDisplayed()) {
			ATUReports.add("User is Resetted to Day Mode  " ,  LogAs.PASSED, null);
			//clickByXpath(Web_UI.dvrTrckerIcon,"DashboardfilterCancel");
			dvrTrckerIcon.click();
		}else {
			ATUReports.add("User is Resetted to Day Mode  " ,  LogAs.FAILED, null);
		}
		dvrTrckerIcon.click();
		//getDriver().switchTo().frame(getDriver().findElement(By.className("diversion-report")));
		if(getDriver().findElement(By.className("//div[@class='mat-card-header-text']//img")).getAttribute("innerText").equals("DiversionReport")) {
			ATUReports.add("Diversion report pop up is displayed" ,  LogAs.PASSED, null);
		}else {
			ATUReports.add("Diversion report pop up is not displayed" ,  LogAs.FAILED, null);
		}
		}
	@Test(priority = 1)
	public static void totalFlightCount(String browser, String Environment) throws Exception {
		int i=0;
		System.out.println("tc02");
		//getting count of total flights under Diverted stations
		int divertedStaFltCount_DR = getDriver().findElements(By.xpath("//div[@class='arr-hdn ng-star-inserted']")).size();
		if(divertedStaFltCount_DR>0) {
			for(int j=0;j<=divertedStaFltCount_DR;j++) {
				String divertedStastats = "(//div[@class='stn-blck ng-star-inserted']/div[@class='arr-cnt-block ng-star-inserted']/span)["+(j+1)+"]";
				int attribute = Integer.parseInt(getDriver().findElement(By.xpath(divertedStastats)).getAttribute("innertext"));
				i=i+attribute;
			}
			//total flight count within the circle 
			int k = Integer.parseInt(getDriver().findElement(By.xpath("//div[@class='total-flights-bg']/div")).getAttribute("innertext"));
                  if(i==k) {
                	  System.out.println("Total diverted flight equals the total flight count");  
                  }else {
                	  System.out.println("Total diverted flight not equals the total flight count");
                  }
		}


	}
}


