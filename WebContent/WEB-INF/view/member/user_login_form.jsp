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
	 아이디:<input type="text" name= "memid" /><br />
	 비밀번호:<input type="text" name= "pass" /><br />
	 <input type="hidden" name="action" value="login"/>	
	<input type="hidden" name="page" value="mypage2"/>
	 <input type="submit" value="로그인" />
	</form>
	</div>
</body>
</html>