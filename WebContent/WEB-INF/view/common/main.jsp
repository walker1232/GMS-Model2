<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!doctype html>
<html lang="en">
	<jsp:include page="head.jsp"/>
<body>
<div id="wrapper">
	<div id="header">
		<jsp:include page="title_box.jsp"/>
		<jsp:include page="login_box.jsp"/>
		<jsp:include page="menu_box.jsp"/>
	</div> <!-- header end -->
	<div id="content">
		<jsp:include page="content_box.jsp"/>
	</div> <!-- content end -->
	<div id ="footer">
		<jsp:include page="footer_box.jsp"/>
	</div>
</div>

<script>
	common.main('${ctx}');
</script>
</body>
</html>