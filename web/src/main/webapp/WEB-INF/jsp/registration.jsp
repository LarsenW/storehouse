<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="base.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${basedir}/resources/css/registration.css">
<script src="${basedir}/resources/js/registration.js"></script>
</head>
<body>
	<div class="container">
		<div class="row">
			<div
				class="col-xs-12 col-sm-8 col-md-6 col-sm-offset-2 col-md-offset-3">
				<form:form modelAttribute="userForm" action='registration'
					method="POST">
					<h2>
						Please Sign Up <small>It's free and always will be.</small>
					</h2>
					<hr class="colorgraph">
					<div class="form-group">
						<form:input path="username" type="text" name="display_name"
							id="display_name" class="form-control input-md"
							placeholder="Display Name" tabindex="3" />
						<br>
						<form:errors path="username" cssClass="error" element="div" />
					</div>
					<div class="form-group">
						<form:input path="email" type="email" name="email" id="email"
							class="form-control input-md" placeholder="Email Address"
							tabindex="4" />
						<br>
						<form:errors path="email" cssClass="error" element="div" />
					</div>
					<div class="row">
						<div class="col-xs-12 col-sm-6 col-md-6">
							<div class="form-group">
								<form:input path="password" type="password" name="password"
									id="password" class="form-control input-md"
									placeholder="Password" tabindex="5" />
								<br>
								<form:errors path="password" cssClass="error" element="div" />
							</div>
						</div>
						<div class="col-xs-12 col-sm-6 col-md-6">
							<div class="form-group">
								<input type="password" name="password_confirmation"
									id="password_confirmation" class="form-control input-md"
									placeholder="Confirm Password" tabindex="6"> <br>
								<div id="password_confirm_error" class="error">Passwords are not equal</div>
							</div>
						</div>
					</div>
					<hr class="colorgraph">
					<div class="row">
						<div class="col-xs-12 col-md-6">
							<input type="submit" value="Register"
								class="btn btn-primary btn-block btn-md" tabindex="7">
						</div>
						<div class="col-xs-12 col-md-6">
							<a href="login" class="btn btn-success btn-block btn-md">Sign
								In</a>
						</div>
					</div>
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>