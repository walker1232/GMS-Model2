var router = (()=>{ 
    			return {move : x=>{
        			location.href = x[0]+'/'+x[1]+'.do?action='+x[2]+'&page='+x[3]}}; // key값과 value Json String : Json Value 
    	})();
/*var service = (()=>{
	return {
		nullChecker : x=>{
			if()
		};
		joinValidation : x=>{
			if(x.getMemid === ""){
				alert('id를 공백으로 하면 안됩니다');
				return false;
			}else if(x.getPassword === ""){
				alert('pass를 공백으로 하면 안됩니다');
				return false;
			}else if(x.getName === ""){
				alert('name를 공백으로 하면 안됩니다');
				return false;
			}else if(x.getSsn === ""){
				alert('ssn를 공백으로 하면 안됩니다');
				return false;
			}else{
				return true;
			}
		}
	};
})();*/
var service = (()=>{
	return {
		nullChecker : x=>{
			var i = 0;
			var j = {
					checker : true,
					text : '필수입력값이 없습니다'
			};
			for(i in x){
				if(x[i] === ''){
					j.checker = false;
				}
				return j;
			}
		}
	};
})();
/*var service = (()=>{
	return {
		validation : x=>{
			
		},
		aaa : x=>{
			
		}
	};
})(); 확장 */
    	// anonymous function
var member = (()=>{
    var _memID, _name, _ssn, _password, _age, _roll, _teamID, _gender;
    var setName = (name)=> {this._name = name;}
    var setMemid = (memid)=> {this._memID = memid;}
    var setSsn = (ssn)=> {this._ssn = ssn;}
    var setPassword = (pass)=> {this._password = pass;}
    var setAge = x=>{
    	var date = new Date().getFullYear();
    	alert(x);
    	alert(x.substring(0,2));
    	this._age = date - 1900 + 1 - x.substring(0,2);
    	alert(this._age);
    	/*this._age = date - 1900 + 1 - x.getSsn.substring(0,3);*/
    	}
    var setGender = x=>{
    	if(x.substring(7,8) === '1'){
    		alert(x.substring(7,8));
    		this._gender = 'man';
    		alert(this._gender);
    	}else{
    		alert(x.substring(7,8));
    		this._gender = 'woman';
    		alert(this._gender);
    	}
    	}
    var getName = ()=> {return this._name;}
    var getMemid = ()=> {return this._memID;}
    var getSsn = ()=> {return this._ssn;}
    var getPassword = ()=> {return this._password;}
    var getAge = ()=> {return this._age;}
    var getGender = ()=> {return this._gender;}
    return {
    		setName : setName,
    		setMemid : setMemid,
    		setSsn : setSsn,
    		setPassword : setPassword,
    		setAge : setAge,
    		setGender : setGender,
    		getName : getName,
    		getMemid : getMemid,
    		getSsn: getSsn,
    		getPassword : getPassword,
    		getGender : getGender,
    		getAge : getAge,
    		   join : x=>{
    			    member.setAge(x);
   					member.setGender(x);
   					
   				}
    		       /*loginValidation : x=>{
    					if(x.getMemid === ''){
    			 			alert('id를 공백으로 하면 안됩니다');
    			 			return false;
    			 		}else if(x.getPassword === ''){
    			 			alert('pass를 공백으로 하면 안됩니다');
    			 			return false;
    			 		}else{
    			 			return true;
    			 		}
    				}*/
    		}
})();

    	//function (){}();
    	//(function (){})();	// Goofy 멍청 하지만 요즘에는 이 방식을 써야 할 때도 있음
    	//(function (){}());	// Groovy 근사한