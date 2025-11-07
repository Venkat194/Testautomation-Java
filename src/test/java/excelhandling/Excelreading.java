package excelhandling;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excelreading {

	public static void main(String[] args) throws IOException {
		FileInputStream file= new FileInputStream("C:\\Users\\Venkatesh Yedla\\eclipse-workspace\\TestAutomation\\TestData\\Testdata1.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		int total_rows =sheet.getLastRowNum();
		int total_cols= sheet.getRow(1).getLastCellNum();
		
		for(int r=0;r<=total_rows;r++) 
		{
			XSSFRow row= sheet.getRow(r);
			for(int c=0;c<total_cols;c++)
			{
				XSSFCell cell= row.getCell(c);
				System.out.print(cell.toString()+"\t"+"\t");
			}
			System.out.println();
		}
		workbook.close();
		file.close();
	}

}
