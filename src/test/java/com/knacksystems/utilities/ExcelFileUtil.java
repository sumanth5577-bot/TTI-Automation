package com.knacksystems.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelFileUtil 
{
	Workbook wb;
	//To load excel file we've to use constructor
	public ExcelFileUtil() throws FileNotFoundException, Throwable
	{
		FileInputStream fis=new FileInputStream("./TestInputs/"+PropertyFileUtil.getValueForKey("project_name")+"/"+PropertyFileUtil.getValueForKey("inputfile"));
		wb=WorkbookFactory.create(fis);
	}
	//To access sheet, We've to use rowCount, colCount and getData from Excel Sheet
	
	public int rowCount(String sheetname)
	{
		return wb.getSheet(sheetname).getLastRowNum();
	}
	
	public int colCount(String sheetname, int row)
	{
		return wb.getSheet(sheetname).getRow(row).getLastCellNum();
	}
	
	public String getData(String sheetname,int row,int column)
	{
		String data="";
		int celldata;
		// Now, we've to consider the cell type. if it is Numeric or String
		
		if(wb.getSheet(sheetname).getRow(row).getCell(column).getCellType()==Cell.CELL_TYPE_NUMERIC)
		{
			celldata=(int) wb.getSheet(sheetname).getRow(row).getCell(column).getNumericCellValue();
			data=String.valueOf(celldata);
		}
		else
		{
			data=wb.getSheet(sheetname).getRow(row).getCell(column).getStringCellValue();
		}
		return data;
	}

	public void setData(String sheetname,int row, int column, String status) throws Throwable 
	{
		Sheet sh=wb.getSheet(sheetname);
		Row rownum=sh.getRow(row);
		Cell cell=rownum.createCell(column);
		cell.setCellValue(status);
		if(status.equalsIgnoreCase("Pass"))
		{
			//Create Cell Style
			CellStyle style=wb.createCellStyle();
			
			//Create Font
			Font font=wb.createFont();
			
			//Apply Color to Text
			font.setColor(IndexedColors.GREEN.getIndex());
			
			//Apply Bold to Text
			font.setBold(true);
			
			//Set Font
			style.setFont(font);
			
			//Set Cell Style
			rownum.getCell(column).setCellStyle(style);
		}
		else if(status.equalsIgnoreCase("Fail"))
		{
			//Create Cell Style
			CellStyle style=wb.createCellStyle();
			
			//Create Font
			Font font=wb.createFont();
			
			//Apply Color to Text
			font.setColor(IndexedColors.RED.getIndex());
			
			//Apply Bold to Text
			font.setBold(true);
			
			//Set Font
			style.setFont(font);
			
			//Set Cell Style
			rownum.getCell(column).setCellStyle(style);
		}
		
		FileOutputStream fos=new FileOutputStream("./TestOutput/"+PropertyFileUtil.getValueForKey("project_name")+"/"+PropertyFileUtil.getValueForKey("outputfile"));
		wb.write(fos);
		fos.close();
		
	}
}
