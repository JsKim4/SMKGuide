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
							<th width="90%">이름</th>
						</tr>
					</thead>
					<c:forEach items="${list}" var="component">
						<tr>
							<td class="componentId" data-id='${component.id}' width="10%">
									<c:out value="${component.id }" /></td>
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
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/component.js?ver=2"></script>
<script type="text/javascript">
	$(document).ready(
		function() {
			console.log(componentService);
			var comType = '<c:out value = "${componentType}"/>'
			var modal = $("#componentModal");
			var modalInputName = modal.find("input[name='name']");
		
			var modalModBtn = $("#modalModBtn");
			var modalRemoveBtn = $("#modalRemoveBtn");
			var modalRegisterBtn = $("#modalRegisterBtn");
			
			
			
			
			
			$("#componentTable").on("click",".componentId",function(e){
				var rno = $(this).data("id");
				console.log(rno);
				e.preventDefault();
				/*replyService.get(rno,function(reply){
					modalInputReply.val(reply.reply);
					modalInputReplyer.val(reply.replyer);
					modalInputReplyDate.val(
							replyService.displayTime(reply.replydate)).
							attr("readonly","readonly");
					modal.data("rno",reply.rno);
					
					modal.find("button[id != 'modalCloseBtn']").hide();
					modalModBtn.show();
					modalRemoveBtn.show();
					
					$(".modal").modal("show");*/
				});
			/*Component 등록 시*/
			$("#regBtn").on("click", function() {
				modal.find("input[name='name']").val("");
				modal.find("button[id !='modalCloseBtn']").hide();
				
				modalRegisterBtn.show();
				
				$("#componentModal").modal("show");
			});
			/*Component 등록 버튼 클릭시*/
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
				// 상세정보
			$(".move").on("click",function(e){
				e.preventDefault();
				actionForm.append("<input type='hidden' name='tobaccoId' value='"+$(this).attr("href")+"'>");
				actionForm.attr("action","./get");
				actionForm.submit();
			});
		}
	);
</script>