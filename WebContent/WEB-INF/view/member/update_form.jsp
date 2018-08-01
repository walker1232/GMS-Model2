<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% String ctx = application.getContextPath(); %>
<jsp:include page="../common/head.jsp"/>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>비밀번호 변경</title>
	<style>
	table, th, td {
    border: 1px solid black;
}
</style>
</head>
<body>
<div id="wrapper">
	<div id="header">
		<jsp:include page="../common/title_box.jsp"/>
		<jsp:include page="../common/login_box.jsp"/>
		<jsp:include page="../common/menu_box.jsp"/>
	</div> <!-- header end -->
	<div id="content">
	<form id="update_form" >
	<table style="width:50%">
	<tr>
		<td rowspan="3"></td>
		<td>아아디</td>
		<td colspan="2">${user.memID}</td>
	</tr>
	<tr>
		<td>이름</td>
		<td >${user.name}</td>
	</tr>
	<tr>
		<td>비번</td>
		<td ><input type="text" name="pass" placeholder="****"></td>
	</tr>
	<tr>
		<td>나이</td>
		<td>${user.age}</td>
		<td>팀명</td>
		<td>${user.teamID}</td>
		<td>
			<input type="radio" id="teamid_1" name="teamid" value="none" checked="checked"/>없음
			<input type="radio" id="teamid_2" name="teamid" value="nolja"/>걍놀자
			<input type="radio" id="teamid_3" name="teamid" value="jieunHouse"/>지은이네
			<input type="radio" id="teamid_4" name="teamid" value="turtleKing"/>터틀킹
			<input type="radio" id="teamid_5" name="teamid" value="codingZzang"/>코딩짱
		</td>
	</tr>
	<tr>
		<td>성별</td>
		<td>${user.gender}</td>
		<td>역할</td>
		<td>${user.roll}</td>
		<td>
			<select name="roll" id="roll">
				<option value="leader" selected="selected">팀장</option>
				<option value="front">프론트개발</option>
				<option value="back">백단개발</option>
				<option value="android">안드로이드개발</option>
				<option value="minfe">민폐</option>
			</select>
		</td>
	</tr>
</table>
	<input type="button" id="updateConfirmBtn" value="수정확인"/>
</form>
	</div> <!-- content end -->
	<div id ="footer">
		<jsp:include page="../common/footer_box.jsp"/>
	</div>
</div>
	<h3>비밀번호 변경</h3>


<script>
    var form = document.getElementById('update_form');
    var roll = document.getElementById("roll");
    for(var i = 0; i < roll.options.length; i++){
    	if(roll.options[i].value === '${user.roll}'){
    		roll.options[i].setAttribute("selected", "selected");
    	}
    }
    form.roll.setAttribute("selected","selected");
	document.getElementById('updateConfirmBtn').addEventListener('click', function(){
		alert('수정확인버튼 클릭함!!');
		//var form = document.getElementById('update_form');
		form.action = "${ctx}/member.do";
		form.method = "post";
		var node = document.createElement('input');
		node.innerHTML = '<input type="hidden" name="action" value="update" />';
		form.appendChild(node);
		form.submit();
	});
	
	 for(var i=1; i<=5; i++){
	        if(document.getElementById('teamid_'+i).value==='${user.teamID}'){
	        document.getElementById('teamid_'+i).checked = true;
	        } 
	    }
</script>
</body>
</html>
