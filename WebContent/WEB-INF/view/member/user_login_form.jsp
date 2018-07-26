<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% String ctx = application.getContextPath(); %>
<!doctype html>
<html lang="en">
	<jsp:include page="../common/head.jsp"/>
<!-- <head>
	<meta charset="UTF-8" />
	<title>user_login</title>
	<link rel="stylesheet" href="../../css/style.css" />
</head> -->
<body>
<div id="user-login-layout">
	<h1>로그인</h1>
	<form id="user_login_form">
		아이디: <input type="text" name="memid">
		비밀번호: <input type="text" name= "pass">
		<input id="loginFormBtn" type="button" value="Login">
		<input type="hidden" name="action" value="login">
		<input type="hidden" name="page" value="mypage2">
	</form>
	</div>
	<script>
	/* mem.setMemid('유효성 체크할 아이디는 hong 이야');
 	alert('유효성 체크값: '+mem.loginValidation()); */
 	document.getElementById('loginFormBtn').addEventListener('click', function(){
 		var member = new Member();
 		var form = document.getElementById('user_login_form');
 		form.action = "${ctx}/member.do";
 		form.method = "post";
 		var memid = form.memid.value;
 		var pass = form.pass.value;
 		member.setMemid(memid);
 		member.setPassword(pass);
 		if(service.loginValidation(member)){
 			form.submit();
 		}
 		/* alert('입력한 ID'+memid); */
 		/* form.submit(); */
 	});
	</script>
</body>
</html>