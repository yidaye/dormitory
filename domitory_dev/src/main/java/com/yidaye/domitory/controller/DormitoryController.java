package com.yidaye.domitory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yidaye.domitory.dao.DorbedDao;
import com.yidaye.domitory.po.Dorbed;
import com.yidaye.domitory.po.Dormitory;
import com.yidaye.domitory.service.DorbedService;
import com.yidaye.domitory.service.DormitoryService;
import com.yidaye.domitory.service.impl.DorbedServiceImpl;

import net.sf.json.JSONObject;

@RestController
@RequestMapping("/dormitory")
public class DormitoryController {

	@Autowired
	private DormitoryService dormitoryService;
	@Autowired
	//private DorbedService dorbedService;
	private DorbedController dorbedContoller;

	
	@RequestMapping("/findAll")
	public JSONObject findAll(@RequestParam(value="page",defaultValue="1")int pag,
            @RequestParam(value="limit",defaultValue="5")int limit,String b_no,String d_no)
	{
		int start =(pag-1)*limit;
	    JSONObject json = new JSONObject();
	    
	    List<Dormitory> dormitories =dormitoryService.findAll(start,limit,b_no,d_no);
	    int count = dormitoryService.findtol(b_no, d_no);
	        json.put("msg", "success");
	        json.put("code", "0");
	        json.put("data", dormitories);
	        json.put("count", count);
	        

	    
	    return json;
	}
	
	@RequestMapping("/findbybno")
	public List<Dormitory> findbybno(String b_no)
	{
		return dormitoryService.findbybno(b_no);
	}
	
	@RequestMapping("/delete")
	public int delete(String b_no)
	{
		
		dorbedContoller.delete(b_no);
		return dormitoryService.delete(b_no);
	}
	
	@RequestMapping("/add")
	public int add(Dormitory dormitory)
	{
		System.out.println(dormitory.getB_no());
		return dormitoryService.add(dormitory);
	}
	
	@RequestMapping("/insert")
	public int insert(int hight,int dor_num,String pepole,String b_no)
	{
		int res=0;
		String d_no="";
		for (int i=1;i<=hight;i++)
		{
			for(int j=1;j<=dor_num;j++)
			{
				if(j<10)
					d_no=Integer.toString(i)+"0"+Integer.toString(j);
				else
					d_no=Integer.toString(i)+Integer.toString(j);
				
				
				dorbedContoller.insert(b_no, d_no, pepole);
				Dormitory dor =new Dormitory();
				dor.setB_no(b_no);
				dor.setD_pepole(pepole);
				dor.setD_no(d_no);
				int res1=dormitoryService.add(dor);
				res=res+res1;
				
			}
		}
		return res;
	}
	
	@RequestMapping("/update")
	public int update(Dormitory dormitory)
	{
		return dormitoryService.update(dormitory);
	}
}
