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
			<div class="panel-heading">Tobacco View</div>
			<!-- end panel-heading -->
			<div class="panel-body">

				<div class="col-lg-1 form-group">
				 <input class="form-control" name='tobaccoId' value='<c:out value="${tobacco.tobaccoId }"/>' readonly="readonly">
				</div>
				<div class="col-lg-11 form-group">
				 <input class="form-control" name='title' value='<c:out value="${tobacco.tobaccoName }"/>' readonly="readonly">
				</div>
				<div class="col-lg-3">
				</div>
				<div class="col-lg-9">
					<div class="form-group">
						<label>nicotine</label>
						<input class="form-control" name='nicotine' value='<c:out value="${tobacco.nicotine }"/>' readonly="readonly">
					</div>
					<div class="form-group">
						<label>tar</label> 
						<input class="form-control" name='tar' value='<c:out value="${tobacco.tar }"/>' readonly="readonly">
					</div>
					<div class="form-group">
						<label>amount</label> 
						<input class="form-control" name='amount' value='<c:out value="${tobacco.quantity }"/>' readonly="readonly">
					</div>
					<div class="form-group">
						<label>price</label> 
						<input class="form-control" name='price' value='<c:out value="${tobacco.price }"/>' readonly="readonly">
					</div>
				</div>
					<div class="form-group col-lg-3">
						<label>brand</label> 
						<input class="form-control" name='brnad' value='<c:out value="${tobacco.brand.name }"/>' readonly="readonly">
					</div>
					<div class="form-group col-lg-3">
						<label>country</label> 
						<input class="form-control" name='country' value='<c:out value="${tobacco.country.name }"/>' readonly="readonly">
					</div>
					<div class="form-group col-lg-3">
						<label>company</label> 
						<input class="form-control" name='company' value='<c:out value="${tobacco.company.name }"/>' readonly="readonly">
					</div>
					<div class="form-group col-lg-3">
						<label>type</label> 
						<input class="form-control" name='type' value='<c:out value="${tobacco.type.name }"/>' readonly="readonly">
					</div>
				<button data-oper='modify' class="btn btn-default">Modify</button>
				<button data-oper='list'  class="btn btn-info">List</button>
				<form id='operForm' action="./modify" method="get">
					<input type="hidden" id='tobaccoId' name='tobaccoId' value='<c:out value="${tobacco.tobaccoId }"/>'>
					<input type="hidden" name='pageNum'  value='<c:out value="${cri.pageNum }"/>'>
					<input type="hidden" name='amount'  value='<c:out value="${cri.amount }"/>'>
					<input type='hidden' name='type' value='${cri.type}'>
					<input type='hidden' name='keyword' value='${cri.keyword}'>
					<input type='hidden' name='tId' value='${cri.TId}'>
					<input type='hidden' name='mId' value='${cri.MId}'>
					<input type='hidden' name='nId' value='${cri.NId}'>
					<input type='hidden' name='bId' value='${cri.BId}'>
				</form>
				<%@include file="reply_modal.jsp"%>
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
				<i class="fa fa-comments fa-fw"></i>Reply
				<button id='addReplyBtn' class='btn btn-primary btn-xs pull-right'>New Reply</button>
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
			<div class="panel-footer">
				
			</div>
		</div>
		<!-- end panel-default -->
	</div>
	<!-- ./ end col-lg-12 -->
</div>
<!-- ./end row -->
<%@include file="../includes/footer.jsp"%>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/comment.js?ver=16"></script>
<!-- reply 관련 script -->
<script>
	$(document).ready(function() {
		var tobaccoValue='<c:out value="${tobacco.tobaccoId}"/>'
		var commentUL = $(".chat");
		var pageNum = 1;
		var replyPageFooter = $(".panel-footer");
		
		showList(1);
		
		function showList(page){
			commentService.getList(
				{type:'T',id:tobaccoValue,page:page||1,},
				function(pageDTO,list){
					console.log(pageDTO);
					console.log(list);
					if(page==-1){
						pageNum=pageDTO.total;
						showList(pageNum);
						return;
					}
					var str="";
					if(list==null || list.length==0){
						return;
					}
					for(var i=0,len=list.length || 0; i<len;i++){
						str+="<li class='left clearfix' data-rno='"+list[i].commentId+"'>";
						str+="	<div class='header'>";
						str+="		<strong class='primary-font'>"+list[i].member.email+"</strong>";
						str+="		<small class='pull-right text-muted'>"+list[i].cdate+"</small>";
						str+="	</div>";
						str+="	<p>"+list[i].content+"</p>";
						str+="</li>";
					}
					commentUL.html(str);
					showCommentPage(pageDTO);
				}
			);
		}
		function showCommentPage(pageDTO){
			
			var str = "<ul class='pagination pull-right'>";
			
			if(pageDTO.prev){
				str+="<li class='page-item'><a class='page-link' href='"+(pageDTO.startPage-1)+"'>Previous</a></li>";
			}
			for(var i=pageDTO.startPage;i<=pageDTO.endPage;i++){
				var active = pageNum== i ? "active" : "";
				str+="<li class='page-item'><a class='page-link' href='"+i+"'>"+i+"</a></li>";
			}	
			
			if(pageDTO.next){
				str+="<li class='page-item'><a class='page-link' href='"+(pageDTO.endPage+1)+"'>Next</a></li>";
			}
			str+="</ul>"
			replyPageFooter.html(str);
		}
		/*
		var modal = $(".modal");
		var modalInputReply = modal.find("input[name='reply']");
		var modalInputReplyer = modal.find("input[name='replyer']");
		var modalInputReplyDate = modal.find("input[name='replydate']");
		
		var modalModBtn = $("#modalModBtn");
		var modalRemoveBtn = $("#modalRemoveBtn");
		var modalRegisterBtn = $("#modalRegisterBtn");
		
		$("#addReplyBtn").on("click",function(e){
			modal.find("input").val("");
			modalInputReplyDate.closest("div").hide();
			modal.find("button[id !='modalCloseBtn']").hide();
			
			modalRegisterBtn.show();
			
			$(".modal").modal("show");
			
		});
		$(".chat").on("click","li",function(e){
			var rno = $(this).data("rno");
			
			replyService.get(rno,function(reply){
				modalInputReply.val(reply.reply);
				modalInputReplyer.val(reply.replyer);
				modalInputReplyDate.val(
						replyService.displayTime(reply.replydate)).
						attr("readonly","readonly");
				modal.data("rno",reply.rno);
				
				modal.find("button[id != 'modalCloseBtn']").hide();
				modalModBtn.show();
				modalRemoveBtn.show();
				
				$(".modal").modal("show");
			});
		});
		
		modalRegisterBtn.on("click",function(e){
			var reply = {
				reply:modalInputReply.val(),
				replyer:modalInputReplyer.val(),
				bno:bnoValue
			};
			if(reply.reply===""){
				alert("입력이 필요합니다.");
				return;
			}
			replyService.add(reply,function(result){
				alert(result);
				
				modal.find("input").val("");
				modal.modal("hide");
				
				showList(1);
				//showList(-1) 오래된 댓글을 먼저 출력할경우
			})
		});
		modalModBtn.on("click",function(e){ 
			var reply = {rno:modal.data("rno"),reply:modalInputReply.val()};
			
			replyService.update(reply,function(result){
				alert(result);
				modal.modal("hide");
				showList(pageNum);
			});
		});
		modalRemoveBtn.on("click",function(e){
			var rno = modal.data("rno");
			
			replyService.remove(rno,function(result){
				alert(result);
				modal.modal("hide");
				showList(pageNum);
			})
		});
		
		
		replyPageFooter.on("click","li a",function(e){
			e.preventDefault();
			
			var targetPageNum = $(this).attr("href");
			pageNum = targetPageNum;
			showList(pageNum);
		});
		*/
		
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
			if(result==='fail')
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