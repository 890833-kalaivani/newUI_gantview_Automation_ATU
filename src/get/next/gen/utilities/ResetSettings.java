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
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashSet;
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

public class ResetSettings extends CommonTest {




	public static void Validate_resetsettings() throws Exception {
		GanntViewHeaderFunctionality.GanntViewSelection();
		CustomZone.SelectStation("ABE");
		Thread.sleep(2000);
		//Apply necessary changes to validate reset settings functionality
		SetuserSettings();

		//Perform Reset settings operation
		Resetusersettings();

		//Confirm reset settings reset back to default mode and reverted all the previous made changes. 
		Performresetvalidation();

	}

	private static void Performresetvalidation() throws Exception {

		System.out.println("Starting Reset validation in settings page");
		CommonTest.SpinnerControl();
		checkuserrole();
		TestcaseInit();
		CustomZone.SelectStation("ABE");
		System.out.println("Check the Mode is Changed back to Day Mode");
		confirmresetdaymode();
		System.out.println("Check whether all the stats are reset back to default mode");
		confirmresetstatsoption();
		System.out.println("Check whether the Show etd is reset back to default mode");
		confirmresetshowetd();
		System.out.println("Check whether the draw to actual GT is reset back to default mode");
		confirmresetdrawtoactualgt();
		System.out.println("Check whether the Reset guidelines is reset back to default mode");
		confirmresetguidelines();
		System.out.println("Check whether the puck display option is reset back to Default");
		confirmresettodefaultpuck();
		System.out.println("Check whether the Eventdetails display reset back to Side");
		confirmresettoside();
		System.out.println("Check whether Show Canceled and unlinked flights reset back to default mode.");
		confirmUnSelectCXL_UNL_Showeobt();
	}

	private static void confirmUnSelectCXL_UNL_Showeobt() throws Exception {

		TestcaseInit();
		clickByXpath(Web_UI.filtericon,"filtericon");
		Thread.sleep(1000);
		clickByXpath(Web_UI.ViewSettings,"ViewSettings");
		Thread.sleep(1000);
		try{
			WebElement ShowCancel = getDriver().findElement(By.xpath(Web_UI.ShowCanceled));
			boolean ShowCancelSelected = ShowCancel.isSelected();
			if(ShowCancelSelected == true){
				ATUReports.add("ShowCancel is checked by default " ,  LogAs.PASSED, null);
			}else{

				ATUReports.add("ShowCancel Is not checked by default" ,  LogAs.FAILED, null);
			}

		}catch(Exception slideoutbelowexep ){

		}
		try{
			WebElement ShowUnlinked = getDriver().findElement(By.xpath(Web_UI.ShowUnlinked));
			String ShowUnlinkedselected = ShowUnlinked.getAttribute("checked");		

			if(ShowUnlinkedselected.equalsIgnoreCase("true")){

				ATUReports.add("Show Unlinked is checked by default " ,  LogAs.PASSED, null);
			}else{

				ATUReports.add("Show Unlinked is not checked by default" ,  LogAs.FAILED, null);
			}

		}catch(Exception slideoutbelowexep ){

		}
		try{
			WebElement ShowSdt = getDriver().findElement(By.xpath(Web_UI.Showsdt));
			boolean ShowSdtSelected = ShowSdt.isSelected();

			if(ShowSdtSelected==false){

				ATUReports.add("Show SDT is Unchecked by default " ,  LogAs.PASSED, null);

			}else{

				ATUReports.add("Show EDT is Not Unchecked by default " ,  LogAs.FAILED, null);
			}

		}catch(Exception slideoutbelowexep ){

		}

		clickByXpath(Web_UI.DashboardfilterCancel,"DashboardfilterCancel");



	}

	private static void confirmresettoside() throws Exception {
		TestcaseInit();
		CommonTest.SpinnerControl();
		clickByXpath(Web_UI.filtericon, "Settings Icon ");
		Thread.sleep(1000);
		clickByXpath(Web_UI.ViewSettings,"View Settings");
		Thread.sleep(3000);
		WebElement slideoutbelow = getDriver().findElement(By.xpath(Web_UI.Slideoutbelow));
		boolean slideoutbelowselected = slideoutbelow.isSelected();
		try{
			if(slideoutbelowselected==false){
				ATUReports.add("Slide out *Below is Unchecked by reset settings" ,  LogAs.PASSED, null);	
			}
			else{

				ATUReports.add("Slideout *Below is not resetted " ,  LogAs.PASSED, null);	
			}

		}catch(Exception slideoutbelowexep ){

		}

		clickByXpath(Web_UI.DashboardfilterCancel,"DashboardfilterCancel");	
	}

	private static void confirmresettodefaultpuck() throws Exception {
		TestcaseInit();
		CommonTest.SpinnerControl();
		clickByXpath(Web_UI.filtericon, "Settings Icon ");
		Thread.sleep(1000);
		clickByXpath(Web_UI.ViewSettings,"View Settings");
		Thread.sleep(3000);
		String defaultcheckbox = getDriver().findElement(By.xpath(Web_UI.Puckdefaultradio)).getAttribute("checked");
		if(defaultcheckbox.equalsIgnoreCase("true")){
			ATUReports.add("Puck setting resetted to Default", LogAs.PASSED, null);
		}else{
			ATUReports.add("Puck setting Not resetted to Default", LogAs.FAILED, null);
		}

		clickByXpath(Web_UI.DashboardfilterCancel,"DashboardfilterCancel");
	}

	public static void Resetusersettings() throws Exception {
		System.out.println("Reseting the User settings to Start reset validation");
		TestcaseInit();
		CommonTest.SpinnerControl();
		clickByXpath(Web_UI.filtericon, "Settings Icon ");
		Thread.sleep(1000);
		clickByXpath(Web_UI.Resetbutton, "Reset button ");
		Thread.sleep(1000);
		WebElement message = getDriver().findElement(By.xpath(Web_UI.resetconfirmtext));
		String messagetext = message.getAttribute("innerText");
		if(messagetext.contains("All user settings will return to default")){
			ATUReports.add("Posted message is valid", LogAs.PASSED, null);
		}else{
			ATUReports.add("Posted message is invalid", LogAs.FAILED, null);
		}
		clickByXpath(Web_UI.Cancelinreset, "Cancel Button ");
		ATUReports.add("Cancel Button is clicked", LogAs.PASSED, null);
		clickByXpath(Web_UI.Resetbutton, "Reset button ");
		Thread.sleep(1000);
		clickByXpath(Web_UI.ResetAcceptbutton, "Accept Button ");
		ATUReports.add("Accept Button is selected", LogAs.PASSED, null);
		Thread.sleep(5000);
		System.out.println("end of reset settinsg");


	}

	private static void confirmresetguidelines() throws Exception {
		TestcaseInit();
		clickByXpath(Web_UI.filtericon, "Settings Icon ");
		Thread.sleep(1000);

		clickByXpath(Web_UI.ViewSettings,"View Settings");
		Thread.sleep(3000);
		ATUReports.add("Selected View Settings tab",  LogAs.PASSED, null);


		try{

			WebElement Guidlineoption = getDriver().findElement(By.xpath(Web_UI.Guidelineoption));
			boolean guidelineselected = Guidlineoption.isSelected();
			if(guidelineselected==false)
			{
				ATUReports.add("Guidelines checkbox is resetted to Default",  LogAs.PASSED, null);
			}else{

				ATUReports.add(" Guidelines are not resetted back to default ",  LogAs.PASSED, null);
			}

		}
		catch(Exception onemoreattempt)
		{
			ATUReports.add(" Issue with selecting guideline option from view settings ",  LogAs.FAILED, null);

		}

		clickByXpath(Web_UI.DashboardfilterCancel,"DashboardfilterCancel");
	}

	private static void confirmresetdrawtoactualgt() throws Exception {
		TestcaseInit();
		clickByXpath(Web_UI.filtericon, "Settings Icon ");
		Thread.sleep(1000);

		Thread.sleep(1000);
		clickByXpath(Web_UI.ViewSettings,"ViewSettings");
		Thread.sleep(1000);
		WebElement showetd = getDriver().findElement(By.xpath(Web_UI.Showmogt));
		boolean showetdselected = showetd.isSelected();
		try{
			if(showetdselected==false){
				ATUReports.add(" DrawtoActual GT  is resetted back to default state " ,  LogAs.PASSED, null);	
			}
			else{

				ATUReports.add("DrawtoActual GT is not resetted back to default state " ,  LogAs.FAILED, null);	
			}
		}catch(Exception Showetdnotselected){
			ATUReports.add("Issue with selecting DrawtoActual GT   " ,  LogAs.FAILED, null);	
		}


		clickByXpath(Web_UI.DashboardfilterCancel,"DashboardfilterCancel");
	}

	private static void confirmresetshowetd() throws Exception {
		TestcaseInit();
		clickByXpath(Web_UI.filtericon,"filtericon");
		Thread.sleep(1000);
		clickByXpath(Web_UI.ViewSettings,"ViewSettings");
		Thread.sleep(1000);
		WebElement showetd = getDriver().findElement(By.xpath(Web_UI.Showetd));
		boolean showetdselected = showetd.isSelected();
		try{
			if(showetdselected==false){
				ATUReports.add("Show etd is resetted back to default state " ,  LogAs.PASSED, null);	
			}
			else{

				ATUReports.add("Show etd is not resetted back to default state " ,  LogAs.FAILED, null);	
			}
		}catch(Exception Showetdnotselected){

		}


		clickByXpath(Web_UI.DashboardfilterCancel,"DashboardfilterCancel");
	}

	private static void confirmresetstatsoption() throws Exception {

		TestcaseInit();
		clickByXpath(Web_UI.filtericon,"filtericon");
		WebElement Statsoption = getDriver().findElement(By.xpath(Web_UI.StatsOption));
		Statsoption.click();
		Thread.sleep(3000);
		ATUReports.add("Stats Option is selected ",  LogAs.PASSED, null); 
		try{
			WebElement Diverted = getDriver().findElement(By.xpath(Web_UI.StatsDiverted));
			WebElement DCN = getDriver().findElement(By.xpath(Web_UI.StatsDCN));
			WebElement MEL = getDriver().findElement(By.xpath(Web_UI.StatsMEL));
			WebElement OTS = getDriver().findElement(By.xpath(Web_UI.StatsOTS));
			WebElement RTD = getDriver().findElement(By.xpath(Web_UI.StatsRTD));
			WebElement GateSwap = getDriver().findElement(By.xpath(Web_UI.StatsGateSwap));
			WebElement AcSwap = getDriver().findElement(By.xpath(Web_UI.StatsAcSwap));
			WebElement RightStart = getDriver().findElement(By.xpath(Web_UI.StatsRightStart));
			WebElement IFS = getDriver().findElement(By.xpath(Web_UI.StatsIFS));
			WebElement GateConflict = getDriver().findElement(By.xpath(Web_UI.StatsGateConflict));
			//WebElement PotentialTows = getDriver().findElement(By.xpath("//*[@id='PotentialTows']"));
			WebElement ATCDelay = getDriver().findElement(By.xpath(Web_UI.StatsATCDelay));
			WebElement DelayedDep = getDriver().findElement(By.xpath(Web_UI.StatsDelayedDep));
			WebElement MOGT = getDriver().findElement(By.xpath(Web_UI.StatsMOGT));
			WebElement originated = getDriver().findElement(By.xpath(Web_UI.Statsoriginated));
			WebElement terminated = getDriver().findElement(By.xpath(Web_UI.Statsterminated));
			WebElement unlinked = getDriver().findElement(By.xpath(Web_UI.Statsunlinked));
			WebElement A14 = getDriver().findElement(By.xpath(Web_UI.StatsA14));
			WebElement WeightRestricted = getDriver().findElement(By.xpath(Web_UI.StatsWeightRestricted));
			WebElement atlasGalley = getDriver().findElement(By.xpath(Web_UI.StatsatlasGalley));

			if(WeightRestricted.isSelected()==false)
			{
				ATUReports.add("Weight Restricted check box resetted back to default Settings  ",  LogAs.PASSED, null); 
			}	
			if(originated.isSelected()==true)
			{

				ATUReports.add("Origin Check box check box resetted back to default Settings  " ,  LogAs.PASSED, null); 
			}
			if(terminated.isSelected()==true)
			{

				ATUReports.add("Term check box resetted back to default Settings   " ,  LogAs.PASSED, null); 
			}

			if(MOGT.isSelected()==false)
			{

				ATUReports.add("MOGT check box resetted back to default Settings    ",  LogAs.PASSED, null); 
			}
			if(originated.isSelected()==false)
			{

				ATUReports.add("originated check box resetted back to default Settings   ",  LogAs.PASSED, null); 
			}
			if(terminated.isSelected()==false)
			{

				ATUReports.add("Term check box resetted back to default Settings    ",  LogAs.PASSED, null); 
			}
			if(unlinked.isSelected()==false)
			{

				ATUReports.add("unlinked check box resetted back to default Settings    ",  LogAs.PASSED, null); 
			}
			if(A14.isSelected()==false)
			{
				ATUReports.add("A14 check box resetted back to default Settings    ",  LogAs.PASSED, null); 
			}

			if(IFS.isSelected()==false)
			{

				ATUReports.add("IFS check box resetted back to default Settings   ",  LogAs.PASSED, null); 
			}

			if(Diverted.isSelected()==false)
			{

				ATUReports.add("Diverted check box resetted back to default Settings   ",  LogAs.PASSED, null); 
			}

			if(DCN.isSelected()==false)
			{

				ATUReports.add("DCN check box resetted back to default Settings   ",  LogAs.PASSED, null); 
			}

			if(MEL.isSelected()==false)
			{

				ATUReports.add("MEL check box resetted back to default Settings    ",  LogAs.PASSED, null); 
			}


			if(OTS.isSelected()==false)
			{

				ATUReports.add("OTS check box resetted back to default Settings    ",  LogAs.PASSED, null); 
			}


			if(RTD.isSelected()==false)
			{

				ATUReports.add("RTD check box resetted back to default Settings     " ,  LogAs.PASSED, null); 
			}

			if(AcSwap.isSelected()==false)
			{

				ATUReports.add("AcSwap check box resetted back to default Settings     ",  LogAs.PASSED, null); 
			}

			if(GateSwap.isSelected()==false)
			{

				ATUReports.add("GateSwap check box resetted back to default Settings    ",  LogAs.PASSED, null); 
			}

			if(RightStart.isSelected()==false)
			{

				ATUReports.add("RightStart check box resetted back to default Settings   ",  LogAs.PASSED, null); 
			}

			if(GateConflict.isSelected()==false)
			{

				ATUReports.add("GateConflict check box resetted back to default Settings    ",  LogAs.PASSED, null); 
			}



			if(ATCDelay.isSelected()==false)
			{

				ATUReports.add("ATCDelay check box resetted back to default Settings   ",  LogAs.PASSED, null); 
			}


			if(DelayedDep.isSelected()==false)
			{

				ATUReports.add("DelayedDep check box resetted back to default Settings     ",  LogAs.PASSED, null); 
			}
			Actions actions = new Actions(getDriver());	
			actions.moveToElement(atlasGalley).build().perform();
			if(atlasGalley.isSelected()==true)
			{

				ATUReports.add("atlasGalley check box resetted back to default Settings   ",  LogAs.PASSED, null); 
			}

			clickByXpath(Web_UI.DashboardfilterCancel,"DashboardfilterCancel");

		}catch(Exception Error)
		{
			System.out.println("Exception with some status");
			ATUReports.add("Some stats thrown error  " +Error.toString(),  LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE)); 
			clickByXpath(Web_UI.ApplyButton,"ApplyButton");
			Thread.sleep(8000);
			GanntViewHeaderFunctionality.SpinnerControl();
		}



	}

	private static void confirmresetdaymode() throws Exception {

		TestcaseInit();
		clickByXpath(Web_UI.filtericon,"filtericon");
		try{
			WebElement Nighticon = getDriver().findElement(By.xpath(Web_UI.Nightmodeenabled));
			ATUReports.add("User is in Night mode " ,  LogAs.FAILED, null);
			clickBywebelementxpath(Nighticon,"Nighticon");
			ATUReports.add("User is switched to Day Mode " ,  LogAs.INFO, null);
			clickByXpath(Web_UI.ApplyButton,"ApplyButton");
		}catch(Exception nonightmode)
		{
			ATUReports.add("User is Resetted to Day Mode  " ,  LogAs.PASSED, null);
			clickByXpath(Web_UI.DashboardfilterCancel,"DashboardfilterCancel");
		}


		CommonTest.SpinnerControl();

	}

	private static void SetuserSettings() throws Exception {
		clickByXpath(Web_UI.filtericon, "Settings Icon ");
		Thread.sleep(1000);
		System.out.println("");

		DashboardFilterOptionValidation.StatsoptionSelection();
		System.out.println("Select all Flight statistics to display in Dashboard for Reset validation");
		DashboardFilterOptionValidation.SelectAllStatistics();

		System.out.println("Select Show ETD Outside checkbox to perform Reset validation Reset back it to Default state");
		DashboardFilterOptionValidation.CheckShowETDoutside();
		System.out.println("Select Draw To Actual GT option to perform reset validation reset it back to Default state");
		DashboardFilterOptionValidation.DrawtoActualGT();
		System.out.println("Select Show Guidelines Option to perform reset validation reset it back to default state");
		PuckUIPlacement.Guidelines();
		System.out.println("Switch to Night mode to perform reset validation reset it back to day mode");
		DashboardFilterOptionValidation.EnableNightmode();
		System.out.println("Select event slide out to below and perform reset validation reset it back to default state");
		DashboardFilterOptionValidation.SelectEventslideouttobelow();
		System.out.println("Unselect Show cancel and Show unlinked flight and perform reset validation reset it back to default state");
		DashboardFilterOptionValidation.UnSelectCXL_UNL_Showeobt();
		System.out.println("Select classic view and perfor reset validation reset it back to default state");
		GanttviewPuckOptions.Setclassicview();
		CommonTest.SpinnerControl();
		GanntViewHeaderFunctionality.GanntViewSelection();
	}


}