package com.yidaye.domitory.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yidaye.domitory.po.Dorrepair;
import com.yidaye.domitory.po.User;
import com.yidaye.domitory.service.DorrepairService;

import net.sf.json.JSONObject;

@RestController
@RequestMapping("/dorrepair")
public class DorrepairContoller {

	@Autowired
	private DorrepairService dorrepairService;
	
	@RequestMapping("/findtoday")
	public JSONObject findtoday(String b_no)
	{
		
		List<Integer> data1=new ArrayList<Integer>();
		List<Integer> data2=new ArrayList<Integer>();
		for(int i=0;i<7;i++)
		{
			SimpleDateFormat tempDate = new SimpleDateFormat("yyyyMMdd");  
			String datetime = tempDate.format(new java.util.Date());
			String date = Integer.toString((Integer.parseInt(datetime)-i)).substring(0,4)+"-"+
			              Integer.toString((Integer.parseInt(datetime)-i)).substring(4,6)+"-"+
					      Integer.toString((Integer.parseInt(datetime)-i)).substring(6,8);
			System.out.println(date);
			data1.add(dorrepairService.findtoday(date, b_no, "未解决"));
			data2.add(dorrepairService.findtoday(date, b_no, "已解决"));
		}
		
		
		JSONObject json = new JSONObject();
		json.put("err",data1);
		json.put("ok",data2);
		return json;
		
	}
	
	@RequestMapping("/findAll")
	public List<Dorrepair> findAll(String b_no)
	{
		return dorrepairService.findAll(b_no);
	}
	
	@RequestMapping("/add")
	public int add(Dorrepair dorrepair)
	{
		SimpleDateFormat tempDate = new SimpleDateFormat("yyyy-MM-dd");  
		String datetime = tempDate.format(new java.util.Date());  
		System.out.println(datetime);
		dorrepair.setDate(datetime);
		return dorrepairService.add(dorrepair);
	}
	
	@RequestMapping("/delete")
	public int delete(int id)
	{
		return dorrepairService.delete(id);
	}
	
	@RequestMapping("/update")
	public int update(Dorrepair dorrepair)
	{
		return dorrepairService.update(dorrepair);
	}
	
	@RequestMapping("/findbyuno")
	public List<Dorrepair> findbyuno(String u_no)
	{
		return dorrepairService.findbyuno(u_no);
	}
	
	@RequestMapping("/findbyid")
	public Dorrepair findbyid(int id)
	{
		return dorrepairService.findbyid(id);
	}
	
	@RequestMapping("/find")
	public JSONObject find(@RequestParam(value="page",defaultValue="1")int pag,
            @RequestParam(value="limit",defaultValue="5")int limit,String date ,String d_no,String state,String b_no)
	{
		if(state.equals("1"))
		{state="未解决";}else if(state.equals("2")){state="已解决";}
		System.out.println(state);
		int start =(pag-1)*limit;
		JSONObject json = new JSONObject();
		List<Dorrepair> dorrepairs=new ArrayList<Dorrepair>();
		dorrepairs=dorrepairService.find(start, limit, date, d_no, state, b_no);
		int count =dorrepairService.findtol(date, d_no, state, b_no);
		json.put("msg", "success");
        json.put("code", "0");
        json.put("data", dorrepairs);
        json.put("count", count);
		return json;
	}
	
	//修改状态
	@RequestMapping("/updastate")
	public int updastate(Dorrepair dorrepair)
	{
		System.out.println(dorrepair.getState());
		System.out.println(dorrepair.getId());
		return dorrepairService.updastate(dorrepair);
	}
			
			
}
