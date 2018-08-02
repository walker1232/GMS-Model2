<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="content-box">
	<div id="contentBox">
	<form id="searchForm" name="searchForm">
		<input type="button" id="searchBtn" value="검색">
		<input id="searchWord" name="searchWord" type="text" placeholder="검색어 입력"/>
		<select name="searchOption" id="searchOption">
			<option value="none">검색조건</option>
			<option value="memid">아이디</option>
			<option value="name">이 름</option>
			<option value="teamname">팀 명</option>
		</select>
	</form>
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
	admin.main('${ctx}');
	/*  service.addClass(
		documemnt.getElementById('searchBox'),
		'width80pt center'
	); */
	/* service.addClass(
		document.getElementById('searchWord'),
		'width100px floatRight'
	);
	service.addClass(
		document.getElementById('searchOption'),
		'floatRight '
	);
	service.addClass(
		document.getElementById('searchBtn'),
		'floatRight '
	);
	service.addClass(
		document.getElementById('contentBoxTab'),
		'width90pt center marginTop30px'
	);
	service.addClass(
		document.getElementById('contentBoxMeta'),
		'bgColorYellow '
	);
	 */
	
		
	/* document.getElementById('searchBtn').addEventListener('',function(){}); 콜백 함수 기본형*/
		//var form = document.getElementById('searchForm');
		//document.getElementById('searchBtn').addEventListener('click',function(){
		/* if(form.searchOption.value === 'memid'){
			alert('retrieve로 검색');
			location.href = '${ctx}/admin.do?action=retrieve&page=memberDetail&memid='+form.searchWord.value;
		}else{
			alert('search로 검색');
			location.href = '${ctx}/admin.do?action=search&page=main&searchOption='+form.searchOption.value+'&searchWord='+form.searchWord.value;
		} */
		
		/* () ? : ; 삼항기본구조*/
		 /* location.href = (form.searchOption.value === 'memid') ?
				 '${ctx}/admin.do?action=retrieve&page=memberDetail&memid='+form.searchWord.value
				: 
					location.href = '${ctx}/admin.do?action=search&page=main&searchOption='+form.searchOption.value+'&searchWord='+form.searchWord.value;
							;
					
	});
		
		var x = document.querySelectorAll('.username');
		for(i in x){
			x[i].style.color = 'blue';
			x[i].style.cursor = 'pointer';
			x[i].addEventListener('click', function(){
				location.href='${ctx}/admin.do?action=retrieve&'+'page=memberDetail&memid='+this.getAttribute('id');
				//여기서의 this는 x[i]를 호출하는 녀석 
			});
		} */
</script>