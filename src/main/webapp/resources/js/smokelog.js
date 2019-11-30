var smokelogService =(function(){
	function add(tobaccoId,callback,error){
		$.ajax({
			type :'post',
			url:'/smokelog/'+tobaccoId+'/new',
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
			url:'/smokelog/pages/'+cri.type+'/'+cri.id+'/'+cri.page+'.json',
			contentType : "application/json; charset=utf-8", // 데이터 전송 타입 지정 json형식 charset = utf-8
			success : function(result,status,xhr){
				if(callback){
					console.log(result);
					console.log(result.list);
					callback(result.smokelogPage,result.list);
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
		add:add,
		getList:getList,
		displayTime:displayTime};
})();