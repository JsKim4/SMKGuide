var commentService =(function(){
	function getList(cri,callback,error){
		$.ajax({
			type :'get',
			url:'/comment/pages/'+cri.type+'/'+cri.id+'/'+cri.page+'.json',
			contentType : "application/json; charset=utf-8", // 데이터 전송 타입 지정 json형식 charset = utf-8
			success : function(result,status,xhr){
				if(callback){
					console.log(result);
					console.log(result.list);
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
	
	function add(comment,callback,error){
		$.ajax({
			type :'post',
			url:'/comment/new',
			data : JSON.stringify(comment),
			contentType : "application/json; charset=utf-8", // 데이터 전송 타입 지정 json형식 charset = utf-8
			success : function(result,status,xhr){
				if(callback){
					callback(result);
				}
			},
			error : function(xhr,status,er){
				if(error){
					error(er);
				}
			}
		})
		
	}
	
	function get(commentId,callback,error){
		$.ajax({
			type :'get',
			url:'/comment/'+commentId+'.json',
			contentType : "application/json; charset=utf-8", // 데이터 전송 타입 지정 json형식 charset = utf-8
			success : function(result,status,xhr){
				if(callback){
					callback(result);
				}
			},
			error : function(xhr,status,er){
				if(error){
					error(er);
				}
			}
		})
	}
	function update(comment,callback,error){
		$.ajax({
			type:'put',
			url:'/comment/'+comment.commentId,
			data : JSON.stringify(comment),
			contentType : "application/json; charset=utf-8",
			success : function(result,status,xhr){
				if(callback){
					callback(result);
				}
			},
			error : function(xhr,status,er){
				if(error){
					error(er);
				}
			}
		})
	}
	
	function remove(comment,callback,error){
		$.ajax({
			type:'delete',
			url:'/comment/'+comment.commentId,
			data : JSON.stringify(comment),
			contentType : "application/json; charset=utf-8",
			success : function(result,status,xhr){
				if(callback){
					callback(result);
				}
			},
			error : function(xhr,status,er){
				if(error){
					error(er);
				}
			}
		})
	}
	
	
	function displayTime(timeValue){
		var today = new Date();
		var gap = today.getTime() - timeValue;
		
		var dateObj = new Date(timeValue);
		var str="";
		if(gap<(1000*60*60*24)){//1000ms*60s*60m*24h
			var hh =dateObj.getHours();
			var mi = dateObj.getMinutes();
			var ss = dateObj.getSeconds();
			
			return [(hh > 9 ? '':'0') + hh,':',(mi > 9 ? '' : '0') + mi,
				':', (ss>9 ? '' : '0') + ss].join('');
		}else{
			
			var yy  = dateObj.getFullYear();
			var mm = dateObj.getMonth()+1;
			var dd = dateObj.getDate();
			return [(yy),'/', (mm > 9 ? '' : '0') + mm, '/', (dd>9 ? '' : '0') + dd].join('');
		}
		
	}
	
	return {
		getList:getList,
		add:add,
		get:get,
		update:update,
		remove:remove,
		displayTime:displayTime};
})();