package com.yidaye.domitory.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yidaye.domitory.po.Ban;

public interface BanDao {

	//查询所有
	public List<Ban> find(@Param("b_no")String b_no);
	
	//条件查询所有
	public List<Ban> findAll(@Param("pag")int pag,@Param("limt")int limt,@Param("b_no")String b_no,@Param("b_sex")String b_sex);
	
	//查询楼栋总数
	public int findtol(@Param("b_no")String b_no,@Param("b_sex")String b_sex);
	
	//修改
	public int update(Ban ban);
	
	//添加
	public int add(Ban ban);
	
	//删除
	public int delete(@Param("b_id")int b_id);
	
	//查询楼栋入住人数
	public int findrelpepo(@Param("b_no")String b_no);
	
	public int findpepo(@Param("b_sex")String b_sex);
}
