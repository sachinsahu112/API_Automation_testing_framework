package com.api.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLUtility {
	String path;
	String sheetName;
	String data;

	public XLUtility(String path) {
		this.path = path;
	}

	public int getRowCount(String sheetName) throws IOException {
		FileInputStream fis = new FileInputStream(path);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sh = wb.getSheet(sheetName);
		int rowCount = sh.getLastRowNum();
		wb.close();
		fis.close();
		return rowCount;
	}

	public int getCellCount(String sheetName, int rowNum) throws IOException {
		FileInputStream fis = new FileInputStream(path);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sh = wb.getSheet(sheetName);
		XSSFRow row = sh.getRow(rowNum);
		int cellCount = row.getLastCellNum();
		wb.close();
		fis.close();
		return cellCount;
	}

	public String getCellData(String sheetName, int rowNum, int coloumnNum) throws IOException {
		FileInputStream fis = new FileInputStream(path);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sh = wb.getSheet(sheetName);
		XSSFRow row = sh.getRow(rowNum);
		XSSFCell cell = row.getCell(coloumnNum);
		DataFormatter dataformater = new DataFormatter();
		String data;
		try {
			data = dataformater.formatCellValue(cell);// return the formatted value of the cell regardless it was any
														// typr;
		} catch (Exception e) {
			data = "";
		}
		wb.close();
		fis.close();
		return data;
	}

	public void setCellData(String sheetName, int rowNum, int coloumNum) throws IOException, InvalidFormatException {
		File file = new File(path);
		if (!file.exists()) {
			XSSFWorkbook wb = new XSSFWorkbook(file);

			FileOutputStream fos = new FileOutputStream(file);
			wb.write(fos);
			FileInputStream fis = new FileInputStream(path);
			// XSSFWorkbook wb=new XSSFWorkbook(file);

			if (wb.getSheetIndex(sheetName) == -1) {
				wb.createSheet(sheetName);

				XSSFSheet sheet = wb.getSheet(sheetName);
				XSSFRow row = sheet.getRow(rowNum);
				if (sheet.getRow(rowNum) == null)
					sheet.createRow(rowNum);// create row if not present
				row = sheet.getRow(rowNum);
				XSSFCell cell;
				cell = row.createCell(coloumNum);
				cell.setCellValue(data);

				wb.write(fos);
				wb.close();
				fos.close();

			}

		}

	}
}
