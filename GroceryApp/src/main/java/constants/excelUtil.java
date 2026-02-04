package constants;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excelUtil 
{

	static FileInputStream dataFile; //excel file 
	static XSSFWorkbook workbk; //Book1
	static XSSFSheet worksheet;// sheets//loginData
	
	public static String getStringData(int row,int col,String sheet) throws IOException // a is row ,b is column or cell
	{
		dataFile=new FileInputStream(ConstClass.testdatafile);
		workbk=new XSSFWorkbook(dataFile);
		worksheet=workbk.getSheet(sheet);
		
		XSSFRow r=worksheet.getRow(row);
		if (r == null) 
		{
            return "";
        }
		XSSFCell c=r.getCell(col);
		if (c == null) 
		{
            return "";
        }
		 DataFormatter formatter = new DataFormatter();
		 return formatter.formatCellValue(c);
	}
	
	public static String getIntegerData(int row,int col,String sheet) throws IOException 
	{ 
		dataFile=new FileInputStream(ConstClass.testdatafile);
		workbk=new XSSFWorkbook(dataFile);
		worksheet=workbk.getSheet(sheet);
		
		XSSFRow r=worksheet.getRow(row);
		XSSFCell c=r.getCell(col);//10
		int y=(int) c.getNumericCellValue();// string - integer  = typecasting
		return String.valueOf(y);
	}
}
