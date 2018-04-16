<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix = "fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listar Filas Exibir</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
</head>

<body>
	<!-- Barra superior com os menus de navegação -->
	<c:import url="Menu.jsp" />
	<!-- Container Principal -->
	<div id="main" class="container">		
		<h3 class="page-header">Filas</h3>

		<table class="table table-striped">
			<tr>
				<th>ID</th>
				<th>Nome</th>
				<th>Imagem</th>
				<th></th>
				<th></th>
				<th></th>
			</tr>
			<c:forEach var="fila" items="${filas}">
				<tr>			
					<td>${fila.id}</td>
					<td>${fila.nome}</td>
					<td><img src="img/${fila.caminhoFigura}" alt="" height="48" width="48" class="img-circle"></td>
					<td><a href="<c:url value='/detalhes_fila?id=${fila.id }'/>">Detalhes</a></td>
					<td><a href="<c:url value='/alterar_fila?id=${fila.id }'/>">Alterar</a></td>
		        	<td><a href="<c:url value='/excluir_fila?id=${fila.id }'/>" style="color: red">Remover</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>

</html>