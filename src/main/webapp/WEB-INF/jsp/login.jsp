<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录界面</title>
</head>
<body>
	<h3>登录</h3>
	<form action="/Shiro/index" method="POST">
		<table>
		<tr>
			<td>用户名</td>
			<td><input type="text" name="username" /></td>
		</tr>	
		<tr>
			<td>密码</td>
			<td><input type="password" name="pwd" /></td>
		</tr>	
		<tr>
			<td><input type="submit" value="提交"></td>
		</tr>
	</table>
	</form>
	<span style="color:red;">${loginErr }</span>
</body>
</html>