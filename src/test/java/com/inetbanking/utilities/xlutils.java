package com.inetbanking.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class xlutils {
	
	public static FileInputStream fil;
	public static FileOutputStream fo;
	public static XSSFWorkbook wb;
	public static XSSFSheet sh;
	public static XSSFRow row;
	public static XSSFCell cell;
	


public static int getrowcount(String xlfile, String xlsheet) throws IOException
{
	fil=new FileInputStream(xlfile);
	wb=new XSSFWorkbook(fil);
	sh=wb.getSheet(xlsheet);
	int row=sh.getLastRowNum();
	wb.close();
	fil.close();
	return row;
}

public static int getcellcount(String xlfile,String xlsheet,int rownum) throws IOException

{
	fil=new FileInputStream(xlfile);
	wb=new XSSFWorkbook(fil);
	sh=wb.getSheet(xlsheet);
	row=sh.getRow(rownum);
	int cell=row.getLastCellNum();
	wb.close();
	fil.close();
	return cell;
	
}

public static String getcelldata(String xlfile,String xlsheet,int rownum,int colunum) throws IOException

{
	fil=new FileInputStream(xlfile);
	wb=new XSSFWorkbook(fil);
	sh=wb.getSheet(xlsheet);
	row=sh.getRow(rownum);
	cell=row.getCell(colunum);
	String data;
	try
	{
		DataFormatter Formatter = new DataFormatter();
		String celldata=Formatter.formatCellValue(cell);
		return celldata;	
		}
	catch(Exception e)
	{
		data="";
	}
    wb.close();
    fil.close();
   
	return data;
}

public static void setcellvalue(String xlfile,String xlsheet,int rownum,int colunum,String data) throws IOException

{
	fil=new FileInputStream(xlfile);
	wb=new XSSFWorkbook(fil);
	sh=wb.getSheet(xlsheet);
	row=sh.getRow(rownum);
	cell=row.createCell(colunum);
	cell.setCellValue(data);
	fo=new FileOutputStream(xlfile);
	wb.write(fo);
	wb.close();
	fil.close();
	fo.close();
}

}