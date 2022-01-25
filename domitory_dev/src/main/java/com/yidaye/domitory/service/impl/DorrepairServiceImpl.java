package com.yidaye.domitory.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yidaye.domitory.dao.DorrepairDao;
import com.yidaye.domitory.po.Dorrepair;
import com.yidaye.domitory.service.DorcleanService;
import com.yidaye.domitory.service.DorrepairService;

@Service

public class DorrepairServiceImpl implements DorrepairService{

	@Autowired
	private DorrepairDao dorrepairDao;
	
	public List<Dorrepair> findbyuno(String u_no)
	{
		return dorrepairDao.findbyuno(u_no);
	}
	
	
	//查询当日维修情况
	public int findtoday(String date,String b_no,String state)
	{
	    return dorrepairDao.findtoday(date, b_no, state);	
	}
	
	public List<Dorrepair> findAll(String b_no)
	{
		return dorrepairDao.findAll(b_no);
	}
	
	public Dorrepair findbyid(int id)
	{
		return dorrepairDao.findbyid(id);
	}
	
	public int delete(int id)
	{
		return dorrepairDao.delete(id);
		
	}
	
	public int update (Dorrepair dorrepair)
	{
		return dorrepairDao.update(dorrepair);
	}
	
	public int add(Dorrepair dorrepair)
	{
		return dorrepairDao.add(dorrepair);
	}
	
	public List<Dorrepair> find(int pag,int limit,String date ,String d_no,String state,String b_no)
	{
		return dorrepairDao.find(pag, limit, date, d_no, state, b_no);
	}
	
	//根据条件查条数
	public int findtol(String date,String d_no,String state,String b_no)
	{
		return dorrepairDao.findtol(date, d_no, state, b_no);
	}
	
	//修改状态
			public int updastate(Dorrepair dorrepair)
			{
				return dorrepairDao.updastate(dorrepair);
			}
}
