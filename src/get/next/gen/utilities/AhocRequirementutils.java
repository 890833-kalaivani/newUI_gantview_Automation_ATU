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
import java.util.List;
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



public class AhocRequirementutils extends CommonTest {
	
// There was an issue in Production and been fixed. When user search with some flight tail numbers in global search it retured backend error. To validate the fix got all the tail number from backend and performing search to know any tail returns backend error.


	public static void verifyTailNotshowingresult() throws Exception {
		
		String url="http://apapnp43.tul.aa.com:8081/GetNGServices/flight/getFlightsForGivenTime";
		String urlCache="http://apapnp43.tul.aa.com:8081/GetNGServices/flight/getFlightsForGivenTime";
		String Starttime = "2017-06-23T05:15:03.514Z";
		String Endtime = "2017-06-23T23:00:03.514Z";
		String sta = "PHL";
		String request= "{\"station\":\""+sta+"\",\"startTime\":\""+Starttime+"\",\"endTime\":\""+Endtime+"\",\"gates\":[],\"allGates\":true,\"pastFlights\":false,\"transactionId\":\"UNKNOWN_00812339_PHX_1489539768116_201\"}";
		GETNGReponse(url,request,urlCache);
		ArrayList<String> lst = DataPuller("json1.txt","Catering",sta);
		System.out.println(lst);
		 Object[] st = lst.toArray();
         for (Object s : st) {
           if (lst.indexOf(s) != lst.lastIndexOf(s)) {
               lst.remove(lst.lastIndexOf(s));
            }
         }

    
        for (String s : lst) {
        	try{
        		
        	//Send Text and Search 
        	getDriver().findElement(By.xpath("//input[@id='globalHeader']")).clear();
        	getDriver().findElement(By.xpath("//input[@id='globalHeader']")).sendKeys(s);
        	getDriver().findElement(By.xpath("//div[@class='search-icon']")).click();
        	Thread.sleep(5000);
        	GanntViewHeaderFunctionality.SpinnerControl();
        	try{
        	//Get the list and find tail is present
        	List<WebElement> Ganntlist = getDriver().findElements(By.xpath("//div[@data-ng-repeat='flt in gts.Flights']"));
        	int Ganntlistcount = Ganntlist.size();
        	if(Ganntlistcount!=0)
        	{
        	
        		ATUReports.add("Flight result is displayed for the flight: "+s,  LogAs.PASSED, null);; 
        	}
        	else
        	{
        		
        		ATUReports.add("Flight result Not displayed for the flight: "+s,  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));; 
        		
        	}
        	}catch(Exception Noprob)
        	{
        		
        	}
        	
        }catch(Exception EEEE)
        	{
        
        	try{
        	
        	ATUReports.add("Popup displayed due to flight not present: "+s,  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));; 
        	
        	getDriver().findElement(By.xpath("//div[text()='OK']")).click();
        	Thread.sleep(2000);
        	}
        	catch(Exception EEd)
        	{
        		Thread.sleep(5000);
        	}
        	}
          }	
		
		
	}
	 public static void GETNGReponse(String strurl,String request1,String strurl2) throws Exception{
			

			
			//&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
			
			//Fetch data from GETNextGen and get the NextGen Flight count
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date date = new java.util.Date();
			String dateWithoutTime =dateFormat.format(date);   //"02 May 2016"; 
			String jsonString1 = request1;
			POST_JSON_GETNG(strurl,jsonString1,"json1.txt");
				
	  }
	  
	  
	  
	  
	  public static String POST_JSON_GETNG(String URL, String jsonString,String path) throws Exception {
		 //   System.out.println("Sending POST Request with value " + jsonString + " to URL:" + URL);
		    long startTime=Calendar.getInstance().getTimeInMillis();
		     URL url = new URL(URL);
		    String json = new String(jsonString);
		  //  System.out.println("jsonString:" + json);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setConnectTimeout(5000);
			conn.setRequestProperty("Accept", "application/json");
			conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setRequestMethod("POST");
			OutputStream os = (OutputStream) conn.getOutputStream();
			os.write(jsonString.getBytes("UTF-8"));
			os.close();
			// read the response
			InputStream in = new BufferedInputStream(conn.getInputStream());
			//String result = org.apache.commons.io.IOUtils.toString(in,"UTF-8"); // response is stored in result
			String result = org.apache.commons.io.IOUtils.toString(in,"UTF-8"); // response is stored in result
			System.out.println("JSON Response:" + result);
			
			try (FileWriter file = new FileWriter(path)) {
				file.write(result);
			in.close();
			conn.disconnect();
			}
			long endTime=Calendar.getInstance().getTimeInMillis();
			long responsetime = startTime-endTime;
			return result;
		}
	  

	  
	  
	  public static  ArrayList<String> DataPuller(String path,String SheetName, String sta) throws Exception{
		  
		
		  	String st, full,append,le,extend, extended;
		  	full="";
		  	extended="";
		  	BufferedReader br = new BufferedReader(new FileReader(path));
		  	while ((st=br.readLine())!=null) {
		      full+=st;
		  	}
		  	ArrayList<String> lstresponse = new ArrayList<String>();
		
		  	
		  if(SheetName.contains("Catering"))
		  {
			  JSONArray jsonObj1 = new JSONArray(full);
		  
			for (int ii=0;ii<jsonObj1.length();ii++)
				
			{
				int rowCountt = ii;
				rowCountt++; 
				JSONObject Testprint11 = jsonObj1.getJSONObject(ii);
				try{
					 String Tail = Testprint11.getJSONObject("flight").getString("assignedTail");
					// System.out.println(Tail + " Tail");
					 lstresponse.add(Tail);
					
				}
				 catch(Exception EEE)
				 {
					 
					
					 
				 }
				

			}
			System.out.println("Completetail:  "+lstresponse);
			
		  }
		  String Tailarrayresponse = lstresponse.toString();
	 return lstresponse;
	  }
}