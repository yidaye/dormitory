package com.yidaye.domitory.service.impl;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yidaye.domitory.dao.BanDao;
import com.yidaye.domitory.po.Ban;
import com.yidaye.domitory.service.BanService;

@Service
public class BanServiceImpl implements BanService {

	@Autowired
	private BanDao banDao;
	
	public List<Ban> findAll(int pag,int limt,String b_no,String b_sex)
	{
		return banDao.findAll( pag,limt,b_no,b_sex);
	}
	
	public List<Ban> find(String b_no)
	{
		return banDao.find(b_no);
	}
	
	public int findtol(String b_no,String b_sex)
	{
		return banDao.findtol(b_no,b_sex);
	}
	
	public int delete(int b_id)
	{
		return banDao.delete(b_id);
	}
	
	public int add(Ban ban)
	{
		return banDao.add(ban);
	}
	
	public int update (Ban ban)
	{
		return banDao.update(ban);
	}
	
	//查询楼栋入住人数
		public int findrelpepo(String b_no)
		{
			return banDao.findrelpepo(b_no);
		}
		
		public int findpepo(String b_sex)
		{
			return banDao.findpepo(b_sex);
		}
}
