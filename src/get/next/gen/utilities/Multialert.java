package get.next.gen.utilities;

import get.next.gen.commonaction.CommonTest;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import get.next.gen.serviceutils.correction;
import get.next.gen.webtestcase.*;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;
import org.testng.annotations.Listeners;

import atu.testng.reports.ATUReports;
import atu.testng.reports.logging.LogAs;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;





















import com.sun.jna.platform.win32.OaIdl.SYSKIND;

import atu.testng.reports.listeners.ATUReportsListener;
import atu.testng.reports.listeners.ConfigurationListener;
import atu.testng.reports.listeners.MethodListener;
@Listeners({ ATUReportsListener.class, ConfigurationListener.class,
MethodListener.class })


public class Multialert extends CommonTest {


	public static void Checkmultialertpresent() throws Exception {
		  TestcaseInit();
		  clickByXpath(Web_UI.MEL, "MEL Stats");
		  CommonTest.SpinnerControl();
		  CommonTest.zoomindata();
		  CommonTest.zoomindata();
			Thread.sleep(3000);
			clickByXpath(Web_UI.SortAscending,"SortAscending");
			Thread.sleep(1000);
			// Select Sort Ascending gate by alphabetical order from dropdown
			clickByXpath(Web_UI.SortAscendinggate,"SortAscendinggate");
			
			Thread.sleep(1000);
		
			List<WebElement> Ganntlist = getDriver().findElements(By.xpath(Web_UI.PuckComplete));
			int Ganntlistcount = Ganntlist.size();
		
			if(Ganntlistcount == 0)
			{
				CommonTest.CheckGanttviewListisnotZero();
			}
			CheckCollapse();
			  clickByXpath(Web_UI.MEL, "MEL Stats");
			CommonTest.CheckExpand();
			List<WebElement> Ganntlist1= getDriver().findElements(By.xpath(Web_UI.PuckComplete));
			int Ganntlistcount1 = Ganntlist1.size();
			
			if(Ganntlistcount1 == 0)
			{
				ATUReports.add( "*************Gantt L ist is Zero and hence Exiting test smoothly*******************",  LogAs.PASSED, null);
			}else
			{
		
				int i=0;
				for (WebElement gantelement : Ganntlist) {
				i++;
				try{
					String idofelement = gantelement.getAttribute("id");
					System.out.println("idofelement: "+idofelement);
					ATUReports.add(" Verifying puck with id :: "+idofelement,  LogAs.INFO, null); 
					
				
							try {

								Actions actions = new Actions(getDriver());
								WebElement moveelement = getDriver().findElement(By.id(idofelement));
								actions.moveToElement(moveelement).build().perform();
								actions.moveToElement(moveelement).build().perform();
								actions.moveToElement(gantelement);
								WebElement  Mouseoverelement = getDriver().findElement(By.xpath("//div[@id='"+idofelement+"']/puck-lefticons[1]/div[1]"));
							//	Thread.sleep(1000);
								actions.moveToElement(Mouseoverelement).build().perform();
								actions.moveToElement(Mouseoverelement).build().perform();
								Boolean Hoverpopup = getDriver().findElement(By.xpath("//div[@class='tooltip-inner']")).isDisplayed();
								if(Hoverpopup==true){
									ATUReports.add("Multialert Hover displayed upon hovering for the puck id "+idofelement,  LogAs.PASSED, null); 
								}else{
									ATUReports.add("Multialert Hover popup not displayed upon hovering for the puck id  "+idofelement,  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE)); 
								}
								actions.moveToElement(Mouseoverelement).click(Mouseoverelement).build().perform();
								
								Thread.sleep(3000);
								Boolean Multialertpopup = getDriver().findElement(By.xpath("//ul[@class='nav nav-tabs']")).isDisplayed();
								if(Multialertpopup==true){
									ATUReports.add("Multialert  popup is displayed upon Clicking the multialert icon for the puck id "+idofelement,  LogAs.PASSED, null); 
								}else{
									ATUReports.add("Multialert ppopup is not displayed upon Clicking the multialert icon for the puck id "+idofelement,  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE)); 
								}
								
								List<WebElement> alertitem= getDriver().findElements(By.xpath("//ul[@class='nav nav-tabs']/li"));
								int sizeofalerts =alertitem.size();
								System.out.println(sizeofalerts);
					//Check the count matches			
									try{
									
									String Count =  getDriver().findElement(By.xpath("//div[@id='"+idofelement+"']/puck-lefticons[1]/div[1]/div[1]")).getAttribute("innerText");
									if(Count==""){
										
									}else{
									int countderived = Integer.parseInt(Count);
									if(countderived>0){
										
										if(sizeofalerts==countderived){
										
											
										
											ATUReports.add( "Count in Multialert and the alerts within the multialert popup matches "+idofelement,"Expected "+sizeofalerts,"Actual "+countderived,  LogAs.PASSED, null);
											//ATUReports.add("Count in Multialert and the alerts within the multialert popup matches "+idofelement,  LogAs.PASSED, null);
											
										}else{
											
											ATUReports.add( "Count in Multialert and the alerts within the multialert popup doesn't matches "+idofelement,"Expected "+sizeofalerts,"Actual "+countderived,  LogAs.FAILED, null);
											
											//ATUReports.add("Count in Multialert and the alerts within the multialert popup doesnt match "+idofelement,  LogAs.FAILED, null); 
										}
										
										
									}else{
										ATUReports.add("Only one alert for the selected puck and hence passing it to next validation "+idofelement,  LogAs.PASSED, null);
									}
									}
								}catch (Exception Exee) {
									
									System.out.println("");
								}
								
								
						//Checking the default selected is highlighted with different background		
									try{
										String color =  gantelement.findElement(By.xpath("puck-lefticons/div[2]/div[2]/div/div/notification-component/div/div[2]/div[2]/div/div/ul/li[1]/a")).getCssValue("background-color");
										System.out.println(color);
										if(color.contains("183, 198, 212")){
											ATUReports.add("Alert icon by default selected is highlighted for the selected Puck id "+idofelement,  LogAs.PASSED, null); 
										}else{
											ATUReports.add("Alert icon by default selected is not highlighted for the selected Puck id "+idofelement,  LogAs.FAILED, null); 
										}
								
									}catch (Exception Exee) {
										System.out.println("");
									}	
								
							//Fetch the icons displayed over the popup and print 
									
									try{
										List<WebElement> alerticons = getDriver().findElements(By.xpath("//ul[@class='nav nav-tabs']/li"));
										int multicount = 0;
										for (WebElement alert : alerticons) {
											multicount++;
											//String printalerticonnames = alert.findElement(By.xpath("a")).getAttribute("innerHTML");
											String printalerticonnames = alert.findElement(By.xpath("a[1]/uib-tab-heading[1]/img[1]")).getAttribute("title");
											ATUReports.add("The icon present in position "+multicount+"is "+printalerticonnames,  LogAs.PASSED, null); 
											System.out.println("The icon present in position "+multicount+"is "+printalerticonnames);
													
										}
										
									}catch (Exception Exee) {
										System.out.println("");
									}
								
							//break;	
								
							}	catch (Exception Exee) {
								System.out.println("Exception while moving to the element "+i);
								ATUReports.add("Exception while moving to the element "+i,  LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE)); 
								}
							
									} 
				catch(Exception id)
				{
					
				}
				}
			}
		  
		
	}

	public static void Checkeventmultialertpresent() throws Exception {

		  TestcaseInit();
		  clickByXpath(Web_UI.TotalAlerts, "Total Alerts");
		  CommonTest.SpinnerControl();
		  CommonTest.zoomindata();
		  CommonTest.zoomindata();
			Thread.sleep(3000);
			clickByXpath(Web_UI.SortAscending,"SortAscending");
			Thread.sleep(1000);
			// Select Sort Ascending gate by alphabetical order from dropdown
			clickByXpath(Web_UI.SortAscendinggate,"SortAscendinggate");
			
			Thread.sleep(1000);
		
			List<WebElement> Ganntlist = getDriver().findElements(By.xpath(Web_UI.PuckComplete));
			int Ganntlistcount = Ganntlist.size();
		
			if(Ganntlistcount == 0)
			{
				CommonTest.CheckGanttviewListisnotZero();
			}
			CheckCollapse();
		    clickByXpath(Web_UI.TotalAlerts, "Total Alerts");
			CommonTest.CheckExpand();
			List<WebElement> Ganntlist1= getDriver().findElements(By.xpath(Web_UI.PuckComplete));
			int Ganntlistcount1 = Ganntlist1.size();
			
			if(Ganntlistcount1 == 0)
			{
				ATUReports.add( "*************Gantt List is Zero and hence Exiting test smoothly*******************",  LogAs.PASSED, null);
			}else
			{
		
				int i=0;
				for (WebElement gantelement : Ganntlist1) {
				i++;
				try{
					String idofelement = gantelement.getAttribute("id");
					System.out.println("idofelement: "+idofelement);
					ATUReports.add(" Verifying puck with id  :: "+idofelement,  LogAs.INFO, null); 
					
				
							try {

								Actions actions = new Actions(getDriver());
								WebElement moveelement = getDriver().findElement(By.id(idofelement));
								actions.moveToElement(moveelement).build().perform();
								actions.moveToElement(moveelement).build().perform();
								actions.moveToElement(gantelement);
								WebElement  Mouseoverelement = getDriver().findElement(By.xpath("//div[@id='"+idofelement+"']/puck-righticons[1]/div[1]"));
							//	Thread.sleep(1000);
								actions.moveToElement(Mouseoverelement).build().perform();
								actions.moveToElement(Mouseoverelement).build().perform();
								Boolean Hoverpopup = getDriver().findElement(By.xpath("//div[@class='tooltip-inner']")).isDisplayed();
								if(Hoverpopup==true){
									ATUReports.add("Multialert Hover displayed upon hovering for the puck id "+idofelement,  LogAs.PASSED, null); 
								}else{
									ATUReports.add("Multialert Hover popup not displayed upon hovering for the puck id  "+idofelement,  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE)); 
								}
								actions.moveToElement(Mouseoverelement).click(Mouseoverelement).build().perform();
								
								Thread.sleep(3000);
								Boolean Multialertpopup = getDriver().findElement(By.xpath("//event-component[1]/div[1]")).isDisplayed();
								if(Multialertpopup==true){
									ATUReports.add("Multialert  popup is displayed upon Clicking the multialert icon for the puck id "+idofelement,  LogAs.PASSED, null); 
								}else{
									ATUReports.add("Multialert popup is not displacyed upon Clicking the multialert icon for the puck id "+idofelement,  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE)); 
								}
								
								List<WebElement> alertitem= getDriver().findElements(By.xpath("//event-component[1]/div[1]/div[2]/span"));
								int sizeofalerts =alertitem.size();
								System.out.println(sizeofalerts);
					//Check the count matches			
									try{
									
									String Count =  getDriver().findElement(By.xpath("//div[@id='"+idofelement+"']/puck-righticons[1]/div[1]/span[1]")).getAttribute("innerText");
									if(Count==""){
										
									}else{
									int countderived = Integer.parseInt(Count);
									if(countderived>0){
										
										if(sizeofalerts==countderived){
										
										
											ATUReports.add( "Count in Multialert and the alerts within the multialert popup matches "+idofelement,"Expected "+sizeofalerts,"Actual "+countderived,  LogAs.PASSED, null);
											//ATUReports.add("Count in Multialert and the alerts within the multialert popup matches "+idofelement,  LogAs.PASSED, null);
											
										}else{
											
											ATUReports.add( "Count in Multialert and the alerts within the multialert popup doesn't matches "+idofelement,"Expected "+sizeofalerts,"Actual "+countderived,  LogAs.FAILED, null);
											
											//ATUReports.add("Count in Multialert and the alerts within the multialert popup doesnt match "+idofelement,  LogAs.FAILED, null); 
										}
										
										
									}else{
										ATUReports.add("Only one alert for the selected puck and hence passing it to next validation  "+idofelement,  LogAs.PASSED, null);
									}
									}
								}catch (Exception Exee) {
									
									System.out.println("");
								}
								
								
						
							//Fetch the icons displayed over the popup and print 
									
									try{
										List<WebElement> alerticons = getDriver().findElements(By.xpath("//event-component[1]/div[1]/div[2]/span"));
										int multicount = 0;
										for (WebElement alert : alerticons) {
											multicount++;
											//String printalerticonnames = alert.findElement(By.xpath("a")).getAttribute("innerHTML");
											String printalerticonnames = alert.getAttribute("className");
											//String splitprintalerticonnames[] = printalerticonnames.split("ng-scope");
											//String printalerticonname = splitprintalerticonnames[2]; 
											ATUReports.add("The icon present in position "+multicount+"is "+printalerticonnames,  LogAs.PASSED, null); 
											System.out.println("The icon present in position "+multicount+"is "+printalerticonnames);
													
										}
										
									}catch (Exception Exee) {
										System.out.println("");
									}
								
							//break;	
								
							}	catch (Exception Exee) {
								
								ATUReports.add("Donot have multi alerts  "+i,  LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE)); 
								}
							
									} 
				catch(Exception id)
				{
					
				}
				}
				
				
				
			}
		  
		
	
		
	}

	
	public static void Checkmultialertpriority() throws Exception {
		  TestcaseInit();
		  //clickByXpath(Web_UI.MEL, "MEL Stats");
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
		
			List<WebElement> Ganntlist = getDriver().findElements(By.xpath(Web_UI.PuckComplete));
			int Ganntlistcount = Ganntlist.size();
			System.out.println("Puck count "+Ganntlistcount);
			if(Ganntlistcount == 0)
			{
				CommonTest.CheckGanttviewListisnotZero();
			}
			CheckCollapse();
			  clickByXpath(Web_UI.MEL, "MEL Stats");
			  Thread.sleep(20000);
			CommonTest.CheckExpand();
			List<WebElement> Ganntlist1= getDriver().findElements(By.xpath(Web_UI.PuckComplete));
			
			int Ganntlistcount1 = Ganntlist1.size();
			System.out.println(Ganntlistcount1);
			if(Ganntlistcount1 == 0)
			{
				ATUReports.add( "*************Gantt L ist is Zero and hence Exiting test smoothly*******************",  LogAs.PASSED, null);
			}else
			{
				System.out.println("Entered Loop");
				int i=0;
				for (WebElement gantelement : Ganntlist1) {
				i++;
				try{
					Thread.sleep(1000);
					String idofelement = gantelement.getAttribute("id");
					ATUReports.add(" Verifying puck with id :: "+idofelement,  LogAs.INFO, null); 
					
				
							try {
								
								Actions actions = new Actions(getDriver());
								WebElement moveelement = getDriver().findElement(By.id(idofelement));
								actions.moveToElement(moveelement).build().perform();
								actions.moveToElement(moveelement).build().perform();
								actions.moveToElement(gantelement);
								WebElement  Mouseoverelement = getDriver().findElement(By.xpath("//div[@id='"+idofelement+"']/puck-lefticons[1]/div[1]"));
								Thread.sleep(1000);
								actions.moveToElement(Mouseoverelement).build().perform();
								actions.moveToElement(Mouseoverelement).build().perform();
								Boolean Hoverpopup = getDriver().findElement(By.xpath("//div[@class='tooltip-inner']")).isDisplayed();
								if(Hoverpopup==true){
									System.out.println("popup displayed");
									ATUReports.add("Multialert Hover displayed upon hovering for the puck id "+idofelement,  LogAs.PASSED, null); 
								}else{
									ATUReports.add("Multialert Hover popup not displayed upon hovering for the puck id  "+idofelement,  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE)); 
								}
								Thread.sleep(1000);
								actions.moveToElement(Mouseoverelement).click(Mouseoverelement).build().perform();
								
								Thread.sleep(3000);
								Boolean Multialertpopup = getDriver().findElement(By.xpath("//ul[@class='nav nav-tabs']")).isDisplayed();
								if(Multialertpopup==true){
									ATUReports.add("Multialert  popup is displayed upon Clicking the multialert icon for the puck id "+idofelement,  LogAs.PASSED, null); 
								}else{
									ATUReports.add("Multialert ppopup is not displayed upon Clicking the multialert icon for the puck id "+idofelement,  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE)); 
								}
								
								List<WebElement> alertitem= getDriver().findElements(By.xpath("//ul[@class='nav nav-tabs']/li/a//img"));
								ArrayList<String> nameArray = new ArrayList<String>();
								System.out.println(alertitem);
								for( WebElement alertname:alertitem )
								{
								String namealert=alertname.getAttribute("title");
								System.out.println(namealert);
								nameArray.add(namealert);
								}
								System.out.println(nameArray);
								ArrayList<Integer> checkArray = new ArrayList<Integer>();
								for(String namereplace:nameArray)
								{
									System.out.println(namereplace);
									switch(namereplace){
									case "SWAP":
										System.out.println("Entered SWAP");
										checkArray.add(1);
										break;
									case "OTS":
										System.out.println("Entered OTS");
										checkArray.add(2);
										break;
									case "Weight Restricted":
										System.out.println("Entered Weight Restricted");
										checkArray.add(3);
										break;
									case "ETD Update Required":
										System.out.println("Entered ETD");
										checkArray.add(5);
										break;
									case "MEL":
										System.out.println("Entered MEL");
										checkArray.add(6);
										break;
									case "IFS":
										System.out.println("Entered IFS Flagship ");
										checkArray.add(7);
										break;
									case "Diverted":
										System.out.println("Entered Diverted");
										checkArray.add(7);
										break;
									case "Right Start":
										System.out.println("Entered RS");
										checkArray.add(11);
										break;	
									
									default:
										System.out.println("No switch matched");
									}
								}
								System.out.println(checkArray);
								Integer[] arr = new Integer[checkArray.size()]; 
						        arr = checkArray.toArray(arr);
						        boolean fincheck =isSorted(arr);
						        if(fincheck)
						        {
						        	ATUReports.add("Multialert  popup is displayed as per priority order ",  LogAs.PASSED, null);
						        }
						        else
						        {
						        	ATUReports.add("Multialert  popup not displayed as per priority order ",  LogAs.FAILED, null);
						        }
								int namearraysize = nameArray.size();
								System.out.println(namearraysize);
								int sizeofalerts =alertitem.size();
								System.out.println(sizeofalerts);
					//Check the count matches			
									try{
									
									String Count =  getDriver().findElement(By.xpath("//div[@id='"+idofelement+"']/puck-lefticons[1]/div[1]/div[1]")).getAttribute("innerText");
									
									int countderived = Integer.parseInt(Count);
									if(countderived<2){
										
										ATUReports.add("Only one alert for the selected puck and hence passing it to next validation "+idofelement,  LogAs.PASSED, null);
										
										
									}
									
								}catch (Exception Exee) {
									
									System.out.println("");
								}
								
								
						
								
							//Fetch the icons displayed over the popup and print 
									
									try{
										List<WebElement> alerticons = getDriver().findElements(By.xpath("//ul[@class='nav nav-tabs']/li"));
										int multicount = 0;
										for (WebElement alert : alerticons) {
											multicount++;
											//String printalerticonnames = alert.findElement(By.xpath("a")).getAttribute("innerHTML");
											String printalerticonnames = alert.findElement(By.xpath("a[1]/uib-tab-heading[1]/img[1]")).getAttribute("title");
											ATUReports.add("The icon present in position "+multicount+"is "+printalerticonnames,  LogAs.PASSED, null); 
											System.out.println("The icon present in position "+multicount+"is "+printalerticonnames);
													
										}
										
									}catch (Exception Exee) {
										System.out.println("");
									}
								
							//break;	
								
							}	catch (Exception Exee) {
								System.out.println("Exception while moving to the element "+i);
								ATUReports.add("Exception while moving to the element "+i,  LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE)); 
								}
							
									} 
				catch(Exception id)
				{
					
				}
				}
				
			}}
		  
			public static boolean isSorted(Integer[] arr){
				for(int i = 1; i < arr.length; i++){
					if(arr[i-1] > arr[i]){
						return false;
					}
				}
				return true;
			}
	
	
	
	
	
	
	
	
	
	
	
	
}
