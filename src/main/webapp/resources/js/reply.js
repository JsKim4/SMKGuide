console.log("Reply Module.........");

var replyService =(function(){
	function add(reply,callback,error){ //전달되는 파라미터
		console.log("add reply..........");
		
		$.ajax({//보냄
			type : 'post', // post 형식
			url : '/replies/new', // replies/new 로 전달
			data : JSON.stringify(reply), // JSON class 의 stringify 문자열이 존재할 경우 데이터를 string 형식으로 가공
			contentType : "application/json; charset=utf-8", // 데이터 전송 타입 지정 json형식 charset = utf-8
			success : function(result,status,xhr){ // 전송 후 파라미터로 success 와 error을 전달 받음
				if(callback){
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
	function getList(param,callback,eror){
		var bno=param.bno;
		var page = param.page || 1;
		$.getJSON("/replies/pages/"+bno+"/"+page+".json",//받아옴
			function(data){
				if(callback){
					callback(data.replyCnt,data.list);
				}
			}
		).fail(function(xhr,status,err){
			if(error){
				error();
			}
		});
	}
	function remove(rno,callback,error){
		$.ajax({
			type:'delete',
			url:'/replies/'+rno,
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
	function update(reply,callback,error){
		console.log("Rno : "+reply.rno);
		
		$.ajax({
			type:'put',
			url:'/replies/' + reply.rno,
			data: JSON.stringify(reply),
			contentType:"application/json; charset=utf-8",
			success : function(result,status,xhr){
				if(callback){
					callback(result);
				}
			},
			error : function(xhr,status,er){
				if(error){
					console.log(reply.rno);
					error(er);
				}
			}
		});
	}
	function get(rno,callback,error){
		$.get("/replies/"+rno+".json",function(result){
			if(callback){
				console.log(result.reply);
				callback(result);
			}
		}).fail(function(xhr,status,err){
			if(error)
				error();
		});
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
			
			return [yy,'/',(mm>9) ? '':'0' + mm,'/',(dd>9)?'':'0'+dd].join('');
		}
		
	}
	return {
		add:add,
		getList:getList,
		remove:remove,
		update:update,
		get:get,
		displayTime:displayTime
		};
})();