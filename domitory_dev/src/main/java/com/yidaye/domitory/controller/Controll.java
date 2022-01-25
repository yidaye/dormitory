package com.yidaye.domitory.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yidaye.domitory.po.User;

@Controller
public class Controll {

	@RequestMapping("/index")
	public String index()
	{
		return "index";
	}
	
	@RequestMapping("/index1")
	public String index1()
	{
		return "index1";
	}
	
	@RequestMapping("/login")
	public String login()
	{
		return "login";
	}
	
	@RequestMapping("/logintest")
	public String login(@ModelAttribute User user)
	{
		return "a";
	}
	
	@RequestMapping("/test")
	public String test()
	{
		
		return "logintest";
	}
}
