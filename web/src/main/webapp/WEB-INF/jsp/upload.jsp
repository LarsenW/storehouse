<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ include file="base.jsp"%>
<!DOCTYPE">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${basedir}/resources/css/upload.css">
<script src="${basedir}/resources/js/upload.js"></script>
</head>
<body>
	<div class="container">
		<div class="row centered-form">
			<div
				class="col-xs-12 col-sm-8 col-md-4 col-sm-offset-2 col-md-offset-4">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title glyphicon glyphicon-upload">Upload new
							file</h3>
					</div>
					<div class="panel-body">
						<form:form method="POST" modelAttribute="itemForm" action="upload">
							<div class="form-group">
								<form:input type="text" name="name" id="name" path="name"
									class="form-control input-sm glowing-border" placeholder="Name" />
							</div>
							<div>
								<form:textarea class="form-control" rows="3" id="comment"
									path="description" placeholder="File description..." />
							</div>
							<br>
							<br>
							<table>
								<tr>
									<td><form:radiobutton path="privacy" value="false" />Public</td>
									<td><form:radiobutton path="privacy" value="true" />Private</td>
								</tr>
							</table>
							<br>
							<br>
							<div class="input-group">
								<span class="input-group-btn"> <span
									class="btn btn-info btn-file"> Browse… <form:input
											type="file" path="data" />
								</span>
								</span> <input id="file_upload" type="text" class="form-control"
									placeholder="file is not chosen" readonly="readonly">
							</div>
							<br>
							<div>
								<input type="submit" value="Upload"
									class="btn btn-primary btn-block">
							</div>
						</form:form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>