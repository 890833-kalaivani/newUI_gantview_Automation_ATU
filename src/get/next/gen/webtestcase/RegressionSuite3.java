package get.next.gen.webtestcase;
import get.next.gen.commonaction.CommonTest;
import get.next.gen.serviceutils.correction;
import get.next.gen.utilities.Alertingflightstatsvalidation;
import get.next.gen.utilities.CloseOut;
import get.next.gen.utilities.CustomZone;
import get.next.gen.utilities.DashboardFilterOptionValidation;
import get.next.gen.utilities.DiversonReport;
import get.next.gen.utilities.EventDetailsValidation;
import get.next.gen.utilities.FlightStatsconfirmation;
import get.next.gen.utilities.GanntViewHeaderFunctionality;
import get.next.gen.utilities.GanttviewPuckOptions;
import get.next.gen.utilities.HoverValidation;
import get.next.gen.utilities.Hybridview;
import get.next.gen.utilities.InternationalDomestic;
import get.next.gen.utilities.Lazyloading;
import get.next.gen.utilities.Multialert;
import get.next.gen.utilities.PuckColorValidation;
import get.next.gen.utilities.PuckUIPlacement;
import get.next.gen.utilities.RampopenClose;
import get.next.gen.utilities.ResetSettings;
import get.next.gen.utilities.SearchValidation;
import get.next.gen.utilities.SortFunctionalityvalidation;
import get.next.gen.utilities.UpdateETD;
import get.next.gen.utilities.consolidatedcrewreport;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import atu.testng.reports.ATUReports;
import atu.testng.reports.logging.LogAs;
public class RegressionSuite3 extends CommonTest {
	@Parameters({ "browser", "Environment" })	
	@Test(priority = 0)
	public void TS01_LoginTestcase(String browser, String Environment) throws Exception {
		Memoryused();
		System.out.println("url: "+Environment+"");
		GanntViewHeaderFunctionality.Login(Environment);
		DashboardFilterOptionValidation.StatsoptionExist();
		DashboardFilterOptionValidation.StatsoptionSelection();
		DashboardFilterOptionValidation.SelectAllStatistics();
		Thread.sleep(1000);
		Memoryused();
	}
	@Test(priority = 1)
	public void TS02_GanttviewSelection() throws Exception {
		GanntViewHeaderFunctionality.GanntViewSelection();
		Memoryused();
	}
	
		///////////////////////////////////////////////////////////////////////////
	
	
	
	
	///////////////////////////////////////////////////////////////////////////////////
	
	/////////////////////////////////////////////////////////////////////////////////	
	
	@Test(priority = 38)
	public void TS38_Verifydifferentpucksize() throws Exception {
		GanntViewHeaderFunctionality.PuckFontSizeValidation();
		Memoryused();
	}
	@Test(priority = 39)
	public void TS39_VerifyRealtimebarExistance() throws Exception {
		GanntViewHeaderFunctionality.GanntViewSelection();
		System.out.println("Verify Realtime bar is present in the gantt view");
		GanntViewHeaderFunctionality.RealtimeBar();
		Memoryused();
	}
	@Test(priority = 40)
	public void TS40_VerifyFlightbetweentimerange() throws Exception {
		//have doubt
		//GanntViewHeaderFunctionality.Betweentimerange();
		Memoryused();
	}
	@Test(priority = 41)
	public void TS41_VerifySortGatebyAscendingorder() throws Exception {
		SortFunctionalityvalidation.SortGateAscending();
		Memoryused();
	}
	@Test(priority = 42)
	public void TS42_VerifySortGatebyDescendingorder() throws Exception {
		SortFunctionalityvalidation.SortGateDescending();
		Memoryused();
	}
	@Test(priority = 43)
	public void TS43_VerifySearchinGanttview() throws Exception {
		SearchValidation.SearchWithValidSearchkey("Ganttview");
		Memoryused();
	}
	@Test(priority = 44)
	public void TS44_VerifySearchwithinvalidkey() throws Exception {
		SearchValidation.SearchWithINValidSearchkey("Ganttview");
		Memoryused();
	}
	@Test(priority = 45)
	public void TS45_CheckHoverDetails() throws Exception {
		HoverValidation.HoverDisplayValidation();
		Memoryused();
	}
	@Test(priority = 46)
	public void TS46_ShouldShowTotalGates() throws Exception {
		//GanntViewHeaderFunctionality.ConfirmTotalGates("Ganttview");
		//Memoryused();
	}
	@Test(priority = 47)
	public void TS47_VerifyZoominZoomouticonPresence() throws Exception {
		CommonTest.zoomin();
		CommonTest.zoomOut();
		Memoryused();
	}
	
	@Test(priority = 88)
	public void TS88_VerifyMultipleAlerticonspresent() throws Exception {
		Alertingflightstatsvalidation.VerifyMultipleAlertsicons("Ganttview");
		Memoryused();
	}
	@Test(priority = 89)
	public void TS89_VerifyAlertingflightstatistics() throws Exception {
		//No more valid
		//	Alertingflightstatsvalidation.VerifyAlertstatspresent("Ganttview");
	}
	@Test(priority = 90)
	public void TS90_VerifyMessageforblockedSelected() throws Exception {
		Alertingflightstatsvalidation.VerifyMessagewhennoflightsforBlocked("Ganttview");
		Memoryused();
	}
	@Test(priority = 91)
	public void TS91_VerifyMessageforYellowSelected() throws Exception {
		Alertingflightstatsvalidation.VerifyMessagewhennoflightsforYellow("Ganttview");
		Memoryused();
	}
	@Test(priority = 92)
	public void TS92_VerifyMessageforTotalSelected() throws Exception {
		//Alertingflightstatsvalidation.VerifyMessagewhennoflightsforTotal("Ganttview");
		//Memoryused();
	}
	@Test(priority = 93)
	public void TS93_VerifyMessageforRedSelected() throws Exception {
		Alertingflightstatsvalidation.VerifyMessagewhennoflightsforRED("Ganttview");
		Memoryused();
	}
	@Test(priority = 94)
	public void TS94_VerifyBlockedflightinMaroon() throws Exception {
		Alertingflightstatsvalidation.VerifyBlockedhaveMaroonColor("Ganttview");
		Memoryused();
	}
	@Test(priority = 95)
	public void TS95_VerifyYellowalertflightsshownYellow() throws Exception {
		Alertingflightstatsvalidation.VerifyYellowStatshaveyellowcolor("Ganttview");
		Memoryused();
	}
	@Test(priority = 96)
	public void TS96_VerifyRedalertflightshownRed() throws Exception {
		Alertingflightstatsvalidation.VerifyRedStatshaveRedcolor("Ganttview");
		Memoryused();
	}
	@Test(priority = 97)
	public void TS97_VerifyEventdetailsPage() throws Exception {
		EventDetailsValidation.EventAlertDetailsPopupselection();
		Memoryused();
	}
	@Test(priority = 98)
	public void TS98_VerifySlideoutdatadisplayed() throws Exception {
		EventDetailsValidation.CheckContentsinSlideOut();
		Memoryused();
	}
	

	
	


	@Test(priority = 105)
	public void TS105_CustomZoneCreation() throws Exception {
		CustomZone.customzonecreation();
		Memoryused();
	}
	@Test(priority = 106)
	public void TS106_CustomZonedeletion() throws Exception {
		CustomZone.customzonedeletion();
		Memoryused();
	}
	@Test(priority = 107)
	public void TS107_RampOpen() throws Exception {
		//RampopenClose.RampOpen();
	}
	@Test(priority = 108)
	public void T108_RampClose() throws Exception {
		//RampopenClose.RampClose();
	}
	@Test(priority = 109)
	public void TS109_TestmessageOn() throws Exception {
		//	RampopenClose.TestmessageOn();
	}
	@Test(priority = 110)
	public void TS110_TestmessageOFF() throws Exception {
		//RampopenClose.TestmessageOFF();
	}
	@Test(priority = 111)
	public void TS111_Verifysamestatusappliedasopen() throws Exception {
		//RampopenClose.samestatusappliedasopen();
	}
	@Test(priority = 112)
	public void TS112_Verifysamestatusappliedasclose() throws Exception {
		//RampopenClose.samestatusappliedasclose();
	}
	@Test(priority = 113)
	public void TS113_VerifyErrorMessagevalidation() throws Exception {
		//RampopenClose.Errorvalidationfortime();
	}
	@Test(priority = 114)
	public void TS114_RampYellow() throws Exception {
		//RampopenClose.RampYellow();
	}
	@Test(priority = 115)
	public void TS115_FittoScreen() throws Exception {
		PuckUIPlacement.FittoScreen();
		Memoryused();
	}
	@Test(priority = 116)
	public void TS116_Guidelines() throws Exception {
		PuckUIPlacement.Guidelines();
		Memoryused();
	}
	@Test(priority = 117)
	public void TS117_StatSelection() throws Exception {
		DashboardFilterOptionValidation.StatsoptionExist();
		DashboardFilterOptionValidation.StatsoptionSelection();
		Memoryused();
	}
	@Test(priority = 118)
	public void TS118_VerifyallStatsareSelected() throws Exception {
		DashboardFilterOptionValidation.SelectAllStatistics();
		Memoryused();
	}
	@Test(priority = 119)
	public void TS119_VerifyGanttviewpuckOption() throws Exception {
		GanttviewPuckOptions.GanttviewSettingsvalidation();
		Memoryused();
	}
	@Test(priority = 128)
	public void TS128_CheckShowETDOutside() throws Exception {
		DashboardFilterOptionValidation.CheckShowETDoutside();
		Memoryused();
	}
	@Test(priority = 129)
	public void TS129_DrawtoActualGT() throws Exception {
		DashboardFilterOptionValidation.DrawtoActualGT();
		Memoryused();
	}
	@Test(priority = 130)
	public void TS130_ValidateDayandnightmode() throws Exception {
		DashboardFilterOptionValidation.CheckDaynightenabling();
		Memoryused();
	}
	@Test(priority = 131)
	public void TS131_CheckDashboardrenamed() throws Exception {
		DashboardFilterOptionValidation.CheckDashboardrenamed();
		Memoryused();
	}
	@Test(priority = 133)
	public void TS132_CheckConsolidatedReport() throws Exception {
		String url="http://apapns43.pdc.aa.com:8080/GetNGServices/flight/getFlightsForGivenTime";
		String urlCache="http://apapns45.pdc.aa.com:8081/GetCrewCache/crew/getCrewAlertReport";
		String Stations[] = {"DFW","PHL","CLT","LAX","LGA","PIT","RDU","MIA","PHX","SFO","ORD","ABE","BOS","BPT","CHO","DTW","FRA","IAD","IAH","JFK","MAD","OGG","OKC","PHL","PIA","PIB",
				"PLS","PNS","POP","POS","PSP","PTP","PTY","PUJ","PVD","PVG","PVR","PWM","SJO","SJT","SJU","STL","STS","STT","SYD","SYR"};
		String Starttime = correction.getpasthrs("America/Chicago",6);
		String Endtime = correction.nexthrs("America/Chicago",2);
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date = new java.util.Date();
		String dateWithoutTime =dateFormat.format(date);   //"02 May 2016"; 
		String strStartTime2 = dateWithoutTime + "T" + Starttime +".737Z";
		String strEndTime2 = dateWithoutTime + "T" + Endtime +".737Z";
		for( int i = 0; i < Stations.length; i++)
		{
			String request="{\"station\":\""+Stations[i]+"\",\"startTime\":\""+strStartTime2+"\",\"endTime\":\""+strEndTime2+"\",\"gates\":[],\"allGates\":true,\"pastFlights\":true,\"transactionId\":\"UNKNOWN_00812339_PHX_1489539768116_201\"}";
			String request2="{\"station\":\""+Stations[i]+"\",\"startTime\":\""+strStartTime2+"\",\"endTime\":\""+strEndTime2+"\",\"pastFlights\":false,\"iatacode\":null,\"gates\":null,\"narrowBody\":true,\"wideBody\":true,\"internationalFlts\":true,\"domesticFlts\":true,\"alertCountsReq\":false,\"transactionId\":\"UNKNOWN-0.0.00000_00789696_DFW_1517406950252_201\"}";
			ATUReports.add("****************Request for flights for given time "+request+"  ********",  LogAs.INFO, null);
			ATUReports.add("****************Request for Consolidated crew report "+request2+"  ********",  LogAs.INFO, null);
			System.out.println(" ");
			System.out.println(Stations[i]);
			String stationname = Stations[i];
			String Alerting = correction.getAlertingstation(url, request, urlCache, request2, stationname);
			if(Alerting.contains("Null")){
			}
			else{
				CustomZone.SelectStation(stationname);
				consolidatedcrewreport.Checkconsolidatedcrewicon();
				break;
			}
		}
		Memoryused();
	}
	@Test(priority = 134)
	public void TC_402_VerifyCrewiconhavebubbleandtitle() throws Exception {
		consolidatedcrewreport.Bubbleholdcountwhencrewalerts();
		Memoryused();
	}	
	@Test(priority = 135)
	public void TS133_VerifyHeaderofCrewReport() throws Exception {
		consolidatedcrewreport.Crewreportholdsreuiredtitle();
		Memoryused();
	}
	@Test(priority = 136)
	public void TS136_CheckSortFunctionality() throws Exception {
		consolidatedcrewreport.CrewSortAscendingDescending();
		Memoryused();
	}	
	@Test(priority = 137)
	public void TS137_CheckSearchFunctionality() throws Exception {
		consolidatedcrewreport.Searchfunctionality();
		Memoryused();
	}
	@Test(priority = 138)
	public void TS138_VerifyredandyellowConnex() throws Exception {
		consolidatedcrewreport.Crewalertcoloring();
		Memoryused();
	}	
	@Test(priority = 139)
	public void TS139_Offandoutflightshouldnotpresent() throws Exception {
		consolidatedcrewreport.Offandoutflightshouldnotpresent();
		Memoryused();
	}
	@Test(priority = 140)
	public void TS140_ConnexdiffofETDETA() throws Exception {
		//	consolidatedcrewreport.ConnexdiffofETDETA();
		Memoryused();
	}
	@Test(priority = 141)
	public void TS141_Checketdlesthan360() throws Exception {
		consolidatedcrewreport.Checketdlesthan360();
		Memoryused();
	}
	/*
				@Test(priority = 142)
				public void TS404_VerifyNocrewalerting() throws Exception {
					String url="http://apapns43.pdc.aa.com:8080/GetNGServices/flight/getFlightsForGivenTime";
					String urlCache="http://apapns45.pdc.aa.com:8081/GetCrewCache/crew/getCrewAlertReport";
					String Stations[] = {"DFW","PHL","CLT","LAX","LGA","PIT","RDU","MIA","PHX","SFO","ORD","ABE","BOS","BPT","CHO","DTW","FRA","IAD","IAH","JFK","MAD","OGG","OKC","PHL","PIA","PIB",
							"PLS","PNS","POP","POS","PSP","PTP","PTY","PUJ","PVD","PVG","PVR","PWM","SJO","SJT","SJU","STL","STS","STT","SYD","SYR"};
					String Starttime = correction.getpasthrs("America/Chicago",6);
					String Endtime = correction.nexthrs("America/Chicago",2);
					DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
					java.util.Date date = new java.util.Date();
					String dateWithoutTime =dateFormat.format(date);   //"02 May 2016"; 
					String strStartTime2 = dateWithoutTime + "T" + Starttime +".737Z";
					String strEndTime2 = dateWithoutTime + "T" + Endtime +".737Z";
					for( int i = 0; i < Stations.length; i++)
					{
					String request="{\"station\":\""+Stations[i]+"\",\"startTime\":\""+strStartTime2+"\",\"endTime\":\""+strEndTime2+"\",\"gates\":[],\"allGates\":true,\"pastFlights\":true,\"transactionId\":\"UNKNOWN_00812339_PHX_1489539768116_201\"}";
					String request2="{\"station\":\""+Stations[i]+"\",\"startTime\":\""+strStartTime2+"\",\"endTime\":\""+strEndTime2+"\",\"pastFlights\":false,\"iatacode\":null,\"gates\":null,\"narrowBody\":true,\"wideBody\":true,\"internationalFlts\":true,\"domesticFlts\":true,\"alertCountsReq\":false,\"transactionId\":\"UNKNOWN-0.0.00000_00789696_DFW_1517406950252_201\"}";
					ATUReports.add("****************Request for flights for given time "+request+"  ********",  LogAs.INFO, null);
					ATUReports.add("****************Request for Consolidated crew report "+request2+"  ********",  LogAs.INFO, null);
					System.out.println(" ");
					System.out.println(Stations[i]);
					String stationname = Stations[i];
					String Alerting = correction.getAlertingstation(url, request, urlCache, request2, stationname);
					if(Alerting.contains("Null")){
						CustomZone.SelectStation(stationname);
						consolidatedcrewreport.Checkconsolidatedcrewicon();
						consolidatedcrewreport.NoCrewdetailsReportmessage();
						break;
					}
					else{
						//CustomZone.SelectStation(stationname);
						//consolidatedcrewreport.Checkconsolidatedcrewicon();
						//break;
					}
					}
					consolidatedcrewreport.closecrewreport();
				}	
	 */
	@Test(priority = 145)
	public void TS142_lastsortsave() throws Exception {
		consolidatedcrewreport.Savesortsession();
		Memoryused();
	}	
	@Test(priority = 146)
	public void TS146_CheckSlidersessionsaved() throws Exception {
		consolidatedcrewreport.CheckSliderexist();
		//	consolidatedcrewreport.Slidersessionsaved();
		Memoryused();
	}	
	@Test(priority = 147)
	public void TS147_UNCheckShowETDOutside() throws Exception {
		DashboardFilterOptionValidation.UNCheckShowETDOutside();
		Memoryused();
	}
	@Test(priority = 148)
	public void TS148_DonotshowGuidelines() throws Exception {
		PuckUIPlacement.DonotshowGuidelines();
		Memoryused();
	}
	@Test(priority = 149)
	public void TS149_DonotdisplayDrawtoActualGT() throws Exception {
		DashboardFilterOptionValidation.DonotdisplayDrawtoActualGT();
		Memoryused();
	}
	@Test(priority = 150)
	public void TS150_Atlasiconinslideout() throws Exception {
		EventDetailsValidation.Atlasiconexistance();
		Memoryused();
	}
	@Test(priority = 151)
	public void TS151_VerifyGanttviewHeaderAtlasGalley() throws Exception {
		GanntViewHeaderFunctionality.AtlasCheck("Ganttview");
		Memoryused();
	}
	@Test(priority = 152)
	public void TS152_VerifySortArrivaltimeAscending() throws Exception {
		//	SortFunctionalityvalidation.SortArrivaltimeAscending();
		//	Memoryused();
	}
	@Test(priority = 153)
	public void TS153_VerifySortArrivaltimeDescending() throws Exception {
		//	SortFunctionalityvalidation.SortArrivaltimeDescending();
		//		Memoryused();
	}
	@Test(priority = 154)
	public void TS154_VerifySortDeparturetimeAscending() throws Exception {
		//	SortFunctionalityvalidation.SortDeparturetimeAscending();
		//Memoryused();
	}
	@Test(priority = 155)
	public void TS155_VerifySortDeparturetimeDescending() throws Exception {
		//	SortFunctionalityvalidation.SortDeparturetimeDescending();
		//	Memoryused();
	}
	@Test(priority = 156)
	public void TS156_VerifySortAscendingbyarrivalstatus() throws Exception {
		//SortFunctionalityvalidation.SortAscendingbyarrivalstatus();
		//Memoryused();
	}
	@Test(priority = 157)
	public void TS157_SortDescendingbyarrivalstatus() throws Exception {
		//SortFunctionalityvalidation.SortDescendingbyarrivalstatus();
		//Memoryused();
	}
	@Test(priority = 158)
	public void TS158_VerifySortAscendingbyDeparturestatus() throws Exception {
		//SortFunctionalityvalidation.SortAscendingbyDeparturestatus();
		//Memoryused();
	}
	@Test(priority = 159)
	public void TS159_VerifySortDescendingbyDeparturestatus() throws Exception {
		//SortFunctionalityvalidation.SortDescendingbyDeparturestatus();
		//Memoryused();
	}
	/*
										@Test(priority = 169)
										public void T1000_Memoryusage() throws Exception {
											ArrayList<Long> Memoryvalues = new ArrayList<Long>();	
											ArrayList<Long> Memoryvalues1 = new ArrayList<Long>();
											for(int lp =0;lp<=53;lp++){
											//	System.out.println(">>......  "+lp);	
												//ATUReports.add(">>......  "+lp, LogAs.PASSED, null); 
												try{
													//Wait 5 minutes
											Thread.sleep(300000);
											System.out.println(">>......");
											ATUReports.add(">>......", LogAs.PASSED, null); 
											Long mem = Memoryused();
											Memoryvalues.add(mem);
											GanntViewHeaderFunctionality.Selectview("Ganntview");
											//Wait 5 minutes
											Thread.sleep(300000);
											System.out.println(">>...");
											ATUReports.add(">>......", LogAs.PASSED, null); 
											Long mem2 = Memoryused();
											Memoryvalues.add(mem2);
											GanntViewHeaderFunctionality.Selectview("Hybridview");
												launchApp(Web_UI.Url);
												Thread.sleep(5000);
												for(int lp1 =0;lp1<=19;lp1++){
													//	System.out.println(">>......  "+lp);	
														//ATUReports.add(">>......  "+lp, LogAs.PASSED, null); 
															//Wait 5 minutes
													Thread.sleep(300000);
													System.out.println(">>......");
													ATUReports.add(">>......", LogAs.PASSED, null); 
													Long mem3 = Memoryused();
													Memoryvalues.add(mem2);
													GanntViewHeaderFunctionality.Selectview("Ganntview");
													//Wait 5 minutes
													Thread.sleep(300000);
													System.out.println(">>...");
													ATUReports.add(">>......", LogAs.PASSED, null); 
													Long mem4 = Memoryused();
													Memoryvalues.add(mem2);
													GanntViewHeaderFunctionality.Selectview("Hybridview");
														}
												}
														catch(Exception ed){
													}
											}
											ATUReports.add(Memoryvalues.toString(), LogAs.PASSED, null); 
											Exportmemoryvalue(Memoryvalues);
										}
	 */
	/*			
										@Test(priority = 161)
										 public void TS161_Tarmacgreaterthan15Validation() throws Exception{
											/*US671614
	 * Below script will check the response have tarmac report greater than 15 and check its been displayed under appropriate objects in service
	 */
	//			String url="http://apapns86.pdc.aa.com:8080/GetNGServices/report/getTarmacReport";
	//			String urlCache="http://apapns86.pdc.aa.com:8080/GetNGServices/report/getTarmacReport";
	//			String Stations[] = {"DFW","PHL"};
	//												String Stations[] = {"DFW","PHL","LAX","ABE","ABI","ABQ","ACT","AEX","AGS","AGU","AKL","ALB","ALO","AMA","AMS","ANC","ANU","ART","ATH","ATL","AUA","AUS","AVL","AVP","AZO","BAQ","BCN","BDA","BDL","BFI","BFL","BFM","BGI","BGR","BHM","BIS","BJX","BMI","BNA","BOG","BOI","BOS","BPT","BRO","BSB","BTR","BTV","BUF","BUR","BWI","BZE","BZN","CAE","CAK","CAP",
	//													"CCS","CDG","CFG","CHA","CHO","CHS","CID","CKB","CLE","CLL","CLO","CLT","CMH","CMI","CMW","CNF","COS","COU","CRP","CRW","CUN","CUR","CUU","CVG","CWA","CYS","CZM",
	//													"DAB","DAY","DBQ","DCA","DEN","DRO","DSM","DTW","DUB","EDI","ELH","ELP","ERI","EUG","EVV","EWN","EWR","EYW","EZE","FAR","FAT","FAY","FCO","FDF","FLG","FLL","FLO",
	//													"FNT","FPO","FRA","FSD","FSM","FWA","GCK","GCM","GDL","GEG","GGG","GGT","GIG","GJT","GLA","GND","GNV","GPT","GRB","GRI","GRK","GRR","GRU","GSO","GSP","GUA","GUS",
	//													"GYE","HAV","HHH","HKG","HMO","HND","HNL","HOG","HOU","HPN","HSV","HTS","HVN","IAD","IAH","ICT","IFP","ILM","IND","IPT","ISP","ITH","JAN","JAX","JFK","JLN",
	//													"KIN","KOA","LAN","LAS","LAW","LBB","LCH","LEX","LFT","LGA","LGB","LHR","LIH","LIM","LIR","LIS","LIT","LPB","LRD","LSE","LYH","MAD","MAF","MAN","MAO","MAR","MBJ",
	//													"MCI","MCO","MDE","MDT","MEI","MEM","MEX","MFE","MGA","MGM","MHH","MHK","MHT","MIA","MKE","MLB","MLI","MLM","MLU","MOB","MQT","MRY","MSN","MSP","MSY","MTJ","MTY",
	//													"MUC","MVD","MXP","MYR","MZT","NAS","NRT","OAJ","OAK","OGG","OKC","OMA","ONT","ORD","ORF","PAP","PBC","PBI","PDX","PEK","PGV","PHF","PHL","PHX","PIA","PIB","PIT",
	//													"PLS","PNS","POP","POS","PSP","PTP","PTY","PUJ","PVD","PVG","PVR","PWM","QRO","RAP","RDM","RDU","RFD","RIC","RME","RNO","ROA","ROC","ROW","RST","RSW","RTB",
	//													"SAF","SAL","SAN","SAP","SAT","SAV","SBA","SBP","SBY","SCE","SCL","SDF","SDQ","SEA","SFO","SGF","SGU","SHV","SJC","SJD","SJO","SJT","SJU","SKB","SLC","SLP",
	//													"SMF","SNA","SNN","SNU","SPI","SPS","SRQ","STI","STL","STS","STT","STX","SUX","SWF","SWO","SXM","SYD","SYR","TGU","TLH","TOL","TPA","TRC","TRI","TUL","TUS","TVC",
	//													"TXK","TYR","TYS","UIO","UVF","VCE","VPS","VRA","VVI","XNA","YOW","YUL","YUM","YVR","YYC","YYZ","ZCL","ZIH","ZRH","ZSA"};
	//	for( int i = 0; i < Stations.length; i++)
	//		{	
	//			String sta = Stations[i];
	//		System.out.println("station   :"+ sta);
	//			String request="{\"station\": \""+sta+"\"}";
	//			correction.Tarmacgreaterthan15startcode(url,request,urlCache,sta);
	//	}	
	//}
	//		@Test(priority = 162)
	//		 public void TS162_Checktarmacdescendingorder() throws Exception{
	/*US671614
	 * Below script will check the response have tarmac report greater than 15 and check its been displayed under appropriate objects in service
	 */
	///				String url="http://apapns86.pdc.aa.com:8080/GetNGServices/report/getTarmacReport";
	//				String urlCache="http://apapns86.pdc.aa.com:8080/GetNGServices/report/getTarmacReport";
	//				String Stations[] = {"DFW","PHL"};
	//	String Stations[] = {"DFW","PHL","LAX","ABE","ABI","ABQ","ACT","AEX","AGS","AGU","AKL","ALB","ALO","AMA","AMS","ANC","ANU","ART","ATH","ATL","AUA","AUS","AVL","AVP","AZO","BAQ","BCN","BDA","BDL","BFI","BFL","BFM","BGI","BGR","BHM","BIS","BJX","BMI","BNA","BOG","BOI","BOS","BPT","BRO","BSB","BTR","BTV","BUF","BUR","BWI","BZE","BZN","CAE","CAK","CAP",
	//			"CCS","CDG","CFG","CHA","CHO","CHS","CID","CKB","CLE","CLL","CLO","CLT","CMH","CMI","CMW","CNF","COS","COU","CRP","CRW","CUN","CUR","CUU","CVG","CWA","CYS","CZM",
	//				"DAB","DAY","DBQ","DCA","DEN","DRO","DSM","DTW","DUB","EDI","ELH","ELP","ERI","EUG","EVV","EWN","EWR","EYW","EZE","FAR","FAT","FAY","FCO","FDF","FLG","FLL","FLO",
	//				"FNT","FPO","FRA","FSD","FSM","FWA","GCK","GCM","GDL","GEG","GGG","GGT","GIG","GJT","GLA","GND","GNV","GPT","GRB","GRI","GRK","GRR","GRU","GSO","GSP","GUA","GUS",
	//				"GYE","HAV","HHH","HKG","HMO","HND","HNL","HOG","HOU","HPN","HSV","HTS","HVN","IAD","IAH","ICT","IFP","ILM","IND","IPT","ISP","ITH","JAN","JAX","JFK","JLN",
	//				"KIN","KOA","LAN","LAS","LAW","LBB","LCH","LEX","LFT","LGA","LGB","LHR","LIH","LIM","LIR","LIS","LIT","LPB","LRD","LSE","LYH","MAD","MAF","MAN","MAO","MAR","MBJ",
	//				"MCI","MCO","MDE","MDT","MEI","MEM","MEX","MFE","MGA","MGM","MHH","MHK","MHT","MIA","MKE","MLB","MLI","MLM","MLU","MOB","MQT","MRY","MSN","MSP","MSY","MTJ","MTY",
	//			"MUC","MVD","MXP","MYR","MZT","NAS","NRT","OAJ","OAK","OGG","OKC","OMA","ONT","ORD","ORF","PAP","PBC","PBI","PDX","PEK","PGV","PHF","PHL","PHX","PIA","PIB","PIT",
	//				"PLS","PNS","POP","POS","PSP","PTP","PTY","PUJ","PVD","PVG","PVR","PWM","QRO","RAP","RDM","RDU","RFD","RIC","RME","RNO","ROA","ROC","ROW","RST","RSW","RTB",
	//				"SAF","SAL","SAN","SAP","SAT","SAV","SBA","SBP","SBY","SCE","SCL","SDF","SDQ","SEA","SFO","SGF","SGU","SHV","SJC","SJD","SJO","SJT","SJU","SKB","SLC","SLP",
	//				"SMF","SNA","SNN","SNU","SPI","SPS","SRQ","STI","STL","STS","STT","STX","SUX","SWF","SWO","SXM","SYD","SYR","TGU","TLH","TOL","TPA","TRC","TRI","TUL","TUS","TVC",
	//				"TXK","TYR","TYS","UIO","UVF","VCE","VPS","VRA","VVI","XNA","YOW","YUL","YUM","YVR","YYC","YYZ","ZCL","ZIH","ZRH","ZSA"};
	//		for( int i = 0; i < Stations.length; i++)
	//			{	
	//				String sta = Stations[i];
	//				System.out.println("station   :"+ sta);
	//			String request="{\"station\": \""+sta+"\"}";
	//			correction.CheckTarmacdescending(url,request,urlCache,sta);
	//		}	
	//}
	
	@Test(priority = 199)
	public void TS199_Closeoutflightsselection() throws Exception {
		CloseOut.SelectCloseout();
		Memoryused();
	}
	@Test(priority = 200)
	public void TS200_UnCloseoutflightsselection() throws Exception {
		CloseOut.UnSelectCloseout();
		Memoryused();
	}
	@Test(priority = 201)
	public void TS201_Verifywhennocloseoutflights() throws Exception {
		Alertingflightstatsvalidation.VerifyMessagewhennoflightsforCloseout("Ganttview");
		Memoryused();
	}
	@Test(priority = 202)
	public void TS202_VerifyGanttviewHeader_Closeout() throws Exception {
		GanntViewHeaderFunctionality.CloseoutCheck("Ganttview");
		Memoryused();
	}
	@Test(priority = 203)
	public void TS203_Verifycloseoutflightisshown() throws Exception {
		CloseOut.shouldshowcloseoutonly();
		Memoryused();
	}
	@Test(priority = 204)
	public void TS204_Verifycloseoutnotshownforschandoffflts() throws Exception {
		CloseOut.ShouldnotshowClosoutexceptoutstatus();
		Memoryused();
	}
	@Test(priority = 205)
	public void TS205_VerifyMessagecloseoutclicked() throws Exception {
		CloseOut.ShouldnotshowClosoutexceptoutstatus();
		Memoryused();
	}		
	@Test(priority = 206)
	public void TS206_Resetsettingsvalidation() throws Exception {
		ResetSettings.Validate_resetsettings();
	}
	@Test(priority = 207)
	public void TS207_ValidateMultialert() throws Exception {
		Multialert.Checkmultialertpresent();
		Multialert.Checkeventmultialertpresent();
	}
	@Test(priority = 208)
	public void TS208_ValidateMultialertpriority() throws Exception {
		System.out.println("TS208_ValidateMultialertpriority");
		Multialert.Checkmultialertpriority();
	}
	
		
	@Test(priority = 250)
	public void TS200_VerifyLogout() throws Exception {
		CommonTest.Logout();
		Memoryused();
	}
}
