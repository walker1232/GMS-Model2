<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div id="login-box">
			<a id="moveLoginForm" >LOGIN</a> &nbsp;&nbsp;&nbsp;
			<a id="moveJoinForm" >JOIN</a> &nbsp;&nbsp;&nbsp;
			<a id="moveUpdateForm">UPDATE</a> &nbsp;&nbsp;&nbsp;
			<a id="moveDeleteForm">Delete</a>
</div>
<script>
	document.getElementById('moveLoginForm');
	moveLoginForm.addEventListener('click', function(){
		alert('클릭 이벤트 체크 !!');
		common.move('member', 'move', 'user_login_form');
	});
	
	document.getElementById('moveJoinForm');
	moveJoinForm.addEventListener('click', function(){
		alert('join 이벤트 체크!!');
		common.move('member', 'move', 'join_form');
	});
	
	document.getElementById('moveUpdateForm');
	moveUpdateForm.addEventListener('click', function(){
		alert('update 이벤트 체크');
		common.move('member', 'move', 'update_form');
	});
	
	document.getElementById('moveDeleteForm');
	moveDeleteForm.addEventListener('click', function(){
		alert('delete 이벤트 체크');
		common.move('member', 'move', 'delete_form');
	});
</script>
