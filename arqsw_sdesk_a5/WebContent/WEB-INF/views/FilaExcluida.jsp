<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Fila Excluída</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
    
</head>

<body>
    <!-- Barra superior com os menus de navegação -->
    <c:import url="Menu.jsp" />
    <!-- Container Principal -->
    <div id="main" class="container">
        <h3 class="page-header">
        <c:if test="${id != -1}">
        	Fila excluída com sucesso!
       	</c:if>
    	<c:if test="${id == -1}">
    		Ocorreu um erro!
    	</c:if>
        </h3>
        <div class="row">
        	<div class="col-md-12">
				<c:if test="${id != -1}">
        			Fila #${id} foi excluída!
        		</c:if>
        		<c:if test="${id == -1}">
        			A fila selecionada possui chamados associados a ela e não pôde ser removida.
        		</c:if>
			</div>
        </div>
    </div>
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
</body>

</html>