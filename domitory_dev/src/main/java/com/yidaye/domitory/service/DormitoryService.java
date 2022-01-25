package com.yidaye.domitory.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yidaye.domitory.po.Dormitory;

public interface DormitoryService {

	//根据楼栋号查询
		public List<Dormitory> findbybno(String b_no);
		
		//查询所有
		public List<Dormitory> findAll(int pag,int limit,String b_no,String d_no);
		//查询数量
		public int findtol(String b_no,String d_no);
		
		//修改
		public int update(Dormitory dormitory);
		
		//删除
		public int delete(String b_no);
		
		//添加
		public int add(Dormitory dormitory);
}
