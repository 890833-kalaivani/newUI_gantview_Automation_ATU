package get.next.gen.webtestcase;

import get.next.gen.commonaction.*;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;

public class Service_UI {

	public static String Starttime;
	public static String Endtime;
	
	
	public static String getFlightsForGivenTimeflightforgiventimeurl;


	public static String getTarmacReportOldurl;
	public static String getTarmacReportNewurl;
	public static String saveOrUpdateUserZonesOldurl;
	public static String saveOrUpdateUserZonesNewurl;
	public static String getZonesAndGatesOldurl;
	public static String getZonesAndGatesNewurl;
	public static String getLongOnBoardAlertOldurl;
	public static String getLongOnBoardAlertNewurl;
	public static String getRecentSwapCountOldurl;
	public static String getRecentSwapCountNewurl;
	public static String stationOffsetOldurl;
	public static String stationOffsetNewurl;
	public static String getSwapReportOldurl;
	public static String getSwapReportNewurl;
	public static String getFlightDelayReportOldurl;
	public static String getFlightDelayReportNewurl;
	public static String deleteCustomZonesOldurl;
	public static String deleteCustomZonesNewurl;

	public static String getFlightEventsOldurl;
	public static String getFlightEventsNewurl;
	public static String getPassengerDetailsOldurl;
	public static String getPassengerDetailsNewurl;
	public static String getCrewReportOldurl;
	public static String getCrewReportNewurl;
	public static String getBagReportDetailsOldurl;
	public static String getBagReportDetailsNewurl;
	public static String getOffloadReportDetailsOldurl;
	public static String getOffloadReportDetailsNewurl;
	public static String saveNotesOldurl;
	public static String saveNotesNewurl;
	public static String getStationListOldurl;
	public static String getStationListNewurl;
		
		
	public static void loadServiceProperties() throws FileNotFoundException {
		try {

			InputStream is = CommonTest.class.getClass().getResourceAsStream("/Service.properties");
			Properties elementProperties = new Properties();
			elementProperties.load(is);

			 getFlightsForGivenTimeflightforgiventimeurl  = elementProperties.getProperty("getFlightsForGivenTimeflightforgiventimeurl");


			getTarmacReportOldurl  = elementProperties.getProperty("getTarmacReportOldurl");
			 getTarmacReportNewurl = elementProperties.getProperty("getTarmacReportNewurl");
			 saveOrUpdateUserZonesOldurl = elementProperties.getProperty("saveOrUpdateUserZonesOldurl");
			 saveOrUpdateUserZonesNewurl = elementProperties.getProperty("saveOrUpdateUserZonesNewurl");
			 getZonesAndGatesOldurl = elementProperties.getProperty("getZonesAndGatesOldurl");
		 getZonesAndGatesNewurl = elementProperties.getProperty("getZonesAndGatesNewurl");
		 getLongOnBoardAlertOldurl = elementProperties.getProperty("getLongOnBoardAlertOldurl");
		 getLongOnBoardAlertNewurl = elementProperties.getProperty("getLongOnBoardAlertNewurl");
		 getRecentSwapCountOldurl = elementProperties.getProperty("getRecentSwapCountOldurl");
		 getRecentSwapCountNewurl = elementProperties.getProperty("getRecentSwapCountNewurl");
		 stationOffsetOldurl = elementProperties.getProperty("stationOffsetOldurl");
			 stationOffsetNewurl = elementProperties.getProperty("stationOffsetNewurl");
 getSwapReportOldurl = elementProperties.getProperty("getSwapReportOldurl");
		 getSwapReportNewurl = elementProperties.getProperty("getSwapReportNewurl");
	 getFlightDelayReportOldurl = elementProperties.getProperty("getFlightDelayReportOldurl");
		 getFlightDelayReportNewurl = elementProperties.getProperty("getFlightDelayReportNewurl");
		 deleteCustomZonesOldurl = elementProperties.getProperty("deleteCustomZonesOldurl");
 deleteCustomZonesNewurl = elementProperties.getProperty("deleteCustomZonesNewurl");

			getFlightEventsOldurl = elementProperties.getProperty("getFlightEventsOldurl");
			 getFlightEventsNewurl = elementProperties.getProperty("getFlightEventsNewurl");
			 getPassengerDetailsOldurl = elementProperties.getProperty("getPassengerDetailsOldurl");
		 getPassengerDetailsNewurl = elementProperties.getProperty("getPassengerDetailsNewurl");
			 getCrewReportOldurl = elementProperties.getProperty("getCrewReportOldurl");
		 getCrewReportNewurl = elementProperties.getProperty("getCrewReportNewurl");
 getBagReportDetailsOldurl = elementProperties.getProperty("getBagReportDetailsOldurl");
			 getBagReportDetailsNewurl = elementProperties.getProperty("getBagReportDetailsNewurl");
			 getOffloadReportDetailsOldurl = elementProperties.getProperty("getOffloadReportDetailsOldurl");
		 getOffloadReportDetailsNewurl = elementProperties.getProperty("getOffloadReportDetailsNewurl");
			 saveNotesOldurl = elementProperties.getProperty("saveNotesOldurl");
		 saveNotesNewurl = elementProperties.getProperty("saveNotesNewurl");
	 getStationListOldurl = elementProperties.getProperty("getStationListOldurl");
		getStationListNewurl = elementProperties.getProperty("getStationListNewurl");
			
			
		
		Starttime = elementProperties.getProperty("Starttime");
		Endtime = elementProperties.getProperty("Endtime");
			
		
				
			
			for (Map.Entry<Object, Object> e : elementProperties.entrySet()) {
				// System.out.println(e);

			}
			System.out.println("lOADED PROPERTIES FOR EXECUTION");

		} catch (Exception e) {
			System.out.println("Exception ==>" + e);
		}

	}

}