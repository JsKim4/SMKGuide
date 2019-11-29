<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">&times;</button>
				<h4 class="modal-title" id="myModalLabel">Reply Modal</h4>
			</div>
			<div class="modal-body">
				<div class="form-group">
					<label>Commenter</label>
					<sec:authorize access="isAnonymous()">
						<input class="form-control" name='email' value=''
							readonly="readonly">
					</sec:authorize>
					<sec:authorize access="!isAnonymous()">
						<input class="form-control" name='email' value='<sec:authentication property="principal.username"/>'
						readonly="readonly">
					</sec:authorize>
				</div>
				<div class="form-group">
					<label>Content</label> <input class="form-control" name='content'
						value='replyer'>
				</div>
				<div class="form-group">
					<label>Comment Date</label> <input class="form-control"
						name='cdate' value=''>
				</div>
			</div>
			<div class="modal-footer">

				<button id='modalModBtn' type="button" class="btn btn-warning">Modify</button>
				<button id='modalRemoveBtn' type="button" class="btn btn-danger">Remove</button>
				<button id='modalRegisterBtn' type="button" class="btn btn-primary">Register</button>
				<button id='modalCloseBtn' type="button" class="btn btn-default">Close</button>
			</div>
		</div>
		<!-- /.modal-content -->
	</div>
	<!-- /.modal-dialog -->
</div>