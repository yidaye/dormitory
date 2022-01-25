package com.yidaye.domitory.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yidaye.domitory.po.Dorrepair;

public interface DorrepairDao {

	//根据条件查
	public List<Dorrepair> find(@Param("pag")int pag,@Param("limt")int limt,@Param("date")String date,@Param("d_no")String d_no,@Param("state")String state,@Param("b_no")String b_no);
	
	//根据条件查 
		public int findtol(@Param("date")String date,@Param("d_no")String d_no,@Param("state")String state,@Param("b_no")String b_no);
		
	//查询当日维修情况
		public int findtoday(@Param("date")String date,@Param("b_no")String b_no,@Param("state")String state);
	
	//根据楼栋号查询
	public List<Dorrepair> findAll(String b_no);
	
	//根据用户名查询
	public List<Dorrepair> findbyuno(@Param("u_no")String u_no);
	
	//根据id查询
		public Dorrepair findbyid(@Param("id")int id);
	
	//添加
	public int add(Dorrepair dorrepair);
	//修改
	public int update (Dorrepair dorrepair);
	
	//删除
	public int delete(@Param("id")int id);
	
	//修改状态
	public int updastate(Dorrepair dorrepair);
}
