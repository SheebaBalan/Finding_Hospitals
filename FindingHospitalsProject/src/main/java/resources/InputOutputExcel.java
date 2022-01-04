package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class InputOutputExcel {
	static String value;
	
public static String readExcel(int rowValue,int cellValue) throws Exception {
		
		//Get a AlertBox file
		File file=new File("excelFile.xlsx");
		//Getting the location of file
		String dir=file.getAbsolutePath();
		//Getting the respective file
		FileInputStream input=new FileInputStream(dir);
		//Get the workbook
		XSSFWorkbook workbook=new XSSFWorkbook(input);
		//Get the sheet
		XSSFSheet sheet=workbook.getSheetAt(0);
		//Get the row
		XSSFRow row=sheet.getRow(rowValue);
		//Get the cell
		XSSFCell cell=row.getCell(cellValue);
		//DataFormatter class to format the cell value
		DataFormatter formatter=new DataFormatter();
		//Read the value
		value=formatter.formatCellValue(cell);
		//Close the workbook
		workbook.close();
		//Return the value
		return value;
		
	}
	

	public static void writeExcel(int sheetValue,int rowValue,int cellValue,String value) throws Exception {
		
		//Getting the AlertBox file
		File file=new File("excelFile.xlsx");
		//Get the location of file
		String dir=file.getAbsolutePath();
		//Get the respective file
		FileInputStream input=new FileInputStream(dir);
		//Get the workbook
		XSSFWorkbook workbook=new XSSFWorkbook(input);
		//Get the sheet
		XSSFSheet sheet=workbook.getSheetAt(sheetValue);
		//Set the value in excel file
		sheet.createRow(rowValue).createCell(cellValue).setCellValue(value);
		//Writing the output to the file
		FileOutputStream  fout=new FileOutputStream(dir);
		workbook.write(fout);
		//Close the workbook
		workbook.close();
		
		
	}


}
