package cn.qblank.shiro.service;

import cn.qblank.shiro.entity.User;

public interface UserService extends BaseService<User>{
	User findUserByUserName(String username);
}
