package com.yidaye.domitory.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yidaye.domitory.dao.DormitoryDao;
import com.yidaye.domitory.po.Dormitory;
import com.yidaye.domitory.service.DormitoryService;

@Service

public class DormitoryServiceImpl implements DormitoryService {

	@Autowired
	private DormitoryDao dormitoryDao;
	
	public List<Dormitory> findAll(int pag,int limit,String b_no,String d_no)
	{
		return dormitoryDao.findAll(pag,limit,b_no,d_no);
	}
	
	//查询数量
			public int findtol(String b_no,String d_no) {
				
				return dormitoryDao.findtol(b_no, d_no);
			}
	public List<Dormitory> findbybno(String b_no)
	{
		return dormitoryDao.findbybno(b_no);
	}
	
	public int delete(String b_no)
	{
		return dormitoryDao.delete(b_no);
	}
	
	public int add(Dormitory dormitory)
	{
		return dormitoryDao.add(dormitory);
	}
	
	public int update(Dormitory dormitory)
	{
		return dormitoryDao.update(dormitory);
	}
}
