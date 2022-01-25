package com.yidaye.domitory.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yidaye.domitory.po.Ban;
import com.yidaye.domitory.service.BanService;

import net.sf.json.JSONObject;

@RestController
@RequestMapping("/ban")
public class BanController {

	@Autowired
	private BanService banService;
	
	@Autowired
	private DormitoryController dormitoryContoller;
	
   @RequestMapping("/findAll")
   public List<Ban> findAll(String b_no)
   {
	   return banService.find(b_no);
   }
	
	@RequestMapping("/findtol")
	public int findtol(String b_no,String b_sex)
	{
		return banService.findtol(b_no,b_sex);
	}
	
	@RequestMapping("/delete")
	public int delete(int b_id,String b_no)
	{
		System.out.println(b_no);
		dormitoryContoller.delete(b_no);
		return banService.delete(b_id);
	}
	
	@RequestMapping("/update")
	public int update(Ban ban)
	{
		return banService.update(ban);
	}
	
	@RequestMapping("/add")
	public int add(Ban ban)
	{   int hight=Integer.parseInt(ban.getB_hight());
	    int dor_num=Integer.parseInt(ban.getB_hight_dor());
	    String pepole =ban.getD_pepole();
	    String b_no =ban.getB_no();
	    
		dormitoryContoller.insert(hight, dor_num, pepole, b_no);
		return banService.add(ban);
	}
	





@RequestMapping("/find")

public JSONObject page_list(@RequestParam(value="page",defaultValue="1")int pag,
		                    @RequestParam(value="limit",defaultValue="5")int limit,String b_no,String b_sex) {
    
	if(b_sex.equals("1"))
	{
		b_sex="男寝";
	}else if(b_sex.equals("2"))
	{
		b_sex="女寝";
	}
	System.out.println(b_no);
	System.out.println(b_sex);
	int start =(pag-1)*limit;
    JSONObject json = new JSONObject();
    
    List<Ban> banlist =banService.findAll(start,limit,b_no,b_sex);
    int count =banService.findtol(b_no,b_sex);
        json.put("msg", "success");
        json.put("code", "0");
        json.put("data", banlist);
        json.put("count", count);
        

    
    return json;

}


  @RequestMapping("/findpepo")
  public List<Map<String,String>> findpepo()
  {
	  List<Map<String,String>> result=new ArrayList<Map<String,String>>();
	  String mtol=Integer.toString(banService.findpepo("男寝"));
	  String wtol=Integer.toString(banService.findpepo("女寝"));
	  Map<String,String> maps= new HashMap<String,String>();
	  Map<String,String> maps1= new HashMap<String,String>();
	  maps.put("name", "男寝");
	  maps.put("value", mtol);
	  maps1.put("name", "女寝");
	  maps1.put("value", wtol);
	  result.add(maps1);
	  result.add(maps);
	  return result;
  }

 @RequestMapping("/echart")
 public List<Map<String,String>> echart(String b_no)
 {
	 List<Map<String,String>> result=new ArrayList<Map<String,String>>();
	 List<Ban> bans=banService.find(b_no);
	 String pepole=bans.get(0).getB_pepole();
	 String rel_pepole=bans.get(0).getB_relpepo();
	 String k_pepole=Integer.toString(Integer.parseInt(pepole)-Integer.parseInt(rel_pepole));
	 Map<String,String> maps= new HashMap<String,String>();
	  Map<String,String> maps1= new HashMap<String,String>();
	  maps.put("name", "空余床位");
	  maps.put("value", k_pepole);
	  maps1.put("name", "入住人数");
	  maps1.put("value", rel_pepole);
	  result.add(maps1);
	  result.add(maps);
	 
	 return result;
 }
	
}
