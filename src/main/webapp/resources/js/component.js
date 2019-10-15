var componentService =(function(){
	function add(component,callback,error){ //전달되는 파라미터
		console.log("add Component..........");
		
		$.ajax({//보냄
			type : 'post', // post 형식
			url : '/component/new', // replies/new 로 전달
			data : JSON.stringify(component), // JSON class 의 stringify 문자열이 존재할 경우 데이터를 string 형식으로 가공
			contentType : "application/json; charset=utf-8", // 데이터 전송 타입 지정 json형식 charset = utf-8
			success : function(result,status,xhr){ // 전송 후 파라미터로 success 와 error을 전달 받음
				if(callback){
					callback(result);	//전송받은 파라미터를 callback
				}
			},
			error : function(xhr,status,er){
				if(error){
					error(er);
				}
			}
		})
	}
	
	return {
		add:add
	};
})();