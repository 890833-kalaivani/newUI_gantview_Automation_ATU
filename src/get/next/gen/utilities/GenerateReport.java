package get.next.gen.utilities;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import get.next.gen.commonaction.CommonTest;
import get.next.gen.webtestcase.Web_UI;
import scala.concurrent.forkjoin.ThreadLocalRandom;

public class GenerateReport extends CommonTest {
	public static Actions action = new Actions(getDriver());
	public static String flightNotes="";
	public static String tailNotes="";
	public static String firstPuckid;

	public static void clickPuckForEventSlideOut() throws Exception {
		//Actions action = new Actions(getDriver());
		clickByXpath("//div[@title='choose font size']/div[1]","fitToScreen");
		Thread.sleep(2000);
		//clickByXpath("//div[@title='choose font size']/div[2]","minFontSize");
		//Thread.sleep(2000);
		/*clickByXpath(Web_UI.SortAscending,"SortAscending");
		Thread.sleep(2000);*/
		List<WebElement> Ganntlist = getDriver().findElements(By.xpath(Web_UI.PuckComplete));
		System.out.println(Ganntlist.size());
		for(WebElement firstPuck:Ganntlist) {
			firstPuckid = firstPuck.getAttribute("id");

			if(!firstPuckid.contains("UNLINKED")) {
				System.out.println("firstPuckid"+firstPuckid);
				WebElement firstPuckidclick = getDriver().findElement(By.xpath("//div[@id='"+firstPuckid+"']"));
				action.moveToElement(firstPuckidclick).build().perform();
				System.out.println("moved to first element"); 
				Thread.sleep(2000);
				firstPuckidclick.click();
				Thread.sleep(2000);
				break;
			}else {
				System.out.println("ID containg Unlinked");
			}
		}

	}
	public static void enteringFlightAndTailNotes() throws Exception {
		Thread.sleep(3000);
		getDriver().switchTo().frame("event-info");
		Thread.sleep(3000);
		getDriver().findElement(By.xpath("(//div[@class='mat-tab-label-content'])[2]")).click();
		Thread.sleep(3000);
		//getDriver().findElement(By.xpath("//input[@id='mat-radio-2-input']")).click();
		//generating random number to choose anyone value in ETD reason drop down
		int randomNum = ThreadLocalRandom.current().nextInt(1, 30);
		flightNotes = "Entering value for flightNotes_"+randomNum;
		WebElement notesTextArea = getDriver().findElement(By.xpath("//textarea[@placeholder='Add Notes']"));
		notesTextArea.sendKeys(flightNotes);
		getDriver().findElement(By.xpath("//span[@class='mat-button-wrapper']")).click();
		Thread.sleep(3000);
		//entering tails note
		getDriver().findElement(By.xpath("(//div[@class='mat-radio-label-content'])[2]")).click();
		//generating random number to choose anyone value in ETD reason drop down
		tailNotes = "Entering value for tailNotes_"+randomNum;
		notesTextArea.sendKeys(tailNotes);
		getDriver().findElement(By.xpath("//span[@class='mat-button-wrapper']")).click();
		//getDriver().switchTo().parentFrame();
	}

	public static void switchingToGenerateReportFrame() throws Exception {
		//clicking generate report menu in event slide out
		/*getDriver().findElement(By.xpath("//img[@class='note-icn ng-scope']")).click();
		getDriver().findElement(By.xpath("//div[@class='notes-opt-items']")).click();*/
		Thread.sleep(1000);
		WebElement findElement = getDriver().findElement(By.xpath("(//div[@class='slideout-header ng-star-inserted']//mat-icon)[3]"));
		Thread.sleep(1000);
		action.moveToElement(findElement).build().perform();
		findElement.click();
		//System.out.println("Switching to UpdateETD frame"+getDriver().switchTo().frame(generateReportFrame));
		Thread.sleep(2000);
	}

	public static void verifySectionsInGenerateReport()throws Exception {
		int noOfSectionInGenerateReport = getDriver().findElements(By.xpath("//app-report-summary//mat-expansion-panel")).size();
		System.out.println("noOfSectionInGenerateReport"+noOfSectionInGenerateReport);
		for(int i=1;i<=noOfSectionInGenerateReport;i++) {
			String genReportsectiontext = getDriver().findElement(By.xpath("(//app-report-summary//mat-expansion-panel)["+i+"]//mat-panel-title")).getAttribute("textContent");
			System.out.println("attribute value is "+genReportsectiontext);
			Thread.sleep(3000);
			List<String> generateReportHeaderValue = Arrays.asList("Offload","Bags","Passenger","Secondary Events","Adhoc Events","Other Turn Info","ETD History","Gate Swaps","Tail Swaps","Crew","Notes","Conversation");
			if((generateReportHeaderValue).contains(genReportsectiontext.trim())) {
				System.out.println(genReportsectiontext+" section info is present in generate report");
			}else {
				System.out.println(genReportsectiontext+" section info is NOT present in generate report");
			}
		}



	}

	public static void verifyValuesOfNotesAndSynopisInGenerateReport() throws Exception{
		//Verify Flight Notes
		System.out.println("verifyValuesOfNotesAndSynopisInGenerateReport");
		WebElement flightNotesinGenerateReport = getDriver().findElement(By.xpath("((//div[contains(@class,'tile-notes')])[1]//div[contains(@class,'notes-cntnt')])[1]//span"));
		String flightNotesInnerTextValue = flightNotesinGenerateReport.getAttribute("textContent").trim();
		System.out.println("Tail notes size value is :"+flightNotesInnerTextValue);
		if(flightNotes.equalsIgnoreCase(flightNotesInnerTextValue)) {
			System.out.println("Flight notes are same");
		}else {
			System.out.println("Flight notes are NOT same or flight notes not saved in generate report"+flightNotes+" | "+flightNotesInnerTextValue);
		}
		//verify tail notes
		System.out.println("verifyValuesOfNotesAndSynopisInGenerateReport");
		WebElement tailNotesinGenerateReport = getDriver().findElement(By.xpath("((//div[contains(@class,'tile-notes')])[2]//div[contains(@class,'notes-cntnt')])[1]//span"));
		String tailNotesInnerTextValue = tailNotesinGenerateReport.getAttribute("textContent").trim();
		System.out.println("Tail notes size value is :"+tailNotesInnerTextValue);
		if(tailNotes.equalsIgnoreCase(tailNotesInnerTextValue)) {
			System.out.println("Tail notes are same");
		}else {
			System.out.println("Tail notes are NOT same or Tail notes not saved"+tailNotes+tailNotesinGenerateReport);
		}
		//System.out.println(e1.findElement(By.xpath("div[3]/span")).getAttribute("TextContent"));
		getDriver().findElement(By.xpath("//textarea[@placeholder='Synopsis']")).sendKeys("Test123");
		getDriver().findElement(By.xpath("(//span[@class='mat-button-wrapper'])[3]")).click();
	}

	public static void printButton() throws Exception {
		boolean enabled = getDriver().findElement(By.xpath("(//div[@class='right-content ng-star-inserted'])[2]/span")).isEnabled();
		System.out.println("Button enabled"+enabled);

		getDriver().findElement(By.xpath("(//div[@class='right-content ng-star-inserted'])[1]/span")).click();
		Thread.sleep(5000);
		String[] pathnames;
		// Creates a new File instance by converting the given pathname string
		// into an abstract pathname
		String s3 = "Flight Report_"+firstPuckid.substring(0, 4)+"_"+firstPuckid.substring(5, 15)+".xlsx";
		System.out.println(s3);
		File f = new File("C:\\Users\\Testing\\Downloads");
		// Populates the array with names of files and directories
		pathnames = f.list();
		List<String> listOfFilesInsideFolder = Arrays.asList(pathnames);
		if(listOfFilesInsideFolder.contains(s3)) {
			System.out.println("File is downloaded and Export button is working");
		}else {
			System.out.println("File is NOT downloaded and Export button is NOT working");
		}
		/*// For each pathname in the pathnames array
		for (String pathname : pathnames) {
			try {
			if(pathname.contains("Flight Report")) {
				System.out.println("File is downloaded and Export button is working");
			}
			}catch(Exception e) {
				System.out.println("123");
			}
		}*/
		/*
		getDriver().findElement(By.xpath("(//div[@class='right-content ng-star-inserted'])[2]/span")).click();
		Thread.sleep(5000);
		try {
			//Switch to Print dialog
			Set<String> windowHandles = getDriver().getWindowHandles();
			if (!windowHandles.isEmpty()) {
				getDriver().switchTo().window((String) windowHandles.toArray()[windowHandles.size() - 1]);
			}
			System.out.println("trying to click cancel");
			//Now work with the dialog as with an ordinary page:  
			getDriver().findElement(By.className("cancel-button")).click();



			getDriver().switchTo().Window(getDriver().WindowHandles.Last());
			//getDriver().switchTo().window(getDriver().getWindowHandles().stream().filter(handle -> !handle.equals(getDriver().getWindowHandle())).findAny().get());
			System.out.println("Reached step 2");
		WebElement printPreviewApp = getDriver().findElement(By.xpath("//print-preview-app"));
		System.out.println("Reached step 3");
		WebElement printPreviewAppContent = (WebElement) ((JavascriptExecutor) getDriver()).executeScript("return arguments[0].shadowRoot", printPreviewApp);
		System.out.println("Reached step 4");
		WebElement printPreviewHeader = printPreviewAppContent.findElement(By.cssSelector("print-preview-header"));
		System.out.println("Reached step 5");
		WebElement printPreviewHeaderContent = (WebElement) ((JavascriptExecutor) getDriver()).executeScript("return arguments[0].shadowRoot", printPreviewHeader);
		System.out.println("Reached step 6");
		printPreviewHeaderContent.findElement(By.cssSelector("paper-button[class*=cancel]")).click();
}catch(Exception e) {

		}


		 */}
	public static void verifyGenerateReportDisplayed() throws Exception{
		//Actions action = new Actions(getDriver());
		clickByXpath("//div[@title='choose font size']/div[1]","fitToScreen");
		Thread.sleep(2000);
		clickByXpath("//div[@title='choose font size']/div[2]","minFontSize");
		Thread.sleep(2000);
		/*clickByXpath(Web_UI.SortAscending,"SortAscending");
		Thread.sleep(2000);*/
		List<WebElement> Ganntlist = getDriver().findElements(By.xpath(Web_UI.PuckComplete));
		System.out.println(Ganntlist.size());
		for(WebElement firstPuck:Ganntlist) {
			String firstPuckid = firstPuck.getAttribute("id");
			System.out.println("firstPuckid"+firstPuckid);
			WebElement firstPuckidclick = getDriver().findElement(By.xpath("//div[@id='"+firstPuckid+"']"));
			action.moveToElement(firstPuckidclick).build().perform();
			System.out.println("moved to first element"); 
			Thread.sleep(2000);
			firstPuckidclick.click();
			Thread.sleep(3000);
			getDriver().switchTo().frame("event-info");
			Thread.sleep(3000);
			getDriver().findElement(By.xpath("(//div[@class='mat-tab-label-content'])[2]")).click();
			Thread.sleep(3000);
			//getDriver().findElement(By.xpath("//input[@id='mat-radio-2-input']")).click();
			//generating random number to choose anyone value in ETD reason drop down
			int randomNum = ThreadLocalRandom.current().nextInt(1, 30);
			String s1 = "Entering value for flightNotes_"+randomNum;
			WebElement notesTextArea = getDriver().findElement(By.xpath("//textarea[@placeholder='Add Notes']"));
			notesTextArea.sendKeys(s1);
			getDriver().findElement(By.xpath("//span[@class='mat-button-wrapper']")).click();
			getDriver().switchTo().parentFrame();
			//clicking generate report menu in event slide out
			getDriver().findElement(By.xpath("//img[@class='note-icn ng-scope']")).click();
			getDriver().findElement(By.xpath("//div[@class='notes-opt-items']")).click();
			Thread.sleep(3000);
			WebElement generateReportFrame = getDriver().findElement(By.id("generate-report-frame"));
			System.out.println("Switching to UpdateETD frame"+getDriver().switchTo().frame(generateReportFrame));
			Thread.sleep(3000);
			String attribute = getDriver().findElement(By.xpath("(//app-report-summary//mat-expansion-panel)[1]//mat-panel-title")).getAttribute("textContent");
			System.out.println("attribute value is "+attribute);
			Thread.sleep(3000);
			List<String> generateReportHeaderValue = new ArrayList<>();
			generateReportHeaderValue.add(attribute);
			System.out.println(generateReportHeaderValue.get(0));
			/*List<WebElement> flightNotesinGenerateReport = getDriver().findElements(By.xpath("//span[contains(text(),'By Flight')]/ancestor::div/following-sibling::app-notes-tile//div[@class='notes-list ng-star-inserted']"));
			Thread.sleep(3000);
			int size = flightNotesinGenerateReport.size();
			System.out.println("Flight notes size value is :"+size);
			for(WebElement e1:flightNotesinGenerateReport) {
				action.moveToElement(e1).build().perform();
				//System.out.println(e1.findElement(By.xpath("div[3]/span")).getAttribute("TextContent"));

				getDriver().findElement(By.xpath("//textarea[@placeholder='Synopsis']")).sendKeys("Test123");
				getDriver().findElement(By.xpath("(//span[@class='mat-button-wrapper'])[3]")).click();

			}*/
		}
	}
	public static void enteringNotes() {
		//Actions action = new Actions(getDriver());
		getDriver().findElement(By.xpath("(//div[@class='mat-tab-label-content'])[2]")).click();
		getDriver().findElement(By.xpath("//input[@id='mat-radio-2-input']")).click();
		//generating random number to choose anyone value in ETD reason drop down
		int randomNum = ThreadLocalRandom.current().nextInt(1, 30);
		String s1 = "Entering value for flightNotes_"+randomNum;
		WebElement notesTextArea = getDriver().findElement(By.xpath("//textarea[@placeholder='Add Notes']"));
		notesTextArea.sendKeys(s1);
		getDriver().findElement(By.xpath("//span[@class='mat-button-wrapper']")).click();
		//entering tails note
		getDriver().findElement(By.xpath("//input[@id='mat-radio-3-input']")).click();
		//generating random number to choose anyone value in ETD reason drop down
		String s2 = "Entering value for tailNotes_"+randomNum;
		notesTextArea.sendKeys(s2);
		getDriver().findElement(By.xpath("//span[@class='mat-button-wrapper']")).click();


	}

}
