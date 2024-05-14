<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.util.List"
	import="modelo.Usuario"
	import="java.util.ArrayList"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>Usuarios Registrados</h1>

	<%
	// Debemos crear una lista y darle el valor de la lista del servlet, pedimos que nos traiga los atributos de "listaUsuarios" del servlet 
	List<Usuario> usuarios = (List) request.getSession().getAttribute("listaUsuarios");
	int contador = 1;
	for (Usuario usu : usuarios) {
	%>
	<p>Cliente número:<% out.println(contador);%></p> 
	<p>Dni:<% out.println(usu.getDni());%></p> 
	<p>Nombre:<% out.println(usu.getName());%></p> 
	<p>Apellidos:<% out.println(usu.getSurName());%></p> 
	<p>Teléfono:<% out.println(usu.getTel());%></p> 
	<p>---------------------------------</p> 
	<%
	contador ++;
	}
	%>


</body>
</html>