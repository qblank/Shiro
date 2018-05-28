package cn.qblank.shiro.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.qblank.shiro.entity.User;
import cn.qblank.shiro.mapper.UserMapper;
import cn.qblank.shiro.service.UserService;
import tk.mybatis.mapper.common.Mapper;

@Service
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {
	@Autowired
	private UserMapper userMapper;

	public User findUserByUserName(String username) {
		return this.userMapper.getUserByUserName(username);
	}

	@Override
	protected Mapper<User> getMapper() {
		return this.userMapper;
	}
	
}
