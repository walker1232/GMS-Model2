<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import ="domain.*" %>
<% String ctx = application.getContextPath(); %>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>Document</title>
	<link rel="stylesheet" href="../../css/style.css" />
</head>
<body>
	<%-- <form action="<%=ctx%>/member.do">
		<input type="hidden" name="action" value="list"/>	
		<input type="hidden" name="page" value="member_list"/>
		<input type="submit" value="목록"/>
	</form> --%>
	<form action="${ctx}/member.do" onsubmit="return trans()" method="get">
		<input type="hidden" name="action" value="list">
		<input type="hidden" name="page" value="member_list">
		<input type="submit" name="list">
	</form>
</body>
</html>
