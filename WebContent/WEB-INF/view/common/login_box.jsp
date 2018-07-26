<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div id="login-box">
			<a id="moveLoginForm" >LOGIN</a> &nbsp;&nbsp;&nbsp;
			<a id="moveJoinForm" >JOIN</a>

</div>
<script>

	document.getElementById('moveLoginForm').addEventListener('click', function(){
		alert('로그인 이벤트 체크 !!');
		router.move(['${ctx}', 'member', 'move', 'user_login_form']); // var x = ['${ctx}', 'member', 'move', 'user_login_form']; 이걸 한번에 쓴 것
	});
	document.getElementById('moveJoinForm').addEventListener('click', function(){
		alert('조인 이벤트 체크!!');
		router.move(['${ctx}', 'member', 'move', 'join_form']);
	});
	

</script>
