package com.yidaye.domitory.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yidaye.domitory.po.Pubinfo;

public interface PubinfoService {

	// 根据条件查询
	public List<Pubinfo> find(int pag,int limt,String date);
	//根据条件查询公告信息条数
			public int findtol(String date);
			
			// 根据条件查询
			public List<Pubinfo> findm(int pag,int limt,String date,String a_no);
			//根据条件查询公告信息条数
					public int findmtol(String date,String a_no);
	
	//查询所有公告信息
		public List<Pubinfo> findAll();
		
		//查询所有公告信息
				public List<Pubinfo> findmAll(String b_no);
	
	//添加公告信息
	public int add(Pubinfo pubinfo);
	
	//修改公告信息
	public int update(Pubinfo pubinfo);
		
	//删除公告信息
	public int delete(int id);
	
}
