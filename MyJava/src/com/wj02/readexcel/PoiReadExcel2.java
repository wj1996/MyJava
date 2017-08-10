package com.wj02.readexcel;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class PoiReadExcel2 {

	public static void main(String[] args) {
		
		//确定需要引进的文件
		File file = new File("C:/Test/poi_test.xlsx");
		
		XSSFWorkbook workbook = null;
		
		try {
			//创建Excel，读取文件内容
			workbook = new XSSFWorkbook(FileUtils.openInputStream(file));
			
			XSSFSheet sheet = workbook.getSheetAt(0);
			int firstNum = 0;
			int lastNum = sheet.getLastRowNum();
			for(int i = firstNum;i <= lastNum;i++){
				XSSFRow row = sheet.getRow(i);
				for(int j = 0;j < row.getLastCellNum();j++){
					XSSFCell cell = row.getCell(j);
					String value = cell.getStringCellValue();
					System.out.print(value + " ");
				}
				System.out.println();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
