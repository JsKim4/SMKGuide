<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" buffer="128kb"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@include file="../includes/header.jsp"%>
<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">Components</h1>
	</div>
	<!-- /.col-lg-12 -->
</div>
<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">
				Tobacco List
				<button id="regBtn" type="button" class="btn btn-xs pull-right">
					Register New Tobacco</button>
			</div>
			<!-- end panel-heading -->
			<div class="panel-body">
				<table class="table table-striped table-bordered table hover">
					<thead>
						<tr>
							<th>번호</th>
							<th colspan="3">이름</th>
						</tr>
					</thead>
				</table>
				<div class='pull-right'>
					<ul class="pagination">
						
					</ul>
					<form id='actionForm' action="./list" method='get'>
						<input type='hidden' name='pageNum' value='${pageMaker.cri.pageNum}'>
						<input type='hidden' name='amount' value='${pageMaker.cri.amount}'>
						<input type='hidden' name='type' value='${pageMaker.cri.type}'>
						<input type='hidden' name='keyword' value='${pageMaker.cri.keyword}'>
						<input type='hidden' name='tId' value='${pageMaker.cri.TId}'>
						<input type='hidden' name='mId' value='${pageMaker.cri.MId}'>
						<input type='hidden' name='nId' value='${pageMaker.cri.NId}'>
						<input type='hidden' name='bId' value='${pageMaker.cri.BId}'>
					</form>
				</div>
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
<script type="text/javascript">
	$(document).ready(
			function() {
				var result = '<c:out value="${result}"/>';
				checkModal(result);
				//checkModal 1회 시행후  history의 state 상태를 null 처리하여 뒤로가기 시에도 modal 시행 안되게 변경
				history.replaceState({}, null, null);
				function checkModal(result) {
					if (result === '' || history.state) {
						return;
					}
					if(result==='success')
						$(".modal-body").html(
								"수정에 성공하였습니다.");
					else if (parseInt(result) > 0) {
						$(".modal-body").html(
								"담배 " + parseInt(result) + " 번이 등록되었습니다.");
					}else{
						$(".modal-body").html(
								"등록이 실패하였습니다.");
						
					}
					$("#myModal").modal("show");
				}

				$("#regBtn").on("click", function() {
					self.location = "./register";
				});
				
				var actionForm = $("#actionForm");
				$(".paginate_button a").on("click",function(e){
					e.preventDefault();
					console.log('click');
					actionForm.find("input[name='pageNum']").val($(this).attr("href"));
					actionForm.submit();
					
				});
				
				$(".move").on("click",function(e){
					e.preventDefault();
					actionForm.append("<input type='hidden' name='tobaccoId' value='"+$(this).attr("href")+"'>");
					actionForm.attr("action","./get");
					actionForm.submit();
				});
			});
</script>