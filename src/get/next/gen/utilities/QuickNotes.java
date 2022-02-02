package get.next.gen.utilities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import atu.testng.reports.ATUReports;
import atu.testng.reports.logging.LogAs;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;
import get.next.gen.commonaction.CommonTest;
import get.next.gen.webtestcase.Web_UI;

public class QuickNotes extends CommonTest {
	public static Actions action = new Actions(getDriver());

	public static void rightClickPuck(String eventName) throws Exception {		
		clickByXpath("//div[@title='choose font size']/div[1]","fitToScreen");
		Thread.sleep(2000);
		clickByXpath("//div[@title='choose font size']/div[2]","minFontSize");
		Thread.sleep(2000);
		/*clickByXpath(Web_UI.SortAscending,"SortAscending");
		Thread.sleep(2000);*/
		List<WebElement> Ganntlist = getDriver().findElements(By.xpath(Web_UI.PuckComplete));
		System.out.println(Ganntlist.size());

		for(WebElement firstPuck:Ganntlist) {
			String firstPuckid = firstPuck.getAttribute("id").trim();
			System.out.println("firstPuckid"+firstPuckid);
			action.moveToElement(firstPuck).build().perform();
			//List<WebElement> arrivalFltStatus = firstPuck.findElements(By.xpath(Web_UI.arrivalFltStatus));
			//List<WebElement> depFltStatus = firstPuck.findElements(By.xpath(Web_UI.depFltStatus));
			if(!firstPuckid.contains("UNLINKED")&&firstPuck.findElement(By.xpath("//div[@id='"+firstPuckid+"']//span[@class='puck-dep-time-spn']/span[1]")).isDisplayed()&&firstPuck.findElement(By.xpath("(//div[@id='"+firstPuckid+"']//div[@class='puck-additional-det']/span)[2]")).isDisplayed()) {
				System.out.println("entered if");
				//if(!firstPuckid.contains("UNLINKED")&&(!(arrivalFltStatus.size()<0))&&(!(depFltStatus.size()<0))) {
				//action.moveToElement(firstPuck).build().perform();
				String depFltStatus = getDriver().findElement(By.xpath("//div[@id='"+firstPuckid+"']//span[@class='puck-dep-time-spn']/span[1]")).getAttribute("textContent");
				System.out.println("depFltStatus "+depFltStatus);
				Thread.sleep(2000);
				//action.moveToElement(firstPuck).build().perform();
				String arrivalFltStatus = getDriver().findElement(By.xpath("(//div[@id='"+firstPuckid+"']//div[@class='puck-additional-det']/span)[2]")).getAttribute("textContent");
				System.out.println("arrivalFltStatus "+arrivalFltStatus);
				Thread.sleep(2000);
				if(arrivalFltStatus.contains("IN")&&depFltStatus.contains("SKD")) {
					WebElement firstPuckidclick = getDriver().findElement(By.xpath("//div[@id='"+firstPuckid+"']"));
					action.moveToElement(firstPuckidclick).build().perform();
					System.out.println("moved to first element"); 
					Thread.sleep(2000);
					action.contextClick(firstPuckidclick);
					action.perform();
					Thread.sleep(3000);
					switch(eventName) {
					case "PAX":
						getDriver().findElement(By.xpath("(//div[@id='"+firstPuckid+"']/following-sibling::ul//li[contains(@class,'quick-nts-li-evt')])[1]/a[@class='quick-nts-option-a ng-binding']")).click();
						Thread.sleep(1000);
						getDriver().findElement(By.xpath("//div[@id='"+firstPuckid+"']/following-sibling::ul//li[@class='quick-nts-li-menu-hdn ng-scope']/a")).click();
						Thread.sleep(1000);
						getDriver().findElement(By.xpath("//div[@id='"+firstPuckid+"']/following-sibling::ul//li[@title='Cleaners not done ']")).click();
						action.moveToElement(firstPuckidclick).build().perform();
						System.out.println("moved to puck element"); 
						Thread.sleep(2000);
						firstPuckidclick.click();
						Thread.sleep(2000);
						getDriver().switchTo().frame("event-info");
						Thread.sleep(3000);
						getDriver().findElement(By.xpath("//div[@title='PAX']//span[contains(@class,'evt-nts-icn')]/mat-icon")).click();
						Thread.sleep(2000);
						String quickNotesAttributeValuePAX = getDriver().findElement(By.xpath("//div[@class='nts-evt-list']/app-list-notes//mat-card-content[@class='mat-card-content']")).getAttribute("textContent");
						if((quickNotesAttributeValuePAX.trim()).contains("PAX - Start of Boarding - Cleaners not done")) {
							ATUReports.add("Quick notes selected in puck for PAX reflected in Notes section",  LogAs.PASSED, null);
						}else {
							ATUReports.add("Quick notes selected in puck for PAX NOT reflected in Notes section  or some issue in submitting quick notes",  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						}
						break;
					case "BAGS":
						
						//action.moveToElement(firstPuckidclick).build().perform();
						WebElement bagsMainMenuInQuickNotesPopUP = getDriver().findElement(By.xpath("(//div[@id='"+firstPuckid+"']/following-sibling::ul//li[contains(@class,'quick-nts-li-evt')])[3]/a"));
						bagsMainMenuInQuickNotesPopUP.click();
						Thread.sleep(2000);
						bagsMainMenuInQuickNotesPopUP.findElement(By.xpath("following-sibling::ul//li[@title='Late transfer bag']/a")).click();
						action.moveToElement(firstPuckidclick).build().perform();
						System.out.println("moved to puck element"); 
						Thread.sleep(2000);
						firstPuckidclick.click();
						Thread.sleep(3000);
						
						getDriver().switchTo().frame("event-info");
						Thread.sleep(3000);
						GenerateReport.switchingToGenerateReportFrame();
						//Thread.sleep(3000);
						/*getDriver().findElement(By.xpath("//div[@title='BAGS']//span[contains(@class,'evt-nts-icn')]/mat-icon")).click();
						Thread.sleep(2000);
						int size = getDriver().findElements(By.xpath("//div[@class='nts-evt-list']/app-list-notes//mat-card-content[@class='mat-card-content']")).size();
						System.out.println("size is"+size);
						String quickNotesAttributeValueBAGS = getDriver().findElement(By.xpath("(//div[@class='nts-evt-list']/app-list-notes//mat-card-content[@class='mat-card-content'])["+size+"]")).getAttribute("textContent");
						System.out.println(quickNotesAttributeValueBAGS);
						if((quickNotesAttributeValueBAGS.trim()).contains("BAGS - Last Bag On - Late transfer bag")) {
							System.out.println("Quick notes selected in puck for BAGS reflected in Notes section");
							ATUReports.add("Quick notes selected in puck for BAGS reflected in Notes section",  LogAs.PASSED, null);
						}else {
							System.out.println("Quick notes selected in puck for BAGS NOT reflected in Notes section");
							ATUReports.add("Quick notes selected in puck for BAGS NOT reflected in Notes section or some issue in submitting quick notes",  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						}*/
						Thread.sleep(2000);
						break;
					}
				}
			}else {
				System.out.println("ID containg Unlinked");
			}
		}

	}





}
