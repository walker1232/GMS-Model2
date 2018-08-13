<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% String ctx = application.getContextPath(); %>

	<div id="content">
		<%-- <jsp:include page="../common/content_box.jsp"/> --%>
		<form id="user_login_form" name="user_login_form">
		<font color="black">아이디: </font><input type="text" name="memid">
		<font color="black">비밀번호: </font><input type="text" name= "pass">
		<input id="loginFormBtn" type="button" value="Login">
		<input type="hidden" name="action" value="login">
		<!-- <input type="hidden" name="page" value="mypage2"> -->
	</form>
	</div> <!-- content end -->
	

	<script>
	/* mem.setMemid('유효성 체크할 아이디는 hong 이야');
 	alert('유효성 체크값: '+mem.loginValidation()); */
 	document.getElementById('loginFormBtn').addEventListener('click', function(){
 		var x = service.nullChecker([document.user_login_form.memid.value, document.user_login_form.pass.value]);
 		if(x.checker){
 			var form = document.getElementById('user_login_form');
 			form.action = "${ctx}/member.do";
 	 		form.method = "post";
 			form.submit();
 		}else{
 			alert(x.text);
 		}
 		/* alert('입력한 ID'+memid); */
 		/* form.submit(); */
 	});
	</script>
