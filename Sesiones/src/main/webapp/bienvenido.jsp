<%@page import="com.educacionit.entidades.Usuario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%
	Usuario usuario = (Usuario) session.getAttribute("usuario");
	out.print(usuario);
	%>

</body>
</html>