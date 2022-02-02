package get.next.gen.serviceutils;

import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.ComparisonOperator;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFConditionalFormattingRule;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFFontFormatting;
import org.apache.poi.xssf.usermodel.XSSFPatternFormatting;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFSheetConditionalFormatting;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.omg.PortableInterceptor.ORBInitInfoPackage.DuplicateName;
public class ConditionalFormatting extends correction {  
	public static  Map<Integer, Integer> errorMap = new HashMap<Integer, Integer>();
        public static void conditionalformatter() throws Exception{
                /* Create Workbook and Worksheet - Add Input Rows */
               
        	FileInputStream excellFile1 = new FileInputStream(new File("FlightgiventimeFlightDetails.xlsx"));
			
		
		// Create Workbook instance holding reference to .xlsx file
		XSSFWorkbook my_workbook = new XSSFWorkbook(excellFile1);
        	
               
                XSSFSheet my_sheet = my_workbook.getSheetAt(0);      
                               /* Access conditional formatting facet layer */
                XSSFSheetConditionalFormatting my_cond_format_layer = my_sheet.getSheetConditionalFormatting();
               /* Create a Rule */
                XSSFConditionalFormattingRule my_rule = my_cond_format_layer.createConditionalFormattingRule("COUNTIF($A$2:$A$2000,A2)>1");
              // FontFormatting font = my_rule.createFontFormatting();
              //  font.setFontStyle(false, true);
              //  font.setFontColorIndex(IndexedColors.BLUE.index);
                /* Define font formatting if rule is met */
                /* Here we say, if the rule is met, set font color to Green */
                XSSFFontFormatting my_rule_pattern2 = my_rule.createFontFormatting();
                XSSFPatternFormatting 	my_rule_pattern = my_rule.createPatternFormatting();
             //   my_rule_pattern.setFontColorIndex(IndexedColors.GREEN.getIndex());
             //   my_rule_pattern.setFontStyle(false, true);
                my_rule_pattern.setFillBackgroundColor(IndexedColors.BLUE.index);
                /* Create a Cell Range Address */
                CellRangeAddress[] my_data_range = {CellRangeAddress.valueOf("A1:A2000")};
                 /* Attach rule to cell range */
                my_cond_format_layer.addConditionalFormatting(my_data_range,my_rule);
                /* Write changes to the workbook */
                FileOutputStream out = new FileOutputStream(new File("Result_Flightdetailscomparison.xlsx"));
                my_workbook.write(out);
                out.close();
                
                
                
                
        }
        
        public static void conditionalformatter2() throws Exception{
            /* Create Workbook and Worksheet - Add Input Rows */
           
    	FileInputStream excellFile1 = new FileInputStream(new File("FlightgiventimeEventDetails.xlsx"));
		
	
	// Create Workbook instance holding reference to .xlsx file
	XSSFWorkbook my_workbook = new XSSFWorkbook(excellFile1);
    	
           
            XSSFSheet my_sheet = my_workbook.getSheetAt(0);                

            
            /* Access conditional formatting facet layer */
            XSSFSheetConditionalFormatting my_cond_format_layer = my_sheet.getSheetConditionalFormatting();
            
            /* Create a Rule */
            XSSFConditionalFormattingRule my_rule = my_cond_format_layer.createConditionalFormattingRule("COUNTIF($A$2:$A$2000,A2)>1");
            
            
           // FontFormatting font = my_rule.createFontFormatting();
          //  font.setFontStyle(false, true);
          //  font.setFontColorIndex(IndexedColors.BLUE.index);
            /* Define font formatting if rule is met */
            /* Here we say, if the rule is met, set font color to Green */
            XSSFFontFormatting my_rule_pattern2 = my_rule.createFontFormatting();
            XSSFPatternFormatting 	my_rule_pattern = my_rule.createPatternFormatting();
            my_rule_pattern.setFillBackgroundColor(IndexedColors.BLUE.index);
          //  my_rule_pattern.setFontStyle(false, true);
            
            /* Create a Cell Range Address */
            CellRangeAddress[] my_data_range = {CellRangeAddress.valueOf("A1:A2000")};
            
            /* Attach rule to cell range */
            my_cond_format_layer.addConditionalFormatting(my_data_range,my_rule);
            
            /* Write changes to the workbook */
            FileOutputStream out = new FileOutputStream(new File("Result_Eventdetailscomparison.xlsx"));
            my_workbook.write(out);
            out.close();
            
    }
        
        
        //****************************************************
        
        
        public static void FinetuneResult(String resultpath) throws Exception{
            /* Create Workbook and Worksheet - Add Input Rows */
           
    	FileInputStream excellFile1 = new FileInputStream(new File(resultpath));
    	XSSFWorkbook workbook = new XSSFWorkbook(excellFile1);

		// Get first sheet from the workbook
		XSSFSheet sheet = workbook.getSheetAt(0);

		int firstRow1 = sheet.getFirstRowNum();
		int lastRow1 = sheet.getLastRowNum();
	
		for (int i = firstRow1; i <= lastRow1; i++) {
			
			System.out.println("\n\nComparing Row " + i);

			XSSFRow row1 = sheet.getRow(i);
			XSSFRow row2 = sheet.getRow(i+1);
			int Rownumber = row1.getRowNum();
			int cellnumber = row1.getFirstCellNum();
			try{
			String rowflightvalue = row1.getCell(0).getStringCellValue();
			String rowflightcachevalue = row2.getCell(0).getStringCellValue();
			
			if(rowflightvalue!="" && rowflightcachevalue!="")
			{
				
			if (rowflightvalue.contains(rowflightcachevalue))
			{
			
				errorMap.put(Rownumber,cellnumber);
				
		}
			else
			{
				//do nothing
			}
		
		}
			}
			catch(Exception Nothinghappens)
			{
				//
			}
		}
	
		//  FileOutputStream out = new FileOutputStream(new File("Fine.xlsx"));
		//  workbook.write(out);
      //    out.close();
		abcd("Result_Flightdetailscomparison.xlsx");
	
	
			
    	
        }
        
        
        
        
        
        
        
        
        
        
        
        


    	public static  void abcd(String filex) throws IOException {

    		try {

    		//	FileInputStream file = new FileInputStream(new File("D:\\json check\\jsontocsv1\\jsontocsv\\Flightgiventime.xlsx"));
    			FileInputStream file = new FileInputStream(new File("Result_Flightdetailscomparison.xlsx"));
    			

    			// Get the workbook instance for XLS file
    			XSSFWorkbook workbook = new XSSFWorkbook(file);

    			// Get first sheet from the workbook
    			XSSFSheet sheet = workbook.getSheetAt(0);

    			// Iterate through each rows from first sheet
    			Iterator<Row> rowIterator = sheet.iterator();

    			
                //Set Style
    			XSSFFont font = workbook.createFont();
    			font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
    			XSSFCellStyle style = workbook.createCellStyle();
    			XSSFColor red = new XSSFColor(new java.awt.Color(255, 0, 0));
    			font.setColor(IndexedColors.RED.getIndex());
    			 
    			style.setFont(font);

    			while (rowIterator.hasNext()) {
    				Row row = rowIterator.next();
    				if (errorMap.containsKey(row.getRowNum())) {
    					Iterator<Cell> cellIterator = row.cellIterator();
    					while (cellIterator.hasNext()) {
    						Cell cell = cellIterator.next();
    						System.out.println(row.getRowNum());
    						if (cell.getColumnIndex() == errorMap.get(row.getRowNum())) {
    							sheet.removeRow(row);
    						}
    					}
    				}

    			}

    			file.close();
    		//	FileOutputStream out = new FileOutputStream(new File("D:\\json check\\jsontocsv1\\jsontocsv\\Flightgiventime.xlsx"));
    			FileOutputStream out = new FileOutputStream(new File("Result_Flightdetailscomparison.xlsx"));
    			
    			workbook.write(out);
    			out.close();

    		} catch (FileNotFoundException e) {
    			e.printStackTrace();
    		} catch (IOException e) {
    			e.printStackTrace();
    		}
    	}

}