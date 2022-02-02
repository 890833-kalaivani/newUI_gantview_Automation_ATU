package get.next.gen.webtestcase;

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
	@Test(priority = 1)
	public void TS03_verifyTeamsMsgChkBoxDisabledByDefault() throws Exception {
		System.out.println("Verify Teams message is disabled by default in settings");
		TeamsMessage.verifyTeamsMsgChkBoxDisabledByDefault();
		GanntViewHeaderFunctionality.GanntViewSelection();
		//	Memoryused();
	}
	@Test(priority = 3)
	public void TS04_verifyGanttCount_TeamsMsgORConnectMe() throws Exception {
		System.out.println("Verify Teams message count is updated once the option is enabled in settings and"
				+ " verify Appropriate message is displayed when message count is Zero"
				+"Verify the number of flights displayed in Gannt view matches the count in teams Alerting count");
		TeamsMessage.verifyTeamsMsgStatsCountandAppropriateMesageForZeroCountMsg();
		//	Memoryused();
	}
	@Test(priority = 4)
	public void TS05_verifyTeamsMsgInGenerateReportAndEventSlideOut() throws Exception {
		System.out.println("Verify Teams message is displayed under Generate report"
				+ " Verify messages are displayed in the slide out under Teams tab");
		TeamsMessage.verifyTeamsMsgInGenerateReportAndEventSlideOut();
		//	Memoryused();
	}


}
