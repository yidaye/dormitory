package com.yidaye.domitory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yidaye.domitory.po.Admin;
import com.yidaye.domitory.service.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private AdminService adminService;
	@RequestMapping("/login")
	public Admin login(String a_no,String a_pass)
	{
		return adminService.login(a_no, a_pass);
	}
}
