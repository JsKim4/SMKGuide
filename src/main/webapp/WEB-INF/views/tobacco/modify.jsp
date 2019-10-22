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
			<div class="panel-heading">Tobacco Modify</div>
			<!-- end panel-heading -->
			<div class="panel-body">
				<form role="form" action="./modify" method="post"  enctype="multipart/form-data">
					<input type="hidden" name='pageNum'  value='<c:out value="${cri.pageNum }"/>'>
					<input type="hidden" name='amount'  value='<c:out value="${cri.amount }"/>'>
					<input type='hidden' name='type' value='${cri.type}'>
					<input type='hidden' name='keyword' value='${cri.keyword}'>
					<input type='hidden' name='tId' value='${cri.TId}'>
					<input type='hidden' name='mId' value='${cri.MId}'>
					<input type='hidden' name='nId' value='${cri.NId}'>
					<input type='hidden' name='bId' value='${cri.BId}'>

					<div class="col-lg-1 form-group">
						<input class="form-control" name='tobaccoId'
							value='<c:out value="${tobacco.tobaccoId }"/>'
							readonly="readonly">
					</div>
					<div class="col-lg-11 form-group">
						<input class="form-control" name='tobaccoName'
							value='<c:out value="${tobacco.tobaccoName }"/>'>
					</div>
					<div class="col-lg-3"></div>
					<div class="col-lg-9">
						<div class="form-group">
							<label>nicotine</label> <input class="form-control"
								name='nicotine' value='<c:out value="${tobacco.nicotine }"/>'>
						</div>
						<div class="form-group">
							<label>tar</label> <input class="form-control" name='tar'
								value='<c:out value="${tobacco.tar }"/>'>
						</div>
						<div class="form-group">
							<label>quantity</label> <input class="form-control" name='quantity'
								value='<c:out value="${tobacco.quantity }"/>'>
						</div>
						<div class="form-group">
							<label>price</label> <input class="form-control" name='price'
								value='<c:out value="${tobacco.price }"/>'>
						</div>
					</div>
					<div class="form-group col-lg-3">
						<label>brand</label> 
						<select name='brand.id'>
							<c:forEach items="${brandList}" var="brand">
								<option value="${brand.id}" <c:out value="${tobacco.brand.id==brand.id?'selected':''}"/>>${brand.name }</option>
							</c:forEach>
						</select>
					</div>
					<div class="form-group col-lg-3">
						<label>country</label> 
						<select name='country.id'>
							<c:forEach items="${countryList}" var="country">
								<option value="${country.id}" <c:out value="${tobacco.country.id==country.id?'selected':''}"/>>${country.name }</option>
							</c:forEach>
						</select>
					</div>
					<div class="form-group col-lg-3">
						<label>company</label> 
						<select name='company.id'>
							<c:forEach items="${companyList}" var="company">
								<option value="${company.id}" <c:out value="${tobacco.company.id==company.id?'selected':''}"/>>${company.name }</option>
							</c:forEach>
						</select>
					</div>
					<div class="form-group col-lg-3">
						<label>type</label> 
						<select name='type.id'>
							<c:forEach items="${typeList}" var="type">
								<option value="${type.id}" <c:out value="${tobacco.type.id==type.id?'selected':''}"/>>${type.name }</option>
							</c:forEach>
						</select>
					</div>
					<div class='form-group'>
						<input type="file" name="uploadFile" value="${tobacco.attach.fileName}">
					</div>
					<div class="col-lg-12">
						<button type="submit" data-oper='modify' class="btn btn-default">
						Modify</button>
						<button type="submit" data-oper='remove' class="btn btn-danger">
							Remove</button>
						<button type="submit" data-oper='list' class="btn btn-info">
							List</button>
					</div>
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
				var pageNumTag = $("input[name='pageNum']").clone();
				var amountTag = $("input[name='amount']").clone();
				var typeTag = $("input[name='type']").clone();
				var keywordTag = $("input[name='keyword']").clone();
				var mIdTag = $("input[name='mId']").clone();
				var nIdTag = $("input[name='nId']").clone();
				var tIdTag = $("input[name='tId']").clone();
				var bIdTag = $("input[name='bId']").clone();
				formObj.empty(); // form태그 내의 모든 내용 삭제
				formObj.append(pageNumTag);
				formObj.append(amountTag);
				formObj.append(typeTag);
				formObj.append(keywordTag);
				formObj.append(mIdTag);
				formObj.append(nIdTag);
				formObj.append(tIdTag);
				formObj.append(bIdTag);
			}
			formObj.submit();
		});
	});
</script>