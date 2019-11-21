<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="modal fade" id="modal" tabindex="-1" role="dialog"
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
					<label>ID</label> <input class="form-control" name='areaId'
						value='<c:out value =""/>' readonly='readonly'>
				</div>
				<div class="form-group">
					<label>Name</label> <input class="form-control" name='areaName'
						value='asdasd'>
				</div>
				<div class="form-group">
					<label>Latitude(/위도)</label> <input class="form-control" name='latitude'
						value='1234'>
				</div>
				<div class="form-group">
					<label>Longitude(/경도)</label> <input class="form-control" name='longitude'
						value='5678'>
				</div>
			</div>
			<div class="modal-footer">
				<button id='modalRemoveBtn' type="button" class="btn btn-danger">Remove</button>
				<button id='modalRegisterBtn' type="button" class="btn btn-primary">Register</button>
				<button id='modalCloseBtn' type="button" class="btn btn-default">Close</button>
			</div>
		</div>
		<!-- /.modal-content -->
	</div>
	<!-- /.modal-dialog -->
</div>