package com.yidaye.domitory.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yidaye.domitory.po.Dorremark;

public interface DorremarkService {

public int add(Dorremark dorremark);
	
	public int delete(int id);
	
	public List<Dorremark> find(int pag, int limt, String date,String b_no );
	
	public int findtol(String date,String b_no );
}
