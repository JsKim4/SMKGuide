<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" buffer="128kb"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@include file="../includes/header.jsp"%>
<div class="row">
	<div class="col-md-4 col-md-offset-4">
		<div class="login-panel panel panel-default">
			<div class="panel-heading">
				<h3 class="panel-title">Please Sign In</h3>
			</div>
			<div class="panel-body">
				<form method="post" action="./login">
					<fieldset>
						<div class="form-group">
							<input class="form-control" placeholder="E-mail" name="username"
								type="email" autofocus>
						</div>
						<div class="form-group">
							<input class="form-control" placeholder="Password"
								name="password" type="password" value="">
						</div>
						<div class="checkbox">
							<label> <input name="remember" type="checkbox"
								value="Remember Me">Remember Me
							</label>
						</div>
						<input type="hidden" name="${_csrf.parameterName }"
							value="${_csrf.token }">
						<div>
							<input type='submit'>
						</div>
					</fieldset>
				</form>
			</div>
		</div>
	</div>
</div>
<%@include file="../includes/footer.jsp"%>