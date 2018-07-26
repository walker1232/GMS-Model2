	function Common(){
    		this.move = function(t, domain, action, page){
    		location.href = t+'/'+domain+'.do?action='+action+'&page='+page}
    	};
    	// anonymous function
    	function Member(){
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
    		this.setName = function(x){
    			this.name = x;
    		}
    		this.setSsn = function(x){
    			this.ssn = x;
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
    	};