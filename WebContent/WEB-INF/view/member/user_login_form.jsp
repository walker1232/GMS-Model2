<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% String ctx = application.getContextPath(); %>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>user_login</title>
	<link rel="stylesheet" href="../../css/style.css" />
</head>
<body>
<div id="user-login-layout">
	<h1>로그인</h1>
	<form id="user-login-form" action="<%=ctx %>/member.do" >
	 아이디:<input type="text" name= "userid" /><br />
	 비밀번호:<input type="text" name= "password" /><br />
	 <input type="hidden" name="action" value="move"/>	
	<input type="hidden" name="page" value="login_result"/>
	 <input type="submit" value="전송" />
	</form>
	</div>
</body>
</html>