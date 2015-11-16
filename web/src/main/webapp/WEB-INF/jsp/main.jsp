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
		<div class="jumbotron">
			<!-- 			<h1>Bootstrap Tutorial</h1> -->
			<p>Bootstrap is the most popular HTML, CSS, and JS framework for
				developing responsive, mobile-first projects on the web.</p>
		</div>
		<div class="row">
			<div class="col-md-12">
				<div class="input-group" id="adv-search">
					<input type="text" class="form-control" placeholder="Search..." />
					<div class="input-group-btn">
						<div class="btn-group" role="group">
							<div class="dropdown dropdown-lg">
								<button type="button" class="btn btn-default dropdown-toggle"
									data-toggle="dropdown" aria-expanded="false">
									<span class="caret"></span>
								</button>
								<div class="dropdown-menu dropdown-menu-right" role="menu">
									<form class="form-horizontal" role="form">
										<div class="form-group">
											<label for="filter">Filter by</label> <select
												class="form-control">
												<option value="0" selected>All categories</option>
												<option value="1">Audio</option>
												<option value="2">Video</option>
												<option value="3">Image</option>
												<option value="4">Text</option>
											</select>
										</div>
										<div class="form-group">
											<label for="contain">Author</label> <input
												class="form-control" type="text" />
										</div>
										<div class="form-group">
											<label for="contain">Contains the words</label> <input
												class="form-control" type="text" />
										</div>
										<button type="submit" class="btn btn-primary">
											<span class="glyphicon glyphicon-search" aria-hidden="true"></span>
										</button>
									</form>
								</div>
							</div>
							<button type="button" class="btn btn-primary">
								<span class="glyphicon glyphicon-search" aria-hidden="true"></span>
							</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<%
		for (GrantedAuthority c : SecurityContextHolder.getContext().getAuthentication().getAuthorities()) {
	%>
	<h2><%=c%></h2>	<%
		}
	%>
</body>
</html>