/*This class includes all the common actions performed by the user while writing scripts such as
Login, Click operation, Findelement with different combination of attibutes ,Explicit Wait, 
Pause script when backend operation etc... */
package get.next.gen.commonaction;import net.lightbody.bmp.BrowserMobProxy;
import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.client.ClientUtil;
import net.lightbody.bmp.core.har.Har;
import net.lightbody.bmp.proxy.CaptureType;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.*;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.openqa.selenium.JavascriptExecutor;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import org.testng.Assert;
import org.testng.Reporter;
import atu.testng.reports.ATUReports;
import atu.testng.reports.logging.LogAs;
import atu.testng.reports.utils.Utils;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;
import com.google.common.base.Function;
import org.testng.Assert;
import get.next.gen.utilities.GanntViewHeaderFunctionality;
import get.next.gen.utilities.GanttviewPuckOptions;
import get.next.gen.webtestcase.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import atu.testng.reports.listeners.ATUReportsListener;
import atu.testng.reports.listeners.ConfigurationListener;
import atu.testng.reports.listeners.MethodListener;
@Listeners({ ATUReportsListener.class, ConfigurationListener.class,
	MethodListener.class })
public class CommonTest {
	//Set Property for ATU Reporter Configuration
	{
		System.setProperty("atu.reporter.config", "atu.properties");
	}
	ChromeOptions options = new ChromeOptions();
	public static WebDriver driver;
	public static  ThreadLocal<WebDriver> threadDriver = new ThreadLocal<WebDriver>();
	public static  ThreadLocal<RemoteWebDriver> MobothreadDriver = new ThreadLocal<RemoteWebDriver>();
	public static BrowserMobProxy proxy;
	public static Pattern pattern;
	public static Matcher matcher;
	public static final String TIME24HOURS_PATTERN =
			"([01]?[0-9]|2[0-3]):[0-5][0-9]";
	@Parameters({ "browser", "Environment" })
	@BeforeTest
	// This method will be called at start of each testcase to launch browser and set prerequisite
	public WebDriver setUp(String browser, String Environment) throws Exception {
		//	threadDriver = new ThreadLocal<WebDriver>();	
		//Below will Load all the properties from property file at start of execution
		Web_UI.loadElementProperties();
		Service_UI.loadServiceProperties();
		Date date = new Date();
		// Setting a Execution date for  zipping the existing test result folder with Execution date
		String ExecutionDate1 = date.toString().substring(0, 16).trim();
		String ExecutionDate = ExecutionDate1.replace(":", "").trim();
		//Movefilesbetweenfolder("Reports","ReportArchive");
		zipFolder("Results", "output//Results_"+ExecutionDate+".zip");
		System.out.println("Report Archived");
		//Based on Browser input provided below will handle the browser selection
		if(browser.equalsIgnoreCase("Chrome"))
		{
			DesiredCapabilities caps = DesiredCapabilities.chrome();
			caps.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			//ChromeOptions options = new ChromeOptions();//introduced this line to disable chrome notifications;
			options.addArguments("disable-notifications");//introduced this line to disable chrome notifications;
			

			//System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			/*LoggingPreferences logPrefs = new LoggingPreferences();
			logPrefs.enable(LogType.BROWSER, Level.ALL);*/
			//   logPrefs.enable(LogType.CLIENT, Level.INFO);
			//   logPrefs.enable(LogType.DRIVER, Level.ALL);
			//    logPrefs.enable(LogType.PERFORMANCE, Level.ALL);
			//    logPrefs.enable(LogType.PROFILER, Level.INFO);
			//   logPrefs.enable(LogType.SERVER, Level.INFO);
			// logPrefs.enable(LogType.PROFILER, Level.INFO);
			//  logPrefs.enable(LogType.BROWSER, Level.ALL);
			//  logPrefs.enable(LogType.PERFORMANCE, Level.ALL);
			//		caps.setCapability(ChromeOptions.CAPABILITY,             options);//introduced this line to disable chrome notifications;
			//	caps.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);

			//   driver = new ChromeDriver(caps);
			//threadDriver.set(new ChromeDriver(caps));
			Thread.sleep(3000);
			//	getDriver().manage().window().maximize();
			options.addArguments("--ignore-ssl-errors=yes");
			options.addArguments("--ignore-certificate-errors");
			options.addArguments("--start-maximized");
			//options.addArguments("--headless", "--disable-gpu", "--window-size=1920,1200","--disable-extensions","--no-sandbox","--disable-dev-shm-usage");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(options);
			System.out.println(driver);
			Thread.sleep(10000);
			launchApp(Environment);
			ATUReports.setWebDriver(driver);
			
		}
		// Installation Path should be provided inorder to Launch the wrapper application
		else if (browser.equalsIgnoreCase("Wrapper")) {
			ChromeOptions options = new ChromeOptions();
			options.setBinary("C:\\Users\\1191409\\AppData\\Local\\Apps\\2.0\\P6O4XGVR.V5B\\GYRP035M.5AM\\getn..tion_54c66e190e4c6c86_0003.000e_71e74ca2091002ce\\GETNG.exe");
			//  options.setBinary("C:\\Users\\Testing\\AppData\\Local\\Apps\\2.0\\DHB812MP.REP\\G1CMYNOE.G7M\\getn..tion_54c66e190e4c6c86_0003.0006_268143fbbed8de4e\\GETNG.exe");
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			Thread.sleep(3000);
			threadDriver.set(new ChromeDriver(options));
			ATUReports.setWebDriver(getDriver());
			Thread.sleep(15000);
		}
		else if (browser.equalsIgnoreCase("Service")) {
			System.out.println("Service script . Intialization Not required ");
		}
		else if (browser.equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
			threadDriver.set(new FirefoxDriver());
			Thread.sleep(3000);
			ATUReports.setWebDriver(getDriver());
			// launchApp(Web_UI.Url);
		}
		else if (browser.equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver", "IEDriverServer.exe");
			threadDriver.set(new InternetExplorerDriver());
			ATUReports.setWebDriver(getDriver());
			Thread.sleep(8000);
			driver.get("https://get.azne.aa.com/GETNextGen/#!/dashboard");
			//launchApp(Web_UI.Url);
			Thread.sleep(8000);
		}
		else if(browser.equalsIgnoreCase("Mobo")){
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability("device","Android");
			capabilities.setCapability("platormName", "Android");
			capabilities.setCapability("deviceName", "Android");
			capabilities.setCapability("app", "getng.apk");
			MobothreadDriver.set(new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities));
			((WebDriver) MobothreadDriver).manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			ATUReports.setWebDriver(getDriver1());
		}
		//Below lines are written to set Title in Report
		ATUReports.indexPageDescription = "American Airlines";
		ATUReports.setAuthorInfo("Bharath", Utils.getCurrentTime(), "1.0");
		return threadDriver.get();
	}
	public static   WebDriver getDriver() {
		return driver;
	}
	//Use MobothreadDriver for Mobile automation.
	public static   WebDriver getDriver1() {
		return MobothreadDriver.get();
	}
	// Below piece of code been used for Move Files from One folder to another
	public static  void Movefilesbetweenfolder(String Reportfolder, String Archivefolder) throws IOException
	{
		File destinationFolder = new File(Archivefolder);
		File sourceFolder = new File(Reportfolder);
		if (!destinationFolder.exists())
		{
			destinationFolder.mkdirs();
		}
		// Check weather source exists and it is folder.
		if (sourceFolder.exists() && sourceFolder.isDirectory())
		{
			// Get list of the files and iterate over them
			File[] listOfFiles = sourceFolder.listFiles();
			if (listOfFiles != null)
			{
				for (File child : listOfFiles )
				{
					// Move files to destination folder
					child.renameTo(new File(destinationFolder + "\\" + child.getName()));
				}
			}
		}
		else
		{
			System.out.println(sourceFolder + "  Folder does not exists");
		}
	}
	//Below Function used to Delete a folder by passing the folder name with Path
	public static  void Deleteafolder(String Foldername) throws IOException
	{
		FileUtils.deleteDirectory(new File(Foldername));
		File file = new File(Foldername);
		if(!file.exists())
		{
			if(file.mkdir())
			{
				//Directory created
			}
			else{
				//Directory not created
			}
		}
	}
	//Below function will capture Screenshot
	public static String captureinfoScreenshot(WebDriver driver,String screenShotName) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String dest = System.getProperty("user.dir") +"\\output\\"+screenShotName+".png";
		File destination = new File(dest);
		FileUtils.copyFile(source, destination);        
		ATUReports.add("Screenshot"+dest, LogAs.PASSED, null); 
		return dest;
	}
	@AfterSuite
	// At the end of each Class . Close the browser and clear all cookies
	public void tearDown() throws Exception {
		//driver.manage().deleteAllCookies();
		//Thread.sleep(5000);
		try{
			//getDriver().close();
			//getDriver().quit();
			//Thread.sleep(5000);
		}catch(Exception Servicescriptrunning){
		}
	}
	//Below function used to zipp a folder
	static public void zipFolder(String srcFolder, String destZipFile) throws Exception {
		ZipOutputStream zip = null;
		FileOutputStream fileWriter = null;
		fileWriter = new FileOutputStream(destZipFile);
		zip = new ZipOutputStream(fileWriter);
		addFolderToZip("", srcFolder, zip);
		zip.flush();
		zip.close();
	}
	// Below will add all the files to zip
	static private void addFileToZip(String path, String srcFile, ZipOutputStream zip)
			throws Exception {
		File folder = new File(srcFile);
		if (folder.isDirectory()) {
			addFolderToZip(path, srcFile, zip);
		} else {
			byte[] buf = new byte[1024];
			int len;
			FileInputStream in = new FileInputStream(srcFile);
			zip.putNextEntry(new ZipEntry(path + "/" + folder.getName()));
			while ((len = in.read(buf)) > 0) {
				zip.write(buf, 0, len);
			}
		}
	}
	//Below will add all folders to Zip
	static private void addFolderToZip(String path, String srcFolder, ZipOutputStream zip)
			throws Exception {try{
				File folder = new File(srcFolder);
				for (String fileName : folder.list()) {
					if (path.equals("")) {
						addFileToZip(folder.getName(), srcFolder + "/" + fileName, zip);
					} else {
						addFileToZip(path + "/" + folder.getName(), srcFolder + "/" + fileName, zip);
					}
				}
			}
			catch(Exception Zipfolder){
			}
	}
	// Below function used to Logout from the application
	public static void Logout() throws Exception {	
		TestcaseInit();
		clickByXpath(Web_UI.LogoutMenu,"Logout Menu");
		ATUReports.add("Selected Logout Menu ", LogAs.PASSED, null); 
		Thread.sleep(1000);
		clickByXpath(Web_UI.Signout,"Signout button");
		ATUReports.add("Selected Signout Button ", LogAs.PASSED, null); 
		Thread.sleep(5000);
		ATUReports.add("Successfully Logged out ", LogAs.PASSED, null); 
	}
	// Below function is written for launching browser and hit url in address bar
	public static void launchApp(String Url) throws InterruptedException	{
		getDriver().get(Url);
		Thread.sleep(2000);
		getDriver().manage().window().maximize();
		getDriver().get(Url);
	}
	// Below function is for login to application
	public static void 	Login(String envi) throws Exception {
		try{
			ATUReports.add("Successfully hit the Url in browser", LogAs.PASSED, null); 
			Thread.sleep(3000);
			//below commented code is the actual code and above is restructured sice its not wrking
			getDriver().findElement(By.id(Web_UI.LoginId)).clear();
			ATUReports.add("Cleared User Name", LogAs.PASSED, null); 
			getDriver().findElement(By.id(Web_UI.Passwordid)).clear();
			ATUReports.add("Cleared Password", LogAs.PASSED, null); 
			Sendtextbyid(Web_UI.LoginId, Web_UI.Username);
			ATUReports.add("Entered User Name", LogAs.PASSED, null); 
			System.out.println("Entered username");
			Sendtextbyid(Web_UI.Passwordid, Web_UI.Password);
			ATUReports.add("Entered User Name", LogAs.PASSED, null); 
			System.out.println("Entered Password");
			WebElement login = getDriver().findElement(By.xpath(Web_UI.Login));
			// Here using Javascript to click on login button as Selenium actions are not supported in IE browser
			JavascriptExecutor executor = (JavascriptExecutor)getDriver();
			executor.executeScript("arguments[0].click();", login);
			ATUReports.add("Selected Login Button", LogAs.PASSED, null); 
			System.out.println("Selected login button");
			Thread.sleep(5000); 
			launchApp(envi);
			Thread.sleep(5000); 
			GanntViewHeaderFunctionality.SpinnerControl();
			checkuserrole();
			GanntViewHeaderFunctionality.SpinnerControl();
			Checkappupdateclosebutton();
			// analyzeLog();
		}
		catch (Exception Popup)
		{   //Analyze log is written and now not been used. Browser logs will be capture
			//analyzeLog();
			//Check and capture screenshot when any failure during login
			ATUReports.add("Login Failed entering credential or Someother Issue", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE)); 
			captureinfoScreenshot(getDriver(), "Login Failed entering credential");
			Checkappupdateclosebutton();
		}
		try
		{
			//Check and confirm the Login happened properly
			Thread.sleep(2000);
			GanntViewHeaderFunctionality.SpinnerControl();
			WebElement LoginCheckpoint = getDriver().findElement(By.xpath(Web_UI.GantviewOption));
			if (LoginCheckpoint!=null)
			{
				ATUReports.add("Loggedin Into the application Successfully", LogAs.PASSED, null); 
			}
			else
			{
				launchApp(Web_UI.Url);
			}
			System.out.println("Logged into the application successfully and checked with check point..");
			System.out.println("**************************************************************************************");
		} catch (Exception LoginelementException)
		{
			ATUReports.add("Some issue with Login", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE)); 
			System.out.println("Some issue in loggin and refreshing the page again to load...");
			launchApp(Web_UI.Url);
			Thread.sleep(10000);
			System.out.println("**************************************************************************************");
			Checkappupdateclosebutton();
		}
	}
	//Below function used to login for any other environment
	public static void loginOtherThanGetNG(String envi) throws Exception {
		ATUReports.add("Successfully hit the Url in browser", LogAs.PASSED, null); 
		Thread.sleep(3000);
		//below commented code is the actual code and above is restructured sice its not wrking
		getDriver().findElement(By.id(Web_UI.LoginId)).clear();
		ATUReports.add("Cleared User Name", LogAs.PASSED, null); 
		getDriver().findElement(By.id(Web_UI.Passwordid)).clear();
		ATUReports.add("Cleared Password", LogAs.PASSED, null); 
		Sendtextbyid(Web_UI.LoginId, Web_UI.Username);
		ATUReports.add("Entered User Name", LogAs.PASSED, null); 
		System.out.println("Entered username");
		Sendtextbyid(Web_UI.Passwordid, Web_UI.prodPwd);
		ATUReports.add("Entered User Name", LogAs.PASSED, null); 
		System.out.println("Entered Password");
		WebElement login = getDriver().findElement(By.xpath(Web_UI.Login));
		// Here using Javascript to click on login button as Selenium actions are not supported in IE browser
		JavascriptExecutor executor = (JavascriptExecutor)getDriver();
		executor.executeScript("arguments[0].click();", login);
		ATUReports.add("Selected Login Button", LogAs.PASSED, null); 
		System.out.println("Selected login button");
		Thread.sleep(5000);
		getDriver().navigate().refresh();
		Thread.sleep(10000);
	}
	// Below function used to select element by its Xpath and we need to pass based on View as some scripts should be run based on view specific.
	public static void clickByXpathbyView(String view,String Ganttxpath, String Hybridxpath) throws Exception {
		if(view.equalsIgnoreCase("Hybridview")){
			CommonTest.SpinnerControl();
			WebElement element = explicitWaitForElement(By.xpath(Hybridxpath));
			if (element != null) {
				((JavascriptExecutor) getDriver()).executeScript("arguments[0].style.border='3px solid red'", element);
				element.click();
				Thread.sleep(2000);
				ATUReports.add("The selected element exist " + Hybridxpath + "  and clicked ", LogAs.PASSED, null); 
			} else {
				ATUReports.add("The selected element exist but click is not happening  " + Hybridxpath , LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));  
				captureinfoScreenshot(getDriver(), "Screen"+Hybridxpath);
			}
		}
		if(view.equalsIgnoreCase("Ganttview")){
			CommonTest.SpinnerControl();
			WebElement element = explicitWaitForElement(By.xpath(Ganttxpath));
			if (element != null) {
				((JavascriptExecutor) getDriver()).executeScript("arguments[0].style.border='3px solid red'", element);
				element.click();
				Thread.sleep(2000);
				ATUReports.add("The selected element exist " + Ganttxpath + "  and clicked ", LogAs.PASSED, null); 
			} else {
				ATUReports.add("The selected element exist but click is not happening  " + Ganttxpath , LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));  
				captureinfoScreenshot(getDriver(), "Screen"+Ganttxpath);
			}
		}
	}
	// Below function used to select element by its Xpath
	public static void clickByXpath(String xpath, String elementfrontendname) throws InterruptedException, IOException {
		try{
			WebElement element = explicitWaitForElement(By.xpath(xpath));
			if (element != null) {
				((JavascriptExecutor) getDriver()).executeScript("arguments[0].style.border='3px solid red'", element);
				element.click();
				Thread.sleep(2000);
				ATUReports.add("The selected element exist **** -->" + elementfrontendname + " **** and clicked ", LogAs.PASSED, null); 
			} else {
				ATUReports.add("The selected element Does NOT exist and  click is not happening  " + elementfrontendname , LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));  
				captureinfoScreenshot(getDriver(), "Screen"+xpath);
			}
		}catch(Exception click){
			ATUReports.add("Element exist but Failed to click the element " + elementfrontendname , LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));  
		}
	}
	// Below Function is used to check settings stats element exist and returns boolean value.
	public static boolean clickByXpathforstats(String xpath, String elementfrontendname) throws InterruptedException, IOException {
		try{
			WebElement element = explicitWaitForElement(By.xpath(xpath));
			if (element != null) {
				((JavascriptExecutor) getDriver()).executeScript("arguments[0].style.border='3px solid red'", element);
				element.click();
				Thread.sleep(2000);
				ATUReports.add("The selected element exist **** -->" + elementfrontendname + " **** and clicked ", LogAs.PASSED, null); 
			} else {
				ATUReports.add("The selected element Does NOT exist and  click is not happening  " + elementfrontendname , LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));  
				captureinfoScreenshot(getDriver(), "Screen"+xpath);
			}
			return true;
		}catch (Exception elementdonotexist){
			ATUReports.add("The selected element /Stats Does NOT exist and  click is not happening  " + elementfrontendname , LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return false;
		}
	}
	// Below function used to select element by its Webelement
	public static void clickBywebelementxpath(WebElement element, String elementfrontendname) throws InterruptedException {
		try{
			if (element != null) {
				((JavascriptExecutor) getDriver()).executeScript("arguments[0].style.border='3px solid red'", element);
				element.click();
				Thread.sleep(2000);
				ATUReports.add("The selected element exist *** --> " + elementfrontendname + " *** and clicked ", LogAs.PASSED, null); 
			} else {
				Assert.fail("The selected element Donot exist");
			}}catch(Exception elementnotexist){
			}
	}
	// Below Function checks whether element present and return webelement
	public static WebElement elementExistByXpath(String xpath) throws InterruptedException {
		WebElement element = explicitWaitForElement(By.xpath(xpath));
		if (element != null) {
			((JavascriptExecutor) getDriver()).executeScript("arguments[0].style.border='3px solid red'", element);
			Thread.sleep(4000);
			ATUReports.add(" The selected element exist " + xpath + "  and clicked", LogAs.PASSED, null); 
		} else {
			//Assert.fail("The selected element Donot exist");
		}
		return element;
	}
	// Below function used to Enter text to a textbox with ID as identifier
	public static void Sendtextbyid(String id, String TextKey) {
		WebElement element = explicitWaitForElement(By.id(id));
		if (element != null) {
			JavascriptExecutor executor = (JavascriptExecutor)getDriver();
			executor.executeScript("arguments[0].style.border='3px solid red'", element);
			//executor.executeScript("arguments[0].value='"+TextKey+"';", element);
			element.sendKeys(TextKey);
			Reporter.log("The selected element exist " + id + "  text key is passed");
		} else {
			Reporter.log("The selected element Donot exist");
			Assert.fail("The selected element Donot exist");
		}
	}
	// Below function used to Enter text to a textbox with Xpath as identifier
	public static void SendtextbyXpath(String Xpath, String TextKey) {
		WebElement element = explicitWaitForElement(By.xpath(Xpath));
		if (element != null) {
			((JavascriptExecutor) getDriver()).executeScript("arguments[0].style.border='3px solid red'", element);
			element.sendKeys(TextKey);
		} else {
			Reporter.log("The selected element Donot exist");
			Assert.fail("The selected element Donot exist");
		}
	}
	// Below Function Returns text value from xpath
	public static String findTextByXpathwithinXpath(String xpath, String Xpath2) {
		WebElement element = explicitWaitForElement(By.xpath(xpath));
		try{
			String returntext = element.findElement(By.xpath(Xpath2)).getText();
			return returntext;
		}
		catch(Exception elementnotexist){
			String returntext = element.findElement(By.xpath(Xpath2)).getAttribute("innerText");
			return returntext;
		}
	}
	// Below function will provide size of table
	public static void Checktablesize(String xpath, String Xpath2) {
		WebElement element = explicitWaitForElement(By.xpath(xpath));
		if (element != null) {
			List<WebElement> Tablelist3 = element.findElements(By.xpath(Xpath2));
			int l = Tablelist3.size();
			System.out.println("The Number of Search result displayed is " + l);
			Reporter.log("Searched for the flight form search flight option and no of flights found is" + l);
		} else {
			Reporter.log("The selected element Donot exist");
			Assert.fail("The selected element Donot exist");
		}
	}
	// Below function used to select an element by Xpath by double clicking it.
	// Mainly used over the leftpane
	public static void doubleclickByXpath(String xpath) {
		WebElement element = explicitWaitForElement(By.xpath(xpath));
		if (element != null) {
			Actions action = new Actions(getDriver());
			((JavascriptExecutor) getDriver()).executeScript("arguments[0].style.border='3px solid red'", element);
			action.doubleClick(element).perform();
			Reporter.log("The selected element exist " + xpath + " and clicked");
		} else {
			Reporter.log("The selected element Donot exist");
		}
	}
	// Below function is used to identify an element by finding an link with in Xpath
	public static void clickBylinkwithinxpath(String xpath, String Link) {
		WebElement element = explicitWaitForElement(By.xpath(xpath));
		WebElement Linkelement = element.findElement(By.linkText(Link));
		if (Linkelement != null) {
			((JavascriptExecutor) getDriver()).executeScript("arguments[0].style.border='3px solid red'", Linkelement);
			Linkelement.click();
			Reporter.log("The selected element exist " + Link + " and clicked");
		} else {
			Reporter.log("The selected element Donot exist");
		}
	}
	// Below code is used to select an nested element having Xpath as identifier
	public static void clickbyxpathwithinxpath(String xpath1, String xpath2) {
		WebElement element = explicitWaitForElement(By.xpath(xpath1));
		WebElement Linkelement = element.findElement(By.xpath(xpath2));
		if (Linkelement != null) {
			((JavascriptExecutor) getDriver()).executeScript("arguments[0].style.border='3px solid red'", Linkelement);
			Linkelement.click();
			Reporter.log("The selected element exist " + xpath2 + " and clicked");
		} else {
			Reporter.log("The selected element Donot exist");
		}
	}
	// Below code is used to select an element by link as identifier
	public static void clickbylink(String vlink) {
		WebElement vlink1 = explicitWaitForElement(By.linkText(vlink));
		if (vlink1 != null) {
			((JavascriptExecutor) getDriver()).executeScript("arguments[0].style.border='3px solid red'", vlink1);
			vlink1.click();
			Reporter.log("The selected element exist " + vlink + " and clicked");
		} else {
			Reporter.log("The selected element Donot exist");
			Assert.fail("The selected element Donot exist");
		}
	}
	// Below code to locate an element by its id.
	public static void clickbyid(String idd) {
		WebElement ids = explicitWaitForElement(By.linkText(idd));
		if (ids != null) {
			((JavascriptExecutor) getDriver()).executeScript("arguments[0].style.border='3px solid red'", ids);
			ids.click();
			Reporter.log("The selected element exist " + idd + " and clicked");
			ATUReports.add(" The selected element exist " + idd + "  and clicked", LogAs.PASSED, null); 
		} else {
			Assert.fail("The selected element Donot exist");
		}
	}
	// If need , use below to take screenshot
	public static void takeScreenShot(String fileName) {
		WebDriver augmentedDriver = new Augmenter().augment(getDriver());
		File screenshot = ((TakesScreenshot) augmentedDriver).getScreenshotAs(OutputType.FILE);
		try {
			String directory = System.getProperty("user.dir");
			System.out.println(directory + fileName);
			FileUtils.copyFile(screenshot, new File(directory + fileName + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	// /////////////////////////////////////////////////////////////////////////////////////////////////
	// Force Wait code
	// ///////////////////////////////////////////////////////////////////////////////////////
	public void sleep(int second) {
		try {
			Thread.sleep(second * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	// ////////////////////////////////////////////////////////////////////////////////
	// Select an element by Class name
	public static void clickByClassName(String className) {
		WebElement element = explicitWaitForElement(By.className(className));
		if (element != null) {
			element.click();
		}
	}
	// ///////////////////////////////////////////////////////////////////////////
	// Use below code to Send keytext incase of Textbox operation
	public static void InputText(String xpath, String getin) {
		WebElement element = explicitWaitForElement(By.xpath(xpath));
		if (element != null) {
			element.click();
			element.sendKeys(getin);
		}
	}
	public static WebElement findelementbyxpath(String xpath) {
		WebElement element = explicitWaitForElement(By.xpath(xpath));
		return element;
	}
	public static WebElement findelementsbyxpath(String xpath) {
		WebElement element = explicitWaitForElement(By.xpath(xpath));
		return element;
	}
	public static WebElement findelementbyid(String idd) {
		WebElement element = explicitWaitForElement(By.id(idd));
		return element;
	}
	// ////////////////////////////////////////////////////////////////////////////////////
	// Explict wait statement to instruct webdriver to wait for an element to visible
	public static WebElement explicitWaitForElement(final By by) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(getDriver()).withTimeout(200, TimeUnit.SECONDS)
				.pollingEvery(5, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
		WebElement element = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(by);
			}
		});
		return element;
	}
	// Function to validate Time Format
	public static boolean timevalidatior(String time)
	{
		Pattern pattern; 
		Matcher matcher; 
		String TIME24HOURS_PATTERN = "([01]?[0-9]|2[0-3]):[0-5][0-9]"; 
		pattern = Pattern.compile(TIME24HOURS_PATTERN); 
		matcher = pattern.matcher(time); 
		return matcher.matches(); 
	} 
	//Below function check newly added UserRole management popup
	public static void checkuserrole() throws Exception {
		try {
			WebElement userrolepopup = getDriver().findElement(By.xpath(Web_UI.Userrolepopup));
			if(userrolepopup!=null)
			{
				try {
					WebElement setrole = getDriver().findElement(By.xpath(Web_UI.SelectUserroledropdown));
					setrole.click();
					clickByXpath(Web_UI.Setuserrole,"Selectuserrole");
					Thread.sleep(1000);
					setrole.click();
					clickByXpath(Web_UI.Continuesettinguserrole,"Continuesettinguserrole");
					Thread.sleep(2000);
					ATUReports.add(" User role updated successfully to regional unit manager", LogAs.PASSED, null); 
				}catch (Exception Rolehandlernotpresent) {
					//test.log(LogStatus.FAIL, "Error in selecting role");
					ATUReports.add(" Error in selecting role ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE)); 
				}
			}
		}catch (Exception Rolehandlernotpresent) {
			ATUReports.add(" Role Handler not present", LogAs.PASSED, null); 
		}
	}
	// Selection Based on view
	public static void Selectview(String viewname) throws Exception {
		String VienameProvided= viewname;
		if (VienameProvided.equalsIgnoreCase("Ganttview"))
		{
			try	{
				clickByXpath(Web_UI.GantviewOption,"GantviewOption");
				CommonTest.SpinnerControl();
				Thread.sleep(1000);
				ATUReports.add("****************** Selected gantt view option for validation ****************** ",  LogAs.PASSED, null);
			}catch(Exception ganttnotselected){
				ATUReports.add("Gantt Option Not selected ",  LogAs.FAILED, null);
			}
		}if (VienameProvided.equalsIgnoreCase("Hybridview"))
		{
			try	{
				clickByXpath(Web_UI.HybridViewOption,"HybridViewOption");
				CommonTest.SpinnerControl();
				Thread.sleep(1000);
				ATUReports.add("****************** Selected Hybrid view option for validation ****************** ",  LogAs.PASSED, null);
			}catch(Exception ganttnotselected){
				ATUReports.add("Hybrid view Option Not selected ",  LogAs.FAILED, null);
			}
		}
	}
	// Below function is to check the data load status based on spinner action
	public static void SpinnerControl() throws Exception {
		try {
			for (int i = 0; i <= 30; i++) {		
				WebElement Spinner = getDriver().findElement(By.xpath(Web_UI.LoadSpinnercontroller));
				if (i<10)
				{
					if (Spinner != null) {
						Thread.sleep(5000);
					}
					else
					{
						break;
					}
				}
				if(i==30){
					ATUReports.add("Taken More time to load the page ", LogAs.INFO,  new CaptureScreen(ScreenshotOf.BROWSER_PAGE));	
				}
			}
		} 
		catch (Exception SpineerException) {
			//System.out.println("Spinner property  issue");
		}
		try{
			WebElement Loadstatus = getDriver().findElement(By.xpath(Web_UI.LoadSpinnerresult));	
			//System.out.println("Checking Data load status");
			if (Loadstatus != null) {	
				//Thread.sleep(1000);
				String LoadMessage = Loadstatus.getAttribute("innerHTML");
				if(LoadMessage.contains("good"))
				{
				}
				else
				{
				}
			}
		}
		catch(Exception E){
			System.out.println("Page not loaded successfully or browser closed on unfortunate event");
		}
	}
	// Zoom Out in Gantt view
	public static void zoomOut() throws InterruptedException, IOException {
		for(int zoomoutcount=0; zoomoutcount<1; zoomoutcount++ )
		{
			clickByXpath(Web_UI.Zoomout,"Zoomout");
			ATUReports.add("Zoom Out icon present in Header bar and Clicked ", LogAs.PASSED, null); 
			GanntViewHeaderFunctionality.RealtimeBar();
		}
	}
	public static void zoomin() throws InterruptedException, IOException {
		for(int zoomoutcount=0; zoomoutcount<1; zoomoutcount++ )
		{
			clickByXpath(Web_UI.Zoomin,"Zoomin");
			ATUReports.add("Zoom In icon present in Header and Clicked ", LogAs.PASSED, null); 
			GanntViewHeaderFunctionality.RealtimeBar();
		}
	}
	// Zoom Out for stats Gantt view
	public static void zoomOutdata() throws InterruptedException {
		try{
			for(int zoomoutcount=0; zoomoutcount<5; zoomoutcount++ )
			{
				getDriver().findElement(By.xpath(Web_UI.Zoomout)).click();
			}
		}catch(Exception Zoomoutexcep){
		}
	}
	public static void zoomindata() throws InterruptedException {
		try{
			for(int zoomoutcount=0; zoomoutcount<5; zoomoutcount++ )
			{
				getDriver().findElement(By.xpath(Web_UI.Zoomin)).click();
			}
		}
		catch(Exception zoomexcep){
		}
	}
	//Below function will perform refresh Function
	public static void Refresh() throws Exception {
		CommonTest.SpinnerControl();
		getDriver().findElement(By.xpath(Web_UI.pagerefreshdropdown)).click();
		ATUReports.add(" Select refresh button from Menu ", LogAs.PASSED, null); 
		Thread.sleep(2000);
		getDriver().findElement(By.xpath(Web_UI.Refreshbutton)).click();		
		Thread.sleep(2000);
		ATUReports.add(" Refresh Executed  ", LogAs.PASSED, null); 
		System.out.print("Refresh Executed");
		GanntViewHeaderFunctionality.SpinnerControl();
	}
	//Below code will execute scroll action in gantt view
	public static void scrollGanttViewright() throws Exception {		
		Actions actions = new Actions(getDriver());
		WebElement scrllbar = findelementbyxpath(Web_UI.Horizontalscrollbar);	
		actions.click(scrllbar).build().perform();
		for (int scrl=0; scrl<=8; scrl++)
		{
			actions.sendKeys(Keys.ARROW_RIGHT).build().perform();
		}
	}
	//Check Gantt is in  Centeraligned and Default and perform basic check for ganttview validation to display flights inorder to confirm no data issues.
	public static void CheckGanttviewListisnotZero() throws Exception {
		try{
			GanntViewHeaderFunctionality.GanntViewSelection();
			//commenting below since spinner ctrl is not present in new ui - Kalai
			//CommonTest.SpinnerControl();
			List<WebElement> Ganntlist = getDriver().findElements(By.xpath(Web_UI.PuckComplete));
			int Ganntlistcount = Ganntlist.size();
			if(Ganntlistcount == 0)
			{
				//Perform setting puck option to default and center
				clickByXpath(Web_UI.filtericon,"filtericon");
				Thread.sleep(2000);
				clickByXpath(Web_UI.ViewSettings,"ViewSettings");
				Thread.sleep(2000);
				clickByXpath(Web_UI.SettingPuckCenter,"SettingPuckCenter");
				Thread.sleep(1000);
				clickByXpath(Web_UI.SettingPuckDefault,"SettingPuckDefault");
				try{
					clickByXpath(Web_UI.ViewSettings,"ViewSettings");
					Thread.sleep(1000);
					WebElement Showetdoutside = getDriver().findElement(By.xpath("//input[@id='gantt-show-etd']"));
					boolean CheckShowetdoutsideselected = Showetdoutside.isSelected();
					// Perform unselecting Show etd outside option from view settings
					if(CheckShowetdoutsideselected==true){
						clickBywebelementxpath(Showetdoutside,"Showetdoutside");
						ATUReports.add("Show etd outside is unselected ",  LogAs.PASSED, null);
					}else{
						ATUReports.add("Show etd outside is already unselected ",  LogAs.PASSED, null);
					}
					// Perform Unselect for draw to actual GT from view settings
					WebElement DrawtoactualGT = getDriver().findElement(By.xpath("//input[@id='gantt-puck-width']"));
					boolean CheckDrawtoactualGTselected = DrawtoactualGT.isSelected();
					if(CheckDrawtoactualGTselected==true){
						clickBywebelementxpath(DrawtoactualGT,"DrawtoactualGT");
						ATUReports.add("DrawtoactualGT is unselected ",  LogAs.PASSED, null);
					}else{
						ATUReports.add("DrawtoactualGT is already unselected ",  LogAs.PASSED, null);
					}
				}catch(Exception errorinetdunchecking){
					ATUReports.add("Error in selecting DrawtoactualGT and Show ETD outside the view ",  LogAs.INFO,  new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}
				try{
					// Check whether International and domestic options are selected in Advanced tab under settings page
					clickByXpath(Web_UI.SettingsAdvancedTab,"SettingsAdvancedTab");
					Thread.sleep(1000);
					WebElement domesticcheck1 = getDriver().findElement(By.xpath("//input[@id='Domestic']"));
					boolean checkDomesticselected = domesticcheck1.isSelected();
					if(checkDomesticselected==false){
						clickBywebelementxpath(domesticcheck1,"domestic");
						ATUReports.add("Selected Domestic option in settings",  LogAs.PASSED, null);
					}else{
						ATUReports.add("Domestic option already selected ",  LogAs.PASSED, null);
					}
					WebElement internationalcheck1 = getDriver().findElement(By.xpath("//input[@id='International']"));
					boolean checkinternationalselected = internationalcheck1.isSelected();
					if(checkinternationalselected==false){
						clickBywebelementxpath(internationalcheck1,"international");
						ATUReports.add("International option Selected",  LogAs.PASSED, null);
					}else{
						ATUReports.add("International option already Selected ",  LogAs.PASSED, null);
					}
				}catch(Exception anotherprop){
					ATUReports.add("Some issue in selecting International and domestic Option ",  LogAs.INFO,  new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}
				Thread.sleep(1000);
				clickByXpath(Web_UI.ApplyButton,"ApplyButton");
				Thread.sleep(8000);
				CommonTest.SpinnerControl();
				Thread.sleep(8000);
			}
			else{
			}
		}
		catch(Exception listempty)
		{
			try{
				clickByXpath(Web_UI.filtericon,"filtericon");
				Thread.sleep(2000);
				clickByXpath(Web_UI.ViewSettings,"ViewSettings");
				Thread.sleep(2000);
				clickByXpath(Web_UI.SettingPuckCenter,"SettingPuckCenter");
				Thread.sleep(1000);
				clickByXpath(Web_UI.SettingPuckDefault,"SettingPuckDefault");
				clickByXpath(Web_UI.ApplyButton,"ApplyButton");
				Thread.sleep(8000);
				CommonTest.SpinnerControl();
				Thread.sleep(8000);
			}
			catch(Exception checkapp)
			{
				ATUReports.add("  CheckApp. List not returned", LogAs.PASSED, null); 
			}
		}
		CommonTest.SpinnerControl();
	}
	//Check Expand  before switching to cases
	public static void CheckExpand() throws Exception {
		try{
			WebElement Expand = getDriver().findElement(By.xpath(Web_UI.Expand));
			Expand.click();	
			ATUReports.add("  View Expanded Successfully  ", LogAs.PASSED, null); 
			Thread.sleep(2000);
		}
		catch(Exception noexpand)
		{
		}
	}
	//Check  Collapse before switching to cases
	public static void CheckCollapse() throws Exception {
		try{
			WebElement Collapse = getDriver().findElement(By.xpath(Web_UI.Collapse));
			Collapse.click();		
			ATUReports.add(" View Collapsed Successfully ", LogAs.PASSED, null); 
		}
		catch(Exception noCollapse)
		{
		}
	}	
	public static void Checkappupdateclosebutton() throws Exception {
		try{
			WebElement OKButton = getDriver().findElement(By.xpath(Web_UI.Closebutton));
			OKButton.click();
		}catch(Exception OKButtonnotpresent)
		{
		}
	}
	public static void CheckOKPopupPresentandclose() throws Exception {
		try{
			WebElement OKButton = getDriver().findElement(By.xpath(Web_UI.OKBUTTON));
			OKButton.click();
		}catch(Exception OKButtonnotpresent)
		{
			Thread.sleep(5000);
		}
	}
	public static void CheckCancelPopupPresentandclose() throws Exception {
		try{
			WebElement OKButton = getDriver().findElement(By.xpath(Web_UI.DashboardfilterCancel));
			OKButton.click();
		}catch(Exception OKButtonnotpresent)
		{
			Thread.sleep(5000);
		}
	}
	//Below will verify the mode is set to Scheduled mode
	public static void CheckScheduled() throws Exception {
		try{
			WebElement ScheduledCheck = getDriver().findElement(By.xpath(Web_UI.SchCheckpoint));
			WebElement ScheduledButton = getDriver().findElement(By.xpath(Web_UI.Schbutton));
			String Scheduledtext = ScheduledCheck.getText();
			if (Scheduledtext.contains("SCH"))
			{
				System.out.println("Already in scheduled mode");
				ATUReports.add("Check whether mode is set to Schedule mode  ", LogAs.PASSED, null); 
				ATUReports.add("Already in Schedule Mode  ", LogAs.PASSED, null); 
			}
			else
			{
				ScheduledButton.click();
				Thread.sleep(8000);
				CommonTest.SpinnerControl();
				Thread.sleep(2000);
				String Scheduledtext1 = ScheduledCheck.getText();
				if (Scheduledtext1.contains("SCH"))
				{
					System.out.println("Selected Scheduled successfully");
					ATUReports.add(" Selected Schedule mode", LogAs.PASSED, null); 
				}
			}
		}
		catch(Exception Noschedule)
		{
			WebElement DepartureCheck = getDriver().findElement(By.xpath(Web_UI.DepCheckpoint));
			WebElement DepartureButton = getDriver().findElement(By.xpath(Web_UI.Schbutton));
			DepartureButton.click();
			Thread.sleep(8000);
			CommonTest.SpinnerControl();
			Thread.sleep(2000);
			WebElement DepartureCheck1 = getDriver().findElement(By.xpath(Web_UI.SchCheckpoint));
			String DepartureText = DepartureCheck1.getText();
			if (DepartureText.contains("SCH"))
			{
				System.out.println(" Schedule mode done");
				ATUReports.add("Switched to Schedule mode ", LogAs.PASSED, null); 
			}
			else
			{
				System.out.println("Something Wrong");
				ATUReports.add("Something Went Wrong ", LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));  
			}
		}
	}	
	public static void CheckDepartureSelected() throws Exception {
		try{
			WebElement DepartureCheck = getDriver().findElement(By.xpath(Web_UI.DepCheckpoint));
			WebElement DepartureButton = getDriver().findElement(By.xpath(Web_UI.Schbutton));
			String DepartureText = DepartureCheck.getText();
			if (DepartureText.contains("DEP"))
			{
				System.out.println("Already in Departure mode");
				ATUReports.add("Already in Departure mode  ", LogAs.PASSED, null); 
			}
			else
			{
				DepartureButton.click();
				Thread.sleep(8000);
				CommonTest.SpinnerControl();
				Thread.sleep(2000);
				String DepartureText1 = DepartureCheck.getText();
				if (DepartureText1.contains("DEP"))
				{
					System.out.println("Selected Departure successfully");
					ATUReports.add(" Departure mode selected successfully  ", LogAs.PASSED, null); 
				}
			}
		}
		catch(Exception Nodeparture)
		{
			WebElement DepartureCheck = getDriver().findElement(By.xpath(Web_UI.SchCheckpoint));
			WebElement DepartureButton = getDriver().findElement(By.xpath(Web_UI.Schbutton));
			DepartureButton.click();
			Thread.sleep(8000);
			CommonTest.SpinnerControl();
			Thread.sleep(2000);
			WebElement DepartureCheck1 = getDriver().findElement(By.xpath(Web_UI.DepCheckpoint));
			String DepartureText = DepartureCheck1.getText();
			if (DepartureText.contains("DEP"))
			{
				System.out.println("Departure mode done");
				ATUReports.add("Switched to Departure mode ", LogAs.PASSED, null); 
			}
			else
			{
				System.out.println("Something Wrong");
				ATUReports.add(" Something went wrong", LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));  
			}
		}
	}	
	//Timer Function validation cchecks the given time is between the time range
	public static boolean isTimeBetweenTwoTime(String time11, String time22, String time33) throws Exception {
		String string1 = time11;
		Date time1 = new SimpleDateFormat("HH:mm:ss").parse(string1);
		// Here i think we need to subtract a day
		Calendar calendar1 = Calendar.getInstance();
		calendar1.setTime(time1);
		calendar1.add(Calendar.DATE, 0);
		String string2 = time22;
		Date time2 = new SimpleDateFormat("HH:mm:ss").parse(string2);
		Calendar calendar2 = Calendar.getInstance();
		calendar2.setTime(time2);
		calendar2.add(Calendar.DATE, 1);
		String someRandomTime = time33;
		Date d = new SimpleDateFormat("HH:mm:ss").parse(someRandomTime);
		Calendar calendar3 = Calendar.getInstance();
		calendar3.setTime(d);
		calendar3.add(Calendar.DATE, 1);
		Date x = calendar3.getTime();
		Date y = calendar1.getTime();
		Date z = calendar2.getTime();
		if (x.after(y) || x.before(z)) {
			//checks whether the current time is between 14:49:00 and 20:11:13.
			System.out.println("Time for validation .. Max range"+time22+ "MinRange "+time11+"Time Passed for validation " +time33);
			return true;
		}
		else
		{
			System.out.println(false);
			return false;
		}
	}
	//Below will check the time is in 24hours format or not
	public static void validateTimein24hours(final String time){
		pattern = Pattern.compile(TIME24HOURS_PATTERN);
		matcher = pattern.matcher(time);
		boolean timematches = matcher.matches();
		System.out.print("The 24 hour format is validated and result is  "+timematches);
	}
	// Har file handling		
	public static void HarStart(String Scenario, String Filename) throws Exception {
		// create a new HAR with the label "GETNg.com"
		proxy.newHar(Scenario);
		// Write HAR Data in a File
		// proxy.start(0);
	}
	public static void HarStop(String Scenario, String Filename) throws Exception {
		Har har = proxy.getHar();
		File harFile = new File("D:\\American Airlines Checkout code\\Captured Har files\\"+Scenario+Filename+".har");
		System.out.println (harFile);
		try {
			har.writeTo(harFile);
		} catch (IOException ex) {
			System.out.println (ex.toString());
			System.out.println("Could not find file " );
		}
		//proxy.endHar();
	}	
	//Check Expand Collapse before switching to cases
	public static void ExpandTest() throws Exception {
		try{
			WebElement Expand = getDriver().findElement(By.xpath(Web_UI.Expand));
			Expand.click();	
			//test.log(LogStatus.PASS, " View Expanded Successfully " );
			ATUReports.add(" View Expanded Successfully ", LogAs.PASSED, null); 
			Thread.sleep(2000);
			try{
				WebElement Expandcheckpoint = getDriver().findElement(By.xpath(Web_UI.Expandcheckpoint));
				if (Expandcheckpoint!=null)
				{
					ATUReports.add("Some issue in expanding the page  ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE)); 
				}
				else{
					ATUReports.add(" View Expanded and verified with checkpoints ", LogAs.PASSED, null); 
				}
			}catch(Exception noexpand)
			{
				ATUReports.add("View Expanded and verified with checkpoints ", LogAs.PASSED, null); 
			}
		}
		catch(Exception noexpand)
		{
		}
	}
	//Check Expand Collapse before switching to cases
	public static void CollapseTest() throws Exception {
		try{
			WebElement Collapse = getDriver().findElement(By.xpath(Web_UI.Collapse));
			Collapse.click();		
			ATUReports.add("View Collapsed Successfully  ", LogAs.PASSED, null); 
			try{
				WebElement Expandcheckpoint = getDriver().findElement(By.xpath(Web_UI.Expandcheckpoint));
				if (Expandcheckpoint!=null)
				{
					ATUReports.add("View Collapsed and verified with checkpoints ", LogAs.PASSED, null); 
				}
				else{
					ATUReports.add("  Some issue in expanding the page ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE)); 
				}
			}catch(Exception noexpand)
			{
				ATUReports.add("Some issue in expanding the page  ", LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));  
			}
		}
		catch(Exception noCollapse)
		{
			ATUReports.add(" View is already in collapsed mode  ", LogAs.PASSED, null); 
		}
	}    
	//Below will be called in start of every testcase to know whether any popups or unwanted window blocking the specific  execution and clears off the popups  
	public static void TestcaseInit() throws Exception {
		try{
			CommonTest.Checkappupdateclosebutton();
		}catch(Exception one){
		}
		try{
			Actions action = new Actions(getDriver());
			action.sendKeys(Keys.ESCAPE).build().perform();
		}catch(Exception one){
		}
		try{
			getDriver().findElement(By.xpath("//div[contains(@class,'repoerts-top')]/span[@class='close-icn']")).click();
		}catch(Exception one){
		}
		try{
			getDriver().findElement(By.xpath("//span[@class='close-icn error-popup']")).click();
		}catch(Exception one){
		}
		try{
			getDriver().findElement(By.xpath("//span[@class='close-icn db-close']")).click();
		}catch(Exception one){
		}
		try{
			CommonTest.CheckCancelPopupPresentandclose();
		}catch(Exception two){
		}		
		try{
			CommonTest.CheckCollapse();
		}catch(Exception one){
		}
		try{
			CommonTest.CheckOKPopupPresentandclose();
		}catch(Exception two){
		}
		try{
			getDriver().findElement(By.xpath("//a[text()='OK']")).click();
		}catch(Exception ramppopup){
		}
		try {
			WebElement SmallFont = getDriver().findElement(By.xpath(Web_UI.SmallFont));
			SmallFont.click();
		}
		catch(Exception two){
		}
	}
	public static void analyzeLog() {
		LogEntries logEntries = getDriver().manage().logs().get(LogType.BROWSER);
		for (LogEntry entry : logEntries) {
			System.out.println(new Date(entry.getTimestamp()) + " " + entry.getLevel() + " " + entry.getMessage());
			//do something useful with the data
			System.out.println(" ");
		}
		for (LogEntry entry1 : getDriver().manage().logs().get(LogType.PERFORMANCE)) {
			System.out.println(entry1.toString());
		}
		for (LogEntry entry2 : getDriver().manage().logs().get(LogType.PROFILER)) {
			System.out.println(entry2.toString());
		}
		for (LogEntry entry3 : getDriver().manage().logs().get(LogType.CLIENT)) {
			System.out.println(entry3.toString());
		}
		for (LogEntry entry4 : getDriver().manage().logs().get(LogType.DRIVER)) {
			System.out.println(entry4.toString());
		}
	}
	//Below will provide system usage memory 
	public static void getSystemUsage() {
		OperatingSystemMXBean operatingSystemMXBean = ManagementFactory
				.getOperatingSystemMXBean();
		for (Method method : operatingSystemMXBean.getClass()
				.getDeclaredMethods()) {
			method.setAccessible(true);
			if (method.getName().startsWith("get")&& Modifier.isPublic(method.getModifiers())) {
				Object value;
				try {
					value = method.invoke(operatingSystemMXBean);
				} catch (Exception e) {
					value = e;
				}
				System.out.println(method.getName() + " = " + value);
			}
		}
	}
	public static void printprocess() {
		try {
			String process;
			Process p = Runtime.getRuntime().exec("ps -few");
			BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
			while ((process = input.readLine()) != null) {
				System.out.println(process); // <-- Print all Process here line
				// by line
			}
			input.close();
			System.out.println(System.getenv().get("chrome.exe"));
		} catch (Exception err) {
			err.printStackTrace();
		}
	}
	public static Long Memoryused() throws Exception {
		Runtime runtime = Runtime.getRuntime();
		String cmds[] = {"cmd", "/c", "tasklist"};
		Process proc = runtime.exec(cmds);
		InputStream inputstream = proc.getInputStream();
		InputStreamReader inputstreamreader = new InputStreamReader(inputstream);
		BufferedReader bufferedreader = new BufferedReader(inputstreamreader);
		String line;
		long Totalmemoryconsumed = 0;
		while ((line = bufferedreader.readLine()) != null) {
			if(line.contains("chrome")){
				String KBB = line.substring(64, 76).trim();
				String Memoryconsumed[] = KBB.split(" K");
				long Memoryadd =  Long.parseLong(Memoryconsumed[0].replace(",", ""));
				Totalmemoryconsumed = Totalmemoryconsumed+Memoryadd;
			}
		}
		System.out.println(Totalmemoryconsumed/1000 + "  MB");
		ATUReports.add(Totalmemoryconsumed/1000 + "  MB", LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE)); 
		return Totalmemoryconsumed/1000;
	}
	public static void Exportmemoryvalue(ArrayList Mem) throws Exception {
		ArrayList<Long> Capturedvalue = Mem;
		try {
			FileInputStream file = new FileInputStream(new File("MemoryUsage1.xlsx"));
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet sheet = workbook.getSheetAt(0);
			Cell cell = null; 
			int mmmm =Capturedvalue.size();           
			try{    
				for( int mia=1;mia<=mmmm-1;mia++){
					long mamamia = Capturedvalue.get(mia);
					Row row = sheet.getRow(mia);
					int columnCount = 2;
					Cell cell1 = row.getCell(1);
					cell1.setCellValue((Long) mamamia);
				}
			}catch(Exception eett){
				System.out.println(" ");
			}
			FileOutputStream outputStream = new FileOutputStream("MemoryUsage.xlsx");
			workbook.write(outputStream);
			outputStream.close();   
		}
		catch(Exception ET){
			System.out.println("");
		}
	}

}