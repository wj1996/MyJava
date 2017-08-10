package com.wj02.readexcel;

import java.io.File;
import java.io.IOException;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class JxlReadExcel {

	public static void main(String[] args) {
		Workbook workbook = null;
		try {
			//获取workbook
			workbook = Workbook.getWorkbook(new File("C:/Test/jxl_test.xls"));
			//获取第一个工作表sheet
			Sheet sheet = workbook.getSheet(0);
			//获取数据
			for(int i = 0;i < sheet.getRows();i++){
				for(int j = 0;j < sheet.getColumns();j++){
					Cell cell = sheet.getCell(j, i);
					System.out.print(cell.getContents() + " ");
				}
				System.out.println();
			}
		} catch (BiffException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(null != workbook){
				workbook.close();
			}
		}
		
		
	}
}
