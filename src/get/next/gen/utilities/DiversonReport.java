package get.next.gen.utilities;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import get.next.gen.commonaction.API_commonActions;
import get.next.gen.commonaction.CommonTest;
import get.next.gen.webtestcase.Web_UI;

public class DiversonReport extends CommonTest {

	/*
	 * @FindBy(xpath="//div[@data-ng-click='changeLockETD()']") public static
	 * WebElement diversionReportIcon; public DiversonReport(){
	 * PageFactory.initElements(getDriver(), this); } public static void iconClick()
	 * { System.out.println("entered page factory"); diversionReportIcon.click(); }
	 */
	static List<String> getNG_flightNumbersList = new ArrayList<>();
	public static boolean classicDiversionFlightsSize;
	static Actions action = new Actions(getDriver());
	public static boolean divReport_IsDisplayed() throws Exception {
		/*clickByXpath("//li[@title='Diversion report']/a", "diversionReportIconClick");
		getDriver().switchTo().frame(0);
		Thread.sleep(5000);*/
		/*getDriver().findElement(By.xpath("//mat-icon[@mattooltip='Live Data, click to view Mock Data']")).click();						 
		Thread.sleep(2000);*/
		if (getDriver().findElement(By.xpath("//mat-card-title[@class='mat-card-title main-title']"))
				.getAttribute("textContent").trim().contains("Diversion Report")) {
			System.out.println("Diversion Report Displayed");
			if(getDriver().findElements(By.xpath("//div[@class='mat-list-item-content']")).size()>1){
				classicDiversionFlightsSize = true;
				System.out.println("Diversion flights are available and hence other tc can be executed");
			}else {
				classicDiversionFlightsSize = false;
				System.out.println("Diversion flights are not available and hence other tc cannot be executed");
			}
		}
		else {
			System.out.println("Issue in Diversion Report to be opened and hence Test case failed");
		}
		System.out.println("classicDiversionFlightsSize"+classicDiversionFlightsSize);

		return classicDiversionFlightsSize;
	}
	public static boolean verifyDiversionFlightsAvailable() throws Exception{
		clickByXpath("//span[@class='mat-button-wrapper']", "classicbuttonClick");
		if(getDriver().findElements(By.xpath("//tr[@class='mat-row cdk-row ng-star-inserted']")).size()!=0){
			return true;
		}else {
			return false;
		}

	}

	public static void divReport_NavigatingToDestinationStation() throws Exception {
		try {
			System.out.println("Reached detination stationmethod");
			clickByXpath("//span[@class='mat-button-wrapper']", "classicbuttonClick");
			Thread.sleep(1000);
			String destinationStation = getDriver()
					.findElement(By.xpath("//div[@class='stats'][1]//div[@class='stn-list ng-star-inserted'][1]"))
					.getAttribute("textContent").substring(0, 4).trim();
			System.out.println("destinationStation"+destinationStation);
			getDriver().switchTo().parentFrame();
			clickByXpath("//span[@class='close-icn']", "closeDiversionReport");
			CustomZone.SelectStation(destinationStation);
			clickByXpath("//li[@title='Diversion report']/a", "diversionReportIconClick");
			Thread.sleep(3000);
			getDriver().switchTo().frame(0);
			clickByXpath("//button[@id='mat-button-toggle-1-button']/div", "returnButtonClick");
			System.out.println("Return button clicked");
		} catch (InterruptedException e) {
			System.out.println(
					"Issue in navigating to Destination status of diversion Report and hence Test case failed");
		}
	}

	public static void divReport_createAdhocEvent() throws Exception {
		try {
			int enhnacedviewRomSize = getDriver().findElements(By.xpath("//div[@class='mat-list-item-content']")).size();
			System.out.println(enhnacedviewRomSize);
			for(int i=2;i<=enhnacedviewRomSize;i++) {
				String arrivalStatus = getDriver().findElement(By.xpath("(//div[@class='mat-list-item-content'])["+i+"]//div[@class='arrival-hdn departure']//div[@class='arr-status']")).getAttribute("textContent").trim();
				System.out.println("cycle"+i);
				if(!arrivalStatus.equalsIgnoreCase("OFF")){
					System.out.println(arrivalStatus);
					getDriver().findElement(By.xpath("(//div[@class='mat-list-item-content'])["+i+"]//mat-icon[@class='mat-icon notranslate material-icons mat-icon-no-color']")).click();
					action.moveToElement(getDriver().findElement(By.xpath("//span[contains(text(),'Adhoc Event')]"))).build().perform();
					action.click(getDriver().findElement(By.xpath("//span[contains(text(),'Adhoc Event')]"))).build().perform();
					Thread.sleep(5000);
					action.moveToElement(getDriver().findElement(By.xpath("//textarea[@id='mat-input-3']"))).build().perform();
					action.click(getDriver().findElement(By.xpath("//textarea[@id='mat-input-3']"))).build().perform();
					action.sendKeys("Test123").build().perform();
					clickByXpath("//div[@class='Create-Action']", "adhocCreateAction");
					break;
				}

			}
		} catch (Exception e) {
			e.printStackTrace();		}
	}

	public static void divReport_createUpdateETD() throws Exception {
		try {



			int enhnacedviewRomSize = getDriver().findElements(By.xpath("//div[@class='mat-list-item-content']")).size();
			System.out.println(enhnacedviewRomSize);
			for(int i=2;i<=enhnacedviewRomSize;i++) {
				String arrivalStatus = getDriver().findElement(By.xpath("(//div[@class='mat-list-item-content'])["+i+"]//div[@class='arrival-hdn departure']//div[@class='arr-status']")).getAttribute("textContent").trim();
				System.out.println("cycle"+i);
				if(!arrivalStatus.equalsIgnoreCase("OFF")){

					getDriver().findElement(By.xpath("(//div[@class='mat-list-item-content'])["+i+"]//mat-icon[@class='mat-icon notranslate material-icons mat-icon-no-color']")).click();
					Thread.sleep(5000);
					action.moveToElement(getDriver().findElement(By.xpath("//span[contains(text(),'ETD Update')]/following-sibling::div"))).build().perform();
					action.click(getDriver().findElement(By.xpath("//span[contains(text(),'ETD Update')]/following-sibling::div"))).build().perform();
					Thread.sleep(5000);
					/*getDriver().findElement(By.xpath("(//div[@class='mat-list-item-content'])["+i+"]//mat-icon[@class='mat-icon notranslate material-icons mat-icon-no-color']")).click();
					Thread.sleep(5000);*/
					//clickByXpath("//div[contains(@class,'mat-select-arrow-wrapper ng-tns')]", "etdReasonsDropDownArrowClick");
					//clickByXpath("//div[contains(@class,'mat-select-arrow-wrapper ng-tns')]", "etdArrowIconClick");
					/*action.moveToElement(getDriver().findElement(By.xpath("//div[contains(@class,'mat-select-value ng-tns')]/span"))).build().perform();
					action.click(getDriver().findElement(By.xpath("//div[contains(@class,'mat-select-value ng-tns')]/span"))).build().perform();
					Thread.sleep(5000);
					action.click(getDriver().findElement(By.xpath("//span[contains(text(),'ACF - Delays during A/C fueling ')]"))).build().perform();*/
					/*clickByXpath("//span[contains(text(),'ACF - Delays during A/C fueling ')]",
							"etdReasonsDropDownValue Selection");*/
					Thread.sleep(2000);
					action.sendKeys(Keys.ESCAPE).build().perform();
					Thread.sleep(2000);
					//getDriver().findElement(By.xpath("//mat-list[@id='cdk-drop-list-0']//mat-list[@id='cdk-drop-list-0']")).click();
					action.sendKeys(Keys.PAGE_DOWN).build().perform();
					Thread.sleep(2000);
					clickByXpath("//div[contains(@class,'mat-select-arrow-wrapper ng-tns')]", "etdArrowIconClick");
					Thread.sleep(3000);
					action.click(getDriver().findElement(By.xpath("//span[contains(text(),'ACF - Delays during A/C fueling ')]"))).build().perform();
					Thread.sleep(2000);
					action.moveToElement(getDriver().findElement(By.xpath("(//span[contains(@class,'mat-form-field-label-wrapper ng-tns')])[7]"))).build().perform();
					Thread.sleep(2000);
					action.click(getDriver().findElement(By.xpath("(//span[contains(@class,'mat-form-field-label-wrapper ng-tns')])[7]"))).build().perform();
					action.sendKeys("Test123").build().perform();
					Thread.sleep(2000);
					/*clickByXpath("//textarea[@id='mat-input-10']", "textEnter");
					getDriver().findElement(By.xpath("//textarea[@id='mat-input-10']")).sendKeys("Test123");

					Thread.sleep(1000);*/
					clickByXpath("//button[@class='mat-focus-indicator apply-btn mat-raised-button mat-button-base']",
							"etdSubmitButton");
					Thread.sleep(5000);
					if (getDriver().findElement(By.xpath("//div[@class='layout-cntnt adhoc']/img[@title='Pending']"))
							.isDisplayed())
						System.out.println("ETD pending icon is Present");
					else
						System.out.println("ETD pending icon is not Present");
					break;
				} 
			}
		}catch (Exception e) {
			e.printStackTrace();	
		}
	}

	public static void divReport_generateReport() throws Exception {
		try {
			int enhnacedviewRomSize = getDriver().findElements(By.xpath("//div[@class='mat-list-item-content']")).size();
			System.out.println(enhnacedviewRomSize);
			for(int i=2;i<=enhnacedviewRomSize;i++) {
				String arrivalStatus = getDriver().findElement(By.xpath("(//div[@class='mat-list-item-content'])["+i+"]//div[@class='arrival-hdn departure']//div[@class='arr-status']")).getAttribute("textContent").trim();
				System.out.println("cycle"+i);
				if(!arrivalStatus.equalsIgnoreCase("OFF")){
					getDriver().findElement(By.xpath("(//div[@class='mat-list-item-content'])["+i+"]//mat-icon[@class='mat-icon notranslate material-icons mat-icon-no-color']")).click();
					Thread.sleep(5000);
					getDriver().findElement(By.xpath("//a[@class='generate-report']/mat-icon"))
					.click();
					String curentWindow = getDriver().getWindowHandle();
					Set<String> s = getDriver().getWindowHandles();
					System.out.println("total window" + s.size());
					Iterator<String> iterator = s.iterator();
					String mainWindow = iterator.next();
					String secondWindow = iterator.next();
					System.out.println("++" + mainWindow + secondWindow);
					getDriver().switchTo().window(secondWindow);
					System.out.println(getDriver().getTitle() + getDriver().getCurrentUrl());
					if (getDriver().findElement(By.xpath("//div[@title='Summary View']")).isDisplayed())
						System.out.println("Generate Report is displayed");
					else
						System.out.println("Generate Report is NOT displayed");
					getDriver().switchTo().defaultContent();
					Thread.sleep(3000);
					System.out.println("switched to main frame");
					if (getDriver().findElement(By.xpath("//mat-card-title[@class='mat-card-title main-title']"))
							.getAttribute("textContent").trim().contains("Diversion Report"))
						System.out.println("Diversion Report Displayed");
					else
						System.out.println("Issue in Diversion Report to be opened and hence Test case failed");
				}
			}
		}catch (Exception e) {
			System.out.println("Issue in opening generate Report  and hence Test case failed");
		}
		// String divReport_flightNumber =
		// getDriver().findElement(By.xpath("(//div[@class='mat-list-item-content'])[2]//div[@class='layout-cntnt
		// user-priority']")).getAttribute("textContent");
		/*
		 * WebElement wb = getDriver().findElement(By.
		 * xpath("(//div[@class='mat-list-item-content'])[2]//div[@class='layout-cntnt user-priority']"
		 * )); Actions actions = new Actions(getDriver()); actions.moveToElement(wb);
		 * String divReport_flightNumber = wb.getAttribute("textContent");
		 * System.out.println("fligght number"+divReport_flightNumber);
		 */
		// getDriver().findElement(By.xpath("//mat-icon[@mattooltip='Live Data, click to
		// view Mock Data']")).click();
		// Thread.sleep(2000);
	}

	public static void divReport_EnteringNotes() throws Exception {
		try {
			/*
			 * Thread.sleep(3000); getDriver().findElement(By.
			 * xpath("//mat-icon[@mattooltip='Live Data, click to view Mock Data']")).click(
			 * ); Thread.sleep(5000);
			 */

			int enhnacedviewRomSize = getDriver().findElements(By.xpath("//div[@class='mat-list-item-content']")).size();
			System.out.println(enhnacedviewRomSize);
			for(int i=2;i<=enhnacedviewRomSize;i++) {
				String arrivalStatus = getDriver().findElement(By.xpath("(//div[@class='mat-list-item-content'])["+i+"]//div[@class='arrival-hdn departure']//div[@class='arr-status']")).getAttribute("textContent").trim();
				System.out.println("cycle"+i);
				if(!arrivalStatus.equalsIgnoreCase("OFF")){

					WebElement wb = getDriver().findElement(By.xpath(
							"(//div[@class='mat-list-item-content'])[" + i + "]//div[@class='uplline-info flex-inline']"));
					String attribute = wb.getAttribute("textContent");
					String flightNumber = attribute.substring(4, 8).trim();
					System.out.println("flightNumber "+flightNumber);
					Thread.sleep(3000);
					WebElement notesIcon = getDriver()
							.findElement(By.xpath("(//div[@class='mat-list-item-content'])["+ i +"]//img[(contains(@src,'notes'))]"));
					Actions actions = new Actions(getDriver());
					actions.moveToElement(notesIcon);
					notesIcon.click();
					// clickByXpath("(//div[@class='mat-list-item-content'])[2]//img[(contains(@src,'notes-black'))]","notesIconClick");
					WebElement wb1 = getDriver().findElement(By.xpath("//textarea[@placeholder='NOTES']"));
					clickByXpath("" + wb1 + "", "notesTextAreaClick");
					String notesEntered = "Notes123" + Calendar.getInstance().getTime();
					System.out.println(notesEntered);
					wb1.sendKeys(notesEntered);
					clickByXpath("//div[@class='create-notes']", "createNotesClick");
					Thread.sleep(1000);
					clickByXpath("//span[@class='mat-button-wrapper']", "classicbuttonClick");
					Thread.sleep(5000);
					int getNG_activeDiversionscount = getDriver().findElements(By.xpath("//tr[@class='mat-row cdk-row ng-star-inserted']")).size();
					System.out.println("getNG_activeDiversionscount"+getNG_activeDiversionscount);
					for (int j = 1; j <= getNG_activeDiversionscount; j++) {
						WebElement flightsRowsInClassicView = getDriver().findElement(By.xpath("//tr[@class='mat-row cdk-row ng-star-inserted']["+j+ "]/td[contains(@class,'dvr-flt-num flt-num')]/div"));
						String fltnumclassic = flightsRowsInClassicView.getAttribute("textContent");
						String flightNumber_classic = fltnumclassic.substring(1, 5).trim();	
						System.out.println(flightNumber + flightNumber_classic);
						if(flightNumber.equalsIgnoreCase(flightNumber_classic)) {
							WebElement classicFlightRows=getDriver().findElement(By.xpath("//tr[@class='mat-row cdk-row ng-star-inserted']["+j+"]"));
							String flightNum = classicFlightRows.findElement(By.xpath("td[2]")).getAttribute("textContent");
							System.out.println(flightNum);
							String classicViewFlightStatus= classicFlightRows.findElement(By.xpath("td[contains(@class,'column-STS')]")).getAttribute("textContent").trim();
							System.out.println(classicViewFlightStatus);
							getDriver().findElement(By.xpath("//tr[@class='mat-row cdk-row ng-star-inserted']["+j+"]//td[contains(@class,'column-RMKS')]")).click();
							clickByXpath("//div[contains(text(),'NOTES')]", "notestabclick");								
							int classicNotesSize = getDriver().findElements(By.xpath("//td[@class='mat-cell cdk-cell cdk-column-REMARKS mat-column-REMARKS ng-star-inserted']")).size();
							System.out.println(classicNotesSize);
							String notesTabContent = getDriver().findElement(By.xpath("(//td[@class='mat-cell cdk-cell cdk-column-REMARKS mat-column-REMARKS ng-star-inserted'])["+classicNotesSize+"]")).getAttribute("textContent");
							System.out.println(notesTabContent.trim()+" "+notesEntered);
							if(notesTabContent.contains(notesEntered)) {

								System.out.println("Entered notes in enhanced view matches the remarks in classic view notes hence tc passed");
							}else {
								System.out.println("Entered notes in enhanced view does not match the remarks in classic view notes hence tc failed");
							}
							clickByXpath("//span[@class='material-icons']", "closeRortPopUpInClassicView");
							clickByXpath("//a[contains(text(),' Enhanced ')]", "enhancedBtnClick");
							Thread.sleep(3000);

						}
					}
					break;
				}
			} 
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void divReport_compareFltNumOfEnhancedviewVsClassicViewWithoutIncludingSwim() throws Exception {
		// Thread.sleep(3000);
		// getDriver().findElement(By.xpath("//mat-icon[@mattooltip='Live Data, click to
		// view Mock Data']")).click();
		Thread.sleep(5000);
		clickByXpath("//div[@class='mat-checkbox-inner-container']", "includeSwimDeselect");
		List<String> l1 = new ArrayList<>();
		List<String> l2 = new ArrayList<>();
		int totalRowsInDiversion = getDriver().findElements(By.xpath("//div[@class='mat-list-item-content']")).size();
		for (int i = 2; i <= totalRowsInDiversion; i++) {
			WebElement wb = getDriver().findElement(By.xpath(
					"(//div[@class='mat-list-item-content'])[" + i + "]//div[@class='uplline-info flex-inline']"));
			String attribute = wb.getAttribute("textContent");
			String flightNumber = attribute.substring(4, 8).trim();
			l1.add(flightNumber);
			System.out.println("Flight# is" + attribute + "Attribute lenghth is " + attribute.length()
			+ "substring value is " + attribute.substring(4, 8));
		}
		Collections.sort(l1);
		System.out.println("List of Flights number are" + l1.toString());
		clickByXpath("//span[@class='mat-button-wrapper']", "classicbuttonClick");
		Thread.sleep(5000);
		int totalRowsInClassicView = getDriver()
				.findElements(By.xpath("//tr[@class='mat-row cdk-row ng-star-inserted']")).size();
		System.out.println("totalRowsInClassicView" + totalRowsInClassicView);
		for (int j = 1; j <= totalRowsInClassicView; j++) {
			WebElement wb = getDriver().findElement(By.xpath("//tr[@class='mat-row cdk-row ng-star-inserted'][" + j
					+ "]/td[contains(@class,'dvr-flt-num flt-num')]/div"));
			String attribute = wb.getAttribute("textContent");
			String flightNumber_classic = attribute.substring(1, 5).trim();
			l2.add(flightNumber_classic);
			Collections.sort(l2);
		}
		System.out.println("List of Flights number in classic view are" + l2.toString());
		for (String s1 : l1)
			if (l2.contains(s1)) {
				System.out.println("Flight # " + s1 + "in Enhanced view is present in classic view");
			} else {
				System.out.println("Flight # " + s1 + "in Enhanced view is not present in classic view");
			}
		clickByXpath("//a[@class='divrsnlink ng-star-inserted']", "enhancedButtonClick");
	}

	public static void accessForClassicViewInDiversionReport() {
		if (API_commonActions.stationOffsetAccessForClassicViewInDiversionReport().contains("890833")) {
			if (getDriver().findElement(By.xpath("//div[@class='mat-ripple mat-button-ripple']")).isDisplayed())
				System.out.println("TC passed as for Access5User displays view for classic");
		} else {
			System.out.println("TC Not passed as for Access5User does not displays view for classic");
		}
	}

	public static void divReport_wideBodyIconVerification() throws Exception {
		int totalRowsInDiversion = getDriver().findElements(By.xpath("//div[@class='mat-list-item-content']")).size();
		System.out.println("totalRowsInDiversion"+totalRowsInDiversion);
		Thread.sleep(2000);
		System.out.println("reached diversion report java class"+API_commonActions.getRequiredFieldPathAsInteger("array.size()"));
		int totalFlightsnumbersInApi = API_commonActions.getRequiredFieldPathAsInteger("array.size()");
		System.out.println("totalFlightsnumbersInApi" +totalFlightsnumbersInApi);
		String apivalue_isWideBody;
		//below lines required for navigating through getng and switching to  destination station
		/*clickByXpath("//li[@title='Diversion report']/a", "diversionReportIconClick");
		getDriver().switchTo().frame(0);
		Thread.sleep(2000);
		divReport_NavigatingToDestinationStation();*/
		/*getDriver().findElement(By.xpath("//mat-icon[@mattooltip='Live Data, click to view Mock Data']")).click();*/
		//	Thread.sleep(3000);
		/*int totalRowsInDiversion = getDriver().findElements(By.xpath("//div[@class='mat-list-item-content']")).size();
		System.out.println("totalRowsInDiversion"+totalRowsInDiversion);*/
		for (int j = 0; j < totalFlightsnumbersInApi; j++) {
			apivalue_isWideBody = API_commonActions
					.getRequiredFieldPathAsString("flifo[" + j + "].addlFlightData[0].isWideBody");
			System.out.println("apivalue_isWideBody"+apivalue_isWideBody);
			if (apivalue_isWideBody.trim().equalsIgnoreCase("true")) {
				String apiFlightnum = API_commonActions
						.getRequiredFieldPathAsString("flifo[" + j + "].flight[1].fltNum");
				for (int i = 2; i <= totalRowsInDiversion; i++) {
					WebElement wb = getDriver().findElement(By.xpath("(//div[@class='mat-list-item-content'])[" + i
							+ "]//div[@class='uplline-info flex-inline']"));
					String attribute = wb.getAttribute("textContent");
					String flightNumber = attribute.substring(4, 8).trim();
					if (apiFlightnum.trim().contains(flightNumber)) {
						boolean isWideBodyIconPresent = getDriver().findElement(By.xpath(
								"(//div[@class='mat-list-item-content'])[" + i + "]//img[@mattooltip='Widebody']"))
								.isDisplayed();
						if (Boolean.toString(isWideBodyIconPresent).equalsIgnoreCase(apivalue_isWideBody)) {
							System.out.println("For Flight "+apiFlightnum+" Wide Body Icon is Present and hence tc passed");
						} else {
							System.out.println("For Flight "+apiFlightnum+" Wide Body Icon is NOT Present and hence tc passed");
						}
					}
				}
			} else {
				if (apivalue_isWideBody.equalsIgnoreCase("false")) {
					String apiFlightnum = API_commonActions
							.getRequiredFieldPathAsString("flifo[" + j + "].flight[1].fltNum");
					for (int i = 2; i <= totalRowsInDiversion; i++) {
						WebElement wb = getDriver().findElement(By.xpath("(//div[@class='mat-list-item-content'])[" + i
								+ "]//div[@class='uplline-info flex-inline']"));
						String attribute = wb.getAttribute("textContent");
						String flightNumber = attribute.substring(4, 8).trim();
						if (apiFlightnum.contains(flightNumber)) {
							if(getDriver().findElements(By.xpath(
									"(//div[@class='mat-list-item-content'])[" + i + "]//img[@mattooltip='Widebody']")).size()==0) {
								System.out.println("For Flight "+apiFlightnum+" Wide Body Icon is NOT Present and hence tc passed");
							} else {
								System.out.println("For Flight "+apiFlightnum+" Wide Body Icon is Present and hence tc failed");
							}
						}
					}
				}
			}
		}
	}

	public static void divReport_InternationalFlagVerfication() throws Exception {
		int totalFlightsnumbersInApi = API_commonActions.getRequiredFieldPathAsInteger("array.size()");
		String apivalue_IntOrDom;
		String intOrDom = "I";
		/*clickByXpath("//li[@title='Diversion report']/a", "diversionReportIconClick");
		getDriver().switchTo().frame(0);
		Thread.sleep(2000);
		getDriver().findElement(By.xpath("//mat-icon[@mattooltip='Live Data, click to view Mock Data']")).click();
		Thread.sleep(3000);*/
		int totalRowsInDiversion = getDriver().findElements(By.xpath("//div[@class='mat-list-item-content']")).size();
		for (int j = 0; j < totalFlightsnumbersInApi; j++) {
			apivalue_IntOrDom = API_commonActions.getRequiredFieldPathAsString("flifo[" + j + "].flight[1].intOrDom");

			if (apivalue_IntOrDom.equalsIgnoreCase("I")) {
				System.out.println("apivalue_IntOrDom - "+apivalue_IntOrDom);
				String apiFlightnum = API_commonActions
						.getRequiredFieldPathAsString("flifo[" + j + "].flight[1].fltNum");
				for (int i = 2; i <= totalRowsInDiversion; i++) {
					WebElement wb = getDriver().findElement(By.xpath("(//div[@class='mat-list-item-content'])[" + i
							+ "]//div[@class='uplline-info flex-inline']"));
					String attribute = wb.getAttribute("textContent");
					String flightNumber = attribute.substring(4, 8).trim();
					System.out.println("apiFlightnum - "+apiFlightnum+"flightNumber"+flightNumber);
					if (apiFlightnum.contains(flightNumber)) {
						if(getDriver().findElements(By.xpath(
								"(//div[@class='mat-list-item-content'])[" + i + "]//img[@mattooltip='International']")).size()!=0) {
							System.out.println("For Flight - "+apiFlightnum+" Internation Icon is Present and hence tc passed");
						} else {
							System.out.println("For Flight - "+apiFlightnum+" Internation Icon is Not Present and hence tc not passed");
						}
					}
				}
			} else {
				if (!apivalue_IntOrDom.equalsIgnoreCase("I")) {
					String apiFlightnum = API_commonActions
							.getRequiredFieldPathAsString("flifo[" + j + "].flight[1].fltNum");
					for (int i = 2; i <= totalRowsInDiversion; i++) {
						WebElement wb = getDriver().findElement(By.xpath("(//div[@class='mat-list-item-content'])[" + i
								+ "]//div[@class='uplline-info flex-inline']"));
						String attribute = wb.getAttribute("textContent");
						String flightNumber = attribute.substring(4, 8).trim();
						if (apiFlightnum.contains(flightNumber)) {
							if(getDriver().findElements(By.xpath(
									"(//div[@class='mat-list-item-content'])[" + i + "]//img[@mattooltip='International']")).size()==0) {
								System.out.println("For Flight - "+apiFlightnum+" Internation Icon is NOT Present and hence tc passed");
							} else {
								System.out.println("For Flight - "+apiFlightnum+" Internation Icon is Present and hence tc passed");
							}
						}
					}
				}
			}
		}
	}
	public static void verifySaveBtnDisabledForOFFFLightsAndEnabledForOtherStatusInClassicView() throws Exception{
		clickByXpath("//button/span[text()='Classic']", "classicbuttonClick");
		Thread.sleep(5000);
		//	int i=1;

		int getNG_ClassicFlightStatusCount = getDriver().findElements(By.xpath("//tr[@class='mat-row cdk-row ng-star-inserted']")).size();
		System.out.println(getNG_ClassicFlightStatusCount);
		for(int i=1;i<=getNG_ClassicFlightStatusCount;i++) {
			WebElement classicFlightRows=getDriver().findElement(By.xpath("//tr[@class='mat-row cdk-row ng-star-inserted']["+i+"]"));
			String flightNum = classicFlightRows.findElement(By.xpath("td[2]")).getAttribute("textContent");
			System.out.println(flightNum);
			String classicViewFlightStatus= classicFlightRows.findElement(By.xpath("td[contains(@class,'column-STS')]")).getAttribute("textContent").trim();
			System.out.println(classicViewFlightStatus);
			classicFlightRows.findElement(By.xpath("td[contains(@class,'column-RMKS')]")).click();
			if(classicViewFlightStatus.equals("OFF")) {
				//classicFlightRows.findElement(By.xpath("td[contains(@class,'column-RMKS active-flt')]")).click();
				//getDriver().findElement(By.xpath("//textarea[contains(@class,'txt-remarks')]")).click();
				Thread.sleep(1000);
				getDriver().findElement(By.xpath("//textarea[contains(@class,'txt-remarks')]")).sendKeys("classic Remarks");
				boolean b1=getDriver().findElement(By.xpath("//div[@class='btn-station-remarks']//span[text()='SAVE']")).isEnabled();
				System.out.println(b1);
				if((getDriver().findElements(By.xpath("//div[@class='btn-station-remarks']/button[@disabled='true']")).size()!=0))					
				{
					System.out.println("For "+flightNum+" with status "+classicViewFlightStatus+" save Button is disabled and hence tc passed");		
				}else{

					System.out.println("For "+flightNum+" with status "+classicViewFlightStatus+" Save Button must be disabled but it is enabled and hence tc failed");
				}
				Thread.sleep(1000);
				getDriver().findElement(By.xpath("//span[@class='material-icons']")).click();

			}else {
				if((getDriver().findElements(By.xpath("//div[@class='btn-station-remarks']/button[@disabled='true']")).size()==0))
				{
					System.out.println("For "+flightNum+" Save  Button is enabled hence Pass");
				}else{
					System.out.println("For "+flightNum+" save Button is disabled hence fail");	
				}
				Thread.sleep(1000);
				getDriver().findElement(By.xpath("//span[@class='material-icons']")).click();

			}
		}

	}

	public static void verifyPETActions() throws Exception{
		/*clickByXpath("//span[@class='mat-button-wrapper']", "classicbuttonClick");
		String diversionStation=getDriver().findElement(By.xpath("((//div[@class='stats'])[2]//div[@class='stn-list ng-star-inserted'])[1]")).getAttribute("textContent").substring(1, 4).trim();
		getDriver().switchTo().parentFrame();
		clickByXpath("//span[@class='close-icn']", "closeDiversionReport");
		CustomZone.SelectStation(diversionStation);
		Thread.sleep(2000);
		clickByXpath("//li[@title='Diversion report']/a", "diversionReportIconClick");
		Thread.sleep(3000);
		getDriver().switchTo().frame(0);
		clickByXpath("//button[@id='mat-button-toggle-2-button']/div", "localButtonClick");
		Thread.sleep(2000);*/
		int totalRowsInDiversion = getDriver().findElements(By.xpath("//div[@class='mat-list-item-content']")).size();
		for (int i = 2; i <= totalRowsInDiversion; i++) {
			if((getDriver().findElement(By.xpath("(//div[@class='arr-status'])[1]"))).getAttribute("textContent").trim().equalsIgnoreCase("IN")&&!(getDriver().findElement(By.xpath("(//div[@class='arr-status'])[1]"))).getAttribute("textContent").trim().equalsIgnoreCase("OFF")) {
				clickByXpath("(//div[@class='mat-list-item-content'])["+i+"]//div[@class='pet-main-div']/img", "pet icon click");
				Thread.sleep(1000);	
				//WebElement petmenu = getDriver().findElement(By.xpath("//button[@class='mat-focus-indicator mat-menu-trigger menu-text mat-menu-item mat-menu-item-submenu-trigger ng-tns-c112-43 mat-menu-item-highlighted']/div"));
				Actions action = new Actions(getDriver());
				action.moveToElement(getDriver().findElement(By.xpath("(//div[contains(@class,'mat-menu-content')]/button)[1]"))).build().perform();
				action.click(getDriver().findElement(By.xpath("(//div[contains(@class,'mat-menu-content')]/button)[1]")));
				Thread.sleep(1000);
				WebElement resetMenu = getDriver().findElement(By.xpath("(//div[contains(@class,'mat-menu-content')]/button)[4]"));
				action.moveToElement(resetMenu).build().perform();
				Thread.sleep(1000);
				clickByXpath("(//div[contains(@class,'mat-menu-content')]/button)[4]", "reset menu click");
				Thread.sleep(1000);
				getDriver().navigate().refresh();
				Thread.sleep(3000);
				/*	getDriver().switchTo().parentFrame();
		Thread.sleep(3000);
		clickByXpath("//li[@title='Diversion report']/a", "diversionReportIconClick");
		Thread.sleep(3000);
		getDriver().switchTo().frame(0);
		clickByXpath("//button[@id='mat-button-toggle-2-button']/div", "localButtonClick");
		Thread.sleep(1000);*/
				if((getDriver().findElements(By.xpath("((//div[@class='mat-list-item-content'])[2]//div[@class='pet-main-div']/span)[2]")).size()==0)){
					System.out.println("Span two elemtn not present");
					Thread.sleep(60000);
					getDriver().navigate().refresh();
					Thread.sleep(5000);
					if((getDriver().findElements(By.xpath("((//div[@class='mat-list-item-content'])[2]//div[@class='pet-main-div']/span)[1]")).size()!=0)){

						System.out.println("Span one elemtn is present on reset");
						clickByXpath("(//div[@class='mat-list-item-content'])["+i+"]//div[@class='pet-main-div']/img", "pet icon click");
						Thread.sleep(2000);
						clickByXpath("(//div[contains(@class,'mat-menu-content')]/button)[1]", "pet menu click");
						Thread.sleep(2000);
						clickByXpath("(//div[contains(@class,'mat-menu-content')]/button)[3]", "stop menu click");
						Thread.sleep(1000);
						String valueBeforeStopPetAction=getDriver().findElement(By.xpath("((//div[@class='mat-list-item-content'])[2]//div[@class='pet-main-div']/span)[1]")).getAttribute("textContent");
						System.out.println("valueBeforeStopPetAction"+valueBeforeStopPetAction);
						Thread.sleep(60000);
						getDriver().navigate().refresh();
						Thread.sleep(10000);
						String valueafterStopPetAction=getDriver().findElement(By.xpath("((//div[@class='mat-list-item-content'])[2]//div[@class='pet-main-div']/span)[1]")).getAttribute("textContent");
						System.out.println("valueafterStopPetAction"+valueafterStopPetAction);
						if(valueBeforeStopPetAction.equalsIgnoreCase(valueafterStopPetAction)) {
							System.out.println("PET stop acton working as expected and hence TC passed");	
							clickByXpath("(//div[@class='mat-list-item-content'])["+i+"]//div[@class='pet-main-div']/img", "pet icon click");
							Thread.sleep(2000);
							clickByXpath("(//div[contains(@class,'mat-menu-content')]/button)[1]", "pet menu click");
							Thread.sleep(2000);
							clickByXpath("(//div[contains(@class,'mat-menu-content')]/button)[2]", "start menu click");
							Thread.sleep(60000);
							getDriver().navigate().refresh();
							Thread.sleep(5000);
							String valueafterStartPetAction=getDriver().findElement(By.xpath("((//div[@class='mat-list-item-content'])[2]//div[@class='pet-main-div']/span)[1]")).getAttribute("textContent");
							System.out.println("valueafterStartPetAction"+valueafterStartPetAction);
							if(Integer.parseInt(String.valueOf(valueafterStartPetAction.charAt(1)))>Integer.parseInt(String.valueOf(valueafterStopPetAction.charAt(1)))) {
								System.out.println("PET start acton working as expected and hence TC passed");	
							}

						}else {
							System.out.println("PET start acton not working as expected and hence TC failed");
						}
						break;

					}else {
						System.out.println("Span one elemtn is not present on reset and hence tc failed");
					}
				}else {
					System.out.println(getDriver().findElements(By.xpath("((//div[@class='mat-list-item-content'])[2]//div[@class='pet-main-div']/span)[2]")).toString());
				}
			}
			else {

			}
		}
	}
	public static void petDisabledForOffStatusFlights() throws Exception {
		clickByXpath("//span[@class='mat-button-wrapper']", "classicbuttonClick");
		String diversionStation=getDriver().findElement(By.xpath("((//div[@class='stats'])[2]//div[@class='stn-list ng-star-inserted'])[1]")).getAttribute("textContent").substring(1, 4).trim();
		getDriver().switchTo().parentFrame();
		clickByXpath("//span[@class='close-icn']", "closeDiversionReport");
		CustomZone.SelectStation(diversionStation);
		Thread.sleep(2000);
		clickByXpath("//li[@title='Diversion report']/a", "diversionReportIconClick");
		Thread.sleep(3000);
		getDriver().switchTo().frame(0);
		clickByXpath("//button[@id='mat-button-toggle-2-button']/div", "localButtonClick");
		Thread.sleep(2000);
		String destFltStatus=getDriver().findElement(By.xpath("(//div[@class='arr-status'])[2]")).getAttribute("textContent").trim();
		System.out.println(destFltStatus);
		if(destFltStatus.equalsIgnoreCase("OFF")) {
			Thread.sleep(1000);
			clickByXpath("//div[@class='pet-main-div']/img", "pet icon click");
			Thread.sleep(1000);	
			Actions action = new Actions(getDriver());
			action.moveToElement(getDriver().findElement(By.xpath("(//div[contains(@class,'mat-menu-content')]/button)[1]"))).build().perform();
			action.click(getDriver().findElement(By.xpath("(//div[contains(@class,'mat-menu-content')]/button)[1]")));
			Thread.sleep(1000);
			if(getDriver().findElement(By.xpath("(//div[contains(@class,'mat-menu-content')]/button)[4]")).isEnabled()) {
				System.out.println("Pet actions enabled for OffFlight status hence fail");
			}else {
				System.out.println("Pet actions disabled  for OffFlight status hence pass");
			}

		}
	}

	public static void verifyGanttViewInLocal() throws Exception {
		clickByXpath("//span[@class='mat-button-wrapper']", "classicbuttonClick");
		String diversionStation=getDriver().findElement(By.xpath("((//div[@class='stats'])[2]//div[@class='stn-list ng-star-inserted'])[1]")).getAttribute("textContent").substring(1, 4).trim();
		getDriver().switchTo().parentFrame();
		clickByXpath("//span[@class='close-icn']", "closeDiversionReport");
		CustomZone.SelectStation(diversionStation);
		Thread.sleep(2000);
		clickByXpath("//li[@title='Diversion report']/a", "diversionReportIconClick");
		Thread.sleep(3000);
		getDriver().switchTo().frame(0);
		clickByXpath("//button[@id='mat-button-toggle-2-button']/div", "localButtonClick");
		Thread.sleep(2000);
		if(getDriver().findElement(By.xpath("//a[@title='Gantt View']")).isDisplayed()) {
			System.out.println("Gantt View icon available for Local button and hence Pass");	
		}else {
			System.out.println("Some issue in Gantt View display for Local button and hence fail");		
		}
	}
	public static void retrievingDataFromGetNGClassic() throws Exception {
		DiversonReport.divReport_IsDisplayed();
		Thread.sleep(2000);
		clickByXpath("//span[@class='mat-button-wrapper']", "classicbuttonClick");
		Thread.sleep(10000);
		int getNG_activeDiversionscount = getDriver().findElements(By.xpath("//tr[@class='mat-row cdk-row ng-star-inserted']")).size();

		for (int i = 1; i <= getNG_activeDiversionscount; i++) {
			StringBuilder stringBuilder = new StringBuilder();
			for(int xpathCount = 1; xpathCount <= 41; xpathCount++) {
				if(xpathCount==29) {
					xpathCount++;
				}
				getDriverDetails(stringBuilder, i, xpathCount);
			}
			getNG_flightNumbersList.add(stringBuilder.toString());
		}
		System.out.println(getNG_flightNumbersList);
	}
	public static void getDriverDetails(StringBuilder stringBuilder, int i, int xpathCount) {
		stringBuilder.append(getDriver().findElement(
				By.xpath("//tr[@class='mat-row cdk-row ng-star-inserted'][" + i + "]/td[" + (xpathCount) + "]"))
				.getAttribute("textContent").trim()).append((xpathCount <41 ? "~" : ""));
	}
}
