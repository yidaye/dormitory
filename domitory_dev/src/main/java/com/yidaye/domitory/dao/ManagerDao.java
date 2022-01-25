package com.yidaye.domitory.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yidaye.domitory.po.Manager;

public interface ManagerDao {

	//查询所有
	public List<Manager> findAll(@Param("pag")int pag,@Param("limit")int limit,@Param("m_no")String m_no, 
			                     @Param("m_name")String m_name,@Param("b_no")String b_no);
	
	//查询所有条数
		public int findAlltol(@Param("m_no")String m_no, 
				                     @Param("m_name")String m_name,@Param("b_no")String b_no);
	
	//删除
	public int delete(@Param("m_id")int m_id);
	
	//查询宿管人数
	public int findtol();

	//修改密码
	public int updapass(@Param("m_id")int m_id,@Param("m_pass")String m_pass);
	
	//修改
	public int update(Manager manager);
	
	//登录
	public Manager login(@Param("m_no")String m_no,@Param("m_pass")String m_pass);
	//添加
	public int add(Manager manager);
	//根据姓名查询宿管信息
	public Manager findByname(String m_name);
	//根据楼栋id查询宿管信息
	public Manager findByid(String b_id);
}
