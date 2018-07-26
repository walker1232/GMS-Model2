<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div id="login-box">
			<a id="moveLoginForm" >LOGIN</a> &nbsp;&nbsp;&nbsp;
			<a id="moveJoinForm" >JOIN</a>

</div>
<script>
	/* document.getElementById('moveLoginForm');
	moveLoginForm.addEventListener('click', function(){
		alert('클릭 이벤트 체크 !!');
		common.move('member', 'move', 'user_login_form');
	}); */
	
	/* document.getElementById('moveJoinForm');
	moveJoinForm.addEventListener('click', function(){
		alert('join 이벤트 체크!!');
		common.move('member', 'move', 'join_form');
	}); */
	document.getElementById('moveLoginForm').addEventListener('click', function(){
		alert('로그인 이벤트 체크 !!');
		new Common().move('${ctx}', 'member', 'move', 'user_login_form');
	});
	document.getElementById('moveJoinForm').addEventListener('click', function(){
		alert('조인 이벤트 체크!!');
		new Common().move('${ctx}', 'member', 'move', 'join_form');
	});
	

</script>
