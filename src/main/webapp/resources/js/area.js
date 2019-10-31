var areaService =(function(){
	function add(area,callback,error){ //전달되는 파라미터
		$.ajax({//보냄
			type : 'post', // post 형식
			url : '/map/new.json', 
			data : JSON.stringify(area), // JSON class 의 stringify 문자열이 존재할 경우 데이터를 string 형식으로 가공
			contentType : "application/json; charset=utf-8", // 데이터 전송 타입 지정 json형식 charset = utf-8
			success : function(result,status,xhr){ // 전송 후 파라미터로 success 와 error을 전달 받음
				if(callback){
					console.log(callback);
					callback(result);	//전송받은 파라미터를 callback
				}
			},
			error : function(xhr,status,er){
				if(error){
					erroe(er);
				}
			}
		})
	}
	function getList(callback,error){
		$.ajax({
			type :'get',
			url:'/map/.json',
			contentType : "application/json; charset=utf-8", // 데이터 전송 타입 지정 json형식 charset = utf-8
			success : function(result,status,xhr){
				if(callback){
					console.log(result.length);
					callback(result);
				}
			},
			error : function(xhr,status,er){
				if(error){
					error(er);
				}
			}
		});
	}
	function remove(areaId,callback,error){
		$.ajax({
			type:'delete',
			url:'/map/'+areaId,
			success : function(deleteResult, status,xhr){
				if(callback){ //callback이 있을경우
					callback(deleteResult);
				} 
			},
			error : function(xhr,status,er){
				if(error){
					error(er);
				}
			}
		})
	}
	function get(areaId,callback,error){
		$.get("/map/"+areaId+".json",function(result){
			if(callback){
				console.log(result.reply);
				callback(result);
			}
		}).fail(function(xhr,status,err){
			if(error)
				error();
		});
	}
	return {
		add:add,
		getList:getList,
		remove:remove,
		get:get
		};
})();