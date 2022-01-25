package com.yidaye.domitory.controller;



import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yidaye.domitory.po.Dorremark;
import com.yidaye.domitory.service.DorremarkService;

import net.sf.json.JSONObject;

@RestController
@RequestMapping("/dorremark")
public class DorremarkController {

	@Autowired
	private DorremarkService dorremarkService;
	
	@RequestMapping("/add")
	public int add(Dorremark dorremark)
	{
		SimpleDateFormat tempDate = new SimpleDateFormat("yyyy-MM-dd");  
		String datetime = tempDate.format(new java.util.Date());
		dorremark.setDate(datetime);
		return dorremarkService.add(dorremark);
	}
	
	@RequestMapping("/delete")
	public int delete(int id)
	{
		return dorremarkService.delete(id);
	}
	
	@RequestMapping("/find")
	public JSONObject find(@RequestParam(value="page",defaultValue="1")int pag,
            @RequestParam(value="limit",defaultValue="5")int limt,String date,String b_no)
	{
		int start =(pag-1)*limt;
		JSONObject json = new JSONObject();
		List<Dorremark> dorbeds = dorremarkService.find(start, limt, date,b_no);
		int count  =dorremarkService.findtol(date,b_no);
		json.put("msg", "success");
        json.put("code", "0");
        json.put("data", dorbeds);
        json.put("count", count);
		return json;
	}
	
	@RequestMapping("/findtol")
	public int findtol(String b_no,String date)
	{
		return dorremarkService.findtol(date, b_no);
	}

}
