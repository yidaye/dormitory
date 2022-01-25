package com.yidaye.domitory.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.web.multipart.MultipartFile;

import com.yidaye.domitory.po.User;

public interface UserService {

	public List<User> findcoll(String b_no);
	
	public List<User> findAll(int pag,int limt,String u_gra,String u_no,String u_name,String b_no);
	
	public int findAlltol(String u_gra,String u_no,String u_name,String b_no);
	
    //登录
	public User login (String u_no,String u_pass);
	
	//根据条件查询
	public List<User> find(int pag,int limt,String u_gra,String u_no,String u_name,String b_no);
	
	//根据条件查询条数
			public int findtol(String u_gra,String u_no,String u_name,String b_no);
		    
	
	//重置密码
    public int updapass(int u_id,String u_pass);
    
  //删除
  	public int delete (int u_id);
	
	//添加用户信息
	public int add(User user);
	
	//根据学号查询
	public User findbyno(String u_no);

	public int addUser(MultipartFile file) throws Exception;
	
	public int update(User user);
}
