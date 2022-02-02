package get.next.gen.utilities;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.google.gson.Gson;
import com.relevantcodes.extentreports.LogStatus;
import atu.testng.reports.ATUReports;
import atu.testng.reports.logging.LogAs;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;
import get.next.gen.commonaction.CommonTest;
public class LookAhead extends CommonTest {
	static XSSFWorkbook workbook = new XSSFWorkbook();
	static XSSFSheet spreadsheet = workbook.createSheet("Diversion Mismatch");
	static XSSFRow row; 
	static Map<String, Object[]> diversionData = new TreeMap<String, Object[]>(); 
	public static void retrieveingDataFromLookAhead() throws Exception {
		/*int lka_activeDiversionscount = getDriver().findElements(By
				.xpath("//table[@id='dt-diversion-tbl-body-print']//tr[@class='dt-diversion-row dt-diversion-active']"))
				.size();
		System.out.println("lka" + lka_activeDiversionscount);*/
		List<String> lka_flightNumbersList = new ArrayList<>();
		List<String> getNG_flightNumbersList = new ArrayList<>();
		//getNG_flightNumbersList=DiversonReport.getNG_flightNumbersList;
		getNG_flightNumbersList.add("AA~2283/05~CSV~MIA~MIA~LAX~B772~7BH~182~~20:09~20:12~101~101~OUT~21:35~~18:29~~~~~~~~~info~queue~1473/07~~MIA~10:00~2343/06 queue~~ORD~12:05~~~~~END");
		getNG_flightNumbersList.add("AA~1234/05~CSV~MIA~MIA~LAX~B77~7BH~165~~20:09~20:12~101~101~OUT~21:35~~18:29~~~~~~~~~info~queue~1473/07~~MIA~10:00~2343/06 queue~~ORD~12:05~~~~~END");
		//getNG_flightNumbersList.add("YX~5015/04~WXD~CLT~ORD~ATW~ERJ6~102~30~~22:47~~11~11~ETD~06:00~~0.006~N/A~~~~~~~~~~5016/05~~CLT~06:00~~~~~~~~~END");
		/*for(int i =1;i<=lka_activeDiversionscount;i++) {
			StringBuilder stringBuilder = new StringBuilder();
			for(int xpathCount = 1; xpathCount <= 40; xpathCount++) {
				if(xpathCount ==2) {
					try {		
						String lka_flightNumfull = getDriver().findElement(By.
								xpath("//tr[@class='dt-diversion-row dt-diversion-active']["+i+"]/td[2]/div")
								).getAttribute("textContent").substring(1,8).trim()+"~"; 
						stringBuilder.append(lka_flightNumfull);
					}catch(Exception e){ 
						String lka_flightNumfull = getDriver().findElement(By.
								xpath("//tr[@class='dt-diversion-row dt-diversion-active']["+i+"]/td[2]")
								).getAttribute("textContent").trim()+"~"; 
						stringBuilder.append(lka_flightNumfull);
					}
				}
				else {
					getDriverDetails(stringBuilder, i, xpathCount);			
				}
			}
			lka_flightNumbersList.add(stringBuilder.toString());
		}*/
		lka_flightNumbersList.add("AA~2283/05~CSV~MIA~MIA~LAX~777~7BH~168~~20:09~20:12~101~17~OUT~21:35~~*-00:35F~*02:07~~~~~~~~~~1473/07~~MIA~10:00~HTL~~ORD~12:05~TERM~~~~END");
		lka_flightNumbersList.add("AA~1234/05~CSV~MIA~MIA~LAX~B772~7BH~182~~20:09~20:12~101~101~OUT~21:35~~18:29~~~~~~~~~info~queue~1473/07~~MIA~10:00~2343/06 queue~~ORD~12:05~~~~~END");
		//lka_flightNumbersList.add("YX~5015/04~WXD~CLT~ORD~ATW~ERJ~102~32~~22:47~~11~11~ETD~06:00~~N/A~N/A~~~~~~~~~~5016/05~~CLT~07:20~~~~~~~~~END");
		System.out.println(lka_flightNumbersList);
		List<String> asList;
		List<String> getNGAsList;
		List<String> lkaFlights = new ArrayList<>();
		List<String> getNGFlights = new ArrayList<>();
		List<String> lkaFieldNames = new ArrayList<>();
		/*lkaFieldNames = Arrays.asList("FltNum","RSN","DEP","DIV","DEST","TYPE","TAIL","PAX","ETA","ON","IN","TET","PET","STS",
				"LGTD","CTD","DTRLEG","FTRLEG","LOC","Acars_Pax","Fuel","Station_Loc","Station_pax","Station fuel","ssr","Rmks","Aircraft_flt",
				"Aircraft_Leg","Aircraft_Dest","Aircraft_LGTD","Cockpit_flt","Cockpit_Leg","Cockpit_Dest","Cockpit_LGTD","Cabin_flt","Cabin_Leg","Cabin_Dest","Cabin_LGTD");*/
		for(int lkaHeders=1;lkaHeders<=40;lkaHeders++) {
			//			getDriver().findElement(By.xpath("(//tr[@class='dt-diversion-header sub']//td)["+lkaHeders+"]")).getAttribute("textContent").trim();
			lkaFieldNames.add(getDriver().findElement(By.xpath("(//tr[@class='dt-diversion-header sub']//td)["+lkaHeders+"]")).getAttribute("textContent").trim());
		}
		System.out.println(lkaFieldNames.toString());
		int row = 1;
		String rowCount=Integer.toString(row);
		diversionData.put(rowCount,  new Object[] {"Flt#", "Field", "LKA","Azpe" });
		for (String lkaElement : lka_flightNumbersList) {
			String[] split = lkaElement.split("~");
			asList = Arrays.asList(split);
		
			lkaFlights.add("1234");
			lkaFlights.add("3456");
			lkaFlights.add(asList.get(1));
			System.out.println("asList size"+asList.size());
			for (String getNGElement : getNG_flightNumbersList) {
				String[] getNGSplit = getNGElement.split("~");
				getNGAsList = Arrays.asList(getNGSplit);
				getNGFlights.add(getNGAsList.get(1));
				System.out.println("getNGAsList size"+getNGAsList.size());
				if(asList.get(1).trim().equals(getNGAsList.get(1).trim())) {
					for(int j=0;j<asList.size();j++) {
						if(!asList.get(j).trim().equalsIgnoreCase(getNGAsList.get(j).trim())){
							System.out.println("For Flight "+asList.get(1)+"    "+lkaFieldNames.get(j)+" field Equal | LKA : "+asList.get(j)+" Azpe : "+getNGAsList.get(j));
							row++;
							rowCount = Integer.toString(row);
							diversionData.put(rowCount,  new Object[] {asList.get(1), lkaFieldNames.get(j), asList.get(j),getNGAsList.get(j) }); 
							Gson gson = new Gson();
							System.out.println(gson.toJson(diversionData.get(rowCount)));
						}
						/*if (split[0].trim().equals(getNGSplit[0].trim())) {//** change .get to [0]
						for (int j = 1; j < split.length; j++) {
							if (!split[j].trim().equalsIgnoreCase(getNGSplit[j].trim())) {//** change .get to [0]
								System.out.println("For Flight " + split[0] + "    " + lkaFieldNames.get(j)
								+ " are not Equal " + split[j] + " : " + getNGSplit[j]);//** change .get to [0]
							}

						}*/
					}
				}
			}
		/*	lkaFlights.removeAll(getNGFlights);
			System.out.println(lkaFlights);
			for(String value:lkaFlights) {
				row++;
				rowCount = Integer.toString(row);
				diversionData.put(rowCount,  new Object[] {"Missing flight in Azpe"+value});
			}*/
			//diversionData.put(rowCount,  new Object[] {lkaFlights});
			writingDataIntoExcel();
		}
	}
	public static void writingDataIntoExcel() throws Exception {
		Set<String> keyid = diversionData.keySet();
		int rowid = 0;
		for (String key : keyid) { 

			row = spreadsheet.createRow(++rowid); 
			Object[] objectArr = diversionData.get(key); 
			int cellid = 0; 
			for (Object obj : objectArr) { 
				Cell cell = row.createCell(++cellid); 
				cell.setCellValue((String)obj); 
			} 
		} 
		FileOutputStream out = new FileOutputStream( 
				new File("DiversionComparisonResults.xlsx")); 
		workbook.write(out);
		out.close();
	}
	public static void getDriverDetails(StringBuilder stringBuilder, int i, int xpathCount) {
		stringBuilder.append(getDriver().findElement(
				By.xpath("//tr[@class='dt-diversion-row dt-diversion-active'][" + i + "]/td[" + (xpathCount) + "]"))
				.getAttribute("textContent").trim()).append((xpathCount <40 ? "~" : ""));
	}
}
