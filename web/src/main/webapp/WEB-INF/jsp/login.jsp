<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="base.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form role="form" name="loginForm" action="login" method='POST'>
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
		<div class="form-group">
			<label for="email">Email address:</label> <input name="username"
				type="text" class="form-control" id="email">
		</div>
		<div class="form-group">
			<label for="pwd">Password:</label> <input name="password"
				type="password" class="form-control" id="pwd">
		</div>
		<div class="checkbox">
			<label><input type="checkbox"> Remember me</label>
		</div>
		<button type="submit" class="btn btn-default">Submit</button>
	</form>
	
</body>
</html>