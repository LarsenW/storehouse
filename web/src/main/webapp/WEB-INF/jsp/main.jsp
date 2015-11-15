<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ include file="base.jsp"%>
<%@ page
	import="org.springframework.security.core.context.SecurityContextHolder"%>
<%@ page import="org.springframework.security.core.GrantedAuthority"%>
<!DOCTYPE html>
<html>
<title>Welcome</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="${basedir}/resources/css/main.css">
</head>
<body>
	<div class="container">
		<div class="btn-group">
			<button type="button" class="btn btn-primary btn-lg">All</button>
			<button type="button" class="btn btn-primary btn-lg">Video</button>
			<button type="button" class="btn btn-primary btn-lg">Audio</button>
			<button type="button" class="btn btn-primary btn-lg">Image</button>
			<button type="button" class="btn btn-primary btn-lg">Text</button>
		</div>
		<br /> <br />
		<div class="search_group">
			<form class="form-inline">
				<div class="input-group input-group-lg">
					<input type="text" class="form-control" placeholder="Search for...">
					<span class="input-group-btn">
						<button class="btn btn-default" type="button">Go!</button>
					</span>
				</div>
			</form>
		</div>
	</div>
	<sec:authorize access="hasRole('ROLE_ADMIN')" var="isAdmin">
		<h1>ALLO</h1>
	</sec:authorize>
	<h2>${isAdmin}</h2>
	<%
		for (GrantedAuthority c : SecurityContextHolder.getContext().getAuthentication().getAuthorities()) {
	%>
	<h2><%=c%></h2>
	<%
		}
	%>
</body>
</html>