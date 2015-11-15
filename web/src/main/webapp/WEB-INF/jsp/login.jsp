<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="base.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="${basedir}/resources/css/login.css">
<script src="${basedir}/resources/js/login.js"></script>
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<div class="row" style="margin-top: 20px">
			<div
				class="col-xs-12 col-sm-8 col-md-6 col-sm-offset-2 col-md-offset-3">
				<form role="form" name="loginForm" action="login" method='POST'>
					<input type="hidden" name="${_csrf.parameterName}"
						value="${_csrf.token}" />
					<fieldset>
						<h2>Please Sign In</h2>
						<hr class="colorgraph">
						<div class="form-group">
							<input type="email" name="username" id="email"
								class="form-control input-md" placeholder="Email Address">
						</div>
						<div class="form-group">
							<input type="password" name="password" id="password"
								class="form-control input-md" placeholder="Password">
						</div>
						<span class="button-checkbox">
							<button type="button" class="btn btn-sm" data-color="info">Remember
								Me</button> <input type="checkbox" name="remember_me" id="remember_me"
							checked="checked" class="hidden"> <a href=""
							class="btn btn-link pull-right">Forgot Password?</a>
						</span>
						<hr class="colorgraph">
						<div class="row">
							<div class="col-xs-6 col-sm-6 col-md-6">
								<input type="submit" class="btn btn-md btn-success btn-block"
									value="Sign In">
							</div>
							<div class="col-xs-6 col-sm-6 col-md-6">
								<a href="registration" class="btn btn-md btn-primary btn-block">Register</a>
							</div>
						</div>
					</fieldset>
				</form>
			</div>
		</div>

	</div>
</body>
</html>