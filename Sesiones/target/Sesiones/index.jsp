<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form action="Validaciones" method="post">

		<input type="email" id="correo" name="correo"
			placeholder="usuario@dominio.ext" required> <br> <input
			type="password" id="clave" name="clave" placeholder="1234"> <br>
		<button type="submit">Validar</button>
		<button type="reset">Limpiar</button>


	</form>

</body>
</html>