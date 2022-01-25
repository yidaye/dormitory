package com.yidaye.domitory.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yidaye.domitory.po.Manager;

public interface ManagerService {

	//查询所有
	public List<Manager> findAll(int pag,int limit,String m_no, String m_name,String b_no);
	
	//查询所有条数
	public int findAlltol(String m_no,String m_name,String b_no);
	//删除
	public int delete(int m_id);
	
	//查询宿管人数
	public int findtol();
	
	//登录
	public Manager login(String m_no,String m_pass);
	
	//添加
		public int add(Manager manager);
		
		//修改密码
		public int updapass(int m_id,String m_pass);
		
		//修改
		public int update(Manager manager);
	
}
