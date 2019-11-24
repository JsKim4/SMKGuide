<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" buffer="128kb"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@include file="../includes/header.jsp"%>
<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">Components - ${componentType} </h1>
	</div>
	<!-- /.col-lg-12 -->
</div>
<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">
				 ${componentType} List
				<button id="regBtn" type="button" class="btn btn-xs pull-right">
					Register New ${componentType}</button>
			</div>
			<!-- end panel-heading -->
			<div class="panel-body">
				<table class="table table-striped table-bordered table hover componentTable">
					<thead>
						<tr>
							<th width="10%">번호</th>
							<th width="90%">제목</th>
						</tr>
					</thead>
					<c:forEach items="${list}" var="component">
						<tr>
							<td width="10%"><a class="move" href='<c:out value="${component.id }" />'>
									<c:out value="${component.id }" /></a></td>
							<td width="90%"><c:out value="${component.name }" /></td>
						</tr>
					</c:forEach>
				</table>
				<div class='pull-right'>
					<ul class="pagination">
						<c:if test="${pageMaker.prev}">
							<li class="paginate_button previous"><a href="${pageMaker.startPage-1 }"> <c:out
										value="Previous" />
							</a></li>
						</c:if>
						<c:forEach var="num" begin="${pageMaker.startPage}"
							end="${pageMaker.endPage}">
							<li class="paginate_button ${pageMaker.cri.pageNum == num ? "active" : "" }"><a href="${num}"> <c:out
										value="${num}" />
							</a></li>
						</c:forEach>
						<c:if test="${pageMaker.next}">
							<li class="paginate_button next"><a href="${pageMaker.endPage+1 }"> <c:out
										value="Next" />
							</a></li>
						</c:if>
					</ul>
					<form id='actionForm' action="./list" method='get'>
						<input type='hidden' name='pageNum' value='${pageMaker.cri.pageNum}'>
						<input type='hidden' name='amount' value='${pageMaker.cri.amount}'>
						<input type='hidden' name='type' value='${pageMaker.cri.type}'>
						<input type='hidden' name='keyword' value='${pageMaker.cri.keyword}'>
					</form>
				</div>
				<%@include file="component_modal.jsp"%>
				<!-- end pull-right -->
				<%@include file="../includes/modal.jsp"%>
			</div>
			<!-- end panel body -->
		</div>
		<!-- end panel-default -->
	</div>
	<!-- /.col-lg-12 -->
</div>
<!-- /.row -->
<%@include file="../includes/footer.jsp"%>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/component.js?ver=13"></script>
<script type="text/javascript">
	$(document).ready(
		function() {
			console.log(componentService);
			var comType = '<c:out value = "${componentType}"/>'
			var modal = $("#componentModal");
			var modalInputName = modal.find("input[name='name']");
			var modalInputId = modal.find("input[name='id']");
		
			var modalModBtn = $("#modalModBtn");
			var modalRemoveBtn = $("#modalRemoveBtn");
			var modalRegisterBtn = $("#modalRegisterBtn");
			var modalCloseBtn = $("#modalCloseBtn"); // Comment modal close
			
			
			//Close 버튼 처리
			modalCloseBtn.on("click",function(e){
				$(".modal").modal("hide");
			});
			
			
			
			
			modalRemoveBtn.on("click",function(e){
				var comp = {
						id:modalInputId.val(),
						type:comType
				};  
				componentService.remove(comp,function(comp){
					modal.find("input").val("");
					modal.modal("hide");
					location.reload();
				},function(er){
					alert("삭제에 실패하였습니다.\n해당 Component로 구성된 담배를 모두 삭제 혹은 변경 해야 합니다.");
						
				});
				
			});
			
			
			/*modify*/
			modalModBtn.on("click",function(e){
				var comp = {
						id:modalInputId.val(),
						name:modalInputName.val(),
						type:comType
				};  
				componentService.modify(comp,function(comp){
					modal.find("input").val("");
					modal.modal("hide");
					location.reload();
				});
				
			});
			
			
			
			/*자세히 보기*/
			$(".move").on("click",function(e){
				e.preventDefault();
				var comp = {
						id:$(this).attr("href"),
						type:comType
					};
				console.log(comp);
				componentService.get(comp,function(component){
					modalInputName.val(component.name);
					modalInputId.val(component.id);
					modal.find("button[id !='modalRegisterBtn']").show();
					modalRegisterBtn.hide();
					$("#componentModal").modal("show");
				});
				
			});
			
			/*Component 등록Form*/
			$("#regBtn").on("click", function() {
				modal.find("input[name='name']").val("");
				modal.find("button[id !='modalCloseBtn']").hide();
				
				modalRegisterBtn.show();
				$("#componentModal").modal("show");
			});
			
			
			
			/*Component 등록*/
			modalRegisterBtn.on("click",function(e){
				var component = {
					type:comType,
					name:modalInputName.val()
				};
				if(component.name===""){
					alert("입력이 필요합니다.");
					return;
				}
				componentService.add(component,function(result){
					modal.find("input").val("");
					modal.modal("hide");
					location.reload();
					
				});
			});
			
			
				
				
			// page 넘김
			var actionForm = $("#actionForm");
			$(".paginate_button a").on("click",function(e){
				e.preventDefault();
				console.log('click');
				actionForm.find("input[name='pageNum']").val($(this).attr("href"));
				actionForm.submit();
					
			});
		}
	);
</script>