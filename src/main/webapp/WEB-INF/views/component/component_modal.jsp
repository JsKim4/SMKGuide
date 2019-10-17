<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="modal fade" id="componentModal" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true" >
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">&times;</button>
				<h4 class="modal-title" id="myModalLabel">${componentType} Modal</h4>
			</div>
			<div class="modal-body">
			<div class="form-group">
					<label>ID</label> <input class="form-control" name='id'
						value='<c:out value =""/>' readonly='readonly'>
				</div>
				<div class="form-group">
					<label>Type</label> <input class="form-control" name='type'
						value='<c:out value = "${componentType}"/>' readonly='readonly'>
				</div>
				<div class="form-group">
					<label>Name</label> <input class="form-control" name='name'
						value='asdasd'>
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