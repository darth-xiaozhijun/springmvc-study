package com.geekshow.controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.geekshow.pojo.Users;
import com.geekshow.service.UsersService;


@Controller
public class UsersController {
	@Resource
	private UsersService usersServiceImpl;
	
	@RequestMapping("register")
	public String register(Users users,MultipartFile file,HttpServletRequest req){
		String fileName = UUID.randomUUID().toString()+file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
		String path = req.getServletContext().getRealPath("images")+"/"+fileName;
		try {
			FileUtils.copyInputStreamToFile(file.getInputStream(), new File(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		//只能取到webapps文件夹内容
		users.setPhoto(fileName);
		int index = usersServiceImpl.insRegister(users);
		if(index>0){
			req.getSession().setAttribute("user", users);
			return "redirect:/showFile";
		}else{
			return "redirect:/register.jsp";
		}
	}
	
	@RequestMapping("{page}")
	public String main(@PathVariable String page){
		System.out.println("restful");
		return page;
	}
	@RequestMapping("login")
	public String login(Users users,HttpSession session){
		if(users.getUsername().equals("admin")&&users.getPassword().equals("123")){
			session.setAttribute("users", users);
			return "main";
		}else{
			return "redirect:/login.jsp";
		}
	}
}
