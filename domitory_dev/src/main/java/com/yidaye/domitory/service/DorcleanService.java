package com.yidaye.domitory.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yidaye.domitory.po.Dorclean;

public interface DorcleanService {

	//根据宿舍号查询
	public List<Dorclean> findbydno(String b_no , String d_no);
	
	//添加宿舍卫生信息
	public int add(Dorclean dorclean);
	
	//根据宿管人员查询
	public List<Dorclean> findAll(String b_no);
	
	//根据条件查
	public List<Dorclean> find(int pag, int limt,String date,String b_no,String d_no); 
	
	//根据条件查
		public int findtol(String date,String b_no,String d_no); 
		
		//修改
				public int update(Dorclean dorclean);
		
	//删除
		public int delete(int id);
		
		//查询未评估宿舍
		public List<String> findnocl(String b_no,String date);
}
