<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="servlet.Libro"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
table {
	font-family: arial, sans-serif;
	border-collapse: collapse;
	width: 100%;
}

td, th {
	border: 1px solid #778899;
	text-align: left;
	padding: 8px;
}

tr:nth-child(even) {
	background-color: #FFFAF0;
}

input[type=submit] {
	width: 100%;
	background-color: #B8860B;
	color: white;
	padding: 14px 20px;
	margin: 8px 0;
	border: none;
	border-radius: 4px;
	cursor: pointer;
}

input[type=text], select {
	width: 100%;
	padding: 12px 20px;
	margin: 8px 0;
	display: inline-block;
	border: 1px solid #ccc;
	border-radius: 4px;
	box-sizing: border-box;
}

input[type=submit]:hover {
	background-color: #E9967A;
}

div {
	border-radius: 5px;
	background-color: #F0FFF0;
	padding: 20px;
	margin-top: 15px;
}
</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>
		<%
		String nombre = request.getParameter("login");
		String apellidos = request.getParameter("password");
		out.print(nombre + " " + apellidos);
		%>
	</h1>
	<table border=1>
		<tr>
			<th>Id</th>
			<th>Titulo</th>
			<th>Autor</th>
			<th>Editorial</th>
			<th>Fecha</th>
			<th>Categoria</th>
			<th>Novedad</th>
			<th>Borrado</th>
			<th>Actualizar</th>
		</tr>
		<%
		ArrayList<Libro> lista = (ArrayList<Libro>) request.getAttribute("lista");
		for (Libro l : lista) {
			out.print("<tr><td>" + l.getId() + "</td>");
			out.print("<td>" + l.getTitulo() + "</td>");
			out.print("<td>" + l.getAutor() + "</td>");
			out.print("<td>" + l.getEditorial() + "</td>");
			out.print("<td>" + l.getFecha() + "</td>");
			out.print("<td>" + l.getCategoria() + "</td>");
			out.print("<td>" + l.getNovedad() + "</td>");
			out.print("<td><a href=./GestorBorrado?id=" + l.getId() + ">Borrado</a></td>");
			out.print("<td><a href=./GestorActualizar?id=" + l.getId() + ">Actualizar</a></td></tr>");

		}
		%>
	</table>
	<%
	Libro l = (Libro) request.getAttribute("libro");
	if (l == null) {
	%>
	<div>
	<form action="./GestorInsertar" method="post">
		<br>Id:<input type=text name="id"> Titulo:<input
			type=text name="titulo"> Autor:<input type=text name="autor">
		Editorial:<input type=text name="editorial"><br> <br>
		Fecha:<input type=text name="fecha"> Categoria<input type=text
			name="categoria"> Novedad:<input type=text name="novedad">
		<br> <br> <input type=submit value="Insertar Libro">
	</form>
	<%
	} else {
	%>
	<form action="./GestorActualizar" method="post">
		<br>Id:<input type=text name="id" value="<%=l.getId()%>">
		Titulo:<input type=text name="titulo" value="<%=l.getTitulo()%>">
		Autor:<input type=text name="autor" value="<%=l.getAutor()%>">
		Editorial:<input type=text name="editorial"
			value="<%=l.getEditorial()%>"><br> <br> Fecha:<input
			type=text name="fecha" value="<%=l.getFecha()%>"> Categoria<input
			type=text name="categoria" value="<%=l.getCategoria()%>">
		Novedad:<input type=text name="novedad" value="<%=l.getNovedad()%>">
		<br> <br> <input type=submit value="Actualizar Libro">
	</form>
	</div>
	<%
	}
	%>

</body>
</html>