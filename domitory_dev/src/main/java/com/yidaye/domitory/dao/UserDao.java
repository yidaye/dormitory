package com.yidaye.domitory.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yidaye.domitory.po.User;

public interface UserDao {
    
	public List<User> findcoll(@Param("b_no") String b_no);
	
	public List<User> findAll(@Param("pag")int pag,@Param("limt")int limt,@Param("u_gra")String u_gra,@Param("u_no")String u_no,@Param("u_name")String u_name,@Param("b_no")String b_no);
	
	public int findAlltol(@Param("u_gra")String u_gra,@Param("u_no")String u_no,@Param("u_name")String u_name,@Param("b_no")String b_no);
	
	
	//根据条件查询
	public List<User> find(@Param("pag")int pag,@Param("limt")int limt,@Param("u_gra")String u_gra,@Param("u_no")String u_no,@Param("u_name")String u_name,@Param("b_no")String b_no);
    
	//根据条件查询条数
		public int findtol(@Param("u_gra")String u_gra,@Param("u_no")String u_no,@Param("u_name")String u_name,@Param("b_no")String b_no);
	    
	//重置密码
	public int updapass(@Param("u_id")int u_id,@Param("u_pass") String u_pass);
	
	//删除
	public int delete (@Param("u_id")int u_id);
	
	//登录
	public User login(@Param("u_no")String u_no,@Param("u_pass")String u_pass);
	
	//添加
	public int add(User user);
	
	//根据学号查询
	public User findbyno(@Param("u_no")String u_no);
	
	public int update(User user);
}
