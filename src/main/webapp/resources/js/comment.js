var commentService =(function(){
	function getList(cri,callback,error){
		$.ajax({
			type :'get',
			url:'/comment/pages/'+cri.type+'/'+cri.id+'/'+cri.page+'.json',
			contentType : "application/json; charset=utf-8", // 데이터 전송 타입 지정 json형식 charset = utf-8
			success : function(result,status,xhr){
				if(callback){
					callback(result.commentPage,result.list);
				}
			},
			error : function(xhr,status,er){
				if(error){
					error(er);
				}
			}
		})
		
	}
	
	
	return {getList:getList};
})();