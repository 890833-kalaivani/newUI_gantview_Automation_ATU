package get.next.gen.webtestcase;

import get.next.gen.commonaction.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;

import org.testng.annotations.Listeners;

import atu.testng.reports.listeners.ATUReportsListener;
import atu.testng.reports.listeners.ConfigurationListener;
import atu.testng.reports.listeners.MethodListener;
@Listeners({ ATUReportsListener.class, ConfigurationListener.class,
MethodListener.class })

public class Web_UI {
	public static String Browser;
	public static String Url;
	public static String SelectingAll;
	public static String Todaysdate;
	public static String Tomorrowdate;
	public static String DeselectAll;
	public static String Horizontalscrollbar;
	public static String StationDropdown;
	public static String StationDropdownselect;
	public static String fltlist;
	public static String LoginId;
	public static String Passwordid;
	public static String prodPwd;
	public static String Hamburgermenu;
	public static String Station;
	public static String  HybridCLOSEOUTS;
	public static String  HybridCLOSEOUTSCount;
	//Atlas galley
	
	public static String Atlas; 
	public static String AtlasCount;
	public static String HybridAtlas;
	public static String HybridAtlasCount;
	
	
	// Event Alert Validation
	public static String Passangeralert;
	public static String Flightlistoption;
	public static String FlightListTable;
	public static String FlightElement;
	public static String FlightNo;
	public static String GantviewOption;
	public static String FlightPuck;
	public static String Passangericon;
	public static String Bagicon;
	public static String Crewicon;
	public static String OFFLOADicon;
	public static String CLAIMSCANicon;
	public static String CABINicon;
	public static String LAVSicon;
	public static String WATERicon;
	public static String FUELINGicon;
	public static String CATERINGicon;
	public static String CloseoutStatscount;
	public static String PuckCompleteCenter;
	
	
	// Gantt view Header Functionality
	public static String Username;
	public static String Password;
	public static String Login;
	public static String Spinner;
	public static String Expandbutton;
	public static String ExpandCheckpoint;
	public static String Collapsebutton;
	public static String CollapseCheckpoint;
	public static String HoursBar;
	public static String HoursSplitup;
	public static String GanttTable;
	public static String GanttFlightList;
	public static String Searchbar;
	public static String NoSearchresult;
	public static String LateArrival;
	public static String GanttHeader;
	public static String GanttTablelist;
	public static String HybridViewOption;
	// Dashboard Events and flight properties

	public static String GateConflicts;
	public static String IFS;
	public static String MEL;
	public static String NarrowBody;
	public static String EarlyArrival;
	public static String ETD;
	public static String WideBody;
	public static String Diverted;
	public static String ACSwaps;
	public static String Mainline;
	public static String Canceled;
	public static String GateSwaps;
	public static String Passanger;
	public static String Bags;
	public static String Crew;
	public static String Offload;
	public static String Claimscan;
	public static String Fuel;
	public static String Cabin;
	public static String Catering;
	public static String LAV;
	public static String Water;
	public static String Decision;
	public static String Delayed;
	public static String MOGT_stats;
	public static String RightStart;
	public static String WeightRestricted;
	
	
	public static String Unlinked;
	public static String OTS;
	public static String Groundinterrupt;
	public static String A14;
	public static String MOGT;
	public static String Origin;
	public static String Term;
	public static String Inop;
	public static String connectMe;
	public static String HeaderViewTitle;
	
	public static String TotalGate;
	// GanntViewDataStatuscodeValidation

	public static String Status;
	public static String TailandDestination;
	public static String TailandDestinationHover;
	public static String ArrivalTime;
	public static String ArrivaltimeHover;
	public static String Departurestatusandtime;
	public static String Departurestatusandtimehover;
	public static String flightlinkage;
	public static String DestinationFlightNo;
	public static String OriginandEquipmenttype;
	public static String OriginandEquipmenttypeHover;
	public static String DepartureflightNo;
	
	
	//Hybrid View	
	public static String HybridAllGate;
	public static String HybridCancelled;
	public static String HybridETD;
	public static String HybridDecision;
	public static String HybridLatearrival;
	public static String HybridEarlyarrival;
	public static String HybridGateSwaps;
	public static String HybridAcSwaps;
	public static String HybridRightStart;
	public static String HybridPotential;
	public static String HybridIFS;
	public static String HybridDelayed;
	public static String HybridA14;
	public static String HybridRed;
	public static String HybridYellow;
	public static String HybridBlocked;
	public static String HybridToatalalert;
	
	public static String HybridGateConflict;
	public static String HybridOTS;
	public static String HybridMOGT;
	public static String HybridDiverted;
	public static String HybridMEL;
	public static String HybridORIGIN;
	public static String HybridTERM;
	public static String HybridUnlinked;
	public static String HybridWeightRestricted;
	//Hybrid Stats count
	
	public static String HybridAllGateCount;
	public static String HybridCancelledCount;
	public static String HybridETDCount;
	public static String HybridDecisionCount; 
	public static String HybridLatearrivalCount; 
	public static String HybridEarlyarrivalCount;
	public static String HybridGateSwapsCount; 
	public static String HybridAcSwapsCount; 
	public static String HybridRightStartCount;
	public static String HybridPotentialCount; 
	public static String HybridIFSCount; 
	public static String HybridA14Count;
	public static String HybridRedCount;
	public static String HybridYellowCount;
	public static String HybridBlockedCount;
	public static String HybridToatalalertCount; 
	public static String HybridDelayedCount;
	
	public static String HybridOffload; 
	public static String HybridClaimscan;
	public static String HybridBags; 
	public static String HybridPax; 
	public static String HybridCrew;
	public static String HybridCabin;
	public static String HybridLavs;
	public static String HybridWater;
	public static String HybridFuel; 
	public static String HybridCatering;
	
	public static String HybridGateConflictCount;
	public static String HybridOTSCount ;
	public static String HybridMOGTCount ;
	public static String HybridDivertedCount;
	public static String HybridMELCount;
	public static String HybridORIGINCount;
	public static String HybridTERMCount;
	public static String HybridUnlinkedCount;
	
	public static String HybridFuelCount;
	public static String HybridPaxCount ;
	public static String HybridBagscount ;
	public static String HybridCrewCount;
	public static String HybridOffloadCount;
	public static String HybridClaimscanCount;
	public static String HybridCabinCount;
	public static String HybridCateringCount;
	public static String HybridLavsCount;
	public static String HybridWaterCount;

	
	public static String LogoutMenu;
	public static String Signout;
	public static String Zoomout;
	public static String Zoomin;
	
	
	//FlightStats Count
	
	public static String CancelledStatsCount;
	public static String ETDStatsCount;
	public static String DecisionStatsCount;
	public static String LateArrivaStatsCount;
	public static String EarlyArrivalStatsCount;
	public static String OTSStatsCount;
	public static String GateSwapsStatsCount;
	public static String ACSwapsStatsCount;
	public static String RightstartStatsCount;
	public static String PotentialtowsStatsCount;
	public static String IFSStatsCount;
	public static String GateConflictsStatsCount;
	public static String DelayedStatsCount;
	public static String MOGTStatsCount;
	public static String InopStatsCount;
	public static String connectMeStatsCount;
	public static String A14StatsCount;
	public static String PassangerStatsCount;
	public static String BagsStatsCount;
	public static String CrewStatsCount;
	public static String OffloadStatsCount;
	public static String ClaimscanStatsCount;
	public static String FuelStatsCount;
	public static String CabinStatsCount;
	public static String CateringStatsCount;
	public static String LavsStatsCount;
	public static String WaterStatsCount;
	public static String TotalStatsCount;
	public static String DivertedStatsCount;
	public static String MELStatsCount;
	
	public static String UnlinkedCount;
	public static String OTSCount;
	public static String GroundinterruptCount;
	public static String A14Count;
	public static String MOGTCount;
	public static String OriginCount;
	public static String TermCount;
	
	public static String Blocked;
	public static String Red;
	public static String Yellow;
	public static String TotalAlerts;
	public static String BlockedCount;
	public static String RedCount;
	public static String YellowCount;
	public static String TotalAlertCount;
	
	//New
	public static String GanttViewHeader;
	public static String ConfirmTotalGatesHeader;
	public static String GanttHeaderText;
	public static String filtericon;
	public static String ZoneElementTable;
	public static String Slider;
	public static String SmallFont;
	public static String MediumFont;
	public static String LargeFont;
	public static String Realtimebar;
	public static String stationtime;
	public static String DashboardfilterCancel;
	public static String Headertitle;
	public static String Messageposted;
	public static String ViewSettings;
	public static String SettingPuckDefault;
	public static String SettingPuckCenter;
	public static String SettingShowcancelledflight;
	public static String SettingShowUnlinkedflight;
	public static String ApplyButton;
	public static String OKBUTTON;

	public static String AlertMessageposted;
	public static String SortAscendinggate;
	public static String  SortAscending;
	public static String  Expand;
	public static String Expandcheckpoint;
	public static String Collapse;
	
	
	//Puck Details
	 	public static String PuckComplete;
		public static String PuckCompleteArrivaldetails;
		public static String PuckCompleteDepartureDetails;
		public static String PuckCompleteLinkage;
		public static String PuckArrivalstationandEqptype;
		public static String PuckArrivaltimeandstatus;
		public static String PuckDepartureTailanddestination;
		public static String PuckDepartureStatusandtime;
		public static String PuckDepartureStation;
		public static String PuckArrivalStation;
		
		public static String Starttime;
		public static String Endtime;
		public static String Starttime1;
		public static String Endtime1;
		public static String Starttime2;
		public static String Endtime2;
		
		
		public static String Userrolepopup;
		public static String SelectUserroledropdown;
		public static String Setuserrole;
		public static String Continuesettinguserrole;
		public static String LoadSpinnercontroller;
		public static String LoadSpinnerresult;
		public static String pagerefreshdropdown;
		public static String Refreshbutton;
		public static String SettingsAdvancedTab;
		public static String Closebutton;
		public static String StationorZonetabselection;
		public static String ZoneLoadericon;
		public static String StatsOption;
		public static String Gateswapicons;
		public static String SettingPuckEnds;
		public static String SettingPuckTail;
		public static String SettingPuckClassic;
		public static String SchCheckpoint;
		public static String Schbutton;
		public static String DepCheckpoint;
		
		
		
		public static String Scrollbar;
		public static String ancestorid;
		public static String Searchiconfilter;
		public static String  ShowCanceled;
		public static String  ShowUnlinked;
		public static String Showsdt;
		public static String  Slideoutbelow;
		public static String Puckdefaultradio;
		public static String Resetbutton;
		public static String  Cancelinreset;
		public static String ResetAcceptbutton;
		public static String Guidelineoption;
		public static String Showetd;
		public static String  Showmogt;
		
		
		
		public static String  Crewconnexicon;
		public static String Crewconnexcount;
		public static String Crewreporttitle;
		public static String CrewHeaderitems;
		public static String POSSearchkey;
		public static String useridSearchkey;
		public static String EmpNameSearchkey;
		public static String ScantimeSearchkey;
		public static String FlightnoSearchkey;
		public static String EtdSearchkey;
		public static String GateSearchkey;
		public static String INBFltSearchkey;
		public static String ORIGINSearchkey;
		public static String Gate2Searchkey;
		public static String StatusSearchkey;
		public static String ETASearchkey;
		public static String Crewslider;
		

		public static String Crewpos;
		public static String Crewposspan;
		public static String Crewuserid;
		public static String Crewuseridspan;
		public static String CrewEmpName;
		public static String CrewEmpNamespan;
		public static String CrewScantime;
		public static String CrewScantimespan;
		public static String CrewFlightno;
		public static String CrewEtd;
		public static String CrewEtdspan;
		public static String CrewGate;
		public static String CrewGatespan;
		public static String CrewINBFlt;
		public static String CrewINBFltspan;
		public static String CrewORIGIN;
		public static String CrewORIGINspan;
		public static String CrewGate2;
		public static String CrewGate2span;
		public static String CrewStatus;
		public static String CrewStatusspan;
		public static String CrewETA;
		public static String CrewETAspan;
		public static String Crewconnex;
		public static String Crewconnexspan;
		public static String crewMOTFDP;
		public static String crewMOTFDPSpan;
		public static String CrewFlightnospan;
		public static String CrewNoreport;
		public static String CrewClosebutton;
		
		
		public static String resetconfirmtext;
		public static String SortAscendingArrivaltime ;
		public static String SortAscendingDeparturetime ;
		public static String SortAscendingArrivalstatus ;
		public static String SortAscendingDeaparturestatus;
		
		
		public static String StatsDiverted;
		public static String StatsDCN ;
		public static String StatsMEL;
		public static String StatsOTS ;
		public static String StatsRTD;
		public static String StatsGateSwap ;
    	public static String StatsAcSwap;
    	public static String StatsRightStart;
 		public static String StatsIFS;
		public static String StatsGateConflict;
		public static String StatsPotentialTows;
    	public static String StatsATCDelay;
		public static String StatsDelayedDep;
  		public static String StatsMOGT;
    	public static String Statsoriginated;
		public static String Statsterminated;
	     public static String Statsunlinked;
	    public static String StatsA14;
	    public static String 	StatsWeightRestricted;
		public static String StatsatlasGalley ;
		
		
		public static String Nightmodeenabled;
		public static String Scrollbarheight;
		public static String Closeslideout;
		public static String  Domesticradio;
		public static String Internationalradio;
		public static String Ganttheaderstatus;
		public static String Puckhover;
		public static String Settingstimerange;
		
		public static String  Confirmdefaultview; 
		public static String  Confirmtailview; 
		public static String  Confirmclassicview; 
		public static String PuckDatacenter;
		public static String  Daymodeenabled;
		
		//Settings
		public static String American_Advanced_ResetSettings; 
		public static String AmericanEagle_Advanced_ResetSettings;
		public static String NarrowBody_Advanced_ResetSettings;
		public static String wideBody_Advanced_ResetSettings;
		public static String international_Advanced_ResetSettings;
		public static String domestic_Advanced_ResetSettings;
		
		//Multialert
		public static String  leftMultialertIcon;
		
		//Quick Notes
		public static String arrivalFltStatus;
		public static String depFltStatus;
		
		
		
	public static void loadElementProperties() throws FileNotFoundException {
		try {

			/*InputStream is = CommonTest.class.getClass().getResourceAsStream("/AllVariables.properties");
			Properties elementProperties = new Properties();
			elementProperties.load(is);*/
			
			Properties elementProperties = new Properties();
			elementProperties.load(new FileInputStream(System.getProperty("user.dir")+"//src//AllVariables.properties"));
			
			Showmogt = elementProperties.getProperty("Showmogt"); 
			Showetd = elementProperties.getProperty("Showetd");
			Guidelineoption = elementProperties.getProperty("Guidelineoption");
			ResetAcceptbutton = elementProperties.getProperty("ResetAcceptbutton");
			Cancelinreset = elementProperties.getProperty("Cancelinreset");  
			Resetbutton = elementProperties.getProperty("Resetbutton"); 
			Puckdefaultradio = elementProperties.getProperty("Puckdefaultradio");
			Slideoutbelow = elementProperties.getProperty("Slideoutbelow");
			Showsdt = elementProperties.getProperty("Showedt");
			ShowUnlinked = elementProperties.getProperty("ShowUnlinked");
			ShowCanceled = elementProperties.getProperty("ShowCanceled");
			Searchiconfilter = elementProperties.getProperty("Searchiconfilter");
			StatsOption = elementProperties.getProperty("StatsOption");
			Userrolepopup = elementProperties.getProperty("Userrolepopup");
			SelectUserroledropdown = elementProperties.getProperty("SelectUserroledropdown");
			Setuserrole = elementProperties.getProperty("Setuserrole");
			Continuesettinguserrole = elementProperties.getProperty("Continuesettinguserrole");
			LoadSpinnercontroller = elementProperties.getProperty("LoadSpinnercontroller");
			LoadSpinnerresult = elementProperties.getProperty("LoadSpinnerresult");
			pagerefreshdropdown = elementProperties.getProperty("pagerefreshdropdown");
			Refreshbutton = elementProperties.getProperty("Refreshbutton");
			SettingsAdvancedTab = elementProperties.getProperty("SettingsAdvancedTab");
			Closebutton = elementProperties.getProperty("Closebutton");
			StationorZonetabselection = elementProperties.getProperty("StationorZonetabselection");
			ZoneLoadericon = elementProperties.getProperty("ZoneLoadericon");
			Gateswapicons = elementProperties.getProperty("Gateswapicons");
			SettingPuckEnds = elementProperties.getProperty("SettingPuckEnds");
			SettingPuckTail = elementProperties.getProperty("SettingPuckTail");
			SettingPuckClassic = elementProperties.getProperty("SettingPuckClassic");
			Horizontalscrollbar = elementProperties.getProperty("Horizontalscrollbar");
			Atlas = elementProperties.getProperty("Atlas");
			AtlasCount = elementProperties.getProperty("AtlasCount");
			HybridAtlas = elementProperties.getProperty("HybridAtlas");
			HybridAtlasCount = elementProperties.getProperty("HybridAtlasCount");
			
			
			Scrollbar = elementProperties.getProperty("Scrollbar");
			ancestorid = elementProperties.getProperty("ancestorid");
			
			
			DepCheckpoint = elementProperties.getProperty("DepCheckpoint");
			SchCheckpoint = elementProperties.getProperty("SchCheckpoint");
			Schbutton = elementProperties.getProperty("Schbutton");
			Starttime = elementProperties.getProperty("Starttime");
			Endtime = elementProperties.getProperty("Endtime");
			Starttime1 = elementProperties.getProperty("Starttime1");
			Endtime1 = elementProperties.getProperty("Endtime1");
			Starttime2 = elementProperties.getProperty("Starttime2");
			Endtime2 = elementProperties.getProperty("Endtime2");
			
			Browser = elementProperties.getProperty("Browser");
			Url = elementProperties.getProperty("Url");
			Todaysdate = elementProperties.getProperty("Todaysdate");
			Tomorrowdate = elementProperties.getProperty("Tomorrowdate");
			SelectingAll = elementProperties.getProperty("SelectingAll");
			DeselectAll = elementProperties.getProperty("DeselectAll");
			StationDropdown = elementProperties.getProperty("StationDropdown");
			StationDropdownselect = elementProperties.getProperty("StationDropdownselect");
			fltlist = elementProperties.getProperty("fltlist");
			LoginId = elementProperties.getProperty("LoginId");
			Passwordid = elementProperties.getProperty("Passwordid");
			prodPwd = elementProperties.getProperty("prodPwd");
			Station = elementProperties.getProperty("Station");
			Hamburgermenu = elementProperties.getProperty("Hamburgermenu");
			// Event Alert Validation
			Passangeralert = elementProperties.getProperty("Passangeralert");
			Flightlistoption = elementProperties.getProperty("Flightlistoption");
			FlightListTable = elementProperties.getProperty("FlightListTable");
			FlightElement = elementProperties.getProperty("FlightElement");
			FlightNo = elementProperties.getProperty("FlightNo");
			GantviewOption = elementProperties.getProperty("GantviewOption");
			FlightPuck = elementProperties.getProperty("FlightPuck");
			Passangericon = elementProperties.getProperty("Passangericon");
			Bagicon = elementProperties.getProperty("Bagicon");
			Crewicon = elementProperties.getProperty("Crewicon");
			OFFLOADicon = elementProperties.getProperty("OFFLOADicon");
			CLAIMSCANicon = elementProperties.getProperty("CLAIMSCANicon");
			CABINicon = elementProperties.getProperty("CABINicon");
			LAVSicon = elementProperties.getProperty("LAVSicon");
			WATERicon = elementProperties.getProperty("WATERicon");
			FUELINGicon = elementProperties.getProperty("FUELINGicon");
			CATERINGicon = elementProperties.getProperty("CATERINGicon");
			
			

			// Gantt view Header Functionality
			Username = elementProperties.getProperty("Username");
			Password = elementProperties.getProperty("Password");
			Login = elementProperties.getProperty("Login");
			Spinner = elementProperties.getProperty("Spinner");
			Expandbutton = elementProperties.getProperty("Expandbutton");
			ExpandCheckpoint = elementProperties.getProperty("ExpandCheckpoint");
			Collapsebutton = elementProperties.getProperty("Collapsebutton");
			CollapseCheckpoint = elementProperties.getProperty("CollapseCheckpoint");
			HoursBar = elementProperties.getProperty("HoursBar");
			HoursSplitup = elementProperties.getProperty("HoursSplitup");
			GanttTable = elementProperties.getProperty("GanttTable");
			GanttFlightList = elementProperties.getProperty("GanttFlightList");
			Searchbar = elementProperties.getProperty("Searchbar");
			LateArrival = elementProperties.getProperty("LateArrival");
			GanttHeader = elementProperties.getProperty("GanttHeader");
			GanttTablelist = elementProperties.getProperty("GanttTablelist");
			// Dashboard Events and flight properties

			GateConflicts = elementProperties.getProperty("GateConflicts");
			MEL = elementProperties.getProperty("MEL");
			NarrowBody = elementProperties.getProperty("NarrowBody");
			EarlyArrival = elementProperties.getProperty("EarlyArrival");
			ETD = elementProperties.getProperty("ETD");
			WideBody = elementProperties.getProperty("WideBody");
			Diverted = elementProperties.getProperty("Diverted");
			ACSwaps = elementProperties.getProperty("ACSwaps");
			Mainline = elementProperties.getProperty("Mainline");
			Canceled = elementProperties.getProperty("Canceled");
			GateSwaps = elementProperties.getProperty("GateSwaps");
			Passanger = elementProperties.getProperty("Passanger");
			Bags = elementProperties.getProperty("Bags");
			Crew = elementProperties.getProperty("Crew");
			Offload = elementProperties.getProperty("Offload");
			Claimscan = elementProperties.getProperty("Claimscan");
			Fuel = elementProperties.getProperty("Fuel");
			Cabin = elementProperties.getProperty("Cabin");
			Catering = elementProperties.getProperty("Catering");
			LAV = elementProperties.getProperty("LAV");
			Water = elementProperties.getProperty("Water");
			Decision = elementProperties.getProperty("Decision");
			Delayed = elementProperties.getProperty("Delayed");
			MOGT = elementProperties.getProperty("MOGT");
			RightStart = elementProperties.getProperty("RightStart");
			IFS = elementProperties.getProperty("IFS");
			
			HeaderViewTitle = elementProperties.getProperty("HeaderViewTitle");
			
			
			
			Unlinked = elementProperties.getProperty("Unlinked");
			OTS = elementProperties.getProperty("OTS");
			Groundinterrupt = elementProperties.getProperty("Groundinterrupt");
			A14 = elementProperties.getProperty("A14");
			MOGT = elementProperties.getProperty("MOGT");
			Origin = elementProperties.getProperty("Origin");
			Term = elementProperties.getProperty("Term");
			Inop = elementProperties.getProperty("Inop");
			connectMe = elementProperties.getProperty("ConnectMe");
			
			TotalGate = elementProperties.getProperty("TotalGate");
			// GanntViewDataStatuscodeValidation

			Status = elementProperties.getProperty("Status");
			TailandDestination = elementProperties.getProperty("TailandDestination");
			TailandDestinationHover = elementProperties.getProperty("TailandDestinationHover");
			ArrivalTime = elementProperties.getProperty("ArrivalTime");
			ArrivaltimeHover = elementProperties.getProperty("ArrivaltimeHover");
			Departurestatusandtime = elementProperties.getProperty("Departurestatusandtime");
			Departurestatusandtimehover = elementProperties.getProperty("Departurestatusandtimehover");
			flightlinkage = elementProperties.getProperty("flightlinkage");
			DestinationFlightNo = elementProperties.getProperty("DestinationFlightNo");
			OriginandEquipmenttype = elementProperties.getProperty("OriginandEquipmenttype");
			OriginandEquipmenttypeHover = elementProperties.getProperty("OriginandEquipmenttypeHover");
			DepartureflightNo = elementProperties.getProperty("DepartureflightNo");
			
			
			
			//HybridIcons
				
			HybridAllGate = elementProperties.getProperty("HybridAllGate");
			HybridCancelled = elementProperties.getProperty("HybridCancelled");
			HybridETD = elementProperties.getProperty("HybridETD");
			HybridDecision = elementProperties.getProperty("HybridDecision");
			HybridLatearrival = elementProperties.getProperty("HybridLatearrival");
			HybridEarlyarrival = elementProperties.getProperty("HybridEarlyarrival");
			HybridGateSwaps = elementProperties.getProperty("HybridGateSwaps");
			HybridAcSwaps = elementProperties.getProperty("HybridAcSwaps");
			HybridRightStart = elementProperties.getProperty("HybridRightStart");
			HybridPotential = elementProperties.getProperty("HybridPotential");
			HybridIFS = elementProperties.getProperty("HybridIFS");
			HybridDelayed = elementProperties.getProperty("HybridDelayed");
			HybridA14 = elementProperties.getProperty("HybridA14");
			HybridRed = elementProperties.getProperty("HybridRed");
			HybridYellow = elementProperties.getProperty("HybridYellow");
			HybridBlocked = elementProperties.getProperty("HybridBlocked");
			HybridToatalalert = elementProperties.getProperty("HybridToatalalert");
		
			HybridOffload = elementProperties.getProperty("HybridOffload");
			HybridClaimscan = elementProperties.getProperty("HybridClaimscan");
			HybridBags = elementProperties.getProperty("HybridBags");
			HybridPax = elementProperties.getProperty("HybridPax");
			HybridCrew = elementProperties.getProperty("HybridCrew");
			HybridCabin = elementProperties.getProperty("HybridCabin");
			HybridLavs = elementProperties.getProperty("HybridLavs");
			HybridWater = elementProperties.getProperty("HybridWater");
			HybridFuel = elementProperties.getProperty("HybridFuel");
			HybridCatering = elementProperties.getProperty("HybridCatering");
		
			
			
			//HybridStatscount
			
			HybridAllGateCount = elementProperties.getProperty("HybridAllGateCount");
	 		HybridCancelledCount = elementProperties.getProperty("HybridCancelledCount");
		 	HybridETDCount = elementProperties.getProperty("HybridETDCount");
			 HybridDecisionCount = elementProperties.getProperty("HybridDecisionCount");
			 HybridLatearrivalCount = elementProperties.getProperty("HybridLatearrivalCount");
			 HybridEarlyarrivalCount = elementProperties.getProperty("HybridEarlyarrivalCount");
			 HybridGateSwapsCount = elementProperties.getProperty("HybridGateSwapsCount");
			 HybridAcSwapsCount = elementProperties.getProperty("HybridAcSwapsCount");
			 HybridRightStartCount = elementProperties.getProperty("HybridRightStartCount");
			 HybridPotentialCount = elementProperties.getProperty("HybridPotentialCount");
			 HybridIFSCount = elementProperties.getProperty("HybridIFSCount");
			 HybridA14Count = elementProperties.getProperty("HybridA14Count");
			 HybridRedCount = elementProperties.getProperty("HybridRedCount");
			 HybridYellowCount = elementProperties.getProperty("HybridYellowCount");
			 HybridBlockedCount = elementProperties.getProperty("HybridBlockedCount");
			 HybridToatalalertCount = elementProperties.getProperty("HybridToatalalertCount");
			 HybridDelayedCount = elementProperties.getProperty("HybridDelayedCount");
			 
			 HybridFuelCount = elementProperties.getProperty("HybridFuelCount");
			 HybridBagscount = elementProperties.getProperty("HybridBagscount");
			 HybridCrewCount = elementProperties.getProperty("HybridCrewCount");
			 HybridClaimscanCount = elementProperties.getProperty("HybridClaimscanCount");
			 HybridCabinCount = elementProperties.getProperty("HybridCabinCount");
			 HybridCateringCount = elementProperties.getProperty("HybridCateringCount");
			 HybridLavsCount = elementProperties.getProperty("HybridLavsCount");
			 HybridPaxCount = elementProperties.getProperty("HybridPaxCount");
			 HybridOffloadCount = elementProperties.getProperty("HybridOffloadCount");
			 HybridWaterCount = elementProperties.getProperty("HybridWaterCount");
			 
				
			
		
	
			
			
			
			
			
			
			PuckCompleteCenter = elementProperties.getProperty("PuckCompleteCenter");
			LogoutMenu = elementProperties.getProperty("LogoutMenu");
			Signout = elementProperties.getProperty("Signout");
			Zoomout = elementProperties.getProperty("Zoomout");
			Zoomin = elementProperties.getProperty("Zoomin");
			HybridViewOption = elementProperties.getProperty("HybridViewOption");
			
			
			 CancelledStatsCount = elementProperties.getProperty("CancelledStatsCount");
			 ETDStatsCount = elementProperties.getProperty("ETDStatsCount");
			 DecisionStatsCount = elementProperties.getProperty("DecisionStatsCount");
			 LateArrivaStatsCount = elementProperties.getProperty("LateArrivaStatsCount");
			 EarlyArrivalStatsCount = elementProperties.getProperty("EarlyArrivalStatsCount");
			 OTSStatsCount = elementProperties.getProperty("OTSStatsCount");
			 GateSwapsStatsCount = elementProperties.getProperty("GateSwapsStatsCount");
			 ACSwapsStatsCount = elementProperties.getProperty("ACSwapsStatsCount");
			 RightstartStatsCount = elementProperties.getProperty("RightstartStatsCount");
			 PotentialtowsStatsCount = elementProperties.getProperty("PotentialtowsStatsCount");
			 IFSStatsCount = elementProperties.getProperty("IFSStatsCount");
			 GateConflictsStatsCount = elementProperties.getProperty("GateConflictsStatsCount");
			 DelayedStatsCount = elementProperties.getProperty("DelayedStatsCount");
			 MOGTStatsCount = elementProperties.getProperty("MOGTStatsCount");
			 A14StatsCount = elementProperties.getProperty("A14StatsCount");
			 InopStatsCount = elementProperties.getProperty("InopStatsCount");
			 connectMeStatsCount = elementProperties.getProperty("connectMeStatsCount");
			 PassangerStatsCount = elementProperties.getProperty("PassangerStatsCount");
			 BagsStatsCount = elementProperties.getProperty("BagsStatsCount");
			 CrewStatsCount = elementProperties.getProperty("CrewStatsCount");
			 OffloadStatsCount = elementProperties.getProperty("OffloadStatsCount");
			 ClaimscanStatsCount = elementProperties.getProperty("ClaimscanStatsCount");
			 FuelStatsCount = elementProperties.getProperty("FuelStatsCount");
			 CabinStatsCount = elementProperties.getProperty("CabinStatsCount");
			 CateringStatsCount = elementProperties.getProperty("CateringStatsCount");
			 LavsStatsCount = elementProperties.getProperty("LavsStatsCount");
			 WaterStatsCount = elementProperties.getProperty("WaterStatsCount");
			 TotalStatsCount = elementProperties.getProperty("TotalStatsCount");
			 DivertedStatsCount = elementProperties.getProperty("DivertedStatsCount");
			 MELStatsCount = elementProperties.getProperty("MELStatsCount");
			 CloseoutStatscount = elementProperties.getProperty("CloseoutStatscount");
			 HybridCLOSEOUTS= elementProperties.getProperty("HybridCLOSEOUTS");
			 HybridCLOSEOUTSCount = elementProperties.getProperty("HybridCLOSEOUTSCount");
			 
			 
			 
			 UnlinkedCount = elementProperties.getProperty("UnlinkedCount");
			 OTSCount = elementProperties.getProperty("OTSCount");
			 GroundinterruptCount = elementProperties.getProperty("GroundinterruptCount");
			 A14Count = elementProperties.getProperty("A14Count");
			 MOGTCount = elementProperties.getProperty("MOGTCount");
			 OriginCount = elementProperties.getProperty("OriginCount");
			 TermCount = elementProperties.getProperty("TermCount");

			 
			 Blocked = elementProperties.getProperty("Blocked");
			 Red = elementProperties.getProperty("Red");
			 Yellow = elementProperties.getProperty("Yellow");
			 TotalAlerts = elementProperties.getProperty("TotalAlerts");
			 BlockedCount = elementProperties.getProperty("BlockedCount");
			 RedCount = elementProperties.getProperty("RedCount");
			 YellowCount = elementProperties.getProperty("YellowCount");
			 TotalAlertCount = elementProperties.getProperty("TotalAlertCount");
			 
			 
			//Flight puck details
			 
			 PuckComplete = elementProperties.getProperty("PuckComplete");
			 PuckCompleteArrivaldetails = elementProperties.getProperty("PuckCompleteArrivaldetails");
			 PuckCompleteDepartureDetails = elementProperties.getProperty("PuckCompleteDepartureDetails");
			 PuckCompleteLinkage = elementProperties.getProperty("PuckCompleteLinkage");
			 PuckArrivalstationandEqptype = elementProperties.getProperty("PuckArrivalstationandEqptype");
			 PuckArrivaltimeandstatus = elementProperties.getProperty("PuckArrivaltimeandstatus");
			 PuckDepartureTailanddestination = elementProperties.getProperty("PuckDepartureTailanddestination");
			 PuckDepartureStatusandtime = elementProperties.getProperty("PuckDepartureStatusandtime");
			 PuckDepartureStation = elementProperties.getProperty("PuckDepartureStation");
			 PuckArrivalStation = elementProperties.getProperty("PuckArrivalStation");
			
		
			 HybridUnlinked = elementProperties.getProperty("HybridUnlinked");
			 HybridUnlinkedCount = elementProperties.getProperty("HybridUnlinkedCount");
			 HybridTERM = elementProperties.getProperty("HybridTERM");
			 HybridTERMCount = elementProperties.getProperty("HybridTERMCount");
			 HybridORIGIN = elementProperties.getProperty("HybridORIGIN");
			 HybridORIGINCount = elementProperties.getProperty("HybridORIGINCount");
			 HybridMEL = elementProperties.getProperty("HybridMEL");
			 HybridMELCount = elementProperties.getProperty("HybridMELCount");
			 HybridDiverted = elementProperties.getProperty("HybridDiverted");
			 HybridDivertedCount = elementProperties.getProperty("HybridDivertedCount");
			 HybridMOGT = elementProperties.getProperty("HybridMOGT");
			 HybridMOGTCount = elementProperties.getProperty("HybridMOGTCount");
			 HybridOTS = elementProperties.getProperty("HybridOTS");
			 HybridOTSCount = elementProperties.getProperty("HybridOTSCount");
			 HybridGateConflict = elementProperties.getProperty("HybridGateConflict");
			 HybridGateConflictCount = elementProperties.getProperty("HybridGateConflictCount");
			 
			 
			 GanttViewHeader = elementProperties.getProperty("GanttViewHeader");
			 ConfirmTotalGatesHeader = elementProperties.getProperty("ConfirmTotalGatesHeader");
			 GanttHeaderText = elementProperties.getProperty("GanttHeaderText");
			 filtericon = elementProperties.getProperty("filtericon");
			 ZoneElementTable = elementProperties.getProperty("ZoneElementTable");
			 Slider = elementProperties.getProperty("Slider");
			 SmallFont = elementProperties.getProperty("SmallFont");
			 MediumFont = elementProperties.getProperty("MediumFont");
			 LargeFont = elementProperties.getProperty("LargeFont");
			 Realtimebar = elementProperties.getProperty("Realtimebar");
			 stationtime = elementProperties.getProperty("stationtime");
			 DashboardfilterCancel = elementProperties.getProperty("DashboardfilterCancel");
			 Headertitle = elementProperties.getProperty("Headertitle");
			 Messageposted = elementProperties.getProperty("Messageposted");
			 ViewSettings = elementProperties.getProperty("ViewSettings");
			 SettingPuckDefault = elementProperties.getProperty("SettingPuckDefault");
			 SettingPuckCenter = elementProperties.getProperty("SettingPuckCenter");
			 SettingShowcancelledflight = elementProperties.getProperty("SettingShowcancelledflight");
			 SettingShowUnlinkedflight = elementProperties.getProperty("SettingShowUnlinkedflight");
			 ApplyButton = elementProperties.getProperty("ApplyButton");
			 OKBUTTON = elementProperties.getProperty("OKBUTTON");
			 
			 AlertMessageposted = elementProperties.getProperty("AlertMessageposted");
			 SortAscendinggate = elementProperties.getProperty("SortAscendinggate");
			 SortAscending = elementProperties.getProperty("SortAscending");
			 Expand = elementProperties.getProperty("Expand");
			 Expandcheckpoint = elementProperties.getProperty("Expandcheckpoint");
			 Collapse = elementProperties.getProperty("Collapse");
				
			 WeightRestricted = elementProperties.getProperty("WeightRestricted");
			 HybridWeightRestricted = elementProperties.getProperty("HybridWeightRestricted");
			 
			 
			 
			 
			 
			 Crewconnexicon = elementProperties.getProperty("Crewconnexicon");
			 Crewconnexcount = elementProperties.getProperty("Crewconnexcount");
			 Crewreporttitle = elementProperties.getProperty("Crewreporttitle");
			 CrewHeaderitems = elementProperties.getProperty("CrewHeaderitems");
			 	POSSearchkey = elementProperties.getProperty("POSSearchkey");
					 useridSearchkey = elementProperties.getProperty("useridSearchkey");
					 EmpNameSearchkey = elementProperties.getProperty("EmpNameSearchkey");
					 ScantimeSearchkey = elementProperties.getProperty("ScantimeSearchkey");
					 FlightnoSearchkey = elementProperties.getProperty("FlightnoSearchkey");
					 EtdSearchkey = elementProperties.getProperty("EtdSearchkey");
					 GateSearchkey = elementProperties.getProperty("GateSearchkey");
					 INBFltSearchkey = elementProperties.getProperty("INBFltSearchkey");
					 ORIGINSearchkey = elementProperties.getProperty("ORIGINSearchkey");
					 Gate2Searchkey = elementProperties.getProperty("Gate2Searchkey");
					 StatusSearchkey = elementProperties.getProperty("StatusSearchkey");
					 ETASearchkey = elementProperties.getProperty("ETASearchkey");
					 
					 Crewslider = elementProperties.getProperty("Crewslider");
					 
					 
					 		 Crewpos = elementProperties.getProperty("Crewpos");
							 Crewposspan = elementProperties.getProperty("Crewposspan");
							 Crewuserid = elementProperties.getProperty("Crewuserid");
							 Crewuseridspan = elementProperties.getProperty("Crewuseridspan");
							 CrewEmpName = elementProperties.getProperty("CrewEmpName");
							 CrewEmpNamespan = elementProperties.getProperty("CrewEmpNamespan");
							 CrewScantime = elementProperties.getProperty("CrewScantime");
							 CrewScantimespan = elementProperties.getProperty("CrewScantimespan");
							 CrewFlightno = elementProperties.getProperty("CrewFlightno");
							 CrewEtd = elementProperties.getProperty("CrewEtd");
							 CrewEtdspan = elementProperties.getProperty("CrewEtdspan");
							 CrewGate = elementProperties.getProperty("CrewGate");
							 CrewGatespan = elementProperties.getProperty("CrewGatespan");
							 CrewINBFlt = elementProperties.getProperty("CrewINBFlt");
							 CrewINBFltspan = elementProperties.getProperty("CrewINBFltspan");
							 CrewORIGIN = elementProperties.getProperty("CrewORIGIN");
							 CrewORIGINspan = elementProperties.getProperty("CrewORIGINspan");
							 CrewGate2 = elementProperties.getProperty("CrewGate2");
							 CrewGate2span = elementProperties.getProperty("CrewGate2span");
							 CrewStatus = elementProperties.getProperty("CrewStatus");
							 CrewStatusspan = elementProperties.getProperty("CrewStatusspan");
							 CrewETA = elementProperties.getProperty("CrewETA");
							 CrewETAspan = elementProperties.getProperty("CrewETAspan");
							 Crewconnex = elementProperties.getProperty("Crewconnex");
							 Crewconnexspan = elementProperties.getProperty("Crewconnexspan");
							 crewMOTFDP = elementProperties.getProperty("crewMOTFDP");
							 crewMOTFDPSpan = elementProperties.getProperty("crewMOTFDPSpan");
							 CrewFlightnospan =  elementProperties.getProperty("CrewFlightnospan");
							 
							 CrewNoreport =  elementProperties.getProperty("CrewNoreport");
							 CrewClosebutton =  elementProperties.getProperty("CrewClosebutton");
							 resetconfirmtext = elementProperties.getProperty("resetconfirmtext");
							 
							 NoSearchresult = elementProperties.getProperty("NoSearchresult");
							 SortAscendingArrivaltime =  elementProperties.getProperty("SortAscendingArrivaltime");
							 SortAscendingDeparturetime =  elementProperties.getProperty("SortAscendingDeparturetime");
							 SortAscendingArrivalstatus =  elementProperties.getProperty("SortAscendingArrivalstatus");
							 SortAscendingDeaparturestatus =  elementProperties.getProperty("SortAscendingDeaparturestatus");
							 
							 
							 
							 
							 StatsDiverted =  elementProperties.getProperty("StatsDiverted");
							 StatsDCN  =  elementProperties.getProperty("StatsDCN");
							 StatsMEL =  elementProperties.getProperty("StatsMEL");
							 StatsOTS  =  elementProperties.getProperty("StatsOTS");
							 StatsRTD =  elementProperties.getProperty("StatsRTD");
							 StatsGateSwap  =  elementProperties.getProperty("StatsGateSwap");
						     StatsAcSwap =  elementProperties.getProperty("StatsAcSwap");
						     StatsRightStart =  elementProperties.getProperty("StatsRightStart");
						 	 StatsIFS =  elementProperties.getProperty("StatsIFS");
							 StatsGateConflict =  elementProperties.getProperty("StatsGateConflict");
							 StatsPotentialTows =  elementProperties.getProperty("StatsPotentialTows");
						     StatsATCDelay =  elementProperties.getProperty("StatsATCDelay");
							 StatsDelayedDep =  elementProperties.getProperty("StatsDelayedDep");
						  	 StatsMOGT =  elementProperties.getProperty("StatsMOGT");
						     Statsoriginated =  elementProperties.getProperty("Statsoriginated");
							 Statsterminated =  elementProperties.getProperty("Statsterminated");
							 Statsunlinked =  elementProperties.getProperty("Statsunlinked");
							 StatsA14 =  elementProperties.getProperty("StatsA14");
							 StatsWeightRestricted =  elementProperties.getProperty("StatsWeightRestricted");
							 StatsatlasGalley =  elementProperties.getProperty("StatsatlasGalley");
							 Nightmodeenabled =  elementProperties.getProperty("Nightmodeenabled");
							 Scrollbarheight = 	elementProperties.getProperty("Scrollbarheight");
							 Closeslideout = elementProperties.getProperty("Closeslideout");
							 
							 Domesticradio = elementProperties.getProperty("Domesticradio"); 
							 Internationalradio = elementProperties.getProperty("Internationalradio"); 
							 Ganttheaderstatus = elementProperties.getProperty("Ganttheaderstatus"); 
							 Puckhover = elementProperties.getProperty("Puckhover"); 
							 Settingstimerange = elementProperties.getProperty("Settingstimerange"); 
							 
							 Confirmdefaultview = elementProperties.getProperty("Confirmdefaultview"); 
							 Confirmtailview = elementProperties.getProperty("Confirmtailview"); 
							 Confirmclassicview = elementProperties.getProperty("Confirmclassicview"); 
							 PuckDatacenter =  elementProperties.getProperty("PuckDatacenter"); 
							 Daymodeenabled =  elementProperties.getProperty("Daymodeenabled");  
							 
							 //Multialert
							 leftMultialertIcon = elementProperties.getProperty("leftMultialertIcon"); 
							 
							 //QuickNotes
							 arrivalFltStatus = elementProperties.getProperty("arrivalFltStatus"); 
							 depFltStatus = elementProperties.getProperty("depFltStatus");
							 
			for (Map.Entry<Object, Object> e : elementProperties.entrySet()) {
				// System.out.println(e);

			}
			System.out.println("lOADED PROPERTIES FOR EXECUTION");

		} catch (Exception e) {
			System.out.println("Exception ==>" + e);
		}

	}

}