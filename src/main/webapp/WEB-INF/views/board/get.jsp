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

				<div class="form-group">
					<label>Bno</label> <input class="form-control" name='bno'
						value='<c:out value="${board.bno }"/>' readonly="readonly">
				</div>
				<div class="form-group">
					<label>Title</label> <input class="form-control" name='title'
						value='<c:out value="${board.title }"/>' readonly="readonly">
				</div>
				<div class="form-group">
					<label>Text area</label>
					<textarea class="form-control" rows="3" name='content'
						readonly="readonly">
							<c:out value="${board.content }" />
						</textarea>
				</div>
				<div class="form-group">
					<label>Writer</label> <input class="form-control" name='writer'
						value='<c:out value="${board.writer }"/>' readonly="readonly">
				</div>
				<button data-oper='modify' class="btn btn-default">Modify</button>
				<button data-oper='list'  class="btn btn-info">List</button>
				<form id='operForm' action="./modify" method="get">
					<input type="hidden" id='bno' name='bno' value='<c:out value="${board.bno }"/>'>
					<input type="hidden" name='pageNum'  value='<c:out value="${cri.pageNum }"/>'>
					<input type="hidden" name='amount'  value='<c:out value="${cri.amount }"/>'>
					<input type='hidden' name='type' value='${cri.type}'>
					<input type='hidden' name='keyword' value='${cri.keyword}'>
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
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/reply.js?ver=11"></script>
<!-- reply 관련 script -->
<script>
	$(document).ready(function() {
		var bnoValue='<c:out value="${board.bno}"/>'
		var replyUL = $(".chat");
		
		showList(1);
		
		function showList(page){
			replyService.getList(
				{bno:bnoValue,page:page||1},
				function(replyCnt,list){
					if(page==-1){
						pageNum=math.ceil(replyCnt/10.0);
						showList(pageNum);
						return;
					}
					var str="";
					if(list==null || list.length==0){
						return;
					}
					for(var i=0,len=list.length || 0; i<len;i++){
						str+="<li class='left clearfix' data-rno='"+list[i].rno+"'>";
						str+="	<div class='header'>";
						str+="		<strong class='primary-font'>"+list[i].replyer+"</strong>";
						str+="		<small class='pull-right text-muted'>"+replyService.displayTime(list[i].updatedate)+"</small>";
						str+="	</div>";
						str+="	<p>"+list[i].reply+"</p>";
						str+="</li>";
					}
					replyUL.html(str);
					showReplyPage(replyCnt);
				}
			);
		}
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
		
		var pageNum = 1;
		var replyPageFooter = $(".panel-footer");
		
		function showReplyPage(replyCnt){
			var endNum = Math.ceil(pageNum/10.0)*10;
			var startNum = endNum-9;
			var prev = startNum!=1;
			var next = false;
			
			if(endNum*10 >= replyCnt){
				endNum = Math.ceil(replyCnt/10.0);
			}
			
			if(endNum*10 < replyCnt){
				next = true;
			}
			
			var str = "<ul class='pagination pull-right'>";
			
			if(prev){
				str+="<li class='page-item'><a class='page-link' href='"+(startNum-1)+"'>Previous</a></li>";
			}
			for(var i=startNum;i<=endNum;i++){
				var active = pageNum== i ? "active" : "";
				str+="<li class='page-item'><a class='page-link' href='"+i+"'>"+i+"</a></li>";
			}
			
			
			if(next){
				str+="<li class='page-item'><a class='page-link' href='"+(endNum+1)+"'>Next</a></li>";
			}
			str+="</ul>"
			console.log(str);
			replyPageFooter.html(str);
		}
		
		replyPageFooter.on("click","li a",function(e){
			e.preventDefault();
			
			var targetPageNum = $(this).attr("href");
			pageNum = targetPageNum;
			showList(pageNum);
		});
		
		
	});
</script>
<!-- board 관련 script -->
<script type="text/javascript">
	$(document).ready(function() {
		console.log(replyService);
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