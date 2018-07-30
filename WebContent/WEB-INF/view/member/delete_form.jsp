<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% String ctx = application.getContextPath(); %>
<jsp:include page="../common/head.jsp"/>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>삭제</title>
</head>
<body>
	<h3>삭제</h3>
<form id="delete_form">
	<input type="hidden" name="memid" value="${user.memID}">
	<input type="hidden" name="pass" value="${user.password}">
	<!-- ID: <input type="text" name="memid"><br />
	Pass: <input type="text" name="pass"><br /> -->
	<input type="hidden" name="action" value="delete"><br />
	<!-- <input type="hidden" name="page" value="delete_result"><br /> -->
	<input id="deleteFormBtn" type="submit" value="delete">
</form>
<script>
	/* documemnt.getElementById('deleteFormBtn').addEventListener('click', function(){
		var form = document.getElementById('delete_form');
		form.action = "${ctx}/member.do"
		form.method = "post";
		if(form.memid.value == ""){
			alert('id를 공백으로 하면 안됩니다');
			document.memid.focus();
		}else if(form.pass.value == ""){
			alert('pass를 공백으로 하면 안됩니다');
			document.pass.focus();
		}
		form.submit();
	}); */
	document.getElementById('deleteFormBtn').addEventListener('click', function(){
		alert('탈퇴확인 버튼 클릭함!!');
		var from = document.getElementById('delete_form');
		form.action = "${ctx}/member.do";
		form.method = "post";
		form.submit();
	});
</script>
</body>
</html>