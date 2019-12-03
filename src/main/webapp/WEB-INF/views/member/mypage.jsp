<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" buffer="128kb"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@include file="../includes/header.jsp"%>
<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">My Page</h1>
	</div>
	<!-- /.col-lg-12 -->
</div>
<div class="row">
	<div class="col-lg-12">
		<div class="panel-default">
			<div class="panel-heading">
				<h3 class="panel-title">My Page</h3>
			</div>
			<div class="panel-body">
				<table>
					<tr>
						<td>Email :</td>
						<td>${member.email}</td>
					</tr>
					<tr>
						<td>name :</td>
						<td>${member.memberName}</td>
					</tr>
					<tr>
						<td>address :</td>
						<td>${member.address}</td>
					</tr>
					<tr>
						<td>Phone Number :</td>
						<td>${member.telephone}</td>
					</tr>
				</table>

				
				<div class="col-lg-4 col-md-6 col-sm-12">
					<div class="panel panel-default">
						<div class="panel-heading">
							<i class="fa fa-comments fa-fw"></i>Comment
						</div>
						<!-- end pannel heading -->
						<div class="panel-body">
							<ul class="chat comment">
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
						<div class="panel-footer comment"></div>
					</div>
					<!-- end panel-default -->
				</div>
				<div class="col-lg-4 col-md-6 col-sm-12">
					<div class="panel panel-default">
						<div class="panel-heading">
							<i class="fa fa-comments fa-fw"></i>smokelog
						</div>
						<!-- end pannel heading -->
						<div class="panel-body">
							<ul class="chat smokelog">
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
						<div class="panel-footer smokelog"></div>
					</div>
					<!-- end panel-default -->
				</div>
				<!-- ./ end col-lg-12 -->
				<div class="col-lg-4 col-md-6 col-sm-12">
					<div class="panel panel-default">
						<div class="panel-heading">
							<i class="fa fa-comments fa-fw"></i>grade
						</div>
						<!-- end pannel heading -->
						<div class="panel-body">
							<ul class="chat grade">
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
						<div class="panel-footer grade"></div>
					</div>
					<!-- end panel-default -->
				</div>
				<!-- ./ end col-lg-12 -->
			</div>
		</div>
	</div>
</div>
<%@include file="../includes/footer.jsp"%>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/js/comment.js?ver=12"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/js/smokelog.js?ver=12"></script>
	<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/js/grade.js?ver=12"></script>
<script>
$(document).ready(function() {
	
	var pageNum = 1; // Comment  페이지
	var commentPageFooter = $(".panel-footer.comment"); //Comment 페이지 넘김 처리
	var commentUL = $(".chat.comment");
	showCommentList(1);
	//showSmokelogList(1);
	var csrfHeaderName = "${_csrf.headerName}";
	var csrfTokenValue = "${_csrf.token}"
	$(document).ajaxSend(function(e, xhr, options) {xhr.setRequestHeader(csrfHeaderName,csrfTokenValue);});
	function showCommentList(page) {
		commentService.getList({
			type : 'M',
			id :" ${member.memberId}",
			page : page || 1,
		},function(pageDTO, list) {
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
						+ list[i].tobacco.tobaccoName
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
		str += "</ul>";
		commentPageFooter.html(str);
	}
	//Comment 페이지 넘김
	commentPageFooter.on("click", "li a", function(e) {
		e.preventDefault();

		var targetPageNum = $(this).attr("href");
		pageNum = targetPageNum;
		showCommentList(pageNum);
	});
});
</script>


<script>
$(document).ready(function() {
	
	var pageNum = 1; // Comment  페이지
	var smokelogPageFooter = $(".panel-footer.smokelog"); //Comment 페이지 넘김 처리
	var smokelogUL = $(".chat.smokelog");
	showSmokelogList(1);
	var csrfHeaderName = "${_csrf.headerName}";
	var csrfTokenValue = "${_csrf.token}"
	$(document).ajaxSend(function(e, xhr, options) {xhr.setRequestHeader(csrfHeaderName,csrfTokenValue);});
	function showSmokelogList(page) {
		smokelogService.getList({
			type : 'M',
			id :" ${member.memberId}",
			page : page || 1,
		},function(pageDTO, list) {
			console.log(list);
			if (page == -1) {
				pageNum = pageDTO.total;
				showSmokeList(pageNum);
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
						+ list[i].tobacco.tobaccoName
						+ "</strong>";
				str += "		<small class='pull-right text-muted'>"
						+ smokelogService
								.displayTime(list[i].cdate)
						+ "</small>";
				str += "	</div>";
				str += "</li>";
			}
			smokelogUL.html(str);
			showSmokelogPage(pageDTO);
		});
	}
	//Comment list Page 출력
	function showSmokelogPage(pageDTO) {

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
		str += "</ul>";
		smokelogPageFooter.html(str);
	}
	smokelogPageFooter.on("click", "li a", function(e) {
		e.preventDefault();

		var targetPageNum = $(this).attr("href");
		pageNum = targetPageNum;
		showSmokelogList(pageNum);
	});
	
});
</script>



<script>
$(document).ready(function() {
	
	var pageNum = 1; // Comment  페이지
	var gradePageFooter = $(".panel-footer.grade"); //Comment 페이지 넘김 처리
	var gradeUL = $(".chat.grade");
	showGradeList(1);
	var csrfHeaderName = "${_csrf.headerName}";
	var csrfTokenValue = "${_csrf.token}"
	$(document).ajaxSend(function(e, xhr, options) {xhr.setRequestHeader(csrfHeaderName,csrfTokenValue);});
	function showGradeList(page) {
		gradeService.getList({
			type : 'M',
			id :" ${member.memberId}",
			page : page || 1,
		},function(pageDTO, list) {
			console.log(list);
			if (page == -1) {
				pageNum = pageDTO.total;
				showSmokeList(pageNum);
				return;
			}
			var str = "";
			if (list == null
					|| list.length == 0) {
				return;
			}
			for (var i = 0, len = list.length || 0; i < len; i++) {
				for (var i = 0, len = list.length || 0; i < len; i++) {
					str += "<li class='left clearfix' data-commentid='"+list[i].commentId+"'>";
					str += "	<div class='header'>";
					str += "		<strong class='primary-font'>"
							+ list[i].tobacco.tobaccoName
							+ "</strong>";
					str += "	</div>";
					str += "	<p>"
							+ list[i].score
							+ " 점</p>";
					str += "</li>";
				}
			}
			gradeUL.html(str);
			showGradePage(pageDTO);
		});
	}
	//Comment list Page 출력
	function showGradePage(pageDTO) {

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
		str += "</ul>";
		gradePageFooter.html(str);
	}
	gradePageFooter.on("click", "li a", function(e) {
		e.preventDefault();

		var targetPageNum = $(this).attr("href");
		pageNum = targetPageNum;
		showGradeList(pageNum);
	});
	
});
</script>