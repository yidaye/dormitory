package com.yidaye.domitory.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yidaye.domitory.dao.DorremarkDao;
import com.yidaye.domitory.po.Dorremark;
import com.yidaye.domitory.service.DorremarkService;

@Service
public class DorremarkServiceImpl implements DorremarkService {

	@Autowired
	private DorremarkDao dorremarkDao;
	
	@Override
	public int add(Dorremark dorremark) {
		// TODO Auto-generated method stub
		return dorremarkDao.add(dorremark);
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return dorremarkDao.delete(id);
	}

	@Override
	public List<Dorremark> find(int pag, int limt, String date,String b_no) {
		// TODO Auto-generated method stub
		return dorremarkDao.find(pag, limt, date,b_no);
	}

	@Override
	public int findtol(String date,String b_no) {
		// TODO Auto-generated method stub
		return dorremarkDao.findtol(date,b_no);
	}

}
