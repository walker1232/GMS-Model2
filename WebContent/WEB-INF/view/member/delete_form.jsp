<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% String ctx = application.getContextPath(); %>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>삭제</title>
</head>
<body>
	<h3>삭제</h3>
	<form action="<%= ctx %>/member.do">
	ID:<input type="text" name="memid"/>
	PW:<input type="text" name="pass" />
	<input type="hidden" name="action" value="move"/>	
	<input type="hidden" name="page" value="delete_result"/>
	<input type="submit" value="삭제"/>
</form>
</body>
</html>