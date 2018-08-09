<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!doctype html>
<html lang="en">
<body>
<div id="wrapper">
	<div id="header">
		
	</div> <!-- header end -->
	<div id="content">
	</div> <!-- content end -->
	<div id ="footer">
	</div>
</div>
<!-- <script>
	function move(domain, action, page){
		console.log('클릭 테스트 성공 ${ctx}')
		alert('클릭 테스트 성공 ${ctx}');
		location.href = "${ctx}/"+domain+".do?action="+action+"&page="+page;
	}
</script> -->
<script>
	function trans(domain, action, page){
		return true;
	}
</script>
</body>
</html>