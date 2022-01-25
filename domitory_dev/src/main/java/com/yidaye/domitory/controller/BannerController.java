package com.yidaye.domitory.controller;

import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yidaye.domitory.po.Banner;
import com.yidaye.domitory.service.BannerService;

import net.sf.json.JSONObject;

@RestController
@RequestMapping("/banner")
public class BannerController {

	@Autowired
	private BannerService bannerService;
	
	@RequestMapping("/delete")
	public int delete(int id)
	{
		return bannerService.delete(id);
	}
	
	@RequestMapping("/add")
	public int add(Banner banner)
	{
		SimpleDateFormat tempDate = new SimpleDateFormat("yyyy-MM-dd");  
		String datetime = tempDate.format(new java.util.Date()); 
		banner.setDate(datetime);
		return bannerService.add(banner);
	}
	
	@RequestMapping("/find")
	public List<Banner> find(String b_no)
	{
		return bannerService.find(b_no);
	}
	
	@RequestMapping("/findAll")
	public JSONObject findAll(@RequestParam(value="page",defaultValue="1")int pag,
            @RequestParam(value="limit",defaultValue="5")int limit,String b_no,String date)
	{
		
		int start =(pag-1)*limit;
		JSONObject json = new JSONObject();
		List<Banner> banlist=bannerService.findAll(start, limit, b_no, date);
		int count = bannerService.findAlltol(b_no, date);
		 json.put("msg", "success");
        json.put("code", "0");
        json.put("data", banlist);
        json.put("count", count);
		
		return json;
	}
}
