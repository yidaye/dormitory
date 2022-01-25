package com.yidaye.domitory.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yidaye.domitory.po.Dormitory;

public interface DormitoryDao {

	//根据楼栋号查询
	public List<Dormitory> findbybno(@Param("b_no")String b_no);
	
	//查询所有
	public List<Dormitory> findAll(@Param("pag")int pag,@Param("limt")int limt,@Param("b_no")String b_no,@Param("d_no")String d_no);
	//查询数量
	public int findtol(@Param("b_no")String b_no,@Param("d_no")String d_no);
	
	
	
	//修改
	public int update(Dormitory dormitory);
	
	//删除
	public int delete(@Param("b_no")String b_no);
	
	//添加
	public int add(Dormitory dormitory);
	
}
