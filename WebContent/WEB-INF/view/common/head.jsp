<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<head>
    <meta charset="UTF-8" />
    <title>Main</title>
    <link rel="stylesheet" href="${css}/style.css"/>
    <script>
    	/* function Common(){
    		this.move = function (domain, action, page){
    			console.log('클릭 테스트 성공 ${ctx}')
    			alert('클릭 테스트 성공 ${ctx}');
    			location.href = "${ctx}/"+domain+".do?action="+action+"&page="+page;
    		}
    	} */
    	var common = new (function(){
    		this.move = function(domain, action, page){
    		location.href = "${ctx}/"+domain+".do?action="+action+"&page="+page}
    	});
    	// anonymous function
    	var mem = new (function (){
    		var memID; 
    		var teamID;
    		var name;
    		var ssn;
    		var age;
    		var roll;
    		var password;
    		this.setMemid = function(x){
    			this.memID = x;
    		}
    		this.setTeamid = function(x){
    			this.teamID = x;
    		}
    		this.setName = function(x){
    			this.name = x;
    		}
    		this.setSsn = function(x){
    			this.ssn = x;
    		}
    		this.setAge = function(x){
    			this.age = x;
    		}
    		this.setRoll = function(x){
    			this.roll = x;
    		}
    		this.setPassword = function(x){
    			this.password = x;
    		}
    		this.getMemid = function(){
    			return this.memID;
    		}
    		this.getPassword = function(){
    			return this.password;
    		}
    		this.getSsn = function(){
    			return this.ssn;
    		}
    		this.loginValidation = function (){
    			/* var ok = false; */
    	 		if(this.memID === ''){
    	 			alert('id를 공백으로 하면 안됩니다');
    	 			return false;
    	 		}else if(this. password === ''){
    	 			alert('pass를 공백으로 하면 안됩니다');
    	 			return false;
    	 		}else{
    	 			return true;
    	 		}
    	 		/* return ok; */
        		/* return this.getMemid(); */
        	}
    	});
    	
    </script>
</head>