<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Indice</title>
</head>
<body>
	<h1>Formulario nuevo usuario</h1>
	<form action="SvUsuarios" method="POST">
		<p>Dni: <input type="text" name="dniUser"/></p> 
		<p>Nombre: <input type="text" name="nameUser"/></p> 
		<p>Apellidos: <input type="text" name="surNameUser"/></p> 
		<p>Telefono: <input type="text" name="telUser"/></p> 
		<button type="submit">Enviar</button>
	</form>
	
		<h1>Consultar usuarios</h1>
	<form action="SvUsuarios" method="GET">
		<button type="submit">Ver usuarios existentes</button>
	</form>
	
		<h1>Eliminar usuario</h1>
	<form action="SvUsuarioDelete" method="POST">
		<p>Id: <input type="text" name="idUserDelete"/></p> 
		<button type="submit">Eliminar</button>
	</form>

	<h1>Modificar datos de usuario</h1>
	<form action="SvUsuariosUpdate" method="GET">
		<p>Id: <input type="text" name="idUserCheck"/></p> 
		<!--  <p>Id: <input type="text" name="idUserUpdate"/></p> 
		<p>Dni: <input type="text" name="dniUserUpdate"/></p> 
		<p>Nombre: <input type="text" name="nameUserUpdate"/></p> 
		<p>Apellidos: <input type="text" name="surNameUserUpdate"/></p> 
		<p>Telefono: <input type="text" name="telUserUpdate"/></p>	 -->
		<button type="submit">Modificar</button>
	</form>
	
</body>
</html>