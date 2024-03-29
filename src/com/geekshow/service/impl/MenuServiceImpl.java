package com.geekshow.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.geekshow.mapper.MenuMapper;
import com.geekshow.pojo.Menu;
import com.geekshow.service.MenuService;


@Service
public class MenuServiceImpl implements MenuService {
	@Resource
	private MenuMapper menuMapper;

	@Override
	public List<Menu> show() {
		return menuMapper.selByPid(0);
	}
}
