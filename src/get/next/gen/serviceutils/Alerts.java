package get.next.gen.serviceutils;

import get.next.gen.commonaction.CommonTest;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Listeners;

import atu.testng.reports.listeners.ATUReportsListener;
import atu.testng.reports.listeners.ConfigurationListener;
import atu.testng.reports.listeners.MethodListener;
@Listeners({ ATUReportsListener.class, ConfigurationListener.class,
MethodListener.class })

public class Alerts extends CommonTest {
	// public static void main(String myHelpers[]) throws Exception{

	public static void startcode(String url, String request, String urls) throws Exception {
		String url1 = url;
		String url3 = urls;
		String request12 = request;

		GETNGReponse(url1, request12, urls);
		PullAttributetoExcelSheet();

	}

	public static void PullAttributetoExcelSheet() throws Exception {

		DataPuller("json1.txt", "Cabin", "EventAlert_Catering.xlsx");
		DataPuller("json1.txt", "Catering", "EventAlert_Cabin.xlsx");
		DataPuller("json1.txt", "Fueling", "EventAlert_Fueling.xlsx");
		//DataPuller("json1.txt", "LAVS", "EventAlerts_Lavs.xlsx");
		//DataPuller("json1.txt", "Water", "EventAlerts_Water.xlsx");

		//DataPuller("json1.txt", "Offload", "EventAlerts_Offload.xlsx");
		//DataPuller("json1.txt", "Claimscan", "EventAlerts_Claimscan.xlsx");
		//DataPuller("json1.txt", "Crew", "EventAlerts_Crew.xlsx");
		//DataPuller("json1.txt", "Bags", "EventAlerts_Bags.xlsx");
		//DataPuller("json1.txt", "Pax", "EventAlerts_Pax.xlsx");
	}

	public static void DataPuller(String path, String SheetName, String ExcelName) throws Exception {

		Date date = new Date();
		TimeZone.setDefault(TimeZone.getTimeZone("GMT"));
		Calendar cal = Calendar.getInstance(TimeZone.getDefault());
		date = cal.getTime();
		String timee = date.toGMTString();
		long timeeunixx = cal.getTimeInMillis();

		long mil = System.currentTimeMillis();
		String st, full, append, le, extend, extended;
		full = "";
		extended = "";
		BufferedReader br = new BufferedReader(new FileReader(path));
		while ((st = br.readLine()) != null) {
			full += st;
		}



		if (SheetName.contains("Cabin")) {
			JSONArray jsonObj1 = new JSONArray(full);
			System.out.println(full);
			FileInputStream inputStream = new FileInputStream(new File(ExcelName));

			XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
			XSSFSheet sheet = workbook.getSheetAt(0);
			for (int ii = 0; ii < jsonObj1.length(); ii++)

			{
				int rowCountt = ii;
				rowCountt++;
				JSONObject Testprint11 = jsonObj1.getJSONObject(ii);
				try {
					String fltNum = Testprint11.getJSONObject("flight").getString("fltNum");
					
					
					System.out.print("");
					try {

						int fltNum1 = Integer.parseInt(fltNum);
						
						System.out.println(fltNum);
					
						String getDepStatus = Testprint11.getJSONObject("flight").getString("getDepStatus");
						String depSta = Testprint11.getJSONObject("flight").getString("depSta");
						String assignedEquipType = Testprint11.getJSONObject("flight").getString("assignedEquipType");
						long flightdeparturetime = Testprint11.getJSONObject("flight")
								.getLong("expectedTimeDepartureGMT");
						//String assignedEquipType = Testprint11.getJSONObject("flight").getString("assignedEquipType");
						 
						//System.out.println(flightdeparturetime);
						long currentGMTtime = cal.getTimeInMillis();
						//System.out.println(currentGMTtime);
						// String BagsDeparturetime1 =
						// Testprint11.getJSONObject("flight").getString("expectedTimeDepartureGMT");
						long BagsDeparturetime = Testprint11.getJSONObject("flight")
								.getLong("expectedTimeDepartureGMT");
						long date3 = (BagsDeparturetime - currentGMTtime) / (60 * 1000);
						long Deviationidentified = (BagsDeparturetime - currentGMTtime) / (1000 * 60 * 60);
					
					
						try {

							String CateringeventAlertStatus = Testprint11.getJSONObject("addlFlightData")
									.getJSONObject("eventList").getJSONObject("cabin").getString("eventAlertStatus");
							
							
								String CateringIsAlert = Testprint11.getJSONObject("addlFlightData")
									.getJSONObject("eventList").getJSONObject("cabin").getString("isAlert");
							
						
							String CateringeventStatus = Testprint11.getJSONObject("addlFlightData")
									.getJSONObject("eventList").getJSONObject("cabin").getString("eventStatus");
							
							if(date3<1){
								System.out.println("Past flight "+fltNum);
							}
							
							
							
							else{
								
								if ((date3 <= 30 && date3 >= 20)){
									
									if(CateringeventStatus.contains("NOT STARTED")){
										System.out.println(CateringeventAlertStatus + " " + CateringeventStatus + "  " + " "
												+ date3 + " Failed " + fltNum+"  cabin");
										if(CateringeventAlertStatus.contains("DELAYED")){
											
										}else{
											System.out.println(CateringeventAlertStatus + " " + CateringeventStatus + "  " + " "
													+ date3 + " Failed " + fltNum+"  cabin");
										}
									}
										
									
								}
								
									if ((date3 <= 20 && date3 >= 10)){
										if(CateringeventStatus.contains("STARTED")||CateringeventStatus.contains("NOT STARTED")){
											System.out.println(CateringeventAlertStatus + " " + CateringeventStatus + "  " + " "
													+ date3 + " Failed " + fltNum+"  cabin");
											if(CateringeventAlertStatus.contains("SLOW")){
												
											}else{
												System.out.println(CateringeventAlertStatus + " " + CateringeventStatus + "  " + " "
														+ date3 + " Failed " + fltNum+"  cabin");
											}
										}
											
									
								}
									
									if ((date3 <= 15 && date3 >= 1)){
										if(CateringeventStatus.contains("STARTED")||CateringeventStatus.contains("NOT STARTED")||CateringeventStatus.contains("SLOW")){
											System.out.println(CateringeventAlertStatus + " " + CateringeventStatus + "  " + " "
													+ date3 + " Failed " + fltNum+"  cabin");
											if(CateringeventAlertStatus.contains("DELAYED")){
												
											}else{
												System.out.println(CateringeventAlertStatus + " " + CateringeventStatus + "  " + " "
														+ date3 + " Failed " + fltNum+"  cabin");
											}
										}
											
										
									}	
								
								
								
			}

						} catch (Exception err) {

							Object[][] Flightdetails = {

							{ "No catering related data", "No catering related data", "No catering related data",
									"No catering related data", fltNum, "NA ",

							}

							// {fltNum1,BagseventStatus,BagsAlertStatus,BagsexpectedAverage,BagsIsAlert,BagsDeparturetime1,Deviationidentified,assignedEquipType,depSta},
							// {depSta,assignedEquipType,"CABIN",CabineventAlertStatus,CabineventStatus,CabinIsAlert,date3,"CREW",CrewAlertStatus,CrewAlertStatus,CrewAlertStatus,CrewIsAlert,date3,"CATERING",CateringeventAlertStatus,CateringeventStatus,CateringIsAlert,date3,"FUELING",fuelingAlertStatus,fuelingeventStatus,fuelingIsAlert,date3,"WATER",waterAlertStatus,watereventStatus,waterIsAlert,date3,"LAVS",lavsAlertStatus,lavseventStatus,lavsIsAlert,date3,getDepStatus,date3,fltNum1

							// }

							};
							for (Object[] Flight : Flightdetails) {
								Row row = sheet.getRow(rowCountt);
								int columnCount = 0;

								for (Object field : Flight) {
									Cell cell = row.getCell(columnCount);
									++columnCount;
									if (field instanceof String) {
										cell.setCellValue((String) field);
									} else if (field instanceof Integer) {
										cell.setCellValue((Integer) field);
									}
								}

							}

						}
					}

					catch (Exception noflights) {
						Object[][] Flightdetails = {

						{ "FlightNumberNotPresent", "FlightNumberNotPresent", "FlightNumberNotPresent",
								"FlightNumberNotPresent", "FlightNumberNotPresent", "NA ",

						}

						// {fltNum1,BagseventStatus,BagsAlertStatus,BagsexpectedAverage,BagsIsAlert,BagsDeparturetime1,Deviationidentified,assignedEquipType,depSta},
						// {depSta,assignedEquipType,"CABIN",CabineventAlertStatus,CabineventStatus,CabinIsAlert,date3,"CREW",CrewAlertStatus,CrewAlertStatus,CrewAlertStatus,CrewIsAlert,date3,"CATERING",CateringeventAlertStatus,CateringeventStatus,CateringIsAlert,date3,"FUELING",fuelingAlertStatus,fuelingeventStatus,fuelingIsAlert,date3,"WATER",waterAlertStatus,watereventStatus,waterIsAlert,date3,"LAVS",lavsAlertStatus,lavseventStatus,lavsIsAlert,date3,getDepStatus,date3,fltNum1

						// }

						};
						for (Object[] Flight : Flightdetails) {
							Row row = sheet.getRow(rowCountt);
							int columnCount = 0;

							for (Object field : Flight) {
								Cell cell = row.getCell(columnCount);
								++columnCount;
								if (field instanceof String) {
									cell.setCellValue((String) field);
								} else if (field instanceof Integer) {
									cell.setCellValue((Integer) field);
								}
							}

						}

					}
				} catch (Exception EEE) {
					Object[][] Flightdetails = { { "FlightNumberNotPresent", "FlightNumberNotPresent",
							"FlightNumberNotPresent", "FlightNumberNotPresent", "FlightNumberNotPresent", "NA ",

					}

					};
					for (Object[] Flight : Flightdetails) {
						Row row = sheet.getRow(rowCountt);
						int columnCount = 0;

						for (Object field : Flight) {
							Cell cell = row.getCell(columnCount);
							++columnCount;
							if (field instanceof String) {
								cell.setCellValue((String) field);
							} else if (field instanceof Integer) {
								cell.setCellValue((Integer) field);
							}
						}
					}
				}

			}

			try (FileOutputStream outputStream = new FileOutputStream(ExcelName)) {
				workbook.write(outputStream);
			}

		}

		if (SheetName.contains("Catering")) {
			JSONArray jsonObj1 = new JSONArray(full);
			FileInputStream inputStream = new FileInputStream(new File(ExcelName));

			XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
			XSSFSheet sheet = workbook.getSheetAt(0);
			for (int ii = 0; ii < jsonObj1.length(); ii++)

			{
				int rowCountt = ii;
				rowCountt++;
				JSONObject Testprint11 = jsonObj1.getJSONObject(ii);
				try {
					String fltNum = Testprint11.getJSONObject("flight").getString("fltNum");
					
					
					System.out.print("");
					try {

						int fltNum1 = Integer.parseInt(fltNum);
						
						System.out.println(fltNum);
					
						String getDepStatus = Testprint11.getJSONObject("flight").getString("getDepStatus");
						String depSta = Testprint11.getJSONObject("flight").getString("depSta");
						String assignedEquipType = Testprint11.getJSONObject("flight").getString("assignedEquipType");
						long flightdeparturetime = Testprint11.getJSONObject("flight")
								.getLong("expectedTimeDepartureGMT");
					//	System.out.println(flightdeparturetime);
						long currentGMTtime = cal.getTimeInMillis();
						//System.out.println(currentGMTtime);
						// String BagsDeparturetime1 =
						// Testprint11.getJSONObject("flight").getString("expectedTimeDepartureGMT");
						long BagsDeparturetime = Testprint11.getJSONObject("flight")
								.getLong("expectedTimeDepartureGMT");
						long date3 = (BagsDeparturetime - currentGMTtime) / (60 * 1000);
						long Deviationidentified = (BagsDeparturetime - currentGMTtime) / (1000 * 60 * 60);

						try {

							String CateringeventAlertStatus = Testprint11.getJSONObject("addlFlightData")
									.getJSONObject("eventList").getJSONObject("catering").getString("eventAlertStatus");
							
								String CateringIsAlert = Testprint11.getJSONObject("addlFlightData")
									.getJSONObject("eventList").getJSONObject("catering").getString("isAlert");
							
						
							String CateringeventStatus = Testprint11.getJSONObject("addlFlightData")
									.getJSONObject("eventList").getJSONObject("catering").getString("eventStatus");
							
							if(date3<1){
								System.out.println("Past flight "+fltNum);
							}
							else{
									if ((date3 <= 30 && date3 >= 20)){
									
									if(CateringeventStatus.contains("NOT STARTED")){
										System.out.println(CateringeventAlertStatus + " " + CateringeventStatus + "  " + " "
												+ date3 + " Failed " + fltNum+"  Catering");
										if(CateringeventAlertStatus.contains("DELAYED")){
											
										}else{
											System.out.println(CateringeventAlertStatus + " " + CateringeventStatus + "  " + " "
													+ date3 + " Failed " + fltNum+"  Catering");
										}
									}
										
									
								}
								
									if ((date3 <= 17 && date3 >= 10)){
										if(CateringeventStatus.contains("STARTED")||CateringeventStatus.contains("NOT STARTED")){
											System.out.println(CateringeventAlertStatus + " " + CateringeventStatus + "  " + " "
													+ date3 + " Failed " + fltNum+"  Catering");
											if(CateringeventAlertStatus.contains("SLOW")){
												
											}else{
												System.out.println(CateringeventAlertStatus + " " + CateringeventStatus + "  " + " "
														+ date3 + " Failed " + fltNum+"  Catering");
											}
										}
											
									
								}
									
									if ((date3 <= 10 && date3 >= 1)){
										if(CateringeventStatus.contains("STARTED")||CateringeventStatus.contains("NOT STARTED")){
											System.out.println(CateringeventAlertStatus + " " + CateringeventStatus + "  " + " "
													+ date3 + " Failed " + fltNum+"  Catering");
											if(CateringeventAlertStatus.contains("DELAYED")){
												
											}else{
												System.out.println(CateringeventAlertStatus + " " + CateringeventStatus + "  " + " "
														+ date3 + " Failed " + fltNum+"  Catering");
											}
										}
											
										
									}	
							}

						} catch (Exception err) {

							Object[][] Flightdetails = {

							{ "No catering related data", "No catering related data", "No catering related data",
									"No catering related data", fltNum, "NA ",

							}

							// {fltNum1,BagseventStatus,BagsAlertStatus,BagsexpectedAverage,BagsIsAlert,BagsDeparturetime1,Deviationidentified,assignedEquipType,depSta},
							// {depSta,assignedEquipType,"CABIN",CabineventAlertStatus,CabineventStatus,CabinIsAlert,date3,"CREW",CrewAlertStatus,CrewAlertStatus,CrewAlertStatus,CrewIsAlert,date3,"CATERING",CateringeventAlertStatus,CateringeventStatus,CateringIsAlert,date3,"FUELING",fuelingAlertStatus,fuelingeventStatus,fuelingIsAlert,date3,"WATER",waterAlertStatus,watereventStatus,waterIsAlert,date3,"LAVS",lavsAlertStatus,lavseventStatus,lavsIsAlert,date3,getDepStatus,date3,fltNum1

							// }

							};
							for (Object[] Flight : Flightdetails) {
								Row row = sheet.getRow(rowCountt);
								int columnCount = 0;

								for (Object field : Flight) {
									Cell cell = row.getCell(columnCount);
									++columnCount;
									if (field instanceof String) {
										cell.setCellValue((String) field);
									} else if (field instanceof Integer) {
										cell.setCellValue((Integer) field);
									}
								}

							}

						}
					}

					catch (Exception noflights) {
						Object[][] Flightdetails = {

						{ "FlightNumberNotPresent", "FlightNumberNotPresent", "FlightNumberNotPresent",
								"FlightNumberNotPresent", "FlightNumberNotPresent", "NA ",

						}

						// {fltNum1,BagseventStatus,BagsAlertStatus,BagsexpectedAverage,BagsIsAlert,BagsDeparturetime1,Deviationidentified,assignedEquipType,depSta},
						// {depSta,assignedEquipType,"CABIN",CabineventAlertStatus,CabineventStatus,CabinIsAlert,date3,"CREW",CrewAlertStatus,CrewAlertStatus,CrewAlertStatus,CrewIsAlert,date3,"CATERING",CateringeventAlertStatus,CateringeventStatus,CateringIsAlert,date3,"FUELING",fuelingAlertStatus,fuelingeventStatus,fuelingIsAlert,date3,"WATER",waterAlertStatus,watereventStatus,waterIsAlert,date3,"LAVS",lavsAlertStatus,lavseventStatus,lavsIsAlert,date3,getDepStatus,date3,fltNum1

						// }

						};
						for (Object[] Flight : Flightdetails) {
							Row row = sheet.getRow(rowCountt);
							int columnCount = 0;

							for (Object field : Flight) {
								Cell cell = row.getCell(columnCount);
								++columnCount;
								if (field instanceof String) {
									cell.setCellValue((String) field);
								} else if (field instanceof Integer) {
									cell.setCellValue((Integer) field);
								}
							}

						}

					}
				} catch (Exception EEE) {
					Object[][] Flightdetails = { { "FlightNumberNotPresent", "FlightNumberNotPresent",
							"FlightNumberNotPresent", "FlightNumberNotPresent", "FlightNumberNotPresent", "NA ",

					}

					};
					for (Object[] Flight : Flightdetails) {
						Row row = sheet.getRow(rowCountt);
						int columnCount = 0;

						for (Object field : Flight) {
							Cell cell = row.getCell(columnCount);
							++columnCount;
							if (field instanceof String) {
								cell.setCellValue((String) field);
							} else if (field instanceof Integer) {
								cell.setCellValue((Integer) field);
							}
						}
					}
				}

			}

			try (FileOutputStream outputStream = new FileOutputStream(ExcelName)) {
				workbook.write(outputStream);
			}

		}

	

		if (SheetName.contains("Fueling")) {
			JSONArray jsonObj1 = new JSONArray(full);
			FileInputStream inputStream = new FileInputStream(new File(ExcelName));

			XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
			XSSFSheet sheet = workbook.getSheetAt(0);
			for (int ii = 0; ii < jsonObj1.length(); ii++)

			{
				int rowCountt = ii;
				rowCountt++;
				JSONObject Testprint11 = jsonObj1.getJSONObject(ii);
				try {
					String fltNum = Testprint11.getJSONObject("flight").getString("fltNum");
					
					
					System.out.print("");
					try {

						int fltNum1 = Integer.parseInt(fltNum);
						
						System.out.println(fltNum);
					
						String getDepStatus = Testprint11.getJSONObject("flight").getString("getDepStatus");
						String depSta = Testprint11.getJSONObject("flight").getString("depSta");
						String assignedEquipType = Testprint11.getJSONObject("flight").getString("assignedEquipType");
						long flightdeparturetime = Testprint11.getJSONObject("flight")
								.getLong("expectedTimeDepartureGMT");
						//System.out.println(flightdeparturetime);
						long currentGMTtime = cal.getTimeInMillis();
						//System.out.println(currentGMTtime);
						// String BagsDeparturetime1 =
						// Testprint11.getJSONObject("flight").getString("expectedTimeDepartureGMT");
						long BagsDeparturetime = Testprint11.getJSONObject("flight")
								.getLong("expectedTimeDepartureGMT");
						long date3 = (BagsDeparturetime - currentGMTtime) / (60 * 1000);
						long Deviationidentified = (BagsDeparturetime - currentGMTtime) / (1000 * 60 * 60);

						try {

							String CateringeventAlertStatus = Testprint11.getJSONObject("addlFlightData")
									.getJSONObject("eventList").getJSONObject("fueling").getString("eventAlertStatus");
							
								String CateringIsAlert = Testprint11.getJSONObject("addlFlightData")
									.getJSONObject("eventList").getJSONObject("fueling").getString("isAlert");
							
						
							String CateringeventStatus = Testprint11.getJSONObject("addlFlightData")
									.getJSONObject("eventList").getJSONObject("fueling").getString("eventStatus");
							
							if(date3<1){
								System.out.println("Past flight "+fltNum);
							}
							else{
								
									if ((date3 <= 30 && date3 >= 20)){
									
									if(CateringeventStatus.contains("NOT STARTED")){
										System.out.println(CateringeventAlertStatus + " " + CateringeventStatus + "  " + " "
												+ date3 + " Failed " + fltNum+"  Fueling");
										if(CateringeventAlertStatus.contains("DELAYED")){
											
										}else{
											System.out.println(CateringeventAlertStatus + " " + CateringeventStatus + "  " + " "
													+ date3 + " Failed " + fltNum+"  Fueling");
										}
									}
										
									
								}
								
									if ((date3 <= 20 && date3 >= 10)){
										if(CateringeventStatus.contains("STARTED")||CateringeventStatus.contains("NOT STARTED")){
											System.out.println(CateringeventAlertStatus + " " + CateringeventStatus + "  " + " "
													+ date3 + " Failed " + fltNum+"  Fueling");
											if(CateringeventAlertStatus.contains("SLOW")){
												
											}else{
												System.out.println(CateringeventAlertStatus + " " + CateringeventStatus + "  " + " "
														+ date3 + " Failed " + fltNum+"  Fueling");
											}
										}
											
									
								}
									
									if ((date3 <= 15 && date3 >= 1)){
										if(CateringeventStatus.contains("STARTED")||CateringeventStatus.contains("NOT STARTED")){
											System.out.println(CateringeventAlertStatus + " " + CateringeventStatus + "  " + " "
													+ date3 + " Failed " + fltNum+"  Fueling");
											if(CateringeventAlertStatus.contains("DELAYED")){
												
											}else{
												System.out.println(CateringeventAlertStatus + " " + CateringeventStatus + "  " + " "
														+ date3 + " Failed " + fltNum+"  Fueling");
											}
										}
											
										
									}	
									
							}

						} catch (Exception err) {

							Object[][] Flightdetails = {

							{ "No catering related data", "No catering related data", "No catering related data",
									"No catering related data", fltNum, "NA ",

							}

							// {fltNum1,BagseventStatus,BagsAlertStatus,BagsexpectedAverage,BagsIsAlert,BagsDeparturetime1,Deviationidentified,assignedEquipType,depSta},
							// {depSta,assignedEquipType,"CABIN",CabineventAlertStatus,CabineventStatus,CabinIsAlert,date3,"CREW",CrewAlertStatus,CrewAlertStatus,CrewAlertStatus,CrewIsAlert,date3,"CATERING",CateringeventAlertStatus,CateringeventStatus,CateringIsAlert,date3,"FUELING",fuelingAlertStatus,fuelingeventStatus,fuelingIsAlert,date3,"WATER",waterAlertStatus,watereventStatus,waterIsAlert,date3,"LAVS",lavsAlertStatus,lavseventStatus,lavsIsAlert,date3,getDepStatus,date3,fltNum1

							// }

							};
							for (Object[] Flight : Flightdetails) {
								Row row = sheet.getRow(rowCountt);
								int columnCount = 0;

								for (Object field : Flight) {
									Cell cell = row.getCell(columnCount);
									++columnCount;
									if (field instanceof String) {
										cell.setCellValue((String) field);
									} else if (field instanceof Integer) {
										cell.setCellValue((Integer) field);
									}
								}

							}

						}
					}

					catch (Exception noflights) {
						Object[][] Flightdetails = {

						{ "FlightNumberNotPresent", "FlightNumberNotPresent", "FlightNumberNotPresent",
								"FlightNumberNotPresent", "FlightNumberNotPresent", "NA ",

						}

						// {fltNum1,BagseventStatus,BagsAlertStatus,BagsexpectedAverage,BagsIsAlert,BagsDeparturetime1,Deviationidentified,assignedEquipType,depSta},
						// {depSta,assignedEquipType,"CABIN",CabineventAlertStatus,CabineventStatus,CabinIsAlert,date3,"CREW",CrewAlertStatus,CrewAlertStatus,CrewAlertStatus,CrewIsAlert,date3,"CATERING",CateringeventAlertStatus,CateringeventStatus,CateringIsAlert,date3,"FUELING",fuelingAlertStatus,fuelingeventStatus,fuelingIsAlert,date3,"WATER",waterAlertStatus,watereventStatus,waterIsAlert,date3,"LAVS",lavsAlertStatus,lavseventStatus,lavsIsAlert,date3,getDepStatus,date3,fltNum1

						// }

						};
						for (Object[] Flight : Flightdetails) {
							Row row = sheet.getRow(rowCountt);
							int columnCount = 0;

							for (Object field : Flight) {
								Cell cell = row.getCell(columnCount);
								++columnCount;
								if (field instanceof String) {
									cell.setCellValue((String) field);
								} else if (field instanceof Integer) {
									cell.setCellValue((Integer) field);
								}
							}

						}

					}
				} catch (Exception EEE) {
					Object[][] Flightdetails = { { "FlightNumberNotPresent", "FlightNumberNotPresent",
							"FlightNumberNotPresent", "FlightNumberNotPresent", "FlightNumberNotPresent", "NA ",

					}

					};
					for (Object[] Flight : Flightdetails) {
						Row row = sheet.getRow(rowCountt);
						int columnCount = 0;

						for (Object field : Flight) {
							Cell cell = row.getCell(columnCount);
							++columnCount;
							if (field instanceof String) {
								cell.setCellValue((String) field);
							} else if (field instanceof Integer) {
								cell.setCellValue((Integer) field);
							}
						}
					}
				}

			}

			try (FileOutputStream outputStream = new FileOutputStream(ExcelName)) {
				workbook.write(outputStream);
			}

		}

		if (SheetName.contains("LAVS")) {}

		if (SheetName.contains("Water")) {}

	}

	// ***************************************************************************

	public static void GETNGReponse(String strurl, String request1, String strurl2) throws Exception {

		// &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&

		// Fetch data from GETNextGen and get the NextGen Flight count
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date = new java.util.Date();
		String dateWithoutTime = dateFormat.format(date); // "02 May 2016";
		String jsonString1 = request1;
		POST_JSON_GETNG(strurl, jsonString1, "json1.txt");

	}

	public static String POST_JSON_GETNG(String URL, String jsonString, String path) throws Exception {
		System.out.println("Sending POST Request with value " + jsonString + " to URL:" + URL);

		long startTime = Calendar.getInstance().getTimeInMillis();

		URL url = new URL(URL);
		String json = new String(jsonString);
		// System.out.println("jsonString:" + json);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setConnectTimeout(5000);
		conn.setRequestProperty("Accept", "application/json");
		conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
		conn.setDoOutput(true);
		conn.setDoInput(true);
		conn.setRequestMethod("POST");
		OutputStream os = (OutputStream) conn.getOutputStream();
		os.write(jsonString.getBytes("UTF-8"));
		os.close();
		// read the response
		InputStream in = new BufferedInputStream(conn.getInputStream());
		// String result = org.apache.commons.io.IOUtils.toString(in,"UTF-8");
		// // response is stored in result
		String result = org.apache.commons.io.IOUtils.toString(in, "UTF-8"); // response
																				// is
																				// stored
																				// in
																				// result
		// System.out.println("JSON Response:" + result);

		try (FileWriter file = new FileWriter(path)) {
			file.write(result);
			in.close();
			conn.disconnect();
		}
		long endTime = Calendar.getInstance().getTimeInMillis();
		long responsetime = startTime - endTime;
		System.out.println("The Total time taken for url  " + "   " + URL + "is" + responsetime + "   milliseconds");
		return result;
	}
}