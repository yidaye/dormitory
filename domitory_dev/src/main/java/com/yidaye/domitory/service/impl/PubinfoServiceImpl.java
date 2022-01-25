package com.yidaye.domitory.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yidaye.domitory.dao.PubinfoDao;
import com.yidaye.domitory.po.Pubinfo;
import com.yidaye.domitory.service.PubinfoService;

@Service
public class PubinfoServiceImpl implements PubinfoService {

	@Autowired
	private PubinfoDao pubinfoDao;
	
	public List<Pubinfo> find(int pag,int limt,String date)
	{
		return pubinfoDao.find(pag,limt,date);
	}
	
	//根据条件查询公告信息条数
	public int findtol(String date)
	{
		return pubinfoDao.findtol(date);
	}
	
	// 根据条件查询
	public List<Pubinfo> findm(int pag,int limt,String date,String a_no)
	{
		return pubinfoDao.findm(pag, limt, date, a_no);
	}
	//根据条件查询公告信息条数
			public int findmtol(String date,String a_no)
			{
				return pubinfoDao.findmtol(date, a_no);
			}
	
	public List<Pubinfo> findAll()
	{
		return pubinfoDao.findAll();	
	}
	public List<Pubinfo> findmAll(String b_no)
	{
		return pubinfoDao.findmAll(b_no);	
	}
	
	public int add(Pubinfo pubinfo)
	{
		return pubinfoDao.add(pubinfo);
	}
	
	public int update(Pubinfo pubinfo)
	{
		return pubinfoDao.update(pubinfo);
	}
	
	public int delete(int id)
	{
		return pubinfoDao.delete(id);
	}
}
