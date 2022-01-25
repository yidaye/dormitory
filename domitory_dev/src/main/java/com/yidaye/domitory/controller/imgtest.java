package com.yidaye.domitory.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import net.sf.json.JSONObject;

@RestController
public class imgtest {
 //绑定文件上传路径到uploadPath
	    private String uploadPath="D:/data/";

	    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd/");

	    
	    public String upload(MultipartFile uploadFile,
	                         HttpServletRequest request) throws Exception {

	        // 在 uploadPath 文件夹中通过日期对上传的文件归类保存
	        // 比如：/2019/06/06/cf13891e-4b95-4000-81eb-b6d70ae44930.png
	        String format = sdf.format(new Date());
	        File folder = new File(uploadPath + format);
	        if (!folder.isDirectory()) {
	            folder.mkdirs();
	        }
	        File path = new File(ResourceUtils.getURL("classpath:static").getPath());
	        System.out.println("path:"+path);
	        
	        String classpath1 = this.getClass().getResource("/").getPath(); 
			   System.out.println("classpath1"+classpath1);
	        // 对上传的文件重命名，避免文件重名
	        String oldName = uploadFile.getOriginalFilename();
	        String newName = UUID.randomUUID().toString()
	               + oldName.substring(oldName.lastIndexOf("."), oldName.length());
	
	        try {
	            // 文件保存
	            uploadFile.transferTo(new File(folder, newName));

	            // 返回上传文件的访问路径
	            String filePath = request.getScheme() + "://" + request.getServerName()
	                    + ":" + request.getServerPort()  + format + newName;
	            return filePath;
	        } catch (IOException e) {
	            throw new Exception(uploadPath);
	        }

	    }

	    @RequestMapping("/upload")
	    public String addUser(MultipartFile file,HttpServletRequest request) throws Exception {
			

			     
			    String uploadPath=this.getClass().getResource("/").toURI().getPath();//获取当前类的路径
			    String filepath=uploadPath.replaceAll("target/classes/", "src/main/resources/image/");
			    System.out.println(filepath);
			    File folder = new File(filepath);
		        
		        // 对上传的文件重命名，避免文件重名
		        String oldName = file.getOriginalFilename();
		        String newName = UUID.randomUUID().toString()
		               + oldName.substring(oldName.lastIndexOf("."), oldName.length());
		            // 文件保存
		             file.transferTo(new File(folder, newName));		            // 返回上传文件的访问路径
		            
		            String filePath = request.getScheme() + "://" + request.getServerName()
		                    + ":" + request.getServerPort() +"/image/"+  newName;
		            System.out.println(filePath);
		            return filePath;
		}
	    
	    @RequestMapping("/uploadimg")
	    public String uploadimg(MultipartFile[] file,HttpServletRequest request) throws Exception {
			
			for(int i=0;i<file.length;i++)
			{
				System.out.println(file[i]);
			}

           return "success";
		}
	    
	    @RequestMapping("/bannerimg")
	    public JSONObject bannerimg(MultipartFile file,HttpServletRequest request) throws Exception
	    {
	    	
	    	  SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd/");
			    String format = sdf.format(new Date());
			     
			    String uploadPath=this.getClass().getResource("/").toURI().getPath();//获取当前类的路径
			    String filepath=uploadPath.replaceAll("target/classes/", "src/main/resources/image/");
			    
			    File folder = new File(filepath);
		       // File folder = new File(uploadPath + format);
		       /* if (!folder.isDirectory()) {
		            folder.mkdirs();
		        }*/
		        /*
		        File path = new File(ResourceUtils.getURL("classpath:static").getPath());
		        System.out.println("path:"+path);获取静态资源路径*/
		        
		        // 对上传的文件重命名，避免文件重名
		        String oldName = file.getOriginalFilename();
		        String newName = UUID.randomUUID().toString()
		               + oldName.substring(oldName.lastIndexOf("."), oldName.length());
		
		     
		            // 文件保存
		             file.transferTo(new File(folder, newName));

		            // 返回上传文件的访问路径
		            
		            String filePath = request.getScheme() + "://" + request.getServerName()
		                    + ":" + request.getServerPort() +"/image/"+  newName;
		          

		            JSONObject json = new JSONObject();
		            JSONObject json1 = new JSONObject();
		            json1.put("src",filePath);
		            json.put("msg", "success");
		            json.put("code", "0");
		            json.put("data",json1 );
		    		
		    		return json;
		      
	    	
	    }
	    
}
