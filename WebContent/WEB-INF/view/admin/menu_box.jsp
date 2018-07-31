<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div id="menu-box">
		<ul id="menu">
			<li><a onclick="move('member', 'move', 'member_list')">회원목록</a></li>
			<li><a id="moveSearchIdForm">회원검색</a></li>
			<li><a href="${ctx }">HOME</a></li>
		</ul>
</div>
<script>
	document.getElementById('moveSearchIdForm');
	moveSearchIdForm.addEventListener('click', function(){
		alert('searchId 이벤트 체크');
		new Common().move('${ctx}', 'member', 'move', 'search_id_form');
	});
	
	
</script>