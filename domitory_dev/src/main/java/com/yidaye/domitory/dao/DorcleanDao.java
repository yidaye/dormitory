package com.yidaye.domitory.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yidaye.domitory.po.Dorclean;

public interface DorcleanDao {

	//根据宿舍号查询
	public List<Dorclean> findbydno(@Param("b_no")String b_no , @Param("d_no")String d_no);
	
	//根据条件查
	public List<Dorclean> find(@Param("pag")int pag,@Param("limt") int limt,@Param("date")String date,@Param("b_no")String b_no,@Param("d_no")String d_no); 
	
	//根据条件查
		public int findtol(@Param("date")String date,@Param("b_no")String b_no,@Param("d_no")String d_no); 
		
	
	//添加宿舍卫生信息
	public int add(Dorclean dorclean);
	
	//根据楼栋号查询
	public List<Dorclean> findAll(@Param("b_no")String b_no);
	
	//删除
	public int delete(@Param("id") int id);
	
	//修改
		public int update(Dorclean dorclean);
	
	//查询未评估宿舍
	public List<String> findnocl(@Param("b_no")String b_no,@Param("date")String date);
	
	
}
