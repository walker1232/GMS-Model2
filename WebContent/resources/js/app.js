var router = (()=>{ 
    			return {move : x=>{
        			location.href = x[0]+'/'+x[1]+'.do?action='+x[2]+'&page='+x[3]}}; // key값과 value Json String : Json Value 
    	})();
var service = (()=>{
	return {
		loginValidation : x=>{
			if(x.getMemid === ''){
	 			alert('id를 공백으로 하면 안됩니다');
	 			return false;
	 		}else if(x.getPassword === ''){
	 			alert('pass를 공백으로 하면 안됩니다');
	 			return false;
	 		}else{
	 			return true;
	 		}
		},
		joinValidation : x=>{
			
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
    	};
    	
    	//function (){}();
    	//(function (){})();	// Goofy 멍청 하지만 요즘에는 이 방식을 써야 할 때도 있음
    	//(function (){}());	// Groovy 근사한