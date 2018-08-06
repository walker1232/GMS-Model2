<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="content-box">
	<div id="searchBox">
		<input type="button" id="searchBtn" value="검색">
		<input id="searchWord" name="searchWord" type="text" placeholder="검색어 입력"/>
		<select name="searchOption" id="searchOption">
			<option value="none">검색조건</option>
			<option value="memid">아이디</option>
			<option value="name">이 름</option>
			<option value="teamid">팀 명</option>
		</select>
	</div>
	<table id="contentBoxTab">
		<tr id="contentBoxMeta">
			<th>아이디</th>
			<th>이 름</th>
			<th>나 이</th>
			<th>성 별</th>
			<th>역 할</th>
			<th>팀 명</th>
		</tr>
		<c:forEach items="${list2}" var="member">
		<tr>
			<td>${member.memID}</td>
			<td><a class="username" id="${member.memID}">${member.name}</a></td>
			<td>${member.age}</td>
			<td>${member.gender}</td>
			<td>${member.roll}</td>
			<td>${member.teamID}</td>
		</tr>
		</c:forEach>
		<tr>
			<td colspan="6">
				전체회원수 : ${count} 명
				<ul class="pageBox">
					<c:forEach  begin="${beginPage}" end="${endPage}" step="1" varStatus="i"> <!-- varStatus는 index를 내장하고 있다 -->
						<li>
							<a href="#">${i.index}</a>
						</li>
						<%-- <span>${i}</span> --%>
					</c:forEach>
						<c:if test="${count gt 25}">
							<li>다음▶</li>
						</c:if>
						
				</ul>
			</td>
		</tr>
	</table>
	<!-- <h1>This is adminpage</h1> -->
</div>
<script>
	admin.main('${ctx}');
</script>