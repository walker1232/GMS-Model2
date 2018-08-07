"use strict";
var router = (()=>{ 
    			return {move : x=>{
        			location.href = x.ctx + '/' + x.domain + '.do?action=' + x.action + '&page=' + x.page}}; // key값과 value Json String : Json Value 
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
            }
            return j;
            },
                addClass : (dom,cName)=>{
                    var arr = cName.split(" ");
                    if(arr.indexOf(cName) == -1){
                        dom.className += " " + cName;
            }
        }
    }
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
/* json은 object value로 속성과 기능이 모두 올 수 있다 */
/*var admin = (()=>{return{};})();*/
var admin = (()=>{
	return{
		check : x=>{
			var isAdmin = confirm('관리자입니까');	// window 생략가능 따라서 BOM의 method 밑도 끝도없이 쓰면 BOM의 method
			if(isAdmin){
				var password = prompt('관리자비번을 입력 바랍니다');
				if(password == 1){
					router.move({
						 ctx : x,
						 domain : 'admin',
						 action : 'list',
						 page : 'main'
					});
				}else{
					alert('비밀번호가 틀렸습니다');
				}
			}else{
				alert('관리자만 접근이 허용됩니다');
			}
		},
		main : x=>{
		service.addClass(
			document.getElementById('searchBox'),
			'width80pt center'
		);
		service.addClass(
			document.getElementById('searchWord'),
			'width100px floatRight'
		);
		service.addClass(
			document.getElementById('searchOption'),
			'floatRight '
		);
		service.addClass(
			document.getElementById('searchBtn'),
			'floatRight '
		);
		service.addClass(
			document.getElementById('contentBoxTab'),
			'width90pt center marginTop30px'
		);
		service.addClass(
			document.getElementById('contentBoxMeta'),
			'bgColorYellow '
		);
		
		
			
		/* document.getElementById('searchBtn').addEventListener('',function(){}); 콜백 함수 기본형*/
			document.getElementById('searchBtn').addEventListener('click',function(){
			 location.href = (document.getElementById('searchOption').value === 'memid') ?
					 x+'/admin.do?action=retrieve&page=memberDetail&memid='+document.getElementById('searchWord').value
					: 
						location.href = x+'/admin.do?action=search&page=main&searchOption='+document.getElementById('searchOption').value+'&searchWord='+document.getElementById('searchWord').value
								;
						
		});
			
			for(var i of document.querySelectorAll('.username')){
				service.addClass(i, 'cursor fontColorBlue');
				i.addEventListener('click', function(){
					location.href=x+'/admin.do?action=retrieve&'+'page=memberDetail&memid='+this.getAttribute('id');
					//여기서의 this는 x[i]를 호출하는 녀석 
				});
			};
			for(var j of document.querySelectorAll('.pageNumber')){
				service.addClass(j, 'cursor fontColorBlue');
				j.addEventListener('click', function(){
					location.href=x+'/admin.do?action=list&'+'page=main&pageNumber='+this.getAttribute('id');
				});
			};
		}
	};})();
var member = (()=>{
    var _memID, _name, _ssn, _password, _age, _roll, _teamID, _gender;
    var setName = (name)=> {this._name = name;}
    var setMemid = (memid)=> {this._memID = memid;}
    var setSsn = (ssn)=> {this._ssn = ssn;}
    var setPassword = (pass)=> {this._password = pass;}
    var setAge = x=>{
    	var date = new Date().getFullYear();
    	this._age = date - 1900 + 1 - x.substring(0,2);
    	}
    var setGender = x=>{
    	if(x.substring(7,8) === '1'){
    		this._gender = 'man';
    	}else{
    		this._gender = 'woman';
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