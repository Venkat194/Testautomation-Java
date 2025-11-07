package excelhandling;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excelwriting {
	public static void main(String[] args) throws IOException {
		FileOutputStream file = new FileOutputStream("C:\\\\Users\\\\Venkatesh Yedla\\\\eclipse-workspace\\\\TestAutomation\\\\TestData\\\\Testdata2.xlsx");
		XSSFWorkbook workboook = new XSSFWorkbook();
		XSSFSheet sheet = workboook.createSheet("Data");
		XSSFRow row1 = sheet.createRow(0);
		row1.createCell(0).setCellValue("data1");
		row1.createCell(1).setCellValue("data2");
		row1.createCell(2).setCellValue("data3");
		
		XSSFRow row2 = sheet.createRow(1);
		row2.createCell(0).setCellValue("data1");
		row2.createCell(1).setCellValue("data2");
		row2.createCell(2).setCellValue("data3");
		
		workboook.write(file);
		workboook.close();
		file.close();
	}

}
