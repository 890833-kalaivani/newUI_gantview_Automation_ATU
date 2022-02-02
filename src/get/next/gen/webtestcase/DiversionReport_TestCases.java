package get.next.gen.webtestcase;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import get.next.gen.commonaction.CommonTest;
import get.next.gen.utilities.DiversonReport;
import get.next.gen.utilities.GanntViewHeaderFunctionality;
public class DiversionReport_TestCases extends CommonTest {
	@Parameters({ "browser", "Environment" })
	@Test(priority = 0)
	public void TS01_LoginTestcase(String browser, String Environment) throws Exception {
		Memoryused();
		System.out.println("url: " + Environment + "");
		GanntViewHeaderFunctionality.Login(Environment);
		DiversonReport.retrievingDataFromGetNGClassic();
		
	}
/*	@Test(priority = 1)
	public void isDiversionReprotDisplayed() throws Exception {
		DiversonReport.divReport_IsDisplayed();
		//DiversonReport.accessForClassicViewInDiversionReport();
	}
	@Test(priority = 2)
	public void divReport_NavigatingToDestinationStation() throws Exception {
		DiversonReport.divReport_NavigatingToDestinationStation();
	}
	
	@Test(priority = 3)
	public void divReport_createAdhocEvent() throws Exception {
		DiversonReport.divReport_createAdhocEvent();
	}
	@Test(priority = 4)
	public void divReport_createUpdateETD() throws Exception {
		DiversonReport.divReport_createUpdateETD();
	}
	@Test(priority = 5)
	public void divReport_EnteringNotes() throws Exception {
		DiversonReport.divReport_EnteringNotes();
	}
	@Test(priority = 6)
	public void divReport_compareFltNumOfEnhancedviewVsClassicViewWithoutIncludingSwim() throws Exception {
		DiversonReport.divReport_compareFltNumOfEnhancedviewVsClassicViewWithoutIncludingSwim();
		getDriver().switchTo().parentFrame();
		clickByXpath("//span[@class='close-icn']", "closeDiversionReport");
	}
	@Test(priority = 250)
	public void TS200_VerifyLogout() throws Exception {
		 CommonTest.Logout();
		Memoryused();
	}*/
	
	
	@Test(priority = 210)
	public void TS210_divReport_IsDisplayed() throws Exception {
		System.out.println("TS210_divReport_IsDisplayed");
		DiversonReport.divReport_IsDisplayed();
	}
	@Test(priority = 211)
	public void TS211_divReport_wideBodyIconVerification() throws Exception {
		System.out.println("TS210_divReport_IsDisplayed");
		DiversonReport.divReport_IsDisplayed();
		DiversonReport.divReport_wideBodyIconVerification();
	}
	@Test(priority = 212)
	public void TS212_divReport_InternationalFlagVerfication() throws Exception {
		System.out.println("TS210_divReport_IsDisplayed");
		DiversonReport.divReport_IsDisplayed();
		DiversonReport.divReport_InternationalFlagVerfication();
	}
	@Test(priority = 213)
	public void TS213_divReport_generateReport() throws Exception {
		System.out.println("TS210_divReport_IsDisplayed");
		DiversonReport.divReport_IsDisplayed();
		DiversonReport.divReport_generateReport();
	}
	@Test(priority = 214)
	public void TS214_divReport_createUpdateETD() throws Exception {
		System.out.println("TS210_divReport_IsDisplayed");
		DiversonReport.divReport_IsDisplayed();
		DiversonReport.divReport_createUpdateETD();
	}
	@Test(priority = 215)
	public void TS215_divReport_EnteringNotes() throws Exception {
		System.out.println("TS210_divReport_IsDisplayed");
		DiversonReport.divReport_IsDisplayed();
		DiversonReport.divReport_EnteringNotes();
	}
	@Test(priority = 216)
	public void TS216_divReport_compareFltNumOfEnhancedviewVsClassicViewWithoutIncludingSwim() throws Exception {
		System.out.println("TS210_divReport_IsDisplayed");
		DiversonReport.divReport_IsDisplayed();
		DiversonReport.divReport_compareFltNumOfEnhancedviewVsClassicViewWithoutIncludingSwim();
	}
	@Test(priority = 217)
	public void TS217_verifySaveBtnDisabledForOFFFLightsAndEnabledForOtherStatusInClassicViewm() throws Exception {
		System.out.println("TS210_divReport_IsDisplayed");
		DiversonReport.divReport_IsDisplayed();
		DiversonReport.verifySaveBtnDisabledForOFFFLightsAndEnabledForOtherStatusInClassicView();
	}
	@Test(priority = 218)
	public void TS218_verifyPETActions() throws Exception {
		System.out.println("TS210_divReport_IsDisplayed");
		DiversonReport.divReport_IsDisplayed();
		DiversonReport.verifyPETActions();
	}
	@Test(priority = 219)
	public void TS219_petDisabledForOffStatusFlights() throws Exception {
		System.out.println("TS210_divReport_IsDisplayed");
		DiversonReport.divReport_IsDisplayed();
		DiversonReport.petDisabledForOffStatusFlights();
	}
	@Test(priority = 220)
	public void TS220_verifyGanttViewInLocal() throws Exception {
		System.out.println("TS210_divReport_IsDisplayed");
		DiversonReport.divReport_IsDisplayed();
		DiversonReport.verifyGanttViewInLocal();
	}
	

	
}
