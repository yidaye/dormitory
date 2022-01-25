package com.yidaye.domitory.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yidaye.domitory.dao.AdminDao;
import com.yidaye.domitory.po.Admin;
import com.yidaye.domitory.service.AdminService;

import jdk.internal.jline.internal.Log;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminDao adminDao;
	
	public Admin login(String a_no,String a_pass)
	{
	
	  return adminDao.login(a_no, a_pass);	
	}
}
