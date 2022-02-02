package get.next.gen.utilities;
import get.next.gen.commonaction.CommonTest;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import get.next.gen.commonaction.CompareExcel;
import get.next.gen.webtestcase.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
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
//
public class Lazyloading extends CommonTest {
	public static void VerifyStatsCount(String Validationstats, String StatisticsName, String Statscount) throws Exception {
		System.out.println("Verifying stats count and puck list displayed in gantt view are matching for the Flight stats :: "+StatisticsName);
		Thread.sleep(10000);
		//using set to avaoid duplicate values of flight number
		Set<String> Flightlists = new HashSet<>();
		//List<String> Flightlists = new ArrayList<>();
		clickByXpathforstats(Validationstats,StatisticsName);
		Thread.sleep(2000);
		boolean checkclicked = clickByXpathforstats(Validationstats,StatisticsName);
		
		if(checkclicked==false){	
			ATUReports.add( " Selected Stats not present in page",  LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		}else{

			Actions actions = new Actions(getDriver());
			aa:
				for(int moveloop = 0;moveloop<=5;)
				{
					try{
						List<WebElement> Ganntlist = getDriver().findElements(By.xpath(Web_UI.PuckComplete));
						int Ganntlistcount = Ganntlist.size();
						System.out.println("Ganntlistcount"+Ganntlistcount);
						for (int i=1;i<=Ganntlistcount;i++) {
							try{
								String idofelement = getDriver().findElement(By.xpath("((//div[contains(@class,'flight-puck')])["+i+"]//app-ganttview-puck-center//span[@class='ng-star-inserted'])[3]")).getAttribute("textContent");
								if(idofelement.contains("UNL")){
									String idofelement_arr = getDriver().findElement(By.xpath("((//div[contains(@class,'flight-puck')])["+i+"]//app-ganttview-puck-center//span[@class='ng-star-inserted'])[1]")).getAttribute("textContent");
									System.out.println("idofelement_arr"+idofelement_arr);
									Flightlists.add(idofelement_arr);
								}
								else{
									System.out.println("idofelement"+idofelement);
									Flightlists.add(idofelement);
								}
							}
							catch(Exception id)				
							{
							}
						}
						WebElement scrollview = getDriver().findElement(By.xpath(Web_UI.Scrollbar));
						boolean scroll_displayed = scrollview.isDisplayed();
						System.out.println("displayed"+scroll_displayed);
						if(scroll_displayed==true) {
							moveloop++;
							scrollview.click(); 
							actions.sendKeys(Keys.PAGE_DOWN).build().perform();
							Thread.sleep(2000);
						}else {
							break aa;
						}		
					}
					catch(Exception e) {

					}
				}
			System.out.println(Flightlists.toString());
			Integer i1=Flightlists.size(); 
			
			String statsCountInDashboard = getDriver().findElement(By.xpath(Statscount)).getAttribute("textContent");
			Integer statsCountInDashboard_Int = Integer.valueOf(statsCountInDashboard);
			System.out.println("statsCountInDashboard_Int : "+statsCountInDashboard_Int  + i1);
			Integer statsCountInDashboard_MaxValue = statsCountInDashboard_Int+3;
			Integer statsCountInDashboard_MinValue = statsCountInDashboard_Int-3;
			System.out.println("statsCountInDashboard_MaxValue:" + statsCountInDashboard_MaxValue);
			System.out.println("statsCountInDashboard_MinValue:" + statsCountInDashboard_MinValue);
			if(i1<= statsCountInDashboard_MaxValue&&i1>=statsCountInDashboard_MinValue) {
				System.out.println("Stats and puck counts matches");
			}
			else {
				System.out.println("Stats and puck counts does not matches");
			}

		}
	}
}