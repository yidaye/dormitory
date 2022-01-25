package com.yidaye.domitory.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yidaye.domitory.po.Dorbed;
import com.yidaye.domitory.po.Dorclean;
import com.yidaye.domitory.service.DorbedService;

import net.sf.json.JSONObject;

@RestController
@RequestMapping("/dorbed")
public class DorbedController {

	@Autowired
	public DorbedService dorbedService;
	
	@RequestMapping("/find")
	//根据条件查询
	public List<Dorbed> find( String b_no, String d_no)
	{
		return dorbedService.find(b_no, d_no);
	}
	
	@RequestMapping("/findAll")
	public JSONObject find(@RequestParam(value="page",defaultValue="1")int pag,
            @RequestParam(value="limit",defaultValue="5")int limt,String b_no,String d_no)
	{
		int start =(pag-1)*limt;
		JSONObject json = new JSONObject();
		List<Dorbed> dorbeds=new ArrayList<Dorbed>();
		dorbeds=dorbedService.findAll(start, limt, b_no, d_no);
		int count =dorbedService.findAlltol(b_no, d_no);
		json.put("msg", "success");
        json.put("code", "0");
        json.put("data", dorbeds);
        json.put("count", count);
		return json;
	}
	
	@RequestMapping("/delete")
	//删除
	public int delete( String b_no)
	{
		return dorbedService.delete(b_no);
	}
	
	@RequestMapping("/add")
	//添加
	public int add(Dorbed dorbed)
	{
		return dorbedService.add(dorbed);
	}
	
	@RequestMapping("/insert")
	public int insert(String b_no,String d_no,String pepole)
	{
		
		int res=0;
		int peo=Integer.parseInt(pepole);
		for(int i=1;i<=peo;i++)
		{
			Dorbed dorbed=new Dorbed();
			dorbed.setB_no(b_no);
			dorbed.setD_no(d_no);
			dorbed.setBed_no(Integer.toString(i));
			System.out.println(dorbed.getBed_no());
			dorbedService.add(dorbed);
		}
		
		
		return res;
	}
	
	@RequestMapping("/findpepo")
	//查询入住人数
	public int findpepo(String b_no)
	{
		return dorbedService.findpepo(b_no);
	}
	
	@RequestMapping("/findkong")
	//查询空余位置
		public int findkong(String b_no)
		{
			return dorbedService.findkong(b_no);
		}

	@RequestMapping("/findwei")
		//查询入住人数
		public int findwei()
		{
			return dorbedService.findwei();
		}
	
	@RequestMapping("/fenpeitol")
	public JSONObject fenpeitol()
	{
		JSONObject json = new JSONObject();
		List<String> unosm=dorbedService.findkpepo("男");
		List<String> unosw=dorbedService.findkpepo("女");
		List<Integer> idsm=dorbedService.findkbed("男寝");
		List<Integer> idsw=dorbedService.findkbed("女寝");
		json.put("man", unosm.size());
		json.put("woman", unosw.size());
		json.put("mandor", idsm.size());
		json.put("womandor", idsw.size());
		return json;
		
	}
	
	@RequestMapping("/fenpei")
	public int fenpei()
	{
		int resu=0;
		int m=0;
		int w=0;
		List<String> unosm=dorbedService.findkpepo("男");
		List<String> unosw=dorbedService.findkpepo("女");
		List<Integer> idsm=dorbedService.findkbed("男寝");
		List<Integer> idsw=dorbedService.findkbed("女寝");
		if(unosm.size()>idsm.size()) m=idsm.size(); else m=unosm.size();
		for(int i=0;i<m;i++)
		{
			dorbedService.update(idsm.get(i), unosm.get(i));
		}
		if(unosw.size()>idsw.size()) w=idsw.size(); else w=unosw.size();
		for(int i=0;i<w;i++)
		{
			dorbedService.update(idsw.get(i), unosw.get(i));
		}
		
		return resu;
	}
	
	@RequestMapping("/diaohuan")
	public int diaohuan(String d_no,String b_no,int id,String u_no)
	{
		int resu=1;
		
		List<Integer> idlist= dorbedService.findk(b_no, d_no);
		if(idlist.size()==0) return -1;
		
		dorbedService.updtuno(u_no);
		
		resu=dorbedService.update(idlist.get(0), u_no);
		
		
		return resu;
	}
	
	@RequestMapping("/delepepo")
	public int delepepo()
	{
		int res=0;
		List<String> unosm=dorbedService.findkpepo("男");
		List<String> unosw=dorbedService.findkpepo("女");
		for(int i=0;i<unosm.size();i++)
		{
			res++;
			dorbedService.delepepo(unosm.get(i));
		}
		for(int i=0;i<unosw.size();i++)
		{
			res++;
			dorbedService.delepepo(unosw.get(i));
		}
		
		return res;
	}
	
}
