package com.wj.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * ��������ȥ���ַ����еĿո񣬻س���tab
 * @author 24253
 *
 */
public class Demo01 {
	public static void main(String[] args) {
//		StringBuffer buffer = new StringBuffer();
//		buffer.append("\t13423456677");
//		String str = buffer.toString();
//		String str1 = str.replace("\\s{2,}|\t", "");
//		System.out.println(str1);
//		System.out.println("-" + buffer.toString() + "-");
		
		String str = "\t123flkalfa   ����\n";
		Pattern p = Pattern.compile("\\s{2,}|\t|\n|\r");        
		Matcher m = p.matcher(str);        
		str= m.replaceAll("");        
		System.out.println(str);   
		System.out.println("����");
	}
}
