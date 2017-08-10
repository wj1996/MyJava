package com.wj02.readexcel;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class PoiReadExcel {

	public static void main(String[] args) {
		//引入需要解析的Excel文件
		File file = new File("C:/Test/poi_test.xls");
		
		HSSFWorkbook workbook = null;
		
		try {
			//创建Excel,读取文件内容
			workbook = new HSSFWorkbook(FileUtils.openInputStream(file));
			
			//获取第一个工作表
//			HSSFSheet sheet = workbook.getSheet("sheet0");
			//读取默认第一个工作表sheet
			HSSFSheet sheet = workbook.getSheetAt(0);
			
			int FirstRowNum = 0;
			int lastRowNum = sheet.getLastRowNum();
			for(int i = FirstRowNum;i <= lastRowNum;i++){
				HSSFRow row = sheet.getRow(i);
				int lastCellNum = row.getLastCellNum();
				for(int j = 0;j < lastCellNum;j++){
					HSSFCell cell = row.getCell(j);
					String value = cell.getStringCellValue();
					System.out.print(value + "  ");
				}
				System.out.println();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
