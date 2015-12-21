<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
<script type="text/javascript"
	src="${basedir}/resources/js/lib/jquery-1.11.3.min.js"></script>
<!-- <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.6.4/jquery.min.js"></script> -->
<script type="text/javascript"
	src="${basedir}/resources/js/lib/jquery.parallax-1.1.3.js"></script>
<script type="text/javascript"
	src="${basedir}/resources/js/lib/jquery.localscroll-1.2.7-min.js"></script>
<script type="text/javascript"
	src="${basedir}/resources/js/lib/jquery.scrollTo-1.4.2-min.js"></script>
<script src="${basedir}/resources/js/main.js"></script>
</head>
<body>
	<div id="intro">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div id="sticky-anchor"></div>
					<div class="row" id="sticky">
						<div class="col-xs-8 col-xs-offset-2">
							<form:form method="GET" modelAttribute="searchForm" action="result">
								<div class="input-group">
									<div class="input-group-btn search-panel">
										<select class="form-control">
											<option>All files</option>
											<option>Audio</option>
											<option>Video</option>
											<option>Image</option>
											<option>Text</option>
										</select>
									</div>
									<input type="hidden" name="search_param" value="all"
										id="search_param"> <input type="text"
										class="form-control" name="x" placeholder="Search file...">
									<span class="input-group-btn">
										<button class="btn btn-primary" type="button">
											<span class="glyphicon glyphicon-search"></span>
										</button>
									</span>
								</div>
							</form:form>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="story">
			<div class="float-left">
			</div>
		</div>
		<!--.story-->
	</div>
	<!--#intro-->

	<div id="second">
		<div class="story">
			<div class="bg"></div>
			<div class="float-right">
			</div>
		</div>
		<!--.story-->

	</div>
	<!--#second-->

	<div id="third">
		<div class="story">
			<div class="float-left">
			</div>
		</div>
		<!--.story-->
	</div>
	<!--#third-->

	<%
		for (GrantedAuthority c : SecurityContextHolder.getContext().getAuthentication().getAuthorities()) {
	%>
	<h2><%=c%></h2>
	<%
		}
	%>

</body>
</html>