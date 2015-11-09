<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<c:set var="basedir" value="${pageContext.request.contextPath}" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="${basedir}/resources/css/lib/bootstrap.min.css">
<script src="${basedir}/resources/js/lib/jquery-1.11.3.min.js"></script>
<script src="${basedir}/resources/js/lib/bootstrap.min.js"></script>
<style>
body {
	background-image: url("${basedir}/resources/images/background.jpg");
}
</style>
<title>Insert title here</title>
</head>
<body>
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="main">WebSiteName</a>
			</div>
			<div>
				<ul class="nav navbar-nav">
					<li class="active"><a href="main">Home</a></li>
					<li><a href="#">Page 1</a></li>
					<li><a href="#">Page 2</a></li>
					<li><a href="#">Page 3</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="registration"><span class="glyphicon glyphicon-user"></span>
							Sign Up</a></li>
					<li><a href="#"><span class="glyphicon glyphicon-log-in"></span>
							Login</a></li>
				</ul>
			</div>
		</div>
	</nav>
</body>
</html>