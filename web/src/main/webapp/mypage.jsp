<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.text.DateFormat"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.Arrays"%>
<%
	//response.setIntHeader("Refresh", 5);
	//response.sendRedirect("another.jsp");
	//response.sendError(777, "F U !");
	String nameForGreets = "anonymus";
	for (Cookie c : request.getCookies()) {
		if (c.getName().equals("name")) {
			nameForGreets = c.getValue();
		}
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Hello dear ,${name}</h1>
	<p>
		you are the best
		<%=nameForGreets%>
	</p>
	<%
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
	%>
	<p><%=dateFormat.format(date)%></p>

</body>
</html>