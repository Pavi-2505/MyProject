package com.crm.Vtiger.genericUtilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

	/**
	 * This method is used to read data from excel
	 * 
	 * @param sheetName
	 * @param rowNo
	 * @param cellNo
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String readDatafRomExcel(String sheetName, int rowNo, int cellNo)
			throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(IPathConstants.excelpath);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		// Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		Row row = sh.getRow(rowNo);
		Cell cell = row.getCell(cellNo);
		String data = cell.toString();
		return data;
	}

	/**
	 * this method is used to write data back to excel
	 * 
	 * @param Sheetname
	 * @param rowno
	 * @param cellNo
	 * @param data
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public void writeDataToExcel(String Sheetname, int rowno, int cellNo, String data)
			throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(IPathConstants.excelpath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(Sheetname);
		Row row = sh.createRow(rowno);
		Cell cell = row.createCell(cellNo);
		cell.setCellValue(data);
		FileOutputStream fout = new FileOutputStream(IPathConstants.excelpath);
		wb.write(fout);
		wb.close();
	}

	/**
	 * This method is used to get the row count in a Sheet
	 * @param Sheetname
	 * @param rowno
	 * @param cellNo
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public int getTheRowCount(String Sheetname) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(IPathConstants.excelpath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(Sheetname);
		int count = sh.getLastRowNum();
		return count;
	}  
}
/*
*//**
	 * This method is used to get the column count in a Sheet
	 * 
	 * @param Sheetname
	 * @param rowno
	 * @param cellNo
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
/*
 * public int getThecolumnCount(String Sheetname) throws
 * EncryptedDocumentException, IOException { FileInputStream fis = new
 * FileInputStream(IPathConstants.excelpath); Workbook wb =
 * WorkbookFactory.create(fis); Sheet sh = wb.getSheet(Sheetname); int rowCount
 * = sh.getLastRowNum(); rowCount. return count; } }
 */