package com.yidaye.domitory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yidaye.domitory.po.Manager;
import com.yidaye.domitory.service.ManagerService;

import net.sf.json.JSONObject;

@RestController
@RequestMapping("/manager")
public class ManagerController {
	
	@Autowired
	private ManagerService managerService;
	
	@RequestMapping("/findAll")
	public JSONObject findAll(@RequestParam(value="page",defaultValue="1")int pag,
             @RequestParam(value="limit",defaultValue="5")int limit,String m_no,String m_name,String b_no)
	{
		int start =(pag-1)*limit;
		JSONObject json = new JSONObject();
		List<Manager> managerlist =managerService.findAll(start,limit,m_no,m_name,b_no);
		int count =managerService.findAlltol(m_no, m_name, b_no);
		json.put("msg", "success");
        json.put("code", "0");
        json.put("data", managerlist);
        json.put("count", count);
		
		return json;
	}
	
	
	@RequestMapping("/delete")
	public int delete(int m_id)
	{
		return managerService.delete(m_id);
	}
	
	@RequestMapping("/add")
	public int add(Manager manager)
	{
		System.out.println(manager.getB_no());
		return managerService.add(manager);
	}
	
	@RequestMapping("/updapass")
	public int updapass(int m_id,String m_pass)
	{
		return managerService.updapass(m_id,m_pass);
	}
	@RequestMapping("/findtol")
	public int findtol()
	{
		return managerService.findtol();
	}

	@RequestMapping("/login")
	public Manager login(String m_no ,String m_pass)
	{
		return managerService.login(m_no, m_pass);
	}
	
	@RequestMapping("/update")
	public int update(Manager manager)
	{
		return managerService.update(manager);
	}
	
}
