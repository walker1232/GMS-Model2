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

<form id="update_form" >
	ID: <input type="text" name="memid"/><br />
	Pass: <input type="text" name="pass"><br />
	NewPw: <input type="text" name="newpass"><br />
	<input type="hidden" name="action" value="update">
	<input type="hidden" name="page" value="update_result">
	<input id="updateFormBtn" type="submit" value="update">
</form>
<script>
	document.getElementById('update_form').addEventListener('click', function(){
		form.action = "${ctx}/member.do";
		form.method = "post";
		if(form.memid.value == ""){
			alert('id를 공백으로 하면 안됩니다');
			document.memid.focus();
		}else if(form.pass.value == ""){
			alert('pass를 공백으로 하면 안됩니다');
			document.pass.focus();
		}else if(form.newpass.value == ""){
			alert('newpass를 공백으로 하면 안됩니다');
			document.newpass.focus();
		}
		form.submit();
	});
</script>
</body>
</html>
