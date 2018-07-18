<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% String ctx = application.getContextPath(); %>
<!-- memID, teamID, name, 800101-1, roll, password -->
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>회원가입화면</title>
</head>
<body>
	<form action="<%=ctx %>/member.do">
		아이디:<input type="text" name="memid"/><br />
		이름:<input type="text" name="name"/><br />
		비밀번호:<input type="text" name="pass"/><br />
		주민번호:<input type="text" name="ssn" /><br />
		<input type="hidden" name="action" value="join"/>	
		<input type="hidden" name="page" value="join_result"/>
		<input type="submit" value="가입" />
	</form>
	
</body>
</html>