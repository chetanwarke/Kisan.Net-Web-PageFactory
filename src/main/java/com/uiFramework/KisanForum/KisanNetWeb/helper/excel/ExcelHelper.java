package com.uiFramework.KisanForum.KisanNetWeb.helper.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.util.Iterator;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.uiFramework.KisanForum.KisanNetWeb.helper.logger.LoggerHelper;
import com.uiFramework.KisanForum.KisanNetWeb.helper.resource.ResourceHelper;

public class ExcelHelper {

	private Logger log = LoggerHelper.getLogger(ExcelHelper.class);

	public Object[][] getExcelData(String excelLocation, String sheetName) {

		try {
			Object dataSets[][] = null;
			FileInputStream file = new FileInputStream(new File(excelLocation));
			// Create Workbook instance
			XSSFWorkbook workbook = new XSSFWorkbook(file);

			// Get sheet Name from Workbook
			XSSFSheet sheet = workbook.getSheet(sheetName);

			// count number of active rows in excel sheet
			int totalRow = sheet.getLastRowNum();
            System.out.println(totalRow);
			// count active columns in row
			int totalColumn = sheet.getRow(0).getLastCellNum();

			dataSets = new Object[totalRow][totalColumn-1];

			// Iterate Through each Rows one by one.
			Iterator<Row> rowIterator = sheet.iterator();
			int i = 0;

			while (rowIterator.hasNext()) {
				i++;
				// for Every row , we need to iterator over columns
				Row row = rowIterator.next();
				
				Iterator<Cell> cellIterator = row.cellIterator();
				int x = 0;
				while (cellIterator.hasNext()) {
					
					Cell cell = cellIterator.next();
					//Enum cell = cellIterator.next();
					if (cell.getStringCellValue().contains("Start")) {
						i = 0;
						break;
					}
					switch (cell.getCellType()) {
					case Cell.CELL_TYPE_STRING:
						dataSets[i-1][x++] = cell.getStringCellValue();
						//System.out.println(dataSets[i-1][x++].toString());
						break;
					case Cell.CELL_TYPE_NUMERIC:
						double mobile = cell.getNumericCellValue();
						String mobileInStringFormat = BigDecimal.valueOf(mobile).toPlainString();
						dataSets[i-1][x++] = mobileInStringFormat;
						//dataSets[i-1][j++] = cell.getNumericCellValue();
						break;
					case Cell.CELL_TYPE_BOOLEAN:
						dataSets[i-1][x++] = cell.getBooleanCellValue();
					case Cell.CELL_TYPE_FORMULA:
						dataSets[i-1][x++] = cell.getCellFormula();
						break;

					default:
						System.out.println("no matching enum type found");
						break;
					}
				}
			}
			return dataSets;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public Object[][] getExcelData1(String excelLocation, String sheetName) throws Exception{
		
		FileInputStream fis;
		fis = new FileInputStream(new File(excelLocation));
		XSSFWorkbook workbook;
		XSSFSheet sheet;
		XSSFRow row;
		XSSFCell cell;
		
		workbook = new XSSFWorkbook(fis);
		int index = workbook.getSheetIndex(sheetName);
		//System.out.println("sheet index is :" +index);
		
		sheet = workbook.getSheetAt(index);
		
		int totalRows = sheet.getLastRowNum();
		System.out.println("Total Rows are :" +totalRows);
		
		row = sheet.getRow(0);
		int totalColumn = row.getLastCellNum();
		System.out.println("Total Columns are " + totalColumn);
		
		Object dataSets[][] = new String[totalRows][totalColumn];
		
		Iterator<Row> rowIterator =  sheet.rowIterator();
		int i = 0;
		while(rowIterator.hasNext()) {
			i++;
			Row rows = rowIterator.next();// assume it returns 0th row
            if(rows.getRowNum()==0) {
			rows = rowIterator.next();
            }
			Iterator<Cell> cellIterator = rows.cellIterator();
			int j = 0;
			System.out.println("");
			while(cellIterator.hasNext()) {
				j++;
				Cell cells = cellIterator.next();
				//System.out.print(cells.getCellTypeEnum() + " ");
				switch(cells.getCellType()) {
				case Cell.CELL_TYPE_STRING:
					dataSets[i-1][j-1] = cells.getStringCellValue();
					System.out.println(dataSets[i-1][j-1] + " ");
					break;
					
				case Cell.CELL_TYPE_NUMERIC:
					double mobile = cells.getNumericCellValue();
					String mobileInStringFormat = BigDecimal.valueOf(mobile).toPlainString();
					dataSets[i-1][j-1] = mobileInStringFormat;
					System.out.println(dataSets[i-1][j-1]);
					break;
					
				case Cell.CELL_TYPE_BOOLEAN:
					dataSets[i-1][j-1] = cells.getBooleanCellValue();
					break;
					
				case Cell.CELL_TYPE_FORMULA:
					dataSets[i-1][j-1] = cells.getCellFormula();
					break;
					
				default :
					System.out.println("no matching enum type found");
					break;	
				}
				
				
			}
		}
		return dataSets;
	}
	
	
	
	
	
	
	
	
	
	
	
	public void updateResult(String excelLocation, String sheetName, String testCaseName, String testStatus){
		try{
			FileInputStream file = new FileInputStream(new File(excelLocation));
			// Create Workbook instance
			XSSFWorkbook workbook = new XSSFWorkbook(file);

			// Get sheet Name from Workbook
			XSSFSheet sheet = workbook.getSheet(sheetName);
			// count number of active rows in excel sheet
			int totalRow = sheet.getLastRowNum()+1;
			for(int i =1; i<totalRow; i++){
				XSSFRow r = sheet.getRow(i);
				String ce = r.getCell(0).getStringCellValue();
				if(ce.contains(testCaseName)){
					r.createCell(1).setCellValue(testStatus);
					file.close();
					log.info("result updated..");
					FileOutputStream out = new FileOutputStream(new File(excelLocation));
					workbook.write(out);
					out.close();
					break;
				}
			}
		}
		catch(Exception e){
			
		}
	}
	
	public static void main(String[] args) {
	 ExcelHelper	 excelHelper = new ExcelHelper();
	 String excelLocation = ResourceHelper.getResourcePath("src/main/resources/configfile/testData.xlsx");
	 Object[][] data = excelHelper.getExcelData(excelLocation, "Login");
	 System.out.println(data);
//	 excelHelper.updateResult(excelLocation, "TestScripts", "Login", "PASS");
//	 excelHelper.updateResult(excelLocation, "TestScripts", "Registration", "FAIL");
//	 excelHelper.updateResult(excelLocation, "TestScripts", "Add to Cart", "PASS");
	 
	}
}
