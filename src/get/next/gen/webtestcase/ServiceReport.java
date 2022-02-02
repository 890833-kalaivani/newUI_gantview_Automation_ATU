package get.next.gen.webtestcase;

import get.next.gen.commonaction.CommonTest;
import get.next.gen.serviceutils.*;
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



public class ServiceReport extends CommonTest {
	


@Test(priority = 0)
public void T01_VerifyTarmacreport() throws Exception {
	
	ServiceComparisionUtilities.VerifyTarmacreport();
				}

@Test(priority = 1)
public void T02_SaveOrUpdateUserZones() throws Exception {
	
	ServiceComparisionUtilities.SaveOrUpdateUserZones();
				}

@Test(priority = 2)
public void T03_GetZonesAndGates() throws Exception {
	
	ServiceComparisionUtilities.getZonesAndGates();
				}

@Test(priority = 3)
public void T04_GetLongOnBoardAlert() throws Exception {
	
	ServiceComparisionUtilities.getLongOnBoardAlert();
				}

@Test(priority = 4)
public void T05_getRecentSwapCount() throws Exception {
	
	ServiceComparisionUtilities.getRecentSwapCount();
				}


@Test(priority = 5)
public void T06_getSwapReport() throws Exception {
	
	ServiceComparisionUtilities.getSwapReport();
				}

@Test(priority = 6)
public void T07_getStationOffset() throws Exception {
	
	ServiceComparisionUtilities.getStationOffset();
				}

@Test(priority = 7)
public void T08_getFlightDelayReport() throws Exception {
	
	ServiceComparisionUtilities.getFlightDelayReport();
				}

@Test(priority = 8)
public void T09_DeletecustomZone() throws Exception {
		ServiceComparisionUtilities.DeletecustomZone();
				}

@Test(priority = 9)
public void T10_getFlightEvents() throws Exception {
		ServiceComparisionUtilities.getFlightEvents();
				}

@Test(priority = 10)
public void T11_getPassengerDetails() throws Exception {
		ServiceComparisionUtilities.getPassengerDetails();
				}

@Test(priority = 11)
public void T12_getCrewReport() throws Exception {
		ServiceComparisionUtilities.getCrewReport();
				}

@Test(priority = 12)
public void T13_getBagReportDetails() throws Exception {
		ServiceComparisionUtilities.getBagReportDetails();
				}

@Test(priority = 13)
public void T14_getOffloadReportDetails() throws Exception {
		ServiceComparisionUtilities.getOffloadReportDetails();
				}

@Test(priority = 14)
public void T15_saveNotes() throws Exception {
		ServiceComparisionUtilities.saveNotes();
				}

@Test(priority = 15)
public void T16_GetStationlist() throws Exception {
		ServiceComparisionUtilities.getStationlist();
				}

}