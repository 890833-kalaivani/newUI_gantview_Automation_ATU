package get.next.gen.webtestcase;

import get.next.gen.commonaction.CommonTest;
import get.next.gen.serviceutils.correction;
import get.next.gen.serviceutils.Alerts;
import get.next.gen.utilities.Alertingflightstatsvalidation;
import get.next.gen.utilities.CustomZone;
import get.next.gen.utilities.DashboardFilterOptionValidation;
import get.next.gen.utilities.EventDetailsValidation;
import get.next.gen.utilities.FlightStatsconfirmation;
import get.next.gen.utilities.GanntViewHeaderFunctionality;
import get.next.gen.utilities.GanttviewPuckOptions;
import get.next.gen.utilities.HoverValidation;
import get.next.gen.utilities.Hybridview;




import get.next.gen.utilities.PuckColorValidation;
import get.next.gen.utilities.PuckUIPlacement;
import get.next.gen.utilities.RampopenClose;
import get.next.gen.utilities.SearchValidation;
import get.next.gen.utilities.SortFunctionalityvalidation;

import java.io.IOException;
import java.util.List;















import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;



public class may31releaseservicescriots extends CommonTest {
	
	
	//Inprogress
	@Test(priority = 0)
	 public void T07_checkalerthappeningproperly() throws Exception{
		//String url="http://apapns43.pdc.aa.com:8080/GetNGServices/flight/getFlightsForGivenTime";
		//String urlCache="http://apapns43.pdc.aa.com:8080/GetNGServices/flight/getFlightsForGivenTime";
		
		
		String url="http://apapnp75.tul.aa.com:8080/GetNGServices/flight/getFlightsForGivenTime";
		String urlCache="http://apapnp76.tul.aa.com:8080/GetNGServices/flight/getFlightsForGivenTime";
		String Stations[] = {"DFW","PHL","LAX","ABE","ABI","ABQ","ACT","AEX","AGS","AGU","AKL","ALB","ALO","AMA","AMS","ANC","ANU","ART","ATH","ATL","AUA","AUS","AVL","AVP","AZO","BAQ","BCN","BDA","BDL","BFI","BFL","BFM","BGI","BGR","BHM","BIS","BJX","BMI","BNA","BOG","BOI","BOS","BPT","BRO","BSB","BTR","BTV","BUF","BUR","BWI","BZE","BZN","CAE","CAK","CAP",
				"CCS","CDG","CFG","CHA","CHO","CHS","CID","CKB","CLE","CLL","CLO","CLT","CMH","CMI","CMW","CNF","COS","COU","CRP","CRW","CUN","CUR","CUU","CVG","CWA","CYS","CZM",
				"DAB","DAY","DBQ","DCA","DEN","DRO","DSM","DTW","DUB","EDI","ELH","ELP","ERI","EUG","EVV","EWN","EWR","EYW","EZE","FAR","FAT","FAY","FCO","FDF","FLG","FLL","FLO",
				"FNT","FPO","FRA","FSD","FSM","FWA","GCK","GCM","GDL","GEG","GGG","GGT","GIG","GJT","GLA","GND","GNV","GPT","GRB","GRI","GRK","GRR","GRU","GSO","GSP","GUA","GUS",
				"GYE","HAV","HHH","HKG","HMO","HND","HNL","HOG","HOU","HPN","HSV","HTS","HVN","IAD","IAH","ICT","IFP","ILM","IND","IPT","ISP","ITH","JAN","JAX","JFK","JLN",
				"KIN","KOA","LAN","LAS","LAW","LBB","LCH","LEX","LFT","LGA","LGB","LHR","LIH","LIM","LIR","LIS","LIT","LPB","LRD","LSE","LYH","MAD","MAF","MAN","MAO","MAR","MBJ",
				"MCI","MCO","MDE","MDT","MEI","MEM","MEX","MFE","MGA","MGM","MHH","MHK","MHT","MIA","MKE","MLB","MLI","MLM","MLU","MOB","MQT","MRY","MSN","MSP","MSY","MTJ","MTY",
				"MUC","MVD","MXP","MYR","MZT","NAS","NRT","OAJ","OAK","OGG","OKC","OMA","ONT","ORD","ORF","PAP","PBC","PBI","PDX","PEK","PGV","PHF","PHL","PHX","PIA","PIB","PIT",
				"PLS","PNS","POP","POS","PSP","PTP","PTY","PUJ","PVD","PVG","PVR","PWM","QRO","RAP","RDM","RDU","RFD","RIC","RME","RNO","ROA","ROC","ROW","RST","RSW","RTB",
				"SAF","SAL","SAN","SAP","SAT","SAV","SBA","SBP","SBY","SCE","SCL","SDF","SDQ","SEA","SFO","SGF","SGU","SHV","SJC","SJD","SJO","SJT","SJU","SKB","SLC","SLP",
				"SMF","SNA","SNN","SNU","SPI","SPS","SRQ","STI","STL","STS","STT","STX","SUX","SWF","SWO","SXM","SYD","SYR","TGU","TLH","TOL","TPA","TRC","TRI","TUL","TUS","TVC",
				"TXK","TYR","TYS","UIO","UVF","VCE","VPS","VRA","VVI","XNA","YOW","YUL","YUM","YVR","YYC","YYZ","ZCL","ZIH","ZRH","ZSA"};;
		
		
		String Starttime = "2017-12-14T06:28:22.773Z";
		String Endtime = "2017-12-14T19:28:22.773Z";
		for( int i = 0; i < Stations.length; i++)
		{
		
		String request="{\"station\":\""+Stations[i]+"\",\"startTime\":\""+Starttime+"\",\"endTime\":\""+Endtime+"\",\"gates\":[],\"allGates\":true,\"pastFlights\":true,\"transactionId\":\"UNKNOWN_00812339_PHX_1489539768116_201\"}";
		
		
		Alerts.startcode(url,request,urlCache);
		}
	}
	 
	


	
	 
	@Test(priority = 6)
 public void T01_CompareBeforeandAfterServciceStarttest() throws Exception{
		
		String strStartTime="00:01:41";
		String strEndTime="23:52:41";
		String url="http://apapns86.pdc.aa.com:8080/GetNGDB/ngflights/getFlightsForKeys";
		String url_cache="http://apapns44.pdc.aa.com:8080/GetFlightCache/flight/getFlightDetailsForKeys";	
		String sta="sta";
		 correction.Beforeandafterserverrestartstartcode("IAH.txt","IAH2.txt",sta,strStartTime,strEndTime);
 }
	
	@Test(priority = 1)
 public static void T02_CompareTarmacreportbetweenprovidedServices() throws Exception{
		
		// * Below Script will compare tarmac report responses fetched from services and post result on whole response comparison
		
		  	String Oldurl="http://apapns43.pdc.aa.com:8080/GetNGServices/getng/getTarmacReport";
			String Newurl="http://apapns43.pdc.aa.com:8080/GetNGServices/report/getTarmacReport";
			String Starttime = "2017-10-17T00:28:24.534Z";
			String Endtime = "2017-10-17T05:28:24.534Z";
	
		String Stations[] = {"DFW"};
	
			for( int i = 0; i < Stations.length; i++)
			{	
				String sta = Stations[i];
				System.out.println(sta);
				String request="{\"station\":\""+sta+"\",\"transactionId\":\"UNKNOWN-0.0.00000_BETA00789696_DFW_1507119025574_212\"}";
				correction.CompareTarmacreportstartcode(Oldurl,request,Newurl,sta);
			}	
	 }
	
	
	@Test(priority = 2)
 public static void T03_VerifyNewEQtypeInclusion_Novrelease() throws Exception{
		
		
		// * Below Script validate whether the EQTYPE H75H & 757E are not present 
		// * AND validate inclusion of New EQTYPE in Nov release
		// * Pass as many station you want in Array for validation
		 
		//	String url="http://apapnp75.tul.aa.com:8080/GetNGServices/flight/getFlightsForGivenTime";
		//	String url_cache="http://apapnp76.tul.aa.com:8080/GetNGServices/flight/getFlightsForGivenTime";
			
			
			String url="http://apapnp75.tul.aa.com:8080/GetNGServices/flight/getFlightsForGivenTime";
			String url_cache="http://apapnp76.tul.aa.com:8080/GetNGServices/flight/getFlightsForGivenTime";
			
			String strStartTime="00:01:41";
			String strEndTime="03:52:41";
			
			String Stations[] = {"PHL"};
			for( int i = 0; i < Stations.length; i++)
			{	
				String sta = Stations[i];
				System.out.println(sta);
				 correction.VerifyNewEQtypeInclusionstartcode(url,url_cache,sta,strStartTime,strEndTime);
		 
			}
	 }
		
	
	@Test(priority = 3)
	 public void T04_EventAlertingIdentificationtest() throws Exception{
		
		/*
		 * Below Script is written to identify the Alerting events accross different station. Run the script which will help you to easily identify the
		 * events alerting in which station, so that it will save your time to identify the data before your execution instead of jumping between stations.
		 */
		
	  //	String url="http://apapns43.pdc.aa.com:8080/GetNGServices/flight/getFlightsForGivenTime";
	//	String urlCache="http://apapns43.pdc.aa.com:8080/GetNGServices/flight/getFlightsForGivenTime";
		
		String url="http://apapnp75.tul.aa.com:8080/GetNGServices/flight/getFlightsForGivenTime";
		String urlCache="http://apapnp76.tul.aa.com:8080/GetNGServices/flight/getFlightsForGivenTime";
		
		String Starttime = "2017-11-28T00:28:24.534Z";
		String Endtime = "2017-11-28T23:28:24.534Z";
	
		String Stations[] = {"DFW"};
		
			for( int i = 0; i < Stations.length; i++)
			{	
			String sta = Stations[i];
			System.out.println(sta);
			String request="{\"station\":\""+sta+"\",\"startTime\":\""+Starttime+"\",\"endTime\":\""+Endtime+"\",\"pastFlights\":false,\"iatacode\":null,\"gates\":null,\"narrowBody\":true,\"wideBody\":true,\"transactionId\":\"UNKNOWN-0.0.00000_BETA00789696_DFW_1507111114808_201\"}";
			
			
			correction.EventAlertingIdentificationstartcode(url,request,urlCache,sta);
			}	
	
	 
	}
	
	@Test(priority = 4)
 public void T05_TarmacFinder() throws Exception{
		
		/*
		 * Below script used to find tarmac report available across stations.
		 */
		  	String url="http://apapnp76.tul.aa.com:8080/GetNGServices/report/getTarmacReport";
			String urlCache="http://apapnp76.tul.aa.com:8080/GetNGServices/report/getTarmacReport";
			String Stations[] = {"DFW","PHL","LAX","ABE","ABI","ABQ","ACT","AEX","AGS","AGU","AKL","ALB","ALO","AMA","AMS","ANC","ANU","ART","ATH","ATL","AUA","AUS","AVL","AVP","AZO","BAQ","BCN","BDA","BDL","BFI","BFL","BFM","BGI","BGR","BHM","BIS","BJX","BMI","BNA","BOG","BOI","BOS","BPT","BRO","BSB","BTR","BTV","BUF","BUR","BWI","BZE","BZN","CAE","CAK","CAP",
				"CCS","CDG","CFG","CHA","CHO","CHS","CID","CKB","CLE","CLL","CLO","CLT","CMH","CMI","CMW","CNF","COS","COU","CRP","CRW","CUN","CUR","CUU","CVG","CWA","CYS","CZM",
				"DAB","DAY","DBQ","DCA","DEN","DRO","DSM","DTW","DUB","EDI","ELH","ELP","ERI","EUG","EVV","EWN","EWR","EYW","EZE","FAR","FAT","FAY","FCO","FDF","FLG","FLL","FLO",
				"FNT","FPO","FRA","FSD","FSM","FWA","GCK","GCM","GDL","GEG","GGG","GGT","GIG","GJT","GLA","GND","GNV","GPT","GRB","GRI","GRK","GRR","GRU","GSO","GSP","GUA","GUS",
				"GYE","HAV","HHH","HKG","HMO","HND","HNL","HOG","HOU","HPN","HSV","HTS","HVN","IAD","IAH","ICN","ICT","IFP","ILM","IND","IPT","ISP","ITH","JAN","JAX","JFK","JLN",
				"KIN","KOA","LAN","LAS","LAW","LBB","LCH","LEX","LFT","LGA","LGB","LHR","LIH","LIM","LIR","LIS","LIT","LPB","LRD","LSE","LYH","MAD","MAF","MAN","MAO","MAR","MBJ",
				"MCI","MCO","MDE","MDT","MEI","MEM","MEX","MFE","MGA","MGM","MHH","MHK","MHT","MIA","MKE","MLB","MLI","MLM","MLU","MOB","MQT","MRY","MSN","MSP","MSY","MTJ","MTY",
				"MUC","MVD","MXP","MYR","MZT","NAS","NRT","OAJ","OAK","OGG","OKC","OMA","ONT","ORD","ORF","PAP","PBC","PBI","PDX","PEK","PGV","PHF","PHL","PHX","PIA","PIB","PIT",
				"PLS","PNS","POP","POS","PSP","PTP","PTY","PUJ","PVD","PVG","PVR","PWM","QRO","RAP","RDM","RDU","RFD","RIC","RME","RNO","ROA","ROC","ROW","RST","RSW","RTB",
				"SAF","SAL","SAN","SAP","SAT","SAV","SBA","SBP","SBY","SCE","SCL","SDF","SDQ","SEA","SFO","SGF","SGU","SHV","SJC","SJD","SJO","SJT","SJU","SKB","SLC","SLP",
				"SMF","SNA","SNN","SNU","SPI","SPS","SRQ","STI","STL","STS","STT","STX","SUX","SWF","SWO","SXM","SYD","SYR","TGU","TLH","TOL","TPA","TRC","TRI","TUL","TUS","TVC",
				"TXK","TYR","TYS","UIO","UVF","VCE","VPS","VRA","VVI","XNA","YOW","YUL","YUM","YVR","YYC","YYZ","ZCL","ZIH","ZRH","ZSA"};
			for( int i = 0; i < Stations.length; i++)
			{	
				String sta = Stations[i];
				System.out.println(sta);
				String request="{\"station\": \""+sta+"\"}";
				correction.TarmacFinderstartcode(url,request,urlCache,sta);
			}	
		
	
		
	}
	
	@Test(priority = 5)
	 public void T06_Tarmacgreaterthan15Validation() throws Exception{

		/*US671614
		 * Below script will check the response have tarmac report greater than 15 and check its been displayed under appropriate objects in service
		 */
			String url="http://apapnp75.tul.aa.com:8080/GetNGServices/report/getTarmacReport";
			String urlCache="http://apapnp75.tul.aa.com:8080/GetNGServices/report/getTarmacReport";
			String Stations[] = {"DFW","PHL","LAX","ABE","ABI","ABQ","ACT","AEX","AGS","AGU","AKL","ALB","ALO","AMA","AMS","ANC","ANU","ART","ATH","ATL","AUA","AUS","AVL","AVP","AZO","BAQ","BCN","BDA","BDL","BFI","BFL","BFM","BGI","BGR","BHM","BIS","BJX","BMI","BNA","BOG","BOI","BOS","BPT","BRO","BSB","BTR","BTV","BUF","BUR","BWI","BZE","BZN","CAE","CAK","CAP",
				"CCS","CDG","CFG","CHA","CHO","CHS","CID","CKB","CLE","CLL","CLO","CLT","CMH","CMI","CMW","CNF","COS","COU","CRP","CRW","CUN","CUR","CUU","CVG","CWA","CYS","CZM",
				"DAB","DAY","DBQ","DCA","DEN","DRO","DSM","DTW","DUB","EDI","ELH","ELP","ERI","EUG","EVV","EWN","EWR","EYW","EZE","FAR","FAT","FAY","FCO","FDF","FLG","FLL","FLO",
				"FNT","FPO","FRA","FSD","FSM","FWA","GCK","GCM","GDL","GEG","GGG","GGT","GIG","GJT","GLA","GND","GNV","GPT","GRB","GRI","GRK","GRR","GRU","GSO","GSP","GUA","GUS",
				"GYE","HAV","HHH","HKG","HMO","HND","HNL","HOG","HOU","HPN","HSV","HTS","HVN","IAD","IAH","ICT","IFP","ILM","IND","IPT","ISP","ITH","JAN","JAX","JFK","JLN",
				"KIN","KOA","LAN","LAS","LAW","LBB","LCH","LEX","LFT","LGA","LGB","LHR","LIH","LIM","LIR","LIS","LIT","LPB","LRD","LSE","LYH","MAD","MAF","MAN","MAO","MAR","MBJ",
				"MCI","MCO","MDE","MDT","MEI","MEM","MEX","MFE","MGA","MGM","MHH","MHK","MHT","MIA","MKE","MLB","MLI","MLM","MLU","MOB","MQT","MRY","MSN","MSP","MSY","MTJ","MTY",
				"MUC","MVD","MXP","MYR","MZT","NAS","NRT","OAJ","OAK","OGG","OKC","OMA","ONT","ORD","ORF","PAP","PBC","PBI","PDX","PEK","PGV","PHF","PHL","PHX","PIA","PIB","PIT",
				"PLS","PNS","POP","POS","PSP","PTP","PTY","PUJ","PVD","PVG","PVR","PWM","QRO","RAP","RDM","RDU","RFD","RIC","RME","RNO","ROA","ROC","ROW","RST","RSW","RTB",
				"SAF","SAL","SAN","SAP","SAT","SAV","SBA","SBP","SBY","SCE","SCL","SDF","SDQ","SEA","SFO","SGF","SGU","SHV","SJC","SJD","SJO","SJT","SJU","SKB","SLC","SLP",
				"SMF","SNA","SNN","SNU","SPI","SPS","SRQ","STI","STL","STS","STT","STX","SUX","SWF","SWO","SXM","SYD","SYR","TGU","TLH","TOL","TPA","TRC","TRI","TUL","TUS","TVC",
				"TXK","TYR","TYS","UIO","UVF","VCE","VPS","VRA","VVI","XNA","YOW","YUL","YUM","YVR","YYC","YYZ","ZCL","ZIH","ZRH","ZSA"};
			for( int i = 0; i < Stations.length; i++)
			{	
				String sta = Stations[i];
				System.out.println("station   :"+ sta);
				String request="{\"station\": \""+sta+"\"}";
				correction.Tarmacgreaterthan15startcode(url,request,urlCache,sta);
			}	
		
	 
	}
			

	
	
	@Test(priority = 7)
	 public void T08_MELNullcheckertest() throws Exception{
		//Below code will check whether the MEL have any null values when type is SEL which is nomore available in database.
		
	//	String url="http://10.245.15.40:8080/GetNGServices/flight/getFlightsForGivenTime";
	//	String urlCache="http://10.245.15.40:8080/GetNGServices/flight/getFlightsForGivenTime";
		
		
		String url="http://apapnp75.tul.aa.com:8080/GetNGServices/flight/getFlightsForGivenTime";
		String urlCache="http://apapnp76.tul.aa.com:8080/GetNGServices/flight/getFlightsForGivenTime";
		String Starttime = "2017-11-29T00:28:24.534Z";
		String Endtime = "2017-11-29T12:28:24.534Z";

	String Stations[] = {"DFW"};
		System.out.println();

		for( int i = 0; i < Stations.length; i++)
		{	
			String sta = Stations[i];
			System.out.println(sta);
		String request="{\"station\":\""+sta+"\",\"startTime\":\""+Starttime+"\",\"endTime\":\""+Endtime+"\",\"gates\":[],\"allGates\":true,\"pastFlights\":true,\"transactionId\":\"UNKNOWN_00812339_PHX_1489539768116_201\"}";
		correction.MELNullcheckerstartcode(url,request,urlCache,sta);
		}	
	
	
 
		
		
	}
	
	
	@Test(priority = 8)
	 public void T09_StageVSProd() throws Exception{
		
		//Compare Stage and Prod responses
		
		//String url="http://apapnp95.tul.aa.com:8080/GetFlightCache/flight/getFlightsForGivenTime";
		//String url_cache="http://apapns44.pdc.aa.com:8080/GetFlightCache/flight/getFlightsForGivenTime";
		
		
		
		String url="http://apapns89.pdc.aa.com:8080/GetFlightCache/flight/getFlightsForGivenTime";
		String url_cache="http://apapns44.pdc.aa.com:8080/GetFlightCache/flight/getFlightsForGivenTime";
		
		String strStartTime="05:05:41";
		String strEndTime="12:12:41";
		
		String Stations[] = {"PHL","DFW","ORD","MIA","STL","CLT"};
		for( int i = 0; i < Stations.length; i++)
		{	
			String sta = Stations[i];
			System.out.println(sta);
			 correction.VerifyProdvsStage(url,url_cache,sta,strStartTime,strEndTime);
	 
		}
	}
	
	@Test(priority = 9)
	 public void T10_beforandafterserverrestartobjwise() throws Exception{
		//Compare the response every fields when data stored in external file and compare after restart of server
		
		String url="http://apapnp95.tul.aa.com:8080/GetFlightCache/flight/getFlightsForGivenTime";
		String url_cache="http://apapns44.pdc.aa.com:8080/GetFlightCache/flight/getFlightsForGivenTime";
		String strStartTime="00:01:41";
		String strEndTime="00:30:41";
		
		String Stations[] = {"PHL"};
		for( int i = 0; i < Stations.length; i++)
		{	
			String sta = Stations[i];
			System.out.println(sta);
			 correction.Verifybeforeandafterobjectwise(url,url_cache,sta,strStartTime,strEndTime);
	 
		}
		
		
		
	}
}