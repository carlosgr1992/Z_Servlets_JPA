<%@page import="modelo.Usuario"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edita usuarios</title>
</head>
<body>

	<h1>Editar usuario</h1>

		<% Usuario usu = (Usuario) request.getAttribute("usuario"); %>

	<form action="SvUsuariosUpdate" method="POST">
		<input type="hidden" name="idUser" value="<%= usu.getId() %>"/>
		<p>Dni: <input type="text" name="dniUserUpdate" value="<%= usu.getDni() %>"/>
		<p>Nombre: <input type="text" name="nameUserUpdate" value="<%= usu.getName() %>"/>
		<p>Apellidos: <input type="text" name="surNameUserUpdate" value="<%= usu.getSurName() %>"/>
		<p>Telefono: <input type="text" name="telUserUpdate" value="<%= usu.getTel() %>"/>
		<button type="submit">Modificar</button>
	</form>
	
</body>
</html>