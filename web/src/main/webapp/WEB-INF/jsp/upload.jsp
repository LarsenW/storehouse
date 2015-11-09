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
</head>
<body>
	<div class="container" align="center">
		<div class="panel panel-default">
			<div class="panel-heading">Upload file</div>
			<div class="panel-body">
				<form:form method="POST" modelAttribute="itemForm" action="upload">
					<p>
						<label class="control-label" for="name">File name</label>
					</p>
					<form:input class="form-control" path="name" type="text"
						name="name" />
					<br>
					<p>
						<label class="control-label" for="name">Description</label>
					</p>
					<form:textarea class="form-control" path="description" type="text"
						name="name" />
					<br>
					<div align="left">
						<form:input path="data" type="file" name="file" />
					</div>
					<br>
					<input class="btn btn-primary" type="submit" value="Upload">
				</form:form>
			</div>
		</div>

	</div>
</body>
</html>