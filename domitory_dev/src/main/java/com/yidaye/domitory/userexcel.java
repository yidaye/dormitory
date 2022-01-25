package com.yidaye.domitory;

import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;


public class userexcel {

	public static void main(String[] args) {
		
				 //excel内标题
		        String[] tarray = {"学号","姓名","性别","电话","学院","年级","班级","专业"};
				 // 建立一个Excel文件
		        Workbook book = new HSSFWorkbook();
		        // 在对应的Excel中建立一个分表
		        Sheet sheet1 =(Sheet) book.createSheet("分表1");
		        // 设置相应的行（初始从0开始），设置标题行
		        Row row =sheet1.createRow(0);
		        //添加excel标题
		        for(int i=0;i<tarray.length;i++)
		        {
		        	// 在所在的行设置所在的单元格（相当于列，初始从0开始,对应的就是A列）
		            Cell cell = row.createCell(i);
		            // 写入相关数据到设置的行列中去。
		            cell.setCellValue(tarray[i]);
		        }
		        //添加数据
		        int u_no=2017010000;
		        String u_name="";
		        String u_sex="";
		        int u_phone=185730400;
		        String u_coll="";
		        String u_gra="";
		        String u_class="";
		        String u_sub="";
		        for(int i=1400;i<1900;i++)
				{
		        	 u_no=u_no+i;
		        	 u_name="测试姓名"+i;
		        	 //if(i%2==1) u_sex="男";else u_sex="女";
		        	 u_sex="男";
		        	 u_phone=u_phone+1;
		        	 if(i%5==0) {u_coll="计算机学院"; u_gra="2017";u_class="17软件1班";u_sub="网络工程";}
		        	 else if(i%5==1) {u_coll="艺术学院"; u_gra="2018";u_class="17软件1班";u_sub="网络工程";}
		        	 else if(i%5==2) {u_coll="电子信息学院"; u_gra="2019";u_class="17软件1班";u_sub="网络工程";}
		        	 else if(i%5==3) {u_coll="商务学院";u_gra="2017";u_class="17软件1班";u_sub="网络工程";}
		        	 else if(i%5==4) {u_coll="体育学院";u_gra="2020";u_class="17软件1班";u_sub="网络工程";}
		        	 
					//System.out.println(users.get(i).getUsername()+users.get(i).getPassword());
		        	  // 设置相应的行（初始从1开始），设置内容行
					Row row1 =sheet1.createRow(i+1);
					// 在所在的行设置所在的单元格（相当于列，初始从0开始,对应的就是A列）
		            Cell cell = row1.createCell(0);
		            Cell cell1=row1.createCell(1);
		            Cell cell2 = row1.createCell(2);
		            Cell cell3=row1.createCell(3);
		            Cell cell4= row1.createCell(4);
		            Cell cell5=row1.createCell(5);
		            Cell cell6= row1.createCell(6);
		            Cell cell7=row1.createCell(7);
		            // 写入相关数据到设置的行列中去。
		            cell.setCellValue(u_no);
		            cell1.setCellValue(u_name);
		            cell2.setCellValue(u_sex);
		            cell3.setCellValue(u_phone);
		            cell4.setCellValue(u_coll);
		            cell5.setCellValue(u_gra);
		            cell6.setCellValue(u_class);
		            cell7.setCellValue(u_sub);
				}
		         try {
		        	//生成文件到相应位置
		 		    //String classpath=this.getClass().getResource("/").toURI().getPath();
		 		    //System.out.println(classpath);
		 		   //建立一个书写器与document对象关联
		 		    //String filepath=classpath.replaceAll("target/classes/", "excel_file/"+filename+".xls");
					String filepath="D:/test/user.xls";
		        	 book.write( new FileOutputStream(filepath));
		        	 System.out.println("ok");
				}catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
	}
}
