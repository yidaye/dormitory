package com.yidaye.domitory.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yidaye.domitory.dao.ManagerDao;
import com.yidaye.domitory.po.Manager;
import com.yidaye.domitory.service.ManagerService;

@Service
public class ManagerServiceImpl implements ManagerService {

	@Autowired
	private ManagerDao managerDao;
	
	public List<Manager> findAll(int pag,int limit,String m_no, String m_name,String b_no)
	{
		return  managerDao.findAll(pag,limit,m_no,m_name,b_no);
	}
	
	//查询所有条数
		public int findAlltol(String m_no,String m_name,String b_no)
		{
			return managerDao.findAlltol(m_no, m_name, b_no);
		}
	
	public int delete(int m_id)
	{
		return managerDao.delete(m_id);
	}
	
	public int add(Manager manager)
	{
		return managerDao.add(manager);
	}
	
	public int updapass(int m_id,String m_pass)
	{
		return managerDao.updapass(m_id,m_pass);
	}
	
	public int findtol()
	{
		return managerDao.findtol();
	}
	
	public Manager login(String m_no,String m_pass)
	{
		return managerDao.login(m_no, m_pass);
	}
	
	public int update(Manager manager)
	{
		return managerDao.update(manager);
	}
}
