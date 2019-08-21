package com.geekshow.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InterceptController {

	@RequestMapping("intercept")
	public String intercept(Model model){
		System.out.println("执行intercept");
//		int i = 5/0;
		model.addAttribute("model", "我们都爱祖国.");
		return "index.jsp";
	}
}
