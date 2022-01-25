package com.yidaye.domitory.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.yidaye.domitory.po.User;
import com.yidaye.domitory.service.DorbedService;
import com.yidaye.domitory.service.UserService;

import net.sf.json.JSONObject;

@RestController
@RequestMapping("/User")
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private DorbedService dorbedService;
	
	@RequestMapping("/findcoll")
	public List<Map<String,String>> findcoll(String b_no)
	{
		
		List<Map<String,String>> result=new ArrayList<Map<String,String>>();
		List<User> users=userService.findcoll(b_no);
		for (int i=0;i<users.size();i++)
		{
			Map<String,String> mapsi= new HashMap<String,String>();
			String value= Integer.toString(users.get(i).getU_id());
			
			mapsi.put("value", value);
			mapsi.put("name",users.get(i).getU_coll());
			result.add(mapsi);
		}
		
		
		
		return result;
	}
	
	@RequestMapping("/findAll")
	public JSONObject findAll(@RequestParam(value="page",defaultValue="1")int pag,
            @RequestParam(value="limit",defaultValue="5")int limit,String u_gra,String u_no,String u_name,String b_no) throws Exception
	{
		int start =(pag-1)*limit;
		JSONObject json = new JSONObject();
		List<User> users=new ArrayList<User>();
		users=userService.findAll(start, limit, u_gra, u_no, u_name,b_no);
		int count =userService.findAlltol(u_gra, u_no, u_name, b_no);
		json.put("msg", "success");
        json.put("code", "0");
        json.put("data", users);
        json.put("count", count);
		return json;
	}
	
	@RequestMapping("/find")
	public JSONObject find(@RequestParam(value="page",defaultValue="1")int pag,
                         @RequestParam(value="limit",defaultValue="5")int limit,String u_gra,String u_no,String u_name,String b_no)
	{
		System.out.println(u_gra);
		System.out.println(u_no);
		System.out.println(u_name);
		System.out.println(b_no);
		int start =(pag-1)*limit;
		JSONObject json = new JSONObject();
		List<User> users=new ArrayList<User>();
		users=userService.find(start, limit, u_gra, u_no, u_name,b_no);
		int count =userService.findtol(u_gra, u_no, u_name, b_no);
		json.put("msg", "success");
        json.put("code", "0");
        json.put("data", users);
        json.put("count", count);
		return json;
	}
	
	@RequestMapping("/updapass")
	public int updapass(int u_id,String u_pass)
	{
		return userService.updapass(u_id,u_pass);
	}
	
	@RequestMapping("/delete")
	public int delete(int u_id,String u_no)
	{
		dorbedService.updtuno(u_no);
		return userService.delete(u_id);
	}
	
	@RequestMapping("/login")
	public User login(String u_no,String u_pass)
	{
		return userService.login(u_no,u_pass);
	}
	
	@RequestMapping("/add")
	public int add(User user)
	{
		return userService.add(user);
	}
	
	@RequestMapping("/findbyno")
	public User findbyno(String u_no)
	{
		return userService.findbyno(u_no);
	}

	@RequestMapping("/import")
public JSONObject excelImport(MultipartFile file,HttpSession session){
		
      //	String fileName = file.getOriginalFilename();
		
		int result = 0;
		
		try {
			result = userService.addUser(file);
		} catch (Exception e) {
 
			e.printStackTrace();
		}
		

		JSONObject json = new JSONObject();
		json.put("msg", "success");
        json.put("code", "100");
        json.put("data", result);
		return json;
		
	}
	
	@RequestMapping("/update")
	public int update(User user)
  	{
  		return userService.update(user);
  	}
}
