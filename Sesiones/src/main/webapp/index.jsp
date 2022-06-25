<%@page import="com.educacionit.enumerados.MensajesFront"%>
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
	if (null != session.getAttribute("usuario")) {
		response.sendRedirect("bienvenido.jsp");
	}
	%>

	<form action="Validaciones" method="post">

		<input type="email" id="correo" name="correo"
			placeholder="usuario@dominio.ext" required> <br> <input
			type="password" id="clave" name="clave" placeholder="1234"> <br>
		<button type="submit">Validar</button>
		<button type="reset">Limpiar</button>
	</form>
	<%
	MensajesFront mensajesFront = (MensajesFront) request.getAttribute("mensaje");
	if (null != mensajesFront) {
		out.print("<h1 style=\"color:red\">" + mensajesFront.getMensaje() + "</h1>");
	}
	%>

</body>
</html>