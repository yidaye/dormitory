package com.yidaye.domitory.service;

import java.util.List;

import com.yidaye.domitory.po.Wantinfo;

public interface WantinfoService {

	    //查询所有缺勤信息
		public List<Wantinfo> findAll();
		
		//根据宿管账号查询
		public List<Wantinfo> findbymno(String m_no);
		
		//根据用户号查询
		public List<Wantinfo> findbyuno(String u_no,String startdate,String enddate);
		
		//删除缺勤信息
		public int delete(int id);
		
		//添加缺勤信息
		public int add(Wantinfo wantinfo);
		
		//修改缺勤信息
				public int update(Wantinfo wantinfo);
		
		//查询条数
		public int findtol(String date,String u_no,String m_no);
		
		//根据条件查询
		public List<Wantinfo> find(int pag,int limt,String date,String u_no,String m_no);
}
