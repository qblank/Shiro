package cn.qblank.shiro.realm;

import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import cn.qblank.shiro.entity.User;
import cn.qblank.shiro.service.UserService;

public class CustomRealm extends AuthorizingRealm {
	@Autowired
	private UserService userService;

	/**
	 * 授权
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
		System.out.println("授权");
		return null;
	}
	
	/**
	 * 认证
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
		
		//令牌——基于用户名和密码的令牌    
        UsernamePasswordToken token = (UsernamePasswordToken) authcToken;  
        //从令牌中取出用户名
        String userName = token.getUsername();
		
		//通过用户名查找用户是否存在
		/*User user = isExist(permissionList, userName);*/
        User user = userService.findUserByUserName(userName);
		if (user == null) {
			return null;
		}
		//用Shiro框架去验证账号密码
		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user,user.getPwd(),this.getName());
		
		return info;
	}

}
