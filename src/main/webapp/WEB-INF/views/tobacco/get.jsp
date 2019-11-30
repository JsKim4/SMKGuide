<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
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
			<div class="panel-heading">Tobacco View</div>
			<!-- end panel-heading -->
			<div class="panel-body">
				<div class="col-lg-1 form-group">
					<input class="form-control" name='tobaccoId'
						value='<c:out value="${tobacco.tobaccoId }"/>' readonly="readonly">
				</div>
				<div class="col-lg-11 form-group">
					<input class="form-control" name='title'
						value='<c:out value="${tobacco.tobaccoName }"/>'
						readonly="readonly">
				</div>
				<div class="col-lg-4" style="text-align: center;">
					<img style="max-height: 270px; max-width: 270px"
						src='/display?fileName=${tobacco.attach.attachFileName}'>
				</div>
				<div class="col-lg-8">
					<div class="form-group">
						<label>nicotine</label> <input class="form-control"
							name='nicotine' value='<c:out value="${tobacco.nicotine }"/>'
							readonly="readonly">
					</div>
					<div class="form-group">
						<label>tar</label> <input class="form-control" name='tar'
							value='<c:out value="${tobacco.tar }"/>' readonly="readonly">
					</div>
					<div class="form-group">
						<label>amount</label> <input class="form-control" name='amount'
							value='<c:out value="${tobacco.quantity }"/>' readonly="readonly">
					</div>
					<div class="form-group">
						<label>price</label> <input class="form-control" name='price'
							value='<c:out value="${tobacco.price }"/>' readonly="readonly">
					</div>
					<div class="form-group">
						<label>Grade : </label> <input class="form-control" name='price'
							value='<c:out value="${tobacco.gradeSum/tobacco.gradeNum }"/>' readonly="readonly">
					</div>
				</div>
				<div class="form-group col-lg-3">
					<label>brand</label> <input class="form-control" name='brnad'
						value='<c:out value="${tobacco.brand.name }"/>'
						readonly="readonly">
				</div>
				<div class="form-group col-lg-3">
					<label>country</label> <input class="form-control" name='country'
						value='<c:out value="${tobacco.country.name }"/>'
						readonly="readonly">
				</div>
				<div class="form-group col-lg-3">
					<label>company</label> <input class="form-control" name='company'
						value='<c:out value="${tobacco.company.name }"/>'
						readonly="readonly">
				</div>
				<div class="form-group col-lg-3">
					<label>type</label> <input class="form-control" name='type'
						value='<c:out value="${tobacco.type.name }"/>' readonly="readonly">
				</div>
				<sec:authorize access="hasAnyRole('ROLE_ADMIN','ROLE_MANAGE')">
					<div class="col-sm-1">
						<button data-oper='modify' class="btn btn-default">Modify</button>
					</div>
				</sec:authorize>
				<div class="col-sm-1">
					<button data-oper='list' class="btn btn-info">List</button>
				</div>
				<sec:authorize access="hasAnyRole('ROLE_ADMIN','ROLE_MANAGE')">
					<div class="col-sm-2">
						<select class="form-control" id="grade">
					      <option value='5'>5</option>
					      <option value='4'>4</option>
					      <option value='3'>3</option>
					      <option value='2'>2</option>
					      <option value='1'>1</option>
					    </select>
					</div>
					<div class="col-sm-3">
						<button type="button" id="gradeSubmit" class="btn btn-default">점수 주기</button>
					</div>
				</sec:authorize>
				<form id='operForm' action="./modify" method="get">
					<input type="hidden" id='tobaccoId' name='tobaccoId'
						value='<c:out value="${tobacco.tobaccoId }"/>'> <input
						type="hidden" name='pageNum'
						value='<c:out value="${cri.pageNum }"/>'> <input
						type="hidden" name='amount'
						value='<c:out value="${cri.amount }"/>'> <input
						type='hidden' name='type' value='${cri.type}'> <input
						type='hidden' name='keyword' value='${cri.keyword}'> <input
						type='hidden' name='tId' value='${cri.TId}'> <input
						type='hidden' name='mId' value='${cri.MId}'> <input
						type='hidden' name='nId' value='${cri.NId}'> <input
						type='hidden' name='bId' value='${cri.BId}'>
				</form>
				
				<%@include file="comment_modal.jsp"%>
			</div>
			<!-- end panel body -->
		</div>
		<!-- end panel-default -->
	</div>
	<!-- /.col-lg-12 -->
</div>
<!-- ./ end row -->
<div class='row'>
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">
				<i class="fa fa-comments fa-fw"></i>Comment

				<sec:authorize access="isAuthenticated()">
					<button id='addCommentBtn'
						class='btn btn-primary btn-xs pull-right'>New Comment</button>
				</sec:authorize>
			</div>
			<!-- end pannel heading -->
			<div class="panel-body">
				<ul class="chat">
					<!-- start reply 
					<li class="left clearfix" data-rno='rno'>
						<div class="header">
							<strong class="primary-font">replyer</strong>
							<small class="pull-right text-muted">date</small>
						</div>
						<p>reply</p>
					</li>
					 end reply -->
				</ul>
				<!-- ul chat end -->
			</div>
			<!-- panel body -->
			<div class="panel-footer"></div>
		</div>
		<!-- end panel-default -->
	</div>
	<!-- ./ end col-lg-12 -->
</div>
<!-- ./end row -->
<%@include file="../includes/footer.jsp"%>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/js/comment.js?ver=12"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/js/grade.js?ver=12"></script>
<!-- reply 관련 script -->
<script>
$(document).ready(function() {
	var tobaccoValue = '<c:out value="${tobacco.tobaccoId}"/>'//출력되고 있는 담배 고유 번호
	var commentUL = $(".chat");
	var pageNum = 1; // Comment  페이지
	var commentPageFooter = $(".panel-footer"); //Comment 페이지 넘김 처리
	showList(1);
	var csrfHeaderName = "${_csrf.headerName}";
	var csrfTokenValue = "${_csrf.token}"
	$(document).ajaxSend(function(e, xhr, options) {xhr.setRequestHeader(csrfHeaderName,csrfTokenValue);});
	//Comment list 출력
	function showList(page) {
		commentService.getList(
		{
			type : 'T',
			id : tobaccoValue,
			page : page || 1,
		},
		function(pageDTO, list) {
			console.log(list);
			if (page == -1) {
				pageNum = pageDTO.total;
				showList(pageNum);
				return;
			}
			var str = "";
			if (list == null
					|| list.length == 0) {
				return;
			}
			for (var i = 0, len = list.length || 0; i < len; i++) {
				str += "<li class='left clearfix' data-commentid='"+list[i].commentId+"'>";
				str += "	<div class='header'>";
				str += "		<strong class='primary-font'>"
						+ list[i].member.email
						+ "</strong>";
				str += "		<small class='pull-right text-muted'>"
						+ commentService
								.displayTime(list[i].cdate)
						+ "</small>";
				str += "	</div>";
				str += "	<p>"
						+ list[i].content
						+ "</p>";
				str += "</li>";
			}
			commentUL.html(str);
			showCommentPage(pageDTO);
		});
	}
	//Comment list Page 출력
	function showCommentPage(pageDTO) {

		var str = "<ul class='pagination pull-right'>";

		if (pageDTO.prev) {
			str += "<li class='page-item'><a class='page-link' href='"
					+ (pageDTO.startPage - 1)
					+ "'>Previous</a></li>";
		}
		for (var i = pageDTO.startPage; i <= pageDTO.endPage; i++) {
			var active = pageNum == i ? "active" : "";
			str += "<li class='page-item "+active+"'><a class='page-link' href='"+i+"'>"
					+ i + "</a></li>";
		}

		if (pageDTO.next) {
			str += "<li class='page-item'><a class='page-link' href='"
					+ (pageDTO.endPage + 1)
					+ "'>Next</a></li>";
		}
		str += "</ul>"
		commentPageFooter.html(str);
	}

	var modal = $(".modal"); //Comment 처리용  modal
	var modalInputContent = modal
			.find("input[name='content']"); //Comment 내용
	var modalInputCommenter = modal
			.find("input[name='email']");
	var modalInputCommentDate = modal
			.find("input[name='cdate']");

	var modalModBtn = $("#modalModBtn"); // Comment 변경
	var modalRemoveBtn = $("#modalRemoveBtn"); // Comment 삭제
	var modalRegisterBtn = $("#modalRegisterBtn"); //Comment 등록
	var modalCloseBtn = $("#modalCloseBtn"); // Comment modal close

	//Close 버튼 처리
	modalCloseBtn.on("click", function(e) {
		$(".modal").modal("hide");
	});

	//Comment 등록 Form 처리
	$("#addCommentBtn").on("click", function(e) {
		modalInputContent.val("");
		modal.find("button[id !='modalCloseBtn']").hide();

		modalRegisterBtn.show();
		//modalInputCommenter.closest("div").hide();
		modalInputCommentDate.closest("div").hide();
		$(".modal").modal("show");

	});
	//Comment 등록
	modalRegisterBtn.on("click", function(e) {
		var comment = {
			content : modalInputContent.val(),
			tobacco : {
				tobaccoId : tobaccoValue
			},
			member : {
				email : modalInputCommenter.val()
			}
		}
		if (comment.content === "") {
			alert("입력이 필요합니다.");
			return;
		}
		console.log(comment);
		commentService.add(comment, function(result) {
			if (result === "success") {
				modalInputContent.val("");
				modal.modal("hide");
				showList(1);
			} else
				alert("입력 실패");
		})
	});
	$(".chat").on("click","li",function(e) {
		var commentId = $(this).data("commentid");
		commentService.get(commentId,function(comment) {
			modalInputContent.val(comment.content);
			modalInputCommenter.val(comment.member.email);
			modalInputCommentDate.val(commentService.displayTime(comment.cdate)).attr("readonly","readonly");
			modal.data("commentid",comment.commentId);
			modal.find("button[id != 'modalCloseBtn']").hide();
			modalModBtn.show();
			modalRemoveBtn.show();
			$(".modal").modal(	"show");
		});
	});

	//Comment 페이지 넘김
	commentPageFooter.on("click", "li a", function(e) {
		e.preventDefault();

		var targetPageNum = $(this).attr("href");
		pageNum = targetPageNum;
		showList(pageNum);
	});

	modalModBtn.on("click", function(e) {
		var comment = {
			commentId : modal.data("commentid"),
			content : modalInputContent.val(),
			member : {
				email : modalInputCommenter.val()
			}
		};

		commentService.update(comment, function(result) {
			//alert(result);
			modal.modal("hide");
			showList(pageNum);
		});
	});
	modalRemoveBtn.on("click", function(e) {
		var comment = {
				commentId : modal.data("commentid"),
				member : {
					email : modalInputCommenter.val()
				}
			};

		commentService.remove(comment, function(result) {
			//alert(result);
			modal.modal("hide");
			showList(pageNum);
		})
	});
	var geadeForm = $("#gradeForm");	
	var gradeSubmit = $("#gradeSubmit");
	gradeSubmit.on("click", function(e) {
		var scoreValue = $("#grade").val();
		var grade = {
				score:scoreValue,
				tobaccoId:tobaccoValue
		}
		console.log(grade);
		gradeService.add(grade,function(result){
			var tobaccoName = '<c:out value="${tobacco.tobaccoName}"/>'//출력되고 있는 담배 고유 번호
			alert(tobaccoName+"에 "+grade.score+"점을 주었습니다.");
		});
		
	});

});
</script>
<!-- board 관련 script -->
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
			if (result === 'fail')
				$(".modal-body").html("삭제되거나 존재하지 않는 게시물 입니다.");
			$("#myModal").modal("show");
		}

		var operForm = $("#operForm");
		$("button[data-oper='modify']").on("click", function(e) {
			operForm.attr("action", "./modify").submit();
		});
		$("button[data-oper='list']").on("click", function(e) {
			operForm.find("#bno").remove();
			operForm.attr("action", "./list").submit();
		});
	});
</script>