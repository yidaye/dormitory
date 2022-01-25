package com.yidaye.domitory.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yidaye.domitory.dao.BannerDao;
import com.yidaye.domitory.po.Banner;
import com.yidaye.domitory.service.BannerService;

@Service
public class BannerServiceImpl implements BannerService {

	@Autowired
	private BannerDao bannerDao;
	
	
	@Override
	public List<Banner> find(String b_no) {
		// TODO Auto-generated method stub
		return bannerDao.find(b_no);
	}
	
	public List<Banner> findAll(int pag, int limt,String b_no,String date)
	{
		return bannerDao.findAll(pag, limt, b_no, date);
	}

	public int findAlltol( String b_no,String date)
	{
		return bannerDao.findAlltol(b_no, date);
	}
	
	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return bannerDao.delete(id);
	}

	@Override
	public int add(Banner banner) {
		// TODO Auto-generated method stub
		return bannerDao.add(banner);
	}

}
