<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@include file="../includes/header.jsp"%>
<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">Board Register</h1>
	</div>
	<!-- /.col-lg-12 -->
</div>
<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">Board register Page</div>
			<!-- end panel-heading -->
			<div class="panel-body">
				<form role="form" action="./register" method="post">
					<div class="form-group">
						<label>Name</label> <input class="form-control" name='tobaccoName'>
					</div>
					<div class="col-lg-3 form-group">
						<label>nicotine</label>
						<input class="form-control" name='nicotine'>
					</div>
					<div class="col-lg-3 form-group">
						<label>tar</label>
						<input class="form-control" name='tar'>
					</div>
					<div class="col-lg-3 form-group">
						<label>amount</label>
						<input class="form-control" name='amount'>
					</div>
					<div class="col-lg-3 form-group">
						<label>price</label>
						<input class="form-control" name='price'>
					</div>
					<div>
						<select name='brand.id'>
							<option value="" 'selected'>Brand</option>
							<c:forEach items="${brandList}" var="brand">
								<option value="${brand.id}">${brand.name }</option>
							</c:forEach>
						</select> 
						
						<select name='type.id'>
							<option value="" 'selected'>Type</option>
							<c:forEach items="${typeList}" var="type">
								<option value="${type.id}">${type.name }</option>
							</c:forEach>
						</select> 
						
						<select name='country.id'>
							<option value="" 'selected'>country</option>
							<c:forEach items="${countryList}" var="country">
								<option value="${country.id}">${country.name }</option>
							</c:forEach>
						</select> 
						
						<select name='company.id'>
							<option value="" 'selected'>Company</option>
							<c:forEach items="${companyList}" var="company">
								<option value="${company.id}">${company.name }</option>
							</c:forEach>
						</select> 
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