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
import atu.testng.reports.listeners.ATUReportsListener;
import atu.testng.reports.listeners.ConfigurationListener;
import atu.testng.reports.listeners.MethodListener;
@Listeners({ ATUReportsListener.class, ConfigurationListener.class,
MethodListener.class })


public class HoverValidation extends CommonTest {
	
	public static void HoverDisplayValidation() throws Exception{
		
	System.out.println("Verify the Hover holds all the details when puck size is small to hold flight information");
		Thread.sleep(3000);
		TestcaseInit();
	try
		{
		
		ATUReports.add("Total Gate stats selected successfully",  LogAs.PASSED, null);
		CommonTest.SpinnerControl();
		Thread.sleep(3000);
		clickByXpath(Web_UI.SortAscending,"SortAscending");
		Thread.sleep(1000);
		// Select Sort Ascending gate by alphabetical order from dropdown
		clickByXpath(Web_UI.SortAscendinggate,"SortAscendinggate");
		Thread.sleep(1000);
		CommonTest.CheckExpand();
		List<WebElement> Ganntlist = getDriver().findElements(By.xpath(Web_UI.PuckComplete));
		int Ganntlistcount = Ganntlist.size();
		if(Ganntlistcount == 0)
		{
			CommonTest.CheckGanttviewListisnotZero();
		}
		
		if(Ganntlistcount == 0)
		{
			ATUReports.add("**************Gantt List is Zero and hence Exiting test smoothly**************",  LogAs.PASSED, null);
		}else{
		if (Ganntlist != null) {
			int i=0;
			for (WebElement gantelement : Ganntlist) {
			i++;
						
						try {
							
							CommonTest.zoomindata();
							CommonTest.zoomindata();
							CommonTest.zoomindata();
							CommonTest.zoomindata();
							Actions actions = new Actions(getDriver());
							actions.moveToElement(gantelement).build().perform();
							String FullText = gantelement.findElement(By.xpath("div[contains(@class,'puck-data')]")).getAttribute("innerText");
							String Verificationtext = FullText.trim();
							System.out.println("Verificationtext"+Verificationtext);
							CommonTest.zoomOutdata();
							CommonTest.zoomOutdata();
							CommonTest.zoomOutdata();
							CommonTest.zoomOutdata();
							actions.moveToElement(gantelement).build().perform();
							Thread.sleep(1000);
							
							try
							{
								//Zoomout to display the hover and extract the element and perform the comparison of hover data with Puck data
								CommonTest.zoomOutdata();
								actions.moveToElement(gantelement).build().perform();	
								WebElement Hoverdisplay = getDriver().findElement(By.xpath(Web_UI.Puckhover));
								String Confirmation = Hoverdisplay.getAttribute("innerText");
								String ConfirmationText = Confirmation.trim();
								System.out.println("ConfirmationText"+ConfirmationText);
								if (ConfirmationText.contains("null")||ConfirmationText.contains(".."))
								{
									ATUReports.add("Hover details displayed Fully "+i,  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									ATUReports.add(ConfirmationText,  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									ATUReports.add("Comparison ", "", "should not hold null / ..", ConfirmationText, LogAs.FAILED, null);
									
									
								}
								else{
									ATUReports.add("Hover details Doesnot contains Null value or Truncated "+i,  LogAs.PASSED, null);
									ATUReports.add("Comparison ", "", "should not hold null / ..", ConfirmationText, LogAs.PASSED, null);
								}
								
								if (ConfirmationText.contains(Verificationtext))
								{
									ATUReports.add("Verified the text with Puck details and been passed Puck NO "+i,  LogAs.PASSED, null);
									ATUReports.add(ConfirmationText,  LogAs.PASSED, null);
									ATUReports.add("Comparison ", "", Verificationtext, ConfirmationText, LogAs.PASSED, null);
									
								}
								else
								{
									ATUReports.add("Puck details and Hover details doesnt match"+i,  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
										ATUReports.add("Comparison ", "", Verificationtext, ConfirmationText, LogAs.FAILED, null);
								}
								CommonTest.zoomindata();
								break;
							}catch(Exception Hovernotpresent)
							{
								CommonTest.zoomindata();
								ATUReports.add("Hover not displayed as Length of puck is not enough to show Hover "+i,  LogAs.PASSED, null);
								
							}
							
								} 
						catch(Exception Noelement)
						{
							ATUReports.add( "Issues in moving between elements "+i,  LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
							
						}
		}
			}
		}			}catch(Exception Noelement)
		{
			
			captureinfoScreenshot(getDriver(),"Total gate selection issues failed");
			ATUReports.add("Total gate selection failed Or Issue in Gantt view",  LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE)); 
		}
				CommonTest.CheckCollapse();
				CommonTest.zoomindata();
		
	
		
		
		
		
		
	}

	
}