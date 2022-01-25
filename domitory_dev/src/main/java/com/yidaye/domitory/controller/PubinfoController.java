package com.yidaye.domitory.controller;

import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yidaye.domitory.po.Pubinfo;
import com.yidaye.domitory.service.PubinfoService;

import net.sf.json.JSONObject;

@RestController
@RequestMapping("/pubinfo")
public class PubinfoController {

	@Autowired
	private PubinfoService pubinfoService;
	
	@RequestMapping("/find")
	public JSONObject find(@RequestParam(value="page",defaultValue="1")int pag,
            @RequestParam(value="limit",defaultValue="5")int limit,String date)
	{
		int start =(pag-1)*limit;
	    JSONObject json = new JSONObject();
	    List<Pubinfo> pubinfos =pubinfoService.find(start, limit, date);
	    int count =pubinfoService.findtol(date);
        json.put("msg", "success");
        json.put("code", "0");
        json.put("data", pubinfos);
        json.put("count", count);
		return json;
	}
	
	@RequestMapping("/findm")
	public JSONObject findm(@RequestParam(value="page",defaultValue="1")int pag,
            @RequestParam(value="limit",defaultValue="5")int limit,String date,String a_no)
	{
		int start =(pag-1)*limit;
	    JSONObject json = new JSONObject();
	    List<Pubinfo> pubinfos =pubinfoService.findm(start, limit, date,a_no);
	    int count =pubinfoService.findmtol(date,a_no);
        json.put("msg", "success");
        json.put("code", "0");
        json.put("data", pubinfos);
        json.put("count", count);
		return json;
	}
	
	@RequestMapping("/findAll")
	public List<Pubinfo> findAll()
	{
		return pubinfoService.findAll();
	}
	
	@RequestMapping("/findmAll")
	public List<Pubinfo> findmAll(String b_no)
	{
		return pubinfoService.findmAll(b_no);
	}
	
	@RequestMapping("/add")
	public int add(Pubinfo pubinfo)
	{
		SimpleDateFormat tempDate = new SimpleDateFormat("yyyy-MM-dd");  
		String datetime = tempDate.format(new java.util.Date());  
		System.out.println(datetime);
		pubinfo.setDate(datetime);
		return pubinfoService.add(pubinfo);
	}
	
	@RequestMapping("/update")
	public int update(Pubinfo pubinfo)
	{
		return pubinfoService.update(pubinfo);
	}
	
	@RequestMapping("/delete")
	public int delete(int id)
	{
		return pubinfoService.delete(id);
	}
}
