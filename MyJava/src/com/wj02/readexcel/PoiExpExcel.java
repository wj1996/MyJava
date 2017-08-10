package com.wj02.readexcel;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/**
 * 97-2003Excel
 * @author 24253
 *
 */
public class PoiExpExcel {

	public static void main(String[] args) {
		
		String[] title = {"id","name","sex"};
		
		//创建Excel工作簿
		HSSFWorkbook workbook = new HSSFWorkbook();
		//创建一个工作表sheet
		HSSFSheet sheet = workbook.createSheet();
		//创建第一行
		HSSFRow row = sheet.createRow(0);
		HSSFCell cell = null;
		//插入第一行数据
		for(int i = 0;i < title.length;i++){
			cell = row.createCell(i);
			cell.setCellValue(title[i]);
		}
		//追加数据
		for(int i = 1;i <= 10;i++){
			HSSFRow nextRow = sheet.createRow(i);
			HSSFCell tempCell = nextRow.createCell(0);
			tempCell.setCellValue("a" + i);
			tempCell = nextRow.createCell(1);
			tempCell.setCellValue("user" + i);
			tempCell = nextRow.createCell(2);
			tempCell.setCellValue("男");
		}
		
		//创建文件
		File file = new File("C:/Test/poi_test.xls");
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
