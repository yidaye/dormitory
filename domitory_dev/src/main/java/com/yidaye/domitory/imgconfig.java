package com.yidaye.domitory;

import java.net.URISyntaxException;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class imgconfig implements WebMvcConfigurer{

	
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		/*
		String path="";
		try {
			String uploadPath=this.getClass().getResource("/").toURI().getPath();//获取当前类的路径
		    String filepath=uploadPath.replaceAll("target/classes/", "src/main/resources/image/");
			path=filepath;
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		registry.addResourceHandler("/image/**").addResourceLocations("file:"+path);
    */
    }

}
