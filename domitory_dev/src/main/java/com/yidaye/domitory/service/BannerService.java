package com.yidaye.domitory.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yidaye.domitory.po.Banner;

public interface BannerService {

	public List<Banner> find(String b_no);
	
	public List<Banner> findAll(int pag, int limt,String b_no,String date);
	
	public int findAlltol( String b_no,String date);
	
	public int delete(int id);
	
	public int add(Banner banner);
	
	
}
