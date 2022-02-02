package get.next.gen.serviceutils;

import get.next.gen.commonaction.CommonTest;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.TimeZone;

import org.apache.commons.io.FileUtils;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Listeners;

import atu.testng.reports.ATUReports;
import atu.testng.reports.logging.LogAs;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.relevantcodes.extentreports.LogStatus;

import atu.testng.reports.listeners.ATUReportsListener;
import atu.testng.reports.listeners.ConfigurationListener;
import atu.testng.reports.listeners.MethodListener;
@Listeners({ ATUReportsListener.class, ConfigurationListener.class,
MethodListener.class })


public class ServiceComparisioncorrection extends CommonTest  {
  //public static void main(String myHelpers[]) throws Exception{
	  
	  public static void ServiceComparisionstartcode(String servicename, String url,String request,String urls,String sta ) throws Exception{
		  String url1=url;
		  String url3=urls;
	  	  String request12=request;
	  	  GETNGReponse(url1,request12,urls);	  
	  	  PullAttributetoExcelSheet(servicename,sta);
	  	// Verifyresult();
	   
  }
	  public static void Getcode(String url,String request,String urls,String sta,String Servicename ) throws Exception{
		  String url1=url;
		  String url3=urls;
	  	  String request12=request;
	  	 String Response1 = GET_JSON_GETNG(url1);
	  	 String Response2 = GET_JSON_GETNG(url3);
	   
	  	 if (Response1.equalsIgnoreCase(Response2))
	  	 {
	  		//test.log(LogStatus.PASS, "Respose  Matches for Station "+sta);
	  		ATUReports.add("Respose  Matches for Station "+sta,  LogAs.PASSED, null);; 
	  	 }
	  	 else{
	  		//test.log(LogStatus.FAIL, "Respose Not Matches for Station "+sta);
	  		ATUReports.add( "Respose Not Matches for Station "+sta,  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));; 
	  		try(  PrintWriter out = new PrintWriter( "//responsemismatch"+"Response1"+sta+" "+Servicename+".txt" )  ){
	  		    out.println( Response1 );
	  		}
	  		try(  PrintWriter out = new PrintWriter( "//responsemismatch"+"Response2"+sta+"  "+Servicename+".txt" )  ){
	  		    out.println( Response2 );
	  		}
	  		
	  	 }
  }
	  
  
	  public static void ServiceComparisionstartcode1(String servicename, String url,String request,String urls,String request1,String sta ) throws Exception{
		  String url1=url;
		  String url3=urls;
	  	  String request12=request;
	  	  String request13=request1;
	  	  GETNGReponse1(url1,request12,url3,request13);
	  	  PullAttributetoExcelSheet(servicename, sta);
	  	// Verifyresult();
	   
  }
	  
  
  public static void PullAttributetoExcelSheet(String servicename, String sta) throws Exception{
		
	 
	  Compareresponse("json1.txt","json2.txt",sta,servicename);
	  
  }
  
  public static void Compareresponse(String path1,String path2,String sta, String servicename) throws Exception{
	  String st, full,append,le,extend, extended,st1,full1;
	  	full="";full1="";
	  	extended="";
	  	BufferedReader br = new BufferedReader(new FileReader(path1));
	  	while ((st=br.readLine())!=null) {
	      full+=st;
	  	}
	  	BufferedReader br1 = new BufferedReader(new FileReader(path2));
	  	while ((st1=br1.readLine())!=null) {
	      full1+=st1;
	  	}
  
	  	String Response1 = full;
	  	String Response2 = full1;
	  	if(Response1.equalsIgnoreCase(Response2))
	  	{
	  		//test.log(LogStatus.INFO, Response1);
	  		//test.log(LogStatus.INFO, Response1);
	  		//test.log(LogStatus.PASS, "Respose Matches for Station "+sta);
	  		ATUReports.add("Respose Matches for Station "+sta,  LogAs.PASSED, null);; 
	  	}
	  	else{
	  	//	test.log(LogStatus.INFO, Response1);
	  	//	test.log(LogStatus.INFO, Response2);
	  		//test.log(LogStatus.FAIL, "Respose MisMatches for Station "+sta);
	  		ATUReports.add("Respose MisMatches for Station "+sta,  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));; 
	  	//	 System.out.println(Response2 );
	  	//	 System.out.println(Response1 );
	  		 System.out.println("================= Fail================================");
	  		 
	  		 FileUtils.writeStringToFile(new File("responsemismatch"+"//Response1"+sta+" "+servicename+".txt"), Response1);
	  		 FileUtils.writeStringToFile(new File("responsemismatch"+"//Response2"+sta+" "+servicename+".txt"), Response2);
//		  		try(  PrintWriter out = new PrintWriter("//responsemismatch"+"Response1"+sta+" "+servicename+".txt" )  ){
//		  		    out.println( Response1 );
//		  		}
//		  		try(  PrintWriter out = new PrintWriter( "//responsemismatch"+"Response2"+sta+" "+servicename+".txt" )  ){
//		  		    out.println( Response2 );
		  		//}
	  	
	  	}
  }
  
  
  
  public static ArrayList<String> ServiceComparisionDataPuller(String path,String SheetName,String ExcelName, String sta) throws Exception{
	  
	  
	     Date date = new Date();
	    TimeZone.setDefault(TimeZone.getTimeZone("GMT"));
	    Calendar cal = Calendar.getInstance(TimeZone.getDefault());
	    date = cal.getTime();
	    String timee = date.toGMTString();
	    long timeeunixx = cal.getTimeInMillis();

		List<String> Righstartlist = new ArrayList<>();
	long mil =System.currentTimeMillis();
	String st, full,append,le,extend, extended;
	full="";
	extended="";
	BufferedReader br = new BufferedReader(new FileReader(path));
	while ((st=br.readLine())!=null) {
    full+=st;
	}
  JSONArray jsonObj1 = new JSONArray(full);

	for (int ii=0;ii<jsonObj1.length();ii++)
		
	{
		int rowCountt = ii;
		rowCountt++; 
		JSONObject Testprint11 = jsonObj1.getJSONObject(ii);
	
		try{
		 String Flightnumber = Testprint11.getJSONObject("flight").getString("fltKey");
		 Righstartlist.add(Flightnumber);	 
			 }catch(Exception newexception)
		{
			System.out.print("");
		}
			
		}
		
		
		

	
	 return  (ArrayList<String>) Righstartlist;
	
			


  }
  
  

  //***************************************************************************


  
  
  public static void GETNGReponse(String strurl,String request1,String strurl2) throws Exception{
		

		
		//&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
		
		//Fetch data from GETNextGen and get the NextGen Flight count
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date = new java.util.Date();
		String dateWithoutTime =dateFormat.format(date);   //"02 May 2016"; 
		String jsonString1 = request1;
		POST_JSON_GETNG(strurl,jsonString1,"json1.txt");
		POST_JSON_GETNG(strurl2,jsonString1,"json2.txt");	
  }
  
  public static void GETNGReponse1(String strurl,String request1,String strurl2,String request2) throws Exception{
		

		
		//&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
		
		//Fetch data from GETNextGen and get the NextGen Flight count
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date = new java.util.Date();
		String dateWithoutTime =dateFormat.format(date);   //"02 May 2016"; 
		String jsonString1 = request1;
		String jsonString2 = request2;
		POST_JSON_GETNG(strurl,jsonString1,"json1.txt");
		POST_JSON_GETNG(strurl2,jsonString2,"json2.txt");	
  }
  
  
  
  
  public static String POST_JSON_GETNG(String URL, String jsonString,String path) throws Exception {
	 //   System.out.println("Sending POST Request with value " + jsonString + " to URL:" + URL);
		String result ="";
	  try{
	  
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
		 result = org.apache.commons.io.IOUtils.toString(in,"UTF-8"); // response is stored in result
	//	System.out.println("JSON Response:" + result);
		
		try (FileWriter file = new FileWriter(path)) {
			file.write(result);
		in.close();
		conn.disconnect();
		}
		long endTime=Calendar.getInstance().getTimeInMillis();
		long responsetime = startTime-endTime;
	//	System.out.println("The Total time taken for url  "+"   "+ URL+"is"+responsetime+ "   milliseconds");
		System.out.println("JSON Response:" + result);
		return result;
	 }catch(Exception Failedtoconnect)
	  {
		 // test.log(LogStatus.FAIL, "Failed to connect network or service");
		  ATUReports.add( "Failed to connect network or service",  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));; 
	  }
	return result;
	
	}
  
  
  public static String GET_JSON_GETNG(String URL) throws Exception {
	

	  String sURL = "http://apapns43.pdc.aa.com:8080/GetNGServices/getng/getStationList"; //just a string

	    // Connect to the URL using java's native library
	  URL url = new URL(sURL); 
	  HttpURLConnection conn = (HttpURLConnection)url.openConnection();
	  conn.setRequestProperty("Accept", "application/json");
	 conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
	  conn.setRequestMethod("GET"); 
		  conn.connect();
		 
		  JsonParser jp = new JsonParser(); //from gson
		    JsonElement root = jp.parse(new InputStreamReader((InputStream) conn.getContent())); 
		    String Response = root.toString();
		    
		    System.out.print(Response);
			return Response;
			}
	  
	  
		
	
  }
