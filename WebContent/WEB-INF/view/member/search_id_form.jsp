<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% String ctx = application.getContextPath(); %>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>Document</title>
</head>
<body>
	<h3>아이디 검색</h3>
	<form action="<%=ctx %>/member.do">
		아이디 <input type="text" name="memid"/> <input type="submit" value="찿기"/>
		<input type="hidden" name="action" value="searchMemberById"/>	
		<input type="hidden" name="page" value="search_id_result"/>
	</form>
</body>
</html>