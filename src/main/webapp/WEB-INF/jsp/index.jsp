<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录成功</title>
</head>
<body>
	<h3>登录成功!!!</h3>
	<button id="quit">退出</button>
</body>
<script type="text/javascript">
	var quit = document.getElementById("quit");
	quit.onclick = function(){
		window.location.href = "/Shiro/quit";
	}
</script>
</html>