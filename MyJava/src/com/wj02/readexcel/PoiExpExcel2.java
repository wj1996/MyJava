package com.wj02.readexcel;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * 97-2003Excel
 * @author 24253
 *
 */
public class PoiExpExcel2 {

	public static void main(String[] args) {
		
		String[] title = {"id","name","sex"};
		
		//创建Excel工作簿
		XSSFWorkbook workbook = new XSSFWorkbook();
		//创建一个工作表sheet
		XSSFSheet sheet = workbook.createSheet();
		//创建第一行
		XSSFRow row = sheet.createRow(0);
		XSSFCell cell = null;
		//插入第一行数据
		for(int i = 0;i < title.length;i++){
			cell = row.createCell(i);
			cell.setCellValue(title[i]);
		}
		//追加数据
		for(int i = 1;i <= 10;i++){
			XSSFRow nextRow = sheet.createRow(i);
			XSSFCell tempCell = nextRow.createCell(0);
			tempCell.setCellValue("a" + i);
			tempCell = nextRow.createCell(1);
			tempCell.setCellValue("user" + i);
			tempCell = nextRow.createCell(2);
			tempCell.setCellValue("男");
		}
		
		//创建文件
		File file = new File("C:/Test/poi_test.xlsx");
		FileOutputStream fos = null;
		try {
//			file.createNewFile();
			
			fos = FileUtils.openOutputStream(file);
			workbook.write(fos);
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(null != fos){
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(null != workbook){
				try {
					workbook.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		
	}
}
