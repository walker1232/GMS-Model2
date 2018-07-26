<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% String ctx = application.getContextPath(); %>
<!-- memID, teamID, name, 800101-1, roll, password -->
<!doctype html>
<html lang="en">
	<jsp:include page="../common/head.jsp"/>
<!-- <head>
	<meta charset="UTF-8" />
	<title>회원가입화면</title>
</head> -->
<body>
	<h1>회원가입</h1>
	<form id="join_form" >
		ID: <input type="text" name="memid"><br />
		Name: <input type="text" name="name"><br />
		Pass: <input type="text" name="pass"><br />
		Ssn : <input type="text" name="ssn"><br />
		<input type="hidden" name="action" value="join">
		<input type="hidden" name="page" value="join_result">
		<input id="JoinFormBtn" type="submit" value="Join">
	</form>
	<script>
		document.getElementById('JoinFormBtn').addEventListener('click', function(){
			alert('조인 클릭 내부');
			var form = document.getElementById('join_form');
			form.action = "${ctx}/member.do";
			form.method = "post";
			if(form.memid.value == ""){
				alert('id를 공백으로 하면 안됩니다');
			}else if(form.pass.value == ""){
				alert('pass를 공백으로 하면 안됩니다');
				document.pass.focus();
			}else if(form.name.value == ""){
				alert('name를 공백으로 하면 안됩니다');
				document.name.focus();
			}else if(form.ssn.value == ""){
				alert('ssn를 공백으로 하면 안됩니다');
				document.ssn.focus();
			}
			form.submit();
		});
	</script>
</body>
</html>