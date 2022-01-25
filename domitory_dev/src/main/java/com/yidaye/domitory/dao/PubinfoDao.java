package com.yidaye.domitory.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yidaye.domitory.po.Pubinfo;

public interface PubinfoDao {
    
	//根据条件查询公告信息
	public List<Pubinfo> find(@Param("pag")int pag,@Param("limt")int limt,@Param("date")String date);
	//根据条件查询公告信息条数
		public int findtol(@Param("date")String date);
		
		//根据条件查询公告信息
		public List<Pubinfo> findm(@Param("pag")int pag,@Param("limt")int limt,@Param("date")String date,@Param("a_no")String a_no);
		//根据条件查询公告信息条数
			public int findmtol(@Param("date")String date,@Param("a_no")String a_no);
		
			//查询所有公告信息
			public List<Pubinfo> findmAll(@Param("b_no")String b_no);
			
			
	//查询所有公告信息
	public List<Pubinfo> findAll();
	
	
	//添加公告信息
	public int add(Pubinfo pubinfo);
	
	//修改公告信息
	public int update(Pubinfo pubinfo);
	
	//删除公告信息
	public int delete(@Param("id")int id);
}
