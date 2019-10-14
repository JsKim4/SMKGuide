<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@include file="../includes/header.jsp"%>
<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">Board Read</h1>
	</div>
	<!-- /.col-lg-12 -->
</div>
<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">Board Read Page</div>
			<!-- end panel-heading -->
			<div class="panel-body">
				<form role="form" action="./modify" method="post">
					<input type="hidden" name='pageNum'  value='<c:out value="${cri.pageNum }"/>'>
					<input type="hidden" name='amount'  value='<c:out value="${cri.amount }"/>'>
					<input type='hidden' name='type' value='${cri.type}'>
					<input type='hidden' name='keyword' value='${cri.keyword}'>
					
					<div class="form-group">
						<label>Bno</label> <input class="form-control" name='bno'
							value='<c:out value="${board.bno }"/>' readonly="readonly">
					</div>
					<div class="form-group">
						<label>Title</label> <input class="form-control" name='title'
							value='<c:out value="${board.title }"/>'>
					</div>
					<div class="form-group">
						<label>Text area</label>
						<textarea class="form-control" rows="3" name='content'>
							<c:out value="${board.content }" />
						</textarea>
					</div>
					<div class="form-group">
						<label>Writer</label> <input class="form-control" name='writer'
							value='<c:out value="${board.writer }"/>' readonly="readonly">
					</div>
					<button type="submit" data-oper='modify' class="btn btn-default">
						Modify</button>
					<button type="submit" data-oper='remove' class="btn btn-danger">
						Remove</button>
					<button type="submit" data-oper='list' class="btn btn-info">
						List</button>
				</form>
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
	$(document).ready(function() {
		var result = '<c:out value="${result}"/>';
		checkModal(result);
		//checkModal 1회 시행후  history의 state 상태를 null 처리하여 뒤로가기 시에도 modal 시행 안되게 변경
		history.replaceState({}, null, null);
		function checkModal(result) {
			if (result === '') {
				return;
			}
			$(".modal-body").html("삭제되거나 존재하지 않는 게시물 입니다.");
			$("#myModal").modal("show");
		}
		var formObj = $("form");
		$('button').on("click", function(e) {
			e.preventDefault();
			// 클릭한 이벤트의 data의 oper속성 값 가져옴
			var operation = $(this).data("oper");
			// 추출한 oper 값 console에 출력
			console.log(operation);

			if (operation === 'remove')
				formObj.attr("action", "./remove");//form의 action 변경
			else if (operation === 'list') {
				formObj.attr("action", "./list").attr("method", "get");//form 상태 변경
				var pageNumTag =  $("input[name='pageNum']").clone();
				var amountTag =  $("input[name='amount']").clone();
				var typeTag =  $("input[name='type']").clone();
				var keywordTag =  $("input[name='keyword']").clone();
				formObj.empty(); // form태그 내의 모든 내용 삭제
				formObj.append(pageNumTag);
				formObj.append(amountTag);
				formObj.append(typeTag);
				formObj.append(keywordTag);
			}
			formObj.submit();
		});
	});
</script>