package com.uiFramework.KisanForum.KisanNetWeb.helper.excel;

import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class LearnExcel {
	public void getExcelData() throws IOException {
		String sheetName = "Login";
		String currentDir = System.getProperty("user.dir");
		System.out.println(currentDir);
		String filePath = currentDir + "\\src\\main\\resources\\configfile\\ECommerce.xlsx";
		System.out.println(filePath);
		
		FileInputStream fis = new FileInputStream(filePath);
		HSSFWorkbook workbook;
		HSSFSheet sheet;
		HSSFRow row;
		HSSFCell cell;
		
		workbook = new HSSFWorkbook(fis);
		int index = workbook.getSheetIndex(sheetName);
		//System.out.println("sheet index is :" +index);
		
		sheet = workbook.getSheetAt(index);
		
		int totalRows = sheet.getLastRowNum();
		System.out.println("Total Rows are :" +totalRows);
		
		row = sheet.getRow(0);
		int totalColumn = row.getLastCellNum();
		System.out.println("Total Columns are " + totalColumn);
		
		Object dataSets[][] = new String[totalRows+1][totalColumn];
		
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
		
		//System.out.println(dataSets);
		//cell = row.getCell(0);
		//System.out.println(cell.getStringCellValue());
		
		
		
	}

}
