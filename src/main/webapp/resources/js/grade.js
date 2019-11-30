var gradeService =(function(){
	function add(grade,callback,error){
		$.ajax({
			type :'post',
			url:'/grade/new',
			data : JSON.stringify(grade),
			contentType : "application/json; charset=utf-8", // 데이터 전송 타입 지정 json형식 charset = utf-8
			success : function(result,status,xhr){
				if(callback){
					callback(result);
				}
			},
			error:function(request,status,error){
			    console.log("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);}
		})
		
	}
	function getList(cri,callback,error){
		$.ajax({
			type :'get',
			url:'/grade/pages/'+cri.type+'/'+cri.id+'/'+cri.page+'.json',
			contentType : "application/json; charset=utf-8", // 데이터 전송 타입 지정 json형식 charset = utf-8
			success : function(result,status,xhr){
				if(callback){
					console.log(result);
					console.log(result.list);
					callback(result.gradePage,result.list);
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
		add:add,
		getList:getList};
})();