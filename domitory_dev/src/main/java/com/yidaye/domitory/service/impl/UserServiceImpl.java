package com.yidaye.domitory.service.impl;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import com.yidaye.domitory.dao.UserDao;
import com.yidaye.domitory.po.User;
import com.yidaye.domitory.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	public List<User> findcoll(String b_no)
	{
		return userDao.findcoll(b_no);
	}
	
	public List<User> findAll(int pag,int limt,String u_gra,String u_no,String u_name,String b_no) {
		
		return userDao.findAll(pag, limt, u_gra, u_no, u_name, b_no);
	}
	
	public int findAlltol(String u_gra,String u_no,String u_name,String b_no)
	{
		return userDao.findAlltol(u_gra, u_no, u_name, b_no);
	}

	//根据条件查
	public List<User> find(int pag,int limt,String u_gra,String u_no,String u_name,String b_no)
	{
		System.out.println(u_gra);
		System.out.println(u_no);
		System.out.println(u_name);
		System.out.println(b_no);
		return userDao.find(pag, limt, u_gra, u_no, u_name,b_no);
	}
	
	//根据条件查询条数
	public int findtol(String u_gra,String u_no,String u_name,String b_no)
	{
		return userDao.findtol(u_gra, u_no, u_name, b_no);
	}
	
	//重置密码
	public int updapass(int u_id,String u_pass)
	{
		return userDao.updapass(u_id,u_pass);
	}
	
	//删除
  	public int delete (int u_id)
  	{
  		return userDao.delete(u_id);
  	}
	
  	public int update(User user)
  	{
  		return userDao.update(user);
  	}
  	
   //登录
	public User login(String u_no,String u_pass)
	{
		return userDao.login(u_no, u_pass);
	}
	
	//添加
	
	public int add(User user)
	{
		return userDao.add(user);
	}
	
	//根据学号查询
	public User findbyno(String u_no)
	{
		return userDao.findbyno(u_no);
	}
	
	
	public int addUser(MultipartFile file) throws Exception {
		int result = 0;
      //存放excel表中所有user信息
		List<User> userList = new ArrayList<>();
		//获取上传文件名
		String fileName = file.getOriginalFilename();
		//获取上传文件名后缀（xlsx或xls
		String suffix = fileName.substring(fileName.lastIndexOf(".")+1);
		//解析文件数据
		InputStream ins = file.getInputStream();
		// POI导出Excel的 workbook
		Workbook wb = null;
		/**
		 * 判断文件格式
        HSSFWorkbook:是操作Excel2003以前（包括2003）的版本，扩展名是.xls
        XSSFWorkbook:是操作Excel2007的版本，扩展名是.xlsx

		 */
		if(suffix.equals("xlsx")){
			
			wb = new XSSFWorkbook(ins);
			
		}else{
			wb = new HSSFWorkbook(ins);
		}
		/**
		 * 获取excel表单的第一个工作蒲
		 */
		Sheet sheet = wb.getSheetAt(0);
		
		/**
		 * line = 2 :从表的第三行开始获取记录
		 * 
		 */
		if(null != sheet){
			
			for(int line = 1; line <= sheet.getLastRowNum();line++){
				
				User user = new User();
				
				Row row = sheet.getRow(line);
				
				if(null == row){
					continue;
				}
				/**
				 * 判断单元格类型是否为文本类型
				 */
				/*
				if(1 != row.getCell(0).getCellType()){
					System.out.println("单元格类型不是文本类型！");
				}*/
				
				/**
				 * 获取第一个单元格的内容
				 */
		          row.getCell(0).setCellType(Cell.CELL_TYPE_STRING);
		          row.getCell(3).setCellType(Cell.CELL_TYPE_STRING);
		          row.getCell(5).setCellType(Cell.CELL_TYPE_STRING);
				String u_no = row.getCell(0).getStringCellValue();
				String u_name = row.getCell(1).getStringCellValue();//获取第一个单元格的内容
				String u_sex = row.getCell(2).getStringCellValue();
				String u_phone = row.getCell(3).getStringCellValue();
				String u_coll = row.getCell(4).getStringCellValue();
				String u_gra = row.getCell(5).getStringCellValue();
				String u_class = row.getCell(6).getStringCellValue();
				String u_sub = row.getCell(7).getStringCellValue();
				user.setU_no(u_no);
				user.setU_name(u_name);
				user.setU_sex(u_sex);
				user.setU_phone(u_phone);
				user.setU_class(u_class);
				user.setU_coll(u_coll);
				user.setU_gra(u_gra);
				user.setU_sub(u_sub);
				user.setU_pass("123456");
				userList.add(user);
	
			}
			
			for(User userInfo:userList){
			
				//int count = userdao.;
				userDao.add(userInfo);
			} 
		}
     
		return result;
	}

	
}
