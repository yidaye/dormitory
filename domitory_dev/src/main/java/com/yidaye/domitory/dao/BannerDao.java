package com.yidaye.domitory.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yidaye.domitory.po.Banner;

public interface BannerDao {

	public List<Banner> find(@Param("b_no") String b_no);
	
	public List<Banner> findAll(@Param("pag")int pag,@Param("limt") int limt,@Param("b_no") String b_no,@Param("date") String date);
	
	public int findAlltol(@Param("b_no") String b_no,@Param("date") String date);
	
	public int delete(@Param("id") int id);
	
	public int add(Banner banner);
}
