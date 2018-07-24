<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!doctype html>
<html lang="en">
<jsp:include page="../common/head.jsp"/>
<body>
<div id="wrapper">
	<div id="header">
		<jsp:include page="../common/title_box.jsp"/>
		<jsp:include page="menu_box.jsp"/>
	</div> <!-- header end -->
	<div id="content">
		<jsp:include page="content_box.jsp"/>
		<%-- <img src="${ctx }/img/home/koala.jpg" alt="100" /> --%>
	</div> <!-- content end -->
	<div id ="footer">
		<jsp:include page="../common/footer_box.jsp"/>
	</div>
	
</div>

<script>
	function move(domain, action, page){
		console.log('클릭 테스트 성공 ${ctx}')
		alert('클릭 테스트 성공 ${ctx}');
		location.href = "${ctx}/"+domain+".do?action="+action+"&page="+page;
	}
</script>

<script>
	function trans(domain, action, page){
		return true;
	}
</script>

</body>
</html>