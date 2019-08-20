package com.geekshow.controller;

import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 四大作用域
 * @author Administrator
 *
 */
@Controller
public class ScopeController {

	@RequestMapping("scope1")
	public String scope1(HttpServletRequest abc,HttpSession sessionParam){
		//request 作用域
		abc.setAttribute("req", "req 的值");
		//session 作用域
		HttpSession session = abc.getSession();
		session.setAttribute("session", "session 的值");
		sessionParam.setAttribute("sessionParam","sessionParam 的值");
		//appliaction 作用域
		ServletContext application = abc.getServletContext();
		application.setAttribute("application","application 的值");
		return "scope.jsp";
	}
	
	@RequestMapping("scope2")
	public String scope2(Map<String,Object> map){
		System.out.println(map.getClass());
		map.put("map","map 的值");
		return "scope.jsp";
	}
	
	@RequestMapping("scope3")
	public String scope3(Model model){
		model.addAttribute("model", "model 的值");
		return "scope.jsp";
	}
	
	@RequestMapping("scope4")
	public ModelAndView scope4(){
		//参数,跳转视图
		ModelAndView mav = new ModelAndView("scope.jsp");
		mav.addObject("mav", "mav 的值");
		return mav;
	}
}
