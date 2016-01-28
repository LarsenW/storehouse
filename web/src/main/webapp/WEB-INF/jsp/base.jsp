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
<!-- <link rel="stylesheet" -->
<!-- 	href="http://css-spinners.com/css/spinner/spinner.css" type="text/css"> -->
<script src="${basedir}/resources/js/lib/jquery-1.11.3.min.js"></script>
<script src="${basedir}/resources/js/lib/bootstrap.min.js"></script>
<script src="${basedir}/resources/js/base.js"></script>
<link rel="stylesheet" href="${basedir}/resources/css/base.css">
<script src="http://mymaplist.com/js/vendor/TweenLite.min.js"></script>
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
				<a class="navbar-brand" href="main">Storehouse</a>
			</div>
			<div>
				<ul class="nav navbar-nav">
					<li><a href="main"class="glyphicon glyphicon-home"></a></li>
					<sec:authorize access="hasRole('ROLE_USER')">
						<li><a href="upload">Upload</a></li>
					</sec:authorize>
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