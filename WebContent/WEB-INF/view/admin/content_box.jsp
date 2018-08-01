<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="content-box">
	<table id="contenBoxTab">
		<tr id="contentBoxMeta">
			<th>아이디</th>
			<th>이 름</th>
			<th>나 이</th>
			<th>성 별</th>
			<th>역 할</th>
			<th>팀 명</th>
		</tr>
		<c:forEach items="${list}" var="member">
		<tr>
			<td>${member.memID}</td>
			<td><a class="username" id="${member.memID}">${member.name}</a></td>
			<td>${member.age}</td>
			<td>${member.gender}</td>
			<td>${member.roll}</td>
			<td>${member.teamID}</td>
		</tr>
		</c:forEach>
	</table>
	<!-- <h1>This is adminpage</h1> -->
</div>
<script>
	document.getElementById('contentBoxMeta').className = 'bgColorisYellow';
	var x = document.querySelectorAll('.username');
	for(i in x){
		x[i].style.color = 'blue';
		x[i].style.cursor = 'pointer';
		x[i].addEventListener('click', function(){
			location.href='${ctx}/admin.do?action=retrieve&'+'page=memberDetail&memid='+this.getAttribute('id');
			//여기서의 this는 x[i]를 호출하는 녀석 
		});
	}
</script>