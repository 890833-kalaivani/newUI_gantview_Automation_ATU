package get.next.gen.utilities;

import get.next.gen.commonaction.CommonTest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import get.next.gen.commonaction.CompareExcel;
import get.next.gen.webtestcase.*;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import atu.testng.reports.ATUReports;
import atu.testng.reports.logging.LogAs;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import atu.testng.reports.listeners.ATUReportsListener;
import atu.testng.reports.listeners.ConfigurationListener;
import atu.testng.reports.listeners.MethodListener;
@Listeners({ ATUReportsListener.class, ConfigurationListener.class,
MethodListener.class })

//

public class SearchValidation extends CommonTest {
	

	public static void SearchWithValidSearchkey(String view) throws Exception {
		TestcaseInit();
		System.out.println("Verify the user performs search with valid search key");
		CommonTest.SpinnerControl();
		try{
			Selectview(view);
			clickByXpathbyView(view, Web_UI.TotalGate, Web_UI.HybridAllGate);
	
			System.out.println("Validating Gantt Search Functionality");
			Pattern pattern;
			GanntViewHeaderFunctionality.SpinnerControl();	 
			clickByXpath(Web_UI.SortAscending,"SortAscending");
			Thread.sleep(1000);
			// Select Sort Ascending gate by alphabetical order from dropdown
			clickByXpath(Web_UI.SortAscendinggate,"SortAscendinggate");
			Thread.sleep(1000);
			List<WebElement> Ganntlist = getDriver().findElements(By.xpath(Web_UI.PuckComplete));
			int Ganntlistcount = Ganntlist.size();
			if (Ganntlist != null) {
				for (WebElement gantelement : Ganntlist) {
					String elementid = gantelement.getAttribute("id");
					String elementtosearch = elementid.substring(0, 4);
					Thread.sleep(2000);
					SendtextbyXpath(Web_UI.Searchbar, elementtosearch);
					Thread.sleep(2000);
					//Replace with Enter Key
					clickByXpath(Web_UI.Searchiconfilter,"search");
					
					
					Thread.sleep(3000);
					Actions actions = new Actions(getDriver());

					WebElement Fli = getDriver().findElement(By.id(elementid));
					actions.moveToElement(Fli);
					if (Fli != null) {
							ATUReports.add("Search Results displayed",  LogAs.PASSED, null);
					} else {
						ATUReports.add("Search Results not displayed",  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						captureinfoScreenshot(getDriver(),"Search Results not displayed");
						
					}

					findelementbyxpath(Web_UI.Searchbar).clear();
					clickByXpath(Web_UI.Searchiconfilter,"search");
					ATUReports.add("Search result Cleared",  LogAs.PASSED, null);
		Thread.sleep(3000);
		break;
			}
				
				
			} else {
				ATUReports.add("Gantt View not displayed or Error in page",  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				captureinfoScreenshot(getDriver(),"SearchGantt View not displayed or Error in page");
					findelementbyxpath(Web_UI.Searchbar).clear();
					
			}

			
		}
		catch(Exception Totalgatenotselected){
			CommonTest.CheckOKPopupPresentandclose();
			CommonTest.CheckCancelPopupPresentandclose();
			Checkappupdateclosebutton();
			
		}	
	}

	public static void SearchWithINValidSearchkey(String view) throws Exception {	

		System.out.println("Verify the user performs search with Invalid search key");
		TestcaseInit();
		GanntViewHeaderFunctionality.GanntViewSelection();
		CommonTest.SpinnerControl();
		try{
			Selectview(view);
			clickByXpathbyView(view, Web_UI.TotalGate, Web_UI.HybridAllGate);
			System.out.println("Validating Gantt Search Functionality by entering Invalid Search Key");
		GanntViewHeaderFunctionality.SpinnerControl();	 
		clickByXpath(Web_UI.SortAscending,"SortAscending");
		Thread.sleep(1000);
		// Select Sort Ascending gate by alphabetical order from dropdown
		clickByXpath(Web_UI.SortAscendinggate,"SortAscendinggate");
		Thread.sleep(1000);
		List<WebElement> Ganntlist = getDriver().findElements(By.xpath(Web_UI.GanttTable));
		int Ganntlistcount = Ganntlist.size();
		if (Ganntlist != null) {
			for (WebElement gantelement : Ganntlist) {
				String InvalidSearchKey = "LJSKHALK";
				SendtextbyXpath(Web_UI.Searchbar, InvalidSearchKey);
				Thread.sleep(2000);
				clickByXpath(Web_UI.Searchiconfilter,"search");
				Thread.sleep(3000);
				String Verifytext1 = "no flight";
				String pulltext1 = getDriver().findElement(By.xpath(Web_UI.NoSearchresult)).getAttribute("innerText").trim();
				if (pulltext1.contains(Verifytext1)) {
					ATUReports.add("search result  displayed with Proper Message",  LogAs.PASSED, null);
				} else {
					System.out.println("Error message is not Displayed");
					ATUReports.add("Error message is not Displayed",  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									
				}

				findelementbyxpath(Web_UI.Searchbar).clear();
				clickByXpath(Web_UI.Searchiconfilter,"search");
				ATUReports.add("Search result Cleared",  LogAs.PASSED, null);
				Thread.sleep(3000);
	
				break;
		}
			
			
		} else {
			ATUReports.add("Gantt View not displayed or Error in page",  LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			findelementbyxpath(Web_UI.Searchbar).clear();
		}

		
		}
		catch(Exception Totalgatenotselected){
			CommonTest.CheckOKPopupPresentandclose();
			CommonTest.CheckCancelPopupPresentandclose();
			Checkappupdateclosebutton();
			ATUReports.add("Couldnot able to select Total gate",  LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		}

	
	}
		
		
}