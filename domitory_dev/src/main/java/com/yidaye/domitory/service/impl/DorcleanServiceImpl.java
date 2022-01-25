package com.yidaye.domitory.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yidaye.domitory.dao.DorcleanDao;
import com.yidaye.domitory.po.Dorclean;
import com.yidaye.domitory.service.DorcleanService;

@Service

public class DorcleanServiceImpl implements DorcleanService {

	@Autowired
	private DorcleanDao dorcleanDao;
	
	public List<Dorclean> findAll(String b_no)
	{
		return dorcleanDao.findAll(b_no);
	}
	
	public int add(Dorclean dorclean)
	{
		return dorcleanDao.add(dorclean);
	}
	
	public List<Dorclean> findbydno(String b_no,String d_no)
	{
		return dorcleanDao.findbydno(b_no, d_no);
	}
	
	//根据条件查
		public List<Dorclean> find(int pag, int limt,String date,String b_no,String d_no)
		{
			return dorcleanDao.find(pag, limt, date, b_no, d_no);
		}
		
		//根据条件查
				public int findtol(String date,String b_no,String d_no)
				{
					return dorcleanDao.findtol(date, b_no, d_no);
				}
	
		//删除
				public int delete(int id)
				{
					return dorcleanDao.delete(id);
				}
				
				//查询未评估宿舍
				public List<String> findnocl(String b_no,String date)
				{
					return dorcleanDao.findnocl(b_no,date);
				}
				
				//修改
				public int update(Dorclean dorclean)
				{
					return dorcleanDao.update(dorclean);
				}
}
