package com.yidaye.domitory.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yidaye.domitory.dao.WantinfoDao;
import com.yidaye.domitory.po.Wantinfo;
import com.yidaye.domitory.service.WantinfoService;

@Service
public class WantinfoServiceImpl implements WantinfoService {

	@Autowired
	private WantinfoDao wantinfoDao;
	
	public List<Wantinfo> findAll()
	{
		return wantinfoDao.findAll();
	}
	
	public List<Wantinfo> findbymno(String m_no)
	{
		return wantinfoDao.findbymno(m_no);
	}
	
	//修改缺勤信息
	public int update(Wantinfo wantinfo)
	{
		return wantinfoDao.update(wantinfo);
	}
	
	public List<Wantinfo> findbyuno(String u_no,String startdate,String enddate)
	{
		return wantinfoDao.findbyuno(u_no,startdate,enddate);
	}
	
	public int delete(int id)
	{
		return wantinfoDao.delete(id);
	}
	
	public int add(Wantinfo wantinfo)
	{
		return wantinfoDao.add(wantinfo);
	}
	
	//查询条数
			public int findtol(String date,String u_no,String m_no)
			{
				return wantinfoDao.findtol(date, u_no, m_no);
			}
	
	//根据条件查询
			public List<Wantinfo> find(int pag,int limt,String date,String u_no,String m_no)
			{
				return wantinfoDao.find(pag, limt, date, u_no, m_no);
			}
	
}
