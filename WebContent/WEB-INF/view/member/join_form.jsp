<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% String ctx = application.getContextPath(); %>
<!-- memID, teamID, name, 800101-1, roll, password -->
<!doctype html>
<html lang="en">
	<jsp:include page="../common/head.jsp"/>
<!-- <head>
	<meta charset="UTF-8" />
	<title>회원가입화면</title>
</head> -->
<body>
<div id="wrapper">
	<div id="header">
		<jsp:include page="../common/title_box.jsp"/>
		<jsp:include page="../common/login_box.jsp"/>
		<jsp:include page="../common/menu_box.jsp"/>
	</div> <!-- header end -->
	<div id="content">
		<h1>회원가입</h1>
	<form id="join_form" name="join_form" >
		ID: <input type="text" name="memid"><br />
		Name: <input type="text" name="name"><br />
		Pass: <input type="text" name="pass"><br />
		Ssn : <input type="text" name="ssn"><br />
		소속팀
		<input type="radio" name="teamid" value="none" checked="checked" />없음
		<input type="radio" name="teamid" value="nolja"/>걍놀자
		<input type="radio" name="teamid" value="jieunHouse"/>지은이네
		<input type="radio" name="teamid" value="turtleKing"/>터틀킹
		<input type="radio" name="teamid" value="codingZzang"/>코딩짱 <br />
		프로젝트역할
		<select name="roll" id="roll">
			<option value="leader">팀장</option>
			<option value="front">프론트개발</option>
			<option value="back">백단개발</option>
			<option value="android">안드로이드개발</option>
			<option value="minfe">민폐</option> <br />
		</select>
		수강과목
		<input type="checkbox" name="subject" value="java" checked="checked"/>Java
		<input type="checkbox" name="subject" value="clang"/>c
		<input type="checkbox" name="subject" value="JSP"/>JSP
		<input type="checkbox" name="subject" value="PHP"/>PHP
		<input type="checkbox" name="subject" value="nodejs"/>NodeJs
		<input type="checkbox" name="subject" value="linux"/>Linux
		<input type="checkbox" name="subject" value="html"/>HTML
		<input type="checkbox" name="subject" value="spring"/>Spring <br />
		<input id="JoinFormBtn" type=button value="Join">
	</form>
	</div> <!-- content end -->
	<div id ="footer">
		<jsp:include page="../common/footer_box.jsp"/>
	</div>
</div>
	
	<script>
		document.getElementById('JoinFormBtn').addEventListener('click', function(){
			var x = service.nullChecker([document.join_form.memid.value, document.join_form.pass.value, 
										document.join_form.name.value, document.join_form.ssn.value]);
			if(x.checker){
				var form = document.getElementById('join_form');
				form.action = "${ctx}/member.do";
				form.method = "post";
				/* var json = {'key', 'value'};
				var val = json.k; */
				// json은 객체를 담을 수 있다
				/* var json = {
						name : ['action', 'gender', 'age'],
						value : ['join', '', '']
				};
				for(var i = 0; i < json.name.length; i++){
					var node = document.createElement('input');
					node.setAttribute('type', 'hidden');
					node.setAttribute('name', json.name[i]);
					node.setAttribute('value', json.value[i]);
					form.appendChild(node);
				}; */
				var arr = [{name:'action', value:'join'}, 
						   {name:'gender'}, 
						   {name:'age'}
						   ];
				for(var i in arr){
					var node = document.createElement('input');
					node.setAttribute('type', 'hidden');
					node.setAttribute('name', arr[i].name);
					node.setAttribute('value', arr[i].value);
					form.appendChild(node);
				};
				
				member.join(form.ssn.value);
				form.gender.value = member.getGender();
				form.age.value = member.getAge();
				alert(member.getGender());
				form.submit();
			}else{
				alert(x.text);
			}
		});
	</script>
</body>
</html>