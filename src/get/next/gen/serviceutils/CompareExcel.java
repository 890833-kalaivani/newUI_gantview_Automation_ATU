package get.next.gen.serviceutils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class CompareExcel extends correction{

	public  Map<Integer, Integer> errorMap = new HashMap<Integer, Integer>();

	public  void abc(String filex) throws IOException {

		try {

		//	FileInputStream file = new FileInputStream(new File("D:\\json check\\jsontocsv1\\jsontocsv\\Flightgiventime.xlsx"));
			FileInputStream file = new FileInputStream(new File(filex));
			

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
			int rowprint = 0;
			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				if (errorMap.containsKey(row.getRowNum())) {
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
					
						Cell cell = cellIterator.next();
						//System.out.println(row.getRowNum());
						
						if (cell.getColumnIndex() == errorMap.get(row.getRowNum())) {
							cell.setCellStyle(style);
						}
					}
					rowprint++;
					
				}

			}
			//System.out.println("The Number of flight details highlighted as mismatch are  " +rowprint);
			file.close();
		//	FileOutputStream out = new FileOutputStream(new File("D:\\json check\\jsontocsv1\\jsontocsv\\Flightgiventime.xlsx"));
			FileOutputStream out = new FileOutputStream(new File(filex));
			
			workbook.write(out);
			out.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public  void comparingTwoExcel(String X, String Y) {

		try {
			// get input excel files
		//	FileInputStream excellFile1 = new FileInputStream(new File("D:\\json check\\jsontocsv1\\jsontocsv\\Flightgiventime.xlsx"));
		//	FileInputStream excellFile2 = new FileInputStream(new File("D:\\json check\\jsontocsv1\\jsontocsv\\Flightgiventimecache.xlsx"));
			
			
				FileInputStream excellFile1 = new FileInputStream(new File(X));
				FileInputStream excellFile2 = new FileInputStream(new File(Y));
			
			
			// Create Workbook instance holding reference to .xlsx file
			XSSFWorkbook workbook1 = new XSSFWorkbook(excellFile1);
			XSSFWorkbook workbook2 = new XSSFWorkbook(excellFile2);

			// Get first/desired sheet from the workbook
			XSSFSheet sheet1 = workbook1.getSheetAt(0);
			XSSFSheet sheet2 = workbook2.getSheetAt(0);

			// Compare sheets
			if (compareTwoSheets(sheet1, sheet2)) {
				System.out.println("\n\nThe two excel sheets are Equal");
			} else {
				System.out.println("\n\nThe two excel sheets are Not Equal");
			}

			abc(X);

			// close files
			excellFile1.close();
			excellFile2.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// Compare Two Sheets
	public  boolean compareTwoSheets(XSSFSheet sheet1, XSSFSheet sheet2) {
		int firstRow1 = sheet1.getFirstRowNum();
		int lastRow1 = sheet2.getLastRowNum();
		int lastRow2 = sheet1.getLastRowNum();
		System.out.println("No of flight details retrieved in flightforgiventime sheet are   " +lastRow2);
		System.out.println("No of flight details retrieved from cache sheet are  " +lastRow1);
		boolean equalSheets = true;
		int mismatchcount = 0;
		int NotFoundcount=0;
		for (int i = firstRow1; i <= lastRow1; i++) {
			int m=1;
			
			for (int j = firstRow1; j <= lastRow1; j++)
			{
			//System.out.println("\n\nComparing Row " + i);

			XSSFRow row1 = sheet1.getRow(i);
			XSSFRow row2 = sheet2.getRow(j);
			try{
			double rowflightvalue = row1.getCell(0).getNumericCellValue();
			double rowflightcachevalue = row2.getCell(0).getNumericCellValue();
			
			if(rowflightvalue!=1 && rowflightcachevalue!=1)
			{
				
			if (rowflightvalue==rowflightcachevalue)
			{
			
			if (!compareTwoRows(row1, row2, i)) {
				equalSheets = false;
			//	System.out.println("Row " + i + " - Not Equal");
				
				mismatchcount++;
				
			} else {
				//System.out.println("Row " + i + " - Equal");
			}
		}
			else
			{
			
				m++;
				if(j==lastRow1)
				{
					NotFoundcount++;
				System.out.println("Not able to find flight number in Excel :: " + rowflightvalue);
				//do nothing
				}
				
			}
			
			
		}
			}catch(Exception Unwanted)
			{
				//donothing
			
			}
		}
			
		}
		System.out.println("Number of flight numbers Not Found in Cache sheets are ::  " +NotFoundcount);
		System.out.println("Mistmatch count between "+sheet1.getSheetName()+ " &  "+ sheet2.getSheetName()+" is :: " +mismatchcount);
		
		return equalSheets;
	}

	// Compare Two Rows
	public  boolean compareTwoRows(XSSFRow row1, XSSFRow row2, int rowNumber) {
		if ((row1 == null) && (row2 == null)) {
			return true;
		} else if ((row1 == null) || (row2 == null)) {
			return false;
		}

		int firstCell1 = row1.getFirstCellNum();
		int lastCell1 = row1.getLastCellNum();
		boolean equalRows = true;

		// Compare all cells in a row
		for (int i = firstCell1; i <= lastCell1; i++) {
			XSSFCell cell1 = row1.getCell(i);
			XSSFCell cell2 = row2.getCell(i);
			if(cell1!=null){
			if (!compareTwoCells(cell1, cell2)) {
				equalRows = false;
			//	System.err.println("       Cell " + i +"Value:  "+ cell1+ "  "+" - NOt Equal");
			//	System.err.println("       Row " + rowNumber );
				System.out.println("       Cell " + cell1 + " - Not Equal");
				errorMap.put(rowNumber, i);
				break;
			} else {
				//System.out.println("       Cell " + i + " - Equal");
			}
			}
		}
		return equalRows;
	}

	// Compare Two Cells
	public  boolean compareTwoCells(XSSFCell cell1, XSSFCell cell2) {
		if ((cell1 == null) && (cell2 == null)) {
			return true;
		} else if ((cell1 == null) || (cell2 == null)) {
			return false;
		}

		boolean equalCells = false;
		int type1 = cell1.getCellType();
		int type2 = cell2.getCellType();
		if (type1 == type2) {
			if (cell1.getCellStyle().equals(cell2.getCellStyle())) {
				// Compare cells based on its type
				switch (cell1.getCellType()) {
				case HSSFCell.CELL_TYPE_FORMULA:
					if (cell1.getCellFormula().equals(cell2.getCellFormula())) {
						equalCells = true;
					}
					break;
				case HSSFCell.CELL_TYPE_NUMERIC:
					if (cell1.getNumericCellValue() == cell2.getNumericCellValue()) {
						equalCells = true;
					}
					break;
				case HSSFCell.CELL_TYPE_STRING:
					if (cell1.getStringCellValue().equals(cell2.getStringCellValue())) {
						equalCells = true;
					}
					break;
				case HSSFCell.CELL_TYPE_BLANK:
					if (cell2.getCellType() == HSSFCell.CELL_TYPE_BLANK) {
						equalCells = true;
					}
					break;
				case HSSFCell.CELL_TYPE_BOOLEAN:
					if (cell1.getBooleanCellValue() == cell2.getBooleanCellValue()) {
						equalCells = true;
					}
					break;
				case HSSFCell.CELL_TYPE_ERROR:
					if (cell1.getErrorCellValue() == cell2.getErrorCellValue()) {
						equalCells = true;
				
					}
					break;
				default:
					if (cell1.getStringCellValue().equals(cell2.getStringCellValue())) {
						equalCells = true;
					}
					break;
				}
			} else {
				return false;
			
			}
		} else {
			return false;
		}
		return equalCells;
	}
	
}