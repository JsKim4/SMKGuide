<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" buffer="128kb"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@include file="../includes/header.jsp"%>
<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">Smoke Area</h1>
	</div>
	<!-- /.col-lg-12 -->
</div>
<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">
				Smoke Area
				<button id="regBtn" type="button" class="btn btn-xs pull-right">
					Register New Area</button>
			</div>
			<!-- end panel-heading -->
			<div class="panel-body">
					<div class="col-lg-12" id="map" style="height:700px;">
					</div>
				<!-- end pull-right -->
				<%@include file="map_modal.jsp"%>
			</div>
			<!-- end panel body -->
		</div>
		<!-- end panel-default -->
	</div>
	<!-- /.col-lg-12 -->
</div>
<!-- /.row -->
<%@include file="../includes/footer.jsp"%>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=002bb9e05de642c46d033331bdd7d5ab"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/area.js?ver=10"></script>
<script>
$(document).ready(function() {
		var container = document.getElementById('map');
		var options = {
			center: new kakao.maps.LatLng(37.562018, 126.980833),
			level: 13
		};
		var map = new kakao.maps.Map(container, options);
		var marker  = new Array();
		showList();
		//Comment list 출력
		function showList(){	
			areaService.getList(
				function(list){
					console.log(list);
					console.log(list.length);
					for(var i=0,len= list.length||0 ;i<len;i++ ){
						var markerPosition =  new kakao.maps.LatLng(list[i].latitude,list[i].longitude);
						console.log(i,len);
						console.log(markerPosition);
						marker[i]= new kakao.maps.Marker({
						    position: markerPosition
						});	
						marker[i].setMap(map);
					}
				}
			);
		}
		
		
		
		
		// 마커를 클릭했을 때 마커 위에 표시할 인포윈도우를 생성합니다
	///	var iwContent = '<div style="padding:5px;">Hello World!</div>', // 인포윈도우에 표출될 내용으로 HTML 문자열이나 document element가 가능합니다
		//    iwRemoveable = true; // removeable 속성을 ture 로 설정하면 인포윈도우를 닫을 수 있는 x버튼이 표시됩니다
		// 인포윈도우를 생성합니다
	//	var infowindow = new kakao.maps.InfoWindow({
	//	    content : iwContent,
	//	    removable : iwRemoveable
		//});
		// 마커에 클릭이벤트를 등록합니다
	///	kakao.maps.event.addListener(marker, 'click', function() {
		      // 마커 위에 인포윈도우를 표시합니다
		//      infowindow.open(map, marker);  
	//	});
		
		
		var modal = $(".modal");  
		var modalRemoveBtn = $("#modalRemoveBtn"); 
		var modalRegisterBtn = $("#modalRegisterBtn"); 
		var modalCloseBtn = $("#modalCloseBtn"); 
		
		var inputName = modal.find("input[name='name']");
		var inputLatitude = modal.find("input[name='latitude']");
		var inputLongitude = modal.find("input[name='longitude']");
		//Close 버튼 처리
		modalCloseBtn.on("click",function(e){
			$(".modal").modal("hide");
		});
		
		$("#regBtn").on("click",function(e){
			modal.find("input").val("");
			
			modalRegisterBtn.show();
			$(".modal").modal("show");
			
		});
		modalRegisterBtn.on("click",function(e){
			var area = {
					areaName:inputName.val(),
					latitude:inputLatitude.val(),
					longitude:inputLongitude.val()
			}
			console.log(area);
			if(area.areaName==="" || area.latitude==="" || area.longitude===""){
				alert("입력이 필요합니다.");
				return;
			}
			areaService.add(area,function(result){
				
				modal.find("input").val("");
				modal.modal("hide");
				showList();
			})
		});
});
</script>