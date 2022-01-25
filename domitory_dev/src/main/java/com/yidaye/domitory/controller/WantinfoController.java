package com.yidaye.domitory.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yidaye.domitory.po.Dorrepair;
import com.yidaye.domitory.po.Wantinfo;
import com.yidaye.domitory.service.WantinfoService;

import net.sf.json.JSONObject;

@RestController
@RequestMapping("/wantinfo")
public class WantinfoController {

	@Autowired
	private WantinfoService wantinfoService;
	
	@RequestMapping("/findAll")
	public List<Wantinfo> findAll()
	{
		return wantinfoService.findAll();
	}
	
	@RequestMapping("/update")
	//修改缺勤信息
	public int update(Wantinfo wantinfo)
	{
		return wantinfoService.update(wantinfo);
	}
	
	@RequestMapping("/findbyuno")
	public List<Wantinfo> findbyuno(String u_no)
	{
		SimpleDateFormat tempDate = new SimpleDateFormat("yyyyMMdd");  
		String startdate = tempDate.format(new java.util.Date());  
		String enddate =Integer.toString(Integer.parseInt(startdate)-6);
		 List<Wantinfo> list= wantinfoService.findbyuno(u_no, startdate, enddate);
		 List<Wantinfo> wantinfo =new ArrayList<Wantinfo>();
		 
          for(int i=0;i<list.size();i++)
          {
        	  Wantinfo want=new Wantinfo();
        	  String datetime = list.get(i).getDate().substring(list.get(i).getDate().length()-4,list.get(i).getDate().length()-2)+"-"+list.get(i).getDate().substring(list.get(i).getDate().length()-2);
        	  want.setDate(datetime);
        	  want.setId(list.get(i).getId());
        	  want.setM_no(list.get(i).getM_no());
        	  want.setRemark(list.get(i).getRemark());
        	  want.setU_no(list.get(i).getU_no());
        	  wantinfo.add(want);
          }
              
		return wantinfo;
	}
	
	@RequestMapping("/findbymno")
	public List<Wantinfo> findbymno(String m_no)
	{
		return wantinfoService.findbymno(m_no);
	}
	
	@RequestMapping("/delete")
	public int delete(int id)
	{
		return wantinfoService.delete(id);
	}
	
	@RequestMapping("/add")
	public int add(Wantinfo wantinfo)
	{
		SimpleDateFormat tempDate = new SimpleDateFormat("yyyy-MM-dd");  
		String datetime = tempDate.format(new java.util.Date());  
		System.out.println(datetime);
		wantinfo.setDate(datetime);
		return wantinfoService.add(wantinfo);
	}
	
	//根据条件查询
	@RequestMapping("/find")
	public JSONObject find(@RequestParam(value="page",defaultValue="1")int pag,
            @RequestParam(value="limit",defaultValue="5")int limit,String date ,String u_no,String m_no)
	{
		int start =(pag-1)*limit;
		JSONObject json = new JSONObject();
		List<Wantinfo> wantinfos=new ArrayList<Wantinfo>();
		wantinfos=wantinfoService.find(start, limit, date, u_no, m_no);
		int count =wantinfoService.findtol(date, u_no, m_no);
		json.put("msg", "success");
        json.put("code", "0");
        json.put("data", wantinfos);
        json.put("count", count);
		return json;
	}
	
	@RequestMapping("/findcount")
	public int  findcount(String date,String u_no,String m_no)
	{
		SimpleDateFormat tempDate = new SimpleDateFormat("yyyy-MM-dd");  
		String datetime = tempDate.format(new java.util.Date());  
		date = datetime;
		return wantinfoService.findtol(date, u_no, m_no);
	}
}
