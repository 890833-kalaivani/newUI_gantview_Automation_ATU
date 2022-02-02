package get.next.gen.utilities;
import java.io.IOException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import atu.testng.reports.ATUReports;
import atu.testng.reports.logging.LogAs;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;
import get.next.gen.commonaction.CommonTest;
import get.next.gen.webtestcase.Web_UI;
import scala.concurrent.forkjoin.ThreadLocalRandom;
public class UpdateETD extends CommonTest {
	public static String attribute;
	public static String etdReasonAndRemarksFldUpdate2="";
	public static void verifyUpdateETDScreenDisplayed() throws Exception {
		GanntViewHeaderFunctionality.GanntViewSelection();
		UpdateETD.updateETDScreenDisplayed();
		clickByXpath("//div[@data-ng-click='changeLockETD()']","UpdateETDIcon");
	}
	public static void verifyETDPost(String etdCondition) throws Exception {
		//Perform Sort functionality so that empty gates issue can be avoided
		clickByXpath(Web_UI.SortAscending,"SortAscending");
		Thread.sleep(3000);
		// Select Sort Ascending gate by alphabetical order from dropdown
		clickByXpath(Web_UI.SortAscendinggate,"SortAscendinggate");
		Thread.sleep(3000);
		//updateETDScreenDisplayed();
		ETDFieldUpdate(etdCondition);
		verifyingActivityLog();		
	}
	public static void verifyErrMsg(String errMSsgValidation) throws Exception {
		GanntViewHeaderFunctionality.GanntViewSelection();
		//UpdateETD.updateETDScreenDisplayed();
		ETDFieldUpdate(errMSsgValidation);
	}
	public static void updateETDScreenDisplayed() throws Exception {
		try { 
			System.out.println("Verify Update ETD icon is available");
			//Click update Etd icon in gantt view
			Thread.sleep(10000);
			getDriver().findElement(By.xpath("//div[@data-ng-click='changeLockETD()']")).isDisplayed();
			ATUReports.add("Update ETD icon is present",  LogAs.PASSED, null);
		}catch(Exception etdIconPresent){
			ATUReports.add("Update ETD icon not present or not clicked",  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		}
	}
	public static void ETDFieldUpdate(String etdCondition) throws Exception {
		clickByXpath("//div[@title='choose font size']/div[1]","fitToScreen");
		Thread.sleep(3000);
		clickByXpath("//div[@data-ng-click='changeLockETD()']","UpdateETDIcon");
		Thread.sleep(4000);
		List<WebElement> listOfETDExtendPuck = getDriver().findElements(By.xpath("//div[@data-ng-repeat='(key, flt) in ganttObject[gate]']/div"));
		System.out.println(listOfETDExtendPuck.size());
		for(WebElement puckresizebar:listOfETDExtendPuck) {
			Actions actions = new Actions(getDriver());
			actions.moveToElement(puckresizebar).build().perform();
			try {
				WebElement displayed = puckresizebar.findElement(By.xpath("div[@class='resize-bar ng-scope']"));
				if(puckresizebar.findElement(By.xpath("div[@class='resize-bar ng-scope']")).isDisplayed()) {
					Point p = displayed.getLocation();
					int x = p.getX();
					int y = p.getY();
					int xx = x+01;
					actions.dragAndDropBy(displayed, xx, y).build().perform();
					Thread.sleep(3000);
					WebElement iframeElement = getDriver().findElement(By.xpath("html/body//iframe[contains(@ng-src,'https://get.azne.aa.com/GetNG/#/updateETD/')]"));
					System.out.println("Switching to UpdateETD frame"+getDriver().switchTo().frame(iframeElement));
					Thread.sleep(2000);
					//getting current ETD value
					UpdateETD.newETDField(etdCondition);
					break;						
				}
				else {
					WebElement scrollview = getDriver().findElement(By.xpath(Web_UI.Scrollbar));
					Thread.sleep(5000);
					scrollview.click(); 
					actions.sendKeys(Keys.PAGE_DOWN).build().perform();
					Thread.sleep(2000);
				}
			}catch(Exception E) {
			}
		}
	}
	public static void newETDField(String etdCondition) throws Exception {
		String CurtETDValue = getDriver().findElement(By.xpath("//div[@class='text-center curr-etd etd-field']")).getAttribute("textContent").trim();
		String curtETDValTime = CurtETDValue.substring(0, 5);
		String[] split = curtETDValTime.split(":");
		Integer split0 = Integer.valueOf(split[0]);
		Integer split1 = Integer.valueOf(split[1]);
		switch(etdCondition){
		case "advisoryPost":
			etdReasonAndRemarksFldUpdate2 = UpdateETD.etdReasonAndRemarksFldUpdate();
			if(split1<50) {
				getDriver().findElement(By.xpath("//input[@id='mat-input-1']")).click();
				getDriver().findElement(By.xpath("//input[@id='mat-input-1']")).clear();
				getDriver().findElement(By.xpath("//input[@id='mat-input-1']")).sendKeys(String.format ("%02d", split0)+":"+String.valueOf((split1+10)));
				/*getDriver().findElement(By.xpath("//input[@placeholder='HH']")).sendKeys(String.valueOf((split0)));
				getDriver().findElement(By.xpath("//input[@placeholder='MM']")).sendKeys(String.valueOf((split1+10)));*/
			}else{
				getDriver().findElement(By.xpath("//input[@id='mat-input-1']")).click();
				getDriver().findElement(By.xpath("//input[@id='mat-input-1']")).clear();
				getDriver().findElement(By.xpath("//input[@id='mat-input-1']")).sendKeys(String.format ("%02d", (split0+1))+":"+String.valueOf((split1-49)));
				/*getDriver().findElement(By.xpath("//input[@placeholder='HH']")).sendKeys(String.valueOf((split0+1)));
				getDriver().findElement(By.xpath("//input[@placeholder='MM']")).sendKeys(String.valueOf((split1-49)));*/
			}
			//clicking submit button	
			getDriver().findElement(By.xpath("//div[@class='apply-btn']")).click();
			System.out.println("Advisory post is submitted");
			ATUReports.add("Advisory post is submitted",  LogAs.PASSED, null);
			break;
		case "requestToPost":
			etdReasonAndRemarksFldUpdate2 = UpdateETD.etdReasonAndRemarksFldUpdate();
			if(split1<=35) {
				getDriver().findElement(By.xpath("//input[@id='mat-input-1']")).click();
				getDriver().findElement(By.xpath("//input[@id='mat-input-1']")).clear();
				getDriver().findElement(By.xpath("//input[@id='mat-input-1']")).sendKeys(String.format ("%02d", split0)+":"+String.valueOf((split1+20)));
				/*getDriver().findElement(By.xpath("//input[@placeholder='HH']")).sendKeys(String.valueOf((split0)));
				getDriver().findElement(By.xpath("//input[@placeholder='MM']")).sendKeys(String.valueOf((split1+20)));*/
			}else{
				int s1 = split0+1;
				int s2 = split1-30;
				/*getDriver().findElement(By.xpath("//input[@placeholder='HH']")).sendKeys(String.valueOf((split0+1)));
				getDriver().findElement(By.xpath("//input[@placeholder='MM']")).sendKeys(String.valueOf((split1+05)));*/
				getDriver().findElement(By.xpath("//input[@id='mat-input-1']")).click();
				getDriver().findElement(By.xpath("//input[@id='mat-input-1']")).clear();
				getDriver().findElement(By.xpath("//input[@id='mat-input-1']")).sendKeys(String.format ("%02d", s1)+":"+String.format ("%02d", s2));
			}
			//clicking submit button	
			getDriver().findElement(By.xpath("//div[@class='apply-btn']")).click();
			System.out.println("Request to post is submitted");
			ATUReports.add("Request to post is submitted",  LogAs.PASSED, null);
			break;
		case "errorMsgValidation":
			try {
				getDriver().findElement(By.xpath("//input[@id='mat-input-1']")).click();
				getDriver().findElement(By.xpath("//input[@id='mat-input-1']")).clear();
				int s1 = split0+5;
				int s2 = split1+05;
				getDriver().findElement(By.xpath("//input[@id='mat-input-1']")).sendKeys(String.format ("%02d", s1)+":"+String.valueOf(s2));
				Thread.sleep(1000);
				String newETDErrMsg = getDriver().findElement(By.xpath("//mat-error[@class='mat-error invalid-eta ng-star-inserted']")).getAttribute("textContent");
				System.out.println("newETDErrMsg:"+newETDErrMsg);
				if((newETDErrMsg.trim()).contains("New ETD must be within four hours from Current ETD")) {
					System.out.println("Error message displayed for New ETD field");
					ATUReports.add("Error message displayed for New ETD field",  LogAs.PASSED, null);
				}else {
					ATUReports.add("Error message not displayed for New ETD field",  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}
				s1=split0+2;
				getDriver().findElement(By.xpath("//input[@id='mat-input-1']")).click();
				getDriver().findElement(By.xpath("//input[@id='mat-input-1']")).clear();
				getDriver().findElement(By.xpath("//input[@id='mat-input-1']")).sendKeys(String.format ("%02d", s1)+":"+String.valueOf((split1+10)));
				String moreThansixtyMinsPopUpMSg = getDriver().findElement(By.xpath("//*[@class='mat-dialog-content']")).getAttribute("textContent");
				if(moreThansixtyMinsPopUpMSg.contains("You are adding more than 60 minutes to the departure time of this flight. Are you sure")) {
					System.out.println("Pop up displayed with appropriate message for entering ETD time more than 60 minutes");
					ATUReports.add("Pop up displayed with appropriate message for entering ETD time more than 60 minutes",  LogAs.PASSED, null);
				}else {
					ATUReports.add("Pop up/appropriate message not displayed for entering ETD time more than 60 minutes",  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}
				getDriver().findElement(By.xpath("//button[@class='mat-focus-indicator mat-raised-button mat-button-base mat-primary']")).click();
				clickByXpath("//div[@class='apply-btn']", "submitButton");
				String remarksErrMsg = getDriver().findElement(By.xpath("//div/mat-error[@id='mat-error-0']")).getAttribute("textContent");
				if(remarksErrMsg.contains("Enter Reason")) {
					System.out.println("Error message displayed for Remarks field");
					ATUReports.add("Error message displayed for Remarks field",  LogAs.PASSED, null);
				}else {
					ATUReports.add("Error message not displayed for Remarks field",  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}
				String etdReasonErrMsg = getDriver().findElement(By.xpath("//div/mat-error[@id='mat-error-1']")).getAttribute("textContent");
				if(etdReasonErrMsg.contains("Select ETD Code")) {
					System.out.println("Error message displayed for ETD reasons  field");
					ATUReports.add("Error message displayed for ETD reasons  field",  LogAs.PASSED, null);
				}else {
					ATUReports.add("Error message not displayed for ETD Reasons field",  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}
			}
			catch(Exception e){
			}
			finally {
				getDriver().switchTo().defaultContent();
				getDriver().findElement(By.xpath("//div//span[contains(@class,'close-icn')]")).click();
			}
			break;
		}
	}
	public static String etdReasonAndRemarksFldUpdate() throws Exception{
		clickByXpath("(//div[contains(@class,'mat-select-arrow ng-tns')])[2]", "arrowClkForETDReason");
		int ETDReasonOptionsNum = getDriver().findElements(By.xpath("//mat-option[contains(@id,'mat-option')]")).size();
		//generating random number to choose anyone value in ETD reason drop down
		int randomNum = ThreadLocalRandom.current().nextInt(1, ETDReasonOptionsNum);
		String s1 = "Entering value for ETD Update "+randomNum;
		try {
			System.out.println("Entered etdReasonAndRemarksFldUpdate");
			//clicking dropdown arrow icon for ETD reasons field
			String enterETdReasonOption = "//mat-option[@id='mat-option-"+randomNum+"']";
			System.out.println("enterETdReasonOption"+enterETdReasonOption);
			clickByXpath(enterETdReasonOption, "ETDReasonSelect");
			//Entering value in Remarks field
			getDriver().findElement(By.xpath("//textarea[@id='mat-input-2']")).sendKeys(s1);
			System.out.println("s1 is:"+s1);
			ATUReports.add("Entered value in ETD Reason/Remarks field",  LogAs.PASSED, null);
		}catch (Exception updateETDFieldsnotEntered) {
			// TODO Auto-generated catch block
			ATUReports.add("values not entered in ETD Reason/Remarks field",  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		}
		return s1;	
	}
	public static void verifyingActivityLog() throws Exception {
		Thread.sleep(2000);
		getDriver().switchTo().parentFrame();
		Thread.sleep(2000);
		getDriver().findElement(By.xpath("//i[@class='fa fa-activity-log-icon']")).click();
		Thread.sleep(1000);
		getDriver().findElement(By.xpath("//a[text()='Station Activity']")).click();
		System.out.println("station activity clicked");
		attribute = getDriver().findElement(By.xpath("//div[@class='ellipsis-text ng-binding'][1]")).getAttribute("textContent");
		System.out.println("Activity log value"+attribute);
		if((etdReasonAndRemarksFldUpdate2.trim()).contains((attribute.trim()))) {
			ATUReports.add("ETD is submitted and verified",  LogAs.PASSED, null);
		}else {
			ATUReports.add("ETD is submitted but no reports available in Activity log",  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		}
		getDriver().findElement(By.xpath("//span[@class='close-icn ng-scope']")).click();
	}
	//Verify update ETD link not displayed for TERM flights
	public static void updateETD_NA_ForTermFlights() throws Exception {
		verifyUpdateETDScreenDisplayed();
		WebElement term = getDriver().findElement(By.xpath("//li[@title='TERM Flights']"));
		Actions action = new Actions(getDriver());
		action.moveToElement(term);
		System.out.println("Element moved");
		JavascriptExecutor executor = (JavascriptExecutor)getDriver();
		executor.executeScript("arguments[0].click();", term);
		clickByXpath("//div[@title='choose font size']/div[1]","fitToScreen");
		List<WebElement> entirePuckList = getDriver().findElements(By.xpath(Web_UI.PuckComplete));
		for(WebElement puckDetails:entirePuckList) {
			String terminatedStringInID = puckDetails.getAttribute("id");
			if(terminatedStringInID.contains("TERMINATED")){
				Actions actions = new Actions(getDriver());
				actions.moveToElement(puckDetails).build().perform();
				try {
					WebElement displayed = puckDetails.findElement(By.xpath("div[@class='resize-bar ng-scope']"));
					if(displayed.isDisplayed()) {
						ATUReports.add("Update ETD resize Bar displayed for Term Flights "+terminatedStringInID,  LogAs.FAILED, null);
					}
				}catch(Exception e){
					ATUReports.add("Update ETD resize Bar not displayed for Term Flights "+terminatedStringInID,  LogAs.PASSED, null);
				}
			}
		}
	
	}
	
	public static void updateETD_NA_out_Off_Cancelled() throws Exception {
		verifyUpdateETDScreenDisplayed();
		WebElement term = getDriver().findElement(By.xpath((Web_UI.Term)));
		JavascriptExecutor executor = (JavascriptExecutor)getDriver();
		executor.executeScript("arguments[0].click();", term);
		clickByXpath("//div[@title='choose font size']/div[1]","fitToScreen");
		List<WebElement> entirePuckList = getDriver().findElements(By.xpath(Web_UI.PuckComplete));
		for(WebElement puckDetails:entirePuckList) {
			String terminatedStringInID = puckDetails.getAttribute("id");
			if(terminatedStringInID.contains("TERMINATED")){
				Actions actions = new Actions(getDriver());
				actions.moveToElement(puckDetails).build().perform();
				try {
					WebElement displayed = puckDetails.findElement(By.xpath("div[@class='resize-bar ng-scope']"));
					if(displayed.isDisplayed()) {
						ATUReports.add("Update ETD resize Bar displayed for Term Flights "+terminatedStringInID,  LogAs.FAILED, null);
					}
				}catch(Exception e){
					ATUReports.add("Update ETD resize Bar not displayed for Term Flights "+terminatedStringInID,  LogAs.PASSED, null);
				}
			}
		}
	
	}
}
