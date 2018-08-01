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
	<form id="search_id_form" >
		ID: <input type="text" name="memid"> <input id="searchIdBtn" type="submit" value="search">
		<input type="hidden" name="action" value="retrieve">
		<input type="hidden" name="page" value="search_id_result">
	</form>
<script>
	document.getElementById('searchIdBtn').addEventListener('click', function(){
		var form = document.getElementById('search_id_form');
		form.action = "${ctx}/member.do";
		form.method = "post";
		if(form.memid.value == ""){
			alert('id를 공백으로 하면 안됩니다');
			document.memid.focus();
		}
		form.submit();
	});
</script>
</body>
</html>