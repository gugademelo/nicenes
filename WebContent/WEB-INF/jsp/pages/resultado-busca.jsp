<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="u" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Resulados da busca</title>
</head>
<body>
	<jsp:include page="/WEB-INF/jsp/partials/header.jsp" />
	<jsp:include page="/WEB-INF/jsp/partials/menu.jsp" />
	<h2>Resultados da busca</h2>
	<h3>Filtro avan�ado</h3>
	<label for="categoria">Categoria</label>
	<form action="google" method="get">
		<select name="categoria">
			<c:forEach var="categoria" items="${categorias}">
				<option value="${categoria.categoria_id }">${categoria.categoria}</option>
			</c:forEach>
		</select>
		<label for="editora">Editora</label>
		<select name="editora">
			<c:forEach var="editora" items="${editoras}">
				<option value="${editora.id }">${editora.nome}</option>
			</c:forEach>
		</select>
		<label for="autor">Autor</label>
		<select name="editora">
			<c:forEach var="autor" items="${autores}">
				<option value="${autor.autor_Id }">${autor.nome}</option>
			</c:forEach>
		</select>
		<input type="submit" value="ok">
	</form>
	<jsp:include page="/WEB-INF/jsp/partials/lista-livros.jsp" />
</body>
</html>