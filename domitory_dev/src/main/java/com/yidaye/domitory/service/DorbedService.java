package com.yidaye.domitory.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yidaye.domitory.po.Dorbed;

public interface DorbedService {

	//根据条件查询
		public List<Dorbed> find( String b_no, String d_no);
		
		public int delepepo(String u_no);
		
		//删除
		public int delete( String b_no);
		
		//添加
		public int add(Dorbed dorbed);
		
		//查询入住人数
		public int findpepo(String b_no);
		
		//查询空余位置
			public int findkong(String b_no);

			//查询入住人数
			public int findwei();
			
			public int updtuno(String u_no);
			
			//查询空余床位
			public List<Integer> findkbed(String b_sex);
			
			//查询未分配人
			public List<String> findkpepo(String u_sex);
			
			//分配
			public int update(int id,String u_no);
			
			public int findAlltol(String b_no,String d_no);
			
			public List<Dorbed> findAll(int pag,int limt,String b_no,String d_no);
			
			public List<Integer> findk(String b_no,String d_no);
}
