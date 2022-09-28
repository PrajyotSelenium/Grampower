package com.gp.webapp.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.apache.log4j.Layout;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.WebDriver;
public class Commons {
      public static WebDriver driver;
      public static FileInputStream fis;
      public static Logger log=Logger.getLogger(Commons.class.getName());
      public static HSSFWorkbook workbook;
      public static HSSFSheet sheet;
      public static HSSFRow row;
      public static HSSFCell cell;
      public static Layout l=new PatternLayout();
      public static Properties pro=new Properties();
      
      public static FileInputStream url() throws IOException
      {
    	  fis=new FileInputStream("src//test//resources//Url//Url.properties");
    	  pro.load(fis);
    	  return fis;
      }
      public static String excel_username() throws IOException
      {
    	  fis=new FileInputStream("src//test//resources//Test cases//TestCases_Grampower.xls");
    	  workbook=new HSSFWorkbook(fis);
    	  sheet=workbook.getSheet("Sheet1");
    	  row=sheet.getRow(9);
    	  cell=row.getCell(6);
    	  String username=cell.getStringCellValue();
    	  return username;
      }
      public static String excel_password() throws IOException
      {
    	  fis=new FileInputStream("src//test//resources//Test cases//TestCases_Grampower.xls");
    	  workbook=new HSSFWorkbook(fis);
    	  sheet=workbook.getSheet("Sheet1");
    	  row=sheet.getRow(11);
    	  cell=row.getCell(6);
    	  String password=cell.getStringCellValue();
    	  return password;
      }
      public static String excel_dropdown() throws IOException
      {
    	  fis=new FileInputStream("src//test//resources//Test cases//TestCases_Grampower.xls");
    	  workbook=new HSSFWorkbook(fis);
    	  sheet=workbook.getSheet("Sheet1");
    	  row=sheet.getRow(19);
    	  cell=row.getCell(6);
    	  String dp=cell.getStringCellValue();
    	  return dp;
      }
}
