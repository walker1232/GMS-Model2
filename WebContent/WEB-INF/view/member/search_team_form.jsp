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
	<form id="search_team_form" >
		TeamName: <input type="text" name="teamid"> <input id="searchTeamBtn" type="submit" value="search" >
		<input type="hidden" name="action" value="search">
		<input type="hidden" name="page" value="search_team_rewult">
	</form>
<script>
	document.getElementById('searchTeamForm').addEventListener('click', function(){
		var form = document.getElementById('search_team_form');
		form.action = "${ctx}/member.do";
		form.method = "post";
		if(form.teamid.value == ""){
			alert('teamid를 공백으로 하면 안됩니다');
			document.teamid.focus();
		}
		form.submit();
	});
</script>
</body>
</html>