package com.yidaye.domitory.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yidaye.domitory.po.Dorclean;
import com.yidaye.domitory.po.Dorrepair;
import com.yidaye.domitory.service.DorcleanService;

import net.sf.json.JSONObject;

@RestController
@RequestMapping("/dorclean")
public class DorcleanController {

	@Autowired
	private DorcleanService dorcleanService;
	
	@RequestMapping("/findAll")
	public List<Dorclean> findAll(String b_no)
	{
		return dorcleanService.findAll(b_no);
	}
	
	@RequestMapping("/findbydno")
	public List<Dorclean> findbydno(String b_no,String d_no)
	{
		List<Dorclean> dorclean = new ArrayList<Dorclean>();
		dorclean=dorcleanService.findbydno(b_no, d_no);
		List<Dorclean> dorclean1 =new ArrayList<Dorclean>();
		dorclean = dorcleanService.findbydno(b_no, d_no);
		int j=0;
		if(dorclean.size()>7) j=7; else j=dorclean.size();
		for(int i=0 ;i<j;i++)
		{
			
			String datetime=dorclean.get(i).getDate().substring(dorclean.get(i).getDate().length()-5);
			dorclean.get(i).setDate(datetime);
			dorclean1.add(dorclean.get(i));
		}
		return dorclean1;
	}
	
	@RequestMapping("/add")
	public int add(Dorclean dorclean)
	{
		SimpleDateFormat tempDate = new SimpleDateFormat("yyyy-MM-dd");  
		String datetime = tempDate.format(new java.util.Date()); 
		dorclean.setDate(datetime);
		return dorcleanService.add(dorclean);
	}
	
	@RequestMapping("/find")
	//根据条件查
			public JSONObject find(@RequestParam(value="page",defaultValue="1")int pag,
		            @RequestParam(value="limit",defaultValue="5")int limit,String date,String b_no,String d_no)
			{
		int start =(pag-1)*limit;
		JSONObject json = new JSONObject();
		List<Dorclean> dorcleans=new ArrayList<Dorclean>();
		dorcleans=dorcleanService.find(start, limit, date, b_no, d_no);
		int count =dorcleanService.findtol(date, b_no, d_no);
		json.put("msg", "success");
        json.put("code", "0");
        json.put("data", dorcleans);
        json.put("count", count);
		return json;
			}
	
	@RequestMapping("/delete")
	//删除
	public int delete(int id)
	{
		return dorcleanService.delete(id);
	}
	
	@RequestMapping("/piadd")
	public int piadd(String b_no)
	{
		SimpleDateFormat tempDate = new SimpleDateFormat("yyyy-MM-dd");  
		String date = tempDate.format(new java.util.Date()); 
		//String date ="2021-05-23";
		int resu=0;
		List<String> dnolist=dorcleanService.findnocl(b_no,date);
		Dorclean dorclean =new Dorclean();
		for (int i=0;i<dnolist.size();i++)
		{
			
			dorclean.setB_no(b_no);
			dorclean.setD_no(dnolist.get(i));
			dorclean.setRemark("");
			dorclean.setSisuation("合格");
			dorclean.setDate(date);
			dorcleanService.add(dorclean);
			resu++;
		}
		
		return resu;
	}
	
	@RequestMapping("/update")
	public int update(Dorclean dorclean)
	{
		return dorcleanService.update(dorclean);
	}
	
	
}
