package get.next.gen.utilities;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import atu.testng.reports.ATUReports;
import atu.testng.reports.logging.LogAs;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;
import get.next.gen.commonaction.CommonTest;
import get.next.gen.webtestcase.Web_UI;

public class TeamsMessage  extends CommonTest{

	public static void verifyTeamsMsgChkBoxDisabledByDefault() throws Exception {
		try {
			//performing reset so that all settings are updated to default
			clickByXpath(Web_UI.filtericon, "Settings Icon ");
			Thread.sleep(1000);
			clickByXpath(Web_UI.Resetbutton, "Reset button ");
			Thread.sleep(1000);
			clickByXpath(Web_UI.ResetAcceptbutton, "Accept Button ");
			Thread.sleep(15000);
			System.out.println("end of reset settinsg");
			//To close any release notes pop up is displayed 
			if((getDriver().findElements(By.xpath(Web_UI.CrewClosebutton)).size()!=0)){
				System.out.println("Close button displayed");
				Thread.sleep(2000);
				clickByXpath(Web_UI.CrewClosebutton, "Close Release notes");
				Thread.sleep(2000);
				clickByXpath(Web_UI.CrewClosebutton, "Close Release notes");
				Thread.sleep(2000);
				System.out.println("close clicked");
			}
			//Performed to update Role and User if pop up prompts for it
			if((getDriver().findElements(By.xpath("//span[@class='report-title']")).size()!=0)){
				System.out.println("entered user role");
				Thread.sleep(5000);
				clickByXpath("//select[@data-ng-model='message.workGroup']", "workGroupDropDownSelect");
				clickByXpath("//option[@value='Control Center']", "controlcenterOptionSelect");
				Thread.sleep(1000);
				clickByXpath("//select[@data-ng-model='message.userRole']", "userRoleDropDownSelect");
				clickByXpath("//option[@value='Company Radio']", "CompanyRadioOptionSelect");
				Thread.sleep(1000);
				clickByXpath("//div[@data-ng-click='updateUserRole(message)']", "continueBtnclick");
				Thread.sleep(5000);
			}
			if((getDriver().findElements(By.xpath(Web_UI.CrewClosebutton)).size()!=0)){
				System.out.println("Close button displayed");
				Thread.sleep(2000);
				clickByXpath(Web_UI.CrewClosebutton, "Close Release notes");
				Thread.sleep(2000);
				System.out.println("close clicked");
			}
			//confirming if Teams message is disabled and to confirm it is not selected by default
			clickByXpath(Web_UI.filtericon, "Settings Icon ");
			Thread.sleep(1000);
			clickByXpath("//*[@id='db-filter-tabs']/div[5]", "viewSettingsTab");
			Thread.sleep(1000);
			if((getDriver().findElements(By.xpath(Web_UI.CrewClosebutton)).size()!=0)){
				System.out.println("Close button displayed");
				clickByXpath(Web_UI.CrewClosebutton, "Close Release notes");
			}
			WebElement teamsMsgChkBox = getDriver().findElement(By.xpath("//input[@id='cmesub']"));
			if(teamsMsgChkBox.isSelected()==false)
			{
				System.out.println();
				ATUReports.add("Teams message check box resetted back to default Settings and is disabled by default",  LogAs.PASSED, null); 
			}
			Thread.sleep(2000);
			clickByXpath("//span[@class='close-icn db-close']", "Close settings page");
		}catch(Exception Error)
		{
			System.out.println("Exception with Teams Message status");
			ATUReports.add("Some stats thrown error  " +Error.toString(),  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE)); 
			//clickByXpath(Web_UI.ApplyButton,"ApplyButton");
			Thread.sleep(8000);
			GanntViewHeaderFunctionality.SpinnerControl();
		}

	}

	public static void verifyTeamsMsgStatsCountandAppropriateMesageForZeroCountMsg() throws Exception, IOException {		
		try
		{//Selecting Teams Message option in Reset settings	
			clickByXpath(Web_UI.filtericon, "Settings Icon ");
			Thread.sleep(1000);
			clickByXpath("//*[@id='db-filter-tabs']/div[5]", "viewSettingsTab");
			Thread.sleep(1000);
			WebElement teamsMsgChkBox = getDriver().findElement(By.xpath("//input[@id='cmesub']"));
			if(teamsMsgChkBox.isSelected()==false)
			{
				teamsMsgChkBox.click();
			}
			clickByXpath(Web_UI.ApplyButton,"ApplyButton");
			Thread.sleep(3000);
			verifyDefaultMsgWhenTeamsMsgIsZer();
		}catch(Exception e) {
			ATUReports.add("Some Issue with selecting Teams message in Stats or msg being displayed or stats count",  LogAs.FAILED, null);	
		}
	}
	public static void verifyDefaultMsgWhenTeamsMsgIsZer() throws Exception {
		//clickByXpath("//div[@class='expnd-fltlst-icn']", "stats expand icon");
		Thread.sleep(2000);		
		if((getDriver().findElements(By.xpath("//div[@title='ConnectMe']/following-sibling::div")).size()!=0)){
			Thread.sleep(1000);
			String connectMeMsgCount = getDriver().findElement(By.xpath("//div[@title='ConnectMe']/following-sibling::div")).getAttribute("textContent").trim();
			System.out.println("connectMeMsgCount : "+connectMeMsgCount);
			Thread.sleep(2000);
			if(connectMeMsgCount.equals("0")) {
				System.out.println("entered msg section");
				clickByXpath("//div[@title='ConnectMe']/following-sibling::div", "ConnectMeEvent click");
				Thread.sleep(2000);
				//Below if condition will check for message when stats count is Zero
				if((getDriver().findElement(By.xpath("//div[@class='no-flt-div row ng-binding ng-scope']")).getAttribute("textContent").trim()
						.equalsIgnoreCase("There are no flight(s) under	ConnectMe"))){
					System.out.println("Msg displayed in appropriate");
					ATUReports.add("Appropriate Message displayed in when no Teams Message is available ",  LogAs.PASSED, null);
					clickByXpath("//div[@class='expnd-fltlst-icn']", "stats expand icon");
				}

			}//Below else  condition will check for stats count in dashboard matches with puck count
			else {
				System.out.println("entered lazy loading");
				//clickByXpath("//div[@title='Expand/Collapse View']", "stats collapse icon");
				Thread.sleep(2000);
				Lazyloading.VerifyStatsCount(Web_UI.connectMe,"Connect Me",Web_UI.connectMeStatsCount);
			}
		}
	}


	public static void verifyTeamsMsgInGenerateReportAndEventSlideOut() throws Exception{
		clickByXpath(Web_UI.connectMe,"Connect Me");
		if(getDriver().findElements(By.xpath("//div[@title='Expand Dashboard Stats']")).size()==0) {
			clickByXpath("//div[@title='Expand/Collapse View']", "collapseElement");
		}
		Thread.sleep(5000);
		List<WebElement> puckElements = getDriver().findElements(By.xpath(Web_UI.PuckComplete));
		System.out.println("puckElements : "+puckElements.size());
		if(puckElements.size()!=0) {
			for(int i=1;i<=puckElements.size();i++) {
				WebElement puckClick = getDriver().findElement(By.xpath("(//div[@data-ng-repeat='(key, flt) in ganttObject[gate]']/div[@data-ng-click='getEvents(flt,$event);'])["+i+"]"));
				Actions action = new Actions(getDriver());
				action.moveToElement(puckClick).build().perform();
				Thread.sleep(2000);
				action.click(puckClick).build().perform();
				clickByXpath("(//div[@data-ng-repeat='(key, flt) in ganttObject[gate]']/div[@data-ng-click='getEvents(flt,$event);'])["+i+"]", "firstelemntClick");
				Thread.sleep(3000);
				getDriver().switchTo().frame("event-info");
				Thread.sleep(10000);
				getDriver().findElement(By.xpath("(//div[@class='mat-tab-label-content'])[2]")).click();
				Thread.sleep(3000);
				getDriver().findElement(By.xpath("(//div[@class='mat-tab-label-content'])[5]")).click();
				Thread.sleep(3000);
				List<WebElement> msgList = getDriver().findElements(By.xpath("//div[@class='messages ng-star-inserted']"));
				List<String> msgListContentInNotesTab = new ArrayList<>();
				List<String> msgListContentInGenerateReport = new ArrayList<>();
				for(int j=1;j<=msgList.size();j++) {		
					String msgText = getDriver().findElement(By.xpath("(//div[@class='messages ng-star-inserted'])["+j+"]//div[@class='message ng-star-inserted']")).getAttribute("textContent").trim();
					msgListContentInNotesTab.add(msgText);
				}
				System.out.println("msgListContentInNotesTab : "+msgListContentInNotesTab.toString());
				Thread.sleep(1000);

				WebElement findElement = getDriver().findElement(By.xpath("(//div[@class='slideout-header ng-star-inserted']//mat-icon)[3]"));
				Thread.sleep(2000);
				action.moveToElement(findElement).build().perform();
				findElement.click();
				Thread.sleep(2000);
				action.sendKeys(Keys.ESCAPE).build().perform();
				Thread.sleep(2000);
				findElement.click();
				Thread.sleep(2000);
				driver.switchTo().defaultContent();
				Thread.sleep(5000);
				/*clickByXpath(Web_UI.CrewClosebutton,"close butn");
				Thread.sleep(2000);
				action.moveToElement(findElement).build().perform();
				findElement.click();*/
				//Thread.sleep(20000);
				WebElement FrameID=driver.findElement(By.id("generate-report-frame"));
				driver.switchTo().frame(FrameID);
				Thread.sleep(20000);
				//System.out.println(getDriver().findElement(By.xpath("//mat-panel-title[@class='mat-expansion-panel-header-title header-text ng-tns-c141-9']")).getAttribute("textContent").trim());
				List<WebElement> msgListInGenerateReport = getDriver().findElements(By.xpath("//div[@class='notes ng-star-inserted']"));
				for(int k=1;k<=msgListInGenerateReport.size();k++) {
					System.out.println("Trying to enter Generate Report frame");
					String msgTextInGenerateReport = getDriver().findElement(By.xpath("(//div[@class='notes ng-star-inserted'])["+k+"]//div[@class='content ng-star-inserted']")).getAttribute("textContent").trim();
					msgListContentInGenerateReport.add(msgTextInGenerateReport);
				}
				System.out.println("msgListContentInGenerateReport : "+msgListContentInGenerateReport.toString());
				boolean containsAll = msgListContentInNotesTab.containsAll(msgListContentInGenerateReport);
				System.out.println(containsAll);
				break;
			}
		}
	}


}

