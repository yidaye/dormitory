package com.yidaye.domitory.controller;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class xmlController {

	@RequestMapping("/xmlcon")
	public String xmlcon(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String xmlData="";
		InputStream sis = null;
		//编码格式改成UTF-8
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("textml; charset=UTF-8");
		response.setHeader("Content-type", "text/html;charset=UTF-8");
		
		sis=request.getInputStream();
		// 取HTTP请求流长度  
        int size = request.getContentLength();  
        
        // 用于缓存每次读取的数据  
        byte[] buffer = new byte[size];  
        // 用于存放结果的数组  
        byte[] xmldataByte = new byte[size];  
        int count = 0;  
        int rbyte = 0;  
        // 循环读取  
        
        
        while (count < size) {   
            // 每次实际读取长度存于rbyte中  
            rbyte = sis.read(buffer);   
            for(int i=0;i<rbyte;i++) {  
                xmldataByte[count + i] = buffer[i];  
            }  
            count += rbyte;  
        }
        xmlData = new String(xmldataByte, "UTF-8"); 
        System.out.println("接收的data为："+xmlData);
        return xmlData;
	}
	
}
