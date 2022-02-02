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



public class Test1 extends CommonTest {
	

	@Test(priority = 0)
	 public void T06_Tarmacgreaterthan15Validation() throws Exception{

		/*US671614
		 * Below script will check the response have tarmac report greater than 15 and check its been displayed under appropriate objects in service
		 */
			String url="http://apapns86.pdc.aa.com:8080/GetNGServices/report/getTarmacReport";
			String urlCache="http://apapns86.pdc.aa.com:8080/GetNGServices/report/getTarmacReport";
			String Stations[] = {"DFW","PHL"};
//			String Stations[] = {"DFW","PHL","LAX","ABE","ABI","ABQ","ACT","AEX","AGS","AGU","AKL","ALB","ALO","AMA","AMS","ANC","ANU","ART","ATH","ATL","AUA","AUS","AVL","AVP","AZO","BAQ","BCN","BDA","BDL","BFI","BFL","BFM","BGI","BGR","BHM","BIS","BJX","BMI","BNA","BOG","BOI","BOS","BPT","BRO","BSB","BTR","BTV","BUF","BUR","BWI","BZE","BZN","CAE","CAK","CAP",
//				"CCS","CDG","CFG","CHA","CHO","CHS","CID","CKB","CLE","CLL","CLO","CLT","CMH","CMI","CMW","CNF","COS","COU","CRP","CRW","CUN","CUR","CUU","CVG","CWA","CYS","CZM",
//				"DAB","DAY","DBQ","DCA","DEN","DRO","DSM","DTW","DUB","EDI","ELH","ELP","ERI","EUG","EVV","EWN","EWR","EYW","EZE","FAR","FAT","FAY","FCO","FDF","FLG","FLL","FLO",
//				"FNT","FPO","FRA","FSD","FSM","FWA","GCK","GCM","GDL","GEG","GGG","GGT","GIG","GJT","GLA","GND","GNV","GPT","GRB","GRI","GRK","GRR","GRU","GSO","GSP","GUA","GUS",
//				"GYE","HAV","HHH","HKG","HMO","HND","HNL","HOG","HOU","HPN","HSV","HTS","HVN","IAD","IAH","ICT","IFP","ILM","IND","IPT","ISP","ITH","JAN","JAX","JFK","JLN",
//				"KIN","KOA","LAN","LAS","LAW","LBB","LCH","LEX","LFT","LGA","LGB","LHR","LIH","LIM","LIR","LIS","LIT","LPB","LRD","LSE","LYH","MAD","MAF","MAN","MAO","MAR","MBJ",
//				"MCI","MCO","MDE","MDT","MEI","MEM","MEX","MFE","MGA","MGM","MHH","MHK","MHT","MIA","MKE","MLB","MLI","MLM","MLU","MOB","MQT","MRY","MSN","MSP","MSY","MTJ","MTY",
//				"MUC","MVD","MXP","MYR","MZT","NAS","NRT","OAJ","OAK","OGG","OKC","OMA","ONT","ORD","ORF","PAP","PBC","PBI","PDX","PEK","PGV","PHF","PHL","PHX","PIA","PIB","PIT",
//				"PLS","PNS","POP","POS","PSP","PTP","PTY","PUJ","PVD","PVG","PVR","PWM","QRO","RAP","RDM","RDU","RFD","RIC","RME","RNO","ROA","ROC","ROW","RST","RSW","RTB",
//				"SAF","SAL","SAN","SAP","SAT","SAV","SBA","SBP","SBY","SCE","SCL","SDF","SDQ","SEA","SFO","SGF","SGU","SHV","SJC","SJD","SJO","SJT","SJU","SKB","SLC","SLP",
//				"SMF","SNA","SNN","SNU","SPI","SPS","SRQ","STI","STL","STS","STT","STX","SUX","SWF","SWO","SXM","SYD","SYR","TGU","TLH","TOL","TPA","TRC","TRI","TUL","TUS","TVC",
//				"TXK","TYR","TYS","UIO","UVF","VCE","VPS","VRA","VVI","XNA","YOW","YUL","YUM","YVR","YYC","YYZ","ZCL","ZIH","ZRH","ZSA"};
			for( int i = 0; i < Stations.length; i++)
			{	
				String sta = Stations[i];
				System.out.println("station   :"+ sta);
				String request="{\"station\": \""+sta+"\"}";
				//correction.Tarmacgreaterthan15startcode(url,request,urlCache,sta);
			}	
		
	 
	}

	
	
	@Test(priority = 1)
	 public void T0323_Checktarmacdescendingorder() throws Exception{

		/*US671614
		 * Below script will check the response have tarmac report greater than 15 and check its been displayed under appropriate objects in service
		 */
			String url="http://apapns86.pdc.aa.com:8080/GetNGServices/report/getTarmacReport";
			String urlCache="http://apapns86.pdc.aa.com:8080/GetNGServices/report/getTarmacReport";
		//	String Stations[] = {"DFW","PHL"};
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
				correction.CheckTarmacdescending(url,request,urlCache,sta);
			}	
		
	 
	}
	
}