<%@page import="com.educacionit.enumerados.MensajesFront"%>
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
	if (null == session.getAttribute("usuario")) {
		response.sendRedirect("index.jsp");
	}

	MensajesFront mensajesFront = (MensajesFront) request.getAttribute("mensaje");
	if (null != mensajesFront) {
		out.print("<h1 style=\"color:green\">" + mensajesFront.getMensaje() + "</h1>");
	}

	Usuario usuario = (Usuario) session.getAttribute("usuario");
	out.print(usuario);
	%>
	<br>
	<a onclick="cerrarSesion()">Cerrar Sesion</a>
	<script type="text/javascript">
		function cerrarSesion() {
			const cerrarSesion = window.confirm("Desea cerrar session?");
			if (cerrarSesion) {
				window.location.href = "Validaciones?cerrarSesion=true";
			}
		}
	</script>
</body>
</html>