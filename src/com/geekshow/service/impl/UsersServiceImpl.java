package com.geekshow.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.geekshow.mapper.UsersMapper;
import com.geekshow.pojo.Users;
import com.geekshow.service.UsersService;

@Service
public class UsersServiceImpl implements UsersService{
	@Resource
	private UsersMapper usersMapper;
	@Override
	public int insRegister(Users users) {
		return usersMapper.insUsers(users);
	}

}
