package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadExcelUtils {

	public static void getDataFromExcel() throws FileNotFoundException, IOException {

		String filePath = "D:\\desktop1\\Excel sheets\\datasheet.xlsx";

		File file = new File(filePath);

		FileInputStream fis = new FileInputStream(file);

		Workbook workbook = WorkbookFactory.create(fis);

		Sheet sheet = workbook.getSheet("Sheet1");

		System.out.println(sheet.getPhysicalNumberOfRows());

		System.out.println(sheet.getRow(0).getPhysicalNumberOfCells());

		workbook.close();
		
	}

	public static void main(String args[]) throws FileNotFoundException, IOException {

		getDataFromExcel();
	}

}
