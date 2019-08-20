package com.geekshow.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.geekshow.mapper.FilesMapper;
import com.geekshow.pojo.Files;
import com.geekshow.pojo.Users;
import com.geekshow.service.FilesService;

@Service
public class FileServiceImpl implements FilesService {
	@Resource
	private FilesMapper filesMapper;

	@Override
	public List<Files> show() {
		return filesMapper.selAll();
	}

	@Override
	public int updCount(int id,Users users,String name) {
		Logger logger = Logger.getLogger(FileServiceImpl.class);
		logger.info(users.getUsername()+"下载了"+name);
		return filesMapper.updCountById(id);
	}
	
	
}
