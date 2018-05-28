package cn.qblank.shiro.entity;

import java.io.Serializable;

import javax.persistence.Entity;

/**
 * 用户类
 * @author evan_qb
 *
 */
@Entity(name = "t_user")
public class User implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String userName;
	private String pwd;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public User(String userName, String pwd) {
		this.userName = userName;
		this.pwd = pwd;
	}
	public User() {
	}
	
	@Override
	public String toString() {
		return "User [userName=" + userName + ", pwd=" + pwd + "]";
	}
	
}
