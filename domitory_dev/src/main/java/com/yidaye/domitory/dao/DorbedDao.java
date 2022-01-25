package com.yidaye.domitory.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yidaye.domitory.po.Dorbed;

public interface DorbedDao {

	//根据条件查询
	public List<Dorbed> find(@Param("b_no") String b_no,@Param("d_no") String d_no);
	
	//删除
	public int delete(@Param("b_no") String b_no);
	
	//添加
	public int add(Dorbed dorbed);
	
	public List<Integer> findk(@Param("b_no")String b_no,@Param("d_no")String d_no);
	
	//查询入住人数
	public int findpepo(@Param("b_no")String b_no);
	
	//查询空余位置
		public int findkong(@Param("b_no")String b_no);

		//查询入住人数
		public int findwei();
		
		public int updtuno(@Param("u_no")String u_no);
		
		//查询空余床位
		public List<Integer> findkbed(@Param("b_sex")String b_sex);
		
		//查询未分配人
		public List<String> findkpepo(@Param("u_sex")String u_sex);
		
		//分配
		public int update(@Param("id")int id,@Param("u_no")String u_no);
		
		public int findAlltol(@Param("b_no")String b_no,@Param("d_no")String d_no);
		
		public int delepepo(@Param("u_no")String u_no);
		
		public List<Dorbed> findAll(@Param("pag")int pag,@Param("limt")int limt,@Param("b_no")String b_no,@Param("d_no")String d_no);
}

