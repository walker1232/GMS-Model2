<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="content-box">
	<table>
		<tr>
			<th><font color="balck">아이디</font></th>
			<th><font color="black">이 름</font></th>
			<th><font color="balck">나 이</font></th>
			<th><font color="balck">성 별</font></th>
			<th><font color="balck">역 할</font></th>
			<th><font color="balck">팀 명</font></th>
		</tr>
		<c:forEach items="${list}" var="member">
		<tr>
			<td><font color="balck">${member.memID}</font></td>
			<td><a href="${ctx}/admin.do?action=retrieve&page=memberDetail&memid=${member.memID}" style="cursor:pointer;"><font color="black">${member.name}</font></a></td>
			<td><font color="black">${member.age}</font></td>
			<td><font color="black">${member.gender}</font></td>
			<td><font color="black">${member.roll}</font></td>
			<td><font color="black">${member.teamID}</font></td>
		</tr>
		</c:forEach>
	</table>
	<!-- <h1>This is adminpage</h1> -->
</div>
<script>
	/* alert("여기에 회원목록이 보이면 됨 : ${list}"); */
</script>