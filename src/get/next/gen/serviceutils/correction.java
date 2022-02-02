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
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

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

import com.relevantcodes.extentreports.LogStatus;

import atu.testng.reports.ATUReports;
import atu.testng.reports.logging.LogAs;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;


import atu.testng.reports.listeners.ATUReportsListener;
import atu.testng.reports.listeners.ConfigurationListener;
import atu.testng.reports.listeners.MethodListener;
@Listeners({ ATUReportsListener.class, ConfigurationListener.class,
MethodListener.class })


public class correction extends CommonTest {
  //public static void main(String myHelpers[]) throws Exception{
	  
	  public static ArrayList<String> startcode(String url,String request,String urls,String sta, String Datatopull ) throws Exception{
		  String url1=url;
		  String url3=urls;
	  	  String request12=request;
	  	  GettheResponsefromService(url1,request12,urls,Datatopull );	  
	  //	  PullAttributetoExcelSheet(sta);
	  	ArrayList<String> Returnthisvalue = DataPuller("json1.txt",sta,Datatopull);
	  	return Returnthisvalue;
  }
  

  
  public static ArrayList<String>  DataPuller(String path, String sta,  String DataPuller) throws Exception{
	  
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
			String Rightstartkey = Testprint11.getJSONObject("flight").getString(DataPuller);
				
				 if(Rightstartkey.contains("Y")||Rightstartkey.contains("y"))
				 {
					 String Flightnumber = Testprint11.getJSONObject("flight").getString("fltNum");
						 
					 Righstartlist.add(Flightnumber);
					 
				 }else{
					 
				 }
			}catch(Exception newexception)
			{
				System.out.print("");
			}
				
			}
			
			
			

		
		 return  (ArrayList<String>) Righstartlist;
		
				

	  
  }
  
  

  //***************************************************************************


  
  
  public static void GettheResponsefromService(String strurl,String request1,String strurl2, String DatatoPull) throws Exception{
		

		
		//&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
		
		//Fetch data from GETNextGen and get the NextGen Flight count
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date = new java.util.Date();
		String dateWithoutTime =dateFormat.format(date);   //"02 May 2016"; 
		String jsonString1 = request1;
		SendRequest(strurl,jsonString1,"json1.txt");
			
  }
  
  
  
  
  public static String SendRequest(String URL, String jsonString,String path) throws Exception {
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
	//	System.out.println("JSON Response:" + result);
		
		try (FileWriter file = new FileWriter(path)) {
			file.write(result);
		in.close();
		conn.disconnect();
		}
		long endTime=Calendar.getInstance().getTimeInMillis();
		long responsetime = startTime-endTime;
	//	System.out.println("The Total time taken for url  "+"   "+ URL+"is"+responsetime+ "   milliseconds");
		return result;
	}
  
  
  /* Before and after Server restart comparison script 
   * Check both old and New response exist in project folder to perform validation
   * Captured the response manually from UI and store it in notepad and passed the notepad name in Script to perform validation
   */
  
  public static void Beforeandafterserverrestartstartcode(String url,String url_cache,String station,String strStartTime,String strEndTime) throws Exception{
	   
	  
	  	String url1=url;
		String url_cache1=url_cache;
		String station1=station;
		String strStartTime1=strStartTime;
		String strEndTime1=strEndTime;

		BeforeandafterNotepadtoexcelFlightdetails1(url1,url_cache1,station);

	
	
}


  public static String nexthrs(String timzoneids,int hrsdec){
		
		SimpleDateFormat dateFormat = new SimpleDateFormat();
		dateFormat.setTimeZone(TimeZone.getTimeZone(timzoneids));
		GregorianCalendar cal = (GregorianCalendar) Calendar.getInstance();
		cal.add(Calendar.DATE, 0);	   
		cal.add(Calendar.HOUR, 6+hrsdec);	
//		String dateandtime = dateFormat.format(cal.getTime());
		String result = cal.getTime().toInstant().truncatedTo(ChronoUnit.SECONDS ).atZone( ZoneId.of( timzoneids ) ).format( DateTimeFormatter.ofPattern( "HH:mm:ss" ).withLocale( Locale.US ) );
		
		return result;
		
	}
	  



public static void BeforeandafterNotepadtoexcelFlightdetails1(String path,String path2,String station) throws Exception{
	
long mil =System.currentTimeMillis();
String st, full,append,le,extend, extended,st2, full2;
full="";
full2="";
extended="";

	
BufferedReader br = new BufferedReader(new FileReader(path));
while ((st=br.readLine())!=null) {
    full+=st;
	  }

JSONArray jsonObj1 = new JSONArray(full);
int Sizeofarray = jsonObj1.length();
System.out.println(Sizeofarray);


BufferedReader br2 = new BufferedReader(new FileReader(path2));
while ((st2=br2.readLine())!=null) {
    full2+=st2;
	  }

JSONArray jsonObj2 = new JSONArray(full2);

int Sizeofarray1 = jsonObj2.length();
System.out.println(Sizeofarray1);



int Forloop1 =   jsonObj1.length();
int Forloop2 =   jsonObj2.length();
int res1,res2;
res1 = Forloop1;
res2 = Forloop2;
int counter1,counter2;


if(Sizeofarray>Sizeofarray1){
	  
	  for(counter1=0;counter1<Sizeofarray;counter1++){
		  
		try{  
		 String jsonnametocompare1 =  jsonObj1.getJSONObject(counter1).toString();
		 String Fltkey =  jsonObj1.getJSONObject(counter1).getJSONObject("flight").getString("fltKey");
		 //System.out.println(jsonnametocompare1);

		 for(counter2=0;counter2<Sizeofarray1;counter2++){
			 try{
			 String jsonnametocompare2 =  jsonObj2.getJSONObject(counter2).toString();
			 String Fltkey2 =  jsonObj2.getJSONObject(counter2).getJSONObject("flight").getString("fltKey");
			// System.out.println(jsonnametocompare2);
			 
			 if(Fltkey.equalsIgnoreCase(Fltkey2)){
				 if(jsonnametocompare1.equalsIgnoreCase(jsonnametocompare2))
				 {
					 System.out.println("");
				 }
				 else{
					 
					 System.out.println(jsonnametocompare1);
					 System.out.println(jsonnametocompare2);
					 System.out.println("Fail"); 
					 ATUReports.add( jsonnametocompare1,  LogAs.INFO, null);
					 ATUReports.add( jsonnametocompare2,  LogAs.INFO, null);
					 ATUReports.add( "Fail",  LogAs.FAILED, null);
				 }
			 }
			 }catch(Exception EE){
				 
			 }
		 }
		}catch(Exception EE){
			 
		 }
		 }
		  
	  }
	  
}

/*
if(res2<res1){

for(counter2=0;counter2<res2;counter2++){
	  
	 String jsonnametocompare2 =  jsonname2[counter2];
	 
	 for(counter1=0;counter1<res1;counter1++){
		 
		 String jsonnametocompare1 =  jsonname1[counter1];
		 
		 if(jsonnametocompare1.contains(jsonnametocompare2)){
			 
			String jsoncompare2 = jsonObj2.getJSONArray(jsonnametocompare1).toString().trim();
			String jsoncompare1 = jsonObj1.getJSONArray(jsonnametocompare2).toString().trim();
			
			int jsoncompare2length = jsoncompare2.length();
			int jsoncompare1length = jsoncompare1.length();
			if(jsoncompare2length == jsoncompare1length )
			{
				System.out.println("Pass");
			}else{
				
					System.out.println("Fail");
					System.out.println("One:::"+jsoncompare2);
					System.out.println("Two:::"+jsoncompare1);
					
					
					 
				
			}
			
		 }else{
			 
		 }
		 
	 }
	  
}
	  
} 
*/
   


  
  
  /*
   * Below code compere two services of tarmac
   * 
   */
public static void CompareTarmacreportstartcode(String url,String request,String urls,String sta ) throws Exception{
	  String url1=url;
	  String url3=urls;
	  String request12=request;
	CompareTarmacreportGETNGReponse(url1,request12,urls);	  
	CompareTarmacreportPullAttributetoExcelSheet(sta); 
}


public static void CompareTarmacreportPullAttributetoExcelSheet(String sta) throws Exception{
	  CompareTarmacreportCompareresponse("json1.txt","json2.txt",sta);

}

public static String getdate(String timzoneids){
	
	SimpleDateFormat dateFormat = new SimpleDateFormat();
	dateFormat.setTimeZone(TimeZone.getTimeZone(timzoneids));
	GregorianCalendar cal = (GregorianCalendar) Calendar.getInstance();
	cal.add(Calendar.DATE, 0);	   
	cal.add(Calendar.MINUTE, 30);	
//	String dateandtime = dateFormat.format(cal.getTime());
	String result = cal.getTime().toInstant().truncatedTo(ChronoUnit.SECONDS ).atZone( ZoneId.of( timzoneids ) ).format( DateTimeFormatter.ofPattern( "MM-dd" ).withLocale( Locale.US ) );

	return result;
	
}

public static void CompareTarmacreportCompareresponse(String path1,String path2,String sta) throws Exception{
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
		ATUReports.add(Response1, LogAs.INFO, new CaptureScreen(ScreenshotOf.DESKTOP)); 
		
		//test.log(LogStatus.INFO, Response2);
		ATUReports.add(Response2, LogAs.INFO, new CaptureScreen(ScreenshotOf.DESKTOP)); 
		//test.log(LogStatus.PASS, "Respose Matches for Station "+sta);
		ATUReports.add("Respose Matches for Station "+sta, LogAs.PASSED, null); 
	}
	else{
		 System.out.println(Response2 );
		 System.out.println(Response1 );
		 System.out.println("================= Fail================================");
	}
}
//***************************************************************************

public static void CompareTarmacreportGETNGReponse(String strurl,String request1,String strurl2) throws Exception{
	
//&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
	
	//Fetch data from GETNextGen and get the NextGen Flight count
	DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	java.util.Date date = new java.util.Date();
	String dateWithoutTime =dateFormat.format(date);   //"02 May 2016"; 
	String jsonString1 = request1;
	CompareTarmacreportPOST_JSON_GETNG(strurl,jsonString1,"json1.txt");
	CompareTarmacreportPOST_JSON_GETNG(strurl2,jsonString1,"json2.txt");	
}




public static String CompareTarmacreportPOST_JSON_GETNG(String URL, String jsonString,String path) throws Exception {
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
}
  
  
  
/*
 * Below function are for Nov release where new eqtype is implemented and removed old EQType
 * 
 */


public static void VerifyNewEQtypeInclusionstartcode(String url,String url_cache,String station,String strStartTime,String strEndTime) throws Exception{
		  	String url1=url;
		String url_cache1=url_cache;
		String station1=station;
		String strStartTime1=strStartTime;
		String strEndTime1=strEndTime;

		VerifyNewEQtypeInclusionGETNGReponse(url1,url_cache1,station1,strStartTime1,strEndTime1);
		VerifyNewEQtypeInclusionNotepadtoexcelFlightdetails1("json1.txt");
		VerifyNewEQtypeInclusionNotepadtoexcelFlightdetails1("json2.txt");
}


public static void VerifyNewEQtypeInclusionNotepadtoexcelFlightdetails1(String path) throws Exception{
	
long mil =System.currentTimeMillis();
String st, full,append,le,extend, extended;
full="";
extended="";

	
BufferedReader br = new BufferedReader(new FileReader(path));
while ((st=br.readLine())!=null) {
    full+=st;
	  }

JSONArray jsonObj1 = new JSONArray(full);
XSSFWorkbook workbook = new XSSFWorkbook();
XSSFSheet sheet = workbook.createSheet("FlightgiventimeFlightDetails");
 for (int i=0;i<jsonObj1.length();i++)
{
 JSONObject Testprint1 = jsonObj1.getJSONObject(i);
	String obj1 =    jsonObj1.getJSONObject(i).toString();
	String Intermediateobject = obj1.replace("{", "");
	String Intermediateobject1 = Intermediateobject.replace("}", "");
	String Intermediateobject2 = Intermediateobject1.replace("\"", "");
	

	try
		{
		try{
		String EqpType =  	Testprint1.getJSONObject("flight").getString("assignedEquipType");
		try{
		if(EqpType.contains("738M"))
		{
			String Flightkey = Testprint1.getJSONObject("flight").getString("fltKey");
			System.out.println("New Eqptype exist :  " +EqpType+"   "+Flightkey);
		}
		
		if(EqpType.contains("H75H"))
		{
			String Flightkey = Testprint1.getJSONObject("flight").getString("fltKey");
			System.out.println(" Eqptype exist Fail :  " +EqpType+"   "+Flightkey);
		}
		
		if(EqpType.contains("757E"))
		{
			String Flightkey = Testprint1.getJSONObject("flight").getString("fltKey");
			System.out.println(" Eqptype exist Fail :  " +EqpType+"   "+Flightkey);
		}
		
		if(EqpType.contains("H757H"))
		{
			String Flightkey = Testprint1.getJSONObject("flight").getString("fltKey");
			System.out.println(" Eqptype exist Pass :  " +EqpType+"   "+Flightkey);
		}
		
		if(EqpType.contains("757X"))
		{
			String Flightkey = Testprint1.getJSONObject("flight").getString("fltKey");
			System.out.println(" Eqptype exist Pass :  " +EqpType+"   "+Flightkey);
		}
		}catch (Exception EE)
		{
			System.out.println(" Issue in fetching flightkey for EQTYPE :  " +EqpType);
		}
		
		}

		catch (Exception EE)
		{
		System.out.println("No Eqptype  for Fightno ");
		}
	
	}catch (Exception EE)
	{
		System.out.println("No Flight No " );
	}
	   
}

   }
//***************************************************************************


public static void VerifyNewEQtypeInclusionGETNGReponse(String strurl,String strurl_cache, String strStation, String strStartTime, String strEndTime) throws Exception{
	
	int count=0;
	int count1=0;
	int counter1=0;
	int counter=0;
	String NextGen_Fltnum =null;
	ArrayList al=new ArrayList();
	ArrayList al_new=new ArrayList();	
	String NextGenCache_Fltnum =null;
	String NextGen_Fltnum_cache=null; 
	String Next_Fltnum=null;
	
	//Fetch data from GETNextGen and get the NextGen Flight count
	DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	java.util.Date date = new java.util.Date();
	String dateWithoutTime =dateFormat.format(date);   //"02 May 2016"; 
	String strStartTime2 = dateWithoutTime + "T" + strStartTime +".737Z";
	String strEndTime2 = dateWithoutTime + "T" + strEndTime +".737Z";
		String jsonString1 = "{\"station\":\""+ strStation + "\",\"pastFlights\":\"true\",\"startTime\":\""+ strStartTime2 + "\",\"endTime\":\""+ strEndTime2 + "\",\"allGates\":true,\"transactionId\":\"00761361_DFW_1473291707741_201\"}";
	String strTotalFlights_NG = VerifyNewEQtypeInclusionPOST_JSON_GETNG(strurl,jsonString1,"json1.txt");
	if(strTotalFlights_NG.equals("") || strTotalFlights_NG.equals("null")){
 		System.out.println("Invalid response from GETNG service");
 	}	
 	strTotalFlights_NG = strTotalFlights_NG.trim();
	String[] arrstrNGTotalFlights = strTotalFlights_NG.split("fltKey\":\""); //"fltKey":"AA,3698,2016-09-19,DFW,0"
	int GETNG_TotalFlights = (arrstrNGTotalFlights.length-1);
	String strTotalFlights_NGCache = VerifyNewEQtypeInclusionPOST_JSON_GETNG(strurl_cache,jsonString1,"json2.txt");
}




public static String VerifyNewEQtypeInclusionPOST_JSON_GETNG(String URL, String jsonString,String path) throws Exception {
  System.out.println("Sending POST Request with value " + jsonString + " to URL:" + URL);
  
  long startTime=Calendar.getInstance().getTimeInMillis();
  
  URL url = new URL(URL);
  String json = new String(jsonString);
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
		String result = org.apache.commons.io.IOUtils.toString(in,"UTF-8"); // response is stored in result
	try (FileWriter file = new FileWriter(path)) {
		file.write(result);
	in.close();
	conn.disconnect();
	}
	long endTime=Calendar.getInstance().getTimeInMillis();
	long responsetime = startTime-endTime;
	System.out.println("The Total time taken for url  "+"   "+ URL+"is"+responsetime+ "   milliseconds");
	return result;
}

  

/*
 * Below script will run across all station and check the alerts
 */



public static void EventAlertingIdentificationstartcode(String url,String request,String urls,String sta ) throws Exception{
	  String url1=url;
	  String url3=urls;
  	  String request12=request;
  	EventAlertingIdentificationGETNGReponse(url1,request12,urls);	  
  	EventAlertingIdentificationPullAttributetoExcelSheet(sta);
   }


public static void EventAlertingIdentificationPullAttributetoExcelSheet(String sta) throws Exception{
	
  EventAlertingIdentificationDataPuller("json1.txt","Catering","EventAlert_Catering.xlsx",sta);

}

public static void EventAlertingIdentificationDataPuller(String path,String SheetName,String ExcelName, String sta) throws Exception{
  
  		Date date = new Date();
	    TimeZone.setDefault(TimeZone.getTimeZone("GMT"));
	    Calendar cal = Calendar.getInstance(TimeZone.getDefault());
	    date = cal.getTime();
	    String timee = date.toGMTString();
	    long timeeunixx = cal.getTimeInMillis();
	    long mil =System.currentTimeMillis();
  	String st, full,append,le,extend, extended;
  	full="";
  	extended="";
  	BufferedReader br = new BufferedReader(new FileReader(path));
  	while ((st=br.readLine())!=null) {
      full+=st;
  	}
  	JSONArray jsonObj1 = new JSONArray(full);
  	 System.out.println("Response  :: "+full);
	for (int ii=0;ii<jsonObj1.length();ii++)
		
	{
		int rowCountt = ii;
		rowCountt++; 
		JSONObject Testprint11 = jsonObj1.getJSONObject(ii);
	 
		try{
			 String fltkey = Testprint11.getJSONObject("flight").getString("assignedEquipType").replace(",", " ");
			 String fltkey1 = Testprint11.getJSONObject("flight").getString("fltKey").replace(",", " ");
		 try{					
			 String event1 = Testprint11.getJSONObject("addlFlightData").getJSONObject("eventList").getJSONObject("bags").getString("eventStatus");
			 String event2 = Testprint11.getJSONObject("addlFlightData").getJSONObject("eventList").getJSONObject("bags").getString("eventAlertStatus");
						 if(event1.contains("N"))
			 {
				 
			 }
			 else{
				 System.out.println(fltkey1+"  "+sta+"  "+event1+"  "+"  "+event2+" bags ");
			 }
			 
			 
			 }catch(Exception EEE){
				// System.out.println(fltkey1+"  "+sta+"  "+"bags Exception");
			 }
			 
			 
			 try{					
				 String event1 = Testprint11.getJSONObject("addlFlightData").getJSONObject("eventList").getJSONObject("lavs").getString("eventStatus");
				 String event2 = Testprint11.getJSONObject("addlFlightData").getJSONObject("eventList").getJSONObject("lavs").getString("eventAlertStatus");
							 if(event1.contains("N"))
				 {
					 
				 }
				 else{
					 System.out.println(fltkey1+"  "+sta+"  "+event1+"  "+"  "+event2+" lavs");
				 }
				 
				 
				 }catch(Exception EEE){
					// System.out.println(fltkey1+"  "+sta+"  "+"lavs Exception");
				 }
			 try{					
				 String event1 = Testprint11.getJSONObject("addlFlightData").getJSONObject("eventList").getJSONObject("pax").getString("eventStatus");
				 String event2 = Testprint11.getJSONObject("addlFlightData").getJSONObject("eventList").getJSONObject("pax").getString("eventAlertStatus");
							 if(event1.contains("N"))
				 {
					 
				 }
				 else{
					 System.out.println(fltkey1+"  "+sta+"  "+event1+"  "+"  "+event2+" pax");
				 }
				 
				 
				 }catch(Exception EEE){
					// System.out.println(fltkey1+"  "+sta+"  "+"pax Exception");
				 }
			 try{					
				 String event1 = Testprint11.getJSONObject("addlFlightData").getJSONObject("eventList").getJSONObject("offload").getString("eventStatus");
				 String event2 = Testprint11.getJSONObject("addlFlightData").getJSONObject("eventList").getJSONObject("offload").getString("eventAlertStatus");
							 if(event1.contains("N"))
				 {
					 
				 }
				 else{
					 System.out.println(fltkey1+"  "+sta+"  "+event1+"  "+"  "+event2+" offload");
				 }
				 
				 
				 }catch(Exception EEE){
					// System.out.println(fltkey1+"  "+sta+"  "+"offload Exception");
				 }
			 try{					
				 String event1 = Testprint11.getJSONObject("addlFlightData").getJSONObject("eventList").getJSONObject("fueling").getString("eventStatus");
				 String event2 = Testprint11.getJSONObject("addlFlightData").getJSONObject("eventList").getJSONObject("fueling").getString("eventAlertStatus");
							 if(event1.contains("N"))
				 {
					 
				 }
				 else{
					 System.out.println(fltkey1+"  "+sta+"  "+event1+"  "+"  "+event2+" fueling");
				 }
				 
				 
				 }catch(Exception EEE){
					// System.out.println(fltkey1+"  "+sta+"  "+"fueling Exception");
				 }
			 try{					
				 String event1 = Testprint11.getJSONObject("addlFlightData").getJSONObject("eventList").getJSONObject("cabin").getString("eventStatus");
				 String event2 = Testprint11.getJSONObject("addlFlightData").getJSONObject("eventList").getJSONObject("cabin").getString("eventAlertStatus");
							 if(event1.contains("N"))
				 {
					 
				 }
				 else{
					 System.out.println(fltkey1+"  "+sta+"  "+event1+"  "+"  "+event2+" cabin");
				 }
				 
				 
				 }catch(Exception EEE){
					// System.out.println(fltkey1+"  "+sta+"  "+"cabin Exception");
				 }
			 try{					
				 String event1 = Testprint11.getJSONObject("addlFlightData").getJSONObject("eventList").getJSONObject("claimscan").getString("eventStatus");
				 String event2 = Testprint11.getJSONObject("addlFlightData").getJSONObject("eventList").getJSONObject("claimscan").getString("eventAlertStatus");
							 if(event1.contains("N"))
				 {
					 
				 }
				 else{
					 System.out.println(fltkey1+"  "+sta+"  "+event1+"  "+"  "+event2+" claimscan");
				 }
				 
				 
				 }catch(Exception EEE){
					// System.out.println(fltkey1+"  "+sta+"  "+"claimscan Exception");
				 }
			 try{					
				 String event1 = Testprint11.getJSONObject("addlFlightData").getJSONObject("eventList").getJSONObject("crew").getString("eventStatus");
				 String event2 = Testprint11.getJSONObject("addlFlightData").getJSONObject("eventList").getJSONObject("crew").getString("eventAlertStatus");
							 if(event1.contains("N"))
				 {
					 
				 }
				 else{
					 System.out.println(fltkey1+"  "+sta+"  "+event1+"  "+"  "+event2+" crew");
				 }
				 
				 
				 }catch(Exception EEE){
					// System.out.println(fltkey1+"  "+sta+"  "+"crew Exception");
				 }
			 try{					
				 String event1 = Testprint11.getJSONObject("addlFlightData").getJSONObject("eventList").getJSONObject("catering").getString("eventStatus");
				 String event2 = Testprint11.getJSONObject("addlFlightData").getJSONObject("eventList").getJSONObject("catering").getString("eventAlertStatus");
							 if(event1.contains("N"))
				 {
					 
				 }
				 else{
					 System.out.println(fltkey1+"  "+sta+"  "+event1+"  "+"  "+event2+" catering");
				 }
				 
				 
				 }catch(Exception EEE){
					// System.out.println(fltkey1+"  "+sta+"  "+"catering Exception");
				 }
			 try{					
				 String event1 = Testprint11.getJSONObject("addlFlightData").getJSONObject("eventList").getJSONObject("water").getString("eventStatus");
				 String event2 = Testprint11.getJSONObject("addlFlightData").getJSONObject("eventList").getJSONObject("water").getString("eventAlertStatus");
							 if(event1.contains("N"))
				 {
					 
				 }
				 else{
					 System.out.println(fltkey1+"  "+sta+"  "+event1+"  "+"  "+event2+" water");
				 }
				 }catch(Exception EEE){
					 //System.out.println(fltkey1+"  "+sta+"  "+"water Exception");
				 }
		}
		 catch(Exception EEE)
		 {
			 
		 }
		}
  
}

//***************************************************************************

public static void EventAlertingIdentificationGETNGReponse(String strurl,String request1,String strurl2) throws Exception{
	//Fetch data from GETNextGen and get the NextGen Flight count
	DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	java.util.Date date = new java.util.Date();
	String dateWithoutTime =dateFormat.format(date);   //"02 May 2016"; 
	String jsonString1 = request1;
	EventAlertingIdentificationPOST_JSON_GETNG(strurl,jsonString1,"json1.txt");
		
}

public static String EventAlertingIdentificationPOST_JSON_GETNG(String URL, String jsonString,String path) throws Exception {
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
	try (FileWriter file = new FileWriter(path)) {
		file.write(result);
	in.close();
	conn.disconnect();
	}
	long endTime=Calendar.getInstance().getTimeInMillis();
	long responsetime = startTime-endTime;
	System.out.println("JSON Response:" + result);
	return result;
}


/*
 * Tarmacfinderscript
 */

public static void TarmacFinderstartcode(String url,String request,String urls,String sta ) throws Exception{
	  String url1=url;
	  String url3=urls;
	  String request12=request;
	TarmacFinderGETNGReponse(url1,request12,urls);	   
}

public static void TarmacFinderGETNGReponse(String strurl,String request1,String strurl2) throws Exception{
//Fetch data from GETNextGen and get the NextGen Flight count
	DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	java.util.Date date = new java.util.Date();
	String dateWithoutTime =dateFormat.format(date); 
	String jsonString1 = request1;
	TarmacFinderPOST_JSON_GETNG(strurl,jsonString1,"json1.txt");
		
}

public static String TarmacFinderPOST_JSON_GETNG(String URL, String jsonString,String path) throws Exception {
  long startTime=Calendar.getInstance().getTimeInMillis();
   URL url = new URL(URL);
  String json = new String(jsonString);
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
	InputStream in = new BufferedInputStream(conn.getInputStream());
	String result = org.apache.commons.io.IOUtils.toString(in,"UTF-8"); // response is stored in result
	try (FileWriter file = new FileWriter(path)) {
		file.write(result);
	in.close();
	conn.disconnect();
	}
	long endTime=Calendar.getInstance().getTimeInMillis();
	long responsetime = startTime-endTime;
	System.out.println("JSON Response:" + result);
	return result;
}

/*
 * US671614Tarmac greater than 15. check appropriate timing present in all duration objects
 */


public static void Tarmacgreaterthan15startcode(String url, String request, String urls, String sta) throws Exception {
	String url1 = url;
	String request12 = request;
	Tarmacgreaterthan15GETNGReponse(url1, request12, urls);
	Tarmacgreaterthan15PullAttributetoExcelSheet(sta);

}


public static void CheckTarmacdescending(String url, String request, String urlCache, String sta) throws Exception {

	Tarmacgreaterthan15GETNGReponse(url, request, urlCache);
	Descendingordervalidation("json1.txt",  sta);

}



public static void Tarmacgreaterthan15PullAttributetoExcelSheet(String sta) throws Exception {

	Tarmacgreaterthan15DataPuller("json1.txt", "Catering", "EventAlert_Catering.xlsx", sta);

}


public static String gettime(String timzoneids){
	
	SimpleDateFormat dateFormat = new SimpleDateFormat();
	dateFormat.setTimeZone(TimeZone.getTimeZone(timzoneids));
	GregorianCalendar cal = (GregorianCalendar) Calendar.getInstance();
	cal.add(Calendar.DATE, 0);	   
	cal.add(Calendar.MINUTE, 40);	
//	String dateandtime = dateFormat.format(cal.getTime());
	String result = cal.getTime().toInstant().truncatedTo(ChronoUnit.SECONDS ).atZone( ZoneId.of( timzoneids ) ).format( DateTimeFormatter.ofPattern( "HH:mm:ss" ).withLocale( Locale.US ) );
	
	return result;
	
}

public static String getStarttime(String timzoneids,int pastminutes){
	
	SimpleDateFormat dateFormat = new SimpleDateFormat();
	dateFormat.setTimeZone(TimeZone.getTimeZone(timzoneids));
	GregorianCalendar cal = (GregorianCalendar) Calendar.getInstance();
	cal.add(Calendar.DATE, 0);	   
	cal.add(Calendar.HOUR, 6);	
	cal.add(Calendar.MINUTE, pastminutes);	
//	String dateandtime = dateFormat.format(cal.getTime());
	String result = cal.getTime().toInstant().truncatedTo(ChronoUnit.SECONDS ).atZone( ZoneId.of( timzoneids ) ).format( DateTimeFormatter.ofPattern( "HH:mm:ss" ).withLocale( Locale.US ) );
	
	return result;
	
}


public static String getEndtime(String timzoneids,int pastminutes){
	
	SimpleDateFormat dateFormat = new SimpleDateFormat();
	dateFormat.setTimeZone(TimeZone.getTimeZone(timzoneids));
	GregorianCalendar cal = (GregorianCalendar) Calendar.getInstance();
	cal.add(Calendar.DATE, 0);	   
	cal.add(Calendar.HOUR, 6);	
	cal.add(Calendar.MINUTE, -pastminutes);	
//	String dateandtime = dateFormat.format(cal.getTime());
	String result = cal.getTime().toInstant().truncatedTo(ChronoUnit.SECONDS ).atZone( ZoneId.of( timzoneids ) ).format( DateTimeFormatter.ofPattern( "HH:mm:ss" ).withLocale( Locale.US ) );
	
	return result;
	
}

public static String getpreviousdate(String timzoneids){
	
	SimpleDateFormat dateFormat = new SimpleDateFormat();
	dateFormat.setTimeZone(TimeZone.getTimeZone(timzoneids));
	GregorianCalendar cal = (GregorianCalendar) Calendar.getInstance();
	cal.add(Calendar.DATE, -1);	   
	cal.add(Calendar.MINUTE, 30);	
//	String dateandtime = dateFormat.format(cal.getTime());
	String result = cal.getTime().toInstant().truncatedTo(ChronoUnit.SECONDS ).atZone( ZoneId.of( timzoneids ) ).format( DateTimeFormatter.ofPattern( "MM-dd" ).withLocale( Locale.US ) );

	return result;
	
}

public static void Descendingordervalidation(String path, String sta)
		throws Exception {

	Date date = new Date();
	TimeZone.setDefault(TimeZone.getTimeZone("GMT"));
	Calendar cal = Calendar.getInstance(TimeZone.getDefault());
	date = cal.getTime();
	String timee = date.toGMTString();
	long timeeunixx = cal.getTimeInMillis();
	
	
    List<String> MainDep60 = new ArrayList<>();
    List<String> MainDep30 = new ArrayList<>();
    List<String> MainDep45 = new ArrayList<>();
    List<String> MainDep15 = new ArrayList<>();
    List<String> MainDep120 = new ArrayList<>();
    List<String> MainDep150 = new ArrayList<>();
    List<String> MainDep90 = new ArrayList<>();
    List<String> MainDep180 = new ArrayList<>();
    List<String> MainArr15 = new ArrayList<>();
    List<String> MainArr30 = new ArrayList<>();
    List<String> MainArr45 = new ArrayList<>();
    List<String> MainArr60 = new ArrayList<>();
    List<String> MainArr90 = new ArrayList<>();
    List<String> MainArr120 = new ArrayList<>();
    List<String> MainArr150 = new ArrayList<>();
    List<String> MainArr180 = new ArrayList<>();
  
	
    List<String> RegDep60 = new ArrayList<>();
    List<String> RegDep30 = new ArrayList<>();
    List<String> RegDep45 = new ArrayList<>();
    List<String> RegDep15 = new ArrayList<>();
    List<String> RegDep120 = new ArrayList<>();
    List<String> RegDep150 = new ArrayList<>();
    List<String> RegDep90 = new ArrayList<>();
    List<String> RegDep180 = new ArrayList<>();
    List<String> RegArr15 = new ArrayList<>();
    List<String> RegArr45 = new ArrayList<>();
    List<String> RegArr30 = new ArrayList<>();
    List<String> RegArr60 = new ArrayList<>();
    List<String> RegArr90 = new ArrayList<>();
    List<String> RegArr120 = new ArrayList<>();
    List<String> RegArr150 = new ArrayList<>();
    List<String> RegArr180 = new ArrayList<>();
	
	
	
	
	
	
	
	
	
	
	
	

	long mil = System.currentTimeMillis();
	String st, full, append, le, extend, extended;
	full = "";
	extended = "";
	BufferedReader br = new BufferedReader(new FileReader(path));
	while ((st = br.readLine()) != null) {
		full += st;
	}

		JSONObject jsonObj1 = new JSONObject(full);
		JSONObject jsonObj2 = new JSONObject(full);
		try {
			JSONObject Testprint11 = (JSONObject) jsonObj1.get("mainlineList");
			JSONObject Testprint12 = (JSONObject) jsonObj2.get("regionalList");
			System.out.println(jsonObj1);
			try {

				if (Testprint11.get("depTarmac").toString().equals("null")) {
					// //System.out.println("null");
				} else {

					int getGt15 = Testprint11.getJSONObject("depTarmac").getJSONArray("longOnBoardGT45").length();
					for (int mia = 0; mia < getGt15; mia++) {
						// System.out.println(Testprint11.getJSONObject("depTarmac").getJSONArray("longOnBoardGT45").getJSONObject(mia).getInt("duration"));
						int duration = Testprint11.getJSONObject("depTarmac").getJSONArray("longOnBoardGT45")
								.getJSONObject(mia).getInt("duration");
						String durationconverted = String.valueOf(duration);
						MainDep45.add(durationconverted);

					}
				}

			} catch (Exception one) {
			}

			try {

				if (Testprint11.get("depTarmac").toString().equals("null")) {
					// System.out.println("null");
				} else {

					int getGt15 = Testprint11.getJSONObject("depTarmac").getJSONArray("longOnBoardGT60").length();
					for (int mia = 0; mia < getGt15; mia++) {
						// System.out.println(Testprint11.getJSONObject("depTarmac").getJSONArray("longOnBoardGT60").getJSONObject(mia).getInt("duration"));
						int duration = Testprint11.getJSONObject("depTarmac").getJSONArray("longOnBoardGT60")
								.getJSONObject(mia).getInt("duration");
						String durationconverted = String.valueOf(duration);
						MainDep60.add(durationconverted);
						
						
						
						

					}
				}

			} catch (Exception one) {
			}

			try {

				if (Testprint11.get("depTarmac").toString().equals("null")) {
					// //System.out.println("null");
				} else {

					int getGt15 = Testprint11.getJSONObject("depTarmac").getJSONArray("longOnBoardGT30").length();
					for (int mia = 0; mia < getGt15; mia++) {
						// System.out.println(Testprint11.getJSONObject("depTarmac").getJSONArray("longOnBoardGT30").getJSONObject(mia).getInt("duration"));
						int duration = Testprint11.getJSONObject("depTarmac").getJSONArray("longOnBoardGT30")
								.getJSONObject(mia).getInt("duration");
						
						String durationconverted = String.valueOf(duration);
						MainDep30.add(durationconverted);
						
					}
				}

			} catch (Exception one) {
			}

			try {

				if (Testprint11.get("depTarmac").toString().equals("null")) {
					// //System.out.println("null");
				} else {

					int getGt15 = Testprint11.getJSONObject("depTarmac").getJSONArray("longOnBoardGT15").length();
					for (int mia = 0; mia < getGt15; mia++) {
						// System.out.println(Testprint11.getJSONObject("depTarmac").getJSONArray("longOnBoardGT15").getJSONObject(mia).getInt("duration"));
						int duration = Testprint11.getJSONObject("depTarmac").getJSONArray("longOnBoardGT15")
								.getJSONObject(mia).getInt("duration");
						
						String durationconverted = String.valueOf(duration);
						MainDep15.add(durationconverted);
						
						
						

					}
				}

			} catch (Exception one) {
			}

			try {

				if (Testprint11.get("depTarmac").toString().equals("null")) {
					// //System.out.println("null");
				} else {

					int getGt15 = Testprint11.getJSONObject("depTarmac").getJSONArray("longOnBoardGT120").length();
					for (int mia = 0; mia < getGt15; mia++) {
						// System.out.println(Testprint11.getJSONObject("depTarmac").getJSONArray("longOnBoardGT120").getJSONObject(mia).getInt("duration"));
						int duration = Testprint11.getJSONObject("depTarmac").getJSONArray("longOnBoardGT120")
								.getJSONObject(mia).getInt("duration");
						
						
						String durationconverted = String.valueOf(duration);
						MainDep120.add(durationconverted);

					}
				}

			} catch (Exception one) {
			}

			try {

				if (Testprint11.get("depTarmac").toString().equals("null")) {
					// //System.out.println("null");
				} else {

					int getGt15 = Testprint11.getJSONObject("depTarmac").getJSONArray("longOnBoardGT150").length();
					for (int mia = 0; mia < getGt15; mia++) {
						// System.out.println(Testprint11.getJSONObject("depTarmac").getJSONArray("longOnBoardGT150").getJSONObject(mia).getInt("duration"));
						int duration = Testprint11.getJSONObject("depTarmac").getJSONArray("longOnBoardGT150")
								.getJSONObject(mia).getInt("duration");
						
						
						String durationconverted = String.valueOf(duration);
						MainDep150.add(durationconverted);
						
						

					}
				}

			} catch (Exception one) {
			}

			try {

				if (Testprint11.get("depTarmac").toString().equals("null")) {
					// //System.out.println("null");
				} else {

					int getGt15 = Testprint11.getJSONObject("depTarmac").getJSONArray("longOnBoardGT90").length();
					for (int mia = 0; mia < getGt15; mia++) {
						// System.out.println(Testprint11.getJSONObject("depTarmac").getJSONArray("longOnBoardGT90").getJSONObject(mia).getInt("duration"));
						int duration = Testprint11.getJSONObject("depTarmac").getJSONArray("longOnBoardGT90")
								.getJSONObject(mia).getInt("duration");
						
						
						String durationconverted = String.valueOf(duration);
						MainDep90.add(durationconverted);
						

					}
				}

			} catch (Exception one) {
			}
			try {

				if (Testprint11.get("depTarmac").toString().equals("null")) {
					// //System.out.println("null");
				} else {

					int getGt15 = Testprint11.getJSONObject("depTarmac").getJSONArray("longOnBoardGT180").length();
					for (int mia = 0; mia < getGt15; mia++) {
						// System.out.println(Testprint11.getJSONObject("depTarmac").getJSONArray("longOnBoardGT180").getJSONObject(mia).getInt("duration"));
						int duration = Testprint11.getJSONObject("depTarmac").getJSONArray("longOnBoardGT180")
								.getJSONObject(mia).getInt("duration");
						
						String durationconverted = String.valueOf(duration);
						MainDep180.add(durationconverted);
						
						
						

					}
				}

			} catch (Exception one) {
			}
			try {

				if (Testprint12.get("depTarmac").toString().equals("null")) {
					// //System.out.println("null");
				} else {

					int getGt15 = Testprint12.getJSONObject("depTarmac").getJSONArray("longOnBoardGT45").length();
					for (int mia = 0; mia < getGt15; mia++) {
						// System.out.println(Testprint12.getJSONObject("depTarmac").getJSONArray("longOnBoardGT45").getJSONObject(mia).getInt("duration"));
						int duration = Testprint12.getJSONObject("depTarmac").getJSONArray("longOnBoardGT45")
								.getJSONObject(mia).getInt("duration");
						
						
						String durationconverted = String.valueOf(duration);
						MainDep45.add(durationconverted);
						

					}
				}

			} catch (Exception one) {
			}

			try {

				if (Testprint12.get("depTarmac").toString().equals("null")) {
					// //System.out.println("null");
				} else {

					int getGt15 = Testprint12.getJSONObject("depTarmac").getJSONArray("longOnBoardGT60").length();
					for (int mia = 0; mia < getGt15; mia++) {
						// System.out.println(Testprint12.getJSONObject("depTarmac").getJSONArray("longOnBoardGT60").getJSONObject(mia).getInt("duration"));
						int duration = Testprint12.getJSONObject("depTarmac").getJSONArray("longOnBoardGT60")
								.getJSONObject(mia).getInt("duration");
						
						
						String durationconverted = String.valueOf(duration);
						RegDep45.add(durationconverted);
						
						
					}
				}

			} catch (Exception one) {
			}

			try {

				if (Testprint12.get("depTarmac").toString().equals("null")) {
					// //System.out.println("null");
				} else {

					int getGt15 = Testprint12.getJSONObject("depTarmac").getJSONArray("longOnBoardGT30").length();
					for (int mia = 0; mia < getGt15; mia++) {
						// System.out.println(Testprint12.getJSONObject("depTarmac").getJSONArray("longOnBoardGT30").getJSONObject(mia).getInt("duration"));
						int duration = Testprint12.getJSONObject("depTarmac").getJSONArray("longOnBoardGT30")
								.getJSONObject(mia).getInt("duration");
						
						
						
						String durationconverted = String.valueOf(duration);
						RegDep30.add(durationconverted);
						
					}
				}

			} catch (Exception one) {
			}

			try {

				if (Testprint12.get("depTarmac").toString().equals("null")) {
					// //System.out.println("null");
				} else {

					int getGt15 = Testprint12.getJSONObject("depTarmac").getJSONArray("longOnBoardGT15").length();
					for (int mia = 0; mia < getGt15; mia++) {
						// System.out.println(Testprint12.getJSONObject("depTarmac").getJSONArray("longOnBoardGT15").getJSONObject(mia).getInt("duration"));
						int duration = Testprint12.getJSONObject("depTarmac").getJSONArray("longOnBoardGT15")
								.getJSONObject(mia).getInt("duration");
						
						String durationconverted = String.valueOf(duration);
						RegDep15.add(durationconverted);
						
						
						
					}
				}

			} catch (Exception one) {
			}

			try {

				if (Testprint12.get("depTarmac").toString().equals("null")) {
					// //System.out.println("null");
				} else {

					int getGt15 = Testprint12.getJSONObject("depTarmac").getJSONArray("longOnBoardGT120").length();
					for (int mia = 0; mia < getGt15; mia++) {
						// System.out.println(Testprint12.getJSONObject("depTarmac").getJSONArray("longOnBoardGT120").getJSONObject(mia).getInt("duration"));
						int duration = Testprint12.getJSONObject("depTarmac").getJSONArray("longOnBoardGT120")
								.getJSONObject(mia).getInt("duration");
						
						
						
						String durationconverted = String.valueOf(duration);
						RegDep120.add(durationconverted);
						
					}
				}

			} catch (Exception one) {
			}

			try {

				if (Testprint12.get("depTarmac").toString().equals("null")) {
					// //System.out.println("null");
				} else {

					int getGt15 = Testprint12.getJSONObject("depTarmac").getJSONArray("longOnBoardGT150").length();
					for (int mia = 0; mia < getGt15; mia++) {
						// System.out.println(Testprint12.getJSONObject("depTarmac").getJSONArray("longOnBoardGT150").getJSONObject(mia).getInt("duration"));
						int duration = Testprint12.getJSONObject("depTarmac").getJSONArray("longOnBoardGT150")
								.getJSONObject(mia).getInt("duration");
						
						String durationconverted = String.valueOf(duration);
						RegDep150.add(durationconverted);
						
						
					}
				}

			} catch (Exception one) {
			}

			try {

				if (Testprint12.get("depTarmac").toString().equals("null")) {
					// //System.out.println("null");
				} else {

					int getGt15 = Testprint12.getJSONObject("depTarmac").getJSONArray("longOnBoardGT90").length();
					for (int mia = 0; mia < getGt15; mia++) {
						// System.out.println(Testprint12.getJSONObject("depTarmac").getJSONArray("longOnBoardGT90").getJSONObject(mia).getInt("duration"));
						int duration = Testprint12.getJSONObject("depTarmac").getJSONArray("longOnBoardGT90")
								.getJSONObject(mia).getInt("duration");
					
						
						String durationconverted = String.valueOf(duration);
						RegDep90.add(durationconverted);
						
					}
				}

			} catch (Exception one) {
			}

			try {

				if (Testprint12.get("depTarmac").toString().equals("null")) {
					// //System.out.println("null");
				} else {

					int getGt15 = Testprint12.getJSONObject("depTarmac").getJSONArray("longOnBoardGT180").length();
					for (int mia = 0; mia < getGt15; mia++) {
						// System.out.println(Testprint12.getJSONObject("depTarmac").getJSONArray("longOnBoardGT180").getJSONObject(mia).getInt("duration"));
						int duration = Testprint12.getJSONObject("depTarmac").getJSONArray("longOnBoardGT180")
								.getJSONObject(mia).getInt("duration");
						
						
						String durationconverted = String.valueOf(duration);
						RegDep15.add(durationconverted);
						
					}
				}

			} catch (Exception one) {
			}

			try {

				if (Testprint11.get("arrTarmac").toString().equals("null")) {
					// //System.out.println("null");
				} else {

					int getGt15 = Testprint11.getJSONObject("arrTarmac").getJSONArray("longOnBoardGT45").length();
					for (int mia = 0; mia < getGt15; mia++) {
						// System.out.println(Testprint11.getJSONObject("arrTarmac").getJSONArray("longOnBoardGT45").getJSONObject(mia).getInt("duration"));
						int duration = Testprint11.getJSONObject("arrTarmac").getJSONArray("longOnBoardGT45")
								.getJSONObject(mia).getInt("duration");
						
						
						
						String durationconverted = String.valueOf(duration);
						MainArr45.add(durationconverted);
						
					}
				}

			} catch (Exception one) {
			}

			try {

				if (Testprint11.get("arrTarmac").toString().equals("null")) {
					// //System.out.println("null");
				} else {

					int getGt15 = Testprint11.getJSONObject("arrTarmac").getJSONArray("longOnBoardGT60").length();
					for (int mia = 0; mia < getGt15; mia++) {
						// System.out.println(Testprint11.getJSONObject("arrTarmac").getJSONArray("longOnBoardGT60").getJSONObject(mia).getInt("duration"));
						int duration = Testprint11.getJSONObject("arrTarmac").getJSONArray("longOnBoardGT60")
								.getJSONObject(mia).getInt("duration");
						
						
						
						String durationconverted = String.valueOf(duration);
						MainArr60.add(durationconverted);

					}
				}

			} catch (Exception one) {
			}

			try {

				if (Testprint11.get("arrTarmac").toString().equals("null")) {
					// //System.out.println("null");
				} else {

					int getGt15 = Testprint11.getJSONObject("arrTarmac").getJSONArray("longOnBoardGT30").length();
					for (int mia = 0; mia < getGt15; mia++) {
						// System.out.println(Testprint11.getJSONObject("arrTarmac").getJSONArray("longOnBoardGT30").getJSONObject(mia).getInt("duration"));
						int duration = Testprint11.getJSONObject("arrTarmac").getJSONArray("longOnBoardGT30")
								.getJSONObject(mia).getInt("duration");
						
						
						
						String durationconverted = String.valueOf(duration);
						MainArr30.add(durationconverted);
					}
				}

			} catch (Exception one) {
			}

			try {

				if (Testprint11.get("arrTarmac").toString().equals("null")) {
					// //System.out.println("null");
				} else {

					int getGt15 = Testprint11.getJSONObject("arrTarmac").getJSONArray("longOnBoardGT15").length();
					for (int mia = 0; mia < getGt15; mia++) {
						// System.out.println(Testprint11.getJSONObject("arrTarmac").getJSONArray("longOnBoardGT15").getJSONObject(mia).getInt("duration"));
						int duration = Testprint11.getJSONObject("arrTarmac").getJSONArray("longOnBoardGT15")
								.getJSONObject(mia).getInt("duration");
						
						String durationconverted = String.valueOf(duration);
						MainArr15.add(durationconverted);
					
					
					}
				}

			} catch (Exception one) {
			}

			try {

				if (Testprint11.get("arrTarmac").toString().equals("null")) {
					// //System.out.println("null");
				} else {

					int getGt15 = Testprint11.getJSONObject("arrTarmac").getJSONArray("longOnBoardGT120").length();
					for (int mia = 0; mia < getGt15; mia++) {
						// System.out.println(Testprint11.getJSONObject("arrTarmac").getJSONArray("longOnBoardGT120").getJSONObject(mia).getInt("duration"));
						int duration = Testprint11.getJSONObject("arrTarmac").getJSONArray("longOnBoardGT120")
								.getJSONObject(mia).getInt("duration");
						
						
						String durationconverted = String.valueOf(duration);
						MainArr120.add(durationconverted);
						
						
					}
				}

			} catch (Exception one) {
			}

			try {

				if (Testprint11.get("arrTarmac").toString().equals("null")) {
					// //System.out.println("null");
				} else {

					int getGt15 = Testprint11.getJSONObject("arrTarmac").getJSONArray("longOnBoardGT150").length();
					for (int mia = 0; mia < getGt15; mia++) {
						// System.out.println(Testprint11.getJSONObject("arrTarmac").getJSONArray("longOnBoardGT150").getJSONObject(mia).getInt("duration"));
						int duration = Testprint11.getJSONObject("arrTarmac").getJSONArray("longOnBoardGT150")
								.getJSONObject(mia).getInt("duration");
						
						
						String durationconverted = String.valueOf(duration);
						MainArr150.add(durationconverted);
						
						
					}
				}

			} catch (Exception one) {
			}

			try {

				if (Testprint11.get("arrTarmac").toString().equals("null")) {
					// //System.out.println("null");
				} else {

					int getGt15 = Testprint11.getJSONObject("arrTarmac").getJSONArray("longOnBoardGT90").length();
					for (int mia = 0; mia < getGt15; mia++) {
						// System.out.println(Testprint11.getJSONObject("arrTarmac").getJSONArray("longOnBoardGT90").getJSONObject(mia).getInt("duration"));
						int duration = Testprint11.getJSONObject("arrTarmac").getJSONArray("longOnBoardGT90")
								.getJSONObject(mia).getInt("duration");
						
						
						String durationconverted = String.valueOf(duration);
						MainArr90.add(durationconverted);
						
					}
				}

			} catch (Exception one) {
			}

			try {

				if (Testprint11.get("arrTarmac").toString().equals("null")) {
					// //System.out.println("null");
				} else {

					int getGt15 = Testprint11.getJSONObject("arrTarmac").getJSONArray("longOnBoardGT180").length();
					for (int mia = 0; mia < getGt15; mia++) {
						// System.out.println(Testprint11.getJSONObject("arrTarmac").getJSONArray("longOnBoardGT180").getJSONObject(mia).getInt("duration"));
						int duration = Testprint11.getJSONObject("arrTarmac").getJSONArray("longOnBoardGT180")
								.getJSONObject(mia).getInt("duration");
						
						
						
						String durationconverted = String.valueOf(duration);
						MainArr180.add(durationconverted);

					}
				}

			} catch (Exception one) {
			}

			try {

				if (Testprint12.get("arrTarmac").toString().equals("null")) {
					// System.out.println("null");
				} else {

					int getGt15 = Testprint12.getJSONObject("arrTarmac").getJSONArray("longOnBoardGT45").length();
					for (int mia = 0; mia < getGt15; mia++) {
						// System.out.println(Testprint12.getJSONObject("arrTarmac").getJSONArray("longOnBoardGT45").getJSONObject(mia).getInt("duration"));
						int duration = Testprint12.getJSONObject("arrTarmac").getJSONArray("longOnBoardGT45")
								.getJSONObject(mia).getInt("duration");
						
						
						
						String durationconverted = String.valueOf(duration);
						RegArr45.add(durationconverted);
						

					}
				}

			} catch (Exception one) {
			}

			try {

				if (Testprint12.get("arrTarmac").toString().equals("null")) {
					// System.out.println("null");
				} else {

					int getGt15 = Testprint12.getJSONObject("arrTarmac").getJSONArray("longOnBoardGT60").length();
					for (int mia = 0; mia < getGt15; mia++) {
						// System.out.println(Testprint12.getJSONObject("arrTarmac").getJSONArray("longOnBoardGT60").getJSONObject(mia).getInt("duration"));
						int duration = Testprint12.getJSONObject("arrTarmac").getJSONArray("longOnBoardGT60")
								.getJSONObject(mia).getInt("duration");
						
						
						
						
						String durationconverted = String.valueOf(duration);
						RegArr60.add(durationconverted);
						

					}
				}

			} catch (Exception one) {
			}

			try {

				if (Testprint12.get("arrTarmac").toString().equals("null")) {
					// System.out.println("null");
				} else {

					int getGt15 = Testprint12.getJSONObject("arrTarmac").getJSONArray("longOnBoardGT30").length();
					for (int mia = 0; mia < getGt15; mia++) {
						// System.out.println(Testprint12.getJSONObject("arrTarmac").getJSONArray("longOnBoardGT30").getJSONObject(mia).getInt("duration"));
						int duration = Testprint12.getJSONObject("arrTarmac").getJSONArray("longOnBoardGT30")
								.getJSONObject(mia).getInt("duration");
						
						
						
						String durationconverted = String.valueOf(duration);
						RegArr30.add(durationconverted);
						
						
					}
				}

			} catch (Exception one) {
			}

			try {

				if (Testprint12.get("arrTarmac").toString().equals("null")) {
					// System.out.println("null");
				} else {

					int getGt15 = Testprint12.getJSONObject("arrTarmac").getJSONArray("longOnBoardGT15").length();
					for (int mia = 0; mia < getGt15; mia++) {
						// System.out.println(Testprint12.getJSONObject("arrTarmac").getJSONArray("longOnBoardGT15").getJSONObject(mia).getInt("duration"));
						int duration = Testprint12.getJSONObject("arrTarmac").getJSONArray("longOnBoardGT15")
								.getJSONObject(mia).getInt("duration");
						
						
						String durationconverted = String.valueOf(duration);
						RegArr15.add(durationconverted);
						

					}
				}

			} catch (Exception one) {
			}

			try {

				if (Testprint12.get("arrTarmac").toString().equals("null")) {
					// System.out.println("null");
				} else {

					int getGt15 = Testprint12.getJSONObject("arrTarmac").getJSONArray("longOnBoardGT120").length();
					for (int mia = 0; mia < getGt15; mia++) {
						// System.out.println(Testprint12.getJSONObject("arrTarmac").getJSONArray("longOnBoardGT120").getJSONObject(mia).getInt("duration"));
						int duration = Testprint12.getJSONObject("arrTarmac").getJSONArray("longOnBoardGT120")
								.getJSONObject(mia).getInt("duration");
						
						
						String durationconverted = String.valueOf(duration);
						RegArr120.add(durationconverted);
						

					}
				}

			} catch (Exception one) {
			}

			try {

				if (Testprint12.get("arrTarmac").toString().equals("null")) {
					// System.out.println("null");
				} else {

					int getGt15 = Testprint12.getJSONObject("arrTarmac").getJSONArray("longOnBoardGT150").length();
					for (int mia = 0; mia < getGt15; mia++) {
						// System.out.println(Testprint12.getJSONObject("arrTarmac").getJSONArray("longOnBoardGT150").getJSONObject(mia).getInt("duration"));
						int duration = Testprint12.getJSONObject("arrTarmac").getJSONArray("longOnBoardGT150")
								.getJSONObject(mia).getInt("duration");
						
						String durationconverted = String.valueOf(duration);
						RegArr150.add(durationconverted);
						
						
						
					}
				}

			} catch (Exception one) {
			}

			try {

				if (Testprint12.get("arrTarmac").toString().equals("null")) {
					// System.out.println("null");
				} else {

					int getGt15 = Testprint12.getJSONObject("arrTarmac").getJSONArray("longOnBoardGT90").length();
					for (int mia = 0; mia < getGt15; mia++) {
						// System.out.println(Testprint12.getJSONObject("arrTarmac").getJSONArray("longOnBoardGT90").getJSONObject(mia).getInt("duration"));
						int duration = Testprint12.getJSONObject("arrTarmac").getJSONArray("longOnBoardGT90")
								.getJSONObject(mia).getInt("duration");
						
						
						
						String durationconverted = String.valueOf(duration);
						RegArr90.add(durationconverted);
						

					}
				}

			} catch (Exception one) {
			}

			try {

				if (Testprint12.get("arrTarmac").toString().equals("null")) {
					// System.out.println("null");
				} else {

					int getGt15 = Testprint12.getJSONObject("arrTarmac").getJSONArray("longOnBoardGT180").length();
					for (int mia = 0; mia < getGt15; mia++) {
						// System.out.println(Testprint12.getJSONObject("arrTarmac").getJSONArray("longOnBoardGT180").getJSONObject(mia).getInt("duration"));
						int duration = Testprint12.getJSONObject("arrTarmac").getJSONArray("longOnBoardGT180")
								.getJSONObject(mia).getInt("duration");

						
						
						
						String durationconverted = String.valueOf(duration);
						RegArr180.add(durationconverted);

					}
				}

			} catch (Exception one) {
			}

		} catch (Exception Esta) {
			System.out.println("Exception ::  " + sta);
		}
	
		
		
	    System.out.println(MainDep60);
	    List<String> MainDep601 = MainDep60;
	    Collections.sort(MainDep60, Collections.reverseOrder());
	    System.out.println(" ");
	    boolean result = Arrays.equals(MainDep601.toArray(),MainDep60.toArray());
		// Return result
		if(result==true)
		{
			ATUReports.add("Arranged properly in Ascending order",  LogAs.PASSED, null);;// test.log(LogStatus.PASS, "Arranged properly in Ascending order");
			ATUReports.add("Sorted Ascending order is valid::  "+MainDep60,  LogAs.PASSED, null);;// test.log(LogStatus.PASS, "Sorted Ascending order is valid::  "+AllGatevaluessorting);
			System.out.println(result);
		}
		else
		{
			ATUReports.add("Not arranged in Ascending order",  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));;// test.log(LogStatus.FAIL, "Not arranged in Ascending order");
			System.out.println(result);
		}

	    System.out.println(MainDep30);
	    List<String> MainDep301 = MainDep30;
	    Collections.sort(MainDep30, Collections.reverseOrder());
	    System.out.println(" ");
	    boolean result1 = Arrays.equals(MainDep301.toArray(),MainDep30.toArray());
			// Return result
			if(result1==true)
			{
				ATUReports.add("Arranged properly in Ascending order",  LogAs.PASSED, null);;// test.log(LogStatus.PASS, "Arranged properly in Ascending order");
				ATUReports.add("Sorted Ascending order is valid::  "+MainDep60,  LogAs.PASSED, null);;// test.log(LogStatus.PASS, "Sorted Ascending order is valid::  "+AllGatevaluessorting);
				System.out.println(result);
			}
			else
			{
				ATUReports.add("Not arranged in Ascending order",  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));;// test.log(LogStatus.FAIL, "Not arranged in Ascending order");
				System.out.println(result1);
			}
	    
	
	    System.out.println(MainDep45);
	    List<String> MainDep451 = MainDep45;
	    Collections.sort(MainDep45, Collections.reverseOrder());
	    System.out.println(" ");
	    boolean result2 = Arrays.equals(MainDep451.toArray(),MainDep45.toArray());
			// Return result
			if(result2==true)
			{
				ATUReports.add("Arranged properly in Ascending order",  LogAs.PASSED, null);;// test.log(LogStatus.PASS, "Arranged properly in Ascending order");
				ATUReports.add("Sorted Ascending order is valid::  "+MainDep60,  LogAs.PASSED, null);;// test.log(LogStatus.PASS, "Sorted Ascending order is valid::  "+AllGatevaluessorting);
				System.out.println(result2);
			}
			else
			{
				ATUReports.add("Not arranged in Ascending order",  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));;// test.log(LogStatus.FAIL, "Not arranged in Ascending order");
				System.out.println(result2);
			}
	
	    System.out.println(MainDep15);
	    List<String> MainDep151 = MainDep15;
	    Collections.sort(MainDep15, Collections.reverseOrder());
	    System.out.println(" ");
	    boolean result3 = Arrays.equals(MainDep151.toArray(),MainDep15.toArray());
			// Return result
			if(result3==true)
			{
				ATUReports.add("Arranged properly in Ascending order",  LogAs.PASSED, null);;// test.log(LogStatus.PASS, "Arranged properly in Ascending order");
				ATUReports.add("Sorted Ascending order is valid::  "+MainDep60,  LogAs.PASSED, null);;// test.log(LogStatus.PASS, "Sorted Ascending order is valid::  "+AllGatevaluessorting);
				System.out.println(result3);
			}
			else
			{
				ATUReports.add("Not arranged in Ascending order",  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));;// test.log(LogStatus.FAIL, "Not arranged in Ascending order");
				System.out.println(result3);
			}
	
	    System.out.println(MainDep120);
	    List<String> MainDep1201 = MainDep120;
	    Collections.sort(MainDep120, Collections.reverseOrder());
	    System.out.println(" ");
	    boolean result4 = Arrays.equals(MainDep120.toArray(),MainDep1201.toArray());
			// Return result
			if(result4==true)
			{
				ATUReports.add("Arranged properly in Ascending order",  LogAs.PASSED, null);;// test.log(LogStatus.PASS, "Arranged properly in Ascending order");
				ATUReports.add("Sorted Ascending order is valid::  "+MainDep60,  LogAs.PASSED, null);;// test.log(LogStatus.PASS, "Sorted Ascending order is valid::  "+AllGatevaluessorting);
				System.out.println(result4);
			}
			else
			{
				ATUReports.add("Not arranged in Ascending order",  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));;// test.log(LogStatus.FAIL, "Not arranged in Ascending order");
				System.out.println(result4);
			}

	    System.out.println(MainDep150);
	    List<String> MainDep1501 = MainDep150;
	    Collections.sort(MainDep150, Collections.reverseOrder());
	    System.out.println(" ");
	    boolean result5 = Arrays.equals(MainDep1501.toArray(),MainDep150.toArray());
			// Return result
			if(result5==true)
			{
				ATUReports.add("Arranged properly in Ascending order",  LogAs.PASSED, null);;// test.log(LogStatus.PASS, "Arranged properly in Ascending order");
				ATUReports.add("Sorted Ascending order is valid::  "+MainDep60,  LogAs.PASSED, null);;// test.log(LogStatus.PASS, "Sorted Ascending order is valid::  "+AllGatevaluessorting);
				System.out.println(result);
			}
			else
			{
				ATUReports.add("Not arranged in Ascending order",  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));;// test.log(LogStatus.FAIL, "Not arranged in Ascending order");
				System.out.println(result);
			}

	    System.out.println(MainDep90);
	    List<String> MainDep901 = MainDep90;
	    Collections.sort(MainDep90, Collections.reverseOrder());
	    System.out.println(" ");
	    boolean result6 = Arrays.equals(MainDep901.toArray(),MainDep90.toArray());
			// Return result
			if(result6==true)
			{
				ATUReports.add("Arranged properly in Ascending order",  LogAs.PASSED, null);;// test.log(LogStatus.PASS, "Arranged properly in Ascending order");
				ATUReports.add("Sorted Ascending order is valid::  "+MainDep60,  LogAs.PASSED, null);;// test.log(LogStatus.PASS, "Sorted Ascending order is valid::  "+AllGatevaluessorting);
				System.out.println(result);
			}
			else
			{
				ATUReports.add("Not arranged in Ascending order",  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));;// test.log(LogStatus.FAIL, "Not arranged in Ascending order");
				System.out.println(result);
			}

	    System.out.println(MainDep180);
	    List<String> MainDep1801 = MainDep180;
	    Collections.sort(MainDep180, Collections.reverseOrder());
	    System.out.println(" ");
	    boolean result7 = Arrays.equals(MainDep1801.toArray(),MainDep180.toArray());
			// Return result
			if(result7==true)
			{
				ATUReports.add("Arranged properly in Ascending order",  LogAs.PASSED, null);;// test.log(LogStatus.PASS, "Arranged properly in Ascending order");
				ATUReports.add("Sorted Ascending order is valid::  "+MainDep60,  LogAs.PASSED, null);;// test.log(LogStatus.PASS, "Sorted Ascending order is valid::  "+AllGatevaluessorting);
				System.out.println(result7);
			}
			else
			{
				ATUReports.add("Not arranged in Ascending order",  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));;// test.log(LogStatus.FAIL, "Not arranged in Ascending order");
				System.out.println(result7);
			}

	    System.out.println(MainArr15);
	    List<String> MainArr151 = MainArr15;
	    Collections.sort(MainArr15, Collections.reverseOrder());
	    System.out.println(" ");
	    boolean result8 = Arrays.equals(MainArr151.toArray(),MainArr15.toArray());
			// Return result
			if(result8==true)
			{
				ATUReports.add("Arranged properly in Ascending order",  LogAs.PASSED, null);;// test.log(LogStatus.PASS, "Arranged properly in Ascending order");
				ATUReports.add("Sorted Ascending order is valid::  "+MainDep60,  LogAs.PASSED, null);;// test.log(LogStatus.PASS, "Sorted Ascending order is valid::  "+AllGatevaluessorting);
				System.out.println(result8);
			}
			else
			{
				ATUReports.add("Not arranged in Ascending order",  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));;// test.log(LogStatus.FAIL, "Not arranged in Ascending order");
				System.out.println(result8);
			}

	    System.out.println(MainArr30);
	    List<String> MainArr301 = MainArr30;
	    Collections.sort(MainArr30, Collections.reverseOrder());
	    System.out.println(" ");
	    boolean result9 = Arrays.equals(MainArr301.toArray(),MainArr30.toArray());
			// Return result
			if(result9==true)
			{
				ATUReports.add("Arranged properly in Ascending order",  LogAs.PASSED, null);;// test.log(LogStatus.PASS, "Arranged properly in Ascending order");
				ATUReports.add("Sorted Ascending order is valid::  "+MainDep60,  LogAs.PASSED, null);;// test.log(LogStatus.PASS, "Sorted Ascending order is valid::  "+AllGatevaluessorting);
				System.out.println(result9);
			}
			else
			{
				ATUReports.add("Not arranged in Ascending order",  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));;// test.log(LogStatus.FAIL, "Not arranged in Ascending order");
				System.out.println(result9);
			}

	    System.out.println(MainArr45);
	    List<String> MainArr451 = MainArr45;
	    Collections.sort(MainArr45, Collections.reverseOrder());
	    System.out.println(" ");
	    boolean result10 = Arrays.equals(MainArr451.toArray(),MainArr45.toArray());
			// Return result
			if(result10==true)
			{
				ATUReports.add("Arranged properly in Ascending order",  LogAs.PASSED, null);;// test.log(LogStatus.PASS, "Arranged properly in Ascending order");
				ATUReports.add("Sorted Ascending order is valid::  "+MainDep60,  LogAs.PASSED, null);;// test.log(LogStatus.PASS, "Sorted Ascending order is valid::  "+AllGatevaluessorting);
				System.out.println(result10);
			}
			else
			{
				ATUReports.add("Not arranged in Ascending order",  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));;// test.log(LogStatus.FAIL, "Not arranged in Ascending order");
				System.out.println(result10);
			}

	    System.out.println(MainArr60);
	    List<String> MainArr601 = MainArr60;
	    Collections.sort(MainArr60, Collections.reverseOrder());
	    System.out.println(" ");
	    boolean result11 = Arrays.equals(MainArr601.toArray(),MainArr60.toArray());
			// Return result
			if(result11==true)
			{
				ATUReports.add("Arranged properly in Ascending order",  LogAs.PASSED, null);;// test.log(LogStatus.PASS, "Arranged properly in Ascending order");
				ATUReports.add("Sorted Ascending order is valid::  "+MainDep60,  LogAs.PASSED, null);;// test.log(LogStatus.PASS, "Sorted Ascending order is valid::  "+AllGatevaluessorting);
				System.out.println(result11);
			}
			else
			{
				ATUReports.add("Not arranged in Ascending order",  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));;// test.log(LogStatus.FAIL, "Not arranged in Ascending order");
				System.out.println(result11);
			}

	    System.out.println(MainArr90);
	    List<String> MainArr901 = MainArr90;
	    Collections.sort(MainArr90, Collections.reverseOrder());
	    System.out.println(" ");
	    boolean result12 = Arrays.equals(MainArr901.toArray(),MainArr90.toArray());
			// Return result
			if(result12==true)
			{
				ATUReports.add("Arranged properly in Ascending order",  LogAs.PASSED, null);;// test.log(LogStatus.PASS, "Arranged properly in Ascending order");
				ATUReports.add("Sorted Ascending order is valid::  "+MainDep60,  LogAs.PASSED, null);;// test.log(LogStatus.PASS, "Sorted Ascending order is valid::  "+AllGatevaluessorting);
				System.out.println(result12);
			}
			else
			{
				ATUReports.add("Not arranged in Ascending order",  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));;// test.log(LogStatus.FAIL, "Not arranged in Ascending order");
				System.out.println(result12);
			}

	    System.out.println(MainArr120);
	    List<String> MainArr1201 = MainArr120;
	    Collections.sort(MainArr120, Collections.reverseOrder());
	    System.out.println(" ");
	    boolean result13 = Arrays.equals(MainArr1201.toArray(),MainArr120.toArray());
			// Return result
			if(result13==true)
			{
				ATUReports.add("Arranged properly in Ascending order",  LogAs.PASSED, null);;// test.log(LogStatus.PASS, "Arranged properly in Ascending order");
				ATUReports.add("Sorted Ascending order is valid::  "+MainDep60,  LogAs.PASSED, null);;// test.log(LogStatus.PASS, "Sorted Ascending order is valid::  "+AllGatevaluessorting);
				System.out.println(result13);
			}
			else
			{
				ATUReports.add("Not arranged in Ascending order",  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));;// test.log(LogStatus.FAIL, "Not arranged in Ascending order");
				System.out.println(result13);
			}
	  
	    System.out.println(MainArr150);
	    List<String> MainArr1501 = MainArr150;
	    Collections.sort(MainArr150, Collections.reverseOrder());
	    System.out.println(" ");
	    boolean result14 = Arrays.equals(MainArr1501.toArray(),MainArr150.toArray());
			// Return result
			if(result14==true)
			{
				ATUReports.add("Arranged properly in Ascending order",  LogAs.PASSED, null);;// test.log(LogStatus.PASS, "Arranged properly in Ascending order");
				ATUReports.add("Sorted Ascending order is valid::  "+MainDep60,  LogAs.PASSED, null);;// test.log(LogStatus.PASS, "Sorted Ascending order is valid::  "+AllGatevaluessorting);
				System.out.println(result14);
			}
			else
			{
				ATUReports.add("Not arranged in Ascending order",  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));;// test.log(LogStatus.FAIL, "Not arranged in Ascending order");
				System.out.println(result14);
			}

	    System.out.println(MainArr180);
	    List<String> MainArr1801 = MainArr180;
	    Collections.sort(MainArr180, Collections.reverseOrder());
	    System.out.println(" ");
	    boolean result15 = Arrays.equals(MainArr1801.toArray(),MainArr180.toArray());
			// Return result
			if(result15==true)
			{
				ATUReports.add("Arranged properly in Ascending order",  LogAs.PASSED, null);;// test.log(LogStatus.PASS, "Arranged properly in Ascending order");
				ATUReports.add("Sorted Ascending order is valid::  "+MainDep60,  LogAs.PASSED, null);;// test.log(LogStatus.PASS, "Sorted Ascending order is valid::  "+AllGatevaluessorting);
				System.out.println(result15);
			}
			else
			{
				ATUReports.add("Not arranged in Ascending order",  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));;// test.log(LogStatus.FAIL, "Not arranged in Ascending order");
				System.out.println(result15);
			}
	  
		

	    System.out.println(RegDep60);
	    List<String> RegDep601 = RegDep60;
	    Collections.sort(RegDep60, Collections.reverseOrder());
	    System.out.println(" ");
	    boolean result16 = Arrays.equals(RegDep601.toArray(),RegDep601.toArray());
			// Return result
			if(result16==true)
			{
				ATUReports.add("Arranged properly in Ascending order",  LogAs.PASSED, null);;// test.log(LogStatus.PASS, "Arranged properly in Ascending order");
				ATUReports.add("Sorted Ascending order is valid::  "+MainDep60,  LogAs.PASSED, null);;// test.log(LogStatus.PASS, "Sorted Ascending order is valid::  "+AllGatevaluessorting);
				System.out.println(result16);
			}
			else
			{
				ATUReports.add("Not arranged in Ascending order",  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));;// test.log(LogStatus.FAIL, "Not arranged in Ascending order");
				System.out.println(result16);
			}
	  
	    System.out.println(RegDep30);
	    List<String> RegDep301 = RegDep30;
	    Collections.sort(RegDep30, Collections.reverseOrder());
	    System.out.println(" ");
	    boolean result17 = Arrays.equals(RegDep301.toArray(),RegDep30.toArray());
			// Return result
			if(result17==true)
			{
				ATUReports.add("Arranged properly in Ascending order",  LogAs.PASSED, null);;// test.log(LogStatus.PASS, "Arranged properly in Ascending order");
				ATUReports.add("Sorted Ascending order is valid::  "+MainDep60,  LogAs.PASSED, null);;// test.log(LogStatus.PASS, "Sorted Ascending order is valid::  "+AllGatevaluessorting);
				System.out.println(result17);
			}
			else
			{
				ATUReports.add("Not arranged in Ascending order",  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));;// test.log(LogStatus.FAIL, "Not arranged in Ascending order");
				System.out.println(result17);
			}

	    System.out.println(RegDep45);
	    List<String> RegDep451 = RegDep45;
	    Collections.sort(RegDep45, Collections.reverseOrder());
	    System.out.println(" ");
	    boolean result18 = Arrays.equals(RegDep451.toArray(),RegDep45.toArray());
			// Return result
			if(result18==true)
			{
				ATUReports.add("Arranged properly in Ascending order",  LogAs.PASSED, null);;// test.log(LogStatus.PASS, "Arranged properly in Ascending order");
				ATUReports.add("Sorted Ascending order is valid::  "+MainDep60,  LogAs.PASSED, null);;// test.log(LogStatus.PASS, "Sorted Ascending order is valid::  "+AllGatevaluessorting);
				System.out.println(result18);
			}
			else
			{
				ATUReports.add("Not arranged in Ascending order",  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));;// test.log(LogStatus.FAIL, "Not arranged in Ascending order");
				System.out.println(result18);
			}
	 
	    System.out.println(RegDep15);
	    List<String> RegDep151 = RegDep15;
	    Collections.sort(RegDep15, Collections.reverseOrder());
	    System.out.println(" ");
	    boolean result19 = Arrays.equals(RegDep151.toArray(),RegDep15.toArray());
			// Return result
			if(result19==true)
			{
				ATUReports.add("Arranged properly in Ascending order",  LogAs.PASSED, null);;// test.log(LogStatus.PASS, "Arranged properly in Ascending order");
				ATUReports.add("Sorted Ascending order is valid::  "+MainDep60,  LogAs.PASSED, null);;// test.log(LogStatus.PASS, "Sorted Ascending order is valid::  "+AllGatevaluessorting);
				System.out.println(result19);
			}
			else
			{
				ATUReports.add("Not arranged in Ascending order",  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));;// test.log(LogStatus.FAIL, "Not arranged in Ascending order");
				System.out.println(result19);
			}
	
	    System.out.println(RegDep120);
	    List<String> RegDep1201 = RegDep120;
	    Collections.sort(RegDep120, Collections.reverseOrder());
	    System.out.println(" ");
	    boolean result20 = Arrays.equals(RegDep1201.toArray(),RegDep120.toArray());
			// Return result
			if(result20==true)
			{
				ATUReports.add("Arranged properly in Ascending order",  LogAs.PASSED, null);;// test.log(LogStatus.PASS, "Arranged properly in Ascending order");
				ATUReports.add("Sorted Ascending order is valid::  "+MainDep60,  LogAs.PASSED, null);;// test.log(LogStatus.PASS, "Sorted Ascending order is valid::  "+AllGatevaluessorting);
				System.out.println(result20);
			}
			else
			{
				ATUReports.add("Not arranged in Ascending order",  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));;// test.log(LogStatus.FAIL, "Not arranged in Ascending order");
				System.out.println(result20);
			}
	
	    System.out.println(RegDep150);
	    List<String> RegDep1501 = RegDep150;
	    Collections.sort(RegDep150, Collections.reverseOrder());
	    System.out.println(" ");
	    boolean result21 = Arrays.equals(RegDep1501.toArray(),RegDep150.toArray());
			// Return result
			if(result21==true)
			{
				ATUReports.add("Arranged properly in Ascending order",  LogAs.PASSED, null);;// test.log(LogStatus.PASS, "Arranged properly in Ascending order");
				ATUReports.add("Sorted Ascending order is valid::  "+MainDep60,  LogAs.PASSED, null);;// test.log(LogStatus.PASS, "Sorted Ascending order is valid::  "+AllGatevaluessorting);
				System.out.println(result21);
			}
			else
			{
				ATUReports.add("Not arranged in Ascending order",  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));;// test.log(LogStatus.FAIL, "Not arranged in Ascending order");
				System.out.println(result21);
			}
	  
	    System.out.println(RegDep90);
	    List<String> RegDep901 = RegDep90;
	    Collections.sort(RegDep90, Collections.reverseOrder());
	    System.out.println(" ");
	    boolean result22 = Arrays.equals(RegDep901.toArray(),RegDep90.toArray());
			// Return result
			if(result22==true)
			{
				ATUReports.add("Arranged properly in Ascending order",  LogAs.PASSED, null);;// test.log(LogStatus.PASS, "Arranged properly in Ascending order");
				ATUReports.add("Sorted Ascending order is valid::  "+MainDep60,  LogAs.PASSED, null);;// test.log(LogStatus.PASS, "Sorted Ascending order is valid::  "+AllGatevaluessorting);
				System.out.println(result22);
			}
			else
			{
				ATUReports.add("Not arranged in Ascending order",  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));;// test.log(LogStatus.FAIL, "Not arranged in Ascending order");
				System.out.println(result22);
			}

	    System.out.println(RegDep180);
	    List<String> RegDep1801 = RegDep180;
	    Collections.sort(RegDep180, Collections.reverseOrder());
	    System.out.println(" ");
	    boolean result23 = Arrays.equals(RegDep1801.toArray(),RegDep180.toArray());
			// Return result
			if(result23==true)
			{
				ATUReports.add("Arranged properly in Ascending order",  LogAs.PASSED, null);;// test.log(LogStatus.PASS, "Arranged properly in Ascending order");
				ATUReports.add("Sorted Ascending order is valid::  "+MainDep60,  LogAs.PASSED, null);;// test.log(LogStatus.PASS, "Sorted Ascending order is valid::  "+AllGatevaluessorting);
				System.out.println(result23);
			}
			else
			{
				ATUReports.add("Not arranged in Ascending order",  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));;// test.log(LogStatus.FAIL, "Not arranged in Ascending order");
				System.out.println(result23);
			}

	    System.out.println(RegArr15);
	    List<String> RegArr151 = RegArr15;
	    Collections.sort(RegArr15, Collections.reverseOrder());
	    System.out.println(" ");
	    boolean result24 = Arrays.equals(RegDep1801.toArray(),RegDep180.toArray());
			// Return result
			if(result24==true)
			{
				ATUReports.add("Arranged properly in Ascending order",  LogAs.PASSED, null);;// test.log(LogStatus.PASS, "Arranged properly in Ascending order");
				ATUReports.add("Sorted Ascending order is valid::  "+MainDep60,  LogAs.PASSED, null);;// test.log(LogStatus.PASS, "Sorted Ascending order is valid::  "+AllGatevaluessorting);
				System.out.println(result24);
			}
			else
			{
				ATUReports.add("Not arranged in Ascending order",  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));;// test.log(LogStatus.FAIL, "Not arranged in Ascending order");
				System.out.println(result24);
			}
	 
	    System.out.println(RegArr45);
	    List<String> RegArr451 = RegArr45;
	    Collections.sort(RegArr45, Collections.reverseOrder());
	    System.out.println(" ");
	    boolean result25 = Arrays.equals(RegArr451.toArray(),RegArr45.toArray());
			// Return result
			if(result25==true)
			{
				ATUReports.add("Arranged properly in Ascending order",  LogAs.PASSED, null);;// test.log(LogStatus.PASS, "Arranged properly in Ascending order");
				ATUReports.add("Sorted Ascending order is valid::  "+MainDep60,  LogAs.PASSED, null);;// test.log(LogStatus.PASS, "Sorted Ascending order is valid::  "+AllGatevaluessorting);
				System.out.println(result25);
			}
			else
			{
				ATUReports.add("Not arranged in Ascending order",  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));;// test.log(LogStatus.FAIL, "Not arranged in Ascending order");
				System.out.println(result25);
			}

	    System.out.println(RegArr30);
	    List<String> RegArr301 = RegArr30;
	    Collections.sort(RegArr30, Collections.reverseOrder());
	    System.out.println(" ");
	    boolean result26 = Arrays.equals(RegArr301.toArray(),RegArr30.toArray());
			// Return result
			if(result26==true)
			{
				ATUReports.add("Arranged properly in Ascending order",  LogAs.PASSED, null);;// test.log(LogStatus.PASS, "Arranged properly in Ascending order");
				ATUReports.add("Sorted Ascending order is valid::  "+MainDep60,  LogAs.PASSED, null);;// test.log(LogStatus.PASS, "Sorted Ascending order is valid::  "+AllGatevaluessorting);
				System.out.println(result26);
			}
			else
			{
				ATUReports.add("Not arranged in Ascending order",  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));;// test.log(LogStatus.FAIL, "Not arranged in Ascending order");
				System.out.println(result26);
			}
	
	    System.out.println(RegArr60);
	    List<String> RegArr601 = RegArr60;
	    Collections.sort(RegArr60, Collections.reverseOrder());
	    System.out.println(" ");
	    boolean result27 = Arrays.equals(RegArr601.toArray(),RegArr60.toArray());
			// Return result
			if(result27==true)
			{
				ATUReports.add("Arranged properly in Ascending order",  LogAs.PASSED, null);;// test.log(LogStatus.PASS, "Arranged properly in Ascending order");
				ATUReports.add("Sorted Ascending order is valid::  "+MainDep60,  LogAs.PASSED, null);;// test.log(LogStatus.PASS, "Sorted Ascending order is valid::  "+AllGatevaluessorting);
				System.out.println(result27);
			}
			else
			{
				ATUReports.add("Not arranged in Ascending order",  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));;// test.log(LogStatus.FAIL, "Not arranged in Ascending order");
				System.out.println(result27);
			}
	
	    System.out.println(RegArr90);
	    List<String> RegArr901 = RegArr90;
	    Collections.sort(RegArr90, Collections.reverseOrder());
	    System.out.println(" ");
	    boolean result28 = Arrays.equals(RegArr901.toArray(),RegArr90.toArray());
			// Return result
			if(result28==true)
			{
				ATUReports.add("Arranged properly in Ascending order",  LogAs.PASSED, null);;// test.log(LogStatus.PASS, "Arranged properly in Ascending order");
				ATUReports.add("Sorted Ascending order is valid::  "+MainDep60,  LogAs.PASSED, null);;// test.log(LogStatus.PASS, "Sorted Ascending order is valid::  "+AllGatevaluessorting);
				System.out.println(result28);
			}
			else
			{
				ATUReports.add("Not arranged in Ascending order",  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));;// test.log(LogStatus.FAIL, "Not arranged in Ascending order");
				System.out.println(result28);
			}
	   
	    System.out.println(RegArr120);
	    List<String> RegArr1201 = RegArr120;
	    Collections.sort(RegArr120, Collections.reverseOrder());
	    System.out.println(" ");
	    boolean result29 = Arrays.equals(RegArr1201.toArray(),RegArr120.toArray());
			// Return result
			if(result29==true)
			{
				ATUReports.add("Arranged properly in Ascending order",  LogAs.PASSED, null);;// test.log(LogStatus.PASS, "Arranged properly in Ascending order");
				ATUReports.add("Sorted Ascending order is valid::  "+MainDep60,  LogAs.PASSED, null);;// test.log(LogStatus.PASS, "Sorted Ascending order is valid::  "+AllGatevaluessorting);
				System.out.println(result29);
			}
			else
			{
				ATUReports.add("Not arranged in Ascending order",  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));;// test.log(LogStatus.FAIL, "Not arranged in Ascending order");
				System.out.println(result29);
			}
	  
	    System.out.println(RegArr150);
	    List<String> RegArr1501 = RegArr150;
	    Collections.sort(RegArr150, Collections.reverseOrder());
	    System.out.println(" ");
	    boolean result30 = Arrays.equals(RegArr1501.toArray(),RegArr150.toArray());
			// Return result
			if(result30==true)
			{
				ATUReports.add("Arranged properly in Ascending order",  LogAs.PASSED, null);;// test.log(LogStatus.PASS, "Arranged properly in Ascending order");
				ATUReports.add("Sorted Ascending order is valid::  "+MainDep60,  LogAs.PASSED, null);;// test.log(LogStatus.PASS, "Sorted Ascending order is valid::  "+AllGatevaluessorting);
				System.out.println(result30);
			}
			else
			{
				ATUReports.add("Not arranged in Ascending order",  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));;// test.log(LogStatus.FAIL, "Not arranged in Ascending order");
				System.out.println(result30);
			}
	
	    System.out.println(RegArr180);
	    List<String> RegArr1801 = RegArr180;
	    Collections.sort(RegArr180, Collections.reverseOrder());
	    System.out.println(" ");
	    boolean result31 = Arrays.equals(RegArr1801.toArray(),RegArr180.toArray());
			// Return result
			if(result31==true)
			{
				ATUReports.add("Arranged properly in Ascending order",  LogAs.PASSED, null);;// test.log(LogStatus.PASS, "Arranged properly in Ascending order");
				ATUReports.add("Sorted Ascending order is valid::  "+MainDep60,  LogAs.PASSED, null);;// test.log(LogStatus.PASS, "Sorted Ascending order is valid::  "+AllGatevaluessorting);
				System.out.println(result31);
			}
			else
			{
				ATUReports.add("Not arranged in Ascending order",  LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));;// test.log(LogStatus.FAIL, "Not arranged in Ascending order");
				System.out.println(result31);
			}
		
	
}

public static void Tarmacgreaterthan15DataPuller(String path, String SheetName, String ExcelName, String sta)
		throws Exception {
	Date date = new Date();
	TimeZone.setDefault(TimeZone.getTimeZone("GMT"));
	Calendar cal = Calendar.getInstance(TimeZone.getDefault());
	date = cal.getTime();
	String timee = date.toGMTString();
	long timeeunixx = cal.getTimeInMillis();

	long mil = System.currentTimeMillis();
	String st, full, append, le, extend, extended;
	full = "";
	extended = "";
	BufferedReader br = new BufferedReader(new FileReader(path));
	while ((st = br.readLine()) != null) {
		full += st;
	}

		JSONObject jsonObj1 = new JSONObject(full);
		JSONObject jsonObj2 = new JSONObject(full);
		try {
			JSONObject Testprint11 = (JSONObject) jsonObj1.get("mainlineList");
			JSONObject Testprint12 = (JSONObject) jsonObj2.get("regionalList");
			System.out.println(jsonObj1);
			try {

				if (Testprint11.get("depTarmac").toString().equals("null")) {
					// //System.out.println("null");
				} else {

					int getGt15 = Testprint11.getJSONObject("depTarmac").getJSONArray("longOnBoardGT45").length();
					for (int mia = 0; mia < getGt15; mia++) {
						// System.out.println(Testprint11.getJSONObject("depTarmac").getJSONArray("longOnBoardGT45").getJSONObject(mia).getInt("duration"));
						int duration = Testprint11.getJSONObject("depTarmac").getJSONArray("longOnBoardGT45")
								.getJSONObject(mia).getInt("duration");
						if (duration >= 45) {
							System.out.println("Duration>45 ::  " + duration);
						} else {
						}

						if (duration <= 180) {
							// System.out.println("Pass :: Duration<180 ::  "+duration);
						} else {
							System.out.println("Fail:: Duration>180 ::  " + duration);
						}

					}
				}

			} catch (Exception one) {
			}

			try {

				if (Testprint11.get("depTarmac").toString().equals("null")) {
					// System.out.println("null");
				} else {

					int getGt15 = Testprint11.getJSONObject("depTarmac").getJSONArray("longOnBoardGT60").length();
					for (int mia = 0; mia < getGt15; mia++) {
						// System.out.println(Testprint11.getJSONObject("depTarmac").getJSONArray("longOnBoardGT60").getJSONObject(mia).getInt("duration"));
						int duration = Testprint11.getJSONObject("depTarmac").getJSONArray("longOnBoardGT60")
								.getJSONObject(mia).getInt("duration");
						if (duration >= 60) {
							System.out.println("Duration>60 ::  " + duration);
						} else {
						}
						if (duration <= 180) {
							// System.out.println("Pass :: Duration<180 ::  "+duration);
						} else {
							System.out.println("Fail:: Duration>180 ::  " + duration);
						}

					}
				}

			} catch (Exception one) {
			}

			try {

				if (Testprint11.get("depTarmac").toString().equals("null")) {
					// //System.out.println("null");
				} else {

					int getGt15 = Testprint11.getJSONObject("depTarmac").getJSONArray("longOnBoardGT30").length();
					for (int mia = 0; mia < getGt15; mia++) {
						// System.out.println(Testprint11.getJSONObject("depTarmac").getJSONArray("longOnBoardGT30").getJSONObject(mia).getInt("duration"));
						int duration = Testprint11.getJSONObject("depTarmac").getJSONArray("longOnBoardGT30")
								.getJSONObject(mia).getInt("duration");
						if (duration >= 30) {
							System.out.println("Duration>30 ::  " + duration);
						} else {
						}
						if (duration <= 180) {
							// System.out.println("Pass :: Duration<180 ::  "+duration);
						} else {
							System.out.println("Fail:: Duration>180 ::  " + duration);
						}

					}
				}

			} catch (Exception one) {
			}

			try {

				if (Testprint11.get("depTarmac").toString().equals("null")) {
					// //System.out.println("null");
				} else {

					int getGt15 = Testprint11.getJSONObject("depTarmac").getJSONArray("longOnBoardGT15").length();
					for (int mia = 0; mia < getGt15; mia++) {
						// System.out.println(Testprint11.getJSONObject("depTarmac").getJSONArray("longOnBoardGT15").getJSONObject(mia).getInt("duration"));
						int duration = Testprint11.getJSONObject("depTarmac").getJSONArray("longOnBoardGT15")
								.getJSONObject(mia).getInt("duration");
						if (duration >= 15) {
							System.out.println("Duration>15 ::  " + duration);
						} else {
						}
						if (duration <= 180) {
							// System.out.println("Pass :: Duration<180 ::  "+duration);
						} else {
							System.out.println("Fail:: Duration>180 ::  " + duration);
						}

					}
				}

			} catch (Exception one) {
			}

			try {

				if (Testprint11.get("depTarmac").toString().equals("null")) {
					// //System.out.println("null");
				} else {

					int getGt15 = Testprint11.getJSONObject("depTarmac").getJSONArray("longOnBoardGT120").length();
					for (int mia = 0; mia < getGt15; mia++) {
						// System.out.println(Testprint11.getJSONObject("depTarmac").getJSONArray("longOnBoardGT120").getJSONObject(mia).getInt("duration"));
						int duration = Testprint11.getJSONObject("depTarmac").getJSONArray("longOnBoardGT120")
								.getJSONObject(mia).getInt("duration");
						if (duration >= 120) {
							System.out.println("Duration>120 ::  " + duration);
						} else {
						}
						if (duration <= 180) {
							// System.out.println("Pass :: Duration<180 ::  "+duration);
						} else {
							System.out.println("Fail:: Duration>180 ::  " + duration);
						}

					}
				}

			} catch (Exception one) {
			}

			try {

				if (Testprint11.get("depTarmac").toString().equals("null")) {
					// //System.out.println("null");
				} else {

					int getGt15 = Testprint11.getJSONObject("depTarmac").getJSONArray("longOnBoardGT150").length();
					for (int mia = 0; mia < getGt15; mia++) {
						// System.out.println(Testprint11.getJSONObject("depTarmac").getJSONArray("longOnBoardGT150").getJSONObject(mia).getInt("duration"));
						int duration = Testprint11.getJSONObject("depTarmac").getJSONArray("longOnBoardGT150")
								.getJSONObject(mia).getInt("duration");
						if (duration >= 150) {
							System.out.println("Duration>150 ::  " + duration);
						} else {
						}
						if (duration <= 180) {
							// System.out.println("Pass :: Duration<180 ::  "+duration);
						} else {
							System.out.println("Fail:: Duration>180 ::  " + duration);
						}

					}
				}

			} catch (Exception one) {
			}

			try {

				if (Testprint11.get("depTarmac").toString().equals("null")) {
					// //System.out.println("null");
				} else {

					int getGt15 = Testprint11.getJSONObject("depTarmac").getJSONArray("longOnBoardGT90").length();
					for (int mia = 0; mia < getGt15; mia++) {
						// System.out.println(Testprint11.getJSONObject("depTarmac").getJSONArray("longOnBoardGT90").getJSONObject(mia).getInt("duration"));
						int duration = Testprint11.getJSONObject("depTarmac").getJSONArray("longOnBoardGT90")
								.getJSONObject(mia).getInt("duration");
						if (duration >= 90) {
							System.out.println("Duration>90 ::  " + duration);
						} else {
						}
						if (duration <= 180) {
							// System.out.println("Pass :: Duration<180 ::  "+duration);
						} else {
							System.out.println("Fail:: Duration>180 ::  " + duration);
						}

					}
				}

			} catch (Exception one) {
			}
			try {

				if (Testprint11.get("depTarmac").toString().equals("null")) {
					// //System.out.println("null");
				} else {

					int getGt15 = Testprint11.getJSONObject("depTarmac").getJSONArray("longOnBoardGT180").length();
					for (int mia = 0; mia < getGt15; mia++) {
						// System.out.println(Testprint11.getJSONObject("depTarmac").getJSONArray("longOnBoardGT180").getJSONObject(mia).getInt("duration"));
						int duration = Testprint11.getJSONObject("depTarmac").getJSONArray("longOnBoardGT180")
								.getJSONObject(mia).getInt("duration");
						if (duration >= 180) {
							System.out.println("Duration>180 ::  " + duration);
						} else {
						}
						if (duration <= 180) {
							// System.out.println("Pass :: Duration<180 ::  "+duration);
						} else {
							System.out.println("Fail:: Duration>180 ::  " + duration);
						}

					}
				}

			} catch (Exception one) {
			}
			try {

				if (Testprint12.get("depTarmac").toString().equals("null")) {
					// //System.out.println("null");
				} else {

					int getGt15 = Testprint12.getJSONObject("depTarmac").getJSONArray("longOnBoardGT45").length();
					for (int mia = 0; mia < getGt15; mia++) {
						// System.out.println(Testprint12.getJSONObject("depTarmac").getJSONArray("longOnBoardGT45").getJSONObject(mia).getInt("duration"));
						int duration = Testprint12.getJSONObject("depTarmac").getJSONArray("longOnBoardGT45")
								.getJSONObject(mia).getInt("duration");
						if (duration >= 45) {
							System.out.println("Duration>45 ::  " + duration);
						} else {
						}
						if (duration <= 180) {
							// System.out.println("Pass :: Duration<180 ::  "+duration);
						} else {
							System.out.println("Fail:: Duration>180 ::  " + duration);
						}

					}
				}

			} catch (Exception one) {
			}

			try {

				if (Testprint12.get("depTarmac").toString().equals("null")) {
					// //System.out.println("null");
				} else {

					int getGt15 = Testprint12.getJSONObject("depTarmac").getJSONArray("longOnBoardGT60").length();
					for (int mia = 0; mia < getGt15; mia++) {
						// System.out.println(Testprint12.getJSONObject("depTarmac").getJSONArray("longOnBoardGT60").getJSONObject(mia).getInt("duration"));
						int duration = Testprint12.getJSONObject("depTarmac").getJSONArray("longOnBoardGT60")
								.getJSONObject(mia).getInt("duration");
						if (duration >= 60) {
							System.out.println("Duration>60 ::  " + duration);
						} else {
						}
						if (duration <= 180) {
							// System.out.println("Pass :: Duration<180 ::  "+duration);
						} else {
							System.out.println("Fail:: Duration>180 ::  " + duration);
						}

					}
				}

			} catch (Exception one) {
			}

			try {

				if (Testprint12.get("depTarmac").toString().equals("null")) {
					// //System.out.println("null");
				} else {

					int getGt15 = Testprint12.getJSONObject("depTarmac").getJSONArray("longOnBoardGT30").length();
					for (int mia = 0; mia < getGt15; mia++) {
						// System.out.println(Testprint12.getJSONObject("depTarmac").getJSONArray("longOnBoardGT30").getJSONObject(mia).getInt("duration"));
						int duration = Testprint12.getJSONObject("depTarmac").getJSONArray("longOnBoardGT30")
								.getJSONObject(mia).getInt("duration");
						if (duration >= 30) {
							System.out.println("Duration>30 ::  " + duration);
						} else {
						}
						if (duration <= 180) {
							// System.out.println("Pass :: Duration<180 ::  "+duration);
						} else {
							System.out.println("Fail:: Duration>180 ::  " + duration);
						}

					}
				}

			} catch (Exception one) {
			}

			try {

				if (Testprint12.get("depTarmac").toString().equals("null")) {
					// //System.out.println("null");
				} else {

					int getGt15 = Testprint12.getJSONObject("depTarmac").getJSONArray("longOnBoardGT15").length();
					for (int mia = 0; mia < getGt15; mia++) {
						// System.out.println(Testprint12.getJSONObject("depTarmac").getJSONArray("longOnBoardGT15").getJSONObject(mia).getInt("duration"));
						int duration = Testprint12.getJSONObject("depTarmac").getJSONArray("longOnBoardGT15")
								.getJSONObject(mia).getInt("duration");
						if (duration >= 15) {
							System.out.println("Duration>15 ::  " + duration);
						} else {
						}
						if (duration <= 180) {
							// System.out.println("Pass :: Duration<180 ::  "+duration);
						} else {
							System.out.println("Fail:: Duration>180 ::  " + duration);
						}

					}
				}

			} catch (Exception one) {
			}

			try {

				if (Testprint12.get("depTarmac").toString().equals("null")) {
					// //System.out.println("null");
				} else {

					int getGt15 = Testprint12.getJSONObject("depTarmac").getJSONArray("longOnBoardGT120").length();
					for (int mia = 0; mia < getGt15; mia++) {
						// System.out.println(Testprint12.getJSONObject("depTarmac").getJSONArray("longOnBoardGT120").getJSONObject(mia).getInt("duration"));
						int duration = Testprint12.getJSONObject("depTarmac").getJSONArray("longOnBoardGT120")
								.getJSONObject(mia).getInt("duration");
						if (duration >= 120) {
							System.out.println("Duration>120 ::  " + duration);
						} else {
						}
						if (duration <= 180) {
							// System.out.println("Pass :: Duration<180 ::  "+duration);
						} else {
							System.out.println("Fail:: Duration>180 ::  " + duration);
						}

					}
				}

			} catch (Exception one) {
			}

			try {

				if (Testprint12.get("depTarmac").toString().equals("null")) {
					// //System.out.println("null");
				} else {

					int getGt15 = Testprint12.getJSONObject("depTarmac").getJSONArray("longOnBoardGT150").length();
					for (int mia = 0; mia < getGt15; mia++) {
						// System.out.println(Testprint12.getJSONObject("depTarmac").getJSONArray("longOnBoardGT150").getJSONObject(mia).getInt("duration"));
						int duration = Testprint12.getJSONObject("depTarmac").getJSONArray("longOnBoardGT150")
								.getJSONObject(mia).getInt("duration");
						if (duration >= 150) {
							System.out.println("Duration>150 ::  " + duration);
						} else {
						}
						if (duration <= 180) {
							// System.out.println("Pass :: Duration<180 ::  "+duration);
						} else {
							System.out.println("Fail:: Duration>180 ::  " + duration);
						}

					}
				}

			} catch (Exception one) {
			}

			try {

				if (Testprint12.get("depTarmac").toString().equals("null")) {
					// //System.out.println("null");
				} else {

					int getGt15 = Testprint12.getJSONObject("depTarmac").getJSONArray("longOnBoardGT90").length();
					for (int mia = 0; mia < getGt15; mia++) {
						// System.out.println(Testprint12.getJSONObject("depTarmac").getJSONArray("longOnBoardGT90").getJSONObject(mia).getInt("duration"));
						int duration = Testprint12.getJSONObject("depTarmac").getJSONArray("longOnBoardGT90")
								.getJSONObject(mia).getInt("duration");
						if (duration >= 90) {
							System.out.println("Duration>90 ::  " + duration);
						} else {
						}
						if (duration <= 180) {
							// System.out.println("Pass :: Duration<180 ::  "+duration);
						} else {
							System.out.println("Fail:: Duration>180 ::  " + duration);
						}

					}
				}

			} catch (Exception one) {
			}

			try {

				if (Testprint12.get("depTarmac").toString().equals("null")) {
					// //System.out.println("null");
				} else {

					int getGt15 = Testprint12.getJSONObject("depTarmac").getJSONArray("longOnBoardGT180").length();
					for (int mia = 0; mia < getGt15; mia++) {
						// System.out.println(Testprint12.getJSONObject("depTarmac").getJSONArray("longOnBoardGT180").getJSONObject(mia).getInt("duration"));
						int duration = Testprint12.getJSONObject("depTarmac").getJSONArray("longOnBoardGT180")
								.getJSONObject(mia).getInt("duration");
						if (duration >= 180) {
							System.out.println("Duration>180 ::  " + duration);
						} else {
						}
						if (duration <= 180) {
							// System.out.println("Pass :: Duration<180 ::  "+duration);
						} else {
							System.out.println("Fail:: Duration>180 ::  " + duration);
						}

					}
				}

			} catch (Exception one) {
			}

			try {

				if (Testprint11.get("arrTarmac").toString().equals("null")) {
					// //System.out.println("null");
				} else {

					int getGt15 = Testprint11.getJSONObject("arrTarmac").getJSONArray("longOnBoardGT45").length();
					for (int mia = 0; mia < getGt15; mia++) {
						// System.out.println(Testprint11.getJSONObject("arrTarmac").getJSONArray("longOnBoardGT45").getJSONObject(mia).getInt("duration"));
						int duration = Testprint11.getJSONObject("arrTarmac").getJSONArray("longOnBoardGT45")
								.getJSONObject(mia).getInt("duration");
						if (duration >= 45) {
							System.out.println("Duration>45 ::  " + duration);
						} else {
						}
						if (duration <= 180) {
							// System.out.println("Pass :: Duration<180 ::  "+duration);
						} else {
							System.out.println("Fail:: Duration>180 ::  " + duration);
						}

					}
				}

			} catch (Exception one) {
			}

			try {

				if (Testprint11.get("arrTarmac").toString().equals("null")) {
					// //System.out.println("null");
				} else {

					int getGt15 = Testprint11.getJSONObject("arrTarmac").getJSONArray("longOnBoardGT60").length();
					for (int mia = 0; mia < getGt15; mia++) {
						// System.out.println(Testprint11.getJSONObject("arrTarmac").getJSONArray("longOnBoardGT60").getJSONObject(mia).getInt("duration"));
						int duration = Testprint11.getJSONObject("arrTarmac").getJSONArray("longOnBoardGT60")
								.getJSONObject(mia).getInt("duration");
						if (duration >= 60) {
							System.out.println("Duration>60 ::  " + duration);
						} else {
						}
						if (duration <= 180) {
							// System.out.println("Pass :: Duration<180 ::  "+duration);
						} else {
							System.out.println("Fail:: Duration>180 ::  " + duration);
						}

					}
				}

			} catch (Exception one) {
			}

			try {

				if (Testprint11.get("arrTarmac").toString().equals("null")) {
					// //System.out.println("null");
				} else {

					int getGt15 = Testprint11.getJSONObject("arrTarmac").getJSONArray("longOnBoardGT30").length();
					for (int mia = 0; mia < getGt15; mia++) {
						// System.out.println(Testprint11.getJSONObject("arrTarmac").getJSONArray("longOnBoardGT30").getJSONObject(mia).getInt("duration"));
						int duration = Testprint11.getJSONObject("arrTarmac").getJSONArray("longOnBoardGT30")
								.getJSONObject(mia).getInt("duration");
						if (duration >= 30) {
							System.out.println("Duration>30 ::  " + duration);
						} else {
						}
						if (duration <= 180) {
							// System.out.println("Pass :: Duration<180 ::  "+duration);
						} else {
							System.out.println("Fail:: Duration>180 ::  " + duration);
						}

					}
				}

			} catch (Exception one) {
			}

			try {

				if (Testprint11.get("arrTarmac").toString().equals("null")) {
					// //System.out.println("null");
				} else {

					int getGt15 = Testprint11.getJSONObject("arrTarmac").getJSONArray("longOnBoardGT15").length();
					for (int mia = 0; mia < getGt15; mia++) {
						// System.out.println(Testprint11.getJSONObject("arrTarmac").getJSONArray("longOnBoardGT15").getJSONObject(mia).getInt("duration"));
						int duration = Testprint11.getJSONObject("arrTarmac").getJSONArray("longOnBoardGT15")
								.getJSONObject(mia).getInt("duration");
						if (duration >= 15) {
							System.out.println("Duration>15 ::  " + duration);
						} else {
						}
						if (duration <= 180) {
							// System.out.println("Pass :: Duration<180 ::  "+duration);
						} else {
							System.out.println("Fail:: Duration>180 ::  " + duration);
						}

					}
				}

			} catch (Exception one) {
			}

			try {

				if (Testprint11.get("arrTarmac").toString().equals("null")) {
					// //System.out.println("null");
				} else {

					int getGt15 = Testprint11.getJSONObject("arrTarmac").getJSONArray("longOnBoardGT120").length();
					for (int mia = 0; mia < getGt15; mia++) {
						// System.out.println(Testprint11.getJSONObject("arrTarmac").getJSONArray("longOnBoardGT120").getJSONObject(mia).getInt("duration"));
						int duration = Testprint11.getJSONObject("arrTarmac").getJSONArray("longOnBoardGT120")
								.getJSONObject(mia).getInt("duration");
						if (duration >= 120) {
							System.out.println("Duration>120 ::  " + duration);
						} else {
						}
						if (duration <= 180) {
							// System.out.println("Pass :: Duration<180 ::  "+duration);
						} else {
							System.out.println("Fail:: Duration>180 ::  " + duration);
						}

					}
				}

			} catch (Exception one) {
			}

			try {

				if (Testprint11.get("arrTarmac").toString().equals("null")) {
					// //System.out.println("null");
				} else {

					int getGt15 = Testprint11.getJSONObject("arrTarmac").getJSONArray("longOnBoardGT150").length();
					for (int mia = 0; mia < getGt15; mia++) {
						// System.out.println(Testprint11.getJSONObject("arrTarmac").getJSONArray("longOnBoardGT150").getJSONObject(mia).getInt("duration"));
						int duration = Testprint11.getJSONObject("arrTarmac").getJSONArray("longOnBoardGT150")
								.getJSONObject(mia).getInt("duration");
						if (duration >= 150) {
							System.out.println("Duration>150 ::  " + duration);
						} else {
						}
						if (duration <= 180) {
							// System.out.println("Pass :: Duration<180 ::  "+duration);
						} else {
							System.out.println("Fail:: Duration>180 ::  " + duration);
						}

					}
				}

			} catch (Exception one) {
			}

			try {

				if (Testprint11.get("arrTarmac").toString().equals("null")) {
					// //System.out.println("null");
				} else {

					int getGt15 = Testprint11.getJSONObject("arrTarmac").getJSONArray("longOnBoardGT90").length();
					for (int mia = 0; mia < getGt15; mia++) {
						// System.out.println(Testprint11.getJSONObject("arrTarmac").getJSONArray("longOnBoardGT90").getJSONObject(mia).getInt("duration"));
						int duration = Testprint11.getJSONObject("arrTarmac").getJSONArray("longOnBoardGT90")
								.getJSONObject(mia).getInt("duration");
						if (duration >= 90) {
							System.out.println("Duration>90 ::  " + duration);
						} else {
						}
						if (duration <= 180) {
							// System.out.println("Pass :: Duration<180 ::  "+duration);
						} else {
							System.out.println("Fail:: Duration>180 ::  " + duration);
						}

					}
				}

			} catch (Exception one) {
			}

			try {

				if (Testprint11.get("arrTarmac").toString().equals("null")) {
					// //System.out.println("null");
				} else {

					int getGt15 = Testprint11.getJSONObject("arrTarmac").getJSONArray("longOnBoardGT180").length();
					for (int mia = 0; mia < getGt15; mia++) {
						// System.out.println(Testprint11.getJSONObject("arrTarmac").getJSONArray("longOnBoardGT180").getJSONObject(mia).getInt("duration"));
						int duration = Testprint11.getJSONObject("arrTarmac").getJSONArray("longOnBoardGT180")
								.getJSONObject(mia).getInt("duration");
						if (duration >= 180) {
							System.out.println("Duration>180 ::  " + duration);
						} else {
						}
						if (duration <= 180) {
							// System.out.println("Pass :: Duration<180 ::  "+duration);
						} else {
							System.out.println("Fail:: Duration>180 ::  " + duration);
						}

					}
				}

			} catch (Exception one) {
			}

			try {

				if (Testprint12.get("arrTarmac").toString().equals("null")) {
					// System.out.println("null");
				} else {

					int getGt15 = Testprint12.getJSONObject("arrTarmac").getJSONArray("longOnBoardGT45").length();
					for (int mia = 0; mia < getGt15; mia++) {
						// System.out.println(Testprint12.getJSONObject("arrTarmac").getJSONArray("longOnBoardGT45").getJSONObject(mia).getInt("duration"));
						int duration = Testprint12.getJSONObject("arrTarmac").getJSONArray("longOnBoardGT45")
								.getJSONObject(mia).getInt("duration");
						if (duration >= 45) {
							System.out.println("Duration>45 ::  " + duration);
						} else {
						}
						if (duration <= 180) {
							// System.out.println("Pass :: Duration<180 ::  "+duration);
						} else {
							System.out.println("Fail:: Duration>180 ::  " + duration);
						}

					}
				}

			} catch (Exception one) {
			}

			try {

				if (Testprint12.get("arrTarmac").toString().equals("null")) {
					// System.out.println("null");
				} else {

					int getGt15 = Testprint12.getJSONObject("arrTarmac").getJSONArray("longOnBoardGT60").length();
					for (int mia = 0; mia < getGt15; mia++) {
						// System.out.println(Testprint12.getJSONObject("arrTarmac").getJSONArray("longOnBoardGT60").getJSONObject(mia).getInt("duration"));
						int duration = Testprint12.getJSONObject("arrTarmac").getJSONArray("longOnBoardGT60")
								.getJSONObject(mia).getInt("duration");
						if (duration >= 60) {
							System.out.println("Duration>60 ::  " + duration);
						} else {
						}
						if (duration <= 180) {
							// System.out.println("Pass :: Duration<180 ::  "+duration);
						} else {
							System.out.println("Fail:: Duration>180 ::  " + duration);
						}

					}
				}

			} catch (Exception one) {
			}

			try {

				if (Testprint12.get("arrTarmac").toString().equals("null")) {
					// System.out.println("null");
				} else {

					int getGt15 = Testprint12.getJSONObject("arrTarmac").getJSONArray("longOnBoardGT30").length();
					for (int mia = 0; mia < getGt15; mia++) {
						// System.out.println(Testprint12.getJSONObject("arrTarmac").getJSONArray("longOnBoardGT30").getJSONObject(mia).getInt("duration"));
						int duration = Testprint12.getJSONObject("arrTarmac").getJSONArray("longOnBoardGT30")
								.getJSONObject(mia).getInt("duration");
						if (duration >= 30) {
							System.out.println("Duration>30 ::  " + duration);
						} else {
						}
						if (duration <= 180) {
							// System.out.println("Pass :: Duration<180 ::  "+duration);
						} else {
							System.out.println("Fail:: Duration>180 ::  " + duration);
						}

					}
				}

			} catch (Exception one) {
			}

			try {

				if (Testprint12.get("arrTarmac").toString().equals("null")) {
					// System.out.println("null");
				} else {

					int getGt15 = Testprint12.getJSONObject("arrTarmac").getJSONArray("longOnBoardGT15").length();
					for (int mia = 0; mia < getGt15; mia++) {
						// System.out.println(Testprint12.getJSONObject("arrTarmac").getJSONArray("longOnBoardGT15").getJSONObject(mia).getInt("duration"));
						int duration = Testprint12.getJSONObject("arrTarmac").getJSONArray("longOnBoardGT15")
								.getJSONObject(mia).getInt("duration");
						if (duration >= 15) {
							System.out.println("Duration>15 ::  " + duration);
						} else {
						}
						if (duration <= 180) {
						} else {
							System.out.println("Fail:: Duration>180 ::  " + duration);
						}

					}
				}

			} catch (Exception one) {
			}

			try {

				if (Testprint12.get("arrTarmac").toString().equals("null")) {
					// System.out.println("null");
				} else {

					int getGt15 = Testprint12.getJSONObject("arrTarmac").getJSONArray("longOnBoardGT120").length();
					for (int mia = 0; mia < getGt15; mia++) {
						// System.out.println(Testprint12.getJSONObject("arrTarmac").getJSONArray("longOnBoardGT120").getJSONObject(mia).getInt("duration"));
						int duration = Testprint12.getJSONObject("arrTarmac").getJSONArray("longOnBoardGT120")
								.getJSONObject(mia).getInt("duration");
						if (duration >= 120) {
							System.out.println("Duration>60 ::  " + duration);
						} else {
						}
						if (duration <= 180) {
							// System.out.println("Pass :: Duration<180 ::  "+duration);
						} else {
							System.out.println("Fail:: Duration>180 ::  " + duration);
						}

					}
				}

			} catch (Exception one) {
			}

			try {

				if (Testprint12.get("arrTarmac").toString().equals("null")) {
					// System.out.println("null");
				} else {

					int getGt15 = Testprint12.getJSONObject("arrTarmac").getJSONArray("longOnBoardGT150").length();
					for (int mia = 0; mia < getGt15; mia++) {
						// System.out.println(Testprint12.getJSONObject("arrTarmac").getJSONArray("longOnBoardGT150").getJSONObject(mia).getInt("duration"));
						int duration = Testprint12.getJSONObject("arrTarmac").getJSONArray("longOnBoardGT150")
								.getJSONObject(mia).getInt("duration");
						if (duration >= 150) {
							System.out.println("Duration>150 ::  " + duration);
						} else {
						}
						if (duration <= 180) {
							// System.out.println("Pass :: Duration<180 ::  "+duration);
						} else {
							System.out.println("Fail:: Duration>180 ::  " + duration);
						}

					}
				}

			} catch (Exception one) {
			}

			try {

				if (Testprint12.get("arrTarmac").toString().equals("null")) {
					// System.out.println("null");
				} else {

					int getGt15 = Testprint12.getJSONObject("arrTarmac").getJSONArray("longOnBoardGT90").length();
					for (int mia = 0; mia < getGt15; mia++) {
						// System.out.println(Testprint12.getJSONObject("arrTarmac").getJSONArray("longOnBoardGT90").getJSONObject(mia).getInt("duration"));
						int duration = Testprint12.getJSONObject("arrTarmac").getJSONArray("longOnBoardGT90")
								.getJSONObject(mia).getInt("duration");
						if (duration >= 90) {
							System.out.println("Duration>90 ::  " + duration);
						} else {
						}
						if (duration <= 180) {
							// System.out.println("Pass :: Duration<180 ::  "+duration);
						} else {
							System.out.println("Fail:: Duration>180 ::  " + duration);
						}

					}
				}

			} catch (Exception one) {
			}

			try {

				if (Testprint12.get("arrTarmac").toString().equals("null")) {
					// System.out.println("null");
				} else {

					int getGt15 = Testprint12.getJSONObject("arrTarmac").getJSONArray("longOnBoardGT180").length();
					for (int mia = 0; mia < getGt15; mia++) {
						// System.out.println(Testprint12.getJSONObject("arrTarmac").getJSONArray("longOnBoardGT180").getJSONObject(mia).getInt("duration"));
						int duration = Testprint12.getJSONObject("arrTarmac").getJSONArray("longOnBoardGT180")
								.getJSONObject(mia).getInt("duration");

						if (duration >= 180) {
							System.out.println("Duration>180 ::  " + duration);
						} else {
							// System.out.println("Fail:: Duration>180 ::  "+duration);
						}

						if (duration >= 60) {
							System.out.println("Duration>60 ::  " + duration);
						} else {
						}
						if (duration <= 180) {
							// System.out.println("Pass :: Duration<180 ::  "+duration);
						} else {
							System.out.println("Fail:: Duration>180 ::  " + duration);
						}

					}
				}

			} catch (Exception one) {
			}

		} catch (Exception Esta) {
			System.out.println("Exception ::  " + sta);
		}
	

}

// ***************************************************************************

public static void Tarmacgreaterthan15GETNGReponse(String strurl, String request1, String strurl2) throws Exception {
	// Fetch data from GETNextGen and get the NextGen Flight count
	DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	java.util.Date date = new java.util.Date();
	String dateWithoutTime = dateFormat.format(date); // "02 May 2016";
	String jsonString1 = request1;
	Tarmacgreaterthan15POST_JSON_GETNG(strurl, jsonString1, "json1.txt");

}

public static String Tarmacgreaterthan15POST_JSON_GETNG(String URL, String jsonString, String path)
		throws Exception {
	// System.out.println("Sending POST Request with value " + jsonString +
	// " to URL:" + URL);
	long startTime = Calendar.getInstance().getTimeInMillis();
	URL url = new URL(URL);
	String json = new String(jsonString);
	// System.out.println("jsonString:" + json);
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
	// String result = org.apache.commons.io.IOUtils.toString(in,"UTF-8");
	// // response is stored in result
	String result = org.apache.commons.io.IOUtils.toString(in, "UTF-8"); // response
																			// is
																			// stored
																			// in
																			// result
	try (FileWriter file = new FileWriter(path)) {
		file.write(result);
		in.close();
		conn.disconnect();
	}
	long endTime = Calendar.getInstance().getTimeInMillis();
	long responsetime = startTime - endTime;
	return result;
}

/*
 * Below code will check whether we have any MEL having null values which 
 * should not show null to user in UI.
 */


public static void MELNullcheckerstartcode(String url,String request,String urls,String sta ) throws Exception{
		  String url1=url;
		  String url3=urls;
	  	  String request12=request;
	  	 
	  	MELNullcheckerGETNGReponse(url1,request12,urls);	  
	  	MELNullcheckerPullAttributetoExcelSheet(sta);
	    }


public static void MELNullcheckerPullAttributetoExcelSheet(String sta) throws Exception{
		
	  MELNullcheckerDataPuller("json1.txt","Catering","EventAlert_Catering.xlsx",sta);

}



public static void MELNullcheckerDataPuller(String path,String SheetName,String ExcelName, String sta) throws Exception{
 
		    Date date = new Date();
		    TimeZone.setDefault(TimeZone.getTimeZone("GMT"));
		    Calendar cal = Calendar.getInstance(TimeZone.getDefault());
		    date = cal.getTime();
		    String timee = date.toGMTString();
		    long timeeunixx = cal.getTimeInMillis();
	
		
	  	long mil =System.currentTimeMillis();
	  	String st, full,append,le,extend, extended;
	  	full="";
	  	extended="";
	  	BufferedReader br = new BufferedReader(new FileReader(path));
	  	while ((st=br.readLine())!=null) {
	      full+=st;
	  	}
	  	
	
	  JSONArray jsonObj1 = new JSONArray(full);
	  int rowCountt =jsonObj1.length();
		for (int ii=0;ii<jsonObj1.length();ii++)
			
		{
			
			rowCountt++; 
			JSONObject Testprint11 = jsonObj1.getJSONObject(ii);
	
			try{
				String fltkey1 = Testprint11.getJSONObject("flight").getString("fltKey").replace(",", " ");
			JSONArray melOtsInfo = Testprint11.getJSONObject("addlFlightData").getJSONArray("melOtsInfo");
				String MELOTSINFOSTRING = melOtsInfo.toString();
			if(melOtsInfo!=null){
			
				int melcount = melOtsInfo.getJSONObject(0).getJSONArray("mels").length();
				int melcounter =0;
				for (int jj=0;jj<melcount;jj++){
					String dmiControlNumber = melOtsInfo.getJSONObject(0).getJSONArray("mels").getJSONObject(jj).getString("dmiControlNumber");
					String dmiPosition = melOtsInfo.getJSONObject(0).getJSONArray("mels").getJSONObject(jj).getString("dmiPosition");	
					String equipTypeEq = melOtsInfo.getJSONObject(0).getJSONArray("mels").getJSONObject(jj).getString("equipTypeEq");	
					String dmiText = melOtsInfo.getJSONObject(0).getJSONArray("mels").getJSONObject(jj).getString("dmiText");
					String dmiClass = melOtsInfo.getJSONObject(0).getJSONArray("mels").getJSONObject(jj).getString("dmiClass");
					String dmiEqType = melOtsInfo.getJSONObject(0).getJSONArray("mels").getJSONObject(jj).getString("dmiEqType");
					
					if(dmiControlNumber.contains("NULL")||dmiControlNumber.contains("null")
							||dmiPosition.contains("NULL")||dmiPosition.contains("null")
							||equipTypeEq.contains("NULL")||equipTypeEq.contains("null")
							||dmiText.contains("NULL")||dmiText.contains("null")
							||dmiClass.contains("NULL")||dmiClass.contains("null")
							||dmiEqType.contains("NULL")||dmiEqType.contains("null")){
						System.out.println(fltkey1); 
						System.out.println("Fail"); 
					}else{
						//System.out.println("Pass"); 
					}
					
				}

				
			}else
			{
			}
			}
			catch(Exception EEE)
			 {			 
				//System.out.println(" "); 
			 }
		}

	  
}

//***************************************************************************

public static void MELNullcheckerGETNGReponse(String strurl,String request1,String strurl2) throws Exception{
		
		//&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
		
		//Fetch data from GETNextGen and get the NextGen Flight count
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date = new java.util.Date();
		String dateWithoutTime =dateFormat.format(date);   //"02 May 2016"; 
		String jsonString1 = request1;
		MELNullcheckerPOST_JSON_GETNG(strurl,jsonString1,"json1.txt");
			
}


public static String MELNullcheckerPOST_JSON_GETNG(String URL, String jsonString,String path) throws Exception {
	 //   System.out.println("Sending POST Request with value " + jsonString + " to URL:" + URL);
	    long startTime=Calendar.getInstance().getTimeInMillis();
	     URL url = new URL(URL);
	    String json = new String(jsonString);
	 
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
		String result = org.apache.commons.io.IOUtils.toString(in,"UTF-8"); // response is stored in result
		try (FileWriter file = new FileWriter(path)) {
			file.write(result);
		in.close();
		conn.disconnect();
		}
		long endTime=Calendar.getInstance().getTimeInMillis();
		long responsetime = startTime-endTime;
		return result;
	}




public static String Getvalueinresponse(String Jsonobject,String valueofelement,int number) throws Exception{
  JSONArray jsonObj1 = new JSONArray(Jsonobject);
  JSONObject Testprint = jsonObj1.getJSONObject(number);

  try{
	  String EqpType = Testprint.getJSONObject("flight").getString(valueofelement);
	  return EqpType;
	  			 
  }catch(Exception Notastring)
  {
	  try{
		  Long EqpType =  Testprint.getJSONObject("flight").getLong(valueofelement); 
		  String EQtype = EqpType.toString();
		  return EQtype;
	  }catch(Exception Notalong)
	  {
		  try{
			  boolean EqpType = Testprint.getJSONObject("flight").getBoolean(valueofelement); 
			  String EQtype = String.valueOf(EqpType);
			  return EQtype;
		  }catch(Exception Notany)
		  {
			  return "Null"; 
		  }
		  
	  }
	  
  }

  
  
	
  
  
  
}


public static void NotepadtoexcelFlightdetails1(String path,String station) throws Exception{

long mil =System.currentTimeMillis();
String st, full,append,le,extend, extended,st2, full2;
full="";
full2="";
extended="";


BufferedReader br = new BufferedReader(new FileReader(path));
while ((st=br.readLine())!=null) {
  full+=st;
  }


BufferedReader br2 = new BufferedReader(new FileReader("json2.txt"));
while ((st2=br2.readLine())!=null) {
  full2+=st2;
  }

JSONArray jsonObj1 = new JSONArray(full);
JSONArray jsonObj2 = new JSONArray(full2);




XSSFWorkbook workbook = new XSSFWorkbook();
XSSFSheet sheet = workbook.createSheet("FlightgiventimeFlightDetails");
for (int i=0;i<jsonObj1.length();i++)
{
	
	if(full.equalsIgnoreCase("[]")){
			System.out.println("NUll Response in :::::::::  apapns89  :::::::::   "+full );
			//test.log(LogStatus.FAIL, "NUll Response in :::::::::  apapns89 :::::::::    "+full);
			 ATUReports.add("NUll Response in :::::::::  apapns89 :::::::::    "+full,  LogAs.FAILED, null);
			break;
		}
		if(full2.equalsIgnoreCase("[]")){
		System.out.println("NUll Response in Cache:::::::::   apapns44 ::::::::: "+full2 );
		ATUReports.add("NUll Response in Cache:::::::::   apapns44 :::::::::  "+full2,  LogAs.FAILED, null);
		//test.log(LogStatus.FAIL, "NUll Response in Cache:::::::::   apapns44 :::::::::  "+full2);
		break;
		}
		
		
   JSONObject Testprint1 = jsonObj1.getJSONObject(i);
		String obj1 =    jsonObj1.getJSONObject(i).toString();
String Intermediateobject2 =obj1;
String fltkey =  	Getvalueinresponse(full,"fltKey",i);
String priorfltkey = Getvalueinresponse(full,"priorLegKey",i);
System.out.println("Validating flight no::  "+i);
   
   for (int j=0;j<jsonObj2.length();j++)
   {
	   JSONObject Testprint2 = jsonObj2.getJSONObject(j);
     	String obj2 =    jsonObj2.getJSONObject(j).toString();
	String Intermediateobject22 = obj2; 
	String fltkey2 =  	Getvalueinresponse(full2,"fltKey",j);
	String priorfltkey2 = Getvalueinresponse(full2,"priorLegKey",j);      
  
	boolean fltkeyempty = fltkey.contains("Null");
	boolean priorfltkeyempty = fltkey.contains("Null");
	
 
	   if(fltkeyempty==false)
	   {
		   if(fltkey.contains(fltkey2)){
		   Fetchandcompare(full,full2,i,j,fltkey,fltkey2);
		   if(j==jsonObj2.length()-1){
			   
			   ATUReports.add("Reached end of searching fltkey and no key found  "+fltkey,  LogAs.INFO, null);
		   }
		   break;
		   }
		   
	   }    	   
	   else
	   {
		   if(priorfltkeyempty==false)
		   {
			   if(priorfltkey.contains(priorfltkey2)){
		   Fetchandcompare(full,full2,i,j,fltkey,fltkey2);
		   if(j==jsonObj2.length()-1){
			//  test.log(LogStatus.INFO, "Reached end of searching fltkey and no key found  "+fltkey);
			   ATUReports.add("Reached end of searching fltkey and no key found  "+fltkey,  LogAs.INFO, null);
		   }
		   break;
			   }
		   }
	   
	   }
	   
   }	}

 }




public static void GETNGReponse(String strurl,String strurl_cache, String strStation, String strStartTime, String strEndTime) throws Exception{

int count=0;
int count1=0;
int counter1=0;
int counter=0;
String NextGen_Fltnum =null;
ArrayList al=new ArrayList();
ArrayList al_new=new ArrayList();	
String NextGenCache_Fltnum =null;
String NextGen_Fltnum_cache=null; 
String Next_Fltnum=null;

//&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&

//Fetch data from GETNextGen and get the NextGen Flight count
DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
java.util.Date date = new java.util.Date();
String dateWithoutTime =dateFormat.format(date);   //"02 May 2016"; 
String strStartTime2 = dateWithoutTime + "T" + strStartTime +".737Z";
String strEndTime2 = dateWithoutTime + "T" + strEndTime +".737Z";
String jsonString1 =  "{\"fltKeys\":"+strStation+",\"instance\":\"stage44\"}";
 
String jsonString2 = strStation;
String strTotalFlights_NGN = POST_JSON_GETNG(strurl_cache,jsonString2,"json2.txt");
String strTotalFlights_NG = POST_JSON_GETNG(strurl,jsonString1,"json1.txt");



if(strTotalFlights_NG.contains("[]")){
	System.out.println("NUll Response in DB:::::::::  strTotalFlights_NG     "+jsonString1 );
//	test.log(LogStatus.FAIL, "NUll Response in DB:::::::::  strTotalFlights_NG     "+jsonString1);
	ATUReports.add("NUll Response in DB:::::::::  strTotalFlights_NG     "+jsonString1,  LogAs.FAILED, null);
}
if(strTotalFlights_NGN.contains("[]")){
System.out.println("NUll Response in Cache:::::::::   strTotalFlights_NGN  "+jsonString2 );
//test.log(LogStatus.FAIL, "NUll Response in Cache:::::::::   strTotalFlights_NGN  "+jsonString2);
ATUReports.add("NUll Response in Cache:::::::::   strTotalFlights_NGN  ",  LogAs.INFO, null);
}
}




public static String POST_JSON_GETNG(String URL, String jsonString,String path) throws Exception {
System.out.println("Sending POST Request with value " + jsonString + " to URL:" + URL);

 
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
//	System.out.println("JSON Response:" + result);

try (FileWriter file = new FileWriter(path)) {
	file.write(result);
in.close();
conn.disconnect();
}
long endTime=Calendar.getInstance().getTimeInMillis();
long responsetime = startTime-endTime;
//System.out.println("The Total time taken for url  "+"   "+ URL+"is"+responsetime+ "   milliseconds");
return result;
}


public  static String getrequest(String keyurl) throws IOException {

String USER_AGENT = "Mozilla/5.0";

String url = "http://apapns44.pdc.aa.com:8080/GetFlightCache/flight/flightCacheKeySet";

URL obj = new URL(url);
HttpURLConnection con = (HttpURLConnection) obj.openConnection();

// optional default is GET
con.setRequestMethod("GET");

//add request header
con.setRequestProperty("User-Agent", USER_AGENT);

int responseCode = con.getResponseCode();
System.out.println("\nSending 'GET' request to URL : " + url);
System.out.println("Response Code : " + responseCode);

BufferedReader in = new BufferedReader(
        new InputStreamReader(con.getInputStream()));
String inputLine;
StringBuffer response = new StringBuffer();

while ((inputLine = in.readLine()) != null) {
	response.append(inputLine);
}
in.close();

//print result
System.out.println(response.toString());
String result = response.toString();
return result;
}

public static void VerifyProdvsStage(String url,String url_cache,String station,String strStartTime,String strEndTime) throws Exception{

String url1=url;
String url_cache1=url_cache;
String station1=station;
String strStartTime1=strStartTime;
String strEndTime1=strEndTime;

VerifyNewEQtypeInclusionGETNGReponsestavsprod(url1,url_cache1,station1,strStartTime1,strEndTime1);
NotepadtoexcelFlightdetails1("json1.txt","DFW");
}


public static String StavsprodInclusionPOST_JSON_GETNG(String URL, String jsonString,String path) throws Exception {
System.out.println("Sending POST Request with value " + jsonString + " to URL:" + URL);

long startTime=Calendar.getInstance().getTimeInMillis();

URL url = new URL(URL);
String json = new String(jsonString);
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
	String result = org.apache.commons.io.IOUtils.toString(in,"UTF-8"); // response is stored in result
try (FileWriter file = new FileWriter(path)) {
	file.write(result);
in.close();
conn.disconnect();
}
long endTime=Calendar.getInstance().getTimeInMillis();
long responsetime = startTime-endTime;
System.out.println("The Total time taken for url  "+"   "+ URL+"is"+responsetime+ "   milliseconds");
return result;
}


public static void VerifyNewEQtypeInclusionGETNGReponsestavsprod(String strurl,String strurl_cache, String strStation, String strStartTime, String strEndTime) throws Exception{


int count=0;
int count1=0;
int counter1=0;
int counter=0;
String NextGen_Fltnum =null;
ArrayList al=new ArrayList();
ArrayList al_new=new ArrayList();	
String NextGenCache_Fltnum =null;
String NextGen_Fltnum_cache=null; 
String Next_Fltnum=null;

//Fetch data from GETNextGen and get the NextGen Flight count
DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
java.util.Date date = new java.util.Date();
String dateWithoutTime =dateFormat.format(date);   //"02 May 2016"; 
String strStartTime2 = dateWithoutTime + "T" + strStartTime +".737Z";
String strEndTime2 = dateWithoutTime + "T" + strEndTime +".737Z";
String jsonString1 = "{\"station\":\""+ strStation + "\",\"pastFlights\":\"true\",\"startTime\":\""+ strStartTime2 + "\",\"endTime\":\""+ strEndTime2 + "\",\"iatacode\":null,\"gates\":null,\"narrowBody\":true,\"wideBody\":true,\"internationalFlts\":true,\"domesticFlts\":true,\"transactionId\":\"UNKNOWN-0.0.00000_00812339_DFW_1515566607124_201\"}";
String strTotalFlights_NG = StavsprodInclusionPOST_JSON_GETNG(strurl,jsonString1,"json1.txt");
if(strTotalFlights_NG.equals("") || strTotalFlights_NG.equals("null")){
	System.out.println("Invalid response from GETNG service");
}	
strTotalFlights_NG = strTotalFlights_NG.trim();
String[] arrstrNGTotalFlights = strTotalFlights_NG.split("fltKey\":\""); //"fltKey":"AA,3698,2016-09-19,DFW,0"
int GETNG_TotalFlights = (arrstrNGTotalFlights.length-1);
String strTotalFlights_NGCache = StavsprodInclusionPOST_JSON_GETNG(strurl_cache,jsonString1,"json2.txt");
}




public static void Fetchandcompare(String full, String full2, int i, int j, String fltKey, String fltKey2) throws Exception{


try
	{
	try{
		String EqpType =  	Getvalueinresponse(full,"assignedEquipType",i);
		String EqpType2 =  	Getvalueinresponse(full2,"assignedEquipType",j);

		
		String fltNum =  	Getvalueinresponse(full,"fltNum",i);
		String fltNum2 =  	Getvalueinresponse(full2,"fltNum",j);


		String fltOrgDate =  	Getvalueinresponse(full,"fltOrgDate",i);
		String fltOrgDate2 =  	Getvalueinresponse(full2,"fltOrgDate",j);

		String depSta =  	Getvalueinresponse(full,"depSta",i);
		String depSta2 =  	Getvalueinresponse(full2,"depSta",j);

		String dupDepStaNum =  	Getvalueinresponse(full,"dupDepStaNum",i);
	//	System.out.println("dupDepStaNum::  "+dupDepStaNum);
		String dupDepStaNum2 =  Getvalueinresponse(full2,"dupDepStaNum",j);
		//System.out.println("dupDepStaNum::  "+dupDepStaNum);

		String carrierCode =  	Getvalueinresponse(full,"carrierCode",i);
		String carrierCode2 =  	Getvalueinresponse(full2,"carrierCode",j);
		
		String iata =  	Getvalueinresponse(full,"iata",i);
		String iata2 =  	Getvalueinresponse(full2,"iata",j);

		String destination =  	Getvalueinresponse(full,"destination",i);
		String destination2 =  	Getvalueinresponse(full2,"destination",j);
		
		String dupArrStaNum =  	Getvalueinresponse(full,"dupArrStaNum",i);
		String dupArrStaNum2 =  	Getvalueinresponse(full2,"dupArrStaNum",j);

		String assignedTail =  	Getvalueinresponse(full,"assignedTail",i);
		String assignedTail2 =  	Getvalueinresponse(full2,"assignedTail",j);

		String skdEquipType =  	Getvalueinresponse(full,"skdEquipType",i);
		String skdEquipType2 =  	Getvalueinresponse(full2,"skdEquipType",j);

		String assignedEquipType =  	Getvalueinresponse(full,"assignedEquipType",i);
		String assignedEquipType2 =  	Getvalueinresponse(full2,"assignedEquipType",j);

		String aircraftRegistrationNbr =  	Getvalueinresponse(full,"aircraftRegistrationNbr",i);
		String aircraftRegistrationNbr2 =  	Getvalueinresponse(full2,"aircraftRegistrationNbr",j);

		String skdTaxiOut =  	Getvalueinresponse(full,"skdTaxiOut",i);
		String skdTaxiOut2 =  	Getvalueinresponse(full2,"skdTaxiOut",j);

		String skdTaxiIn =  	Getvalueinresponse(full,"skdTaxiIn",i);
		String skdTaxiIn2 =  	Getvalueinresponse(full2,"skdTaxiIn",j);

		String latestTaxiOut =  	Getvalueinresponse(full,"latestTaxiOut",i);
		String latestTaxiOut2 =  	Getvalueinresponse(full2,"latestTaxiOut",j);

		String latestTaxiIn =  	Getvalueinresponse(full,"latestTaxiIn",i);
		String latestTaxiIn2 =  	Getvalueinresponse(full2,"latestTaxiIn",j);

		String depGMTAdjustment =  	Getvalueinresponse(full,"depGMTAdjustment",i);
		String depGMTAdjustment2 =  	Getvalueinresponse(full2,"depGMTAdjustment",j);

		String arrGMTAdjustment =  	Getvalueinresponse(full,"arrGMTAdjustment",i);
		String arrGMTAdjustment2 =  	Getvalueinresponse(full2,"arrGMTAdjustment",j);

		String mogt =  	Getvalueinresponse(full,"mogt",i);
		String mogt2 =  	Getvalueinresponse(full2,"mogt",j);

		String nextLegFltNum =  	Getvalueinresponse(full,"nextLegFltNum",i);
		String nextLegFltNum2 =  	Getvalueinresponse(full2,"nextLegFltNum",j);

		String nextLegOrgDate =  	Getvalueinresponse(full,"nextLegOrgDate",i);
		String nextLegOrgDate2 =  	Getvalueinresponse(full2,"nextLegOrgDate",j);

		String nextLegFltDupCode =  	Getvalueinresponse(full,"nextLegFltDupCode",i);
		String nextLegFltDupCode2 =  	Getvalueinresponse(full2,"nextLegFltDupCode",j);

		String nextLegCarrierCode =  	Getvalueinresponse(full,"nextLegCarrierCode",i);
		String nextLegCarrierCode2 =  	Getvalueinresponse(full2,"nextLegCarrierCode",j);

		String nextLegKey =  	Getvalueinresponse(full,"nextLegKey",i);
		String nextLegKey2 =  	Getvalueinresponse(full2,"nextLegKey",j);

		String priorLegFltNum =  	Getvalueinresponse(full,"priorLegFltNum",i);
		String priorLegFltNum2 =  	Getvalueinresponse(full2,"priorLegFltNum",j);

		String priorLegOrgDate =  	Getvalueinresponse(full,"priorLegOrgDate",i);
		String priorLegOrgDate2 =  	Getvalueinresponse(full2,"priorLegOrgDate",j);

		String priorLegFltDupCode =  	Getvalueinresponse(full,"priorLegFltDupCode",i);
		String priorLegFltDupCode2 =  	Getvalueinresponse(full2,"priorLegFltDupCode",j);

		String priorLegDepStation =  	Getvalueinresponse(full,"priorLegDepStation",i);
		String priorLegDepStation2 =  	Getvalueinresponse(full2,"priorLegDepStation",j);
		
		String priorLegCarrierCode =  	Getvalueinresponse(full,"priorLegCarrierCode",i);
		String priorLegCarrierCode2 =  	Getvalueinresponse(full2,"priorLegCarrierCode",j);

		
		String legStatus =  	Getvalueinresponse(full,"legStatus",i);
		String legStatus2 =  	Getvalueinresponse(full2,"legStatus",j);

		String depStatus =  	Getvalueinresponse(full,"depStatus",i);
		String depStatus2 =  	Getvalueinresponse(full2,"depStatus",j);

		String arrStatus =  	Getvalueinresponse(full,"arrStatus",i);
		String arrStatus2 =  	Getvalueinresponse(full2,"arrStatus",j);

		String depGate =  	Getvalueinresponse(full,"depGate",i);
		String depGate2 =  	Getvalueinresponse(full2,"depGate",j);

		String arrGate =  	Getvalueinresponse(full,"arrGate",i);
		String arrGate2 =  	Getvalueinresponse(full2,"arrGate",j);
		
		String bagclaim =  	Getvalueinresponse(full,"bagclaim",i);
		String bagclaim2 =  	Getvalueinresponse(full2,"bagclaim",j);
	
	//	String arrTerminal =  	Getvalueinresponse(full,"assignedEquipType");
	//	String arrTerminal2 =  	Getvalueinresponse(full2,"assignedEquipType");
		
		String intOrDom =  	Getvalueinresponse(full,"intOrDom",i);
		String intOrDom2 =  	Getvalueinresponse(full2,"intOrDom",j);

		String kickOffFlt =  	Getvalueinresponse(full,"kickOffFlt",i);
		String kickOffFlt2 =  	Getvalueinresponse(full2,"kickOffFlt",j);
		
	//	String depTerminal =  	Testprint1.getString("depTerminal");
	//	String depTerminal2 =  	Getvalueinresponse(full2,"assignedEquipType");String("depTerminal");

	////////////////////////////////////////////////////////////////////////////////////////////////////////////

		String isThruFlight =  	Getvalueinresponse(full,"isThruFlight",i);
		String isThruFlight2 =  	Getvalueinresponse(full2,"isThruFlight",j);

		String getDepStatus =  	Getvalueinresponse(full,"getDepStatus",i);
		String getDepStatus2 =  	Getvalueinresponse(full2,"getDepStatus",j);

		String getArrStatus =  	Getvalueinresponse(full,"getArrStatus",i);
		String getArrStatus2 =  	Getvalueinresponse(full2,"getArrStatus",j);

		String wtRestricted =  	Getvalueinresponse(full,"wtRestricted",i);
		String wtRestricted2 =  	Getvalueinresponse(full2,"wtRestricted",j);
		
		String dispDesk =  	Getvalueinresponse(full,"dispDesk",i);
		String dispDesk2 =  	Getvalueinresponse(full2,"dispDesk",j);
		
	

		String depGateChange =  	Getvalueinresponse(full,"depGateChange",i);
		String depGateChange2 =  	Getvalueinresponse(full2,"depGateChange",j);

		String expectedTimeArrivalGMT =  	Getvalueinresponse(full,"expectedTimeArrivalGMT",i);
		String expectedTimeArrivalGMT2 =  	Getvalueinresponse(full2,"expectedTimeArrivalGMT",j);

		String scheduledTimeArrivalGMT =  	Getvalueinresponse(full,"scheduledTimeArrivalGMT",i);
		String scheduledTimeArrivalGMT2 =  	Getvalueinresponse(full2,"scheduledTimeArrivalGMT",j);

		String expectedTimeDepartureGMT =  	Getvalueinresponse(full,"expectedTimeDepartureGMT",i);
		String expectedTimeDepartureGMT2 =  	Getvalueinresponse(full2,"expectedTimeDepartureGMT",j);

		String scheduledTimeDepartureGMT =  	Getvalueinresponse(full,"scheduledTimeDepartureGMT",i);
		String scheduledTimeDepartureGMT2 =  	Getvalueinresponse(full2,"scheduledTimeDepartureGMT",j);

		String expectedTimeArrivalLocal =  	Getvalueinresponse(full,"expectedTimeArrivalLocal",i);
		String expectedTimeArrivalLocal2 =  	Getvalueinresponse(full2,"expectedTimeArrivalLocal",j);

		String scheduledTimeArrivalLocal =  	Getvalueinresponse(full,"scheduledTimeArrivalLocal",i);
		String scheduledTimeArrivalLocal2 =  	Getvalueinresponse(full2,"scheduledTimeArrivalLocal",j);

		String expectedTimeDepartureLocal =  	Getvalueinresponse(full,"expectedTimeDepartureLocal",i);
		String expectedTimeDepartureLocal2 =  	Getvalueinresponse(full2,"expectedTimeDepartureLocal",j);

		String scheduledTimeDepartureLocal =  	Getvalueinresponse(full,"scheduledTimeDepartureLocal",i);
		String scheduledTimeDepartureLocal2 =  	Getvalueinresponse(full2,"scheduledTimeDepartureLocal",j);
		
		
		String actualOnGMT =  	Getvalueinresponse(full,"actualOnGMT",i);
		String actualOnGMT2 =  	Getvalueinresponse(full2,"actualOnGMT",j);
		
	
		
		String actualOnLoc =  	Getvalueinresponse(full,"actualOnLoc",i);
		String actualOnLoc2 =  	Getvalueinresponse(full2,"actualOnLoc",j);
		
		
		String actualInGMT =  	Getvalueinresponse(full,"actualInGMT",i);
		String actualInGMT2 =  	Getvalueinresponse(full2,"actualInGMT",j);
		
	
		String actualInLoc =  	Getvalueinresponse(full,"actualInLoc",i);
		String actualInLoc2 =  	Getvalueinresponse(full2,"actualInLoc",j);
		
	
		String actualOutGMT =  	Getvalueinresponse(full,"actualOutGMT",i);
		String actualOutGMT2 =  	Getvalueinresponse(full2,"actualOutGMT",j);
		
		
		String actualOutLoc =  	Getvalueinresponse(full,"actualOutLoc",i);
		String actualOutLoc2 =  	Getvalueinresponse(full2,"actualOutLoc",j);
		
		
		String actualOffGMT =  	Getvalueinresponse(full,"actualOffGMT",i);
		String actualOffGMT2 =  	Getvalueinresponse(full2,"actualOffGMT",j);
		
		String actualOffLoc =  	Getvalueinresponse(full,"actualOffLoc",i);
		String actualOffLoc2 =  	Getvalueinresponse(full2,"actualOffLoc",j);

		

		String sourceTimeStamp =  	Getvalueinresponse(full,"sourceTimeStamp",i);
		String sourceTimeStamp2 =  	Getvalueinresponse(full2,"sourceTimeStamp",j);

		String etdUpdatedAt =  	Getvalueinresponse(full,"etdUpdatedAt",i);
		String etdUpdatedAt2 =  	Getvalueinresponse(full2,"etdUpdatedAt",j);

		String etaUpdatedAt =  	Getvalueinresponse(full,"etaUpdatedAt",i);
		String etaUpdatedAt2 =  	Getvalueinresponse(full2,"etaUpdatedAt",j);

		
		String onUpdatedAt =  	Getvalueinresponse(full,"onUpdatedAt",i);
			String onUpdatedAt2 =  	Getvalueinresponse(full2,"onUpdatedAt",j);

	
			String eonUpdatedAt =  	Getvalueinresponse(full,"eonUpdatedAt",i);
			String eonUpdatedAt2 =  	Getvalueinresponse(full2,"eonUpdatedAt",j);
		
		
		String inUpdatedAt =  	Getvalueinresponse(full,"inUpdatedAt",i);
			String inUpdatedAt2 =  	Getvalueinresponse(full2,"inUpdatedAt",j);
		
		
		
		String offUpdatedAt =  	Getvalueinresponse(full,"offUpdatedAt",i);
			String offUpdatedAt2 =  	Getvalueinresponse(full2,"offUpdatedAt",j);
		
		
		
			String etoUpdatedAt =  	Getvalueinresponse(full,"etoUpdatedAt",i);
			String etoUpdatedAt2 =  	Getvalueinresponse(full2,"etoUpdatedAt",j);
		
		
	
			String outUpdatedAt =  	Getvalueinresponse(full,"outUpdatedAt",i);
			String outUpdatedAt2 =  	Getvalueinresponse(full2,"outUpdatedAt",j);
		

			String cancelUpdatedAt =  	Getvalueinresponse(full,"cancelUpdatedAt",i);
			String cancelUpdatedAt2 =  	Getvalueinresponse(full2,"cancelUpdatedAt",j);
		

			String eqsubUpdatedAt =  	Getvalueinresponse(full,"eqsubUpdatedAt",i);
			String eqsubUpdatedAt2 =  	Getvalueinresponse(full2,"eqsubUpdatedAt",j);
		
		
			String eqlinkUpdatedAt =  	Getvalueinresponse(full,"eqlinkUpdatedAt",i);
			String eqlinkUpdatedAt2 =  	Getvalueinresponse(full2,"eqlinkUpdatedAt",j);
		
		
			String groundTimeUpdatedAt =  	Getvalueinresponse(full,"groundTimeUpdatedAt",i);
			String groundTimeUpdatedAt2 =  	Getvalueinresponse(full2,"groundTimeUpdatedAt",j);
		
		
			String gateUpdatedAt =  	Getvalueinresponse(full,"gateUpdatedAt",i);
		String gateUpdatedAt2 =  	Getvalueinresponse(full2,"gateUpdatedAt",j);
		
		String createUpdatedAt =  	Getvalueinresponse(full,"createUpdatedAt",i);
		String createUpdatedAt2 =  	Getvalueinresponse(full2,"createUpdatedAt",j);
		
		
		String cycleUpdatedAt =  	Getvalueinresponse(full,"cycleUpdatedAt",i);
		String cycleUpdatedAt2 =  	Getvalueinresponse(full2,"cycleUpdatedAt",j);
		    			
		String deleteUpdatedAt =  	Getvalueinresponse(full,"deleteUpdatedAt",i);
		String deleteUpdatedAt2 =  	Getvalueinresponse(full2,"deleteUpdatedAt",j);
		
	
		String continuationUpdatedAt =  	Getvalueinresponse(full,"continuationUpdatedAt",i);
		String continuationUpdatedAt2	 =  	Getvalueinresponse(full2,"continuationUpdatedAt",j);
		
		
	
		String reinstateUpdatedAt =  	Getvalueinresponse(full,"reinstateUpdatedAt",i);
		String reinstateUpdatedAt2 =  	Getvalueinresponse(full2,"reinstateUpdatedAt",j);
	
		String diversionUpdatedAt =  	Getvalueinresponse(full,"diversionUpdatedAt",i);
		String diversionUpdatedAt2 =  	Getvalueinresponse(full2,"diversionUpdatedAt",j);
	
		String returnUpdatedAt =  	Getvalueinresponse(full,"returnUpdatedAt",i);
		String returnUpdatedAt2 =  	Getvalueinresponse(full2,"returnUpdatedAt",j);
	
		String decisionUpdatedAt =  	Getvalueinresponse(full,"returnUpdatedAt",i);
		String decisionUpdatedAt2 =  	Getvalueinresponse(full2,"returnUpdatedAt",j);

		
		String rtdUpdatedAt =  	Getvalueinresponse(full,"rtdUpdatedAt",i);
		String rtdUpdatedAt2 =  	Getvalueinresponse(full2,"rtdUpdatedAt",j);
		
		
		String crewUpdatedAt =  	Getvalueinresponse(full,"crewUpdatedAt",i);
		String crewUpdatedAt2 =  	Getvalueinresponse(full2,"crewUpdatedAt",j);
		
	
		String fuelSlipUpdatedAt =  	Getvalueinresponse(full,"fuelSlipUpdatedAt",i);
		String fuelSlipUpdatedAt2 =  	Getvalueinresponse(full2,"fuelSlipUpdatedAt",j);
		
		

		
	try{
		
	if(EqpType.contains(EqpType2))
	{
	
	}else{
		System.out.println(fltKey2+"EqpType Fail :  " +EqpType+"   "+EqpType2+"  --------- "+fltKey);
		//test.log(LogStatus.FAIL, "EqpType   Fail :  " +EqpType+"   "+EqpType2+"  --------- "+fltKey);
		ATUReports.add("EqpType   Fail :  " +EqpType+"   "+EqpType2+"  --------- "+fltKey,  LogAs.FAILED, null);
	}
	
	
	

	
	
	if(fltNum.contains(fltNum2))
	{
	
	}else{
		System.out.println(fltKey2+"fltNum  Fail :  " +fltNum+"   "+fltNum2+"  --------- "+fltKey);
	//	test.log(LogStatus.FAIL,"fltNum  Fail :  " +fltNum+"   "+fltNum2+"  --------- "+fltKey);
		ATUReports.add("fltNum  Fail :  " +fltNum+"   "+fltNum2+"  --------- "+fltKey,  LogAs.FAILED, null);
	}
	
	
	if(fltOrgDate.contains(fltOrgDate2))
	{
	
	}else{
		System.out.println(fltKey2+"fltOrgDate  Fail :  " +fltOrgDate+"   "+fltOrgDate2+"  --------- "+fltKey);
		//test.log(LogStatus.FAIL,"fltOrgDate  Fail :  " +fltOrgDate+"   "+fltOrgDate2+"  --------- "+fltKey);
		ATUReports.add("fltOrgDate  Fail :  " +fltOrgDate+"   "+fltOrgDate2+"  --------- "+fltKey,  LogAs.FAILED, null);
	}
	
		
	if(depSta.contains(depSta2))
	{
	
	}else{
		System.out.println(fltKey2+"depSta  Fail :  " +depSta+"   "+depSta2+"  --------- "+fltKey);
		//test.log(LogStatus.FAIL,"depSta  Fail :  " +depSta+"   "+depSta2+"  --------- "+fltKey);
		ATUReports.add("depSta  Fail :  " +depSta+"   "+depSta2+"  --------- "+fltKey,  LogAs.FAILED, null);
	}
	
	
	if(dupDepStaNum.equalsIgnoreCase(dupDepStaNum2))
	{
	
	}else{
		System.out.println(fltKey2+"dupDepStaNum  Fail :  " +dupDepStaNum+"   "+dupDepStaNum2+"  --------- "+fltKey);
	//	test.log(LogStatus.FAIL, "dupDepStaNum  Fail :  " +dupDepStaNum+"   "+dupDepStaNum2+"  --------- "+fltKey);
		ATUReports.add("dupDepStaNum  Fail :  " +dupDepStaNum+"   "+dupDepStaNum2+"  --------- "+fltKey,  LogAs.FAILED, null);
	}
	
	
	if(carrierCode.contains(carrierCode2))
	{
	
	}else{
		System.out.println(fltKey2+"carrierCode  Fail :  " +carrierCode+"   "+carrierCode2+"  --------- "+fltKey);
//		test.log(LogStatus.FAIL,"carrierCode  Fail :  " +carrierCode+"   "+carrierCode2+"  --------- "+fltKey);
		ATUReports.add("carrierCode  Fail :  " +carrierCode+"   "+carrierCode2+"  --------- "+fltKey,  LogAs.INFO, null);
	}
	
	
	if(iata.contains(iata2))
	{
	
	}else{
		System.out.println(fltKey2+"iata  Fail :  " +iata+"   "+iata2+"  --------- "+fltKey);
		//test.log(LogStatus.FAIL,"iata  Fail :  " +iata+"   "+iata2+"  --------- "+fltKey);
		ATUReports.add("iata  Fail :  " +iata+"   "+iata2+"  --------- "+fltKey,  LogAs.FAILED, null);
	}
	
	
	if(destination.contains(destination2))
	{
	
	}else{
		System.out.println(fltKey2+"destination  Fail :  " +destination+"   "+destination2+"  --------- "+fltKey);
		//test.log(LogStatus.FAIL,"destination  Fail :  " +destination+"   "+destination2+"  --------- "+fltKey);
		ATUReports.add("destination  Fail :  " +destination+"   "+destination2+"  --------- "+fltKey,  LogAs.FAILED, null);
	}
	
	
	if(dupArrStaNum.contains(dupArrStaNum2))
	{
	
	}else{
		System.out.println(fltKey2+" dupArrStaNum Fail :  " +dupArrStaNum+"   "+dupArrStaNum2+"  --------- "+fltKey);
		//test.log(LogStatus.FAIL, " dupArrStaNum Fail :  " +dupArrStaNum+"   "+dupArrStaNum2+"  --------- "+fltKey);
		ATUReports.add(" dupArrStaNum Fail :  " +dupArrStaNum+"   "+dupArrStaNum2+"  --------- "+fltKey,  LogAs.FAILED, null);
	}
	
	
	if(assignedTail .contains(assignedTail2))
	{
	
	}else{
		System.out.println(fltKey2+"assignedTail  Fail :  " +assignedTail+"   "+assignedTail2+"  --------- "+fltKey);
		//test.log(LogStatus.FAIL,"assignedTail  Fail :  " +assignedTail+"   "+assignedTail2+"  --------- "+fltKey);
		ATUReports.add("assignedTail  Fail :  " +assignedTail+"   "+assignedTail2+"  --------- "+fltKey,  LogAs.FAILED, null);
	}
	
	
	if(skdEquipType.contains(skdEquipType2))
	{
	
	}else{
		System.out.println(fltKey2+"skdEquipType  Fail :  " +skdEquipType+"   "+skdEquipType2+"  --------- "+fltKey);
		//test.log(LogStatus.FAIL,"skdEquipType  Fail :  " +skdEquipType+"   "+skdEquipType2+"  --------- "+fltKey);
		ATUReports.add("skdEquipType  Fail :  " +skdEquipType+"   "+skdEquipType2+"  --------- "+fltKey,  LogAs.FAILED, null);
	}
	
	
	if(assignedEquipType.contains(assignedEquipType2))
	{
	
	}else{
		System.out.println(fltKey2+"assignedEquipType  Fail :  " +assignedEquipType+"   "+assignedEquipType2+"  --------- "+fltKey);
		//test.log(LogStatus.FAIL,"assignedEquipType  Fail :  " +assignedEquipType+"   "+assignedEquipType2+"  --------- "+fltKey);
		ATUReports.add("assignedEquipType  Fail :  " +assignedEquipType+"   "+assignedEquipType2+"  --------- "+fltKey,  LogAs.FAILED, null);
	}
	
	
	if(aircraftRegistrationNbr.contains(aircraftRegistrationNbr2))
	{
	
	}else{
		System.out.println(fltKey2+"aircraftRegistrationNbr  Fail :  " +aircraftRegistrationNbr+"   "+aircraftRegistrationNbr2+"  --------- "+fltKey);
		//test.log(LogStatus.FAIL,"aircraftRegistrationNbr  Fail :  " +aircraftRegistrationNbr+"   "+aircraftRegistrationNbr2+"  --------- "+fltKey);
		ATUReports.add("aircraftRegistrationNbr  Fail :  " +aircraftRegistrationNbr+"   "+aircraftRegistrationNbr2+"  --------- "+fltKey,  LogAs.FAILED, null);
	}
	
	
	
	if(skdTaxiOut.equalsIgnoreCase(skdTaxiOut2))
	{
	
	}else{
		System.out.println(fltKey2+"skdTaxiOut  Fail :  " +skdTaxiOut+"   "+skdTaxiOut2+"  --------- "+fltKey);
		//test.log(LogStatus.FAIL,"skdTaxiOut  Fail :  " +skdTaxiOut+"   "+skdTaxiOut2+"  --------- "+fltKey);
		ATUReports.add("skdTaxiOut  Fail :  " +skdTaxiOut+"   "+skdTaxiOut2+"  --------- "+fltKey,  LogAs.FAILED, null);
	}
	
	
	if(skdTaxiIn.equalsIgnoreCase(skdTaxiIn2))
	{
	
	}else{
		System.out.println(fltKey2+"skdTaxiIn  Fail :  " +skdTaxiIn+"   "+skdTaxiIn2+"  --------- "+fltKey);
		//test.log(LogStatus.FAIL,"skdTaxiIn  Fail :  " +skdTaxiIn+"   "+skdTaxiIn2+"  --------- "+fltKey);
		ATUReports.add("skdTaxiIn  Fail :  " +skdTaxiIn+"   "+skdTaxiIn2+"  --------- "+fltKey,  LogAs.FAILED, null);
	}
	
	
	if(latestTaxiOut.equalsIgnoreCase(latestTaxiOut2))
	{
	
	}else{
		System.out.println(fltKey2+"latestTaxiOut  Fail :  " +latestTaxiOut+"   "+latestTaxiOut2+"  --------- "+fltKey);
		//test.log(LogStatus.FAIL,"latestTaxiOut  Fail :  " +latestTaxiOut+"   "+latestTaxiOut2+"  --------- "+fltKey);
		ATUReports.add("latestTaxiOut  Fail :  " +latestTaxiOut+"   "+latestTaxiOut2+"  --------- "+fltKey,  LogAs.FAILED, null);
	}
	
	
	
 		
	
	if(latestTaxiIn.equalsIgnoreCase(latestTaxiIn2))
	{
	
	}else{
		System.out.println(fltKey2+"latestTaxiIn  Fail :  " +latestTaxiIn+"   "+latestTaxiIn2+"  --------- "+fltKey);
		//test.log(LogStatus.FAIL,"latestTaxiIn  Fail :  " +latestTaxiIn+"   "+latestTaxiIn2+"  --------- "+fltKey);
		ATUReports.add("latestTaxiIn  Fail :  " +latestTaxiIn+"   "+latestTaxiIn2+"  --------- "+fltKey,  LogAs.FAILED, null);
	}
	
	
	
	
	if(depGMTAdjustment.contains(depGMTAdjustment2))
	{
	
	}else{
		System.out.println(fltKey2+"depGMTAdjustment  Fail :  " +depGMTAdjustment+"   "+depGMTAdjustment2+"  --------- "+fltKey);
		//test.log(LogStatus.FAIL,"depGMTAdjustment  Fail :  " +depGMTAdjustment+"   "+depGMTAdjustment2+"  --------- "+fltKey);
		ATUReports.add("depGMTAdjustment  Fail :  " +depGMTAdjustment+"   "+depGMTAdjustment2+"  --------- "+fltKey,  LogAs.FAILED, null);
	}
	
	
	if(arrGMTAdjustment.contains(arrGMTAdjustment2))
	{
	
	}else{
		System.out.println(fltKey2+"arrGMTAdjustment  Fail :  " +EqpType+"   "+arrGMTAdjustment2+"  --------- "+fltKey);
		//test.log(LogStatus.FAIL,"arrGMTAdjustment  Fail :  " +EqpType+"   "+arrGMTAdjustment2+"  --------- "+fltKey);
		ATUReports.add("arrGMTAdjustment  Fail :  " +EqpType+"   "+arrGMTAdjustment2+"  --------- "+fltKey,  LogAs.FAILED, null);
	}
	
	
	if(mogt.equalsIgnoreCase(mogt2))
	{
	
	}else{
		System.out.println(fltKey2+"mogt  Fail :  " +mogt+"   "+mogt2+"  --------- "+fltKey);
		//test.log(LogStatus.FAIL,"mogt  Fail :  " +mogt+"   "+mogt2+"  --------- "+fltKey);
		ATUReports.add("mogt  Fail :  " +mogt+"   "+mogt2+"  --------- "+fltKey,  LogAs.FAILED, null);
	}
	
	
	if(nextLegFltNum.contains(nextLegFltNum2))
	{
	
	}else{
		System.out.println(fltKey2+"nextLegFltNum  Fail :  " +nextLegFltNum+"   "+nextLegFltNum2+"  --------- "+fltKey);
		//test.log(LogStatus.FAIL,"nextLegFltNum  Fail :  " +nextLegFltNum+"   "+nextLegFltNum2+"  --------- "+fltKey);
		ATUReports.add("nextLegFltNum  Fail :  " +nextLegFltNum+"   "+nextLegFltNum2+"  --------- "+fltKey,LogAs.FAILED, null);
	}
	
	
	if(nextLegOrgDate.contains(nextLegOrgDate2))
	{
	
	}else{
		System.out.println(fltKey2+"nextLegOrgDate  Fail :  " +nextLegOrgDate+"   "+nextLegOrgDate2+"  --------- "+fltKey);
		//test.log(LogStatus.FAIL,"nextLegOrgDate  Fail :  " +nextLegOrgDate+"   "+nextLegOrgDate2+"  --------- "+fltKey);
		ATUReports.add("nextLegOrgDate  Fail :  " +nextLegOrgDate+"   "+nextLegOrgDate2+"  --------- "+fltKey,  LogAs.FAILED, null);
	}
	
	
	if(nextLegFltDupCode.contains(nextLegFltDupCode2))
	{
	
	}else{
		System.out.println(fltKey2+"nextLegFltDupCode  Fail :  " +nextLegFltDupCode+"   "+nextLegFltDupCode2+"  --------- "+fltKey);
		//test.log(LogStatus.FAIL,"nextLegFltDupCode  Fail :  " +nextLegFltDupCode+"   "+nextLegFltDupCode2+"  --------- "+fltKey);
		ATUReports.add("nextLegFltDupCode  Fail :  " +nextLegFltDupCode+"   "+nextLegFltDupCode2+"  --------- "+fltKey,  LogAs.FAILED, null);
	}
	
	
	if(nextLegCarrierCode .contains(nextLegCarrierCode2))
	{
	
	}else{
		System.out.println(fltKey2+"nextLegCarrierCode  Fail :  " +nextLegCarrierCode +"   "+nextLegCarrierCode2+"  --------- "+fltKey);
		//test.log(LogStatus.FAIL,"nextLegCarrierCode  Fail :  " +nextLegCarrierCode +"   "+nextLegCarrierCode2+"  --------- "+fltKey);
		ATUReports.add("nextLegCarrierCode  Fail :  " +nextLegCarrierCode +"   "+nextLegCarrierCode2+"  --------- "+fltKey,  LogAs.FAILED, null);
		
	}
	
	
	if(nextLegKey.contains(nextLegKey2))
	{
	
	}else{
		System.out.println(fltKey2+"nextLegKey  Fail :  " +nextLegKey+"   "+nextLegKey2+"  --------- "+fltKey);
		//test.log(LogStatus.FAIL, "nextLegKey  Fail :  " +nextLegKey+"   "+nextLegKey2+"  --------- "+fltKey);
		ATUReports.add( "nextLegKey  Fail :  " +nextLegKey+"   "+nextLegKey2+"  --------- "+fltKey,  LogAs.FAILED, null);
	}
	
	
	if(priorLegFltNum.contains(priorLegFltNum2))
	{
	
	}else{
		System.out.println(fltKey2+"priorLegFltNum  Fail :  " +priorLegFltNum+"   "+priorLegFltNum2+"  --------- "+fltKey);
		//test.log(LogStatus.FAIL,"priorLegFltNum  Fail :  " +priorLegFltNum+"   "+priorLegFltNum2+"  --------- "+fltKey);
		ATUReports.add("priorLegFltNum  Fail :  " +priorLegFltNum+"   "+priorLegFltNum2+"  --------- "+fltKey,  LogAs.FAILED, null);
	}
	
	
	if(priorLegOrgDate.contains(priorLegOrgDate2))
	{
	
	}else{
		System.out.println(fltKey2+"priorLegOrgDate  Fail :  " +priorLegOrgDate+"   "+priorLegOrgDate2+"  --------- "+fltKey);
	//	test.log(LogStatus.FAIL,"priorLegOrgDate  Fail :  " +priorLegOrgDate+"   "+priorLegOrgDate2+"  --------- "+fltKey);
		ATUReports.add("priorLegOrgDate  Fail :  " +priorLegOrgDate+"   "+priorLegOrgDate2+"  --------- "+fltKey,  LogAs.FAILED, null);
	}
	
	
	if(priorLegFltDupCode.contains(priorLegFltDupCode2))
	{
	
	}else{
		System.out.println(fltKey2+"priorLegFltDupCode  Fail :  " +priorLegFltDupCode2+"   "+priorLegFltDupCode2+"  --------- "+fltKey);
	//	test.log(LogStatus.FAIL,"priorLegFltDupCode  Fail :  " +priorLegFltDupCode2+"   "+priorLegFltDupCode2+"  --------- "+fltKey);
		ATUReports.add("priorLegFltDupCode  Fail :  " +priorLegFltDupCode2+"   "+priorLegFltDupCode2+"  --------- "+fltKey,  LogAs.FAILED, null);
	}
	
	
	if(priorLegDepStation.contains(priorLegDepStation2))
	{
	
	}else{
		System.out.println(fltKey2+"priorLegDepStation  Fail :  " +priorLegDepStation+"   "+priorLegDepStation2+"  --------- "+fltKey);
	//	test.log(LogStatus.FAIL, "priorLegDepStation  Fail :  " +priorLegDepStation+"   "+priorLegDepStation2+"  --------- "+fltKey);
		ATUReports.add("priorLegDepStation  Fail :  " +priorLegDepStation+"   "+priorLegDepStation2+"  --------- "+fltKey,  LogAs.FAILED, null);
	}
	
	
	if(priorLegCarrierCode.contains(priorLegCarrierCode2))
	{
	
	}else{
		System.out.println(fltKey2+"priorLegCarrierCode  Fail :  " +priorLegCarrierCode+"   "+priorLegCarrierCode2+"  --------- "+fltKey);
	//	test.log(LogStatus.FAIL, "priorLegCarrierCode  Fail :  " +priorLegCarrierCode+"   "+priorLegCarrierCode2+"  --------- "+fltKey);
		ATUReports.add("priorLegCarrierCode  Fail :  " +priorLegCarrierCode+"   "+priorLegCarrierCode2+"  --------- "+fltKey,  LogAs.FAILED, null);
	}
	
	
	
	
	
	if(legStatus.contains(legStatus2))
	{
	
	}else{
		System.out.println(fltKey2+"legStatus  Fail :  " +legStatus+"   "+legStatus2+"  --------- "+fltKey);
		//test.log(LogStatus.FAIL,"legStatus  Fail :  " +legStatus+"   "+legStatus2+"  --------- "+fltKey);
		ATUReports.add("legStatus  Fail :  " +legStatus+"   "+legStatus2+"  --------- "+fltKey,  LogAs.FAILED, null);
	}
	
	
	if(depStatus.contains(depStatus2))
	{
	
	}else{
		System.out.println(fltKey2+"depStatus  Fail :  " +depStatus+"   "+depStatus2+"  --------- "+fltKey);
		//test.log(LogStatus.FAIL,"depStatus  Fail :  " +depStatus+"   "+depStatus2+"  --------- "+fltKey);
		ATUReports.add("depStatus  Fail :  " +depStatus+"   "+depStatus2+"  --------- "+fltKey,  LogAs.FAILED, null);
	}
	
	
	if(arrStatus.contains(arrStatus2))
	{
	
	}else{
		System.out.println(fltKey2+"arrStatus Fail :  " +arrStatus+"   "+arrStatus2+"  --------- "+fltKey);
		//test.log(LogStatus.FAIL,"arrStatus Fail :  " +arrStatus+"   "+arrStatus2+"  --------- "+fltKey);
		ATUReports.add("arrStatus Fail :  " +arrStatus+"   "+arrStatus2+"  --------- "+fltKey,  LogAs.FAILED, null);
	}
	
	
	if(depGate.contains(depGate2))
	{
	
	}else{
		System.out.println(fltKey2+"depGate  Fail :  " +depGate+"   "+depGate2+"  --------- "+fltKey);
		//test.log(LogStatus.FAIL, "depGate  Fail :  " +depGate+"   "+depGate2+"  --------- "+fltKey);
		ATUReports.add("depGate  Fail :  " +depGate+"   "+depGate2+"  --------- "+fltKey,  LogAs.FAILED, null);
	}
	
	
	if(arrGate.contains(arrGate2))
	{
	
	}else{
		System.out.println(fltKey2+"arrGate  Fail :  " +arrGate+"   "+arrGate2+"  --------- "+fltKey);
		//test.log(LogStatus.FAIL,"arrGate  Fail :  " +arrGate+"   "+arrGate2+"  --------- "+fltKey);
		ATUReports.add("arrGate  Fail :  " +arrGate+"   "+arrGate2+"  --------- "+fltKey,  LogAs.FAILED, null);
	}
	
	if(bagclaim.contains(bagclaim2))
	{
	
	}else{
		System.out.println(fltKey2+"bagclaim  Fail :  " +bagclaim+"   "+bagclaim2+"  --------- "+fltKey);
		//test.log(LogStatus.FAIL,"bagclaim  Fail :  " +bagclaim+"   "+bagclaim2+"  --------- "+fltKey);
		ATUReports.add("bagclaim  Fail :  " +bagclaim+"   "+bagclaim2+"  --------- "+fltKey,  LogAs.FAILED, null);
	}

	
//	if(arrTerminal.contains(arrTerminal2))
//	{
//	
//	}else{
//		System.out.println("arrTerminal  Fail :  " +arrTerminal+"   "+arrTerminal2+"  --------- "+fltKey);
//		test.log(LogStatus.FAIL, "arrTerminal  Fail :  " +arrTerminal+"   "+arrTerminal2+"  --------- "+fltKey);
//	}
	
	if(intOrDom.contains(intOrDom2))
	{
	
	}else{
		System.out.println(fltKey2+"intOrDom  Fail :  " +intOrDom+"   "+intOrDom2+"  --------- "+fltKey);
		//test.log(LogStatus.FAIL, "intOrDom  Fail :  " +intOrDom+"   "+intOrDom2+"  --------- "+fltKey);
		ATUReports.add("intOrDom  Fail :  " +intOrDom+"   "+intOrDom2+"  --------- "+fltKey,  LogAs.FAILED, null);
	}
	
	
	
	
	if(kickOffFlt.contains(kickOffFlt2))
	{
	
	}else{
		System.out.println(fltKey2+"kickOffFlt  Fail :  " +kickOffFlt+"   "+kickOffFlt2+"  --------- "+fltKey);
		//test.log(LogStatus.FAIL,"kickOffFlt  Fail :  " +kickOffFlt+"   "+kickOffFlt2+"  --------- "+fltKey);
		ATUReports.add("kickOffFlt  Fail :  " +kickOffFlt+"   "+kickOffFlt2+"  --------- "+fltKey,  LogAs.FAILED, null);
	}
	


	if(getDepStatus.contains(getDepStatus2))
	{
	
	}else{
		System.out.println(fltKey2+"getDepStatus  Fail :  " +getDepStatus+"   "+getDepStatus2+"  --------- "+fltKey);
		//test.log(LogStatus.FAIL, "getDepStatus  Fail :  " +getDepStatus+"   "+getDepStatus2+"  --------- "+fltKey);
		ATUReports.add("getDepStatus  Fail :  " +getDepStatus+"   "+getDepStatus2+"  --------- "+fltKey,  LogAs.FAILED, null);
	}
	
	

	
	if(getArrStatus.contains(getArrStatus2))
	{
	
	}else{
		System.out.println(fltKey2+"getArrStatus  Fail :  " +getArrStatus+"   "+getArrStatus2+"  --------- "+fltKey);
		//test.log(LogStatus.FAIL,"getArrStatus  Fail :  " +getArrStatus+"   "+getArrStatus2+"  --------- "+fltKey);
		ATUReports.add("getArrStatus  Fail :  " +getArrStatus+"   "+getArrStatus2+"  --------- "+fltKey,  LogAs.FAILED, null);
	}
	
	
	if(wtRestricted.equalsIgnoreCase(wtRestricted2))
	{
	
	}else{
		System.out.println(fltKey2+"wtRestricted  Fail :  " +wtRestricted+"   "+wtRestricted2+"  --------- "+fltKey);
		//test.log(LogStatus.FAIL, "wtRestricted  Fail :  " +wtRestricted+"   "+wtRestricted2+"  --------- "+fltKey);
		ATUReports.add("wtRestricted  Fail :  " +wtRestricted+"   "+wtRestricted2+"  --------- "+fltKey,  LogAs.FAILED, null);
	}
	
	

	if(dispDesk.contains(dispDesk2))
	{
	
	}else{
		System.out.println(fltKey2+"dispDesk  Fail :  " +dispDesk+"   "+dispDesk2+"  --------- "+fltKey);
		//test.log(LogStatus.FAIL, "dispDesk  Fail :  " +dispDesk+"   "+dispDesk2+"  --------- "+fltKey);
		ATUReports.add("dispDesk  Fail :  " +dispDesk+"   "+dispDesk2+"  --------- "+fltKey,  LogAs.FAILED, null);
	}
	

	
	if(depGateChange.equalsIgnoreCase(depGateChange2))
	{
	
	}else{
		System.out.println(fltKey2+"depGateChange  Fail :  " +depGateChange+"   "+depGateChange2+"  --------- "+fltKey);
		//test.log(LogStatus.FAIL, "depGateChange  Fail :  " +depGateChange+"   "+depGateChange2+"  --------- "+fltKey);
		ATUReports.add("depGateChange  Fail :  " +depGateChange+"   "+depGateChange2+"  --------- "+fltKey,  LogAs.FAILED, null);
	}
	
	if(expectedTimeArrivalGMT.equalsIgnoreCase(expectedTimeArrivalGMT2))
	{
	
	}else{
		System.out.println(fltKey2+"expectedTimeArrivalGMT  Fail :  " +expectedTimeArrivalGMT+"   "+expectedTimeArrivalGMT2+"  --------- "+fltKey);
		//test.log(LogStatus.FAIL,"expectedTimeArrivalGMT  Fail :  " +expectedTimeArrivalGMT+"   "+expectedTimeArrivalGMT2+"  --------- "+fltKey);
		ATUReports.add("expectedTimeArrivalGMT  Fail :  " +expectedTimeArrivalGMT+"   "+expectedTimeArrivalGMT2+"  --------- "+fltKey,  LogAs.FAILED, null);
	}
	
	if(scheduledTimeArrivalGMT.equalsIgnoreCase(scheduledTimeArrivalGMT2))
	{
	
	}else{
		System.out.println(fltKey2+"scheduledTimeArrivalGMT  Fail :  " +scheduledTimeArrivalGMT+"   "+scheduledTimeArrivalGMT2+"  --------- "+fltKey);
		//test.log(LogStatus.FAIL,"scheduledTimeArrivalGMT  Fail :  " +scheduledTimeArrivalGMT+"   "+scheduledTimeArrivalGMT2+"  --------- "+fltKey);
		ATUReports.add("scheduledTimeArrivalGMT  Fail :  " +scheduledTimeArrivalGMT+"   "+scheduledTimeArrivalGMT2+"  --------- "+fltKey,  LogAs.FAILED, null);
	}
	

	
	if(expectedTimeDepartureGMT.equalsIgnoreCase(expectedTimeDepartureGMT2))
	{
	
	}else{
		System.out.println(fltKey2+"expectedTimeDepartureGMT  Fail :  " +expectedTimeDepartureGMT+"   "+expectedTimeDepartureGMT2+"  --------- "+fltKey);
	//	test.log(LogStatus.FAIL, "expectedTimeDepartureGMT  Fail :  " +expectedTimeDepartureGMT+"   "+expectedTimeDepartureGMT2+"  --------- "+fltKey);
		ATUReports.add("expectedTimeDepartureGMT  Fail :  " +expectedTimeDepartureGMT+"   "+expectedTimeDepartureGMT2+"  --------- "+fltKey,  LogAs.FAILED, null);
	}
	
	
	
	
	if(scheduledTimeDepartureGMT.equalsIgnoreCase(scheduledTimeDepartureGMT2))
	{
	
	}else{
		System.out.println(fltKey2+"scheduledTimeDepartureGMT  Fail :  " +scheduledTimeDepartureGMT+"   "+scheduledTimeDepartureGMT2+"  --------- "+fltKey);
		//test.log(LogStatus.FAIL,"scheduledTimeDepartureGMT  Fail :  " +scheduledTimeDepartureGMT+"   "+scheduledTimeDepartureGMT2+"  --------- "+fltKey);
		ATUReports.add("scheduledTimeDepartureGMT  Fail :  " +scheduledTimeDepartureGMT+"   "+scheduledTimeDepartureGMT2+"  --------- "+fltKey,  LogAs.FAILED, null);
	}
	
	
		if(expectedTimeArrivalLocal.equalsIgnoreCase(expectedTimeArrivalLocal2))
	{
	
	}else{
		System.out.println(fltKey2+"expectedTimeArrivalLocal  Fail :  " +expectedTimeArrivalLocal+"   "+expectedTimeArrivalLocal2+"  --------- "+fltKey);
		//test.log(LogStatus.FAIL, "expectedTimeArrivalLocal  Fail :  " +expectedTimeArrivalLocal+"   "+expectedTimeArrivalLocal2+"  --------- "+fltKey);
		ATUReports.add("expectedTimeArrivalLocal  Fail :  " +expectedTimeArrivalLocal+"   "+expectedTimeArrivalLocal2+"  --------- "+fltKey,  LogAs.FAILED, null);
	}
	
	
	if(scheduledTimeArrivalLocal.equalsIgnoreCase(scheduledTimeArrivalLocal2))
	{
	
	}else{
		System.out.println(fltKey2+"scheduledTimeArrivalLocal  Fail :  " +scheduledTimeArrivalLocal+"   "+scheduledTimeArrivalLocal2+"  --------- "+fltKey);
		//test.log(LogStatus.FAIL, "scheduledTimeArrivalLocal  Fail :  " +scheduledTimeArrivalLocal+"   "+scheduledTimeArrivalLocal2+"  --------- "+fltKey);
		ATUReports.add("scheduledTimeArrivalLocal  Fail :  " +scheduledTimeArrivalLocal+"   "+scheduledTimeArrivalLocal2+"  --------- "+fltKey,  LogAs.FAILED, null);
	}

	
	if(expectedTimeDepartureLocal.equalsIgnoreCase(expectedTimeDepartureLocal2))
	{
	
	}else{
		System.out.println(fltKey2+"expectedTimeDepartureLocal  Fail :  " +expectedTimeDepartureLocal+"   "+expectedTimeDepartureLocal2+"  --------- "+fltKey);
		//test.log(LogStatus.FAIL, "expectedTimeDepartureLocal  Fail :  " +expectedTimeDepartureLocal+"   "+expectedTimeDepartureLocal2+"  --------- "+fltKey);
		ATUReports.add("expectedTimeDepartureLocal  Fail :  " +expectedTimeDepartureLocal+"   "+expectedTimeDepartureLocal2+"  --------- "+fltKey,  LogAs.FAILED, null);
	}
	
	if(scheduledTimeDepartureLocal.equalsIgnoreCase(scheduledTimeDepartureLocal2))
	{
	
	}else{
		System.out.println(fltKey2+"scheduledTimeDepartureLocal  Fail :  " +scheduledTimeDepartureLocal+"   "+scheduledTimeDepartureLocal2+"  --------- "+fltKey);
		//test.log(LogStatus.FAIL,"scheduledTimeDepartureLocal  Fail :  " +scheduledTimeDepartureLocal+"   "+scheduledTimeDepartureLocal2+"  --------- "+fltKey);
		ATUReports.add("scheduledTimeDepartureLocal  Fail :  " +scheduledTimeDepartureLocal+"   "+scheduledTimeDepartureLocal2+"  --------- "+fltKey,  LogAs.FAILED, null);
	}


	if(actualOnGMT.equalsIgnoreCase(actualOnGMT2))
	{
	
	}else{
		System.out.println(fltKey2+"actualOnGMT  Fail :  " +actualOnGMT+"   "+actualOnGMT2+"  --------- "+fltKey);
		//test.log(LogStatus.FAIL,"actualOnGMT  Fail :  " +actualOnGMT+"   "+actualOnGMT2+"  --------- "+fltKey);
		ATUReports.add("actualOnGMT  Fail :  " +actualOnGMT+"   "+actualOnGMT2+"  --------- "+fltKey,  LogAs.FAILED, null);
	}

	if(actualOnLoc.equalsIgnoreCase(actualOnLoc2))
	{
	
	}else{
		System.out.println(fltKey2+"actualOnLoc  Fail :  " +actualOnLoc+"   "+actualOnLoc2+"  --------- "+fltKey);
		//test.log(LogStatus.FAIL, "actualOnLoc  Fail :  " +actualOnLoc+"   "+actualOnLoc2+"  --------- "+fltKey);
		ATUReports.add("actualOnLoc  Fail :  " +actualOnLoc+"   "+actualOnLoc2+"  --------- "+fltKey,  LogAs.FAILED, null);
	}

	if(actualInGMT.equalsIgnoreCase(actualInGMT2))
	{
	
	}else{
		System.out.println(fltKey2+"actualInGMT  Fail :  " +actualInGMT+"   "+actualInGMT2+"  --------- "+fltKey);
	//	test.log(LogStatus.FAIL,"actualInGMT  Fail :  " +actualInGMT+"   "+actualInGMT2+"  --------- "+fltKey);
		ATUReports.add("actualInGMT  Fail :  " +actualInGMT+"   "+actualInGMT2+"  --------- "+fltKey,  LogAs.FAILED, null);
	}

	if(actualInLoc.equalsIgnoreCase(actualInLoc2))
	{
	
	}else{
		System.out.println(fltKey2+"actualInLoc  Fail :  " +actualInLoc+"   "+actualInLoc2+"  --------- "+fltKey);
		//test.log(LogStatus.FAIL,"actualInLoc  Fail :  " +actualInLoc+"   "+actualInLoc2+"  --------- "+fltKey);
		ATUReports.add("actualInLoc  Fail :  " +actualInLoc+"   "+actualInLoc2+"  --------- "+fltKey,  LogAs.FAILED, null);
	}

	
	if(actualOutGMT.equalsIgnoreCase(actualOutGMT2))
	{
	
	}else{
		System.out.println(fltKey2+"actualOutGMT  Fail :  " +actualOutGMT+"   "+actualOutGMT2+"  --------- "+fltKey);
		//test.log(LogStatus.FAIL,"actualOutGMT  Fail :  " +actualOutGMT+"   "+actualOutGMT2+"  --------- "+fltKey);
		ATUReports.add("actualOutGMT  Fail :  " +actualOutGMT+"   "+actualOutGMT2+"  --------- "+fltKey,  LogAs.FAILED, null);
	}
	
	if(actualOutLoc.equalsIgnoreCase(actualOutLoc2))
	{
	
	}else{
		System.out.println(fltKey2+"actualOutLoc  Fail :  " +actualOutLoc+"   "+actualOutLoc2+"  --------- "+fltKey);
		//test.log(LogStatus.FAIL, "actualOutLoc  Fail :  " +actualOutLoc+"   "+actualOutLoc2+"  --------- "+fltKey);
		ATUReports.add("actualOutLoc  Fail :  " +actualOutLoc+"   "+actualOutLoc2+"  --------- "+fltKey,  LogAs.FAILED, null);
	}
	
	if(actualOffGMT.equalsIgnoreCase(actualOffGMT2))
	{
	
	}else{
		System.out.println(fltKey2+"actualOffGMT  Fail :  " +actualOffGMT+"   "+actualOffGMT2+"  --------- "+fltKey);
		//test.log(LogStatus.FAIL, "actualOffGMT  Fail :  " +actualOffGMT+"   "+actualOffGMT2+"  --------- "+fltKey);
		ATUReports.add("actualOffGMT  Fail :  " +actualOffGMT+"   "+actualOffGMT2+"  --------- "+fltKey,  LogAs.FAILED, null);
	}

	if(actualOffLoc.equalsIgnoreCase(actualOffLoc2))
	{
	
	}else{
		System.out.println(fltKey2+"actualOffLoc  Fail :  " +actualOffLoc+"   "+actualOffLoc2+"  --------- "+fltKey);
		//test.log(LogStatus.FAIL,"actualOffLoc  Fail :  " +actualOffLoc+"   "+actualOffLoc2+"  --------- "+fltKey);
		ATUReports.add("actualOffLoc  Fail :  " +actualOffLoc+"   "+actualOffLoc2+"  --------- "+fltKey,  LogAs.FAILED, null);
	}
	

	if(sourceTimeStamp.equalsIgnoreCase(sourceTimeStamp2))
	{
	
	}else{
		System.out.println(fltKey2+"sourceTimeStamp  Fail :  " +sourceTimeStamp+"   "+sourceTimeStamp2+"  --------- "+fltKey);
		//test.log(LogStatus.FAIL, "sourceTimeStamp  Fail :  " +sourceTimeStamp+"   "+sourceTimeStamp2+"  --------- "+fltKey);
		ATUReports.add("sourceTimeStamp  Fail :  " +sourceTimeStamp+"   "+sourceTimeStamp2+"  --------- "+fltKey,  LogAs.FAILED, null);
	}
	
	if(etdUpdatedAt.equalsIgnoreCase(etdUpdatedAt2))
	{
	
	}else{
		System.out.println(fltKey2+"etdUpdatedAt  Fail :  " +etdUpdatedAt+"   "+etdUpdatedAt2+"  --------- "+fltKey);
		//test.log(LogStatus.FAIL,"etdUpdatedAt  Fail :  " +etdUpdatedAt+"   "+etdUpdatedAt2+"  --------- "+fltKey);
		ATUReports.add("etdUpdatedAt  Fail :  " +etdUpdatedAt+"   "+etdUpdatedAt2+"  --------- "+fltKey,  LogAs.FAILED, null);
	}
	
		if(etaUpdatedAt.equalsIgnoreCase(etaUpdatedAt2))
	{
	
	}else{
		System.out.println(fltKey2+"etaUpdatedAt  Fail :  " +etaUpdatedAt+"   "+etaUpdatedAt2+"  --------- "+fltKey);
		//test.log(LogStatus.FAIL,"etaUpdatedAt  Fail :  " +etaUpdatedAt+"   "+etaUpdatedAt2+"  --------- "+fltKey);
		ATUReports.add("etaUpdatedAt  Fail :  " +etaUpdatedAt+"   "+etaUpdatedAt2+"  --------- "+fltKey,  LogAs.FAILED, null);
	}
	
		if(onUpdatedAt.equalsIgnoreCase(onUpdatedAt2))
	{
	
	}else{
		System.out.println(fltKey2+"onUpdatedAt  Fail :  " +onUpdatedAt+"   "+onUpdatedAt2+"  --------- "+fltKey);
		//test.log(LogStatus.FAIL,"onUpdatedAt  Fail :  " +onUpdatedAt+"   "+onUpdatedAt2+"  --------- "+fltKey);
		ATUReports.add("onUpdatedAt  Fail :  " +onUpdatedAt+"   "+onUpdatedAt2+"  --------- "+fltKey,  LogAs.FAILED, null);
	}

		if(eonUpdatedAt.equalsIgnoreCase(eonUpdatedAt2))
	{
	
	}else{
		System.out.println(fltKey2+"eonUpdatedAt  Fail :  " +eonUpdatedAt+"   "+eonUpdatedAt2+"  --------- "+fltKey);
	//	test.log(LogStatus.FAIL,"eonUpdatedAt  Fail :  " +eonUpdatedAt+"   "+eonUpdatedAt2+"  --------- "+fltKey);
		ATUReports.add("eonUpdatedAt  Fail :  " +eonUpdatedAt+"   "+eonUpdatedAt2+"  --------- "+fltKey,  LogAs.FAILED, null);
	}
	
		if(inUpdatedAt.equalsIgnoreCase(inUpdatedAt2))
	{
	
	}else{
		System.out.println(fltKey2+"inUpdatedAt  Fail :  " +inUpdatedAt+"   "+inUpdatedAt2+"  --------- "+fltKey);
	//	test.log(LogStatus.FAIL, "inUpdatedAt  Fail :  " +inUpdatedAt+"   "+inUpdatedAt2+"  --------- "+fltKey);
		ATUReports.add("inUpdatedAt  Fail :  " +inUpdatedAt+"   "+inUpdatedAt2+"  --------- "+fltKey,  LogAs.FAILED, null);
	}
	
	
		if(offUpdatedAt.equalsIgnoreCase(offUpdatedAt2))
	{
	
	}else{
		System.out.println(fltKey2+"offUpdatedAt  Fail :  " +offUpdatedAt+"   "+offUpdatedAt2+"  --------- "+fltKey);
		//test.log(LogStatus.FAIL, "offUpdatedAt  Fail :  " +offUpdatedAt+"   "+offUpdatedAt2+"  --------- "+fltKey);
		ATUReports.add("offUpdatedAt  Fail :  " +offUpdatedAt+"   "+offUpdatedAt2+"  --------- "+fltKey,  LogAs.FAILED, null);
	}
	
	
			if(etoUpdatedAt.equalsIgnoreCase(etoUpdatedAt2))
	{
	
	}else{
		System.out.println(fltKey2+"etoUpdatedAt  Fail :  " +etoUpdatedAt+"   "+etoUpdatedAt2+"  --------- "+fltKey);
		//test.log(LogStatus.FAIL,"etoUpdatedAt  Fail :  " +etoUpdatedAt+"   "+etoUpdatedAt2+"  --------- "+fltKey);
		ATUReports.add("etoUpdatedAt  Fail :  " +etoUpdatedAt+"   "+etoUpdatedAt2+"  --------- "+fltKey,  LogAs.FAILED, null);
	}
	

			if(outUpdatedAt.equalsIgnoreCase(outUpdatedAt2))
	{
	
	}else{
		System.out.println(fltKey2+"outUpdatedAt  Fail :  " +outUpdatedAt+"   "+outUpdatedAt2+"  --------- "+fltKey);
		//test.log(LogStatus.FAIL,"outUpdatedAt  Fail :  " +outUpdatedAt+"   "+outUpdatedAt2+"  --------- "+fltKey);
		ATUReports.add("outUpdatedAt  Fail :  " +outUpdatedAt+"   "+outUpdatedAt2+"  --------- "+fltKey,  LogAs.FAILED, null);
	}

		if(cancelUpdatedAt.equalsIgnoreCase(cancelUpdatedAt2))
	{
	
	}else{
		System.out.println(fltKey2+"cancelUpdatedAt  Fail :  " +cancelUpdatedAt+"   "+cancelUpdatedAt2+"  --------- "+fltKey);
	//	test.log(LogStatus.FAIL,"cancelUpdatedAt  Fail :  " +cancelUpdatedAt+"   "+cancelUpdatedAt2+"  --------- "+fltKey);
		ATUReports.add("cancelUpdatedAt  Fail :  " +cancelUpdatedAt+"   "+cancelUpdatedAt2+"  --------- "+fltKey,  LogAs.FAILED, null);
	}

		if(eqsubUpdatedAt.equalsIgnoreCase(eqsubUpdatedAt2))
	{
	
	}else{
		System.out.println(fltKey2+"eqsubUpdatedAt  Fail :  " +eqsubUpdatedAt+"   "+eqsubUpdatedAt2+"  --------- "+fltKey);
		//test.log(LogStatus.FAIL,"eqsubUpdatedAt  Fail :  " +eqsubUpdatedAt+"   "+eqsubUpdatedAt2+"  --------- "+fltKey);
		ATUReports.add("eqsubUpdatedAt  Fail :  " +eqsubUpdatedAt+"   "+eqsubUpdatedAt2+"  --------- "+fltKey,  LogAs.FAILED, null);
	}
		
	
		if(eqlinkUpdatedAt.equalsIgnoreCase(eqlinkUpdatedAt2))
	{
	
	}else{
		System.out.println(fltKey2+"eqlinkUpdatedAt  Fail :  " +eqlinkUpdatedAt+"   "+eqlinkUpdatedAt2+"  --------- "+fltKey);
		//test.log(LogStatus.FAIL, "eqlinkUpdatedAt  Fail :  " +eqlinkUpdatedAt+"   "+eqlinkUpdatedAt2+"  --------- "+fltKey);
		ATUReports.add("eqlinkUpdatedAt  Fail :  " +eqlinkUpdatedAt+"   "+eqlinkUpdatedAt2+"  --------- "+fltKey,  LogAs.FAILED, null);
	}
	
			if(groundTimeUpdatedAt.equalsIgnoreCase(groundTimeUpdatedAt2))
	{
	
	}else{
		System.out.println(fltKey2+"groundTimeUpdatedAt  Fail :  " +groundTimeUpdatedAt+"   "+groundTimeUpdatedAt2+"  --------- "+fltKey);
		//test.log(LogStatus.FAIL,"groundTimeUpdatedAt  Fail :  " +groundTimeUpdatedAt+"   "+groundTimeUpdatedAt2+"  --------- "+fltKey);
		ATUReports.add("groundTimeUpdatedAt  Fail :  " +groundTimeUpdatedAt+"   "+groundTimeUpdatedAt2+"  --------- "+fltKey,  LogAs.FAILED, null);
	}
	
	if(gateUpdatedAt.equalsIgnoreCase(gateUpdatedAt2))
	{
	
	}else{
		System.out.println(fltKey2+"gateUpdatedAt  Fail :  " +gateUpdatedAt+"   "+gateUpdatedAt2+"  --------- "+fltKey);
		//test.log(LogStatus.FAIL,"gateUpdatedAt  Fail :  " +gateUpdatedAt+"   "+gateUpdatedAt2+"  --------- "+fltKey);
		ATUReports.add("gateUpdatedAt  Fail :  " +gateUpdatedAt+"   "+gateUpdatedAt2+"  --------- "+fltKey,  LogAs.FAILED, null);
	}
	
	if(createUpdatedAt.equalsIgnoreCase(createUpdatedAt2))
	{
	
	
	}else{
		System.out.println(fltKey2+"createUpdatedAt  Fail :  " +createUpdatedAt+"   "+createUpdatedAt2+"    "+fltKey);
		//test.log(LogStatus.FAIL, "createUpdatedAt  Fail :  " +createUpdatedAt+"   "+createUpdatedAt2+"    "+fltKey);
		ATUReports.add("createUpdatedAt  Fail :  " +createUpdatedAt+"   "+createUpdatedAt2+"    "+fltKey,  LogAs.FAILED, null);
	}
	
		if(cycleUpdatedAt.equalsIgnoreCase(cycleUpdatedAt2))
	{
	
	}else{
		System.out.println(fltKey2+"cycleUpdatedAt  Fail :  " +cycleUpdatedAt+"   "+cycleUpdatedAt2+"  --------- "+fltKey);
		//test.log(LogStatus.FAIL,"cycleUpdatedAt  Fail :  " +cycleUpdatedAt+"   "+cycleUpdatedAt2+"  --------- "+fltKey);
		ATUReports.add("cycleUpdatedAt  Fail :  " +cycleUpdatedAt+"   "+cycleUpdatedAt2+"  --------- "+fltKey,  LogAs.FAILED, null);
	}   			
	if(deleteUpdatedAt.equalsIgnoreCase(deleteUpdatedAt2))
	{
	
	}else{
		System.out.println(fltKey2+"deleteUpdatedAt  Fail :  " +deleteUpdatedAt+"   "+deleteUpdatedAt2+"  --------- "+fltKey);
		//test.log(LogStatus.FAIL,"deleteUpdatedAt  Fail :  " +deleteUpdatedAt+"   "+deleteUpdatedAt2+"  --------- "+fltKey);
		ATUReports.add("deleteUpdatedAt  Fail :  " +deleteUpdatedAt+"   "+deleteUpdatedAt2+"  --------- "+fltKey,  LogAs.FAILED, null);
	}
	

	if(continuationUpdatedAt.equalsIgnoreCase(continuationUpdatedAt2))
	{
	
	}else{
		System.out.println(fltKey2+"continuationUpdatedAt  Fail :  " +continuationUpdatedAt+"   "+continuationUpdatedAt2+"  --------- "+fltKey);
		//test.log(LogStatus.FAIL, "continuationUpdatedAt  Fail :  " +continuationUpdatedAt+"   "+continuationUpdatedAt2+"  --------- "+fltKey);
		ATUReports.add("continuationUpdatedAt  Fail :  " +continuationUpdatedAt+"   "+continuationUpdatedAt2+"  --------- "+fltKey,  LogAs.FAILED, null);
	}
	

	if(reinstateUpdatedAt.equalsIgnoreCase(reinstateUpdatedAt2))
	{
	
	}else{
		System.out.println(fltKey2+"reinstateUpdatedAt  Fail :  " +reinstateUpdatedAt+"   "+reinstateUpdatedAt2+"  --------- "+fltKey);
		//test.log(LogStatus.FAIL,"reinstateUpdatedAt  Fail :  " +reinstateUpdatedAt+"   "+reinstateUpdatedAt2+"  --------- "+fltKey);
		ATUReports.add("reinstateUpdatedAt  Fail :  " +reinstateUpdatedAt+"   "+reinstateUpdatedAt2+"  --------- "+fltKey,  LogAs.FAILED, null);
	}
	if(diversionUpdatedAt.equalsIgnoreCase(diversionUpdatedAt2))
	{
	
	}else{
		System.out.println(fltKey2+"diversionUpdatedAt  Fail :  " +diversionUpdatedAt+"   "+diversionUpdatedAt2+"  --------- "+fltKey);
		//test.log(LogStatus.FAIL,"diversionUpdatedAt  Fail :  " +diversionUpdatedAt+"   "+diversionUpdatedAt2+"  --------- "+fltKey);
		ATUReports.add("diversionUpdatedAt  Fail :  " +diversionUpdatedAt+"   "+diversionUpdatedAt2+"  --------- "+fltKey,  LogAs.FAILED, null);
	}
	if(returnUpdatedAt.equalsIgnoreCase(returnUpdatedAt2))
	{
	
	}else{
		System.out.println(fltKey2+"returnUpdatedAt  Fail :  " +returnUpdatedAt+"   "+returnUpdatedAt2+"  --------- "+fltKey);
		//test.log(LogStatus.FAIL,"returnUpdatedAt  Fail :  " +returnUpdatedAt+"   "+returnUpdatedAt2+"  --------- "+fltKey);
		ATUReports.add("returnUpdatedAt  Fail :  " +returnUpdatedAt+"   "+returnUpdatedAt2+"  --------- "+fltKey,  LogAs.FAILED, null);
	}
	if(decisionUpdatedAt.equalsIgnoreCase(decisionUpdatedAt2))
	{
	
	}else{
		System.out.println(fltKey2+"decisionUpdatedAt  Fail :  " +decisionUpdatedAt+"   "+decisionUpdatedAt2+"  --------- "+fltKey);
		//test.log(LogStatus.FAIL,"decisionUpdatedAt  Fail :  " +decisionUpdatedAt+"   "+decisionUpdatedAt2+"  --------- "+fltKey);
		ATUReports.add("decisionUpdatedAt  Fail :  " +decisionUpdatedAt+"   "+decisionUpdatedAt2+"  --------- "+fltKey,  LogAs.FAILED, null);
	}
	
	if(rtdUpdatedAt.equalsIgnoreCase(rtdUpdatedAt2))
	{
	
	}else{
		System.out.println(fltKey2+"rtdUpdatedAt  Fail :  " +rtdUpdatedAt+"   "+rtdUpdatedAt2+"  --------- "+fltKey);
		//test.log(LogStatus.FAIL,"rtdUpdatedAt  Fail :  " +rtdUpdatedAt+"   "+rtdUpdatedAt2+"  --------- "+fltKey);
		ATUReports.add("rtdUpdatedAt  Fail :  " +rtdUpdatedAt+"   "+rtdUpdatedAt2+"  --------- "+fltKey,  LogAs.FAILED, null);
	}
	
	if(crewUpdatedAt.equalsIgnoreCase(crewUpdatedAt2))
	{
	
	}else{
		System.out.println(fltKey2+"crewUpdatedAt  Fail :  " +crewUpdatedAt+"   "+EqpType+"  --------- "+fltKey);
	//	test.log(LogStatus.FAIL, "crewUpdatedAt  Fail :  " +crewUpdatedAt+"   "+EqpType+"  --------- "+fltKey);
		ATUReports.add("crewUpdatedAt  Fail :  " +crewUpdatedAt+"   "+EqpType+"  --------- "+fltKey,  LogAs.FAILED, null);
	}

		if(fuelSlipUpdatedAt.equalsIgnoreCase(fuelSlipUpdatedAt2))
	{
	
	}else{
		System.out.println(fltKey2+"fuelSlipUpdatedAt  Fail :  " +fuelSlipUpdatedAt+"   "+fuelSlipUpdatedAt2+"  --------- "+fltKey );
		//test.log(LogStatus.FAIL, "fuelSlipUpdatedAt  Fail :  " +fuelSlipUpdatedAt+"   "+fuelSlipUpdatedAt2+"  --------- "+fltKey);
		ATUReports.add("fuelSlipUpdatedAt  Fail :  " +fuelSlipUpdatedAt+"   "+fuelSlipUpdatedAt2+"  --------- "+fltKey,  LogAs.FAILED, null);
	}
	
	
	
	
	
	}catch (Exception EE)
	{
		System.out.println("Exception " );
	//	test.log(LogStatus.FAIL, "Exception ");
		ATUReports.add( "Exception ",  LogAs.FAILED, null);
//		test.log(LogStatus.INFO, Intermediateobject2);
//		test.log(LogStatus.INFO, Intermediateobject22);
	}
	
	}
	catch (Exception EE)
	{
	
		System.out.println("Exception in fetching element. Compare response manually ");
		System.out.println("Response1 :: "+full);
		//System.out.println("Response2:: "+Intermediateobject22);
		//test.log(LogStatus.FAIL, "Exception in fetching element. Compare response manually "+full);
		ATUReports.add( "Exception ",  LogAs.FAILED, null);
	//	test.log(LogStatus.INFO, Intermediateobject2);
	//	test.log(LogStatus.INFO, Intermediateobject22);
		
		
	}

	



}catch (Exception EE)
{
	System.out.println("No Flight No " );
	//test.log(LogStatus.FAIL, "Exception in fetching element. Compare response manually "+full);
	ATUReports.add( "Exception ",  LogAs.FAILED, null);
//	test.log(LogStatus.INFO, Intermediateobject2);
//	test.log(LogStatus.INFO, Intermediateobject22);
}
 


}


//*********_____Before and after restart************************************************************

public static String Getvalueinresponsebeforeandafter(String Jsonobject,String valueofelement,int number) throws Exception{
	  JSONArray jsonObj1 = new JSONArray(Jsonobject);
	  JSONObject Testprint = jsonObj1.getJSONObject(number);
	
	  try{
		  String EqpType =  	Testprint.getJSONObject("flight").getString(valueofelement);
		  return EqpType;
		  			 
	  }catch(Exception Notastring)
	  {
		  try{
			  Long EqpType =  	Testprint.getJSONObject("flight").getLong(valueofelement); 
			  String EQtype = EqpType.toString();
			  return EQtype;
		  }catch(Exception Notalong)
		  {
			  try{
				  boolean EqpType =  	Testprint.getJSONObject("flight").getBoolean(valueofelement); 
				  String EQtype = String.valueOf(EqpType);
				  return EQtype;
			  }catch(Exception Notany)
			  {
				  return "Null"; 
			  }
			  
		  }
		  
	  }
	
	  
	  
  	
	  
	  
	  
}


public static void NotepadtoexcelFlightdetailsbefandafter(String path,String path2,String station) throws Exception{
	
long mil =System.currentTimeMillis();
String st, full,append,le,extend, extended,st2, full2;
full="";
full2="";
extended="";

	
BufferedReader br = new BufferedReader(new FileReader(path));
while ((st=br.readLine())!=null) {
    full+=st;
	  }


BufferedReader br2 = new BufferedReader(new FileReader(path2));
while ((st2=br2.readLine())!=null) {
    full2+=st2;
	  }

JSONArray jsonObj1 = new JSONArray(full);
JSONArray jsonObj2 = new JSONArray(full2);

	
	

XSSFWorkbook workbook = new XSSFWorkbook();
XSSFSheet sheet = workbook.createSheet("FlightgiventimeFlightDetails");
 for (int i=0;i<jsonObj1.length();i++)
 {
	   JSONObject Testprint1 = jsonObj1.getJSONObject(i);
 		String obj1 =    jsonObj1.getJSONObject(i).toString();
	String Intermediateobject2 =obj1;
	String fltkey =  	Getvalueinresponsebeforeandafter(full,"fltKey",i);
	String priorfltkey = Getvalueinresponsebeforeandafter(full,"priorLegKey",i);
	System.out.println("Validating flight no::  "+i);
	   
	   for (int j=0;j<=jsonObj2.length()-1;j++)
	   {
		   JSONObject Testprint2 = jsonObj2.getJSONObject(j);
	     	String obj2 =    jsonObj2.getJSONObject(j).toString();
		String Intermediateobject22 = obj2; 
		String fltkey2 =  	Getvalueinresponsebeforeandafter(full2,"fltKey",j);
		String priorfltkey2 = Getvalueinresponsebeforeandafter(full2,"priorLegKey",j);   
	   
		boolean fltkeyempty = fltkey.contains("Null");
		boolean priorfltkeyempty = fltkey.contains("Null");
	   if(fltkeyempty==false)
	   {
		   if(fltkey.contains(fltkey2)){
			   Fetchandcomparebeforeandafterserever(full,full2,i,j,fltkey,fltkey2);
		   if(j==jsonObj2.length()-1){
			   
			   ATUReports.add("Reached end of searching fltkey and no key found  "+fltkey,  LogAs.INFO, null);
		   }
		   break;
		   }
		   
	   }    	   
	   else
	   {
		   if(priorfltkeyempty==false)
		   {
			   if(priorfltkey.contains(priorfltkey2)){
				   Fetchandcomparebeforeandafterserever(full,full2,i,j,fltkey,fltkey2);
		   if(j==jsonObj2.length()-1){
			   ATUReports.add("Reached end of searching priorlegkey and no key found  "+priorfltkey,  LogAs.INFO, null);
		   }
		   break;
			   }
		   }
	   
	   }	
	   
	   }

   }

}


public static void Fetchandcomparebeforeandafterserever(String full, String full2, int i, int j, String fltKey, String fltKey2) throws Exception{


try
	{
	try{
		String EqpType =  	Getvalueinresponse(full,"assignedEquipType",i);
		String EqpType2 =  	Getvalueinresponse(full2,"assignedEquipType",j);

		
		String fltNum =  	Getvalueinresponse(full,"fltNum",i);
		String fltNum2 =  	Getvalueinresponse(full2,"fltNum",j);


		String fltOrgDate =  	Getvalueinresponse(full,"fltOrgDate",i);
		String fltOrgDate2 =  	Getvalueinresponse(full2,"fltOrgDate",j);

		String depSta =  	Getvalueinresponse(full,"depSta",i);
		String depSta2 =  	Getvalueinresponse(full2,"depSta",j);

		String dupDepStaNum =  	Getvalueinresponse(full,"dupDepStaNum",i);
	//	System.out.println("dupDepStaNum::  "+dupDepStaNum);
		String dupDepStaNum2 =  Getvalueinresponse(full2,"dupDepStaNum",j);
		//System.out.println("dupDepStaNum::  "+dupDepStaNum);

		String carrierCode =  	Getvalueinresponse(full,"carrierCode",i);
		String carrierCode2 =  	Getvalueinresponse(full2,"carrierCode",j);
		
		String iata =  	Getvalueinresponse(full,"iata",i);
		String iata2 =  	Getvalueinresponse(full2,"iata",j);

		String destination =  	Getvalueinresponse(full,"destination",i);
		String destination2 =  	Getvalueinresponse(full2,"destination",j);
		
		String dupArrStaNum =  	Getvalueinresponse(full,"dupArrStaNum",i);
		String dupArrStaNum2 =  	Getvalueinresponse(full2,"dupArrStaNum",j);

		String assignedTail =  	Getvalueinresponse(full,"assignedTail",i);
		String assignedTail2 =  	Getvalueinresponse(full2,"assignedTail",j);

		String skdEquipType =  	Getvalueinresponse(full,"skdEquipType",i);
		String skdEquipType2 =  	Getvalueinresponse(full2,"skdEquipType",j);

		String assignedEquipType =  	Getvalueinresponse(full,"assignedEquipType",i);
		String assignedEquipType2 =  	Getvalueinresponse(full2,"assignedEquipType",j);

		String aircraftRegistrationNbr =  	Getvalueinresponse(full,"aircraftRegistrationNbr",i);
		String aircraftRegistrationNbr2 =  	Getvalueinresponse(full2,"aircraftRegistrationNbr",j);

		String skdTaxiOut =  	Getvalueinresponse(full,"skdTaxiOut",i);
		String skdTaxiOut2 =  	Getvalueinresponse(full2,"skdTaxiOut",j);

		String skdTaxiIn =  	Getvalueinresponse(full,"skdTaxiIn",i);
		String skdTaxiIn2 =  	Getvalueinresponse(full2,"skdTaxiIn",j);

		String latestTaxiOut =  	Getvalueinresponse(full,"latestTaxiOut",i);
		String latestTaxiOut2 =  	Getvalueinresponse(full2,"latestTaxiOut",j);

		String latestTaxiIn =  	Getvalueinresponse(full,"latestTaxiIn",i);
		String latestTaxiIn2 =  	Getvalueinresponse(full2,"latestTaxiIn",j);

		String depGMTAdjustment =  	Getvalueinresponse(full,"depGMTAdjustment",i);
		String depGMTAdjustment2 =  	Getvalueinresponse(full2,"depGMTAdjustment",j);

		String arrGMTAdjustment =  	Getvalueinresponse(full,"arrGMTAdjustment",i);
		String arrGMTAdjustment2 =  	Getvalueinresponse(full2,"arrGMTAdjustment",j);

		String mogt =  	Getvalueinresponse(full,"mogt",i);
		String mogt2 =  	Getvalueinresponse(full2,"mogt",j);

		String nextLegFltNum =  	Getvalueinresponse(full,"nextLegFltNum",i);
		String nextLegFltNum2 =  	Getvalueinresponse(full2,"nextLegFltNum",j);

		String nextLegOrgDate =  	Getvalueinresponse(full,"nextLegOrgDate",i);
		String nextLegOrgDate2 =  	Getvalueinresponse(full2,"nextLegOrgDate",j);

		String nextLegFltDupCode =  	Getvalueinresponse(full,"nextLegFltDupCode",i);
		String nextLegFltDupCode2 =  	Getvalueinresponse(full2,"nextLegFltDupCode",j);

		String nextLegCarrierCode =  	Getvalueinresponse(full,"nextLegCarrierCode",i);
		String nextLegCarrierCode2 =  	Getvalueinresponse(full2,"nextLegCarrierCode",j);

		String nextLegKey =  	Getvalueinresponse(full,"nextLegKey",i);
		String nextLegKey2 =  	Getvalueinresponse(full2,"nextLegKey",j);

		String priorLegFltNum =  	Getvalueinresponse(full,"priorLegFltNum",i);
		String priorLegFltNum2 =  	Getvalueinresponse(full2,"priorLegFltNum",j);

		String priorLegOrgDate =  	Getvalueinresponse(full,"priorLegOrgDate",i);
		String priorLegOrgDate2 =  	Getvalueinresponse(full2,"priorLegOrgDate",j);

		String priorLegFltDupCode =  	Getvalueinresponse(full,"priorLegFltDupCode",i);
		String priorLegFltDupCode2 =  	Getvalueinresponse(full2,"priorLegFltDupCode",j);

		String priorLegDepStation =  	Getvalueinresponse(full,"priorLegDepStation",i);
		String priorLegDepStation2 =  	Getvalueinresponse(full2,"priorLegDepStation",j);
		
		String priorLegCarrierCode =  	Getvalueinresponse(full,"priorLegCarrierCode",i);
		String priorLegCarrierCode2 =  	Getvalueinresponse(full2,"priorLegCarrierCode",j);

		
		String legStatus =  	Getvalueinresponse(full,"legStatus",i);
		String legStatus2 =  	Getvalueinresponse(full2,"legStatus",j);

		String depStatus =  	Getvalueinresponse(full,"depStatus",i);
		String depStatus2 =  	Getvalueinresponse(full2,"depStatus",j);

		String arrStatus =  	Getvalueinresponse(full,"arrStatus",i);
		String arrStatus2 =  	Getvalueinresponse(full2,"arrStatus",j);

		String depGate =  	Getvalueinresponse(full,"depGate",i);
		String depGate2 =  	Getvalueinresponse(full2,"depGate",j);

		String arrGate =  	Getvalueinresponse(full,"arrGate",i);
		String arrGate2 =  	Getvalueinresponse(full2,"arrGate",j);
		
		String bagclaim =  	Getvalueinresponse(full,"bagclaim",i);
		String bagclaim2 =  	Getvalueinresponse(full2,"bagclaim",j);
	
	//	String arrTerminal =  	Getvalueinresponse(full,"assignedEquipType");
	//	String arrTerminal2 =  	Getvalueinresponse(full2,"assignedEquipType");
		
		String intOrDom =  	Getvalueinresponse(full,"intOrDom",i);
		String intOrDom2 =  	Getvalueinresponse(full2,"intOrDom",j);

		String kickOffFlt =  	Getvalueinresponse(full,"kickOffFlt",i);
		String kickOffFlt2 =  	Getvalueinresponse(full2,"kickOffFlt",j);
		
	//	String depTerminal =  	Testprint1.getString("depTerminal");
	//	String depTerminal2 =  	Getvalueinresponse(full2,"assignedEquipType");String("depTerminal");

	////////////////////////////////////////////////////////////////////////////////////////////////////////////

		String isThruFlight =  	Getvalueinresponse(full,"isThruFlight",i);
		String isThruFlight2 =  	Getvalueinresponse(full2,"isThruFlight",j);

		String getDepStatus =  	Getvalueinresponse(full,"getDepStatus",i);
		String getDepStatus2 =  	Getvalueinresponse(full2,"getDepStatus",j);

		String getArrStatus =  	Getvalueinresponse(full,"getArrStatus",i);
		String getArrStatus2 =  	Getvalueinresponse(full2,"getArrStatus",j);

		String wtRestricted =  	Getvalueinresponse(full,"wtRestricted",i);
		String wtRestricted2 =  	Getvalueinresponse(full2,"wtRestricted",j);
		
		String dispDesk =  	Getvalueinresponse(full,"dispDesk",i);
		String dispDesk2 =  	Getvalueinresponse(full2,"dispDesk",j);
		
	

		String depGateChange =  	Getvalueinresponse(full,"depGateChange",i);
		String depGateChange2 =  	Getvalueinresponse(full2,"depGateChange",j);

		String expectedTimeArrivalGMT =  	Getvalueinresponse(full,"expectedTimeArrivalGMT",i);
		String expectedTimeArrivalGMT2 =  	Getvalueinresponse(full2,"expectedTimeArrivalGMT",j);

		String scheduledTimeArrivalGMT =  	Getvalueinresponse(full,"scheduledTimeArrivalGMT",i);
		String scheduledTimeArrivalGMT2 =  	Getvalueinresponse(full2,"scheduledTimeArrivalGMT",j);

		String expectedTimeDepartureGMT =  	Getvalueinresponse(full,"expectedTimeDepartureGMT",i);
		String expectedTimeDepartureGMT2 =  	Getvalueinresponse(full2,"expectedTimeDepartureGMT",j);

		String scheduledTimeDepartureGMT =  	Getvalueinresponse(full,"scheduledTimeDepartureGMT",i);
		String scheduledTimeDepartureGMT2 =  	Getvalueinresponse(full2,"scheduledTimeDepartureGMT",j);

		String expectedTimeArrivalLocal =  	Getvalueinresponse(full,"expectedTimeArrivalLocal",i);
		String expectedTimeArrivalLocal2 =  	Getvalueinresponse(full2,"expectedTimeArrivalLocal",j);

		String scheduledTimeArrivalLocal =  	Getvalueinresponse(full,"scheduledTimeArrivalLocal",i);
		String scheduledTimeArrivalLocal2 =  	Getvalueinresponse(full2,"scheduledTimeArrivalLocal",j);

		String expectedTimeDepartureLocal =  	Getvalueinresponse(full,"expectedTimeDepartureLocal",i);
		String expectedTimeDepartureLocal2 =  	Getvalueinresponse(full2,"expectedTimeDepartureLocal",j);

		String scheduledTimeDepartureLocal =  	Getvalueinresponse(full,"scheduledTimeDepartureLocal",i);
		String scheduledTimeDepartureLocal2 =  	Getvalueinresponse(full2,"scheduledTimeDepartureLocal",j);
		
		
		String actualOnGMT =  	Getvalueinresponse(full,"actualOnGMT",i);
		String actualOnGMT2 =  	Getvalueinresponse(full2,"actualOnGMT",j);
		
	
		
		String actualOnLoc =  	Getvalueinresponse(full,"actualOnLoc",i);
		String actualOnLoc2 =  	Getvalueinresponse(full2,"actualOnLoc",j);
		
		
		String actualInGMT =  	Getvalueinresponse(full,"actualInGMT",i);
		String actualInGMT2 =  	Getvalueinresponse(full2,"actualInGMT",j);
		
	
		String actualInLoc =  	Getvalueinresponse(full,"actualInLoc",i);
		String actualInLoc2 =  	Getvalueinresponse(full2,"actualInLoc",j);
		
	
		String actualOutGMT =  	Getvalueinresponse(full,"actualOutGMT",i);
		String actualOutGMT2 =  	Getvalueinresponse(full2,"actualOutGMT",j);
		
		
		String actualOutLoc =  	Getvalueinresponse(full,"actualOutLoc",i);
		String actualOutLoc2 =  	Getvalueinresponse(full2,"actualOutLoc",j);
		
		
		String actualOffGMT =  	Getvalueinresponse(full,"actualOffGMT",i);
		String actualOffGMT2 =  	Getvalueinresponse(full2,"actualOffGMT",j);
		
		String actualOffLoc =  	Getvalueinresponse(full,"actualOffLoc",i);
		String actualOffLoc2 =  	Getvalueinresponse(full2,"actualOffLoc",j);

		

		String sourceTimeStamp =  	Getvalueinresponse(full,"sourceTimeStamp",i);
		String sourceTimeStamp2 =  	Getvalueinresponse(full2,"sourceTimeStamp",j);

		String etdUpdatedAt =  	Getvalueinresponse(full,"etdUpdatedAt",i);
		String etdUpdatedAt2 =  	Getvalueinresponse(full2,"etdUpdatedAt",j);

		String etaUpdatedAt =  	Getvalueinresponse(full,"etaUpdatedAt",i);
		String etaUpdatedAt2 =  	Getvalueinresponse(full2,"etaUpdatedAt",j);

		
		String onUpdatedAt =  	Getvalueinresponse(full,"onUpdatedAt",i);
			String onUpdatedAt2 =  	Getvalueinresponse(full2,"onUpdatedAt",j);

	
			String eonUpdatedAt =  	Getvalueinresponse(full,"eonUpdatedAt",i);
			String eonUpdatedAt2 =  	Getvalueinresponse(full2,"eonUpdatedAt",j);
		
		
		String inUpdatedAt =  	Getvalueinresponse(full,"inUpdatedAt",i);
			String inUpdatedAt2 =  	Getvalueinresponse(full2,"inUpdatedAt",j);
		
		
		
		String offUpdatedAt =  	Getvalueinresponse(full,"offUpdatedAt",i);
			String offUpdatedAt2 =  	Getvalueinresponse(full2,"offUpdatedAt",j);
		
		
		
			String etoUpdatedAt =  	Getvalueinresponse(full,"etoUpdatedAt",i);
			String etoUpdatedAt2 =  	Getvalueinresponse(full2,"etoUpdatedAt",j);
		
		
	
			String outUpdatedAt =  	Getvalueinresponse(full,"outUpdatedAt",i);
			String outUpdatedAt2 =  	Getvalueinresponse(full2,"outUpdatedAt",j);
		

			String cancelUpdatedAt =  	Getvalueinresponse(full,"cancelUpdatedAt",i);
			String cancelUpdatedAt2 =  	Getvalueinresponse(full2,"cancelUpdatedAt",j);
		

			String eqsubUpdatedAt =  	Getvalueinresponse(full,"eqsubUpdatedAt",i);
			String eqsubUpdatedAt2 =  	Getvalueinresponse(full2,"eqsubUpdatedAt",j);
		
		
			String eqlinkUpdatedAt =  	Getvalueinresponse(full,"eqlinkUpdatedAt",i);
			String eqlinkUpdatedAt2 =  	Getvalueinresponse(full2,"eqlinkUpdatedAt",j);
		
		
			String groundTimeUpdatedAt =  	Getvalueinresponse(full,"groundTimeUpdatedAt",i);
			String groundTimeUpdatedAt2 =  	Getvalueinresponse(full2,"groundTimeUpdatedAt",j);
		
		
			String gateUpdatedAt =  	Getvalueinresponse(full,"gateUpdatedAt",i);
		String gateUpdatedAt2 =  	Getvalueinresponse(full2,"gateUpdatedAt",j);
		
		String createUpdatedAt =  	Getvalueinresponse(full,"createUpdatedAt",i);
		String createUpdatedAt2 =  	Getvalueinresponse(full2,"createUpdatedAt",j);
		
		
		String cycleUpdatedAt =  	Getvalueinresponse(full,"cycleUpdatedAt",i);
		String cycleUpdatedAt2 =  	Getvalueinresponse(full2,"cycleUpdatedAt",j);
		    			
		String deleteUpdatedAt =  	Getvalueinresponse(full,"deleteUpdatedAt",i);
		String deleteUpdatedAt2 =  	Getvalueinresponse(full2,"deleteUpdatedAt",j);
		
	
		String continuationUpdatedAt =  	Getvalueinresponse(full,"continuationUpdatedAt",i);
		String continuationUpdatedAt2	 =  	Getvalueinresponse(full2,"continuationUpdatedAt",j);
		
		
	
		String reinstateUpdatedAt =  	Getvalueinresponse(full,"reinstateUpdatedAt",i);
		String reinstateUpdatedAt2 =  	Getvalueinresponse(full2,"reinstateUpdatedAt",j);
	
		String diversionUpdatedAt =  	Getvalueinresponse(full,"diversionUpdatedAt",i);
		String diversionUpdatedAt2 =  	Getvalueinresponse(full2,"diversionUpdatedAt",j);
	
		String returnUpdatedAt =  	Getvalueinresponse(full,"returnUpdatedAt",i);
		String returnUpdatedAt2 =  	Getvalueinresponse(full2,"returnUpdatedAt",j);
	
		String decisionUpdatedAt =  	Getvalueinresponse(full,"returnUpdatedAt",i);
		String decisionUpdatedAt2 =  	Getvalueinresponse(full2,"returnUpdatedAt",j);

		
		String rtdUpdatedAt =  	Getvalueinresponse(full,"rtdUpdatedAt",i);
		String rtdUpdatedAt2 =  	Getvalueinresponse(full2,"rtdUpdatedAt",j);
		
		
		String crewUpdatedAt =  	Getvalueinresponse(full,"crewUpdatedAt",i);
		String crewUpdatedAt2 =  	Getvalueinresponse(full2,"crewUpdatedAt",j);
		
	
		String fuelSlipUpdatedAt =  	Getvalueinresponse(full,"fuelSlipUpdatedAt",i);
		String fuelSlipUpdatedAt2 =  	Getvalueinresponse(full2,"fuelSlipUpdatedAt",j);
		
		

		
	try{
		
	if(EqpType.contains(EqpType2))
	{
	
	}else{
		System.out.println(fltKey2+"EqpType Fail :  " +EqpType+"   "+EqpType2+"  --------- "+fltKey);
		//test.log(LogStatus.FAIL, "EqpType   Fail :  " +EqpType+"   "+EqpType2+"  --------- "+fltKey);
		ATUReports.add("EqpType   Fail :  " +EqpType+"   "+EqpType2+"  --------- "+fltKey,  LogAs.FAILED, null);
	}
	
	
	

	
	
	if(fltNum.contains(fltNum2))
	{
	
	}else{
		System.out.println(fltKey2+"fltNum  Fail :  " +fltNum+"   "+fltNum2+"  --------- "+fltKey);
	//	test.log(LogStatus.FAIL,"fltNum  Fail :  " +fltNum+"   "+fltNum2+"  --------- "+fltKey);
		ATUReports.add("fltNum  Fail :  " +fltNum+"   "+fltNum2+"  --------- "+fltKey,  LogAs.FAILED, null);
	}
	
	
	if(fltOrgDate.contains(fltOrgDate2))
	{
	
	}else{
		System.out.println(fltKey2+"fltOrgDate  Fail :  " +fltOrgDate+"   "+fltOrgDate2+"  --------- "+fltKey);
		//test.log(LogStatus.FAIL,"fltOrgDate  Fail :  " +fltOrgDate+"   "+fltOrgDate2+"  --------- "+fltKey);
		ATUReports.add("fltOrgDate  Fail :  " +fltOrgDate+"   "+fltOrgDate2+"  --------- "+fltKey,  LogAs.FAILED, null);
	}
	
		
	if(depSta.contains(depSta2))
	{
	
	}else{
		System.out.println(fltKey2+"depSta  Fail :  " +depSta+"   "+depSta2+"  --------- "+fltKey);
		//test.log(LogStatus.FAIL,"depSta  Fail :  " +depSta+"   "+depSta2+"  --------- "+fltKey);
		ATUReports.add("depSta  Fail :  " +depSta+"   "+depSta2+"  --------- "+fltKey,  LogAs.FAILED, null);
	}
	
	
	if(dupDepStaNum.equalsIgnoreCase(dupDepStaNum2))
	{
	
	}else{
		System.out.println(fltKey2+"dupDepStaNum  Fail :  " +dupDepStaNum+"   "+dupDepStaNum2+"  --------- "+fltKey);
	//	test.log(LogStatus.FAIL, "dupDepStaNum  Fail :  " +dupDepStaNum+"   "+dupDepStaNum2+"  --------- "+fltKey);
		ATUReports.add("dupDepStaNum  Fail :  " +dupDepStaNum+"   "+dupDepStaNum2+"  --------- "+fltKey,  LogAs.FAILED, null);
	}
	
	
	if(carrierCode.contains(carrierCode2))
	{
	
	}else{
		System.out.println(fltKey2+"carrierCode  Fail :  " +carrierCode+"   "+carrierCode2+"  --------- "+fltKey);
//		test.log(LogStatus.FAIL,"carrierCode  Fail :  " +carrierCode+"   "+carrierCode2+"  --------- "+fltKey);
		ATUReports.add("carrierCode  Fail :  " +carrierCode+"   "+carrierCode2+"  --------- "+fltKey,  LogAs.INFO, null);
	}
	
	
	if(iata.contains(iata2))
	{
	
	}else{
		System.out.println(fltKey2+"iata  Fail :  " +iata+"   "+iata2+"  --------- "+fltKey);
		//test.log(LogStatus.FAIL,"iata  Fail :  " +iata+"   "+iata2+"  --------- "+fltKey);
		ATUReports.add("iata  Fail :  " +iata+"   "+iata2+"  --------- "+fltKey,  LogAs.FAILED, null);
	}
	
	
	if(destination.contains(destination2))
	{
	
	}else{
		System.out.println(fltKey2+"destination  Fail :  " +destination+"   "+destination2+"  --------- "+fltKey);
		//test.log(LogStatus.FAIL,"destination  Fail :  " +destination+"   "+destination2+"  --------- "+fltKey);
		ATUReports.add("destination  Fail :  " +destination+"   "+destination2+"  --------- "+fltKey,  LogAs.FAILED, null);
	}
	
	
	if(dupArrStaNum.contains(dupArrStaNum2))
	{
	
	}else{
		System.out.println(fltKey2+" dupArrStaNum Fail :  " +dupArrStaNum+"   "+dupArrStaNum2+"  --------- "+fltKey);
		//test.log(LogStatus.FAIL, " dupArrStaNum Fail :  " +dupArrStaNum+"   "+dupArrStaNum2+"  --------- "+fltKey);
		ATUReports.add(" dupArrStaNum Fail :  " +dupArrStaNum+"   "+dupArrStaNum2+"  --------- "+fltKey,  LogAs.FAILED, null);
	}
	
	
	if(assignedTail .contains(assignedTail2))
	{
	
	}else{
		System.out.println(fltKey2+"assignedTail  Fail :  " +assignedTail+"   "+assignedTail2+"  --------- "+fltKey);
		//test.log(LogStatus.FAIL,"assignedTail  Fail :  " +assignedTail+"   "+assignedTail2+"  --------- "+fltKey);
		ATUReports.add("assignedTail  Fail :  " +assignedTail+"   "+assignedTail2+"  --------- "+fltKey,  LogAs.FAILED, null);
	}
	
	
	if(skdEquipType.contains(skdEquipType2))
	{
	
	}else{
		System.out.println(fltKey2+"skdEquipType  Fail :  " +skdEquipType+"   "+skdEquipType2+"  --------- "+fltKey);
		//test.log(LogStatus.FAIL,"skdEquipType  Fail :  " +skdEquipType+"   "+skdEquipType2+"  --------- "+fltKey);
		ATUReports.add("skdEquipType  Fail :  " +skdEquipType+"   "+skdEquipType2+"  --------- "+fltKey,  LogAs.FAILED, null);
	}
	
	
	if(assignedEquipType.contains(assignedEquipType2))
	{
	
	}else{
		System.out.println(fltKey2+"assignedEquipType  Fail :  " +assignedEquipType+"   "+assignedEquipType2+"  --------- "+fltKey);
		//test.log(LogStatus.FAIL,"assignedEquipType  Fail :  " +assignedEquipType+"   "+assignedEquipType2+"  --------- "+fltKey);
		ATUReports.add("assignedEquipType  Fail :  " +assignedEquipType+"   "+assignedEquipType2+"  --------- "+fltKey,  LogAs.FAILED, null);
	}
	
	
	if(aircraftRegistrationNbr.contains(aircraftRegistrationNbr2))
	{
	
	}else{
		System.out.println(fltKey2+"aircraftRegistrationNbr  Fail :  " +aircraftRegistrationNbr+"   "+aircraftRegistrationNbr2+"  --------- "+fltKey);
		//test.log(LogStatus.FAIL,"aircraftRegistrationNbr  Fail :  " +aircraftRegistrationNbr+"   "+aircraftRegistrationNbr2+"  --------- "+fltKey);
		ATUReports.add("aircraftRegistrationNbr  Fail :  " +aircraftRegistrationNbr+"   "+aircraftRegistrationNbr2+"  --------- "+fltKey,  LogAs.FAILED, null);
	}
	
	
	
	if(skdTaxiOut.equalsIgnoreCase(skdTaxiOut2))
	{
	
	}else{
		System.out.println(fltKey2+"skdTaxiOut  Fail :  " +skdTaxiOut+"   "+skdTaxiOut2+"  --------- "+fltKey);
		//test.log(LogStatus.FAIL,"skdTaxiOut  Fail :  " +skdTaxiOut+"   "+skdTaxiOut2+"  --------- "+fltKey);
		ATUReports.add("skdTaxiOut  Fail :  " +skdTaxiOut+"   "+skdTaxiOut2+"  --------- "+fltKey,  LogAs.FAILED, null);
	}
	
	
	if(skdTaxiIn.equalsIgnoreCase(skdTaxiIn2))
	{
	
	}else{
		System.out.println(fltKey2+"skdTaxiIn  Fail :  " +skdTaxiIn+"   "+skdTaxiIn2+"  --------- "+fltKey);
		//test.log(LogStatus.FAIL,"skdTaxiIn  Fail :  " +skdTaxiIn+"   "+skdTaxiIn2+"  --------- "+fltKey);
		ATUReports.add("skdTaxiIn  Fail :  " +skdTaxiIn+"   "+skdTaxiIn2+"  --------- "+fltKey,  LogAs.FAILED, null);
	}
	
	
	if(latestTaxiOut.equalsIgnoreCase(latestTaxiOut2))
	{
	
	}else{
		System.out.println(fltKey2+"latestTaxiOut  Fail :  " +latestTaxiOut+"   "+latestTaxiOut2+"  --------- "+fltKey);
		//test.log(LogStatus.FAIL,"latestTaxiOut  Fail :  " +latestTaxiOut+"   "+latestTaxiOut2+"  --------- "+fltKey);
		ATUReports.add("latestTaxiOut  Fail :  " +latestTaxiOut+"   "+latestTaxiOut2+"  --------- "+fltKey,  LogAs.FAILED, null);
	}
	
	
	
 		
	
	if(latestTaxiIn.equalsIgnoreCase(latestTaxiIn2))
	{
	
	}else{
		System.out.println(fltKey2+"latestTaxiIn  Fail :  " +latestTaxiIn+"   "+latestTaxiIn2+"  --------- "+fltKey);
		//test.log(LogStatus.FAIL,"latestTaxiIn  Fail :  " +latestTaxiIn+"   "+latestTaxiIn2+"  --------- "+fltKey);
		ATUReports.add("latestTaxiIn  Fail :  " +latestTaxiIn+"   "+latestTaxiIn2+"  --------- "+fltKey,  LogAs.FAILED, null);
	}
	
	
	
	
	if(depGMTAdjustment.contains(depGMTAdjustment2))
	{
	
	}else{
		System.out.println(fltKey2+"depGMTAdjustment  Fail :  " +depGMTAdjustment+"   "+depGMTAdjustment2+"  --------- "+fltKey);
		//test.log(LogStatus.FAIL,"depGMTAdjustment  Fail :  " +depGMTAdjustment+"   "+depGMTAdjustment2+"  --------- "+fltKey);
		ATUReports.add("depGMTAdjustment  Fail :  " +depGMTAdjustment+"   "+depGMTAdjustment2+"  --------- "+fltKey,  LogAs.FAILED, null);
	}
	
	
	if(arrGMTAdjustment.contains(arrGMTAdjustment2))
	{
	
	}else{
		System.out.println(fltKey2+"arrGMTAdjustment  Fail :  " +EqpType+"   "+arrGMTAdjustment2+"  --------- "+fltKey);
		//test.log(LogStatus.FAIL,"arrGMTAdjustment  Fail :  " +EqpType+"   "+arrGMTAdjustment2+"  --------- "+fltKey);
		ATUReports.add("arrGMTAdjustment  Fail :  " +EqpType+"   "+arrGMTAdjustment2+"  --------- "+fltKey,  LogAs.FAILED, null);
	}
	
	
	if(mogt.equalsIgnoreCase(mogt2))
	{
	
	}else{
		System.out.println(fltKey2+"mogt  Fail :  " +mogt+"   "+mogt2+"  --------- "+fltKey);
		//test.log(LogStatus.FAIL,"mogt  Fail :  " +mogt+"   "+mogt2+"  --------- "+fltKey);
		ATUReports.add("mogt  Fail :  " +mogt+"   "+mogt2+"  --------- "+fltKey,  LogAs.FAILED, null);
	}
	
	
	if(nextLegFltNum.contains(nextLegFltNum2))
	{
	
	}else{
		System.out.println(fltKey2+"nextLegFltNum  Fail :  " +nextLegFltNum+"   "+nextLegFltNum2+"  --------- "+fltKey);
		//test.log(LogStatus.FAIL,"nextLegFltNum  Fail :  " +nextLegFltNum+"   "+nextLegFltNum2+"  --------- "+fltKey);
		ATUReports.add("nextLegFltNum  Fail :  " +nextLegFltNum+"   "+nextLegFltNum2+"  --------- "+fltKey,LogAs.FAILED, null);
	}
	
	
	if(nextLegOrgDate.contains(nextLegOrgDate2))
	{
	
	}else{
		System.out.println(fltKey2+"nextLegOrgDate  Fail :  " +nextLegOrgDate+"   "+nextLegOrgDate2+"  --------- "+fltKey);
		//test.log(LogStatus.FAIL,"nextLegOrgDate  Fail :  " +nextLegOrgDate+"   "+nextLegOrgDate2+"  --------- "+fltKey);
		ATUReports.add("nextLegOrgDate  Fail :  " +nextLegOrgDate+"   "+nextLegOrgDate2+"  --------- "+fltKey,  LogAs.FAILED, null);
	}
	
	
	if(nextLegFltDupCode.contains(nextLegFltDupCode2))
	{
	
	}else{
		System.out.println(fltKey2+"nextLegFltDupCode  Fail :  " +nextLegFltDupCode+"   "+nextLegFltDupCode2+"  --------- "+fltKey);
		//test.log(LogStatus.FAIL,"nextLegFltDupCode  Fail :  " +nextLegFltDupCode+"   "+nextLegFltDupCode2+"  --------- "+fltKey);
		ATUReports.add("nextLegFltDupCode  Fail :  " +nextLegFltDupCode+"   "+nextLegFltDupCode2+"  --------- "+fltKey,  LogAs.FAILED, null);
	}
	
	
	if(nextLegCarrierCode .contains(nextLegCarrierCode2))
	{
	
	}else{
		System.out.println(fltKey2+"nextLegCarrierCode  Fail :  " +nextLegCarrierCode +"   "+nextLegCarrierCode2+"  --------- "+fltKey);
		//test.log(LogStatus.FAIL,"nextLegCarrierCode  Fail :  " +nextLegCarrierCode +"   "+nextLegCarrierCode2+"  --------- "+fltKey);
		ATUReports.add("nextLegCarrierCode  Fail :  " +nextLegCarrierCode +"   "+nextLegCarrierCode2+"  --------- "+fltKey,  LogAs.FAILED, null);
		
	}
	
	
	if(nextLegKey.contains(nextLegKey2))
	{
	
	}else{
		System.out.println(fltKey2+"nextLegKey  Fail :  " +nextLegKey+"   "+nextLegKey2+"  --------- "+fltKey);
		//test.log(LogStatus.FAIL, "nextLegKey  Fail :  " +nextLegKey+"   "+nextLegKey2+"  --------- "+fltKey);
		ATUReports.add( "nextLegKey  Fail :  " +nextLegKey+"   "+nextLegKey2+"  --------- "+fltKey,  LogAs.FAILED, null);
	}
	
	
	if(priorLegFltNum.contains(priorLegFltNum2))
	{
	
	}else{
		System.out.println(fltKey2+"priorLegFltNum  Fail :  " +priorLegFltNum+"   "+priorLegFltNum2+"  --------- "+fltKey);
		//test.log(LogStatus.FAIL,"priorLegFltNum  Fail :  " +priorLegFltNum+"   "+priorLegFltNum2+"  --------- "+fltKey);
		ATUReports.add("priorLegFltNum  Fail :  " +priorLegFltNum+"   "+priorLegFltNum2+"  --------- "+fltKey,  LogAs.FAILED, null);
	}
	
	
	if(priorLegOrgDate.contains(priorLegOrgDate2))
	{
	
	}else{
		System.out.println(fltKey2+"priorLegOrgDate  Fail :  " +priorLegOrgDate+"   "+priorLegOrgDate2+"  --------- "+fltKey);
	//	test.log(LogStatus.FAIL,"priorLegOrgDate  Fail :  " +priorLegOrgDate+"   "+priorLegOrgDate2+"  --------- "+fltKey);
		ATUReports.add("priorLegOrgDate  Fail :  " +priorLegOrgDate+"   "+priorLegOrgDate2+"  --------- "+fltKey,  LogAs.FAILED, null);
	}
	
	
	if(priorLegFltDupCode.contains(priorLegFltDupCode2))
	{
	
	}else{
		System.out.println(fltKey2+"priorLegFltDupCode  Fail :  " +priorLegFltDupCode2+"   "+priorLegFltDupCode2+"  --------- "+fltKey);
	//	test.log(LogStatus.FAIL,"priorLegFltDupCode  Fail :  " +priorLegFltDupCode2+"   "+priorLegFltDupCode2+"  --------- "+fltKey);
		ATUReports.add("priorLegFltDupCode  Fail :  " +priorLegFltDupCode2+"   "+priorLegFltDupCode2+"  --------- "+fltKey,  LogAs.FAILED, null);
	}
	
	
	if(priorLegDepStation.contains(priorLegDepStation2))
	{
	
	}else{
		System.out.println(fltKey2+"priorLegDepStation  Fail :  " +priorLegDepStation+"   "+priorLegDepStation2+"  --------- "+fltKey);
	//	test.log(LogStatus.FAIL, "priorLegDepStation  Fail :  " +priorLegDepStation+"   "+priorLegDepStation2+"  --------- "+fltKey);
		ATUReports.add("priorLegDepStation  Fail :  " +priorLegDepStation+"   "+priorLegDepStation2+"  --------- "+fltKey,  LogAs.FAILED, null);
	}
	
	
	if(priorLegCarrierCode.contains(priorLegCarrierCode2))
	{
	
	}else{
		System.out.println(fltKey2+"priorLegCarrierCode  Fail :  " +priorLegCarrierCode+"   "+priorLegCarrierCode2+"  --------- "+fltKey);
	//	test.log(LogStatus.FAIL, "priorLegCarrierCode  Fail :  " +priorLegCarrierCode+"   "+priorLegCarrierCode2+"  --------- "+fltKey);
		ATUReports.add("priorLegCarrierCode  Fail :  " +priorLegCarrierCode+"   "+priorLegCarrierCode2+"  --------- "+fltKey,  LogAs.FAILED, null);
	}
	
	
	
	
	
	if(legStatus.contains(legStatus2))
	{
	
	}else{
		System.out.println(fltKey2+"legStatus  Fail :  " +legStatus+"   "+legStatus2+"  --------- "+fltKey);
		//test.log(LogStatus.FAIL,"legStatus  Fail :  " +legStatus+"   "+legStatus2+"  --------- "+fltKey);
		ATUReports.add("legStatus  Fail :  " +legStatus+"   "+legStatus2+"  --------- "+fltKey,  LogAs.FAILED, null);
	}
	
	
	if(depStatus.contains(depStatus2))
	{
	
	}else{
		System.out.println(fltKey2+"depStatus  Fail :  " +depStatus+"   "+depStatus2+"  --------- "+fltKey);
		//test.log(LogStatus.FAIL,"depStatus  Fail :  " +depStatus+"   "+depStatus2+"  --------- "+fltKey);
		ATUReports.add("depStatus  Fail :  " +depStatus+"   "+depStatus2+"  --------- "+fltKey,  LogAs.FAILED, null);
	}
	
	
	if(arrStatus.contains(arrStatus2))
	{
	
	}else{
		System.out.println(fltKey2+"arrStatus Fail :  " +arrStatus+"   "+arrStatus2+"  --------- "+fltKey);
		//test.log(LogStatus.FAIL,"arrStatus Fail :  " +arrStatus+"   "+arrStatus2+"  --------- "+fltKey);
		ATUReports.add("arrStatus Fail :  " +arrStatus+"   "+arrStatus2+"  --------- "+fltKey,  LogAs.FAILED, null);
	}
	
	
	if(depGate.contains(depGate2))
	{
	
	}else{
		System.out.println(fltKey2+"depGate  Fail :  " +depGate+"   "+depGate2+"  --------- "+fltKey);
		//test.log(LogStatus.FAIL, "depGate  Fail :  " +depGate+"   "+depGate2+"  --------- "+fltKey);
		ATUReports.add("depGate  Fail :  " +depGate+"   "+depGate2+"  --------- "+fltKey,  LogAs.FAILED, null);
	}
	
	
	if(arrGate.contains(arrGate2))
	{
	
	}else{
		System.out.println(fltKey2+"arrGate  Fail :  " +arrGate+"   "+arrGate2+"  --------- "+fltKey);
		//test.log(LogStatus.FAIL,"arrGate  Fail :  " +arrGate+"   "+arrGate2+"  --------- "+fltKey);
		ATUReports.add("arrGate  Fail :  " +arrGate+"   "+arrGate2+"  --------- "+fltKey,  LogAs.FAILED, null);
	}
	
	if(bagclaim.contains(bagclaim2))
	{
	
	}else{
		System.out.println(fltKey2+"bagclaim  Fail :  " +bagclaim+"   "+bagclaim2+"  --------- "+fltKey);
		//test.log(LogStatus.FAIL,"bagclaim  Fail :  " +bagclaim+"   "+bagclaim2+"  --------- "+fltKey);
		ATUReports.add("bagclaim  Fail :  " +bagclaim+"   "+bagclaim2+"  --------- "+fltKey,  LogAs.FAILED, null);
	}

	
//	if(arrTerminal.contains(arrTerminal2))
//	{
//	
//	}else{
//		System.out.println("arrTerminal  Fail :  " +arrTerminal+"   "+arrTerminal2+"  --------- "+fltKey);
//		test.log(LogStatus.FAIL, "arrTerminal  Fail :  " +arrTerminal+"   "+arrTerminal2+"  --------- "+fltKey);
//	}
	
	if(intOrDom.contains(intOrDom2))
	{
	
	}else{
		System.out.println(fltKey2+"intOrDom  Fail :  " +intOrDom+"   "+intOrDom2+"  --------- "+fltKey);
		//test.log(LogStatus.FAIL, "intOrDom  Fail :  " +intOrDom+"   "+intOrDom2+"  --------- "+fltKey);
		ATUReports.add("intOrDom  Fail :  " +intOrDom+"   "+intOrDom2+"  --------- "+fltKey,  LogAs.FAILED, null);
	}
	
	
	
	
	if(kickOffFlt.contains(kickOffFlt2))
	{
	
	}else{
		System.out.println(fltKey2+"kickOffFlt  Fail :  " +kickOffFlt+"   "+kickOffFlt2+"  --------- "+fltKey);
		//test.log(LogStatus.FAIL,"kickOffFlt  Fail :  " +kickOffFlt+"   "+kickOffFlt2+"  --------- "+fltKey);
		ATUReports.add("kickOffFlt  Fail :  " +kickOffFlt+"   "+kickOffFlt2+"  --------- "+fltKey,  LogAs.FAILED, null);
	}
	


	if(getDepStatus.contains(getDepStatus2))
	{
	
	}else{
		System.out.println(fltKey2+"getDepStatus  Fail :  " +getDepStatus+"   "+getDepStatus2+"  --------- "+fltKey);
		//test.log(LogStatus.FAIL, "getDepStatus  Fail :  " +getDepStatus+"   "+getDepStatus2+"  --------- "+fltKey);
		ATUReports.add("getDepStatus  Fail :  " +getDepStatus+"   "+getDepStatus2+"  --------- "+fltKey,  LogAs.FAILED, null);
	}
	
	

	
	if(getArrStatus.contains(getArrStatus2))
	{
	
	}else{
		System.out.println(fltKey2+"getArrStatus  Fail :  " +getArrStatus+"   "+getArrStatus2+"  --------- "+fltKey);
		//test.log(LogStatus.FAIL,"getArrStatus  Fail :  " +getArrStatus+"   "+getArrStatus2+"  --------- "+fltKey);
		ATUReports.add("getArrStatus  Fail :  " +getArrStatus+"   "+getArrStatus2+"  --------- "+fltKey,  LogAs.FAILED, null);
	}
	
	
	if(wtRestricted.equalsIgnoreCase(wtRestricted2))
	{
	
	}else{
		System.out.println(fltKey2+"wtRestricted  Fail :  " +wtRestricted+"   "+wtRestricted2+"  --------- "+fltKey);
		//test.log(LogStatus.FAIL, "wtRestricted  Fail :  " +wtRestricted+"   "+wtRestricted2+"  --------- "+fltKey);
		ATUReports.add("wtRestricted  Fail :  " +wtRestricted+"   "+wtRestricted2+"  --------- "+fltKey,  LogAs.FAILED, null);
	}
	
	

	if(dispDesk.contains(dispDesk2))
	{
	
	}else{
		System.out.println(fltKey2+"dispDesk  Fail :  " +dispDesk+"   "+dispDesk2+"  --------- "+fltKey);
		//test.log(LogStatus.FAIL, "dispDesk  Fail :  " +dispDesk+"   "+dispDesk2+"  --------- "+fltKey);
		ATUReports.add("dispDesk  Fail :  " +dispDesk+"   "+dispDesk2+"  --------- "+fltKey,  LogAs.FAILED, null);
	}
	

	
	if(depGateChange.equalsIgnoreCase(depGateChange2))
	{
	
	}else{
		System.out.println(fltKey2+"depGateChange  Fail :  " +depGateChange+"   "+depGateChange2+"  --------- "+fltKey);
		//test.log(LogStatus.FAIL, "depGateChange  Fail :  " +depGateChange+"   "+depGateChange2+"  --------- "+fltKey);
		ATUReports.add("depGateChange  Fail :  " +depGateChange+"   "+depGateChange2+"  --------- "+fltKey,  LogAs.FAILED, null);
	}
	
	if(expectedTimeArrivalGMT.equalsIgnoreCase(expectedTimeArrivalGMT2))
	{
	
	}else{
		System.out.println(fltKey2+"expectedTimeArrivalGMT  Fail :  " +expectedTimeArrivalGMT+"   "+expectedTimeArrivalGMT2+"  --------- "+fltKey);
		//test.log(LogStatus.FAIL,"expectedTimeArrivalGMT  Fail :  " +expectedTimeArrivalGMT+"   "+expectedTimeArrivalGMT2+"  --------- "+fltKey);
		ATUReports.add("expectedTimeArrivalGMT  Fail :  " +expectedTimeArrivalGMT+"   "+expectedTimeArrivalGMT2+"  --------- "+fltKey,  LogAs.FAILED, null);
	}
	
	if(scheduledTimeArrivalGMT.equalsIgnoreCase(scheduledTimeArrivalGMT2))
	{
	
	}else{
		System.out.println(fltKey2+"scheduledTimeArrivalGMT  Fail :  " +scheduledTimeArrivalGMT+"   "+scheduledTimeArrivalGMT2+"  --------- "+fltKey);
		//test.log(LogStatus.FAIL,"scheduledTimeArrivalGMT  Fail :  " +scheduledTimeArrivalGMT+"   "+scheduledTimeArrivalGMT2+"  --------- "+fltKey);
		ATUReports.add("scheduledTimeArrivalGMT  Fail :  " +scheduledTimeArrivalGMT+"   "+scheduledTimeArrivalGMT2+"  --------- "+fltKey,  LogAs.FAILED, null);
	}
	

	
	if(expectedTimeDepartureGMT.equalsIgnoreCase(expectedTimeDepartureGMT2))
	{
	
	}else{
		System.out.println(fltKey2+"expectedTimeDepartureGMT  Fail :  " +expectedTimeDepartureGMT+"   "+expectedTimeDepartureGMT2+"  --------- "+fltKey);
	//	test.log(LogStatus.FAIL, "expectedTimeDepartureGMT  Fail :  " +expectedTimeDepartureGMT+"   "+expectedTimeDepartureGMT2+"  --------- "+fltKey);
		ATUReports.add("expectedTimeDepartureGMT  Fail :  " +expectedTimeDepartureGMT+"   "+expectedTimeDepartureGMT2+"  --------- "+fltKey,  LogAs.FAILED, null);
	}
	
	
	
	
	if(scheduledTimeDepartureGMT.equalsIgnoreCase(scheduledTimeDepartureGMT2))
	{
	
	}else{
		System.out.println(fltKey2+"scheduledTimeDepartureGMT  Fail :  " +scheduledTimeDepartureGMT+"   "+scheduledTimeDepartureGMT2+"  --------- "+fltKey);
		//test.log(LogStatus.FAIL,"scheduledTimeDepartureGMT  Fail :  " +scheduledTimeDepartureGMT+"   "+scheduledTimeDepartureGMT2+"  --------- "+fltKey);
		ATUReports.add("scheduledTimeDepartureGMT  Fail :  " +scheduledTimeDepartureGMT+"   "+scheduledTimeDepartureGMT2+"  --------- "+fltKey,  LogAs.FAILED, null);
	}
	
	
		if(expectedTimeArrivalLocal.equalsIgnoreCase(expectedTimeArrivalLocal2))
	{
	
	}else{
		System.out.println(fltKey2+"expectedTimeArrivalLocal  Fail :  " +expectedTimeArrivalLocal+"   "+expectedTimeArrivalLocal2+"  --------- "+fltKey);
		//test.log(LogStatus.FAIL, "expectedTimeArrivalLocal  Fail :  " +expectedTimeArrivalLocal+"   "+expectedTimeArrivalLocal2+"  --------- "+fltKey);
		ATUReports.add("expectedTimeArrivalLocal  Fail :  " +expectedTimeArrivalLocal+"   "+expectedTimeArrivalLocal2+"  --------- "+fltKey,  LogAs.FAILED, null);
	}
	
	
	if(scheduledTimeArrivalLocal.equalsIgnoreCase(scheduledTimeArrivalLocal2))
	{
	
	}else{
		System.out.println(fltKey2+"scheduledTimeArrivalLocal  Fail :  " +scheduledTimeArrivalLocal+"   "+scheduledTimeArrivalLocal2+"  --------- "+fltKey);
		//test.log(LogStatus.FAIL, "scheduledTimeArrivalLocal  Fail :  " +scheduledTimeArrivalLocal+"   "+scheduledTimeArrivalLocal2+"  --------- "+fltKey);
		ATUReports.add("scheduledTimeArrivalLocal  Fail :  " +scheduledTimeArrivalLocal+"   "+scheduledTimeArrivalLocal2+"  --------- "+fltKey,  LogAs.FAILED, null);
	}

	
	if(expectedTimeDepartureLocal.equalsIgnoreCase(expectedTimeDepartureLocal2))
	{
	
	}else{
		System.out.println(fltKey2+"expectedTimeDepartureLocal  Fail :  " +expectedTimeDepartureLocal+"   "+expectedTimeDepartureLocal2+"  --------- "+fltKey);
		//test.log(LogStatus.FAIL, "expectedTimeDepartureLocal  Fail :  " +expectedTimeDepartureLocal+"   "+expectedTimeDepartureLocal2+"  --------- "+fltKey);
		ATUReports.add("expectedTimeDepartureLocal  Fail :  " +expectedTimeDepartureLocal+"   "+expectedTimeDepartureLocal2+"  --------- "+fltKey,  LogAs.FAILED, null);
	}
	
	if(scheduledTimeDepartureLocal.equalsIgnoreCase(scheduledTimeDepartureLocal2))
	{
	
	}else{
		System.out.println(fltKey2+"scheduledTimeDepartureLocal  Fail :  " +scheduledTimeDepartureLocal+"   "+scheduledTimeDepartureLocal2+"  --------- "+fltKey);
		//test.log(LogStatus.FAIL,"scheduledTimeDepartureLocal  Fail :  " +scheduledTimeDepartureLocal+"   "+scheduledTimeDepartureLocal2+"  --------- "+fltKey);
		ATUReports.add("scheduledTimeDepartureLocal  Fail :  " +scheduledTimeDepartureLocal+"   "+scheduledTimeDepartureLocal2+"  --------- "+fltKey,  LogAs.FAILED, null);
	}


	if(actualOnGMT.equalsIgnoreCase(actualOnGMT2))
	{
	
	}else{
		System.out.println(fltKey2+"actualOnGMT  Fail :  " +actualOnGMT+"   "+actualOnGMT2+"  --------- "+fltKey);
		//test.log(LogStatus.FAIL,"actualOnGMT  Fail :  " +actualOnGMT+"   "+actualOnGMT2+"  --------- "+fltKey);
		ATUReports.add("actualOnGMT  Fail :  " +actualOnGMT+"   "+actualOnGMT2+"  --------- "+fltKey,  LogAs.FAILED, null);
	}

	if(actualOnLoc.equalsIgnoreCase(actualOnLoc2))
	{
	
	}else{
		System.out.println(fltKey2+"actualOnLoc  Fail :  " +actualOnLoc+"   "+actualOnLoc2+"  --------- "+fltKey);
		//test.log(LogStatus.FAIL, "actualOnLoc  Fail :  " +actualOnLoc+"   "+actualOnLoc2+"  --------- "+fltKey);
		ATUReports.add("actualOnLoc  Fail :  " +actualOnLoc+"   "+actualOnLoc2+"  --------- "+fltKey,  LogAs.FAILED, null);
	}

	if(actualInGMT.equalsIgnoreCase(actualInGMT2))
	{
	
	}else{
		System.out.println(fltKey2+"actualInGMT  Fail :  " +actualInGMT+"   "+actualInGMT2+"  --------- "+fltKey);
	//	test.log(LogStatus.FAIL,"actualInGMT  Fail :  " +actualInGMT+"   "+actualInGMT2+"  --------- "+fltKey);
		ATUReports.add("actualInGMT  Fail :  " +actualInGMT+"   "+actualInGMT2+"  --------- "+fltKey,  LogAs.FAILED, null);
	}

	if(actualInLoc.equalsIgnoreCase(actualInLoc2))
	{
	
	}else{
		System.out.println(fltKey2+"actualInLoc  Fail :  " +actualInLoc+"   "+actualInLoc2+"  --------- "+fltKey);
		//test.log(LogStatus.FAIL,"actualInLoc  Fail :  " +actualInLoc+"   "+actualInLoc2+"  --------- "+fltKey);
		ATUReports.add("actualInLoc  Fail :  " +actualInLoc+"   "+actualInLoc2+"  --------- "+fltKey,  LogAs.FAILED, null);
	}

	
	if(actualOutGMT.equalsIgnoreCase(actualOutGMT2))
	{
	
	}else{
		System.out.println(fltKey2+"actualOutGMT  Fail :  " +actualOutGMT+"   "+actualOutGMT2+"  --------- "+fltKey);
		//test.log(LogStatus.FAIL,"actualOutGMT  Fail :  " +actualOutGMT+"   "+actualOutGMT2+"  --------- "+fltKey);
		ATUReports.add("actualOutGMT  Fail :  " +actualOutGMT+"   "+actualOutGMT2+"  --------- "+fltKey,  LogAs.FAILED, null);
	}
	
	if(actualOutLoc.equalsIgnoreCase(actualOutLoc2))
	{
	
	}else{
		System.out.println(fltKey2+"actualOutLoc  Fail :  " +actualOutLoc+"   "+actualOutLoc2+"  --------- "+fltKey);
		//test.log(LogStatus.FAIL, "actualOutLoc  Fail :  " +actualOutLoc+"   "+actualOutLoc2+"  --------- "+fltKey);
		ATUReports.add("actualOutLoc  Fail :  " +actualOutLoc+"   "+actualOutLoc2+"  --------- "+fltKey,  LogAs.FAILED, null);
	}
	
	if(actualOffGMT.equalsIgnoreCase(actualOffGMT2))
	{
	
	}else{
		System.out.println(fltKey2+"actualOffGMT  Fail :  " +actualOffGMT+"   "+actualOffGMT2+"  --------- "+fltKey);
		//test.log(LogStatus.FAIL, "actualOffGMT  Fail :  " +actualOffGMT+"   "+actualOffGMT2+"  --------- "+fltKey);
		ATUReports.add("actualOffGMT  Fail :  " +actualOffGMT+"   "+actualOffGMT2+"  --------- "+fltKey,  LogAs.FAILED, null);
	}

	if(actualOffLoc.equalsIgnoreCase(actualOffLoc2))
	{
	
	}else{
		System.out.println(fltKey2+"actualOffLoc  Fail :  " +actualOffLoc+"   "+actualOffLoc2+"  --------- "+fltKey);
		//test.log(LogStatus.FAIL,"actualOffLoc  Fail :  " +actualOffLoc+"   "+actualOffLoc2+"  --------- "+fltKey);
		ATUReports.add("actualOffLoc  Fail :  " +actualOffLoc+"   "+actualOffLoc2+"  --------- "+fltKey,  LogAs.FAILED, null);
	}
	

	if(sourceTimeStamp.equalsIgnoreCase(sourceTimeStamp2))
	{
	
	}else{
		System.out.println(fltKey2+"sourceTimeStamp  Fail :  " +sourceTimeStamp+"   "+sourceTimeStamp2+"  --------- "+fltKey);
		//test.log(LogStatus.FAIL, "sourceTimeStamp  Fail :  " +sourceTimeStamp+"   "+sourceTimeStamp2+"  --------- "+fltKey);
		ATUReports.add("sourceTimeStamp  Fail :  " +sourceTimeStamp+"   "+sourceTimeStamp2+"  --------- "+fltKey,  LogAs.FAILED, null);
	}
	
	if(etdUpdatedAt.equalsIgnoreCase(etdUpdatedAt2))
	{
	
	}else{
		System.out.println(fltKey2+"etdUpdatedAt  Fail :  " +etdUpdatedAt+"   "+etdUpdatedAt2+"  --------- "+fltKey);
		//test.log(LogStatus.FAIL,"etdUpdatedAt  Fail :  " +etdUpdatedAt+"   "+etdUpdatedAt2+"  --------- "+fltKey);
		ATUReports.add("etdUpdatedAt  Fail :  " +etdUpdatedAt+"   "+etdUpdatedAt2+"  --------- "+fltKey,  LogAs.FAILED, null);
	}
	
		if(etaUpdatedAt.equalsIgnoreCase(etaUpdatedAt2))
	{
	
	}else{
		System.out.println(fltKey2+"etaUpdatedAt  Fail :  " +etaUpdatedAt+"   "+etaUpdatedAt2+"  --------- "+fltKey);
		//test.log(LogStatus.FAIL,"etaUpdatedAt  Fail :  " +etaUpdatedAt+"   "+etaUpdatedAt2+"  --------- "+fltKey);
		ATUReports.add("etaUpdatedAt  Fail :  " +etaUpdatedAt+"   "+etaUpdatedAt2+"  --------- "+fltKey,  LogAs.FAILED, null);
	}
	
		if(onUpdatedAt.equalsIgnoreCase(onUpdatedAt2))
	{
	
	}else{
		System.out.println(fltKey2+"onUpdatedAt  Fail :  " +onUpdatedAt+"   "+onUpdatedAt2+"  --------- "+fltKey);
		//test.log(LogStatus.FAIL,"onUpdatedAt  Fail :  " +onUpdatedAt+"   "+onUpdatedAt2+"  --------- "+fltKey);
		ATUReports.add("onUpdatedAt  Fail :  " +onUpdatedAt+"   "+onUpdatedAt2+"  --------- "+fltKey,  LogAs.FAILED, null);
	}

		if(eonUpdatedAt.equalsIgnoreCase(eonUpdatedAt2))
	{
	
	}else{
		System.out.println(fltKey2+"eonUpdatedAt  Fail :  " +eonUpdatedAt+"   "+eonUpdatedAt2+"  --------- "+fltKey);
	//	test.log(LogStatus.FAIL,"eonUpdatedAt  Fail :  " +eonUpdatedAt+"   "+eonUpdatedAt2+"  --------- "+fltKey);
		ATUReports.add("eonUpdatedAt  Fail :  " +eonUpdatedAt+"   "+eonUpdatedAt2+"  --------- "+fltKey,  LogAs.FAILED, null);
	}
	
		if(inUpdatedAt.equalsIgnoreCase(inUpdatedAt2))
	{
	
	}else{
		System.out.println(fltKey2+"inUpdatedAt  Fail :  " +inUpdatedAt+"   "+inUpdatedAt2+"  --------- "+fltKey);
	//	test.log(LogStatus.FAIL, "inUpdatedAt  Fail :  " +inUpdatedAt+"   "+inUpdatedAt2+"  --------- "+fltKey);
		ATUReports.add("inUpdatedAt  Fail :  " +inUpdatedAt+"   "+inUpdatedAt2+"  --------- "+fltKey,  LogAs.FAILED, null);
	}
	
	
		if(offUpdatedAt.equalsIgnoreCase(offUpdatedAt2))
	{
	
	}else{
		System.out.println(fltKey2+"offUpdatedAt  Fail :  " +offUpdatedAt+"   "+offUpdatedAt2+"  --------- "+fltKey);
		//test.log(LogStatus.FAIL, "offUpdatedAt  Fail :  " +offUpdatedAt+"   "+offUpdatedAt2+"  --------- "+fltKey);
		ATUReports.add("offUpdatedAt  Fail :  " +offUpdatedAt+"   "+offUpdatedAt2+"  --------- "+fltKey,  LogAs.FAILED, null);
	}
	
	
			if(etoUpdatedAt.equalsIgnoreCase(etoUpdatedAt2))
	{
	
	}else{
		System.out.println(fltKey2+"etoUpdatedAt  Fail :  " +etoUpdatedAt+"   "+etoUpdatedAt2+"  --------- "+fltKey);
		//test.log(LogStatus.FAIL,"etoUpdatedAt  Fail :  " +etoUpdatedAt+"   "+etoUpdatedAt2+"  --------- "+fltKey);
		ATUReports.add("etoUpdatedAt  Fail :  " +etoUpdatedAt+"   "+etoUpdatedAt2+"  --------- "+fltKey,  LogAs.FAILED, null);
	}
	

			if(outUpdatedAt.equalsIgnoreCase(outUpdatedAt2))
	{
	
	}else{
		System.out.println(fltKey2+"outUpdatedAt  Fail :  " +outUpdatedAt+"   "+outUpdatedAt2+"  --------- "+fltKey);
		//test.log(LogStatus.FAIL,"outUpdatedAt  Fail :  " +outUpdatedAt+"   "+outUpdatedAt2+"  --------- "+fltKey);
		ATUReports.add("outUpdatedAt  Fail :  " +outUpdatedAt+"   "+outUpdatedAt2+"  --------- "+fltKey,  LogAs.FAILED, null);
	}

		if(cancelUpdatedAt.equalsIgnoreCase(cancelUpdatedAt2))
	{
	
	}else{
		System.out.println(fltKey2+"cancelUpdatedAt  Fail :  " +cancelUpdatedAt+"   "+cancelUpdatedAt2+"  --------- "+fltKey);
	//	test.log(LogStatus.FAIL,"cancelUpdatedAt  Fail :  " +cancelUpdatedAt+"   "+cancelUpdatedAt2+"  --------- "+fltKey);
		ATUReports.add("cancelUpdatedAt  Fail :  " +cancelUpdatedAt+"   "+cancelUpdatedAt2+"  --------- "+fltKey,  LogAs.FAILED, null);
	}

		if(eqsubUpdatedAt.equalsIgnoreCase(eqsubUpdatedAt2))
	{
	
	}else{
		System.out.println(fltKey2+"eqsubUpdatedAt  Fail :  " +eqsubUpdatedAt+"   "+eqsubUpdatedAt2+"  --------- "+fltKey);
		//test.log(LogStatus.FAIL,"eqsubUpdatedAt  Fail :  " +eqsubUpdatedAt+"   "+eqsubUpdatedAt2+"  --------- "+fltKey);
		ATUReports.add("eqsubUpdatedAt  Fail :  " +eqsubUpdatedAt+"   "+eqsubUpdatedAt2+"  --------- "+fltKey,  LogAs.FAILED, null);
	}
		
	
		if(eqlinkUpdatedAt.equalsIgnoreCase(eqlinkUpdatedAt2))
	{
	
	}else{
		System.out.println(fltKey2+"eqlinkUpdatedAt  Fail :  " +eqlinkUpdatedAt+"   "+eqlinkUpdatedAt2+"  --------- "+fltKey);
		//test.log(LogStatus.FAIL, "eqlinkUpdatedAt  Fail :  " +eqlinkUpdatedAt+"   "+eqlinkUpdatedAt2+"  --------- "+fltKey);
		ATUReports.add("eqlinkUpdatedAt  Fail :  " +eqlinkUpdatedAt+"   "+eqlinkUpdatedAt2+"  --------- "+fltKey,  LogAs.FAILED, null);
	}
	
			if(groundTimeUpdatedAt.equalsIgnoreCase(groundTimeUpdatedAt2))
	{
	
	}else{
		System.out.println(fltKey2+"groundTimeUpdatedAt  Fail :  " +groundTimeUpdatedAt+"   "+groundTimeUpdatedAt2+"  --------- "+fltKey);
		//test.log(LogStatus.FAIL,"groundTimeUpdatedAt  Fail :  " +groundTimeUpdatedAt+"   "+groundTimeUpdatedAt2+"  --------- "+fltKey);
		ATUReports.add("groundTimeUpdatedAt  Fail :  " +groundTimeUpdatedAt+"   "+groundTimeUpdatedAt2+"  --------- "+fltKey,  LogAs.FAILED, null);
	}
	
	if(gateUpdatedAt.equalsIgnoreCase(gateUpdatedAt2))
	{
	
	}else{
		System.out.println(fltKey2+"gateUpdatedAt  Fail :  " +gateUpdatedAt+"   "+gateUpdatedAt2+"  --------- "+fltKey);
		//test.log(LogStatus.FAIL,"gateUpdatedAt  Fail :  " +gateUpdatedAt+"   "+gateUpdatedAt2+"  --------- "+fltKey);
		ATUReports.add("gateUpdatedAt  Fail :  " +gateUpdatedAt+"   "+gateUpdatedAt2+"  --------- "+fltKey,  LogAs.FAILED, null);
	}
	
	if(createUpdatedAt.equalsIgnoreCase(createUpdatedAt2))
	{
	
	
	}else{
		System.out.println(fltKey2+"createUpdatedAt  Fail :  " +createUpdatedAt+"   "+createUpdatedAt2+"    "+fltKey);
		//test.log(LogStatus.FAIL, "createUpdatedAt  Fail :  " +createUpdatedAt+"   "+createUpdatedAt2+"    "+fltKey);
		ATUReports.add("createUpdatedAt  Fail :  " +createUpdatedAt+"   "+createUpdatedAt2+"    "+fltKey,  LogAs.FAILED, null);
	}
	
		if(cycleUpdatedAt.equalsIgnoreCase(cycleUpdatedAt2))
	{
	
	}else{
		System.out.println(fltKey2+"cycleUpdatedAt  Fail :  " +cycleUpdatedAt+"   "+cycleUpdatedAt2+"  --------- "+fltKey);
		//test.log(LogStatus.FAIL,"cycleUpdatedAt  Fail :  " +cycleUpdatedAt+"   "+cycleUpdatedAt2+"  --------- "+fltKey);
		ATUReports.add("cycleUpdatedAt  Fail :  " +cycleUpdatedAt+"   "+cycleUpdatedAt2+"  --------- "+fltKey,  LogAs.FAILED, null);
	}   			
	if(deleteUpdatedAt.equalsIgnoreCase(deleteUpdatedAt2))
	{
	
	}else{
		System.out.println(fltKey2+"deleteUpdatedAt  Fail :  " +deleteUpdatedAt+"   "+deleteUpdatedAt2+"  --------- "+fltKey);
		//test.log(LogStatus.FAIL,"deleteUpdatedAt  Fail :  " +deleteUpdatedAt+"   "+deleteUpdatedAt2+"  --------- "+fltKey);
		ATUReports.add("deleteUpdatedAt  Fail :  " +deleteUpdatedAt+"   "+deleteUpdatedAt2+"  --------- "+fltKey,  LogAs.FAILED, null);
	}
	

	if(continuationUpdatedAt.equalsIgnoreCase(continuationUpdatedAt2))
	{
	
	}else{
		System.out.println(fltKey2+"continuationUpdatedAt  Fail :  " +continuationUpdatedAt+"   "+continuationUpdatedAt2+"  --------- "+fltKey);
		//test.log(LogStatus.FAIL, "continuationUpdatedAt  Fail :  " +continuationUpdatedAt+"   "+continuationUpdatedAt2+"  --------- "+fltKey);
		ATUReports.add("continuationUpdatedAt  Fail :  " +continuationUpdatedAt+"   "+continuationUpdatedAt2+"  --------- "+fltKey,  LogAs.FAILED, null);
	}
	

	if(reinstateUpdatedAt.equalsIgnoreCase(reinstateUpdatedAt2))
	{
	
	}else{
		System.out.println(fltKey2+"reinstateUpdatedAt  Fail :  " +reinstateUpdatedAt+"   "+reinstateUpdatedAt2+"  --------- "+fltKey);
		//test.log(LogStatus.FAIL,"reinstateUpdatedAt  Fail :  " +reinstateUpdatedAt+"   "+reinstateUpdatedAt2+"  --------- "+fltKey);
		ATUReports.add("reinstateUpdatedAt  Fail :  " +reinstateUpdatedAt+"   "+reinstateUpdatedAt2+"  --------- "+fltKey,  LogAs.FAILED, null);
	}
	if(diversionUpdatedAt.equalsIgnoreCase(diversionUpdatedAt2))
	{
	
	}else{
		System.out.println(fltKey2+"diversionUpdatedAt  Fail :  " +diversionUpdatedAt+"   "+diversionUpdatedAt2+"  --------- "+fltKey);
		//test.log(LogStatus.FAIL,"diversionUpdatedAt  Fail :  " +diversionUpdatedAt+"   "+diversionUpdatedAt2+"  --------- "+fltKey);
		ATUReports.add("diversionUpdatedAt  Fail :  " +diversionUpdatedAt+"   "+diversionUpdatedAt2+"  --------- "+fltKey,  LogAs.FAILED, null);
	}
	if(returnUpdatedAt.equalsIgnoreCase(returnUpdatedAt2))
	{
	
	}else{
		System.out.println(fltKey2+"returnUpdatedAt  Fail :  " +returnUpdatedAt+"   "+returnUpdatedAt2+"  --------- "+fltKey);
		//test.log(LogStatus.FAIL,"returnUpdatedAt  Fail :  " +returnUpdatedAt+"   "+returnUpdatedAt2+"  --------- "+fltKey);
		ATUReports.add("returnUpdatedAt  Fail :  " +returnUpdatedAt+"   "+returnUpdatedAt2+"  --------- "+fltKey,  LogAs.FAILED, null);
	}
	if(decisionUpdatedAt.equalsIgnoreCase(decisionUpdatedAt2))
	{
	
	}else{
		System.out.println(fltKey2+"decisionUpdatedAt  Fail :  " +decisionUpdatedAt+"   "+decisionUpdatedAt2+"  --------- "+fltKey);
		//test.log(LogStatus.FAIL,"decisionUpdatedAt  Fail :  " +decisionUpdatedAt+"   "+decisionUpdatedAt2+"  --------- "+fltKey);
		ATUReports.add("decisionUpdatedAt  Fail :  " +decisionUpdatedAt+"   "+decisionUpdatedAt2+"  --------- "+fltKey,  LogAs.FAILED, null);
	}
	
	if(rtdUpdatedAt.equalsIgnoreCase(rtdUpdatedAt2))
	{
	
	}else{
		System.out.println(fltKey2+"rtdUpdatedAt  Fail :  " +rtdUpdatedAt+"   "+rtdUpdatedAt2+"  --------- "+fltKey);
		//test.log(LogStatus.FAIL,"rtdUpdatedAt  Fail :  " +rtdUpdatedAt+"   "+rtdUpdatedAt2+"  --------- "+fltKey);
		ATUReports.add("rtdUpdatedAt  Fail :  " +rtdUpdatedAt+"   "+rtdUpdatedAt2+"  --------- "+fltKey,  LogAs.FAILED, null);
	}
	
	if(crewUpdatedAt.equalsIgnoreCase(crewUpdatedAt2))
	{
	
	}else{
		System.out.println(fltKey2+"crewUpdatedAt  Fail :  " +crewUpdatedAt+"   "+EqpType+"  --------- "+fltKey);
	//	test.log(LogStatus.FAIL, "crewUpdatedAt  Fail :  " +crewUpdatedAt+"   "+EqpType+"  --------- "+fltKey);
		ATUReports.add("crewUpdatedAt  Fail :  " +crewUpdatedAt+"   "+EqpType+"  --------- "+fltKey,  LogAs.FAILED, null);
	}

		if(fuelSlipUpdatedAt.equalsIgnoreCase(fuelSlipUpdatedAt2))
	{
	
	}else{
		System.out.println(fltKey2+"fuelSlipUpdatedAt  Fail :  " +fuelSlipUpdatedAt+"   "+fuelSlipUpdatedAt2+"  --------- "+fltKey );
		//test.log(LogStatus.FAIL, "fuelSlipUpdatedAt  Fail :  " +fuelSlipUpdatedAt+"   "+fuelSlipUpdatedAt2+"  --------- "+fltKey);
		ATUReports.add("fuelSlipUpdatedAt  Fail :  " +fuelSlipUpdatedAt+"   "+fuelSlipUpdatedAt2+"  --------- "+fltKey,  LogAs.FAILED, null);
	}
	
	
	
	
	
	}catch (Exception EE)
	{
		System.out.println("Exception " );
	//	test.log(LogStatus.FAIL, "Exception ");
		ATUReports.add( "Exception ",  LogAs.FAILED, null);
//		test.log(LogStatus.INFO, Intermediateobject2);
//		test.log(LogStatus.INFO, Intermediateobject22);
	}
	
	}
	catch (Exception EE)
	{
	
		System.out.println("Exception in fetching element. Compare response manually ");
		System.out.println("Response1 :: "+full);
		//System.out.println("Response2:: "+Intermediateobject22);
		//test.log(LogStatus.FAIL, "Exception in fetching element. Compare response manually "+full);
		ATUReports.add( "Exception ",  LogAs.FAILED, null);
	//	test.log(LogStatus.INFO, Intermediateobject2);
	//	test.log(LogStatus.INFO, Intermediateobject22);
		
		
	}

	



}catch (Exception EE)
{
	System.out.println("No Flight No " );
	//test.log(LogStatus.FAIL, "Exception in fetching element. Compare response manually "+full);
	ATUReports.add( "Exception ",  LogAs.FAILED, null);
//	test.log(LogStatus.INFO, Intermediateobject2);
//	test.log(LogStatus.INFO, Intermediateobject22);
}
 


}












public static void Verifybeforeandafter(String url,String url_cache,String station,String strStartTime,String strEndTime) throws Exception{

String url1=url;
String url_cache1=url_cache;
String station1=station;
String strStartTime1=strStartTime;
String strEndTime1=strEndTime;

//VerifyNewEQtypeInclusionGETNGReponse(url1,url_cache1,station1,strStartTime1,strEndTime1);
NotepadtoexcelFlightdetailsbefandafter("STL.txt","STL2.txt",station);
NotepadtoexcelFlightdetailsbefandafter("DFW.txt","DFW2.txt",station);
NotepadtoexcelFlightdetailsbefandafter("CLT.txt","CLT2.txt",station);
}


public static String VerifyNewEQtypeInclusionPOST_JSON_GETNGbefandaft(String URL, String jsonString,String path) throws Exception {
System.out.println("Sending POST Request with value " + jsonString + " to URL:" + URL);

long startTime=Calendar.getInstance().getTimeInMillis();

URL url = new URL(URL);
String json = new String(jsonString);
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
		String result = org.apache.commons.io.IOUtils.toString(in,"UTF-8"); // response is stored in result
	try (FileWriter file = new FileWriter(path)) {
		file.write(result);
	in.close();
	conn.disconnect();
	}
	long endTime=Calendar.getInstance().getTimeInMillis();
	long responsetime = startTime-endTime;
	System.out.println("The Total time taken for url  "+"   "+ URL+"is"+responsetime+ "   milliseconds");
	return result;
}






















// ***************************** compare beforeandafter server restart every object wise ********************

public static String Getvalueinresponsebeforeandafterobjectwise(String Jsonobject,String valueofelement,int number) throws Exception{
	  JSONArray jsonObj1 = new JSONArray(Jsonobject);
	  JSONObject Testprint = jsonObj1.getJSONObject(number);
	
	  try{
		  String EqpType =  	Testprint.getJSONObject("flight").getString(valueofelement);
		  return EqpType;
		  			 
	  }catch(Exception Notastring)
	  {
		  try{
			  Long EqpType =  	Testprint.getJSONObject("flight").getLong(valueofelement); 
			  String EQtype = EqpType.toString();
			  return EQtype;
		  }catch(Exception Notalong)
		  {
			  try{
				  boolean EqpType =  	Testprint.getJSONObject("flight").getBoolean(valueofelement); 
				  String EQtype = String.valueOf(EqpType);
				  return EQtype;
			  }catch(Exception Notany)
			  {
				  try{
						
					  JSONArray depgatehistory = Testprint.getJSONObject("flight").getJSONArray(valueofelement);
					  String EQtype = depgatehistory.toString();
					  return EQtype;
							  
				  }catch(Exception Notany1)
				  {
				  return "empty"; 
				  }
			  }
			  
		  }
		  
	  }
	
	  
	  
  	
	  
	  
	  
}


public static void NotepadtoexcelFlightdetailsbefandafterobjectwise(String path,String path2,String station) throws Exception{
	
long mil =System.currentTimeMillis();
String st, full,append,le,extend, extended,st2, full2;
full="";
full2="";
extended="";

	
BufferedReader br = new BufferedReader(new FileReader(path));
while ((st=br.readLine())!=null) {
    full+=st;
	  }


BufferedReader br2 = new BufferedReader(new FileReader(path2));
while ((st2=br2.readLine())!=null) {
    full2+=st2;
	  }

JSONArray jsonObj1 = new JSONArray(full);
JSONArray jsonObj2 = new JSONArray(full2);

	
	


 for (int i=0;i<jsonObj1.length();i++)
 {
	   JSONObject Testprint1 = jsonObj1.getJSONObject(i);
 		String obj1 =    jsonObj1.getJSONObject(i).toString();
	String Intermediateobject2 =obj1;
	String fltkey =  	Getvalueinresponsebeforeandafterobjectwise(full,"fltKey",i);
	String priorfltkey = Getvalueinresponsebeforeandafterobjectwise(full,"priorLegKey",i);
	System.out.println("Validating flight no::  "+i);
	   
	   for (int j=0;j<=jsonObj2.length()-1;j++)
	   {
		   JSONObject Testprint2 = jsonObj2.getJSONObject(j);
	     	String obj2 =    jsonObj2.getJSONObject(j).toString();
		String Intermediateobject22 = obj2; 
		String fltkey2 =  	Getvalueinresponsebeforeandafterobjectwise(full2,"fltKey",j);
		String priorfltkey2 = Getvalueinresponsebeforeandafterobjectwise(full2,"priorLegKey",j);   
	   
		boolean fltkeyempty = fltkey.contains("Null");
		boolean priorfltkeyempty = fltkey.contains("Null");
	   if(fltkeyempty==false)
	   {
		   if(fltkey.contains(fltkey2)){
			   Fetchandcomparebeforeandaftersereverobjectwise(full,full2,i,j,fltkey,fltkey2);
		   if(j==jsonObj2.length()-1){
			 //  test.log(LogStatus.INFO, "Reached end of searching fltkey and no key found  "+fltkey);
			   ATUReports.add("Reached end of searching fltkey and no key found  "+fltkey,  LogAs.FAILED, null);
		   }
		   break;
		   }
		   
	   }    	   
	   else
	   {
		   if(priorfltkeyempty==false)
		   {
			   if(priorfltkey.contains(priorfltkey2)){
				   Fetchandcomparebeforeandaftersereverobjectwise(full,full2,i,j,fltkey,fltkey2);
		   if(j==jsonObj2.length()-1){
			  // test.log(LogStatus.INFO, "Reached end of searching fltkey and no key found  "+fltkey);
			   ATUReports.add("Reached end of searching fltkey and no key found  "+fltkey,  LogAs.INFO, null);
		   }
		   break;
			   }
		   }
	   
	   }	
	   
	   }

   }

}


public static void Fetchandcomparebeforeandaftersereverobjectwise(String full, String full2, int i, int j, String fltKey, String fltKey2) throws Exception{

 
	try
	{
	try{
		String EqpType =  	Getvalueinresponsebeforeandafterobjectwise(full,"assignedEquipType",i);
		String EqpType2 =  	Getvalueinresponsebeforeandafterobjectwise(full2,"assignedEquipType",j);

		
		String fltNum =  	Getvalueinresponsebeforeandafterobjectwise(full,"fltNum",i);
		String fltNum2 =  	Getvalueinresponsebeforeandafterobjectwise(full2,"fltNum",j);


		String fltOrgDate =  	Getvalueinresponsebeforeandafterobjectwise(full,"fltOrgDate",i);
		String fltOrgDate2 =  	Getvalueinresponsebeforeandafterobjectwise(full2,"fltOrgDate",j);

		String depSta =  	Getvalueinresponsebeforeandafterobjectwise(full,"depSta",i);
		String depSta2 =  	Getvalueinresponsebeforeandafterobjectwise(full2,"depSta",j);

		String dupDepStaNum =  	Getvalueinresponsebeforeandafterobjectwise(full,"dupDepStaNum",i);
	//	System.out.println("dupDepStaNum::  "+dupDepStaNum);
		String dupDepStaNum2 =  Getvalueinresponsebeforeandafterobjectwise(full2,"dupDepStaNum",j);
		//System.out.println("dupDepStaNum::  "+dupDepStaNum);

		String carrierCode =  	Getvalueinresponsebeforeandafterobjectwise(full,"carrierCode",i);
		String carrierCode2 =  	Getvalueinresponsebeforeandafterobjectwise(full2,"carrierCode",j);
		
		String iata =  	Getvalueinresponsebeforeandafterobjectwise(full,"iata",i);
		String iata2 =  	Getvalueinresponsebeforeandafterobjectwise(full2,"iata",j);

		String destination =  	Getvalueinresponsebeforeandafterobjectwise(full,"destination",i);
		String destination2 =  	Getvalueinresponsebeforeandafterobjectwise(full2,"destination",j);
		
		String dupArrStaNum =  	Getvalueinresponsebeforeandafterobjectwise(full,"dupArrStaNum",i);
		String dupArrStaNum2 =  	Getvalueinresponsebeforeandafterobjectwise(full2,"dupArrStaNum",j);

		String assignedTail =  	Getvalueinresponsebeforeandafterobjectwise(full,"assignedTail",i);
		String assignedTail2 =  	Getvalueinresponsebeforeandafterobjectwise(full2,"assignedTail",j);

		String skdEquipType =  	Getvalueinresponsebeforeandafterobjectwise(full,"skdEquipType",i);
		String skdEquipType2 =  	Getvalueinresponsebeforeandafterobjectwise(full2,"skdEquipType",j);

		String assignedEquipType =  	Getvalueinresponsebeforeandafterobjectwise(full,"assignedEquipType",i);
		String assignedEquipType2 =  	Getvalueinresponsebeforeandafterobjectwise(full2,"assignedEquipType",j);

		String aircraftRegistrationNbr =  	Getvalueinresponsebeforeandafterobjectwise(full,"aircraftRegistrationNbr",i);
		String aircraftRegistrationNbr2 =  	Getvalueinresponsebeforeandafterobjectwise(full2,"aircraftRegistrationNbr",j);

		String skdTaxiOut =  	Getvalueinresponsebeforeandafterobjectwise(full,"skdTaxiOut",i);
		String skdTaxiOut2 =  	Getvalueinresponsebeforeandafterobjectwise(full2,"skdTaxiOut",j);

		String skdTaxiIn =  	Getvalueinresponsebeforeandafterobjectwise(full,"skdTaxiIn",i);
		String skdTaxiIn2 =  	Getvalueinresponsebeforeandafterobjectwise(full2,"skdTaxiIn",j);

		String latestTaxiOut =  	Getvalueinresponsebeforeandafterobjectwise(full,"latestTaxiOut",i);
		String latestTaxiOut2 =  	Getvalueinresponsebeforeandafterobjectwise(full2,"latestTaxiOut",j);

		String latestTaxiIn =  	Getvalueinresponsebeforeandafterobjectwise(full,"latestTaxiIn",i);
		String latestTaxiIn2 =  	Getvalueinresponsebeforeandafterobjectwise(full2,"latestTaxiIn",j);

		String depGMTAdjustment =  	Getvalueinresponsebeforeandafterobjectwise(full,"depGMTAdjustment",i);
		String depGMTAdjustment2 =  	Getvalueinresponsebeforeandafterobjectwise(full2,"depGMTAdjustment",j);

		String arrGMTAdjustment =  	Getvalueinresponsebeforeandafterobjectwise(full,"arrGMTAdjustment",i);
		String arrGMTAdjustment2 =  	Getvalueinresponsebeforeandafterobjectwise(full2,"arrGMTAdjustment",j);

		String mogt =  	Getvalueinresponsebeforeandafterobjectwise(full,"mogt",i);
		String mogt2 =  	Getvalueinresponsebeforeandafterobjectwise(full2,"mogt",j);

		String nextLegFltNum =  	Getvalueinresponsebeforeandafterobjectwise(full,"nextLegFltNum",i);
		String nextLegFltNum2 =  	Getvalueinresponsebeforeandafterobjectwise(full2,"nextLegFltNum",j);

		String nextLegOrgDate =  	Getvalueinresponsebeforeandafterobjectwise(full,"nextLegOrgDate",i);
		String nextLegOrgDate2 =  	Getvalueinresponsebeforeandafterobjectwise(full2,"nextLegOrgDate",j);

		String nextLegFltDupCode =  	Getvalueinresponsebeforeandafterobjectwise(full,"nextLegFltDupCode",i);
		String nextLegFltDupCode2 =  	Getvalueinresponsebeforeandafterobjectwise(full2,"nextLegFltDupCode",j);

		String nextLegCarrierCode =  	Getvalueinresponsebeforeandafterobjectwise(full,"nextLegCarrierCode",i);
		String nextLegCarrierCode2 =  	Getvalueinresponsebeforeandafterobjectwise(full2,"nextLegCarrierCode",j);

		String nextLegKey =  	Getvalueinresponsebeforeandafterobjectwise(full,"nextLegKey",i);
		String nextLegKey2 =  	Getvalueinresponsebeforeandafterobjectwise(full2,"nextLegKey",j);

		String priorLegFltNum =  	Getvalueinresponsebeforeandafterobjectwise(full,"priorLegFltNum",i);
		String priorLegFltNum2 =  	Getvalueinresponsebeforeandafterobjectwise(full2,"priorLegFltNum",j);

		String priorLegOrgDate =  	Getvalueinresponsebeforeandafterobjectwise(full,"priorLegOrgDate",i);
		String priorLegOrgDate2 =  	Getvalueinresponsebeforeandafterobjectwise(full2,"priorLegOrgDate",j);

		String priorLegFltDupCode =  	Getvalueinresponsebeforeandafterobjectwise(full,"priorLegFltDupCode",i);
		String priorLegFltDupCode2 =  	Getvalueinresponsebeforeandafterobjectwise(full2,"priorLegFltDupCode",j);

		String priorLegDepStation =  	Getvalueinresponsebeforeandafterobjectwise(full,"priorLegDepStation",i);
		String priorLegDepStation2 =  	Getvalueinresponsebeforeandafterobjectwise(full2,"priorLegDepStation",j);
		
		String priorLegCarrierCode =  	Getvalueinresponsebeforeandafterobjectwise(full,"priorLegCarrierCode",i);
		String priorLegCarrierCode2 =  	Getvalueinresponsebeforeandafterobjectwise(full2,"priorLegCarrierCode",j);

		
		String legStatus =  	Getvalueinresponsebeforeandafterobjectwise(full,"legStatus",i);
		String legStatus2 =  	Getvalueinresponsebeforeandafterobjectwise(full2,"legStatus",j);

		String depStatus =  	Getvalueinresponsebeforeandafterobjectwise(full,"depStatus",i);
		String depStatus2 =  	Getvalueinresponsebeforeandafterobjectwise(full2,"depStatus",j);

		String arrStatus =  	Getvalueinresponsebeforeandafterobjectwise(full,"arrStatus",i);
		String arrStatus2 =  	Getvalueinresponsebeforeandafterobjectwise(full2,"arrStatus",j);

		String depGate =  	Getvalueinresponsebeforeandafterobjectwise(full,"depGate",i);
		String depGate2 =  	Getvalueinresponsebeforeandafterobjectwise(full2,"depGate",j);

		String arrGate =  	Getvalueinresponsebeforeandafterobjectwise(full,"arrGate",i);
		String arrGate2 =  	Getvalueinresponsebeforeandafterobjectwise(full2,"arrGate",j);
		
		String bagclaim =  	Getvalueinresponsebeforeandafterobjectwise(full,"bagclaim",i);
		String bagclaim2 =  	Getvalueinresponsebeforeandafterobjectwise(full2,"bagclaim",j);
	
	//	String arrTerminal =  	Getvalueinresponsebeforeandafter(full,"assignedEquipType");
	//	String arrTerminal2 =  	Getvalueinresponsebeforeandafter(full2,"assignedEquipType");
		
		String intOrDom =  	Getvalueinresponsebeforeandafterobjectwise(full,"intOrDom",i);
		String intOrDom2 =  	Getvalueinresponsebeforeandafterobjectwise(full2,"intOrDom",j);

		String kickOffFlt =  	Getvalueinresponsebeforeandafterobjectwise(full,"kickOffFlt",i);
		String kickOffFlt2 =  	Getvalueinresponsebeforeandafterobjectwise(full2,"kickOffFlt",j);
		
	//	String depTerminal =  	Testprint1.getString("depTerminal");
	//	String depTerminal2 =  	Getvalueinresponsebeforeandafter(full2,"assignedEquipType");String("depTerminal");

	////////////////////////////////////////////////////////////////////////////////////////////////////////////

		String isThruFlight =  	Getvalueinresponsebeforeandafterobjectwise(full,"isThruFlight",i);
		String isThruFlight2 =  	Getvalueinresponsebeforeandafterobjectwise(full2,"isThruFlight",j);

		String getDepStatus =  	Getvalueinresponsebeforeandafterobjectwise(full,"getDepStatus",i);
		String getDepStatus2 =  	Getvalueinresponsebeforeandafterobjectwise(full2,"getDepStatus",j);

		String getArrStatus =  	Getvalueinresponsebeforeandafterobjectwise(full,"getArrStatus",i);
		String getArrStatus2 =  	Getvalueinresponsebeforeandafterobjectwise(full2,"getArrStatus",j);

		String wtRestricted =  	Getvalueinresponsebeforeandafterobjectwise(full,"wtRestricted",i);
		String wtRestricted2 =  	Getvalueinresponsebeforeandafterobjectwise(full2,"wtRestricted",j);
		
		String dispDesk =  	Getvalueinresponsebeforeandafterobjectwise(full,"dispDesk",i);
		String dispDesk2 =  	Getvalueinresponsebeforeandafterobjectwise(full2,"dispDesk",j);
		
	

		String depGateChange =  	Getvalueinresponsebeforeandafterobjectwise(full,"depGateChange",i);
		String depGateChange2 =  	Getvalueinresponsebeforeandafterobjectwise(full2,"depGateChange",j);

		String expectedTimeArrivalGMT =  	Getvalueinresponsebeforeandafterobjectwise(full,"expectedTimeArrivalGMT",i);
		String expectedTimeArrivalGMT2 =  	Getvalueinresponsebeforeandafterobjectwise(full2,"expectedTimeArrivalGMT",j);

		String scheduledTimeArrivalGMT =  	Getvalueinresponsebeforeandafterobjectwise(full,"scheduledTimeArrivalGMT",i);
		String scheduledTimeArrivalGMT2 =  	Getvalueinresponsebeforeandafterobjectwise(full2,"scheduledTimeArrivalGMT",j);

		String expectedTimeDepartureGMT =  	Getvalueinresponsebeforeandafterobjectwise(full,"expectedTimeDepartureGMT",i);
		String expectedTimeDepartureGMT2 =  	Getvalueinresponsebeforeandafterobjectwise(full2,"expectedTimeDepartureGMT",j);

		String scheduledTimeDepartureGMT =  	Getvalueinresponsebeforeandafterobjectwise(full,"scheduledTimeDepartureGMT",i);
		String scheduledTimeDepartureGMT2 =  	Getvalueinresponsebeforeandafterobjectwise(full2,"scheduledTimeDepartureGMT",j);

		String expectedTimeArrivalLocal =  	Getvalueinresponsebeforeandafterobjectwise(full,"expectedTimeArrivalLocal",i);
		String expectedTimeArrivalLocal2 =  	Getvalueinresponsebeforeandafterobjectwise(full2,"expectedTimeArrivalLocal",j);

		String scheduledTimeArrivalLocal =  	Getvalueinresponsebeforeandafterobjectwise(full,"scheduledTimeArrivalLocal",i);
		String scheduledTimeArrivalLocal2 =  	Getvalueinresponsebeforeandafterobjectwise(full2,"scheduledTimeArrivalLocal",j);

		String expectedTimeDepartureLocal =  	Getvalueinresponsebeforeandafterobjectwise(full,"expectedTimeDepartureLocal",i);
		String expectedTimeDepartureLocal2 =  	Getvalueinresponsebeforeandafterobjectwise(full2,"expectedTimeDepartureLocal",j);

		String scheduledTimeDepartureLocal =  	Getvalueinresponsebeforeandafterobjectwise(full,"scheduledTimeDepartureLocal",i);
		String scheduledTimeDepartureLocal2 =  	Getvalueinresponsebeforeandafterobjectwise(full2,"scheduledTimeDepartureLocal",j);
		
		
		String actualOnGMT =  	Getvalueinresponsebeforeandafterobjectwise(full,"actualOnGMT",i);
		String actualOnGMT2 =  	Getvalueinresponsebeforeandafterobjectwise(full2,"actualOnGMT",j);
		
	
		
		String actualOnLoc =  	Getvalueinresponsebeforeandafterobjectwise(full,"actualOnLoc",i);
		String actualOnLoc2 =  	Getvalueinresponsebeforeandafterobjectwise(full2,"actualOnLoc",j);
		
		
		String actualInGMT =  	Getvalueinresponsebeforeandafterobjectwise(full,"actualInGMT",i);
		String actualInGMT2 =  	Getvalueinresponsebeforeandafterobjectwise(full2,"actualInGMT",j);
		
	
		String actualInLoc =  	Getvalueinresponsebeforeandafterobjectwise(full,"actualInLoc",i);
		String actualInLoc2 =  	Getvalueinresponsebeforeandafterobjectwise(full2,"actualInLoc",j);
		
	
		String actualOutGMT =  	Getvalueinresponsebeforeandafterobjectwise(full,"actualOutGMT",i);
		String actualOutGMT2 =  	Getvalueinresponsebeforeandafterobjectwise(full2,"actualOutGMT",j);
		
		
		String actualOutLoc =  	Getvalueinresponsebeforeandafterobjectwise(full,"actualOutLoc",i);
		String actualOutLoc2 =  	Getvalueinresponsebeforeandafterobjectwise(full2,"actualOutLoc",j);
		
		
		String actualOffGMT =  	Getvalueinresponsebeforeandafterobjectwise(full,"actualOffGMT",i);
		String actualOffGMT2 =  	Getvalueinresponsebeforeandafterobjectwise(full2,"actualOffGMT",j);
		
		String actualOffLoc =  	Getvalueinresponsebeforeandafterobjectwise(full,"actualOffLoc",i);
		String actualOffLoc2 =  	Getvalueinresponsebeforeandafterobjectwise(full2,"actualOffLoc",j);

		

		String sourceTimeStamp =  	Getvalueinresponsebeforeandafterobjectwise(full,"sourceTimeStamp",i);
		String sourceTimeStamp2 =  	Getvalueinresponsebeforeandafterobjectwise(full2,"sourceTimeStamp",j);

		String etdUpdatedAt =  	Getvalueinresponsebeforeandafterobjectwise(full,"etdUpdatedAt",i);
		String etdUpdatedAt2 =  	Getvalueinresponsebeforeandafterobjectwise(full2,"etdUpdatedAt",j);

		String etaUpdatedAt =  	Getvalueinresponsebeforeandafterobjectwise(full,"etaUpdatedAt",i);
		String etaUpdatedAt2 =  	Getvalueinresponsebeforeandafterobjectwise(full2,"etaUpdatedAt",j);

		
		String onUpdatedAt =  	Getvalueinresponsebeforeandafterobjectwise(full,"onUpdatedAt",i);
			String onUpdatedAt2 =  	Getvalueinresponsebeforeandafterobjectwise(full2,"onUpdatedAt",j);

	
			String eonUpdatedAt =  	Getvalueinresponsebeforeandafterobjectwise(full,"eonUpdatedAt",i);
			String eonUpdatedAt2 =  	Getvalueinresponsebeforeandafterobjectwise(full2,"eonUpdatedAt",j);
		
		
		String inUpdatedAt =  	Getvalueinresponsebeforeandafterobjectwise(full,"inUpdatedAt",i);
			String inUpdatedAt2 =  	Getvalueinresponsebeforeandafterobjectwise(full2,"inUpdatedAt",j);
		
		
		
		String offUpdatedAt =  	Getvalueinresponsebeforeandafterobjectwise(full,"offUpdatedAt",i);
			String offUpdatedAt2 =  	Getvalueinresponsebeforeandafterobjectwise(full2,"offUpdatedAt",j);
		
		
		
			String etoUpdatedAt =  	Getvalueinresponsebeforeandafterobjectwise(full,"etoUpdatedAt",i);
			String etoUpdatedAt2 =  	Getvalueinresponsebeforeandafterobjectwise(full2,"etoUpdatedAt",j);
		
		
	
			String outUpdatedAt =  	Getvalueinresponsebeforeandafterobjectwise(full,"outUpdatedAt",i);
			String outUpdatedAt2 =  	Getvalueinresponsebeforeandafterobjectwise(full2,"outUpdatedAt",j);
		

			String cancelUpdatedAt =  	Getvalueinresponsebeforeandafterobjectwise(full,"cancelUpdatedAt",i);
			String cancelUpdatedAt2 =  	Getvalueinresponsebeforeandafterobjectwise(full2,"cancelUpdatedAt",j);
		

			String eqsubUpdatedAt =  	Getvalueinresponsebeforeandafterobjectwise(full,"eqsubUpdatedAt",i);
			String eqsubUpdatedAt2 =  	Getvalueinresponsebeforeandafterobjectwise(full2,"eqsubUpdatedAt",j);
		
		
			String eqlinkUpdatedAt =  	Getvalueinresponsebeforeandafterobjectwise(full,"eqlinkUpdatedAt",i);
			String eqlinkUpdatedAt2 =  	Getvalueinresponsebeforeandafterobjectwise(full2,"eqlinkUpdatedAt",j);
		
		
			String groundTimeUpdatedAt =  	Getvalueinresponsebeforeandafterobjectwise(full,"groundTimeUpdatedAt",i);
			String groundTimeUpdatedAt2 =  	Getvalueinresponsebeforeandafterobjectwise(full2,"groundTimeUpdatedAt",j);
		
		
			String gateUpdatedAt =  	Getvalueinresponsebeforeandafterobjectwise(full,"gateUpdatedAt",i);
		String gateUpdatedAt2 =  	Getvalueinresponsebeforeandafterobjectwise(full2,"gateUpdatedAt",j);
		
		String createUpdatedAt =  	Getvalueinresponsebeforeandafterobjectwise(full,"createUpdatedAt",i);
		String createUpdatedAt2 =  	Getvalueinresponsebeforeandafterobjectwise(full2,"createUpdatedAt",j);
		
		
		String cycleUpdatedAt =  	Getvalueinresponsebeforeandafterobjectwise(full,"cycleUpdatedAt",i);
		String cycleUpdatedAt2 =  	Getvalueinresponsebeforeandafterobjectwise(full2,"cycleUpdatedAt",j);
		    			
		String deleteUpdatedAt =  	Getvalueinresponsebeforeandafterobjectwise(full,"deleteUpdatedAt",i);
		String deleteUpdatedAt2 =  	Getvalueinresponsebeforeandafterobjectwise(full2,"deleteUpdatedAt",j);
		
	
		String continuationUpdatedAt =  	Getvalueinresponsebeforeandafterobjectwise(full,"continuationUpdatedAt",i);
		String continuationUpdatedAt2	 =  	Getvalueinresponsebeforeandafterobjectwise(full2,"continuationUpdatedAt",j);
		
		
	
		String reinstateUpdatedAt =  	Getvalueinresponsebeforeandafterobjectwise(full,"reinstateUpdatedAt",i);
		String reinstateUpdatedAt2 =  	Getvalueinresponsebeforeandafterobjectwise(full2,"reinstateUpdatedAt",j);
	
		String diversionUpdatedAt =  	Getvalueinresponsebeforeandafterobjectwise(full,"diversionUpdatedAt",i);
		String diversionUpdatedAt2 =  	Getvalueinresponsebeforeandafterobjectwise(full2,"diversionUpdatedAt",j);
	
		String returnUpdatedAt =  	Getvalueinresponsebeforeandafterobjectwise(full,"returnUpdatedAt",i);
		String returnUpdatedAt2 =  	Getvalueinresponsebeforeandafterobjectwise(full2,"returnUpdatedAt",j);
	
		String decisionUpdatedAt =  	Getvalueinresponsebeforeandafterobjectwise(full,"returnUpdatedAt",i);
		String decisionUpdatedAt2 =  	Getvalueinresponsebeforeandafterobjectwise(full2,"returnUpdatedAt",j);

		
		String rtdUpdatedAt =  	Getvalueinresponsebeforeandafterobjectwise(full,"rtdUpdatedAt",i);
		String rtdUpdatedAt2 =  	Getvalueinresponsebeforeandafterobjectwise(full2,"rtdUpdatedAt",j);
		
		
		String crewUpdatedAt =  	Getvalueinresponsebeforeandafterobjectwise(full,"crewUpdatedAt",i);
		String crewUpdatedAt2 =  	Getvalueinresponsebeforeandafterobjectwise(full2,"crewUpdatedAt",j);
		
	
		String fuelSlipUpdatedAt =  	Getvalueinresponsebeforeandafterobjectwise(full,"fuelSlipUpdatedAt",i);
		String fuelSlipUpdatedAt2 =  	Getvalueinresponsebeforeandafterobjectwise(full2,"fuelSlipUpdatedAt",j);
		
		

		
	try{
		
		if(EqpType.contains(EqpType2))
		{
		
		}else{
			System.out.println(fltKey2+"EqpType Fail :  " +EqpType+"   "+EqpType2+"  --------- "+fltKey);
			//test.log(LogStatus.FAIL, "EqpType   Fail :  " +EqpType+"   "+EqpType2+"  --------- "+fltKey);
			 ATUReports.add("EqpType   Fail :  " +EqpType+"   "+EqpType2+"  --------- "+fltKey,  LogAs.FAILED, null);
		}
		
		
		

		
	
		if(fltNum.contains(fltNum2))
		{
		
		}else{
			System.out.println(fltKey2+"fltNum  Fail :  " +fltNum+"   "+fltNum2+"  --------- "+fltKey);
			//test.log(LogStatus.FAIL,"fltNum  Fail :  " +fltNum+"   "+fltNum2+"  --------- "+fltKey);
			 ATUReports.add("fltNum  Fail :  " +fltNum+"   "+fltNum2+"  --------- "+fltKey,  LogAs.FAILED, null);
		}
		
	
		if(fltOrgDate.contains(fltOrgDate2))
		{
		
		}else{
			System.out.println(fltKey2+"fltOrgDate  Fail :  " +fltOrgDate+"   "+fltOrgDate2+"  --------- "+fltKey);
			//test.log(LogStatus.FAIL,"fltOrgDate  Fail :  " +fltOrgDate+"   "+fltOrgDate2+"  --------- "+fltKey);
			 ATUReports.add("fltOrgDate  Fail :  " +fltOrgDate+"   "+fltOrgDate2+"  --------- "+fltKey,  LogAs.FAILED, null);
		}
		
	
		if(depSta.contains(depSta2))
		{
		
		}else{
			System.out.println(fltKey2+"depSta  Fail :  " +depSta+"   "+depSta2+"  --------- "+fltKey);
			//test.log(LogStatus.FAIL,"depSta  Fail :  " +depSta+"   "+depSta2+"  --------- "+fltKey);
			 ATUReports.add("depSta  Fail :  " +depSta+"   "+depSta2+"  --------- "+fltKey,  LogAs.FAILED, null);
		}
		
	
		if(dupDepStaNum.equalsIgnoreCase(dupDepStaNum2))
		{
		
		}else{
			System.out.println(fltKey2+"dupDepStaNum  Fail :  " +dupDepStaNum+"   "+dupDepStaNum2+"  --------- "+fltKey);
			//test.log(LogStatus.FAIL, "dupDepStaNum  Fail :  " +dupDepStaNum+"   "+dupDepStaNum2+"  --------- "+fltKey);
			 ATUReports.add("dupDepStaNum  Fail :  " +dupDepStaNum+"   "+dupDepStaNum2+"  --------- "+fltKey,  LogAs.FAILED, null);
		}
		
	
		if(carrierCode.contains(carrierCode2))
		{
		
		}else{
			System.out.println(fltKey2+"carrierCode  Fail :  " +carrierCode+"   "+carrierCode2+"  --------- "+fltKey);
			//test.log(LogStatus.FAIL,"carrierCode  Fail :  " +carrierCode+"   "+carrierCode2+"  --------- "+fltKey);
			 ATUReports.add("carrierCode  Fail :  " +carrierCode+"   "+carrierCode2+"  --------- "+fltKey,  LogAs.FAILED, null);
		}
		
	
		if(iata.contains(iata2))
		{
		
		}else{
			System.out.println(fltKey2+"iata  Fail :  " +iata+"   "+iata2+"  --------- "+fltKey);
			//test.log(LogStatus.FAIL,"iata  Fail :  " +iata+"   "+iata2+"  --------- "+fltKey);
			 ATUReports.add("iata  Fail :  " +iata+"   "+iata2+"  --------- "+fltKey,  LogAs.FAILED, null);
		}
		
	
		if(destination.contains(destination2))
		{
		
		}else{
			System.out.println(fltKey2+"destination  Fail :  " +destination+"   "+destination2+"  --------- "+fltKey);
			//test.log(LogStatus.FAIL,"destination  Fail :  " +destination+"   "+destination2+"  --------- "+fltKey);
			 ATUReports.add("destination  Fail :  " +destination+"   "+destination2+"  --------- "+fltKey,  LogAs.FAILED, null);
		}
		
	
		if(dupArrStaNum.contains(dupArrStaNum2))
		{
		
		}else{
			System.out.println(fltKey2+" dupArrStaNum Fail :  " +dupArrStaNum+"   "+dupArrStaNum2+"  --------- "+fltKey);
		//	test.log(LogStatus.FAIL, " dupArrStaNum Fail :  " +dupArrStaNum+"   "+dupArrStaNum2+"  --------- "+fltKey);
			 ATUReports.add(" dupArrStaNum Fail :  " +dupArrStaNum+"   "+dupArrStaNum2+"  --------- "+fltKey,  LogAs.FAILED, null);
		}
		
	
		if(assignedTail .contains(assignedTail2))
		{
		
		}else{
			System.out.println(fltKey2+"assignedTail  Fail :  " +assignedTail+"   "+assignedTail2+"  --------- "+fltKey);
		//	test.log(LogStatus.FAIL,"assignedTail  Fail :  " +assignedTail+"   "+assignedTail2+"  --------- "+fltKey);
			 ATUReports.add("assignedTail  Fail :  " +assignedTail+"   "+assignedTail2+"  --------- "+fltKey,  LogAs.FAILED, null);
		}
		
	
		if(skdEquipType.contains(skdEquipType2))
		{
		
		}else{
			System.out.println(fltKey2+"skdEquipType  Fail :  " +skdEquipType+"   "+skdEquipType2+"  --------- "+fltKey);
			//test.log(LogStatus.FAIL,"skdEquipType  Fail :  " +skdEquipType+"   "+skdEquipType2+"  --------- "+fltKey);
			 ATUReports.add("skdEquipType  Fail :  " +skdEquipType+"   "+skdEquipType2+"  --------- "+fltKey,  LogAs.INFO, null);
		}
		
	
		if(assignedEquipType.contains(assignedEquipType2))
		{
		
		}else{
			System.out.println(fltKey2+"assignedEquipType  Fail :  " +assignedEquipType+"   "+assignedEquipType2+"  --------- "+fltKey);
			//test.log(LogStatus.FAIL,"assignedEquipType  Fail :  " +assignedEquipType+"   "+assignedEquipType2+"  --------- "+fltKey);
			 ATUReports.add("assignedEquipType  Fail :  " +assignedEquipType+"   "+assignedEquipType2+"  --------- "+fltKey,  LogAs.FAILED, null);
		}
		
	
		if(aircraftRegistrationNbr.contains(aircraftRegistrationNbr2))
		{
		
		}else{
			System.out.println(fltKey2+"aircraftRegistrationNbr  Fail :  " +aircraftRegistrationNbr+"   "+aircraftRegistrationNbr2+"  --------- "+fltKey);
			//test.log(LogStatus.FAIL,"aircraftRegistrationNbr  Fail :  " +aircraftRegistrationNbr+"   "+aircraftRegistrationNbr2+"  --------- "+fltKey);
			 ATUReports.add("aircraftRegistrationNbr  Fail :  " +aircraftRegistrationNbr+"   "+aircraftRegistrationNbr2+"  --------- "+fltKey,  LogAs.FAILED, null);
		}
		
	
		if(skdTaxiOut.equalsIgnoreCase(skdTaxiOut2))
		{
		
		}else{
			System.out.println(fltKey2+"skdTaxiOut  Fail :  " +skdTaxiOut+"   "+skdTaxiOut2+"  --------- "+fltKey);
		//	test.log(LogStatus.FAIL,"skdTaxiOut  Fail :  " +skdTaxiOut+"   "+skdTaxiOut2+"  --------- "+fltKey);
			 ATUReports.add("skdTaxiOut  Fail :  " +skdTaxiOut+"   "+skdTaxiOut2+"  --------- "+fltKey,  LogAs.FAILED, null);
		}
		
	
		if(skdTaxiIn.equalsIgnoreCase(skdTaxiIn2))
		{
		
		}else{
			System.out.println(fltKey2+"skdTaxiIn  Fail :  " +skdTaxiIn+"   "+skdTaxiIn2+"  --------- "+fltKey);
			//test.log(LogStatus.FAIL,"skdTaxiIn  Fail :  " +skdTaxiIn+"   "+skdTaxiIn2+"  --------- "+fltKey);
			 ATUReports.add("skdTaxiIn  Fail :  " +skdTaxiIn+"   "+skdTaxiIn2+"  --------- "+fltKey,  LogAs.FAILED, null);
		}
		
	
		if(latestTaxiOut.equalsIgnoreCase(latestTaxiOut2))
		{
		
		}else{
			System.out.println(fltKey2+"latestTaxiOut  Fail :  " +latestTaxiOut+"   "+latestTaxiOut2+"  --------- "+fltKey);
		//	test.log(LogStatus.FAIL,"latestTaxiOut  Fail :  " +latestTaxiOut+"   "+latestTaxiOut2+"  --------- "+fltKey);
			 ATUReports.add("latestTaxiOut  Fail :  " +latestTaxiOut+"   "+latestTaxiOut2+"  --------- "+fltKey,  LogAs.FAILED, null);
		}
		
	
   		
	
		if(latestTaxiIn.equalsIgnoreCase(latestTaxiIn2))
		{
		
		}else{
			System.out.println(fltKey2+"latestTaxiIn  Fail :  " +latestTaxiIn+"   "+latestTaxiIn2+"  --------- "+fltKey);
			//test.log(LogStatus.FAIL,"latestTaxiIn  Fail :  " +latestTaxiIn+"   "+latestTaxiIn2+"  --------- "+fltKey);
			 ATUReports.add("latestTaxiIn  Fail :  " +latestTaxiIn+"   "+latestTaxiIn2+"  --------- "+fltKey,  LogAs.INFO, null);
		}
		
		
		
	
		if(depGMTAdjustment.contains(depGMTAdjustment2))
		{
		
		}else{
			System.out.println(fltKey2+"depGMTAdjustment  Fail :  " +depGMTAdjustment+"   "+depGMTAdjustment2+"  --------- "+fltKey);
		//	test.log(LogStatus.FAIL,"depGMTAdjustment  Fail :  " +depGMTAdjustment+"   "+depGMTAdjustment2+"  --------- "+fltKey);
			 ATUReports.add("depGMTAdjustment  Fail :  " +depGMTAdjustment+"   "+depGMTAdjustment2+"  --------- "+fltKey,  LogAs.FAILED, null);
		}
		
	
		if(arrGMTAdjustment.contains(arrGMTAdjustment2))
		{
		
		}else{
			System.out.println(fltKey2+"arrGMTAdjustment  Fail :  " +EqpType+"   "+arrGMTAdjustment2+"  --------- "+fltKey);
		//	test.log(LogStatus.FAIL,"arrGMTAdjustment  Fail :  " +EqpType+"   "+arrGMTAdjustment2+"  --------- "+fltKey);
			 ATUReports.add("arrGMTAdjustment  Fail :  " +EqpType+"   "+arrGMTAdjustment2+"  --------- "+fltKey,  LogAs.FAILED, null);
		}
		
	
		if(mogt.equalsIgnoreCase(mogt2))
		{
		
		}else{
			System.out.println(fltKey2+"mogt  Fail :  " +mogt+"   "+mogt2+"  --------- "+fltKey);
			//test.log(LogStatus.FAIL,"mogt  Fail :  " +mogt+"   "+mogt2+"  --------- "+fltKey);
			 ATUReports.add("mogt  Fail :  " +mogt+"   "+mogt2+"  --------- "+fltKey,  LogAs.FAILED, null);
		}
		
	
		if(nextLegFltNum.contains(nextLegFltNum2))
		{
		
		}else{
			System.out.println(fltKey2+"nextLegFltNum  Fail :  " +nextLegFltNum+"   "+nextLegFltNum2+"  --------- "+fltKey);
		//	test.log(LogStatus.FAIL,"nextLegFltNum  Fail :  " +nextLegFltNum+"   "+nextLegFltNum2+"  --------- "+fltKey);
			 ATUReports.add("nextLegFltNum  Fail :  " +nextLegFltNum+"   "+nextLegFltNum2+"  --------- "+fltKey,  LogAs.FAILED, null);
		}
		
	
		if(nextLegOrgDate.contains(nextLegOrgDate2))
		{
		
		}else{
			System.out.println(fltKey2+"nextLegOrgDate  Fail :  " +nextLegOrgDate+"   "+nextLegOrgDate2+"  --------- "+fltKey);
			//test.log(LogStatus.FAIL,"nextLegOrgDate  Fail :  " +nextLegOrgDate+"   "+nextLegOrgDate2+"  --------- "+fltKey);
			 ATUReports.add("nextLegOrgDate  Fail :  " +nextLegOrgDate+"   "+nextLegOrgDate2+"  --------- "+fltKey,  LogAs.FAILED, null);
		}
		
	
		if(nextLegFltDupCode.contains(nextLegFltDupCode2))
		{
		
		}else{
			System.out.println(fltKey2+"nextLegFltDupCode  Fail :  " +nextLegFltDupCode+"   "+nextLegFltDupCode2+"  --------- "+fltKey);
			//test.log(LogStatus.FAIL,"nextLegFltDupCode  Fail :  " +nextLegFltDupCode+"   "+nextLegFltDupCode2+"  --------- "+fltKey);
			 ATUReports.add("nextLegFltDupCode  Fail :  " +nextLegFltDupCode+"   "+nextLegFltDupCode2+"  --------- "+fltKey,  LogAs.FAILED, null);
		}
		
	
		if(nextLegCarrierCode .contains(nextLegCarrierCode2))
		{
		
		}else{
			System.out.println(fltKey2+"nextLegCarrierCode  Fail :  " +nextLegCarrierCode +"   "+nextLegCarrierCode2+"  --------- "+fltKey);
		//	test.log(LogStatus.FAIL,"nextLegCarrierCode  Fail :  " +nextLegCarrierCode +"   "+nextLegCarrierCode2+"  --------- "+fltKey);
			 ATUReports.add("nextLegCarrierCode  Fail :  " +nextLegCarrierCode +"   "+nextLegCarrierCode2+"  --------- "+fltKey,  LogAs.FAILED, null);
		}
		
	
		if(nextLegKey.contains(nextLegKey2))
		{
		
		}else{
			System.out.println(fltKey2+"nextLegKey  Fail :  " +nextLegKey+"   "+nextLegKey2+"  --------- "+fltKey);
		//	test.log(LogStatus.FAIL, "nextLegKey  Fail :  " +nextLegKey+"   "+nextLegKey2+"  --------- "+fltKey);
			 ATUReports.add("nextLegKey  Fail :  " +nextLegKey+"   "+nextLegKey2+"  --------- "+fltKey,  LogAs.FAILED, null);
		}
		
	
		if(priorLegFltNum.contains(priorLegFltNum2))
		{
		
		}else{
			System.out.println(fltKey2+"priorLegFltNum  Fail :  " +priorLegFltNum+"   "+priorLegFltNum2+"  --------- "+fltKey);
			//test.log(LogStatus.FAIL,"priorLegFltNum  Fail :  " +priorLegFltNum+"   "+priorLegFltNum2+"  --------- "+fltKey);
			 ATUReports.add("priorLegFltNum  Fail :  " +priorLegFltNum+"   "+priorLegFltNum2+"  --------- "+fltKey,  LogAs.FAILED, null);
		}
		
	
		if(priorLegOrgDate.contains(priorLegOrgDate2))
		{
		
		}else{
			System.out.println(fltKey2+"priorLegOrgDate  Fail :  " +priorLegOrgDate+"   "+priorLegOrgDate2+"  --------- "+fltKey);
			//test.log(LogStatus.FAIL,"priorLegOrgDate  Fail :  " +priorLegOrgDate+"   "+priorLegOrgDate2+"  --------- "+fltKey);
			 ATUReports.add("priorLegOrgDate  Fail :  " +priorLegOrgDate+"   "+priorLegOrgDate2+"  --------- "+fltKey,  LogAs.FAILED, null);
		}
		
	
		if(priorLegFltDupCode.contains(priorLegFltDupCode2))
		{
		
		}else{
			System.out.println(fltKey2+"priorLegFltDupCode  Fail :  " +priorLegFltDupCode2+"   "+priorLegFltDupCode2+"  --------- "+fltKey);
			//test.log(LogStatus.FAIL,"priorLegFltDupCode  Fail :  " +priorLegFltDupCode2+"   "+priorLegFltDupCode2+"  --------- "+fltKey);
			 ATUReports.add("priorLegFltDupCode  Fail :  " +priorLegFltDupCode2+"   "+priorLegFltDupCode2+"  --------- "+fltKey,  LogAs.FAILED, null);
		}
		
	
		if(priorLegDepStation.contains(priorLegDepStation2))
		{
		
		}else{
			System.out.println(fltKey2+"priorLegDepStation  Fail :  " +priorLegDepStation+"   "+priorLegDepStation2+"  --------- "+fltKey);
		//	test.log(LogStatus.FAIL, "priorLegDepStation  Fail :  " +priorLegDepStation+"   "+priorLegDepStation2+"  --------- "+fltKey);
			 ATUReports.add("priorLegDepStation  Fail :  " +priorLegDepStation+"   "+priorLegDepStation2+"  --------- "+fltKey,  LogAs.FAILED, null);
		}
		
	
		if(priorLegCarrierCode.contains(priorLegCarrierCode2))
		{
		
		}else{
			System.out.println(fltKey2+"priorLegCarrierCode  Fail :  " +priorLegCarrierCode+"   "+priorLegCarrierCode2+"  --------- "+fltKey);
			//test.log(LogStatus.FAIL, "priorLegCarrierCode  Fail :  " +priorLegCarrierCode+"   "+priorLegCarrierCode2+"  --------- "+fltKey);
			 ATUReports.add("priorLegCarrierCode  Fail :  " +priorLegCarrierCode+"   "+priorLegCarrierCode2+"  --------- "+fltKey,  LogAs.FAILED, null);
		}
		
	
		
		
	
		if(legStatus.contains(legStatus2))
		{
		
		}else{
			System.out.println(fltKey2+"legStatus  Fail :  " +legStatus+"   "+legStatus2+"  --------- "+fltKey);
			//test.log(LogStatus.FAIL,"legStatus  Fail :  " +legStatus+"   "+legStatus2+"  --------- "+fltKey);
			 ATUReports.add("legStatus  Fail :  " +legStatus+"   "+legStatus2+"  --------- "+fltKey,  LogAs.FAILED, null);
		}
		
	
		if(depStatus.contains(depStatus2))
		{
		
		}else{
			System.out.println(fltKey2+"depStatus  Fail :  " +depStatus+"   "+depStatus2+"  --------- "+fltKey);
		//	test.log(LogStatus.FAIL,"depStatus  Fail :  " +depStatus+"   "+depStatus2+"  --------- "+fltKey);
			 ATUReports.add("depStatus  Fail :  " +depStatus+"   "+depStatus2+"  --------- "+fltKey,  LogAs.FAILED, null);
		}
		
	
		if(arrStatus.contains(arrStatus2))
		{
		
		}else{
			System.out.println(fltKey2+"arrStatus Fail :  " +arrStatus+"   "+arrStatus2+"  --------- "+fltKey);
		//	test.log(LogStatus.FAIL,"arrStatus Fail :  " +arrStatus+"   "+arrStatus2+"  --------- "+fltKey);
			 ATUReports.add("arrStatus Fail :  " +arrStatus+"   "+arrStatus2+"  --------- "+fltKey,  LogAs.FAILED, null);
		}
		
	
		if(depGate.contains(depGate2))
		{
		
		}else{
			System.out.println(fltKey2+"depGate  Fail :  " +depGate+"   "+depGate2+"  --------- "+fltKey);
			//test.log(LogStatus.FAIL, "depGate  Fail :  " +depGate+"   "+depGate2+"  --------- "+fltKey);
			 ATUReports.add("depGate  Fail :  " +depGate+"   "+depGate2+"  --------- "+fltKey,  LogAs.FAILED, null);
		}
		
	
		if(arrGate.contains(arrGate2))
		{
		
		}else{
			System.out.println(fltKey2+"arrGate  Fail :  " +arrGate+"   "+arrGate2+"  --------- "+fltKey);
			//test.log(LogStatus.FAIL,"arrGate  Fail :  " +arrGate+"   "+arrGate2+"  --------- "+fltKey);
			 ATUReports.add("arrGate  Fail :  " +arrGate+"   "+arrGate2+"  --------- "+fltKey,  LogAs.FAILED, null);
		}
		
		if(bagclaim.contains(bagclaim2))
		{
		
		}else{
			System.out.println(fltKey2+"bagclaim  Fail :  " +bagclaim+"   "+bagclaim2+"  --------- "+fltKey);
			//test.log(LogStatus.FAIL,"bagclaim  Fail :  " +bagclaim+"   "+bagclaim2+"  --------- "+fltKey);
			 ATUReports.add("bagclaim  Fail :  " +bagclaim+"   "+bagclaim2+"  --------- "+fltKey,  LogAs.FAILED, null);
		}
	
		
//		if(arrTerminal.contains(arrTerminal2))
//		{
//		
//		}else{
//			System.out.println("arrTerminal  Fail :  " +arrTerminal+"   "+arrTerminal2+"  --------- "+fltKey);
//			test.log(LogStatus.FAIL, "arrTerminal  Fail :  " +arrTerminal+"   "+arrTerminal2+"  --------- "+fltKey);
//		}
		
		if(intOrDom.contains(intOrDom2))
		{
		
		}else{
			System.out.println(fltKey2+"intOrDom  Fail :  " +intOrDom+"   "+intOrDom2+"  --------- "+fltKey);
		//	test.log(LogStatus.FAIL, "intOrDom  Fail :  " +intOrDom+"   "+intOrDom2+"  --------- "+fltKey);
			 ATUReports.add("intOrDom  Fail :  " +intOrDom+"   "+intOrDom2+"  --------- "+fltKey,  LogAs.FAILED, null);
		}
		
		
		
		
		if(kickOffFlt.contains(kickOffFlt2))
		{
		
		}else{
			System.out.println(fltKey2+"kickOffFlt  Fail :  " +kickOffFlt+"   "+kickOffFlt2+"  --------- "+fltKey);
			//test.log(LogStatus.FAIL,"kickOffFlt  Fail :  " +kickOffFlt+"   "+kickOffFlt2+"  --------- "+fltKey);
			 ATUReports.add("kickOffFlt  Fail :  " +kickOffFlt+"   "+kickOffFlt2+"  --------- "+fltKey,  LogAs.FAILED, null);
		}
		

	
		if(getDepStatus.contains(getDepStatus2))
		{
		
		}else{
			System.out.println(fltKey2+"getDepStatus  Fail :  " +getDepStatus+"   "+getDepStatus2+"  --------- "+fltKey);
			//test.log(LogStatus.FAIL, "getDepStatus  Fail :  " +getDepStatus+"   "+getDepStatus2+"  --------- "+fltKey);
			 ATUReports.add("getDepStatus  Fail :  " +getDepStatus+"   "+getDepStatus2+"  --------- "+fltKey,  LogAs.FAILED, null);
		}
		
		

		
		if(getArrStatus.contains(getArrStatus2))
		{
		
		}else{
			System.out.println(fltKey2+"getArrStatus  Fail :  " +getArrStatus+"   "+getArrStatus2+"  --------- "+fltKey);
			//test.log(LogStatus.FAIL,"getArrStatus  Fail :  " +getArrStatus+"   "+getArrStatus2+"  --------- "+fltKey);
			 ATUReports.add("getArrStatus  Fail :  " +getArrStatus+"   "+getArrStatus2+"  --------- "+fltKey,  LogAs.FAILED, null);
		}
		
		
		if(wtRestricted.equalsIgnoreCase(wtRestricted2))
		{
		
		}else{
			System.out.println(fltKey2+"wtRestricted  Fail :  " +wtRestricted+"   "+wtRestricted2+"  --------- "+fltKey);
			//test.log(LogStatus.FAIL, "wtRestricted  Fail :  " +wtRestricted+"   "+wtRestricted2+"  --------- "+fltKey);
			 ATUReports.add("wtRestricted  Fail :  " +wtRestricted+"   "+wtRestricted2+"  --------- "+fltKey,  LogAs.FAILED, null);
		}
		
		

		if(dispDesk.contains(dispDesk2))
		{
		
		}else{
			System.out.println(fltKey2+"dispDesk  Fail :  " +dispDesk+"   "+dispDesk2+"  --------- "+fltKey);
			//test.log(LogStatus.FAIL, "dispDesk  Fail :  " +dispDesk+"   "+dispDesk2+"  --------- "+fltKey);
			 ATUReports.add("dispDesk  Fail :  " +dispDesk+"   "+dispDesk2+"  --------- "+fltKey,  LogAs.FAILED, null);
		}
		
	
		
		if(depGateChange.equalsIgnoreCase(depGateChange2))
		{
		
		}else{
			System.out.println(fltKey2+"depGateChange  Fail :  " +depGateChange+"   "+depGateChange2+"  --------- "+fltKey);
			//test.log(LogStatus.FAIL, "depGateChange  Fail :  " +depGateChange+"   "+depGateChange2+"  --------- "+fltKey);
			 ATUReports.add("depGateChange  Fail :  " +depGateChange+"   "+depGateChange2+"  --------- "+fltKey,  LogAs.FAILED, null);
		}
		
		if(expectedTimeArrivalGMT.equalsIgnoreCase(expectedTimeArrivalGMT2))
		{
		
		}else{
			System.out.println(fltKey2+"expectedTimeArrivalGMT  Fail :  " +expectedTimeArrivalGMT+"   "+expectedTimeArrivalGMT2+"  --------- "+fltKey);
		//	test.log(LogStatus.FAIL,"expectedTimeArrivalGMT  Fail :  " +expectedTimeArrivalGMT+"   "+expectedTimeArrivalGMT2+"  --------- "+fltKey);
			 ATUReports.add("expectedTimeArrivalGMT  Fail :  " +expectedTimeArrivalGMT+"   "+expectedTimeArrivalGMT2+"  --------- "+fltKey,  LogAs.FAILED, null);
		}
		
		if(scheduledTimeArrivalGMT.equalsIgnoreCase(scheduledTimeArrivalGMT2))
		{
		
		}else{
			System.out.println(fltKey2+"scheduledTimeArrivalGMT  Fail :  " +scheduledTimeArrivalGMT+"   "+scheduledTimeArrivalGMT2+"  --------- "+fltKey);
			//test.log(LogStatus.FAIL,"scheduledTimeArrivalGMT  Fail :  " +scheduledTimeArrivalGMT+"   "+scheduledTimeArrivalGMT2+"  --------- "+fltKey);
			 ATUReports.add(fltKey2+"scheduledTimeArrivalGMT  Fail :  " +scheduledTimeArrivalGMT+"   "+scheduledTimeArrivalGMT2+"  --------- "+fltKey,  LogAs.FAILED, null);
		}
		

		
		if(expectedTimeDepartureGMT.equalsIgnoreCase(expectedTimeDepartureGMT2))
		{
		
		}else{
			System.out.println(fltKey2+"expectedTimeDepartureGMT  Fail :  " +expectedTimeDepartureGMT+"   "+expectedTimeDepartureGMT2+"  --------- "+fltKey);
		//	test.log(LogStatus.FAIL, "expectedTimeDepartureGMT  Fail :  " +expectedTimeDepartureGMT+"   "+expectedTimeDepartureGMT2+"  --------- "+fltKey);
			 ATUReports.add("expectedTimeDepartureGMT  Fail :  " +expectedTimeDepartureGMT+"   "+expectedTimeDepartureGMT2+"  --------- "+fltKey,  LogAs.FAILED, null);
		}
		
		
		
		
		if(scheduledTimeDepartureGMT.equalsIgnoreCase(scheduledTimeDepartureGMT2))
		{
		
		}else{
			System.out.println(fltKey2+"scheduledTimeDepartureGMT  Fail :  " +scheduledTimeDepartureGMT+"   "+scheduledTimeDepartureGMT2+"  --------- "+fltKey);
			//test.log(LogStatus.FAIL,"scheduledTimeDepartureGMT  Fail :  " +scheduledTimeDepartureGMT+"   "+scheduledTimeDepartureGMT2+"  --------- "+fltKey);
			 ATUReports.add("scheduledTimeDepartureGMT  Fail :  " +scheduledTimeDepartureGMT+"   "+scheduledTimeDepartureGMT2+"  --------- "+fltKey,  LogAs.FAILED, null);
		}
		
		
			if(expectedTimeArrivalLocal.equalsIgnoreCase(expectedTimeArrivalLocal2))
		{
		
		}else{
			System.out.println(fltKey2+"expectedTimeArrivalLocal  Fail :  " +expectedTimeArrivalLocal+"   "+expectedTimeArrivalLocal2+"  --------- "+fltKey);
			//test.log(LogStatus.FAIL, "expectedTimeArrivalLocal  Fail :  " +expectedTimeArrivalLocal+"   "+expectedTimeArrivalLocal2+"  --------- "+fltKey);
			 ATUReports.add( "expectedTimeArrivalLocal  Fail :  " +expectedTimeArrivalLocal+"   "+expectedTimeArrivalLocal2+"  --------- "+fltKey,  LogAs.FAILED, null);
		}
		
		
		if(scheduledTimeArrivalLocal.equalsIgnoreCase(scheduledTimeArrivalLocal2))
		{
		
		}else{
			System.out.println(fltKey2+"scheduledTimeArrivalLocal  Fail :  " +scheduledTimeArrivalLocal+"   "+scheduledTimeArrivalLocal2+"  --------- "+fltKey);
			//test.log(LogStatus.FAIL, "scheduledTimeArrivalLocal  Fail :  " +scheduledTimeArrivalLocal+"   "+scheduledTimeArrivalLocal2+"  --------- "+fltKey);
			ATUReports.add("scheduledTimeArrivalLocal  Fail :  " +scheduledTimeArrivalLocal+"   "+scheduledTimeArrivalLocal2+"  --------- "+fltKey,  LogAs.FAILED, null);
		}
	
		
		if(expectedTimeDepartureLocal.equalsIgnoreCase(expectedTimeDepartureLocal2))
		{
		
		}else{
			System.out.println(fltKey2+"expectedTimeDepartureLocal  Fail :  " +expectedTimeDepartureLocal+"   "+expectedTimeDepartureLocal2+"  --------- "+fltKey);
		//	test.log(LogStatus.FAIL, "expectedTimeDepartureLocal  Fail :  " +expectedTimeDepartureLocal+"   "+expectedTimeDepartureLocal2+"  --------- "+fltKey);
			ATUReports.add("expectedTimeDepartureLocal  Fail :  " +expectedTimeDepartureLocal+"   "+expectedTimeDepartureLocal2+"  --------- "+fltKey,  LogAs.FAILED, null);
		}
		
		if(scheduledTimeDepartureLocal.equalsIgnoreCase(scheduledTimeDepartureLocal2))
		{
		
		}else{
			System.out.println(fltKey2+"scheduledTimeDepartureLocal  Fail :  " +scheduledTimeDepartureLocal+"   "+scheduledTimeDepartureLocal2+"  --------- "+fltKey);
		//	test.log(LogStatus.FAIL,"scheduledTimeDepartureLocal  Fail :  " +scheduledTimeDepartureLocal+"   "+scheduledTimeDepartureLocal2+"  --------- "+fltKey);
			ATUReports.add("scheduledTimeDepartureLocal  Fail :  " +scheduledTimeDepartureLocal+"   "+scheduledTimeDepartureLocal2+"  --------- "+fltKey,  LogAs.FAILED, null);
		}

	
		if(actualOnGMT.equalsIgnoreCase(actualOnGMT2))
		{
		
		}else{
			System.out.println(fltKey2+"actualOnGMT  Fail :  " +actualOnGMT+"   "+actualOnGMT2+"  --------- "+fltKey);
			//test.log(LogStatus.FAIL,"actualOnGMT  Fail :  " +actualOnGMT+"   "+actualOnGMT2+"  --------- "+fltKey);
			ATUReports.add("actualOnGMT  Fail :  " +actualOnGMT+"   "+actualOnGMT2+"  --------- "+fltKey,  LogAs.FAILED, null);
			
		}
	
		if(actualOnLoc.equalsIgnoreCase(actualOnLoc2))
		{
		
		}else{
			System.out.println(fltKey2+"actualOnLoc  Fail :  " +actualOnLoc+"   "+actualOnLoc2+"  --------- "+fltKey);
		//	test.log(LogStatus.FAIL, "actualOnLoc  Fail :  " +actualOnLoc+"   "+actualOnLoc2+"  --------- "+fltKey);
			ATUReports.add("actualOnLoc  Fail :  " +actualOnLoc+"   "+actualOnLoc2+"  --------- "+fltKey,  LogAs.FAILED, null);
		}

		if(actualInGMT.equalsIgnoreCase(actualInGMT2))
		{
		
		}else{
			System.out.println(fltKey2+"actualInGMT  Fail :  " +actualInGMT+"   "+actualInGMT2+"  --------- "+fltKey);
			//test.log(LogStatus.FAIL,"actualInGMT  Fail :  " +actualInGMT+"   "+actualInGMT2+"  --------- "+fltKey);
			ATUReports.add("actualInGMT  Fail :  " +actualInGMT+"   "+actualInGMT2+"  --------- "+fltKey,  LogAs.FAILED, null);
		}
	
		if(actualInLoc.equalsIgnoreCase(actualInLoc2))
		{
		
		}else{
			System.out.println(fltKey2+"actualInLoc  Fail :  " +actualInLoc+"   "+actualInLoc2+"  --------- "+fltKey);
			//test.log(LogStatus.FAIL,"actualInLoc  Fail :  " +actualInLoc+"   "+actualInLoc2+"  --------- "+fltKey);
			ATUReports.add("actualInLoc  Fail :  " +actualInLoc+"   "+actualInLoc2+"  --------- "+fltKey,  LogAs.FAILED, null);
		}
	
		
		if(actualOutGMT.equalsIgnoreCase(actualOutGMT2))
		{
		
		}else{
			System.out.println(fltKey2+"actualOutGMT  Fail :  " +actualOutGMT+"   "+actualOutGMT2+"  --------- "+fltKey);
			//test.log(LogStatus.FAIL,"actualOutGMT  Fail :  " +actualOutGMT+"   "+actualOutGMT2+"  --------- "+fltKey);
			ATUReports.add("actualOutGMT  Fail :  " +actualOutGMT+"   "+actualOutGMT2+"  --------- "+fltKey,  LogAs.FAILED, null);
		}
		
		if(actualOutLoc.equalsIgnoreCase(actualOutLoc2))
		{
		
		}else{
			System.out.println(fltKey2+"actualOutLoc  Fail :  " +actualOutLoc+"   "+actualOutLoc2+"  --------- "+fltKey);
			//test.log(LogStatus.FAIL, "actualOutLoc  Fail :  " +actualOutLoc+"   "+actualOutLoc2+"  --------- "+fltKey);
			ATUReports.add("actualOutLoc  Fail :  " +actualOutLoc+"   "+actualOutLoc2+"  --------- "+fltKey,  LogAs.FAILED, null);
		}
		
		if(actualOffGMT.equalsIgnoreCase(actualOffGMT2))
		{
		
		}else{
			System.out.println(fltKey2+"actualOffGMT  Fail :  " +actualOffGMT+"   "+actualOffGMT2+"  --------- "+fltKey);
			//test.log(LogStatus.FAIL, "actualOffGMT  Fail :  " +actualOffGMT+"   "+actualOffGMT2+"  --------- "+fltKey);
			ATUReports.add( "actualOffGMT  Fail :  " +actualOffGMT+"   "+actualOffGMT2+"  --------- "+fltKey,  LogAs.FAILED, null);
		}
	
		if(actualOffLoc.equalsIgnoreCase(actualOffLoc2))
		{
		
		}else{
			System.out.println(fltKey2+"actualOffLoc  Fail :  " +actualOffLoc+"   "+actualOffLoc2+"  --------- "+fltKey);
			//test.log(LogStatus.FAIL,"actualOffLoc  Fail :  " +actualOffLoc+"   "+actualOffLoc2+"  --------- "+fltKey);
			ATUReports.add("actualOffLoc  Fail :  " +actualOffLoc+"   "+actualOffLoc2+"  --------- "+fltKey,  LogAs.FAILED, null);
		}
		

		if(sourceTimeStamp.equalsIgnoreCase(sourceTimeStamp2))
		{
		
		}else{
			System.out.println(fltKey2+"sourceTimeStamp  Fail :  " +sourceTimeStamp+"   "+sourceTimeStamp2+"  --------- "+fltKey);
			//test.log(LogStatus.FAIL, "sourceTimeStamp  Fail :  " +sourceTimeStamp+"   "+sourceTimeStamp2+"  --------- "+fltKey);
			ATUReports.add("sourceTimeStamp  Fail :  " +sourceTimeStamp+"   "+sourceTimeStamp2+"  --------- "+fltKey,  LogAs.FAILED, null);
		}
		
		if(etdUpdatedAt.equalsIgnoreCase(etdUpdatedAt2))
		{
		
		}else{
			System.out.println(fltKey2+"etdUpdatedAt  Fail :  " +etdUpdatedAt+"   "+etdUpdatedAt2+"  --------- "+fltKey);
		//	test.log(LogStatus.FAIL,"etdUpdatedAt  Fail :  " +etdUpdatedAt+"   "+etdUpdatedAt2+"  --------- "+fltKey);
			ATUReports.add("etdUpdatedAt  Fail :  " +etdUpdatedAt+"   "+etdUpdatedAt2+"  --------- "+fltKey,  LogAs.FAILED, null);
		}
		
			if(etaUpdatedAt.equalsIgnoreCase(etaUpdatedAt2))
		{
		
		}else{
			System.out.println(fltKey2+"etaUpdatedAt  Fail :  " +etaUpdatedAt+"   "+etaUpdatedAt2+"  --------- "+fltKey);
			//test.log(LogStatus.FAIL,"etaUpdatedAt  Fail :  " +etaUpdatedAt+"   "+etaUpdatedAt2+"  --------- "+fltKey);
			ATUReports.add("etaUpdatedAt  Fail :  " +etaUpdatedAt+"   "+etaUpdatedAt2+"  --------- "+fltKey,  LogAs.FAILED, null);
		}
		
		if(onUpdatedAt.equalsIgnoreCase(onUpdatedAt2))
		{
		
		}else{
			System.out.println(fltKey2+"onUpdatedAt  Fail :  " +onUpdatedAt+"   "+onUpdatedAt2+"  --------- "+fltKey);
			//test.log(LogStatus.FAIL,"onUpdatedAt  Fail :  " +onUpdatedAt+"   "+onUpdatedAt2+"  --------- "+fltKey);
			ATUReports.add("onUpdatedAt  Fail :  " +onUpdatedAt+"   "+onUpdatedAt2+"  --------- "+fltKey,  LogAs.FAILED, null);
		}
	
		if(eonUpdatedAt.equalsIgnoreCase(eonUpdatedAt2))
		{
		
		}else{
			System.out.println(fltKey2+"eonUpdatedAt  Fail :  " +eonUpdatedAt+"   "+eonUpdatedAt2+"  --------- "+fltKey);
		//	test.log(LogStatus.FAIL,"eonUpdatedAt  Fail :  " +eonUpdatedAt+"   "+eonUpdatedAt2+"  --------- "+fltKey);
			ATUReports.add("eonUpdatedAt  Fail :  " +eonUpdatedAt+"   "+eonUpdatedAt2+"  --------- "+fltKey,  LogAs.FAILED, null);
		}
		
		if(inUpdatedAt.equalsIgnoreCase(inUpdatedAt2))
		{
		
		}else{
			System.out.println(fltKey2+"inUpdatedAt  Fail :  " +inUpdatedAt+"   "+inUpdatedAt2+"  --------- "+fltKey);
		//	test.log(LogStatus.FAIL, "inUpdatedAt  Fail :  " +inUpdatedAt+"   "+inUpdatedAt2+"  --------- "+fltKey);
			ATUReports.add("inUpdatedAt  Fail :  " +inUpdatedAt+"   "+inUpdatedAt2+"  --------- "+fltKey,  LogAs.FAILED, null);
		}
		
		
		if(offUpdatedAt.equalsIgnoreCase(offUpdatedAt2))
		{
		
		}else{
			System.out.println(fltKey2+"offUpdatedAt  Fail :  " +offUpdatedAt+"   "+offUpdatedAt2+"  --------- "+fltKey);
			//test.log(LogStatus.FAIL, "offUpdatedAt  Fail :  " +offUpdatedAt+"   "+offUpdatedAt2+"  --------- "+fltKey);
			ATUReports.add("offUpdatedAt  Fail :  " +offUpdatedAt+"   "+offUpdatedAt2+"  --------- "+fltKey,  LogAs.FAILED, null);
		}
		
		
			if(etoUpdatedAt.equalsIgnoreCase(etoUpdatedAt2))
		{
		
		}else{
			System.out.println(fltKey2+"etoUpdatedAt  Fail :  " +etoUpdatedAt+"   "+etoUpdatedAt2+"  --------- "+fltKey);
			//test.log(LogStatus.FAIL,"etoUpdatedAt  Fail :  " +etoUpdatedAt+"   "+etoUpdatedAt2+"  --------- "+fltKey);
			ATUReports.add("etoUpdatedAt  Fail :  " +etoUpdatedAt+"   "+etoUpdatedAt2+"  --------- "+fltKey,  LogAs.FAILED, null);
		}
		
	
			if(outUpdatedAt.equalsIgnoreCase(outUpdatedAt2))
		{
		
		}else{
			System.out.println(fltKey2+"outUpdatedAt  Fail :  " +outUpdatedAt+"   "+outUpdatedAt2+"  --------- "+fltKey);
			//test.log(LogStatus.FAIL,"outUpdatedAt  Fail :  " +outUpdatedAt+"   "+outUpdatedAt2+"  --------- "+fltKey);
			ATUReports.add("outUpdatedAt  Fail :  " +outUpdatedAt+"   "+outUpdatedAt2+"  --------- "+fltKey,  LogAs.FAILED, null);
		}

		if(cancelUpdatedAt.equalsIgnoreCase(cancelUpdatedAt2))
		{
		
		}else{
			System.out.println(fltKey2+"cancelUpdatedAt  Fail :  " +cancelUpdatedAt+"   "+cancelUpdatedAt2+"  --------- "+fltKey);
			//test.log(LogStatus.FAIL,"cancelUpdatedAt  Fail :  " +cancelUpdatedAt+"   "+cancelUpdatedAt2+"  --------- "+fltKey);
			ATUReports.add("cancelUpdatedAt  Fail :  " +cancelUpdatedAt+"   "+cancelUpdatedAt2+"  --------- "+fltKey,  LogAs.FAILED, null);
		}

		if(eqsubUpdatedAt.equalsIgnoreCase(eqsubUpdatedAt2))
		{
		
		}else{
			System.out.println(fltKey2+"eqsubUpdatedAt  Fail :  " +eqsubUpdatedAt+"   "+eqsubUpdatedAt2+"  --------- "+fltKey);
			//test.log(LogStatus.FAIL,"eqsubUpdatedAt  Fail :  " +eqsubUpdatedAt+"   "+eqsubUpdatedAt2+"  --------- "+fltKey);
			ATUReports.add("eqsubUpdatedAt  Fail :  " +eqsubUpdatedAt+"   "+eqsubUpdatedAt2+"  --------- "+fltKey,  LogAs.FAILED, null);
		}
		
		if(eqlinkUpdatedAt.equalsIgnoreCase(eqlinkUpdatedAt2))
		{
		
		}else{
			System.out.println(fltKey2+"eqlinkUpdatedAt  Fail :  " +eqlinkUpdatedAt+"   "+eqlinkUpdatedAt2+"  --------- "+fltKey);
			//test.log(LogStatus.FAIL, "eqlinkUpdatedAt  Fail :  " +eqlinkUpdatedAt+"   "+eqlinkUpdatedAt2+"  --------- "+fltKey);
			ATUReports.add("eqlinkUpdatedAt  Fail :  " +eqlinkUpdatedAt+"   "+eqlinkUpdatedAt2+"  --------- "+fltKey,  LogAs.FAILED, null);
		}
		
			if(groundTimeUpdatedAt.equalsIgnoreCase(groundTimeUpdatedAt2))
		{
		
		}else{
			System.out.println(fltKey2+"groundTimeUpdatedAt  Fail :  " +groundTimeUpdatedAt+"   "+groundTimeUpdatedAt2+"  --------- "+fltKey);
			//test.log(LogStatus.FAIL,"groundTimeUpdatedAt  Fail :  " +groundTimeUpdatedAt+"   "+groundTimeUpdatedAt2+"  --------- "+fltKey);
			ATUReports.add("groundTimeUpdatedAt  Fail :  " +groundTimeUpdatedAt+"   "+groundTimeUpdatedAt2+"  --------- "+fltKey,  LogAs.FAILED, null);
		}
		
		if(gateUpdatedAt.equalsIgnoreCase(gateUpdatedAt2))
		{
		
		}else{
			System.out.println(fltKey2+"gateUpdatedAt  Fail :  " +gateUpdatedAt+"   "+gateUpdatedAt2+"  --------- "+fltKey);
			//test.log(LogStatus.FAIL,"gateUpdatedAt  Fail :  " +gateUpdatedAt+"   "+gateUpdatedAt2+"  --------- "+fltKey);
			ATUReports.add("gateUpdatedAt  Fail :  " +gateUpdatedAt+"   "+gateUpdatedAt2+"  --------- "+fltKey,  LogAs.FAILED, null);
		}
		
		if(createUpdatedAt.equalsIgnoreCase(createUpdatedAt2))
		{
		
		
		}else{
			System.out.println(fltKey2+"createUpdatedAt  Fail :  " +createUpdatedAt+"   "+createUpdatedAt2+"    "+fltKey);
			//test.log(LogStatus.FAIL, "createUpdatedAt  Fail :  " +createUpdatedAt+"   "+createUpdatedAt2+"    "+fltKey);
			ATUReports.add("createUpdatedAt  Fail :  " +createUpdatedAt+"   "+createUpdatedAt2+"    "+fltKey,  LogAs.FAILED, null);
		}
		
			if(cycleUpdatedAt.equalsIgnoreCase(cycleUpdatedAt2))
		{
		
		}else{
			System.out.println(fltKey2+"cycleUpdatedAt  Fail :  " +cycleUpdatedAt+"   "+cycleUpdatedAt2+"  --------- "+fltKey);
			//test.log(LogStatus.FAIL,"cycleUpdatedAt  Fail :  " +cycleUpdatedAt+"   "+cycleUpdatedAt2+"  --------- "+fltKey);
			ATUReports.add("cycleUpdatedAt  Fail :  " +cycleUpdatedAt+"   "+cycleUpdatedAt2+"  --------- "+fltKey,  LogAs.FAILED, null);
		}   			
		if(deleteUpdatedAt.equalsIgnoreCase(deleteUpdatedAt2))
		{
		
		}else{
			System.out.println(fltKey2+"deleteUpdatedAt  Fail :  " +deleteUpdatedAt+"   "+deleteUpdatedAt2+"  --------- "+fltKey);
		//	test.log(LogStatus.FAIL,"deleteUpdatedAt  Fail :  " +deleteUpdatedAt+"   "+deleteUpdatedAt2+"  --------- "+fltKey);
			ATUReports.add("deleteUpdatedAt  Fail :  " +deleteUpdatedAt+"   "+deleteUpdatedAt2+"  --------- "+fltKey,  LogAs.FAILED, null);
		}
	
		if(continuationUpdatedAt.equalsIgnoreCase(continuationUpdatedAt2))
		{
		
		}else{
			System.out.println(fltKey2+"continuationUpdatedAt  Fail :  " +continuationUpdatedAt+"   "+continuationUpdatedAt2+"  --------- "+fltKey);
			//test.log(LogStatus.FAIL, "continuationUpdatedAt  Fail :  " +continuationUpdatedAt+"   "+continuationUpdatedAt2+"  --------- "+fltKey);
			ATUReports.add("continuationUpdatedAt  Fail :  " +continuationUpdatedAt+"   "+continuationUpdatedAt2+"  --------- "+fltKey,  LogAs.FAILED, null);
		}
		
	
		if(reinstateUpdatedAt.equalsIgnoreCase(reinstateUpdatedAt2))
		{
		
		}else{
			System.out.println(fltKey2+"reinstateUpdatedAt  Fail :  " +reinstateUpdatedAt+"   "+reinstateUpdatedAt2+"  --------- "+fltKey);
			//test.log(LogStatus.FAIL,"reinstateUpdatedAt  Fail :  " +reinstateUpdatedAt+"   "+reinstateUpdatedAt2+"  --------- "+fltKey);
			ATUReports.add("reinstateUpdatedAt  Fail :  " +reinstateUpdatedAt+"   "+reinstateUpdatedAt2+"  --------- "+fltKey,  LogAs.FAILED, null);
		}
		if(diversionUpdatedAt.equalsIgnoreCase(diversionUpdatedAt2))
		{
		
		}else{
			System.out.println(fltKey2+"diversionUpdatedAt  Fail :  " +diversionUpdatedAt+"   "+diversionUpdatedAt2+"  --------- "+fltKey);
		//	test.log(LogStatus.FAIL,"diversionUpdatedAt  Fail :  " +diversionUpdatedAt+"   "+diversionUpdatedAt2+"  --------- "+fltKey);
			ATUReports.add("diversionUpdatedAt  Fail :  " +diversionUpdatedAt+"   "+diversionUpdatedAt2+"  --------- "+fltKey,  LogAs.FAILED, null);
		}
		if(returnUpdatedAt.equalsIgnoreCase(returnUpdatedAt2))
		{
		
		}else{
			System.out.println(fltKey2+"returnUpdatedAt  Fail :  " +returnUpdatedAt+"   "+returnUpdatedAt2+"  --------- "+fltKey);
			//test.log(LogStatus.FAIL,"returnUpdatedAt  Fail :  " +returnUpdatedAt+"   "+returnUpdatedAt2+"  --------- "+fltKey);
			ATUReports.add("returnUpdatedAt  Fail :  " +returnUpdatedAt+"   "+returnUpdatedAt2+"  --------- "+fltKey,  LogAs.FAILED, null);
		}
		if(decisionUpdatedAt.equalsIgnoreCase(decisionUpdatedAt2))
		{
		
		}else{
			System.out.println(fltKey2+"decisionUpdatedAt  Fail :  " +decisionUpdatedAt+"   "+decisionUpdatedAt2+"  --------- "+fltKey);
			//test.log(LogStatus.FAIL,"decisionUpdatedAt  Fail :  " +decisionUpdatedAt+"   "+decisionUpdatedAt2+"  --------- "+fltKey);
			ATUReports.add("decisionUpdatedAt  Fail :  " +decisionUpdatedAt+"   "+decisionUpdatedAt2+"  --------- "+fltKey,  LogAs.FAILED, null);
		}
		
		if(rtdUpdatedAt.equalsIgnoreCase(rtdUpdatedAt2))
		{
		
		}else{
			System.out.println(fltKey2+"rtdUpdatedAt  Fail :  " +rtdUpdatedAt+"   "+rtdUpdatedAt2+"  --------- "+fltKey);
			//test.log(LogStatus.FAIL,"rtdUpdatedAt  Fail :  " +rtdUpdatedAt+"   "+rtdUpdatedAt2+"  --------- "+fltKey);
			ATUReports.add("rtdUpdatedAt  Fail :  " +rtdUpdatedAt+"   "+rtdUpdatedAt2+"  --------- "+fltKey,  LogAs.FAILED, null);
		}
		
		if(crewUpdatedAt.equalsIgnoreCase(crewUpdatedAt2))
		{
		
		}else{
			System.out.println(fltKey2+"crewUpdatedAt  Fail :  " +crewUpdatedAt+"   "+EqpType+"  --------- "+fltKey);
			//test.log(LogStatus.FAIL, "crewUpdatedAt  Fail :  " +crewUpdatedAt+"   "+EqpType+"  --------- "+fltKey);
			ATUReports.add("crewUpdatedAt  Fail :  " +crewUpdatedAt+"   "+EqpType+"  --------- "+fltKey,  LogAs.FAILED, null);
		}
	
			if(fuelSlipUpdatedAt.equalsIgnoreCase(fuelSlipUpdatedAt2))
		{
		
		}else{
			System.out.println(fltKey2+"fuelSlipUpdatedAt  Fail :  " +fuelSlipUpdatedAt+"   "+fuelSlipUpdatedAt2+"  --------- "+fltKey );
			//test.log(LogStatus.FAIL, "fuelSlipUpdatedAt  Fail :  " +fuelSlipUpdatedAt+"   "+fuelSlipUpdatedAt2+"  --------- "+fltKey);
			ATUReports.add( "fuelSlipUpdatedAt  Fail :  " +fuelSlipUpdatedAt+"   "+fuelSlipUpdatedAt2+"  --------- "+fltKey,  LogAs.FAILED, null);
		}
		
		
		
		
		
	}catch (Exception EE)
	{
		System.out.println("Exception " );
		//test.log(LogStatus.FAIL, "Exception ");
		ATUReports.add(  "Exception ",  LogAs.FAILED, null);
//		test.log(LogStatus.INFO, Intermediateobject2);
//		test.log(LogStatus.INFO, Intermediateobject22);
	}
	
	}
	
	catch (Exception EE)
	{
		
		System.out.println("Exception in fetching element. Compare response manually ");
		System.out.println("Response1 :: "+full);
		//System.out.println("Response2:: "+Intermediateobject22);
	//	test.log(LogStatus.FAIL, "Exception in fetching element. Compare response manually "+full);
		ATUReports.add(  "Exception in fetching element. Compare response manually "+full,  LogAs.FAILED, null);
	//	test.log(LogStatus.INFO, Intermediateobject2);
	//	test.log(LogStatus.INFO, Intermediateobject22);
		
		
	}
	
	



}catch (Exception EE)
	{
		System.out.println("No Flight No " );
		//test.log(LogStatus.FAIL, "Exception in fetching element. Compare response manually "+full);
		ATUReports.add("Exception in fetching element. Compare response manually "+full,  LogAs.FAILED, null);
		
	//	test.log(LogStatus.INFO, Intermediateobject2);
	//	test.log(LogStatus.INFO, Intermediateobject22);
	}
   

}












public static void Verifybeforeandafterobjectwise(String url,String url_cache,String station,String strStartTime,String strEndTime) throws Exception{

String url1=url;
String url_cache1=url_cache;
String station1=station;
String strStartTime1=strStartTime;
String strEndTime1=strEndTime;

//VerifyNewEQtypeInclusionGETNGReponse(url1,url_cache1,station1,strStartTime1,strEndTime1);
NotepadtoexcelFlightdetailsbefandafterobjectwise("STL.txt","STL2.txt",station);
NotepadtoexcelFlightdetailsbefandafterobjectwise("DFW.txt","DFW2.txt",station);
NotepadtoexcelFlightdetailsbefandafterobjectwise("CLT.txt","CLT2.txt",station);
}


public static String VerifyNewEQtypeInclusionPOST_JSON_GETNGbefandaftobjectwise(String URL, String jsonString,String path) throws Exception {
System.out.println("Sending POST Request with value " + jsonString + " to URL:" + URL);

long startTime=Calendar.getInstance().getTimeInMillis();

URL url = new URL(URL);
String json = new String(jsonString);
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
		String result = org.apache.commons.io.IOUtils.toString(in,"UTF-8"); // response is stored in result
	try (FileWriter file = new FileWriter(path)) {
		file.write(result);
	in.close();
	conn.disconnect();
	}
	long endTime=Calendar.getInstance().getTimeInMillis();
	long responsetime = startTime-endTime;
	System.out.println("The Total time taken for url  "+"   "+ URL+"is"+responsetime+ "   milliseconds");
	return result;
}





public static void Crewstart(String url, String request, String urls,String request2) throws Exception {
	String url1 = url;
	String url3 = urls;
	String request12 = request;
	String request13 = request2;
	CrewGETNGReponse(url1, request12, urls,request2);
	
	CrewDataPuller("json1.txt","json2.txt", "Crew");
}

 public static String Getcrewobjectfromflightforgiventime(String Jsonobject,String valueofelement,int number) throws Exception{
	  JSONArray jsonObj1 = new JSONArray(Jsonobject);
	  JSONObject Testprint = jsonObj1.getJSONObject(number);
	
	  try{
		  String EqpType =  	Testprint.getJSONObject("flight").getString(valueofelement);
		  return EqpType;
		  			 
	  }catch(Exception Notastring)
	  {
		  try{
			  Long EqpType =  	Testprint.getJSONObject("flight").getLong(valueofelement); 
			  String EQtype = EqpType.toString();
			  return EQtype;
		  }catch(Exception Notalong)
		  {
			  try{
				  boolean EqpType =  	Testprint.getJSONObject("flight").getBoolean(valueofelement); 
				  String EQtype = String.valueOf(EqpType);
				  return EQtype;
			  }catch(Exception Notany)
			  {
				  return "Null"; 
			  }
			  
		  }
		  
	  }

 }

 
 
 public static String Getcrewobjectfromallcrewreportservice(JSONObject Jsonobject,String valueofelement,int number) throws Exception{
	//  JSONArray jsonObj1 = new JSONArray(Jsonobject);
	 // JSONObject Testprint = jsonObj1.getJSONObject(Jsonobject);
	  JSONObject Testprint = Jsonobject;
	  try{
		  String EqpType =  	Testprint.getString(valueofelement);
		  return EqpType;
		  			 
	  }catch(Exception Notastring)
	  {
		  try{
			  Long EqpType =  	Testprint.getLong(valueofelement); 
			  String EQtype = EqpType.toString();
			  return EQtype;
		  }catch(Exception Notalong)
		  {
			  try{
				  boolean EqpType =  	Testprint.getBoolean(valueofelement); 
				  String EQtype = String.valueOf(EqpType);
				  return EQtype;
			  }catch(Exception Notany)
			  {
				  return "Null"; 
			  }
			  
		  }
		  
	  }

 }

 public static String Getcrewobjectfromsinglecrewreport(String Jsonobject,String valueofelement,int number) throws Exception{
	  JSONArray jsonObj1 = new JSONArray(Jsonobject);
	  JSONObject Testprint = jsonObj1.getJSONObject(number);
	
	  try{
		  String EqpType =  	Testprint.getString(valueofelement);
		  return EqpType;
		  			 
	  }catch(Exception Notastring)
	  {
		  try{
			  Long EqpType =  	Testprint.getLong(valueofelement); 
			  String EQtype = EqpType.toString();
			  return EQtype;
		  }catch(Exception Notalong)
		  {
			  try{
				  boolean EqpType =  	Testprint.getBoolean(valueofelement); 
				  String EQtype = String.valueOf(EqpType);
				  return EQtype;
			  }catch(Exception Notany)
			  {
				  return "Null"; 
			  }
			  
		  }
		  
	  }

 }


public static void CrewDataPuller(String path,String path1, String EventName) throws Exception {

	Date date = new Date();
	TimeZone.setDefault(TimeZone.getTimeZone("GMT"));
	Calendar cal = Calendar.getInstance(TimeZone.getDefault());
	date = cal.getTime();
	String timee = date.toGMTString();
	long timeeunixx = cal.getTimeInMillis();

	long mil = System.currentTimeMillis();
	String st, st2, full,full2, append, le, extend, extended;
	full = "";
	full2 = "";
	extended = "";
	BufferedReader br = new BufferedReader(new FileReader(path));
	while ((st = br.readLine()) != null) {
		full += st;
	}

	//ATUReports.add("Flight for given time response "+full, LogAs.INFO, null);
	//System.out.println("Flights for given time "+full);
	BufferedReader br2 = new BufferedReader(new FileReader(path1));
	while ((st2 = br2.readLine()) != null) {
		full2 += st2;
	}
	
	//ATUReports.add("Consolidated crew report response  "+full2, LogAs.INFO, null);
	
	
	System.out.println("Consolidated crew report " +full2);
	List<String> Crewalertingfromflightsforgiventime = new ArrayList<>();
	
	JSONObject jsonObje11 = new JSONObject(full2);
	String yellowalert = Getcrewobjectfromallcrewreportservice(jsonObje11, "yellowAlert", 1) ;
	String Redalert = Getcrewobjectfromallcrewreportservice(jsonObje11, "redAlert", 1) ;
	String Totalalert = Getcrewobjectfromallcrewreportservice(jsonObje11, "totalAlert", 1) ;
	
	ATUReports.add("Yellow alerting flights are "+yellowalert,  LogAs.INFO, null);
	ATUReports.add("Red alerting flights are "+Redalert,  LogAs.INFO, null);
	ATUReports.add("Total alerting flights are "+Totalalert,  LogAs.INFO, null);

	if (EventName.contains("Crew")) {
		JSONArray jsonObj1 = new JSONArray(full);
	//	System.out.println(full);
		for (int ii = 0; ii < jsonObj1.length(); ii++)

		{
			int rowCountt = ii;
			rowCountt++;
			JSONObject Testprint11 = jsonObj1.getJSONObject(ii);
			try {
				String fltKey = Getcrewobjectfromflightforgiventime(full, "fltKey", ii);
				String fltNum = Getcrewobjectfromflightforgiventime(full, "fltNum", ii);
				String Statusofflight = Getcrewobjectfromflightforgiventime(full, "getDepStatus", ii);
			
				
				try {
							String CateringIsAlert = Testprint11.getJSONObject("addlFlightData")
								.getJSONObject("eventList").getJSONObject("crew").getString("isAlert");
				           boolean checkstatus1 = Statusofflight.equalsIgnoreCase("OFF")||Statusofflight.equalsIgnoreCase("OUT")||Statusofflight.equalsIgnoreCase("CXL");
					//********************	
				           String Cateringeventstatus = Testprint11.getJSONObject("addlFlightData")
									.getJSONObject("eventList").getJSONObject("crew").getString("eventAlertStatus");
				           if(CateringIsAlert.contains("Y")&&Cateringeventstatus.contains("ONTIME")){
				        	   ATUReports.add("*** Crew is alerting but the status is ONTIME in Eventdetails page*****   "+fltKey,  LogAs.FAILED, null);  
				           }
				           
				           if(CateringIsAlert.contains("Y")&&checkstatus1==true){
				        	   ATUReports.add("OFF/CXL/OUT holds Creq alerting   "+fltKey,  LogAs.FAILED, null); 
				           }
						if(CateringIsAlert.contains("Y")&&checkstatus1==false){
							
							//****************** Proceed in taking the flight key value , If Catering alert is Alerting and  status of the flight is Not equal to OFF/OUT/ Cancel .
							
							System.out.println("Crew Alerting found for flight   "+fltKey);
							ATUReports.add("Crew Alerting found for flight   "+fltKey,  LogAs.INFO, null);
							
							String crewurl = "http://apapns43.pdc.aa.com:8080/GetNGServices/getng/getCrewReport";
							
							//******************* Fetching the Crew report from Event details page *****************************************
							String request123 ="{\"flightKey\":\""+fltKey+"\"}";
							
							//Get the crew report with flight key
							CrewGetResponsefromService(crewurl, request123, "json3.txt");
						
							String st3;
							String full3 = "";
							BufferedReader br3 = new BufferedReader(new FileReader("json3.txt"));
							while ((st3 = br3.readLine()) != null) {
								full3 += st3;
							}
							JSONArray jsonObj3= new JSONArray(full3);
							
							ATUReports.add("Global crew response for validation provided below ", LogAs.INFO, null);
							ATUReports.add(jsonObje11.toString(), LogAs.INFO, null);
							ATUReports.add("Flightkey  crew report response for validation provided below ", LogAs.INFO, null);
							ATUReports.add(jsonObj3.toString(), LogAs.INFO, null);
							
							
							for (int kk = 0; kk < jsonObj3.length(); kk++){
								int rowCountttt = kk;
								rowCountttt++;
								JSONObject Testprint1111 = jsonObj3.getJSONObject(kk);
								String getcrewdesignation = Getcrewobjectfromsinglecrewreport(full3, "designation", kk);
								String getcrewempNumber = Getcrewobjectfromsinglecrewreport(full3, "empNumber", kk); 
								String getcrewconnectiontime = Getcrewobjectfromsinglecrewreport(full3, "connectionTime", kk);
								String getcrewstatus = Getcrewobjectfromsinglecrewreport(full3, "status", kk); 
								String getcrewgate = Getcrewobjectfromsinglecrewreport(full3, "gate", kk); 
								String getcrewOrigination = Getcrewobjectfromsinglecrewreport(full3, "origination", kk); 
								
//***************************************************To check the Event details Crew report validation***************************************************************
							
								int conextimefordebug = Integer.parseInt(getcrewconnectiontime);
								boolean Statusnotontime = getcrewstatus.contains("ONTIME");
															
								Crewalertingfromflightsforgiventime.add(fltKey+" **** "+getcrewempNumber+" *****  "+getcrewstatus);
								
								boolean connexlessthan80 = conextimefordebug>80;
								System.out.println("Connextome   "+conextimefordebug+"   "+fltKey);
							
							
								//************** Check the status from Event details crew report have null values*****************************
								
								
								if(getcrewstatus.contains("Null")){
									 ATUReports.add("***Crew report status fetchecd from the Eventdetails have Null values ***  "+fltKey,  LogAs.FAILED, null);	
								}
								if(getcrewstatus.contains("")&&conextimefordebug>45){
									 ATUReports.add("***Crew status is Yellow/ Red but still the connection time is high to alert  ***  "+fltKey,  LogAs.FAILED, null);	
								}
								//***********************************************************************************************************	
								
								if(connexlessthan80==true&&Statusnotontime==false)
								{
									
									ATUReports.add("Fail"+conextimefordebug+"   "+fltKey,  LogAs.FAILED, null);	
									System.out.println("Fail   "+conextimefordebug+"   "+fltKey);
								}
								String checkcrew0 = Testprint1111.toString();
								if(getcrewstatus.contains("Null")||getcrewempNumber.contains("Null")){
									ATUReports.add("****Crew status OR Crew Employee number is null for fltkey***  "+fltKey+ "   "+getcrewstatus,  LogAs.FAILED, null);	
								}
								
//*********************Till Above is to check the eventdetails crew report validation******************************************************************************************************								
								
								else{
									
								JSONObject jsonObje = new JSONObject(full2);
								JSONArray jsonObj2 = jsonObje.getJSONArray("alertDetails");
								String consolecrewresponse = jsonObje.toString();
								//System.out.println(jsonObj2.length());
								for (int jj = 0; jj < jsonObj2.length(); jj++)
									
								{
									int rowCounttt = jj;
									
									JSONObject Testprint111 = jsonObj2.getJSONObject(jj);
									rowCounttt++;
									try {
										String fltNum2 = Getcrewobjectfromallcrewreportservice(Testprint111, "flight", jj) ; 
										String empnumber = Getcrewobjectfromallcrewreportservice(Testprint111, "empNumber", jj) ;
										String connectionTime = Getcrewobjectfromallcrewreportservice(Testprint111, "connectionTime", jj) ; 
										String Status = Getcrewobjectfromallcrewreportservice(Testprint111, "status", jj) ; 
										String designation = Getcrewobjectfromallcrewreportservice(Testprint111, "designation", jj) ;
										String gate = Getcrewobjectfromallcrewreportservice(Testprint111, "gate", jj) ;
										String origination = Getcrewobjectfromallcrewreportservice(Testprint111, "origination", jj) ;
										
										String checkcrew = Testprint111.toString();
										
	//************************************************** Below to check Consolidated report value validation***************************************									
										
										if(fltNum2.contains("Null")||empnumber.contains("Null")||connectionTime.contains("Null")||Status.contains("Null")||designation.contains("Null")||gate.contains("Null")||origination.contains("Null")){
											ATUReports.add("Empty values " +"fltNum2"+"  "+"empnumber"+"  "+"connectionTime"+"  "+"Status"+"  "+"designation"+"  "+"gate"+" "+"origination",  LogAs.INFO, null);
											ATUReports.add("Empty values " +fltNum2+"  "+empnumber+"  "+connectionTime+"  "+Status+"  "+designation+"  "+gate+" "+origination,  LogAs.FAILED, null);	
										}
										
										if(empnumber.contains(getcrewempNumber)){
											
											if(empnumber.contains(getcrewempNumber)){
												ATUReports.add("Details matches for empnumber  " +empnumber+"  "+getcrewempNumber,  LogAs.PASSED, null);
												//test.log(LogStatus.PASS, "Details matches for empnumber  " +empnumber+"  "+getcrewempNumber);
											}else{
												//ATUReports.add("Single Flight crew response with flight key  "+fltKey,  LogAs.INFO, null);
												//ATUReports.add(checkcrew0,  LogAs.INFO, null);
												//ATUReports.add("getCrewAlertReport Response  ",  LogAs.INFO, null);
												//	ATUReports.add(checkcrew,  LogAs.INFO, null);
												ATUReports.add("Mismatch in empnumber "+"** Consolidated Crew report employee Number = " +empnumber+"  "+"** Eventdetails Crew report employee Number = "+getcrewempNumber,  LogAs.FAILED, null);
												System.out.println("Single Flight crew response with flight key  "+checkcrew0);
												System.out.println("getCrewAlertReport Response  "+checkcrew);
												//test.log(LogStatus.FAIL, "Mismatch in empnumber " +empnumber+"  "+getcrewempNumber);
											}
											
												if(designation.contains(getcrewdesignation)){
													ATUReports.add("Details matches for designation " +designation+"  "+getcrewdesignation,  LogAs.PASSED, null);
													//test.log(LogStatus.PASS, "Details matches for designation " +designation+"  "+getcrewdesignation);
											}else{
//												ATUReports.add("Single Flight crew response with flight key  ",  LogAs.INFO, null);
//												ATUReports.add(checkcrew0,  LogAs.INFO, null);
//												ATUReports.add("getCrewAlertReport Response  ",  LogAs.INFO, null);
//												ATUReports.add(checkcrew,  LogAs.INFO, null);
												
												System.out.println("Single Flight crew response with flight key  "+checkcrew0);
												System.out.println("getCrewAlertReport Response   "+checkcrew);
												ATUReports.add("Mismatch in designation "+"** Consolidated Crew report designation Number = " +designation+"  "+"** Eventdetails Crew report designation Number = "+getcrewdesignation,  LogAs.FAILED, null);
												//test.log(LogStatus.FAIL, "Mismatch in designation " +designation+"  "+getcrewdesignation);
												
											}

													if(Status.contains(getcrewstatus)){
														ATUReports.add("Details matches for status  " +Status+"  "+getcrewstatus,  LogAs.PASSED, null);
														//test.log(LogStatus.PASS, "Details matches for status  " +Status+"  "+getcrewstatus);
														}else{
//															ATUReports.add("Single Flight crew response with flight key  ",  LogAs.INFO, null);
//															ATUReports.add(checkcrew0,  LogAs.INFO, null);
//															ATUReports.add("getCrewAlertReport Response   ",  LogAs.INFO, null);
//															ATUReports.add(checkcrew,  LogAs.INFO, null);
//															
															System.out.println("Single Flight crew response with flight key  "+checkcrew0);
															System.out.println("getCrewAlertReport Response   "+checkcrew);
															ATUReports.add("Mismatch in Status "+"** Consolidated Crew report Status  = " +Status+"  "+"** Eventdetails Crew report Status  = "+getcrewstatus,  LogAs.FAILED, null);
															//test.log(LogStatus.FAIL, "Mismatch in status " +Status+"  "+getcrewstatus);
																	}

														if((connectionTime!=null)||(getcrewconnectiontime!=null)){
															Long connectiontimeconverted1 = Long.parseLong(connectionTime);
															Long connectiontimeconverted2 = Long.parseLong(getcrewconnectiontime);
															
															Long connectiontimemaximumbuffer = connectiontimeconverted1+2;
															Long connectiontimeminimumbuffer = connectiontimeconverted1-2;
													
															if(connectionTime.equalsIgnoreCase(getcrewconnectiontime)){
																ATUReports.add("Check once Manually the response " +connectionTime+"  "+getcrewconnectiontime,  LogAs.INFO, null);
																//test.log(LogStatus.INFO, "Check once Manually the response " +connectionTime+"  "+getcrewconnectiontime);
															}
															
															if((connectiontimeconverted1<=connectiontimemaximumbuffer&&connectiontimeconverted1>=connectiontimeminimumbuffer)&&(connectiontimeconverted2<=connectiontimemaximumbuffer&&connectiontimeconverted2>=connectiontimeminimumbuffer))
															{
																ATUReports.add("Details matches for getcrewconnectiontime " +connectionTime+"  "+getcrewconnectiontime,  LogAs.PASSED, null);
														//	test.log(LogStatus.PASS, "Details matches for getcrewconnectiontime " +connectionTime+"  "+getcrewconnectiontime);
															}
															else{
//																ATUReports.add("Single Flight crew response with flight key  ",  LogAs.INFO, null);
//																ATUReports.add(checkcrew0,  LogAs.INFO, null);
//																ATUReports.add("getCrewAlertReport Response   ",  LogAs.INFO, null);
//																ATUReports.add(checkcrew,  LogAs.INFO, null);
//																
																
																ATUReports.add("Details Mismatches for getcrewconnectiontime " +connectionTime+"  "+getcrewconnectiontime,  LogAs.FAILED, null);
															//	test.log(LogStatus.FAIL, "Mismatch in getcrewconnectiontime " +connectionTime+"  "+getcrewconnectiontime);
																		}
														}

															if(gate.contains(getcrewgate)){
																ATUReports.add("Details matches for gate  " +gate+"  "+getcrewgate,  LogAs.PASSED, null);
																//test.log(LogStatus.PASS, "Details matches for gate  " +gate+"  "+getcrewgate);
																}else{
//																	ATUReports.add("Single Flight crew response with flight key  ",  LogAs.INFO, null);
//																	ATUReports.add(checkcrew0,  LogAs.INFO, null);
//																	ATUReports.add("getCrewAlertReport Response   ",  LogAs.INFO, null);
//																	ATUReports.add(checkcrew,  LogAs.INFO, null);
//																	
																	System.out.println("Single Flight crew response with flight key  "+checkcrew0);
																	System.out.println("getCrewAlertReport Response   "+checkcrew);
																	ATUReports.add("Mismatch in gate "+"** Consolidated Crew report gate Number = " +gate+"  "+"** Eventdetails Crew report gate Number = "+getcrewgate,  LogAs.FAILED, null);
																	//test.log(LogStatus.FAIL, "Mismatch in gate " +gate+"  "+getcrewgate);
																			}

																if(origination.contains(getcrewOrigination)){
																	ATUReports.add("Details matches for origination " +origination+"  "+getcrewOrigination,  LogAs.PASSED, null);
																	//test.log(LogStatus.PASS, "Details matches for origination " +origination+"  "+getcrewOrigination);
																	}else{
//																		ATUReports.add("Single Flight crew response with flight key  ",  LogAs.INFO, null);
//																		ATUReports.add(checkcrew0,  LogAs.INFO, null);
//																		ATUReports.add("getCrewAlertReport Response   ",  LogAs.INFO, null);
//																		ATUReports.add(checkcrew,  LogAs.INFO, null);
//																		
																		System.out.println("Single Flight crew response with flight key  "+checkcrew0);
																		System.out.println("getCrewAlertReport Response   "+checkcrew);
																		ATUReports.add("Mismatch in origination "+"** Consolidated Crew report origination Number = " +origination+"  "+"** Eventdetails Crew report origination Number = "+getcrewOrigination,  LogAs.FAILED, null);
																		//test.log(LogStatus.FAIL, "Mismatch in origination " +origination+"  "+getcrewOrigination);
																			}
											
										
										break;
										}
										else{

										if(jj==jsonObj2.length()){
											ATUReports.add("Reached end of response and didnt find the Employee number " +empnumber,  LogAs.FAILED, null);
											ATUReports.add("Flight key response  ",  LogAs.INFO, null);
											ATUReports.add(checkcrew0,  LogAs.INFO, null);
											ATUReports.add("Complete getCrewAlertReport response Below  ",  LogAs.INFO, null);
											ATUReports.add(consolecrewresponse,  LogAs.INFO, null);
											
											//test.log(LogStatus.FAIL, "Reached end of response and didnt find the Employee number " +empnumber);
										}
										}

									} catch (Exception EEE) {
								

								}
							
							
							
						}
								
								}
						
						
									}
							
						
						}

					} catch (Exception err) {
						
					}
				

				
			} catch (Exception EEE) {
		

		}

		
			System.out.print(".");
			}
		System.out.println("");
		int unwantedloop = Crewalertingfromflightsforgiventime.size();
		List<String> unwantedarray = new ArrayList<>();
		for(int ma=0; ma<unwantedloop;ma++){
			
			String maiii = Crewalertingfromflightsforgiventime.get(ma);
			if(maiii.contains("ONTIME")){
				
			}else{
				unwantedarray.add(maiii);
			}
		}
		ATUReports.add("************************FINE Tuned result try "+unwantedarray.size(),  LogAs.INFO, null);
		ATUReports.add("************************FINE Tuned result try "+unwantedarray.toString(),  LogAs.INFO, null);
	System.out.println("Number of alerting flights from flightforgiventime is  "+Crewalertingfromflightsforgiventime.size());
	System.out.println("Alerting flights and employee number from flightforgiventime are  "+Crewalertingfromflightsforgiventime.toString());
	//ATUReports.add("No of alerting flights flightforgiventime is  "+Crewalertingfromflightsforgiventime.size(),  LogAs.INFO, null);
//	ATUReports.add("Number of alerting flight's details  from flightforgiventime is  "+Crewalertingfromflightsforgiventime.toString(),  LogAs.INFO, null);
	
	int Totalflightcrewalert = Crewalertingfromflightsforgiventime.size();
	int globalTotalalertcrew = Integer.parseInt(Totalalert);
	System.out.println("Alerting flights and employee number from Consolidated crew report are  "+globalTotalalertcrew);
	if(Totalflightcrewalert == globalTotalalertcrew){
		
		ATUReports.add("Total crew alert flights and Crew flights from giventime is Matching  "+"** Total alerting flights from flight for giventime = "+Totalflightcrewalert + "  "+"**Consolidated crew report = "+globalTotalalertcrew,  LogAs.PASSED, null);
	}
	else{
		ATUReports.add("Total crew alert flights and Crew flights from giventime is Not  Matching  "+"** Total alerting flights from flight for giventime = "+Totalflightcrewalert + "  "+"**Consolidated crew report = "+globalTotalalertcrew,  LogAs.FAILED, null);
	}
	}


}

// ***************************************************************************

public static void CrewGETNGReponse(String strurl, String request1, String strurl2,String request2) throws Exception {

	// &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&

	// Fetch data from GETNextGen and get the NextGen Flight count
	DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	java.util.Date date = new java.util.Date();
	String dateWithoutTime = dateFormat.format(date); // "02 May 2016";
	String jsonString1 = request1;
	String jsonString2 = request2;
	System.out.println("Requesting for getFlightsForGivenTime" );
	CrewGetResponsefromService(strurl, jsonString1, "json1.txt");
	System.out.println("Requesting for Consolidated Crew report for the station " );
	CrewGetResponsefromService(strurl2, jsonString2, "json2.txt");

}


public static void CrewUIGETNGReponse(String strurl, String request1, String strurl2,String request2) throws Exception {

	// &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&

	// Fetch data from GETNextGen and get the NextGen Flight count
	DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	java.util.Date date = new java.util.Date();
	String dateWithoutTime = dateFormat.format(date); // "02 May 2016";
	String jsonString1 = request1;
	String jsonString2 = request2;
	System.out.println("Requesting for getFlightsForGivenTime" );
	CrewGetResponsefromService(strurl, jsonString1, "json1.txt");
	System.out.println("Requesting for Consolidated Crew report for the station " );
	CrewGetResponsefromService(strurl2, jsonString2, "json2.txt");

}

public static String CrewGetResponsefromService(String URL, String jsonString, String path) throws Exception {
	//System.out.println("Sending POST Request with value " + jsonString + " to URL:" + URL);

	try{
	long startTime = Calendar.getInstance().getTimeInMillis();

	URL url = new URL(URL);
	String json = new String(jsonString);
	// System.out.println("jsonString:" + json);
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
	// String result = org.apache.commons.io.IOUtils.toString(in,"UTF-8");
	// // response is stored in result
	String result = org.apache.commons.io.IOUtils.toString(in, "UTF-8"); // response
	//System.out.println(result);																	// is
																			// stored
																			// in
																			// result
	// System.out.println("JSON Response:" + result);

	try (FileWriter file = new FileWriter(path)) {
		file.write(result);
		in.close();
		conn.disconnect();
	}
	long endTime = Calendar.getInstance().getTimeInMillis();
	long responsetime = startTime - endTime;
//	System.out.println("The Total time taken for url  " + "   " + URL + "is" + responsetime + "   milliseconds");
	//System.out.println(result);
	return result;
	}catch(Exception nooutput){
		ATUReports.add("GetNg Flight for given time is not responding ",  LogAs.INFO, null);
		return "Null";
	}
	
}












public static void startEOBTValidation(String url,String url_cache,String station,String strStartTime,String strEndTime,String Currenttime,String nowdate,String previousday) throws Exception{
	   
	  
  	String url1=url;
	String url_cache1=url_cache;
	String station1=station;
	String strStartTime1=strStartTime;
	String strEndTime1=strEndTime;

EOBTReponse(url1,url_cache1,station1,strStartTime1,strEndTime1);
EOBTDataPuller("json1.txt",station,"INTnotDOM",Currenttime,nowdate,previousday);


}



public static void EOBTDataPuller(String path, String sta, String Case,String Currenttime,String nowdate,String Previousdate) throws Exception{
  
    Date date = new Date();
    TimeZone.setDefault(TimeZone.getTimeZone("GMT"));
    Calendar cal = Calendar.getInstance(TimeZone.getDefault());
    date = cal.getTime();
    String timee = date.toGMTString();
    long timeeunixx = cal.getTimeInMillis();


	long mil =System.currentTimeMillis();
	String st, full,append,le,extend, extended;
	full="";
	extended="";
	BufferedReader br = new BufferedReader(new FileReader(path));
	while ((st=br.readLine())!=null) {
  full+=st;
	}
	

// JSONArray jsonObj1 = new JSONArray(full);
JSONObject jsonObj1 = new JSONObject(full);
String[] jsonname1 = JSONObject.getNames(jsonObj1);
int Forloop1 =   jsonObj1.length();


int count =1;
Map<String, Integer> freq = new HashMap<String, Integer>();

for (int kk=0;kk<Forloop1-1;)
 	  {
  
  kk++;
  String flightname = jsonname1[kk];
  try{
  JSONArray Testprint11 = jsonObj1.getJSONArray(flightname);
 // System.out.println("JSON Response:" + Testprint11);
  int Forloop2 =   Testprint11.length();
  System.out.println(Forloop2);
 // System.out.println(Forloop2);
  
		  for (int mm=0;mm<Forloop2;)
		  {
			
	String fltkey1 = Testprint11.getJSONObject(mm).getJSONObject("flight").getString("fltKey").replace(",", " ");
	System.out.println(fltkey1);
	try{
		
		String time11 = Currenttime;
			
		String fetchtime[] = Testprint11.getJSONObject(mm).getJSONObject("flight").getString("expectedTimeDepartureLocalStr").split(" ");
		String time22 = fetchtime[1];
		String date33 = fetchtime[0];
		
	boolean validationcheckstart = isTimeBetweenTwoTime(time11, time22,date33,nowdate,Previousdate);
	
	if(validationcheckstart==true){
	try{
	String eobtLocalStr = Testprint11.getJSONObject(mm).getJSONObject("addlFlightData").getString("eobtLocalStr");
	//test.log(LogStatus.PASS, " eobtLocalStr"+fltkey1);
	}catch(Exception one){
		System.out.println("Split "+mm  +" * NO eobtLocalStr * "+fltkey1+"  Departure Date :: "+date33 +"  Departure time ::  "+time22 +"  Current Station time :: "+time11);
		ATUReports.add("Split "+mm  +" * NO eobtLocalStr * "+fltkey1+"  Departure Date :: "+date33 +"  Departure time ::  "+time22 +"  Current Station time :: "+time11,  LogAs.FAILED, null);
	//	test.log(LogStatus.FAIL, "Split "+mm  +" * NO eobtLocalStr * "+fltkey1+"  Departure Date :: "+date33 +"  Departure time ::  "+time22 +"  Current Station time :: "+time11);
		freq.put(fltkey1, count + 1);
	}
	try{
	String eobtGMTStr = Testprint11.getJSONObject(mm).getJSONObject("addlFlightData").getString("eobtGMTStr");
	//test.log(LogStatus.PASS, " eobtGMTStr"+fltkey1);
	}catch(Exception one){
		System.out.println("Split "+mm  +" * NO eobtGMTStr * "+fltkey1+"  Departure Date :: "+date33 +"  Departure time ::  "+time22 +"  Current Station time :: "+time11);
		ATUReports.add("Split "+mm  +" * NO eobtGMTStr * "+fltkey1+"  Departure Date :: "+date33 +"  Departure time ::  "+time22 +"  Current Station time :: "+time11,  LogAs.FAILED, null);
		//test.log(LogStatus.FAIL, "Split "+mm  +" * NO eobtGMTStr * "+fltkey1+"  Departure Date :: "+date33 +"  Departure time ::  "+time22 +"  Current Station time :: "+time11);
		freq.put(fltkey1, count + 1);
	}
	try{
	long eobtGMT = Testprint11.getJSONObject(mm).getJSONObject("addlFlightData").getLong("eobtGMT");
	//test.log(LogStatus.PASS, " eobtGMT"+fltkey1);
	}catch(Exception one){
		System.out.println("Split "+mm  +" * NO eobtGMT * "+fltkey1+"  Departure Date :: "+date33 +"  Departure time ::  "+time22 +"  Current Station time :: "+time11);
		ATUReports.add("Split "+mm  +" * NO eobtGMT * "+fltkey1+"  Departure Date :: "+date33 +"  Departure time ::  "+time22 +"  Current Station time :: "+time11,  LogAs.FAILED, null);
		//test.log(LogStatus.FAIL, "Split "+mm  +" * NO eobtGMT * "+fltkey1+"  Departure Date :: "+date33 +"  Departure time ::  "+time22 +"  Current Station time :: "+time11);
		freq.put(fltkey1, count + 1);
	}
	try{
		long eobtLocal = Testprint11.getJSONObject(mm).getJSONObject("addlFlightData").getLong("eobtLocal");
		//test.log(LogStatus.PASS, " eobtLocal"+fltkey1);
	}catch(Exception one){
		System.out.println("Split "+mm  +" * NO eobtLocal * "+fltkey1+"  Departure Date :: "+date33 +"  Departure time ::  "+time22 +"  Current Station time :: "+time11);
		ATUReports.add( "Split "+mm  +" * NO eobtLocal * "+fltkey1+"  Departure Date :: "+date33 +"  Departure time ::  "+time22 +"  Current Station time :: "+time11,  LogAs.FAILED, null);
		//test.log(LogStatus.FAIL, "Split "+mm  +" * NO eobtLocal * "+fltkey1+"  Departure Date :: "+date33 +"  Departure time ::  "+time22 +"  Current Station time :: "+time11);
		freq.put(fltkey1, count + 1);
	}
	
	}
	
	}catch(Exception one){
		System.out.println("Fetching time issue");
	}
	
	
	
	
	//System.out.println(mm);
	  mm++;
		  
	 
	
  }	
	
}
catch(Exception EEE)
 {			 
	//System.out.println(" "); 
 }

 	  }
System.out.println(freq.size());
ATUReports.add( "***************************  No Of Flights to validate is   :::  "+Forloop1+"   ***********************************",  LogAs.INFO, null);
ATUReports.add(  "*************************** Number of failures  :::  "+freq.size()  +"  ***************************",  LogAs.INFO, null);
//test.log(LogStatus.INFO, "***************************  No Of Flights to validate is   :::  "+Forloop1+"   ***********************************");
//test.log(LogStatus.INFO, "*************************** Number of failures  :::  "+freq.size()  +"  ***************************");
  
}








public static void EOBTReponse(String strurl,String strurl_cache, String strStation, String strStartTime, String strEndTime) throws Exception{

int count=0;
int count1=0;
int counter1=0;
int counter=0;
String NextGen_Fltnum =null;
ArrayList al=new ArrayList();
ArrayList al_new=new ArrayList();	
String NextGenCache_Fltnum =null;
String NextGen_Fltnum_cache=null; 
String Next_Fltnum=null;

//&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&

//Fetch data from GETNextGen and get the NextGen Flight count
DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
java.util.Date date = new java.util.Date();
String dateWithoutTime =dateFormat.format(date);   //"02 May 2016"; 
String strStartTime2 = dateWithoutTime + "T" + strStartTime +".737Z";
String strEndTime2 = dateWithoutTime + "T" + strEndTime +".737Z";

String jsonString1 = "{\"station\":\""+strStation+"\",\"startTime\":\""+strStartTime2+"\",\"endTime\":\""+strEndTime2+"\",\"pastFlights\":true,\"iatacode\":null,\"gates\":null,\"narrowBody\":true,\"wideBody\":true,\"internationalFlts\":true,\"domesticFlts\":true,\"transactionId\":\"UNKNOWN-0.0.00000_BETA00789696_DFW_1507111114808_201\"}";

String jsonString2 = "{\"station\":\""+strStation+"\",\"startTime\":\""+strStartTime2+"\",\"endTime\":\""+strEndTime2+"\",\"pastFlights\":true,\"iatacode\":null,\"gates\":null,\"narrowBody\":true,\"wideBody\":true,\"internationalFlts\":false,\"domesticFlts\":true,\"transactionId\":\"UNKNOWN-0.0.00000_BETA00789696_DFW_1507111114808_201\"}";

String jsonString3 = "{\"station\":\""+strStation+"\",\"startTime\":\""+strStartTime2+"\",\"endTime\":\""+strEndTime2+"\",\"pastFlights\":true,\"iatacode\":null,\"gates\":null,\"narrowBody\":true,\"wideBody\":true,\"internationalFlts\":true,\"domesticFlts\":true,\"transactionId\":\"UNKNOWN-0.0.00000_BETA00789696_DFW_1507111114808_201\"}";

String jsonString4 = "{\"station\":\""+strStation+"\",\"startTime\":\""+strStartTime2+"\",\"endTime\":\""+strEndTime2+"\",\"pastFlights\":true,\"iatacode\":null,\"gates\":null,\"narrowBody\":true,\"wideBody\":true,\"internationalFlts\":false,\"domesticFlts\":true,\"transactionId\":\"UNKNOWN-0.0.00000_BETA00789696_DFW_1507111114808_201\"}";




String strTotalFlights_NG = POSTEOBT_JSON_GETNG(strurl,jsonString1,"json1.txt");
//String strTotalFlights_NG = POST_JSON_GETNG(strurl,jsonString2,"json2.txt");
//String strTotalFlights_NG = POST_JSON_GETNG(strurl,jsonString3,"json3.txt");
//String strTotalFlights_NG = POST_JSON_GETNG(strurl,jsonString4,"json4.txt");
}




public static String POSTEOBT_JSON_GETNG(String URL, String jsonString,String path) throws Exception {
System.out.println("Sending POST Request with value " + jsonString + " to URL:" + URL);

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
//	System.out.println("JSON Response:" + result);

try (FileWriter file = new FileWriter(path)) {
	file.write(result);
in.close();
conn.disconnect();
}
long endTime=Calendar.getInstance().getTimeInMillis();
long responsetime = startTime-endTime;
//System.out.println("The Total time taken for url  "+"   "+ URL+"is"+responsetime+ "   milliseconds");
return result;
}


public static String gettimezone(String station){
	
	List<String> America1 = Arrays.asList("PHX"); //-7
	List<String> America2 = Arrays.asList("DFW","ORD","STL"); //-6
	List<String> America3 = Arrays.asList("RDU","MIA","JFK","CLT"); //-5
	List<String> America4 = Arrays.asList("LAX");//-8
	
	if(America1.contains(station)){
		return "America/Phoenix";
	}
	
	if(America2.contains(station)){
		return "America/Chicago";
	}
	
	if(America3.contains(station)){
		return "America/New_York";
	}
	
	if(America4.contains(station)){
		return "America/Los_Angeles";
	}
	
	return "America/Guatemala";
}



public static String getpasthrs(String timzoneids,int hrsdec){
	
	SimpleDateFormat dateFormat = new SimpleDateFormat();
	dateFormat.setTimeZone(TimeZone.getTimeZone(timzoneids));
	GregorianCalendar cal = (GregorianCalendar) Calendar.getInstance();
	cal.add(Calendar.DATE, 0);	   
	cal.add(Calendar.HOUR, 0);	
//	String dateandtime = dateFormat.format(cal.getTime());
	String result = cal.getTime().toInstant().truncatedTo(ChronoUnit.SECONDS ).atZone( ZoneId.of( timzoneids ) ).format( DateTimeFormatter.ofPattern( "HH:mm:ss" ).withLocale( Locale.US ) );
	
	return result;
	
}








public static boolean isTimeBetweenTwoTime(String time11, String time22, String date33,String datenow,String previousday) throws Exception {


String string1 = time11;

Date time1 = new SimpleDateFormat("HH:mm:ss").parse(string1);
// Here i think we need to subtract a day
Calendar calendar1 = Calendar.getInstance();
calendar1.setTime(time1);
calendar1.add(Calendar.DATE, 0);
calendar1.add(Calendar.HOUR, 0);
//System.out.println("Time for checkpoint " +calendar1.getTime());

String string2 = time22;
Date time2 = new SimpleDateFormat("HH:mm:ss").parse(string2);
Calendar calendar2 = Calendar.getInstance();
calendar2.setTime(time2);
calendar2.add(Calendar.DATE, 0);
calendar2.add(Calendar.HOUR, 0);
// System.out.println("Current day "+calendar2.getTime());


String string3 = time22;
Date time3 = new SimpleDateFormat("HH:mm:ss").parse(string2);
Calendar calendar3 = Calendar.getInstance();
calendar3.setTime(time3);
calendar3.add(Calendar.DATE, -1);
calendar3.add(Calendar.HOUR, 0);
// System.out.println("Previous day  "+calendar3.getTime());


Date y = calendar1.getTime();    //less timerange -sethours / 6hours
Date z = calendar2.getTime();    // More timerange - set hours
Date zz = calendar3.getTime();

if(date33.contains(datenow)){


if (z.before(y)) {
	       
//System.out.println("true");
return true;
 }
else
{
  return false;
}
}
else if(date33.contains(previousday)){
if(zz.before(y)){     
// System.out.println("true");
return true;
}
else
{
  return false;
}

}else{
	 return false;
}

		









}



public static String getAlertingstation(String url,String request,String urlCache,String request2,String Stations) throws Exception {
	
	
	String 	 ISalerting = correction.alertcrew(url,request,urlCache,request2,Stations);
	return ISalerting;

}


public static String alertcrew(String url, String request, String urls,String request2,String station) throws Exception {
	String url1 = url;
	String url3 = urls;
	String request12 = request;
	String request13 = request2;
	CrewUIGETNGReponse(url1, request12, urls,request2);
	
	String Stationalertingcrew = Consolalertingcrew("json1.txt","json2.txt", "Crew");
	if(Stationalertingcrew.contains("Null")){
		return "Null";
	}else{
		return station;
	}
}




public static String Consolalertingcrew(String path,String path1, String EventName) throws Exception {
	
	Date date = new Date();
	TimeZone.setDefault(TimeZone.getTimeZone("GMT"));
	Calendar cal = Calendar.getInstance(TimeZone.getDefault());
	date = cal.getTime();
	String timee = date.toGMTString();
	long timeeunixx = cal.getTimeInMillis();

	long mil = System.currentTimeMillis();
	String st, st2, full,full2, append, le, extend, extended;
	full = "";
	full2 = "";
	extended = "";

	BufferedReader br2 = new BufferedReader(new FileReader(path1));
	while ((st2 = br2.readLine()) != null) {
		full2 += st2;
	}

	//List<String> Crewalertingfromflightsforgiventime = new ArrayList<>();
	
	JSONObject jsonObje11 = new JSONObject(full2);
	System.out.println(full2);
	String yellowalert = Getcrewobjectfromallcrewreportservice(jsonObje11, "yellowAlert", 1) ;
	String Redalert = Getcrewobjectfromallcrewreportservice(jsonObje11, "redAlert", 1) ;
	String Totalalert = Getcrewobjectfromallcrewreportservice(jsonObje11, "totalAlert", 1) ;
	int globalTotalalertcrew = Integer.parseInt(Totalalert);
	if(globalTotalalertcrew > 0){
		
		ATUReports.add("Alerting present in the station and proceed with Station   ",  LogAs.PASSED, null);
		return Totalalert;
	}
	else{
		
	}
	
	return "Null";
}



	


}