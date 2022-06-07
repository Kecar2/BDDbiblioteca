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
	border: 1px solid #dddddd;
	text-align: left;
	padding: 8px;
}

tr:nth-child(even) {
	background-color: #dddddd;
}

input[type=submit] {
	width: 100%;
	background-color: #4CAF50;
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
	background-color: #45a049;
}

div {
	border-radius: 5px;
	background-color: #f2f2f2;
	padding: 20px;
}
</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div>
		<form action="./GestorInsertar" method="post">
			<br> Id:<input type=text name="id"><br> <br>Titulo:<input
				type=text name="titulo"><br> <br>Autor:<input
				type=text name="autor"><br> <br>Editorial:<input
				type=text name="editorial"><br> <br>Fecha:<input
				type=text name="fecha"><br> <br>Categoria<input
				type=text name="categoria"><br> <br> Novedad:<input
				type=text name="novedad"><br> <br> <input
				type=submit value="Insertar Libro"><br>
		</form>
	</div>
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
			out.print("<td><a href=./GestorBorrado?id=" + l.getId() + ">Borrado</a></td></tr>");
		}
		%>
	</table>


</body>
</html>