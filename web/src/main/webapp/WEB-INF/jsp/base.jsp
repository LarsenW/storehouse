<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<c:set var="basedir" value="${pageContext.request.contextPath}" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="${basedir}/resources/css/lib/bootstrap.min.css">
<script src="${basedir}/resources/js/lib/jquery-1.11.3.min.js"></script>
<script src="${basedir}/resources/js/lib/bootstrap.min.js"></script>
<script src="${basedir}/resources/js/base.js"></script>
<script src="http://mymaplist.com/js/vendor/TweenLite.min.js"></script>
<style>
body {
	 background-image: url("${basedir}/resources/images/background.png");
}
</style>
<script type="text/javascript">
	function submitform() {
		document.logoutForm.submit();
	}
</script>
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
					<sec:authorize access="hasRole('ROLE_USER')">
						<li><a href="upload">Upload</a></li>
					</sec:authorize>
					<li><a href="#">Page 2</a></li>
					<li><a href="#">Page 3</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<sec:authorize access="isAnonymous()">

						<li><a href="registration"><span
								class="glyphicon glyphicon-user"></span> Sign Up</a></li>
						<li><a href="login"><span
								class="glyphicon glyphicon-log-in"></span> Log in</a></li>
					</sec:authorize>
					<sec:authorize access="isAuthenticated()">
						<form action="${basedir}/logout" method="post" id="logoutForm"
							name="logoutForm">
							<input type="hidden" name="${_csrf.parameterName}"
								value="${_csrf.token}" />
							<!--<button type="submit" class="btn btn-default">Log out</button> -->
						</form>
						<li><a href="javascript: submitform()"><span
								class="glyphicon glyphicon-log-out"></span>Log out</a></li>
					</sec:authorize>
				</ul>
			</div>
		</div>
	</nav>
</body>
</html>