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



public class IndividualTestRun extends CommonTest{

	@Parameters({ "browser", "Environment" })	


	@Test(priority = 0)
	public static void Check(String browser, String Environment) throws Exception {
		TestcaseInit();
		GanntViewHeaderFunctionality.Login(Environment);
		GanntViewHeaderFunctionality.GanntViewSelection();
		Thread.sleep(4000);
		CommonTest.SpinnerControl();
		CommonTest.zoomindata();
		CommonTest.zoomindata();
		Thread.sleep(4000);
		clickByXpath(Web_UI.SortAscending,"SortAscending");
		Thread.sleep(1000);
		// Select Sort Ascending gate by alphabetical order from dropdown
		clickByXpath(Web_UI.SortAscendinggate,"SortAscendinggate");
		Thread.sleep(5000);
		
		Thread.sleep(5000);
		Actions actions = new Actions(getDriver());
		for(int moveloop = 0;moveloop<=15;)
		{
			CommonTest.SpinnerControl();
			try{
				List<WebElement> Ganntlist = getDriver().findElements(By.xpath(Web_UI.PuckComplete));
				for (WebElement gantelement : Ganntlist) {
					try{
						String puckid = gantelement.getAttribute("id");
						WebElement statelement = getDriver().findElement(By.xpath("//div[@data-ng-repeat='(key, flt) in ganttObject[gate]']/div[@id='"+puckid+"']/div[contains(@class,'puck-contnt')]/div[2]/span[2]"));
						String statusdet =statelement.getAttribute("innerText");
						
						if(statusdet.equals("TERM") || statusdet.equals("UNL"))
						{
							//clicking lock sysmbol
							getDriver().findElement(By.xpath("//span[@class='lock-icn ng-scope']")).click();						
//							WebElement getGateID = getDriver().findElement(By.xpath("//div[@data-ng-repeat='(key, flt) in ganttObject[gate]']/div[@id='"+puckid+"']/parent::div/parent::div/parent::div/parent::div"));
							//WebElement getGateID = getDriver().findElement(By.xpath("//div[@data-ng-repeat='(key, flt) in ganttObject[gate]']/div[@id='"+puckid+"']/parent::div/following-sibling::div);
							//String gateID = getGateID.getAttribute("id");
							try {

								WebElement moveElement = getDriver().findElement(By.xpath("//div[@data-ng-repeat='(key, flt) in ganttObject[gate]']/div[@id='"+puckid+"']/parent::div/parent::div/parent::div/parent::div/parent::div/following-sibling::div"));
								 Point point = moveElement.getLocation();
								 int xcord = point.getX();
								 int ycord = point.getY();
								 actions.dragAndDropBy(statelement, xcord, ycord);
								 ATUReports.add("GateChange not displayed for"+statusdet,  LogAs.FAILED, null);
							}
							catch(Exception e){
								ATUReports.add("GateChange not displayed for"+statusdet,  LogAs.PASSED, null);
							}
						}
						else
						{
							String getstat = getDriver().findElement(By.xpath("//div[@data-ng-repeat='(key, flt) in ganttObject[gate]']/div[@id='"+puckid+"']/div[contains(@class,'puck-contnt')]/div[3]/span[2]/span[1]")).getAttribute("innerText");
							
							WebElement getGateID = getDriver().findElement(By.xpath("//div[@data-ng-repeat='(key, flt) in ganttObject[gate]']/div[@id='"+puckid+"']/parent::div/parent::div/parent::div/parent::div"));
							String gateID = getGateID.getAttribute("id");
							if(getstat.contains("ON") || getstat.contains("OFF") || getstat.contains("CXL") )
							{
								try {

									WebElement moveElement = getDriver().findElement(By.xpath("//div[@id='"+gateID+"']/parent::div/following-sibling::div"));
									actions.moveToElement(moveElement);
								}
								catch(Exception e){
									ATUReports.add("GateChange not available for"+statusdet +"Status flights",  LogAs.PASSED, null);
								}


							}
						}


					}catch(Exception id)
					{
					}
				}
				try{
					WebElement scrollview = getDriver().findElement(By.xpath(Web_UI.Scrollbar));
					scrollview.click(); 
					actions.sendKeys(Keys.PAGE_DOWN).build().perform();
					Thread.sleep(2000);
					WebElement scrollviewhightcheck = getDriver().findElement(By.xpath(Web_UI.Scrollbarheight));
					//Do One review here
					String styleheight =scrollviewhightcheck.getCssValue("min-height");
					if(styleheight.equalsIgnoreCase("0px")){
						break;
					}
				}catch(Exception er){
					ATUReports.add( " **********Scroll Not Happening*********",  LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				} 

				Thread.sleep(3000);
			}catch(Exception pagenotconsistent)
			{
				Thread.sleep(2000);
				CommonTest.SpinnerControl();
				ATUReports.add( "  Gantt list is Empty ",  LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				//moveloop++;
			}
			moveloop++;
		}

	}

}


