<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% String ctx = application.getContextPath(); %>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>비밀번호 변경</title>
</head>
<body>
	<h3>비밀번호 변경</h3>
<form action="<%= ctx %>/member.do">
	ID:<input type="text" name="memid"/>
	PW:<input type="text" name="pass" />
	NEWPW:<input type="text" name="newpass"/>
	<input type="hidden" name="action" value="move"/>	
	<input type="hidden" name="page" value="update_result"/>
	<input type="submit" value="변경" />
</form>
</body>
</html>
