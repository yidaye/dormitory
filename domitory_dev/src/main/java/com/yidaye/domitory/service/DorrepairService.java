package com.yidaye.domitory.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yidaye.domitory.po.Dorrepair;

public interface DorrepairService {

	    //根据楼栋号查询
		public List<Dorrepair> findAll(String b_no);
		
		//根据用户名查询
		public List<Dorrepair> findbyuno(String u_no);
		
		//查询当日维修情况
				public int findtoday(String date,String b_no,String state);
		
		//根据id查询
		public Dorrepair findbyid(int id);
		
		//添加
		public int add(Dorrepair dorrepair);
		//修改
		public int update (Dorrepair dorrepair);
		
		//删除
		public int delete(int id);
		
		//根据条件查
		public List<Dorrepair> find(int pag,int limit,String date ,String d_no,String state,String b_no);
		
		//根据条件查条数
				public int findtol(String date,String d_no,String state,String b_no);
			
		
		//修改状态
		public int updastate(Dorrepair dorrepair);
}
