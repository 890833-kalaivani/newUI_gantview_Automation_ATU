package get.next.gen.utilities;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import atu.testng.reports.ATUReports;
import atu.testng.reports.logging.LogAs;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;
import get.next.gen.commonaction.CommonTest;
import scala.concurrent.forkjoin.ThreadLocalRandom;

public class TwistApplication extends CommonTest{
	public static String etdReasonAndRemarksFldUpdate2="";
	public static void verifyTwistAppDisplaysGMTTime() {
		final Date currentTime = new Date();
		final SimpleDateFormat sdf =
				new SimpleDateFormat("hh:mm");
		// Give it to me in GMT time.
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		String currentGMTTime = sdf.format(currentTime).toString().trim();
		System.out.println("GMT time: " + sdf.format(currentTime).toString());
		String twistHeaderTime = getDriver().findElement(By.xpath("//div[@class='current-time all-tab-margin']/div")).getAttribute("textContent");
		System.out.println(twistHeaderTime);
		if(twistHeaderTime.trim().contains(currentGMTTime)) {
			System.out.println("GMT time is displayed");
		}
	}
	public static void verifyETDUpdate() throws Exception{
		clickByXpath("//mat-icon[@mattooltip='Unlock ETD']", "Enlock ETD");
		List<WebElement> listOfETDExtendPuck = getDriver().findElements(By.xpath("//div[@class='ng-resizable-handle ng-resizable-e']"));
		System.out.println(listOfETDExtendPuck.size());
		for(WebElement puckresizebar:listOfETDExtendPuck) {
			Actions actions = new Actions(getDriver());
			actions.moveToElement(puckresizebar).build().perform();
			Thread.sleep(2000);
			try {

				Point p = puckresizebar.getLocation();
				int x = p.getX();
				int y = p.getY();
				int xx = x+01;
				Thread.sleep(2000);
				actions.dragAndDropBy(puckresizebar, xx, y).build().perform();
				Thread.sleep(2000);
				if(getDriver().findElements(By.xpath("//div[contains(text(),'UPDATE ETD')]")).size()!=0) {
					System.out.println("Reached");
					TwistApplication.newETDField("requestToPost");
					break;
				}
				Thread.sleep(2000);
				//break;
			}catch(Exception e){

			}
		}			
	}
	public static void newETDField(String etdCondition) throws Exception {
		String CurtETDValue = getDriver().findElement(By.xpath("//div[@class='row etd-data']//div[@class='col-5']")).getAttribute("textContent").trim();
		String curtETDValTime = CurtETDValue.substring(0, 5);
		String[] split = curtETDValTime.split(":");
		Integer split0 = Integer.valueOf(split[0]);
		Integer split1 = Integer.valueOf(split[1]);
		switch(etdCondition){
		case "advisoryPost":
			etdReasonAndRemarksFldUpdate2 = TwistApplication.etdOptionReasonAndRemarksFldUpdate();
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
			getDriver().findElement(By.xpath("//button[@class='btn btn-primary']")).click();
			System.out.println("Advisory post is submitted");
			ATUReports.add("Advisory post is submitted",  LogAs.PASSED, null);
			break;
		case "requestToPost":
			etdReasonAndRemarksFldUpdate2 = TwistApplication.etdOptionReasonAndRemarksFldUpdate();
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
			getDriver().findElement(By.xpath("//button[@class='btn btn-primary']")).click();
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
				clickByXpath("//button[@class='btn btn-primary']", "submitButton");
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
	public static String etdOptionReasonAndRemarksFldUpdate() throws Exception{
		clickByXpath("(//div[@class='mat-select-arrow-wrapper'])[1]/div", "arrowClkForOption");
		clickByXpath("//mat-option[@value='ETD']/span", "ETDOptionSelect");
		clickByXpath("(//div[@class='mat-select-arrow-wrapper'])[2]/div", "arrowClkForETDReason");
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
}
