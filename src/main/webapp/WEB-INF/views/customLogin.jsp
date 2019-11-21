<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" buffer="128kb"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@include file="includes/header.jsp"%>
<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">Login</h1>
	</div>
	<!-- /.col-lg-12 -->
</div>
<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">로그인</div>
			<!-- end panel-heading -->
			<div class="panel-body">
				<form method="post" action="/login">
					<div>
						<input type="text" name='username' value='admin'>
					</div>
					<div>
						<input type="password" name='password' value='123'>
					</div>
					<div>
						<input type='submit'>
					</div>
					<input type="hidden" name="${_csrf.parameterName }"
						value="${_csrf.token }">
				</form>
			</div>
			<!-- end panel body -->
		</div>
		<!-- end panel-default -->
	</div>
	<!-- /.col-lg-12 -->
</div>
<!-- /.row -->
<%@include file="includes/footer.jsp"%>