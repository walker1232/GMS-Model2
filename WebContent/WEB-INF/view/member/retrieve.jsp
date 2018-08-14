<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

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
		<td><img src="${img}/${profile}" alt="" />이미지</td>
		<td colspan="2">${retrieve.memID}</td>
	</tr>
	<tr>
		<td>이름</td>
		<td colspan="2">${retrieve.name}</td>
	</tr>
	<tr>
		<td>비번</td>
		<td colspan="2">*******</td>
	</tr>
	<tr>
		<td>나이</td>
		<td>${retrieve.age}</td>
		<td>팀명</td>
		<td>${retrieve.teamID}</td>
	</tr>
	<tr>
		<td>성별</td>
		<td>${retrieve.gender}</td>
		<td>역할</td>
		<td>${retrieve.roll}</td>
	</tr>
</table>
</div>
	</div> <!-- content end -->



<script>
	document.getElementById('myPage2MoveToUpdate').addEventListener('click', function(){
		router.move({ctx : '${ctx}',
					 domain : 'member',
					 action : 'move',
					 page : 'modify'});
	});
	document.getElementById('myPage2MoveToDelete').addEventListener('click', function(){
		router.move({ctx : '${ctx}',
					 domain : 'member',
					 action : 'move',
					 page : 'remove'});
	});
</script>
