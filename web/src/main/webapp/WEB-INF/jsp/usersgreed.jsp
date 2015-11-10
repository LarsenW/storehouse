<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="base.jsp"%>
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="${basedir}/resources/css/usergreed.css">
<title>Insert title here</title>
</head>
<body>
	<div class="container" align="center">
		<div class="panel panel-default">
			<div class="panel-heading">Upload file</div>
			<div class="panel-body">
				<table class="table table-striped table-responsive">
					<tr>
						<th class="danger">ID</th>
						<th>Username</th>
						<th>email</th>
					</tr>
					<c:forEach items="${users}" var="i">
						<tr>
							<td class="danger">${i.id}</td>
							<td>${i.name}</td>
							<td>${i.email}</td>
							<td><div class="btn-group">
									<button type="button" class="btn btn-primary dropdown-toggle"
										data-toggle="dropdown">
										Action <span class="caret"></span>
									</button>
									<ul class="dropdown-menu" role="menu">
										<li><a href="#" class="glyphicon glyphicon-align-justify"> Show files</a></li>
										<li><a href="#" class="glyphicon glyphicon-remove-circle"> Add to ban</a></li>
									</ul>
								</div></td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>
</body>
</html>