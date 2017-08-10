package com.wj02.readexcel;

import java.io.File;
import java.io.IOException;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class JxlExcel {

	
	
	public static void main(String[] args) {
		String[] title = {"id","name","sex"};
		//创建Excel文件
		File file = new File("C:/Test/jxl_test.xls");
		WritableWorkbook workbook = null;
		try {
			file.createNewFile();
			//创建工作簿
			workbook = Workbook.createWorkbook(file);
			//创建sheet
			WritableSheet sheet = workbook.createSheet("sheet1", 0);
			Label label = null;
			//第一行设置列名
			for(int i = 0;i < title.length;i++){
				label = new Label(i,0,title[i]);
				sheet.addCell(label);
			}
			//追加数据
			for(int i = 1;i < 10;i++){
				label = new Label(0,i,"a" + i);
				sheet.addCell(label);
				label = new Label(1,i,"user" + i);
				sheet.addCell(label);
				label = new Label(2,i,"男");
				sheet.addCell(label);
			}
			
			workbook.write();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (RowsExceededException e) {
			e.printStackTrace();
		} catch (WriteException e) {
			e.printStackTrace();
		}finally{
			if(null != workbook){
				try {
					workbook.close();
				} catch (WriteException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
