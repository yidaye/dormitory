package com.yidaye.domitory.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yidaye.domitory.po.Ban;

public interface BanService {

	    //查询所有
		public List<Ban> findAll(int pag,int limt,String b_no,String b_sex);
		
		public List<Ban> find(String b_no);
		
		//查询楼栋总数
		public int findtol(String b_no,String b_sex);
		
		//修改
		public int update(Ban ban);
		
		//添加
		public int add(Ban ban);
		
		//删除
		public int delete(int b_id);
		
		//查询楼栋入住人数
		public int findrelpepo(String b_no);
		
		public int findpepo(String b_sex);
}
