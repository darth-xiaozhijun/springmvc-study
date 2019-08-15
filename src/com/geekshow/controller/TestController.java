package com.geekshow.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

	@RequestMapping("demo")
	public String demo(String name,int age){
		
		System.out.println("执行demo"+" "+name+" "+age);
		return "main.jsp";
	}
	
	@RequestMapping("demo2")
	public String demo2(){
		System.out.println("demo2");
		return "main1.jsp";
	}
}
