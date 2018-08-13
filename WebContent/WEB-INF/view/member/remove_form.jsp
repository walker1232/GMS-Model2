<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% String ctx = application.getContextPath(); %>
	<div id="content">
		<form id="delete_form">
			<!-- ID: <input type="text" name="memid"><br /> -->
			<font color="black">비밀번호 재입력: </font><input type="text" name="pass">
			<input id="deleteFormBtn" type="button" value="delete">
		</form>
		
	</div> <!-- content end -->
	

	<script>
		var form = document.getElementById('delete_form');
		document.getElementById('deleteFormBtn').addEventListener('click', function(){
			alert('탈퇴확인 버튼 클릭함!!');
			var val = form.pass.value;
			if(val === '${user.password}'){
				form.action = "${ctx}/member.do";
				form.method = "post";
				var node = document.createElement('input');
				node.innerHTML = '<input type="hidden" name="action" value="remove" />';
				form.appendChild(node);
				form.submit();
			}else{
			alert('비밀번호가 다릅니다!!');
			}
		});
		
		
	</script>
