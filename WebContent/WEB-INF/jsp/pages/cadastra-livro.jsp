<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Novo livro</title>
<jsp:include page="/WEB-INF/jsp/partials/css_links.jsp" />
</head>
<body>
	<jsp:include page="/WEB-INF/jsp/partials/header.jsp" />
	<jsp:include page="/WEB-INF/jsp/partials/menu.jsp" />
	<c:if test="${empty editar }">
		<form method="post" action="novo-livro">
	</c:if>
	<c:if test="${not empty editar }">
		<form method="post" action="editar-livro">
	</c:if>
	
	<label for="titulo">Titulo</label>
	<input type="text" name="titulo" value="${editar.titulo}">
	<label for="isbn">ISBN</label>
	<input type="text" name="isbn" value="${editar.isbn}">
	<label for="colecao">Coleção</label>
	<input type="text" name="colecao" value="${editar.colecao}">
	<label for="edicao">Edição</label>
	<input type="text" name="edicao" value="${editar.edicao}">
	<label for="idioma">Idioma</label>
	<input type="text" name="idioma" value="${editar.idioma}">
	<label for="ano">Ano</label>
	<input type="text" name="ano" value="${editar.ano}">

	<label for="categoria">Categoria</label>
	<select name="categoria">
		<c:forEach var="categoria" items="${categorias}">
		
			<c:if test="${editar.categoria.categoria_id == categoria.categoria_id}">
				<option value="${categoria.categoria_id }" selected>${categoria.categoria}</option>
			</c:if>
			<c:if test="${editar.categoria.categoria_id != categoria.categoria_id}">
				<option value="${categoria.categoria_id }">${categoria.categoria}</option>
			</c:if>
			
		</c:forEach>
	</select>
	<label for="editora">Editora</label>
	<select name="editora">
		<c:forEach var="editora" items="${editoras}">
		
			<c:if test="${editar.editora.id == editora.id}">
				<option value="${editora.id }" selected>${editora.nome}</option>
			</c:if>
			<c:if test="${editar.editora.id != editora.id}">
				<option value="${editora.id }">${editora.nome}</option>
			</c:if>
		
		</c:forEach>
	</select>

	<label for="autor">Autor</label>
	<select name="autor">
		<c:forEach var="autor" items="${autores}">
		
			<c:if test="${editar.autor.autor_Id == autor.autor_Id}">
				<option value="${autor.autor_Id }" selected>${autor.nome}&nbsp;${autor.sobrenome}</option>
			</c:if>
			<c:if test="${editar.autor.autor_Id != autor.autor_Id}">
				<option value="${autor.autor_Id }" >${autor.nome}&nbsp;${autor.sobrenome}</option>
			</c:if>
			
		</c:forEach>
	</select>
	
	<label for="assunto">Preço</label>
	<input type="text" name="preco" value="${editar.preco}">
	
		<c:if test="${not empty editar }">
			<input type="hidden" name="editar_id" value="${editar.livro_id }">
		</c:if>
		
	<input type="submit" value="Cadastrar">
	
	</form>

</body>
</html>