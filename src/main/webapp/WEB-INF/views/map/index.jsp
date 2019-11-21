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
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/area.js?ver=11"></script>
<script>
$(document).ready(function() {
	
		var modal = $(".modal");  
		var modalRemoveBtn = $("#modalRemoveBtn"); 
		var modalRegisterBtn = $("#modalRegisterBtn"); 
		var modalCloseBtn = $("#modalCloseBtn"); 
		
		
		var inputId = modal.find("input[name='areaId']");
		var inputName = modal.find("input[name='areaName']");
		var inputLatitude = modal.find("input[name='latitude']");
		var inputLongitude = modal.find("input[name='longitude']");
		var container = document.getElementById('map');
		
		var options = {
			center: new kakao.maps.LatLng(37.562018, 126.980833),
			level: 13
		};
		var map = new kakao.maps.Map(container, options);
		var positions  = new Array();
		showList();
		//Comment list 출력
		function showList(){	
			areaService.getList(
				function(list){
					console.log(list);
					console.log(list.length);
					for(var i=0,len= list.length||0 ;i<len;i++ ){
						var content ="<div>"+list[i].areaName+"</div>"+
									"<div>"+list[i].latitude+" "+list[i].longitude+"</div>";
						positions.push({
							 content: content,
							 clickContent : modal.clone(),
						     latlng: new kakao.maps.LatLng(list[i].latitude, list[i].longitude)
						});
						console.log(positions[i].content);
						var marker = new kakao.maps.Marker({
						 	map: map, // 마커를 표시할 지도
						    position: positions[i].latlng // 마커의 위치
						});
						var infowindow = new kakao.maps.InfoWindow({
					        content: positions[i].content // 인포윈도우에 표시할 내용
					    });
						kakao.maps.event.addListener(marker, 'mouseover', makeOverListener(map, marker, infowindow));
						kakao.maps.event.addListener(marker, 'mouseout', makeOutListener(infowindow));
						kakao.maps.event.addListener(marker, 'click',mouseClickListener(list[i].areaId))
					}
					function mouseClickListener(id){
						return function(){
							areaService.get(id,function(area){
								inputId.val(area.areaId).attr("readonly","readonly");
								inputName.val(area.areaName).attr("readonly","readonly");
								inputLatitude.val(area.latitude).attr("readonly","readonly");
								inputLongitude.val(area.longitude).attr("readonly","readonly");
								
								modal.find("button[id != 'modalCloseBtn']").hide();
								modalRemoveBtn.show();
								
								console.log(area);
								$(".modal").modal("show");
							});
						}
					}
					function makeOverListener(map, marker, infowindow) {
					    return function() {
					        infowindow.open(map, marker);
					    };
					}

					// 인포윈도우를 닫는 클로저를 만드는 함수입니다 
					function makeOutListener(infowindow) {
					    return function() {
					        infowindow.close();
					    };
					}
				}
			);
		}

		//Close 버튼 처리
		modalCloseBtn.on("click",function(e){
			$(".modal").modal("hide");
		});
		
		$("#regBtn").on("click",function(e){
			modal.find("input").val("");
			inputName.removeAttr("readonly");
			inputLatitude.removeAttr("readonly");
			inputLongitude.removeAttr("readonly");
			
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
		modalRemoveBtn.on("click",function(e){
			areaService.remove(inputId.val(),function(result){
				modal.find("input").val("");
				modal.modal("hide");
				showList();
			});
		});
});
</script>