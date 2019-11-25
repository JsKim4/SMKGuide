<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@include file="../includes/header.jsp"%>

<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">Member Register</h1>
	</div>
	<!-- /.col-lg-12 -->
</div>
<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">Member register Page</div>
			<!-- end panel-heading -->
			<div class="panel-body">
				<form action="./register" method="post">
				  <sec:csrfInput />
					<div class="form-group">
						<label>email</label> 
						<input class="form-control" name='email'>
					</div>
					<div class="form-group">
						<label>password</label> 
						<input class="form-control" name='password'>
					</div>
					<div class="form-group">
						<label>name</label> 
						<input class="form-control" name='memberName'>
					</div>
					<div class="form-group">
						<label>phone</label> 
						<input class="form-control" name='telephone'>
					</div>
					<div class="form-group">
						<label>address</label> 
						<input class="form-control" name='address'>
					</div>
					<div class='pull-right'>
						<button type="submit" class="btn btn-default">Submit Button</button>
						<button type="reset" class="btn btn-default">Reset Button</button>
					</div>
				</form>
			</div>
			<!-- end panel body -->
		</div>
		<!-- end panel-default -->
	</div>
	<!-- /.col-lg-12 -->
</div>
<!-- /.row -->
<%@include file="../includes/footer.jsp"%>