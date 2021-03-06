<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="../common/head.jsp"/>
<%-- <h1>마이페이지 진입</h1>
<h1>이름: ${user.name}</h1>
<h1>아아디: ${user.memID}</h1>
<h1>비밀번호: *******</h1>
<h1>주민번호: ${user.ssn}</h1>
<h1>팀아이디: ${user.teamID}</h1>
<h1>나이: ${user.age}</h1>
<h1>역할: ${user.roll}</h1>
<h1>성별: ${user.gender}</h1> --%>
<div id="wrapper">
	<div id="header">
		<jsp:include page="../common/title_box.jsp"/>
		<jsp:include page="../common/login_box.jsp"/>
		<jsp:include page="../common/menu_box.jsp"/>
	</div> <!-- header end -->
	<div id="content">
		<div>
	<a id="myPage2MoveToUpdate">UPDATE FORM 이동</a>
	<a id="myPage2MoveToDelete">DELETE FORM 이동</a>
		</div>
<div>
<h1>마이페이지 진입</h1>
<table style="width:50%">
	<tr>
		<td rowspan="3"></td>
		<td>아이디</td>
		<td colspan="2">${user.memID}</td>
	</tr>
	<tr>
		<td>이름</td>
		<td colspan="2">${user.name}</td>
	</tr>
	<tr>
		<td>비번</td>
		<td colspan="2">*******</td>
	</tr>
	<tr>
		<td>나이</td>
		<td>${user.age}</td>
		<td>팀명</td>
		<td>${user.teamID}</td>
	</tr>
	<tr>
		<td>성별</td>
		<td>${user.gender}</td>
		<td>역할</td>
		<td>${user.roll}</td>
	</tr>
</table>
</div>
	</div> <!-- content end -->
	<div id ="footer">
		<jsp:include page="../common/footer_box.jsp"/>
	</div>
</div>


<script>
	document.getElementById('myPage2MoveToUpdate').addEventListener('click', function(){
		router.move({ctx : '${ctx}',
					 domain : 'member',
					 action : 'move',
					 page : 'update_form'});
	});
	document.getElementById('myPage2MoveToDelete').addEventListener('click', function(){
		router.move({ctx : '${ctx}',
					 domain : 'member',
					 action : 'move',
					 page : 'delete_form'});
	});
</script>
