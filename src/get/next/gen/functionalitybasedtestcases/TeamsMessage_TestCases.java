package get.next.gen.functionalitybasedtestcases;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import get.next.gen.commonaction.CommonTest;
import get.next.gen.utilities.GanntViewHeaderFunctionality;
import get.next.gen.utilities.TeamsMessage;

public class TeamsMessage_TestCases extends CommonTest{
	@Parameters({ "browser", "Environment" })	
	@Test(priority = 0)
	public void TS01_LoginTestcase(String browser, String Environment) throws Exception {
		Memoryused();
		System.out.println("url: teams messge class"+Environment+"");
		//GanntViewHeaderFunctionality.Login("https://get.azne.aa.com/GETNextGen/#!/dashboard");
		GanntViewHeaderFunctionality.Login(Environment);
		Thread.sleep(1000);
		Memoryused();
	}
	@Test(priority = 1)
	public void TS02_GanttviewSelection() throws Exception {
		GanntViewHeaderFunctionality.GanntViewSelection();
		Memoryused();
	}
	@Test(enabled=false)
	public void TS02_verifyTeamsMsgChkBoxDisabledByDefault() throws Exception {
		System.out.println("Verify Teams message is disabled by default in settings");
		TeamsMessage.verifyTeamsMsgChkBoxDisabledByDefault();
		//	Memoryused();
	}
	@Test(enabled=false)
	public void TS02_verifyGanttCount_TeamsMsgORConnectMe() throws Exception {
		System.out.println("Verify Teams message count is updated once the option is enabled in settings and"
				+ " verify Appropriate message is displayed when message count is Zero");
		TeamsMessage.verifyTeamsMsgStatsCountandAppropriateMesageForZeroCountMsg();
		//	Memoryused();
	}
	@Test(priority = 2)
	public void TS02_verifyTeamsMsgInGenerateReportAndEventSlideOut() throws Exception {
		System.out.println("Verify Teams message is displayed under Generate report"
				+ " Verify messages are displayed in the slide out under Teams tab");
		TeamsMessage.verifyTeamsMsgInGenerateReportAndEventSlideOut();
		//	Memoryused();
	}
	@Test(priority = 250)
	public void TS200_VerifyLogout() throws Exception {
		CommonTest.Logout();
		Memoryused();
	}
}
