package com.geekshow.mapper;

import java.util.List;

import com.geekshow.pojo.Menu;

public interface MenuMapper {
	List<Menu> selByPid(int pid);
}
