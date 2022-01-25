package com.yidaye.domitory.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yidaye.domitory.po.Dorremark;

public interface DorremarkDao {
	
	public int add(Dorremark dorremark);
	
	public int delete(@Param("id") int id);
	
	public List<Dorremark> find(@Param("pag")int pag,@Param("limt") int limt,@Param("date") String date,@Param("b_no") String b_no);
	
	public int findtol(@Param("date") String date,@Param("b_no") String b_no );

}
