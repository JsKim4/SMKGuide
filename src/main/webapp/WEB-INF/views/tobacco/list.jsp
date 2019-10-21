<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" buffer="128kb"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@include file="../includes/header.jsp"%>
<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">Tobaccos</h1>
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
							<th>#번호</th>
							<th>담배명</th>
							<th>브랜드명</th>
							<th>수량</th>
							<th>가격</th>
						</tr>
					</thead>
					<c:forEach items="${list}" var="tobacco">
						<tr>
							<td><a class='move' href='<c:out value="${tobacco.tobaccoId}"/>'>
									<c:out value="${tobacco.tobaccoId}" />
							</a></td>
							<td><c:out value="${tobacco.tobaccoName }" /> <b>[ <c:out value="${tobacco.commentCnt}" /> ]</td>
							<td><c:out value="${tobacco.brand.name }" /></td>
							<td><c:out value="${tobacco.quantity }" /></td>
							<td><c:out value="${tobacco.price }" /></td>
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
						<input type='hidden' name='tId' value='${pageMaker.cri.TId}'>
						<input type='hidden' name='mId' value='${pageMaker.cri.MId}'>
						<input type='hidden' name='nId' value='${pageMaker.cri.NId}'>
						<input type='hidden' name='bId' value='${pageMaker.cri.BId}'>
					</form>
					<form id='searchForm' action="./list" method='get'>
						<div>
							<select name='bId' >
								<option value="" <c:out value="${pageMaker.cri.BId==null?'selected':''}"/>>Brand</option>
								<c:forEach items="${brandList}" var="brand">
									<option value="${brand.id}" <c:out value="${pageMaker.cri.BId==brand.id?'selected':''}"/>>${brand.name }</option>
								</c:forEach>
							</select> 
							
							<select name='tId'>
								<option value="">Type</option>
								<c:forEach items="${typeList}" var="type">
									<option value="${type.id}" <c:out value="${pageMaker.cri.TId==type.id?'selected':''}"/>>${type.name }</option>
								</c:forEach>
							</select> 
							
							<select name='nId'>
								<option value="" >country</option>
								<c:forEach items="${countryList}" var="country">
									<option value="${country.id}" <c:out value="${pageMaker.cri.NId==country.id?'selected':''}"/>>${country.name }</option>
								</c:forEach>
							</select> 
							
							<select name='mId'>
								<option value="">Company</option>
								<c:forEach items="${companyList}" var="company">
									<option value="${company.id}" <c:out value="${pageMaker.cri.MId==company.id?'selected':''}"/>>${company.name }</option>
								</c:forEach>
							</select> 
							<input type='text' name='keyword' value='<c:out value="${pageMaker.cri.keyword}"/>'/>
							<input type='hidden' name='type' value='${pageMaker.cri.type}'>
							<input type='hidden' name='pageNum' value='${pageMaker.cri.pageNum}'>
							<input type='hidden' name='amount' value='${pageMaker.cri.amount}'>
							<button class='btn btn-default'>Search</button>
						</div>
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
				
				var searchForm =$('#searchForm');
				$("#searchForm button").on("click",function(e){
					var type="";
					if(searchForm.find("select[name='bId']").val()){
						type = type+"B";
					}
					if(searchForm.find("select[name='tId']").val()){
						type = type+"T";
					}
					if(searchForm.find("select[name='mId']").val()){
						type = type+"M";
					}
					if(searchForm.find("select[name='nId']").val()){
						type = type+"N";
					}
					searchForm.find("input[name='type']").val(type);
					searchForm.find("input[name='pageNum']").val("1");
					e.preventDefault();
					searchForm.submit();
					
				});
			});
</script>