<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% String ctx = application.getContextPath(); %>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>팀명 찾기</title>
</head>
<body>
	<h3>팀이름 검색</h3>
	<form action="<%=ctx %>/member.do">
		팀이름:<input type="text" name="teamid"/> <input type="submit" value="검색"/> 
		<input type="hidden" name="action" value="move"/>	
		<input type="hidden" name="page" value="search_team_result"/>
	</form>
</body>
</html>