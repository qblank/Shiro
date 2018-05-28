package cn.qblank.shiro.mapper;


import cn.qblank.shiro.entity.User;
import tk.mybatis.mapper.common.Mapper;

public interface UserMapper extends Mapper<User>{
	User getUserByUserName(String username);
}
