package com.amazon.GenericLib;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileUtilities {
	
	/**
	 * It is used to read the data from property file
	 * @param key
	 * @return
	 * @throws IOException
	 */
	public String getPropertydata(String key) throws IOException
	{
		Properties p= new Properties();
		FileInputStream fis=new FileInputStream(AutoConstants.propertyFilePath);
		p.load(fis);
		return p.getProperty(key);
		
	}
	
	/**
	 * It is used to read the data from excel file
	 * @param Sheetname
	 * @param row
	 * @param cell
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String getExceldata(String Sheetname, int row, int cell) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis= new FileInputStream(AutoConstants.excelPath);
		Workbook wb = WorkbookFactory.create(fis);
		String s = wb.getSheet(Sheetname).getRow(row).getCell(cell).getStringCellValue();
		return s;
		
	}


}
