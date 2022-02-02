package get.next.gen.functionalitybasedtestcases;
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
	@Test(priority = 1)
	public void isDiversionReprotDisplayed() throws Exception {
		DiversonReport.divReport_IsDisplayed();
		DiversonReport.accessForClassicViewInDiversionReport();
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
	}
}
