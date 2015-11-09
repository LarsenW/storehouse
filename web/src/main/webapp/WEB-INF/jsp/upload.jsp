<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form:form method="POST" modelAttribute="itemForm" action="upload">
		File to upload: <form:input path="data" type="file" name="file" />
		<br /> Name: <form:input path="name" type="text" name="name" />
		<br />
		<br />
		<input type="submit" value="upload"> Press here to upload the file!
	</form:form>
</body>
</html>