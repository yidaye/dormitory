package com.yidaye.domitory.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yidaye.domitory.po.Wantinfo;

public interface WantinfoDao {

	//查询所有缺勤信息
	public List<Wantinfo> findAll();
	
	//根据宿管账号查询
	public List<Wantinfo> findbymno(@Param("m_no")String m_no);
	
	//根据用户号查询
	public List<Wantinfo> findbyuno(@Param("u_no")String u_no,@Param("startdate")String startdate,@Param("enddate")String enddate);
	
	//删除缺勤信息
	public int delete(int id);
	
	//添加缺勤信息
	public int add(Wantinfo wantinfo);
	
	//修改缺勤信息
		public int update(Wantinfo wantinfo);
	
	//查询条数
	public int findtol(@Param("date") String date,@Param("u_no") String u_no,@Param("m_no")String m_no);;
	
	//根据条件查询
	public List<Wantinfo> find(@Param("pag") int pag,@Param("limt") int limit,@Param("date") String date,@Param("u_no") String u_no,@Param("m_no")String m_no);
}
