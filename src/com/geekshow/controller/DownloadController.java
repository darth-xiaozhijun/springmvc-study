package com.geekshow.controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class DownloadController {

	@RequestMapping("download")
	public void download(String fileName,HttpServletResponse res,HttpServletRequest req) throws IOException{
		//设置响应流中文件进行下载
		res.setHeader("Content-Disposition", "attachment;filename="+fileName);
		//把二进制流放入到响应体中.
		ServletOutputStream os = res.getOutputStream();
		String path = req.getServletContext().getRealPath("files");
		System.out.println(path);
		File file = new File(path, fileName);
		byte[] bytes = FileUtils.readFileToByteArray(file);
		os.write(bytes);
		os.flush();
		os.close();
	}
	
	@RequestMapping("upload")
	public String upload(MultipartFile file,String name) throws IOException{
		String fileName = file.getOriginalFilename();
		String suffix = fileName.substring(fileName.lastIndexOf("."));
		//判断上传文件类型
		if(suffix.equalsIgnoreCase(".png")){
			String uuid = UUID.randomUUID().toString();
			FileUtils.copyInputStreamToFile(file.getInputStream(), new File("E:/"+uuid+suffix));
			return "/index.jsp";
		}else{
			return "error.jsp";
		}
	}
}
