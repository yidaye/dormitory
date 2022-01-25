package com.yidaye.domitory.dao;

import org.apache.ibatis.annotations.Param;

import com.yidaye.domitory.po.Admin;

public interface AdminDao {

	//登录
	public Admin login(@Param("a_no")String  a_no,@Param("a_pass")String a_pass);
}
